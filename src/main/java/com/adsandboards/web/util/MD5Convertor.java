package com.adsandboards.web.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;

public class MD5Convertor {

	static final Logger logger = Logger.getLogger(MD5Convertor.class);

	public static String convertToMD5(String value) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(value.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			logger.warn("No such algorithm:" + e.getCause());
		} catch (UnsupportedEncodingException e) {
			logger.warn("Unsupported Encoding:" + e.getCause());
		}
		final byte[] resultByte = messageDigest.digest();
		String result = new String(Hex.encodeHex(resultByte));
		return result;
	}

}
