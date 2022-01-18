package game.player;

import game.service.PlayerData;

public class Double11Player extends BasePlayer {
    public Double11Player(PlayerData data) {
        super(data);
    }

    public Double11Player(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }

    public void buyJinguoIn11(){
        this.runAction3("{\"huodong2\":{\"hd246Buy\":{\"type\":3,\"count\":1,\"id\":1}},\"rsn\":\"%s\"}");
    }

    public void buyQinmi(){
        this.runAction3("{\"huodong2\":{\"hd246Buy\":{\"type\":1,\"count\":1,\"id\":11}},\"rsn\":\"%s\"}");
    }

    public void buyMeili(){
        this.runAction3("{\"huodong2\":{\"hd246Buy\":{\"type\":1,\"count\":1,\"id\":12}},\"rsn\":\"%s\"}");
    }

    public void sishantiaozhan(){
        for(int i = 1; i  <= 5; i++){
            this.runAction3("{\"huodong\":{\"hd496TaskDaily\":{\"id\":"+i+"}},\"rsn\":\"%s\"}");
        }
    }

    public void sishanWeek(){
        for(int i = 1; i <= 3; i++){
            for(int  j = 1; j <= 10; j++){
                this.runAction2("{\"huodong\":{\"hd496TaskWeek\":{\"id\":"+j+",\"week\":"+i+"}},\"rsn\":\"%s\"}");
            }
        }
        this.runAction1("{\"huodong\":{\"hd496RwdAll\":[]},\"rsn\":\"%s\"}");

    }

}
