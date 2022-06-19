package game.player;

import game.active.DefaultGameRunner;
import game.command.BaseCommand;
import game.command.LeagueCommand;
import game.command.RewardCommand;
import game.player.RewardPlayer;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.Level;

import static game.service.GameRunner.RUNNER;

class RewardPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void reward1() {
        runner.all1(px -> {
            RewardPlayer p = new RewardPlayer(px);

            p.rewardMeili();
            p.rewardMeili();

            p.runAction2(LeagueCommand.pickUpRwd());

            for(int i = 1; i <= 9; i++){
                p.rewardQinmi();
                p.rewardLiangshi();
                p.rewardTilidan();
            }

            p.rewardLiangshi();
            p.rewardLiangshi();
            p.rewardLiangshi();
            p.rewardLiangshi();
            p.rewardLiangshi();

            p.rewardGuoli();
            p.rewardGuoli();

            p.runAction2(LeagueCommand.goShop);
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));


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
            p.rewardYuanbao();
            p.rewardKillLianmengBoss();
        }

        p.rewardKillXiongnu();
    }

    @Test
    void reward_kuayamen_test()  {
        runner.all1(p -> {
            for(int i = 33; i <= 37; i++){
                p.runAction1(BaseCommand.houseMake(12, i));
            }
            for(int i = 38; i <= 41; i++){
                p.runAction1(BaseCommand.houseMake(11, i));
            }
//            p.runAction2(RewardCommand.getKuaYamenReward());
//            p.runAction2(BaseCommand.mengzhan(36));

        });

        GameRunner.sleep(5);
    }

    @Test
    void reward_kua_qinmi_test()  {
        runner.all1(px -> {
            RewardPlayer p = new RewardPlayer(px);
            p.reward_kua_qinmi();

//            for(int i = 1; i <= 7; i++){
//                p.rewardQinmi();
//                p.rewardLiangshi();
//                p.rewardLiangshi();
//                p.rewardZhengzai();
//            }
//            p.reward
                    HuodongPlayer hp = new HuodongPlayer(px);
            hp.chijiReward();
        });

        GameRunner.sleep(5);
    }

    @Test
    void reward_kua_meili_test()  {
        runner.all1(px -> {
            RewardPlayer p = new RewardPlayer(px);
            p.reward_kua_meili();
        });

        GameRunner.sleep(5);
    }

    @Test
    void reward_kua_guoli_test()  {
        runner.all1(px -> {
            RewardPlayer p = new RewardPlayer(px);
            p.reward_kua_guoli();
        });

        GameRunner.sleep(5);
    }


}