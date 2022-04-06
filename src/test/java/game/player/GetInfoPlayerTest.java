package game.player;

import game.active.DefaultGameRunner;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static game.service.GameRunner.*;
import static org.junit.jupiter.api.Assertions.*;

class GetInfoPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    ExecutorService es = Executors.newWorkStealingPool(40);

    @Test
    void getAll() {

        String all1 = runner.all1( p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(DAHAO);
        }, p-> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(XIAOHAO1);
        }, p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(XIAOHAO2);
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
    void openMail() {
        String all1 = runner.all1( p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.openAllmail();
        });
        System.out.println(all1);

    }


    @Test
    void hero_lvup_test() {
        runner.single("huodong.json", p ->{
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.hero_lvup(44);
        });

    }

    @Test
    void hero_lvup_all_test() {
        runner.all1(p ->{
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.hero_lvup(1);
        });

    }

    @Test
    void hero_pkskill_lvup_test() {
        runner.single("huodong.json", p ->{
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.hero_pkskill_lvup(1);
        });
    }

    @Test
    void hero_pkskill_lvup_all_test() {
        runner.all1(p ->{
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.hero_pkskill_lvup(8);
        });
    }


}