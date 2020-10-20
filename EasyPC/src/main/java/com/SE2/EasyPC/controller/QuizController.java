package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.service.QuizService;
import com.SE2.EasyPC.logging.Log;

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
    @GetMapping("/quiz-beginner")
    //request body with object to post
    public Build getRecommendedBuild(@Valid @RequestBody List<String> answers,  HttpServletRequest request ) {
        //append to log
        Log.createLog(0, "getRecommendedBuild query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return quizService.getRecommendedBuild(answers);
    }

}
