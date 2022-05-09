package game.player;

import game.service.PlayerData;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ShopPlayer extends BasePlayer {
    public ShopPlayer(PlayerData data) {
        super(data);
    }

    public ShopPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }

    /**
     * 买V5资质礼包
     */
    public void buyV3Zizhi(){
        this.runAction1("{\"shop\":{\"shopGift\":{\"id\":4}},\"rsn\":\"%s\"}");
    }

    /**
     * 买V3资质礼包
     */
    public void buyV5Zizhi(){
        this.runAction1("{\"shop\":{\"shopGift\":{\"id\":5}},\"rsn\":\"%s\"}");
    }

    /**
     * 买V5亲密礼包
     */
    public void buyV5Qinmi(){
        throw new NotImplementedException();
    }

    /**
     * 买V3亲密礼包
     */
    public void buyV3Qinmi(){
        throw new NotImplementedException();
    }

    /**
     * 买V5魅力礼包
     */
    public void buyV5Meili(){
        throw new NotImplementedException();
    }

    /**
     * 买V3魅力礼包
     */
    public void buyV3Meili(){
        throw new NotImplementedException();
    }


}
