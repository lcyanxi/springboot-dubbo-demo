package com.lcyanxi.web;

import com.lcyanxi.dto.ResponseDTO;
import com.lcyanxi.po.RequestPO;
import com.lcyanxi.service.IOrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lcyanxi on 2019/9/21
 */

public class UserController {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("manage-consumer.xml");

        //用户下单过程
        IOrderService services=(IOrderService)context.getBean("orderService");

        RequestPO request=new RequestPO();
        request.setUserName("lcyanxi");
        request.setOrderNo("201901211710");
        ResponseDTO response=services.doOrderNo(request);

        System.out.println(response);
    }
}
