package game.service;

import game.command.LeagueCommand;
import game.player.BasePlayer;

public class TongmengService {

    public static void buyItems(BasePlayer p){
        p.runAction2(LeagueCommand.buyShopItem(1));
        p.runAction2(LeagueCommand.buyShopItem(1));
        p.runAction2(LeagueCommand.buyShopItem(1));
        p.runAction2(LeagueCommand.buyShopItem(1));
//        p.runAction2(LeagueCommand.buyShopItem(2));
//        p.runAction2(LeagueCommand.buyShopItem(2));
//        p.runAction2(LeagueCommand.buyShopItem(2));
//        p.runAction2(LeagueCommand.buyShopItem(8));
//        p.runAction2(LeagueCommand.buyShopItem(8));
        p.runAction2(LeagueCommand.buyShopItem(5));
        p.runAction2(LeagueCommand.buyShopItem(5));
        p.runAction2(LeagueCommand.buyShopItem(5));
        p.runAction2(LeagueCommand.buyShopItem(5));
        p.runAction2(LeagueCommand.buyShopItem(5));
//        p.runAction2(LeagueCommand.upgradeSeat(1));
    }
}
