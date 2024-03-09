package com.GrowSkil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GrowSkil.entity.Enrollment;
import com.GrowSkil.exception.EnrollmentNotFoundException;
import com.GrowSkil.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public ResponseEntity<Enrollment> enrollUser(@RequestParam("userId") int userId, @RequestParam("courseId") int courseId) {
        try {
            Enrollment enrollment = enrollmentService.enrollUser(userId, courseId);
            return ResponseEntity.ok().body(enrollment);
        } catch (EnrollmentNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{enrollmentId}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable("enrollmentId") int enrollmentId) {
        try {
            Enrollment enrollment = enrollmentService.getEnrollmentById(enrollmentId);
            return ResponseEntity.ok().body(enrollment);
        } catch (EnrollmentNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<String> cancelEnrollment(@PathVariable("enrollmentId") int enrollmentId) {
        try {
            enrollmentService.cancelEnrollment(enrollmentId);
            return ResponseEntity.ok().body("Enrollment canceled successfully");
        } catch (EnrollmentNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment not found");
        }
    }
}
