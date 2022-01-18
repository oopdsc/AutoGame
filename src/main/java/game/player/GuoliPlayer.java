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


    public void addGuoli(){

        String res = this.getAllinfo();
        DocumentContext dc = JsonPath.parse(res);

        //政治丸给诸葛亮
        List<Integer> item33 = dc.read("$.a.item.itemList[?(@.id==33)].count");
        Integer item33Count = getFromList(item33);

        if(item33Count != null){
            if(item33Count.intValue() > 50){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":50,\"heroid\":38,\"id\":33}}}");
            } else  if(item33Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item33Count.intValue()+",\"heroid\":38,\"id\":33}}}");
            }
        }

        //政治丹给诸葛亮
        List<Integer> item34 = dc.read("$.a.item.itemList[?(@.id==34)].count");
        Integer item34Count = getFromList(item34);

        if(item34Count != null){
            if(item34Count.intValue() > 50){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":50,\"heroid\":38,\"id\":33}}}");
            } else  if(item34Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item34Count.intValue()+",\"heroid\":38,\"id\":33}}}");
            }
        }

        //全属性丸给郭嘉
        List<Integer> item53 = dc.read("$.a.item.itemList[?(@.id==53)].count");
        Integer item53Count = getFromList(item33);

        if(item53Count != null){
            if(item53Count.intValue() > 50){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":50,\"heroid\":41,\"id\":53}}}");
            } else  if(item53Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item53Count.intValue()+",\"heroid\":41,\"id\":53}}}");
            }
        }

        //全属性丹给郭嘉
        List<Integer> item54 = dc.read("$.a.item.itemList[?(@.id==54)].count");
        Integer item54Count = getFromList(item54);

        if(item54Count != null){
            if(item54Count.intValue() > 50){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":50,\"heroid\":41,\"id\":54}}}");
            } else  if(item54Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item54Count.intValue()+",\"heroid\":41,\"id\":54}}}");
            }
        }
    }

    public <T> T getFromList(List<T> list){
        return list == null || list.size() == 0 ? null : list.get(0);
    }




}
