package com.ReCarChoi.client;

import com.ReCarChoi.codec.Decoder;
import com.ReCarChoi.codec.Encoder;
import com.ReCarChoi.protocol.Request;
import com.ReCarChoi.protocol.Response;
import com.ReCarChoi.protocol.ServiceDescriptor;
import com.ReCarChoi.transport.TransportClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 14:51
 * @description 调用远程服务的代理类
 */
@Slf4j
public class RemoteInvoker implements InvocationHandler {
    private Class clazz;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    RemoteInvoker(Class clazz,
            Encoder encoder,
            Decoder decoder,
            TransportSelector selector){
        this.clazz = clazz;
        this.decoder = decoder;
        this.encoder = encoder;
        this.selector = selector;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = new Request();
        request.setServiceDescriptor(ServiceDescriptor.from(clazz,method));
        request.setParameters(args);
        Response response = invokeRemote(request);
        if ((response == null || response.getCode() != 0)){
            throw new IllegalStateException("fail to invoke remote: " + response);
        }
        return response.getData();
    }

    private Response invokeRemote(Request request) {
        Response response = null;
        TransportClient client = null;

        try{
            client = selector.select();
            byte[] outBytes = encoder.encode(request);
            InputStream write = client.write(new ByteArrayInputStream(outBytes));
            byte[] inBytes = IOUtils.readFully(write,write.available());
            response = decoder.decode(inBytes, Response.class);
        }catch (IOException e) {
            log.warn(e.getMessage(),e);
            response = new Response();
            response.setCode(1);
            response.setMessage("RpcClient got error: " + e.getClass() + " : " + e.getMessage());
        }finally{
            if (client != null){
                selector.release(client);
            }
        }
        return response;
    }
}
