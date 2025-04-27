/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portalrefimpl.schedule.upcomingappointments.svc;

import org.w3c.dom.Document;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.serviceinvoker.XMLReaderIdentifier;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.schedule.upcomingappointments.request.UpcomingAppointmentsRequest;
import portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentsResponse;

public class UpcomingAppointmentsServiceInvoker extends AbstractServiceInvoker {

	public UpcomingAppointmentsServiceInvoker() {
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}

	
	/**
	 * Get the webservice url
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper.getWebServiceURL(PortalConstants.UPCOMINGAPPOINTMENTDETAILS_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * form the url parameters from the request object
	 */
	public String getURLParameters(BaseRequest request) {
		UpcomingAppointmentsRequest upcomingAppointmentsRequest = (UpcomingAppointmentsRequest) request;
		String patientId = request.getPatientId();
		if (patientId == null) {
			patientId = "";
		}
		String params = "patientId=" + patientId;

		int startRecordNum = upcomingAppointmentsRequest.getStartRecordNum();
		if (startRecordNum != 0)
			params += "&startRecordNum=" + startRecordNum;
		else
			params += "&startRecordNum=";
		int endRecordNum = upcomingAppointmentsRequest.getEndRecordNum();
		if (endRecordNum != 0)
			params += "&endRecordNum=" + endRecordNum;
		else
			params += "&endRecordNum=";
		String facilityId = upcomingAppointmentsRequest.getFacilityId();
		if (facilityId == null)
			facilityId = "";
		params += "&facilityId=" + facilityId;
		String fromDate = upcomingAppointmentsRequest.getFromDate();
		if (fromDate == null)
			fromDate = "";
		params += "&fromDate=" + fromDate;
		String toDate = upcomingAppointmentsRequest.getToDate();
		if (toDate == null)
			toDate = "";
		params += "&toDate=" + toDate;
		return params;
	}

	/**
	 * 
	 */
	public BaseResponse getResponseObject() {
		return new UpcomingAppointmentsResponse();
	}

	/**
	 * 
	 */
	public void readXMLContent(Document document, BaseResponse response) {
		// This method need not be implemented when we are doing JAXB
		// unmarshalling This method is implemented merely to satisfy the
		// contract

	}

	/**
	 * This method returns an instance of the impl class
	 * used for performing the business operation 
	 */
	protected BaseService getServiceImpl() {
		return new UpcomingAppointmentsSvcImpl();
	}
	
	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public UpcomingAppointmentsResponse getDataThroughService(UpcomingAppointmentsRequest request){
		UpcomingAppointmentsSvcImpl svcImpl = new UpcomingAppointmentsSvcImpl();
		return svcImpl.getUpcomingAppointmentDetails(request);
	}

}
