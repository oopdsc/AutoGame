package game.player;

import game.service.PlayerData;

import static game.service.GameRunner.sleepInMillis;

public class RewardPlayer extends BasePlayer {
    public RewardPlayer(PlayerData data) {
        super(data);
    }

    public RewardPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }


    public void rewardYuanbao(){

        this.baseReward("201");
    }

    public void rewardShibing(){
        this.baseReward("202");
    }



    public void rewardYinliang(){
        this.baseReward("203");
    }

    public void rewardJuanzhou(){
        this.baseReward("204");
    }
    public void rewardQinmi(){
        this.baseReward("205");
    }

    public void rewardGuoli(){
        this.baseReward("206");
    }

    public void rewardLianyin(){
        this.baseReward("210");
    }

    public void rewardKillXiongnu(){
        this.baseReward("215");
    }

    public void rewardTilidan(){
        this.baseReward("219");
    }

    public void rewardHuolidan(){
        this.baseReward("220");
    }

    public void rewardMeili(){
        this.baseReward("221");
    }

    public void rewardLianmengBoss(){
        this.baseReward("223");
    }

    public void rewardKillLianmengBoss(){
        this.baseReward("224");
    }

    public void rewardLiangshi(){
        this.baseReward("226");
    }

    public void rewardJinglidan(){
        this.baseReward("227");
    }





    public void rewardZhuangban(){
        this.runAction3("{\"user\":{\"get_cj\":{\"id\":5}},\"rsn\":\"%s\"}");
    }

    public void reward_kua_guoli(){
        this.runAction3("{\"huodong\":{\"hd313Get\":[]},\"rsn\":\"%s\"}");
    }

    public void reward_bolanshitu(){
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":1}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":2}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":4}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":5}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":6}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":7}},\"rsn\":\"%s\"}");

        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":9}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":10}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":11}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":12}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":13}},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong2\":{\"hd961PickDailyTaskRwd\":{\"id\":14}},\"rsn\":\"%s\"}");
    }

    public void reward_ganen(){
        for(int i = 1; i <= 7; i++) {
            this.runAction3("{\"huodong2\":{\"hd997option\":{\"id\":" + i + ",\"itemid\":1}},\"rsn\":\"%s\"}");
            sleepInMillis(500);
            this.runAction3("{\"huodong2\":{\"hd997getSignRwd\":{\"id\":" + i + "}},\"rsn\":\"%s\"}");
        }
    }



}