package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.Mouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//MouseRepository inherits from JpaRepository for communication with database
@Repository
public interface MouseRepository extends JpaRepository<Mouse, Long> {
    
}
