package com.dev.cruddemo.dao;

import com.dev.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastname(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
