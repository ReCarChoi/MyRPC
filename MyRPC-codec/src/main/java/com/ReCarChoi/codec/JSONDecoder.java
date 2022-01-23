package com.ReCarChoi.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 16:34
 * @description 反序列化
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}
