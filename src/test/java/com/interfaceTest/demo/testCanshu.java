
package com.interfaceTest.demo;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import com.interfaceTest.Data.DataClass;
import com.interfaceTest.Data.Tokenzhi;
import com.interfaceTest.Tools.DesUtils;
import com.interfaceTest.Tools.Tools;
import com.interfaceTest.Tools.UrlTools;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
@RunWith(Parameterized.class)
public class testCanshu {
    private DesUtils desUtils;
    private JSONObject obj3;



    @Parameterized.Parameters()

    public static List<DataClass> data() throws IOException {


        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<DataClass> data = mapper.readValue(

                new File("ezhixinData/login.yaml"),
                new TypeReference<List<DataClass>>(){}
        );

        return data;
    }

    @Parameterized.Parameter
    public DataClass dataw;
    /*
    登录用例
     */
     @Test
    public void loginCeshi() {
//        assertThat(dataw.getCount(),  equalTo(dataw.getKey()));
         desUtils = new DesUtils(Tools.getMD5("ffffffff-b4e1-611a-0000-00002d1eabc3"));
        Map<String, Object> data=new HashMap<>();
        data.put("appVersion", desUtils.ebotongEncrypto("2.8.1"));
        data.put("device", desUtils.ebotongEncrypto("小米"));
        data.put("deviceId", "ffffffff-b4e1-611a-0000-00002d1eabc3");
        data.put("mobile",desUtils.ebotongEncrypto(dataw.getCount()));
        data.put("loginPwd", desUtils.ebotongEncrypto(dataw.getKey()));
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


        String MingWen =  desUtils.ebotongDecrypto(responseText);
              System.out.print(MingWen);
        JSONObject obj2 = JSONObject.parseObject(MingWen);

        //获取item的JSONObject
         obj3 = obj2.getJSONObject("item");
         String resultcode =  obj3.getString("result");
           String ZheToken = obj3.getString("token");
         UrlTools.token = ZheToken;
        System.out.println(UrlTools.token);
        int rrr2 = Integer.parseInt(resultcode);
        //判断result返回值
        if(rrr2 == 1001){
            //判断result返回值
            Assert.assertEquals("返回码是否是1001","1001",resultcode);
            System.out.print("用例通过");
        } else {
            //判断result返回值
            Assert.assertEquals("返回码是否是1001","1001",resultcode);
            System.out.print("\n"+obj3.getString("resultInfo"));
        }
    }
    //查询认证状态
    @Test
    public void renzhengzhuangt(){
        desUtils = new DesUtils(Tools.getMD5(UrlTools.token));
        Map<String, Object> data=new HashMap<>();
        data.put("token", UrlTools.token);
        data.put("userCode", desUtils.ebotongEncrypto(UrlTools.userCode));
        data.put("device",desUtils.ebotongEncrypto("小米"));
        data.put("appVersion", desUtils.ebotongEncrypto("2.8.1"));
        data.put("osVersion", desUtils.ebotongEncrypto("281"));

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(data)
                .when().post("地址");
        String response1 =  response.getBody().asString();
        //获得JSONObject对象（密文）并打印
        JSONObject obj = JSONObject.parseObject(response1);
        //获取返回值ciphertext字段内容（密文）
        String responseText = obj.getString("ciphertext");
        String MingWen =  desUtils.ebotongDecrypto(responseText);
        System.out.print(MingWen);
        //把String转为json对象
        JSONObject obj2 = JSONObject.parseObject(MingWen);

        //获取item的JSONObject
        obj3 = obj2.getJSONObject("item");
        String resultcode =  obj3.getString("result");
        int rrr2 = Integer.parseInt(resultcode);
        //判断result返回值
        if(rrr2 == 1001){
            //判断result返回值
            Assert.assertEquals(obj3.getString("result"),"1001","返回码是否是1001");
            System.out.print("用例通过");
        } else {
            //判断result返回值
            Assert.assertEquals(resultcode,1001,"返回码是否是1001");
            System.out.print("\n"+obj3.getString("resultInfo"));
        }
    }
    @Test
    public void zxz(){
        String str = "";
        String pattern = "request";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }
   @After
    public void dds(){
        System.out.println();
  }

}