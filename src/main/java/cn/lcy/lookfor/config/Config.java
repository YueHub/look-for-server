package cn.lcy.lookfor.config;

import java.io.IOException;
import java.util.Properties;

import cn.lcy.lookfor.util.Configuration;

public class Config {
	
	/**
	 * 配置类不需要生成实例
	 */
	private Config() {}
	
	/**
	 * 配置文件名
	 */
	public static final String PROPERTY_FILE = "look-for.properties";
	
	/**
	 * 配置
	 */
	public static Properties properties;
	
	/**
	 * 图片的 url 地址
	 */
	public static String imgUrl;
	
	/**
	 * 读取配置
	 */
	static {
		try {
			properties = Configuration.propertiesLoader(PROPERTY_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		imgUrl = properties.getProperty("imgUrl").toString();
	}

}
