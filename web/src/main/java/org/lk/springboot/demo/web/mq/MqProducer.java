package org.lk.springboot.demo.web.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class MqProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Bean(name = "sampleQueue")
    public Destination sample(){
        return new ActiveMQQueue("sample.queue");
    }

    @Autowired
    @Qualifier("sampleQueue")
    private Destination destination;

    @Scheduled(fixedDelay=1000000)//每10s执行1次
    public void send() {
        this.jmsMessagingTemplate.convertAndSend(destination, "hi,activeMQ");
    }
}
