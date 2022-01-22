package game.player;

import game.active.DefaultGameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Double11PlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void buyItems() {
        runner.all1(p -> {
            Double11Player hp = new Double11Player(p);
            hp.buyJinguoIn11();
            hp.buyQinmi();
            hp.buyMeili();
        });
        System.out.println("done");
    }

}