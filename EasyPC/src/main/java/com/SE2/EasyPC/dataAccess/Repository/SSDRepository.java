package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.SSD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//SSDRepository inherits from JpaRepository for communication with database
@Repository
public interface SSDRepository extends JpaRepository<SSD, Long> {

}
