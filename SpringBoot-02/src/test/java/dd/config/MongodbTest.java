package dd.config;

import dd.SpringBootC02Application;
import dd.mongoRepository.CategoryRepository;
import dd.mongoRepository.entity.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huaaijia on 2016/10/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootC02Application.class)
public class MongodbTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Before
    public void setUp() {
        categoryRepository.deleteAll();
    }
    @Test
    public void test() throws Exception {
        // 创建三个User，并验证User总数
        categoryRepository.save(new Category(1L, "didi", 30));
        categoryRepository.save(new Category(2L, "mama", 40));
        categoryRepository.save(new Category(3L, "kaka", 50));
        Assert.assertEquals(3, categoryRepository.findAll().size());
        // 删除一个User，再验证User总数
        Category u = categoryRepository.findOne(1L);
        categoryRepository.delete(u);
        Assert.assertEquals(2, categoryRepository.findAll().size());
        // 删除一个User，再验证User总数
        u = categoryRepository.findByCategoryName("mama");
        categoryRepository.delete(u);
        Assert.assertEquals(1, categoryRepository.findAll().size());
    }
}