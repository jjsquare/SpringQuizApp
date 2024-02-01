package com.jashan.quizApp.Doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jashan.quizApp.Models.QuizTable;

@Repository
public interface QuizDoa extends JpaRepository<QuizTable,Integer> {

}
