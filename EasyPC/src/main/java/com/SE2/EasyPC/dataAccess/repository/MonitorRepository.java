package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//MonitorRepository inherits from JpaRepository for communication with database
@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {

}

