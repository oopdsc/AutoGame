package game.player;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import game.active.DefaultGameRunner;
import game.command.BaseCommand;
import game.command.LeagueCommand;
import game.service.GameRunner;
import game.service.Hero;
import org.junit.jupiter.api.Test;

import java.util.*;

class LeaguePlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();
    Configuration conf = Configuration.defaultConfiguration();
    Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
    Random r = new Random();

    public void joinJinling(BasePlayer p) {
        p.runAction1(LeagueCommand.joinJinLing);
    }

    public void enterLeague(BasePlayer p) {
        p.runAction1(LeagueCommand.enter);
    }

    public void build(BasePlayer p) {

        for (int i = 1; i <= 5; i++) {
            this.singleBuild(p);
        }
        GameRunner.sleep(40);

    }

    public void singleBuild(BasePlayer p) {
        String resp = p.runAction2(LeagueCommand.startBuild).getBody();
        DocumentContext dc = JsonPath.using(conf2).parse(resp);

        Integer buildNum = dc.read("$.a.league.buildInfo.num");
        if (buildNum.intValue() < 5) {
            List<Map<String, Object>> events = dc.read("$.a.league.buildList");
            if (Objects.isNull(events) || events.size() == 0) {
            } else {
                int[] levels = new int[4];
                for (int i = 0; i < 3; i++) {
                    Integer id = Integer.valueOf(events.get(i).get("id").toString());
                    Integer level = Integer.valueOf(events.get(i).get("level").toString());
                    levels[id] = level;
                }
                int maxId = 1;
                int maxLv = levels[maxId];
                if (levels[2] > maxLv) {
                    maxId = 2;
                    maxLv = levels[2];
                }
                if (levels[3] > maxLv) {
                    maxId = 3;
                }
                p.runActionSleep(LeagueCommand.dailyBuild(maxId), r.nextInt(2) + 2).getBody();
            }
        }

    }

    public void shop(BasePlayer p) {
        p.runAction2(LeagueCommand.goShop);
        p.runAction2(LeagueCommand.buyShopItem(5));
        p.runAction2(LeagueCommand.buyShopItem(5));
        p.runAction2(LeagueCommand.buyShopItem(5));
    }

    public void startFuben(BasePlayer p) {
        p.runAction2(LeagueCommand.fuben);
        p.runAction2(LeagueCommand.dispatchFuben(1, p.data.uid, 34, 36, 44, 41, 9));
        p.runAction2(LeagueCommand.dispatchFuben(2, p.data.uid, 33, 55, 38, 23, 1));
    }

    /**
     * 开始典藏阁读书
     *
     * @param p
     */
    public void startFz(BasePlayer p) {
        p.runAction2(LeagueCommand.startFZ);
        p.runAction2(LeagueCommand.dispatchFZ(27, 1));
    }

    @Test
    void fubenTest() {
        runner.all1(p -> {
            try {
                p.runAction2(BaseCommand.mengzhan(2));

                this.enterLeague(p);
//                this.build(p);

                this.startFuben(p);


            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    @Test
    void fubenOverTest() {
        runner.processSingle(GameRunner.XIAOHAO1, p -> {

            this.enterLeague(p);
            p.overFuben();
            this.build(p);
            this.shop(p);
        });
    }

    @Test
    void buildTest() {

//        runner.processSingle(GameRunner.DAHAO, p -> {
        runner.all1(p -> {
            this.enterLeague(p);
            this.build(p);
            this.shop(p);
//                this.startFuben(p);

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saima_reward();
            p.runAction1(BaseCommand.mengzhan(1));

        }, p -> {
//            this.enterLeague(p);
//            this.build(p);
//            this.shop(p);
//                this.startFuben(p);

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saima_reward();
            p.runAction1(BaseCommand.mengzhan(1));

        }, p -> {
            this.enterLeague(p);
            this.build(p);
            this.shop(p);
//                this.startFuben(p);

            HuodongPlayer hp = new HuodongPlayer(p);
            hp.saima_reward();
            p.runAction1(BaseCommand.mengzhan(1));

        });
    }

    @Test
    void everyUser6() {
        Random r = new Random();
        runner.all1(p -> {
            for (int i = 1; i <= 5; i++) {
                p.runAction2("{\"fapei\":{\"recall\":{\"type\":0,\"did\":" + i + "}},\"rsn\":\"%s\"}");
            }
            this.enterLeague(p);
            this.startFz(p);

        });
    }
}