package com.interfaceTest.demo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.interfaceTest.Data.DataClass;
import com.interfaceTest.Data.Tokenzhi;
import com.interfaceTest.Tools.DesUtils;
import com.interfaceTest.Tools.Tools;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
@RunWith(Parameterized.class)
public class restAssuredDemo {

    private DesUtils desUtilsDevices;

    @BeforeClass
    public void setUp() throws Exception {

        //定义所有请求使用ssl配置
        RestAssured.useRelaxedHTTPSValidation();
        //设置请求参数进行url code编码/设置请求、超时时间
        RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().
                defaultCharsetForContentType("utf-8","application/x-www-form-urlencoded")).
                httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout",2000).
                        setParam("http.socket.timeout",2000));
    }

    @Test
    public void getTest1(){
        Tokenzhi tokenzhi =  new Tokenzhi();
        tokenzhi.getToken11();


        System.out.println(tokenzhi.getToken11());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("limit",2);
        map.put("offset", 0);
        map.put("type", "last_actived");
       Response response = given().params(map).post("https://testerhome.com/api/v3/topics.json");
        int statusCode = response.getStatusCode();



    }
    @Test
    public void getTest2(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("limit",2);
        map.put("offset", 0);
        map.put("type", "last_actived");
        Response response = given().params(map).post("https://testerhome.com/api/v3/topics.json");
        int statusCode = response.getStatusCode();


    }
    //filter实现对返回值的判断
    @Test
    public void testLoginCase(){

        desUtilsDevices = new DesUtils(Tools.getMD5("ffffffff-b4e1-611a-0000-00002d1eabc3"));
        DataClass dataClass = new DataClass();
        Map<String, Object> data=new HashMap<>();
        data.put("appVersion", desUtilsDevices.ebotongEncrypto("2.8.1"));
        data.put("device", "e5cYG7U7ODs=");
        data.put("deviceId", "ffffffff-b4e1-611a-0000-00002d1eabc3");

        data.put("mobile","91hXGPFTC9V1iShjWWW2rA==");
        data.put("loginPwd", "B+YEUEW77p8=");
        data.put("osVersion", "E2od\\/zNQCU8=");
        data.put("phoneModel", "TyacmvBnzGc=");
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(data)
                .when().post("https://apix.funinhr.com/api/enterprise/login");
        String response1 =  response.getBody().print();
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response1);
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");
        System.out.print(responseText);

        String MingWen =  desUtilsDevices.ebotongDecrypto(responseText);
        JSONObject obj2 = JSONObject.parseObject(MingWen);

        //获取item的JSONObject
        JSONObject obj3 = obj2.getJSONObject("item");

        //判断result返回值
        Assert.assertEquals(obj3.getString("result"),"1001","返回码是否是1001");
    }
    @Test
    public void Testfilter(){
        given()
                .auth().basic("hogwarts", "123456")
                .log().all()
                .filter( (req, res, ctx)->{
                    Response responseOri=ctx.next(req, res);
                    ResponseBuilder responseBuilder=new ResponseBuilder().clone(responseOri);
                    responseBuilder.setBody(
                            Base64.getDecoder().decode(
                                    responseOri.getBody().asString().trim().replace("\n", "")));
                    responseBuilder.setContentType(ContentType.JSON);
                    return responseBuilder.build();

                })
                .when().get("http://shell.testing-studio.com:9002/sec.json")
                .then().log().all()
                .statusCode(200).body("topics.id[0]", equalTo(15150));
    }
}
