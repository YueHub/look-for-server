package cn.lcy.lookfor.vo;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {

    /**
     * 错误编码
     */
    private int errorCode;

    /**
     * 错误信息
     */
    private String message;

    public ErrorMessage() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}