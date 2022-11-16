package game.runner;

import reactor.core.publisher.Flux;

public interface Comsuer<PlayerData> {
    public void process(Flux<PlayerData> flux);
}
