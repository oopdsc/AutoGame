package game.controller;

import game.config.Flags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        logger.info("hello");
        return "hello";
    }

    @GetMapping("/tasks")
    @ResponseBody
    public String tasks(){
        return Flags.dahao + "<br />" + Flags.xiaohao1 + "<br />" + Flags.xiaohao2;
    }
}
