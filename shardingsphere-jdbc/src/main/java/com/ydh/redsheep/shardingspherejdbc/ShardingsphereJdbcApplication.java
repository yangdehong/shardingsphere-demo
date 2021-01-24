package com.ydh.redsheep.shardingspherejdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class ShardingsphereJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereJdbcApplication.class, args);
    }

}
