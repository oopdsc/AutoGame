package game.player;

import game.active.DefaultGameRunner;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static game.service.GameRunner.*;
import static org.junit.jupiter.api.Assertions.*;

class GetInfoPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    ExecutorService es = Executors.newWorkStealingPool(40);

    @Test
    void getCash() {

        es.submit(() -> runner.singleDahao(p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(DAHAO);
        }) );

        es.submit(() -> runner.singleXiaohao1(p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(XIAOHAO1);

        }) );

        es.submit(() -> runner.singleXiaohao2(p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(XIAOHAO2);
        }) );

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