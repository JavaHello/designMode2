package org.lk.springboot.demo.web.util;

import org.lk.springboot.demo.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @ExceptionHandler(value=AccessDeniedException.class)
    public ResponseMessage allExceptionHandler(AccessDeniedException exception) throws Exception {
        logger.error(exception.getMessage(), exception);
        return ResponseMessage.failure(exception.getMessage()).build();
    }

    /**
     * 所有异常报错
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler({Exception.class, Throwable.class})
    public ResponseMessage allExceptionHandler(Exception exception) throws Exception {
        logger.error(exception.getMessage(), exception);
        return ResponseMessage.failure().build();
    }

    @ExceptionHandler(value=ApiException.class)
    public ResponseMessage allExceptionHandler(ApiException exception) throws Exception {
        return ResponseMessage.failure(exception.getMessage()).build();
    }
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    public ResponseMessage allExceptionHandler(MethodArgumentNotValidException exception) throws Exception {
        return ResponseMessage.failure(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()).build();
    }
}