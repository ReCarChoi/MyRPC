package com.ReCarChoi.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 10:17
 * @description 表示一个具体的服务
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}
