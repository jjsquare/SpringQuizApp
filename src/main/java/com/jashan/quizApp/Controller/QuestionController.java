package com.jashan.quizApp.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.jashan.quizApp.Models.Question;
import com.jashan.quizApp.Services.QuestionService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("Question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("AllQuestions")
    public ResponseEntity<List<Question>> allQuestions() {
        return questionService.allQuestions();
    }
    
    @GetMapping("Topic/{topic}")
    public List<Question> getQuestionByTopic(@PathVariable String topic) {
        return questionService.GetQuestionByTopic(topic);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
        
    }
    
    
}
