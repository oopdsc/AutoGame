package game.backup;

import game.active.DefaultGameRunner;
import game.config.Flags;
import game.job.Xiaohao2Task;
import game.player.BasePlayer;
import game.player.Double11Player;
import game.player.YamenPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static game.service.GameRunner.DAHAO;
import static game.service.GameRunner.sleep;

//@Component
public class DahaoAt130Task {

//    Logger logger = LoggerFactory.getLogger(Xiaohao2Task.class);
//
//    DefaultGameRunner runner = new DefaultGameRunner();
//
//    //1点半打BOSS
////    @Scheduled(cron = "0 30 1 * * ?")
//    public void taskAt130() throws IOException {
//        runner.processSingle(DAHAO, d -> d.openboss, p -> {
//            p.openboss();
//        });
//        runner.dahao(p -> {
//
//            p.gold();
//            p.gold2();
//
//            p.silu();
//            p.taofa();
//
//            p.yardward();
//            p.hunt();
//
//            p.laofan();
//
//
//
//
//            p.buyItem0();
//            p.buyItem1();
//            p.buyItem2();
//            p.buyItem3();
//            p.buyXiongnu();
//
//            p.buyQiuyin();
//            p.shopCanjuan();
//
//            p.hitboss();
//
//            p.householdMake();
//        });
//    }
//
////    @Scheduled(cron = "0 20 1 * * TUE,THU,SAT")
//    public void mengzhan() throws IOException {
//        runner.processSingle(DAHAO, p -> {
//            p.mengzhanReward();
//            p.mengzhan();
//        });
//    }
//
//    //中午12点打匈奴
////    @Scheduled(cron = "0 3 12 * * ?")
//    public void menggu() throws IOException {
//        runner.dahao(p -> {
//            p.menggu();
//        });
//    }
//
//
////    @Scheduled(cron = "0 1 20 * * ?")
//    public void hitxiongnu() throws IOException {
//        runner.dahao(p -> {
//            if (Flags.xiongnu) {
//                p.hitXiongnu();
//            }
//
//            p.buyXiongnu();
//
//
//
//        });
//    }
//    //每两个小时打衙门
////    @Scheduled(cron = "0 30 0,2,4,6 * * ?")
//    public void yamenTask() throws IOException {
//        runner.processSingle(DAHAO, p -> {
//            p.yamen3();
//            if (Flags.kuayamen) {
//                YamenPlayer yp = new YamenPlayer(p);
//                yp.kua_yamen();
//            }
//
//        });
//    }

}
