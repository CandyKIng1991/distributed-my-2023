package com.grandfather.www.util;/**
 * @author: MrLiu
 * @createTime: 2023/07/07 19:13
 * @description: xxx
 */

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.uitil
 * @className: Port
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-07 19:13
 * @version: 1.0
 */
public class PortServer {


    public static String getUrl() {

        return "http://" + PortServer.getIpAndPort();
    }


    //通过request获取ip
    public static String getIp() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getServerName();
    }

    //通过request获取端口
    public static String getLocalPort() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getServerPort() + "";
    }

    public static String getIpAndPort() {
        return getIp() + ":" + getLocalPort();
    }
}
