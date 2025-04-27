/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.Common;

public class InsufficientBatchException extends Exception{

	public InsufficientBatchException ( String message){
		super(message);
	}

	public InsufficientBatchException (){
		super("APP-ST0043 Insufficient batch quantity");
	}
	
	public InsufficientBatchException (int availableQuantity){
		super("APP-ST0043 Insufficient batch quantity");
		this.availableQuantity=availableQuantity;
	}

	public int getAvailableQuantity(){
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity){
		this.availableQuantity=availableQuantity;
	}

	private int availableQuantity=0;
}
