package com.example.elastic.job.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ZookeeperRegistry {

    @Bean(name = "registryCenter", initMethod = "init")
    public ZookeeperRegistryCenter registryCenter(ZookeeperRegistryProperties registryProperties) {
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(
                registryProperties.getServerLists(), registryProperties.getNamespace());
        zookeeperConfiguration.setDigest(registryProperties.getDigest());
        zookeeperConfiguration.setBaseSleepTimeMilliseconds(registryProperties.getBaseSleepTimeMilliseconds());
        zookeeperConfiguration.setConnectionTimeoutMilliseconds(registryProperties.getConnectionTimeoutMilliseconds());
        zookeeperConfiguration.setMaxRetries(registryProperties.getMaxRetries());
        zookeeperConfiguration.setMaxSleepTimeMilliseconds(registryProperties.getMaxSleepTimeMilliseconds());
        zookeeperConfiguration.setSessionTimeoutMilliseconds(zookeeperConfiguration.getSessionTimeoutMilliseconds());
        log.info("elasticJob注册中心——Zookeeper初始化成功。serverLists={}。nameSpace={}", registryProperties.getServerLists(), registryProperties.getNamespace());
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }
}
