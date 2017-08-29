package org.lk.springboot.demo.web.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.lk.springboot.demo.exception.ErrorCodeEnum;

public class ResponseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String ERROR_CODE = "0001";
	public final static String SUCCESS_CODE = "0000";

	public ResponseMessage() {
		super();
	}

	private ResponseMessage(String code, String message,Object content) {
		super();
		this.code = code;
		this.message = message;
		this.content = content;
	}

	private String code;
	private String message;
	
	private Object content;
	
	public static class Build {
		private String code;
		private String message;

		private Object content;

		public Build(){
			
		}
		public Build setCode(String code){
			this.code = code;
			return this;
		}
		public Build setMessage(String message) {
			this.message = message;
			return this;
		}

		public Build setContent(Object content) {
			this.content = content;
			return this;
		}

		public ResponseMessage build(){
			if(this.code == null){
				throw new IllegalArgumentException("code is null");
			}
			if(this.message == null){
				throw new IllegalArgumentException("message is null");
			}
			return new ResponseMessage(this.code, this.message, this.content);
		}
		
	}
	
	public static Build success(){
		return success("成功");
	}
	public static Build success(String message){
		return new Build().setCode(SUCCESS_CODE).setMessage(message);
	}
	public static Build failure(){
		return failure("失败");
	}
	public static Build failure(String message){
		return failure(ERROR_CODE, message);
	}
	public static Build failure(String code,String message){
		return new Build().setCode(code).setMessage(message);
	}
	public static Build failure(ErrorCodeEnum errorCodeEnum){
		return failure(errorCodeEnum.getCode(), errorCodeEnum.getMessage());
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getContent() {
		return content;
	}
}
