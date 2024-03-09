package com.GrowSkil.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GrowSkil.entity.Instructor;
import com.GrowSkil.exception.InstructorNotFoundException;
import com.GrowSkil.repository.InstructorRepository;
import com.GrowSkil.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(int instructorId) throws InstructorNotFoundException {
        return instructorRepository.findById(instructorId)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor with ID " + instructorId + " not found"));
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(int instructorId) throws InstructorNotFoundException {
        Instructor instructorToDelete = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor with ID " + instructorId + " not found"));
        instructorRepository.delete(instructorToDelete);
    }
}
