package game.controller;

import game.active.DefaultGameRunner;
import game.player.ZhanmaPlayer;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/zhanma")
public class ZhanmaController {

    DefaultGameRunner runner = new DefaultGameRunner();

    @ApiOperation(value="加战马国力", tags = {"战马榜"})
    @GetMapping("/warhorseActive")
    @ResponseBody
    public String warhorseActive() {

        runner.all( p -> {
            ZhanmaPlayer zp = new ZhanmaPlayer(p);
            zp.warhorseActive();
        });

        return "done";
    }

    @ApiOperation(value = "战马奖励", tags = {"战马榜"})
    @GetMapping("/warhorseReward")
    @ResponseBody
    public String warhorseReward() {
        runner.all( p -> {
            ZhanmaPlayer zp = new ZhanmaPlayer(p);
            zp.rewardAll();
        });

        return "done";
    }


}


