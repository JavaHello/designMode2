package org.lk.springboot.demo.web.util;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 所有异常报错
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)
    public ResponseMessage allExceptionHandler(Exception exception) throws Exception {
        return ResponseMessage.failure().build();
    }
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    public ResponseMessage allExceptionHandler(MethodArgumentNotValidException exception) throws Exception {
        return ResponseMessage.failure(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()).build();
    }
}