package cn.lcy.lookfor.enums;

public enum ErrorEnum {

    PARAMERROR(400, "参数错误"),
    DATABASEERROR(500, "关系数据库错误");

    private int code;

    private String message;

    private ErrorEnum(int code, String message) {
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
}
