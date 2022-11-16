package game.player;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import game.runner.PlayerData;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static game.runner.GameRunner.getRsn;

public class JunjiPlayer extends BasePlayer {
    public JunjiPlayer(PlayerData data) {
        super(data);
    }

    public JunjiPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }

    /**
     * list junji
     * {"cabinet":{"cabinetInfo":[]},"rsn":"2mxqqlambyx"}
     * $.a.cabinet.info.list[]
     * list":[{"id":8,"type":"low","nature":"e1","dispatch_type":0,"dispatched":0,"rwd":0}]"
     *
     * send junji
     * {"cabinet":{"dispatch":{"seat":2,"hero":[{"heroid":41},{"heroid":38},{"heroid":39},{"heroid":40},{"heroid":13}],"id":4}},"rsn":"6xxbbgupwgg"}
     *
     *
     * check single junji
     * {"cabinet":{"thingInfo":{"id":4}},"rsn":"5yyhhfpvfje"}
     * $.a.cabinet.thing.list[] is null  ("list":[])
     *
     * "list":[{"fuidInfo":{"id":"7005929","name":"\u674e\u5927\u7237","step":"1","job":2,"sex":1,"level":17,"vip":5,"vipStatus":1,"chenghao":0,"extra_ch":"","dress":0,"beijing":0,"shili":834768373,"frame":0,"setFrame":0,"chatFrame":0,"head":0,"mingrenchenghao":0,"bigEmoji":[],"guajian":0},
     * "seat_id":2}]}
     */

    public void checkCabinet(){
        String body = this.runAction1("{\"cabinet\":{\"cabinetInfo\":[]},\"rsn\":\"%s\"}").getBody();
        DocumentContext dc = JsonPath.parse(body);
        List<Object> cabinets = dc.read("$.a.cabinet.info.list[*].id");
//        dispatched, id , type
        for(Object cabinet : cabinets){
            int id = Integer.valueOf(cabinet.toString()).intValue();
            String resp = this.runAction1("{\"cabinet\":{\"thingInfo\":{\"id\":"+id+"}},\"rsn\":\"%s\"}").getBody();
            DocumentContext dc2 = JsonPath.parse(resp);
//            Integer seat = dc2.read("$.a.cabinet.thing.list.length()");
            List<String> type = dc.read("$.a.cabinet.info.list[?(@.id=="+id+")].type");
            logger.info("id : {} , seat {}, type = {}", id, 0, type.get(0));
//            if(seat == 0){
//                this.buyItemByType(type);
//                logger.info("{} sending to {}...", this.data.username, id);
//                this.sendCabinet(id);
//                break;
//            }

        }
    }

    public void checkCabinet2() {
        try{
            String body = this.runAction1("{\"cabinet\":{\"cabinetInfo\":[]},\"rsn\":\"%s\"}").getBody();
            DocumentContext dc = JsonPath.parse(body);
            Map<String, Object> cabinet = dc.read("$.a.cabinet.info.list["+this.data.cabinetIndex+"]");
            Integer id = Integer.valueOf(cabinet.get("id").toString());
            Integer dispatched = Integer.valueOf(cabinet.get("dispatched").toString());
            String type = String.valueOf(cabinet.get("type"));

            Cabinet cab = Cabinet.DEFAULT;
            if("low".equalsIgnoreCase(type)){
                cab = Cabinet.LOW;
            }else if("middle".equalsIgnoreCase(type)){
                cab = Cabinet.MIDDLE;
            }else if("high".equalsIgnoreCase(type)){
                cab = Cabinet.HIGH;
            }

            if(dispatched < cab.getMaxBound()){

//                logger.info("buy item: {}", cab.getBuyAction());

                this.runAction1(cab.getBuyAction());
//                this.buyItemByType(type);
                this.sendCabinet(id, this.data.cabinetHeros);
//                logger.info("{} seat id {} dispatched {} type {}, heros [{},{},{},{},{}]",
//                        this.data.username, id, dispatched, type,
//                        this.data.cabinetHeros[0],
//                        this.data.cabinetHeros[1],
//                        this.data.cabinetHeros[2],
//                        this.data.cabinetHeros[3],
//                        this.data.cabinetHeros[4]
//                        );
            }
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
    }

    public void sendCabinet(int id){
        this.runAction2("{\"cabinet\":{\"dispatch\":{\"seat\":28,\"hero\":[{\"heroid\":34},{\"heroid\":37},{\"heroid\":55},{\"heroid\":1},{\"heroid\":2}],\"id\":"+id+"}},\"rsn\":\"%s\"}");
    }

    public void sendCabinet(int id, int[] heros){
        Random r = new Random();
        if(heros.length == 5){
            int seat = r.nextInt(20) + 5;
            this.runAction2("{\"cabinet\":{\"dispatch\":{\"seat\":"+ seat +",\"hero\":[" +
                    "{\"heroid\":"+heros[0]+"}," +
                    "{\"heroid\":"+heros[1]+"}," +
                    "{\"heroid\":"+heros[2]+"}," +
                    "{\"heroid\":"+heros[3]+"}," +
                    "{\"heroid\":"+heros[4]+"}],\"id\":"+id+"}},\"rsn\":\"%s\"}");
        }

    }

    public void buyItemByType(String type){
        if("low".equalsIgnoreCase(type)){
            this.runAction1("{\"club\":{\"shopBuy\":{\"id\":15}},\"rsn\":\"%s\"}");
        }else if("middle".equalsIgnoreCase(type)){
            this.runAction1("{\"club\":{\"shopBuy\":{\"id\":16}},\"rsn\":\"%s\"}");
        }else if("high".equalsIgnoreCase(type)){
            this.runAction1("{\"club\":{\"shopBuy\":{\"id\":17}},\"rsn\":\"%s\"}");
        }
    }

}

enum Cabinet{
    DEFAULT("", -1, 0),
    LOW("low", 2, 15),
    MIDDLE("middle", 3, 16),
    HIGH("high", 3, 17);

    String type;
    int bound;
    int item;
    Cabinet(String type, int bound, int item){
        this.type = type;
        this.bound = bound;
        this.item = item;
    }

    String getBuyAction(){
        return "{\"club\":{\"shopBuy\":{\"id\":"+item+"}},\"rsn\":\"%s\"}";
    }

    int getMaxBound(){
        return bound;
    }
}
