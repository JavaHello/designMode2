package org.lk.springboot.demo.web.websocket;

public class SocketRespMsg {
    private String message;

    public SocketRespMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
