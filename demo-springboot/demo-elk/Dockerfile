FROM openjdk
# 声明服务运行在9090端口
EXPOSE 9900
# 将当前目录下的jar包复制到docker容器的/目录下
COPY ./target/demo-elk-1.0.0.jar ./app.jar
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]