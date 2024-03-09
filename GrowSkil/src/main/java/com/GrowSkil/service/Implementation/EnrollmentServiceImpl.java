package com.GrowSkil.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GrowSkil.entity.Course;
import com.GrowSkil.entity.Enrollment;
import com.GrowSkil.entity.User;
import com.GrowSkil.exception.EnrollmentNotFoundException;
import com.GrowSkil.repository.CourseRepository;
import com.GrowSkil.repository.EnrollmentRepository;
import com.GrowSkil.repository.UserRepository;
import com.GrowSkil.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Enrollment enrollUser(int userId, int courseId) throws EnrollmentNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EnrollmentNotFoundException("User with ID " + userId + " not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EnrollmentNotFoundException("Course with ID " + courseId + " not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment getEnrollmentById(int enrollmentId) throws EnrollmentNotFoundException {
        return enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment with ID " + enrollmentId + " not found"));
    }

    @Override
    public void cancelEnrollment(int enrollmentId) throws EnrollmentNotFoundException {
        Enrollment enrollmentToDelete = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment with ID " + enrollmentId + " not found"));
        enrollmentRepository.delete(enrollmentToDelete);
    }
}

