package com.interfaceTest.main;

import com.alibaba.fastjson.JSONObject;
import com.interfaceTest.Tools.DesUtils;
import com.interfaceTest.Tools.Tools;
import com.interfaceTest.Tools.UrlTools;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.HashMap;

public class LoginMain {
    public static DesUtils desUtilsIdevces = new DesUtils(Tools.getMD5(UrlTools.idevcesId));

    public static HashMap<String,Object> dataDevicesId= new HashMap<>();
    public static HashMap<String,Object> data1= new HashMap<>();
    public static DesUtils desUtilsToken;
    public static MainTest mainTest = new MainTest();
    public static HashMap<String,Object> dataToken = new HashMap<>();
    public static String token1 = "";
    public static String userCo = "";
    @BeforeClass
    public static  void mian() {

        data1.put("appVersion", desUtilsIdevces.ebotongEncrypto("2.8.1"));
        data1.put("device", desUtilsIdevces.ebotongEncrypto("小米"));
        data1.put("deviceId", UrlTools.idevcesId);
        data1.put("mobile", desUtilsIdevces.ebotongEncrypto("18310614641"));
        data1.put("loginPwd", desUtilsIdevces.ebotongEncrypto("123456a"));
        data1.put("osVersion", desUtilsIdevces.ebotongEncrypto("280"));
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(data1)
                .when().post(UrlTools.loginUrl);
        String response1 = response.getBody().asString();
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response1);
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");
        String MingWen = desUtilsIdevces.ebotongDecrypto(responseText);
        //打印明文返回值
//        System.out.println(MingWen);
        JSONObject obj2 = JSONObject.parseObject(MingWen);

        //获取item的JSONObject
        JSONObject obj3 = obj2.getJSONObject("item");
        String resultcode = obj3.getString("result");
        String ZheToken = obj3.getString("token");
        String ZheUserCode = obj3.getString("userCode");
       token1 = ZheToken;
       userCo = ZheUserCode;
        System.out.println("token是：" + ZheToken);
        System.out.println("userCode是：" + ZheUserCode);
        int rrr2 = Integer.parseInt(resultcode);
        //判断result返回值
        if (rrr2 == 1001) {
            //判断result返回值
            Assert.assertEquals("是否相等", "1001", resultcode);
        } else {
            //判断result返回值
            Assert.assertEquals("是否相等", "1001", resultcode);

            System.out.println("\n" + obj3.getString("resultInfo"));
        }
        //map对象里面添加必备的三个参数
        dataDevicesId.put("deviceId", UrlTools.idevcesId);
        dataDevicesId.put("device", desUtilsIdevces.ebotongEncrypto("小米"));
        dataDevicesId.put("appVersion", desUtilsIdevces.ebotongEncrypto("2.8.1"));
        dataDevicesId.put("osVersion", desUtilsIdevces.ebotongEncrypto("281"));

         desUtilsToken = new DesUtils(Tools.getMD5(token1));
        dataToken.put("token", token1);
        dataToken.put("userCode", desUtilsToken.ebotongEncrypto(userCo));
        dataToken.put("device", desUtilsToken.ebotongEncrypto("小米"));
        dataToken.put("appVersion", desUtilsToken.ebotongEncrypto("2.8.1"));
        dataToken.put("osVersion", desUtilsToken.ebotongEncrypto("281"));

        //新增核验人
        dataToken.put("verifyName", desUtilsToken.ebotongEncrypto("王乐诗"));
        dataToken.put("verifyMobile", desUtilsToken.ebotongEncrypto("18310614641"));
        dataToken.put("verifyIdCard", desUtilsToken.ebotongEncrypto("210181199502010641"));
        dataToken.put("verifyJob", desUtilsToken.ebotongEncrypto("总裁"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest2(token1,dataToken,UrlTools.zxzsaveverify,"1");

    }

}
