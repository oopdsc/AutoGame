package game.service;

import game.player.BasePlayer;
import reactor.core.CorePublisher;
import reactor.core.publisher.Flux;

public interface Comsuer<PlayerData> {
    public void process(Flux<PlayerData> flux);
}
