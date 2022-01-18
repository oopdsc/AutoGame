package game.job;

import game.active.DefaultGameRunner;
import game.player.Double11Player;
import game.player.HuodongPlayer;
import game.player.RewardPlayer;
import game.service.GameRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@Component
public class ChongbangTask {

    DefaultGameRunner runner = new DefaultGameRunner();

    //child 冲榜
//    @Scheduled(cron = "30 59 21 * * ?")
    public void chongbang() throws IOException {

    }
}
