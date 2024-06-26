package com.bytehonor.sdk.server.spring.web.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bytehonor.sdk.base.spring.response.JsonResponse;
import com.bytehonor.sdk.server.spring.exception.ErrorConvertor;

/**
 * 
 * @author lijianqiang
 *
 */
@ControllerAdvice
public class GlobalExceptionAdvisor {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionAdvisor.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public final JsonResponse<?> globalErrorHandler(Exception ex) {
        LOG.error("globalErrorHandler", ex);
        return ErrorConvertor.convert(ex);
    }

}
