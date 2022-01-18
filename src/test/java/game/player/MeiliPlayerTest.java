package game.player;

import game.active.DefaultGameRunner;
import game.config.Flags;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MeiliPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    /**
     * 担任用魅力道具1。个人亲密用
     */
    @Test
    void meili1() {
        StopWatch sw = new StopWatch();
        sw.start();
        int num = 1000;
        runner.single(GameRunner.HUODONG, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= num; i++){
                mp.meili1();
            }
        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

    /**
     * 担任用魅力道具2。个人亲密用
     */
    @Test
    void meili2() {
        StopWatch sw = new StopWatch();
        sw.start();
        int num = 16000;
        runner.single(GameRunner.HUODONG, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= num; i++){
                mp.meili2();
            }
        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

    @Test
    void meili3() {
        StopWatch sw = new StopWatch();
        sw.start();
        //15959 - 13104 =
        int num = 698;
        runner.single(GameRunner.HUODONG, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= num; i++){
                mp.meili3();
            }
        });

        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

    @Test
    void reward(){
        String all1 = runner.all1( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            mp.meili_reward();

            Double11Player dp = new Double11Player(p);
            dp.sishanWeek();
        });
        System.out.println(all1);
    }





}