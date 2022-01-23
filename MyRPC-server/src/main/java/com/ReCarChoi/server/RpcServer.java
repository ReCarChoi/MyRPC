package com.ReCarChoi.server;

import com.ReCarChoi.codec.Decoder;
import com.ReCarChoi.codec.Encoder;
import com.ReCarChoi.protocol.Request;
import com.ReCarChoi.protocol.Response;
import com.ReCarChoi.transport.RequestHandler;
import com.ReCarChoi.transport.TransportServer;
import com.ReCarChoi.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 11:29
 * @description RPC具体的服务
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer(){
        this(new RpcServerConfig());
    }

    public RpcServer(RpcServerConfig config) {
        this.config = config;
        //net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), this.handler);
        //codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        //service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass,T bean){
        serviceManager.register(interfaceClass,bean);
    }

    public void start(){
        this.net.start();
    }

    public void stop(){
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResponse) {
            Response response = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(receive,receive.available());
                Request request = decoder.decode(inBytes, Request.class);
                log.info("get request : {}",request);
                ServiceInstance instance = serviceManager.lookup(request);
                Object invoke = serviceInvoker.invoke(instance, request);
                response.setData(invoke);
            } catch (IOException e) {
                log.warn(e.getMessage(),e);
                response.setCode(1);
                response.setMessage("RpcServer got error" + e.getClass().getName() + " " + e.getMessage());
            }finally{
                try {
                    byte[] outBytes = encoder.encode(response);
                    toResponse.write(outBytes);
                    log.info("Response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(),e);
                    e.printStackTrace();
                }
            }
        }
    };
}
