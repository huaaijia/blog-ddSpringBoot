package dd.config;

import dd.domain.Book;
import dd.utils.RedisObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by huaaijia on 2016/10/21.
 */
@Configuration
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setPassword(redisProperties.getPassword());
        jedisConnectionFactory.setPort(redisProperties.getPort());
        return jedisConnectionFactory;
    }

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public RedisTemplate<String, Book> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Book> template = new RedisTemplate<String, Book>();
        template.setConnectionFactory(factory);
//        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
