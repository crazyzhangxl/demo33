package com.jit.demo.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by nsizm on 2018/8/7.
 * springBean工具类
 */
@Service
public class SpringBeanFactory implements ApplicationContextAware {

    private final static Logger LOG = LoggerFactory.getLogger(SpringBeanFactory.class);

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanFactory.applicationContext = applicationContext;
    }

    /**
     * 获取某个Bean的对象
     */
    public static <T> T getBean(Class<T> clazz) {
        try {
            return applicationContext.getBean(clazz);
        } catch (Exception e) {
            LOG.error("Spring getBean:{},e:{}" ,clazz, e);
        }
        return null;
    }
}