package com.centum.codeWithSharath.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
@Entity

@Table(name="STUDENT_TABLE")


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public int age;
    public String department;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Student(){

}
    public Student(Long id, String name, int age, String department, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", courses=" + courses +
                '}';
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TABLE",
                joinColumns =  {
            @JoinColumn(name = "student_id", referencedColumnName = "id")},
            inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")}
    )
    @JsonBackReference
    private Set<Course> courses;


}
