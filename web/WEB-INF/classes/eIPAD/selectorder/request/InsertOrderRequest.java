/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.request;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import eIPAD.selectorder.healthobject.*;



public class InsertOrderRequest {

	private ArrayList<InsertOrderHO> insertOrderHOArrayList;
	private HttpServletRequest httpRequest;
	/**
	 * @return the insertOrderHOArrayList
	 */
	public ArrayList<InsertOrderHO> getInsertOrderHOArrayList() {
		return insertOrderHOArrayList;
	}
	/**
	 * @param insertOrderHOArrayList the insertOrderHOArrayList to set
	 */
	public void setInsertOrderHOArrayList(ArrayList<InsertOrderHO> insertOrderHOArrayList) {
		this.insertOrderHOArrayList = insertOrderHOArrayList;
	}
	/**
	 * @return the httpRequest
	 */
	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}
	/**
	 * @param httpRequest the httpRequest to set
	 */
	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}





	
}
