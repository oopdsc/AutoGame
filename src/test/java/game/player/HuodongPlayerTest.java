package game.player;

import game.active.DefaultGameRunner;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

import static game.service.GameRunner.*;
import static org.junit.jupiter.api.Assertions.*;

class HuodongPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void chiji() {
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.chiji();
        });
    }

    @Test
    void chijiReward() {
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.chijiReward();
        });
    }

    @Test
    void zaji() {
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.zajiActive();
            hp.zajiReward();
        });
    }

    @Test
    void zajiReward() {
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.zajiReward();
        });
    }

    @Test
    void zhongshuReward() {
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.zhongshuReward();

            RewardPlayer rp = new RewardPlayer(p);
            rp.rewardZhuangban();
        });
    }

    @Test
    void cefeng()  {
        runner.all1(px -> {
            HuodongPlayer p = new HuodongPlayer(px);
            p.cefeng();
        });

        GameRunner.sleep(5);
    }

    @Test
    void danzhu()  {
        runner.all1(px -> {
            HuodongPlayer p = new HuodongPlayer(px);
            p.danzhu();
        });

        GameRunner.sleep(5);
    }

    @Test
    void saima(){
        runner.single("huodong.json", p -> {
            System.out.println(p.data.uid);
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saima();
//            hp.runAction1("{\"huodong\":{\"hd685chageRand\":{\"rand\":1}},\"rsn\":\"%s\"}");
        });
        System.out.println("done");
    }

    @Test
    void saimaStart(){
        runner.all1(p -> {
            GameRunner.sleepInMillis(runner.rd.nextInt(30));
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saima(2);
        });
        System.out.println("done");
    }



    @Test
    void joinsaima(){
        runner.all1(p -> {
            GameRunner.sleepInMillis(runner.rd.nextInt(100));
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.randomSaima();
        });
        System.out.println("done");
    }

    @Test
    void heshan_create_test(){
        runner.single("huodong.json", p -> {
            System.out.println(p.data.uid);
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.heshan_create();
        });
        System.out.println("done");
    }

    @Test
    void heshan_join_test(){
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.heshan_join();
        });
        System.out.println("done");
    }
    @Test
    void heshan_play_test(){
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            for(int i = 1; i <= 10; i++){
                hp.heshan();
            }
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

    @Test
    void caoxue(){
        runner.all1(p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.caoxueAll();
//            String body = "{\"rsn\":\"%s\",\"huanggong\":{\"qingAn\":{\"type\":0,\"chenghao\":15,\"fuid\":7006984}}}";
//            hp.runAction1(body);


        });
        System.out.println("done");
    }

    @Test
    void caoxueReward(){
        runner.all1(p -> {

//        runner.single("huodong.json", p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.caoxueReward();

//            MeiliPlayer mp = new MeiliPlayer(p);
//            mp.meili_reward();
//            String body = "{\"rsn\":\"%s\",\"huanggong\":{\"qingAn\":{\"type\":0,\"chenghao\":15,\"fuid\":7006984}}}";
//            hp.runAction1(body);


        });
        System.out.println("done");
    }



    @Test
    void double11(){
        runner.all1(p -> {

            HuodongPlayer hp = new HuodongPlayer(p);



        });
        System.out.println("done");
    }

    @Test
    void wabao(){
        runner.single("huodong.json", p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.wabao();
        });
        System.out.println("done");
    }

    @Test
    void wabao2(){
        runner.single("huodong.json", p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.wabao();
        });
        System.out.println("done");
    }

    @Test
    void wabao3(){
        runner.single("huodong.json", p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.wabao();
        });
        System.out.println("done");
    }
}