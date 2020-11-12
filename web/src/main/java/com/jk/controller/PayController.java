package com.jk.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class PayController {

    private final String APP_ID = "2016110100783292";
    private final String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCRldsLaKEzghBPmUGjFEwmtY6A1bhE7qZ1bArKWMgx6+xnssDD/60TPsnpm9otCWZManxxc77WDDLK0wChUydy7pOUnXp2gZ7gj2GmvNH6pE0mB/CTvuQubQjPiGOcyvLlYmEVOFkHw1YecYyQ+S9jgRtpsvJvKh5kGu+3rdmYNUaJQ5hilzESWIFxlNxvUYyhUoIUKpXjJP+1p8h3+IYRUk3rYgsXPqX4sg/Xd8lC0x4JGpyKLqG2ce+9p+NFFv1rIp8HjwbM1Vhvq4B2/ndFkHp1hEiqQx6BrPzs/hm5Hf2irxowSI5Cn45M7uk8R0mbvEy0XfNtXE4FxRlErQV1AgMBAAECggEAHpLM7GltqQaAbGbv7NJ/Z4WrRo0bZIaFuJUW8wWQDUPRYrmcV8ziyO7fskqDl/+oVxXpyl2XTxZCuGt1b2uqFi3aGlSz+h0gg2I5DK4MnslQVlNGh5CIFOPa/NJUsQHB3sA5SR6LO+Eevcf00CE0fX4IhrsIxKWguj8Z5oYA80CxqtsC1YOI1b6LB9bDp9/8iT6ZEhFtMKNUqGo73WDiadr/GTKF/skMnjEhJhd6arrWLMWeamFrTu7aMNgDS//VsUF0JUop7cs6abFSkali5a5o/xmDj9KtAw/Xhq3Vju7Quv9uuUaNZOkX2XN4vbl+9URBH3FVg4H83LOBBbfCxQKBgQDzS3Cmip0wFT4uPXJyEXRptWeezIyDSVP+GvnT+dcsxagRPX3/fqOh1ZXHhTlsEolhHvmE0LCp1fZEIhL7zlk+2zhaw85TVQQy4ar28nr0E+fITWEPr/idsOH6tkDn1I/3CGW2N0NlOz+qDceWW6CsaQh6QOlpdsxxv3LgUEnYvwKBgQCZMCiWbjmvkZWYaMvp3KIu+G7osuC7fjjZD0Uir2hs8VBz619wJSteLZsdFuCgS7NamV6LqX+l6oZAdJKKDSlpDbVNpOXcaKLPC3fRZAAuj1zxErgD2R8qt+O3yHySbyjTgqRtUM9RU+Nrve3mbrL9RkjvkQpPzVCq1xBv89VaywKBgQC9MAKvXsaQp1Qs/NdL4ErYEJo9H+58AL9xr2Rp87PhOupQTbL2xHFV3RKVjgFzCo8NmNqK7wURbDIOFTkR2goIGMwfuHdu0YNsVZNuaGw39GqelZ1OZ5Y6eVuga6zZGa/BdyQwp5Se2Y3OHN0BDMtKhnpzJprayeh841TfHU/vXQKBgQCUeJ+uBVE1wBXMrS2OEYDDo5fjQ5QbROAWSP2J+5ZrmIuQfn12tR/OXMdtL0IxOo2v7tw64uJMTf0mtZVd5hnPrzCc+4ip0mSR5ZyQvqqKdfrv0GO3nxXdEnPMKa3LQ5+/OGzjYqI9QeA3CdNtNreWUSvZvarP48AehOlyiFKudwKBgQC5prOWDr0tHYu8cTDI0j/71RcAxbz/DydhSDlTCbb1chkRASO2tJuSdh3W5dvi0+lfKF0KizxenXvSBLjEpNberpzEecIZ690b9LUjePsSbyveEyeLRV7YN2EMU5+6/MomYvtSIkywFSFAf2Oh28OzfFNsrZfompY6J74HtC6U5A==";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn7qsCr35VXm5vsg4YSwofXRFdqaC8Q7Fh8xu7okPfbIR5bZ1KAddhpCUPk3bVGXtARr31KcbF0S6TLrivaxq0EssxGn0vlqBFghr2Yphn6xr9vn70y+2Z0rPD4nclCWWf/xlW2W4M6GKwRVhjxw6buNQDp1OnQqp7pbECkzyjWDUsnItPvSNDF7Gx8Lluh1ePATGafuMO6AA6/A8uA2FAlJOGzZ74VFVayLOu+b5FU2Mfp3kWtPKJQetnnsjUCD7Y7PKKzlvskZQimvrCjour9tAFgHh9ns+ny1p7yYxkkzLbeKrzFOfLHhdsrFfSpp42qd4x9fuVvxmTD0zp8jhywIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://127.0.0.1:8080/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://127.0.0.1:8080/returnUrl";
    @RequestMapping("alipay")
    public void alipay(HttpServletResponse httpResponse,String name,Integer money) throws IOException {

        Random r=new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =Integer.toString(money);
        //订单名称，必填
        String subject =name;
        //商品描述，可空
        String body = null;
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping(value = "returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);


            //支付成功，修复支付状态
//            payService.updateById(Integer.valueOf(out_trade_no));
            return "index";//跳转付款成功页面
        }else{
            return null;//跳转付款失败页面
        }

    }
}

