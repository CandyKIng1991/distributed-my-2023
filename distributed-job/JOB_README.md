
[TOC]

# 任务调度


## 任务调度适用场景


|序号|名称|描述|
|---|----|----|
| 1 | 报表| 电商项目使用:<br>昨天订单量,  上个月的订单,<br>每个店长昨日,每周每月的销售量<br>需要每天或者每月定时去计算生成|
| 2 | 日月结单  |  一般是支付,金融领域(证券公司)  |
| 3 |  爬虫    |  每天或者每几小时,定时的爬取别人的内容 |
| 4 | 数据归档  |  数据到了一定的量级,可以对其进行归档,作为冷数据<br>比如订单量  |


* 1.2.3是基于时间,4是基于数据.


## 任务调度框架


|序号| 名称| 描述 |
|----|-----|-----|
| 1  |  非分布式 |  想要获取商家上个月订单,但是,代码在两个tomcat上,非分布式两个服务器都启动,都来运行这个任务, 而想要的结果实际只在一台服务器上,适合分布式框架,但是非分布式的框架用起来简单,既不需要高并发,也不需要高可用,挂掉一回无所谓 |
| 2  |  分布式   |   |



### 非分布式调度框架


* @Scheduled spring框架自带




### 分布式调度框架

序号| 名称| 网址 |描述 |
|----|-----|-----|-----|
| 1  |  QuartZ |  [http://www.quartz-scheduler.org/](http://www.quartz-scheduler.org/)<br>[https://github.com/quartz-scheduler/quartz](https://github.com/quartz-scheduler/quartz) |原始的框架,后期很多框架基于它,缺点缺少界面化,接口不够人性化      |
| 2  |  Elasticjob | [https://shardingsphere.apache.org/elasticjob/](https://shardingsphere.apache.org/elasticjob/)<br>[https://github.com/apache/shardingsphere-elasticjob](https://github.com/apache/shardingsphere-elasticjob)  | 旧版叫做sharedingJDBC.基于QuartZ开发,当当开源出来的框架,归属到了Apache,用了很多中间件,复杂度较高   |
| 3  |  XXL-JOB(推荐)   | [https://www.xuxueli.com/xxl-job/](https://www.xuxueli.com/xxl-job/) <br> [https://github.com/xuxueli/xxl-job](https://github.com/xuxueli/xxl-job) |轻量级框架,大众点评开源出来的,适合绝大多数开发者,维护文档较好       |
| 4  |  SchedulerX   | [https://www.aliyun.com/search?k=schedulerx&__is_mobile__=false&__is_spider__=false&__is_grey__=false](https://www.aliyun.com/search?k=schedulerx&__is_mobile__=false&__is_spider__=false&__is_grey__=false)| 阿里云开发出来的商用产品,对其调度,控制台都在阿里云上,需要话费金钱,非免费       |
| 5  |  PowerJob   | [https://github.com/PowerJob/PowerJob](https://github.com/PowerJob/PowerJob)| 比较新,阿里云schedulerx团队离职的开发写的        |




### Scheduled核心配置属性


序号| 名称| 描述 |
|----|-----|-----|
| 1  |  @EnableScheduling |是否开启 schedule ,加在类上,作用就是当前类<br>加在@SpringBootApplication 上,就是整个项目生效      |
| 2  |  @Scheduled |fixedDelay 默认是int型<br>fixedDelayString 说明等号后要是字符型数据<br>默认项目启动就打印 initialDelay 不在启动的时候打印 -----延迟启动<br>initialDelay 延迟启动<br>fixedDelay 固定延迟，时间间隔是前次任务的结束到下次任务的开始<br>fixedRate 时间间隔是前次任务和下次任务的开始<br>crontab  https://cron.qqe2.com/ 这个网址可以解析表达式,输入条件自动生成表达式      |




## XXL-JOB



* XXL-JOB是大众点评员工徐雪里于2015年发布的分布式任务调度平台


* 官网地址: [https://www.xuxueli.com/xxl-job/](https://www.xuxueli.com/xxl-job/)






























