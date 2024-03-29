package game.job;

import game.active.DefaultGameRunner;
import game.config.Flags;
import game.player.BasePlayer;
import game.player.JuediYamenPlayer;
import game.player.JunjiPlayer;
import game.player.YamenPlayer;
import game.service.CangJingGeService;
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
    @Scheduled(cron = "0 58 21 * * ?")
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

    @Scheduled(cron = "0 15 11 * * ?")
    public void cangjingge() {
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

}
