package game.player;

import game.active.DefaultGameRunner;
import game.command.LeagueCommand;
import game.command.RewardCommand;
import game.runner.GameRunner;
import org.junit.jupiter.api.Test;

class RewardPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void reward1() {
        runner.all1(px -> {
            RewardPlayer p = new RewardPlayer(px);
//            this.rewardLianmengBang(p);
            this.reward_kua_zhizhi(p);

//            this.reward(p);
//                this.reward_qinmi(p);
//            p.runAction3("{\"huodong2\":{\"hd238Get\":[]},\"rsn\":\"%s\"}");
//            for(int i = 1; i<=3; i++){
//                p.rewardMeili();
//                p.rewardQinmi();
//                p.rewardQinmi();
//                p.rewardQinmi();
//                p.rewardQinmi();
//                p.rewardGuoli();
//                p.rewardLiangshi();
//                p.rewardLiangshi();
//                p.rewardLiangshi();
//                p.rewardLiangshi();
//                p.rewardLiangshi();
//                p.rewardYuanbao();
//                p.rewardYuanbao();
//            }

//                p.rewardYuanbao();
//                p.rewardYuanbao();
//            p.rewardYuanbao();
//            p.rewardYuanbao();
//            p.rewardYuanbao();
            p.runAction2(LeagueCommand.goShop);

            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(2));
            p.runAction2(LeagueCommand.buyShopItem(2));
            p.runAction2(LeagueCommand.buyShopItem(2));

            p.runAction2(LeagueCommand.buyShopItem(8));
            p.runAction2(LeagueCommand.buyShopItem(8));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));

//            HuodongPlayer hp = new HuodongPlayer(p);
//            hp.randomSaima();


//            for (int i = 1; i <= 18; i++) {
//                p.rewardLianmengBoss();
//            }
//
//            HuodongPlayer hp = new HuodongPlayer(px);
//            hp.zhongshuReward();
//            hp.danzhu();

//            RewardPlayer p = new RewardPlayer(px);
//
//            p.rewardMeili();
//            p.rewardMeili();
//
//            p.runAction2(LeagueCommand.pickUpRwd());
//
//            for(int i = 1; i <= 9; i++){
//                p.rewardQinmi();
//                p.rewardLiangshi();
//                p.rewardTilidan();
//            }
//
//            p.rewardLiangshi();
//            p.rewardLiangshi();
//            p.rewardLiangshi();
//            p.rewardLiangshi();
//            p.rewardLiangshi();
//
//            p.rewardGuoli();
//            p.rewardGuoli();
//
//            p.runAction2(LeagueCommand.goShop);
//            p.runAction2(LeagueCommand.buyShopItem(5));
//            p.runAction2(LeagueCommand.buyShopItem(5));


//            this.rewardLianmengBang(p);

//            for(int i = 1; i <= 4; i++){
//                p.rewardMeili();
//                p.rewardQinmi();
//                p.rewardYinliang();
//                p.rewardYinliang();
//            }
//
//
//            for(int i = 1; i <= 7; i++){
//                p.rewardYinliang();
////                p.rewardHuolidan();
//                p.rewardGuoli();
//                p.rewardGuoli();
//
////                p.rewardZhengzai();
//            }
//            p.rewardZhengzai();
//            p.rewardZhuangban();
//            p.reward_kua_guoli();
//            for(int i = 1; i <= 6; i++){
//                p.rewardYuanbao();
//            }
//            p.reward_kua_qinmi();
//
//            HuodongPlayer hp = new HuodongPlayer(p);
//            hp.chijiReward();
//            p.rewardLiangshi();
//            p.rewardLiangshi();
//            p.rewardZhengzai();
//            p.rewardZhengzai();
//            for(int i = 1; i <= 6; i++){
//                p.rewardQinmi();
//                p.rewardGuoli();
//                p.rewardLiangshi();
//                p.rewardLiangshi();
//                p.rewardZhengzai();
//                p.rewardZhengzai();
//            }



//            p.rewardYinliang();

//            p.reward_ganen();

        });

        GameRunner.sleep(5);
    }

    public void reward_kua_zhizhi(RewardPlayer p){
        p.reward_kua_zizhi();

        for(int i = 1; i <= 10; i++){
            p.rewardGuoli();
        }
        for (int i = 1; i <= 13; i++) {
            p.rewardSchool();
        }

    }

    public void reward_qinmi(RewardPlayer p){
        for(int i = 1; i <= 3; i++){
            p.rewardGuoli();
            p.rewardQinmi();
            p.rewardQinmi();
            p.rewardQinmi();
            p.rewardLiangshi();
            p.rewardLiangshi();
            p.rewardLiangshi();
            p.rewardLiangshi();
            p.rewardLiangshi();
        }

    }

    public void rewardMeiliBang(RewardPlayer p){
        for (int i = 1; i <= 10; i++) {
            p.rewardTilidan();
            p.rewardMeili();
            p.rewardQinmi();
            p.rewardGuoli();
            p.rewardLiangshi();
            p.rewardHuolidan();
            p.rewardJinglidan();
            p.rewardYuanbao();
            p.rewardLianyin();
        }
    }



    public void rewardLianmengBang(RewardPlayer p){

        for (int i = 1; i <= 18; i++) {
            p.rewardLianmengBoss();
        }

        for (int i = 1; i <= 15; i++) {
            p.rewardShibing();
        }

        for (int i = 1; i <= 10; i++) {
            p.rewardGuoli();
//            p.rewardYuanbao();
            p.rewardKillLianmengBoss();
        }

//        p.rewardKillXiongnu();
    }

    @Test
    void reward_kuayamen_test()  {
        runner.all1(p -> {
//            for(int i = 33; i <= 37; i++){
//                p.runAction1(BaseCommand.houseMake(12, i));
//            }
//            for(int i = 38; i <= 41; i++){
//                p.runAction1(BaseCommand.houseMake(11, i));
//            }
            p.runAction2(RewardCommand.getKuaYamenReward());
            RewardPlayer rp = new RewardPlayer(p);
            for(int i = 1; i <= 5; i++){
                rp.rewardYuanbao();
                rp.rewardGuoli();
            }

//            p.runAction2(BaseCommand.mengzhan(36));

        });

        GameRunner.sleep(5);
    }

    @Test
    void reward_kua_league_test()  {
        runner.all1(px -> {
            RewardPlayer p = new RewardPlayer(px);
            p.reward_league();
            p.runAction2(LeagueCommand.goShop);
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(5));
        });
    }

    @Test
    void reward_kua_qinmi_test()  {
        runner.all1(px -> {
            RewardPlayer p = new RewardPlayer(px);
//            p.reward_kuayamen();
            p.reward_kua_qinmi();
            for(int i = 1; i <= 7; i++){
                p.rewardQinmi();
                p.rewardLiangshi();
                p.rewardLiangshi();
                p.rewardZhengzai();
                p.rewardYuanbao();
            }


            p.runAction2(LeagueCommand.goShop);
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(2));
            p.runAction2(LeagueCommand.buyShopItem(2));
            p.runAction2(LeagueCommand.buyShopItem(2));
            p.runAction2(LeagueCommand.buyShopItem(3));
            p.runAction2(LeagueCommand.buyShopItem(3));
            p.runAction2(LeagueCommand.buyShopItem(3));
            p.runAction2(LeagueCommand.buyShopItem(3));
            p.runAction2(LeagueCommand.buyShopItem(8));
            p.runAction2(LeagueCommand.buyShopItem(8));
            p.runAction2(LeagueCommand.upgradeSeat(1));
            p.runAction2(LeagueCommand.buyShopItem(5));

//            for(int i = 1; i <= 5; i++){
//                p.runAction2(LeagueCommand.xsupgrade(55));
//            }

//            p.reward
//                    HuodongPlayer hp = new HuodongPlayer(px);
//                    hp.
//            hp.chijiReward();

//            hp.runAction2()
        });

        GameRunner.sleep(5);
    }

    @Test
    void reward_kua_meili_test()  {
        runner.all1(px -> {
            RewardPlayer p = new RewardPlayer(px);
            p.reward_kua_meili();

            for(int i = 1; i <= 5; i++){
                p.rewardGuoli();
                p.rewardQinmi();
                p.rewardShibing();
                p.rewardShibing();
                p.rewardShibing();
                p.rewardYuanbao();
                p.rewardMeili();
            }
            p.rewardMeili();

            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(2));
            p.runAction2(LeagueCommand.buyShopItem(2));
            p.runAction2(LeagueCommand.buyShopItem(2));
            p.runAction2(LeagueCommand.buyShopItem(3));
            p.runAction2(LeagueCommand.buyShopItem(3));
            p.runAction2(LeagueCommand.buyShopItem(3));
            p.runAction2(LeagueCommand.buyShopItem(3));
            p.runAction2(LeagueCommand.buyShopItem(8));
            p.runAction2(LeagueCommand.buyShopItem(8));
//            p.runAction2(LeagueCommand.upgradeSeat(1));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));


        });

        GameRunner.sleep(5);
    }

    @Test
    void reward_kua_guoli_test()  {
        runner.all1(px -> {
            RewardPlayer p = new RewardPlayer(px);
            p.reward_kua_guoli();


            HuodongPlayer hp = new HuodongPlayer(px);
            hp.longzhu();

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
////            p.runAction2(LeagueCommand.upgradeSeat(1));
//            p.runAction2(LeagueCommand.buyShopItem(5));

        });

        GameRunner.sleep(5);
    }


}