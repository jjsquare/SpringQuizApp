package com.jashan.quizApp.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jashan.quizApp.Doa.QuestionDoa;
import com.jashan.quizApp.Doa.QuizDoa;
import com.jashan.quizApp.Models.Question;
import com.jashan.quizApp.Models.QuestionWapper;
import com.jashan.quizApp.Models.QuizTable;
import com.jashan.quizApp.Models.Resopnse;

@Service
public class QuizService {

    @Autowired
    QuizDoa quizDoa;
    @Autowired
    QuestionDoa questionDoa;

    
    public ResponseEntity<String> createQuiz(String topic, String title, int numberOfQuestions) {
        List<Question> questions = questionDoa.findRandomQuestionByTopic(topic, numberOfQuestions);
        QuizTable quiz = new QuizTable();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDoa.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWapper>> getQuizQuestions(int id) {

        Optional<QuizTable> quiz = quizDoa.findById(id);
        List<Question> questionFromDb = quiz.get().getQuestions();
        List<QuestionWapper> questionForUser = new ArrayList<>();
        for(Question q :questionFromDb ){
            QuestionWapper temp = new QuestionWapper(
                q.id, q.questionTitle, q.option1, q.option2, q.option3, q.option4);
                questionForUser.add(temp);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
        
    }


    public ResponseEntity<Integer> calculateResult(int id, List<Resopnse> resopnses) {
        QuizTable quiz = quizDoa.findById(id).get();
        List<Question> question = quiz.getQuestions();
        int right =0;
        int i=0;
        for(Resopnse resopnse : resopnses){
            if(resopnse.getResponse().equals(question.get(i).getAns())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
    
}
