package com.bytehonor.sdk.server.spring.start;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.bytehonor.sdk.server.spring.config.ServerConfig;
import com.bytehonor.sdk.server.spring.context.ApplicationContextHolder;

public class SpringServerStarter {

    public static void init(ConfigurableApplicationContext context) {
        ApplicationContextHolder.setContext(context);

        ServerConfig.init(ApplicationContextHolder.getBean(Environment.class));

        List<SpringServerListener> listeners = SpringServerListenerFactory.list();
        for (SpringServerListener listener : listeners) {
            listener.onStart();
        }
    }
}
