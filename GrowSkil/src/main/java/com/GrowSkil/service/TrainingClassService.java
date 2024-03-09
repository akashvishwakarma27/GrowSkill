package com.GrowSkil.service;

import java.util.List;

import com.GrowSkil.entity.TrainingClass;
import com.GrowSkil.exception.ClassNotFoundException;

public interface TrainingClassService {
    List<TrainingClass> getClassesByCourseId(int courseId);
    TrainingClass getClassById(int classId) throws ClassNotFoundException;
    TrainingClass saveClass(TrainingClass classObj);
    void deleteClass(int classId) throws ClassNotFoundException;
}
