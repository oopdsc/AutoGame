package game.job;

import game.active.DefaultGameRunner;
import game.runner.XiaohaoRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Xiaohao2Task {

    Logger logger = LoggerFactory.getLogger(Xiaohao2Task.class);

    DefaultGameRunner runner = new DefaultGameRunner();

    @Autowired
    @Qualifier("xiaohao1Runner")
    XiaohaoRunner xiaohao1;

    @Autowired
    @Qualifier("xiaohao2Runner")
    XiaohaoRunner xiaohao2;

    //每个小时收菜
    @Scheduled(cron = "11 6 * * * ?")
    public void xiaohao1() {
        LocalDateTime dt = LocalDateTime.now();
        int h = dt.getHour();
        if(h == 20){
            return;
        }
        runner.singleXiaohao1(xiaohao1);
    }

    //晚上8点匈奴
    @Scheduled(cron = "7 1 20 * * ?")
    public void hitXiongnu1() {
        runner.singleXiaohao1(xiaohao1.hitXiongnu());
    }

    //每个小时收菜
    @Scheduled(cron = "14 7 * * * ?")
    public void xiaohao2() {
        LocalDateTime dt = LocalDateTime.now();
        int h = dt.getHour();
        if(h == 20){
            return;
        }
        runner.singleXiaohao2(xiaohao2);
    }

    //晚上8点匈奴
    @Scheduled(cron = "37 1 20 * * ?")
    public void hitXiongnu2() {
        runner.singleXiaohao2(xiaohao2.hitXiongnu());
    }
}
