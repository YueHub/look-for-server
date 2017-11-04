package cn.lcy.lookfor.enums;

public enum SuccessEnum {
	
	POSTADDSUCCESS(200, "帖子添加成功");
	
	private int code;
	
	private String message;
	
	private SuccessEnum(int code, String message) {
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