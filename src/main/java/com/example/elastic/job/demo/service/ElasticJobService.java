package com.example.elastic.job.demo.service;

import com.example.elastic.job.demo.entity.MyJobInfo;
import com.example.elastic.job.demo.util.SpringContextHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.elasticjob.api.ElasticJob;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticJobService {

    @Autowired
    private ZookeeperRegistryCenter zookeeperRegistryCenter;

    @Autowired
    private SpringContextHelper springContextHelper;

    public void initJob(MyJobInfo jobInfo) {
        try {
            JobConfiguration jobConfig = null;
            JobConfiguration.Builder builder = JobConfiguration.newBuilder(jobInfo.getJobName(),
                    jobInfo.getShardingCount());
            builder.cron(jobInfo.getCron());
            if (StringUtils.isNotBlank(jobInfo.getShardingParams())) {
                builder.shardingItemParameters(jobInfo.getShardingParams());
            }
            if (StringUtils.isNotBlank(jobInfo.getJobParam())) {
                builder.jobParameter(jobInfo.getJobParam());
            }
            builder.failover(true);
            jobConfig = builder.build();

            Class clz = Class.forName(jobInfo.getJobClass());
            ElasticJob job = (ElasticJob) springContextHelper.getBean(clz);
            new ScheduleJobBootstrap(zookeeperRegistryCenter, job, jobConfig).schedule();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
