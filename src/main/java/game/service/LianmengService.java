package game.service;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import game.player.BasePlayer;

import java.util.LinkedList;

public class LianmengService {

    static Configuration conf = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);

    public static void buyItems(BasePlayer p){
        String resp = p.runAction1("{\"club\":{\"clubInfo\":[]},\"rsn\":\"%s\"}").getBody();

        DocumentContext dc = JsonPath.using(conf).parse(resp);

        Object lv1 = dc.read("$.a.club.memberInfo.leftgx");
        int leftgx = Integer.valueOf(lv1.toString());

        if(leftgx >= 100000){
            for (int i = 1; i <= 6; i++) {
                for(int j = 12; j <= 14; j++){
                    p.runAction1("{\"club\":{\"shopBuy\":{\"id\":"+j+"}},\"rsn\":\"%s\"}");
                }
            }
        }
    }

}
