package dd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dd.repository.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Table;

/**
 * Created by huaaijia on 2016/10/20.
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

    Student findByName(String name);

    Student findByNameAndAge(String name, Integer age);

    @Query("from user u where u.name=:name")
    Student findStudent(@Param("name") String name);
}
