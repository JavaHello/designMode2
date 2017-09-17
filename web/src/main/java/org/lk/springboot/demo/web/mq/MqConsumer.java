package org.lk.springboot.demo.web.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MqConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text){
        logger.info("mq 消息:{}", text);
    }
}
