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
package eIPAD.DiaryView.healthobject;

import java.util.ArrayList;

/**
 * @author vchoughule 
 *
 */
public class OTProcDetail {
	private String procDesc ;
	private String operCode ;

	/**
	 * @return the procDesc
	 */
	public String getProcDesc() {
		return procDesc;
	}

	/**
	 * @param procDesc the procDesc to set
	 */
	public void setProcDesc(String procDesc) {
		this.procDesc = procDesc;
	}

	/**
	 * @return the operCode
	 */
	public String getOperCode() {
		return operCode;
	}

	/**
	 * @param operCode the operCode to set
	 */
	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

}
