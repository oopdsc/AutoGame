package game.player;

import game.active.DefaultGameRunner;
import game.runner.GameRunner;
import game.service.HuodongService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static game.runner.GameRunner.*;

class GetInfoPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    ExecutorService es = Executors.newWorkStealingPool(40);

    @Test
    void getAll() throws IOException {

//        FileUtils.write(new File("./"+ DAHAO +"/misc-20220816.txt"),
//                "名字,皮肤,书桌,钱,关卡,巾帼令,将臣布匹,书院装扮,巾帼装扮,联盟碎片,联盟道具,联盟高级道具," +
//                        "武力卷轴,智力卷轴,政治卷轴,魅力卷轴,卷轴,小黄书,大黄书," +
//                        "亲密1,亲密2,亲密包,魅力1,魅力2,酒楼,联盟\n", false);
//        FileUtils.write(new File("./"+ XIAOHAO1 +"/misc-20220430.txt"),
//                "名字,皮肤,书桌,钱,关卡,巾帼令,将臣布匹,书院装扮,巾帼装扮," +
//                        "武力卷轴,智力卷轴,政治卷轴,魅力卷轴,卷轴,小黄书,大黄书," +
//                        "亲密1,亲密2,亲密包,魅力1,魅力2\n", false);
//        FileUtils.write(new File("./"+ XIAOHAO2 +"/misc-20220430.txt"),
//                "名字,皮肤,书桌,钱,关卡,巾帼令,将臣布匹,书院装扮,巾帼装扮," +
//                        "武力卷轴,智力卷轴,政治卷轴,魅力卷轴,卷轴,小黄书,大黄书," +
//                        "亲密1,亲密2,亲密包,魅力1,魅力2\n", false);

//        FileUtils.write(new File("./"+ DAHAO +"/zz-20220810.txt"), "profile,姓名,id,等级,武力,战力,满武力,书籍经验,总资质\n");
//        FileUtils.write(new File("./"+ XIAOHAO1 +"/zz-20220428.txt"), "profile,姓名,id,等级,武力,战力,满武力,书籍经验,总资质\n");
//        FileUtils.write(new File("./"+ XIAOHAO2 +"/zz-20220428.txt"), "profile,姓名,id,等级,武力,战力,满武力,书籍经验,总资质\n");


        String all1 = runner.all1( p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(DAHAO);
        }, p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(XIAOHAO1);
        }, p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(XIAOHAO2);
        });

//        runner.processSingle( HUODONG, p -> {
//            GetInfoPlayer gp = new GetInfoPlayer(p);
//            gp.getAll(XIAOHAO2);
//        });

    }

    @Test
    void getMGMT() throws IOException {
        runner.processSingle(HUODONG, p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.mgft(DAHAO);
        });
    }

    @Test
    void numTest(){
        double lv = 400;
        double zz = 500;
        int aepE1 = 80000000;

        double zhanli = (double)(zz * lv) / 20000 + (double)(aepE1) / 100000000;

        System.out.println(zhanli);

        LocalDate ld = LocalDate.now();
        LinkedList<String> sat = new LinkedList<>();
        LinkedList<String> sun = new LinkedList<>();
        for(int i = 0; i <= 36; i++){
            if(DayOfWeek.SATURDAY.equals(ld.getDayOfWeek())){
                sat.addLast(ld.toString());
            }else if(DayOfWeek.SUNDAY.equals(ld.getDayOfWeek())){
                sun.addLast(ld.toString());
            }
            ld = ld.plusMonths(1);
        }

        System.out.println("sat:");
        for(String s : sat){
            System.out.println(s);
        }
        System.out.println("sun:");
        for(String s : sun){
            System.out.println(s);
        }

    }

    @Test
    void getZhuangban() {

        String all1 = runner.all1( p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getFzMainScoreInfo();
        });
        System.out.println(all1);

    }


    /**
     * 亲密活动排名
     */
    @Test
    void loveRankInfo() {

        runner.single(GameRunner.HUODONG, p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.loveRankInfo();

        });

    }

    @Test
    void listHero() {

        runner.single(RUNNER, p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll("all");
        });

    }


    @Test
    void openMail() {
        String all1 = runner.all1( p -> {
//        runner.processSingle(HUODONG, p-> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
//            p.householdMake();
            gp.openAllmail();
        });
//        System.out.println(all1);

    }

    @Test
    void hero_lvup_test() {
        runner.single("huodong.json", p ->{
            GetInfoPlayer gp = new GetInfoPlayer(p);
//            gp.hero_lvup(2);
//            gp.hero_lvup(13);
//            gp.hero_lvup(23);
//            gp.hero_lvup(24);
//            gp.hero_lvup(34);
//            gp.hero_lvup(33);
//            gp.hero_lvup(37);
//            gp.hero_lvup(26);
//            gp.hero_lvup(11);
//            gp.hero_lvup(12);
//
//            gp.hero_lvup(6);
//            gp.hero_lvup(16);
//            gp.hero_lvup(20);
//            gp.hero_lvup(44);

            gp.hero_lvup(28);
            gp.hero_lvup(35);
            gp.hero_lvup(39);
            gp.hero_lvup(40);
        });

    }

    @Test
    void hero_lvup_all_test() {
        runner.all1(p ->{
            GetInfoPlayer gp = new GetInfoPlayer(p);
//            gp.hero_lvup(2);
//            gp.hero_lvup(13);
//            gp.hero_lvup(23);
//            gp.hero_lvup(24);
//            gp.hero_lvup(34);
//            gp.hero_lvup(33);
//            gp.hero_lvup(37);
//            gp.hero_lvup(26);
//            gp.hero_lvup(11);
//            gp.hero_lvup(12);
//            gp.hero_lvup(6);
//            gp.hero_lvup(16);
//            gp.hero_lvup(20);
//            gp.hero_lvup(44);

            gp.hero_lvup(28);
            gp.hero_lvup(35);
            gp.hero_lvup(39);
            gp.hero_lvup(40);
        });
    }

    @Test
    void hero_lvup_all_test2() {
        runner.all1(p ->{
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.hero_lvup(41);
        });
    }

    @Test
    void hero_pkskill_lvup_test() {
        runner.single("huodong.json", p ->{
            GetInfoPlayer gp = new GetInfoPlayer(p);
//            gp.hero_pkskill_lvup(1);
        });
    }

    @Test
    void hero_pkskill_lvup_all_test() {
        runner.all1(p ->{
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.hero_pkskill_lvup(16, 28, 23);
//            gp.hero_pkskill_lvup(38);
//            gp.hero_pkskill_lvup(41);
//            gp.hero_pkskill_lvup(35);
//            gp.hero_pkskill_lvup(36);
//            gp.hero_pkskill_lvup(37);
//            gp.hero_pkskill_lvup(39);
//            gp.hero_pkskill_lvup(40);

//            for(int i = 33; i <= 37; i++){
//                gp.runAction2("{\"club\":{\"householdMake\":{\"id\":12,\"heroid\":"+i+"}},\"rsn\":\"%s\"}");
//            }
//            for(int i = 38; i <= 41; i++){
//                gp.runAction2("{\"club\":{\"householdMake\":{\"id\":11,\"heroid\":"+i+"}},\"rsn\":\"%s\"}");
//            }
        });
    }


}