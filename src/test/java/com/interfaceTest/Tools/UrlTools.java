package com.interfaceTest.Tools;

public class UrlTools {
    public  static final String ceshi= "https://api.funinhr.com/api";
    public  static final String zhengshi= "https://api.funinhr.com/api";

    public static final String idevcesId = "ffffffff-b4e1-611a-0000-00002d1eabc3";
    public static String token = "5b484aa12384755db385be79";
    public static  String tokenxiaoqiang = "5b56d60323847576e7bdfde5";
    public static  String userCode = "5b18dc072384753fdb18c668";
    public static  String userCodexiaoqiang = "5b56d60323847576e7bdfdde";
    public static  String  verifyCode = "5b738765238475492dcdcb2f";
    public static  String  verifyCodeChen = "5b33006423847542c0e95247";
    public static  String  verifyCodexianshang = "5b8f73cd41eefc3825e8cf3e";
    public static  String  verifyCodebaogao = "5b8f7d1441eefc3825e8db72";


    //小强请求地址路径
    public static final String loginUrl = ceshi+"/enterprise/login";
    public static final String BannerUrl =ceshi+ "/index/get/banner";
    public static final String getNewsListUrl =ceshi+ "/news/getNewsList";
    public static final String registeSMSUrl =ceshi+ "/enterprise/send/registeSMS";
    public static final String loginSMSUrl =ceshi+ "/enterprise/send/loginSMS";
    public static final String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         authenUrl =ceshi+ "/get/enterprise/authen";
    public static final String indexSousuoUrl =ceshi+ "/get/index/search";
    public static final String verifylistjUrl =ceshi+ "/get/verify/list";
    public static final String weixinchongzhi=ceshi+ "/weixin/pay";
    public static final String RenTaiKuSouSuo=ceshi+ "/get/in/verify/search";
    public static final String QiYeRenZheng=ceshi+ "/save/enterprise/info";
    public static final String CepingLeiBiao=ceshi+ "/get/all/eval/verify";
    public static final String CepingLeiBiaoDaiCePing=ceshi+ "/get/wait/eval/verify";
    public static final String CepingLeiBiaoCePingZhong=ceshi+ "/get/in/eval/verify";
    public static final String CepingLeiBiaoYiCePing=ceshi+ "/get/already/eval/verify";
    public static final String CepingLeiBiaoLeiBiaoLiuLan=ceshi+ "/get/already/eval/verify";
    public static final String CepingLeiBiaoChaKanBaoao=ceshi+ "/get/report/list";
    public static final String CuiShouQuan=ceshi+ "/send/urge/verifySMS";
    public static final String JingDanJinDu=ceshi+ "/get/order/process";
    public static final String DuoXiangHuYinCanshu=ceshi+ "/get/custom/verify/config";
    public static final String DuoXiangHuYinxiadan=ceshi+ "/custom/pre/order";
    public static final String DuoXiangHuYinZhiFu=ceshi+ "/pay/custom/order";
    public static final String ShouQuanZhong=ceshi+ "/get/in/verify/list";
    public static final String RenYuanLeiBiao=ceshi+ "/get/all/resume";
    public static final String YiHeYan=ceshi+ "/get/verified/list";
    public static final String WieHeYan=ceshi+ "/get/verifying/list";

    public static final String XiaZaiBaoGao=ceshi+ "/download/report";
    public static final String XiaZaiJianLi=ceshi+ "/download/resume";
    public static final String FaSongXuiGaiDuanXin=ceshi+ "/send/update/resumeSMS";
    public static final String ZhiFuBaoChongZhi=ceshi+ "/funinhr/pre/pay";
    public static final String WeiXinChongZhi=ceshi+ "/smile/pre/pay";
    public static final String JiBenHeYanZanShu=ceshi+ "/smile/pre/pay";
    public static final String JiBenHeYanXiaDan=ceshi+ "/basic/pre/order";
    public static final String JIBenHeYanZhifu =ceshi+ "/pay/basic/order";
    public static final String AnZhuoKaiGuan =ceshi+ "/get/andriod/switch";
    //json文件路径G
    public static final String loginjsonUrl = "JsonFile/login.json";
    public static final String getNewsListjsonUrl = "/Users/haal/文档/InterfaJson/获取新闻.json";
    public static final String BannerjsonUrl = "/Users/haal/文档/InterfaJson/banner.json";
    public static final String registeSMSjsonUrl = "/Users/haal/文档/InterfaJson/发送注册短信.json";
    public static final String loginSMSjsonUrl = "/Users/haal/文档/InterfaJson/短信登录.json";
    public static final String authenjsonUrl = "/Users/haal/文档/InterfaJson/查询企业认证状态.json";
    public static final String verifylistjsonUrl = "/Users/haal/文档/InterfaJson/获得可授权列表.json";
    public static final String indexSousuojsonUrl = "/Users/haal/文档/InterfaJson/首页搜索.json";



    //张晓哲的请求地址
    public static final String zxzregisteSMS = ceshi+ "/enterprise/send/registeSMS";
    public static final String zxzregiste = ceshi+ "/enterprise/register";
    public static final String zxzloginSMS = ceshi+ "/enterprise/send/loginSMS";
    public static final String zxzSMS = ceshi+ "/enterprise/sms/login";
    public static final String zxzseekPwdSMS = ceshi+ "/enterprise/send/seekPwdSMS";
    public static final String zxzseekPwd = ceshi+ "/enterprise/seek/pwd";
    public static final String zxzsaveverify = ceshi+ "/save/verify";
    public static final String zxzverifySMS = ceshi+ "/send/apply/verifySMS";
    public static final String zxzenterpriseinfo = ceshi+ "/save/enterprise/info";
    public static final String zxzgetverifylisto =ceshi+ "/get/verify/list";
    public static final String zxzsavepaypwd = ceshi+ "/save/paypwd";
    public static final String zxzverifymessage = ceshi+ "/get/verify/message";
    public static final String zxzmessagecount = ceshi+ "/get/message/count";
    public static final String zxzmoneylist = ceshi+ "/get/account/message";
    public static final String zxzsystemlist = ceshi+ "/get/system/message";
    public static final String zxzwxchong = ceshi+ "/weixin/pay";
    public static final String zxzalichong = ceshi+ "/alipay/pay";
    public static final String zxzindexsearch = ceshi+ "/get/index/search";
    public static final String zxzListsearch = ceshi+ "/get/verify/search";
    public static final String zxzresumesearch = ceshi+ "/get/resume/search";
    public static final String zxzsavework = ceshi+ "/save/work/verify";
    public static final String zxziosversion = ceshi+ "/get/ios/version";
    public static final String zxzandroidversion = ceshi+ "/get/android/version";
    public static final String zxztongshi = ceshi+ "/save/colleague/verify";
    public static final String zxzverifycinfig = ceshi+ "/get/overall/verify/config";
    public static final String zxzOverall = ceshi+ "/overall/pre/order";
    public static final String zxzallResume = ceshi+ "/get/all/resume";
    public static final String zxzResumeverify = ceshi+ "/get/resume/verify";
    public static final String zxzresume = ceshi+ "/get/resume/html";
    public static final String zxzfaEmaill = ceshi+ "/send/resume/email";
    public static final String zxziosSwich = ceshi+ "/get/ios/switch";
    public static final String zxzandroidSwich = ceshi+ "/get/andriod/switch";
    public static final String zxzadminchong = ceshi+ "/admin/create/trade";
    public static final String zxzshou = ceshi+ "/get/statistics/config";
    public static final String zxzheyan = ceshi+ "/get/verify/config";
    public static final String zxzindex = ceshi+ "/get/index/config";




}
