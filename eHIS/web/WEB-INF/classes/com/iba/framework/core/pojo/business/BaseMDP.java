/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Jun 5, 2006
 */
package com.iba.framework.core.pojo.business;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.iba.framework.core.util.Constants;

/**
 * Abstract Base Message Driven POJO
 * 
 * @author S Sabarinathan
 * @spring.property name="connectionProperty" ref="jmsFactory"
 * @spring.property name="destination" ref="defautlt"
 * @spring.property name="sessionTransacted" value="true"
 * @spring.property name="transactionManager" ref="jmsTransactionManager"
 * 
 */

public abstract class BaseMDP extends DefaultMessageListenerContainer implements
		MessageListener {
	public final void onMessage(Message oMessage) {
		try {
			System.out.println("Message Owner : "
					+ oMessage.getStringProperty("messageOwner"));
			switch (oMessage.getIntProperty("messageType")) {
			case Constants.TEXT_MESSAGE:
				processTextMessage(((TextMessage) oMessage).getText());
				break;
			case Constants.OBJECT_MESSAGE:
				processObjectMessage(((ObjectMessage) oMessage).getObject());
				break;
			case Constants.MAP_MESSAGE:
				// TODO Testing has to be done
				MapMessage mapMessage = (MapMessage) oMessage;
				Enumeration enumeration = mapMessage.getMapNames();
				Map oMap = new HashMap();
				String key = null;
				while (enumeration.hasMoreElements()) {
					key = enumeration.nextElement().toString();
					oMap.put(key, mapMessage.getObject(key));
				}
				processMapMessage(oMap);
				break;
			case Constants.BYTE_MESSAGE:
				// TODO will be implemented later
				break;
			default:

			}
		} catch (JMSException e) {
			System.err.println("Message Type Required");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public abstract void processMapMessage(Map map);

	public abstract void processTextMessage(String text);

	public abstract void processObjectMessage(Serializable object);
}
