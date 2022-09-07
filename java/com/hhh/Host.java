package com.hhh;

/**
 * <p>
 * 描述:虚拟主机，一个tomcat可以部署多个web应用，那么就需要一个虚拟主机来维护Context与域名之间的关系
 *
 * </p>
 *
 * @author hhh
 * @since 2022/8/23
 */
public interface Host {
    void start();
    void stop();
}
