package cn.lcy.lookfor.vo;

import org.springframework.stereotype.Component;

import cn.lcy.lookfor.config.Config;

@Component
public class ResultVO {
	
	/**
	 * API 版本号
	 */
	private String version = Config.version;
	
	/**
	 * 请求接受时间
	 */
	private String requestTime;
	
	/**
	 * 发送响应时间
	 */
	private String responseTime;
	
	/**
	 * 返回结果
	 */
	private Object result;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
