package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.Description;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DescriptionRepository inherits from JpaRepository for communication with database
@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
    Description findByPartName( String partName ); // Find Description by part_name
}