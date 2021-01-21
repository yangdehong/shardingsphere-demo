package com.ydh.redsheep.shardingspherejdbc.repository;

import com.ydh.redsheep.shardingspherejdbc.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionRepository  extends JpaRepository<Position,Long> {

    @Query(nativeQuery = true,value = "select p.id,p.name,p.salary,p.city,pd.description from position p join position_detail pd on(p.id=pd.pid) where p.id=:id")
    Object findPositionsById(@Param("id") long id);

}
