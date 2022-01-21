package game.player;

import game.active.DefaultGameRunner;
import game.config.Flags;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import static org.junit.jupiter.api.Assertions.*;

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
    void singleCook() {
        runner.single(GameRunner.RUNNER, d -> d.username.equals("wang25687"), p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 5; i++){
                qp.cook();
            }
        });
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
        runner.multi(GameRunner.RUNNER, d -> d.huodong, p -> {
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
        int num = 5;
        int id = 1253;
        runner.single("huodong.json", p -> {
            p.son2();
            for(int i = 1; i <= num; i++){
                p.sonFood2(id);
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
            GameRunner.sleepInMillis(runner.rd.nextInt(1000));
            QinmiPlayer dp = new QinmiPlayer(p);
            dp.clubQinmi();
        });
        GameRunner.sleep(600);
        System.out.println(all1);
    }

    @Test
    public void xiaohaoQinmi(){
        runner.processMulti("huodong.json", p -> {
            GameRunner.sleepInMillis(runner.rd.nextInt(1000));
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 400; i++){
                qp.qinmi12();
            }
        });

        GameRunner.sleep(20);
        System.out.println("done");
    }


}