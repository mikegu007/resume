package com.mike.common;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

/**/
public class UtilMath {
    //整数
    private static DecimalFormat dfLng = new DecimalFormat("##############0");
    private static DecimalFormat dfLong = new DecimalFormat("###,###,###,###,##0");
    //一位小数
    private static DecimalFormat df1 = new DecimalFormat("##############0.0");
    private static DecimalFormat df1Format = new DecimalFormat("###,###,###,###,##0.0");
    //两位小数
    private static DecimalFormat df2 = new DecimalFormat("##############0.00");
    private static DecimalFormat df2Format = new DecimalFormat("###,###,###,###,##0.00");
    //四位小数
    private static DecimalFormat df4 = new DecimalFormat("###,###,###,###,##0.0000");
    //六位小数
    private static DecimalFormat df6Number = new DecimalFormat("#######################0.000000");
    private static DecimalFormat df6NumberF = new DecimalFormat("#,###,###,###,###,###,##0.000000");

    public final static DecimalFormat stdAmountFormat = new DecimalFormat("###,###,###,###,##0.00");
    public final static DecimalFormat stdNumberFormat = new DecimalFormat("#0.00");
    public final static String DEF_NUM_TEN_THOUSAND = "10000";//万
    public static final double MAX_VALUE = 9999999999999.99D;
    public static final double MIN_VALUE = -9999999999999.99D;

    private final static BigDecimal ONE_BIG = new BigDecimal(1.00D);
    private static final String UNIT = "万仟佰拾亿仟佰拾万仟佰拾元角分";
    private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";

    /**
     * 4舍5入double，2位小数
     */
    public static double roundDouble(double src) {
        return roundDouble(src, 2);
    }

    public static double roundDouble(double src, int scale) {
        if (scale < 0) scale = 2;
        BigDecimal src_b = new BigDecimal(src);
        BigDecimal src_v = src_b.divide(ONE_BIG, scale, BigDecimal.ROUND_HALF_UP);// 4舍5入
        return src_v.doubleValue();
    }

    /**
     * 比较两Double是否相等，将会吧他们专程BigDecimal进行比较；
     *
     * @param src double1
     * @param tag double2
     * @return src > tag =1, src < tag=0,否则反馈-1
     */
    public static int compare(double src, double tag) {
        BigDecimal src_b = new BigDecimal(src);
        BigDecimal src_v = src_b.divide(ONE_BIG, 2, BigDecimal.ROUND_HALF_UP);// 4舍5入

        BigDecimal tag_b = new BigDecimal(tag);
        BigDecimal tag_v = tag_b.divide(ONE_BIG, 2, BigDecimal.ROUND_HALF_UP);// 4舍5入

        return src_v.compareTo(tag_v);
    }

    /**
     * 自动过滤金额中的逗号转换为double,如果出错，则返回0
     *
     * @param s 源串，可能为带逗号的金额串；
     * @return double
     */
    public static Double toDouble(String s) {
        return todouble(s);
    }

    /**
     * 自动过滤金额中的逗号转换为double,如果出错，则返回0
     *
     * @param s 源串，可能为带逗号的金额串；
     * @return double
     */
    public static double todouble(String s) {
        try {
            return Double.parseDouble(s.replaceAll(",", ""));
        } catch (Exception e) {
            return 0.00;
        }
    }

    /**
     * 获取double,主要过滤d为null的情况；
     *
     * @param d Double对象；
     * @return double
     */
    public static double todouble(Double d) {
        if (d == null) return 0.0d;
        return d.doubleValue();
    }

    /**
     * 自动过滤金额中的逗号转换为float,如果出错，则返回0
     *
     * @param s 源串，可能为带逗号的金额串；
     * @return Float
     */
    public static Float toFloat(String s) {
        return tofloat(s);
    }

    /**
     * 自动过滤金额中的逗号转换为float,如果出错，则返回0
     *
     * @param s 源串，可能为带逗号的金额串；
     * @return Float
     */
    public static float tofloat(String s) {
        try {
            return Float.parseFloat(s.replaceAll(",", ""));
        } catch (Exception e) {
            return 0.0f;
        }
    }

    public static long tolong(String src, long defaultvalue) {
        try {
            return Long.parseLong(src);
        } catch (Exception e) {
            return defaultvalue;
        }
    }

    public static int toint(String src, int defaultvalue) {
        try {
            return Integer.parseInt(src);
        } catch (Exception e) {
            return defaultvalue;
        }
    }

    /**
     * 考虑使用中的精度，判断一个Value是否>0，实际是>0.00001
     *
     * @param value double类型
     * @return boolean
     */
    public static boolean isBigThanZero(double value) {
        return (value > 0.00001);
    }

    /**
     * 考虑使用中的精度，判断一个Value是否>0，实际是>0.00001
     *
     * @param value String类型
     * @return boolean
     */
    public static boolean isBigThanZero(String value) {
        return !UtilPub.isEmpty(value) && isBigThanZero(toDouble(value));
    }

    /**
     * 考虑使用中的精度，判断一个Value是否=0，实际是给出一个值范围。
     *
     * @param value double类型
     * @return boolean
     */
    public static boolean isEqualsZero(double value) {
        return (-0.00001 < value && value < 0.00001);
    }

    /**
     * 考虑使用中的精度，判断一个Value是否=0，实际是给出一个值范围。
     *
     * @param value String类型
     * @return boolean
     */
    public static boolean isEqualsZero(String value) {
        return UtilPub.isEmpty(value) || isEqualsZero(toDouble(value));
    }

    /**
     * 是否是负数
     *
     * @param db_val 要判断的double
     * @return 负数则返回true；
     */
    public static boolean isNegative(double db_val) {
        return (compare(db_val, 0.00D) == -1);
    }

    /**
     * 是否是正数
     *
     * @param db_val 要判断的double
     * @return 正数则返回true；
     */
    public static boolean isPlus(double db_val) {
        return (compare(db_val, 0.00D) == 1);
    }

    /**
     * 得到金额字符串，保持小数点2位
     *
     * @param db 将double转换为金额字符串；
     * @return 金额字符串#0.00；
     */
    public static String toStdNumberString(double db) {
        try {
            return stdNumberFormat.format(db);
        } catch (Exception e) {
            return "0.00";
        }
    }

    public static String toStdNumberStringEx(double db) {
        try {
            if (compare(db, -1d) == 0) return "-";
            return stdNumberFormat.format(db);
        } catch (Exception e) {
            return "0.00";
        }
    }

    /**
     * 将金额格式字符串，如23,333,093.01 去掉逗号
     *
     * @param s 金额串
     * @return String 去掉逗号后的串,如果amount为空,则返回0.00
     */
    public static String toStdNumberString(String s) {
        if (UtilPub.isEmpty(s))
            return "0.00";
        return stdNumberFormat.format(UtilMath.todouble(s));
    }

    /**
     * 将数据转换为两位小数的数字格式；
     *
     * @param d             数据
     * @param isZeroToEmpty 如果未0，是否返回“”；
     * @return 两位小数的字符串；
     */
    public static String toStdNumberString(double d, boolean isZeroToEmpty) {
        if (isEqualsZero(d)) {
            return isZeroToEmpty ? "": "0.00";
        }
        return stdNumberFormat.format(d);
    }

    public static String toStdNumberString(String s, boolean isZeroToEmpty) {
        return toStdNumberString(UtilMath.todouble(s), isZeroToEmpty);
    }

    public static String toStdNumberString(double d, int scale) {
        DecimalFormat dfn = null;
        if (scale == 1) dfn = df1Format;
        if (scale == 2) dfn = df2Format;
        else if (scale == 4) dfn = df4;
        else if (scale == 6) dfn = df6NumberF;
        else if (scale <= 0) dfn = dfLong;
        else {
            StringBuilder sb = new StringBuilder("###,###,###,###,##0.");
            for (int i = 0; i < scale; i++) sb.append("0");
            dfn = new DecimalFormat(sb.toString());
        }
        return dfn.format(d);
    }

    /**
     * 将数字乘100，保留小数点后两位, 然后后面添加%
     *
     * @param d                          值
     * @param isZeroToEmpty，如果值为0，是否返回空；
     * @return 字符串；
     */
    public static String toStdPercentNumberStr(double d, boolean isZeroToEmpty) {
        if (d > -0.00000000001 && d < 0.00000000001) {
            return isZeroToEmpty ? "": "0.00%";
        }
        return toStdNumberString(d * 100) + "%";
    }


    public static String toStdAmountString(double d) {
        return toStdAmountString(d, false);
    }

    /**
     * 将数据转换为两位小数的金额格式，带逗号；
     *
     * @param d             数据
     * @param isZeroToEmpty 如果未0，是否返回“”；
     * @return 金额格式的字符串；
     */
    public static String toStdAmountString(double d, boolean isZeroToEmpty) {
        if (isEqualsZero(d)) {
            return isZeroToEmpty ? "": "0.00";
        }
        return stdAmountFormat.format(d);
    }

    public static String toStdAmountString(String s) {
        return toStdAmountString(UtilMath.todouble(s), false);
    }

    public static String toStdAmountString(String s, boolean isZeroToEmpty) {
        return toStdAmountString(UtilMath.todouble(s), isZeroToEmpty);
    }


    /**
     * 将小写金额转换为人民币大写金额
     *
     * @param s 金额格式的串
     * @return String 转换结果
     */
    /*public static String toCapsAmountString(String s) {
        if (UtilPub.isEmpty(s)) return "";
        return toCapsAmountString(todouble(s));
    }*/

    /**
     * 将小写金额转换为人民币大写金额
     *
     * @param v double
     * @return String 转换结果
     */
    /*public static String toCapsAmountString(double v) {
        if (v < MIN_VALUE || v > MAX_VALUE) return "参数非法!";

        boolean negative = isNegative(v);

        if (negative) v = Math.abs(v);
        long l = Math.round(v * 100);
        if (l == 0) return "零元整";

        String strValue = String.valueOf(l);
        // i用来控制数
        int i = 0;
        // j用来控制单位
        int j = UNIT.length() - strValue.length();
        StringBuilder rs = new StringBuilder(32);
        boolean isZero = false;
        for (; i < strValue.length(); i++, j++) {
            char ch = strValue.charAt(i);
            if (ch == '0') {
                isZero = true;
                if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '万' || UNIT.charAt(j) == '元') {
                    rs.append(UNIT.charAt(j));
                    isZero = false;
                }
            } else {
                if (isZero) {
                    rs.append('零');
                    isZero = false;
                }
                rs.append(DIGIT.charAt(ch - '0')).append(UNIT.charAt(j));
            }
        }
        if (rs.charAt(rs.length() - 1) != '分')
            rs.append('整');

        i = rs.indexOf("亿万");
        if (i > 0) rs.delete(i + 1, i + 2);     // i+1 ->万

        if (negative)
            return rs.insert(0, '负').toString();
        else
            return rs.toString();
    }*/

    /**
     * 返回0 到 maxvalue的随机数
     *
     * @param maxvalue 随机数的最大值
     * @return int
     */
    public static int rnd(int maxvalue) {
        return (int) (Math.random() * (maxvalue + 1));
    }


    public static double chkDbNull(Double v) {
        return v == null ? 0: v;
    }

    public static double max(double d1, double d2) {
        return compare(d1, d2) < 0 ? d2 : d1;
    }

    public static double min(double d1, double d2) {
        return compare(d1, d2) < 0 ? d1 : d2;
    }

    /**
     * 计算公式 参数以Map方式传入
     * @param expr 表达式
     * @param mapVar 变量
     * @return 计算结果
     */
    public static Object calcExprMapObject(String expr, Map<String, Object> mapVar) {
        if (UtilPub.isEmpty(expr)) return "";
        JexlContext jc = new MapContext();
        for (String k: mapVar.keySet()) jc.set(k, mapVar.get(k));
        Expression e = new JexlEngine().createExpression(expr);
        return e.evaluate(jc);
    }

    /**
     * 计算公式，参数以数组方式传入，key、value交替
     * @param expr 表达式
     * @param vars 变量
     * @return
     */
    public static Object calcExprObjectEx(String expr, Object... vars) {
        if (UtilPub.isEmpty(expr)) return "";
        JexlContext jc = new MapContext();
        for (int i = 0, len = vars.length; i < len;) {
            jc.set((String)vars[i++], vars[i++]);
        }
        Expression e = new JexlEngine().createExpression(expr);
        return e.evaluate(jc);
    }

    public static double calcExprMapDouble(String expr, Map<String, Object> mapVar) {
        Object o = calcExprMapObject(expr, mapVar);
        if (o != null) return UtilPub.getDoubleIgnoreErr(o.toString());
        return 0.0;
    }

    public static double calcExprDoubleEx(String expr, Object... vars) {
        Object o = calcExprObjectEx(expr, vars);
        if (o != null) return UtilPub.getDoubleIgnoreErr(o.toString());
        return 0.0;
    }
}
