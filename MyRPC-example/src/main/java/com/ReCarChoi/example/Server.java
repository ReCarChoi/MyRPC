package com.ReCarChoi.example;

import com.ReCarChoi.server.RpcServer;
import com.ReCarChoi.server.RpcServerConfig;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 15:14
 * @description TODO
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer(new RpcServerConfig());
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
