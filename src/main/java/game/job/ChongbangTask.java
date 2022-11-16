package game.job;

import game.active.DefaultGameRunner;
import game.player.*;
import game.runner.GameRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.IOException;

//@Component
public class ChongbangTask {

    DefaultGameRunner runner = new DefaultGameRunner();

//    @Scheduled(cron = "10 46 21 * * ?")
    public void chongbang3() throws IOException {
        runner.single(GameRunner.HUODONG, p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            mp.buyBeast(3);
        });
    }

    @Scheduled(cron = "30 58 21 * * ?")
    public void chongbang2() throws IOException {
        System.out.println("hello");
    }
//    child 冲榜
//    @Scheduled(cron = "20 59 21 * * ?")
    public void child() throws IOException {
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single("child.json", p -> {
            p.son2();
            for(int i = 1; i <= 50; i++){
                p.sonFood2(1458);
                p.sonFood2(1459);
                p.son2();
            }

        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

//    @Scheduled(cron = "0 59 23 * * ?")
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
        runner.single("club.json", p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.highItemGongxian();

        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }


//        @Scheduled(cron = "54 59 21 * * ?")
    public void guoli(){
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single(GameRunner.HUODONG, p -> {
            for(int i = 1; i <= 6; i++){
                //女将光环
                p.runAction0("{\"hero\":{\"upghskill\":{\"sid\":16,\"id\":55}},\"rsn\":\"%s\"}");
            }

        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }

    @Scheduled(cron = "28 59 21 * * ?")
    public void club(){
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single("club.json", p -> {
            LianmengPlayer lp = new LianmengPlayer(p);
            lp.clubBossPk();
//            lp.highItemGongxian();
//            lp.getMengZhanReward();
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

//    @Scheduled(cron = "0 56 21 * * ?")
    public void meili() {
        runner.processSingle("huodong2.json", p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 1000; i++){
                mp.meili2();
            }
            for(int i = 1; i <= 3000; i++){
                mp.meili2();
            }
        });

        System.out.println("meili done");
    }

    @Scheduled(cron = "30 59 21 * * ?")
    public void beast() {
        System.out.println("beast start...");
        StopWatch sw = new StopWatch();
        sw.start();
        runner.single("huodong2.json", p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 10; i++){
                mp.upLvBeast2(1, 8);
                mp.upLvBeast2(2, 8);
                mp.upLvBeast2(3, 8);
            }
        });
        sw.stop();
        System.out.println("Done, time :" + sw.getTotalTimeSeconds());
    }



//    @Scheduled(cron = "0 49 21 * * ?")
    public void zizhi() {
        runner.processSingle(GameRunner.HUODONG, p -> {
                ZizhiPlayer zp = new ZizhiPlayer(p);

            for(int i = 1; i <= 1500; i++){
//                    {"hero":{"upzzskill":{"type":2,"sid":127,"num":1,"id":55}},"rsn":"5wwwfvfavaf"}
                zp.useJuanzhou0(127, 55);
            }

            for(int i = 1; i <= 2320; i++){
//                    {"hero":{"upzzskill":{"type":2,"sid":127,"num":1,"id":55}},"rsn":"5wwwfvfavaf"}
                zp.useJuanzhou0(169, 66);
            }

            for(int i = 1; i <= 1965; i++){
//                zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":109,\"num\":1,\"id\":51}},\"rsn\":\"%s\"}");
                zp.useJuanzhou0(150, 58);
            }

            for(int i = 1; i <= 100; i++){
                zp.useBook0(128, 55);
            }

            for(int i = 1; i <= 15; i++){
                zp.hanlinLvUp();
            }

//                for(int i = 1; i <= 450; i++){
//                    zp.useBook0(128, 55);
//                }

//                //郭嘉武力
//                for(int i = 1; i <= 100; i++){
//                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":66,\"num\":1,\"id\":41}},\"rsn\":\"%s\"}");
//                }
////                   孙武武力
//                for(int i = 1; i <= 200; i++){
//                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":47,\"num\":1,\"id\":28}},\"rsn\":\"%s\"}");
//                }
//                // 周瑜武力
//                for(int i = 1; i <= 100; i++){
//                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":63,\"num\":1,\"id\":38}},\"rsn\":\"%s\"}");
//                }
//
//                for(int i = 1; i <= 400; i++){
//                    //马云绿智力
//                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":127,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
//                    //郭嘉政治
//                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":67,\"num\":1,\"id\":41}},\"rsn\":\"%s\"}");
//                    //关银屏魅力
//                    zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":109,\"num\":1,\"id\":51}},\"rsn\":\"%s\"}");
//                }

        });

        System.out.println("zizhi done");
    }

}
