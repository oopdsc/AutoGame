package game.controller;

import game.active.DefaultGameRunner;
import game.player.QinmiPlayer;
import game.player.ZhanmaPlayer;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/qinmi")
public class QinmiController {

    DefaultGameRunner runner = new DefaultGameRunner();

    @ApiOperation(value="用玉米", tags = {"亲密榜"})
    @GetMapping("/usercook")
    @ResponseBody
    public String usercook() {

        runner.all( p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            qp.useCook();
        });

        return "done";
    }

    @ApiOperation(value="做玉米", tags = {"亲密榜"})
    @GetMapping("/cook")
    @ResponseBody
    public String cook() {

        runner.all( p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 10; i++){
                qp.cook();
            }

        });

        return "done";
    }


}


