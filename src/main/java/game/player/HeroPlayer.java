package game.player;

import game.service.PlayerData;

public class HeroPlayer extends BasePlayer {
    public HeroPlayer(PlayerData data) {
        super(data);
    }

    public HeroPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }

    public void hero_zhili4(){
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":10,\"heroid\":55,\"id\":24}}}");
    }

    public void hero_zhili3(){
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":10,\"heroid\":55,\"id\":23}}}");
    }

    public void pkskill1up(int heroid){
        this.runAction1("{\"hero\":{\"uppkskill\":{\"sid\":1,\"id\":"+heroid+"}},\"rsn\":\"%s\"}");
    }

    public void pkskill2up(int heroid){
        this.runAction1("{\"hero\":{\"uppkskill\":{\"sid\":2,\"id\":"+heroid+"}},\"rsn\":\"%s\"}");
    }

    public void hero_up(int heroid, int currentLv){
        if(currentLv >= 300){
            return;
        }
        if(currentLv < 100){
            for(int i = 1; i <= 10; i++){
                this.lv_up(heroid);
            }
            this.hero_up(heroid, 100);
        }else{
            this.senior_up(heroid);
            for(int i = 1; i <= 5; i++){
                this.lv_up(heroid);
            }
            this.hero_up(heroid, currentLv + 50);
        }
    }

    public void lv_up(int heroid){
        this.runAction1("{\"hero\":{\"upgradeTen\":{\"id\":"+heroid+"}},\"rsn\":\"%s\"}");
    }

    public void senior_up(int heroid){
        this.runAction1("{\"hero\":{\"upsenior\":{\"id\":"+heroid+"}},\"rsn\":\"%s\"}");
    }

    public void lv_item_300_from_200(){
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":15,\"id\":163}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":15,\"id\":164}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":15,\"id\":165}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":5,\"id\":166}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":5,\"id\":167}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":5,\"id\":168}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":169}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":170}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":171}}}");
    }

    public void lv_item_300_from_250(){
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":12,\"id\":163}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":12,\"id\":164}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":12,\"id\":165}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":4,\"id\":166}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":4,\"id\":167}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":4,\"id\":168}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":169}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":170}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":171}}}");
    }

    //from 0
    public void lv_item_300(){
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":16,\"id\":163}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":16,\"id\":164}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":16,\"id\":165}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":5,\"id\":166}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":5,\"id\":167}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":5,\"id\":168}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":169}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":170}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":171}}}");
    }

    public void item_350(){
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":60,\"id\":163}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":60,\"id\":164}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":60,\"id\":165}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":20,\"id\":166}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":20,\"id\":167}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":20,\"id\":168}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":5,\"id\":169}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":5,\"id\":170}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":5,\"id\":171}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":172}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":173}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":174}}}");
    }

    public void item_400(){
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":360,\"id\":163}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":360,\"id\":164}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":360,\"id\":165}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":120,\"id\":166}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":120,\"id\":167}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":120,\"id\":168}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":30,\"id\":169}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":30,\"id\":170}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":30,\"id\":171}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":6,\"id\":172}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":6,\"id\":173}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":6,\"id\":174}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":175}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":176}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":177}}}");
    }




    public void mayunlv(){
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":436,\"id\":163}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":436,\"id\":164}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":436,\"id\":165}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":145,\"id\":166}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":145,\"id\":167}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":145,\"id\":168}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":36,\"id\":169}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":36,\"id\":170}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":36,\"id\":171}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":7,\"id\":172}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":7,\"id\":173}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":7,\"id\":174}}}");

        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":175}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":176}}}");
        this.runAction3("{\"rsn\":\"%s\",\"item\":{\"hecheng\":{\"count\":1,\"id\":177}}}");


        for(int i = 1; i <= 10; i++){
            this.runAction3("{\"hero\":{\"upgradeTen\":{\"id\":55}},\"rsn\":\"%s\"}");
            this.runAction3("{\"hero\":{\"upsenior\":{\"id\":55}},\"rsn\":\"%s\"}");
        }

        for(int j = 1; j <= 6; j++){
            for(int i = 1; i <= 5; i++){
                this.runAction3("{\"hero\":{\"upgradeTen\":{\"id\":55}},\"rsn\":\"%s\"}");
                this.runAction3("{\"hero\":{\"upsenior\":{\"id\":55}},\"rsn\":\"%s\"}");
            }
        }
    }


}
