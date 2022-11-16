package game.player;

import game.active.DefaultGameRunner;
import game.command.LeagueCommand;
import game.runner.GameRunner;
import game.service.CangJingGeService;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static game.runner.GameRunner.getRsn;

class ZizhiPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void everyUser5() {
        runner.all1(
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);
//                    zp.useBook(ZizhiPlayer.SID_5ZHILI_JiaRenTieJi, 55);
//                    zp.useBook(ZizhiPlayer.SID_5ZHILI_JiaRenTieJi, 55);
//                    for(int i = 33; i <= 37; i++){
//                        zp.useBook(ZizhiPlayer.SID_4WULI_WUHU, i);
//                    }
//                    for(int i : p.data.mzid){
//                    zp.runAction2(LeagueCommand.xsupgrade1(41));
//                    for(int i = 1; i <= 1; i++){
//                        zp.runAction2(LeagueCommand.xsupgrade1(38));
////                        zp.runAction2(LeagueCommand.xsupgrade1(6));
//                    }

//                    zp.runAction2(LeagueCommand.xsupgrade1(34));
//                    zp.runAction2(LeagueCommand.xsupgrade1(34));

//                    zp.runAction2(LeagueCommand.xsupgrade(55));
//                    zp.runAction2(LeagueCommand.xsupgrade(55));
//                    zp.runAction2(LeagueCommand.xsupgrade(55));
//                    zp.runAction2(LeagueCommand.xsupgrade(55));

                    zp.runAction2(LeagueCommand.buyShopItem(1));
                    zp.runAction2(LeagueCommand.buyShopItem(1));
                    zp.runAction2(LeagueCommand.buyShopItem(1));
                    zp.runAction2(LeagueCommand.buyShopItem(1));
                    zp.runAction2(LeagueCommand.buyShopItem(2));
                    zp.runAction2(LeagueCommand.buyShopItem(2));
                    zp.runAction2(LeagueCommand.buyShopItem(2));

                    zp.runAction2(LeagueCommand.buyShopItem(8));
                    zp.runAction2(LeagueCommand.buyShopItem(8));
//                    zp.runAction2(LeagueCommand.upgradeSeat(1));
                    zp.runAction2(LeagueCommand.buyShopItem(5));
                    zp.runAction2(LeagueCommand.buyShopItem(5));
//                    }


                    //        for(int i = 1; i <= 1; i++){
//            this.runAction2(LeagueCommand.xsupgrade1(10));
//            this.runAction2(LeagueCommand.xsupgrade1(11));
//            this.runAction2(LeagueCommand.xsupgrade1(12));
//            this.runAction2(LeagueCommand.xsupgrade1(13));
//            this.runAction2(LeagueCommand.xsupgrade1(10));
//            this.runAction2(LeagueCommand.xsupgrade1(11));
//            this.runAction2(LeagueCommand.xsupgrade1(12));
//            this.runAction2(LeagueCommand.xsupgrade1(13));
//            this.runAction2(LeagueCommand.xsupgrade1(26));
//            this.runAction2(LeagueCommand.xsupgrade1(28));
//        }


                    for (int i = 1; i <= 1; i++) {
//                        zp.useBook(2, 1);
//                        zp.useBook(2, 2);
//                        zp.useBook(2, 8);
//                        zp.useBook(3, 38);
//                        zp.useBook(3, 41);
//                        zp.useBook(62, 33);
//                        zp.useBook(62, 34);
//                        zp.useBook(62, 35);
//                        zp.useBook(62, 36);
//                        zp.useBook(62, 37);

//                        zp.useBook(62, 37);
//                        zp.useBook(3, 40);
                    }
                }
        );
        System.out.println("done");
    }

    @Test
    void zzbangAll2() {

        List<String> names = new LinkedList<>();
//        names.add("wang25687");
//        names.add("ssqwerty");
//        names.add("cq147369");
//        names.add("muyang1");
//        names.add("pby123");
//        names.add("pby1234");

        runner.all1(
                p -> {
                    if (!names.contains(p.data.username)) {
                        CangJingGeService.oneKeyHelp(p);
//                        TongmengService.buyItems(p);
                    }
                }
        );
    }


    @Test
    void zzbangAll() {

        List<String> names = new LinkedList<>();
//        names.add("wang25687");
//        names.add("ssqwerty");
//        names.add("cq147369");
//        names.add("muyang1");
//        names.add("pby123");
//        names.add("pby1234");

        runner.all1(
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);
                    if(!names.contains(p.data.username)){
                        for (int i = 1; i <= 1; i++) {
//                            加资质
//                            zp.runAction2(LeagueCommand.xsupgrade1(10));
//                            zp.runAction2(LeagueCommand.xsupgrade1(11));
//                            zp.runAction2(LeagueCommand.xsupgrade1(12));
//                            zp.runAction2(LeagueCommand.xsupgrade1(13));
//                            zp.runAction2(LeagueCommand.xsupgrade1(10));
//                            zp.runAction2(LeagueCommand.xsupgrade1(11));
//                            zp.runAction2(LeagueCommand.xsupgrade1(12));
//                            zp.runAction2(LeagueCommand.xsupgrade1(13));
//                            zp.runAction2(LeagueCommand.xsupgrade1(26));
//                            zp.runAction2(LeagueCommand.xsupgrade1(28));

//                            加修身道具
//                            zp.runAction2(LeagueCommand.xsupgrade1(38));

//                          加国力
                            zp.runAction2(LeagueCommand.xsupgrade1(33));
                            zp.runAction2(LeagueCommand.xsupgrade1(34));
                            zp.runAction2(LeagueCommand.xsupgrade1(35));
                            zp.runAction2(LeagueCommand.xsupgrade1(36));
                            zp.runAction2(LeagueCommand.xsupgrade1(37));
                            zp.runAction2(LeagueCommand.xsupgrade1(39));
                            zp.runAction2(LeagueCommand.xsupgrade1(40));
                        }
                    }


//                    zp.runAction2(LeagueCommand.buyShopItem(1));
//                    zp.runAction2(LeagueCommand.buyShopItem(1));
//                    zp.runAction2(LeagueCommand.buyShopItem(1));
//                    zp.runAction2(LeagueCommand.buyShopItem(1));
//                    zp.runAction2(LeagueCommand.buyShopItem(2));
//                    zp.runAction2(LeagueCommand.buyShopItem(2));
//                    zp.runAction2(LeagueCommand.buyShopItem(2));
//
//                    zp.runAction2(LeagueCommand.buyShopItem(8));
//                    zp.runAction2(LeagueCommand.buyShopItem(8));
//                    zp.runAction2(LeagueCommand.buyShopItem(5));
//                    zp.runAction2(LeagueCommand.buyShopItem(5));
//                    zp.runAction2(LeagueCommand.buyShopItem(5));

                }
        );
        System.out.println("done");
    }

    @Test
    void chongbangJuanzhou() {
        System.out.println("start" + new Date());
        runner.single(GameRunner.HUODONG,
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);

                    for(int i = 1; i <= 30; i++){
                        zp.hanlinLvUp();
                    }

                    for (int i = 1; i <= 380; i++) {
                        zp.useJuanzhou0(127, 55);
                    }

                    for (int i = 1; i <= 160; i++) {
                        zp.useJuanzhou0(150, 58);
                        zp.useJuanzhou0(169, 66);
                    }
                });
    }

    @Test
    void chongbangBook() {
        System.out.println("start" + new Date());
        runner.single(GameRunner.HUODONG,
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);
                    for (int i = 1; i <= 450; i++) {
//                        zp.runAction2("{\"rsn\":\"%s\",\"item\":{\"useforhero\":{\"count\":100,\"heroid\":55,\"id\":81}}}");
                        zp.useBook0(128, 55);
                    }

                });
    }

    @Test
    void useJuanzhou() {
        System.out.println("start" + new Date());
        runner.single(GameRunner.HUODONG,
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);

                    //郭嘉武力
                    for (int i = 1; i <= 100; i++) {
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":66,\"num\":1,\"id\":41}},\"rsn\":\"%s\"}");
                    }
//                   孙武武力
                    for (int i = 1; i <= 200; i++) {
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":47,\"num\":1,\"id\":28}},\"rsn\":\"%s\"}");
                    }
                    // 周瑜武力
                    for (int i = 1; i <= 100; i++) {
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":63,\"num\":1,\"id\":38}},\"rsn\":\"%s\"}");
                    }

                    for (int i = 1; i <= 500; i++) {
                        //马云绿智力
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":127,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
                        //郭嘉政治
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":67,\"num\":1,\"id\":41}},\"rsn\":\"9rbmcmizjc\"}");
                        //关银屏魅力
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":109,\"num\":1,\"id\":51}},\"rsn\":\"%s\"}");
                    }


//                    for (int i = 1; i <= 2000; i++) {
//                        zp.useJuanzhou();
//                    }
//
//                    for(int i = 1; i <= 350; i++){
//                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":5,\"num\":1,\"id\":66}},\"rsn\":\"%s\"}");
//                    }
//
//                    for(int i = 1; i <= 100; i++){
//                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":1,\"sid\":128,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
//                    }

//                    for(int i = 1; i<= 400;i++){
////                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":107,\"num\":1,\"id\":51}},\"rsn\":\"%s\"}");
//                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":1611,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
//                    }
//
//                    for (int i = 1; i <= 80; i++){
//                        //郭嘉 - 3星政治 - 公羊传
//                        zp.useBook(13, 41);
//                    }
//
//                    for (int i = 1; i <= 68; i++){
//                        //庞统 - 3星政治 - 公羊传
//                        zp.useBook(13, 39);
//                    }
//
//                    for (int i = 1; i <= 98; i++){
//                        //周瑜 -2星政治 - 书经
//                        zp.useBook(12, 40);
//                    }
//
//                    for (int i = 1; i <= 27; i++){
//                        //孙尚香 - 5星政治 - 联姻
//                        zp.useBook(104, 50);
//                    }
//
//                    for (int i = 1; i <= 28; i++){
//                        //黄忠 - 4星政治 - 左传
//                        zp.useBook(41, 37);
//                    }
//
//                    for (int i = 1; i <= 22; i++){
//                        //墨子 - 5星政治 - 墨子
//                        zp.useBook(41, 22);
//                    }
//
//                    for (int i = 1; i <= 300; i++){
//                        //马超 - 2星政治 - 书经
//                        zp.useBook(41, 20);
//                    }
//
//                    for (int i = 1; i <= 300; i++){
//                        //苏乞儿 -
//                        zp.useBook(41, 20);
//                    }
//
//                    for (int i = 1; i <= 300; i++){
//                        //荆轲 -
//                        zp.useBook(41, 20);
//                    }

                });
        System.out.println("done" + new Date());
    }

    @Test
    public void reward() {
        runner.all1(p -> {
            ZizhiPlayer zp = new ZizhiPlayer(p);
            zp.reward();
        });
    }
}