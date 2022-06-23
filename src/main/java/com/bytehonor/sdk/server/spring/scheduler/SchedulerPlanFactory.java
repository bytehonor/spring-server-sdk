package com.bytehonor.sdk.server.spring.scheduler;

import java.util.ArrayList;
import java.util.List;

import com.bytehonor.sdk.server.spring.scheduler.plan.SchedulerPlan;

/**
 * @author lijianqiang
 *
 */
public class SchedulerPlanFactory {

    private static final List<SchedulerPlan> LIST = new ArrayList<SchedulerPlan>(512);

    public static void put(SchedulerPlan plan) {
        if (plan != null) {
            LIST.add(plan);
        }
    }

    public static List<SchedulerPlan> plans() {
        return LIST;
    }

}
