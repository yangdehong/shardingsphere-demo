package com.ydh.redsheep.shardingspherejdbc.repository;

import com.ydh.redsheep.shardingspherejdbc.entity.BOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BOrderRepository extends JpaRepository<BOrder,Long> {
}
