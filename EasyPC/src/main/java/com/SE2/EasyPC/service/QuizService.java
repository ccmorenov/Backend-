package com.SE2.EasyPC.service;

import java.util.ArrayList;
import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.dataAccess.repository.BuildRepository;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic layer for the beginner quiz
@Service
public class QuizService {
    
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

    public Build getRecommendedBuild( List<String> answers ) {
        long budget = 0;
        if( answers.size() != 5 ){
            Log.createLog(4, "Incorrect number of quiz answers");
            return null;
        }
        try{
            budget = Long.parseLong( answers.get(0) );
        }catch( Exception e ){
            Log.createLog(4, "Price is not a number");
            return null;
        }
        // concatenate all other answers into a single String
        Build basic = createBuild( 1,1,1,1,1,1,1,1,1 );
        Build mid = createBuild( 3,3,3,3,3,3,3,3,3 );
        Build ultra = createBuild( 4,4,4,4,4,4,3,4,4 );
        System.out.println("basic " + basic.getPrice());
        System.out.println("mid " + mid.getPrice());
        System.out.println("ultra " + ultra.getPrice());

        Build gaming_1 = createBuild( 2,2,2,2,2,2,2,2,2 );
        Build gaming_cpu = createBuild( 3,3,2,2,2,2,2,2,2 );
        Build gaming_gpu = createBuild( 2,2,3,3,3,3,1,3,3 );
        System.out.println("gaming_1 " + gaming_1.getPrice());
        System.out.println("gaming_cpu " + gaming_cpu.getPrice());
        System.out.println("gaming_gpu " + gaming_gpu.getPrice());

        Build design_1 = createBuild( 2,3,1,2,1,3,2,2,2 );
        Build design_disk = createBuild( 3,4,1,3,2,3,3,3,2 );
        Build design_performance = createBuild( 4,4,2,4,2,4,3,3,2 );
        System.out.println("design_1 " + design_1.getPrice());
        System.out.println("design_disk " + design_disk.getPrice());
        System.out.println("design_performance " + design_performance.getPrice());

        Build work_gpu = createBuild( 3,1,3,3,2,3,2,2,2 );
        Build work_cpu = createBuild( 2,3,1,2,2,2,1,1,1 );
        Build work_disk = createBuild( 2,2,1,2,1,2,3,1,1 );
        System.out.println("work_gpu " + work_gpu.getPrice());
        System.out.println("work_cpu " + work_cpu.getPrice());
        System.out.println("work_disk " + work_disk.getPrice());

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
        return recommendation;
    }


    private Build createBuild( long id_motherboard , long id_cpu , long id_gpu , long id_ram ,
                                long id_cooling , long id_ssd , long id_hdd , long id_powerSupply ,
                                long id_case ){
        
        return new Build( motherboardService.getMotherboardById(id_motherboard) , cpuService.getCPUById(id_cpu),
                        gpuService.getGPUById(id_gpu) , ramService.getRAMById(id_ram),
                        coolingService.getCoolingById(id_cooling) , ssdService.getSSDById(id_ssd),
                        hddService.getHDDById(id_hdd) , powerSupplyService.getPowerSupplyById(id_powerSupply),
                        caseService.getCaseById(id_case) );
    }

}
