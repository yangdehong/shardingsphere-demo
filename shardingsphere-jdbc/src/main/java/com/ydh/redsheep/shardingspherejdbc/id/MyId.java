package com.ydh.redsheep.shardingspherejdbc.id;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

/**
* 自定义主键生成器
* @author : yangdehong
* @date : 2021/1/21 20:26
*/
public class MyId implements ShardingKeyGenerator {

    private SnowflakeShardingKeyGenerator snow = new SnowflakeShardingKeyGenerator();

    @Override
    public Comparable<?> generateKey() {
        System.out.println("------执行了自定义主键生成器MyId-------");
        return snow.generateKey();
    }

    @Override
    public String getType() {
        return "YDHKEY";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
