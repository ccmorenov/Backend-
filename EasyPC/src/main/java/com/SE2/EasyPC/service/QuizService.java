package com.SE2.EasyPC.service;

import java.util.ArrayList;
import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.dataAccess.repository.BuildRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.pojo.BuildPOJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for the beginner quiz
@Service
public class QuizService {
    
    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    BuildRepository buildRepository;
    @Autowired
    MotherboardService motherboardService;
    @Autowired
    CPUService cpuService;
    @Autowired
    GPUService gpuService;
    @Autowired
    RAMService ramService;
    @Autowired
    CoolingService coolingService;
    @Autowired
    SSDService ssdService;
    @Autowired
    HDDService hddService;
    @Autowired
    PowerSupplyService powerSupplyService;
    @Autowired
    CaseService caseService;

    public BuildPOJO getRecommendedBuild( List<String> answers ) {
        long budget = 0;
        if( answers.size() != 5 ){
            logger.error( "Incorrect number of quiz answers" );
            return null;
        }
        try{
            budget = Long.parseLong( answers.get(0) );
        }catch( Exception e ){
            logger.error( "Quiz answer for budget is not a number" );
            return null;
        }
        logger.trace( "Quiz answers received" );
        // concatenate all other answers into a single String
        Build basic = buildRepository.findById( (long)2 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 2));
        Build mid = buildRepository.findById( (long)3 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 3));;
        Build ultra = buildRepository.findById( (long)4 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 4));;

        Build gaming_1 = buildRepository.findById( (long)5 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 5));;
        Build gaming_cpu = buildRepository.findById( (long)6 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 6));;
        Build gaming_gpu = buildRepository.findById( (long)7 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 7));;

        Build design_1 = buildRepository.findById( (long)8 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 8));;
        Build design_disk = buildRepository.findById( (long)9 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 9));;
        Build design_performance = buildRepository.findById( (long)10 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 10));;

        Build work_gpu = buildRepository.findById( (long)11 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 11));;
        Build work_cpu = buildRepository.findById( (long)12 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 12));;
        Build work_disk = buildRepository.findById( (long)13 ).orElseThrow(() -> new ResourceNotFoundException("Build", "id", 13));;
        List <Build> options = new ArrayList <> ();
        options.add( basic );
        options.add( mid );
        options.add( ultra );

        if( answers.get(1).equals("1") ){
            options.add( gaming_1 );
            if( answers.get(2).equals("4") || answers.get(2).equals("3") || answers.get(3).equals("1")
            || answers.get(4).equals("3") ){
                options.add( gaming_gpu );
            }else{
                options.add( gaming_cpu );
            }
        }else if( answers.get(1).equals("2") ){
            options.add( design_1 );
            if( answers.get(3).equals("3") && !answers.get(2).equals("3") && !answers.get(4).equals("3") ){
                options.add( design_disk );
            }else options.add( design_performance );
        }else if( answers.get(1).equals("3") ){
            if( answers.get(2).equals("3") ){
                options.add( work_gpu );
            }else if( answers.get(4).equals("3") ){
                options.add( work_disk );
            }else{
                options.add( work_cpu );
            }
        }

        Build recommendation = null;
        int current_price = -1;
        for( Build build : options ){
            if( build.getPrice() > current_price && build.getPrice() <= budget ){
                recommendation = build;
                current_price = build.getPrice();
            }
        }
        return new BuildPOJO( recommendation );
    }

}
