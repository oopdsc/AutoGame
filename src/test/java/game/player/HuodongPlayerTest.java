package game.player;

import game.active.DefaultGameRunner;
import game.command.BaseCommand;
import game.command.LeagueCommand;
import game.runner.GameRunner;
import org.junit.jupiter.api.Test;

class HuodongPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void chiji() {
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.chiji();
//            hp.zhongshuhuodong();
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

            hp.xiangqinyingwu();
//            hp.chiji();

            RewardPlayer rp = new RewardPlayer(p);
            rp.reward_kua_guoli();

            for(int i = 1; i <= 4; i++){
                p.runAction2(LeagueCommand.buyShopItem(1));
            }

        }, p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.zajiActive();
            hp.zajiReward();

            hp.xiangqinyingwu();
//            hp.chiji();

            RewardPlayer rp = new RewardPlayer(p);
            rp.reward_kua_guoli();

            for(int i = 1; i <= 4; i++){
                p.runAction2(LeagueCommand.buyShopItem(1));
            }

            QinmiPlayer qp = new QinmiPlayer(p);
            qp.useCook(3);

        }, p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.zajiActive();
            hp.zajiReward();

            hp.xiangqinyingwu();
//            hp.chiji();

            RewardPlayer rp = new RewardPlayer(p);
            rp.reward_kua_guoli();

            for(int i = 1; i <= 4; i++){
                p.runAction2(LeagueCommand.buyShopItem(1));
            }

            QinmiPlayer qp = new QinmiPlayer(p);
            qp.useCook(3);

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

//        Consumer<T> consumer =

        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.chiji();
            hp.zhongshuReward();


        }, p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
//            hp.zhongshuReward();
//            hp.chijiReward();
            hp.lishanXunli_daily();
            hp.lishanXunli_xunli();

            hp.chiji();

            for(int i = 33; i <= 37; i++){
                hp.runAction2("{\"club\":{\"householdMake\":{\"id\":12,\"heroid\":"+i+"}},\"rsn\":\"%s\"}");
            }
            for(int i = 38; i <= 41; i++){
                hp.runAction2("{\"club\":{\"householdMake\":{\"id\":11,\"heroid\":"+i+"}},\"rsn\":\"%s\"}");
            }

//            RewardPlayer rp = new RewardPlayer(p);
            hp.runAction3("{\"huodong2\":{\"hd238Get\":[]},\"rsn\":\"%s\"}");

            QinmiPlayer qp = new QinmiPlayer(p);
            qp.useCook(3);
        }, p -> {
            HuodongPlayer hp = new HuodongPlayer(p);

            hp.chiji();
//            hp.zhongshuReward();
//            hp.chijiReward();
            hp.lishanXunli_daily();
            hp.lishanXunli_xunli();

            for(int i = 33; i <= 37; i++){
                hp.runAction2("{\"club\":{\"householdMake\":{\"id\":12,\"heroid\":"+i+"}},\"rsn\":\"%s\"}");
            }
            for(int i = 38; i <= 41; i++){
                hp.runAction2("{\"club\":{\"householdMake\":{\"id\":11,\"heroid\":"+i+"}},\"rsn\":\"%s\"}");
            }

//            RewardPlayer rp = new RewardPlayer(p);
            hp.runAction3("{\"huodong2\":{\"hd238Get\":[]},\"rsn\":\"%s\"}");

            QinmiPlayer qp = new QinmiPlayer(p);
            qp.useCook(3);
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

            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addGuoli();
        });

        GameRunner.sleep(5);
    }

    @Test
    void saimaCreate(){
        runner.single("gold.json", p -> {
            System.out.println(p.data.uid);
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saima_Create();
//            hp.runAction1("{\"huodong\":{\"hd685chageRand\":{\"rand\":1}},\"rsn\":\"%s\"}");
        });
        System.out.println("done");

    }

    @Test
    void saimaStart(){
        runner.all1(p -> {
//            GameRunner.sleepInMillis(runner.rd.nextInt(30));
//            p.runAction1(LeagueCommand.enter);
//
//            p.runAction2(LeagueCommand.fuben);
//            String fuben = p.runAction2(LeagueCommand.fuben).getBody();
//            Configuration conf = Configuration.defaultConfiguration();
//            Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
//            DocumentContext dc = JsonPath.using(conf2).parse(fuben);
//            List<Map<String, Object>> events = dc.read("$.a.league.fbList[0].events");
//            if(Objects.isNull(events) || events.size() == 0){
//            }else{
//                for(int i = 0; i < events.size(); i++) {
//                    Integer id = Integer.valueOf(events.get(i).get("id").toString());
//                    p.runAction2(LeagueCommand.fubenEvent(1, id));
//                }
//            }
//            p.runAction2(LeagueCommand.fubenOver(1));

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saima_play(38);

//            hp.cuju();



//            String body = "{\"club\":{\"kuaPKAdd\":{\"hid\":35}},\"rsn\":\"%s\"}";
//            hp.runAction1(body);

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
            hp.saima_randJoin();
        });
        System.out.println("done");
    }

    @Test
    void heshan_create_test(){
        runner.single(GameRunner.XIAOHAO2, p -> {
            System.out.println(p.data.uid);
            HuodongPlayer hp = new HuodongPlayer(p);
//            hp.heshan_create();
        });
        System.out.println("done");
    }

    @Test
    void heshan_join_test(){
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.heshan_join();
            hp.runAction2(LeagueCommand.buyShopItem(1));
            hp.runAction2(LeagueCommand.buyShopItem(1));
            hp.runAction2(LeagueCommand.buyShopItem(1));
            hp.runAction2(LeagueCommand.buyShopItem(1));
        }, p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.runAction2(LeagueCommand.buyShopItem(1));
            hp.runAction2(LeagueCommand.buyShopItem(1));
            hp.runAction2(LeagueCommand.buyShopItem(1));
            hp.runAction2(LeagueCommand.buyShopItem(1));
        }, p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.runAction2(LeagueCommand.buyShopItem(1));
            hp.runAction2(LeagueCommand.buyShopItem(1));
            hp.runAction2(LeagueCommand.buyShopItem(1));
            hp.runAction2(LeagueCommand.buyShopItem(1));
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
            hp.runAction2(LeagueCommand.buyShopItem(1));
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
            hp.caoxueReward();
//            hp.caoxueAll();
//
            Double11Player dp = new Double11Player(p);
            dp.buyJinguoIn11();

            dp.runAction2(LeagueCommand.buyShopItem(1));
            dp.runAction2(LeagueCommand.buyShopItem(1));
            dp.runAction2(LeagueCommand.buyShopItem(1));
            dp.runAction2(LeagueCommand.buyShopItem(1));
            dp.runAction2(LeagueCommand.buyShopItem(5));
            dp.runAction2(LeagueCommand.buyShopItem(5));

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

            RewardPlayer rp = new RewardPlayer(p);
            rp.reward_kuayamen();

            rp.runAction2(BaseCommand.mengzhan(36));
            rp.runAction2(LeagueCommand.buyShopItem(1));
            rp.runAction2(LeagueCommand.buyShopItem(1));
            rp.runAction2(LeagueCommand.buyShopItem(1));
            rp.runAction2(LeagueCommand.buyShopItem(1));

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

//            HuodongPlayer hp = new HuodongPlayer(p);
//
//            hp.runAction2("{\"huodong2\":{\"hd990Info\":[]},\"rsn\":\"%s\"}");
//            hp.runAction2("{\"huodong2\":{\"hd990Clear\":{\"a1\":0,\"a2\":3,\"b1\":0,\"b\":2,\"a\":1,\"b2\":4}},\"rsn\":\"%s\"}");
//            hp.runAction2("{\"huodong2\":{\"hd990Clear\":{\"a1\":2,\"a2\":1,\"b1\":1,\"b\":2,\"a\":3,\"b2\":1}},\"rsn\":\"%s\"}");
//            hp.runAction2("{\"huodong2\":{\"hd990Clear\":{\"a1\":6,\"a2\":2,\"b1\":5,\"b\":4,\"a\":3,\"b2\":2}},\"rsn\":\"%s\"}");

            Double11Player dp = new Double11Player(p);
            dp.buyJinguoIn11();

            dp.runAction2(LeagueCommand.buyShopItem(1));
            dp.runAction2(LeagueCommand.buyShopItem(1));
            dp.runAction2(LeagueCommand.buyShopItem(1));
            dp.runAction2(LeagueCommand.buyShopItem(1));

            dp.runAction2(LeagueCommand.upgradeSeat(1));

            dp.runAction2(LeagueCommand.buyShopItem(5));
            dp.runAction2(LeagueCommand.buyShopItem(5));
            dp.runAction2(LeagueCommand.buyShopItem(5));
            dp.runAction2(LeagueCommand.buyShopItem(5));
            dp.runAction2(LeagueCommand.buyShopItem(5));
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
        runner.single("xiaohao11.json", p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.wabao();
        });
        System.out.println("done");
    }

    @Test
    void wabao3(){
        runner.single("xiaohao2.json", p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.wabao();
        });
        System.out.println("done");
    }


    @Test
    void shenlong() {
        runner.all1(p -> {
            for(int i = 1; i <= 3; i++ ){
                p.runAction1("{\"hd988\":{\"play\":{\"count\":1}},\"rsn\":\"%s\"}");
            }

            HuodongPlayer hp = new HuodongPlayer(p);
//            hp.zajiActive();

        });
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

    @Test
    void cuju() {
        runner.all1(p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
//            hp.cuju();
//
//            p.runAction2(LeagueCommand.goShop);
//            p.runAction2(LeagueCommand.buyShopItem(1));
//            p.runAction2(LeagueCommand.buyShopItem(1));
//            p.runAction2(LeagueCommand.buyShopItem(1));
//            p.runAction2(LeagueCommand.buyShopItem(1));
//            p.runAction2(LeagueCommand.buyShopItem(2));
//            p.runAction2(LeagueCommand.buyShopItem(2));
//            p.runAction2(LeagueCommand.buyShopItem(2));
//            p.runAction2(LeagueCommand.buyShopItem(3));
//            p.runAction2(LeagueCommand.buyShopItem(3));
//            p.runAction2(LeagueCommand.buyShopItem(3));
//            p.runAction2(LeagueCommand.buyShopItem(3));
//            p.runAction2(LeagueCommand.buyShopItem(8));
//            p.runAction2(LeagueCommand.buyShopItem(8));
////            p.runAction2(LeagueCommand.upgradeSeat(1));
//            p.runAction2(LeagueCommand.buyShopItem(5));
//
//            QinmiPlayer qp = new QinmiPlayer(p);
//            qp.useCook(3);

//            hp.saimaCreate(41);

//            p.runAction2(LeagueCommand.goShop);
//            p.runAction2(LeagueCommand.buyShopItem(1));
//            p.runAction2(LeagueCommand.buyShopItem(1));
//            p.runAction2(LeagueCommand.buyShopItem(1));
//            p.runAction2(LeagueCommand.buyShopItem(1));
////            p.runAction2(LeagueCommand.upgradeSeat(1));
//            p.runAction2(LeagueCommand.buyShopItem(5));


//            hp.zajiActive();
//            for(int i = 33; i <= 37; i++){
//                hp.runAction2("{\"club\":{\"householdMake\":{\"id\":12,\"heroid\":"+i+"}},\"rsn\":\"%s\"}");
//            }
        });
        System.out.println("done");
    }

    @Test
    void buyHighZaji() {
        runner.single("goldhuodong.json", p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.buyHighZhongshu();
        });
        System.out.println("done");
    }

    @Test
    void buyHighZhongshu() {
        runner.single("goldhuodong.json", p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.buyHighZhongshu();
        });
        System.out.println("done");
    }

    @Test
    void xiangqinyingwu() {
        runner.all1(p -> {
            if(!p.data.username.equals("pby123456")){


                HuodongPlayer hp = new HuodongPlayer(p);
                hp.xiangqinyingwu();
            }

//            hp.runAction3("{\"huodong2\":{\"hd962Info\":[]},\"rsn\":\"%s\"}");
//            for(int i = 1; i <= 9; i++){
//                hp.runAction3("{\"huodong2\":{\"hd962Start\":{\"num\":1}},\"rsn\":\"%s\"}");
//            }

//            RewardPlayer rp = new RewardPlayer(p);
//            rp.reward_kuayamen();
////            hp.runAction2(BaseCommand.mengzhan(2));
//            hp.runAction2(LeagueCommand.buyShopItem(1));
//            hp.runAction2(LeagueCommand.buyShopItem(1));
//            hp.runAction2(LeagueCommand.buyShopItem(1));
//            hp.runAction2(LeagueCommand.buyShopItem(1));
//            hp.runAction2(LeagueCommand.buyShopItem(2));
//            hp.runAction2(LeagueCommand.buyShopItem(2));
//            hp.runAction2(LeagueCommand.buyShopItem(2));
//
//            hp.runAction2(LeagueCommand.buyShopItem(8));
//            hp.runAction2(LeagueCommand.buyShopItem(8));
////            hp.runAction2(LeagueCommand.upgradeSeat(1));
//            hp.runAction2(LeagueCommand.buyShopItem(5));
        });
    }
}