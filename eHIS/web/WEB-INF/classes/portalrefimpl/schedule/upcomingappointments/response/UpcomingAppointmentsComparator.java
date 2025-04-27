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
package portalrefimpl.schedule.upcomingappointments.response;

import java.util.Comparator;
import java.util.Date;

import portalrefimpl.PortalHelper;

/**
 * This is the comparator class for upcoming appointments
 * upcoming appointments consists of appointments from EM and appointment
 * requests from portal - hence there is a need to sort the appointments
 * This comparator implementation helps in sorting the upcoming appointments
 * 
 * @author gramamoorthy
 *
 */
public class UpcomingAppointmentsComparator implements
		Comparator<UpcomingAppointmentDetails> {

	/**
	 * This method compares two upcoming appointment details object
	 * and returns an integer value representing the comparison result.
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public int compare(UpcomingAppointmentDetails o1,
			UpcomingAppointmentDetails o2) {
		// no need to check for null as the data should
		// be valid if control comes here
		String firstApptDate = o1.getAppointmentDate();
		String firstStartTime = o1.getAppointmentStartTime();
		String firstCompleteDateStr = firstApptDate + " " + firstStartTime;
		
		String secondApptDate = o2.getAppointmentDate();
		String secondStartTime = o2.getAppointmentStartTime();
		String secondCompleteDateStr = secondApptDate + " " + secondStartTime;
		
		// now convert the complete date strings to the date object equivalent
		final String DATEFORMAT = "dd/MM/yyyy HH:mm";
		Date firstCompleteDate = PortalHelper.getDateFromString(
				firstCompleteDateStr, DATEFORMAT);
		Date secondCompleteDate = PortalHelper.getDateFromString(
				secondCompleteDateStr, DATEFORMAT);
		final int GREATER = 1;
		final int LESSER = -1;
		int compareResult = 0;
		if(firstCompleteDate.after(secondCompleteDate)){
			compareResult = GREATER;
		}else if(firstCompleteDate.before(secondCompleteDate)){
			compareResult = LESSER;
		}
		return compareResult;
	}

	/*public static void main(String[] args){
		// first initialize the list of objects 
		List<UpcomingAppointmentDetails> detailsList = new ArrayList<UpcomingAppointmentDetails>();
		UpcomingAppointmentDetails detailsObj = new UpcomingAppointmentDetails();
		detailsObj.setAppointmentDate("29/04/2013");
		detailsObj.setAppointmentStartTime("10:00");
		detailsObj.setAppointmentEndTime("10:30");
		detailsList.add(detailsObj);
		
		detailsObj = new UpcomingAppointmentDetails();
		detailsObj.setAppointmentDate("30/04/2013");
		detailsObj.setAppointmentStartTime("13:00");
		detailsObj.setAppointmentEndTime("13:30");
		detailsList.add(detailsObj);
		
		detailsObj = new UpcomingAppointmentDetails();
		detailsObj.setAppointmentDate("27/04/2013");
		detailsObj.setAppointmentStartTime("12:00");
		detailsObj.setAppointmentEndTime("12:30");
		detailsList.add(detailsObj);
		
		detailsObj = new UpcomingAppointmentDetails();
		detailsObj.setAppointmentDate("28/04/2013");
		detailsObj.setAppointmentStartTime("16:00");
		detailsObj.setAppointmentEndTime("16:30");
		detailsList.add(detailsObj);
		
		detailsObj = new UpcomingAppointmentDetails();
		detailsObj.setAppointmentDate("26/04/2013");
		detailsObj.setAppointmentStartTime("09:00");
		detailsObj.setAppointmentEndTime("09:30");
		detailsList.add(detailsObj);
		
		detailsObj = new UpcomingAppointmentDetails();
		detailsObj.setAppointmentDate("29/04/2013");
		detailsObj.setAppointmentStartTime("09:00");
		detailsObj.setAppointmentEndTime("09:30");
		detailsList.add(detailsObj);
		
		detailsObj = new UpcomingAppointmentDetails();
		detailsObj.setAppointmentDate("03/05/2013");
		detailsObj.setAppointmentStartTime("18:00");
		detailsObj.setAppointmentEndTime("18:30");
		detailsList.add(detailsObj);
		
		UpcomingAppointmentsComparator comparator = new UpcomingAppointmentsComparator();
		Collections.sort(detailsList, comparator);
		// iterate through the list
		for(UpcomingAppointmentDetails details : detailsList){
			System.out.println(details.getAppointmentDate() + "|||"
					+ details.getAppointmentStartTime() + "|||"
					+ details.getAppointmentEndTime());
		}
	}*/
	
}
