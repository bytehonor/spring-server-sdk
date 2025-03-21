package com.bytehonor.sdk.server.spring.pool;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.lang.spring.thread.SafeTask;
import com.bytehonor.sdk.lang.spring.thread.SpringTaskPoolExecutor;

public class SpringTaskPoolExecutorTest {

    private static final Logger LOG = LoggerFactory.getLogger(SpringTaskPoolExecutorTest.class);

    @Test
    public void test() {
        SpringTaskPoolExecutor.put(new SafeTask() {

            @Override
            public void runInSafe() {
                LOG.info("111");
            }

        });

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            LOG.error("sleep", e);
        }

        SpringTaskPoolExecutor.put(new SafeTask() {

            @Override
            public void runInSafe() {
                LOG.info("222");
            }

        });

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            LOG.error("sleep", e);
        }
    }

}
