/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.util;

public final class DTO {
	private int status = 0;

	private Throwable exception = null;

	private String messageId = null;

	private Object object = null;

	private String target = null;

	private Page page;

	private int mode;

	public DTO() {

	}

	public Throwable getException() {
		return this.exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String message) {
		this.messageId = message;
	}

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public boolean hasGotException() {
		return exception != null ? true : false;
	}

	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[Status:");
		sb.append(status);
		sb.append(", Object:");
		sb.append(object);
		sb.append(", Exception:");
		sb.append(exception);
		sb.append(", Message Id:");
		sb.append(messageId);
		return sb.toString();
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
}
