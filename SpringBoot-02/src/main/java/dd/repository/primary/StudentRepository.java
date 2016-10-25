package dd.repository.primary;

import dd.repository.primary.entity.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by huaaijia on 2016/10/20.
 */
@CacheConfig(cacheNames = "students")
public interface StudentRepository extends JpaRepository<Student, Long>{

    @Cacheable
    Student findByName(String name);

    Student findByNameAndAge(String name, Integer age);

    @Query("from student u where u.name=:name")
    Student findStudent(@Param("name") String name);

    @CachePut(key = "#p0.name")
    Student save(Student user);
}
