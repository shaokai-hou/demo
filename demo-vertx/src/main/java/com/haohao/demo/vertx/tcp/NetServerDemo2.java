package com.haohao.demo.vertx.tcp;

import cn.hutool.core.util.StrUtil;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.SocketAddress;

/**
 * @author haohao
 * @date 2022年07月20日 16:05
 */
public class NetServerDemo2 extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        final String host = "localhost";
        final int port = 9985;

        EventBus eventBus = this.vertx.eventBus();

        eventBus.consumer("msg:test", message -> {
            System.out.println("event bus 消息：" + message.body());
            message.reply(message);
        });

        NetServer netServer = this.vertx.createNetServer();

        netServer.connectHandler(socket -> {

            SocketAddress socketAddress = socket.remoteAddress();
            String format = StrUtil.format("socket {}:{}", socketAddress.host(), socketAddress.port());
            System.out.println(format);

            socket.handler(buffer ->
                    System.out.println("读取到数据:" + buffer.toString() + " 长度为: " + buffer.length())
            );

            socket.write(Buffer.buffer("回消息"), res ->
                    System.out.println(res.succeeded() ? "服务端消息发送成功" : "服务端消息发送失败")
            );

            socket.closeHandler(handle -> {
                System.out.println("客户端退出连接");
            });
        }).listen(port, host, res -> {
                    System.out.println(res.succeeded() ? "Tcp服务端启动成功" : "Tcp服务端启动失败:" + res.cause().getMessage());
                }
        );
    }
}
