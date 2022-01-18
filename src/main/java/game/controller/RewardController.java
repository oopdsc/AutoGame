package game.controller;

import game.active.DefaultGameRunner;
import game.player.BasePlayer;
import game.player.RewardPlayer;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Controller()
@RequestMapping("/reward")
public class RewardController {

    DefaultGameRunner runner = new DefaultGameRunner();


    @ApiOperation(value = "国力涨幅", tags = {"奖励"})
    @GetMapping("/rewardGuoli")
    @ResponseBody
    public String rewardGuoli() {
        return this.reward(15, rp -> rp.rewardGuoli());
    }

    @ApiOperation(value = "士兵消耗", tags = {"奖励"})
    @GetMapping("/rewardShibing")
    @ResponseBody
    public String rewardShibing() {
        return this.reward(10, rp -> rp.rewardShibing());
    }

    @ApiOperation(value = "元宝消耗", tags = {"奖励"})
    @GetMapping("/rewardYuanbao")
    @ResponseBody
    public String rewardYuanbao() {
        return this.reward(10, rp -> rp.rewardYuanbao());
    }

    @ApiOperation(value = "卷轴消耗", tags = {"奖励"})
    @GetMapping("/rewardJuanzhou")
    @ResponseBody
    public String rewardJuanzhou() {
        return this.reward(10, rp -> rp.rewardJuanzhou());
    }

    @ApiOperation(value = "联姻次数", tags = {"奖励"})
    @GetMapping("/rewardLianyin")
    @ResponseBody
    public String rewardLianyin() {
        return this.reward(10, rp -> rp.rewardLianyin());
    }

    @ApiOperation(value = "粮食消耗", tags = {"奖励"})
    @GetMapping("/rewardLiangshi")
    @ResponseBody
    public String rewardLiangshi() {
        return this.reward(10, rp -> rp.rewardLiangshi());
    }

    @ApiOperation(value = "亲密涨幅", tags = {"奖励"})
    @GetMapping("/rewardQinmi")
    @ResponseBody
    public String rewardQinmi() {
        return this.reward(10, rp -> rp.rewardQinmi());
    }

    @ApiOperation(value = "魅力涨幅", tags = {"奖励"})
    @GetMapping("/rewardMeili")
    @ResponseBody
    public String rewardMeili() {
        return this.reward(10, rp -> rp.rewardMeili());
    }

    @ApiOperation(value = "击杀副本BOSS", tags = {"奖励"})
    @GetMapping("/rewardKillLianmengBoss")
    @ResponseBody
    public String rewardKillLianmengBoss() {
        return this.reward(10, rp -> rp.rewardKillLianmengBoss());
    }

    @ApiOperation(value = "联盟副本伤害", tags = {"奖励"})
    @GetMapping("/rewardLianmengBoss")
    @ResponseBody
    public String rewardLianmengBoss() {
        return this.reward(10, rp -> rp.rewardLianmengBoss());
    }

    @ApiOperation(value = "击杀匈奴王", tags = {"奖励"})
    @GetMapping("/rewardKillXiongnu")
    @ResponseBody
    public String rewardKillXiongnu() {
        return this.reward(3, rp -> rp.rewardKillXiongnu());
    }

    @ApiOperation(value = "银两", tags = {"奖励"})
    @GetMapping("/rewardYinliang")
    @ResponseBody
    public String rewardYinliang() {
        return this.reward(15, rp -> rp.rewardYinliang());
    }

    @ApiOperation(value = "精力丹", tags = {"奖励"})
    @GetMapping("/rewardJinglidan")
    @ResponseBody
    public String rewardJinglidan() {
        return this.reward(10, rp -> rp.rewardJinglidan());
    }

    @ApiOperation(value = "活力丹", tags = {"奖励"})
    @GetMapping("/rewardHuolidan")
    @ResponseBody
    public String rewardHuolidan() {
        return this.reward(10, rp -> rp.rewardHuolidan());
    }

    @ApiOperation(value = "体力丹", tags = {"奖励"})
    @GetMapping("/rewardTilidan")
    @ResponseBody
    public String rewardTilidan() {
        return this.reward(10, rp -> rp.rewardTilidan());
    }

    @ApiOperation(value = "装扮", tags = {"奖励"})
    @GetMapping("/rewardZhuangban")
    @ResponseBody
    public String rewardZhuangban() {
        return this.reward(10, rp -> rp.rewardZhuangban());
    }

//    @ApiOperation(value = "巢穴活动", tags = {"奖励"})
//    @GetMapping("/caoxueReward")
//    @ResponseBody
//    public String caoxueReward() {
//        return this.reward(10, rp -> rp.caoxueReward());
//    }




    public String reward(int size, Consumer<RewardPlayer> consumer) {

        runner.all((p) -> {
            RewardPlayer rp = new RewardPlayer(p);
            for (int i = 1; i <= size; i++) {
                consumer.accept(rp);
            }
        });

        return "done";
    }

}


