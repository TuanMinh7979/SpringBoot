package com.Springlambok.lambok.util;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {
	

	public static String hash(String plain) {
		return BCrypt.hashpw(plain, BCrypt.gensalt());
	}

	public static boolean verify(String plain, String hasded) {

		return BCrypt.checkpw(plain, hasded);
	}

}
