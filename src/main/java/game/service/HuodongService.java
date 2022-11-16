package game.service;

import com.jayway.jsonpath.JsonPath;
import game.player.BasePlayer;
import game.runner.GameRunner;

import java.util.Date;
import java.util.Random;

import static game.runner.GameRunner.sleep;

public class HuodongService {

    static Random rd = new Random();

    public static void saima_create(BasePlayer p){
        p.runAction3("{\"huodong\":{\"hd685createClub\":{\"name\":\"X"
                +rd.nextInt(7) + "2" + rd.nextInt(8) + "4" + rd.nextInt(9) +
                "\",\"rand\":1}},\"rsn\":\"%s\"}");
    }

    public static void saima_join(BasePlayer p){
        p.runAction3("{\"huodong\":{\"hd685randJoy\":\"\"},\"rsn\":\"%s\"}");
    }

    public static void saima_start(BasePlayer p, int hid){
        String resp = p.runAction3("{\"huodong\":{\"hd685Info\":[]},\"rsn\":\"%s\"}").getBody();
        Object clubid = JsonPath.read(resp, "$.a.mjdshuodong.user.my_club_id");
        p.runAction3("{\"huodong\":{\"hd685buy\":{\"num\":30,\"id\":1}},\"rsn\":\"%s\"}");
        p.runAction3("{\"huodong\":{\"hd685startGame\":{\"startGame\":" + new Date().getTime() / 1000 + "}},\"rsn\":\"%s\"}");
        sleep(60);
        p.runAction3("{\"huodong\":{\"hd685endGame\":{\"club_id\":"+clubid.toString()+",\"hid\":" + hid + ",\"daoju\":[{\"count\":30,\"kind\":11,\"id\":793}]}},\"rsn\":\"%s\"}");
    }

    public static void saima_reward(BasePlayer p){
        p.runAction1("{\"huodong\":{\"hd685exchange\":{\"num\":1,\"id\":4}},\"rsn\":\"%s\"}");
        for(int i = 1; i <= 6; i++){
            p.runAction1("{\"huodong\":{\"hd685exchange\":{\"num\":1,\"id\":6}},\"rsn\":\"%s\"}");
        }
    }

    public static void tree_play(BasePlayer p){
        for (int i = 1; i <= 10; i++) {
            p.runAction2("{\"huodong\":{\"hd437buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            p.runAction2("{\"huodong\":{\"hd437play\":{\"id\":351}},\"rsn\":\"%s\"}");
        }
    }

    public static void tree_buy2(BasePlayer p){
        for(int i = 1; i <= 10; i++){
            p.runAction2("{\"huodong\":{\"hd437buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            p.runAction2("{\"huodong\":{\"hd437buy\":{\"id\":2}},\"rsn\":\"%s\"}");
        }
    }

    public static void tree_use2(BasePlayer p){
        for(int i = 1; i <= 30; i++){
            p.runAction1("{\"huodong\":{\"hd437play\":{\"count\":1,\"id\":351}},\"rsn\":\"%s\"}");
            p.runAction1("{\"huodong\":{\"hd437play\":{\"count\":1,\"id\":352}},\"rsn\":\"%s\"}");
        }
        p.runAction1("{\"huodong\":{\"hd437buy\":{\"id\":3}},\"rsn\":\"%s\"}");
        p.runAction1("{\"huodong\":{\"hd437play\":{\"count\":1,\"id\":353}},\"rsn\":\"%s\"}");
    }

    public static void tree_reward(BasePlayer p){
        p.runAction2("{\"huodong\":{\"hd437exchange\":{\"id\":9}},\"rsn\":\"%s\"}");
    }

    public static void zaji_play(BasePlayer p){
        for (int i = 1; i <= 10; i++) {
            p.runAction2("{\"huodong\":{\"hd456buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            p.runAction2("{\"huodong\":{\"hd456play\":{\"id\":361}},\"rsn\":\"%s\"}");
        }
    }

    public static void zaji_buy2(BasePlayer p){
        for(int i = 1; i <= 10; i++){
            p.runAction2("{\"huodong\":{\"hd456buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            p.runAction2("{\"huodong\":{\"hd456buy\":{\"id\":2}},\"rsn\":\"%s\"}");
        }
    }

    public static void zaji_use2(BasePlayer p){
        for(int i = 1; i <= 10; i++){
            p.runAction1("{\"huodong\":{\"hd456buy\":{\"id\":1}},\"rsn\":\"%s\"}");
            p.runAction1("{\"huodong\":{\"hd456buy\":{\"id\":2}},\"rsn\":\"%s\"}");
        }
        for(int i = 1; i <= 30; i++){
            p.runAction1("{\"huodong\":{\"hd456play\":{\"id\":361}},\"rsn\":\"%s\"}");
            p.runAction1("{\"huodong\":{\"hd456play\":{\"id\":362}},\"rsn\":\"%s\"}");
        }
        p.runAction1("{\"huodong\":{\"hd456buy\":{\"id\":3}},\"rsn\":\"%s\"}");
        p.runAction1("{\"huodong\":{\"hd456play\":{\"count\":1,\"id\":363}},\"rsn\":\"%s\"}");
    }

    public static void zaji_reward(BasePlayer p){
        p.runAction3("{\"huodong\":{\"hd456exchange\":{\"id\":9}},\"rsn\":\"%s\"}");
    }


    public static void chicken_play(BasePlayer p){
        for (int i = 1; i <= 20; i++) {
            p.runAction2("{\"huodong\":{\"hd282play\":{\"id\":271}},\"rsn\":\"%s\"}");
            p.runAction2("{\"huodong\":{\"hd282buy\":{\"id\":1}},\"rsn\":\"%s\"}");
        }
    }

    public static void chicken_reward(BasePlayer p){
        for(int i = 1; i <= 4; i++){
            p.runAction2("{\"huodong\":{\"hd282exchange\":{\"id\":5}},\"rsn\":\"%s\"}");
        }
    }

    public static void zhongqiubobing(BasePlayer p){
        p.runAction2("{\"rsn\":\"%s\",\"hd1049\":{\"main\":[]}}");
        for(int i = 1; i <= 3; i++){
            p.runAction2("{\"rsn\":\"%s\",\"hd1049\":{\"task\":{\"id\":"+i+"}}}");
            p.runAction2("{\"rsn\":\"%s\",\"hd1049\":{\"play\":{\"num\":1}}}");
        }

    }

    public static void double11(BasePlayer p){
        p.runAction3("{\"huodong2\":{\"hd246Buy\":{\"type\":3,\"count\":1,\"id\":1}},\"rsn\":\"%s\"}");
    }

    public static void xiangqinyingwu(BasePlayer p){
        p.runAction2("{\"huodong2\":{\"hd743Receive\":[]},\"rsn\":\"%s\"}");
        p.runAction2("{\"huodong2\":{\"hd743Choose\":{\"skinId\":636}},\"rsn\":\"%s\"}");
        p.runAction2("{\"huodong2\":{\"hd743Play\":{\"count\":1,\"isCash\":0}},\"rsn\":\"%s\"}");
    }

    public static void shouwang_join(BasePlayer p){
//        p.runAction2("{\"huodong2\":{\"hd921Watch\":[]},\"rsn\":\"8jrkramvram\"}");
//
//        GameRunner.sleep(6);

        p.runAction2("{\"huodong2\":{\"hd921Info\":[]},\"rsn\":\"%s\"}");
    }



    /**
     *
     * @param p
     * @param bossId - boss id.
     *               金雕 - 15
     *               驯鹿 - 11
     *               湾鄂 - 16
     * @param heroId
     * @param bid   珍兽 ID, can be 0
     */
    public static void shouwang_fight(BasePlayer p, int bossId, int heroId, int bid){
        p.runAction2("{\"huodong2\":{\"hd921Fight\":{\"bkid\":"+bossId+",\"bid\":"+bid+",\"hid\":"+heroId+"}},\"rsn\":\"%s\"}");
    }


    public static void shouwang_reward1(BasePlayer p){
        p.runAction2("{\"huodong2\":{\"hd921RwdPartake\":{\"bkid\":15}},\"rsn\":\"%s\"}");
        p.runAction2("{\"huodong2\":{\"hd921RwdPartake\":{\"bkid\":16}},\"rsn\":\"%s\"}");
    }

    public static void shouwang_reward2(BasePlayer p){
        p.runAction2("{\"huodong2\":{\"hd921Exchange\":{\"count\":1,\"id\":10}},\"rsn\":\"%s\"}");
        p.runAction2("{\"huodong2\":{\"hd921Exchange\":{\"count\":1,\"id\":12}},\"rsn\":\"%s\"}");
    }

    public static void cuju(BasePlayer p){
        //        this.runAction2("{\"huodong2\":{\"hd874SelHero\":{\"heroidStr\":\"33,34,55,36,41,39\"}},\"rsn\":\"%s\"}");
//        this.runAction2("{\"huodong2\":{\"hd874Start\":[]},\"rsn\":\"%s\"}");
//        sleep(30);
//        this.runAction2("{\"huodong2\":{\"hd874Play\":{\"dienum\":5,\"type\":1,\"time\":30,\"iswin\":1,\"blood\":5}},\"rsn\":\"%s\"}");
        p.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        p.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        p.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        p.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        p.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
        p.runAction3("{\"huodong2\":{\"hd874Play\":{\"dienum\":0,\"type\":2,\"time\":0,\"iswin\":0,\"blood\":5}},\"rsn\":\"%s\"}");
    }



    /**
     * 弹珠
     */
    public static void longzhu2(BasePlayer p){
        p.runAction2("{\"huodong2\":{\"hd962Info\":[]},\"rsn\":\"%s\"}");
        for(int i = 1; i <= 9; i++){
            p.runAction2("{\"huodong2\":{\"hd962Start\":{\"num\":1}},\"rsn\":\"%s\"}");
        }
    }




}
