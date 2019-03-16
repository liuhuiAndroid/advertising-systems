# advertising-systems
## 第3章 广告系统骨架开发

#### 3-1 Maven 基础知识

1. Maven常用命令

   ```
   mvn -v 
   mvn compile
   mvn test 
   mvn package
   mvn clean 
   mvn install
   ```

#### 3-2 Maven 相关特性

1. 传递依赖和排除依赖

2. 依赖冲突

   1. 短路优先
   2. 声明优先

3. 多模块项目/聚合

   1. 父模块pom文件的配置：packaging类型必须是pom

      ```xml
          <groupId>com.imooc.ad</groupId>
          <artifactId>imooc-ad</artifactId>
      	<packaging>pom</packaging>
          <version>1.0-SNAPSHOT</version>
      ```

   2. 聚合子模块：使用modules标签

      ```xml
          <modules>
              <module>ad-eureka</module>
              <module>ad-gateway</module>
              <module>imooc-ad-service</module>
          </modules>
      ```

   3. 父模块统一管理依赖包：使用dependencyManagement标签

      ```xml
          <dependencyManagement>
              <dependencies>
                  <dependency>
                      <groupId>org.springframework.cloud</groupId>
                      <artifactId>spring-cloud-dependencies</artifactId>
                      <version>${spring-cloud.version}</version>
                      <type>pom</type>
                      <scope>import</scope>
                  </dependency>
              </dependencies>
          </dependencyManagement>
      ```

   4. 子模块需要在pom中声明父模块：使用parent标签

      ```xml
          <parent>
              <artifactId>imooc-ad</artifactId>
              <groupId>com.imooc.ad</groupId>
              <version>1.0-SNAPSHOT</version>
          </parent>
      ```

#### 3-3 广告系统主工程

#### 3-4 单节点 Eureka Server 的开发

#### 3-5 Eureka Server 的部署

1. hosts文件

   ```
   127.0.0.1 server1
   127.0.0.1 server2
   127.0.0.1 server3
   ```

2. 使用不同的配置文件打包

   ```shell
   mvn clean package -Dmaven.test.skip=true -U
   cd target 
   java -jar ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=server1
   java -jar ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=server2
   java -jar ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=server3
   ```


#### 3-6 微服务架构及网关组件介绍

1. 微服务架构及其应用场景
   1. 微服务架构的两种方式
      1. 点对点的方式：服务之间直接调用，每个微服务都开放Rest API，并调用其他微服务的接口
      2. API网关方式：业务接口通过API网关暴露，是所有客户端接口的唯一入口。微服务之间的通信也通过API网关

#### 3-7 网关启动程序的开发

#### 3-8 自定义网关过滤器的开发

#### 3-9 关于 ad-eureka 的介绍及作业

#### 3-10 关于 ad-gateway 的介绍及作业

## 第4章 微服务通用模块开发

#### 4-1 关于通用模块功能的介绍

1. 统一的响应
2. 统一的异常处理
   1. 不直接展示错误，对用户友好
   2. 异常分类，便于排查问题，Debug
   3. 降低业务代码中对异常处理的耦合
3. 统一配置

#### 4-2 统一响应处理的开发

#### 4-3 统一异常处理的开发

#### 4-4 统一配置的开发

#### 4-5 关于通用模块的说明及作业