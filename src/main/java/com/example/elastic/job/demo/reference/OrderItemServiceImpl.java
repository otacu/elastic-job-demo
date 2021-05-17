package com.example.elastic.job.demo.reference;

import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Override
    public void queryItem(String shardingParam) {
        System.out.println("分片" + shardingParam + "商品");
    }
}
