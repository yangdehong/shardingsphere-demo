package com.ydh.redsheep.shardingspherejdbc.repository;

import com.ydh.redsheep.shardingspherejdbc.entity.COrderPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface COrderRepository extends JpaRepository<COrderPO,Long> {
}
