package com.grandfather.www.blockhandeler;/**
 * @author: MrLiu
 * @createTime: 2023/07/03 13:42
 * @description: xxx
 */

import com.google.gson.Gson;
import com.grandfather.www.common.ExceptionEnum;
import com.grandfather.www.common.Result;
import com.grandfather.www.common.ResultResponse;
import com.grandfather.www.common.Status;
import com.grandfather.www.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.blockhandeler
 * @className: GlobalExceptionHandler
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-03 13:42
 * @version: 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultResponse bizExceptionHandler(HttpServletRequest req, BizException e) {
        logger.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultResponse.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("发生空指针异常！原因是:", e);
        return ResultResponse.error(ExceptionEnum.BODY_NOT_MATCH);
    }

    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("未知异常！原因是:", e);
        return ResultResponse.success(ExceptionEnum.INTERNAL_SERVER_ERROR);
    }
}
