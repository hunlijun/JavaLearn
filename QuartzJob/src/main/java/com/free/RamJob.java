package com.free;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class RamJob implements Job {
    private static Logger _log = LoggerFactory.getLogger(RamJob.class);


    public void execute(JobExecutionContext context) throws JobExecutionException {
        _log.info("Say hello to Quartz" + new Date());
    }
}
