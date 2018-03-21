package com.mike.resume.web;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.mike.common.ResponseResult;
import com.mike.common.UtilGenerateID;
import com.mike.resume.entity.COrder;
import com.mike.resume.entity.WXPaymentPo;
import com.mike.resume.enums.EnumOrderStatus;
import com.mike.resume.service.impl.COrderServiceImpl;
import com.mike.resume.util.MessageUtil;
import com.mike.resume.util.PayUtil;
import com.mike.resume.util.weixinPay.Signature;
import com.mike.resume.util.weixinPay.Util;
import com.mike.resume.util.weixinPay.nativePay.NativeBackData;
import com.mike.resume.util.weixinPay.nativePay.NativeBackReqData;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Mike
 * @date 2018/3/12
 */
@RestController
public class PayAction {

    @Autowired
    private COrderServiceImpl cOrderService;

//    private String total_fee;//总金额
//    private String body;//商品描述
//    private String detail;//商品详情
//    private String attach;//附加数据
//    private String time_start;//交易起始时间
//    private String time_expire;//交易结束时间
//    private String openid;//用户标识
//    private JSONArray jsonArray=new JSONArray();

    @RequestMapping(value = "/pay", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String pay(HttpServletRequest request, @RequestBody String json) throws UnsupportedEncodingException, DocumentException{
//        body = new String(body.getBytes("UTF-8"),"ISO-8859-1");
        String appid = "替换为自己的小程序ID";//小程序ID
        String mch_id = "替换为自己的商户号";//商户号
        String nonce_str = UtilGenerateID.generateID("");//随机字符串
        String today = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String code = PayUtil.createCode(8);
        String out_trade_no = mch_id+today+code;//商户订单号
        String spbill_create_ip = "替换为自己的终端IP";//终端IP
        String notify_url = "http://www.weixin.qq.com/wxpay/pay.php";//通知地址
        String trade_type = "JSAPI";//交易类型
        String openid="替换为用户的openid";//用户标识
        /**/
        WXPaymentPo paymentPo = new WXPaymentPo();
        paymentPo.setAppid(appid);
        paymentPo.setMch_id(mch_id);
        paymentPo.setNonce_str(nonce_str);
//        String newbody=new String(body.getBytes("ISO-8859-1"),"UTF-8");//以utf-8编码放入paymentPo，微信支付要求字符编码统一采用UTF-8字符编码
//        paymentPo.setBody(newbody);
        paymentPo.setOut_trade_no(out_trade_no);
//        paymentPo.setTotal_fee(total_fee);
        paymentPo.setSpbill_create_ip(spbill_create_ip);
        paymentPo.setNotify_url(notify_url);
        paymentPo.setTrade_type(trade_type);
        paymentPo.setOpenid(openid);
        // 把请求参数打包成数组
        Map sParaTemp = new HashMap();
        sParaTemp.put("appid", paymentPo.getAppid());
        sParaTemp.put("mch_id", paymentPo.getMch_id());
        sParaTemp.put("nonce_str", paymentPo.getNonce_str());
        sParaTemp.put("body",  paymentPo.getBody());
        sParaTemp.put("out_trade_no", paymentPo.getOut_trade_no());
        sParaTemp.put("total_fee",paymentPo.getTotal_fee());
        sParaTemp.put("spbill_create_ip", paymentPo.getSpbill_create_ip());
        sParaTemp.put("notify_url",paymentPo.getNotify_url());
        sParaTemp.put("trade_type", paymentPo.getTrade_type());
        sParaTemp.put("openid", paymentPo.getOpenid());
        // 除去数组中的空值和签名参数
        Map sPara = PayUtil.paraFilter(sParaTemp);
        String prestr = PayUtil.createLinkString(sPara); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        String key = "&key=替换为商户支付密钥"; // 商户支付密钥
        //MD5运算生成签名
        String mysign = PayUtil.sign(prestr, key, "utf-8").toUpperCase();
        paymentPo.setSign(mysign);
        //打包要发送的xml
        String respXml = MessageUtil.messageToXML(paymentPo);
        // 打印respXml发现，得到的xml中有“__”不对，应该替换成“_”
        respXml = respXml.replace("__", "_");
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";//统一下单API接口链接
        String param = respXml;
        //String result = SendRequestForUrl.sendRequest(url, param);//发起请求
        String result =PayUtil.httpRequest(url, "POST", param);
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap();
        InputStream in=new ByteArrayInputStream(result.getBytes());
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(in);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();
        for (Element element : elementList) {
            map.put(element.getName(), element.getText());
        }
        // 返回信息
        String return_code = map.get("return_code");//返回状态码
        String return_msg = map.get("return_msg");//返回信息
        System.out.println("return_msg"+return_msg);
        JSONObject JsonObject=new JSONObject() ;
        if(return_code=="SUCCESS"||return_code.equals(return_code)){
            // 业务结果
            String prepay_id = map.get("prepay_id");//返回的预付单信息
            String nonceStr=UtilGenerateID.generateID("");
            JsonObject.put("nonceStr", nonceStr);
            JsonObject.put("package", "prepay_id="+prepay_id);
            Long timeStamp= System.currentTimeMillis()/1000;
            JsonObject.put("timeStamp", timeStamp+"");
            String stringSignTemp = "appId="+appid+"&nonceStr=" + nonceStr + "&package=prepay_id=" + prepay_id+ "&signType=MD5&timeStamp=" + timeStamp;
            //再次签名
            String paySign=PayUtil.sign(stringSignTemp, "&key=替换为自己的密钥", "utf-8").toUpperCase();
            JsonObject.put("paySign", paySign);
//            jsonArray.add(JsonObject);
        }
        return "pay";
    }


    /**
     * 微信支付回调方法
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/wxPay/fromWeixin")
    public void fromWeixin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收微信回调
        String notityXml = "", inputLine;
        try {
            while ((inputLine = request.getReader().readLine()) != null) {
                notityXml += inputLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                request.getReader().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("接收到的报文：" + notityXml);
        //转换为对象
        NativeBackData nativeBackData = (NativeBackData) Util.getObjectFromXML(notityXml, NativeBackData.class);
        //检查签名
        String sign = nativeBackData.getSign();
        String calSign = Signature.getSign(nativeBackData.toMap());
        nativeBackData.setSign(null);
        String calSign2 = Signature.getSign(nativeBackData.toMap());
        Util.log("返回的签名：" + sign);
        Util.log("计算的签名：" + calSign);
        Util.log("计算的签名2：" + calSign2);
        //判断是否成功
        NativeBackReqData nativeBackReqData = new NativeBackReqData();
        if (nativeBackData.getReturn_code().equals("SUCCESS")) {
            COrder cOrder = new COrder();
            cOrder.setOrderNo(nativeBackData.getOut_trade_no());
            cOrder.setStatus(EnumOrderStatus.ToSend.getStatusCode());
            cOrderService.updateCOrder(cOrder);
//                SimpleResult<Order> result = orderService.payment(nativeBackData.getOut_trade_no());
//                try {
                    //支付成功后 发送email
//                    reportService.sendOrderConfirmEmail(result.getResultcontent().getSendEmail(), null, result.getResultcontent());
                    //// TODO: 2016/11/28 游客模式下订单马上发送报告
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }

                nativeBackReqData.setReturn_code("SUCCESS");

        }else {
            nativeBackReqData.setReturn_code("FAIL");
            nativeBackReqData.setReturn_msg("支付失败");
        }
        //回复微信处理情况
        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(Util.getXMLStringFromObject(nativeBackReqData).getBytes());
        out.flush();
        out.close();
    }
}
