package game.player;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.runner.PlayerData;

import java.util.Date;

import static game.runner.GameRunner.sleep;
import static game.runner.GameRunner.sleepInMillis;

public class HuodongPlayer extends BasePlayer {
    public HuodongPlayer(PlayerData data) {
        super(data);
    }

    public HuodongPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }


    /**
     * 弹珠
     */
    public void danzhu(){
        this.runAction3("{\"huodong2\":{\"hd962Info\":[]},\"rsn\":\"%s\"}");

//        this.runAction3("{\"huodong2\":{\"hd962Start\":{\"num\":10}},\"rsn\":\"%s\"}");
        for(int i = 1; i <= 3; i++){
            this.runAction3("{\"huodong2\":{\"hd962Start\":{\"num\":1}},\"rsn\":\"%s\"}");
        }


//        this.runAction3("{\"huodong2\":{\"hd962Start\":{\"num\":1}},\"rsn\":\"%s\"}");
    }

    public void xiangqinyingwu(){
        this.runAction2("{\"huodong2\":{\"hd743Receive\":[]},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong2\":{\"hd743Choose\":{\"skinId\":636}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong2\":{\"hd743Play\":{\"count\":1,\"isCash\":0}},\"rsn\":\"%s\"}");
    }

    /**
     * 河山
     */
    public void heshan(){
        this.runAction3("{\"huodong2\":{\"hd684Play\":{\"num\":1}},\"rsn\":\"%s\"}");
    }

    public void heshan_create(){
        this.runAction1("{\"huodong2\":{\"hd684createTeam\":{\"name\":\""+rd.nextInt(20) + "9" + rd.nextInt(20) + "9" + rd.nextInt(9) +"\",\"rand\":1}},\"rsn\":\"%s\"}");
    }

    public void heshan_join(){
        this.runAction1("{\"huodong2\":{\"hd684randJoin\":\"\"},\"rsn\":\"%s\"}");
    }

    /**
     * 册封
     */
    public void cefeng(){
        this.runAction2("{\"huodong2\":{\"hd755Info\":[]},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong2\":{\"hd755Wife\":{\"id\":1}},\"rsn\":\"%s\"}");
        for (int n = 1; n <= 10; n++) {
            for (int i = 1; i <= 4; i++) {
                this.runAction1("{\"huodong2\":{\"hd755Play\":{\"type\":" + i + "}},\"rsn\":\"%s\"}");
            }
        }
    }

    public void zizhifanli(){
        this.runAction2("{\"huodong\":{\"hd715Rwd\":[]},\"rsn\":\"%s\"}");
    }

    public void lishanXunli_daily(){
        this.runAction2("{\"huodong2\":{\"hd708Task\":{\"id\":1}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong2\":{\"hd708Task\":{\"id\":2}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong2\":{\"hd708Task\":{\"id\":3}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong2\":{\"hd708Task\":{\"id\":4}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong2\":{\"hd708Task\":{\"id\":7}},\"rsn\":\"%s\"}");
    }

    public void lishanXunli_xunli(){
        this.runAction2("{\"huodong2\":{\"hd708Play\":{\"num\":10}},\"rsn\":\"%s\"}");
    }


    /**
     * 吃鸡活动
     */
    public void chiji(){

        String body1 = "{\"huodong\":{\"hd282buy\":{\"id\":1}},\"rsn\":\"%s\"}";
        String body2 = "{\"huodong\":{\"hd282play\":{\"id\":271}},\"rsn\":\"%s\"}";
        //"{\"huodong\":{\"hd282play\":{\"id\":272}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= 20; i++) {
            this.runAction2(body2);
//            this.runAction2(body2);
            this.runAction2(body1);
        }
    }

    /**
     * 吃鸡活动奖励
     */
    public void chijiReward(){
        String body2 = "{\"huodong\":{\"hd282exchange\":{\"id\":5}},\"rsn\":\"%s\"}";
        //"{\"huodong\":{\"hd282exchange\":{\"id\":3}},\"rsn\":\"%s\"}";
        for(int i = 1; i <= 4; i++){
            this.runAction2(body2);
        }
    }

    public void yuebing(){
//        {"huodong2":{"hd990Info":[]},"rsn":"9zssbbbjnbm"}
//        {"huodong2":{"hd990Clear":{"a1":0,"a2":3,"b1":0,"b":2,"a":1,"b2":4}},"rsn":"3hhhefssfen"}
//    {"huodong2":{"hd990Clear":{"a1":2,"a2":1,"b1":1,"b":2,"a":3,"b2":1}},"rsn":"5jffaaavvyh"}
//{"huodong2":{"hd990Clear":{"a1":6,"a2":2,"b1":5,"b":4,"a":3,"b2":2}},"rsn":"3hhhefssfzn"}


    }

    /**
     * 杂技活动
     */
    public void zajiActive() {
        for (int i = 1; i <= 10; i++) {
            this.runAction2("{\"huodong\":{\"hd456buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            this.runAction2("{\"huodong\":{\"hd456play\":{\"id\":361}},\"rsn\":\"%s\"}");
        }

    }

    public void buyHighZaji(){
        for(int i = 1; i <= 10; i++){
            this.runAction3("{\"huodong\":{\"hd456buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            this.runAction2("{\"huodong\":{\"hd456buy\":{\"id\":2}},\"rsn\":\"%s\"}");
        }
    }

    public void buyHighZhongshu(){
        for(int i = 1; i <= 10; i++){
            this.runAction2("{\"huodong\":{\"hd437buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            this.runAction2("{\"huodong\":{\"hd437buy\":{\"id\":2}},\"rsn\":\"%s\"}");
        }
    }
    public void useHighZhongshu(){
//
        for(int i = 1; i <= 30; i++){
            this.runAction2("{\"huodong\":{\"hd437buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            this.runAction2("{\"huodong\":{\"hd437buy\":{\"id\":2}},\"rsn\":\"%s\"}");
        }
        this.runAction2("{\"huodong\":{\"hd437buy\":{\"id\":3}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong\":{\"hd437buy\":{\"id\":3}},\"rsn\":\"%s\"}");
    }



    /**
     * 杂技活动奖励
     */
    public void zajiReward() {

        this.runAction3("{\"huodong\":{\"hd456exchange\":{\"id\":9}},\"rsn\":\"%s\"}");
    }


    //种树活动
    //{"huodong":{"hd437buy":{"id":1}},"rsn":"8makkraxkxm"}
//    {"huodong":{"hd437play":{"id":351}},"rsn":"3hreekswhw"}

    /**
     *种树活动
     */
    public void zhongshuhuodong() {
        for (int i = 1; i <= 10; i++) {
            this.runAction3("{\"huodong\":{\"hd437buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            this.runAction3("{\"huodong\":{\"hd437play\":{\"id\":351}},\"rsn\":\"%s\"}");
        }

    }

    /**
     * 种树活动奖励
     */
    public void zhongshuReward() {
        this.runAction2("{\"huodong\":{\"hd437exchange\":{\"id\":9}},\"rsn\":\"%s\"}");

    }

    /**
     * 赛马
     * @param hid
     */
    public void saima_play(int hid) {
        String resp = this.runAction3("{\"huodong\":{\"hd685Info\":[]},\"rsn\":\"%s\"}").getBody();

        Object clubid = JsonPath.read(resp, "$.a.mjdshuodong.user.my_club_id");

        this.runAction3("{\"huodong\":{\"hd685buy\":{\"num\":30,\"id\":1}},\"rsn\":\"%s\"}");
        runAction3("{\"huodong\":{\"hd685startGame\":{\"startGame\":" + new Date().getTime() / 1000 + "}},\"rsn\":\"%s\"}");
        sleep(60);
        runAction3("{\"huodong\":{\"hd685endGame\":{\"club_id\":"+clubid.toString()+",\"hid\":" + hid + ",\"daoju\":[{\"count\":30,\"kind\":11,\"id\":793}]}},\"rsn\":\"%s\"}");
    }

    public void saima_reward(){
        this.runAction1("{\"huodong\":{\"hd685exchange\":{\"num\":1,\"id\":4}},\"rsn\":\"%s\"}");
        for(int i = 1; i <= 6; i++){
            this.runAction1("{\"huodong\":{\"hd685exchange\":{\"num\":1,\"id\":6}},\"rsn\":\"%s\"}");
        }
    }

    /**
     * 巢穴活动
     */
    public void caoxueAll(){
        try {
            String roll = this.runAction3("{\"huodong2\":{\"hd966Info\":[]},\"rsn\":\"%s\"}").getBody();
            DocumentContext dc = JsonPath.parse(roll);

            String power = dc.read("$.a.richman2.my.power").toString();

            for (int i = 1; i <= Integer.valueOf(power).intValue(); i++) {
//            for (int i = 1; i <= 5; i++) {
                this.caoxueActive();
                sleepInMillis(200);
            }
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }

    }

    public void caoxueActive(){

        String roll = this.runAction3("{\"huodong2\":{\"hd966Roll\":[]},\"rsn\":\"%s\"}").getBody();
        DocumentContext dc = JsonPath.parse(roll);

        String resid = dc.read("$.a.richman2.res[0].id").toString();

        if("5".equals(resid)){
            this.runAction3("{\"huodong2\":{\"hd966DealEvent\":{\"id\":1}},\"rsn\":\"%s\"}");
        }else if("9".equals(resid)){
            this.runAction3("{\"huodong2\":{\"hd966DealEvent\":{\"id\":1}},\"rsn\":\"%s\"}");
        }else if("12".equals(resid)){
            String attid = dc.read("$.a.richman2.res[0].num1").toString();
            this.runAction3("{\"huodong2\":{\"hd966Attack\":{\"flag\":0,\"id\":"+Integer.valueOf(attid).intValue()+"}},\"rsn\":\"%s\"}");
        }else if("8".equals(resid)){
            String nowid = dc.read("$.a.richman2.my.now").toString();
            this.runAction3("{\"huodong2\":{\"hd966OpenBox\":{\"param\":0,\"id\":"+Integer.valueOf(nowid).intValue()+"}},\"rsn\":\"%s\"}");
        }

//        roll
//        {"huodong2":{"hd966Roll":[]},"rsn":"1teiauwibk"}
//        a.richman2.res.num1
//        a.richman2.res.id=12
//        {"huodong2":{"hd966Attack":{"flag":0,"id":10008}},"rsn":"3zzhznfpknp"}

//        heshui
//        a.richman2.res.id=5
//         {"huodong2":{"hd966DealEvent":{"id":1}},"rsn":"9zzrzcszrmi"}

//        box
        //        a.richman2.res.id=8
//        a.richman2.my.now = id
//        {"huodong2":{"hd966OpenBox":{"param":0,"id":38}},"rsn":"5jjwjeffwff"}
//        a.richman2.res.id=9
//        {"huodong2":{"hd966DealEvent":{"id":1}},"rsn":"1qqtqrbuuiu"}
    }

    public void caoxueReward(){

        String resp = this.runAction3NoLog("{\"huodong2\":{\"hd966Info\":[]},\"rsn\":\"%s\"}").getBody();

        DocumentContext dc = JsonPath.parse(resp);
        Object retain = dc.read("$.a.richman2.retain.score");
        int retainInt = Integer.valueOf(retain.toString());
        if(retainInt > 0){

            this.runAction2("{\"huodong2\":{\"hd966RwdBox\":{\"id\":1}},\"rsn\":\"%s\"}");
            this.runAction2("{\"huodong2\":{\"hd966RwdBox\":{\"id\":2}},\"rsn\":\"%s\"}");
            this.runAction2("{\"huodong2\":{\"hd966RwdBox\":{\"id\":3}},\"rsn\":\"%s\"}");
            this.runAction2("{\"huodong2\":{\"hd966RwdRank\":[]},\"rsn\":\"%s\"}");

//            int tim3 = retainInt / 625 > 8 ? 8 : retainInt / 625;
            for(int i = 1; i <= 8; i++){
                this.runAction2("{\"huodong2\":{\"hd966Exchange\":{\"id\":3}},\"rsn\":\"%s\"}");
            }
//            retainInt = retainInt - 625 * tim3;
//            if(retainInt > 0){
//                int tim9 = retainInt / 50 > 100 ? 100 : retainInt / 50;
//                for(int i = 1; i <= tim9 ; i++){
//                    this.runAction2("{\"huodong2\":{\"hd966Exchange\":{\"id\":9}},\"rsn\":\"%s\"}");
//                }
//            }

        }
    }

    public void saima_Create(){
        this.runAction3("{\"huodong\":{\"hd685createClub\":{\"name\":\"X"+rd.nextInt(7) + "2" + rd.nextInt(8) + "4" + rd.nextInt(9) +"\",\"rand\":1}},\"rsn\":\"%s\"}");
    }

    //7008920
    //7008921
    //7008922
    //7008923
    //7008924
    //7008925
    //7008926
    //7008927
    //7008928
    //7008929
    public void joinSaima(String cid){
        this.runAction3("{\"huodong\":{\"hd685joinForId\":{\"club_id\":"+cid+"}},\"rsn\":\"%s\"}");
    }

    public void saima_randJoin(){
        this.runAction3("{\"huodong\":{\"hd685randJoy\":\"\"},\"rsn\":\"%s\"}");
    }

    public void saimaBuy(){

    }

    public void cangjian(){
        this.runAction1("{\"huodong2\":{\"hd776Hero\":{\"id\":1}},\"rsn\":\"%s\"}");

        for(int i = 1; i <= 10; i++){
            this.runAction1("{\"huodong2\":{\"hd776Play\":{\"type\":1}},\"rsn\":\"%s\"}");
            this.runAction1("{\"huodong2\":{\"hd776Play\":{\"type\":3}},\"rsn\":\"%s\"}");
            this.runAction1("{\"huodong2\":{\"hd776Play\":{\"type\":2}},\"rsn\":\"%s\"}");
            this.runAction1("{\"huodong2\":{\"hd776Play\":{\"type\":4}},\"rsn\":\"%s\"}");
        }
    }

    /**
     * 小号返利
     */
    public void xiaohaoFanli(){

        for(int i = 1; i <= 6; i++){
//            this.runAction2("{\"huodong\":{\"hd331Get\":[]},\"rsn\":\"%s\"}");
            this.runAction1("{\"huodong\":{\"hd331Rwd\":[]},\"rsn\":\"%s\"}");
            this.runAction1("{\"huodong\":{\"hd201Rwd\":[]},\"rsn\":\"%s\"}");
        }

    }


    public void wabao(){

        this.data.isYanwu = true;

//        this.openYanwu();
//
//        YamenPlayer yp = new YamenPlayer(this);
//        yp.chushi_One();
//        yp.chushi_One();

//        this.buySchool();
//        this.buySchool();

//        this.runAction2("{\"club\":{\"dayGongXian\":{\"dcid\":1}},\"rsn\":\"%s\"}");

        for(int i = 1; i <= 12; i++){
            this.runAction2("{\"huodong\":{\"hd296Task\":{\"id\":"+i+"}},\"rsn\":\"%s\"}");
        }

        for(int i = 1; i <= 20; i++){
            this.runAction3("{\"huodong\":{\"hd296Wa\":[]},\"rsn\":\"%s\"}");
        }
        this.runAction2("{\"huodong\":{\"hd296Rwd\":{\"id\":5}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong\":{\"hd296Rwd\":{\"id\":10}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong\":{\"hd296Rwd\":{\"id\":15}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong\":{\"hd296Rwd\":{\"id\":20}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong\":{\"hd296Rwd\":{\"id\":25}},\"rsn\":\"%s\"}");

        this.runAction2("{\"huodong\":{\"hd296Rwd\":{\"id\":26}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong\":{\"hd296Rwd\":{\"id\":27}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong\":{\"hd296Rwd\":{\"id\":28}},\"rsn\":\"%s\"}");
        this.runAction2("{\"huodong\":{\"hd296Rwd\":{\"id\":29}},\"rsn\":\"%s\"}");

//        for(int i = 1; i <= 6; i++){
//            this.runAction2("{\"huodong\":{\"hd201Rwd\":[]},\"rsn\":\"%s\"}");
//            this.runAction2("{\"huodong\":{\"hd331Rwd\":[]},\"rsn\":\"%s\"}");
//        }




    }

    public void reward_ganen(){
        for(int i = 1; i <= 7; i++) {
            if(i == 3){
                this.runAction3("{\"huodong2\":{\"hd997option\":{\"id\":" + i + ",\"itemid\":4}},\"rsn\":\"%s\"}");
            }else{
                this.runAction3("{\"huodong2\":{\"hd997option\":{\"id\":" + i + ",\"itemid\":1}},\"rsn\":\"%s\"}");
            }

            sleepInMillis(500);
            this.runAction3("{\"huodong2\":{\"hd997getSignRwd\":{\"id\":" + i + "}},\"rsn\":\"%s\"}");
        }
    }

    public void cuju(){
//        this.runAction2("{\"huodong2\":{\"hd874SelHero\":{\"heroidStr\":\"33,34,55,36,41,39\"}},\"rsn\":\"%s\"}");
//        this.runAction2("{\"huodong2\":{\"hd874Start\":[]},\"rsn\":\"%s\"}");
//        sleep(30);
//        this.runAction2("{\"huodong2\":{\"hd874Play\":{\"dienum\":5,\"type\":1,\"time\":30,\"iswin\":1,\"blood\":5}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
    }

    public void cujuReward(){
        for(int i = 1; i <= 5; i++){
            this.runAction2("{\"huodong2\":{\"hd874Rwd\":{\"type\":1,\"id\":"+i+"}},\"rsn\":\"%s\"}");
        }
    }

    public void longzhou(){
        String name = "";
        this.runAction2("{\"hd999\":{\"name\":{\"name\":\"A13457\"}},\"rsn\":\"%s\"}");
        this.runAction2("{\"hd999\":{\"rwdTask\":{\"id\":1}},\"rsn\":\"%s\"}");
        this.runAction2("{\"hd999\":{\"rwdTask\":{\"id\":3}},\"rsn\":\"%s\"}");
        this.runAction2("{\"hd999\":{\"rwdTask\":{\"id\":6}},\"rsn\":\"%s\"}");
        this.runAction2("{\"hd999\":{\"rwdTask\":{\"id\":7}},\"rsn\":\"%s\"}");
        for(int i = 1; i <= 8; i++){
            this.runAction2("{\"hd999\":{\"eat\":{\"num\":1,\"id\":42105}},\"rsn\":\"%s\"}");
        }

    }

    public void longzhu(){
//        this.runAction2("{\"hd988\":{\"info\":[]},\"rsn\":\"%s\"}");
        for(int i = 1; i <= 9; i++){
            this.runAction2("{\"huodong2\":{\"hd962Start\":{\"num\":1}},\"rsn\":\"%s\"}");
//            this.runAction2("{\"hd988\":{\"play\":{\"count\":1}},\"rsn\":\"%s\"}");
        }
//        this.runAction2("{\"hd988\":{\"play\":{\"count\":1}},\"rsn\":\"%s\"}");
//        this.runAction2("{\"hd988\":{\"play\":{\"count\":1}},\"rsn\":\"%s\"}");

    }

    public void longzhu2(){
        this.runAction2("{\"huodong2\":{\"hd962Info\":[]},\"rsn\":\"%s\"}");
        for(int i = 1; i <= 9; i++){
            this.runAction2("{\"huodong2\":{\"hd962Start\":{\"num\":1}},\"rsn\":\"%s\"}");
        }

    }
}
