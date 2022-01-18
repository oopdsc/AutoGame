package game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostUtils {

    Logger logger = LoggerFactory.getLogger(Player.class);

    RestTemplate restTemplate = new RestTemplate();

    public void doPost(){


        String url = "http://sglyqw.commpad.cn/servers/s7.php?sevid=7&ver=V1.0.351&uid=&token=&platform=qiangwanzdhgios&lang=zh-cn";
//                     "http://sglyqw.commpad.cn/servers/s7.php?sevid=7&ver=V1.0.351&uid=&token=&platform=qiangwanzdhgios&lang=zh-cn"
//        String body = "{\"rsn\":\"9mrszjncbts\",\"login\":{\"loginAccount\":{\"platform\":\"qiangwanzdhgios\",\"openid\":\"2953184_ios\",\"openkey\":\"9acd032355d503bc0cd5beb4941c44a6\"}}}";

        String body = "{\"rsn\":\"9mrszjncbts\",\"login\":{\"loginAccount\":{\"platform\":\"qiangwanzdhgios\"," +
                "\"openid\":\"2587430_ios\"," +
                "\"openkey\":\"8e63ad62fb17920353f555247a40c160\"}}}";

        HttpHeaders headers = getHttpHeaders();

        HttpEntity entity = new HttpEntity(body, headers);

        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        body = response.getBody();

        logger.info(response.getBody());
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "appstoreQWNEW/1.0.2.1 CFNetwork/1197 Darwin/20.0.0");
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }

    public static void main(String [] args){
        new PostUtils().doPost();
    }
}
