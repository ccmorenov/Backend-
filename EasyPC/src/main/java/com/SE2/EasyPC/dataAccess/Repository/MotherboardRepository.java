package com.SE2.EasyPC.dataAccess.Repository;

import com.SE2.EasyPC.dataAccess.model.Motherboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {

}
