package com.lcyanxi.config;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lcyanxi.listener.DemoChangeListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lichang on 2019/9/25
 */
@Configuration
public class EventConfig {

    @Bean
    public EventBus demoChangeEventBus() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demoChangeEventBus-pool-%d").build();
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(3, 5,
                60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        AsyncEventBus asyncEventBus = new AsyncEventBus("demoChangeEventBus", threadPoolExecutor);
        asyncEventBus.register(new DemoChangeListener());
        return asyncEventBus;
    }


}
