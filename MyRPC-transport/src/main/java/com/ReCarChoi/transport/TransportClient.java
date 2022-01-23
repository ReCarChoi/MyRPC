package com.ReCarChoi.transport;

import com.ReCarChoi.protocol.Peer;

import java.io.InputStream;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 19:21
 * @description TODO
 * 1.创建连接
 * 2.发送数据，并且等待响应
 * 3.关闭连接
 */
public interface TransportClient {
    void connect(Peer peer);
    InputStream write(InputStream data);
    void close();
}
