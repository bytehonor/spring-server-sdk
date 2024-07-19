package com.bytehonor.sdk.server.spring.work;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.lang.spring.constant.TimeConstants;
import com.bytehonor.sdk.lang.spring.thread.SafeTask;
import com.bytehonor.sdk.lang.spring.thread.Sleep;

public class ScheduleWorkPoolExecutorTest {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduleWorkPoolExecutorTest.class);

    @Test
    public void test() {
        // nThreads = 1 就得排队
        ScheduleWorkPoolExecutor.schedule(new SafeTask() {

            @Override
            public void runInSafe() {
                LOG.info("task1 begin");
                Sleep.millis(1000L);
                LOG.info("task1 end");
            }

        }, 1000L, TimeConstants.MINUTE);

        ScheduleWorkPoolExecutor.schedule(new SafeTask() {

            @Override
            public void runInSafe() {
                LOG.info("task2 begin");
                Sleep.millis(2000L);
                LOG.info("task2 end");
            }

        }, 1000L, TimeConstants.MINUTE);

        ScheduleWorkPoolExecutor.schedule(new SafeTask() {

            @Override
            public void runInSafe() {
                LOG.info("task3 begin");
                Sleep.millis(3000L);
                LOG.info("task3 end");
            }

        }, 1000L, TimeConstants.MINUTE);

        ScheduleWorkPoolExecutor.schedule(new SafeTask() {

            @Override
            public void runInSafe() {
                LOG.info("task4 begin");
                Sleep.millis(4000L);
                LOG.info("task4 end");
            }

        }, 1000L, TimeConstants.MINUTE);

        Sleep.millis(TimeConstants.HOUR);
    }

}
