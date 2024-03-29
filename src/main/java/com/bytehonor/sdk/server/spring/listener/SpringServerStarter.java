package com.bytehonor.sdk.server.spring.listener;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.bytehonor.sdk.server.spring.context.ApplicationContextHolder;
import com.bytehonor.sdk.server.spring.context.ServerContext;
import com.bytehonor.sdk.server.spring.exception.ErrorConvertor;

/**
 * 服务初始化动作
 * 
 * @author lijianqiang
 *
 */
public class SpringServerStarter {

    private static final Logger LOG = LoggerFactory.getLogger(SpringServerStarter.class);

    public static void init(ConfigurableApplicationContext context) {
        Objects.requireNonNull(context, "context");

        LOG.info("context, id:{}", context.getId());

        ApplicationContextHolder.setContext(context);

        ServerContext.init(ApplicationContextHolder.getBean(Environment.class));

        try {
            ReadyListener listener = ApplicationContextHolder.getBean(ReadyListener.class);
            if (listener != null) {
                listener.onStart();
            } else {
                LOG.warn("ReadyListener null");
            }
        } catch (Exception e) {
            LOG.warn("ReadyListener:{}", ErrorConvertor.format(e));
        }
    }
}
