package com.haohao.vertx.tcp;

import io.vertx.core.Vertx;

/**
 * @author haohao
 * @date 2022年07月20日 17:25
 */
public class Test {

    public static void main(String[] args) {
//        Vertx.vertx().deployVerticle(new NetServerDemo());
        Vertx.vertx().deployVerticle(new NetServerDemo2());
//        Vertx.vertx().deployVerticle(new NetClientDemo());
    }
}
