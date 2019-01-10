package com.interfaceTest.main;

import com.interfaceTest.Tools.UrlTools;
import org.junit.AfterClass;
import org.junit.Test;



public class InterfaceMain extends LoginMain{

    //查询企业状态
    @Test
    public void test1(){
        mainTest.InterTest(token1,dataToken,UrlTools.authenUrl,"1","1001");
    }
        //查询首页banner
    @Test
    public void indexBanner(){
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.BannerUrl,"2","1001");
    }
    //企业用户注册下发验证码
    @Test
    public void registeSMS(){
        dataDevicesId.put("mobile", desUtilsIdevces.ebotongEncrypto("18310614644"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzregisteSMS,"1","2001");
    }
    //企业用户注册
    @Test
    public void registeTest(){
        dataDevicesId.put("mobile", desUtilsIdevces.ebotongEncrypto("18310614644"));
        dataDevicesId.put("loginPwd", desUtilsIdevces.ebotongEncrypto("123456a"));
        dataDevicesId.put("validateCode", desUtilsIdevces.ebotongEncrypto("123456"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzregiste,"1","2004");
    }
    //发送短信登录验证码
    @Test
    public void loginSMS(){
        dataDevicesId.put("mobile", desUtilsIdevces.ebotongEncrypto("18310614644"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzloginSMS,"1","2001");
    }
    //短信登录
    @Test
    public void SMSLogin(){

        dataDevicesId.put("mobile", desUtilsIdevces.ebotongEncrypto("18310614644"));
        dataDevicesId.put("validateCode", desUtilsIdevces.ebotongEncrypto("123456"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzSMS,"1","2004");
    }
    //企业用户找回密码下发验证码
    @Test
    public void seekPwdSMS(){
        dataDevicesId.put("mobile", desUtilsIdevces.ebotongEncrypto("18310614644"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzseekPwdSMS,"1","2007");
    }
    //企业用户找回密码
    @Test
    public void seekPwd(){
        dataDevicesId.put("mobile", desUtilsIdevces.ebotongEncrypto("18310614644"));
        dataDevicesId.put("validateCode", desUtilsIdevces.ebotongEncrypto("123456"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzseekPwd,"1","2005");
    }
    //新增/修改 核验人

    public void asaveverify(){
        dataToken.put("verifyName", desUtilsToken.ebotongEncrypto("核验人"));
        dataToken.put("verifyMobile", desUtilsToken.ebotongEncrypto("18310614644"));
        dataToken.put("verifyIdCard", desUtilsToken.ebotongEncrypto("130126199511111220"));
        dataToken.put("verifyJob", desUtilsToken.ebotongEncrypto("总裁"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
       mainTest.InterTest(token1,dataToken,UrlTools.zxzsaveverify,"1","1001");
    }
    //申请核验(短信)
    @Test
    public void verifySMS(){
        dataToken.put("verifyCode", desUtilsToken.ebotongEncrypto("5b8f7d1441eefc3825e8db72"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(token1,dataToken,UrlTools.zxzverifySMS,"1","2001");
    }
    //企业认证
    @Test
    public void enterpriseinfo(){
        dataToken.put("enterpriseName", desUtilsToken.ebotongEncrypto("接口测试"));
        dataToken.put("enterpriseCorporationName",desUtilsToken.ebotongEncrypto("张晓哲1"));
        dataToken.put("enterpriseCertificateCode",desUtilsToken.ebotongEncrypto("1234567890123456789"));
        dataToken.put("enterpriseCorporationMobile",desUtilsToken.ebotongEncrypto("18310614641"));
        dataToken.put("companyCategory",desUtilsToken.ebotongEncrypto("计算机软件"));
        dataToken.put("enterpriseCharteredImage",desUtilsToken.ebotongEncrypto("http://cdn.funinhr.com/test/image/chartered/chartered_4592523f15bc95a42318b2abf99dba08_oss.jpg"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(token1 ,dataToken,UrlTools.zxzenterpriseinfo,"1","1001");
    }
    //未授权列表查询
    @Test
    public void getverifylist(){
        dataToken.put("pageStart", desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(token1,dataToken,UrlTools.zxzgetverifylisto,"2","1001");
    }
    //设置支付密码
    @Test
    public void savapaypwd(){
        dataToken.put("payPwd", desUtilsToken.ebotongEncrypto("123456"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：没有item对象使用非1参数。参数5：返回值
        mainTest.InterTest(token1,dataToken,UrlTools.zxzsavepaypwd,"1","1001");
    }
    //消息——获得认证消息列表
    @Test
    public void verifymessage(){
        dataToken.put("pageStart", desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize", desUtilsToken.ebotongEncrypto("15"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：没有item对象使用非1参数。参数5：返回值
        mainTest.InterTest(token1,dataToken,UrlTools.zxzverifymessage,"2","1001");
    }
    //—消息——获得消息未读数量
    @Test
    public void messagecount(){
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：没有item对象使用非1参数。参数5：返回值
        mainTest.InterTest(token1,dataToken,UrlTools.zxzmessagecount,"1","1001");
    }
    //消息——获得钱包消息列表
    //消息——获得系统消息列表（未完成）
    @Test
    public void moneylist(){
        dataToken.put("pageStart", desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize", desUtilsToken.ebotongEncrypto("15"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：没有item对象使用非1参数。参数5：返回值
        mainTest.InterTest(token1,dataToken,UrlTools.zxzmoneylist,"2","1001");
//        mainTest.InterTest(token1,dataToken,UrlTools.zxzsystemlist,"2","1001");

    }
    //微信支付宝充值
    @Test
    public void wxchong(){
        dataToken.put("amount", desUtilsToken.ebotongEncrypto("10"));
        //调用接口方法，参数1：加解密密钥，参数2传入data请求参数，参数3请求url，参数4：没有item对象使用非1参数。参数5：返回值
        mainTest.InterTest(token1,dataToken,UrlTools.zxzwxchong,"1","1001");
        mainTest.InterTest(token1,dataToken,UrlTools.zxzalichong,"1","1001");
    }
    @AfterClass
    public static void endle(){

    }
}
