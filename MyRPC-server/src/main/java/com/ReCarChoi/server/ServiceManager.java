package com.ReCarChoi.server;

import com.ReCarChoi.protocol.Request;
import com.ReCarChoi.protocol.ServiceDescriptor;
import com.ReCarChoi.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 10:18
 * @description 管理rpc暴露的服务 service管理类
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor,ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass,T bean){
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance instance = new ServiceInstance(bean, method);
            ServiceDescriptor descriptor = ServiceDescriptor.from(interfaceClass, method);
            services.put(descriptor, instance);
            log.info("register service: {} {}",descriptor.getClazz(),instance.getMethod());
        }
    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor descriptor = request.getServiceDescriptor();
        return services.get(descriptor);
    }
}
