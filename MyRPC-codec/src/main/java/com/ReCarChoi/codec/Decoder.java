package com.ReCarChoi.codec;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 16:29
 * @description 反序列化
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
