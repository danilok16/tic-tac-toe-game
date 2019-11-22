package com.unicap.redes.tictactoe.common;

import java.io.Serializable;

public class TransferObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;

    public TransferObject() {
    }

    public TransferObject(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "server.TransferObject{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
