package com.interfaceTest.demo;

import com.alibaba.fastjson.JSONObject;
import com.interfaceTest.Tools.DesUtils;
import com.interfaceTest.Tools.Tools;
import com.interfaceTest.Tools.UrlTools;
import com.interfaceTest.main.MainTest;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



import java.io.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class jiekouTest1 {
    private UrlTools urlTools;

    @BeforeClass
    public void before(){
         urlTools = new UrlTools();

    }

    @Test
    public void testSearch(){
        //信任https的任何证书
        RestAssured.useRelaxedHTTPSValidation();

        //given开头表示输入数据
        RestAssured.given().log().all()
                //query请求
                .queryParam("code", "sogo")
                //头信息
                .header("Cookie", "device_id=864d4cb52ace61737d69da102e7e996d; __utmz=1.1516097049.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); s=fv11u1xhjc; xq_a_token=229a3a53d49b5d0078125899e528279b0e54b5fe; xq_a_token.sig=oI-FfEMvVYbAuj7Ho7Z9mPjGjjI; xq_r_token=8a43eb9046efe1c0a8437476082dc9aac6db2626; xq_r_token.sig=Efl_JMfn071_BmxcpNvmjMmUP40; Hm_lvt_1db88642e346389874251b5a1eded6e3=1523358353; u=851523358353984; __utmc=1; __utma=1.1295158553.1516097049.1523673254.1523696123.10; __utmt=1; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1523696133; __utmb=1.3.10.1523696123")
                //表示触发条件
                .when()
                .get("https://xueqiu.com/stock/search.json")
                //对结果断言
                .then()
                .log().all()
                //状态码断言
                .statusCode(200)
                //字段断言
                .body("stocks.name", Matchers.hasItems("搜狗"))
                .body("stocks.code", Matchers.hasItems("sogo"));
    }
    @Test
    public  void  testLogin(){
        RestAssured.given().log().all()
                .header("Cookie", "aliyungf_tc=AQAAAHM28zf+2w4AwLfEc+OHoi32QnzV; xq_a_token=229a3a53d49b5d0078125899e528279b0e54b5fe; xq_a_token.sig=oI-FfEMvVYbAuj7Ho7Z9mPjGjjI; xq_r_token=8a43eb9046efe1c0a8437476082dc9aac6db2626; xq_r_token.sig=Efl_JMfn071_BmxcpNvmjMmUP40; u=931523700233834; __utma=1.78034356.1523700234.1523700234.1523700234.1; __utmc=1; __utmz=1.1523700234.1.1.utmcsr=cn.bing.com|utmccn=(referral)|utmcmd=referral|utmcct=/; __utmt=1; device_id=c158b90e6b9a5a0fa1689c297c2a0e53; __utmb=1.2.10.1523700234; Hm_lvt_1db88642e346389874251b5a1eded6e3=1523700234,1523700251; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1523700251")
                .queryParam("symbol", "SH000001")
                .queryParam("period","1d")
                .when().get("https://xueqiu.com/stock/forchart/stocklist.json")
                .then().log().all()
                .statusCode(200)
                .assertThat().body("success", Matchers.equalTo("true"))
                .assertThat().body("stock.symbol",  Matchers.equalTo("SH000001"));
    }
    @Test()
    public void getHttpTest1() {
        Response response = RestAssured.given()
                .get("https://api.douban.com/v2/book/search");
        // 打印出 response 的body

        response.print();
    }
    @Test()
    public void getHttpsTest() {
        Response response = RestAssured.given()
                // 配置SSL 让所有请求支持所有的主机名
                .config((RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())))
                .params("q", "自动化测试", "start", 0, "count", 2)
                .get("https://api.douban.com/v2/book/search");

        // 打印出 response 的body
        response.print();
    }
    @Test
    public void postTest2() {

        Response response = RestAssured.given()
                // 设置request Content-Type
                .contentType("application/x-www-form-urlencoded")
                // 请求参数 放body
                .body("UserName=XXXX&Password=XXXXXX&CheckCode=&Remember=false&LoginCheckCode=7505")
                // POST 请求
                .post("http://XXXX.XXXX.com/Home/Login");

        response.print();
    }


     //登录
     @Test
     public void testApplicationJson() throws IOException {
         String bodyString = MainTest.json2String("/Users/haal/文档/1.json").toString();
        //body请求参数
//        final String bodyString = "{\"appVersion\": \"0r\\/ynPFJiQ8=\",\"device\": \"e5cYG7U7ODs=\",\"deviceId\": \"ffffffff-b4e1-611a-0000-00002d1eabc3\",\"loginPwd\": \"B+YEUEW77p8=\",\"mobile\": \"Zs3SAgmWuh0DH+SpZcKZzQ==\",\"osVersion\": \"E2od\\/zNQCU8=\",\"phoneModel\": \"TyacmvBnzGc=\"}";
        //发送请求，设置请求方式
        Response response =  RestAssured.given().
                contentType("application/json").
                request().body(bodyString).
                expect().
                statusCode(200).
           //  发送请求
                when().
                post("https://apix.funinhr.com/api/enterprise/login");
          //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response.print());
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");
        //DES解密（通过设备id）
        DesUtils desUtils =new DesUtils(Tools.getMD5(UrlTools.idevcesId));
       //获取明文返回值并解密，转为String类型
        String MingWen = desUtils.ebotongDecrypto(responseText);
        //转化为JSONObject对象（全）
        JSONObject obj2 = JSONObject.parseObject(MingWen);
        //获取item的JSONObject
        JSONObject obj3 = obj2.getJSONObject("item");
        //判断result返回值
        Assert.assertEquals(obj3.getString("result"),"1002","返回码是否是1001");

         System.out.print(MainTest.json2String("/Users/haal/文档/1.json").toString());
    }

}