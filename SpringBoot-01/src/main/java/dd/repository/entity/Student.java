package dd.repository.entity;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;

/**
 * Created by huaaijia on 2016/10/20.
 *
 * 配合SpringBoot jpa实现
 */
@Entity(name="user")
public class Student {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long id;

    @Column(nullable = true, length = 5)
    private String name;

    @Column(nullable = false)
    private Integer age;

    private Student(){}

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
