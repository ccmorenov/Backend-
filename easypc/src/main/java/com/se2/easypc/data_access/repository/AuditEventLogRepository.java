package com.se2.easypc.data_access.repository;

import com.se2.easypc.data_access.model.AuditEventLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//AuditEventRepository inherits from JpaRepository for communication with database
@Repository
public interface AuditEventLogRepository extends JpaRepository<AuditEventLog, Long> {
    
}