package game;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.active.DefaultGameRunner;
import game.player.*;
import game.service.GameRunner;
import game.service.PlayerData;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static game.service.GameRunner.*;

class GameRunnerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void runner2(){
        runner.singleDahao(
                p -> {
                    p.sjxo();
                    p.gold();
                    p.gold2();

                    p.silu();
                    p.taofa();

                    p.hunt();

                    p.yardward();
                    p.buyZhongzi();

                    p.harvest();
                    p.plant();
                    p.school();

                    p.son();

                    p.xunfun();
                    p.zhengwu();
                    p.jingying();
                }
        );
    }

    @Test
    void runner1(){
        String all1 = runner.all1( p -> {
            for(int i = 1; i <= 12; i++){
                p.runAction2("{\"huodong2\":{\"hd962Start\":{\"num\":1}},\"rsn\":\"%s\"}");
            }

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.zajiActive();
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
    public void mengzhan(){
        StopWatch sw = new StopWatch();
        sw.start();
        runner.all1( p -> {

            p.mengzhan();

        });

        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
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
    public void yamen_test(){
        StopWatch sw = new StopWatch();
        sw.start();
        runner.all1(p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            hp.lishanXunli_daily();
            hp.zizhifanli();
            p.yamen3();
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

                    GameRunner.sleep(2);

                }else{
                    logger.info("{} current bmap is {}", p.data.username, bmap.intValue());
                }

            });
        }


        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

    @Test
    public void getRsn_test(){
//        for(int i = 1 ; i <= 9; i++){
//            for(int j = 1; j <= 5; j++){
//                logger.info(GameRunner.getRsn(i, j));
//            }
//        }


//        7cclllopodg
//        7ccxlllopxg
        logger.info(GameRunner.getRsn(7, 1));
    }

    @Test
    public void getDate_test(){
        long ts = (new Date().getTime() / 10000) % 100000000;

        long ltime = ts << 1;


        Date x = new Date();
//        x.setDate(13);
//        long ts2 = (x.getTime() / 10000) % 100000000;
//        long ltime2 = ts2 << 1;
        String x1 = String.valueOf(x.getTime()).substring(2, 10);

        logger.info("{} : {}", ltime, x1);
    }

    @Test
    public void gold() {
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single(GameRunner.HUODONG, p -> {
            p.hitboss();
        });
    }

}