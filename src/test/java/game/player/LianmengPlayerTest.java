package game.player;

import game.active.DefaultGameRunner;
import game.config.Flags;
import game.runner.GameRunner;
import org.junit.jupiter.api.Test;

class LianmengPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();
//    15700 + 8600 = 24300 * 2 = 48600
//、、24300   48600   6000
//    27800+24300  52100  54110
//    53200 - 48600 = 4600
//    27210 54610  27400     24200
//    25800
//    26300 -> 47110
//    24300 -> 30300  -> 37300

//    529   487  42
//    266
//263
    @Test
    void club() {
        runner.single(GameRunner.GOLD, p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.club();

        });
    }

    int t = 1;
    @Test
    void club2() {
        Flags.sleepTime = 3;

        runner.single("club.json", p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.highItemGongxian();
            t++;
        });
    }

    @Test
    void buyItems() {
        runner.single("club.json", p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.buyItems();

            for(int i = 1; i <= 6; i++){
//            this.runAction2("{\"huodong\":{\"hd331Get\":[]},\"rsn\":\"%s\"}");
                lp.runAction1("{\"huodong\":{\"hd331Rwd\":[]},\"rsn\":\"%s\"}");
                lp.runAction1("{\"huodong\":{\"hd201Rwd\":[]},\"rsn\":\"%s\"}");
            }

            RewardPlayer rp = new RewardPlayer(p);
            for(int i = 1; i <= 4; i++){
                rp.rewardYuanbao();
            }


        });

    }
}