package com.SE2.EasyPC.service.strategies;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Build;

public class MostExpensiveBuild implements BuildChooser {
    
    @Override
    public Build chooseBuild ( List<Build> options ){
        Build selected = null;
        for( Build option : options ){
            if( selected == null || selected.getPrice() < option.getPrice() ) selected = option;
        }
        return selected;
    }
}
