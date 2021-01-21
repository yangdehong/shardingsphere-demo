package com.ydh.redsheep.shardingspherejdbc.repository;

import com.ydh.redsheep.shardingspherejdbc.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
