package com.interfaceTest.main;

import com.alibaba.fastjson.JSONObject;
import com.interfaceTest.Tools.DesUtils;
import com.interfaceTest.Tools.Tools;
import com.interfaceTest.Tools.UrlTools;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class MainTest {

    private DesUtils desUtils;
    private JSONObject jsonQuan;
    private JSONObject jsonItem;
    private String resultcode;
    private String resultinfo = "";


    //json文件转化为String类型
    public static String json2String(String path) throws IOException {
        StringBuilder result = new StringBuilder();
        InputStream in = new FileInputStream(path);
        //读取文件上的数据。
        // 将字节流向字符流的转换。
        InputStreamReader isr = new InputStreamReader(in, "UTF-8");//读取
        //创建字符流缓冲区
        BufferedReader bufr = new BufferedReader(isr);//缓冲

        String line = null;
        while ((line = bufr.readLine()) != null) {
            result.append(System.lineSeparator() + line);
        }
        isr.close();
        return result.toString();
    }
    @Test
    public String DemoTest(String jsonUrl ,String requestUrl, String requesType,String itemType) throws IOException {
        //获取json文件
//        String bodyString = json2String(jsonUrl).toString();

        //发送请求，设置请求方式
        Response response =  RestAssured.given().
                contentType("application/json").
                request().body(jsonUrl).
                expect().
                statusCode(200).
                //  发送请求
                        when().
                        post(requestUrl);
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response.asString());
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");
        //DES解密（通过设备id）
        DesUtils desUtils =new DesUtils(Tools.getMD5(requesType));
        //获取明文返回值并解密，转为String类型
        String MingWen = desUtils.ebotongDecrypto(responseText);
        System.out.println(MingWen);
        //转化为JSONObject对象（全）
        JSONObject obj2 = JSONObject.parseObject(MingWen);

        //获取item的JSONObject
        JSONObject obj3 = obj2.getJSONObject("item");

        //判断result返回值
//        Assert.assertEquals(obj3.getString(itemType),requestCode,"返回码是否是1001");
        System.out.println("DemoTest方法里面的返回值是"+obj3.getString(itemType));
        return obj3.getString(itemType);

    }

    @Test
    public void DemoTestType2(String jsonUrl ,String requestUrl, String requesType,String itemType,String requestCode) throws IOException {
        //获取json文件
        String bodyString = json2String(jsonUrl).toString();
        //发送请求，设置请求方式
        Response response =  RestAssured.given().
                contentType("application/json").
                request().body(bodyString).
                expect().
                statusCode(200).
                //  发送请求
                        when().
                        post(requestUrl);
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response.asString());
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");
        //DES解密（通过设备id）
        DesUtils desUtils =new DesUtils(Tools.getMD5(requesType));
        //获取明文返回值并解密，转为String类型
        String MingWen = desUtils.ebotongDecrypto(responseText);

        //转化为JSONObject对象（全）
        JSONObject obj2 = JSONObject.parseObject(MingWen);


        //判断result返回值
        Assert.assertEquals(obj2.getString(itemType),requestCode,"返回码是否是1001");

    }
    //调用主的接口方法
   @Test
   public void InterTest(String desToken, Map<String, Object> Mapdata, String PostUrl, String ResponType, String ReCode){
        //加解密方法
       desUtils = new DesUtils(Tools.getMD5(desToken));
       //判断token是否为空
       String ifToken = desToken;
       if(ifToken==null){
           throw new RuntimeException("token错误");
       }else{

       }
       //发送post请求
       Response response = RestAssured.given()
               .contentType("application/json")
               .body(Mapdata)
               .when().post(PostUrl);
       //获得body信息
       String response1 =  response.getBody().asString();
       if(response1==null){
           throw new RuntimeException("发送请求不正确");
       }else{

       }
       //获得JSONObject对象（密文）并打印
       JSONObject obj = JSONObject.parseObject(response1);
       //获取返回值ciphertext字段内容（密文）
       String responseText = obj.getString("ciphertext");
       String MingWen =  desUtils.ebotongDecrypto(responseText);
       System.out.println("明文返回串："+MingWen);
       if (ResponType.equals("1")){
           //把String转为json对象
           jsonQuan = JSONObject.parseObject(MingWen);
           //得到item的json对象
           jsonItem = jsonQuan.getJSONObject("item");
           //得到reslut返回值
            resultcode =  jsonItem.getString("result");
           //得到错误信息的返回值
           resultinfo =  jsonItem.getString("resultInfo");

           //判断result返回值
           if(resultcode .equals(ReCode)== true){
               //判断result返回值
               Assert.assertEquals("返回码是否是相等",ReCode,resultcode);
               System.out.println("用例通过");
           } else {
               //判断result返回值
               Assert.assertEquals("返回码是否是相等-->"+resultinfo,ReCode,resultcode);

           }
       }else {
             jsonQuan = JSONObject.parseObject(MingWen);
             resultcode =  jsonQuan.getString("result");
             //得到错误信息的返回值
             resultinfo =  jsonQuan.getString("resultInfo");
               //判断result返回值
               if(resultcode .equals(ReCode)== true){
                   //判断result返回值
                   Assert.assertEquals("返回码是否是相等", ReCode,resultcode);
                   System.out.println("用例通过");
               } else {
                   //判断result返回值
                   Assert.assertEquals("返回码是否是相等-->"+resultinfo,ReCode,resultcode);
               }
       }
   }
    //调用主的接口方法（无返回参数）
    @Test
    public void InterTest2(String desToken, Map<String, Object> Mapdata, String PostUrl, String ResponType){
        //加解密方法
        desUtils = new DesUtils(Tools.getMD5(desToken));
        //判断token是否为空
        String ifToken = desToken;
        if(ifToken==null){
            throw new RuntimeException("token错误");
        }else{

        }
        //发送post请求
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(Mapdata)
                .when().post(PostUrl);
        //获得body信息
        String response1 =  response.getBody().asString();
        if(response1==null){
            throw new RuntimeException("发送请求不正确");
        }else{

        }
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response1);
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");
        String MingWen =  desUtils.ebotongDecrypto(responseText);
        System.out.println("明文返回串："+MingWen);
        if (ResponType.equals("1")){
            //把String转为json对象
            jsonQuan = JSONObject.parseObject(MingWen);
            //得到item的json对象
            jsonItem = jsonQuan.getJSONObject("item");
            //得到reslut返回值
            resultcode =  jsonItem.getString("result");
            //得到错误信息的返回值
            resultinfo =  jsonItem.getString("resultInfo");

        }else {
            jsonQuan = JSONObject.parseObject(MingWen);
            resultcode =  jsonQuan.getString("result");
            //得到错误信息的返回值
            resultinfo =  jsonQuan.getString("resultInfo");
        }


    }

    @Test
    public void Testfangfa(){
        String a = UrlTools.tokenxiaoqiang;
        desUtils = new DesUtils(Tools.getMD5(a));
        if(a!=UrlTools.token&&a!=UrlTools.tokenxiaoqiang){
            throw new RuntimeException("token错误");
        }
        Map<String, Object> data=new HashMap<>();
        data.put("token", UrlTools.token);
        data.put("userCode", desUtils.ebotongEncrypto(UrlTools.userCode));
        data.put("device",desUtils.ebotongEncrypto("小米"));
        data.put("appVersion", desUtils.ebotongEncrypto("2.8.1"));
        data.put("osVersion", desUtils.ebotongEncrypto("281"));
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(data)
                .when().post(UrlTools.authenUrl);
        String response1 =  response.getBody().asString();
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response1);
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");
        String MingWen =  desUtils.ebotongDecrypto(responseText);

            System.out.println(MingWen);
            //把String转为json对象
        jsonQuan = JSONObject.parseObject(MingWen);
            //获取item的JSONObject
        jsonItem = jsonQuan.getJSONObject("item");
        String resultcode =  jsonItem.getString("result");
        int rrr2 = Integer.parseInt(resultcode);
        //判断result返回值
        if(rrr2 == 1001){
            //判断result返回值
            Assert.assertEquals(jsonItem.getString("result"),1001,"返回码是否是相等");
            System.out.println("用例通过");
        } else {
            //判断result返回值
            Assert.assertEquals(resultcode,"1001","返回码是否是1001");
            System.out.println("\n"+jsonItem.getString("resultInfo"));
        }



    }
    @After
    public void s (){
        System.out.println("执行完了");
    }
}
