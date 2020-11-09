package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CaseRepository inherits from JpaRepository for communication with database
@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
    
}