package com.ReCarChoi.transport;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 19:24
 * @description TODO
 * 1.启动，监听
 * 2.接受请求
 * 3.关闭监听
 */
public interface TransportServer {
    void init(int port,RequestHandler handler);
    void start();
    void stop();
}
