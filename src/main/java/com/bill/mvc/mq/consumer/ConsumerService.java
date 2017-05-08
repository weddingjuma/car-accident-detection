package com.bill.mvc.mq.consumer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by chenking on 2017/5/6.
 */
@Service(value = "consumerservice")
public class ConsumerService {
    @Resource(name = "jmsQueuetemplate")
    private JmsTemplate jmsTemplate;

    /*
    接受消息
    *
    * */
    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);

        System.out.println("from queue " + destination.toString() + " receive message");


        return tm;

    }

}
