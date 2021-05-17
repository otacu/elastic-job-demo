package com.example.elastic.job.demo;

import com.example.elastic.job.demo.job.MyOrderScheduleJob;
import com.example.elastic.job.demo.util.SpringContextHelper;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ElasticJobDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private SpringContextHelper springContextHelper;

    @Test
    public void test1() throws Exception {
        Class clz = Class.forName("com.example.elastic.job.demo.job.MyOrderScheduleJob");
        MyOrderScheduleJob job = (MyOrderScheduleJob) springContextHelper.getBean(clz);
        ShardingContext shardingContext = new ShardingContext("", "", 3, "", 1, "beijing");
        job.execute(shardingContext);
    }
}
