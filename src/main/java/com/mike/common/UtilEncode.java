package com.mike.common;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * Created by Mike on 2017/11/7.
 */
public class UtilEncode {
    private static char[] hexChar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public UtilEncode() {
    }

    public static String toHexString(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);

        for(int i = 0; i < bytes.length; ++i) {
            buf.append(hexChar[(bytes[i] & 240) >>> 4]);
            buf.append(hexChar[bytes[i] & 15]);
        }

        return buf.toString();
    }

    public static byte[] fromHexString(String str) {
        int stringLength = str.length();
        if((stringLength & 1) != 0) {
            throw new IllegalArgumentException("������Ч��16�����ַ�����");
        } else {
            byte[] b = new byte[stringLength / 2];
            int i = 0;

            for(int j = 0; i < stringLength; ++j) {
                int high = convertChar(str.charAt(i));
                int low = convertChar(str.charAt(i + 1));
                b[j] = (byte)(high << 4 | low);
                i += 2;
            }

            return b;
        }
    }

    public static String encodeMD5(String origin) {
        return encode(origin, "MD5");
    }

    public static String encodeSHA(String origin) {
        return encode(origin, "SHA");
    }

    public static String encode(String origin, String digestType) {
        try {
            MessageDigest var3 = MessageDigest.getInstance(digestType);
            return toHexString(var3.digest(origin.getBytes("GBK")));
        } catch (Exception var31) {
            return "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";
        }
    }

    private static int convertChar(char c) {
        if(48 <= c && c <= 57) {
            return c - 48;
        } else if(97 <= c && c <= 102) {
            return c - 97 + 10;
        } else if(65 <= c && c <= 70) {
            return c - 65 + 10;
        } else {
            throw new IllegalArgumentException("Invalid hex Character:" + c);
        }
    }

    public static String base64Encode(String s) {
        try {
            return Base64.encode(URLEncoder.encode(s, "utf-8").replace("+", "%20").getBytes());
        } catch (UnsupportedEncodingException var2) {
            return Base64.encode(s.getBytes());
        }
    }

    public static String base64Decode(String s) {
        try {
            return URLDecoder.decode(new String(Base64.decode(s)), "utf-8");
        } catch (UnsupportedEncodingException var2) {
            return new String(Base64.decode(s));
        }
    }

    public static String decrypt(String txt) {
        StringBuilder src = new StringBuilder(64);
        int n = 1;
        int srclen = 0;
        int i = 0;

        int l1;
        for(int l = txt.length(); i < l; i += l1) {
            l1 = Integer.parseInt(txt.substring(i, i + 1), 21) - 10;
            ++i;
            String s = txt.substring(i, i + l1);
            if(i > 1) {
                src.append((char)(Integer.parseInt(s, 36) - n * 10 - srclen));
                ++n;
            } else {
                srclen = Integer.parseInt(s, 36) - 10;
            }
        }

        return src.toString();
    }

    public static String encrypt(String txt) {
        if(UtilPub.isEmpty(txt)) {
            return "";
        } else {
            StringBuilder src = new StringBuilder(64);
            int l = txt.length();
            String s = Integer.toString(l + 10, 36);
            src.append(Integer.toString(s.length() + 10, 21)).append(s);

            for(int i = 0; i < l; ++i) {
                s = Integer.toString(txt.charAt(i) + (i + 1) * 10 + l, 36);
                src.append(Integer.toString(s.length() + 10, 21)).append(s);
            }

            return src.toString();
        }
    }

    public static void main(String[] arg) {
        System.out.println(encodeMD5("888888"));
    }
}
