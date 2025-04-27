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

public class HealthCardVisitRuleBean  implements
		Serializable {
	
	private static final long serialVersionUID = 1L;
	

	String clinicCode=new String();
	String visitTypeCode=new String();
	String noOfVisitsAllowed=new String();
	String clinicSelected=new String();
	String clinicCodeDescription=new String();
	String visitTypeDescription=new String();	

	public String getClinicCode() {
		return clinicCode;
	}
	public void setClinicCode(String clinicCode) {
		this.clinicCode = clinicCode;
	}
	public String getVisitTypeCode() {
		return visitTypeCode;
	}
	public void setVisitTypeCode(String visitTypeCode) {
		this.visitTypeCode = visitTypeCode;
	}
	public String getNoOfVisitsAllowed() {
		return noOfVisitsAllowed;
	}
	public void setNoOfVisitsAllowed(String noOfVisitsAllowed) {
		this.noOfVisitsAllowed = noOfVisitsAllowed;
	}
	public String getClinicSelected() {
		return clinicSelected;
	}
	public void setClinicSelected(String clinicSelected) {
		this.clinicSelected = clinicSelected;
	}
	public String getClinicCodeDescription() {
		return clinicCodeDescription;
	}
	public void setClinicCodeDescription(String clinicCodeDescription) {
		this.clinicCodeDescription = clinicCodeDescription;
	}
	public String getVisitTypeDescription() {
		return visitTypeDescription;
	}
	public void setVisitTypeDescription(String visitTypeDescription) {
		this.visitTypeDescription = visitTypeDescription;
	}

	
	public String toString(){
		return "{clinicCode=" + clinicCode 
				+ ",visitTypeCode=" + visitTypeCode
				+ ",noOfVisitsAllowed=" + noOfVisitsAllowed
				+ ",clinicSelected=" + clinicSelected 
				+ ",clinicCodeDescription=" + clinicCodeDescription 
				+ ",visitTypeDescription=" + visitTypeDescription 
				+ "}";
	}
	
	public boolean equals(HealthCardVisitRuleBean paramBean) {
		if (this.getClinicCode().equals(paramBean.getClinicCode())
			&& this.getVisitTypeCode().equals(paramBean.getVisitTypeCode())		
			&& this.getNoOfVisitsAllowed().equals(paramBean.getNoOfVisitsAllowed())			
			&& this.getClinicSelected().equals(paramBean.getClinicSelected())) {
				return true;
			}
		return false;
	}

	public int hashCode() {
		return this.clinicCode.hashCode() + this.visitTypeCode.hashCode() + this.noOfVisitsAllowed.hashCode();
	}

}
