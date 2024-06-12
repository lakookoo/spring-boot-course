package com.ltp.gradesubmission.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.ltp.gradesubmission.entity.Grade;

import jakarta.transaction.Transactional;
import java.util.List;


public interface GradeRepository extends CrudRepository<Grade, Long> {
    Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @Transactional
    void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
    List<Grade> findByStudentId(Long studentId);
    List<Grade> findByCourseId(Long courseId);

}