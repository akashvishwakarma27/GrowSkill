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

import com.GrowSkil.entity.TrainingClass;
import com.GrowSkil.service.TrainingClassService;

@RestController
@RequestMapping("/classes")
public class TrainingClassController {

    @Autowired
    private TrainingClassService classService;

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<TrainingClass>> getClassesByCourseId(@PathVariable("courseId") int courseId) {
        List<TrainingClass> classes = classService.getClassesByCourseId(courseId);
        return ResponseEntity.ok().body(classes);
    }

    @GetMapping("/{classId}")
    public ResponseEntity<TrainingClass> getClassById(@PathVariable("classId") int classId) {
        TrainingClass trainingClass = classService.getClassById(classId);
		return ResponseEntity.ok().body(trainingClass);
    }

    @PostMapping("/save")
    public ResponseEntity<TrainingClass> saveClass(@RequestBody TrainingClass classObj) {
        TrainingClass savedClass = classService.saveClass(classObj);
        return ResponseEntity.ok().body(savedClass);
    }

    @DeleteMapping("/{classId}")
    public ResponseEntity<String> deleteClass(@PathVariable("classId") int classId) {
        classService.deleteClass(classId);
		return ResponseEntity.ok().body("Class deleted successfully");
    }
}
