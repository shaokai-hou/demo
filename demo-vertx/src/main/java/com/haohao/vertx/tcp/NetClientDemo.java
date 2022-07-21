package com.haohao.vertx.tcp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetClientOptions;
import io.vertx.core.net.NetSocket;

/**
 * @author haohao
 * @date 2022年07月20日 16:23
 */
public class NetClientDemo extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        final String host = "localhost";
        final int port = 9984;

        vertx.createNetClient(new NetClientOptions().setConnectTimeout(10000))
                .connect(port, host, res -> {
                    if (res.succeeded()) {
                        System.out.println("连接成功");
                        NetSocket socket = res.result();

                        socket.handler(buffer ->
                                System.out.println("读取到服务端数据:" + buffer.toString() + " 长度为: " + buffer.length())
                        );

                        socket.write(Buffer.buffer("发送消息给服务端"), asyncResult ->
                                System.out.println(asyncResult.succeeded() ? "客户端消息发送成功" : "客户端消息发送失败")
                        );

                        socket.closeHandler(handle -> {
                            System.out.println("客户端断开连接");
                        });

                    } else {
                        System.out.println("连接失败");
                    }
                });

    }
}
