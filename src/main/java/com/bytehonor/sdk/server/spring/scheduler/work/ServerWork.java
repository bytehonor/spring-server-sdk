package com.bytehonor.sdk.server.spring.scheduler.work;

import java.util.ArrayList;
import java.util.List;

import com.bytehonor.sdk.lang.spring.Java;

public final class ServerWork implements SpringWork {

    private final List<SpringWorkTask> tasks;
    
    public ServerWork() {
        this.tasks = new ArrayList<SpringWorkTask>();
    }

    @Override
    public List<SpringWorkTask> tasks() {
        return tasks;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
    
    public ServerWork add(SpringWorkTask task) {
        Java.requireNonNull(task, "task");

        tasks.add(task);
        return this;
    }
}
