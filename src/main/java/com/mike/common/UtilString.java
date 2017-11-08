package com.mike.common;

import java.text.Collator;
import java.util.*;

@SuppressWarnings("UnusedDeclaration")
public class UtilString {
    private static Collator chineseCollator = Collator.getInstance(Locale.CHINA);

    /**
     * strSrc中寻找第一个strSe并且返回以其分隔的Left部分，汉字长度也为1
     *
     * @param strSrc 源字符串
     * @param strSe  分割字符
     * @return String 返回
     */
    public static String getLeft(String strSrc, String strSe) {
        if (UtilPub.isEmpty(strSrc))
            return "";
        if (UtilPub.isEmpty(strSe))
            strSe = " ";

        String result = "";
        int pos = strSrc.indexOf(strSe);
        if (pos >= 0)
            result = strSrc.substring(0, pos);
        return result;
    }

    /**
     * 返回字符串的左边部分，汉字长度也为1
     *
     * @param strSrc 源串,如果为空，则返回“”；
     * @param count  要获取的右边字符串长度,负数将返回“”，如果count>字符串长度，则返回整个字符串；
     * @return String return
     */
    public static String getLeft(String strSrc, int count) {
        if (UtilPub.isEmpty(strSrc) || count <= 0) {
            return "";
        }
        if (strSrc.length() < count) {
            return strSrc;
        } else {
            return strSrc.substring(0, count);
        }
    }

    /**
     * strSrc中寻找第一个strSe并且返回以其分隔的Right部分,汉字长度也为1
     *
     * @param strSrc 源串
     * @param strSe  分隔符,一个字符
     * @return String right部分
     */
    public static String getRight(String strSrc, String strSe) {
        if (UtilPub.isEmpty(strSrc))
            return "";
        if (UtilPub.isEmpty(strSe))
            strSe = " ";

        String result = strSrc;
        int pos = strSrc.indexOf(strSe);
        if (pos >= 0)
            result = strSrc.substring(pos + 1);
        return result;
    }

    /**
     * 返回字符串的右边部分，汉字长度也为1
     *
     * @param strSrc 源串
     * @param count  要获取的右边字符串长度,负数将返回“”，如果count>字符串长度，则返回整个字符串；
     * @return String return
     */
    public static String getRight(String strSrc, int count) {
        if (UtilPub.isEmpty(strSrc) || count <= 0) {
            return "";
        }
        int l = strSrc.length();
        if (l <= count) {
            return strSrc;
        }
        return strSrc.substring(l - count);
    }

    /**
     * 左边补齐字符
     *
     * @param src    源串
     * @param pad    补齐字符
     * @param length 最终长度
     * @return 补齐后的字符串
     */
    public static String padLeft(String src, String pad, int length) {
        StringBuilder sb = new StringBuilder(repeatString(pad, length));
        sb.append(src);
        return sb.substring(sb.length() - length);
    }

    public static String padLeft(long src, String pad, int length) {
        StringBuilder sb = new StringBuilder(repeatString(pad, length));
        sb.append(src);
        return sb.substring(sb.length() - length);
    }

    public static String padRight(String src, String pad, int length) {
        StringBuilder sb = new StringBuilder(length * pad.length() + src.length());
        sb.append(src).append(repeatString(pad, length));
        return sb.substring(0, length);
    }

    public static String padRight(long src, String pad, int length) {
        StringBuilder sb = new StringBuilder(length * pad.length());
        sb.append(src).append(repeatString(pad, length));
        return sb.substring(0, length);
    }

    /**
     * 由于jdk1.3提供的replace函数不能满足替换要求，自己写一个
     *
     * @param src  源串
     * @param oldS 将...
     * @param newS 替换成...
     * @return 替换后的字符串
     */
    public static String replaceString(String src, String oldS, String newS) {
        StringBuilder ret = new StringBuilder(64);
        int pos = src.indexOf(oldS);
        while (pos >= 0) {
            ret.append(src.substring(0, pos)).append(newS);
            src = src.substring(pos + oldS.length());
            pos = src.indexOf(oldS);
        }
        ret.append(src);
        return ret.toString();
    }

    /**
     * 取得指定字符串左边的有效数字,首先去掉两边空格
     *
     * @param s 源串
     * @return 串左边的有效数字
     */
    public static String getStringLeftNumber(String s) {
        String ret = "";
        int dotCount = 0;
        s = s.trim();
        char[] carr = s.toCharArray();
        for (char aCarr : carr) {
            if (Character.isDigit(aCarr)) {
                ret += aCarr;
            } else if (aCarr == '.' && dotCount == 0) {
                ret += aCarr;
                dotCount++;
            } else {
                break;
            }
        }
        if (ret.endsWith(".")) {
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }

    /**
     * 取得重复字串
     *
     * @param repeatString 重复字串
     * @param count        重复次数
     * @return String
     */
    public static String repeatString(String repeatString, int count) {
        if (count <= 0) return "";
        StringBuilder ret = new StringBuilder(repeatString.length() * count);
        for (int i = 1; i <= count; i++) {
            ret.append(repeatString);
        }
        return ret.toString();
    }

    /**
     * 去除字符串左边的指定字符串
     *
     * @param src 源字符串
     * @param cut 要去掉的字符串；
     * @return 处理结果
     */
    public static String cutStringLeft(String src, String cut) {
        if (UtilPub.isEmpty(src) || UtilPub.isEmpty(cut)) {
            return "";
        }
        if (src.startsWith(cut)) {
            return cutStringLeft(src.substring(cut.length()), cut);
        } else {
            return src;
        }
    }

    public static String cutStringRight(String src, String cut) {
        if (UtilPub.isEmpty(src) || UtilPub.isEmpty(cut)) {
            return "";
        }
        while (src.endsWith(cut))
            src = src.substring(0, src.length() - cut.length());

        return src;
    }

    /**
     * Removes all spaces from a string
     * 可以替换大部分空白字符， 不限于空格,\s 可以匹配空格、制表符、换页符等空白字符的其中任意一个
     */
    public static String removeSpaces(String str) {
        return str.replaceAll("\\s*", "");
    }

    /**
     * Creates a single string from a List of strings seperated by a delimiter.
     *
     * @param list  a list of strings to join
     * @param delim the delimiter character(s) to use. (null value will join with no delimiter)
     * @return a String of all values in the list seperated by the delimiter
     */
    public static String join(List<String> list, String delim) {
        if (list == null || list.size() < 1)
            return null;
        StringBuffer buf = new StringBuffer();
        Iterator i = list.iterator();

        while (i.hasNext()) {
            buf.append((String) i.next());
            if (i.hasNext())
                buf.append(delim);
        }
        return buf.toString();
    }

    /**
     * Splits a String on a delimiter into a List of Strings.
     *
     * @param str   the String to split
     * @param delim the delimiter character(s) to join on (null will split on whitespace)
     * @return a list of Strings
     */
    public static List<String> split(String str, String delim) {
        List<String> splitList = null;
        StringTokenizer st;
        if (str == null)
            return splitList;

        if (delim != null)
            st = new StringTokenizer(str, delim);
        else
            st = new StringTokenizer(str);

        if (st.hasMoreTokens()) {
            splitList = new ArrayList<String>();
            while (st.hasMoreTokens())
                splitList.add(st.nextToken());
        }
        return splitList;
    }

    //是否为true,(1,y,true,yes)
    public static boolean toBoolean(String v) {
        return "1".equals(v) || "y".equalsIgnoreCase(v) || "true".equalsIgnoreCase(v) || "yes".equalsIgnoreCase(v);
    }

    public static int chineseCompare(String s1, String s2) {
        return chineseCollator.compare(s1, s2);
    }

    /**
     * 按照编码级次，得到类型的真实编码，主要用于like 'parentCode%'
     * getSplitTypeCode('GF82000',2, 2, 1) == GF82
     * getSplitTypeCode('GF82100',3, 2, 1) == GF821
     * getSplitTypeCode('82100'  ,3, 0, 1) == 821
     *
     * @param curLevel   当前编码的所在层次
     * @param startIndex 数字编码的开始选项
     * @param perSize    每层的数字编码长度
     */
    public static String getRealCode(String code, int curLevel, int startIndex, int perSize) {
        StringBuilder sb = new StringBuilder(code.length());
        if (startIndex > 0) sb.append(code.substring(0, startIndex));
        for (int i = startIndex, l = 0; i < code.length(); i += perSize) {
            if (l < curLevel) {
                sb.append(code.substring(i, i + perSize));
                ++l;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    //函数功能: 正整数
    public static boolean isPureNumber(String inputString) {
        return inputString.matches("^[1-9]\\d*$");
    }

    //函数功能: 正整数
    public static boolean isNumber(String inputString) {
        return inputString.matches("^[0-9]\\d*$");
    }

    //首字母大写
    public static String upFirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String padRightBytes(String src, String pad, int length) {
        length -= src.replaceAll("[^\\x00-\\xff]", "**").length();
        return src + repeatString(pad, length);
    }

    //按字节数取子串，begin不是按字节的
    public static String substrByte(String src, int begin, int len) {
        StringBuilder sb = new StringBuilder(32);
        char c;
        int tl = src.length();
        for (int i = begin; i < len + begin && i < tl; i++) {

            c = src.charAt(i);
            sb.append(c);
            if (String.valueOf(c).replaceAll("[^\\x00-\\xff]", "**").length() > 1) {
                // 遇到中文汉字，截取字节总数减1
                --len;
            }
        }
        return sb.toString();
    }

    public static float[] getFloatArr(String source, String split){
        if(source == null || source.length() == 0){
            return null;
        }
        String[] floatArr = source.split(split);
        float[] result = new float[floatArr.length];
        for(int i = 0; i < floatArr.length; i++){
            try {
                result[i] = Float.parseFloat(floatArr[i]);
            } catch (NumberFormatException e) {
                result[i] = 0;
                e.printStackTrace();
            }
        }
        return result;
    }
}
