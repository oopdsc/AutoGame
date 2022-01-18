package game.player;

import game.service.PlayerData;

public class ZhanmaPlayer extends BasePlayer {
    public ZhanmaPlayer(PlayerData data) {
        super(data);
    }

    public ZhanmaPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }


    /**
     * 饲养战马
     */
    public void warhorseActive(){
        this.runAction3("{\"huodong2\":{\"hd238Buy\":{\"id\":1}},\"rsn\":\"%s\"}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"useitem\":{\"id\":9102,\"count\":1}}}");
        this.runAction3("{\"warHorse\":{\"sendWarHorse\":[]},\"rsn\":\"%s\"}");
        this.runAction3("{\"warHorse\":{\"upgrade\":{\"num\":1,\"id\":1}},\"rsn\":\"%s\"}");
    }

    public void rewardAll(){
        this.warhorseReward();
        this.xiongnu();
        for(int i = 1; i <= 5; i++){
            this.guoli();
        }

        for(int i = 1; i <= 11; i++){
            this.shuyuan();
        }
    }


    public void warhorseReward(){
        this.runAction3("{\"huodong2\":{\"hd238Get\":[]},\"rsn\":\"%s\"}");
    }

    public void guoli(){
        this.baseReward("206");
    }

    public void shuyuan(){
        this.baseReward("211");
    }

    public void xiongnu(){
        this.baseReward("215");
    }
}
