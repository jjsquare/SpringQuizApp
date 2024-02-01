package com.jashan.quizApp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String questionTitle;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String ans;
    public String difficultyLevel;
    public String topic;
    
}
