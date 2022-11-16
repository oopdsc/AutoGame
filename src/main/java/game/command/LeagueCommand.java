package game.command;

public class LeagueCommand {

    public static String joinJinLing = "{\"rsn\":\"%s\",\"league\":{\"join\":{\"id\":6}}}";
    public static String enter = "{\"rsn\":\"%s\",\"league\":{\"main\":[]}}";
    public static String startBuild = "{\"rsn\":\"%s\",\"league\":{\"buildMain\":[]}}";
    public static String dailyBuild(int id){
        return "{\"rsn\":\"%s\",\"league\":{\"buildBuild\":{\"id\":"+id+"}}}";
    }

    public static String startFZ = "{\"rsn\":\"%s\",\"league\":{\"fzMain\":[]}}";

    //    {"rsn":"4ccahgibmmb","league":{"fzDispatchHero":{"heroId":30,"seatId":2}}}
    public static String dispatchFZ(int hero, int seat){
        return "{\"rsn\":\"%s\",\"league\":{\"fzDispatchHero\":{\"heroId\":"+hero+",\"seatId\":"+seat+"}}}";
    }


    public static String goShop = "{\"rsn\":\"%s\",\"league\":{\"shopMain\":[]}}";

    public static String buyShopItem(int itemId){
        return "{\"rsn\":\"%s\",\"league\":{\"shopBuy\":{\"id\":"+itemId+"}}}";
    }

    public static String fuben = "{\"rsn\":\"%s\",\"league\":{\"fbMain\":[]}}";
    public static String dispatchFuben(int fubenId, String playerId, int ... hid){
        return "{\"rsn\":\"%s\",\"league\":{\"fbStart\":{\"team\":" +
                "[{\"id\":1,\"uid\":"+playerId+",\"hid\":"+hid[0]+"}," +
                "{\"id\":2,\"uid\":"+playerId+",\"hid\":"+hid[1]+"}," +
                "{\"id\":3,\"uid\":"+playerId+",\"hid\":"+hid[2]+"}," +
                "{\"id\":4,\"uid\":"+playerId+",\"hid\":"+hid[3]+"}," +
                "{\"id\":5,\"uid\":"+playerId+",\"hid\":"+hid[4]+"}]," +
                "\"id\":"+fubenId+"}}}";
    }
    public static String fubenEvent(int fbId, int id){
        return "{\"rsn\":\"%s\",\"league\":{\"fbEventOver\":{\"fbId\":"+fbId+",\"eventId\":"+id+"}}}";
    }

    public static String fubenOver(int fbId){
        return "{\"rsn\":\"%s\",\"league\":{\"fbOver\":{\"id\":"+fbId+"}}}";
    }

    /**
     * 领取同盟藏典阁奖励
     * @return
     */
    public static String pickUpRwd(){
        return "{\"rsn\":\"%s\",\"league\":{\"cbPickupRwd\":[]}}";
    }

    public static String fzPickupAllScore(){
        return "{\"rsn\":\"%s\",\"league\":{\"fzPickupAllScore\":[]}}";
    }

    /**
     * 同盟典藏阁席位升级
     * @param seatId
     * @return
     */
    public static String upgradeSeat(int seatId){
        return "{\"rsn\":\"%s\",\"league\":{\"fzUpgradeSeat\":{\"seatId\":"+seatId+"}}}";
    }

    /**
     * 武将修身升级
     * @param heroid
     * @return
     */
    public static String xsupgrade(int heroid){
        return "{\"hero\":{\"xsUpgrade\":{\"type\":0,\"hid\":"+heroid+"}},\"rsn\":\"%s\"}";
    }
    public static String xsupgrade1(int heroid){
        return "{\"hero\":{\"xsUpgrade\":{\"type\":1,\"hid\":"+heroid+"}},\"rsn\":\"%s\"}";
    }
}
