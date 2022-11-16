package game.service;

import game.active.DefaultGameRunner;
import game.runner.GameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroServiceTest {
    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void pkSkillup() {
        runner.all1(p -> {
//            HuodongService.saima_start(p, 37);
//            TongmengService.buyItems(p);
//            HuodongService.zaji_play(p);
//            HeroService.pkSkillup(p, 160, 40);


            HuodongService.tree_play(p);
            HeroService.xsupgrade1(p, HeroService.WEIXIAOBAO);
        });
        System.out.println("done");
    }

    @Test
    void upzzskill() {
        runner.single(GameRunner.HUODONG, p -> {
            //                2120 2647 2144
            for (int i = 1; i <= 130; i++) {
//                HeroService.upzzskillJingyan(p, HeroService.MAYUNLV, HeroService.MAYUNLV_5ZHI);
            }
            for (int i = 1; i <= 2120; i++) {
                HeroService.upzzskillJuanzhou(p, HeroService.MAYUNLV, HeroService.MAYUNLV_7ZHI);
            }
            for (int i = 1; i <= 2144; i++) {
                HeroService.upzzskillJuanzhou(p, HeroService.ZHANGXINGCAI, HeroService.ZHANGXINGCAI_7MEI);
            }
            for (int i = 1; i <= 2647; i++) {
                HeroService.upzzskillJuanzhou(p, HeroService.ZHANGCHUNHUA, HeroService.ZHANGCHUNHUA_7ZHENG);
            }
        });
    }


}