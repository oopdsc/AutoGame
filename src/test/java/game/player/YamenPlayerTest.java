package game.player;

import game.active.DefaultGameRunner;
import game.config.Flags;
import game.runner.GameRunner;
import org.junit.jupiter.api.Test;

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
        runner.single(GameRunner.DAHAO, d -> d.username.equals("ssqwerty"), p -> {
            YamenPlayer yp = new YamenPlayer(p);
            Flags.yamenShop = true;
            for(int i = 1; i <= 2; i++){
                yp.chushi_One();
            }

        });
    }

    @Test
    void chushi2() {
        runner.single(GameRunner.DAHAO, d -> d.username.equals("18612160829"), p -> {
            YamenPlayer yp = new YamenPlayer(p);
            Flags.yamenShop = true;
            for(int i = 1; i <= 4; i++){
                yp.chushi_One();
            }

        });
    }

    @Test
    void chushi3() {
        runner.single(GameRunner.DAHAO, d -> d.username.equals("15504973518"), p -> {
            YamenPlayer yp = new YamenPlayer(p);
            Flags.yamenShop = true;
            for(int i = 1; i <= 4; i++){
                yp.chushi_One();
            }

        });
    }
}