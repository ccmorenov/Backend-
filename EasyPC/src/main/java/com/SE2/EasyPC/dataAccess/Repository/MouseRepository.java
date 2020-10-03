package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.Mouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//MouseRepository inherits from JpaRepository for communication with database
@Repository
public interface MouseRepository extends JpaRepository<Mouse, Long> {
    
}
