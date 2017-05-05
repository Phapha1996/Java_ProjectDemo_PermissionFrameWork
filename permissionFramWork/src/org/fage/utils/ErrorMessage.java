package org.fage.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ErrorMessage {
	private static Properties prop;
	
	static{
		try {
			InputStream in = ErrorMessage.class.getClassLoader().getResourceAsStream("message.properties");
			prop = new Properties();
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//得到错误消息
	public static String getErrorMessage(String errorMessage){
		return prop.getProperty(errorMessage);
	}
	
}
