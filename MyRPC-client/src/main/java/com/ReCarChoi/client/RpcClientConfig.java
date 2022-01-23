package com.ReCarChoi.client;

import com.ReCarChoi.codec.Decoder;
import com.ReCarChoi.codec.Encoder;
import com.ReCarChoi.codec.JSONDecoder;
import com.ReCarChoi.codec.JSONEncoder;
import com.ReCarChoi.protocol.Peer;
import com.ReCarChoi.transport.HTTPTransportClient;
import com.ReCarChoi.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 14:38
 * @description Client配置类
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1",8081));
}
