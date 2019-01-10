package com.interfaceTest.TestFangfa;

import com.alibaba.fastjson.JSONObject;
import com.interfaceTest.Tools.DesUtils;
import com.interfaceTest.Tools.Tools;
import com.interfaceTest.Tools.UrlTools;
import com.interfaceTest.main.MainTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class qingqiu {
    private DesUtils desUtils;
    @Test
    public void  ceshi(){
        desUtils = new DesUtils(Tools.getMD5(UrlTools.idevcesId));
        Map<String, Object> data=new HashMap<>();

        data.put("deviceId", UrlTools.idevcesId);
        data.put("mobile", desUtils.ebotongEncrypto("18310614641"));
        data.put("device",desUtils.ebotongEncrypto("小米"));
        data.put("appVersion", desUtils.ebotongEncrypto("2.8.1"));
        data.put("osVersion", desUtils.ebotongEncrypto("281"));
        data.put("loginPwd", desUtils.ebotongEncrypto("123456a"));

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(data)
                .when().post("https://api.funinhr.com/api/enterprise/login");
        String response1 =  response.getBody().asString();
        System.out.println(response1);
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response1);
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");
        String MingWen =  desUtils.ebotongDecrypto(responseText);
        System.out.println(MingWen);
        System.out.println(MingWen);

    }


}
