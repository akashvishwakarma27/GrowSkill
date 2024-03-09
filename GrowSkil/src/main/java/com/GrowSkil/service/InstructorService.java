package com.GrowSkil.service;

import java.util.List;

import com.GrowSkil.entity.Instructor;
import com.GrowSkil.exception.InstructorNotFoundException;

public interface InstructorService {
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(int instructorId) throws InstructorNotFoundException;
    Instructor saveInstructor(Instructor instructor);
    void deleteInstructor(int instructorId) throws InstructorNotFoundException;
}
