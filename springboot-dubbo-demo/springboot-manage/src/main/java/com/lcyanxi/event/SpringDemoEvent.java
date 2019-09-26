package com.lcyanxi.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Created by lichang on 2019/9/26
 */
@Data
public class SpringDemoEvent extends ApplicationEvent {

    private String message;

    public SpringDemoEvent(final Object source,String message) {
        super(source);
        this.message=message;
    }
}
