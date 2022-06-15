package game.service;

import game.config.Flags;
import game.player.BasePlayer;
import game.player.Double11Player;
import game.player.JuediYamenPlayer;
import game.player.YamenPlayer;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.function.Consumer;

public class XiaohaoRunner implements Consumer<BasePlayer> {

    @Override
    public void accept(BasePlayer p) {
        LocalDateTime dt = LocalDateTime.now();
        int h = dt.getHour();

        //1,5,9,13,17,21
        //30+
        p.xiaohaosjxo();
        p.xunfun2();

        if(h % 5 == 0){
            p.harvest();
            p.xiaohaoPlant();
        }

        if (h % 4 == 1) {
            p.schoolOne();

            p.son();

            p.zhengwu1();
            p.jingying();
            for(int i = 1; i <= Flags.cook; i++){
                p.cookOne();
            }

        }

        if (h == 10 || h == 18 || h == 14 || h == 16) {
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

        if (h == 0) {
            doAt0(p);
        } else if (h == 2) {
            doAt2(p);
        } else if (h == 3) {
            doAt3(p);
        } else if (h == 7) {
            doAt7(p);
        } else if (h == 8) {
            doAt10(p);
        } else if (h == 12) {
            doAt12(p);
        } else if (h == 19) {
            doAt19(p);
        } else if (h == 20) {
            doAt20(p);
        } else if (h == 22) {
            doAt22(p);
        } else if (h == 23) {
            doAt23(p);
        }
    }

    /**
     * 低保，丝路，讨伐，打猎   15+次
     *
     * @param p
     */
    public void doAt0(BasePlayer p) {
        p.gold();
        p.gold2();

        p.silu();
        p.taofa();

        p.hunt();

        p.yardward();
        p.buyZhongzi();
        p.mobaiZJ();


    }

    /**
     * 牢犯 和建设联盟  10+次
     *
     * @param p
     */
    public void doAt2(BasePlayer p) {
        p.laofan();
        p.householdMake();
        p.buyXiongnu();
    }


    /**
     * 盟战 2 次
     *
     * @param p
     */
    public void doAt3(BasePlayer p) {

        LocalDateTime dt = LocalDateTime.now();
        DayOfWeek w = dt.getDayOfWeek();

        if (w.getValue() % 2 == 0) {
            p.mengzhanReward();
            p.mengzhan();
        }

        p.buybook();
        p.buyItem3();
        p.shopCanjuan();

    }

    /**
     * Hit club boss 50+次
     *
     * @param p
     */
    public void doAt7(BasePlayer p) {
        p.hitboss();
    }

    private void doAt10(BasePlayer p) {
        p.son_allDone();
    }


    /**
     * 匈奴  50+ 次
     *
     * @param p
     */
    public void doAt12(BasePlayer p) {
        p.menggu();
    }

    /**
     * 买匈奴道具  40+ 次
     *
     * @param p
     */
    public void doAt19(BasePlayer p) {

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
     *
     * @param p
     */
    public void doAt22(BasePlayer p) {

    }

    /**
     * 领取每日奖励， 和四善  20+
     *
     * @param p
     */
    public void doAt23(BasePlayer p) {

        p.taskReward();
        p.weekLoginReward();

//        Double11Player dp = new Double11Player(p);
//        dp.sishantiaozhan();
    }

}
