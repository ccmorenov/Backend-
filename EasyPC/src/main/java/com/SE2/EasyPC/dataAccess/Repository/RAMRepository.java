package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.RAM;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//RAMRepository inherits from JpaRepository for communication with database
@Repository
public interface RAMRepository extends JpaRepository<RAM, Long> {

}
