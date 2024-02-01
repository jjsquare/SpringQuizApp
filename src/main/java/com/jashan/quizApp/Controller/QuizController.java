package com.jashan.quizApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.jashan.quizApp.Models.QuestionWapper;
import com.jashan.quizApp.Models.Resopnse;
import com.jashan.quizApp.Services.QuizService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String topic, @RequestParam String title, @RequestParam int numberOfQuestions) {
        return quizService.createQuiz(topic,title,numberOfQuestions);
    }
    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionWapper>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuizQuestions(id);
    }
    
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Resopnse> resopnse)  {
        
        
        return quizService.calculateResult(id, resopnse);
    }
    
    
}
