package game.player;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import game.service.Hero;
import game.service.HeroData;
import game.service.PlayerData;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static game.service.GameRunner.DAHAO;
import static game.service.GameRunner.getRsn;

public class GetInfoPlayer extends BasePlayer {
    public GetInfoPlayer(PlayerData data) {
        super(data);
    }
    public GetInfoPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }


    public void getAllWives(){
        ResponseEntity<String> res = this.runAction3("{\"rsn\":\"%s\",\"guide\":{\"login\":{\"platform\":\"qiangwanzdhgios\",\"ug\":\"\"}}}");

        DocumentContext dc = JsonPath.parse(res.getBody());

        List<String> wifeId = dc.read("$.a.wife.wifeList[?(@.banish==0)].id");

    }

    public void getAll(String folder){
        String resp = this.getAllinfo();
        this.getCash(resp, folder);
//        this.hero(resp, folder);
//        this.getCourtyardInfo(false, folder);
//        System.out.println("done : " + folder);
    }


    public void getCash(String res, String folder){
//        String body = "{\"rsn\":\"" + getRsn() + "\",\"guide\":{\"login\":{\"platform\":\"qiangwanzdhgios\",\"ug\":\"\"}}}";
//        ResponseEntity<String> resp = this.execute(baseUrl, body);
//        String res = resp.getBody();
        DocumentContext dc = JsonPath.parse(res);

        List<Integer> book1 = dc.read("$.a.item.itemList[?(@.id==61)].count");
        List<Integer> book2 = dc.read("$.a.item.itemList[?(@.id==62)].count");
        List<Integer> book3 = dc.read("$.a.item.itemList[?(@.id==63)].count");
        List<Integer> book4 = dc.read("$.a.item.itemList[?(@.id==64)].count");
        List<Integer> book = dc.read("$.a.item.itemList[?(@.id==77)].count");
        List<Integer> sbook = dc.read("$.a.item.itemList[?(@.id==81)].count");
        List<Integer> bbook = dc.read("$.a.item.itemList[?(@.id==83)].count");

        List<Object> qinmi1 = dc.read("$.a.item.itemList[?(@.id==91)].count");
        List<Object> qinmi2 = dc.read("$.a.item.itemList[?(@.id==92)].count");

        List<Object> meili1 = dc.read("$.a.item.itemList[?(@.id==93)].count");
        List<Object> meili2 = dc.read("$.a.item.itemList[?(@.id==94)].count");

        Integer desk = dc.read("$.a.school.base.desk", Integer.class);

        logger.info("cash1 {}", dc.read("$.a.user.user.cash").toString());
        String cash = dc.read("$.a.user.user.cash").toString();
        logger.info("cash2 {}", cash);

        List<Object> jinguoling = dc.read("$.a.item.itemList[?(@.id==138)].count");
        Integer x1 = 0;

        if(Objects.isNull(jinguoling) || jinguoling.size() == 0){
        }else{
            x1  = Integer.valueOf(jinguoling.get(0).toString());
        }

        List<Object> rr = Arrays.asList(
                getFromList(book1),
                getFromList(book2),
                getFromList(book3),
                getFromList(book4),
                getFromList(book),
                getFromList(sbook),
                getFromList(bbook),
                qinmi1 == null || qinmi1.size() == 0 ? 0 : qinmi1.get(0),
                getFromList(qinmi2),
                getFromList(meili1),
                getFromList(meili2),
                cash,
                desk,
                x1);
        String content = Strings.join(rr, ',');

        try {
            FileUtils.write(new File("./"+ folder +"/Items-20220122.txt"), this.getData().username + "," + content + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Object getFromList(List list){
        return list == null || list.size() == 0 ? 0 : list.get(0);
    }

    public void openAllmail(){

        String body = "{\"rsn\":\"" + getRsn() + "\",\"guide\":{\"login\":{\"platform\":\"qiangwanzdhgios\",\"ug\":\"\"}}}";
        String res = this.execute(baseUrl, body).getBody();
        DocumentContext dc = JsonPath.parse(res);
        List<Object> mails = dc.read("$.a.mail.mailList[?(@.rts==0 && @.mtype == '1')].id");

        mails.stream().forEach(mail -> {
            String body2 = "{\"rsn\":\"" + getRsn() +"\",\"mail\":{\"openMails\":{\"mid\":"+mail+"}}}";
            this.execute(baseUrl, body2).getBody();

            String body3 = "{\"rsn\":\"" + getRsn() +"\",\"mail\":{\"redMails\":{\"mid\":"+mail+"}}}";
            this.execute(baseUrl, body3).getBody();
        });


        //{"rsn":"7ycggscylcy","mail":{"openMails":{"mid":4008}}}

        //{"rsn":"8makkvamojm","mail":{"redMails":{"mid":4008}}}
    }

    public void getMayunlv(){
        ResponseEntity<String> resp =  this.runAction3("{\"rsn\":\"%s\",\"guide\":{\"login\":{\"platform\":\"qiangwanzdhgios\",\"ug\":\"\"}}}");
        String res = resp.getBody();
        Configuration conf = Configuration.defaultConfiguration();
        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        DocumentContext dc = JsonPath.using(conf2).parse(res);
        List<Object> book1 = dc.read("$.a.item.itemList[?(@.id==138)].count");


        List<Object> heros = new LinkedList<>();
        List<Map<String, Object>> heros2 = dc.read("$.a.hero.heroList");
        Map<Integer, Object> topheros2 = new HashMap<>();

        for(int i = 0; i < heros2.size(); i++){
            Integer id = Integer.valueOf(heros2.get(i).get("id").toString());
            if(! (id == 41 || id == 38 || id == 36)){
                continue;
            }

            Integer lv = Integer.valueOf(heros2.get(i).get("level").toString());
            Integer zz = Integer.valueOf(((Map)heros2.get(i).get("zz")).get("e1").toString());

//            System.out.println(heros2.get(i).get("id") + "|" + heros2.get(i).get("level") + ":" + ((Map)heros2.get(i).get("zz")).get("e1"));
            topheros2.put(zz, heros2.get(i).get("id") + HeroData.heroname.get(Integer.valueOf(heros2.get(i).get("id").toString())) + "-" + lv + ":" + zz);






//            if(lv >= 400 && zz >= 480){
//
//            }else{
//                heros.add(HeroData.heroname.get(Integer.valueOf(heros2.get(i).get("id").toString())) + "-" + lv + ":" + zz);
//            }

        }
        topheros2.keySet().stream().sorted((y, x) -> {
            return (x < y) ? -1 : ((x == y) ? 0 : 1);
        }).forEach(key ->{
            heros.add(topheros2.get(key));
        });


//
//        for(int i = 33; i <= 41; i++){
//            List<Object> hero = dc.read("$.a.hero.heroList[?(@.id=='"+i+"')].level");
//            Integer lv = 0;
//
//            List<Object> herozz = dc.read("$.a.hero.heroList[?(@.id=='"+i+"')].zz.e1");
//            Integer zz = 0;
//
//            if(Objects.isNull(hero) || hero.size() == 0){
//            }else{
//                lv  = Integer.valueOf(hero.get(0).toString());
//                zz  = Integer.valueOf(herozz.get(0).toString());
//            }
//            heros.add(i + "-" + lv);
//            heros.add(zz);
//        }

//
//        List<Object> hero39 = dc.read("$.a.hero.heroList[?(@.id=='39')].level");
//        List<Object> hero40 = dc.read("$.a.hero.heroList[?(@.id=='40')].level");
//        List<Object> hero41 = dc.read("$.a.hero.heroList[?(@.id=='41')].level");
//
//        List<Object> hero38zz = dc.read("$.a.hero.heroList[?(@.id=='38')].zz.e1");
//        List<Object> hero39zz = dc.read("$.a.hero.heroList[?(@.id=='39')].zz.e1");
//        List<Object> hero40zz = dc.read("$.a.hero.heroList[?(@.id=='40')].zz.e1");
//        List<Object> hero41zz = dc.read("$.a.hero.heroList[?(@.id=='41')].zz.e1");

        Object allAttr = dc.read("$.a.user.ep.e2");

        Object zhiliAttr = dc.read("$.a.user.old_ep.ep");

        Integer cash = dc.read("$.a.user.user.cash", Integer.class);

        Integer desk = dc.read("$.a.school.base.desk", Integer.class);

        Integer x1 = 0;

        if(Objects.isNull(book1) || book1.size() == 0){
        }else{
            x1  = Integer.valueOf(book1.get(0).toString());
        }



//        if(Objects.isNull(hero39) || hero39.size() == 0){
//        }else{
//            x39  = Integer.valueOf(hero39.get(0).toString());
//            x39zz  = Integer.valueOf(hero39zz.get(0).toString());
//        }
//
//        if(Objects.isNull(hero40) || hero40.size() == 0){
//        }else{
//            x40  = Integer.valueOf(hero40.get(0).toString());
//            x40zz  = Integer.valueOf(hero40zz.get(0).toString());
//        }
//
//        if(Objects.isNull(hero41) || hero41.size() == 0){
//        }else{
//            x41  = Integer.valueOf(hero41.get(0).toString());
//            x41zz  = Integer.valueOf(hero41zz.get(0).toString());
//        }

//        for(int i = desk.intValue(); i < 5; i++){
//            this.buySchool();
//            this.schoolOne(3, 2);
//        }
//
//        this.schoolOne(4, 41);
//        this.schoolOne(5, 38);

////        if(x.intValue() == 0 && x1.intValue() >= 10){
//            this.runAction("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":10,\"id\":153}}}");
//            this.runAction("{\"huodong\":{\"hd272Rwd\":{\"id\":55}},\"rsn\":\"%s\"}");   //马云绿
//        {"huodong":{"hd270Rwd":{"id":41}},"rsn":"7xxysocsvsy"}   //郭嘉
//        {"huodong":{"hd270Rwd":{"id":38}},"rsn":"9ririjbjbm"}     //诸葛亮
////        }

//        if(x.intValue() >= 1){
////            this.mayunlv();
//            this.useBook();
//        }

        List<Object> rr = Arrays.asList(cash, x1, allAttr, zhiliAttr);
        heros.addAll(rr);
        String content = Strings.join(heros, ',');

        try {
            FileUtils.write(new File("./hero.txt"), this.getData().username + "," + content + "\r", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void hero(String res, String folder){
//        ResponseEntity<String> resp =  this.runAction3("{\"rsn\":\"%s\",\"guide\":{\"login\":{\"platform\":\"qiangwanzdhgios\",\"ug\":\"\"}}}");
//        String res = resp.getBody();
        Configuration conf = Configuration.defaultConfiguration();
        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        DocumentContext dc = JsonPath.using(conf2).parse(res);

        List<Hero> heros = new LinkedList<>();
        List<Map<String, Object>> heros2 = dc.read("$.a.hero.heroList");
//        Map<Integer, Object> topheros2 = new HashMap<>();

        boolean hasMachao = false;
//        for(int i = 0; i < heros2.size(); i++){
//            Hero hero = new Hero();
//            Integer id = Integer.valueOf(heros2.get(i).get("id").toString());
//
//            Integer lv = Integer.valueOf(heros2.get(i).get("level").toString());
//            Integer zz = Integer.valueOf(((Map)heros2.get(i).get("zz")).get("e1").toString());
//
//            hero.lv = lv.intValue();
//            hero.zz = zz.intValue();
//            hero.name = HeroData.heroname.get(id);
//            hero.id = id;
//            heros.add(hero);
////            topheros2.put(zz, id + HeroData.heroname.get(id) + "-" + lv + ":" + zz);
//
////            if(id.intValue() == 36){
////                hasMachao = true;
////            }
//        }

        heros.sort((y, x) -> {
            return (x.zz < y.zz) ? -1 : ((x.zz == y.zz) ? 0 : 1);
        });

        Integer bmap = dc.read("$.a.user.guide.bmap");

        Object zhiliAttr = dc.read("$.a.user.ep.e2");

        Object allAttr = dc.read("$.a.user.old_ep.ep");

        List<Object> rr = Arrays.asList(data.silu, zhiliAttr.toString(), bmap);
        String content1 = Strings.join(heros, ',');
        String content2 = Strings.join(rr, ',');

        try {
//            FileUtils.write(new File("./"+ folder +"/hero.txt"), this.getData().username + "," + content1 + "\r", true);
            FileUtils.write(new File("./"+ folder +"/attr.txt"), this.getData().username + "," + content2 + "\r", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCaoxueInfo(){
        ResponseEntity<String> resp =  this.runAction3("{\"huodong2\":{\"hd966Info\":[]},\"rsn\":\"%s\"}");
        String res = resp.getBody();
        Configuration conf = Configuration.defaultConfiguration();
        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        DocumentContext dc = JsonPath.using(conf2).parse(res);
        List<Object> book1 = dc.read("$.a.richman2.store[?(@.id==60101)].count");

        Integer x1 = 0;

        if(Objects.isNull(book1) || book1.size() == 0){
        }else{
            x1  = Integer.valueOf(book1.get(0).toString());
        }

        List<Object> rr = Arrays.asList( x1);
        String content = Strings.join(rr, ',');

        try {
            FileUtils.write(new File("./caoxue.txt"), this.getData().username + "," + content + "\r", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getBeastInfo(String res, String folder){
//        ResponseEntity<String> resp =  this.runAction3("{\"rsn\":\"%s\",\"guide\":{\"login\":{\"platform\":\"qiangwanzdhgios\",\"ug\":\"\"}}}");
//        String res = resp.getBody();
        Configuration conf = Configuration.defaultConfiguration();
        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        DocumentContext dc = JsonPath.using(conf2).parse(res);
        List<Object> book1 = dc.read("$.a.beast.bag[?(@.id==101)].count");
        List<Object> book2 = dc.read("$.a.beast.bag[?(@.id==102)].count");
        List<Object> book3 = dc.read("$.a.beast.bag[?(@.id==103)].count");

        Integer x1 = 0;
        Integer x2 = 0;
        Integer x3 = 0;

        if(Objects.isNull(book1) || book1.size() == 0){
        }else{
            x1  = Integer.valueOf(book1.get(0).toString());
        }

        if(Objects.isNull(book2) || book2.size() == 0){
        }else{
            x2  = Integer.valueOf(book2.get(0).toString());
        }

        if(Objects.isNull(book3) || book3.size() == 0){
        }else{
            x3  = Integer.valueOf(book3.get(0).toString());
        }

        List<Object> rr = Arrays.asList(x1, x2, x3);
        String content = Strings.join(rr, ',');

        try {
            FileUtils.write(new File("./"+ folder +"/beast.txt"), this.getData().username + "," + content + "\r", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCourtyardInfo(boolean buy, String folder){
        ResponseEntity<String> resp =  this.runAction3("{\"courtyard\":{\"comeCourtyard\":[]},\"rsn\":\"%s\"}");
        String res = resp.getBody();
        Configuration conf = Configuration.defaultConfiguration();
        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        DocumentContext dc = JsonPath.using(conf2).parse(res);
        List<Object> book1 = dc.read("$.a.courtyard.bag[?(@.id==21)].num");
        List<Object> book2 = dc.read("$.a.courtyard.bag[?(@.id==121)].num");
        List<Object> book3 = dc.read("$.a.courtyard.bag[?(@.id==22)].num");
        List<Object> book4 = dc.read("$.a.courtyard.bag[?(@.id==122)].num");
        List<Object> book5 = dc.read("$.a.courtyard.bag[?(@.id==28)].num");
        List<Object> book6 = dc.read("$.a.courtyard.bag[?(@.id==128)].num");

        List<Object> book7 = dc.read("$.a.courtyard.bag[?(@.id==207)].num");

        Object lv = dc.read("$.a.courtyard.base.lv");
        Object mc = dc.read("$.a.courtyard.base.mc");
        Object sp = dc.read("$.a.courtyard.base.sp");

        Integer littletreezz = 0;
        Integer littletree = 0;
        Integer middletreezz = 0;
        Integer middletree = 0;
        Integer yumizz = 0;
        Integer yumi = 0;
        Integer yumiFan = 0;

        if(Objects.isNull(book1) || book1.size() == 0){
        }else{
            littletreezz  = Integer.valueOf(book1.get(0).toString());
        }

        if(Objects.isNull(book2) || book2.size() == 0){
        }else{
            littletree  = Integer.valueOf(book2.get(0).toString());
        }

        if(Objects.isNull(book3) || book3.size() == 0){
        }else{
            middletreezz  = Integer.valueOf(book3.get(0).toString());
        }

        if(Objects.isNull(book4) || book4.size() == 0){
        }else{
            middletree  = Integer.valueOf(book4.get(0).toString());
        }

        if(Objects.isNull(book5) || book5.size() == 0){
        }else{
            yumizz  = Integer.valueOf(book5.get(0).toString());
        }

        if(Objects.isNull(book6) || book6.size() == 0){
        }else{
            yumi  = Integer.valueOf(book6.get(0).toString());
        }

        if(Objects.isNull(book7) || book7.size() == 0){
        }else{
            yumiFan  = Integer.valueOf(book7.get(0).toString());
        }

        List<Object> rr = Arrays.asList(lv, mc, sp, littletreezz, littletree, middletreezz, middletree, yumizz, yumi, yumiFan);
        String content = Strings.join(rr, ',');

        if(buy){
            if(Integer.valueOf(lv.toString()).intValue() == 5){
                //do nothing
                this.buyYumi(100);
            }else if(Integer.valueOf(lv.toString()).intValue() >= 3){
    //            if(middletreezz.intValue() < 30){
    //                this.buyMiddleTree(30 - middletreezz.intValue());
    //            }
                if(yumizz.intValue() < 100){
                    this.buyYumi(100 - yumizz.intValue());
                }
            }else if(Integer.valueOf(lv.toString()).intValue() == 1){
                this.buyLittleTree(10);
            }else if(Integer.valueOf(lv.toString()).intValue() == 2) {
                this.buyYumi(Integer.valueOf(sp.toString()).intValue()/ 200);
            }


//                else{
//                    this.buyYumi(10);
//                }
//                if(littletreezz.intValue() < 20){
//                    this.buyLittleTree(20 - littletreezz.intValue());
//                }
//                this.buyYumi(10);
//                if(yumizz.intValue() < 40){
//                    this.buyYumi(40 - yumizz.intValue());
//                }
//            }
        }else{
            try {
                FileUtils.write(new File("./"+ folder +"/courtyard.txt"), this.getData().username + "," + content + "\r", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void loveRankInfo(){
        String body = this.runAction3("{\"rsn\":\"%s\",\"ranking\":{\"paihang\":{\"type\":3}}}").getBody();

        Configuration conf = Configuration.defaultConfiguration();
        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        DocumentContext dc = JsonPath.using(conf2).parse(body);

        List<Map<String, Object>> lists = dc.read("$.a.ranking.love");

        for(int i = 0; i < 100; i++){
            Map<String, Object> m = lists.get(i);
            try {
                FileUtils.write(new File("./loverank-20210114.txt"), m.get("name") + "," + m.get("num") + "\r", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
