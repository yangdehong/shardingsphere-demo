package com.ydh.redsheep.shardingspherejdbc;

import com.ydh.redsheep.shardingspherejdbc.entity.City;
import com.ydh.redsheep.shardingspherejdbc.entity.Position;
import com.ydh.redsheep.shardingspherejdbc.entity.PositionDetail;
import com.ydh.redsheep.shardingspherejdbc.repository.CityRepository;
import com.ydh.redsheep.shardingspherejdbc.repository.PositionDetailRepository;
import com.ydh.redsheep.shardingspherejdbc.repository.PositionRepository;
import org.apache.shardingsphere.api.hint.HintManager;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class TxTests {

    @Resource
    private PositionRepository positionRepository;

    @Resource
    private PositionDetailRepository positionDetailRepository;

    @Test
    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void test1(){
//        TransactionTypeHolder.set(TransactionType.BASE);
        for (int i=1;i<=5;i++){
            Position position = new Position();
            position.setName("root"+i);
            position.setSalary("1000000");
            position.setCity("beijing");
            positionRepository.save(position);

            if (i==3){
                throw new RuntimeException("人为制造异常");
            }

            PositionDetail positionDetail = new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("this is a root "+i);
            positionDetailRepository.save(positionDetail);
        }
    }

}
