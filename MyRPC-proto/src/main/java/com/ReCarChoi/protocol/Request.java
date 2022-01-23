package com.ReCarChoi.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 13:20
 * @description 表示RPC的一个请求
 */

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Request {
    private ServiceDescriptor serviceDescriptor;
    private Object[] parameters;
}
