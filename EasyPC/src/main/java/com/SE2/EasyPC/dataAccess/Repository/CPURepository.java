package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.CPU;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CPURepository inherits from JpaRepository for communication with database
@Repository
public interface CPURepository extends JpaRepository<CPU, Long> {

}
