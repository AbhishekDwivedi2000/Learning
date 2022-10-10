package com.example.Learning.Repository;


import com.example.Learning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {




}

