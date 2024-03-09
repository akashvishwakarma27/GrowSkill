package com.GrowSkil.service.Implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GrowSkil.entity.TrainingClass;
import com.GrowSkil.exception.ClassNotFoundException;
import com.GrowSkil.repository.TrainingClassRepository;
import com.GrowSkil.service.TrainingClassService;

@Service
public class TrainingClassServiceImpl implements TrainingClassService {

    @Autowired
    private TrainingClassRepository trainingClassRepository;

    @Override
    public List<TrainingClass> getClassesByCourseId(int courseId) {
        return trainingClassRepository.findByCourseId(courseId);
    }

    @Override
    public TrainingClass getClassById(int classId) throws ClassNotFoundException {
        return trainingClassRepository.findById(classId)
                .orElseThrow(() -> new ClassNotFoundException("Class with ID " + classId + " not found"));
    }

    @Override
    public TrainingClass saveClass(TrainingClass classObj) {
        return trainingClassRepository.save(classObj);
    }

    @Override
    public void deleteClass(int classId) throws ClassNotFoundException {
        TrainingClass classToDelete = trainingClassRepository.findById(classId)
                .orElseThrow(() -> new ClassNotFoundException("Class with ID " + classId + " not found"));
        trainingClassRepository.delete(classToDelete);
    }
}
