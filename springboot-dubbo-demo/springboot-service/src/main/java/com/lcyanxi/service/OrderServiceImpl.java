package com.lcyanxi.service;


import com.lcyanxi.dto.ResponseDTO;
import com.lcyanxi.po.RequestPO;
import org.springframework.stereotype.Service;

/**
 * Created by lcyanxi on 2019/9/21
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    public ResponseDTO doOrderNo(RequestPO po) {
        System.out.println("用户数据获取到" + po);
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("处理成功");
        dto.setStatusCode(100);
        return dto;
    }
}
