package game.player;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import game.command.BaseCommand;
import game.command.LeagueCommand;
import game.service.GameRunner;
import game.service.PlayerData;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static game.service.GameRunner.*;

public class BasePlayer {

    Logger logger = LoggerFactory.getLogger(BasePlayer.class);
    RestTemplate restTemplate = new RestTemplate();
    Configuration conf = Configuration.defaultConfiguration();
    Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
    Random r = new Random();

    public String baseUrl = "";

    public PlayerData data;

    HttpHeaders headers;

    Random rd = new Random();

    ExecutorService executor = Executors.newFixedThreadPool(8);

    public BasePlayer(PlayerData data) {
        this.data = data;
        headers = new HttpHeaders();
//        User-Agent: appstoreQWNEW/1.0.2.1 CFNetwork/1197 Darwin/20.0.0
        headers.set("User-Agent", "appstoreQWNEW/1.0.2.1 CFNetwork/1197 Darwin/20.0.0");
        headers.set("Content-Type", "application/x-www-form-urlencoded");
    }

    public void login() {

        GameRunner.sleepInMillis(rd.nextInt(1000));

        if (Objects.isNull(data.uid) || Objects.isNull(data.token)) {
            String body = "{\"rsn\":\"" + getRsn() + "\",\"login\":{\"loginAccount\":{\"platform\":\"qiangwanzdhgios\"," +
                    "\"openid\":\"" + data.openid + "\",\"openkey\":\"" + data.openkey + "\"}}}";

            ResponseEntity<String> response2 = this.executeSleep("http://sglyqw.commpad.cn/servers/s7.php?sevid=7&ver=V1.0.385&uid=&token=&platform=qiangwanzdhgios&lang=zh-cn", body, 1);

            body = response2.getBody();

            logger.debug(response2.getBody());

            try {
                String uid = JsonPath.parse(body).read("$.a.loginMod.loginAccount.uid", String.class);
                String token = JsonPath.parse(body).read("$.a.loginMod.loginAccount.token", String.class);
                this.data.uid = uid;
                this.data.token = token;
                this.baseUrl = "http://sglyqw.commpad.cn/servers/s7.php?sevid=7&ver=V1.0.385&uid=" + uid + "&token=" + token + "&platform=qiangwanzdhgios&lang=zh-cn";
            } catch (Exception ex) {
                logger.error("Login failed for {}", data.username);
            }
        } else {
            this.baseUrl = "http://sglyqw.commpad.cn/servers/s7.php?sevid=7&ver=V1.0.385&uid=" + data.uid + "&token=" + data.token + "&platform=qiangwanzdhgios&lang=zh-cn";
        }


    }

    public String getAllinfo() {
        return this.runAction3NoLog("{\"rsn\":\"%s\",\"guide\":{\"login\":{\"platform\":\"qiangwanzdhgios\",\"ug\":\"\"}}}").getBody();
    }


    public void silu() {

//        if(!"ssqwerty".equals(this.data.username)){
            String body = "{\"silkroad\":{\"rootPlay\":{\"gid\":" + data.silu + "}},\"rsn\":\"" + getRsn() + "\"}";
            this.execute(baseUrl, body);
//        }


    }

    public void silu(int silu) {
        String body = "{\"silkroad\":{\"rootPlay\":{\"gid\":" + (data.silu +silu) + "}},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body);
    }

    public void taofa() {

        String body = "{\"rsn\":\"" + getRsn() + "\",\"taofa\":{\"rootPlay\":{\"gid\":" + data.getTaofa() + "}}}";
        this.execute(baseUrl, body);
    }

    public void buybook() {

        String body = "{\"club\":{\"shopBuy\":{\"id\":7}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= 10; i++) {
            this.runAction1(body);
        }

    }

    public void buyItem3() {
        String body1 = "{\"club\":{\"shopBuy\":{\"id\":12}},\"rsn\":\"%s\"}";
        String body2 = "{\"club\":{\"shopBuy\":{\"id\":13}},\"rsn\":\"%s\"}";
        String body3 = "{\"club\":{\"shopBuy\":{\"id\":14}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= data.buyItem3; i++) {
            this.runAction1(body1);
            this.runAction1(body2);
            this.runAction1(body3);
        }
    }

    public void buyItem2() {
        String body1 = "{\"club\":{\"shopBuy\":{\"id\":9}},\"rsn\":\"%s\"}";
        String body2 = "{\"club\":{\"shopBuy\":{\"id\":10}},\"rsn\":\"%s\"}";
        String body3 = "{\"club\":{\"shopBuy\":{\"id\":11}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= data.buyItem2; i++) {
            this.runAction1(body1);
            this.runAction1(body2);
            this.runAction1(body3);
        }
    }

    public void buyItem1() {
        String body1 = "{\"club\":{\"shopBuy\":{\"id\":4}},\"rsn\":\"%s\"}";
        String body2 = "{\"club\":{\"shopBuy\":{\"id\":5}},\"rsn\":\"%s\"}";
        String body3 = "{\"club\":{\"shopBuy\":{\"id\":6}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= data.buyItem1; i++) {
            this.runAction1(body1);
            this.runAction1(body2);
            this.runAction1(body3);
        }
    }

    public void buyItem0() {
        if (data.buyItem0) {
            String body1 = "{\"club\":{\"shopBuy\":{\"id\":16}},\"rsn\":\"" + getRsn() + "\"}";
            String body2 = "{\"club\":{\"shopBuy\":{\"id\":17}},\"rsn\":\"" + getRsn() + "\"}";

            this.execute(baseUrl, body1);
            this.execute(baseUrl, body2);
        }
    }

    public void buyXiongnu() {

        String body1 = "{\"wordboss\":{\"shopBuy\":{\"id\":1}},\"rsn\":\"%s\"}";
        String body2 = "{\"wordboss\":{\"shopBuy\":{\"id\":2}},\"rsn\":\"%s\"}";
        String body3 = "{\"wordboss\":{\"shopBuy\":{\"id\":3}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= data.buyXiongnu1; i++) {
            this.runAction1(body1);
            this.runAction1(body2);
            this.runAction1(body3);
        }

        if(data.buyXiongnu2){
            String body6 = "{\"wordboss\":{\"shopBuy\":{\"id\":6}},\"rsn\":\"" + getRsn() + "\"}";
            String body7 = "{\"wordboss\":{\"shopBuy\":{\"id\":7}},\"rsn\":\"%s\"}";
            for (int i = 1; i <= 2; i++) {
                this.runAction1(body6);
            }
            this.runAction1(body7);
        }

    }

    public void zhengwu() {

        String body = "{\"user\":{\"zhengWu\":{\"act\":1}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= 9; i++) {
            this.runAction1(body);
        }
    }

    public void zhengwu1() {

        String body = "{\"user\":{\"zhengWu\":{\"act\":2}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= 9; i++) {
            this.runAction1(body);
        }
    }

    public void zhengwu2() {

        String body = "{\"user\":{\"zhengWu\":{\"act\":2}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= 12; i++) {
            this.runAction1(body);
        }
    }

    //level up
    public void levelUp() {
        this.runAction3("{\"user\":{\"shengguan\":[]},\"rsn\":\"%s\"}");
    }

    public void school() {
        String body1 = "{\"rsn\":\"" + getRsn() + "\",\"school\":{\"allover\":[]}}";
        this.execute(baseUrl, body1);

//        GameRunner.sleep(2);

        String body2 = "{\"rsn\":\"" + getRsn() + "\",\"school\":{\"allstart\":[]}}";
        this.execute(baseUrl, body2);
    }

    public List<Integer> combine(Integer[] school, Integer[] noschool){
        List<Integer> lists = new LinkedList<>();
        if(school.length > 0){
            lists.addAll(Arrays.asList(school));
        }

        lists.addAll(Arrays.asList(PlayerData.commonSchool));
        if(noschool.length > 0){
            lists.removeAll(Arrays.asList(noschool));
        }

        return lists;
    }

    /**
     */
    public void schoolOne() {
        List<Integer> schools = this.combine(data.schoolHero, data.noschoolHero);

        String body1 = "{\"rsn\":\"" + getRsn() + "\",\"school\":{\"allover\":[]}}";
        this.execute(baseUrl, body1);

        if(schools.size() >= data.deskNum){
            for(int i = 1; i <= data.deskNum; i++){
                this.schoolOne(i, schools.get(i - 1));
            }
        }
    }

    /**
     *
     * @param id desk id, start from 1
     * @param hid hero id
     */
    public void schoolOne(int id, int hid) {
//        this.runAction2("{\"rsn\":\"%s\",\"school\":{\"over\":{\"id\":" + id + "}}}");
        this.runAction2("{\"rsn\":\"%s\",\"school\":{\"start\":{\"id\":" + id + ",\"hid\":" + hid + "}}}");
    }

    //升级老婆技能
    //{"wife":{"upskill":{"skillId":1033,"id":33}},"rsn":"3hwkehfksn"}

    //升级武将光环
    //{"hero":{"upghskill":{"sid":4,"id":35}},"rsn":"9zzstinbjmt"}
//    {"hero":{"upghskill":{"sid":6,"id":38}},"rsn":"7cpoycoccg"}


    public void useXoItems() {
        this.runAction1("{\"wife\":{\"weige\":[]},\"rsn\":\"%s\"}");
    }

    public void yjxo() {
//        String body1 = "{\"wife\":{\"yjxo\":[]},\"rsn\":\"" + getRsn() + "\"}";
//        this.execute(baseUrl, body1);

        String body1 = "{\"wife\":{\"yjxo\":[]},\"rsn\":\"%s\"}";
        this.runAction1(body1);
    }

    public void sjxo() {
        String body1 = "{\"wife\":{\"sjxo\":[]},\"rsn\":\"%s\"}";
        for (int i = 1; i <= 4; i++) {
            this.runAction1(body1);
        }
    }

    public void xiaohaosjxo() {
        for (int i = 1; i <= 3; i++) {
            String body1 = "{\"wife\":{\"sjxo\":[]},\"rsn\":\"%s\"}";
            this.runAction3(body1);
        }
    }

    public void xunfunRecover() {
        this.runAction1("{\"rsn\":\"%s\",\"xunfang\":{\"recover\":[]}}");
    }

    //one key
    public void xunfun() {
//        String body1 = "{\"rsn\":\"" + getRsn() + "\",\"xunfang\":{\"xunfan\":{\"type\":1}}}";
//        this.execute(baseUrl, body1);
        this.runAction1("{\"rsn\":\"%s\",\"xunfang\":{\"xunfan\":{\"type\":1}}}");
    }

    //single xunfun
    public void xunfun2() {
        for (int i = 1; i <= 4; i++) {
            this.runAction1("{\"rsn\":\"%s\",\"xunfang\":{\"xunfan\":{\"type\":0}}}");
        }
    }

    public void son() {
        String body1 = "{\"rsn\":\"%s\",\"son\":{\"allplay\":[]}}";
        this.runAction1(body1);

    }

    public void sonFood(int id) {
        String body1 = "{\"rsn\":\"%s\",\"son\":{\"onfood\":{\"id\":" + id + "}}}";
        this.runAction1(body1);
    }

    public void son2() {
        String body1 = "{\"rsn\":\"%s\",\"son\":{\"allplay\":[]}}";
        this.runAction0(body1);
    }

    public void sonFood2(int id) {
        String body1 = "{\"rsn\":\"%s\",\"son\":{\"onfood\":{\"id\":" + id + "}}}";
        this.runAction0(body1);
    }

    //{"rsn":"9rjnrjcjim","son":{"onfood":{"id":1198}}}
    //{"rsn":"8marojrjrie","son":{"allplay":[]}}



    public void laofan() {

        String body1 = "{\"rsn\":\"%s\",\"laofang\":{\"bianDa\":{\"type\":1}}}";
        for (int i = 1; i <= 10; i++) {
            this.runAction3(body1);
        }

    }

    public void chat(){
        this.runAction2("{\"rsn\":\"%s\",\"chat\":{\"sev\":{\"msg\":\"[a17]\"}}}");
    }

    public void buyHero(){
//        {"huodong":{"hd270Rwd":{"id":41}},"rsn":"7xxysocsvsy"}   //郭嘉
//        {"huodong":{"hd270Rwd":{"id":38}},"rsn":"9ririjbjbm"}     //诸葛亮
//        {\"huodong\":{\"hd272Rwd\":{\"id\":55}},\"rsn\":\"%s\"}
//        {"huodong":{"hd271Rwd":{"id":35}},"rsn":"9rbmcmssbm"}  //赵云
    }

    public void yardward() {
        String body1 = "{\"courtyard\":{\"getCourtyardDayRwd\":[]},\"rsn\":\"" + getRsn() + "\"}";

        this.execute(baseUrl, body1);
    }

    public void harvest() {
        String body1 = "{\"courtyard\":{\"harvest\":{\"type\":1}},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body1);
    }

    public void plant() {

        if (data.zid > 0) {
            for (int i = 1; i <= 8; i++) {
                String body1 = "{\"courtyard\":{\"plantFarm\":{\"id\":" + i + ",\"zid\":" + data.zid + "}},\"rsn\":\"" + getRsn() + "\"}";
                this.execute(baseUrl, body1);
            }
        }

    }

    //xiaohao mai zhongzi
    public void buyZhongzi() {
//        String body1 = "{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":5,\"id\":1}},\"rsn\":\"%s\"}";  //杨树种子
//         String body1 = "{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":5,\"id\":2}},\"rsn\":\"%s\"}";  //桦树种子
//        String body1 = "{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":"+data.zidCount+",\"id\":8}},\"rsn\":\"%s\"}";  //玉米
        if(data.zidbuy > 0 ){
            String body1 = "{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":" + data.zidCount + ",\"id\":" + data.zidbuy + "}},\"rsn\":\"%s\"}";  //玉米
            this.runAction3(body1);
        }

    }

    public void buyYumi(int num){
        this.runAction3("{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":"+num+",\"id\":8}},\"rsn\":\"%s\"}");
    }

    public void buyLittleTree(int num){
        this.runAction3("{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":"+num+",\"id\":1}},\"rsn\":\"%s\"}");
    }

    public void buyMiddleTree(int num){
        this.runAction3("{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":"+num+",\"id\":2}},\"rsn\":\"%s\"}");
    }

    public void buyLajiao(int num){
        this.runAction3("{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":"+num+",\"id\":13}},\"rsn\":\"%s\"}");
    }

    public void buyCong(int num){
        this.runAction3("{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":"+num+",\"id\":4}},\"rsn\":\"%s\"}");
    }

    public void buyHuangdou(int num){
        this.runAction3("{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":"+num+",\"id\":5}},\"rsn\":\"%s\"}");
    }

    public void buyQiezi(int num){
        this.runAction3("{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":"+num+",\"id\":9}},\"rsn\":\"%s\"}");
    }



    public void xiaohaoPlant() {
        if (data.zid > 0) {
            for (int i = 1; i <= 3; i++) {
                String body1 = "{\"courtyard\":{\"plantFarm\":{\"id\":" + i + ",\"zid\":" + data.zid + "}},\"rsn\":\"%s\"}";
                this.runAction3(body1);
            }
        }
    }

    //买蚯蚓
    public void buyQiuyin() {
//        {"courtyard":{"buyShop":{"type":2,"count":50,"id":3}},"rsn":"8jmevxomavi"}
        if (data.cooknum >= 10) {
            String body2 = "{\"courtyard\":{\"buyShop\":{\"type\":2,\"count\":50,\"id\":3}},\"rsn\":\"" + getRsn() + "\"}";
            this.execute(baseUrl, body2);
        }

    }

    //做菜

    /**
     * 耗时20秒/每次, 请设置好 sleep time.
     */
    public void cook() {
        if (data.cookid > 0) {
            String body2 = "{\"courtyard\":{\"cpScore\":{\"total\":3,\"num\":" + data.cooknum + ",\"cpid\":" + data.cookid + "}},\"rsn\":\"" + getRsn() + "\"}";
            this.runAction4(body2);

            body2 = "{\"courtyard\":{\"cpScore\":{\"total\":6,\"num\":" + data.cooknum + ",\"cpid\":" + data.cookid + "}},\"rsn\":\"" + getRsn() + "\"}";
            this.runAction4(body2);

            body2 = "{\"courtyard\":{\"madeMenu\":{\"id\":3,\"num\":" + data.cooknum + ",\"cpid\":" + data.cookid + "}},\"rsn\":\"" + getRsn() + "\"}";
            this.runAction2(body2);
        }
    }

    public void cookOne() {
//        int num = 1;
//        int cookid = 207;
        if (data.cookid > 0) {
            String body2 = "{\"courtyard\":{\"cpScore\":{\"total\":3,\"num\":" + data.cooknum + ",\"cpid\":" + data.cookid + "}},\"rsn\":\"" + getRsn() + "\"}";
            this.runAction4(body2);

            body2 = "{\"courtyard\":{\"cpScore\":{\"total\":6,\"num\":" + data.cooknum  + ",\"cpid\":" + data.cookid + "}},\"rsn\":\"" + getRsn() + "\"}";
            this.runAction4(body2);

            body2 = "{\"courtyard\":{\"madeMenu\":{\"id\":3,\"num\":" + data.cooknum  + ",\"cpid\":" + data.cookid + "}},\"rsn\":\"" + getRsn() + "\"}";
            this.runAction2(body2);
        }
    }

    //礼包
    //{"rsn":"3zzphskkspf","recode":{"exchange":{"key":"c0084cb7"}}}

    public void qinmi11() {
        this.runAction0("{\"wife\":{\"reward\":{\"count\":1,\"id\":"+ this.data.wifeId+",\"itemId\":91}},\"rsn\":\"%s\"}");
    }

    public void qinmi12() {
        this.runAction0("{\"wife\":{\"reward\":{\"count\":1,\"id\":"+ this.data.wifeId+",\"itemId\":92}},\"rsn\":\"%s\"}");
    }

    public void qinmi13() {
        this.runAction0("{\"rsn\":\"%s\",\"item\":{\"useitem\":{\"id\":106,\"count\":1}}}");
    }

    public void qinmibao() {
        String body2 = "{\"rsn\":\"%s\",\"item\":{\"useitem\":{\"id\":106,\"count\":1}}}";
        this.runAction3(body2);
    }

    public void buySchool(){
        this.runAction1("{\"rsn\":\"%s\",\"school\":{\"buydesk\":[]}}");
    }

    //酒店的卷轴残卷
    public void shopCanjuan() {
        if (data.shopnum > 0) {
            for (int i = 1; i <= data.shopnum; i++) {
                this.runAction1("{\"boite\":{\"shopChange\":{\"id\":10}},\"rsn\":\"%s\"}");
            }
            for(int i = 2; i <= 9; i++){
                this.runAction1("{\"boite\":{\"shopChange\":{\"id\":"+i+"}},\"rsn\":\"%s\"}");
            }
        }

    }

    //木兰围场
    public void hunt() {

        String body2 = "{\"rsn\":\"" + getRsn() + "\",\"paddock\":{\"comePaddock\":[]}}";
        this.execute(baseUrl, body2);
        sleepInMillis(100);

        body2 = "{\"rsn\":\"" + getRsn() + "\",\"paddock\":{\"enter\":[]}}";
        this.execute(baseUrl, body2);
        sleepInMillis(100);


        for (int i = 0; i < data.hunt.length; i++) {
            if (data.hunt[i] != 0) {

                body2 = "{\"rsn\":\"" + getRsn() + "\",\"paddock\":{\"probe\":[]}}";
                this.execute(baseUrl, body2);

                sleepInMillis(100);

                String body1 = "{\"rsn\":\"" + getRsn() + "\",\"paddock\":{\"play\":{\"hid\":" + data.hunt[i] + "}}}";
                this.execute(baseUrl, body1);
                sleepInMillis(100);
            }
        }

        for (int i = 1; i <= 11; i++) {
            body2 = "{\"rsn\":\"" + getRsn() + "\",\"paddock\":{\"get_hp_rwd\":{\"id\":" + i + "}}}";
            this.execute(baseUrl, body2);
        }

    }


    //挑战
    //{"yamen":{"tiaozhan":{"id":79858,"hid":9,"fuid":7009025}},"rsn":"8aermovjmm"}
    //普通衙门
    public void yamen3() {
        try {
            this.runAction3("{\"yamen\":{\"yamen\":[]},\"rsn\":\"%s\"}");
            ResponseEntity<String> resp = this.runAction3("{\"yamen\":{\"pizun\":[]},\"rsn\":\"%s\"}");
            this.interanlYamen(resp);
        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }



    public void interanlYamen(ResponseEntity<String> resp) {
        int index = 1;
        int shopTime = 0;

        logger.info(resp.getBody());
        Object fstate = JsonPath.parse(resp.getBody()).read("$.a.yamen.fight.fstate");

        while (!"0".equals(fstate.toString())) {

            DocumentContext dc = JsonPath.parse(resp.getBody());
            int fherosnum = dc.read("$.a.yamen.fight.fheros.length()");

            if(data.yamenShop || shopTime == 0){
                shopTime++;
                String shop = "$.a.yamen.fight.shop[0].id";
                Object shopid = dc.read(shop);
                this.runAction3("{\"yamen\":{\"seladd\":{\"id\":" + Integer.valueOf(shopid.toString()) + "}},\"rsn\":\"%s\"}");
            }

            int hid = 0;
            int senior = 0;
            for (int i = 0; i < fherosnum; i++) {
                Object tsenior = dc.read("$.a.yamen.fight.fheros[" + i + "].senior");
                int isenior = Integer.valueOf(tsenior.toString()).intValue();
                if (senior > isenior || senior == 0) {
                    Object tid = dc.read("$.a.yamen.fight.fheros["+i+"].id");
                    hid = Integer.valueOf(tid.toString()).intValue();
                    senior = isenior;
                }
            }

            resp = this.runAction3("{\"yamen\":{\"fight\":{\"id\":" + hid + "}},\"rsn\":\"%s\"}");
            index++;
            fstate = JsonPath.parse(resp.getBody()).read("$.a.yamen.fight.fstate");

            if ("2".equals(fstate.toString())) {
                GameRunner.sleep(1);
                resp = this.runAction3("{\"yamen\":{\"getrwd\":[]},\"rsn\":\"%s\"}");
                fstate = JsonPath.parse(resp.getBody()).read("$.a.yamen.fight.fstate");
            }
        }

    }

    //一键衙门
    public void yamen() {

        String body0 = "{\"yamen\":{\"yamen\":[]},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body0);

        String body1 = "{\"yamen\":{\"pizun\":[]},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body1);

        sleep(3);

        String body2 = "{\"yamen\":{\"oneKeyPlay\":[]},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body2);
    }

    //盟里的建筑
    public void householdMake() {

        if (data.housemake) {
            //zhili
            this.runAction3(BaseCommand.houseMake(6, 55));

            //meili
            this.runAction3(BaseCommand.houseMake(2, 58));
        }

        //五虎建城门
        for(int i = 33; i <= 37; i++){
            this.runAction3(BaseCommand.houseMake(12, i));
        }
        for(int i = 38; i <= 41; i++){
            this.runAction3(BaseCommand.houseMake(11, i));
        }
    }

    public void openboss() {
        if (data.openboss) {
            for (int i = 1; i <= 13; i++) {
                this.runAction3("{\"club\":{\"clubBossOpen\":{\"cbid\":" + i + ",\"type\":2}},\"rsn\":\"%s\"}");
            }
        }

    }

    /**
     * 联盟副本BOSS
     */
    public void hitboss() {
        if (data.hitBoss > 0) {
            for (int hid : data.heroid) {
                this.runAction3(BaseCommand.hitClubBoss(data.hitBoss, hid));
            }
        }
    }

    /**
     *
     */
    public void mengzhan() {
        LocalDate ld = LocalDate.now();
        int day = ld.getDayOfMonth() / 2;
        if (day < data.mzid.length) {
            this.runAction2(BaseCommand.mengzhan(data.mzid[day]));
        }
    }

    public void taskReward() {
//        {"daily":{"gettask":{"id":3}},"rsn":"9rjmcbrtrt"}
        int[] task = {3, 4, 5, 6, 10, 11, 12, 13, 14, 15, 17, 18, 20, 21};
        for (int i = 0; i < task.length; i++) {
            String body = "{\"daily\":{\"gettask\":{\"id\":" + task[i] + "}},\"rsn\":\"" + getRsn() + "\"}";
            this.execute(baseUrl, body);
        }
        //{"daily":{"getrwd":{"id":1}},"rsn":"7csyvdcocy"}
        for (int i = 1; i <= 5; i++) {
            String body = "{\"daily\":{\"getrwd\":{\"id\":" + i + "}},\"rsn\":\"" + getRsn() + "\"}";
            this.execute(baseUrl, body);
        }
    }

    public void weekYuanBaoReward() {
        this.runAction3("{\"huodong\":{\"hd201Rwd\":[]},\"rsn\":\"%s\"}");
    }

    public void weekLoginReward() {
        this.runAction3("{\"huodong\":{\"hd208Rwd\":[]},\"rsn\":\"%s\"}");
    }

    public void kuafuReward() {
        this.runAction3("{\"huodong\":{\"hd314Get\":[]},\"rsn\":\"%s\"}");
    }

    public void kuafuReward2() {
        this.runAction3("{\"huodong2\":{\"hd954GetSevRwd\":[]},\"rsn\":\"%s\"}");
    }

    public void qinmiRiceReward() {
        this.runAction3("{\"huodong\":{\"hd226Rwd\":[]},\"rsn\":\"%s\"}");
    }



    public void mengzhanReward() {
        String body = "{\"club\":{\"kuaPKrwdget\":{\"id\":1}},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body);
    }

    public void jingying() {
        String body = "{\"user\":{\"jingYingAll\":[]},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body);
    }

    public void gold() {

        for (int i = 1; i <= 3; i++) {
            String body = "{\"rsn\":\"" + getRsn() + "\",\"ranking\":{\"mobai\":{\"type\":" + i + "}}}";
            this.execute(baseUrl, body);
        }

//        快活帝 - 联盟亲密
        String body = "{\"rsn\":\"%s\",\"huanggong\":{\"qingAn\":{\"type\":0,\"chenghao\":15,\"fuid\":7006984}}}";

        //精诚帝 - 联盟经验
//        String body = "{\"rsn\":\"%s\",\"huanggong\":{\"qingAn\":{\"type\":0,\"chenghao\":5,\"fuid\":7006984}}}";
        this.runAction2(body);
    }

    public void gold2() {
        String body = "{\"rsn\":\"" + getRsn() + "\",\"chenghao\":{\"wyrwd\":[]}}";
        this.execute(baseUrl, body);
    }

    public void mobaiZJ() {
        this.runAction3("{\"rsn\":\"%s\",\"ranking\":{\"mobai\":{\"type\":4}}}");
        this.runAction3("{\"rsn\":\"%s\",\"ranking\":{\"mobai\":{\"type\":5}}}");
        this.runAction3("{\"rsn\":\"%s\",\"ranking\":{\"heroMobai\":[]}}");
    }


    /**
     * 中午12点的匈奴
     */
    public void menggu() {
        this.runAction1("{\"wordboss\":{\"goFightmg\":[]},\"rsn\":\"%s\"}");

        for (int hid : data.mengguid) {
            if (hid > 0) {
                this.runAction1(BaseCommand.hitmenggu(hid));
            }
        }
    }

    public void leagueBuild(){
        String resp = this.runAction2(LeagueCommand.startBuild).getBody();
        DocumentContext dc = JsonPath.using(conf2).parse(resp);

        Integer buildNum = dc.read("$.a.league.buildInfo.num");
        if(buildNum.intValue() < 5){
            List<Map<String, Object>> events = dc.read("$.a.league.buildList");
            if (Objects.isNull(events) || events.size() == 0) {
            } else {
                int[] levels = new int[4];
                for (int i = 0; i < 3; i++) {
                    Integer id = Integer.valueOf(events.get(i).get("id").toString());
                    Integer level = Integer.valueOf(events.get(i).get("level").toString());
                    levels[id] = level;
                }
                int maxId = 1;
                int maxLv = levels[maxId];
                if (levels[2] > maxLv) {
                    maxId = 2;
                    maxLv = levels[2];
                }
                if (levels[3] > maxLv) {
                    maxId = 3;
                }
                this.runActionSleep(LeagueCommand.dailyBuild(maxId), r.nextInt(2) + 2).getBody();
            }
        }
    }

    public void startFuben(){
        this.runAction2(LeagueCommand.fuben);
        if(this.data.fubenId1.length == 5){
            this.runAction2(LeagueCommand.dispatchFuben(1, this.data.uid, this.data.fubenId1));
        }

        if(this.data.fubenId2.length == 5){
            this.runAction2(LeagueCommand.dispatchFuben(2, this.data.uid, this.data.fubenId2));
        }
    }

    public void overFuben(){
        String fuben = this.runAction2(LeagueCommand.fuben).getBody();

        if(this.data.fubenId1.length == 5){
            this.overFubenId(fuben, 1);
        }

        if(this.data.fubenId2.length == 5){
            this.overFubenId(fuben, 2);
        }
    }

    public void overFubenId(String fuben, int fubenId){
        DocumentContext dc = JsonPath.using(conf2).parse(fuben);
        List<Map<String, Object>> events = dc.read("$.a.league.fbList["+(fubenId - 1)+"].events");
        if(Objects.isNull(events) || events.size() == 0){
        }else{
            for(int i = 0; i < events.size(); i++) {
                Integer id = Integer.valueOf(events.get(i).get("id").toString());
                this.runAction2(LeagueCommand.fubenEvent(1, id));
            }
        }
        this.runAction2(LeagueCommand.fubenOver(fubenId));
    }

    /**
     * 晚上8点的匈奴
     */
    public void hitXiongnu() {
        for (int hid : data.geerdan) {
            if (hid > 0) {
                this.runAction1(BaseCommand.hitgeerdan(hid));
            }
        }
    }

    public void xunfangtili() {

        String body = "{\"user\":{\"adok\":{\"label\":\"xunfangtili\"}},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body);

    }

    public void openYanwu() {
        if (data.isYanwu) {
            String all = this.getAllinfo();

            //if 被踢了，需要先接收被踢消息，否则不能开始新的演武
            DocumentContext dc = JsonPath.parse(all);
            String ruid = dc.read("$.a.hanlin.info.ruid").toString();
            if (ruid.length() > 1) {
                this.runAction3("{\"rsn\":\"%s\",\"hanlin\":{\"comein\":{\"fuid\":" + ruid + "}}}");
            }

            this.runAction3("{\"rsn\":\"%s\",\"hanlin\":{\"opendesk\":{\"num\":1}}}");
        }
    }

    public void joinYanwu() {

        try{
            String all = this.getAllinfo();

            //if 被踢了，需要先接收被踢消息，否则不能开始新的演武
            DocumentContext dc = JsonPath.parse(all);
            String ruid = dc.read("$.a.hanlin.info.ruid").toString();
            if (ruid.length() > 1) {
                this.runAction3("{\"rsn\":\"%s\",\"hanlin\":{\"comein\":{\"fuid\":" + ruid + "}}}");
            }

            if (!StringUtils.isEmpty(data.yanwuFuId)) {
                this.runAction3("{\"rsn\":\"%s\",\"hanlin\":{\"sitdown\":{\"rid\":" + data.yanwuRid + ",\"fuid\":" + data.yanwuFuId + "}}}");
            }
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }

    }

    public void xiaohaoYard() {
        this.harvest();
        this.runAction3("{\"courtyard\":{\"exchange\":{\"num\":2600,\"id\":1}},\"rsn\":\"%s\"}");
        this.runAction3("{\"courtyard\":{\"upgradeCourtyard\":[]},\"rsn\":\"%s\"}");
        this.runAction3("{\"courtyard\":{\"openFarm\":{\"id\":3}},\"rsn\":\"%s\"}");
    }

    //打boss
    public void pvb(int hid){
        this.runAction3("{\"user\":{\"pvb\":{\"id\":"+hid+"}},\"rsn\":\"%s\"}");
    }

    //一键过关
    public void bpvb(){
        this.runAction3("{\"user\":{\"bpve\":[]},\"rsn\":\"%s\"}");
    }


    public void son_keju(int sonId){
        this.runAction3("{\"rsn\":\"%s\",\"son\":{\"keju\":{\"id\":"+sonId+"}}}");
    }

    public void son_name(int sonId){
        this.runAction3("{\"rsn\":\"%s\",\"son\":{\"sonname\":{\"name\":\"1234\",\"id\":"+sonId+"}}}");
    }

    public void son_allDone() {
        if(data.sonFood){
            String all = this.getAllinfo();
            DocumentContext dc = JsonPath.parse(all);
            List<Object> sons = dc.read("$.a.son.sonList[?(@.state==3)].id");
            if (sons.size() > 0) {
                sons.stream().forEach( son -> {
                    this.son_keju(Integer.valueOf(son.toString()).intValue());
                });
            }

            List<Object> sons2 = dc.read("$.a.son.sonList[?(@.state==0)].id");
            if (sons2.size() > 0) {
                sons2.stream().forEach( son -> {
                    this.son_name(Integer.valueOf(son.toString()).intValue());
                });
            }
        }
    }

    public void baseReward(String rwdId){
        this.runAction1("{\"huodong\":{\"hd"+rwdId+"Rwd\":[]},\"rsn\":\"%s\"}");
    }


    public ResponseEntity<String> execute(String url, String body) {
        return executeSleep(url, body, rd.nextInt(4) + 1);
    }

    public ResponseEntity<String> runAction0(String action) {
        return this.runActionNoSleep(action);
    }

    public ResponseEntity<String> runAction1(String action) {
        return this.runActionSleep(action, 1);
    }

    public ResponseEntity<String> runAction2(String action) {
        return this.runActionSleep(action, 2);
    }

    public ResponseEntity<String> runAction3(String action) {
        return this.runActionSleep(action, 3);
    }

    public ResponseEntity<String> runAction3NoLog(String action) {
        return this.runActionSleepNoLog(action, 3);
    }


    public ResponseEntity<String> runAction4(String action) {
        return this.runActionSleep(action, 4);
    }

    public ResponseEntity<String> runActionSleep(String action, int second) {
        String body = String.format(action, getRsn());
        ResponseEntity<String> resp = this.executeSleep(this.baseUrl, body, second);
        return resp;
    }

    public ResponseEntity<String> runActionSleepNoLog(String action, int second) {
        String body = String.format(action, getRsn());
        ResponseEntity<String> resp = this.executeSleepNoLog(this.baseUrl, body, second);
        return resp;
    }

    public ResponseEntity<String> runActionNoSleep(String action) {
        String body = String.format(action, getRsn());
        ResponseEntity<String> resp = this.executeNoSleep(this.baseUrl, body);
        return resp;
    }

    public ResponseEntity<String> executeNoSleep(String url, String body) {
        HttpEntity entity = new HttpEntity(body, getHttpHeaders());
        logger.info(this.data.username + ":" + body);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        logger.debug(response.getBody());
        return response;
    }

    public ResponseEntity<String> executeSleep(String url, String body, int second) {
        HttpEntity entity = new HttpEntity(body, getHttpHeaders());
        logger.info(this.data.username + ":" + body);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        logger.debug(response.getBody());
        sleep(second);
        return response;
    }

    public ResponseEntity<String> executeSleepNoLog(String url, String body, int second) {
        HttpEntity entity = new HttpEntity(body, getHttpHeaders());
        logger.info(this.data.username + ":" + body);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        sleep(second);
        return response;
    }


    private HttpHeaders getHttpHeaders() {
        return this.headers;
    }

    public PlayerData getData() {
        return data;
    }

    public void setData(PlayerData data) {
        this.data = data;
    }
}
