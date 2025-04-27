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
package eIPAD.DiaryView.response;

import java.util.ArrayList;

import eIPAD.DiaryView.healthobject.OTProcDetail;

/**
 * @author vchoughule 
 *
 */
public class OTProcDetailResponse {
	ArrayList<OTProcDetail> otProcDetailList = new ArrayList<OTProcDetail>();

	/**
	 * @return the otProcDetailList
	 */
	public ArrayList<OTProcDetail> getOtProcDetailList() {
		return otProcDetailList;
	}

	/**
	 * @param otProcDetailList the otProcDetailList to set
	 */
	public void setOtProcDetailList(ArrayList<OTProcDetail> otProcDetailList) {
		this.otProcDetailList = otProcDetailList;
	}
	

}
