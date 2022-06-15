package game.command;

public class LeagueCommand {

    public static String joinJinLing = "{\"rsn\":\"%s\",\"league\":{\"join\":{\"id\":6}}}";
    public static String enter = "{\"rsn\":\"%s\",\"league\":{\"main\":[]}}";
    public static String startBuild = "{\"rsn\":\"%s\",\"league\":{\"buildMain\":[]}}";
    public static String dailyBuild(int id){
        return "{\"rsn\":\"%s\",\"league\":{\"buildBuild\":{\"id\":"+id+"}}}";
    }

    public static String startFZ = "{\"rsn\":\"%s\",\"league\":{\"fzMain\":[]}}";
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
}
