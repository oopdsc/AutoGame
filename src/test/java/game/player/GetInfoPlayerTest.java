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

        Future<String> fDAHAO = es.submit(() -> {

            runner.singleDahao(p -> {
                GetInfoPlayer gp = new GetInfoPlayer(p);
                gp.getAll(DAHAO);
            });
            return "dahao";
        } );

        Future<String> fXIAOHAO1 = es.submit(() -> {

            runner.singleXiaohao1(p -> {
                GetInfoPlayer gp = new GetInfoPlayer(p);
                gp.getAll(XIAOHAO1);
            });
            return "XIAOHAO1";
        } );

        Future<String> fXIAOHAO2 = es.submit(() -> {

            runner.singleXiaohao2(p -> {
                GetInfoPlayer gp = new GetInfoPlayer(p);
                gp.getAll(XIAOHAO2);
            });
            return "XIAOHAO2";
        } );

        try {
            System.out.println(fDAHAO.get() + fXIAOHAO1.get() + fXIAOHAO2.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
}