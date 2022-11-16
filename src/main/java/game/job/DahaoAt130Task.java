package game.job;

import game.active.DefaultGameRunner;
import game.command.LeagueCommand;
import game.config.Flags;
import game.player.*;
import game.service.LianmengService;
import game.service.TongmengService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class DahaoAt130Task {

    Logger logger = LoggerFactory.getLogger(Xiaohao2Task.class);

    DefaultGameRunner runner = new DefaultGameRunner();

    //晚上8点匈奴
    @Scheduled(cron = "7 3 20 * * ?")
    public void hitXiongnu(){
        runner.shuffleDahao(p -> {
            doAt20(p);
        });
    }

    //每个小时收菜
    @Scheduled(cron = "7 5 * * * ?")
    public void shoucai() {
        LocalDateTime dt = LocalDateTime.now();
        int h = dt.getHour();

        if(h == 20){
            return;
        }else{

            runner.singleDahao(
                    p -> {
                        p.sjxo();
                        //1,5,9,13,17,21
                        //30+
                        if(h % 4 == 1){
                            p.harvest();
                            p.plant();
                            p.school();

                            p.son();

                            p.xunfun();
                            p.zhengwu1();
                            p.jingying();

                            for(int i = 1; i <= Flags.cook; i++){
                                p.cookOne();
                            }
                        }

                        if(h == 10 || h == 18 || h == 14 || h == 16){
                            p.yamen3();
                            if (Flags.kuayamen) {
                                YamenPlayer yp = new YamenPlayer(p);
                                yp.kua_yamen();
                            }

                            if (Flags.jdyamen) {
                                JuediYamenPlayer yp = new JuediYamenPlayer(p);
                                yp.kua_jdyamen();
                            }
                        }

                        if(h == 0){
                            doAt0(p);
                        } else if(h == 2){
                            doAt2(p);
                        } else if(h == 3){
                            doAt3(p);
                        }else if(h == 7){
                            doAt7(p);
                        } else if(h == 8){
                            doAt10(p);
                        } else if(h == 12){
                            doAt12(p);
                        }else if(h == 15){
                            doAt15(p);
                        }else if(h == 19){
                            doAt19(p);
                        }else if(h == 22){
                            doAt22(p);
                        } else if(h == 23){
                            doAt23(p);
                        }
                    });

        }


    }

    private void doAt10(BasePlayer p) {
        p.son_allDone();

        p.runAction2(LeagueCommand.enter);
        p.startFuben();
    }

    /**
     * 低保，丝路，讨伐，打猎   15+次
     * @param p
     */
    public void doAt0(BasePlayer p){
        p.gold();
        p.gold2();

        p.silu();
        p.taofa();

        p.hunt();

        p.yardward();
        p.buyZhongzi();
    }

    /**
     * 牢犯 和建设联盟  10+次
     * @param p
     */
    public void doAt2(BasePlayer p){
        p.laofan();
        p.householdMake();
        p.buyXiongnu();
    }


    /**
     * 盟战 2 次
     * @param p
     */
    public void doAt3(BasePlayer p){

        LocalDateTime dt = LocalDateTime.now();
        DayOfWeek w = dt.getDayOfWeek();

        if(w.getValue() == 3){
            RewardPlayer rp = new RewardPlayer(p);
            rp.rewardZhuangban();
        }

        if(w.getValue() % 2 == 0){
            p.mengzhanReward();
            p.mengzhan();
        }

        p.buybook();
        LianmengService.buyItems(p);
//        p.buyItem0();
//        p.buyItem3();
//        p.buyItem2();
//        p.buyItem1();
        p.shopCanjuan();


    }

    /**
     * Hit club boss 50+次
     * @param p
     */
    public void doAt7(BasePlayer p){
        if(p.data.openboss){
            p.openboss();
        }

        p.hitboss();
    }


    /**
     * 匈奴  50+ 次
     * @param p
     */
    public void doAt12(BasePlayer p){
        p.menggu();
        p.runAction2(LeagueCommand.enter);
        for (int i = 1; i <= 5; i++) {
            p.leagueBuild();
        }
    }

    public void doAt15(BasePlayer p){
    }

    /**
     * 买匈奴道具  40+ 次
     * @param p
     */
    public void doAt19(BasePlayer p){
        p.runAction2(LeagueCommand.enter);
        p.overFuben();
        p.runAction2(LeagueCommand.goShop);
        TongmengService.buyItems(p);
    }

    /**
     * 买匈奴道具  20+ 次
     * @param p
     */
    public void doAt20(BasePlayer p){

        if (Flags.xiongnu) {
            p.hitXiongnu();
        }


    }

    /**
     * 买副本道具，和酒店  50+ 次
     * @param p
     */
    public void doAt22(BasePlayer p){

    }

    /**
     * 领取每日奖励， 和四善  20+
     * @param p
     */
    public void doAt23(BasePlayer p){

        p.taskReward();
        p.weekLoginReward();

//        Double11Player dp = new Double11Player(p);
//        dp.sishantiaozhan();
    }



}
