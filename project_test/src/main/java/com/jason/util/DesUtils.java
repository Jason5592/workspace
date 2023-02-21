package com.jason.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/***
 * @description: Des工具类
 * @author: cjh
 * @date: 2022/1/25 14:07
 */
public class DesUtils {
	
	private static final String KEY = "e#2sy^2u";
	
	private static final String ALGORITHM = "DES";
	
	/**
	 * 默认的编码
	 */
	public static final String DEFAULT_CHATSET = "UTF-8";
	
	public static byte[] encrypt(byte[] src, String secretKey) throws Exception {
		byte[] b = secretKey.getBytes(DEFAULT_CHATSET);
		SecretKey deskey = new SecretKeySpec(b, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, deskey);
        return cipher.doFinal(src);
	}
	
	public static String encrypt(String src, String secretKey) throws Exception {
		byte[] b = encrypt(src.getBytes(DEFAULT_CHATSET), secretKey);
		return Base64.encodeBase64String(b);
	}
	
	public static String encrypt(String src) throws Exception {
		byte[] b = encrypt(src.getBytes(DEFAULT_CHATSET), KEY);
		return Base64.encodeBase64String(b);
	}
	
	public static String encryptPwd(String src) throws Exception {
		if(StringUtils.isEmpty(src)) {
			return src;
		}
		byte[] b = encrypt(src.getBytes(DEFAULT_CHATSET), KEY);
		return Base64.encodeBase64String(b);
	}
	
	public static byte[] decrypt(byte[] src, String secretKey) throws Exception {
		byte[] b = secretKey.getBytes(DEFAULT_CHATSET);
		SecretKey deskey = new SecretKeySpec(b, ALGORITHM);
        Cipher c1 = Cipher.getInstance(ALGORITHM);
        c1.init(Cipher.DECRYPT_MODE, deskey);
        return c1.doFinal(src);
	}

	public static String decrypt(String src, String secretKey) throws Exception {
		byte[] b = Base64.decodeBase64(src);
		byte[] result = decrypt(b, secretKey);
		return new String(result, DEFAULT_CHATSET);
	}
	
	public static String decrypt(String src) throws Exception {
		byte[] b = Base64.decodeBase64(src);
		byte[] result = decrypt(b, KEY);
		return new String(result, DEFAULT_CHATSET);
	}
	
	public static String decryptPwd(String src) throws Exception {
		if(StringUtils.isEmpty(src)) {
			return src;
		}
		if(isNum(src)) {
			return src;
		}
		byte[] b = Base64.decodeBase64(src);
		byte[] result = decrypt(b, KEY);
		return new String(result, DEFAULT_CHATSET);
	}

	private static boolean isNum(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		return str.matches("^[-\\+]?[,.\\d]*$");
	}
	
	public static void main(String args[]) throws Exception {
		String s11111 = encrypt("123456");
		String saaaaa = DesUtils.encrypt("aaaaaa");
		System.out.println(s11111);
		System.out.println("加密=" + saaaaa);
		System.out.println(decryptPwd(s11111));
		System.out.println("解密=" + DesUtils.decryptPwd(saaaaa));
		System.out.println(decryptPwd("6vlI6UEKw8s="));
		System.out.println(decryptPwd("6vlI6UEKw8s="));
	}

}
