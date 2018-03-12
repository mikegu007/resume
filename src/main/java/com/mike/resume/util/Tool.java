package com.mike.resume.util;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Tool {
	
	public static String httpUrl;


	public static  String loadCommonUrl(String urlName){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("url.properties");
			p.load(in);
			in.close();
			httpUrl = p.getProperty(urlName);
			System.out.println("Url==="+httpUrl);
			return httpUrl;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}



	//获得客户端真实IP地址的方法二：
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	// 完整的判断中文汉字和符号
	public static boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	// 根据Unicode编码完美的判断中文汉字和符号
	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	public static Boolean matchNumber(String str){
		boolean result=str.matches("[0-9]+");
		return result;
	}

	public static Double compareValueRate(BigDecimal value1, BigDecimal value2){
		DecimalFormat df = new DecimalFormat("#.00");
		Double increase = null;
		Double d1;
		Double d2;
		if(value1==null || "".equals(value1)){
			return null;
		}else if(value2 == null || "".equals(value2)){
			return null;
		}else {
			d1 = Double.parseDouble(String.valueOf(value1));
			d2 = Double.parseDouble(String.valueOf(value2));
			if(0 != d1 && 0 != d2){
				Double rateValue = (d1-d2)/d2*100;
				increase = Double.valueOf(df.format(rateValue));
				return minusConverNumber(increase);

			}
		}
		return increase;
	}

	public static Double minusConverNumber(Double val){
		BigDecimal decimal = new BigDecimal(val);
		return Double.valueOf(decimal.toString().replace("-",""));
	}

	/**
	 * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
	 * 此方法中前三位格式有：
	 * 13+任意数
	 * 15+除4的任意数
	 * 18+除1和4的任意数
	 * 17+除9的任意数
	 * 147
	 */
	public static boolean isChinaPhoneLegal( String str ) throws PatternSyntaxException {
		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}
	/**
	 * 正则表达式校验邮箱
	 * @param emaile 待匹配的邮箱
	 * @return 匹配成功返回true 否则返回false;
	 */
	public static boolean checkEmaile(String emaile){
		boolean result = false;
		if (StringUtil.isNotNull(emaile)){
			String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
			//正则表达式的模式
			Pattern p = Pattern.compile(RULE_EMAIL);
			//正则表达式的匹配器
			Matcher m = p.matcher(emaile);
			//进行正则匹配
			result = m.matches();
		}

		return result;
	}
}
