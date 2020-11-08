package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.pojo.BuildPOJO;
import com.SE2.EasyPC.service.QuizService;
import com.SE2.EasyPC.service.strategies.MostExpensiveBuild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class QuizController {

    private static final Logger logger = LogManager.getLogger();

     //declares corresponding service
     @Autowired
     QuizService quizService;

    //Get http request for build
    @PostMapping("/quiz-beginner")
    //request body with object to post
    public BuildPOJO getRecommendedBuild(@Valid @RequestBody List<String> answers,  HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        quizService.setStrategy( new MostExpensiveBuild() );
        return quizService.getRecommendedBuild(answers);
    }
    //Get http request for build price
    @PostMapping("/quiz-beginner-price") 
    public int getRecommendedBuildPrice(@Valid @RequestBody List<String> answers,  HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        quizService.setStrategy( new MostExpensiveBuild() );
        Build recommended = quizService.getRecommendedBuild(answers).toBuild();
        return recommended.getPrice();
    }

}
