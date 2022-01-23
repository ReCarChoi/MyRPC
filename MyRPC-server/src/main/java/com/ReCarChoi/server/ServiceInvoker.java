package com.ReCarChoi.server;

import com.ReCarChoi.protocol.Request;
import com.ReCarChoi.utils.ReflectionUtils;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 11:27
 * @description 调用具体服务
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request){
        return ReflectionUtils.invoke(
                service.getTarget(),
                service.getMethod(),
                request.getParameters());
    }
}
