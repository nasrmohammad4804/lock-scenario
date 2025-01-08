package com.nasr.shedlock.tasks;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DailyNotificationTask implements Task<Void> {

    @Value("${instance.identifier}")
    private String identifier;

    @Scheduled(cron = "0 0 0 * * ?")
    @SchedulerLock(lockAtLeastFor = "1m", name = "dailyNotificationTask")
    public Optional<Void> doTask() {

        System.out.println("send notification from identifier: " + identifier);
        return Optional.empty();
    }
}
