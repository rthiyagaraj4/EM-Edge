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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.request.PatientInfo;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetails;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse;

/**
 * @author GRamamoorthy
 * 
 */
public class AppointmentDetailsHelper {

	/**
	 * 
	 * @param appointmentDetailsRequest
	 * @return
	 */
	public static AppointmentDetailsResponse getAppointmentDetail(
			AppointmentDetailsRequest appointmentDetailsRequest) {
		AppointmentDetailsResponse appointmentDetailsResponse = null;

		// just a safe check
		if (appointmentDetailsRequest == null) {
			return appointmentDetailsResponse;
		}
		PatientInfo patientInfo = appointmentDetailsRequest.getPatientInfo();
		// another safe check
		if (patientInfo == null) {
			return appointmentDetailsResponse;
		}
		// form the url object to be hit programmatically
		String patientId = patientInfo.getPatientId();
		if(patientId == null){
			patientId = "";
		}
		String urlString = PortalHelper
				.getWebServiceURL(PortalConstants.APPOINTMENTDETAILS_WS_URL_KEY);
		urlString += "?patientId=" + patientId;
		urlString += "&recordCount="
				+ PortalConstants.HOMEPAGE_APPOINTMENTLIST_RECORDCOUNT;
		String portalUserName = appointmentDetailsRequest.getPortalUserName();
		if(portalUserName == null){
			portalUserName = "";
		}
		urlString += "&";
		urlString += PortalConstants.PORTALUSER_REQUEST_PARAM_KEY;
		urlString += "=";
		urlString += PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE;
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			// e.printStackTrace();
			System.out.println("could not establish the url connection "
					+ e.getMessage());
			return appointmentDetailsResponse;
		}
		// set up the urlconnection to hit the url
		URLConnection connection = null;
		try {
			connection = url.openConnection();
			connection.setDoOutput(true);
		} catch (IOException e) {
			System.out.println("could not establish the url connection "
					+ e.getMessage());
			return appointmentDetailsResponse;
		}
		// indicate that the url is to be hit from client to server
		OutputStreamWriter out = null;
		try {
			out = new OutputStreamWriter(connection.getOutputStream());
		} catch (IOException e) {
			System.out.println("could not open the url " + e.getMessage());
			return appointmentDetailsResponse;
		}

		// now initialize the reading from the server
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
		} catch (IOException e) {
			System.out.println("could not read from the url " + e.getMessage());
			return appointmentDetailsResponse;
		}
		// have the code to check for and delete the output xml file
		// if it already exists
		final String FILENAME = "Output.xml";
		/*
		 * File file = null; BufferedWriter bufWriter = null; try { file = new
		 * File(FILENAME); boolean deletedResult = false; final int
		 * DELETECOUNTER = 5; int counter = 0; while(file.exists()){
		 * deletedResult = file.delete(); if(deletedResult){ break; }
		 * if(!deletedResult && (counter > DELETECOUNTER)){ break; } counter++;
		 * } if(!deletedResult && (counter > DELETECOUNTER)){
		 * System.out.println("Could not create file for writing the contents");
		 * return appointmentDetailsResponse; } bufWriter = new
		 * BufferedWriter(new FileWriter(file)); } catch (Exception e1) {
		 * System.
		 * out.println("Could not create file for writing the contents "+e1
		 * .getMessage()); return appointmentDetailsResponse; }
		 */

		// now comes the logic where the server's output is read
		// and saved in in the xml file
		String decodedString;
		StringBuffer sbuff = new StringBuffer();
		try {
			while ((decodedString = in.readLine()) != null) {
				System.out.println(decodedString);
				/*
				 * if(bufWriter != null){ bufWriter.write(decodedString); }
				 */
				sbuff.append(decodedString);
			}
			/* bufWriter.flush(); */
			in.close();
		} catch (IOException e) {
			System.out.println("could not read the url contents "
					+ e.getMessage());
			return appointmentDetailsResponse;
		}

		// now comes the logic where the server's output has to
		// be converted to a response object
		appointmentDetailsResponse = getAppointmentDetail(sbuff.toString());

		return appointmentDetailsResponse;
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	private static AppointmentDetailsResponse getAppointmentDetail(
			String xmlContent) {
		AppointmentDetailsResponse appointmentDetailsResponse = null;
		List<AppointmentDetails> appointmentDetailsList = new ArrayList<AppointmentDetails>();
		ErrorInfo errorInfo = new ErrorInfo();

		byte[] byteArr = xmlContent.getBytes();
		final ByteArrayInputStream is = new ByteArrayInputStream(byteArr);
		InputSource source = new InputSource(is);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Could not read from output xml file "
					+ e.getMessage());
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.WEBSVC_READ_ERROR_CODE);
			appointmentDetailsResponse = new AppointmentDetailsResponse();
			appointmentDetailsResponse.addError(errorInfo);
			return appointmentDetailsResponse;
		}
		Document doc = null;
		try {
			/* doc = dBuilder.parse(file); */
			doc = dBuilder.parse(source);
		} catch (Exception e) {
			System.out.println("Could not parse output xml file "
					+ e.getMessage());
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.WEBSVC_READ_ERROR_CODE);
			appointmentDetailsResponse = new AppointmentDetailsResponse();
			appointmentDetailsResponse.addError(errorInfo);
			return appointmentDetailsResponse;
		}
		doc.getDocumentElement().normalize();
		String rootElement = doc.getDocumentElement().getNodeName();

		if (PortalConstants.ERRORS_WRAPPER_KEY.equalsIgnoreCase(rootElement)) {
			appointmentDetailsResponse = new AppointmentDetailsResponse();
			NodeList errorNodeList = doc
					.getElementsByTagName(PortalConstants.ERROR_KEY);
			int errorNodesLength = errorNodeList != null ? errorNodeList
					.getLength() : 0;
			Node errorNode = null;

			for (int count = 0; count < errorNodesLength; count++) {
				errorNode = errorNodeList.item(count);
				if (errorNode.getNodeType() == Node.ELEMENT_NODE) {
					errorInfo = new ErrorInfo();

					Element errorElement = (Element) errorNode;

					NodeList errorCodeNodes = errorElement
							.getElementsByTagName(PortalConstants.ERRORCODE_KEY);

					if (errorCodeNodes != null) {
						Element errorCodeElement = (Element) errorCodeNodes
								.item(0);
						NodeList errorCodeChildNodes = errorCodeElement
								.getChildNodes();
						if (errorCodeChildNodes != null) {
							Node errorCodeChildNode = errorCodeChildNodes
									.item(0);
							if (errorCodeChildNode != null) {
								String errorCodeString = errorCodeChildNode
										.getNodeValue();
								int errorCode = -1;
								try {
									errorCode = Integer
											.parseInt(errorCodeString);
								} catch (NumberFormatException e) {
									// cannot do much
								}

								errorInfo.setErrorCode(errorCode);
								// System.out.println("error code="+errorCode);
							}
						}
					}

					NodeList errorMessageNodes = errorElement
							.getElementsByTagName(PortalConstants.ERRORMESSAGE_KEY);

					if (errorMessageNodes != null) {
						Element errorMessageElement = (Element) errorMessageNodes
								.item(0);
						NodeList errorMessageChildNodes = errorMessageElement
								.getChildNodes();
						if (errorMessageChildNodes != null) {
							Node errorMessageChildNode = errorMessageChildNodes
									.item(0);
							if (errorMessageChildNode != null) {
								String errorMessage = errorMessageChildNode
										.getNodeValue();
								// System.out.println("error message="+errorMessage);

								errorInfo.setErrorMessage(errorMessage);
							}
						}
					}

					appointmentDetailsResponse.addError(errorInfo);
				}
			}

		}

		/*
		 * if(PortalConstants.ERRORINFO_KEY.equalsIgnoreCase(rootElement)){
		 * NodeList errorCodeNodes = doc
		 * .getElementsByTagName(PortalConstants.ERRORCODE_KEY); NodeList
		 * errorMessageNodes = doc
		 * .getElementsByTagName(PortalConstants.ERRORMESSAGE_KEY);
		 * if(errorCodeNodes != null){ Element errorCodeElement =
		 * (Element)errorCodeNodes.item(0); NodeList errorCodeChildNodes =
		 * errorCodeElement.getChildNodes(); if(errorCodeChildNodes != null){
		 * Node errorCodeChildNode = errorCodeChildNodes.item(0);
		 * if(errorCodeChildNode != null){ String errorCodeString =
		 * errorCodeChildNode.getNodeValue(); int errorCode = -1; try {
		 * errorCode = Integer.parseInt(errorCodeString); } catch
		 * (NumberFormatException e) { // cannot do much }
		 * errorInfo.setErrorCode(errorCode); } } } if(errorMessageNodes !=
		 * null){ Element errorMessageElement =
		 * (Element)errorMessageNodes.item(0); NodeList errorMessageChildNodes =
		 * errorMessageElement.getChildNodes(); if(errorMessageChildNodes !=
		 * null){ Node errorMessageChildNode = errorMessageChildNodes.item(0);
		 * if(errorMessageChildNode != null){ String errorMessage =
		 * errorMessageChildNode.getNodeValue();
		 * errorInfo.setErrorMessage(errorMessage); } } } }
		 */
		else if (AppointmentDetailConstant.APPOINTMENTDETAILS_KEY
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

			// now set positive values to error info object
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			errorInfo.setErrorMessage(null);
			
			appointmentDetailsResponse = new AppointmentDetailsResponse();
			appointmentDetailsResponse
					.setAppointmentDetailsList(appointmentDetailsList);
			appointmentDetailsResponse.addError(errorInfo);
		}

		return appointmentDetailsResponse;
	}

}
