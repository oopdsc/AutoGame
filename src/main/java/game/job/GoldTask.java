package game.job;

import game.active.DefaultGameRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static game.runner.GameRunner.*;

@Component
public class GoldTask {

    DefaultGameRunner runner = new DefaultGameRunner();

    //get gold only
    @Scheduled(cron = "0 30 0 * * ?")
    public void taskAt130() throws IOException {

        runner.single(GOLD, p ->{
            try{
                p.gold();
                p.mobaiZJ();
            }catch (Exception e){
                logger.error(e.getMessage(), e);
            }

        });
    }

    @Scheduled(cron = "0 30 3/6 * * ?")
    public void zhengwu2() throws IOException {

        runner.single(GOLD, p ->{
            try{
                p.zhengwu2();
            }catch (Exception e){
                logger.error(e.getMessage(), e);
            }

        });
    }
}
