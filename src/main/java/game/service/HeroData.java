package game.service;

import io.swagger.models.auth.In;

import java.util.*;

public class HeroData {

    public static List<String> heroname = new LinkedList<>();
    public static Map<Integer, String> heros = new HashMap<>();

    static {
        heroname = Arrays.asList(






                "",
                "零零发",
                "鳌拜",
                "和珅",
                "郑板桥",
                "喜来乐",
                "苏乞儿",
                "李卫",
                "刘伯温",
                "林则徐",
                "方世玉",
                "多尔衮",
                "左宗棠",
                "张之洞",
                "蒲松龄",
                "李鸿章",
                "李寻欢",
                "索尼",
                "胡雪岩",
                "曹雪芹",
                "海大富",
                "华佗",
                "墨子",
                "杜甫",
                "廉颇",
                "庄周",
                "李元芳",
                "鲁班",
                "孙武",
                "张良",
                "姜子牙",
                "孙膑",
                "白起",
                "关羽",
                "张飞",
                "赵云",
                "马超",
                "黄忠",
                "诸葛亮",
                "庞统",
                "周瑜",
                "郭嘉",
                "匈奴王",
                "荆轲",
                "韦小宝",
                "黄飞鸿",
                "李白",
                "吕布",
                "孙策",
                "汉武帝",
                "孙尚香",
                "关银屏",
                "唐伯虎",
                "吕玲绮",
                "曹丕",
                "马云騄",
                "李世民",
                "尔丹王子",
                "张星彩",
                "张辽",
                "乐进",
                "于禁",
                "张郃",
                "徐晃",
                "摸金校尉",
                "王异",
                "张春华",
                "赵匡胤",
                "祝融",
                "高长恭",
                "杨延昭",
                "霍去病",
                "陆逊",
                "铁木真",
                "朱元璋",
                "真吕布",
                "周武王",
                "司马懿",
                "秦始皇",
                "卫青",
                "鳌拜",
                "大禹",
                "花木兰",
                ""

        );
        for(int i = 1; i < heroname.size(); i++){
            heros.put(i, i + heroname.get(i));
        }
    }
}
