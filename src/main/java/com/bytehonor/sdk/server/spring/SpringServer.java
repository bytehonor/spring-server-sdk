package com.bytehonor.sdk.server.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.bytehonor.sdk.lang.spring.Java;
import com.bytehonor.sdk.server.spring.web.context.ApplicationContextHolder;
import com.bytehonor.sdk.server.spring.web.context.ServerContext;

/**
 * @author lijianqiang
 *
 */
public final class SpringServer {

    public static <T> T bean(Class<T> requiredType) {
        Java.requireNonNull(requiredType, "requiredType");

        return ApplicationContextHolder.getBean(requiredType);
    }

    public static String id() {
        return ServerContext.self().getId();
    }

    public static String ip() {
        return ServerContext.self().getIp();
    }

    public static String name() {
        return ServerContext.self().getName();
    }

    public static int port() {
        return ServerContext.self().getPort();
    }

    public static String property(String key) {
        Java.requireNonNull(key, "key");

        return ServerContext.self().getEnv().getProperty(key);
    }

    public static void init(ConfigurableApplicationContext context) {
        ApplicationContextHolder.setContext(context);
        ServerContext.init(ApplicationContextHolder.getBean(Environment.class));
    }
}
