package com.SE2.EasyPC.service;

import java.util.List;
import java.util.Set;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.dataAccess.model.PowerSupply;
import com.SE2.EasyPC.dataAccess.repository.BuildRepository;
import com.SE2.EasyPC.dataAccess.repository.PowerSupplyRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic layer for the beginner quiz
@Service
public class QuizService {
    
    @Autowired
    BuildRepository buildRepository;

    public Build getRecommendedBuild( List<String> answers ) {
        if( answers.size() != 5 ){
            Log.createLog(4, "Incorrect number of quiz answers");
            return null;
        }
        try{
            Long budget = Long.parseLong( answers.get(0) );
        }catch( Exception e ){
            Log.createLog(4, "Price is not a number");
            return null;
        }
        // concatenate all other answers into a single String
        String all_answers = answers.get(1) + answers.get(2) + answers.get(3) + answers.get(4) + answers.get(5);
        //
        List <Build> prebuilds;
        Set <String> answersForBuild;
        return null;
    }

}
