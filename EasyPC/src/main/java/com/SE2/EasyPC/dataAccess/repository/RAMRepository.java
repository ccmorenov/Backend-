package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.RAM;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//RAMRepository inherits from JpaRepository for communication with database
@Repository
public interface RAMRepository extends JpaRepository<RAM, Long> {

}
