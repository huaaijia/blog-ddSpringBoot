package dd.repository.secondary;

import dd.repository.secondary.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by huaaijia on 2016/10/20.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

    Teacher findByName(String name);

    Teacher findByNameAndAge(String name, Integer age);

    @Query("from teacher u where u.name=:name")
    Teacher findTeacher(@Param("name") String name);
}
