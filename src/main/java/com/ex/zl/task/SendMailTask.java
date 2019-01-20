package com.ex.zl.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendMailTask {

    @Scheduled(cron="0 0 9 * * ?")
    private void process(){

    }
}
