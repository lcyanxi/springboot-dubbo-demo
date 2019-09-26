package com.lcyanxi.po;



import lombok.Data;

import java.io.Serializable;

/**
 * Created by lcyanxi on 2019/9/21
 */

@Data
public class RequestPO implements Serializable{

    private static final long serialVersionUID = 4361241616953120345L;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 电话号码
     */
    private String phone;


}
