package com.ReCarChoi.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 13:13
 * @description 表示网络传输的一个端点
 */

@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
