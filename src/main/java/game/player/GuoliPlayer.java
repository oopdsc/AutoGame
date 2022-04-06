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
            if(item33Count.intValue() > 100){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":38,\"id\":33}}}");
            } else  if(item33Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item33Count.intValue()+",\"heroid\":38,\"id\":33}}}");
            }
        }

        //政治丹给诸葛亮
        List<Integer> item34 = dc.read("$.a.item.itemList[?(@.id==34)].count");
        Integer item34Count = getFromList(item34);

        if(item34Count != null){
            if(item34Count.intValue() > 100){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":38,\"id\":33}}}");
            } else  if(item34Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item34Count.intValue()+",\"heroid\":38,\"id\":33}}}");
            }
        }

        //智力属性丸给马云绿
        List<Integer> item23 = dc.read("$.a.item.itemList[?(@.id==23)].count");
        Integer item23Count = getFromList(item23);

        if(item23Count != null){
            if(item23Count.intValue() > 100){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":55,\"id\":23}}}");
            } else  if(item23Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item23Count.intValue()+",\"heroid\":55,\"id\":23}}}");
            }
        }

        //智力属性丹给马云绿
        List<Integer> item24 = dc.read("$.a.item.itemList[?(@.id==24)].count");
        Integer item24Count = getFromList(item24);

        if(item24Count != null){
            if(item24Count.intValue() > 100){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":55,\"id\":24}}}");
            } else  if(item24Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item24Count.intValue()+",\"heroid\":55,\"id\":24}}}");
            }
        }

        //全属性丸给郭嘉
        List<Integer> item53 = dc.read("$.a.item.itemList[?(@.id==53)].count");
        Integer item53Count = getFromList(item53);

        if(item53Count != null){
            if(item53Count.intValue() > 100){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":41,\"id\":53}}}");
            } else  if(item53Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item53Count.intValue()+",\"heroid\":41,\"id\":53}}}");
            }
        }

        //全属性丹给郭嘉
        List<Integer> item54 = dc.read("$.a.item.itemList[?(@.id==54)].count");
        Integer item54Count = getFromList(item54);

        if(item54Count != null){
            if(item54Count.intValue() > 100){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":41,\"id\":54}}}");
            } else  if(item54Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item54Count.intValue()+",\"heroid\":41,\"id\":54}}}");
            }
        }

        //武力丸给赵云
        List<Integer> item13 = dc.read("$.a.item.itemList[?(@.id==13)].count");
        Integer item13Count = getFromList(item13);

        if(item13Count != null){
            if(item13Count.intValue() > 100){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":35,\"id\":13}}}");
            } else  if(item13Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item13Count.intValue()+",\"heroid\":35,\"id\":13}}}");
            }
        }

        //武力丹给赵云
        List<Integer> item14 = dc.read("$.a.item.itemList[?(@.id==14)].count");
        Integer item14Count = getFromList(item14);

        if(item14Count != null){
            if(item14Count.intValue() > 100){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":35,\"id\":14}}}");
            } else  if(item14Count.intValue() != 0){
                this.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":"+item14Count.intValue()+",\"heroid\":35,\"id\":14}}}");
            }
        }



    }

    public <T> T getFromList(List<T> list){
        return list == null || list.size() == 0 ? null : list.get(0);
    }


    public void kuafu_reward(){
        this.runAction2("{\"huodong\":{\"hd313Get\":[]},\"rsn\":\"%s\"}");
    }


}
