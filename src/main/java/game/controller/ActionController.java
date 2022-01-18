package game.controller;

import game.active.DefaultGameRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@Controller()
@RequestMapping("/action")
public class ActionController {

    @PostMapping("/{file}")
    @ResponseBody
    public String doaction(@PathVariable String file, @RequestBody String body) throws IOException {

        new DefaultGameRunner().single(file + ".json", p -> {
            Arrays.stream(body.split("\\|")).forEach(ac ->{
                p.runAction3(ac);
            });
        });

        return "done";
    }

}
