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

    @Test
    public void alluseMeiliItems1() {

        int num = 25;
        StopWatch sw = new StopWatch();
        sw.start();
        runner.all1(p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= num; i++){
                mp.meili2();
            }
        });
        sw.stop();
        System.out.println("done " + sw.getTotalTimeSeconds() );
    }

    /**
     * 担任用魅力道具1。个人魅力用
     * WANG7777
     */
    @Test
    void meili1() {
        StopWatch sw = new StopWatch();
        sw.start();
        int num = 1;
        runner.single(GameRunner.HUODONG, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 2000; i++){
                mp.meili1();
            }

//            for(int i = 1; i <= 2000; i++){
//                mp.meili2();
//            }
        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

    /**
     * 担任用魅力道具2。个人魅力用
     *
     */
    @Test
    void meili2() {
        StopWatch sw = new StopWatch();
        sw.start();
        int num = 3;
        runner.single("huodong2.json", p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= num; i++){
//                mp.meili1();
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

//            Double11Player dp = new Double11Player(p);
//            dp.sishanWeek();
        });
        System.out.println(all1);
    }


    @Test
    void upBeast() {
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single(GameRunner.HUODONG, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 13; i++){
                mp.upLvBeast2(1, 8);
                mp.upLvBeast2(2, 8);
                mp.upLvBeast2(3, 8);
            }

        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }


    @Test
    void kua_meili(){
        String all1 = runner.all1( null, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            mp.kua_meili();
        }, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            mp.kua_meili();
        });
        System.out.println(all1);
    }


    @Test
    void buyBeast() {
        runner.single(GameRunner.HUODONG, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            mp.buyBeast(3);
        });
    }
}