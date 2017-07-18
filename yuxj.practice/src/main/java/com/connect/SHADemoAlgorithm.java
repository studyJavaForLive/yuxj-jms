package com.connect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SHADemoAlgorithm {
	public static String src = "Hello SHA";
	
	public static void main(String[] args) {
		
		jdkSHA1();
		
		bcSHA1();
		
		ccSHA1();
		
	}
	
	public static void jdkSHA1(){
		
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA");
			
			sha.update(src.getBytes());
			
			System.out.println("jdk SHA:" + Hex.encodeHexString(sha.digest()));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void bcSHA1(){
		
		Security.addProvider(new BouncyCastleProvider());
		
		try {
			MessageDigest mdSha1 = MessageDigest.getInstance("SHA");
			
			//加载到mdSha1
			mdSha1.update(src.getBytes());
			
			//加密
			byte[] bytes = mdSha1.digest();
			
			//转换成String类型
			String strByte = org.bouncycastle.util.encoders.Hex.toHexString(bytes);
			
			System.out.println("bouncy code SHA:" + strByte);
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ccSHA1(){
		
		System.out.println("commons code:"+ DigestUtils.sha1Hex(src));
		
	}
}









