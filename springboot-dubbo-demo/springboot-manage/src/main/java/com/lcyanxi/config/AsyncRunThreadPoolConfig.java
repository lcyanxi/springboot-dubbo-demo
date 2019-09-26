package com.lcyanxi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lichang on 2019/9/26
 */
@Configuration
@EnableAsync
public class AsyncRunThreadPoolConfig {
    /**
     * <!-- 配置线程池 -->
     * <bean id="asyncRunBusinessThreadPoolTaskExecutor"
     * class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
     * <!-- 核心线程数 -->
     * <property name="corePoolSize" value="100" />
     * <!-- 最大线程数 -->
     * <property name="maxPoolSize" value="1000" />
     * <!-- 创建阻塞队列，线程池满了直接在调用线程上执行 -->
     * <property name="queueCapacity" value="0" />
     * <!-- 线程池维护线程所允许的空闲时间 -->
     * <property name="keepAliveSeconds" value="300" />
     * <property name="threadNamePrefix" value="async-run-business-" />
     * <property name="waitForTasksToCompleteOnShutdown" value="true" />
     * <!-- 线程池对拒绝任务(无线程可用)的处理策略 ThreadPoolExecutor.CallerRunsPolicy ,直接在调用线程执行任务(保证业务逻辑正确). -->
     * <property name="rejectedExecutionHandler">
     * <bean class="java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy" />
     * </property>
     * </bean>
     **/

    @Bean(name = "asyncRunThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor asyncRunThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(100);
        threadPoolTaskExecutor.setMaxPoolSize(1000);
        threadPoolTaskExecutor.setQueueCapacity(0);
        threadPoolTaskExecutor.setKeepAliveSeconds(300);
        threadPoolTaskExecutor.setThreadNamePrefix("async-run-business-");
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return threadPoolTaskExecutor;
    }

}
