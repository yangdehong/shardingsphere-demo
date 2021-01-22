package com.ydh.redsheep.shardingspherejdbc;

import com.ydh.redsheep.shardingspherejdbc.entity.City;
import com.ydh.redsheep.shardingspherejdbc.repository.CityRepository;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class HintTests {

    @Resource
    private CityRepository cityRepository;

    @Test
    public void test1(){
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue(0L); //强制路由到ds${xx%2}
        List<City> list = cityRepository.findAll();
        list.forEach(city->{
            System.out.println(city.getId()+" "+city.getName()+" "+city.getProvince());
        });
    }

}
