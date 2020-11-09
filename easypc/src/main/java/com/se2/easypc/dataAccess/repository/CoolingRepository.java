package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.Cooling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CoolingRepository inherits from JpaRepository for communication with database
@Repository
public interface CoolingRepository extends JpaRepository<Cooling, Long> {
    
}
