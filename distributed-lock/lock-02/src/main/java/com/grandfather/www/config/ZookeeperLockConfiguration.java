package com.grandfather.www.config;/**
 * @author: MrLiu
 * @createTime: 2023/07/07 15:46
 * @description: xxx
 */

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryUntilElapsed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.zookeeper.lock.ZookeeperLockRegistry;

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.config
 * @className: ZookeeperLockConfiguration
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-07 15:46
 * @version: 1.0
 */
@Configuration
public class ZookeeperLockConfiguration {


    /**
     * 创建连接客户端的zookeeper
     * <p>
     * 连接不对会报错: java.lang.IllegalStateException: Expected state [STARTED] was [LATENT]
     *
     * @return 返回连接
     * @throws Exception 产生异常
     */
    @Bean
    public CuratorFramework curatorFramework() throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
                "127.0.0.1:2181", // 服务的地址,一般是zookeeper的地址
                new RetryUntilElapsed(
                        1000, // 以sleepMsBetweenRetries的间隔重连,直到超过maxElapsedTimeMs的时间设置
                        4             //  重连几次,简单粗暴
                ));

        // start()开始连接，没有此会报错
        curatorFramework.start();

        // 阻塞直到连接成功
        curatorFramework.blockUntilConnected();

        return curatorFramework;

    }


    /**
     * 将框架注册到zookeeper当中去
     *
     * @param curatorFramework 连接zookeeper服务的框架
     * @return 注册结果
     */
    @Bean
    public ZookeeperLockRegistry zookeeperLockRegistry(CuratorFramework curatorFramework) {
        return new ZookeeperLockRegistry(curatorFramework, "/locks");
    }

}
