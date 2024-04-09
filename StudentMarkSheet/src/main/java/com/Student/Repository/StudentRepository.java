package com.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Entityy.MarkSheet;

public interface StudentRepository extends JpaRepository<MarkSheet, Integer> {

}
