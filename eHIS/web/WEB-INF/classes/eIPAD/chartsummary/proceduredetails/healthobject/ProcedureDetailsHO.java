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
package eIPAD.chartsummary.proceduredetails.healthobject;

/**
 * @author GaneshkumarC 
 * This class is used to hold the procedure details record
 */
public class ProcedureDetailsHO implements java.io.Serializable {
	private String procedureCode;
	private String procedureDescription;
	private String procedureDateTime;
	private String endDateTime;
	private String status;
	private String procedureCodeScheme;
	private String practitionerName;
	/**
	 * @return the procedureCode
	 */
	public String getProcedureCode() {
		return procedureCode;
	}
	/**
	 * @param procedureCode the procedureCode to set
	 */
	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	/**
	 * @return the procedureDescription
	 */
	public String getProcedureDescription() {
		return procedureDescription;
	}
	/**
	 * @param procedureDescription the procedureDescription to set
	 */
	public void setProcedureDescription(String procedureDescription) {
		this.procedureDescription = procedureDescription;
	}
	/**
	 * @return the procedureDateTime
	 */
	public String getProcedureDateTime() {
		return procedureDateTime;
	}
	/**
	 * @param procedureDateTime the procedureDateTime to set
	 */
	public void setProcedureDateTime(String procedureDateTime) {
		this.procedureDateTime = procedureDateTime;
	}
	/**
	 * @return the endDateTime
	 */
	public String getEndDateTime() {
		return endDateTime;
	}
	/**
	 * @param endDateTime the endDateTime to set
	 */
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the procedureCodeScheme
	 */
	public String getProcedureCodeScheme() {
		return procedureCodeScheme;
	}
	/**
	 * @param procedureCodeScheme the procedureCodeScheme to set
	 */
	public void setProcedureCodeScheme(String procedureCodeScheme) {
		this.procedureCodeScheme = procedureCodeScheme;
	}
	/**
	 * @return the practitionerName
	 */
	public String getPractitionerName() {
		return practitionerName;
	}
	/**
	 * @param practitionerName the practitionerName to set
	 */
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}


}
