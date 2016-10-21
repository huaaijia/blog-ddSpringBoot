package dd.config;

import dd.SpringBootC02Application;
import dd.repository.primary.StudentRepository;
import dd.repository.primary.entity.Student;
import dd.repository.secondary.TeacherRepository;
import dd.repository.secondary.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huaaijia on 2016/10/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootC02Application.class)
public class JpaDataSourceConfigTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testJpaMultipleDataSource() throws Exception {
        studentRepository.save(new Student("S1", 10));
        studentRepository.save(new Student("S2", 20));
        studentRepository.save(new Student("S3", 30));
        studentRepository.save(new Student("S4", 40));
        studentRepository.save(new Student("S5", 50));
        Assert.assertEquals(5, studentRepository.findAll().size());

        teacherRepository.save(new Teacher("T1", 10));
        teacherRepository.save(new Teacher("T2", 20));
        teacherRepository.save(new Teacher("T3", 30));
        Assert.assertEquals(3, teacherRepository.findAll().size());
    }

}