package game.service;

import game.player.BasePlayer;

public class BeastService {



    public static int LINGHU = 1;
    public static int HOUZI = 2;
    public static int DOUNIU = 8;
    public static void call(BasePlayer p, int beastId){
        p.runAction2("{\"rsn\":\"%s\",\"beast\":{\"call\":{\"id\":"+beastId+"}}}");
    }

    /*
     * 1 - 小药丸
     * 2 - 中药丸
     * 3 - 大药丸
     * 9 - 孔雀
     * 10 - 灵蛇
     * 11 - 白熊
     * 12 - 斗牛
     */
    public static void buyItem(BasePlayer p, int id){
        for(int i = 1; i <= 10; i++){
            p.runAction3("{\"rsn\":\"%s\",\"beast\":{\"buy\":{\"id\":" + id + "}}}");
        }
    }

    /**
     * @param itemid  1 : 小经验；2 : 中经验； 3 ： 大经验
     * @param beastid 1 ： 狐狸； 2 ： 猴子    7: 白熊 8： 斗牛
     */
    public static void upLvBeast(BasePlayer p, int itemid, int beastid) {
        p.runAction3("{\"rsn\":\"%s\",\"beast\":{\"upLv\":{\"type\":1,\"item_id\":" + itemid + ",\"id\":" + beastid + "}}}");
    }

    public static void upLvBeast2(BasePlayer p, int itemid, int beastid) {
        p.runAction0("{\"rsn\":\"%s\",\"beast\":{\"upLv\":{\"type\":2,\"item_id\":" + itemid + ",\"id\":" + beastid + "}}}");
    }

}
