/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blHcard;

import java.io.Serializable;


public class HealthCardCashBillingGroupBean implements
		Serializable {
	
	private static final long serialVersionUID = 1L;
	String blngGrpId=new String();
	String blngGroupdescription=new String();
	
	public String getBlngGrpId() {
		return blngGrpId;
	}
	public void setBlngGrpId(String blngGrpId) {
		this.blngGrpId = blngGrpId;
	}	
	public String getBlngGroupdescription() {
		return blngGroupdescription;
	}
	public void setBlngGroupdescription(String blngGroupdescription) {
		this.blngGroupdescription = blngGroupdescription;
	}
	
	public String toString(){
		return "{blngGrpId=" + blngGrpId 
				+ ",blngGroupdescription=" + blngGroupdescription
				+ "}";
	}
	
	public boolean equals(HealthCardCashBillingGroupBean paramBean) {
		if (this.getBlngGrpId().equals(paramBean.getBlngGrpId())) {
				return true;
			}
		return false;
	}

	public int hashCode() {
		return this.blngGrpId.hashCode();
	}
			
}
