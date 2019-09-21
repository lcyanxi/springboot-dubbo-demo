package com.lcyanxi.service;


import com.lcyanxi.dto.ResponseDTO;
import com.lcyanxi.po.RequestPO;

/**
 * Created by lcyanxi on 2019/9/21
 */

public interface IOrderService {

    ResponseDTO doOrderNo(RequestPO po);

}
