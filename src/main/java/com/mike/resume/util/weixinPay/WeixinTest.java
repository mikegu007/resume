package com.mike.resume.util.weixinPay;

import com.IT3acredit.GlobalEagle.util.weixin.nativePay.NativeReqData;
import com.IT3acredit.GlobalEagle.util.weixin.nativePay.NativeResData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.HashMap;
import java.util.Map;

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
