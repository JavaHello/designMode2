package org.lk.springboot.demo.exception;

/**
 * @author luokai
 *
 */
public class ApiException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;
	
	public ApiException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
	
	public ApiException(ErrorCodeEnum errorCodeEnum) {
		super(errorCodeEnum.getMessage());
		this.code = errorCodeEnum.getCode();
		this.message = errorCodeEnum.getMessage();
	}
	
	public ApiException() {
		super();
	}

	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
}
