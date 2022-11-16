package game.player;

import game.active.DefaultGameRunner;
import game.config.Flags;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class JunjiPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void checkCabinet() {
        runner.single("huodong.json", p -> {
            JunjiPlayer jp = new JunjiPlayer(p);
            jp.checkCabinet();
        });
    }


    @Test
    void checkCabinet2() {
        LocalDate ld = LocalDate.now();
        int dayInWeek = ld.getDayOfWeek().getValue();
        int slt = Flags.sleepTime;
        Flags.sleepTime = 3;
        runner.single(dayInWeek+ "-cabinet.json", p -> {
            JunjiPlayer jp = new JunjiPlayer(p);
            jp.checkCabinet2();
        });
//        GameRunner.sleep(100);
        Flags.sleepTime = slt;
        System.out.println("done");
    }
}