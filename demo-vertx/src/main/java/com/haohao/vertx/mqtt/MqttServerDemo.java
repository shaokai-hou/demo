package com.haohao.vertx.mqtt;

import io.vertx.core.Vertx;
import io.vertx.mqtt.MqttServer;

/**
 * @author haohao
 * @date 2022年07月21日 10:22
 */
public class MqttServerDemo {

    public static void main(String[] args) {
        MqttServer mqttServer = MqttServer.create(Vertx.vertx());
        mqttServer.endpointHandler(endpoint -> {

                    // shows main connect info
                    System.out.println("MQTT client [" + endpoint.clientIdentifier() + "] request to connect, clean session = " + endpoint.isCleanSession());

                    if (endpoint.auth() != null) {
                        System.out.println("[username = " + endpoint.auth().getUsername() + ", password = " + endpoint.auth().getPassword() + "]");
                    }
                    System.out.println("[properties = " + endpoint.connectProperties() + "]");
                    if (endpoint.will() != null) {
                        System.out.println("[will topic = " + endpoint.will().getWillTopic() + " msg = " + new String(endpoint.will().getWillMessageBytes()) +
                                " QoS = " + endpoint.will().getWillQos() + " isRetain = " + endpoint.will().isWillRetain() + "]");
                    }
                    System.out.println("[keep alive timeout = " + endpoint.keepAliveTimeSeconds() + "]");

                    // accept connection from the remote client
                    endpoint.accept(false);

                }).listen(ar -> {
                    if (ar.succeeded()) {
                        System.out.println("MQTT server is listening on port " + ar.result().actualPort());
                    } else {
                        System.out.println("Error on starting the server");
                        ar.cause().printStackTrace();
                    }
                });
    }
}
