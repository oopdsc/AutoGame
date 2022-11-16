package game.player;

import game.active.DefaultGameRunner;
import game.command.LeagueCommand;
import game.config.Flags;
import game.runner.GameRunner;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

class QinmiPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void allCook() {

        int size = 25;

        runner.all(p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= size; i++){
                qp.cookOne();
            }

        });

        GameRunner.sleep(12 * size);
        System.out.println("done");
    }

    @Test
    void allUseCook() {
        runner.all1( p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            qp.useCook(3);

            p.runAction2(LeagueCommand.goShop);
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));


        });

        System.out.println("done");
    }
//    DAHAO     :  - 14757 = 3132
//    XIAOHAO 1 : 14754 - 11622 = 3132
//    XIAOHAO 2 : 17922 - 14754 = 3168
    @Test
    void singleUseCook() {
        runner.processSingle(GameRunner.DAHAO, p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            qp.useCook(3);

            p.runAction2(LeagueCommand.goShop);
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));

        });

        System.out.println("done");
    }



    @Test
    void singleCook() {
        runner.single(GameRunner.DAHAO, d -> d.username.equals("wang25687"), p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 4; i++){
                qp.cook();
            }
        });
    }


    @Test
    void useSingleItem() {
        StopWatch sw = new StopWatch();
        sw.start();
        int qinmi1 = 0;
        int qinmi2 = 0;
        int qinmi3 = 600;
        runner.processSingle("child.json", p -> {
//            402
            for(int i = 1; i <= qinmi1; i++){
                p.qinmi11();
            }

            for(int i = 1; i <= qinmi2; i++){
                p.qinmi12();
            }

            for(int i = 1; i <= qinmi3; i++){
                p.qinmi13();
            }


        });
        sw.stop();
        System.out.println("done " + sw.getTotalTimeSeconds() );
    }

    /**
     * 担任用亲密道具1。个人亲密用
     * @param num
     */
    public void useSingleQinmiItems1(int num) {
        StopWatch sw = new StopWatch();
        sw.start();
        runner.processSingle(GameRunner.HUODONG, p -> {
            for(int i = 1; i <= num; i++){
                p.qinmi11();
            }
        });
        sw.stop();
        System.out.println("done " + sw.getTotalTimeSeconds() );
    }

    /**
     * 担任用亲密道具2。个人亲密用
     * @param num
     */
    public void useSingleQinmiItems2(int num){
        StopWatch sw = new StopWatch();
        sw.start();
        runner.processSingle(GameRunner.HUODONG, p -> {
            for(int i = 1; i <= num; i++){
                p.qinmi12();
            }
        });
        sw.stop();
        System.out.println("done " + sw.getTotalTimeSeconds() );
    }

    /**
     * 担任用亲密道具3。个人亲密用
     * @param num
     */
    public void useSingleQinmiItems3(int num) {
        StopWatch sw = new StopWatch();
        sw.start();
        runner.processSingle(GameRunner.HUODONG, p -> {
            for(int i = 1; i <= num; i++){
                p.qinmi13();
            }
            GameRunner.sleep(Flags.sleepTime);
        });
        sw.stop();
        System.out.println("done " + sw.getTotalTimeSeconds() );
    }


    /**
     * 多线程用亲密道具1. 联盟亲密用
     * @param num
     */
    public void alluseQinmiItems1(int num) {
        runner.multi("clubQinmi.json", d -> d.huodong, p -> {
            for(int i = 1; i <= num; i++){
                p.qinmi11();
            }
        });
        GameRunner.sleep(100);
        System.out.println("done");
    }

    /**
     * 多线程用亲密道具2. 联盟亲密用
     * @param num
     */
    public void alluseQinmiItems2(int num) {
        runner.multi(GameRunner.RUNNER, d -> d.huodong, p -> {
            for(int i = 1; i <= num; i++){
                p.qinmi12();
            }
        });
        GameRunner.sleep(100);
        System.out.println("done");
    }


    /**
     * 子嗣活动 冲榜
     */
    @Test
    public void sonFood2(){
        int num = 42;
        int id = 1332;
        runner.single("huodong.json", p -> {
            p.son2();
            for(int i = 1; i <= num; i++){
                p.sonFood2(1334);
                p.sonFood2(1351);
                p.son2();
            }
        });
        System.out.println("done");
    }


    @Test
    public void silkrold(){
        runner.single("huodong.json", p -> {
            for(int i = 5; i <= 50; i++){
                p.runAction4("{\"silkroad\":{\"play\":{\"gid\":"+i+"}},\"rsn\":\"%s\"}");
            }
        });
        System.out.println("done");
    }


    @Test
    void clubQinmireward(){
        String all1 = runner.all1( p -> {
//            GameRunner.sleepInMillis(runner.rd.nextInt(1000));
            QinmiPlayer dp = new QinmiPlayer(p);
            dp.clubQinmi();

            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.buyShopItem(1));
            p.runAction2(LeagueCommand.upgradeSeat(1));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));
            p.runAction2(LeagueCommand.buyShopItem(5));
        });
//        GameRunner.sleep(600);
        System.out.println(all1);
    }

    @Test
    public void xiaohaoQinmiClub(){
        runner.all1(null, p->{
            QinmiPlayer qp = new QinmiPlayer(p);
            p.data.wifeId = 2;
            for(int i = 1; i <= 30; i++){
                qp.qinmi11();
                qp.qinmi12();
            }
        }, p->{
            QinmiPlayer qp = new QinmiPlayer(p);
            p.data.wifeId = 2;
            for(int i = 1; i <= 30; i++){
                qp.qinmi11();
                qp.qinmi12();
            }
        });

    }

    @Test
    public void xiaohaoQinmi1(){
//        runner.processMulti("clubQinmi.json", p -> {
//        runner.processSingle("clubQinmi.json", p -> {
            runner.processSingle(GameRunner.XIAOHAO1, p -> {
//            GameRunner.sleepInMillis(runner.rd.nextInt(1000));
            QinmiPlayer qp = new QinmiPlayer(p);
//            for(int i = 1; i <= 500; i++){
//                qp.qinmi11();
//            }
            for(int i = 1; i <= 500; i++){
                qp.qinmi11();
            }
        });

//        GameRunner.sleep(20);
        System.out.println("done");
    }

    @Test
    public void xiaohaoQinmi2(){
//        runner.processMulti("clubQinmi.json", p -> {
//        runner.processSingle("clubQinmi.json", p -> {
        runner.processSingle(GameRunner.XIAOHAO2, p -> {
//            GameRunner.sleepInMillis(runner.rd.nextInt(1000));
            QinmiPlayer qp = new QinmiPlayer(p);
//            for(int i = 1; i <= 500; i++){
//                qp.qinmi11();
//            }
            for(int i = 1; i <= 600; i++){
                qp.qinmi11();
            }
        });

//        GameRunner.sleep(20);
        System.out.println("done");
    }

    @Test
    public void xiaohaoQinmi3(){
        runner.processMulti("clubQinmi2.json", p -> {
            GameRunner.sleepInMillis(runner.rd.nextInt(200));
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 130; i++){
                qp.qinmi12();
            }
        });

        GameRunner.sleep(20);
        System.out.println("done");
    }

    @Test
    public void xunfang_test(){
        runner.all1(p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 50; i++){
                qp.xunfun();
                qp.xunfunRecover();
            }
            qp.xunfun();

        }, p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 30; i++){
                qp.xunfun2();
                qp.xunfunRecover();
            }
            qp.xunfun2();

        }, p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 30; i++){
                qp.xunfun2();
                qp.xunfunRecover();
            }
            qp.xunfun2();

        });
        System.out.println("done");
    }


    @Test
    public void sjxo_test(){
        runner.all1(p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 50; i++){
                qp.yjxo();
                qp.useXoItems();
            }
            qp.yjxo();

        }, p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 20; i++){
                qp.sjxo();
                qp.useXoItems();
            }
            qp.sjxo();

        }, p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 20; i++){
                qp.sjxo();
                qp.useXoItems();
            }
            qp.sjxo();

        });
        System.out.println("done");
    }


}