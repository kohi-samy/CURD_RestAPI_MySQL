package com.kvks.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kvks.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
}
