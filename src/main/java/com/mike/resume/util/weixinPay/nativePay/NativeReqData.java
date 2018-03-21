package com.mike.resume.util.weixinPay.nativePay;

import com.IT3acredit.GlobalEagle.util.weixin.Configure;
import com.IT3acredit.GlobalEagle.util.weixin.RandomStringGenerator;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gavin on 16-12-15.
 */
public class NativeReqData {

    private String appid = Configure.getAppid();//微信支付分配的公众账号ID（企业号corpid即为此appId）
    private String mch_id = Configure.getMchid();//商户号
    private String device_info = Configure.getDevice_info();//自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
    private String nonce_str = RandomStringGenerator.getRandomStringByLength(32);//随机字符串，长度要求在32位以内。推荐随机数生成算法
    private String sign;//通过签名算法计算得出的签名值，详见签名生成算法
    private String sign_type;//签名类型，默认为MD5，支持HMAC-SHA256和MD5。可为空
    private String body;//商品简单描述，该字段请按照规范传递，具体请见参数规定
    private String detail;//商品详细列表，使用Json格式，传输签名前请务必使用CDATA标签将JSON文本串保护起来。。可为空
//    goods_detail []：
//      └ goods_id String 必填 32 商品的编号
//      └ wxpay_goods_id String 可选 32 微信支付定义的统一商品编号
//      └ goods_name String 必填 256 商品名称
//      └ quantity Int 必填 商品数量
//      └ price Int 必填 商品单价，单位为分
//    注意：a、单品总金额应<=订单总金额total_fee，否则会导致下单失败。b、 单品单价，如果商户有优惠，需传输商户优惠后的单价
    private String attach;//附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。可为空
    private String out_trade_no;//商户系统内部订单号，要求32个字符内、且在同一个商户号下唯一。 详见商户订单号
    private String fee_type;//符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型。可为空
    private Integer total_fee;//订单总金额，单位为分，详见支付金额
    private String spbill_create_ip = Configure.getIP();//APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
    private String time_start;//订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则。可为空
    private String time_expire;//订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则。可为空
//    注意：最短失效时间间隔必须大于5分钟
    private String goods_tag;//商品标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠。可为空
    private String notify_url = Configure.getNotify_url();//异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
    private String trade_type = "NATIVE";//交易类型。取值如下：JSAPI，NATIVE，APP等，说明详见参数规定
    private String product_id;//trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
    private String limit_pay;//上传此参数no_credit--可限制用户不能使用信用卡支付。可为空
    private String openid;//trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换。可为空

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}