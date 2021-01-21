package com.ydh.redsheep.shardingspherejdbc;

import com.ydh.redsheep.shardingspherejdbc.entity.BOrder;
import com.ydh.redsheep.shardingspherejdbc.entity.City;
import com.ydh.redsheep.shardingspherejdbc.entity.Position;
import com.ydh.redsheep.shardingspherejdbc.entity.PositionDetail;
import com.ydh.redsheep.shardingspherejdbc.repository.BOrderRepository;
import com.ydh.redsheep.shardingspherejdbc.repository.CityRepository;
import com.ydh.redsheep.shardingspherejdbc.repository.PositionDetailRepository;
import com.ydh.redsheep.shardingspherejdbc.repository.PositionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class ShardingDatabaseApplicationTests {

    @Resource
    private PositionRepository positionRepository;
    @Resource
    private PositionDetailRepository positionDetailRepository;
    @Resource
    private CityRepository cityRepository;
    @Resource
    private BOrderRepository orderRepository;

    /**
     * 单表分库插入
     */
    @Test
    public void testAdd(){
        for (int i=1;i<=20;i++){
            Position position = new Position();
//            position.setId(i);
            position.setName("ydh"+i);
            position.setSalary("1000000");
            position.setCity("beijing");
            positionRepository.save(position);
        }
    }

    /**
     * 两张表的分库插入
     */
    @Test
    public void testAdd2(){
        for (int i=1;i<=20;i++){
            Position position = new Position();
            position.setName("lagou"+i);
            position.setSalary("1000000");
            position.setCity("beijing");
            positionRepository.save(position);

            PositionDetail positionDetail = new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("this is a message "+i);
            positionDetailRepository.save(positionDetail);
        }
    }

    /**
     * 两张表的分库查询
     */
    @Test
    public void testLoad(){
        Object object = positionRepository.findPositionsById(559113096224833536L);
        Object[] position = (Object[])object;
        System.out.println(position[0]+" "+position[1]+" "+position[2]+" "+position[3]+" "+position[4]);
    }

    /**
     * 字典表测试
     */
    @Test
    public void testBroadCast(){
        City city = new City();
        city.setName("beijing");
        city.setProvince("beijing");
        cityRepository.save(city);
    }

    /**
    * 分库分表
    * @author : yangdehong
    * @date : 2021/1/21 20:54
    */
    @Test
    public void testShardingBOrder(){
        for (int i=0; i< 100; i++) {
            Random random = new Random();
            int companyId = random.nextInt(10);
            BOrder order = new BOrder();
            order.setIsDel(false);
            order.setCompanyId(companyId);
            order.setPositionId(3242342);
            order.setUserId(2222);
            order.setPublishUserId(1111);
            order.setResumeType(1);
            order.setStatus("AUTO");
            order.setCreateTime(new Date());
            order.setOperateTime(new Date());
            order.setWorkYear("2");
            order.setName("ydh");
            order.setPositionName("Java");
            order.setResumeId(23233);
            orderRepository.save(order);
        }
    }

}
