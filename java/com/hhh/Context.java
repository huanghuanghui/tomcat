package com.hhh;

/**
 * <p>
 * 描述:一个context表示一个web应用，并且一个engine可以包含多个context
 * Context也拥有start与stop方法，将启动时加载资源与停止时释放资源的权限细化到每一个组件
 * </p>
 *
 * @author hhh
 * @since 2022/8/23
 */
public interface Context {
    void start();
    void stop();
}
