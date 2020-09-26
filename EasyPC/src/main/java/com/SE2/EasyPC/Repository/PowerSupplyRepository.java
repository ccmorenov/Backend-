package com.SE2.EasyPC.Repository;

import com.SE2.EasyPC.dataAccess.model.PowerSupply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {

}