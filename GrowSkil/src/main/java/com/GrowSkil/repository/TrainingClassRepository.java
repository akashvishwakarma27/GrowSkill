package com.GrowSkil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrowSkil.entity.TrainingClass;

@Repository
public interface TrainingClassRepository extends JpaRepository<TrainingClass, Integer> {

	List<TrainingClass> findByCourseId(int courseId);
}