package com.ReCarChoi.protocol;

import lombok.Data;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 13:21
 * @description 表示RPC的返回响应
 */

@Data
public class Response extends Throwable {
    //服务返回编码，0-成功，非0失败
    private int code = 0;
    //具体的错误信息
    private String message = "ok";
    //返回的数据
    private Object data;
}
