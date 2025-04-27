/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Jun 2, 2006
 */
package com.iba.framework.core.pojo.business;

import org.springframework.jms.core.JmsTemplate;

import com.iba.framework.core.exception.MessageException;
import com.iba.framework.core.util.JMessageCreator;
import com.iba.framework.core.vo.MessagePropertiesVO;

/**
 * @author S Sabarinathan
 */
public class MessageFacade {
	private JmsTemplate jmsTemplate;

	/**
	 * @return Returns the jmsTemplate.
	 */
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	/**
	 * @param jmsTemplate
	 *            The jmsTemplate to set.
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public final Object doMessage(Object clientMessage,
			MessagePropertiesVO properties) throws MessageException {
		jmsTemplate.setDeliveryPersistent(properties.isPersistentMode());
		if (properties.getQueueName() == null
				|| properties.getQueueName().equals(""))
			throw new MessageException("SRV_5000", "Queue name is missing.");
		jmsTemplate.setDefaultDestinationName(properties.getQueueName());
		jmsTemplate.setSessionTransacted(properties.isTransacted());
		jmsTemplate.setPriority(properties.getPriority());
		jmsTemplate.send(new JMessageCreator(clientMessage, properties));
		return null;
	}
}
