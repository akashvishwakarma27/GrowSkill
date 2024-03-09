package com.GrowSkil.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes")
public class TrainingClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;
    
    @JsonIgnore
    @ManyToOne
    private Course course;
    
    private Date date;
    private String time;
    private String topic;
    private String zoomLink;
}
