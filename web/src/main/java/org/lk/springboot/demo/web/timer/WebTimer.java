package org.lk.springboot.demo.web.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebTimer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 每５秒跑一次
     */
    @Scheduled(cron = "0/5 * 9-10 * * ?")
    public void excuteTask(){
        logger.info("定时任务");
    }
}
