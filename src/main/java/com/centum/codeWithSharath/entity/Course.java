package com.centum.codeWithSharath.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name="COURSE_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    @Id
   @GeneratedValue
    public Long id;
    public String title;
    public String abbrevation;
    public int modules;
    public double fee;
    @ManyToMany(mappedBy = "courses" , fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Student> students;

}
