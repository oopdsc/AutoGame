package game.player;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.service.PlayerData;

import java.util.Date;

import static game.service.GameRunner.sleep;
import static game.service.GameRunner.sleepInMillis;

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

        this.runAction3("{\"huodong2\":{\"hd962Start\":{\"num\":10}},\"rsn\":\"%s\"}");

        this.runAction3("{\"huodong2\":{\"hd962Start\":{\"num\":1}},\"rsn\":\"%s\"}");

        this.runAction3("{\"huodong2\":{\"hd962Start\":{\"num\":1}},\"rsn\":\"%s\"}");
    }

    /**
     * 河山
     */
    public void heshan(){
        for(int i = 1; i <= 10; i++){
            this.runAction3("{\"huodong2\":{\"hd684Play\":{\"num\":1}},\"rsn\":\"%s\"}");
        }
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

    /**
     * 吃鸡活动
     */
    public void chiji(){

        String body1 = "{\"huodong\":{\"hd282buy\":{\"id\":1}},\"rsn\":\"%s\"}";
        String body2 = "{\"huodong\":{\"hd282play\":{\"id\":271}},\"rsn\":\"%s\"}";
        //"{\"huodong\":{\"hd282play\":{\"id\":272}},\"rsn\":\"%s\"}";

        for (int i = 1; i <= 20; i++) {
            this.runAction3(body1);
            this.runAction3(body2);
        }
    }

    /**
     * 吃鸡活动奖励
     */
    public void chijiReward(){
        String body2 = "{\"huodong\":{\"hd282exchange\":{\"id\":5}},\"rsn\":\"%s\"}";
        //"{\"huodong\":{\"hd282exchange\":{\"id\":3}},\"rsn\":\"%s\"}";
        for(int i = 1; i <= 10; i++){
            this.runAction3(body2);
        }
    }

    /**
     * 杂技活动
     */
    public void zajiActive() {
        this.runAction3("{\"huodong\":{\"hd456buy\":{\"id\":1}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong\":{\"hd456play\":{\"id\":361}},\"rsn\":\"%s\"}");
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
        this.runAction3("{\"huodong\":{\"hd437exchange\":{\"id\":9}},\"rsn\":\"%s\"}");

    }

    /**
     * 赛马
     * @param hid
     */
    public void saima(int hid) {
        String resp = this.runAction3("{\"huodong\":{\"hd685Info\":[]},\"rsn\":\"%s\"}").getBody();

        Object clubid = JsonPath.read(resp, "$.a.mjdshuodong.user.my_club_id");

        this.runAction3("{\"huodong\":{\"hd685buy\":{\"num\":30,\"id\":1}},\"rsn\":\"%s\"}");
        runAction3("{\"huodong\":{\"hd685startGame\":{\"startGame\":" + new Date().getTime() / 1000 + "}},\"rsn\":\"%s\"}");
        sleep(60);
        runAction3("{\"huodong\":{\"hd685endGame\":{\"club_id\":"+clubid.toString()+",\"hid\":" + hid + ",\"daoju\":[{\"count\":30,\"kind\":11,\"id\":793}]}},\"rsn\":\"%s\"}");
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
        this.runAction3("{\"huodong2\":{\"hd966RwdBox\":{\"id\":1}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd966RwdBox\":{\"id\":2}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd966RwdBox\":{\"id\":3}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd966RwdRank\":[]},\"rsn\":\"%s\"}");

        for(int i = 1; i <= 8; i++){
            this.runAction3("{\"huodong2\":{\"hd966Exchange\":{\"id\":3}},\"rsn\":\"%s\"}");
        }
        for(int i = 1; i <= 50; i++){
            this.runAction3("{\"huodong2\":{\"hd966Exchange\":{\"id\":9}},\"rsn\":\"%s\"}");
        }

    }

    public void saima(){
        this.runAction3("{\"huodong\":{\"hd685createClub\":{\"name\":\""+rd.nextInt(7) + "2" + rd.nextInt(8) + "3" + rd.nextInt(9) +"\",\"rand\":0}},\"rsn\":\"%s\"}");
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

    public void randomSaima(){
        this.runAction1("{\"huodong\":{\"hd685randJoy\":\"\"},\"rsn\":\"%s\"}");
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

}
