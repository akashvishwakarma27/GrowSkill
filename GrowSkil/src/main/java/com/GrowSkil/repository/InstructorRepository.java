package com.GrowSkil.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrowSkil.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    Instructor findByEmail(String email);
}