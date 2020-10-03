package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.Motherboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//MotherboardRepository inherits from JpaRepository for communication with database
@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {

}
