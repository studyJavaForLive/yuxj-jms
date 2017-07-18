package com.connect;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Demo1 {
	
	public static void main(String[] args) {
		
		String scr = "imooc security base64";
		
		Base64Demo.jdkBase64(scr);
		
		Base64Demo.jdBase64(scr);
		
		Base64Demo.commonsCodeBase64(scr);
		
	}
	
	
	
}
/**
 * Base64加密算法
 * @author 1991
 *
 */
class Base64Demo{
	
	public static void jdkBase64(String code) {
		
		Encoder encoder = Base64.getEncoder();
		
		String encode = encoder.encodeToString(code.getBytes());
		
		System.out.println(encode);
		
		Decoder decoder = Base64.getDecoder();
		
		System.out.println(new String(decoder.decode(encode)));
		
	}
	
	public static void jdBase64(String code){
		
		BASE64Encoder encoder = new BASE64Encoder();
		
		String encode = encoder.encode(code.getBytes());
		
		System.out.println(encode);
		
		BASE64Decoder decoder = new BASE64Decoder();
		
		try {
			System.out.println(new String(decoder.decodeBuffer(encode)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commonsCodeBase64(String src) {
		
		byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		
		System.out.println(new String(bytes));
		
		System.out.println(new String (org.apache.commons.codec.binary.Base64.decodeBase64(bytes)));
		
	}
}
















