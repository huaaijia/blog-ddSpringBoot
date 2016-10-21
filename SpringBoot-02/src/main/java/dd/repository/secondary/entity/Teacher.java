package dd.repository.secondary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by huaaijia on 2016/10/20.
 *
 * 配合SpringBoot jpa实现
 */
@Entity(name="teacher")
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name="teacher_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;

    private Teacher(){}

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Teacher(Long id, String name, Integer age) {
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
