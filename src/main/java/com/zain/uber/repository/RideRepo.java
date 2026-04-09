package com.zain.uber.repository;

import com.zain.uber.entity.Rider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepo extends JpaRepository<Rider, Long> {

    

}
