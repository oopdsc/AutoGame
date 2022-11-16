package game.config;

import game.runner.XiaohaoRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
    }

    @Bean
    public XiaohaoRunner xiaohao1Runner(){
        XiaohaoRunner runner = new XiaohaoRunner();
        return runner;
    }

    @Bean
    public XiaohaoRunner xiaohao2Runner(){
        XiaohaoRunner runner = new XiaohaoRunner();
        return runner;
    }
}
