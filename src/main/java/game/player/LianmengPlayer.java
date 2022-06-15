package game.player;

import game.command.ShopCommand;
import game.service.PlayerData;

import static game.service.GameRunner.getRsn;

public class LianmengPlayer extends BasePlayer {
    public LianmengPlayer(PlayerData data) {
        super(data);
    }

    public LianmengPlayer(BasePlayer player){
        super(player.data);
        super.baseUrl = player.baseUrl;
    }



    //{"club":{"clubApply":{"cid":70003}},"rsn":"8makkraejme"}
//    {"club":{"dayGongXian":{"dcid":3}},"rsn":"2awyynhnnh"}
//{"club":{"outClub":[]},"rsn":"6xwgguwpwsx"}
//      128  普通联盟令
//    131   追杀令
//    132   高级联盟令
//    135   联盟令碎片
//    {"rsn":"6wllsylgby","item":{"hecheng":{"count":1,"id":128}}}  合成普通联盟令


    public void club(){
        this.applyClub();
        this.dayGongxian();
        this.outClub();
    }

    public void applyClub() {
        String body = "{\"club\":{\"clubApply\":{\"cid\":70003}},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body);
    }

    public void dayGongxian() {
        String body = "{\"club\":{\"dayGongXian\":{\"dcid\":3}},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body);
    }

    public void dayHighGongxian() {
        this.runAction0("{\"club\":{\"dayGongXian\":{\"dcid\":5}},\"rsn\":\"%s\"}");
    }

    public void outClub() {
        String body = "{\"club\":{\"outClub\":[]},\"rsn\":\"" + getRsn() + "\"}";
        this.execute(baseUrl, body);
    }

    public void buyItems(){
        for(int i = 1; i <= 12; i++){
            this.runAction2(ShopCommand.ShopClubItems);
        }
        this.runAction2(ShopCommand.hechengClubNormalItem);
        this.runAction2(ShopCommand.hechengClubHighItem);
    }


    public void clubActiveReward() {
        for (int i = 1; i <= 15; i++) {
            this.runAction3("{\"huodong\":{\"hd202Rwd\":[]},\"rsn\":\"%s\"}");
        }
        for (int i = 1; i <= 10; i++) {
            this.runAction3("{\"huodong\":{\"hd206Rwd\":[]},\"rsn\":\"%s\"}");
        }
        for (int i = 1; i <= 18; i++) {
            this.runAction3("{\"huodong\":{\"hd223Rwd\":[]},\"rsn\":\"%s\"}");
        }
        for (int i = 1; i <= 11; i++) {
            this.runAction3("{\"huodong\":{\"hd224Rwd\":[]},\"rsn\":\"%s\"}");
        }
    }

}
