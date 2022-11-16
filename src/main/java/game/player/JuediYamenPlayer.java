package game.player;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.runner.PlayerData;
import org.springframework.http.ResponseEntity;


public class JuediYamenPlayer extends BasePlayer {
    public JuediYamenPlayer(PlayerData data) {
        super(data);
    }

    public JuediYamenPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }


    //绝地跨服衙门
    public void kua_jdyamen() {
        try {
            this.runAction3("{\"kuayamen\":{\"jdSjtz\":[]},\"rsn\":\"%s\"}");
            ResponseEntity<String> resp = this.runAction3("{\"kuayamen\":{\"jdPiZhun\":[]},\"rsn\":\"%s\"}");
            this.interanlKuaJdYamen(resp);
        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void kua_jdchushi() {
        try {
            this.runAction3("{\"kuayamen\":{\"jdSjtz\":[]},\"rsn\":\"%s\"}");
            ResponseEntity<String> resp = this.runAction3("{\"kuayamen\":{\"jdChushi\":[]},\"rsn\":\"%s\"}");
            this.interanlKuaJdYamen(resp);
        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void kua_jdchushi_one() {
        try {
            ResponseEntity<String> resp2 = this.runAction3("{\"kuayamen\":{\"jdSjtz\":[]},\"rsn\":\"%s\"}");
            Object chunum = JsonPath.parse(resp2.getBody()).read("$.a.jdyamen.info.chunum");

            int chunum2 = Integer.valueOf(chunum.toString()).intValue();
            if(chunum2 >= 1){
                ResponseEntity<String> resp = this.runAction3("{\"kuayamen\":{\"jdChushi\":[]},\"rsn\":\"%s\"}");
                this.interanlKuaJdYamen(resp);
            }else{
                logger.info("{} no more Juedi chushi Yamen times.", this.data.username);
            }

        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void kua_jdchushi_full() {
        try {
            ResponseEntity<String> resp2 = this.runAction3("{\"kuayamen\":{\"jdSjtz\":[]},\"rsn\":\"%s\"}");
            Object chunum = JsonPath.parse(resp2.getBody()).read("$.a.jdyamen.info.chunum");

            int chunum2 = Integer.valueOf(chunum.toString()).intValue();
            for(int i = 1; i <= chunum2; i++){
                ResponseEntity<String> resp = this.runAction3("{\"kuayamen\":{\"jdChushi\":[]},\"rsn\":\"%s\"}");
                this.interanlKuaJdYamen(resp);
            }

        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void jdYameInternal(){
//        {"kuayamen":{"jdPiZhun":[]},"rsn":"6wplxksbpg"}
//        this.runAction("{\"kuayamen\":{\"jdSjtz\":[]},\"rsn\":\"5jjwvwjyyae\"}");
    }

    public void interanlKuaJdYamen(ResponseEntity<String> resp) {

        Object fstate = JsonPath.parse(resp.getBody()).read("$.a.jdyamen.fight.fstate");

        while (!"0".equals(fstate.toString())) {

            DocumentContext dc = JsonPath.parse(resp.getBody());
            int fherosnum = dc.read("$.a.jdyamen.fight.fheros.length()");

            Object shopid = dc.read("$.a.jdyamen.fight.shop[0].id");
            this.runAction3("{\"kuayamen\":{\"jdSeladd\":{\"id\":" + Integer.valueOf(shopid.toString()) + "}},\"rsn\":\"%s\"}");

            int hid = 0;
            int senior = 0;
            for (int i = 0; i < fherosnum; i++) {
                Object tsenior = dc.read("$.a.jdyamen.fight.fheros[" + i + "].senior");
                int isenior = Integer.valueOf(tsenior.toString()).intValue();
                if (senior > isenior || senior == 0) {
                    Object tid = dc.read("$.a.jdyamen.fight.fheros[0].id");
                    hid = Integer.valueOf(tid.toString()).intValue();
                    senior = isenior;
                }
            }

            resp = this.runAction3("{\"kuayamen\":{\"jdFight\":{\"id\":" + hid + "}},\"rsn\":\"%s\"}");
            fstate = JsonPath.parse(resp.getBody()).read("$.a.jdyamen.fight.fstate");

            if ("2".equals(fstate.toString())) {
                resp = this.runAction3("{\"kuayamen\":{\"jdGetrwd\":[]},\"rsn\":\"%s\"}");
                fstate = JsonPath.parse(resp.getBody()).read("$.a.jdyamen.fight.fstate");
            }
        }

    }
}
