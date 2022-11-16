package game.player;

import game.runner.PlayerData;

public class LianmengYamenPlayer extends BasePlayer {
    public LianmengYamenPlayer(PlayerData data) {
        super(data);
    }

    public LianmengYamenPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }



}
