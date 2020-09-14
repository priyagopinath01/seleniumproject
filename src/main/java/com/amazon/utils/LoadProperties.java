package com.amazon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	static Properties prop = new Properties();
	
	public LoadProperties() throws IOException {
		File f = new File(
				System.getProperty("user.dir") + "\\src\\test\\resource\\com\\configuration\\configuration.properties");
		FileInputStream fin = new FileInputStream(f);
		prop.load(fin);
	}

	public String getBrowserName() {
		String property = prop.getProperty("browserName");
		return property;
	}

	public String getUrl() {
		String property = prop.getProperty("url");
		return property;
	}

	public String getimplicitWait() {
		String property = prop.getProperty("implicitWait");
		return property;
	}

}
