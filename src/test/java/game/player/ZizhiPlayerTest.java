package game.player;

import game.active.DefaultGameRunner;
import game.service.GameRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZizhiPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    void everyUser5() {
        runner.single(GameRunner.RUNNER,
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);
                    zp.useBook(ZizhiPlayer.SID_5ZHILI_JiaRenTieJi, 55);
                });
        System.out.println("done");
    }

    @Test
    void useJuanzhou() {
        runner.single(GameRunner.HUODONG,
                p -> {
                    ZizhiPlayer zp = new ZizhiPlayer(p);
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

                    for(int i = 1; i<= 400;i++){
//                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":107,\"num\":1,\"id\":51}},\"rsn\":\"%s\"}");
                        zp.runAction0("{\"hero\":{\"upzzskill\":{\"type\":2,\"sid\":1611,\"num\":1,\"id\":55}},\"rsn\":\"%s\"}");
                    }
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
        System.out.println("done");
    }

    public void reward(){
        runner.all(p -> {
            ZizhiPlayer zp = new ZizhiPlayer(p);
            zp.reward();
        });
    }
}