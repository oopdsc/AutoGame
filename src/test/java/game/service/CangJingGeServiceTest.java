package game.service;

import game.active.DefaultGameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CangJingGeServiceTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void seekHelp() {
        runner.singleDahao(p -> {
            CangJingGeService.seekHelp(p);
        });

        runner.singleXiaohao1(p -> {
            CangJingGeService.oneKeyHelp(p);
        });

        runner.singleXiaohao2(p -> {
            CangJingGeService.seekHelp(p);
        });

        runner.singleDahao(p -> {
            CangJingGeService.manualHelp(p);
        });

        runner.singleXiaohao1(p -> {
            CangJingGeService.seekHelp(p);
        });

        runner.singleXiaohao2(p -> {
            CangJingGeService.manualHelp(p);
        });
    }

    @Test
    void manualHelp() {

    }
}