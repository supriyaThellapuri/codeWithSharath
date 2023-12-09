package com.centum.codeWithSharath.repository;

import com.centum.codeWithSharath.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByFeeLessThan(double price);

//    @Query("SELECT COUNT(s) FROM Course c JOIN c.enrolledStudents s WHERE c.name = :title")
//    int countEnrolledStudentsByCourseName(@Param("courseName") String title);
}
