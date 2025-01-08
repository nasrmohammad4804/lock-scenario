package com.nasr.shedlock.tasks;

import java.util.Optional;

public interface Task<T> {

    Optional<T> doTask();
}
