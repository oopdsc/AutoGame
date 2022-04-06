package game.controller;

import game.active.DefaultGameRunner;
import game.player.HuodongPlayer;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.function.Consumer;

@Controller()
@RequestMapping("/huodong")
public class HuodongController {

    DefaultGameRunner runner = new DefaultGameRunner();

    @ApiOperation(value="吃鸡", tags = {"吃鸡活动"})
    @GetMapping("/chiji")
    @ResponseBody
    public String chiji() {
        this.base(hp -> {hp.chiji();});
        return "done";
    }

    @ApiOperation(value="吃鸡奖励", tags = {"吃鸡活动"})
    @GetMapping("/chijiReward")
    @ResponseBody
    public String chijiReward() {
        this.base(hp -> {hp.chijiReward();});
        return "done";
    }

    @ApiOperation(value="杂技", tags = {"杂技活动"})
    @GetMapping("/zaji")
    @ResponseBody
    public String zaji() {
        this.base(hp -> {hp.zajiActive();});
        return "done";
    }

    @ApiOperation(value="杂技奖励", tags = {"杂技活动"})
    @GetMapping("/zajiReward")
    @ResponseBody
    public String zajiReward() {
        this.base(hp -> {hp.zajiReward();});
        return "done";
    }

    @ApiOperation(value="种树", tags = {"种树活动"})
    @GetMapping("/zhongshuhuodong")
    @ResponseBody
    public String zhongshuhuodong() {
        this.base(hp -> {hp.zhongshuhuodong();});
        return "done";
    }

    @ApiOperation(value="种树活动奖励", tags = {"种树活动"})
    @GetMapping("/zhongshuReward")
    @ResponseBody
    public String zhongshuReward() {
        this.base(hp -> {hp.zhongshuReward();});
        return "done";
    }


    @ApiOperation(value="巢穴", tags = {"巢穴活动"})
    @GetMapping("/caoxue")
    @ResponseBody
    public String caoxue() {
        this.base(hp -> {hp.caoxueAll();});
        return "done";
    }

    @ApiOperation(value="巢穴活动奖励", tags = {"巢穴活动"})
    @GetMapping("/caoxueReward")
    @ResponseBody
    public String caoxueReward() {
        this.base(hp -> {hp.caoxueReward();});
        return "done";
    }






    public void base(Consumer<HuodongPlayer> consumer){
        runner.all( p -> {
            HuodongPlayer hp = new HuodongPlayer(p);
            consumer.accept(hp);
        });
    }




}


