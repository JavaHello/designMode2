package org.lk.springboot.demo.web.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.lk.springboot.demo.exception.ErrorCodeEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

    private ResponseMessage(String code, String message, Object content) {
        super();
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;


    public static class Build {
        private String code;
        private String message;

        @JSONField(serialize = false)
        private Map<String, Object> content;

        public Build() {

        }

        public Build setCode(String code) {
            this.code = code;
            return this;
        }

        public Build setMessage(String message) {
            this.message = message;
            return this;
        }

        public Build put(String key, Object value) {
            if (this.content == null) {
                this.content = new HashMap<>();
            }
            this.content.put(key, value);
            return this;
        }

        private Build init() {
            if (this.code == null) {
                throw new IllegalArgumentException("code is null");
            }
            if (this.message == null) {
                throw new IllegalArgumentException("message is null");
            }
            return this;
        }

        public ResponseMessage build() {
            this.init();
            return new ResponseMessage(this.code, this.message, this.content);
        }

        public JSONObject buildJson() {
            this.init();
            JSONObject json = (JSONObject) JSONObject.toJSON(this);
            this.putJson(json, this.content);
            return json;
        }

        private void putJson(JSONObject json, Map<String, Object> content) {
            if (content != null)
                for (Map.Entry<String, Object> stringObjectEntry : content.entrySet()) {
                    json.put(stringObjectEntry.getKey(), stringObjectEntry.getValue());
                }
        }

    }

    public static Build success() {
        return success("成功");
    }

    public static Build success(String message) {
        return new Build().setCode(SUCCESS_CODE).setMessage(message);
    }

    public static Build failure() {
        return failure("失败");
    }

    public static Build failure(String message) {
        return failure(ERROR_CODE, message);
    }

    public static Build failure(String code, String message) {
        return new Build().setCode(code).setMessage(message);
    }

    public static Build failure(ErrorCodeEnum errorCodeEnum) {
        return failure(errorCodeEnum.getCode(), errorCodeEnum.getMessage());
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
