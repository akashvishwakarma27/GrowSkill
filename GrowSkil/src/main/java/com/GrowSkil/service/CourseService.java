package com.GrowSkil.service;

import java.util.List;

import com.GrowSkil.entity.Course;
import com.GrowSkil.exception.CourseNotFoundException;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(int courseId) throws CourseNotFoundException;
    Course saveCourse(Course course);
    void deleteCourse(int courseId) throws CourseNotFoundException;
}
