package org.lk.springboot.demo.exception;

/**
 * 错误代码
 * @author luokai
 *
 */
public enum ErrorCodeEnum {
	ERROR("0001", "错误"),
	ERROR_MODIFY("0002", "修改数据失败"),
    ERROR_PASSWORD("0003", "密码错误"), 
    NOT_PERMISSION("0004", "没有权限此操作"),
    ERROR_WEIXIN_ECHOSTR("weixin0001", "错误的微信服务验证");
	private String code;
	private String message;
	private ErrorCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
}
