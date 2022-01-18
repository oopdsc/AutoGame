package game.controller;

import game.active.DefaultGameRunner;
import game.player.GetInfoPlayer;
import game.service.GameRunner;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static game.service.GameRunner.*;

@Controller()
@RequestMapping("/all")
public class AllController {

    DefaultGameRunner runner = new DefaultGameRunner();

    @ApiOperation(value="演武")
    @GetMapping("/yanwu")
    @ResponseBody
    public String yanwu() {

        runner.single(GameRunner.DAHAO, d->d.isYanwu, p -> {
            p.openYanwu();
        });

        runner.single(GameRunner.DAHAO,  d->!d.isYanwu, p -> p.joinYanwu());

        runner.single(GameRunner.XIAOHAO, p -> p.joinYanwu());

        return "done";
    }




    @ApiOperation(value="儿子")
    @GetMapping("/son")
    @ResponseBody
    public String son(){
        runner.single(GameRunner.RUNNER, p -> {
            p.son_allDone();
        });
        return "done";
    }


    ExecutorService es = Executors.newWorkStealingPool(40);
    @ApiOperation(value="获取信息")
    @GetMapping("/getAll")
    @ResponseBody
    public String getAll() {

        es.submit(() -> runner.singleDahao(p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(DAHAO);
        }) );

        es.submit(() -> runner.singleXiaohao1(p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(XIAOHAO1);

        }) );

        es.submit(() -> runner.singleXiaohao2(p -> {
            GetInfoPlayer gp = new GetInfoPlayer(p);
            gp.getAll(XIAOHAO2);
        }) );
        return "done";

    }


}
