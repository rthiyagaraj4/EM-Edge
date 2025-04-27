/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.* ;
import javax.servlet.*;
import javax.servlet.http.*;

public class PatientContext implements java.io.Serializable {
	
	public HttpServletRequest request;
	public HttpSession session;	
	public String sFacilityId;
	public String sEncounterId;
	public String sPatientId;
	public String sClinicianId;
	public String sPracType;
	public String sLocale;
	public String sFromDate;
	public String sTodate;
	public String sPeriod;
	public String sEncounterCheck;
	public String sChartId;
	public String sAge;
	public String sGender;
	public String sDob;
	public String sPatientClass;
	public String loggedInUser;
	public String responsibilityID;
	
	
	
}
