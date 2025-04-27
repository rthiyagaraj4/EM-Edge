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
package com.iba.framework.core.vo;

import javax.jms.Message;

import com.iba.framework.core.util.Constants;

/**
 * @author S Sabarinathan
 * 
 */
public class MessagePropertiesVO {
	private boolean persistentMode = true; // Persistent or non-persitent

	private boolean transacted = false;

	private int priority = Message.DEFAULT_PRIORITY;

	private String queueName;

	private int messageType = Constants.OBJECT_MESSAGE;

	private String messageOwner;

	/**
	 * @return Returns the deliveryMode.
	 */
	public boolean isPersistentMode() {
		return persistentMode;
	}

	/**
	 * @param deliveryMode
	 *            The deliveryMode to set.
	 */
	public void setPersistentMode(boolean deliveryMode) {
		this.persistentMode = deliveryMode;
	}

	/**
	 * @return Returns the transacted.
	 */
	public boolean isTransacted() {
		return transacted;
	}

	/**
	 * @param transacted
	 *            The transacted to set.
	 */
	public void setTransacted(boolean transacted) {
		this.transacted = transacted;
	}

	/**
	 * @return Returns the priority.
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            The priority to set.
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return Returns the queue.
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * @param queue
	 *            The queue to set.
	 */
	public void setQueueName(String queue) {
		this.queueName = queue;
	}

	/**
	 * @return Returns the messageType.
	 */
	public int getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType
	 *            The messageType to set.
	 */
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return Returns the messageOriginatorClass.
	 */
	public String getMessageOwner() {
		return messageOwner;
	}

	/**
	 * @param messageOriginatorClass
	 *            The messageOriginatorClass to set.
	 */
	public void setMessageOwner(String messageOriginatorClass) {
		this.messageOwner = messageOriginatorClass;
	}
}
