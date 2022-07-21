package com.haohao.vertx.web;

import io.vertx.core.Vertx;

/**
 * @author haohao
 * @date 2022年07月21日 09:53
 */
public class App {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new DatabaseVerticle());
        vertx.deployVerticle(new HttpVerticle());
    }
}
