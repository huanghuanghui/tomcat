package com.hhh;

/**
 * <p>
 * 描述:接收其他客户端发来的请求，并进行解析，完成相关业务处理，并将处理结果返回给其他客户端
 * - 一个Server拥有多个Service（相互独立，共享同一个JVM与类库）
 * - 一个Service负责维护多个Engine（servlet引擎）与connector，
 *      container与connector分别拥有自己的start与stop方法用来维护/释放自己所持有的资源
 * </p>
 *
 * @author hhh
 * @since 2022/8/23
 */
public interface Server {

    /**
     * 启动服务器，打开socket连接，监听服务器端口，在接收到客户端请求时，进行处理并返回响应
     */
    void start();

    /**
     * 停止服务器并释放网络资源
     */
    void stop();
}
