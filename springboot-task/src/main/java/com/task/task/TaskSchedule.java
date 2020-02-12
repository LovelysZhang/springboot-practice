package com.task.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务
 *
 * @author non human
 * on 2020/2/12
 */
@Slf4j
@Service
public class TaskSchedule {

    /**
     * second ,minute, hour, day of month, month ，day of week.
     * 秒，分，时，日，月，周几
     * eg: once per minute on weekdays
     */
    @Scheduled(cron = "0/10 * * * * MON-FRI")
    public void task() {
        log.info("定时任务已执行");
    }
}
