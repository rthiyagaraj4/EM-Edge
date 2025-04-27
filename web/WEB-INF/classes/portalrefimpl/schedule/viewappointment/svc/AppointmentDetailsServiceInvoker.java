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
package portalrefimpl.schedule.viewappointment.svc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetails;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse;

/**
 * This is the client class for the appointment details servoce
 * @author GRamamoorthy
 *
 */
public class AppointmentDetailsServiceInvoker extends AbstractServiceInvoker {

	/**
	 * This method returns the HTTP base URL for the underlying service
	 * @param request
	 * @return
	 */
	public String getWebServiceURL(BaseRequest request) {
		String urlString = PortalHelper
				.getWebServiceURL(PortalConstants.APPOINTMENTDETAILS_WS_URL_KEY);
		return urlString;
	}

	/**
	 * This method gets the URL parameters for the underlying service
	 * The URL parameters will be appended to the base HTTP URL
	 * of the underlying service
	 * @param request
	 * @return
	 */
	public String getURLParameters(BaseRequest request) {
		StringBuffer parameterBuffer = new StringBuffer();
		// first patient id
		String patientId = request.getPatientId();
		if(patientId == null){
			patientId = "";
		}
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PATIENTID_REQUEST_PARAM_KEY, patientId));
		parameterBuffer.append("&");
		// safely cast
		AppointmentDetailsRequest apptDetailsRequest = (AppointmentDetailsRequest)request;
		// now record count
		int recordCount = apptDetailsRequest.getRecordCount();
		if(recordCount <= 0){
			recordCount = PortalConstants.HOMEPAGE_APPOINTMENTLIST_RECORDCOUNT;
		}
		parameterBuffer
				.append(getCompleteParamString(
						ScheduleConstants.APPOINTMENT_DETAILS_RECORDCOUNT_REQUEST_PARAM_KEY,
						""+recordCount));
		parameterBuffer.append("&");
		// portal user name
		String portalUserName = request.getPortalUserName();
		if(portalUserName == null){
			portalUserName = "";
		}
		
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY, portalUserName));
		
		return parameterBuffer.toString();
	}

	/**
	 * This method returns an instance of the response
	 * object used in the underlying service
	 * @return
	 */
	public BaseResponse getResponseObject() {
		return new AppointmentDetailsResponse();
	}

	/**
	 * This method reads the XML  obtained from the web service
	 * and populates data in the response object
	 * @param document
	 * @param response
	 */
	public void readXMLContent(Document doc, BaseResponse response) {
		AppointmentDetailsResponse appointmentDetailsResponse = (AppointmentDetailsResponse) response;
		List<AppointmentDetails> appointmentDetailsList = new ArrayList<AppointmentDetails>();
		
		String rootElement = doc.getDocumentElement().getNodeName();
		if (AppointmentDetailConstant.APPOINTMENTDETAILS_KEY
				.equalsIgnoreCase(rootElement)) {
			NodeList appointmentDetailNodes = doc
					.getElementsByTagName(AppointmentDetailConstant.APPOINTMENTDETAIL_KEY);
			int detailNodesLen = appointmentDetailNodes != null ? appointmentDetailNodes
					.getLength() : 0;
			Node appointmentDetailNode = null;

			AppointmentDetails appointmentDetails = null;
			String practitioner = null;
			String speciality = null;
			Date appointmentStartTime = null;
			Date appointmentEndTime = null;
			Date appointmentDate = null;
			long apptStart = 0;
			long apptEnd = 0;
			long apptDateLong = 0;
			String apptStartStr = null;
			String apptEndStr = null;
			String apptDateStr = null;
			// iterate through the nodes and form the object
			for (int count = 0; count < detailNodesLen; count++) {
				appointmentDetailNode = appointmentDetailNodes.item(count);
				if (appointmentDetailNode.getNodeType() == Node.ELEMENT_NODE) {
					Element appointmentElement = (Element) appointmentDetailNode;

					// read the practitioner info
					NodeList practitionerNodeList = appointmentElement
							.getElementsByTagName(AppointmentDetailConstant.PRACTITIONER_KEY);
					if (practitionerNodeList != null) {
						Element practitionerElement = (Element) practitionerNodeList
								.item(0);

						NodeList practitionerChildNodeList = practitionerElement
								.getChildNodes();
						practitioner = ((Node) practitionerChildNodeList
								.item(0)).getNodeValue().trim();
					}

					// read the speciality info
					NodeList specialityNodeList = appointmentElement
							.getElementsByTagName(AppointmentDetailConstant.SPECIALITY_KEY);
					if (specialityNodeList != null) {
						Element specialityElement = (Element) specialityNodeList
								.item(0);

						NodeList specialityChildNodeList = specialityElement
								.getChildNodes();
						speciality = ((Node) specialityChildNodeList.item(0))
								.getNodeValue().trim();
					}

					// read the appointment date
					NodeList apptDateNodeList = appointmentElement
							.getElementsByTagName(AppointmentDetailConstant.APPOINTMENT_DATE);
					if (apptDateNodeList != null) {
						Element apptDateElement = (Element) apptDateNodeList
								.item(0);

						NodeList apptDateChildNodeList = apptDateElement
								.getChildNodes();
						apptDateStr = ((Node) apptDateChildNodeList.item(0))
								.getNodeValue().trim();
						try {
							apptDateLong = Long.parseLong(apptDateStr);
						} catch (NumberFormatException e) {
							// cannot do anything - initialize this to
							// current time
							apptDateLong = System.currentTimeMillis();
						}
						appointmentDate = new Date(apptDateLong);
					}

					// read the appointment start time
					NodeList apptStartTimeNodeList = appointmentElement
							.getElementsByTagName(AppointmentDetailConstant.APPOINTMENT_STARTTIME_KEY);
					if (apptStartTimeNodeList != null) {
						Element apptStartTimeElement = (Element) apptStartTimeNodeList
								.item(0);

						NodeList apptStartTimeChildNodeList = apptStartTimeElement
								.getChildNodes();
						apptStartStr = ((Node) apptStartTimeChildNodeList
								.item(0)).getNodeValue().trim();
						try {
							apptStart = Long.parseLong(apptStartStr);
						} catch (NumberFormatException e) {
							// cannot do anything - initialize this to
							// current time
							apptStart = System.currentTimeMillis();
						}
						appointmentStartTime = new Date(apptStart);
					}

					// read the appointment end time
					NodeList apptEndTimeNodeList = appointmentElement
							.getElementsByTagName(AppointmentDetailConstant.APPOINTMENT_ENDTIME_KEY);
					if (apptEndTimeNodeList != null) {
						Element apptEndTimeElement = (Element) apptEndTimeNodeList
								.item(0);

						NodeList apptEndTimeChildNodeList = apptEndTimeElement
								.getChildNodes();
						apptEndStr = ((Node) apptEndTimeChildNodeList.item(0))
								.getNodeValue().trim();

						try {
							apptEnd = Long.parseLong(apptEndStr);
						} catch (NumberFormatException e) {
							// cannot do anything - initialize this to
							// current time
							apptEnd = System.currentTimeMillis();
						}
						appointmentEndTime = new Date(apptEnd);
					}

					// initialize the details object and set the data
					appointmentDetails = new AppointmentDetails();
					appointmentDetails.setPractitioner(practitioner);
					appointmentDetails.setApptSpeciality(speciality);
					appointmentDetails.setApptStartTime(appointmentStartTime);
					appointmentDetails.setApptEndTime(appointmentEndTime);
					appointmentDetails.setAppointmentDate(appointmentDate);
					// finally add to the list
					appointmentDetailsList.add(appointmentDetails);
				}
			}

			
			// set positive response
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
			
			appointmentDetailsResponse = new AppointmentDetailsResponse();
			appointmentDetailsResponse
					.setAppointmentDetailsList(appointmentDetailsList);
			appointmentDetailsResponse.addError(errorInfo);
		}
	}


	/**
	 * This method returns an instance of the impl class
	 * used for performing the business operation 
	 */
	protected BaseService getServiceImpl() {
		return new AppointmentSvcImpl();
	}

	/**
	 * This method gets the required data from the underlying 
	 * service implementation
	 */
	public AppointmentDetailsResponse getDataThroughService(AppointmentDetailsRequest request) {
		AppointmentSvcImpl svcImpl = new AppointmentSvcImpl();
		return svcImpl.getAppointmentDetails(request);
	}

}
