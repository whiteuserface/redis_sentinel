package Test;

import Vo.RedisInfo;
import com.example.redis_sentinel.Redis_sentinelApplication;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = Redis_sentinelApplication.class)
public class RedisSentinelApplicationTest {

    @Test
    void test(){
        while(true){
            try{
                //1초마다 호출
                Thread.sleep(1000);
                RedisInfo redisInfo = new RedisInfo();
                redisInfo.setKey("key");
                redisInfo.setValue("value");
                HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/get")
                        .header("Context-Type","application/json")
                        .body(redisInfo)
                        .asJson();

                log.info("### 테스트 결과 => status : {} | response : {}", response.getStatus() , response.getBody().getObject());


            } catch(Exception e){
                log.error("### 테스트 에러 발생 => {}", e.getMessage());
            }
        }
    }
}
