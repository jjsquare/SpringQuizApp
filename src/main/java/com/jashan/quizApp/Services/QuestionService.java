package com.jashan.quizApp.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jashan.quizApp.Doa.QuestionDoa;
import com.jashan.quizApp.Models.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionDoa questionDoa;

    public ResponseEntity<List<Question>> allQuestions() {
        try{
            return new ResponseEntity<>(questionDoa.findAll(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public List<Question> GetQuestionByTopic(String topic) {
        
        return questionDoa.findByTopic(topic);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        if(question != null){
         questionDoa.save(question);
         return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("not the correct format",HttpStatus.BAD_REQUEST);
    }

    
    
}
