package com.subrat.spring.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.subrat.spring.model.InventoryResponse;
import com.subrat.spring.model.Product;
import com.subrat.spring.service.OrderService;

@Component
public class MessageReceiver implements MessageListener{

	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
	@Autowired
	MessageConverter messageConverter;
	@Autowired
	OrderService orderService;
	public void onMessage(Message message) {
		
		try {
			LOG.info("*****************************");
			Product product= (Product) messageConverter.fromMessage(message);
			
			LOG.info("Application: order response received: {}",product);
			
			orderService.processOrder(product);
			LOG.info("*****************************");
		} catch (MessageConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
