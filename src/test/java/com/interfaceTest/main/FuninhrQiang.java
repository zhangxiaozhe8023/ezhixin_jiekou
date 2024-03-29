package com.interfaceTest.main;

import com.interfaceTest.Tools.UrlTools;
import org.junit.AfterClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class FuninhrQiang extends LoginMain{

    //微信支付
    @Test
     public void test1(){
        dataToken.put("amount",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.weixinchongzhi,"1","1001");
    }
    //企业认证--------走通了但出现null了
    public void test3(){
        MainTest mainTest = new MainTest();
        Map<String, Object> dataToken=new HashMap<>();
        dataToken.put("token", token1);
        dataToken.put("userCode", desUtilsToken.ebotongEncrypto(UrlTools.userCodexiaoqiang));
        dataToken.put("enterpriseName",desUtilsToken.ebotongEncrypto("北京清河大学测试"));
        dataToken.put("enterpriseCorporationName",desUtilsToken.ebotongEncrypto("罗广强"));
        dataToken.put("enterpriseCertificateCode",desUtilsToken.ebotongEncrypto("123456789852123"));
        dataToken.put("enterpriseEmail",desUtilsToken.ebotongEncrypto("13120050655@163.com"));
        dataToken.put("enterpriseCharteredAddress",desUtilsToken.ebotongEncrypto("北京"));
        dataToken.put("enterprisePresentAddress",desUtilsToken.ebotongEncrypto("清河"));
        dataToken.put("enterpriseCorporationMobile",desUtilsToken.ebotongEncrypto("13120050655"));
        dataToken.put("enterpriseCharteredImage",desUtilsToken.ebotongEncrypto("https://pan.baidu.com/s/1a_Rz2w_M0RH44GPx0wI1aw"));
        dataToken.put("companyCategory",desUtilsToken.ebotongEncrypto("2"));
        dataToken.put("device",desUtilsToken.ebotongEncrypto("小米"));
        dataToken.put("appVersion", desUtilsToken.ebotongEncrypto("2.8.1"));
        dataToken.put("osVersion", desUtilsToken.ebotongEncrypto("281"));
        mainTest.InterTest(token1,dataToken,UrlTools.QiYeRenZheng,"1","1001");
    }
    //职评（以人维度）——查询全部测评列表
    @Test
    public void test4(){
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.CepingLeiBiao,"2","1001");
    }
    //职评（以人维度）——查询待测评列表
    @Test
    public void test5(){
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.CepingLeiBiaoDaiCePing,"2","1001");
    }
    //职评（以人维度）——查询测评中列表
    @Test
    public void test6(){
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.CepingLeiBiaoCePingZhong,"2","1001");
    }
    //职评（以人维度）——查询已测评列表
    @Test
    public void test7(){
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.CepingLeiBiaoYiCePing,"2","1001");
    }
    //人员报告列表——点击预览html
    @Test
    public void test8(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto("5b57eaa023847576e7be0d3d"));
        dataToken.put("orderCode",desUtilsToken.ebotongEncrypto(""));	//订单编号（没填但也走通了）
        mainTest.InterTest(token1,dataToken,UrlTools.CepingLeiBiaoLeiBiaoLiuLan,"2","1001");
    }
    //职评（以人维度）——详情查看报告列表
    @Test
    public void test9(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodebaogao));
        mainTest.InterTest(token1,dataToken,UrlTools.CepingLeiBiaoChaKanBaoao,"2","1001");
    }
    //发短信催促核验人(verifyCode字段可去test15方法立找)3002记录不存在
    @Test
    public void test10(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodexianshang));
        mainTest.InterTest(token1,dataToken,UrlTools.CuiShouQuan,"1","2001");
    }
    //（新版）查看订单进度（无订单编号返回1002：明文错误）
    public void test11(){
        dataToken.put("orderCode",desUtilsToken.ebotongEncrypto(""));	//订单编号（返回结果：1002）
        mainTest.InterTest(token1,dataToken,UrlTools.JingDanJinDu,"2","1001");
    }
    //多项核验——获得参数配置（有问题）
    @Test
    public void test12(){
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.DuoXiangHuYinCanshu,"2","1001");
    }
    //多项核验下单(成功但又有null)未完成

    public void test13(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto("5b57eaa023847576e7be0d3d"));
        dataToken.put("verifyArray",desUtilsToken.ebotongEncrypto("['1001','1002','1003']"));
        mainTest.InterTest(token1,dataToken,UrlTools.DuoXiangHuYinxiadan,"1","1001");
    }
    //多项核验——订单支付（无订单编号导致错误）
    public void test14(){
        dataToken.put("orderCode",desUtilsToken.ebotongEncrypto(""));//无订单编号
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto("5b57eaa023847576e7be0d3d"));
        dataToken.put("payPwd",desUtilsToken.ebotongEncrypto("123456"));
        mainTest.InterTest(token1,dataToken,UrlTools.DuoXiangHuYinZhiFu,"2","1001");
    }
    //我的授权——获得授权中列表
    @Test
    public void test15(){
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.ShouQuanZhong,"2","1001");
    }
    //我的——人员列表
    @Test
    public void test16(){
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.RenYuanLeiBiao,"2","1001");
    }
    //人员列表——删除(没有此功能)

    //获得 已核验的 已授权/授权中列表
    @Test
    public void test17(){
        dataToken.put("packageCode",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.YiHeYan,"2","1001");
    }
    //获得 未核验的 已授权/授权中列表
    @Test
    public void test18(){

        dataToken.put("packageCode",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.WieHeYan,"2","1001");
    }
    //查询首页banner

    public void indexBanner(){
        //调用接口方法，参数1：加解密密钥，参数2传入dataToken请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(UrlTools.idevcesId,dataToken,UrlTools.BannerUrl,"2","1001");
    }
    //查询首页banner

    public void indexBanne22r(){
        dataToken.put("packageCode",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("1"));
        //调用接口方法，参数1：加解密密钥，参数2传入dataToken请求参数，参数3请求url，参数4：待定。参数5：
        mainTest.InterTest(token1,dataDevicesId,UrlTools.WieHeYan,"2","1001");
    }
    //下载报告(null 原因不名)

    public void test19(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto("5b57eaa023847576e7be0d3d"));
//        Map<String, Object> dataToken=new HashMap<>();
//        dataToken.put("token", token1);
//        dataToken.put("userCode", desUtilsToken.ebotongEncrypto(UrlTools.userCodexiaoqiang));
//        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto("5b57eaa023847576e7be0d3d"));
//        dataToken.put("device",desUtilsToken.ebotongEncrypto("小米"));
//        dataToken.put("appVersion", desUtilsToken.ebotongEncrypto("2.8.1"));
//        dataToken.put("osVersion", desUtilsToken.ebotongEncrypto("281"));
        mainTest.InterTest(token1,dataToken,UrlTools.XiaZaiBaoGao,"1","1001");
    }
    //下载简历
    @Test
    public void test20(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodebaogao));
        mainTest.InterTest(token1,dataToken,UrlTools.XiaZaiJianLi,"1","1001");
    }

    //修改简历发送短信
    @Test
    public void test21(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodexianshang));
        mainTest.InterTest(token1,dataToken,UrlTools.FaSongXuiGaiDuanXin,"1","2001");
    }
    //支付宝（二维码）充值
    @Test
    public void test22(){
        dataToken.put("amount",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.ZhiFuBaoChongZhi,"1","1001");
    }
    //微信（二维码）充值
    @Test
    public void test23(){
        dataToken.put("amount",desUtilsToken.ebotongEncrypto("1"));
        mainTest.InterTest(token1,dataToken,UrlTools.WeiXinChongZhi,"1","1001");
    }

   // 基本核验——获得参数配置
   @Test
   public void test24(){
       dataToken.put("amount",desUtilsToken.ebotongEncrypto("1"));
       mainTest.InterTest(token1,dataToken,UrlTools.JiBenHeYanZanShu,"1","1001");
   }
    //基本核验下单（{"item":2010}原因为止）

    public void test25(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto("5b57eaa023847576e7be0d3d"));
        dataToken.put("verifyArray",desUtilsToken.ebotongEncrypto("['1001','1002','1003']"));
        mainTest.InterTest(token1,dataToken,UrlTools.JiBenHeYanXiaDan,"2","1001");
    }
    //基本核验——订单支付（null）

    public void test26(){
        MainTest mainTest = new MainTest();
        Map<String, Object> dataToken=new HashMap<>();
        dataToken.put("token", token1);
        dataToken.put("userCode", desUtilsToken.ebotongEncrypto(UrlTools.userCodexiaoqiang));
        dataToken.put("orderCode",desUtilsToken.ebotongEncrypto(""));//无订单编号
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto("5b57eaa023847576e7be0d3d"));
        dataToken.put("payPwd",desUtilsToken.ebotongEncrypto("123456"));
        dataToken.put("device",desUtilsToken.ebotongEncrypto("小米"));
        dataToken.put("appVersion", desUtilsToken.ebotongEncrypto("2.8.1"));
        dataToken.put("osVersion", desUtilsToken.ebotongEncrypto("281"));
        mainTest.InterTest(token1,dataToken,UrlTools.JIBenHeYanZhifu,"2","1001");
    }
    //获取安卓开关(一大常串子不知道是什么)

    public void test27(){
        mainTest.InterTest(UrlTools.idevcesId,dataToken,UrlTools.AnZhuoKaiGuan,"2","1001");
    }
    @AfterClass
    public static void  endle(){
        System.out.println("结束了");
    }


}
