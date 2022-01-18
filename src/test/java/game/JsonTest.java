package game;

import com.jayway.jsonpath.JsonPath;
import game.active.DefaultGameRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static game.service.GameRunner.getRsn;

public class JsonTest {

    /*


     */
    @Test
    public void test(){
        String x = "{\"status\":0,\"msg\":\"\\u767b\\u5f55\\u6210\\u529f\",\"data\":{\"uid\":\"11331603\",\"token\":1635936372,\"email\":\"\",\"bindTel\":false}}";
        int uid = JsonPath.parse(x).read("$.status");
        System.out.println(uid);

        String x2 = "{\n" +
                "  \"s\": 1,\n" +
                "  \"a\": {\"item\": {\n" +
                "      \"itemList\": [\n" +
                "        {\n" +
                "          \"id\": 11,\n" +
                "          \"count\": 11935\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 12,\n" +
                "          \"count\": 4168\n" +
                "        }]}}}";
        List<Integer> count12 = JsonPath.parse(x2).read("$.a.item.itemList[?(@.id==12)].count");
        count12.stream().forEach(System.out::println);
    }

    @Test
    public void format(){
        String body = String.format("{\"huodong\":{\"hd282buy\":{\"id\":1}},\"rsn\":\"%s\"}", getRsn());
        System.out.println(body);
    }

    @Test
    public void yamen(){
        String x = "{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":10,\"id\":8}},\"rsn\":\"%s\"}|{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":10,\"id\":8}},\"rsn\":\"%s\"}|{\"courtyard\":{\"buyShop\":{\"type\":1,\"count\":10,\"id\":8}},\"rsn\":\"%s\"}";
        System.out.println(x.split("\\|").length);
    }
}
