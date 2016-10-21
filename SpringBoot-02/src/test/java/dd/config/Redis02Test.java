package dd.config;

import dd.SpringBootC02Application;
import dd.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huaaijia on 2016/10/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootC02Application.class)
public class Redis02Test {

    @Autowired
    private RedisTemplate<String, Book> redisTemplate;

    @Test
    public void test() throws Exception {
        // 保存对象
        Book book = new Book("aaa", 20);
        redisTemplate.opsForValue().set(book.getBookName(), book);
        book = new Book("bbb", 30);
        redisTemplate.opsForValue().set(book.getBookName(), book);
        book = new Book("ccc", 40);
        redisTemplate.opsForValue().set(book.getBookName(), book);
        Assert.assertEquals(20, redisTemplate.opsForValue().get("aaa").getCount().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("bbb").getCount().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("ccc").getCount().longValue());
    }
}