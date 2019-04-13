package ru.sberbook.sberbookroot.util;

public class ProfileUtils {
    public static boolean isPhone(String credential) {
        return !credential.contains("@");
    }

    public static boolean isEmail(String credential) {
        return credential.contains("@");
    }

}
