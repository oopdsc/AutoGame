package game.player;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.service.PlayerData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class QinmiPlayer extends BasePlayer {
    public QinmiPlayer(PlayerData data) {
        super(data);
    }

    public QinmiPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }

    /**
     * 自动吃体力丹寻访
     * @param num
     */
    public void xunfun(int num) {
        //TODO
        this.xunfunRecover();
        this.xunfun();
    }


    //使用爆米花
    public void useCookAction(int roleid) {
        String body2 = "{\"rsn\":\"%s\",\"item\":{\"userYard\":{\"count\":1,\"roleid\":" + roleid + ",\"id\":207}}}";
        this.runAction1(body2);
    }

    public void useCook(int num){
        ResponseEntity<String> res = this.runAction3("{\"rsn\":\"%s\",\"guide\":{\"login\":{\"platform\":\"qiangwanzdhgios\",\"ug\":\"\"}}}");

        DocumentContext dc = JsonPath.parse(res.getBody());

        List<Object> wifeId = dc.read("$.a.wife.wifeList[?(@.banish==0)].id");
        wifeId.stream().forEach(id -> {
            for(int i = 1; i <= num; i++){
                this.useCookAction(Integer.valueOf(id.toString()).intValue());
            }
        });
    }

    public void reward1(){
        this.runAction3("{\"huodong\":{\"hd221Rwd\":[]},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong\":{\"hd205Rwd\":[]},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong\":{\"hd226Rwd\":[]},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong\":{\"hd206Rwd\":[]},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong\":{\"hd219Rwd\":[]},\"rsn\":\"%s\"}");
        this.runAction3("{\"huodong\":{\"hd220Rwd\":[]},\"rsn\":\"%s\"}");
    }

    public void clubQinmi(){
        for(int i = 1; i <= 4; i++){
            this.baseReward("221"); //meili
        }
        for(int i = 1; i <= 8; i++){
            this.baseReward("205"); //qin mi
            this.baseReward("206"); //guoli
            this.baseReward("219"); //tili
            this.baseReward("227"); //jingli

        }

        for(int i = 1; i <= 14; i++){
            this.baseReward("226");//liangshi
        }



    }
}
