package redis;

import com.cache.SpringBootCacheApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author lovely
 * on 2020/2/9
 */

@SpringBootTest(classes = SpringBootCacheApplication.class)
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void ping() {

    }

    @Test
    public void stringTest() {
        Integer result = stringRedisTemplate.opsForValue().append("msg", "new");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println("----------->" + msg);
    }
}
