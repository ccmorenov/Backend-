package com.SE2.EasyPC.Repository;

import com.SE2.EasyPC.dataAccess.model.RAM;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAMRepository extends JpaRepository<RAM, Long> {

}
