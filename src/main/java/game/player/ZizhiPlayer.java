package game.player;

import com.jayway.jsonpath.JsonPath;
import game.service.GameRunner;
import game.service.PlayerData;

public class ZizhiPlayer extends BasePlayer {
    public ZizhiPlayer(PlayerData data) {
        super(data);
    }

    public ZizhiPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }

    public static int SID_5WULI = 5;
//    public static int SID_3WULI = 5;
//    public static int SID_5ZHILI = 5;

    public static int SID_5ZHILI_JiaRenTieJi = 128;
    public static int SID_7ZHILI_JiangWu = 1611;

    public void zizhiReward(){
        //School
        for(int i = 1 ; i <= 14; i++){
            this.runAction3("{\"huodong\":{\"hd211Rwd\":[]},\"rsn\":\"%s\"}");
        }

        //guoli
        for(int i = 1; i <= 6; i++){
            this.runAction3("{\"huodong\":{\"hd204Rwd\":[]},\"rsn\":\"%s\"}");
        }

        this.runAction3("{\"huodong\":{\"hd206Rwd\":[]},\"rsn\":\"%s\"}");
    }

    public void zizhiKuaReward(){
        this.runAction3("{{\"huodong\":{\"hd266Get\":[]},\"rsn\":\"%s\"}");
    }


    public void useJuanzhou() {

        //type 2 - batch ; 1 - single
        // sid - skill id
        //id - hero id

        //马云绿 - 将舞红妆
        //{"hero":{"upzzskill":{"type":2,"sid":1611,"num":30,"id":55}},"rsn":"7ycogsyxpvl"}
//        this.runAction3("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":1611,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");

        //马云绿 - 佳人铁骑
        //{"hero":{"upzzskill":{"type":1,"sid":128,"num":1,"id":55}},"rsn":"3ehkrhffnef"}
//        this.runAction3("{\"hero\":{\"upzzskill\":{\"type\":1,\"sid\":128,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
        //{"hero":{"upzzskill":{"type":2,"sid":1601,"num":1,"id":51}},"rsn":"7ycggccsgyg"}

        //马云绿 - 易筋经 5武力
//        this.runAction3("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":5,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");

        //张春华 - 冷血皇后 - 7政治
        this.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":169,\"num\":1,\"id\":66}},\"rsn\":\"%s\"}");
    }

    public void useBook(){
//        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":20,\"heroid\":55,\"id\":81}}}");
//        this.runAction3("{\"hero\":{\"upzzskill\":{\"type\":1,\"sid\":128,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
    }

    //升级技能
    public void skillup(){
        this.runAction3("{\"hero\":{\"uppkskill\":{\"sid\":1,\"id\":55}},\"rsn\":\"%s\"}");
        this.runAction3("{\"hero\":{\"uppkskill\":{\"sid\":2,\"id\":55}},\"rsn\":\"%s\"}");
    }


    public void useJuanzhou(int sid, int hid){
        this.runAction3("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":"+sid+",\"num\":1,\"id\":"+hid+"}},\"rsn\":\"%s\"}");
    }

    public void useJuanzhouSuccess(int sid, int hid){
        int success = 0;
        int time = 0;
        //超过十次退出，以免因为没有卷轴死循环
        while(success != 1 || time <= 10){
            String resp = this.runAction1("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":"+sid+",\"num\":1,\"id\":"+hid+"}},\"rsn\":\"%s\"}").getBody();
            //u.hero.onekey.success=1
            try{
                Object fstate = JsonPath.parse(resp).read("$.u.hero.onekey.success");
                success = Integer.valueOf(fstate.toString()).intValue();
            }catch(Exception e){
                //如果没有卷轴也认为失败
                success = 0;
            }

            time++;
        }

    }

    public void useBook(int sid, int hid){
        this.runAction1("{\"hero\":{\"upzzskill\":{\"type\":1,\"sid\":"+sid+",\"num\":1,\"id\":"+hid+"}},\"rsn\":\"%s\"}");
    }

    public void useBook0(int sid, int hid){
        this.runAction0("{\"hero\":{\"upzzskill\":{\"type\":1,\"sid\":"+sid+",\"num\":1,\"id\":"+hid+"}},\"rsn\":\"%s\"}");
    }

    public void useJuanzhou0(int sid, int hid){
        this.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":"+sid+",\"num\":1,\"id\":"+hid+"}},\"rsn\":\"%s\"}");
    }

    public void maYunlv7zhiJuanzhou(){
        this.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":127,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
    }

    public void maYunlv5zhiBook(){
        this.runAction0("{\"hero\":{\"upzzskill\":{\"type\":1,\"sid\":128,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
    }

    public void reward(){
        this.runAction3("{\"huodong\":{\"hd266Get\":[]},\"rsn\":\"%s\"}");
        for(int i = 1; i <= 12; i++){
            this.baseReward("206");     //国力
        }

        for(int i = 1; i <= 14; i++){
            this.baseReward("211");     //shcool
        }

        for(int i = 1 ; i <= 5; i++){
            this.baseReward("201");  // 元宝
        }

        for(int i = 1 ; i <= 12; i++){
            this.baseReward("204");  // 卷轴
        }


    }

    public void hanlinLvUp(){
        this.runAction0("{\"rsn\":\"%s\",\"hanlin\":{\"upskill\":[]}}");
    }
}
