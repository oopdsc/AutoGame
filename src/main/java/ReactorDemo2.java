import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.List;

public class ReactorDemo2 {

    Logger logger = LoggerFactory.getLogger(ReactorDemo2.class);

    Consumer2 con2 = new Consumer2();

    public void foo(){
        Flux<List<String>> ds = Flux.create(con2);

//        ds.parallel(3).doOnNext(new BaseSubscriber<String>() {
//            @Override
//            protected void hookOnSubscribe(Subscription subscription) {
//                logger.info("hookOnSubscribe");
//                super.hookOnSubscribe(subscription);
//
//            }
//
//            @Override
//            protected void hookOnComplete() {
//                logger.info("hookOnComplete");
//                super.hookOnComplete();
//            }
//
//            @Override
//            protected void hookOnNext(String value) {
//                logger.info("hookOnNext" + value);
//                super.hookOnNext(value);
////                request(1);
//            }
//        }).sequential().doOnNext(new BaseSubscriber<String>() {
//            @Override
//            protected void hookOnNext(String value) {
//                logger.info("hookOnNext2" + value);
//                request(1);
//            }
//
//        });

        ds.subscribe(new BaseSubscriber<List<String>>() {
            @Override
            protected void hookOnNext(List<String> value) {
                logger.info("doOnNext" + value.size());
                Flux<String> ff = Flux.fromIterable(value);
                Scheduler s = Schedulers.parallel();
                ff.parallel(10).runOn(s).doOnNext(e -> {


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                    logger.info("parallel doOnNext" + e);
                }).subscribe();
//                        .sequential().subscribe(new BaseSubscriber<String>() {
//                                @Override
//                                protected void hookOnNext(String value) {
//                                    logger.info("hookOnNext2" + value);
//                                }
////                request(1);
//            });
                logger.info("before request");
                request(2);
        }
    });
    }

    public static void main(String[] args){
        new ReactorDemo2().foo();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
