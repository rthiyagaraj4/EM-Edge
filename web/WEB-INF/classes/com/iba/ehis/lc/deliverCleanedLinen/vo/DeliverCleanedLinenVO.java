/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.deliverCleanedLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADateTime;

public class DeliverCleanedLinenVO extends LcVO {
	
	/* Declaration of DeliverCleanedLinen variables for the VO  */
	
	private String requestNum;
	private String deliveryRefNum;

	private String requestDate;
	private String deliveryDate;
	private String requestStatus;
	private String operatingFaciltyId;
	private String linenItem;
	private String linenDesc;
	private String sourceType;
	private String sourceCode;
	
	private String linenHandedOverBy;
	private String linenCollectedBy;
		
	

	private AutoGenerationList linenDeliverList;

	
	/* Generated getter and setter metods of the above variables */
	



	public DeliverCleanedLinenVO() {
		linenDeliverList = new AutoGenerationList(LinenDeliverList.class);
	}

	
	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(String requestNum) {
		this.requestNum = requestNum;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	
	public String getDeliveryDate() {
		return deliveryDate;
	}



	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



	public String getLinenCollectedBy() {
		return linenCollectedBy;
	}



	public void setLinenCollectedBy(String linenCollectedBy) {
		this.linenCollectedBy = linenCollectedBy;
	}



	public String getLinenHandedOverBy() {
		return linenHandedOverBy;
	}



	public void setLinenHandedOverBy(String linenHandedOverBy) {
		this.linenHandedOverBy = linenHandedOverBy;
	}



	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}


	public AutoGenerationList getLinenDeliverList() {
		return linenDeliverList;
	}


	public void setLinenDeliverList(AutoGenerationList linenDeliverList) {
		this.linenDeliverList = linenDeliverList;
	}


	public String getDeliveryRefNum() {
		return deliveryRefNum;
	}


	public void setDeliveryRefNum(String deliveryRefNum) {
		this.deliveryRefNum = deliveryRefNum;
	}


	public String getRequestStatus() {
		return requestStatus;
	}


	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}


	public String getOperatingFaciltyId() {
		return operatingFaciltyId;
	}


	public void setOperatingFaciltyId(String operatingFaciltyId) {
		this.operatingFaciltyId = operatingFaciltyId;
	}


	public String getLinenDesc() {
		return linenDesc;
	}


	public void setLinenDesc(String linenDesc) {
		this.linenDesc = linenDesc;
	}

}
