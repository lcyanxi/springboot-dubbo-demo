package com.lcyanxi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lcyanxi on 2019/9/21
 */
@Data
public class ResponseDTO implements Serializable{

    private static final long serialVersionUID = 8015871739515218061L;
    /**
     * 应答消息
     */
    private String message;

    /**
     * 状态编码
     */
    private int statusCode;

}
