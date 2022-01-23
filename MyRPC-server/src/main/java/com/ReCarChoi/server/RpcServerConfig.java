package com.ReCarChoi.server;

import com.ReCarChoi.codec.Decoder;
import com.ReCarChoi.codec.Encoder;
import com.ReCarChoi.codec.JSONDecoder;
import com.ReCarChoi.codec.JSONEncoder;
import com.ReCarChoi.transport.HTTPTransportServer;
import com.ReCarChoi.transport.TransportServer;
import lombok.Data;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 10:08
 * @description rpcServer属性配置
 */
@Data
public class RpcServerConfig {
    //网络协议
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    //序列化
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    //序列化
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    //默认端口号
    private int port = 8081;
}
