package com.ReCarChoi.client;

import com.ReCarChoi.protocol.Peer;
import com.ReCarChoi.transport.TransportClient;

import java.util.List;


/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 14:10
 * @description 表示选择那个server去连接
 */
public interface TransportSelector {

    /**
     * create by: ReCarChoi
     * description:初始化selector
     * create time: 14:23 2022/1/22
     * @param peers 可以连接的server端点信息
     * @param count client与server建立多少个连接
     * @param clazz client实现class
     * @return
     */
    void init(List<Peer> peers,int count,Class<? extends  TransportClient> clazz);

    /**
     * create by: ReCarChoi
     * description:选择一个transport与server做交互
     * @return 网络client
     */
    TransportClient select();

    /**
     * create by: ReCarChoi
     * description:释放用完的client
     * @param client
     */
    void release(TransportClient client);

    /**
     * create by: ReCarChoi
     * description:关闭selector
     * create time: 14:25 2022/1/22
     */
    void close();

}
