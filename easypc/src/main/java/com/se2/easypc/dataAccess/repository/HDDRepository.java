package com.se2.easypc.dataAccess.repository;
import com.se2.easypc.dataAccess.model.HDD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//HDDRepository inherits from JpaRepository for communication with database
@Repository
public interface HDDRepository extends JpaRepository<HDD, Long> {

}
