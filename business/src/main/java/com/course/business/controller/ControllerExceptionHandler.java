package com.course.business.controller;

import com.course.server.exception.ValidatorException;
import com.course.server.respDto.CommonRespDto;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zzy
 * @date 2022/2/28
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    
    @ExceptionHandler(value = ValidatorException.class)
    @ResponseBody
    public CommonRespDto validatorExceptionHandler(ValidatorException  e) {
            CommonRespDto commonRespDto = new CommonRespDto();
            commonRespDto.setSuccess(false);
            LOG.warn(e.getMessage());
            commonRespDto.setMessage("请求参数异常!");
            return commonRespDto;
    }

}
