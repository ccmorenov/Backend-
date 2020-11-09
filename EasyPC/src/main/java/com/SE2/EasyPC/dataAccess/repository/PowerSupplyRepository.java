package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.PowerSupply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//PowerSupplyRepository inherits from JpaRepository for communication with database
@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {

}