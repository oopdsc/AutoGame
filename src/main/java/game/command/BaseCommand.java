package game.command;

public class BaseCommand {

    public static String mengzhan(int heroId){
        return "{\"club\":{\"kuaPKAdd\":{\"hid\":" + heroId + "}},\"rsn\":\"%s\"}";
    }

    /**
     *
     * @param houseId 6 - 智力 2 - 魅力  12 - 武力 11 - 政治
     * @param heroId
     * @return
     */
    public static String houseMake(int houseId, int heroId){
        return "{\"club\":{\"householdMake\":{\"id\":"+houseId+",\"heroid\":"+heroId+"}},\"rsn\":\"%s\"}";
    }
}
