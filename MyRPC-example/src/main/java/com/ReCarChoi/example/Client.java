package com.ReCarChoi.example;

import com.ReCarChoi.client.RpcClient;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/22 15:14
 * @description TODO
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int r1 = service.add(1, 2);
        int r2 = service.minus(10, 8);
        System.out.println(r1);
        System.out.println(r2);
    }
}
