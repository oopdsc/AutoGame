import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.FluxSink;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Consumer2 implements Consumer<FluxSink<List<String>>> {

    Logger logger = LoggerFactory.getLogger(Consumer2.class);

    int n = 0;

    @Override
    public void accept(FluxSink<List<String>> sink) {
        sink.onRequest(e -> {
            logger.info("on request");
            if(n <= 2){
                List<String> list = new ArrayList<>(4);
                list.add("hello " + n);
                list.add("world " + n);
                list.add("AAAAA " + n);
                list.add("BBBBB " + n);


                n++;
                sink.next(list);
            }else{
                sink.complete();
            }

        });
    }
}
