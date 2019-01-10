package com.interfaceTest.main;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.interfaceTest.Tools.UrlTools;
import org.junit.Test;
public class FuninhrInerfce2 extends LoginMain{

    //首页模块——搜索
    @Test
    public void indexsearch(){
        dataToken.put("searchCondition",desUtilsToken.ebotongEncrypto("陈"));
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("15"));
        System.out.println(dataToken);
        mainTest.InterTest(token1,dataToken,UrlTools.zxzindexsearch,"2","1001");
    }
    //授权列表——搜索和我的人才库搜索
    @Test
    public void verifysearch(){
        dataToken.put("searchCondition",desUtilsToken.ebotongEncrypto("陈"));
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("15"));
        mainTest.InterTest(token1,dataToken,UrlTools.zxzListsearch,"2","1001");
        mainTest.InterTest(token1,dataToken,UrlTools.zxzresumesearch,"2","1001");
    }
    //工作订单*(未完成)

    public void workOder(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodeChen));
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("[{'workCode':'59acbda82b4a7804f44885ca'，'isVerifySalary':'1'}]"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("15"));
        mainTest.InterTest(token1,dataToken,UrlTools.zxzindexsearch,"2","1001");
    }
    //保存修改工作经历*(未完成)
    public void saveWork(){

        // Json对象中是添加的键值对,JSONArray中添加的是Json对象

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        // JSONObject 对象中添加键值对
        jsonObject.put("workEnterpriseName","2nfjUA8maRj8xr1u3ndEBMJwXkT4TIkYOQPpcbo0bGA2izoEPjS44Q==");
        jsonObject.put("workBalance","0ke0ADRKgOE=");
        jsonObject.put("workStartTime","fMjQl2r6Tcs=");
        jsonObject.put("workEndTime","4lhvYKcqj80=");
        jsonObject.put("isVerifySalary","uVg98Scx6XM=");
        // 将JSONObject对象添加到json数组中
        jsonArray.add(jsonObject);
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodeChen));
        dataToken.put("workArray",jsonArray);
        System.out.println(dataToken);
        mainTest.InterTest(token1,dataToken,UrlTools.zxzsavework,"1","1001");
    }
    //iOS获取版本信息
    @Test
    public void IosVersion(){
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxziosversion,"2","1001");
    }
    //获取ios，安卓开关
    @Test
    public void IosSwich(){
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxziosSwich,"2","1001");
//        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzandroidSwich,"2","1001");
    }
    //Android获取版本信息（未完成）

    public void AndroidVersion(){
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzandroidversion,"2","1001");
    }
    //保存修改工作经历*(未完成)

    public void colleague(){
        // Json对象中是添加的键值对,JSONArray中添加的是Json对象
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        // JSONObject 对象中添加键值对
        jsonObject.put("colleagueName",desUtilsToken.ebotongEncrypto("张校长"));
        jsonObject.put("colleagueMobile",desUtilsToken.ebotongEncrypto("13120050655"));
        jsonObject.put("companyName",desUtilsToken.ebotongEncrypto("范德萨"));
        jsonObject.put("verifyJob",desUtilsToken.ebotongEncrypto("范德萨3"));
        jsonObject.put("jobStartTime",desUtilsToken.ebotongEncrypto("201801"));
        jsonObject.put("jobEndTime",desUtilsToken.ebotongEncrypto("201805"));
        // 将JSONObject对象添加到json数组中
        jsonArray.add(jsonObject);
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodeChen));
        dataToken.put("colleagueArray",jsonArray);
        System.out.println(dataToken);
        mainTest.InterTest(token1,dataToken,UrlTools.zxztongshi,"1","1001");
    }
    //全面核验——获得参数配置
    @Test
    public void verifycinfig(){
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzverifycinfig,"2","1001");
    }
    //全面核验下单（未完成）

    public void Overall(){
        // Json对象中是添加的键值对,JSONArray中添加的是Json对象
//        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = new JSONArray();
//        // JSONObject 对象中添加键值对
//        jsonObject.put("1001");
//        jsonObject.put("colleagueMobile",desUtilsToken.ebotongEncrypto("13120050655"));
//        jsonObject.put("companyName",desUtilsToken.ebotongEncrypto("范德萨"));
//        jsonObject.put("verifyJob",desUtilsToken.ebotongEncrypto("范德萨3"));
//        jsonObject.put("jobStartTime",desUtilsToken.ebotongEncrypto("201801"));
//        jsonObject.put("jobEndTime",desUtilsToken.ebotongEncrypto("201805"));
//        // 将JSONObject对象添加到json数组中
//        jsonArray.add(jsonObject);

        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodeChen));
        dataToken.put("verifyArray",desUtilsToken.ebotongEncrypto("['1001','1002','1003','1004','1005','1006','1007']"));
        mainTest.InterTest(token1,dataToken,UrlTools.zxzOverall,"2","1001");
    }
    //我的——人才库列表
    @Test
    public void allResume(){
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("15"));
        mainTest.InterTest(token1,dataToken,UrlTools.zxzallResume,"2","1001");
    }
    //我的——报告列表（未完成）数据库异常

    public void Resumeverify(){
        dataToken.put("pageStart",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("pageSize",desUtilsToken.ebotongEncrypto("15"));
        dataToken.put("resumeVerifyType",desUtilsToken.ebotongEncrypto("0"));
        dataToken.put("resumeVerifyStatus",desUtilsToken.ebotongEncrypto("0"));
        mainTest.InterTest(token1,dataToken,UrlTools.zxzResumeverify,"2","1001");
    }
    //人员列表——点击预览html（返回值异常）

    public void resumeHtml(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodeChen));
        mainTest.InterTest(token1,dataToken,UrlTools.zxzresume,"2","1001");
    }
    //人员报告列表——点击预览html（未完成）

    public void BaogaoHtml(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodeChen));
        mainTest.InterTest(token1,dataToken,UrlTools.zxzresume,"2","1001");
    }
    //人员列表——发送到邮箱（未完成有问题）

    public void FaEmaill(){
        dataToken.put("verifyCode",desUtilsToken.ebotongEncrypto(UrlTools.verifyCodeChen));
        dataToken.put("enterpriseEmail",desUtilsToken.ebotongEncrypto("980778026@qq.com"));
        mainTest.InterTest(token1,dataToken,UrlTools.zxzfaEmaill,"1","1001");
    }
    //管理员充值
    @Test
    public void adminChong(){
        mainTest.InterTest(UrlTools.idevcesId,dataDevicesId,UrlTools.zxzindex,"2","1001");
    }

}
