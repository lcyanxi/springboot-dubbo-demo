package com.lcyanxi.web;

import com.google.common.eventbus.EventBus;
import com.lcyanxi.dto.ResponseDTO;
import com.lcyanxi.event.ChangeMessageEvent;
import com.lcyanxi.event.SpringDemoEvent;
import com.lcyanxi.po.RequestPO;
import com.lcyanxi.service.IOrderQueryService;
import com.lcyanxi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lcyanxi on 2019/9/21
 */
@Controller
public class UserController {

    @Autowired
    private EventBus demoChangeEventBus;

    @Autowired
    private ApplicationContext applicationContext;

    @ResponseBody
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(@RequestParam("name") String name){

        System.out.println("获取到用户："+name+"登录");
        String message="用户:"+name+"登录成功";


        System.out.println("guava事件监听发送消息开始>>>>>>>>>>>>>>>>>>>>>");
        ChangeMessageEvent event=new ChangeMessageEvent();
        event.setMessage(message);
        demoChangeEventBus.post(event);
        System.out.println("guava事件监听发送消息结束>>>>>>>>>>>>>>>>>>>>>");

        System.out.println("spring事件监听发送消息开始>>>>>>>>>>>>>>>>>>>>>");

        SpringDemoEvent event2=new SpringDemoEvent(this,message);
        applicationContext.publishEvent(event2);
        System.out.println("spring事件监听发送消息结束>>>>>>>>>>>>>>>>>>>>>");
        return message;
    }



    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("manage-consumer.xml");

        //用户下单过程
        IOrderService services=(IOrderService)context.getBean("orderService");

        //订单查询
        IOrderQueryService queryService=(IOrderQueryService)context.getBean("orderQueryService");
        System.out.println(queryService.queryOrder("新东方在线"));

        RequestPO request=new RequestPO();
        request.setUserName("lcyanxi");
        request.setOrderNo("201901211710");
        ResponseDTO response=services.doOrderNo(request);

        System.out.println(response);
    }
}
