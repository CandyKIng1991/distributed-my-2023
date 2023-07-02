# Distributed-my-2023

#### 介绍
2023学习分布式

#### 软件架构
软件架构说明


##### 官方文档

[中文文档](https://github.com/Meituan-Dianping/Leaf/blob/feature/spring-boot-starter/README_CN.md)



## 顺序


| 序号 | 名称            | 连接                                     | 部署文档                                                         |
|----|---------------|----------------------------------------|--------------------------------------------------------------|
| 1  | 分布式ID         | [分布式ID](./distributed-id-master)        | [分布式ID部署文档](./distributed-id-master/ID_README.md)            |
| 2  | SpringSession | [SpringSession](./distributed-session)      | [SpringSession](./distributed-session/SESSION_README.md)     |
| 3  | 分布式任务调度          | [分布式任务调度](./distributed-job)   | [分布式任务调度](./distributed-job/JOB_README.md)                   |
| 4  | 分布式限流         | [分布式限流](./distributed-limiter)         | [分布式限流](./distributed-limiter/LIMIT_README.md)<br>[相关文章](./doc/ApacheBench的安装.md) |
| 5  | 分库分表          | [分库分表](./distributed-sharding)         |                                                              |
| 6  | 分布式事务         | [分布式事务](./distributed-seata)           |                                                              |

### 地址

[Apache ShardingSphere](https://shardingsphere.apache.org/)


### 解决问题

#### 1.源码的com/sankuai/inf/leaf/snowflake/SnowflakeZookeeperHolder.java中存在FileUtils.writeStringToFile的IO异常,改为可靠的基础代码写法.
