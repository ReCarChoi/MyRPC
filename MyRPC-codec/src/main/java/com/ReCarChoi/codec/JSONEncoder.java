package com.ReCarChoi.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 16:30
 * @description 基于json的序列化实现
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object object) {
        return JSON.toJSONBytes(object);
    }
}
