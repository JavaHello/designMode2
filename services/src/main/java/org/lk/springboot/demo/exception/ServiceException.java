package org.lk.springboot.demo.exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -8663782564934857683L;
    private String code;
    private String message;

    public ServiceException() {
        this(ErrorCodeEnum.ERROR.getCode(),ErrorCodeEnum.ERROR.getMessage());
    }
    public ServiceException(ErrorCodeEnum errorCodeEnum) {
        this(errorCodeEnum.getCode(),errorCodeEnum.getMessage());
    }
    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
