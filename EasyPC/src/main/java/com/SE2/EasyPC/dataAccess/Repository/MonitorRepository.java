package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {

}

