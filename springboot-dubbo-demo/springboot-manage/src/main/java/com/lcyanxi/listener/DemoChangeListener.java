package com.lcyanxi.listener;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.google.common.eventbus.Subscribe;
import com.lcyanxi.event.ChangeMessageEvent;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lichang on 2019/9/25
 */
@Data
@Slf4j
public class DemoChangeListener {

    private static Logger logger = LoggerFactory.getLogger(DemoChangeListener.class);

    @Subscribe
    public void ExcelAnalysisError(ChangeMessageEvent event) {

        log.info("监听到了【数据变更消息】 event: {}", JSON.toJSONString(event));
        try {
            String message = event.getMessage();
            Preconditions.checkNotNull(message);
        } catch (Exception e) {
            log.error("【数据变更消息】event信息错误 ");
            return;
        }
    }
}
