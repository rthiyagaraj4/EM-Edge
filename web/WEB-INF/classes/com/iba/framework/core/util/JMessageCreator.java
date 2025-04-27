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
package com.iba.framework.core.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

import com.iba.framework.core.exception.SystemException;
import com.iba.framework.core.vo.MessagePropertiesVO;

/**
 * @author S Sabarinathan
 * 
 */
public class JMessageCreator implements MessageCreator {
	private final Object oMessage;

	private final MessagePropertiesVO props;

	public JMessageCreator(Object oMessage, MessagePropertiesVO props) {
		this.oMessage = oMessage;
		this.props = props;
	}

	public Message createMessage(Session session) throws JMSException {
		Message outMessage = null;
		switch (props.getMessageType()) {
		case Constants.OBJECT_MESSAGE:
			if (!(oMessage instanceof Serializable))
				throw new SystemException("SRV_5000",
						"Object is not serialized.");
			outMessage = session.createObjectMessage((Serializable) oMessage);
			break;
		case Constants.TEXT_MESSAGE:
			outMessage = session.createTextMessage((String) oMessage);
			break;
		case Constants.MAP_MESSAGE:
			MapMessage mapMessage = session.createMapMessage();
			Map inMapMessage = (Map) oMessage;
			Iterator iterator = inMapMessage.keySet().iterator();
			String key = null;
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				mapMessage.setObject(key, inMapMessage.get(key));
			}
			outMessage = mapMessage;
			break;
		case Constants.BYTE_MESSAGE:
			// TODO
			break;
		default:
			throw new SystemException("SRV_5000", "Invalid message type.");
		}
		outMessage.setStringProperty("messageOwner", props.getMessageOwner());
		outMessage.setIntProperty("messageType", props.getMessageType());
		return outMessage;
	}
}
