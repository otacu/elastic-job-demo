package com.example.elastic.job.demo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHelper implements ApplicationContextAware {

    /**
     * Spring应用上下文环境
     */
    private ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param applicationContext applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * @return ApplicationContext
     */
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象
     * 这里重写了bean方法，起主要作用
     *
     * @param name bean名称
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException 异常
     */
    public Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * 获取对象
     * 这里重写了bean方法，起主要作用
     *
     * @param clazz clazz
     * @param <T>   类型
     * @throws BeansException 异常
     */
    public <T> T getBean(Class<T> clazz) throws BeansException {
        return applicationContext.getBean(clazz);
    }
}
