package game.job;

import game.active.DefaultGameRunner;
import game.config.Flags;
import game.player.BasePlayer;
import game.player.JuediYamenPlayer;
import game.player.JunjiPlayer;
import game.player.YamenPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CabinetTask {

    Logger logger = LoggerFactory.getLogger(CabinetTask.class);

    DefaultGameRunner runner = new DefaultGameRunner();

    //晚上派军机
    @Scheduled(cron = "0 59 21 * * ?")
    public void cabinet() {
        LocalDate ld = LocalDate.now();
        int dayInWeek = ld.getDayOfWeek().getValue();
        int slt = Flags.sleepTime;
        Flags.sleepTime = 3;
        runner.single(dayInWeek+ "-cabinet.json", p -> {
            JunjiPlayer jp = new JunjiPlayer(p);
            jp.checkCabinet2();
        });
        Flags.sleepTime = slt;
    }

}
