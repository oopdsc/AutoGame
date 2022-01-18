package game.controller;

import game.active.DefaultGameRunner;
import game.player.MeiliPlayer;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/meili")
public class MeiliController {

    DefaultGameRunner runner = new DefaultGameRunner();

    @ApiOperation(value="加魅力1", tags = {"魅力榜"})
    @GetMapping("/meili1")
    @ResponseBody
    public String meili1() {

        runner.all( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            mp.meili1();
        });

        return "done";
    }

    @ApiOperation(value="跨服魅力奖励", tags = {"魅力榜"})
    @GetMapping("/kuaMeiliReward")
    @ResponseBody
    public String kuaMeiliReward() {

        runner.all( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            mp.kua_meiliReward();
        });

        return "done";
    }

    @ApiOperation(value="加珍兽", tags = {"珍兽榜"})
    @GetMapping("/beast")
    @ResponseBody
    public String beast() {

        runner.all( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            mp.upLvBeast(1, 1);
            mp.upLvBeast(1, 2);
        });

        return "done";
    }


}


