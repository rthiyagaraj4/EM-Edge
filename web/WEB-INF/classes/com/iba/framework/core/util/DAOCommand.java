/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package com.iba.framework.core.util;

/**
 * @author ParimalaK
 * 
 */
public class DAOCommand implements Command {

	// private int action ;

	private Object object;

	private String entityName;

	private Class entityClass;

	public Class getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}

	public DAOCommand() {

	}

	/*
	 * public int getAction() { return this.action; } public void setAction(int
	 * action) { this.action = action; }
	 */
	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public DAOCommand(Object object, String entityName) {
		super();
		this.object = object;
		this.entityName = entityName;
	}
}
