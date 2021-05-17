package com.example.elastic.job.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "elastic.job.zk")
@PropertySource("classpath:elastic-job.properties")
public class ZookeeperRegistryProperties {
   //服务地址，ip:port，多个地址用逗号分隔
    private String serverLists;
   //命名空间
    private String namespace;
   //最大重试次数
    private int maxRetries = 3;
   //连接超时时间，毫秒
    private int connectionTimeoutMilliseconds = 15000;
   //会话超时时间，毫秒
    private int sessionTimeoutMilliseconds = 60000;
   //等待重试的间隔时间的初始值，毫秒
    private int baseSleepTimeMilliseconds = 1000;
   //等待重试的间隔时间的最大值，毫秒
    private int maxSleepTimeMilliseconds = 3000;
   //连接zk的权限令牌，缺省为不需要权限验证。
    private String digest = "";

}
