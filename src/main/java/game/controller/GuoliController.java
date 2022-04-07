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

    @ApiOperation(value="加武力", tags = {"国力榜"})
    @GetMapping("/addWuli")
    @ResponseBody
    public String addWuli() {

        runner.all( p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addWuli();
        });

        return "done";
    }

    @ApiOperation(value="加智力", tags = {"国力榜"})
    @GetMapping("/addZhili")
    @ResponseBody
    public String addZhili() {

        runner.all( p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addZhili();
        });

        return "done";
    }

    @ApiOperation(value="加政治", tags = {"国力榜"})
    @GetMapping("/addZhengzhi")
    @ResponseBody
    public String addZhengzhi() {

        runner.all( p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addZhengzhi();
        });

        return "done";
    }

    @ApiOperation(value="加魅力", tags = {"国力榜"})
    @GetMapping("/addMeili")
    @ResponseBody
    public String addMeili() {

        runner.all( p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addMeili();
        });

        return "done";
    }

    @ApiOperation(value="加全属性", tags = {"国力榜"})
    @GetMapping("/addQuan")
    @ResponseBody
    public String addQuan() {

        runner.all( p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addQuan();
        });

        return "done";
    }


}


