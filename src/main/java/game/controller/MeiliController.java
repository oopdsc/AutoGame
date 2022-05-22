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

    @ApiOperation(value="跨服魅力", tags = {"魅力榜"})
    @GetMapping("/kuaMeili")
    @ResponseBody
    public String kuaMeili() {

        runner.all( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            mp.kua_meili();
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

    @ApiOperation(value="买珍兽大经验", tags = {"珍兽榜"})
    @GetMapping("/buyBigExp")
    @ResponseBody
    public String buyBigExp() {

        runner.all( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 10; i++){
                mp.buyBeast(3);
            }
        });

        return "done";
    }

    @ApiOperation(value="买孔雀", tags = {"珍兽榜"})
    @GetMapping("/buyKongque")
    @ResponseBody
    public String buyKongque() {

        runner.all( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 10; i++){
                mp.buyBeast(9);
            }
        });

        return "done";
    }

    @ApiOperation(value="买灵蛇", tags = {"珍兽榜"})
    @GetMapping("/buyLingshe")
    @ResponseBody
    public String buyLingshe() {

        runner.all( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 10; i++){
                mp.buyBeast(10);
            }
        });

        return "done";
    }

    @ApiOperation(value="买白熊", tags = {"珍兽榜"})
    @GetMapping("/buyBaixiong")
    @ResponseBody
    public String buyBaixiong() {

        runner.all( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 10; i++){
                mp.buyBeast(11);
            }
        });

        return "done";
    }

    @ApiOperation(value="买斗牛", tags = {"珍兽榜"})
    @GetMapping("/buyDouniu")
    @ResponseBody
    public String buyDouniu() {

        runner.all( p -> {
            MeiliPlayer mp = new MeiliPlayer(p);
            for(int i = 1; i <= 10; i++){
                mp.buyBeast(12);
            }
        });

        return "done";
    }


}


