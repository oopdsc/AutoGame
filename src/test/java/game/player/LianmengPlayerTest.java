package game.player;

import game.active.DefaultGameRunner;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LianmengPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void club() {
        runner.single(GameRunner.GOLD, p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.club();
        });
    }
}