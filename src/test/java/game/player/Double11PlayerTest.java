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
//            hp.buyQinmi();
            hp.buyMeili();

            hp.runAction1("{\"huodong2\":{\"hd238Get\":[]},\"rsn\":\"%s\"}");
            hp.runAction1("{\"huodong\":{\"hd546buy\":{\"id\":1}},\"rsn\":\"%s\"}");

//            HuodongPlayer hp2 = new HuodongPlayer(p);
//            hp2.cangjian();
//
//            YamenPlayer yp = new YamenPlayer(p);
//            yp.reward_KuafuYamen();


        });
        System.out.println("done");
    }

}