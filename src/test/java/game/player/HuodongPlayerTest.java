package game.player;

import game.active.DefaultGameRunner;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

import static game.service.GameRunner.RUNNER;
import static game.service.GameRunner.sleep;
import static org.junit.jupiter.api.Assertions.*;

class HuodongPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void chiji() {
        runner.all(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.chiji();
        });
    }

    @Test
    void chijiReward() {
        runner.all(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.chijiReward();
        });
    }

    @Test
    void cefeng()  {
        runner.processSingle(RUNNER, px -> {
            HuodongPlayer p = new HuodongPlayer(px);
            p.cefeng();
            sleep(20);
        });

        GameRunner.sleep(5);
    }

    @Test
    void danzhu()  {
        runner.processSingle(RUNNER, px -> {
            HuodongPlayer p = new HuodongPlayer(px);
            p.danzhu();
            sleep(20);
        });

        GameRunner.sleep(5);
    }

    @Test
    void saima(){
        runner.single("huodong.json", p -> {
            System.out.println(p.data.uid);
            HuodongPlayer hp = new HuodongPlayer(p);
//            hp.saima();
            hp.runAction1("{\"huodong\":{\"hd685chageRand\":{\"rand\":1}},\"rsn\":\"%s\"}");
        });
        System.out.println("done");
    }

    @Test
    void saimaStart(){
        runner.all1(p -> {
            GameRunner.sleepInMillis(runner.rd.nextInt(1000));
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saima(1);
        });
        System.out.println("done");
    }



    @Test
    void joinsaima(){
        runner.all1(p -> {
            GameRunner.sleepInMillis(runner.rd.nextInt(1000));
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.randomSaima();
        });
        System.out.println("done");
    }

    @Test
    void cangjian(){
        runner.all1(p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.kuafu_reward();

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.cangjian();


        });
        System.out.println("done");
    }
}