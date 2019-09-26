package com.lcyanxi.listener;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lcyanxi.event.SpringDemoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by lichang on 2019/9/26
 */
@Component
public class SpringDemoListener {

    private static Logger logger = LoggerFactory.getLogger(SpringDemoListener.class);

    @Async
    @EventListener
    public void onApplicationEvent(SpringDemoEvent event) {
        logger.info("spring监听到了【数据变更消息】 event: {}", JSON.toJSONString(event));
        try {
            Thread.sleep(5000);
            String message = event.getMessage();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+message);
            Preconditions.checkNotNull(message);
        } catch (Exception e) {
            logger.error("【数据变更消息】event信息错误 ");
            return;
        }
        logger.info("spring监听到了【数据变更消息】 event: {}", JSON.toJSONString(event));
    }
}
