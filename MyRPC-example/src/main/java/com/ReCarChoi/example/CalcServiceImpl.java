package com.ReCarChoi.example;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 15:15
 * @description TODO
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
