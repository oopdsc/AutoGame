package game.service;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import game.active.DefaultGameRunner;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class CommonServiceTest {
    DefaultGameRunner runner = new DefaultGameRunner();
    @Test
    void commonRunner() {
        runner.all1(p -> {

            TongmengService.buyItems(p);
            LianmengService.buyItems(p);
            HuodongService.tree_play(p);
            HuodongService.chicken_play(p);
//            HuodongService.longzhu2(p);

//            HuodongService.zaji_play(p);

//            HuodongService.cuju(p);
//            BeastService.buyItem(p, 3);
//            BeastService.buyItem(p, 10);
//            CangJingGeService.
//            CangJingGeService.readNewBook(p);

//            HuodongService.shouwang_reward1(p);
//            for(int i = 1; i <= 25; i++){
//                HuodongService.shouwang_reward2(p);
//            }



////            HeroService.xsupgrade1(p, 26);
//            HuodongService.double11(p);
//            CangJingGeService.foo3(p);
//            BeastService.call(p, BeastService.DOUNIU);

//            HuodongService.shouwang_join(p);
//            HuodongService.shouwang_fight(p, 15, HeroService.ZHANGFEI, BeastService.DOUNIU);
//            HuodongService.shouwang_fight(p, 15, HeroService.ZHAOYUN, BeastService.DOUNIU);
//            HuodongService.shouwang_fight(p, 15, HeroService.MACHAO, BeastService.DOUNIU);
//            HuodongService.shouwang_fight(p, 15, HeroService.HUANGZHONG, BeastService.DOUNIU);
//
//            HuodongService.shouwang_fight(p, 15, HeroService.ZHUGELIANG, BeastService.DOUNIU);
//            HuodongService.shouwang_fight(p, 15, HeroService.ZHOUYU, BeastService.DOUNIU);
//            HuodongService.shouwang_fight(p, 15, HeroService.PANGTONG, BeastService.DOUNIU);
//            HuodongService.shouwang_fight(p, 15, HeroService.GUOJIA, BeastService.DOUNIU);

//            HuodongService.saima_join(p);
//            HuodongService.saima_start(p, 39);

//            HuodongService.zaji_play(p);
//            GuoliService.reward_kua(p);

//            HuodongService.tree_play(p);
//            HuodongService.saima_reward(p);

//            ZhanmaPlayer rp = new ZhanmaPlayer(p);
//            rp.rewardAll();
//
//

//            LianmengService.buyItems(p);

//            HuodongService.zhongqiubobing(p);
//            TongmengService.buyItems(p);
//            HuodongService.tree_play(p);

//            HuodongService.tree_reward(p);





        });
        System.out.println("done");
    }

    @Test
    void commonRunner2() {
        runner.all1(p -> {

            String res = p.getAllinfo();
            Configuration conf = Configuration.defaultConfiguration();
            conf = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
            DocumentContext dc = JsonPath.using(conf).parse(res);

            List<Map<String, Object>> heros2 = dc.read("$.a.hero.heroList");

            HuodongService.shouwang_join(p);
            for (int i = 0; i < heros2.size(); i++) {
                Integer id = Integer.valueOf(heros2.get(i).get("id").toString());
                HuodongService.shouwang_fight(p, 16, id, 0);
            }
        });
    }


    @Test
    void commonRunner3() {

        runner.singleDahao(p -> {
            CangJingGeService.seekHelp(p);
        });

        runner.singleXiaohao1(p -> {
            CangJingGeService.oneKeyHelp(p);
        });

        runner.singleXiaohao2(p -> {
            CangJingGeService.seekHelp(p);
        });


    }

}