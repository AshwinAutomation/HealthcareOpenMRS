package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;
  
	public Properties init_prop() throws IOException {
		
		properties=new Properties();
		try {
			FileInputStream fi= new FileInputStream("./src/test/resources/config/config.properties");
			properties.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		  return properties;
	}
}
