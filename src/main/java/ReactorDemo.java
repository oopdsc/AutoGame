import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReactorDemo {

    public List<String> bar(){
        LinkedList<String> ff = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            ff.add(String.valueOf(i));
        }
//         Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
        return ff;
    }

    public void foo() {
        Flux<String> flux = Flux.create(fluxSink -> {



            this.bar().forEach(s -> {

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + " hello " + s);


                fluxSink.next("hello " + s);
            });
//            for (int i = 0; i < 5; i++) {
//
////                try {
////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//                System.out.println(Thread.currentThread().getName() + " hello " + i);
//                fluxSink.next("hello " + i);
//
//            }
            fluxSink.complete();

        });

        Flux<String> flux1 = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });

        Flux<String> flux2 = Flux.generate(sk -> {
            for (int i = 0; i < 10; i++) {
                sk.next("hello " + i);
            }
        });

        Scheduler s = Schedulers.parallel();

//        flux.limitRate(8).doOnNext(c -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()  + c);
//        }).subscribe();

//        flux.parallel().runOn(s).subscribe(c -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + c);
//
////            request(2);
//        });
//parallel().runOn(s).
        flux.parallel().runOn(s).subscribe(new BaseSubscriber<String>() {

            @Override
            public void hookOnSubscribe(Subscription subscription) {
                request(1);
            }

            @Override
            public void hookOnNext(String integer) {
                System.out.println("Cancelling after having received " + integer);
                request(1);
//                cancel();
            }
        });

        Flux.range(1, 10)
                .doOnRequest(r -> System.out.println("request of " + r))
                .subscribe(new BaseSubscriber<Integer>() {

                    @Override
                    public void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    public void hookOnNext(Integer integer) {
                        System.out.println("Cancelling after having received " + integer);
                        cancel();
                    }
                });

//        s.start();

        System.out.println("done");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ReactorDemo().foo();
    }

}
