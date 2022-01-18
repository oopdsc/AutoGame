package game.controller;

import game.active.DefaultGameRunner;
import game.player.GuoliPlayer;
import game.player.QinmiPlayer;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/guoli")
public class GuoliController {

    DefaultGameRunner runner = new DefaultGameRunner();

    @ApiOperation(value="加国力", tags = {"国力榜"})
    @GetMapping("/addguoli")
    @ResponseBody
    public String addguoli() {

        runner.all( p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addGuoli();
        });

        return "done";
    }


}


