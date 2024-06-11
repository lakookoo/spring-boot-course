package com.ltp.gradesubmission.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    Grade findByStudentId(Long studentId);
    Grade findByStudentIdAndCourseId(Long studentId, Long courseId);
}