package com.bytehonor.sdk.server.spring.scheduler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.lang.spring.thread.SafeRunner;
import com.bytehonor.sdk.server.spring.scheduler.plan.SchedulerPlan;

/**
 * @author lijianqiang
 *
 */
public class SchedulerPlanExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(SchedulerPlanExecutor.class);

    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(2);

    public static void run(final LocalDateTime ldt) {
        Objects.requireNonNull(ldt, "ldt");

        List<SchedulerPlan> plans = SchedulerPlanFactory.plans();
        if (plans.isEmpty()) {
            LOG.warn("plans isEmpty");
            return;
        }

        int accepts = 0;
        for (SchedulerPlan plan : plans) {
            if (plan.accept(ldt) == false) {
                continue;
            }
            put(plan.create(ldt));
            accepts++;
        }

        LOG.info("accepts:{}, plans:{}, ldt:{}", accepts, plans.size(), ldt);
    }

    private static void put(SafeRunner runner) {
        if (runner == null) {
            return;
        }
        SERVICE.execute(runner);
    }

}
