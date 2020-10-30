package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Case;
import com.SE2.EasyPC.dataAccess.repository.CaseRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Case, recives calls from CaseController and calls CaseRepository
@Service
public class CaseService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    CaseRepository caseRepository;

    public List<Case> getAllCases() { // returns a list with all Cases in the database
        try{
            return caseRepository.findAll();
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public Case getCaseById( Long id ) { // returns the Case with the requested ID or an exception if it does not exist
        try{
            return caseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Case", "id", id));
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public Case createCase(Case caseObj) { // creates a new Case in the database
        try{
            return caseRepository.save(caseObj);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public void deleteCase( Long id ) { // deletes the Case with the requested ID or an exception if it does not exist
        try{
            Case caseObj = caseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Case", "id", id));
            caseRepository.delete(caseObj);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    
}
