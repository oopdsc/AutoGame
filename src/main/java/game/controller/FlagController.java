package game.controller;

import game.config.Flags;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/flag")
public class FlagController {

    @ApiOperation(value="获取击杀匈奴开关", tags = {"系统参数"})
    @GetMapping("/xiongnu")
    @ResponseBody
    public String xiongnu(){
        return String.valueOf(Flags.xiongnu);
    }

    @ApiOperation(value="更新击杀匈奴开关", tags = {"系统参数"})
    @GetMapping("/updateXiongnu")
    @ResponseBody
    public String updateXiongnu(){
        Flags.xiongnu = !Flags.xiongnu;
        return String.valueOf(Flags.xiongnu);
    }

    @ApiOperation(value="获取跨服衙门开关", tags = {"系统参数"})
    @GetMapping("/kuayamen")
    @ResponseBody
    public String kuayamen(){
        return String.valueOf(Flags.kuayamen);
    }

    @ApiOperation(value="更新跨服衙门开关", tags = {"系统参数"})
    @GetMapping("/updateKuayamen")
    @ResponseBody
    public String updateKuayamen(){
        Flags.kuayamen = !Flags.kuayamen;
        return String.valueOf(Flags.kuayamen);
    }

    @ApiOperation(value="获取跨服绝地衙门开关", tags = {"系统参数"})
    @GetMapping("/jdyamen")
    @ResponseBody
    public String jdyamen(){
        return String.valueOf(Flags.jdyamen);
    }

    @ApiOperation(value="更新跨服绝地衙门开关", tags = {"系统参数"})
    @GetMapping("/updatejdyamen")
    @ResponseBody
    public String updatejdyamen(){
        Flags.jdyamen = !Flags.jdyamen;
        return String.valueOf(Flags.jdyamen);
    }

    @ApiOperation(value="获取衙门开关", tags = {"系统参数"})
    @GetMapping("/fullyamen")
    @ResponseBody
    public String fullyamen(){
        return String.valueOf(Flags.fullyamen);
    }

    @ApiOperation(value="更新衙门开关", tags = {"系统参数"})
    @GetMapping("/updateFullyamen")
    @ResponseBody
    public String updateFullyamen(){
        Flags.fullyamen = !Flags.fullyamen;
        return String.valueOf(Flags.fullyamen);
    }
    @ApiOperation(value="获取购买种子ID", tags = {"系统参数"})
    @GetMapping("/zidbuy")
    @ResponseBody
    public String zidbuy(){
        return String.valueOf(Flags.zidbuy);
    }

    @ApiOperation(value="更新购买种子ID", tags = {"系统参数"})
    @PostMapping("/updatezidbuy")
    @ResponseBody
    public String updateZidbuy(@RequestBody String zidbuy){
        Flags.zidbuy = Integer.valueOf(zidbuy).intValue();
        return String.valueOf(Flags.zidbuy);
    }

    @ApiOperation(value="获取购买种子数量", tags = {"系统参数"})
    @GetMapping("/zidCount")
    @ResponseBody
    public String zidCount(){
        return String.valueOf(Flags.zidCount);
    }

    @ApiOperation(value="更新购买种子数量", tags = {"系统参数"})
    @PostMapping("/updatezidCount")
    @ResponseBody
    public String updatezidCount(@RequestBody String zidCount){
        Flags.zidCount = Integer.valueOf(zidCount).intValue();
        return String.valueOf(Flags.zidCount);
    }

    @ApiOperation(value="做菜数量", tags = {"系统参数"})
    @GetMapping("/cook")
    @ResponseBody
    public String cook(){
        return String.valueOf(Flags.cook);
    }

    @ApiOperation(value="更新做菜数量", tags = {"系统参数"})
    @PostMapping("/updatecook")
    @ResponseBody
    public String updatecook(@RequestBody String cook){
        Flags.cook = Integer.valueOf(cook).intValue();
        return String.valueOf(Flags.cook);
    }

    @ApiOperation(value="大号任务运行中", tags = {"系统参数"})
    @GetMapping("/dahao")
    @ResponseBody
    public String dahao(){
        return String.valueOf(Flags.dahao);
    }

    @ApiOperation(value="小号1任务运行中", tags = {"系统参数"})
    @GetMapping("/xiaohao1")
    @ResponseBody
    public String xiaohao1(){
        return String.valueOf(Flags.xiaohao1);
    }

    @ApiOperation(value="小号2任务运行中", tags = {"系统参数"})
    @GetMapping("/xiaohao2")
    @ResponseBody
    public String xiaohao2(){
        return String.valueOf(Flags.xiaohao2);
    }


}
