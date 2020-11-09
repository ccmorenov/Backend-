package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.GPU;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//GPURepository inherits from JpaRepository for communication with database
@Repository
public interface GPURepository extends JpaRepository<GPU, Long> {

}
