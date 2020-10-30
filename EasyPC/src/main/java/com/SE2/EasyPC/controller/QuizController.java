package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class QuizController {

     //declares corresponding service
     @Autowired
     QuizService quizService;

    //Get http request for build
    @PostMapping("/quiz-beginner")
    //request body with object to post
    public Build getRecommendedBuild(@Valid @RequestBody List<String> answers,  HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return quizService.getRecommendedBuild(answers);
    }
    //Get http request for build price
    @PostMapping("/quiz-beginner-price") 
    public int getRecommendedBuildPrice(@Valid @RequestBody List<String> answers,  HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        Build recommended= quizService.getRecommendedBuild(answers);
        return recommended.getPrice();
    }

}
