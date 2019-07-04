package com.zhenxin.utils;


import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.json.JSONException;
import org.springframework.stereotype.Component;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.Random;
@Component
public  class  MassageUtils{
    private   static   Integer sdkappid=1400226758;
    private  static   String  appKey="a320953e4b4d77cfb4c6f19b6729d716";
    private  static   Integer templateId=366324;
    private  static   String  smsSign="味美记餐厅";
    public static String   sendMessage(String phone) {
        String random ="";
        try {
            for (int i = 0; i <=5 ; i++) {
                random+= new Random().nextInt(10);
            }
            String[] params = {random,"30"};
            SmsSingleSender ssender = new SmsSingleSender(sdkappid , appKey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phone,
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        } catch (com.github.qcloudsms.httpclient.HTTPException e) {
            e.printStackTrace();
        }
        return random;
    }
}
