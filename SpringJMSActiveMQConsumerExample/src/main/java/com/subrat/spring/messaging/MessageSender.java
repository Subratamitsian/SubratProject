package com.subrat.spring.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.subrat.spring.model.InventoryResponse;
import com.subrat.spring.model.Product;

@Component
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;
 
    public void sendMessage(final InventoryResponse inventoryResponse) {
 
        jmsTemplate.send(new MessageCreator(){
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage(inventoryResponse);
                    return objectMessage;
                }
            });
    }

}
