package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseConfig {
	
	public static  String getconfig(String key)  {
		
		
		Properties pro = new Properties();// how to read config /note pad or text file?
		
		//config file location
		String path ="./config.properties";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//connection of both
		try {
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(pro.get(key));
		
		return pro.get(key).toString();
	}
	public static void main(String[] args) throws Throwable {
		System.out.println(BaseConfig.getconfig("URL"));
	
	}

}
