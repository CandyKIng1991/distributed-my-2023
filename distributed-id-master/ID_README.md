# 分布式ID 部署文档

## 前景提示

* 由于这里使用的是旧版的Leaf,所以不是master的代码,而是feature代码,由于无法导入maven,所以这里直接将源码放入测试项目中

| 序号 | 名称    | 地址                                                                                  |
|----|-------|-------------------------------------------------------------------------------------|
| 1  | 美团双算法 | [Leaf算法](https://github.com/Meituan-Dianping/Leaf/tree/feature/spring-boot-starter) |

## 好使的用maven导入方法

* maven导入

```
   <dependency>
        <groupId>com.sankuai.inf.leaf</groupId>
        <artifactId>leaf-boot-starter</artifactId>
        <version>1.0.1-RELEASE</version>
   </dependency>
        
   <dependency>
        <groupId>org.apache.curator</groupId>
        <artifactId>curator-recipes</artifactId>
        <version>2.6.0</version>
        <exclusions>
           <exclusion>
              <artifactId>log4j</artifactId>
              <groupId>log4j</groupId>
           </exclusion>
        </exclusions>
   </dependency>




```

## 数据库建立

* 本地创建数据库leaf,创建表格信息如下:

```

CREATE DATABASE leaf
CREATE TABLE `leaf_alloc` (
  `biz_tag` varchar(128)  NOT NULL DEFAULT '',
  `max_id` bigint(20) NOT NULL DEFAULT '1',
  `step` int(11) NOT NULL,
  `description` varchar(256)  DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`biz_tag`)
) ENGINE=InnoDB;

insert into leaf_alloc(biz_tag, max_id, step, description) values('leaf-segment-test', 1, 2000, 'Test leaf Segment Mode Get Id')


```

## 配置properties

Leaf 提供两种生成的ID的方式（号段模式和snowflake模式），你可以同时开启两种方式，也可以指定开启某种方式（默认两种方式为关闭状态）。

Leaf Server的配置都在leaf-server/src/main/resources/leaf.properties中

| 配置项                       | 含义                  | 默认值   |
|---------------------------|---------------------|-------|
| leaf.name                 | leaf 服务名            |       |
| leaf.segment.enable       | 是否开启号段模式            | false |
| leaf.jdbc.url             | mysql 库地址           |       |
| leaf.jdbc.username        | mysql 用户名           |       |
| leaf.jdbc.password        | mysql 密码            |       |
| leaf.snowflake.enable     | 是否开启snowflake模式     | false |
| leaf.snowflake.zk.address | snowflake模式下的zk地址   |       |
| leaf.snowflake.port       | snowflake模式下的服务注册端口 |       |

## 启动默认接口方式

### 1.直接点击启动服务

| 序号 | 类名                         | 位置                                                                                                                                                                    |
|----|----------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | LeafServerApplication.java | [com.sankuai.inf.leaf.server.LeafServerApplication.java](./distributed-id-master/distributed-id/src/main/java/com/sankuai/inf/leaf/server/LeafServerApplication.java) |

### 2.或者导入到自己的controller下

| 序号 | 名称   | 接口                                                                 |
|----|------|--------------------------------------------------------------------|
| 1  | 号段算法 | [segment](http://localhost:8080/api/segment/get/leaf-segment-test) |
| 2  | 雪花算法 | [snowflake](http://localhost:8080/api/snowflake/get/test)          |
| 3  | 号段监控 | [cache](http://localhost:8080/cache)                               |

## 自行开发的端口

| 序号 | 名称          | 接口                                           |
|----|-------------|----------------------------------------------|
| 1  | 号段算法(只返回数值) | [segment](http://localhost:8080/segment)     |
| 2  | 号段算法(规范返回)  | [segment](http://localhost:8080/segment2)    |
| 3  | 雪花算法(规范返回)  | [snowflake](http://localhost:8080/snowflake) |

## 问题

```
  org.apache.curator.CuratorConnectionLossException: KeeperErrorCode = ConnectionLoss

```

* 主要是properties配置的zookeeper出问题了.
* 修改leaf.properties中的leaf.snowflake.address,设置为一个好使的zookeeper,问题解决

