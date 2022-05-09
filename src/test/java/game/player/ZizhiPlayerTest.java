package game.player;

import game.active.DefaultGameRunner;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ZizhiPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void everyUser5() {
        runner.all1(
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);
//                    zp.useBook(ZizhiPlayer.SID_5ZHILI_JiaRenTieJi, 55);
//                    zp.useBook(ZizhiPlayer.SID_5ZHILI_JiaRenTieJi, 55);
                    for(int i = 1; i <=2; i++){
                        zp.useBook(2, 1);
                        zp.useBook(2, 2);
                        zp.useBook(2, 8);
                        zp.useBook(3, 38);
                        zp.useBook(3, 41);
                        zp.useBook(62, 33);
                        zp.useBook(62, 34);
                        zp.useBook(62, 35);
                        zp.useBook(62, 36);
                        zp.useBook(62, 37);
                    }

                    HuodongPlayer hp = new HuodongPlayer(p);
                    hp.reward_ganen();

                }
//                , p -> {
//                    ZizhiPlayer zp = new ZizhiPlayer(p);
//
//                    zp.useBook(2, 1);
//                    zp.useBook(2, 2);
//                    zp.useBook(2, 8);
//
//                    zp.useBook(63, 38);
//
//
//                }
//                , p -> {
//                    ZizhiPlayer zp = new ZizhiPlayer(p);
//
//                    zp.useBook(2, 1);
//                    zp.useBook(2, 2);
//                    zp.useBook(2, 8);
//                    zp.useBook(63, 38);
//                }
                );
        System.out.println("done");
    }


    @Test
    void chongbangJuanzhou() {
        System.out.println("start" + new Date());
        runner.single(GameRunner.HUODONG,
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);

                    for(int i = 1; i <= 1; i++){
                        zp.useJuanzhou0(127, 55);
                    }
        });
    }

    @Test
    void chongbangBook() {
        System.out.println("start" + new Date());
        runner.single(GameRunner.HUODONG,
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);
                    for(int i = 1; i <= 150; i++){
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
                    for(int i = 1; i <= 100; i++){
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":66,\"num\":1,\"id\":41}},\"rsn\":\"%s\"}");
                    }
//                   孙武武力
                    for(int i = 1; i <= 200; i++){
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":47,\"num\":1,\"id\":28}},\"rsn\":\"%s\"}");
                    }
                    // 周瑜武力
                    for(int i = 1; i <= 100; i++){
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":63,\"num\":1,\"id\":38}},\"rsn\":\"%s\"}");
                    }

                    for(int i = 1; i <= 500; i++){
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
    public void reward(){
        runner.all1(p -> {
            ZizhiPlayer zp = new ZizhiPlayer(p);
            zp.reward();
        });
    }
}