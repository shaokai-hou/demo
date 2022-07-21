package com.haohao.vertx.http;

import io.vertx.core.Vertx;

/**
 * @author haohao
 * @date 2022年07月20日 17:28
 */
public class Test {

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(new HttpServerDemo());
    }
}
