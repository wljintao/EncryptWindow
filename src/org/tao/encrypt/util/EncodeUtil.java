package org.tao.encrypt.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class EncodeUtil {
	public static String encodeBase64(String str) {
		byte[] bytes = str.getBytes();
		byte[] encodeBytes = Base64.encodeBase64(bytes, true);
		String result = new String(encodeBytes);
		return result;
	}

	public static String encodeMD5(String str) {
		String result = DigestUtils.md5Hex(str);
		return result;
	}

	public static String encodeSHA1(String str) {
		String result = DigestUtils.sha1Hex(str);
		return result;
	}
}
