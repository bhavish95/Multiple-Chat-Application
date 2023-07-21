package com.bhavish.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
	
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException{
		String encryptedPassword=null;
		MessageDigest messageDigest=MessageDigest.getInstance("MD5");
		messageDigest.update(plainPassword.getBytes());
		byte[] encrypt=messageDigest.digest();
		StringBuffer sb=new StringBuffer();
		for(byte b:encrypt) {
			sb.append(b);
		}
		encryptedPassword=sb.toString();
		//System.out.println("Encrypted password"+encryptedPassword);
		return encryptedPassword;
				
        
	}
	
}
