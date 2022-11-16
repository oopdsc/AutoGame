package game.service;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import game.command.LeagueCommand;
import game.player.BasePlayer;
import game.player.HeroPlayer;
import game.utils.JsonUtil;

import java.util.List;

public class HeroService {




    public static void xsupgrade1(BasePlayer p, int hero){
        p.runAction2(LeagueCommand.xsupgrade1(hero));
    }


    public static void pkSkillup(BasePlayer p, int lv, int ... heros){

        String resp = p.getAllinfo();
        Configuration conf = Configuration.defaultConfiguration();
        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        DocumentContext dc = JsonPath.using(conf2).parse(resp);
        for(int hero : heros){
//            this.hero_pkskill_lvup2(dc, 80, i);
            List<Integer> lv1 = dc.read("$.a.hero.heroList[?(@.id=="+hero+")].pkskill[?(@.id==1)].level");
            List<Integer> lv2 = dc.read("$.a.hero.heroList[?(@.id=="+hero+")].pkskill[?(@.id==2)].level");

            int lv1i = Integer.valueOf(JsonUtil.getFromList(lv1).toString()).intValue();
            int lv2i = Integer.valueOf(JsonUtil.getFromList(lv2).toString()).intValue();

            for(int i = 1; i <= lv - lv1i; i++){
                p.runAction1("{\"hero\":{\"uppkskill\":{\"sid\":1,\"id\":"+hero+"}},\"rsn\":\"%s\"}");
            }
            for(int i = 1; i <= lv - lv2i; i++){
                p.runAction1("{\"hero\":{\"uppkskill\":{\"sid\":2,\"id\":"+hero+"}},\"rsn\":\"%s\"}");
            }
        }
    }

    public static void useBookForHero(BasePlayer p, int hero){
        p.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":"+hero+",\"id\":81}}}");
    }
    public static void upzzskillJuanzhou(BasePlayer p, int hero, int sid){
        p.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":"+sid
                +",\"num\":1,\"id\":"+hero+"}},\"rsn\":\"%s\"}");
    }

    public static void upzzskillJingyan(BasePlayer p, int hero, int sid){
        p.runAction0("{\"hero\":{\"upzzskill\":{\"type\":1,\"sid\":"+sid
                +",\"num\":1,\"id\":"+hero+"}},\"rsn\":\"%s\"}");
    }

    /*
    152 - 吕玲绮
    155 - 王异
    157 - 祝融
     */
    public static void hechengNvjiang(BasePlayer p, int itemId){
        p.runAction2("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":10,\"id\":152}}}");
    }

    public static void getNvjiang(BasePlayer p, int heroId){
        p.runAction2("{\"huodong\":{\"hd272Rwd\":{\"id\":"+heroId+"}},\"rsn\":\"%s\"}");
    }


    static int LINGLINGFA = 1;

    static int DUFU = 23;

    static int GUANYU = 33;
    static int ZHANGFEI = 34;
    static int ZHAOYUN = 35;
    static int MACHAO = 36;
    static int HUANGZHONG = 37;
    static int ZHUGELIANG = 38;
    static int PANGTONG = 39;
    static int ZHOUYU = 40;
    static int GUOJIA = 41;

    static int WEIXIAOBAO = 44;

    static int GUANYINPIN = 51;
    static int GUANYINPIN_6WU = 107;
    static int GUANYINPIN_6MEI = 109;

    static int LVLINGQI = 53;
    static int LVLINGQI_6WU = 111;
    static int LVLINGQI_6ZHI = 113;
    static int LVLINGQI_7ZHI = 1611;

    static int MAYUNLV = 55;
    static int MAYUNLV_7ZHI = 127;

    static int ZHANGXINGCAI = 58;
    static int ZHANGXINGCAI_5WU = 5;
    static int ZHANGXINGCAI_7MEI = 150;

    static int WANGYI = 65;
    static int WANGYI_6WU = 165;

    static int ZHANGCHUNHUA = 66;
    static int ZHANGCHUNHUA_7ZHENG = 169;

    static int ZHURONG = 68;
    static int ZHURONG_7WULI = 171;

}
