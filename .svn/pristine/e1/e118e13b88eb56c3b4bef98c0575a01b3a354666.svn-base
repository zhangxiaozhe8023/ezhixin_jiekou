package com.interfaceTest.Tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tools {


	/**
	 * 获取32位MD5  取其中八位
	 * 
	 * @param value
	 * @return
	 */

	public static String getMD5(String value) {

		String hashtext = null;
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(value.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			hashtext = bigInt.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
//			hashtext = hashtext.toUpperCase();//大写
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		if (hashtext == null) {
			return "null";
		}else{
			hashtext = hashtext.substring(0,1)+hashtext.substring(2,3)+hashtext.substring(3,4)+hashtext.substring(6,7)
					+hashtext.substring(10,11)+hashtext.substring(20,21)+hashtext.substring(29,30)+hashtext.substring(30,31);
		}

		return hashtext;
	}

	/**
	 * 获取32位MD5
	 *
	 * @param value
	 * @return
	 */

	public static String get32MD5(String value) {

		String hashtext = null;
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(value.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			hashtext = bigInt.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
//			hashtext = hashtext.toUpperCase();//大写
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		if (hashtext == null) {
			return "null";
		}else{
			return hashtext;
		}

	}

}
