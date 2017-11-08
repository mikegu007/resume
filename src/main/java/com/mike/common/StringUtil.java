package com.mike.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mike on 2017/11/7.
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

    public static boolean isNull(Object obj) {
        boolean flag = false;
        if(null == obj || "".equals(obj)) {
            flag = true;
        }
        return flag;
    }

    public static String cutLetters(String source) {
        String regEx = "[A-Z]|[a-z]]*";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(source);
        return m.replaceAll("").trim();
    }

    public static String isIndex(String value) {
        Integer indexValue = null;
        Integer indexValues = null;
        if(value != null && !value.trim().equals("")) {
            try {
                indexValue = Integer.valueOf((int)Double.parseDouble(value));
                System.out.println("indexValue==" + indexValue);
                if(indexValue.intValue() < 100 || indexValue.intValue() > 600) {
                    indexValue = Integer.valueOf(600);
                }

                indexValues = Integer.valueOf(indexValue.intValue() % 10);
                indexValue = Integer.valueOf(indexValue.intValue() / 10);
                if(null != indexValues && indexValues.intValue() > 4) {
                    indexValue = Integer.valueOf((indexValue.intValue() + 1) * 10);
                } else {
                    indexValue = Integer.valueOf(indexValue.intValue() * 10);
                }

                System.out.println("indexValue==" + indexValue);
                return indexValue + "";
            } catch (Exception var4) {
                return "600";
            }
        } else {
            return "600";
        }
    }
}
