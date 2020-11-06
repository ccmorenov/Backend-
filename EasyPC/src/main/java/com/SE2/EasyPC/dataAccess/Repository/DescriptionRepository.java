package com.SE2.EasyPC.dataAccess.repository;

import com.SE2.EasyPC.dataAccess.model.Description;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DescriptionRepository inherits from JpaRepository for communication with database
@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
    Description findByPartName( String partName ); // Find Description by part_name
}