package com.ReCarChoi.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 19:25
 * @description 处理网络请求的handler
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResponse);
}
