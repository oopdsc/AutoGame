package game.service;

import game.player.BasePlayer;

/**
 * 匠作活动
 */
public class JiangzuoService {

    /**
     * 第一次进入活动
     * @param p
     */
    public static void startup(BasePlayer p){
        p.runAction2("{\"hd1036\":{\"enter\":[]},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"rank\":[]},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"recruit\":[]},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"recruitTrue\":{\"id\":5}},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"town\":{\"id\":101}},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"dispatch\":{\"pid\":1,\"id\":101}},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"town\":{\"id\":101}},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"rwdTown\":[]},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"town\":{\"id\":101}},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"guide\":{\"id\":5}},\"rsn\":\"%s\"}");
        p.runAction2("{\"hd1036\":{\"town\":{\"id\":101}},\"rsn\":\"%s\"}");
    }

    /**
     * 升级
     * @param p
     */
    public static void upgradeYf(BasePlayer p){
        for(int i = 1; i <= 5; i++){
            p.runAction2("{\"hd1036\":{\"upgradeYf\":{\"id\":"+i+"}},\"rsn\":\"%s\"}");
        }
    }
}
