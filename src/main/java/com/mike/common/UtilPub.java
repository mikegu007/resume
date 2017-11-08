package com.mike.common;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Mike on 2017/11/7.
 */
public class UtilPub {
    public static final String ROOT_PATH = UtilPub.class.getResource("/").getPath().toString();
    public static String WEB_PATH = "";
    private static SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat tFormat = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat dLFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat dLFormat2 = new SimpleDateFormat("yyyyMMdd");
    private static DecimalFormat df2Format = new DecimalFormat("###,###,###,###,##0.00");

    public UtilPub() {
    }

    public static <K, V> Map<K, V> toMap(K k1, V v1) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> Map<K, V> toMap(K k1, V v1, K k2, V v2) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> Map<K, V> toMap(K k1, V v1, K k2, V v2, K k3, V v3) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static <K, V> Map<K, V> toMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    public static <K, V> Map<K, V> toMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        HashMap map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    @SafeVarargs
    public static <T> T[] asArray(T... args) {
        return args;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(Object[] o) {
        return o == null || o.length == 0;
    }

    public static boolean isEmptyStr(String str) {
        return str == null || str.trim().length() == 0 || "-".equals(str);
    }

    public static boolean isEmptyId(String id) {
        return id == null || id.trim().length() == 0 || "0".equals(id) || "-".equals(id) || "-1".equals(id) || "null".equals(id) || "(无)".equals(id);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNotEmptyId(String str) {
        return !isEmptyId(str);
    }

    public static boolean isNotEmptyStr(String str) {
        return !isEmptyStr(str);
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Object[] o) {
        return !isEmpty(o);
    }

    public static String ignoreNull(String str) {
        return str == null?"":str;
    }

    public static String trimIgnoreNull(String str) {
        return str == null?"":str.trim();
    }

    public static double getDoubleIgnoreErr(String str) {
        if(str == null) {
            return 0.0D;
        } else {
            str = str.trim();
            if(str.equals("")) {
                return 0.0D;
            } else {
                str = str.replaceAll(",", "").replaceAll("，", "");

                try {
                    return Double.valueOf(str).doubleValue();
                } catch (Exception var2) {
                    return 0.0D;
                }
            }
        }
    }

    public static int getIntIgnoreErr(String str) {
        return getIntIgnoreErr(str, 0);
    }

    public static int getIntIgnoreErr(String str, int defValue) {
        if(str == null) {
            return defValue;
        } else {
            str = str.trim();
            if(str.equals("")) {
                return defValue;
            } else {
                str = str.replaceAll(",", "").replaceAll("，", "");
                if(str.contains(".")) {
                    str = str.substring(0, str.indexOf(46));
                }

                try {
                    return Integer.valueOf(str).intValue();
                } catch (Exception var3) {
                    return defValue;
                }
            }
        }
    }

    public static long getLongIgnoreErr(String str) {
        return getLongIgnoreErr(str, 0L);
    }

    public static long getLongIgnoreErr(String str, long defValue) {
        if(str == null) {
            return defValue;
        } else {
            str = str.trim();
            if(str.equals("")) {
                return defValue;
            } else {
                str = str.replaceAll(",", "").replaceAll("，", "");

                try {
                    return Long.valueOf(str).longValue();
                } catch (Exception var4) {
                    return defValue;
                }
            }
        }
    }

    public static Date getDateFromTimestampIgnoreNull(Timestamp datetime) {
        return datetime == null?null:new Date(datetime.getTime());
    }

    public static Date getSqlDateFromUtilDate(java.util.Date utilDate) {
        return new Date(utilDate.getTime());
    }

    public static java.util.Date getUtilDateFromSqlDate(Date sqlDate) {
        return new java.util.Date(sqlDate.getTime());
    }

    public static Date getDateFromStrIgnoreErr(String dateStr) {
        try {
            return Date.valueOf(dateStr);
        } catch (Exception var2) {
            return null;
        }
    }

    public static String getDateStrIgnoreNull(java.util.Date obj) {
        return obj == null?"":dFormat.format(obj);
    }

    public static String getDateStrIgnoreNull(Date obj) {
        return obj == null?"":dFormat.format(obj);
    }

    public static String getDateHtmlStrIgnoreNull(java.util.Date obj) {
        return UtilHtml.getHtmlStr(getDateStrIgnoreNull(obj));
    }

    public static String getDateHtmlStrIgnoreNull(Date obj) {
        return UtilHtml.getHtmlStr(getDateStrIgnoreNull(obj));
    }

    public static String getDateStrIgnoreNull(Timestamp obj) {
        return obj == null?"":dFormat.format(obj);
    }

    public static String getDateHtmlStrIgnoreNull(Timestamp obj) {
        return UtilHtml.getHtmlStr(getDateStrIgnoreNull(obj));
    }

    public static String getTimeStrIgnoreNull(Timestamp obj) {
        return obj == null?"":tFormat.format(obj);
    }

    public static String getTimeHtmlStrIgnoreNull(Timestamp obj) {
        return UtilHtml.getHtmlStr(getTimeStrIgnoreNull(obj));
    }

    public static Timestamp getDateTimeFromStrIgnoreErr(String dateTimeStr) {
        try {
            return Timestamp.valueOf(dateTimeStr);
        } catch (Exception var2) {
            return null;
        }
    }

    public static String getDateTimeStrIgnoreNull(Timestamp obj) {
        return obj == null?"":dtFormat.format(obj);
    }

    public static String getDateTimeBRHtmlStrIgnoreNull(Timestamp obj) {
        return obj == null?"&nbsp;":getDateStrIgnoreNull(obj) + "<br>" + getTimeStrIgnoreNull(obj);
    }

    public static String getDateTimeHtmlStrIgnoreNull(Timestamp obj) {
        return UtilHtml.getHtmlStr(getDateTimeStrIgnoreNull(obj));
    }

    public static Date getCurDate() {
        return new Date(System.currentTimeMillis());
    }

    public static String getCurDateStr() {
        return dFormat.format(new Date(System.currentTimeMillis()));
    }

    public static Timestamp getCurDatetime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getCurDatetimeStr() {
        return dtFormat.format(new Timestamp(System.currentTimeMillis()));
    }

    public static String checkNull(String str) {
        return isEmpty(str)?"":str.trim();
    }

    public static String checkNull(Integer n) {
        return checkNull(n, true);
    }

    public static String checkNull(Integer n, boolean zeroToEmpty) {
        int v;
        if(n != null && n.intValue() != 0) {
            v = n.intValue();
        } else {
            v = 0;
        }

        return v != 0?String.valueOf(v):(zeroToEmpty?"":"0");
    }

    public static String checkNull(Long n) {
        return checkNull(n, 0L);
    }

    public static String checkNull(Long n, long defValue) {
        return n != null?String.valueOf(n):String.valueOf(defValue);
    }

    public static String checkNull(Double n) {
        return checkNull(n, 0.0D);
    }

    public static String checkNull(Double n, double defValue) {
        double d = n != null?n.doubleValue():defValue;
        return String.valueOf(d);
    }

    public static String periodIdToYm(String period_id) {
        return !isEmpty(period_id) && period_id.trim().length() == 6?period_id.trim().substring(0, 4).concat("-").concat(period_id.trim().substring(4)):"";
    }

    public static String getThisYear() {
        GregorianCalendar tlpDate = new GregorianCalendar();
        tlpDate.setTime(getCurDate());
        return String.valueOf(tlpDate.get(1));
    }

    public static String getThisMonth() {
        GregorianCalendar tlpDate = new GregorianCalendar();
        tlpDate.setTime(getCurDate());
        return String.valueOf(tlpDate.get(2));
    }

    public static boolean isContain(String str, String subStr) {
        return !isEmpty(str) && !isEmpty(subStr) && str.contains(subStr);
    }

    public static String checkNull(String strValue, String defaultValue) {
        return strValue == null?defaultValue:strValue;
    }

    public static String checkEmpty(String strValue, String defaultValue) {
        return isEmpty(strValue)?defaultValue:strValue;
    }

    public static String checkEmptyId(String strValue, String defaultValue) {
        return isEmptyId(strValue)?defaultValue:strValue;
    }

    public static boolean isInList(String str, List lt) {
        if(lt == null) {
            return false;
        } else if(isEmpty(str)) {
            return false;
        } else {
            Iterator var2 = lt.iterator();

            Object aLt;
            do {
                if(!var2.hasNext()) {
                    return false;
                }

                aLt = var2.next();
            } while(!str.equals(aLt));

            return true;
        }
    }

    public static boolean arrayLengthIsSame(Object[] a, Object[] b) {
        int size_a = a == null?0:a.length;
        int size_b = b == null?0:b.length;
        return size_a == size_b;
    }

    public static String subLastChar(String str) {
        return isEmpty(str)?"":str.substring(0, str.length() - 1);
    }

    public static String getOrigMsg(Throwable e) {
        String s = e.getMessage();

        for(Throwable t = e.getCause(); t != null; t = t.getCause()) {
            s = t.getMessage();
        }

        return s;
    }

    public static <V> V getValueFromMapIgnoreCase(Map<String, V> map, String key) {
        Iterator var2 = map.keySet().iterator();

        String k;
        do {
            if(!var2.hasNext()) {
                return null;
            }

            k = (String)var2.next();
        } while(!k.equalsIgnoreCase(key));

        return map.get(k);
    }

    public static void strToMap(String str, Map<String, String> map, boolean upperKey) {
        String[] ss = str.split("&");
        String[] var6 = ss;
        int var7 = ss.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String s = var6[var8];
            if(!isEmpty(s)) {
                String[] sp = s.split("=");
                String key;
                if(upperKey) {
                    key = sp[0].toUpperCase();
                } else {
                    key = sp[0];
                }

                if(sp.length > 1) {
                    map.put(key, sp[1]);
                } else {
                    map.put(key, "");
                }
            }
        }

    }

    public static int strLength(String source) {
        int totalLength = source.length();
        String otherStr = source.replaceAll("\\d|\\w", "");
        int otherLength = otherStr.length();
        return totalLength - otherLength + otherLength * 2;
    }

    public static String checkLastTime(String strTime) {
        return isEmpty(strTime)?"":checkLastTime(UtilMath.tolong(strTime, 0L));
    }

    public static String checkLastTime(long lngTime) {
        if(0L >= lngTime) {
            return "";
        } else {
            String s1 = String.valueOf(lngTime + "").trim();
            return s1.length() != 14?"":s1.substring(0, 4).concat("-").concat(s1.substring(4, 6)).concat("-").concat(s1.substring(6, 8)).concat(" ").concat(s1.substring(8, 10)).concat(":").concat(s1.substring(10, 12)).concat(":").concat(s1.substring(12));
        }
    }

    public static Long getLastTime() {
        return UtilDateTime.nowDateTimeNumber();
    }

    public static Long getLastDate() {
        return Long.valueOf(dLFormat2.format(new Timestamp(System.currentTimeMillis())));
    }

    public static String getAmountStr(double amount) {
        return df2Format.format(amount);
    }

    public static String getAmountStr(double amount, boolean zeroShowEmpty) {
        return zeroShowEmpty && UtilMath.isEqualsZero(amount)?"":df2Format.format(amount);
    }

    public static String getIntStr(int d) {
        return d == 0?"":String.valueOf(d);
    }

    public static String cutZero(String codeStr) {
        int j = 0;
        int len = codeStr.length() - 1;

        for(int i = len; i > -1 && 48 == codeStr.charAt(i); --i) {
            ++j;
        }

        return codeStr.substring(0, len - j + 1);
    }

    public static String fillZero(int codeLen, String cutedCode) {
        StringBuilder codeStr = (new StringBuilder(20)).append(cutedCode);
        int len = cutedCode.length();

        for(int i = 0; i < codeLen - len; ++i) {
            codeStr.append("0");
        }

        return codeStr.toString();
    }

    public static boolean toBoolean(String v, boolean b) {
        return v == null?b:"1".equals(v) || "true".equalsIgnoreCase(v) || "Y".equalsIgnoreCase(v) || "yes".equalsIgnoreCase(v);
    }

    public static String getDateStr(Object _dateTime) {
        String dateTime = String.valueOf(_dateTime);
        if(!isEmpty(dateTime) && dateTime.length() >= 7) {
            String s1 = String.valueOf(dateTime);
            return s1.substring(0, 4) + "-" + s1.substring(4, 6) + "-" + s1.substring(6, 8);
        } else {
            return "";
        }
    }

    public static String getDateTimeStr(Object _dateTime) {
        String dateTime = String.valueOf(_dateTime);
        if(!isEmpty(dateTime) && dateTime.length() >= 14) {
            String s1 = String.valueOf(dateTime);
            return s1.substring(0, 4) + "-" + s1.substring(4, 6) + "-" + s1.substring(6, 8);
        } else {
            return "";
        }
    }

    public static String getYearMonthStr(Object _dateTime) {
        String dateTime = String.valueOf(_dateTime);
        if(!isEmpty(dateTime) && dateTime.length() >= 7) {
            String s1 = String.valueOf(dateTime);
            return s1.substring(0, 4) + s1.substring(4, 6);
        } else {
            return "";
        }
    }

    public static String getStrArrayFirst(String sa) {
        String[] ss = sa.split(",");
        return ss.length > 0?ss[0]:"";
    }

    public static String remove(String str) {
        if(isEmpty(str)) {
            return "";
        } else {
            char[] charArray = str.toCharArray();
            char[] strArray = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '/', '-'};
            char[] var3 = charArray;
            int var4 = charArray.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                char c = var3[var5];
                if(!ArrayUtils.contains(strArray, c)) {
                    str = StringUtils.remove(str, c);
                }
            }

            return str;
        }
    }

    public static class FileName {
        public String path = "";
        public String name = "";
        public String mainName = "";
        public String exName = "";

        public FileName(String fileFullName) {
            File file = new File(fileFullName);
            this.path = file.getParent();
            this.name = file.getName();
            int i = this.name.lastIndexOf(".");
            if(i < 0) {
                this.mainName = this.name;
                this.exName = "";
            } else {
                this.mainName = this.name.substring(0, i);
                this.exName = this.name.substring(i + 1, this.name.length());
            }

        }
    }
}
