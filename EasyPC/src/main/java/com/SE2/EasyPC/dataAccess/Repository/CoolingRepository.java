package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.Cooling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CoolingRepository inherits from JpaRepository for communication with database
@Repository
public interface CoolingRepository extends JpaRepository<Cooling, Long> {
    
}
