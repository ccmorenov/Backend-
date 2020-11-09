package com.SE2.EasyPC.service.strategies;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Build;

public interface BuildChooser {
    
    // method that selects a Build according to a strategy
    Build chooseBuild ( List<Build> options );
}
