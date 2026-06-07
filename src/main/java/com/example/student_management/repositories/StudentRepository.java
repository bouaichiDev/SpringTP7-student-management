package com.example.student_management.repositories;


import com.example.student_management.entity.Student;
import jakarta.websocket.OnClose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Objects;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Recherche d'un étudiant par son identifiant
    Student findById(int id);

    // Requête personnalisée pour compter les étudiants par année de naissance
    @Query("SELECT new com.example.student_management.dto.StudentCountByYear(YEAR(s.dateNaissance), COUNT(s)) FROM Student s GROUP BY YEAR(s.dateNaissance)")
    Collection<Objects[]> findNbrStudentByYear();
}