package com.bill.mvc.mq.producter;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.Des;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.File;

/**
 * Created by chenking on 2017/5/6.
 */
@Service(value = "producerservice")
public class ProducerService {
    @Resource(name="jmsQueuetemplate")
    private JmsTemplate jmsTemplate;

    /*
    * 向指定队列发送消息
    * */
    public void sendMessage(Destination destination,final String msg){
        System.out.println("send message "+destination.toString()+" message"+msg);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {


                return session.createTextMessage(msg);
            }
        });
    }
    /*
    *
    * send streammessage
    * */
    public void sendMessage(Destination destination,final byte[] msg){
        System.out.println("send stream message bytes");
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                BytesMessage byteMessage=session.createBytesMessage();
               byteMessage.writeBytes(msg);
                return byteMessage;
            }
        });
    }
    /*
    * send sreammessage
    * */
    public void sendMessage(Destination destination,final File file){
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {

                return session.createObjectMessage(file);
            }
        });
    }

    /*
    * 向着默认队列发送消息
    * */
    public void sendMessage(final String msg){
        Destination destination=jmsTemplate.getDefaultDestination();
        sendMessage(destination,msg);
    }


}
