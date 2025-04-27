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
package portalrefimpl.schedule.createappointment.request;

import java.util.Calendar;
import java.util.Date;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;



/**
 * This is the request class for getting the list of practitioners
 * for a given speciality
 * @author GRamamoorthy
 *
 */
public class PractitionerRequest extends BaseRequest {

	/**
	 * data members in this class
	 */
	protected String facilityId = null;
	
	protected String specialityCode = null;
	
	protected String primarySpecialityCode = null;
	
	protected String practitionerType = null;
	
	protected String practitionerId = null;
	
	protected String practitionerName = null;
	
	protected String gender = null;
	
	protected String positionCode = null;
	
	protected String operationStandardId = null;
	
	protected String clinicCode = null;
	
	protected String visitType = null;
	
	protected String resourceClass = null;
	
	protected String preferredDateAsString = null;
	
	protected String preferredFromDateAsString = null;
	
	protected String preferredToDateAsString = null;
	
	protected String preferredStartTime = null;
	
	protected String preferredEndTime = null;
	
	protected String careLocationIndicator = null;
	
	protected String catalogCode = null;
	
	protected String specialityDesc = null;
	
	protected String facilityDesc = null;

	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}

	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	/**
	 * @return the specialityCode
	 */
	public String getSpecialityCode() {
		return specialityCode;
	}

	/**
	 * @param specialityCode the specialityCode to set
	 */
	public void setSpecialityCode(String specialityCode) {
		this.specialityCode = specialityCode;
	}

	/**
	 * @return the primarySpecialityCode
	 */
	public String getPrimarySpecialityCode() {
		return primarySpecialityCode;
	}

	/**
	 * @param primarySpecialityCode the primarySpecialityCode to set
	 */
	public void setPrimarySpecialityCode(String primarySpecialityCode) {
		this.primarySpecialityCode = primarySpecialityCode;
	}

	/**
	 * @return the practitionerType
	 */
	public String getPractitionerType() {
		return practitionerType;
	}

	/**
	 * @param practitionerType the practitionerType to set
	 */
	public void setPractitionerType(String practitionerType) {
		this.practitionerType = practitionerType;
	}

	/**
	 * @return the practitionerId
	 */
	public String getPractitionerId() {
		return practitionerId;
	}

	/**
	 * @param practitionerId the practitionerId to set
	 */
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
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

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the positionCode
	 */
	public String getPositionCode() {
		return positionCode;
	}

	/**
	 * @param positionCode the positionCode to set
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	/**
	 * @return the operationStandardId
	 */
	public String getOperationStandardId() {
		return operationStandardId;
	}

	/**
	 * @param operationStandardId the operationStandardId to set
	 */
	public void setOperationStandardId(String operationStandardId) {
		this.operationStandardId = operationStandardId;
	}

	/**
	 * @return the clinicCode
	 */
	public String getClinicCode() {
		return clinicCode;
	}

	/**
	 * @param clinicCode the clinicCode to set
	 */
	public void setClinicCode(String clinicCode) {
		this.clinicCode = clinicCode;
	}

	/**
	 * @return the visitType
	 */
	public String getVisitType() {
		return visitType;
	}

	/**
	 * @param visitType the visitType to set
	 */
	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	/**
	 * @return the resourceClass
	 */
	public String getResourceClass() {
		return resourceClass;
	}

	/**
	 * @param resourceClass the resourceClass to set
	 */
	public void setResourceClass(String resourceClass) {
		this.resourceClass = resourceClass;
	}

	/**
	 * @return the preferredStartTime
	 */
	public String getPreferredStartTime() {
		return preferredStartTime;
	}

	/**
	 * @param preferredStartTime the preferredStartTime to set
	 */
	public void setPreferredStartTime(String preferredStartTime) {
		this.preferredStartTime = preferredStartTime;
	}

	/**
	 * @return the preferredEndTime
	 */
	public String getPreferredEndTime() {
		return preferredEndTime;
	}

	/**
	 * @param preferredEndTime the preferredEndTime to set
	 */
	public void setPreferredEndTime(String preferredEndTime) {
		this.preferredEndTime = preferredEndTime;
	}

	/**
	 * @return the careLocationIndicator
	 */
	public String getCareLocationIndicator() {
		return careLocationIndicator;
	}

	/**
	 * @param careLocationIndicator the careLocationIndicator to set
	 */
	public void setCareLocationIndicator(String careLocationIndicator) {
		this.careLocationIndicator = careLocationIndicator;
	}

	/**
	 * @return the preferredDateAsString
	 */
	public String getPreferredFromDateAsString() {
		return preferredFromDateAsString;
	}

	/**
	 * @param preferredDateAsString the preferredDateAsString to set
	 */
	public void setPreferredFromDateAsString(String preferredFromDateAsString) {
		this.preferredFromDateAsString = preferredFromDateAsString;
	}

	/**
	 * @return the catalogCode
	 */
	public String getCatalogCode() {
		return catalogCode;
	}

	/**
	 * @param catalogCode the catalogCode to set
	 */
	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
	}

	/**
	 * @return the preferredToDateAsString
	 */
	public String getPreferredToDateAsString() {
		return preferredToDateAsString;
	}

	/**
	 * @param preferredToDateAsString the preferredToDateAsString to set
	 */
	public void setPreferredToDateAsString(String preferredToDateAsString) {
		this.preferredToDateAsString = preferredToDateAsString;
	}

	/**
	 * @return the preferredDateAsString
	 */
	public String getPreferredDateAsString() {
		return preferredDateAsString;
	}

	/**
	 * @param preferredDateAsString the preferredDateAsString to set
	 */
	public void setPreferredDateAsString(String preferredDateAsString) {
		this.preferredDateAsString = preferredDateAsString;
		// set the from date and to date as well
		this.preferredFromDateAsString = preferredDateAsString;
		// just initialize the to date string also to the preferred date
		// it will be overwritten below
		this.preferredToDateAsString = preferredDateAsString;
		Date endDate = PortalHelper
				.getDateFromString(
						preferredDateAsString,
						CreateAppointmentConstants.PRACTITIONER_SERVICE_PREFERRED_DATE_FORMAT);
		if(endDate != null){
			Calendar endCal = Calendar.getInstance();
			endCal.setTime(endDate);
			endCal.add(Calendar.DATE,
					CreateAppointmentConstants.BOOKAPPT_PREFERREDENDDATE_RANGE);
			this.preferredToDateAsString = PortalHelper
					.getDateAsString(
							endCal.getTime(),
							CreateAppointmentConstants.PRACTITIONER_SERVICE_PREFERRED_DATE_FORMAT);
		}
	}

	/**
	 * @return the specialityDesc
	 */
	public String getSpecialityDesc() {
		return specialityDesc;
	}

	/**
	 * @param specialityDesc the specialityDesc to set
	 */
	public void setSpecialityDesc(String specialityDesc) {
		this.specialityDesc = specialityDesc;
	}

	/**
	 * @return the facilityDesc
	 */
	public String getFacilityDesc() {
		return facilityDesc;
	}

	/**
	 * @param facilityDesc the facilityDesc to set
	 */
	public void setFacilityDesc(String facilityDesc) {
		this.facilityDesc = facilityDesc;
	}
	
	
	
}
