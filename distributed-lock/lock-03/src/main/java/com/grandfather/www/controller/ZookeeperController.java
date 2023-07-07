package com.grandfather.www.controller;/**
 * @author: MrLiu
 * @createTime: 2023/07/07 15:19
 * @description: xxx
 */

import com.grandfather.www.config.ZookeeperLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.controller
 * @className: ZookeeperController
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-07 15:19
 * @version: 1.0
 */
@RestController
@Slf4j
public class ZookeeperController {

    boolean res = false;

    StringBuilder stringBuilder = new StringBuilder();

    @GetMapping("/lockZookeeper")
    public String lockZookeeper() {

        try {
            res = ZookeeperLockUtil.acquire();
            if (res) {
                log.info("..........开始下单...........");
                Thread.sleep(3000);
                stringBuilder.append("抢到了,解锁了...");
                log.info(stringBuilder.toString());
            } else {
                stringBuilder.append("..........很遗憾,未抢到...........");
                log.info(stringBuilder.toString());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (res) {
                //释放锁
                ZookeeperLockUtil.release();
            }
        }

        return "结果是 : " + stringBuilder.toString();

    }


}
