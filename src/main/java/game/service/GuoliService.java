package game.service;

import game.command.LeagueCommand;
import game.player.BasePlayer;
import game.player.RewardPlayer;

public class GuoliService {

    public static void guanghuan(BasePlayer p){
        //女将光环
        p.runAction0("{\"hero\":{\"upghskill\":{\"sid\":16,\"id\":55}},\"rsn\":\"%s\"}");

//        张春华 光环 1
//        {"hero":{"upghskill":{"sid":29,"id":66}},"rsn":"1kkrwwqkuku"}
    }

    public static void wife(BasePlayer p){
//        张春华 老婆 政治
        p.runAction2("{\"wife\":{\"upskill\":{\"skillId\":261,\"upNum\":1,\"id\":44}},\"rsn\":\"%s\"}");
//        关银屏 老婆 花好月圆
        p.runAction2("{\"wife\":{\"upskill\":{\"skillId\":1029,\"upNum\":1,\"id\":29}},\"rsn\":\"%s\"}");
    }


    public static void buyItems(BasePlayer p){
        for(int i = 1; i <= 120; i++){
//        张春华 老婆 政治
            p.runAction0("{\"wife\":{\"upskill\":{\"skillId\":261,\"upNum\":1,\"id\":44}},\"rsn\":\"%s\"}");
            p.runAction0("{\"wife\":{\"upskill\":{\"skillId\":261,\"upNum\":1,\"id\":44}},\"rsn\":\"%s\"}");
        }

        for(int i = 1; i <= 98; i++) {
            p.runAction0("{\"hero\":{\"upgrade\":{\"id\":66}},\"rsn\":\"%s\"}");
        }

//        关银屏 老婆 花好月圆   26W
        for(int i = 1; i <= 50; i++){
            p.runAction0("{\"wife\":{\"upskill\":{\"skillId\":1029,\"upNum\":1,\"id\":29}},\"rsn\":\"%s\"}");
        }

//        for(int i = 1; i <= 2; i++){
//            p.runAction0("{\"hero\":{\"upghskill\":{\"sid\":16,\"id\":55}},\"rsn\":\"%s\"}");
//        }

        for(int i = 1; i <= 10; i++){
            p.runAction0("{\"hero\":{\"upghskill\":{\"sid\":29,\"id\":66}},\"rsn\":\"%s\"}");
        }
    }


    public static void reward_kua(BasePlayer p){
        RewardPlayer rp = new RewardPlayer(p);
        p.runAction2("{\"huodong\":{\"hd313Get\":[]},\"rsn\":\"%s\"}");
        for(int i = 1; i <= 15; i++){
            rp.rewardYinliang();
            rp.rewardGuoli();
        }
        for(int i = 1; i <= 5; i++){
            rp.rewardYuanbao();
        }
    }
}
