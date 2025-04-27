/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.RecPatChiefComplaint;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;

public interface RecPatChiefComplaintRemote extends EJBObject {

	public  java.util.HashMap insertChiefComplaint(
										java.util.Properties p,
										String x_facility_id,
										Long x_encounter_id,
										String x_complaint_id,
										String x_onset_date,
										String x_remarks,
										String client_ip_address,
										String locale,
		                                String x_complaint_details
		                                 
								
	) throws RemoteException;
	public  java.util.HashMap modifyChiefComplaint(
										java.util.Properties p,
										String x_facility_id,
										Long x_encounter_id,
										String x_complaint_id,
										String x_onset_date,
										String x_remarks,
										String client_ip_address,
										String locale,
										String err_remarks,
		                                String x_complaint_details,
		                                String x_error_yn
								
	) throws RemoteException;
}
