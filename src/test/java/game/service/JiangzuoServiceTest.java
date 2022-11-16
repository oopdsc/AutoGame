package game.service;

import game.active.DefaultGameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiangzuoServiceTest {
    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void startup() {
        runner.all1(p -> {
            JiangzuoService.startup(p);
            TongmengService.buyItems(p);
        });
        System.out.println("done");
    }
}