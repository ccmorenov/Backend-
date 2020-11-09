package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//BuildRepository inherits from JpaRepository for communication with database
@Repository
public interface BuildRepository extends JpaRepository<Build, Long> {
    
}