package game.active;

import com.alibaba.fastjson.JSONObject;
import game.player.BasePlayer;
import game.runner.GameRunner;
import game.runner.PlayerData;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.function.Consumer;

public class DefaultGameRunner implements GameRunner<BasePlayer> {

    @Override
    public BasePlayer login(PlayerData data) {
        BasePlayer player = new BasePlayer(data);
        player.login();
        return player;
    }


    public void gold(Consumer<BasePlayer> onNext) throws IOException {
        Resource playerData = GameRunner.getResource("gold.json");

        String players = FileUtils.readFileToString(playerData.getFile(), Charset.defaultCharset());

        List<PlayerData> datas = JSONObject.parseArray(players, PlayerData.class);

        Flux<PlayerData> flux = Flux.fromIterable(datas);
        Scheduler s = Schedulers.boundedElastic();
        flux.parallel(datas.size()).runOn(s).map(this::login)
                .doOnNext(onNext).subscribe();
    }

    public void clubActive() throws IOException {

        GameRunner.sleep(240);
    }
}
