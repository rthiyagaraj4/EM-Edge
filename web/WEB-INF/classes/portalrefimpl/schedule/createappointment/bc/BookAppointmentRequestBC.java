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
package portalrefimpl.schedule.createappointment.bc;

import portalrefimpl.schedule.createappointment.appointmentrequest.handler.AppointmentHandler;
import portalrefimpl.schedule.createappointment.appointmentrequest.handler.AppointmentHandlerFactory;
import portalrefimpl.schedule.createappointment.request.BookAppointmentRequest;
import portalrefimpl.schedule.createappointment.response.BookAppointmentResponse;

/**
 * This is the BC layer class for book appointment functionality
 * 
 * @author GRamamoorthy
 *
 */
public class BookAppointmentRequestBC {

	/**
	 * This method executes the book appointment functionality
	 * This method makes use of the appointment request controller
	 * object to execute the specific logic for book appointment
	 * and then gets the response object
	 * 
	 * @return
	 */
	public BookAppointmentResponse getBookAppointmentResponse(
			BookAppointmentRequest request) {
		// initialize the response
		BookAppointmentResponse response = null;
		
		AppointmentHandler handler = AppointmentHandlerFactory.getInstance()
				.getAppointmentHandler(request);
		/*AppointmentResponse apptResponse = handler.performOperation(request);*/
		response = (BookAppointmentResponse)handler.performOperation(request);
		
		
		// add the request object to the controller
		// this will start the entire flow of executing logic
		// for this request and getting the response back
		/*AppointmentRequestController controller = AppointmentRequestController
				.getInstance();
		controller.addAppointmentRequest(request);
		
		//waiting logic to get the response back
		String bookApptMaxRetriesStr = PortalHelper.getConfigPropertyValue(
				CreateAppointmentConstants.BOOKAPPOINTMENT_MAX_RETRIES_KEY);
		int bookApptMaxRetries = PortalHelper.getIntegerValue(
				bookApptMaxRetriesStr,
				CreateAppointmentConstants.BOOKAPPOINTMENT_DEFAULT_MAX_RETRIES);
		String bookApptRetryIntervalStr = PortalHelper
				.getConfigPropertyValue(CreateAppointmentConstants.BOOKAPPOINTMENT_RETRY_INTERVAL_MILLIS_KEY);
		int bookApptRetryInterval = PortalHelper.getIntegerValue(
				bookApptRetryIntervalStr,
				CreateAppointmentConstants.BOOKAPPOINTMENT_DEFAULT_RETRY_INTERVAL_MILLIS);
		int counter = 0;
		while(true && (counter < bookApptMaxRetries)){
			try {
				Thread.sleep(bookApptRetryInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ResponseContainer responseContainer = request
					.getResponseContainer();
			if(responseContainer != null){
				response = (BookAppointmentResponse)responseContainer.getAppointmentResponse();
				break;
			}
			counter++;
		}
		// safe keeps - if we do not get a response
		// then we form an error response
		if((counter == bookApptMaxRetries) && (response == null)){
			// code to stop the execution of the request
			ExecutionStatus executionStatus = request.getExecutionStatus();
			if(ExecutionStatus.IN_PROGRESS == executionStatus){
				request.setAbort(true);
			}else if(ExecutionStatus.COMPLETED == executionStatus){
				// last check for request execution completed 
				// get the response container
				ResponseContainer responseContainer = request
						.getResponseContainer();
				if(responseContainer != null){
					response = (BookAppointmentResponse)responseContainer.getAppointmentResponse();
					return response;
				}
			}
			
			response = new BookAppointmentResponse();
			ErrorInfo errorInfo = new ErrorInfo();
			int errorCode = CreateAppointmentConstants.BOOKAPPOINTMENT_INSERT_RETRIES_EXCEEDED_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.setErrorInfo(errorInfo);
		}*/
		
		return response;
	}
	
	/*private BookAppointmentRequest getBookAppointmentRequest(){
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		bookAppointmentRequest.setFacilityId("HS");
		bookAppointmentRequest.setPatientId("HC00007128");
		bookAppointmentRequest.setPractitionerId("AZAMUDDIN");
		bookAppointmentRequest.setLocationCode("AC45");
		bookAppointmentRequest.setSpecialityId("22");
		bookAppointmentRequest.setPreferredDate("11/04/2013");
		bookAppointmentRequest.setPreferredFromTime("11/04/2013 13:30");
		bookAppointmentRequest.setPreferredToTime("11/04/2013 14:30");
		
		return bookAppointmentRequest;
	}
	
	
	public static void main(String[] args) {
		BookAppointmentRequestBC bcInst = new BookAppointmentRequestBC();
		BookAppointmentRequest request = bcInst.getBookAppointmentRequest();
		BookAppointmentResponse response = bcInst.getBookAppointmentResponse(request);
		System.out.println("error code from response="+response.getErrorInfo().getErrorCode());
	}*/
	
}
