package com.jashan.quizApp.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionWapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String questionTitle;
    public String option1;
    public String option2;
    public String option3;
    public String option4;

    public QuestionWapper(int id,String questionTitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
    }
}
