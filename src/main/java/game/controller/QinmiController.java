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
    @GetMapping("/usecook")
    @ResponseBody
    public String usecook() {

        runner.all( p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            qp.useCook(3);
        });

        return "done";
    }

    @ApiOperation(value="用一次玉米", tags = {"亲密榜"})
    @GetMapping("/usecookOnce")
    @ResponseBody
    public String usecookOnce() {

        runner.all( p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            qp.useCook(1);
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

    @ApiOperation(value="用亲密道具1", tags = {"亲密榜"})
    @GetMapping("/useItem1")
    @ResponseBody
    public String useItem1() {

        runner.all( p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 100; i++){
                qp.qinmi11();
            }

        });

        return "done";
    }

    @ApiOperation(value="用亲密道具2", tags = {"亲密榜"})
    @GetMapping("/useItem2")
    @ResponseBody
    public String useItem2() {

        runner.all( p -> {
            QinmiPlayer qp = new QinmiPlayer(p);
            for(int i = 1; i <= 100; i++){
                qp.qinmi12();
            }

        });

        return "done";
    }


}


