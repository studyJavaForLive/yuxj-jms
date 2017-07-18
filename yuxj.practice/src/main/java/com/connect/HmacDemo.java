package com.connect;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;

public class HmacDemo {

	public static void main(String[] args) {

		String src = "Hello Hmac!";

		try {
			// 初始化KeyGenerator
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");

			// 产生密钥
			SecretKey secret = keyGenerator.generateKey();

			byte[] key = secret.getEncoded();

			System.out.println(key);

			// 还原密钥
			SecretKey restoreKey = new SecretKeySpec(key, "HmacMD5");

			// 实例化MAC
			Mac mac = Mac.getInstance(restoreKey.getAlgorithm());

			// 初始化mac
			mac.init(restoreKey);

			// 执行摘要
			byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());

			System.out.println(org.apache.commons.codec.binary.Hex.encodeHexString(hmacMD5Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		test();

	}

	public static void test() {

		String src = "Hello Hmac!";

		try {
			// 初始化KeyGenerator
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");

			// 产生密钥
			SecretKey secret = keyGenerator.generateKey();

//			byte[] key = secret.getEncoded();
			byte[] key = org.apache.commons.codec.binary.Hex.decodeHex(new char[]{'a','a','a','a','a','a','a','a'});

			System.out.println(key);

			// 还原密钥
			SecretKey restoreKey = new SecretKeySpec(key, "HmacMD5");

			// 实例化MAC
			Mac mac = Mac.getInstance(restoreKey.getAlgorithm());

			// 初始化mac
			mac.init(restoreKey);

			// 执行摘要
			byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());

			System.out.println(org.apache.commons.codec.binary.Hex.encodeHexString(hmacMD5Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			e.printStackTrace();
		}

	}
}