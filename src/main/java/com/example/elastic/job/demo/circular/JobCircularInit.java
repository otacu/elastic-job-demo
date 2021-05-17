package com.example.elastic.job.demo.circular;

import com.example.elastic.job.demo.entity.MyJobInfo;
import com.example.elastic.job.demo.service.ElasticJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobCircularInit {

    @Autowired
    private ElasticJobService elasticJobService;

    @PostConstruct
    public void initJob() {
        // TODO 从配置中心读取所有job配置
        MyJobInfo jobInfo = new MyJobInfo();
        jobInfo.setJobName("myScheduleJob");
        jobInfo.setCron("0 */1 * * * ?");
        jobInfo.setJobClass("com.example.elastic.job.demo.job.MyOrderScheduleJob");
        jobInfo.setShardingCount(3);
        jobInfo.setShardingParams("0=Beijing,1=Shanghai,2=Guangzhou");

        List<MyJobInfo> list = new ArrayList<>();
        list.add(jobInfo);
        // 初始化
        for (MyJobInfo myJobInfo : list) {
            elasticJobService.initJob(myJobInfo);
        }

    }
}
