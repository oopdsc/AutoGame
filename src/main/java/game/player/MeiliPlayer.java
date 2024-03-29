package game.player;

import game.runner.PlayerData;

import static game.runner.GameRunner.getRsn;

public class MeiliPlayer extends BasePlayer {
    public MeiliPlayer(PlayerData data) {
        super(data);
    }

    public MeiliPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }


    public void meili1() {
        //33 - 马云绿
        //29 - 关银屏
        //44 - 张春华
        this.runAction0("{\"wife\":{\"reward\":{\"count\":1,\"id\":33,\"itemId\":93}},\"rsn\":\"%s\"}");
    }

    public void meili2() {
        //33 - 马云绿
        this.runAction0("{\"wife\":{\"reward\":{\"count\":1,\"id\":33,\"itemId\":94}},\"rsn\":\"%s\"}");
    }

    public void meili21() {
        //33 - 马云绿
        this.runAction1("{\"wife\":{\"reward\":{\"count\":50,\"id\":33,\"itemId\":93}},\"rsn\":\"%s\"}");
    }

    public void meili3(){
        this.runAction0("{\"rsn\":\"%s\",\"item\":{\"useitem\":{\"id\":107,\"count\":1}}}");
    }

    public void meiliKuafu() {
        this.runAction3("{\"huodong2\":{\"hd954GetTaskRwdByID\":{\"id\":1}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd954play\":{\"num\":1}},\"rsn\":\"%s\"}");
    }

    /**
     * 1 - 小药丸
     * 2 - 中药丸
     * 3 - 大药丸
     * 9 - 孔雀
     * 10 - 灵蛇
     * 11 - 白熊
     * 12 - 斗牛
     * @param id
     */
    public void buyBeast(int id) {

        this.runAction3("{\"rsn\":\"%s\",\"beast\":{\"buy\":{\"id\":" + id + "}}}");
    }

    /**
     * @param itemid  1 : 小经验；2 : 中经验； 3 ： 大经验
     * @param beastid 1 ： 狐狸； 2 ： 猴子    7: 白熊 8： 斗牛
     */
    public void upLvBeast(int itemid, int beastid) {
//        {"rsn":"8avijeeaak","beast":{"upLv":{"type":1,"item_id":2,"id":1}}}
        this.runAction3("{\"rsn\":\"%s\",\"beast\":{\"upLv\":{\"type\":1,\"item_id\":" + itemid + ",\"id\":" + beastid + "}}}");

//        {"rsn":"9zzcmmmziti","beast":{"upLv":{"type":2,"item_id":1,"id":8}}}
    }

    public void upLvBeast2(int itemid, int beastid) {
//        {"rsn":"8avijeeaak","beast":{"upLv":{"type":1,"item_id":2,"id":1}}}
        this.runAction0("{\"rsn\":\"%s\",\"beast\":{\"upLv\":{\"type\":2,\"item_id\":" + itemid + ",\"id\":" + beastid + "}}}");

//        {"rsn":"9zzcmmmziti","beast":{"upLv":{"type":2,"item_id":1,"id":8}}}
    }

    //跨服魅力活动中的炮击
    public void pao(){
        this.runAction0("{\"huodong2\":{\"hd954Paoji\":{\"uid\":7000673,\"num\":1}},\"rsn\":\"%s\"}");
    }


    public void kua_meili(){
//        {"huodong2":{"hd954GetTaskRwd":[]},"rsn":"7ycopddcdgg"}
//        this.runAction3("{\"huodong2\":{\"hd954GetTaskRwdByID\":{\"id\":1}},\"rsn\":\"%s\"}");

        this.meili21();

        this.runAction1("{\"huodong2\":{\"hd954GetTaskRwd\":[]},\"rsn\":\"%s\"}");
//
        this.runAction1("{\"huodong2\":{\"hd954play\":{\"num\":1}},\"rsn\":\"%s\"}");
    }

    public void kua_meili_play(){
        this.runAction0("{\"huodong2\":{\"hd954play\":{\"num\":1}},\"rsn\":\"%s\"}");
    }

    public void meili_reward(){
        for(int i = 1; i <= 8; i++){
            this.runAction1("{\"huodong\":{\"hd221Rwd\":[]},\"rsn\":\"%s\"}"); //魅力
        }

        for(int i = 1; i <= 18; i++){
            this.runAction1("{\"huodong\":{\"hd202Rwd\":[]},\"rsn\":\"%s\"}"); //士兵
        }
        for(int i = 1; i <= 5; i++){
            this.runAction1("{\"huodong\":{\"hd205Rwd\":[]},\"rsn\":\"%s\"}"); //亲密
        }
        for(int i = 1; i <= 9; i++){
            this.runAction1("{\"huodong\":{\"hd206Rwd\":[]},\"rsn\":\"%s\"}"); //国力
        }
        this.runAction1("{\"huodong2\":{\"hd954GetSevRwd\":[]},\"rsn\":\"%s\"}"); //跨服
    }

    public void kua_meiliReward(){
        this.runAction3("{\"huodong2\":{\"hd954GetSevRwd\":[]},\"rsn\":\"%s\"}");
    }




}
