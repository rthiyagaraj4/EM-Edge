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
package portal.result.viewtestresult.svc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import portal.common.request.BaseRequest;
import portal.common.response.BaseResponse;
import portal.common.response.ErrorInfo;
import portal.common.serviceinvoker.AbstractServiceInvoker;
import portal.result.viewtestresult.response.TestResult;
import portal.result.viewtestresult.response.TestResultResponse;
import portal.tools.TestDetailsConstant;
import portal.tools.PortalConstants;
import portal.tools.PortalHelper;


/**
 * @author GRamamoorthy
 *
 */
public class TestDetailsServiceInvoker extends AbstractServiceInvoker {

	/**
	 * 
	 */
	public String getWebServiceURL(BaseRequest request) {
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.TESTDETAILS_WS_URL_KEY);
		return webServiceUrl;
	}

	/**
	 * 
	 */
	public String getURLParameters(BaseRequest request) {
		String patientId = request.getPatientId();
		if(patientId == null){
			patientId = "";
		}
		String params = "patientId="+patientId;
		return params;
	}

	/**
	 * 
	 */
	public BaseResponse getResponseObject() {
		return new TestResultResponse();
	}

	/**
	 * 
	 */
	public boolean validateRequest(BaseRequest request) {
		boolean validRequest = true;
		if(request == null){
			validRequest = false;
		}
		String patientId = request.getPatientId();
		if(patientId == null || patientId.trim().equals("")){
			validRequest = false;
		}
		
		return validRequest;
	}

	/**
	 * 
	 */
	public void readXMLContent(Document doc, BaseResponse response) {
		NodeList testDetailNodes = doc
				.getElementsByTagName(TestDetailsConstant.TESTDETAIL_KEY);
		int detailNodesLen = testDetailNodes != null?testDetailNodes.getLength():0;
		Node testDetailNode = null;
		
		
		String orderNo = null;
		String location = null;
		String practId = null;
		String practName = null;
		String status = null;
		String order = null;
		Date orderDate = null;
		long orderDateLongVal = 0;
		String orderDateStrVal = null;
		String resultType = null;
		TestResult testDetails = null;
		List<TestResult> testDetailsList = new ArrayList<TestResult>();
		// now the response is definitely of type TestDetailsResponse
		// so set the list
		((TestResultResponse)response).setTestDetailsList(testDetailsList);
		
		// iterate through the nodes and form the object
		for(int count=0;count<detailNodesLen;count++){
			testDetailNode = testDetailNodes.item(count);
			if(testDetailNode.getNodeType() == Node.ELEMENT_NODE){
				Element testDetailElement = (Element)testDetailNode;
				
				// read the orderNo info 
				NodeList orderNoNodeList = testDetailElement
						.getElementsByTagName(TestDetailsConstant.ORDERNO_KEY);
				if(orderNoNodeList != null){
					Element orderNoElement = (Element)orderNoNodeList.item(0);

					NodeList orderNoChildNodeList = orderNoElement.getChildNodes();
					orderNo = ((Node) orderNoChildNodeList.item(0))
							.getNodeValue().trim();
				}
					
				// read the location info
				NodeList locationNodeList = testDetailElement
						.getElementsByTagName(TestDetailsConstant.LOCATION_KEY);
				if(locationNodeList != null){
					Element locationElement = (Element)locationNodeList.item(0);

					NodeList locationChildNodeList = locationElement.getChildNodes();
					location = ((Node) locationChildNodeList.item(0))
							.getNodeValue().trim();
				}
				
				// read the resultType date
				NodeList resultTypeNodeList = testDetailElement
						.getElementsByTagName(TestDetailsConstant.RESULTTYPE_KEY);
				if(resultTypeNodeList != null){
					Element resultTypeElement = (Element)resultTypeNodeList.item(0);

					NodeList resultTypeChildNodeList = resultTypeElement.getChildNodes();
					resultType = ((Node) resultTypeChildNodeList.item(0))
							.getNodeValue().trim();
					/*try {
						apptDateLong = Long.parseLong(apptDateStr);
					} catch (NumberFormatException e) {
						// cannot do anything - initialize this to
						// current time
						apptDateLong = System.currentTimeMillis();
					}
					appointmentDate = new Date(apptDateLong);*/
				}
				
				// read the order value
				NodeList orderNodeList = testDetailElement
						.getElementsByTagName(TestDetailsConstant.ORDER_KEY);
				if(orderNodeList != null){
					Element orderElement = (Element)orderNodeList.item(0);

					NodeList orderChildNodeList = orderElement.getChildNodes();
					order = ((Node) orderChildNodeList.item(0))
							.getNodeValue().trim();
					/*try {
						apptStart = Long.parseLong(apptStartStr);
					} catch (NumberFormatException e) {
						// cannot do anything - initialize this to
						// current time
						apptStart = System.currentTimeMillis();
					}
					appointmentStartTime = new Date(apptStart);*/
				}
				
				// read the order date time
				NodeList orderDateNodeList = testDetailElement
						.getElementsByTagName(TestDetailsConstant.ORDER_DATE_KEY);
				if(orderDateNodeList != null){
					Element orderDateElement = (Element)orderDateNodeList.item(0);

					NodeList orderDateChildNodeList = orderDateElement.getChildNodes();
					orderDateStrVal = ((Node) orderDateChildNodeList.item(0))
							.getNodeValue().trim();
					
					try {
						orderDateLongVal = Long.parseLong(orderDateStrVal);
					} catch (NumberFormatException e) {
						// cannot do anything - initialize this to
						// current time
						orderDateLongVal = System.currentTimeMillis();
					}
					orderDate = new Date(orderDateLongVal);
				}
				
				// read the practitioner name value
				NodeList practNameNodeList = testDetailElement
						.getElementsByTagName(TestDetailsConstant.PRACT_NAME_KEY);
				if(practNameNodeList != null){
					Element practNameElement = (Element)practNameNodeList.item(0);

					NodeList practNameChildNodeList = practNameElement.getChildNodes();
					practName = ((Node) practNameChildNodeList.item(0))
							.getNodeValue().trim();
				}
				
				// read the practitioner id value
				NodeList practIdNodeList = testDetailElement
						.getElementsByTagName(TestDetailsConstant.PRACT_ID_KEY);
				if(practIdNodeList != null){
					Element practIdElement = (Element)practIdNodeList.item(0);

					NodeList practIdChildNodeList = practIdElement.getChildNodes();
					practId = ((Node) practIdChildNodeList.item(0))
							.getNodeValue().trim();
				}
				
				// read the status value
				NodeList statusNodeList = testDetailElement
						.getElementsByTagName(TestDetailsConstant.STATUS_KEY);
				if(statusNodeList != null){
					Element statusElement = (Element)statusNodeList.item(0);

					NodeList statusChildNodeList = statusElement.getChildNodes();
					status = ((Node) statusChildNodeList.item(0))
							.getNodeValue().trim();
				}
				
				testDetails = new TestResult();
				testDetails.setOrderNo(orderNo);
				testDetails.setPractName(practName);
				testDetails.setResultType(resultType);
				
				testDetailsList.add(testDetails);
				
				// initialize the details object and set the data
				/*appointmentDetails = new AppointmentDetails();
				appointmentDetails.setPractitioner(practitioner);
				appointmentDetails.setApptSpeciality(speciality);
				appointmentDetails.setApptStartTime(appointmentStartTime);
				appointmentDetails.setApptEndTime(appointmentEndTime);
				appointmentDetails.setAppointmentDate(appointmentDate);
				// finally add to the list
				appointmentDetailsList.add(appointmentDetails);*/
			}
		}
		
		// now set positive values to error info object
		ErrorInfo errorInfo = response.getErrorInfo();
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		errorInfo.setErrorMessage(null);
	}

}
