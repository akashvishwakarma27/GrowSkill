package com.GrowSkil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrowSkil.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
	 	List<Enrollment> findByUserId(int userId);
	    
	    List<Enrollment> findByCourseId(int courseId);
}
