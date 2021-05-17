package com.example.elastic.job.demo.job;

import com.example.elastic.job.demo.reference.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyOrderScheduleJob implements SimpleJob {

    @Autowired
    private OrderService orderService;

    @Override
    public void execute(ShardingContext shardingContext) {
        // 这里去远程调其它服务的接口
        orderService.queryOrder(shardingContext.getShardingParameter());
    }

}
