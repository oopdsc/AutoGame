package game.service;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.player.BasePlayer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class QinmiService {

    public static void useCook(BasePlayer p, int num){
        ResponseEntity<String> res = p.runAction3("{\"rsn\":\"%s\",\"guide\":{\"login\":{\"platform\":\"qiangwanzdhgios\",\"ug\":\"\"}}}");
        DocumentContext dc = JsonPath.parse(res.getBody());
        List<Object> wifeId = dc.read("$.a.wife.wifeList[?(@.banish==0)].id");
        wifeId.stream().forEach(id -> {
            for(int i = 1; i <= num; i++){
                String body2 = "{\"rsn\":\"%s\",\"item\":{\"userYard\":{\"count\":1,\"roleid\":" + id + ",\"id\":207}}}";
                p.runAction1(body2);
            }
        });
    }

}
