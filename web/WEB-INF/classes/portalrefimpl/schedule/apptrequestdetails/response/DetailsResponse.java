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
package portalrefimpl.schedule.apptrequestdetails.response;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.common.response.BaseResponse;

/**
 * This is the response class having details of an appointment request.
 * This class extends BaseResponse
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name="AppointmentRequestDetail")
public class DetailsResponse extends BaseResponse {

	private String facilityId = null;
	
	private String facilityName = null;
	
	private String apptRequestReferenceNumber = null;

	private Date preferredDate = null;
	
	private String specialityCode = null;
	
	private String specialityName = null;
	
	private String careLocationTypeIndicator = null;
	
	private String locationCode = null;
	
	private String resourceClass = null;
	
	private String resourceId = null;
	
	private String resourceName = null;
	
	private String patientId = null;
	
	private String preferredFromTime = null;
	
	private String preferredToTime = null;
	
	/**
	 * @return the facilityId
	 */
	@XmlElement(name="FacilityId")
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
	 * @return the apptRequestReferenceNumber
	 */
	@XmlElement(name="ReferenceNumber")
	public String getApptRequestReferenceNumber() {
		return apptRequestReferenceNumber;
	}

	/**
	 * @param apptRequestReferenceNumber the apptRequestReferenceNumber to set
	 */
	public void setApptRequestReferenceNumber(String apptRequestReferenceNumber) {
		this.apptRequestReferenceNumber = apptRequestReferenceNumber;
	}

	/**
	 * @return the preferredDate
	 */
	@XmlElement(name="PreferredDate")
	public Date getPreferredDate() {
		return preferredDate;
	}

	/**
	 * @param preferredDate the preferredDate to set
	 */
	public void setPreferredDate(Date preferredDate) {
		this.preferredDate = preferredDate;
	}

	/**
	 * @return the specialityCode
	 */
	@XmlElement(name="SpecialityCode")
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
	 * @return the careLocationTypeIndicator
	 */
	@XmlElement(name="CareLocationTypeIndicator")
	public String getCareLocationTypeIndicator() {
		return careLocationTypeIndicator;
	}

	/**
	 * @param careLocationTypeIndicator the careLocationTypeIndicator to set
	 */
	public void setCareLocationTypeIndicator(String careLocationTypeIndicator) {
		this.careLocationTypeIndicator = careLocationTypeIndicator;
	}

	/**
	 * @return the locationCode
	 */
	@XmlElement(name="LocationCode")
	public String getLocationCode() {
		return locationCode;
	}

	/**
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	/**
	 * @return the resourceClass
	 */
	@XmlElement(name="ResourceClass")
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
	 * @return the resourceId
	 */
	@XmlElement(name="ResourceId")
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the patientId
	 */
	@XmlElement(name="PatientId")
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the preferredFromTime
	 */
	@XmlElement(name="PreferredFromTime")
	public String getPreferredFromTime() {
		return preferredFromTime;
	}

	/**
	 * @param preferredFromTime the preferredFromTime to set
	 */
	public void setPreferredFromTime(String preferredFromTime) {
		this.preferredFromTime = preferredFromTime;
	}

	/**
	 * @return the preferredToTime
	 */
	@XmlElement(name="PreferredToTime")
	public String getPreferredToTime() {
		return preferredToTime;
	}

	/**
	 * @param preferredToTime the preferredToTime to set
	 */
	public void setPreferredToTime(String preferredToTime) {
		this.preferredToTime = preferredToTime;
	}

	/**
	 * @return the facilityName
	 */
	@XmlElement(name="FacilityName")
	public String getFacilityName() {
		return facilityName;
	}

	/**
	 * @param facilityName the facilityName to set
	 */
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	/**
	 * @return the specialityName
	 */
	@XmlElement(name="SpecialtyName")
	public String getSpecialityName() {
		return specialityName;
	}

	/**
	 * @param specialityName the specialityName to set
	 */
	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

	/**
	 * @return the resourceName
	 */
	@XmlElement(name="ResourceName")
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	
}
