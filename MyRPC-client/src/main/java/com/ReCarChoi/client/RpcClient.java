package com.ReCarChoi.client;

import com.ReCarChoi.codec.Decoder;
import com.ReCarChoi.codec.Encoder;
import com.ReCarChoi.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 14:44
 * @description Rpc用户端
 */
@SuppressWarnings(value = "all")
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient(){
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());
        this.selector.init(
                this.config.getServers(),
                this.config.getConnectCount(),
                this.config.getTransportClass());
    }

    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz,encoder,decoder,selector));
    }
}
