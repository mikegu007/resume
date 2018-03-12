package com.mike.resume.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mike
 * @date 2018/3/12
 */
public class StringUtil {
    public StringUtil() {
    }

    public static boolean isNotNull(Object obj) {
        boolean flag = true;
        if(null == obj || "".equals(obj)) {
            flag = false;
        }

        return flag;
    }

    public static String cutLetters(String source) {
        String regEx = "[A-Z]|[a-z]]*";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(source);
        return m.replaceAll("").trim();
    }

}
