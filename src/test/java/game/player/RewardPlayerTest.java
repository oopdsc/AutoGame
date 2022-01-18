package game.player;

import game.active.DefaultGameRunner;
import game.player.RewardPlayer;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static game.service.GameRunner.RUNNER;

class RewardPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void reward1() throws IOException {
        runner.processSingle(RUNNER, px -> {
            RewardPlayer p = new RewardPlayer(px);

//            this.rewardLianmengBang(p);

            p.reward_ganen();

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

}