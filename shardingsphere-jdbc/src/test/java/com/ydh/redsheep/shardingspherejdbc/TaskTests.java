package com.ydh.redsheep.shardingspherejdbc;

import com.ydh.redsheep.shardingspherejdbc.entity.COrderPO;
import com.ydh.redsheep.shardingspherejdbc.entity.Position;
import com.ydh.redsheep.shardingspherejdbc.entity.PositionDetail;
import com.ydh.redsheep.shardingspherejdbc.repository.COrderRepository;
import com.ydh.redsheep.shardingspherejdbc.repository.PositionDetailRepository;
import com.ydh.redsheep.shardingspherejdbc.repository.PositionRepository;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
class TaskTests {

    @Resource
    private COrderRepository cOrderRepository;

    @Test
    public void add(){
        for (int i=1;i<=100;i++){
            COrderPO cOrderPO = new COrderPO();
            cOrderPO.setUserId(new Random().nextInt(10));
            cOrderPO.setCompanyId(i);
            cOrderPO.setPositionId(1);
            cOrderPO.setResumeType(1);
            cOrderPO.setPublishUserId(1);
            cOrderPO.setDel(false);
            cOrderPO.setStatus("1");
            cOrderPO.setCreateTime(new Date());
            cOrderPO.setUpdateTime(new Date());
            cOrderRepository.save(cOrderPO);
        }
    }

    @Test
    public void getAll(){
        List<COrderPO> all = cOrderRepository.findAll();
        System.out.println(all);
        System.out.println(all.size());
    }


}
