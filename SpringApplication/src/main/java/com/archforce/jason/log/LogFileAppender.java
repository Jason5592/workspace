package com.archforce.jason.log;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

public class LogFileAppender extends DailyRollingFileAppender {

    @Override
    public boolean isAsSevereAsThreshold(Priority priority) {
        return this.getThreshold().equals(priority);
    }
}
