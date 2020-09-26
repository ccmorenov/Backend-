package com.SE2.EasyPC.dataAccess.Repository;

import com.SE2.EasyPC.dataAccess.model.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends JpaRepository<Build, Long> {
    
}