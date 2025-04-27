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
package eIP.advbedmgmt.transaction.canceladmission;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This is the controller class for getting the patient check in
 * status flag
 * this class in turn calls the bean class and gets the status
 * @author GRamamoorthy
 *
 */
public class PatientCheckInController {
	
	/**
	 * String constant for the bean id
	 */
	private static String PATIENT_CHECKIN_STATUS_BEAN_KEYWORD = "patCheckInStatus";

	/**
	 * This method gets the patient check in status flag 
	 * the status flag is used as a parameter in cancel admission functionality in IP
	 * module
	 * @param request
	 * @return
	 */
	public PatientCheckInStatusResponse getPatientCheckInStatus(PatientCheckInStatusRequest request){
		PatientCheckInStatusResponse response = null;
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		PatientCheckInAllowedBean beanInst = (PatientCheckInAllowedBean) context
				.getBean(PATIENT_CHECKIN_STATUS_BEAN_KEYWORD);
		response = beanInst.getPatientCheckedInStatus(request);
		return response;
	}
	
}
