package game.controller;

import game.active.DefaultGameRunner;
import game.player.JuediYamenPlayer;
import game.player.YamenPlayer;
import game.player.ZhanmaPlayer;
import game.service.GameRunner;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller()
@RequestMapping("/yamen")
public class YamenController {

    DefaultGameRunner runner = new DefaultGameRunner();

    @ApiOperation(value="跨服衙门一次", tags = {"衙门榜"})
    @GetMapping("/oneKuaChushi")
    @ResponseBody
    public String oneKuaChushi() {

        runner.all( p -> {
            YamenPlayer yp = new YamenPlayer(p);
            yp.kua_chushi_one();
        });

        return "done";
    }

    @ApiOperation(value="跨服衙门全部", tags = {"衙门榜"})
    @GetMapping("/fullKuaChushi")
    @ResponseBody
    public String fullKuaChushi() {

        runner.all( p -> {
            YamenPlayer yp = new YamenPlayer(p);
            yp.kua_chushi_full();
        });

        return "done";
    }

    @ApiOperation(value="绝地衙门一次", tags = {"衙门榜"})
    @GetMapping("/oneJdChushi")
    @ResponseBody
    public String oneJdChushi() {

        runner.all( p -> {
            JuediYamenPlayer yp = new JuediYamenPlayer(p);
            yp.kua_jdchushi_one();
        });

        return "done";
    }

    @ApiOperation(value="绝地衙门全部", tags = {"衙门榜"})
    @GetMapping("/fullJdChushi")
    @ResponseBody
    public String fullJdChushi() {

        runner.all( p -> {
            JuediYamenPlayer yp = new JuediYamenPlayer(p);
            yp.kua_jdchushi_full();
        });

        return "done";
    }

    @ApiOperation(value="本服衙门一次", tags = {"衙门榜"})
    @GetMapping("/oneYamen")
    @ResponseBody
    public String oneYamen() throws IOException {

        runner.all( p -> {
            YamenPlayer yp = new YamenPlayer(p);
            yp.chushi_One();
        });

        return "done";
    }

    @ApiOperation(value="本服衙门全部", tags = {"衙门榜"})
    @GetMapping("/allYamen")
    @ResponseBody
    public String allYamen(){

        runner.all( p -> {
            YamenPlayer yp = new YamenPlayer(p);
            yp.chushi_full();
        });

        return "done";
    }

    @ApiOperation(value="跨服衙门奖励", tags = {"衙门榜"})
    @GetMapping("/rewardKuafuYamen")
    @ResponseBody
    public String reward_KuafuYamen(){

        runner.all( p -> {
            YamenPlayer yp = new YamenPlayer(p);
            yp.reward_KuafuYamen();
        });

        return "done";
    }



}


