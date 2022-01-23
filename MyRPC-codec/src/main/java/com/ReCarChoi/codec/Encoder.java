package com.ReCarChoi.codec;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 16:28
 * @description 序列化
 */
public interface Encoder {
    byte[] encode(Object object);
}
