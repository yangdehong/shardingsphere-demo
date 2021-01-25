package com.ydh.redsheep.shardingspherejdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class ShardingsphereJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereJdbcApplication.class, args);
    }

}
