package com.ydh.redsheep.shardingspherejdbc;

import com.ydh.redsheep.shardingspherejdbc.entity.CUser;
import com.ydh.redsheep.shardingspherejdbc.entity.City;
import com.ydh.redsheep.shardingspherejdbc.repository.CUserRepository;
import com.ydh.redsheep.shardingspherejdbc.repository.CityRepository;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class EncrypyTests {

    @Resource
    private CUserRepository userRepository;

    @Test
    public void testAdd(){
        for (int i=0; i<2; i++) {
            CUser user = new CUser();
            user.setName("tiger");
            user.setPwd("abc");
            userRepository.save(user);
        }
    }

    @Test
    public void testFind(){
        List<CUser> list = userRepository.findByPwd("abc");
        // 参数使用密文，这样是查不到的
//        List<CUser> list = userRepository.findByPwd("urfTcCrgkt2aQnnS7QaaNQ==");
        list.forEach(cUser -> {
            System.out.println(cUser.getId()+" "+cUser.getName()+" "+cUser.getPwd());
        });
    }

}
