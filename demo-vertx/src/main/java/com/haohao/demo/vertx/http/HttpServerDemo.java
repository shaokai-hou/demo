package com.haohao.demo.vertx.http;

import cn.hutool.core.util.StrUtil;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.net.SocketAddress;

/**
 * @author haohao
 * @date 2022年07月20日 17:01
 */
public class HttpServerDemo extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        final String host = "localhost";
        final int port = 9984;

        HttpServer httpServer = vertx.createHttpServer();

        httpServer.requestHandler(request -> {

            SocketAddress socketAddress = request.remoteAddress();
            String format = StrUtil.format("request {}:{}", socketAddress.host(), socketAddress.port());
            System.out.println(format);

            HttpServerResponse response = request.response();
            response.putHeader("Content-type", "text/html;charset=utf-8");
            response.end("hello word");
        }).listen(port, host, res ->
                System.out.println(res.succeeded() ? "Http服务端启动成功" : "Http服务端启动失败:" + res.cause().getMessage())
        );
    }

}
