package com.jashan.quizApp.Doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jashan.quizApp.Models.Question;
import java.util.List;


@Repository
public interface QuestionDoa extends JpaRepository<Question,Integer>{

    List<Question> findByTopic(String topic);

    @Query(value ="SELECT * FROM question q WHERE q.topic =:topic ORDER BY RAND() LIMIT :numberOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionByTopic(String topic, int numberOfQuestions);
    
}
