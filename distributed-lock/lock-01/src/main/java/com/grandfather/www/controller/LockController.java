package com.grandfather.www.controller;/**
 * @author: MrLiu
 * @createTime: 2023/07/07 14:26
 * @description: xxx
 */

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.controller
 * @className: LockController
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-07 14:26
 * @version: 1.0
 */

@RestController
@Slf4j
public class LockController {

    /**
     * 使用这个模式进行锁
     */
    @Autowired
    private RedissonClient redissonClient;

    /**
     * 不加redis锁的情况
     *
     * @return 结果
     */
    @GetMapping("/lock")
    public String lock() {

        // 期望再次被访问是在三秒以后,而不是立即被访问,这种模式很多时候sleep业务未执行完就被访问了.
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("解锁了...");

        return "解锁成功....";
    }

    /**
     * <a href="http://localhost:8087/addLock">...</a>
     * 使用加锁的模式
     *
     * @return 添加结果
     */
    @GetMapping("/addLock")
    public String addLock() {

        RLock locked = redissonClient.getLock("locked");

        // 期望再次被访问是在三秒以后,而不是立即被访问,这种模式很多时候sleep业务未执行完就被访问了.
        try {
            locked.lock();
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locked.unlock();
            log.info("解锁了...");
        }


        return "解锁成功....";
    }

    /**
     * <a href="http://localhost:8087/addLock">...</a>
     * 修改锁的时间
     *
     * @return 添加结果
     */
    @GetMapping("/addLockTime")
    public String addLockTime() {

        RLock locked = redissonClient.getLock("locked");

        // 期望再次被访问是在三秒以后,而不是立即被访问,这种模式很多时候sleep业务未执行完就被访问了.
        try {
            // 锁五秒
            locked.lock(5, TimeUnit.SECONDS);
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locked.unlock();
            log.info("解锁了...");
        }


        return "解锁成功....";
    }

    /**
     * <a href="http://localhost:8087/addTryLock">...</a>
     * 模拟抢购
     *
     * @return 添加结果
     */
    @GetMapping("/addTryLock")
    public String addTryLock() {

        StringBuilder stringBuilder = new StringBuilder();

        RLock locked = redissonClient.getLock("locked");

        // 期望再次被访问是在三秒以后,而不是立即被访问,这种模式很多时候sleep业务未执行完就被访问了.
        try {

            boolean tryLock = locked.tryLock();

            if (tryLock) {
                log.info("..........开始下单...........");
                Thread.sleep(3000);
                locked.unlock();
                stringBuilder.append("抢到了,解锁了...");
                log.info(stringBuilder.toString());
            } else {
                stringBuilder.append("..........很遗憾,未抢到...........");
                log.info(stringBuilder.toString());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "抢购结束,结果是 : "+stringBuilder.toString();
    }
}
