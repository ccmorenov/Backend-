package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.PowerSupply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//PowerSupplyRepository inherits from JpaRepository for communication with database
@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {

}