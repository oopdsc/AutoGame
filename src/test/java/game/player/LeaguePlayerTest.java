package game.player;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import game.active.DefaultGameRunner;
import game.command.LeagueCommand;
import game.service.GameRunner;
import game.service.Hero;
import org.junit.jupiter.api.Test;

import java.util.*;

class LeaguePlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    public void joinJinling(BasePlayer p){
        p.runAction1(LeagueCommand.joinJinLing);
    }

    public void enterLeague(BasePlayer p){
        p.runAction1(LeagueCommand.enter);
    }

    public void build(BasePlayer p){
        Random r = new Random();
        p.runAction2(LeagueCommand.startBuild);
        p.runActionSleep(LeagueCommand.dailyBuild(1), r.nextInt(2) + 2);
        p.runActionSleep(LeagueCommand.dailyBuild(2), r.nextInt(1) * 5 + 3);
        p.runActionSleep(LeagueCommand.dailyBuild(3), r.nextInt(2) * 5 + 1);
        p.runActionSleep(LeagueCommand.dailyBuild(1), r.nextInt(2) * 5 + 2);
        p.runActionSleep(LeagueCommand.dailyBuild(3), r.nextInt(1) * 5 + 1);
    }

    public void shop(BasePlayer p){
        p.runAction2(LeagueCommand.goShop);
        p.runAction2(LeagueCommand.buyShopItem(1));
    }

    public void startFuben(BasePlayer p){
        p.runAction2(LeagueCommand.fuben);
        p.runAction2(LeagueCommand.dispatchFuben(1, p.data.uid, 33, 34, 35, 36, 37));
    }

    public void overFuben(BasePlayer p){
        String fuben = p.runAction2(LeagueCommand.fuben).getBody();
        Configuration conf = Configuration.defaultConfiguration();
        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        DocumentContext dc = JsonPath.using(conf2).parse(fuben);
        List<Map<String, Object>> events = dc.read("$.a.league.fbList[0].events");
        if(Objects.isNull(events) || events.size() == 0){
        }else{
            for(int i = 0; i < events.size(); i++) {
                Integer id = Integer.valueOf(events.get(i).get("id").toString());
                p.runAction2(LeagueCommand.fubenEvent(1, id));
            }
        }
        p.runAction2(LeagueCommand.fubenOver(1));
    }


    /**
     * 开始典藏阁读书
     * @param p
     */
    public void startFz(BasePlayer p){
        p.runAction2(LeagueCommand.startFZ);
        p.runAction2(LeagueCommand.dispatchFZ(27, 1));
    }

    @Test
    void everyUser5() {

        runner.processSingle(GameRunner.DAHAO, p -> {
            p.son();


        });
    }

    @Test
    void everyUser6() {
        Random r = new Random();
        runner.all1(p -> {
            for(int i = 1; i <= 5; i++){
                p.runAction2("{\"fapei\":{\"recall\":{\"type\":0,\"did\":"+i+"}},\"rsn\":\"%s\"}");
            }
            this.enterLeague(p);
            this.startFz(p);

        });
    }
}