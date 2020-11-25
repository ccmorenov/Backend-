package com.se2.easypc.data_access.repository;
import com.se2.easypc.data_access.model.HDD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//HDDRepository inherits from JpaRepository for communication with database
@Repository
public interface HDDRepository extends JpaRepository<HDD, Long> {

}
