package com.bytehonor.sdk.server.spring.scheduler.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.lang.spring.string.SpringString;
import com.bytehonor.sdk.lang.spring.thread.SafeTask;
import com.bytehonor.sdk.lang.spring.thread.ScheduleTaskPoolExecutor;

/**
 * 循环执行的任务
 */
public abstract class SpringWorkTask extends SafeTask  {

    private static final Logger LOG = LoggerFactory.getLogger(SpringWorkTask.class);

    /**
     * 循环间隔毫秒数
     * 
     * @return
     */
    public abstract long intervalMillis();

    public final void start() {
        long intervals = intervalMillis();
        LOG.info("start {}, intervals:{}", thisName(), intervals);
        ScheduleTaskPoolExecutor.schedule(this, 100L, intervals);
    }

    private String thisName() {
        String name = this.getClass().getSimpleName();
        if (SpringString.isEmpty(name)) {
            name = "Anonymous";
        }
        return name;
    }
}
