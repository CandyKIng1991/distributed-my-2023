package com.grandfather.www.common;/**
 * @author: MrLiu
 * @createTime: 2023/07/03 13:38
 * @description: xxx
 */

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.common
 * @className: BaseErrorInfoInterface
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-03 13:38
 * @version: 1.0
 */
public interface  BaseErrorInfoInterface {

    /**
     *  错误码
     * @return
     */
    String getResultCode();

    /**
     * 错误描述
     * @return
     */
    String getResultMsg();
}
