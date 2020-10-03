package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//AdminRepository inherits from JpaRepository for communication with database
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
