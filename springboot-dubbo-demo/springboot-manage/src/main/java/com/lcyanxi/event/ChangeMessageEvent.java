package com.lcyanxi.event;

import lombok.Data;

/**
 * Created by lichang on 2019/9/25
 */
@Data
public class ChangeMessageEvent {

    /**
     * 消息体
     */
    private String message;
}
