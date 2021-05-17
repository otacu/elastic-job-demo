package com.example.elastic.job.demo.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderItemService orderItemService;

    public void queryOrder(String shardingParam) {
        System.out.println("分片参数" + shardingParam);
        orderItemService.queryItem(shardingParam);
    }
}
