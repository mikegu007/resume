package com.mike.resume.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUtil {
	

	/**
     *  GET
	 * @return
     */
    public static String httpURLConectionGET(String Stringurl) {
        try {
            URL url = new URL(Stringurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            connection.disconnect();
            System.out.println(sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("???!");
        }
       return null;
    }

    /**
     *   POST
     */
    public static String httpURLConnectionPOST (String Stringurl) {
        try {
            URL url = new URL(Stringurl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);

            connection.setDoInput(true);

            connection.setRequestMethod("POST");

            connection.setUseCaches(false);

            connection.setInstanceFollowRedirects(true);

            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.connect();

            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
            String parm = "storeId=" + URLEncoder.encode("32", "utf-8");

            dataout.writeBytes(parm);

            dataout.flush();
            dataout.close();
            System.out.println(connection.getResponseCode());

            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = bf.readLine()) != null) {
                sb.append(bf.readLine());
            }
            bf.close();
            connection.disconnect();
            System.out.println(sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String syncData(String Stringurl ) {
    	String strReturn = "";
    	String strContent = "";
    	String strHttpUrl =   Stringurl 		;
    	try {
    	URL url = new URL(strHttpUrl);
    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	conn.setRequestMethod("POST");
    	conn.setDoOutput(true);
    	OutputStream out = conn.getOutputStream();
    	out.write(strContent.getBytes("UTF-8"));
    	out.flush();
    	out.close();
    	InputStream ins2 = conn.getInputStream();
    	strReturn = convertStreamToString(ins2);
    	ins2.close();
    	} catch (Exception e) {
    	System.out.println("URL" + strHttpUrl + "!");
    	e.printStackTrace();
    	}
        System.out.println("URL==" + strHttpUrl + "");
    	System.out.println("data=="+strReturn);
    	return strReturn;
    	}
	    private static String convertStreamToString(InputStream ins) {
	    String strRet = "";
	    try {
	    StringBuffer sbuf = new StringBuffer();
	    InputStreamReader reader = new InputStreamReader(ins, "UTF-8");
	    Reader buf = new BufferedReader(reader);
	    int ch;
	    int iCharNum = 0;
	    while ((ch = buf.read()) > -1) {
	    iCharNum += 1;
	    sbuf.append((char) ch);
	    } buf.close();
	    strRet = sbuf.toString();
	    sbuf.delete(0, sbuf.length());
	    } catch (Exception e) {
	    e.printStackTrace();
	    return "";
	    } return strRet;
	    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String url = "http://192.168.1.240:5566/CPM/service/getIndexBySearchCompanyNameCN.do?param=…Ã∞≤–≈";
		System.out.println(syncData(url));
	}

}
