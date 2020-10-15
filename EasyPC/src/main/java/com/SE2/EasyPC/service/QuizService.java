package com.SE2.EasyPC.service;

import java.util.List;
import java.util.Set;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.dataAccess.model.Motherboard;
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
        if( answers.size() != 5 ){
            Log.createLog(4, "Incorrect number of quiz answers");
            return null;
        }
        try{
            long budget = Long.parseLong( answers.get(0) );
        }catch( Exception e ){
            Log.createLog(4, "Price is not a number");
            return null;
        }
        // concatenate all other answers into a single String
        String all_answers = answers.get(1) + answers.get(2) + answers.get(3) + answers.get(4);

        Build basic = createBuild( 1,1,1,1,1,1,1,1,1 );
        Build mid = createBuild( 3,3,3,3,3,3,3,3,3 );
        Build ultra = createBuild( 4,4,4,4,4,4,3,4,4 );

        Build gaming_1 = createBuild( 2,2,2,2,2,2,2,2,2 );
        Build gaming_cpu = createBuild( 3,3,2,2,2,2,2,2,2 );
        Build gaming_gpu = createBuild( 2,2,3,3,3,3,1,3,3 );

        Build design_1 = createBuild( 2,3,1,2,1,3,2,2,2 );
        Build design_disk = createBuild( 3,4,1,3,2,3,3,3,2 );
        Build design_performance = createBuild( 4,4,2,4,2,4,3,3,2 );

        Build work_gpu = createBuild( 3,1,3,3,2,3,2,2,2 );
        Build work_cpu = createBuild( 2,3,1,2,2,2,1,1,1 );
        Build work_disk = createBuild( 2,2,1,2,1,2,3,1,1 );

        return basic;
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
