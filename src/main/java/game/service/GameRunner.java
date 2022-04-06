package game.service;

import com.alibaba.fastjson.JSONObject;
import game.config.Flags;
import game.player.BasePlayer;
import game.player.Double11Player;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface GameRunner<T extends BasePlayer> {

    Logger logger = LoggerFactory.getLogger(GameRunner.class);

    String RUNNER = "runner.json";
    String HUODONG = "huodong.json";
    String DAHAO = "dahao.json";
    String XIAOHAO = "xiaohao.json";
    String XIAOHAO1 = "xiaohao1.json";
    String XIAOHAO2 = "xiaohao2.json";
    String GOLD = "gold.json";
    ExecutorService es = Executors.newWorkStealingPool(40);

    Scheduler s = Schedulers.boundedElastic();

    int size = 4;

    Random rd = new Random();

    static Resource getResource(String file){

//        return new ClassPathResource(file);

        return new FileSystemResource("/usr/games/" + file);
//        return new FileSystemResource("D:/Work/reactor/src/main/resources/" + file);
    }

    default void all(Consumer<T> consumer){
        es.submit(() -> this.singleDahao(consumer) );

        es.submit(() -> this.singleXiaohao1(consumer));

        es.submit(() -> this.singleXiaohao2(consumer));
    }

    default String all1(Consumer<T> consumer1, Consumer<T> consumer2, Consumer<T> consumer3){
        Future<String> dahao = es.submit(() -> {
            if(Objects.nonNull(consumer1)){
                this.singleDahao(p -> {
                    consumer1.accept(p);
                });
            }
            return "dahao";
        } );

        Future<String> xiaohao1 =  es.submit(() -> {
            if(Objects.nonNull(consumer2)){
                this.singleXiaohao1(p -> {
                    consumer2.accept(p);
                });
            }
            return "Xiaohao1";
        });

        Future<String> xiaohao2 = es.submit(() -> {
            if(Objects.nonNull(consumer3)){
                this.singleXiaohao2(p -> {
                    consumer3.accept(p);
                });
            }
            return "Xiaohao2";
        });

        try {
            return
                    dahao.get() +
                    xiaohao1.get() +
                            xiaohao2.get();
        } catch (Exception e) {
            return "not all done";
        }
    }

    default String all1(Consumer<T> consumer){
        return this.all1(consumer, consumer, consumer);

    }

    default void multi(String file, Consumer<T> consumer) {
        this.processMulti(file, p->{
            consumer.accept(p);
            GameRunner.sleep(Flags.sleepTime);
        });
    }

    default void multi(String file, Predicate<PlayerData> predicate, Consumer<T> consumer)  {
        this.processMulti(file, predicate, p->{
            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);
        });
    }

    default void single(String file, Consumer<T> consumer) {
        this.processSingle(file, p->{
            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);
        });
    }

    default void singleRunner(Consumer<T> consumer) {
        this.single(RUNNER, consumer);
    }

    default void singleDahao(Consumer<T> consumer) {
        this.processSingle(DAHAO, p->{

            Flags.dahao = p.data.username;

            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);
        });

        Flags.dahao = "false";
    }

    default void shuffleDahao(Consumer<T> consumer) {
        this.processShuffle(DAHAO, p->{

            Flags.dahao = p.data.username;

            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);
        });

        Flags.dahao = "false";
    }

    default void singleXiaohao1(Consumer<T> consumer) {
        this.processSingle(XIAOHAO1, p->{

            Flags.xiaohao1 = p.data.username;

            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);
        });

        Flags.xiaohao1 = "false";
    }

    default void singleXiaohao2(Consumer<T> consumer) {
        this.processSingle(XIAOHAO2, p->{

            Flags.xiaohao2 = p.data.username;

            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);
        });

        Flags.xiaohao2 = "false";
    }

    default void single(String file, Predicate<PlayerData> predicate, Consumer<T> consumer)  {
        this.processSingle(file, predicate, p->{
            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);
        });
    }

    default void singleRunner(Predicate<PlayerData> predicate, Consumer<T> consumer) {
        this.single(RUNNER, predicate, consumer);
    }

    default void singleDahao(Predicate<PlayerData> predicate, Consumer<T> consumer) {
        this.processSingle(DAHAO, predicate, p->{

            Flags.dahao = p.data.username;

            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);
        });

        Flags.dahao = "false";
    }

    default void singleXiaohao1(Predicate<PlayerData> predicate, Consumer<T> consumer) {
        this.processSingle(XIAOHAO1, predicate, p->{

            Flags.xiaohao1 = p.data.username;

            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);

        });

        Flags.xiaohao1 = "false";
    }

    default void singleXiaohao2(Predicate<PlayerData> predicate, Consumer<T> consumer) {
        this.processSingle(XIAOHAO2, predicate, p->{

            Flags.xiaohao2 = p.data.username;

            consumer.accept(p);

            GameRunner.sleep(Flags.sleepTime);
        });

        Flags.xiaohao2 = "false";
    }


    T login(PlayerData data);

    default void processMulti(String file, Predicate<PlayerData> predicate, Consumer<T> onNext) {
        try {
            Resource playerData = getResource(file);

            String players = FileUtils.readFileToString(playerData.getFile(), Charset.defaultCharset());

            List<PlayerData> datas = JSONObject.parseArray(players, PlayerData.class);

            Flux<PlayerData> flux = Flux.fromIterable(datas);

            flux.filter(predicate).parallel(size).runOn(s).map(this::login)
                    .doOnNext(onNext).sequential().doOnComplete(() -> {
                logger.info("process done." + LocalDateTime.now());
            }).subscribe();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    default void processMulti(String file, Consumer<T> onNext) {
        try {
            Resource playerData = getResource(file);

            String players = FileUtils.readFileToString(playerData.getFile(), Charset.defaultCharset());

            List<PlayerData> datas = JSONObject.parseArray(players, PlayerData.class);

            Flux<PlayerData> flux = Flux.fromIterable(datas);

            flux.parallel(size).runOn(s).map(this::login)
                    .doOnNext(onNext).sequential().doOnComplete(() -> {
                logger.info("process done." + LocalDateTime.now());
            }).subscribe();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    default void processSingle(String file, Predicate<PlayerData> predicate, Consumer<T> onNext) {

        try{
            Resource playerData = getResource(file);

            String players = FileUtils.readFileToString(playerData.getFile(), Charset.defaultCharset());

            List<PlayerData> datas = JSONObject.parseArray(players, PlayerData.class);
            Flux<PlayerData> flux = Flux.fromIterable(datas);

            flux.filter(predicate).map(this::login).doOnNext(onNext).subscribe();
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }

    }

    default void processShuffle(String file, Consumer<T> onNext) {
        try{
            Resource playerData = getResource(file);

            String players = FileUtils.readFileToString(playerData.getFile(), Charset.defaultCharset());

            List<PlayerData> datas = JSONObject.parseArray(players, PlayerData.class);
            Collections.shuffle(datas);
            Flux<PlayerData> flux = Flux.fromIterable(datas);

            flux.map(this::login).doOnNext(onNext).subscribe();
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
    }

    default void processSingle(String file, Consumer<T> onNext) {
        try{
            Resource playerData = getResource(file);

            String players = FileUtils.readFileToString(playerData.getFile(), Charset.defaultCharset());

            List<PlayerData> datas = JSONObject.parseArray(players, PlayerData.class)
//                    .subList(43, 86)
                    ;

//            System.out.println(datas.size());
            Flux<PlayerData> flux = Flux.fromIterable(datas);

            flux.map(this::login).doOnNext(onNext).subscribe();
        }catch(Exception e){
            logger.error(e.getMessage(), e);
        }
    }

    static String getRsn() {
        long ts = (new Date().getTime() / 10000) % 100000000;
        int rand = 1;
//        int codeRand = 7;
//        char[] codeArr = {'l', 'c', 'y', 'x', 'g', 'o', 'v', 's', 'p', 'd'};

//        int codeRand = 1;
//        char[] codeArr = {'u','t','k','q','a','b','r','e','i','w'};

        int codeRand = rd.nextInt(8) + 1;
        char[][] codeArrs = {
                {'0','0','0','0','0','0','0','0','0','0'},
                {'u','t','k','q','a','b','r','e','i','w'},
                {'q','a','y','m','x','n','b','w','h','l'},
                {'p','h','e','z','f','k','n','r','w','s'},
                {'g','c','f','a','m','i','v','h','b','x'},
                {'h','w','y','j','f','p','e','v','r','a'},
                {'b','w','x','s','g','u','y','p','k','l'},
                {'l','c','y','x','g','o','v','s','p','d'},
                {'o','a','m','j','k','r','i','v','e','x'},
                {'t','r','m','z','s','n','c','j','i','b'}
        };

        char[] codeArr = codeArrs[codeRand];

        long ltime = ts << rand;
        String strltime = String.valueOf(ltime).substring(2) + "0";
        String atime = String.valueOf(rand) + strltime;
        String cipher = "";
        int len = atime.length();

        for (int i = 0; i < len; i++) {
            int index = Integer.valueOf(atime.charAt(i)).intValue() - 48;
            char s = codeArr[index];
            cipher = cipher + s;
        }

        return codeRand + cipher;
    }


    static void sleep(int second) {
        if(second == 0){
            return;
        }
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void sleepInMillis(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
