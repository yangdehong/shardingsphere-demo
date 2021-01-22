package com.ydh.redsheep.shardingspherejdbc.hint;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
* 强制路由，比如读操作走主库
* @author : yangdehong
* @date : 2021/1/21 21:50
*/
public class MyHintShardingAlgorithm implements HintShardingAlgorithm<String> {

    /**
     *
     * @param availableTargetNames 所有的分库集合
     * @param shardingValue 表以及配置的hint规则
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> shardingValue) {
        Collection<String> result = new ArrayList<>();
        for (String each : availableTargetNames){
            for (String dbName : shardingValue.getValues()) {
                if (each.equals(dbName)) {
                    result.add(each);
                }
            }
        }
        return result;
    }

}
