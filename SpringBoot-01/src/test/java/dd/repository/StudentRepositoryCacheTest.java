package dd.repository;

import dd.repository.entity.Student;
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
public class StudentRepositoryCacheTest {

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
         * Hibernate: select student0_.user_id as user_id1_0_, student0_.age as age2_0_, student0_.name as name3_0_ from user student0_ where student0_.name=?
         * 第一次查询：10
         * Hibernate: select student0_.user_id as user_id1_0_, student0_.age as age2_0_, student0_.name as name3_0_ from user student0_ where student0_.name=?
         * 第二次查询：10
         */

        /**
         * 加入cache
         * Hibernate: select student0_.user_id as user_id1_0_, student0_.age as age2_0_, student0_.name as name3_0_ from user student0_ where student0_.name=?
         * 第一次查询：10
         * 第二次查询：10
         */
    }

    @Autowired
    private CacheManager cacheManager;

}
