package com.connect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
/**
 * 消息摘要加密算法
 * MD5 SHA MAC
 * @author 1991
 *
 */


public class MDDemoDigest{
	
	public static void main(String[] args) {
		
		String src = "Hello MD5";
		
		DesUtil.jdkMD5(src);
		DesUtil.bcMD5(src);
		DesUtil.ccMD5(src);
		
	}

}
class DesUtil{
	
	public static void jdkMD5(String src){
		
		try {
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			
			byte[] bytes = md5.digest(src.getBytes());
			
//			int length = bytes.length;
			
			System.out.println("JDK MD5 " + Hex.encodeHexString(bytes));
			
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void bcMD5(String src){
		
		Security.addProvider(new BouncyCastleProvider());
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
//			System.out.println(md5.getProvider());
			byte[] bytes = md5.digest(src.getBytes());
			System.out.println("BC MD5 " + org.bouncycastle.util.encoders.Hex.toHexString(bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	public static void ccMD5(String src){
		
		System.out.println("CC MD5 " + DigestUtils.md5Hex(src));
		
	}
	
}
