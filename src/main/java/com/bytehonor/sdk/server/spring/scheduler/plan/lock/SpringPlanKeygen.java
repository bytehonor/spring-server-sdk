package com.bytehonor.sdk.server.spring.scheduler.plan.lock;

import java.time.LocalDateTime;

import com.bytehonor.sdk.lang.spring.Java;
import com.bytehonor.sdk.lang.spring.constant.DateConstants;
import com.bytehonor.sdk.lang.spring.util.TimeFormatUtils;

/**
 * @author lijianqiang
 *
 */
public class SpringPlanKeygen {

    public static String make(String prefix, LocalDateTime ldt) {
        Java.requireNonNull(prefix, "prefix");
        Java.requireNonNull(ldt, "ldt");

        return new StringBuilder().append(prefix).append(":").append(time(ldt)).toString();
    }

    public static String make(String prefix, long time) {
        Java.requireNonNull(prefix, "prefix");

        return make(prefix, TimeFormatUtils.fromTimestamp(time));
    }

    private static String time(LocalDateTime ldt) {
        return ldt.format(DateConstants.YYYY_MM_DD_HH_MM);
    }
}
