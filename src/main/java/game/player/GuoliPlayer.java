package game.player;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.service.PlayerData;

import java.util.List;

public class GuoliPlayer extends BasePlayer {
    public GuoliPlayer(PlayerData data) {
        super(data);
    }

    public GuoliPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }

    public void addWuli(){
        String res = this.getAllinfo();
        DocumentContext dc = JsonPath.parse(res);

        //武力丸给赵云
        this.useItemforhero(dc, 13, 35);
        this.useItemforhero(dc, 14, 35);
    }

    public void addZhili(){
        String res = this.getAllinfo();
        DocumentContext dc = JsonPath.parse(res);
        this.useItemforhero(dc, 23, 55);
        this.useItemforhero(dc, 24, 55);
    }

    public void addZhengzhi(){
        String res = this.getAllinfo();
        DocumentContext dc = JsonPath.parse(res);
        this.useItemforhero(dc, 33, 38);
        this.useItemforhero(dc, 34, 38);
    }

    public void addMeili(){
        String res = this.getAllinfo();
        DocumentContext dc = JsonPath.parse(res);
        this.useItemforhero(dc, 43, 38);
        this.useItemforhero(dc, 44, 38);
    }

    public void addQuan(){
        String res = this.getAllinfo();
        DocumentContext dc = JsonPath.parse(res);
        this.useItemforhero(dc, 53, 38);
        this.useItemforhero(dc, 54, 35);
    }

    public void addAllGuoli(){
        String res = this.getAllinfo();
        DocumentContext dc = JsonPath.parse(res);
        int num = this.useItemforhero(dc, 11, 35);
        while(num > 100){
            this.useItemforhero( 11, 35);
            num = num - 100;
        }
        num = this.useItemforhero(dc, 12, 35);
        while(num > 100){
            this.useItemforhero( 12, 35);
            num = num - 100;
        }

        num = this.useItemforhero(dc, 21, 55);
        while(num > 100){
            this.useItemforhero( 21, 55);
            num = num - 100;
        }

        num = this.useItemforhero(dc, 22, 55);
        while(num > 100){
            this.useItemforhero( 22, 55);
            num = num - 100;
        }

        num = this.useItemforhero(dc, 31, 38);
        while(num > 100){
            this.useItemforhero( 31, 38);
            num = num - 100;
        }

        num = this.useItemforhero(dc, 32, 38);
        while(num > 100){
            this.useItemforhero( 32, 38);
            num = num - 100;
        }

        num = this.useItemforhero(dc, 51, 38);
        while(num > 100){
            this.useItemforhero( 51, 38);
            num = num - 100;
        }

        num = this.useItemforhero(dc, 52, 38);
        while(num > 100){
            this.useItemforhero( 52, 38);
            num = num - 100;
        }


    }


    public void addGuoli(){

        String res = this.getAllinfo();
        DocumentContext dc = JsonPath.parse(res);

        //武力丸给赵云
        int num = this.useItemforhero(dc, 13, 35);
        if(num > 100){
            this.useItemforhero(13, 35);
        }
        //武力丹给赵云
        this.useItemforhero(dc, 14, 35);

        //智力属性丸给马云绿
        this.useItemforhero(dc, 23, 55);
        //智力属性丹给马云绿
        this.useItemforhero(dc, 24, 55);

        //政治丸给诸葛亮
        num = this.useItemforhero(dc, 33, 38);
        if(num > 100){
            this.useItemforhero(33, 38);
        }
        //政治丹给诸葛亮
        this.useItemforhero(dc, 34, 38);

        //魅力丸给诸葛亮
        num = this.useItemforhero(dc, 43, 38);
        if(num > 100){
            this.useItemforhero(43, 38);
        }
        //魅力丹给诸葛亮
        this.useItemforhero(dc, 44, 38);

        //全属性丸给诸葛亮
        this.useItemforhero(dc, 53, 38);
        //全属性丹给诸葛亮
        this.useItemforhero(dc, 54, 38);

        //赵云光环
        this.runAction1("{\"hero\":{\"upghskill\":{\"sid\":4,\"id\":35}},\"rsn\":\"%s\"}");
        //诸葛亮光环
//        this.runAction1("{\"hero\":{\"upghskill\":{\"sid\":6,\"id\":38}},\"rsn\":\"%s\"}");


    }

    public int useItemforhero(DocumentContext dc, int itemId, int heroId){
        List<Integer> items = dc.read("$.a.item.itemList[?(@.id=="+itemId+")].count");
        Integer itemsCount = getFromList(items);

        if(itemsCount != null){
            if(itemsCount.intValue() > 100){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":"+heroId+",\"id\":"+itemId+"}}}");
                return itemsCount.intValue() - 100;
            } else  if(itemsCount.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+itemsCount.intValue()+",\"heroid\":"+heroId+",\"id\":"+itemId+"}}}");
            }
        }
        return 0;
    }

    public void useItemforhero(int itemId, int heroId){
        this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":"+heroId+",\"id\":"+itemId+"}}}");
    }

    public <T> T getFromList(List<T> list){
        return list == null || list.size() == 0 ? null : list.get(0);
    }


    public void kuafu_reward(){
        this.runAction2("{\"huodong\":{\"hd313Get\":[]},\"rsn\":\"%s\"}");
    }


}
