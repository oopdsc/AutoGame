package game.job;

import game.active.DefaultGameRunner;
import game.player.*;
import game.service.GameRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@Component
public class ChongbangTask {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Scheduled(cron = "10 59 21 * * ?")
    public void chongbang2() throws IOException {
        System.out.println("hello");
    }
    //child 冲榜
    @Scheduled(cron = "31 59 21 * * ?")
    public void chongbang() throws IOException {
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single(GameRunner.HUODONG, p -> {
            p.son2();
            for(int i = 1; i <= 42; i++){
                p.sonFood2(1334);
                p.sonFood2(1351);
                p.son2();
            }

        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

    @Scheduled(cron = "0 59 23 * * ?")
    public void double11() throws IOException {
        runner.single(GameRunner.HUODONG, p -> {

            HuodongPlayer hp = new HuodongPlayer(p);
//            hp.bu
            hp.buySchool();
            hp.buySchool();
            hp.buySchool();
            hp.buySchool();
            hp.xiaohaoFanli();
        });
    }


//    @Scheduled(cron = "27 59 21 * * ?")
    public void clubHighGongXian(){
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single("club2.json", p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.dayHighGongxian();

        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

//    @Scheduled(cron = "45 58 21 * * ?")
    public void club(){
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single("club.json", p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.club();
        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

//    @Scheduled(cron = "0 53 21 * * ?")
    public void qinmi() {
        runner.processSingle(GameRunner.HUODONG, p -> {
            for(int i = 1; i <= 10; i++){
                p.qinmi11();
            }

            for(int i = 1; i <= 2500; i++){
                p.qinmi12();
            }

            for(int i = 1; i <= 1000; i++){
                p.qinmi13();
            }

        });

        System.out.println("qinmi done");
    }

//    @Scheduled(cron = "30 59 21 * * ?")
    public void beast() {
        System.out.println("beast start...");
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single(GameRunner.HUODONG, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 6; i++){
                mp.upLvBeast2(1, 8);
                mp.upLvBeast2(2, 8);
                mp.upLvBeast2(3, 8);
            }
        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }



//    @Scheduled(cron = "0 57 21 * * ?")
    public void zizhi() {
        runner.processSingle(GameRunner.HUODONG, p -> {
                ZizhiPlayer zp = new ZizhiPlayer(p);

                //郭嘉武力
                for(int i = 1; i <= 100; i++){
                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":66,\"num\":1,\"id\":41}},\"rsn\":\"%s\"}");
                }
//                   孙武武力
                for(int i = 1; i <= 200; i++){
                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":47,\"num\":1,\"id\":28}},\"rsn\":\"%s\"}");
                }
                // 周瑜武力
                for(int i = 1; i <= 100; i++){
                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":63,\"num\":1,\"id\":38}},\"rsn\":\"%s\"}");
                }

                for(int i = 1; i <= 400; i++){
                    //马云绿智力
                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":127,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
                    //郭嘉政治
                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":67,\"num\":1,\"id\":41}},\"rsn\":\"%s\"}");
                    //关银屏魅力
                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":109,\"num\":1,\"id\":51}},\"rsn\":\"%s\"}");
                }

        });

        System.out.println("zizhi done");
    }

}
