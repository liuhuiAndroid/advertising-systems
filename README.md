# advertising-systems
[广告系统概览与准备工作]()

[广告系统骨架开发]()



## 附录

#### docker 基本命令

```shell
systemctl start docker # 启动docker
docker restart `container id` # 重启container
```

#### mysql 安装

```shell
docker run --name mysql8 -e MYSQL_ROOT_PASSWORD=mySt8#pW -p 3306:3306 -d mysql:8.0.12 --character-set-server=utf8mb4
```

#### kafka 安装

```shell
# docker compose 安装
sudo curl -L https://github.com/docker/compose/releases/download/1.21.2/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
docker-compose --version
vi docker-compose.yml
docker-compose up -d
docker ps
docker-compose ps
docker-compose scale kafka=3
docker-compose stop  # 停止
docker-compose restart # 重启服务
docker-compose down # 停止并移除容器
docker exec root_kafka_1 kafka-topics.sh --describe --topic topic001 --zookeeper zookeeper:2181 # 查看topic001的基本情况
```

```dockerfile
# docker-compose.yml
version: '2'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"
  kafka:
    image: wurstmeister/kafka:2.12-2.1.0
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092
      KAFKA_LISTENERS: PLAINTEXT://:9092
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_CREATE_TOPICS: "topic001:2:1"
      KAFKA_HEAP_OPTS: "-Xmx256M -Xms128M"
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
```

#### 问题

1. 解决mysql8+使用navicat连接乱码问题

   ```shell
   ALTER USER 'root'@'localhost' IDENTIFIED BY 'mySt8#pW' PASSWORD EXPIRE NEVER; #修改加密规则 
   ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mySt8#pW'; #更新一下用户的密码 
   FLUSH PRIVILEGES; #刷新权限 
   # --------------------------------------------------
   select user,plugin from user where user = 'root';
   delete from user where user = 'root' and plugin = 'caching_sha2_password'
   update user set host = '%' where user = 'root';
   FLUSH PRIVILEGES;
   ```

2. Kafka 启动出现JVM内存不足异常解决方法

   编辑bin/kafka-server.start.sh

   修改`export KAFKA_HEAP_OPTS="-Xmx1G -Xms1G"`

   为`export KAFKA_HEAP_OPTS="-Xmx256M -Xms128M"`

   即可

3. mySt8#pW.sec4
