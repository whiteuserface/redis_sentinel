package Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void addKey(String key, String value){
        try{
            redisTemplate.opsForValue().set(key,value);
        } catch(Exception e){
            log.error("### Redis Set Key Error !!! ::: {}", e.getMessage());
        }
    }

    public String getValue(String key){
        String value = "";
        try{
            if(redisTemplate.hasKey(key)) {
                value = redisTemplate.opsForValue().get(key);
            }
        } catch (Exception e){
            log.error("### Redis Set Key Error !!! ::: {}", e.getMessage());
        }
        return value;
        }
}
