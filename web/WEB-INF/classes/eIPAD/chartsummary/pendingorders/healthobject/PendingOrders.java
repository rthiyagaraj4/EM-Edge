/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.pendingorders.healthobject;
import java.util.*;
public class PendingOrders implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderCategory;
	private String orderCategoryDescription;
	private List<PendingOrderItems> pendingOrderItemList;
	private int listCount;
	/**
	 * @return the orderCategory 
	 */
	public String getOrderCategory() {
		return orderCategory;
	}
	/**
	 * @param orderCategory the orderCategory to set
	 */
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	/**
	 * @return the orderCategoryDescription
	 */
	public String getOrderCategoryDescription() {
		return orderCategoryDescription;
	}
	/**
	 * @param orderCategoryDescription the orderCategoryDescription to set
	 */
	public void setOrderCategoryDescription(String orderCategoryDescription) {
		this.orderCategoryDescription = orderCategoryDescription;
	}
	/**
	 * @return the pendingOrderItemList
	 */
	public List<PendingOrderItems> getPendingOrderItemList() {
		return pendingOrderItemList;
	}
	/**
	 * @param pendingOrderItemList the pendingOrderItemList to set
	 */
	public void setPendingOrderItemList(List<PendingOrderItems> pendingOrderItemList) {
		this.pendingOrderItemList = pendingOrderItemList;
	}
	/**
	 * @return the listCount
	 */
	public int getListCount() {
		return listCount;
	}
	/**
	 * @param listCount the listCount to set
	 */
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof PendingOrders)
		{
			PendingOrders oPendingOrders = (PendingOrders)obj;
			if(this.orderCategory != null && this.orderCategory.equals(oPendingOrders.getOrderCategory()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	public int hashCode() {
		return this.orderCategory.hashCode();
	}
}
