package com.zyfera.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zyfera.assignment.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
