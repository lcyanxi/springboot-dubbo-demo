package com.lcyanxi.service;

import org.springframework.stereotype.Service;

/**
 * Created by lcyanxi on 2019/9/21
 */
@Service("orderQueryService")
public class OrderQueryServiceImpl implements IOrderQueryService {

    @Override
    public String queryOrder(String param) {
        System.out.println("接收到参数:"+param);
        return "参数请求处理成功";
    }
}
