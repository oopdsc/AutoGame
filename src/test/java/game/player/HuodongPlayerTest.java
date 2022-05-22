package game.player;

import game.active.DefaultGameRunner;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

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
        runner.all1(null, null, p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.zajiActive();
//            hp.zajiReward();
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
            hp.chijiReward();
            hp.lishanXunli_daily();
            hp.lishanXunli_xunli();

//            RewardPlayer rp = new RewardPlayer(p);
//            rp.rewardZhuangban();
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

            RewardPlayer rp = new RewardPlayer(p);
            rp.reward_kuayamen();
        });

        GameRunner.sleep(5);
    }

    @Test
    void saimaCreate(){
        runner.single("gold.json", p -> {
            System.out.println(p.data.uid);
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saimaCreate();
//            hp.runAction1("{\"huodong\":{\"hd685chageRand\":{\"rand\":1}},\"rsn\":\"%s\"}");
        });
        System.out.println("done");
    }

    @Test
    void saimaStart(){
        runner.all1(p -> {
            GameRunner.sleepInMillis(runner.rd.nextInt(30));
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saimaCreate(6);

            hp.zhongshuReward();
        });
        System.out.println("done");
    }

    @Test
    void saima_reward_test(){
        runner.all1(p -> {
//            GameRunner.sleepInMillis(runner.rd.nextInt(30));
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saima_reward();
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
        runner.single(GameRunner.HUODONG, p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
//            hp.bu
            hp.buySchool();
            hp.buySchool();
            hp.buySchool();
            hp.buySchool();
            hp.xiaohaoFanli();
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

    /**
     * 五一活动
     */
    @Test
    void wuyi(){
        runner.all1(p -> {
//            p.runAction1("{\"hd988\":{\"play\":{\"count\":5}},\"rsn\":\"%s\"}");
//
//            p.runAction1("{\"huodong2\":{\"hd989Select\":{\"selects\":\"84_1,81_1,381_1,76_1\",\"id\":1}},\"rsn\":\"%s\"}");
//            p.runAction1("{\"huodong2\":{\"hd989Pickup\":{\"id\":1}},\"rsn\":\"%s\"}");
//
//            p.runAction1("{\"huodong2\":{\"hd989Select\":{\"selects\":\"83_1,106_1,107_1,123_1\",\"id\":2}},\"rsn\":\"%s\"}");
//            p.runAction1("{\"huodong2\":{\"hd989Pickup\":{\"id\":2}},\"rsn\":\"%s\"}");
//
//            p.runAction1("{\"huodong2\":{\"hd989Select\":{\"selects\":\"86_1,125_1,382_1,90_1\",\"id\":3}},\"rsn\":\"%s\"}");
//            p.runAction1("{\"huodong2\":{\"hd989Pickup\":{\"id\":3}},\"rsn\":\"%s\"}");
//
//            p.runAction1("{\"huodong2\":{\"hd989Select\":{\"selects\":\"254_1,935_1,387_1,255_1\",\"id\":4}},\"rsn\":\"%s\"}");
//            p.runAction1("{\"huodong2\":{\"hd989Pickup\":{\"id\":4}},\"rsn\":\"%s\"}");
//
//            p.runAction1("{\"huodong2\":{\"hd989Select\":{\"selects\":\"138_1,383_1,148_1,78_1\",\"id\":5}},\"rsn\":\"%s\"}");
            p.runAction1("{\"huodong2\":{\"hd989Pickup\":{\"id\":5}},\"rsn\":\"%s\"}");


            p.runAction2("{\"huodong\":{\"hd456exchange\":{\"id\":9}},\"rsn\":\"%s\"}");

            p.runAction2("{\"huodong\":{\"hd456exchange\":{\"id\":9}},\"rsn\":\"%s\"}");

            RewardPlayer rp = new RewardPlayer(p);

//            for(int i = 1; i <= 15; i++){
//                rp.rewardGuoli();
//                rp.rewardYinliang();
//            }


            rp.reward_kua_guoli();



        });
    }
}