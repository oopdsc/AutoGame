package game;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.active.DefaultGameRunner;
import game.player.GetInfoPlayer;
import game.player.HeroPlayer;
import game.player.MeiliPlayer;
import game.player.ZizhiPlayer;
import game.service.GameRunner;
import game.service.PlayerData;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

    @Test
    public void schoolOne(){
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single(GameRunner.HUODONG, p -> {

            p.schoolOne();

        });

        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }


    @Test
    public void bpvb(){
        StopWatch sw = new StopWatch();
        sw.start();
        int size = 3;
        for(int i = 1 ; i <= size; i++){
            runner.single(GameRunner.HUODONG, d -> d.heroid[0] > 1,p -> {

                //pgh12345 - 48
                //pgh123456 - 33
                String res = p.getAllinfo();
                DocumentContext dc = JsonPath.parse(res);

                Integer bmap = dc.read("$.a.user.guide.bmap");
                if(bmap.intValue() <= 130){

                    try {
                        FileUtils.write(new File("./Guanka.txt"), p.data.username + ":" + bmap.intValue() + "\n", true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    p.runAction3("{\"user\":{\"entergk\":[]},\"rsn\":\"%s\"}");

                    int smap = bmap.intValue()  * 40;
                    int mmap = bmap.intValue() * 5 + 1;

                    p.runAction3("{\"rsn\":\"%s\",\"guide\":{\"guide\":{\"smap\":"+smap  +",\"bmap\":"+bmap.intValue()+",\"mmap\":"+ mmap +"}}}");

                    p.pvb(p.data.heroid[0]);

                    p.runAction3("{\"rsn\":\"%s\",\"guide\":{\"guide\":{\"smap\":"+smap  +",\"bmap\":"+ (bmap.intValue() + 1)+",\"mmap\":"+ mmap +"}}}");

                    p.runAction3("{\"user\":{\"onekey_msg\":[]},\"rsn\":\"%s\"}");

                    p.bpvb();

                }else{
                    logger.info("{} current bmap is {}", p.data.username, bmap.intValue());
                }

            });
        }


        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }
}