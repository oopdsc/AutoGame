package game.service;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.player.BasePlayer;

import java.util.List;
import java.util.Map;

public class CangJingGeService {

    public static void foo(BasePlayer p){
        p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"comeIn\":[]}}");
        p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"choose\":[]}}");
        p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"study\":[]}}");
        p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"seek\":[]}}");
    }

    public static void seekHelp(BasePlayer p){
//        p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"comeIn\":[]}}");
//        p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"seek\":[]}}");
        CangJingGeService.readNewBook(p);
    }

    public static void oneKeyHelp(BasePlayer p){
        p.runAction2("{\"club\":{\"clubInfo\":[]},\"rsn\":\"%s\"}");
        p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"oneKeyHelp\":[]}}");
    }

    public static void manualHelp(BasePlayer p){
        String resp = p.getAllinfo();
        DocumentContext dc = JsonPath.parse(resp);
        List<Map<String, Object>> seeks = dc.read("$.u.cangjingge.seek");
        for(int i = 0; i < 13; i++){
            Map<String, Object> seek = seeks.get(i);
            int time = Integer.valueOf(seek.get("time").toString());
            int msgid = Integer.valueOf(seek.get("msgid").toString());
            int uid = Integer.valueOf(((Map) seek.get("user")).get("uid").toString());
            p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"help\":{\"time\":"+time
                    +",\"id\":"+msgid+",\"fuid\":"+uid+"}}}");
        }

//        Object status = dc.read("$.u.cangjingge.seek.status");
//        u.cangjingge.seek[].time=1668444426/msgid=598/.user.uid=7008340
//        {"rsn":"8jrkvrreeoe","cangjingge":{"help":{"time":1668444426,"id":598,"fuid":7008340}}}
    }

    public static void readNewBook(BasePlayer p){
        String resp = p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"comeIn\":[]}}").getBody();
        DocumentContext dc = JsonPath.parse(resp);

        Object status = dc.read("$.a.cangjingge.user.status");
        int statu = Integer.valueOf(status.toString());
        if(statu == 2){
            p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"getbook\":[]}}");

            p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"choose\":[]}}");

            p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"study\":[]}}");
        }
        p.runAction2("{\"rsn\":\"%s\",\"cangjingge\":{\"seek\":[]}}");
    }
}
