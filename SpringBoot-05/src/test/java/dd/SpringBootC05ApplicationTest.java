package dd;

import dd.domain.User;
import dd.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by huaaijia on 2016/10/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringBootC05ApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        userMapper.insert("MyBatis", 20);
        User u = userMapper.findByName("MyBatis");
        Assert.assertEquals(20, u.getAge().intValue());
    }

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        // insert一条数据，并select出来验证
        userMapper.insert("MyBatis2", 20);
        User u = userMapper.findByName("MyBatis2");
        Assert.assertEquals(20, u.getAge().intValue());
        // update一条数据，并select出来验证
        u.setAge(30);
        userMapper.update(u);
        u = userMapper.findByName("MyBatis2");
        Assert.assertEquals(30, u.getAge().intValue());
        // 删除这条数据，并select验证
        userMapper.delete(u.getUserId());
        u = userMapper.findByName("MyBatis2");
        Assert.assertEquals(null, u);
    }

    @Test
    @Rollback
    public void testUserMapperList() throws Exception {
        List<User> userList = userMapper.findAll();
        for(User user : userList) {
            Assert.assertEquals(null, user.getUserId());
            Assert.assertNotEquals(null, user.getName());
        }
    }

}