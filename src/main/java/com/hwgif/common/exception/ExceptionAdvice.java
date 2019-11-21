package com.hwgif.common.exception;

import com.hwgif.common.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lc.huang on 2019/11/19.
 * Description  目标全局异常处理
 */
@ControllerAdvice(basePackages = "com.hwgif.api")
public class ExceptionAdvice {

    private static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult handleMultipartException(Exception e){
        logger.info(e.getLocalizedMessage(),e);
        return CommonResult.exceptionResult(e.getMessage());
    }
}
