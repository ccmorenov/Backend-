package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//MonitorRepository inherits from JpaRepository for communication with database
@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {

}

