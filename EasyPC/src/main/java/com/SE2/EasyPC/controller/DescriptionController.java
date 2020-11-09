package com.SE2.EasyPC.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.SE2.EasyPC.dataAccess.model.Description;
import com.SE2.EasyPC.service.DescriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class DescriptionController {
    
    private static final Logger logger = LogManager.getLogger();

    //declares corresponding service
    @Autowired
    DescriptionService descriptionService;

    //get http request for all descriptions
    @GetMapping("/descriptions")
    public List<Description> getAllDescriptions( HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return descriptionService.getAllDescriptions();
    }

    //get http request for Description by specific part name
    @GetMapping("/description/{name}")
    public Description getUsersById(@PathVariable(value = "name") String partName, HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return descriptionService.findByPartName(partName);
    }

}
