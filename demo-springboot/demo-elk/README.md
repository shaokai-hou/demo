# springboot+docker+docker-compose+elk 日志收集

## 运行 docker-compose

> docker-compose启动命令
```shell
docker-compose up -d
```
> Dockerfile构建命令
```shell
docker build -t demo-elk-app:1.0.0 .
```

>打包命令
```shell
mvn clean package
mvn dockerfile:build
```
>推送镜像
```shell
mvn dockerfile:push
```