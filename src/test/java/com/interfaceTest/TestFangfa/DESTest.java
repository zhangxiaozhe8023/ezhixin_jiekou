package com.interfaceTest.TestFangfa;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.interfaceTest.Tools.DesUtils;
import com.interfaceTest.Tools.Tools;
import com.interfaceTest.Tools.UrlTools;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.HashMap;


public class DESTest {


    private static HashMap Mapmap;

//    private static String

    @BeforeClass
    public static void before(){

    }
    @Test
    //加密是token的
         public  void JiamiToken (){
            DesUtils desUtils =new DesUtils(Tools.getMD5("5b57d48923847576e7be015f"));
        //1312005
//        DesUtils desUtils =new DesUtils(Tools.getMD5("5b31f7402384757c45f8bbe2"));
        //加密
//        System.out.print("5b2080782384757c00c3b391"+"\n");
//        System.out.print(desUtils.ebotongEncrypto("5b18dc072384753fdb18c668")+"\n");
//        System.out.print(desUtils.ebotongEncrypto("李彦")+"\n");
//        System.out.print(desUtils.ebotongEncrypto("18310614641")+"\n");
//        System.out.print(desUtils.ebotongEncrypto("420106198001274416")+"\n");
//        System.out.print(desUtils.ebotongEncrypto("5b3de2cc23847543e7029b31")+"\n");
//        System.out.print(desUtils.ebotongEncrypto("654321")+"\n");
//        System.out.print(desUtils.ebotongEncrypto("10")+"\n");
//        System.out.print(desUtils.ebotongEncrypto("1")+"\n");
        System.out.println(desUtils.ebotongEncrypto("5a962267caf23b4ab9bde7dd"));
        System.out.println(desUtils.ebotongEncrypto("小米"));
        System.out.println(desUtils.ebotongEncrypto("2.8.0"));
        System.out.println(desUtils.ebotongEncrypto("280"));


    }

    @Test
    public  void   JiamidevicesId(){
        DesUtils  desUtils =new DesUtils(Tools.getMD5("ffffffff-b4e1-611a-0000-00002d1eabc3"));
        System.out.print(desUtils.ebotongEncrypto("18310614641")+"\n");
        System.out.print(desUtils.ebotongEncrypto("123456a")+"\n");
        System.out.print(desUtils.ebotongEncrypto("Android")+"\n");
        System.out.print(desUtils.ebotongEncrypto("2.8.0")+"\n");
        System.out.print(desUtils.ebotongEncrypto("7.0")+"\n");
        System.out.print(desUtils.ebotongEncrypto("Android")+"\n");
//        System.out.print(desUtils.ebotongEncrypto("2.8.0")+"\n");
//        System.out.print(desUtils.ebotongEncrypto("280")+"\n");

    }
    @Test
    public  void JiemiDeviceid (){
        DesUtils desUtils =new DesUtils(Tools.getMD5("ffffffff-b4e1-611a-0000-00002d1eabc3"));
//        DesUtils desUtils =new DesUtils(Tools.getMD5("5b2080782384757c00c3b391"));
//        DesUtils desUtils =new DesUtils(Tools.getMD5("5b31f7402384757c45f8bbe2"));
        //解密
        System.out.print(desUtils.ebotongDecrypto("uYQ/FUvkERxJSzYYrR3klT0sd0eDmz2rqpPC5kuhWvbTKy7a2HHeK1ZPSIUQ0/UlTSEnxrWS9C8Lay71Uh38GnIUfewjl2KXFiM62bcjOk1Ps7JzfIGQHg=="));
        System.out.print(desUtils.ebotongDecrypto(""));
        System.out.print(desUtils.ebotongDecrypto(""));
        System.out.print(desUtils.ebotongDecrypto(""));

    }
    @Test
    public  void JiemiToken (){
        DesUtils desUtils =new DesUtils(Tools.getMD5("5b2080782384757c00c3b391"));
//        DesUtils desUtils =new DesUtils(Tools.getMD5("5b31f7402384757c45f8bbe2"));
        //解密
//        System.out.print(desUtils.ebotongDecrypto("4yG74k6WpIGVkl5PoK9y7Grg+h6gOiBAObj7kivHTzOPH5h+8tYF9D0oBuR9OM+XoKHek5qKLNiNSW+aArXYaQsFS0GoI6GUCQ3nDV8kBo85uPuSK8dPM80mVVdENEkRuim9ncswdsU="));
//        System.out.print(desUtils.ebotongDecrypto("4yG74k6WpIGVkl5PoK9y7Grg+h6gOiBACEJsTdk845mxxLf+Q06nsRQYMPgT79BYxrmH8VwyYVosQXF2AOVyjxsT8BheDTikCZlLa+aIrrBfoB8YbF5qUExKoworILiT"));
//        System.out.print(desUtils.ebotongDecrypto("4yG74k6WpIGVkl5PoK9y7OBphLY96917JuY8Xuzd2M1CjzMR+a/3rvBKe2sS4Qj3RKdDbnpY5TtziSI26vFKLqV3zoEsYKv56RhWaoG//c1pgKvk+hWJVg=="));
//        System.out.print(desUtils.ebotongDecrypto("4yG74k6WpIGVkl5PoK9y7I4GvAB24J71OkS2FTnxIuk="));
//        System.out.print(desUtils.ebotongDecrypto("4yG74k6WpIGVkl5PoK9y7NVAGavWuPEwGxPwGF4NOKSHOFfjC0T1kObbH5zPTSabeFSP88UT+CCjYFlftADTY+K80+SaXViHC62M3+qCaaA="));
//        System.out.print(desUtils.ebotongDecrypto("4yG74k6WpIGVkl5PoK9y7Grg+h6gOiBAWDgLZOtZF5cUmXlulw78MQGByUxA977b4DD7hTaMrOMMP9M3QvOoKNtPU/QOaSWGq9TfPdy25z12DWnyytumdEWtfTZJ1PzjZaTpd5DipbbCmcOfVK8X5ZrRjmR1K2o/hV8lGtqV+T+V0dycYWxmegGd4o9O28WIgBa+ClJQh0ogeW1ZPlG5WTfs2/3Sz3MhOlf6HaJjZEjpOxycwTttEsPdH3mdcbCSMFiihuBH3iC8GfcZ4BUVEE8AWnsMnSNIKUmnK4bX7gJ7wgPtH9g4ONTPM9vJxdVTwMoucZEzEaM="));
//        System.out.print(desUtils.ebotongDecrypto("4yG74k6WpIGOwzlUi6GNZI6bFHgm+3KOYO8d+GwZU8Ypnbohpc8rGFe4hoByXVdXIELCyWjL/DQO8Vm0l2/l6nfYVA3+HZgNP6763suhQ4oaLUGakimV8xLaHiE/es7Dni/br9iaejxXLI/Sp/36b5YL894rV4bUFRpBpQg59fcbT04mkaXzlj4dy+A8bLbWNuXRNLTIX7+ap5ojW+4H5euBZ6jCnqyVee2xdPWZtVAjeE/nMVAxc8Y0rtZoswe9JRB3lF2Wt3+t58OiZ+Zgr/uva5UNChF9bHKQnfxXs6ElABFmRb7JNT+ZT8Q9G3UqFMy87b/TLlr/au7dZyHevZ7rGWly+jZEuA5wPPxJYSN2x5EK0CT1Yw=="));
//        System.out.print(desUtils.ebotongDecrypto("FiDdf8JGQnWNtDt58LR0FRBSwNBPNBCpGacZYxGU55Y9/0jrKfh5X2d9QPShgbF53UTn3o82qCoeBLSMbsm1sdeig5YkyKs7mExLDdSHHlMpKSIvp8OsP1NP9XgF4m2Y0cX2Ra3J20+C50mBm2W6176DlIDO0Q6cle1+9S5EXRP5CdAJUgq8o0yDT/SNyU7bwEp12+5uHsAwhPuGvJQA22N4xUxJzQcd1p/cyCj/vCENWYhQz2iGugOrfrdF8yY0Cz4z6tzBkl9ROmjh2oU/pvre2JYQcpE7fCTFLt0d7e5VFpTlJbVMU7kNa1nOCPgXZn2hYCtWLbqo9N5xOE3baBV5fWimMKTijvASYEYQvnYY9zhPVNAsxfYdUIxdPr/ODyu/TcIE6I4="));
        System.out.print(desUtils.ebotongDecrypto("3MV9r8G5Rnw="));
        System.out.print(desUtils.ebotongDecrypto("GJjxRXs8vsU="));
        System.out.print(desUtils.ebotongDecrypto("GJjxRXs8vsU="));
        System.out.print(desUtils.ebotongDecrypto("GJjxRXs8vsU="));

    }


}
