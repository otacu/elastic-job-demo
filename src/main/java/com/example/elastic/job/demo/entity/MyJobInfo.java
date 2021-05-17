package com.example.elastic.job.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyJobInfo implements Serializable {
    private String jobName;

    private String cron;

    private String jobClass;

    /**
     * 作业参数
     */
    private String jobParam;

    /**
     * 分片参数
     */
    private String shardingParams;

    /**
     * 业务类型
     */
    private Short businessType;

    /**
     * 分片数
     */
    private Integer shardingCount;
}
