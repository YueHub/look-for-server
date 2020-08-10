package cn.lcy.lookfor.vo;

import org.springframework.stereotype.Component;

@Component
public class SuccessMessage {

    /**
     * 状态编码
     */
    private int code;

    /**
     * 成功信息
     */
    private String message;

    private Object data;

    public SuccessMessage() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
