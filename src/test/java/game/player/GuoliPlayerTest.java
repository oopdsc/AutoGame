package game.player;

import game.active.DefaultGameRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("国力榜测试")
class GuoliPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    @DisplayName("加国力")
    public void addGuoli(){
        String all1 = runner.all1( p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
//            gp.silu();
            gp.addGuoli();


        });
        System.out.println(all1);
    }

}