package dd.repository.primary;

import dd.repository.primary.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by huaaijia on 2016/10/20.
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

    Student findByName(String name);

    Student findByNameAndAge(String name, Integer age);

    @Query("from student u where u.name=:name")
    Student findStudent(@Param("name") String name);
}
