package dd.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import dd.repository.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Table;

/**
 * Created by huaaijia on 2016/10/20.
 */
@CacheConfig(cacheNames = "users")
public interface StudentRepository extends JpaRepository<Student, Long>{

    @Cacheable
    Student findByName(String name);

    Student findByNameAndAge(String name, Integer age);

    @Query("from user u where u.name=:name")
    Student findStudent(@Param("name") String name);
}
