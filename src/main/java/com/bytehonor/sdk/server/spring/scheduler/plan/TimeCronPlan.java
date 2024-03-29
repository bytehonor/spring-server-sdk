package com.bytehonor.sdk.server.spring.scheduler.plan;

import java.time.LocalDateTime;
import java.util.List;

import com.bytehonor.sdk.server.spring.scheduler.time.TimeCron;
import com.bytehonor.sdk.server.spring.scheduler.time.TimeGroupPrinter;

/**
 * @author lijianqiang
 *
 */
public abstract class TimeCronPlan implements TimePlan {

    public abstract List<TimeCron> crons();

    @Override
    public final boolean accept(LocalDateTime ldt) {
        List<TimeCron> crons = crons();
        // 没有配置的则false
        if (crons == null || crons.isEmpty()) {
            return false;
        }

        for (TimeCron cron : crons) {
            if (cron.match(ldt)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void print() {
        TimeGroupPrinter.print(crons());
    }

}
