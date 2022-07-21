package com.haohao.demo.vertx.web;

import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * @author haohao
 * @date 2022年07月21日 09:52
 */
public class HttpVerticle extends DatabaseVerticle{

    @Override
    public void start() throws Exception {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        router.get("/user/:id").handler(this::getUser);

        server.requestHandler(router);
        server.listen(8080);
    }

    private void getUser(RoutingContext ctx) {
        int id = Integer.parseInt(ctx.request().getParam("id"));
        JsonObject json = new JsonObject().put("id", id);
        vertx.eventBus().request("com.javafm.vertx.database", json, r -> {
            if (r.succeeded()){
                out(ctx, r.result().body().toString());
            } else {
                r.cause().printStackTrace();
                ctx.fail(r.cause());
            }
        });
    }

    private void out(RoutingContext ctx, String msg) {
        ctx.response().putHeader("Content-Type", "application/json; charset=utf-8")
                .end(msg);
    }
}
