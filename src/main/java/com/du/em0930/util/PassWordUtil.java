package com.du.em0930.util;

import org.mindrot.jbcrypt.BCrypt;

public class PassWordUtil {
    //해싱
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    //비교
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
