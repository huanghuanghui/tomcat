package com.hhh;

/**
 * <p>
 * 描述:负责开启Socket并监听客户端请求，返回响应数据
 * </p>
 *
 * @author hhh
 * @since 2022/8/23
 */
public interface Connector {
    void start();
    void stop();
}
