package com.GrowSkil.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GrowSkil.entity.Instructor;
import com.GrowSkil.exception.InstructorNotFoundException;
import com.GrowSkil.service.InstructorService;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable int instructorId) throws InstructorNotFoundException {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorService.saveInstructor(instructor);
        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable int instructorId) throws InstructorNotFoundException {
        instructorService.deleteInstructor(instructorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
