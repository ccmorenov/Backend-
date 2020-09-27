package com.SE2.EasyPC.dataAccess.repository;
import com.SE2.EasyPC.dataAccess.model.Keyboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<Keyboard, Long> {

}