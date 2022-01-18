package game;

import game.active.DefaultGameRunner;
import game.player.GetInfoPlayer;
import game.player.HeroPlayer;
import game.player.ZizhiPlayer;
import game.service.GameRunner;
import game.service.PlayerData;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static game.service.GameRunner.*;

class GameRunnerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void runner1(){
        String all1 = runner.all1( p -> {
            p.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":30,\"heroid\":41,\"id\":53}}}");
            p.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":30,\"heroid\":38,\"id\":33}}}");
        });
        System.out.println(all1);
    }

    @Test
    void runner() {
        runner.single(
                RUNNER,
//                DAHAO,
//                XIAOHAO1,
//                XIAOHAO2,
//                GOLD,

                d -> d.huodong,

                p -> {
//                    p.runAction3("{\"user\":{\"get_cj\":{\"id\":5}},\"rsn\":\"%s\"}");
                    p.chat();

                    ZizhiPlayer zp = new ZizhiPlayer(p);
                    zp.useJuanzhou(ZizhiPlayer.SID_5WULI, 55);
                    zp.useBook(ZizhiPlayer.SID_5ZHILI_JiaRenTieJi, 55);
                });

        System.out.println("done");
        GameRunner.sleep(10);
    }

    @Test
    void getInfo() {
//        FileUtils.write(new File("./courtyard.txt"), "username,lv,mc,sp,little tree zz,little tree,middle tree zz,middle tree,yumi zz,yumi", true);
        new GameRunner<GetInfoPlayer>() {

            @Override
            public GetInfoPlayer login(PlayerData data) {
                GetInfoPlayer p = new GetInfoPlayer(data);
                p.login();
                return p;
            }
        }.processSingle(
                RUNNER,
//                GOLD,
                d -> d.huodong,
                p -> {
//                    p.levelUp();
//                    p.getCourtyardInfo(true);
//                    p.getCourtyardInfo(false);
                    sleep(20);
//                    p.getBeastInfo();
//                    p.getMayunlv();
//                    p.getCash();
//                    p.loveRankInfo();
//                    p.openAllmail();
                }
        );

        GameRunner.sleep(3);
    }
}