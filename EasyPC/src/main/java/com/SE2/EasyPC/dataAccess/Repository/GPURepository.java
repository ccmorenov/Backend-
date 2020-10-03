package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.GPU;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//GPURepository inherits from JpaRepository for communication with database
@Repository
public interface GPURepository extends JpaRepository<GPU, Long> {

}
