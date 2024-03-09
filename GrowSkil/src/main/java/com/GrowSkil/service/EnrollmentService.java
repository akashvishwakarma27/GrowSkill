package com.GrowSkil.service;

import com.GrowSkil.entity.Enrollment;
import com.GrowSkil.exception.EnrollmentNotFoundException;

public interface EnrollmentService {
    Enrollment enrollUser(int userId, int courseId) throws EnrollmentNotFoundException;
    Enrollment getEnrollmentById(int enrollmentId) throws EnrollmentNotFoundException;
    void cancelEnrollment(int enrollmentId) throws EnrollmentNotFoundException;
}
