package dd.config;

import dd.repository.primary.StudentRepository;
import dd.repository.primary.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huaaijia on 2016/10/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisCache {


    @Autowired
    private StudentRepository studentRepository;

    @Before
    public void before() {
        studentRepository.save(new Student("AAAAA", 10));
    }

    @Test
    public void test() throws Exception {
        Student u1 = studentRepository.findByName("AAAAA");
        System.out.println("第一次查询：" + u1.getAge());
        Student u2 = studentRepository.findByName("AAAAA");
        System.out.println("第二次查询：" + u2.getAge());

        /**
         * Hibernate: select student0_.student_id as student_1_0_, student0_.age as age2_0_, student0_.name as name3_0_ from student student0_ where student0_.name=?
         第一次查询：10
         第二次查询：10
         */

        /**
         * 127.0.0.1:6379> config set requirepass ******
         (error) NOAUTH Authentication required.
         127.0.0.1:6379>
         127.0.0.1:6379>
         127.0.0.1:6379>
         127.0.0.1:6379> keys *
         (error) NOAUTH Authentication required.
         127.0.0.1:6379> auth ******
         OK
         127.0.0.1:6379> config set requirepass
         (error) ERR Wrong number of arguments for CONFIG set
         127.0.0.1:6379> keys *
         1) "bbb"
         2) "ccc"
         3) "aaa"
         127.0.0.1:6379> keys *
         1) "students:\xac\xed\x00\x05t\x00\x05AAAAA"
         2) "bbb"
         3) "ccc"
         4) "aaa"
         */
    }

    @Autowired
    private CacheManager cacheManager;
}
