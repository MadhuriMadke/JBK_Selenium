package com.tka.utilities.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
	public static String valueOfAnyKey(String anyKey) {
		InputStream inputStream = null;
		inputStream = PropUtil.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(anyKey);
	}
}
