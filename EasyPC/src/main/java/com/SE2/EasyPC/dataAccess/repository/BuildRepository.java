package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//BuildRepository inherits from JpaRepository for communication with database
@Repository
public interface BuildRepository extends JpaRepository<Build, Long> {
    
}