package game.backup;

import game.active.DefaultGameRunner;
import game.config.Flags;
import game.player.BasePlayer;
import game.player.Double11Player;
import game.player.YamenPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static game.service.GameRunner.*;

//@Component
public class Xiaohao1Task {
//
//    Logger logger = LoggerFactory.getLogger(Xiaohao1Task.class);
//
//    DefaultGameRunner runner = new DefaultGameRunner();
//
////    @Scheduled(cron = "0 40 1 * * ?")
//    public void taskAt130() throws IOException {
//        runner.singleXiaohao1(p->{
//            p.gold();
//            p.hitboss();
//            p.buybook();
//            p.silu();
//            p.taofa();
//            p.laofan();
//            p.yardward();
//            p.buyZhongzi();
//            p.mobaiZJ();
//        });
//    }
//
//    //每两个小时打衙门
////    @Scheduled(cron = "0 32 0,2,4,6 * * ?")
//    public void yamenTask() throws IOException {
//        runner.processSingle(XIAOHAO, p -> {
//            p.yamen3();
//
//            if (Flags.kuayamen) {
//                YamenPlayer yp = new YamenPlayer(p);
//                yp.kua_yamen();
//            }
//        });
//    }
//
////    @Scheduled(cron = "0 7/30 * * * ?")
//    public void hourly() throws IOException {
//        runner.singleXiaohao1(p->{
//            p.harvest();
//            p.xiaohaoPlant();
//            p.son();
//            p.sjxo();
//            p.xunfun2();
//            p.zhengwu1();
//            p.jingying();
//            p.schoolOne(1, 55);
//            p.schoolOne(2, 1);
//            p.schoolOne(3, 2);
//            p.schoolOne(4, 38);
//            p.schoolOne(5, 41);
//        });
//    }
//
////    @Scheduled(cron = "0 25 1 * * TUE,THU,SAT")
//    public void mengzhan() throws IOException {
//        runner.processSingle(XIAOHAO, p->{
//            p.mengzhanReward();
//            p.mengzhan();
//        });
//    }
//
////    @Scheduled(cron = "0 2 20 * * ?")
//    public void hitxiongnu() throws IOException {
//        runner.singleXiaohao1(p -> {
//            if(Flags.xiongnu){
//                p.hitXiongnu();
//            }
//            p.taskReward();
//            p.weekLoginReward();
//            p.buyXiongnu();
//
//            Double11Player dp = new Double11Player(p);
//            dp.sishantiaozhan();
//        });
//    }
//
//    //每个小时收菜
//    @Scheduled(cron = "11 6 * * * ?")
//    public void shoucai() throws IOException {
//
//        Flags.xiaohao1 = "true";
//
//        LocalDateTime dt = LocalDateTime.now();
//        int h = dt.getHour();
//
//        runner.processSingle(XIAOHAO1,
//                p -> {
//
//                    try{
//                        Flags.xiaohao1 = p.data.username;
//
//                        //1,5,9,13,17,21
//                        //30+
//                        if(h % 4 == 1){
//                            p.harvest();
//                            p.xiaohaoPlant();
//
//                            p.schoolOne(1, 55);
//                            p.schoolOne(2, 1);
//                            p.schoolOne(3, 2);
//                            p.schoolOne(4, 38);
//                            p.schoolOne(5, 41);
//
//                            p.son();
//                            p.xiaohaosjxo();
//                            p.xunfun2();
//                            p.zhengwu1();
//                            p.jingying();
//                        }
//
//                        if(h == 8 || h == 11 || h == 14 || h == 16){
//                            p.yamen3();
//
//                            if (Flags.kuayamen) {
//                                YamenPlayer yp = new YamenPlayer(p);
//                                yp.kua_yamen();
//                            }
//                        }
//
//                        if(h == 0){
//                            doAt0(p);
//                        } else if(h == 2){
//                            doAt2(p);
//                        } else if(h == 3){
//                            doAt3(p);
//                        } else if(h == 7){
//                            doAt7(p);
//                        } else if(h == 10){
//                            doAt10(p);
//                        } else if(h == 12){
//                            doAt12(p);
//                        }else if(h == 19){
//                            doAt19(p);
//                        } else if(h == 22){
//                            doAt22(p);
//                        } else if(h == 23){
//                            doAt23(p);
//                        }
//
//                        sleep(Flags.sleepTime);
//                    } catch (Exception e) {
//                        logger.error(p.data.username + e.getMessage(), e);
//                    }
//
//                });
//
//        Flags.xiaohao1 = "false";
//    }
//
//    /**
//     * 低保，丝路，讨伐，打猎   15+次
//     * @param p
//     */
//    public void doAt0(BasePlayer p){
//        p.gold();
//        p.gold2();
//
//        p.silu();
//        p.taofa();
//
//        p.yardward();
//
//        p.buyZhongzi();
//        p.mobaiZJ();
//    }
//
//    /**
//     * 牢犯 和建设联盟  10+次
//     * @param p
//     */
//    public void doAt2(BasePlayer p){
//        p.laofan();
//        p.householdMake();
//    }
//
//
//    /**
//     * 盟战 2 次
//     * @param p
//     */
//    public void doAt3(BasePlayer p){
//
//        LocalDateTime dt = LocalDateTime.now();
//        DayOfWeek w = dt.getDayOfWeek();
//
//        if(w.getValue() % 2 == 0){
//            p.mengzhanReward();
//            p.mengzhan();
//        }
//
//    }
//
//    /**
//     * Hit club boss 50+次
//     * @param p
//     */
//    public void doAt7(BasePlayer p){
//        p.hitboss();
//    }
//
//    private void doAt10(BasePlayer p) {
//        p.son_allDone();
//    }
//
//
//    /**
//     * 匈奴  50+ 次
//     * @param p
//     */
//    public void doAt12(BasePlayer p){
//        p.menggu();
//    }
//
//    /**
//     * 买匈奴道具  40+ 次
//     * @param p
//     */
//    public void doAt19(BasePlayer p){
//        p.buyXiongnu();
//    }
//
//    /**
//     * 买副本道具，和酒店  50+ 次
//     * @param p
//     */
//    public void doAt22(BasePlayer p){
//        p.buybook();
//
//        p.shopCanjuan();
//    }
//
//    /**
//     * 领取每日奖励， 和四善  20+
//     * @param p
//     */
//    public void doAt23(BasePlayer p){
//
//        p.taskReward();
//        p.weekLoginReward();
//
//        Double11Player dp = new Double11Player(p);
//        dp.sishantiaozhan();
//    }
}
