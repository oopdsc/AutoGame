package game.service;

import game.active.DefaultGameRunner;
import game.player.HuodongPlayer;
import game.runner.GameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HuodongServiceTest {
    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void saima_create() {
        runner.processSingle10("gold.json", p -> {
            System.out.println(p.data.uid);
            HuodongService.saima_create(p);
        });
        System.out.println("done");
    }

    @Test
    void saima_join() {
        runner.all1(p -> {
//            HuodongService.saima_join(p);

            HuodongService.saima_start(p, 41);

            TongmengService.buyItems(p);

//            HuodongService.saima_reward(p);
        });
        System.out.println("done");
    }

    /**
     * 小号买种树道具
     */
    @Test
    void tree_gold2() {
        runner.processSingle10(GameRunner.GOLD, p ->{
//            小号买
            HuodongService.tree_buy2(p);

//            小号用
//            HuodongService.tree_use2(p);

//            HuodongService.zaji_buy2(p);

//            HuodongService.zaji_use2(p);

        });
    }
}