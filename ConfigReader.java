package com.bhavish.chatapp.utils;

import java.util.ResourceBundle;

public class ConfigReader {
	ConfigReader(){}
   private static ResourceBundle rb=ResourceBundle.getBundle("Config");
    public static String getValue(String key) {
    	return rb.getString(key);
    }
}
