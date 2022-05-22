package game.player;

import game.active.DefaultGameRunner;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LianmengPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();
//、、24300   48600   6000
//    27800+24300  52100  54110
    @Test
    void club() {
        runner.single(GameRunner.GOLD, p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.club();
        });
    }

    @Test
    void club2() {
        runner.single(GameRunner.GOLD, p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.dayHighGongxian();
        });
    }
}