package game.player;

import game.active.DefaultGameRunner;
import game.service.GuoliService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("国力榜测试")
class GuoliPlayerTest {

    DefaultGameRunner runner = new DefaultGameRunner();

    @Test
    @DisplayName("加国力")
    public void addGuoli(){
        String all1 = runner.all1( p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addGuoli();
        }, p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addGuoli();
        }, p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addGuoli();
        });
        System.out.println(all1);
    }

    @Test
    @DisplayName("加国力")
    public void addSingleGuoli(){
        runner.single("huodong.json", p -> {
            GuoliPlayer gp = new GuoliPlayer(p);
            gp.addAllGuoli();
        });
        System.out.println("done");
    }

    @Test
    @DisplayName("加国力")
    public void addSingleGuoli2(){
        runner.single("huodong.json", p -> {
            GuoliService.buyItems(p);
        });
        System.out.println("done");
    }

}