package game.player;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.service.GameRunner;
import game.service.PlayerData;
import org.springframework.http.ResponseEntity;

public class YamenPlayer extends BasePlayer {
    public YamenPlayer(PlayerData data) {
        super(data);
    }

    public YamenPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }


    public void chushi() {
        try {
            this.runAction3("{\"yamen\":{\"yamen\":[]},\"rsn\":\"%s\"}");
            ResponseEntity<String> resp = this.runAction3("{\"yamen\":{\"chushi\":[]},\"rsn\":\"%s\"}");
            this.interanlYamen2(resp);
        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void chushi_One() {
        try {
            ResponseEntity<String> resp2 = this.runAction3("{\"yamen\":{\"yamen\":[]},\"rsn\":\"%s\"}");
            Object chunum = JsonPath.parse(resp2.getBody()).read("$.a.yamen.info.chunum");

            int chunum2 = Integer.valueOf(chunum.toString()).intValue();
            if(chunum2 >= 1){
                ResponseEntity<String> resp = this.runAction3("{\"yamen\":{\"chushi\":[]},\"rsn\":\"%s\"}");
                this.interanlYamen2(resp);
            }else{
                logger.info("{} no more chushi Yamen times.", this.data.username);
            }

        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void chushi_full() {
        try {
            ResponseEntity<String> resp2 = this.runAction3("{\"yamen\":{\"yamen\":[]},\"rsn\":\"%s\"}");
            Object chunum = JsonPath.parse(resp2.getBody()).read("$.a.yamen.info.chunum");

            int chunum2 = Integer.valueOf(chunum.toString()).intValue();
            for(int i = 1; i <= chunum2; i++){
                ResponseEntity<String> resp = this.runAction3("{\"yamen\":{\"chushi\":[]},\"rsn\":\"%s\"}");
                this.interanlYamen2(resp);
            }

        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void interanlYamen2(ResponseEntity<String> resp) {
        int index = 1;
        Object fstate = JsonPath.parse(resp.getBody()).read("$.a.yamen.fight.fstate");

        while (!"0".equals(fstate.toString())) {

            DocumentContext dc = JsonPath.parse(resp.getBody());
            int fherosnum = dc.read("$.a.yamen.fight.fheros.length()");

            String shop = "";
            if(index == 1){
                shop = "$.a.yamen.fight.shop[0].id";
            }else{
                shop = "$.a.yamen.fight.shop[1].id";
            }
            Object shopid = dc.read(shop);
            this.runAction3("{\"yamen\":{\"seladd\":{\"id\":" + Integer.valueOf(shopid.toString()) + "}},\"rsn\":\"%s\"}");

            int hid = 0;
            int senior = 0;
            for (int i = 0; i < fherosnum; i++) {
                Object tsenior = dc.read("$.a.yamen.fight.fheros[" + i + "].senior");
                int isenior = Integer.valueOf(tsenior.toString()).intValue();
                if (senior > isenior || senior == 0) {
                    Object tid = dc.read("$.a.yamen.fight.fheros["+i+"].id");
                    hid = Integer.valueOf(tid.toString()).intValue();
                    senior = isenior;
                }
            }

            resp = this.runAction3("{\"yamen\":{\"fight\":{\"id\":" + hid + "}},\"rsn\":\"%s\"}");
            index++;
            fstate = JsonPath.parse(resp.getBody()).read("$.a.yamen.fight.fstate");

            if ("2".equals(fstate.toString())) {
                GameRunner.sleep(1);
                resp = this.runAction3("{\"yamen\":{\"getrwd\":[]},\"rsn\":\"%s\"}");
                fstate = JsonPath.parse(resp.getBody()).read("$.a.yamen.fight.fstate");
            }
        }

    }



    //普通跨服衙门
    public void kua_yamen() {
        try {
            this.runAction3("{\"kuayamen\":{\"yamen\":[]},\"rsn\":\"%s\"}");
            ResponseEntity<String> resp = this.runAction3("{\"kuayamen\":{\"pizun\":[]},\"rsn\":\"%s\"}");
            this.interanlKuaYamen(resp);
        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void kua_yamen2() {
        try {
            ResponseEntity<String> resp = this.runAction3("{\"kuayamen\":{\"yamen\":[]},\"rsn\":\"%s\"}");
//            ResponseEntity<String> resp = this.runAction("{\"kuayamen\":{\"pizun\":[]},\"rsn\":\"%s\"}");
            this.interanlKuaYamen(resp);
        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void kua_chushi() {
        try {
            this.runAction3("{\"kuayamen\":{\"yamen\":[]},\"rsn\":\"%s\"}");
            ResponseEntity<String> resp = this.runAction3("{\"kuayamen\":{\"chushi\":[]},\"rsn\":\"%s\"}");
            this.interanlKuaYamen(resp);
        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void kua_chushi_one() {
        try {
            ResponseEntity<String> resp2 = this.runAction3("{\"kuayamen\":{\"yamen\":[]},\"rsn\":\"%s\"}");
            Object chunum = JsonPath.parse(resp2.getBody()).read("$.a.kuayamen.info.chunum");

            int chunum2 = Integer.valueOf(chunum.toString()).intValue();
            if(chunum2 >= 1){
                ResponseEntity<String> resp = this.runAction3("{\"kuayamen\":{\"chushi\":[]},\"rsn\":\"%s\"}");
                this.interanlKuaYamen(resp);
            }else{
                logger.info("{} no more Kua chushi Yamen times.", this.data.username);
            }

        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void kua_chushi_full() {
        try {
            ResponseEntity<String> resp2 = this.runAction3("{\"kuayamen\":{\"yamen\":[]},\"rsn\":\"%s\"}");
            Object chunum = JsonPath.parse(resp2.getBody()).read("$.a.kuayamen.info.chunum");

            int chunum2 = Integer.valueOf(chunum.toString()).intValue();
            for(int i = 1; i <= chunum2; i++){
                ResponseEntity<String> resp = this.runAction3("{\"kuayamen\":{\"chushi\":[]},\"rsn\":\"%s\"}");
                this.interanlKuaYamen(resp);
            }

        } catch (Exception e) {
            logger.error(this.data.username + e.getMessage(), e);
        }
    }

    public void interanlKuaYamen(ResponseEntity<String> resp) {

        Object fstate = JsonPath.parse(resp.getBody()).read("$.a.kuayamen.fight.fstate");

        while (!"0".equals(fstate.toString())) {

            DocumentContext dc = JsonPath.parse(resp.getBody());
            int fherosnum = dc.read("$.a.kuayamen.fight.fheros.length()");

            Object shopid = dc.read("$.a.kuayamen.fight.shop[0].id");
            this.runAction3("{\"kuayamen\":{\"seladd\":{\"id\":" + Integer.valueOf(shopid.toString()) + "}},\"rsn\":\"%s\"}");

            int hid = 0;
            int senior = 0;
            for (int i = 0; i < fherosnum; i++) {
                Object tsenior = dc.read("$.a.kuayamen.fight.fheros[" + i + "].senior");
                int isenior = Integer.valueOf(tsenior.toString()).intValue();
                if (senior > isenior || senior == 0) {
                    Object tid = dc.read("$.a.kuayamen.fight.fheros["+i+"].id");
                    hid = Integer.valueOf(tid.toString()).intValue();
                    senior = isenior;
                }
            }

            resp = this.runAction3("{\"kuayamen\":{\"fight\":{\"id\":" + hid + "}},\"rsn\":\"%s\"}");
            fstate = JsonPath.parse(resp.getBody()).read("$.a.kuayamen.fight.fstate");

            if ("2".equals(fstate.toString())) {
                GameRunner.sleep(1);
                resp = this.runAction3("{\"kuayamen\":{\"getrwd\":[]},\"rsn\":\"%s\"}");
                fstate = JsonPath.parse(resp.getBody()).read("$.a.kuayamen.fight.fstate");
            }
        }

    }

    //跨服衙门
    public void kuayamen_OneKey() {
        if (data.yamen) {
            this.runAction3("{\"kuayamen\":{\"pizun\":[]},\"rsn\":\"%s\"}");
            this.runAction3("{\"kuayamen\":{\"oneKeyPlay\":[]},\"rsn\":\"%s\"}");
        }
    }

    public void reward_KuafuYamen(){
        this.runAction2("{\"kuayamen\":{\"getSevRwd\":[]},\"rsn\":\"%s\"}");
    }

/**
 id=84717
 uid=7008211

 id=84838
 uid=7008779
 */

    public void tiaozhan(int id, int hid, int fuid){
//        {"yamen":{"tiaozhan":{"id":79858,"hid":9,"fuid":7009025}},"rsn":"8aermovjmm"}
        ResponseEntity<String> resp = this.runAction2("{\"yamen\":{\"tiaozhan\":{\"id\":"+id+",\"hid\":"+hid+",\"fuid\":"+fuid+"}},\"rsn\":\"%s\"}");
        this.interanlYamen2(resp);
        logger.info("resp : {}", resp);
    }
}
