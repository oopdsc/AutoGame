package game;

import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class Player {

    Logger logger = LoggerFactory.getLogger(Player.class);

    RestTemplate restTemplate = new RestTemplate();



    String uid = "";
    String token = "";
    String openid = "";
    String openkey = "";

    String username = "";
    String password = "";

    String url = "";

    String rsn = "";

    public Player(String un, String pw, String oid, String okey){
        this.username = un;
        this.password = pw;
        this.openid = oid;
        this.openkey = okey;
    }

    public void setRsn(String rsn){
        this.rsn = rsn;
    }

    public void doMobai(){

        HttpHeaders headers = getHttpHeaders();

        for(int i = 1; i<=3; i++){
            String body = "{\"rsn\":\"" + rsn + "\",\"ranking\":{\"mobai\":{\"type\":"+i+"}}}";
            HttpEntity entity = new HttpEntity(body, headers);
            ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        }

        String body = "{\"rsn\":\""+rsn+"\",\"huanggong\":{\"qingAn\":{\"type\":0,\"chenghao\":30}}}";
        HttpEntity entity = new HttpEntity(body, headers);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        logger.info(response.getBody());

    }

    public void doLogin(){
        String loginurl = "http://usercenter.zhisnet.cn/account/fastLogin.php?appid=189&username=" + this.username + "&password=" + this.password + "&_lang=zh-cn";

        //http://sglyqw.commpad.cn/servers/s7.php?sevid=7&ver=V1.0.351&uid=&token=&platform=qiangwanzdhgios&lang=zh-cn
        //{"rsn":"5ywfjvphwhf","login":{"loginAccount":{"platform":"qiangwanzdhgios","openid":"2582176_ios","openkey":"971e6dfd4def2cac5c2260ff07a20133"}}}

        //{"rsn":"9mrszjnsrmt","login":{"loginAccount":{"platform":"qiangwanzdhgios","openid":"2587430_ios","openkey":"8e63ad62fb17920353f555247a40c160"}}}
        //{"rsn":"8makjvrkroe","login":{"loginAccount":{"platform":"qiangwanzdhgios","openid":"2587430_ios","openkey":"8e63ad62fb17920353f555247a40c160"}}}

        //{"s":1,"a":{"system":{"verifySwitch":{"status":2},"verify":{"status":0},"sys":{"time":1635937526}},
        // "loginMod":{"loginAccount":{"uid":"7005243","token":"79690c944e8f28d11f783b2b6588e384",
        // "backurl":"","num1":"","pftoken":"","gamename":"","ip":"121.32.46.249","useraccount":"",
        // "thirdpurl":"http:\/\/ledongsdk.coolnull.com\/App\/Me\/purl2game?appid=800105"}}},"u":[]}

        //http://sglyqw.commpad.cn/servers/s7.php?sevid=7&ver=V1.0.351&uid=7005243&token=79690c944e8f28d11f783b2b6588e384&platform=qiangwanzdhgios&lang=zh-cn
        //{"rsn":"5wvwrvphry","guide":{"login":{"platform":"qiangwanzdhgios","ug":""}}}
        String body = "";

        HttpHeaders headers = getHttpHeaders();

        HttpEntity entity = new HttpEntity(body, headers);

//        ResponseEntity<String> response = this.restTemplate.exchange(loginurl, HttpMethod.POST, entity, String.class);

//        body = response.getBody();
//
//        logger.info(response.getBody());


        body = "{\"rsn\":\""+this.rsn+"\",\"login\":{\"loginAccount\":{\"platform\":\"qiangwanzdhgios\"," +
                "\"openid\":\""+this.openid+"\",\"openkey\":\""+this.openkey+"\"}}}";
        HttpEntity entity2 = new HttpEntity(body, headers);

        ResponseEntity<String> response2 = this.restTemplate.exchange(
                "http://sglyqw.commpad.cn/servers/s7.php?sevid=7&ver=V1.0.351&uid=&token=&platform=qiangwanzdhgios&lang=zh-cn", HttpMethod.POST, entity2, String.class);

        body = response2.getBody();
        logger.info(response2.getBody());


        this.uid = JsonPath.parse(body).read("$.a.loginMod.loginAccount.uid", String.class);
        this.token = JsonPath.parse(body).read("$.a.loginMod.loginAccount.token", String.class);
        this.url = "http://sglyqw.commpad.cn/servers/s7.php?sevid=7&ver=V1.0.351&uid="+this.uid+"&token="+this.token+"&platform=qiangwanzdhgios&lang=zh-cn";


    }




    public void doBoss(int bossid, int id, String rsn){
        String body = "{\"club\":{\"clubBossPK\":{\"cbid\":"+bossid+",\"id\":"+ id + "}},\"rsn\":\"" + rsn + "\"}";

        HttpEntity entity = new HttpEntity(body, getHttpHeaders());
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        logger.info(response.getBody());
    }

    public void act(){
        this.doLogin();
        this.doMobai();
    }


    //征收
//{"user":{"jingYingAll":[]},"rsn":"6wpwkkwbsy"}
    //丝路
    //{"silkroad":{"rootPlay":{"gid":40}},"rsn":"9zmijnmsssi"}
    //讨伐
    //{"rsn":"4afbhifmhhv","taofa":{"rootPlay":{"gid":40}}}


    //买黄书
//    {"club":{"shopBuy":{"id":7}},"rsn":"9zmijnmnsti"}

    //买匈奴
    //{"wordboss":{"shopBuy":{"id":1}},"rsn":"5wvwrrwpwh"}

    //hit xiongnu
    //{"wordboss":{"hitgeerdan":{"id":1}},"rsn":"7cscppcvsv"}

    //zhengwu
//    {"user":{"zhengWu":{"act":1}},"rsn":"5ywfjvejrrh"}

    //xunfang
    //{"rsn":"8makjvijxrm","xunfang":{"xunfan":{"type":1}}}

    //{"rsn":"5ywfjvefhrr","school":{"allover":[]}}
    //{"rsn":"6sxkpuxkxpx","school":{"allstart":[]}}

    //{"wife":{"yjxo":[]},"rsn":"6sxkpuxkgwy"}
//                               1aywalyxyb
    //{"yamen":{"pizun":[]},"rsn":"8jmevrmeemk"}
    //{"yamen":{"fight":{"id":5}},"rsn":"8makjvikrji"}

    //领日常
    //{"courtyard":{"getCourtyardDayRwd":[]},"rsn":"4fcmahvmxhv"}
    //种树
    //{"courtyard":{"plantFarm":{"id":1,"zid":21}},"rsn":"7cscppyopl"}

    public static void  main(String [] args) throws IOException {
//        Player one = new Player("ssqwerty", "123456", "2587430_ios", "8e63ad62fb17920353f555247a40c160");
//        Player one = new Player("cq147369", "123456");

        Player one = new Player("cq1473691", "123456", "2953184_ios", "9acd032355d503bc0cd5beb4941c44a6");
        one.setRsn("4afbhifchcf");
        one.act();
//        one.doBoss();

//        LuaValue value = LuaUtils.runLua("encryptTime.lua");
//        LuaValue value = LuaUtils.runLuaCommand("print 'hello,world!'");
//        LuaValue value2 = LuaUtils.runLuaCommand("print os.time()");
//        System.out.println(value);
//        LuaValue value3 = LuaUtils.ret("hello.lua");

//        String rsn = "4fcmahmcmmb";
//        for(int i = 20 ; i < 30; i++){
//            one.doBoss(11, i, rsn);
//        }
//        one.doMobai(rsn);
//        System.out.println(value3);

    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "appstoreQWNEW/1.0.2.1 CFNetwork/1197 Darwin/20.0.0");
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }
}
