package com.mike.resume.service.impl;




import com.mike.resume.util.weixinPay.Configure;
import com.mike.resume.util.weixinPay.HttpsRequest;
import com.mike.resume.util.weixinPay.Signature;
import com.mike.resume.util.weixinPay.Util;
import com.mike.resume.util.weixinPay.nativePay.NativeReqData;
import com.mike.resume.util.weixinPay.nativePay.NativeResData;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;


/**
 * Created by gavin on 16-12-15.
 */
public class WeixinTest {
    public static void main(String[] args) throws UnrecoverableKeyException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        NativeReqData reqData = new NativeReqData();
        reqData.setBody("weixinzhifutest");
        reqData.setOut_trade_no("test1111");
        reqData.setTotal_fee(100);
        reqData.setNotify_url("1111");
        reqData.setSign(Signature.getSign(reqData.toMap()));
//
//        XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
//        String postDataXML = xStreamForRequestPostData.toXML(reqData);
//
//        Util.log("API，POST过去的数据是：");
//        Util.log(postDataXML);

        HttpsRequest httpsRequest = new HttpsRequest();
        String resString = httpsRequest.sendPost(Configure.UNIFIED_API,reqData);

        Util.log("API，返回的数据是：");
        Util.log(resString);

        NativeResData resData = (NativeResData) Util.getObjectFromXML(resString, NativeResData.class);
        Util.log(resData.getSign());
        resData.setSign(null);
        Util.log(Signature.getSign(resData.toMap()));


    }


}
