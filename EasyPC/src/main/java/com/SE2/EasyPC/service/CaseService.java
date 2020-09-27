package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Case;
import com.SE2.EasyPC.dataAccess.repository.CaseRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {

    @Autowired
    CaseRepository caseRepository;

    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    public Case getCaseById( Long id ) {
        return caseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Case", "id", id));
    }

    public Case createCase(Case caseObj) {
        return caseRepository.save(caseObj);
    }

    public void deleteCase( Long id ) {
        Case caseObj = caseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Case", "id", id));
        caseRepository.delete(caseObj);
    }

    
}
