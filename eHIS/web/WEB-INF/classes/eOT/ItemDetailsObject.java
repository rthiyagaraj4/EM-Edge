/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import java.io.Serializable;

import eOT.Common.OTAdapter;

public class ItemDetailsObject extends OTAdapter implements Serializable 
{

	private static final long serialVersionUID = 1L;
	
	private String itemCode = "";
	private String itemQuantity = "";
	private String requestedDate = "";
	private String cancel = "";
	private String cancelledRemark = "";
	private String itemSpecRemark = "";

	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public String getCancelledRemark() {
		return cancelledRemark;
	}
	public void setCancelledRemark(String cancelledRemark) {
		this.cancelledRemark = cancelledRemark;
	}
	public String getItemSpecRemark() {
		return itemSpecRemark;
	}
	public void setItemSpecRemark(String itemSpecRemark) {
		this.itemSpecRemark = itemSpecRemark;
	}
	
}
