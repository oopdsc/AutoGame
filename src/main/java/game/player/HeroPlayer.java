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
