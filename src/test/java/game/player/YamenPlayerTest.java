package game.player;

import game.active.DefaultGameRunner;
import game.config.Flags;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YamenPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void tiaozhan() {
        runner.single(GameRunner.HUODONG, p -> {
          YamenPlayer yp = new YamenPlayer(p);
          yp.tiaozhan(84717, 66, 7008211);
        });
    }

    @Test
    void chushi() {
        runner.single(GameRunner.HUODONG, p -> {
            YamenPlayer yp = new YamenPlayer(p);
            Flags.yamenShop = true;
            for(int i = 1; i <= 10; i++){
                yp.chushi_One();
            }

        });
    }
}