package game.player;

import game.active.DefaultGameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void buyZizhiTest() {
        int v5Items = 5;
        int v3Items = 1;
        int reward = 4;
        runner.single("ZizhiBuyer.json", p -> {
            ShopPlayer sp = new ShopPlayer(p);
            for(int i = 1; i <= v5Items; i++){
                sp.buyV5Zizhi();
            }
            for(int i = 1; i <= v3Items; i++){
                sp.buyV3Zizhi();
            }

            RewardPlayer rp = new RewardPlayer(p);
            for(int i = 1; i <= reward; i++){
                rp.rewardYuanbao();
            }


        });
    }

    @Test
    void buyQinmiTest() {
        int v5Items = 5;
        int v3Items = 1;
        runner.single("", p -> {
            ShopPlayer sp = new ShopPlayer(p);
            for(int i = 1; i <= v5Items; i++){
                sp.buyV5Qinmi();
            }
            for(int i = 1; i <= v3Items; i++){
                sp.buyV3Qinmi();
            }

        });
    }
}