package com.ydh.redsheep.shardingspherejdbc;

import com.ydh.redsheep.shardingspherejdbc.entity.City;
import com.ydh.redsheep.shardingspherejdbc.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MasterSlaveTests {

    @Resource
    private CityRepository cityRepository;

    @Test
    public void testAdd(){
        City city = new City();
        city.setName("shanghai");
        city.setProvince("shanghai");
        cityRepository.save(city);
    }

    @Test
    public void testFind(){
        List<City> list = cityRepository.findAll();
        list.forEach(city->{
            System.out.println(city.getId()+" "+city.getName()+" "+city.getProvince());
        });
    }

}
