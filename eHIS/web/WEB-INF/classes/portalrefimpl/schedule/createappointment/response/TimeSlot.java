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
package portalrefimpl.schedule.createappointment.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.PortalHelper;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;

/**
 * This is a model class used to represent time slot information
 * This model class is used in the practitioner time slot service response
 * object
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "TimeSlot")
public class TimeSlot {

	private static final int HRINDEX = 0;
	private static final int MININDEX = 1;
	
	/**
	 * Data members in this class
	 */
	private String startTime = null;
	
	private String endTime = null;
	
	private TimeSlotStatus slotStatus = null;

	/**
	 * @return the startTime
	 */
	@XmlElement(name = "StartTime")
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	@XmlElement(name = "EndTime")
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the slotStatus
	 */
	@XmlElement(name = "SlotStatus")
	public TimeSlotStatus getSlotStatus() {
		return slotStatus;
	}

	/**
	 * @param slotStatus the slotStatus to set
	 */
	public void setSlotStatus(TimeSlotStatus slotStatus) {
		this.slotStatus = slotStatus;
	}
	
	/**
	 * This method checks whether this time slot falls
	 * with in the preferred from and to time
	 * @return
	 */
	public boolean isTimeSlotInPreferredTimeRange(String preferredFromTime,String preferredToTime){
		boolean inRange = false;
		// safe checks
		if((startTime == null || startTime.trim().equals("")) || (endTime == null || endTime.trim().equals(""))){
			return inRange;
		}
		// safe checks
		if ((preferredFromTime == null || preferredFromTime.trim().equals(""))
				|| (preferredToTime == null || preferredToTime.trim()
						.equals(""))) {
			return inRange;
		}
		
		int startTimes[] = getHoursAndMinutes(startTime);
		int startTimeHrs = startTimes[HRINDEX];//PortalHelper.getIntegerValue(startTimeHrsStr, -1);
		int startTimeMins = startTimes[MININDEX];//PortalHelper.getIntegerValue(startTimeMinsStr, -1);
		
		int endTimes[] = getHoursAndMinutes(endTime);
		int endTimeHrs = endTimes[HRINDEX];
		int endTimeMins = endTimes[MININDEX];
		
		//int endTimeHrs = PortalHelper.getIntegerValue(endTime, -1);
		int preferredFromTimes[] = getHoursAndMinutes(preferredFromTime);
		int preferredFromHrs = preferredFromTimes[HRINDEX];
		int preferredFromMins = preferredFromTimes[MININDEX] ;
		
		int preferredToTimes[] = getHoursAndMinutes(preferredToTime);
		int preferredToHrs = preferredToTimes[HRINDEX];
		int preferredToMins = preferredToTimes[MININDEX];
		// safe checks
		if (startTimeHrs == -1 || startTimeMins == -1 || endTimeHrs == -1
				|| endTimeMins == -1 || preferredFromHrs == -1
				|| preferredFromMins == -1 || preferredToHrs == -1
				|| preferredToMins == -1) {
			return inRange;
		}
		
		boolean startTimeInRange = isStartTimeInRange(preferredFromHrs,
				preferredFromMins, preferredToHrs, preferredToMins,
				startTimeHrs, startTimeMins);
		//isStartTimeInRange(preferredFromHrs, preferredFromMins,
				//startTimeHrs, startTimeMins);
		boolean endTimeInRange = isEndTimeInRange(preferredFromHrs,
				preferredFromMins, preferredToHrs, preferredToMins,
				endTimeHrs, endTimeMins);
		/*boolean endTimeInRange = isEndTimeInRange(preferredToHrs, preferredToMins,
				endTimeHrs, endTimeMins);*/
		inRange = startTimeInRange || endTimeInRange;
				
		return inRange;
	}
	
	/**
	 * This method gets the hours and minutes given a string containing time
	 * value in the format HH:MM
	 * @param timeStr
	 * @return
	 */
	private int[] getHoursAndMinutes(String timeStr){
		int[] hoursAndMinutes = new int[2];
		int hrsIndex = timeStr.indexOf(CreateAppointmentConstants.TIMESLOT_HOUR_DELIMITER);
		String hrsStr = null;
		String minsStr = null;
		if(hrsIndex > 0){
			hrsStr = timeStr.substring(0, hrsIndex);	
			minsStr = timeStr.substring(hrsIndex+1, timeStr.length());
		}
		int hrs = PortalHelper.getIntegerValue(hrsStr, -1);
		int mins = PortalHelper.getIntegerValue(minsStr, -1);
		hoursAndMinutes[HRINDEX] = hrs;
		hoursAndMinutes[MININDEX] = mins;
		
		return hoursAndMinutes;
	}
	
	/**
	 * This method will check whether the start time lies between preferred time 
	 * @param preferredStartHrs
	 * @param preferredStartMins
	 * @param preferredEndHrs
	 * @param preferredEndMins
	 * @param hrs
	 * @param mins
	 * @return
	 */
	private boolean isStartTimeInRange(int preferredStartHrs,
			int preferredStartMins, int preferredEndHrs, int preferredEndMins,
			int hrs, int mins) {
		boolean inRange = false;
		
		if(hrs > preferredStartHrs){
			if(hrs < preferredEndHrs){
				inRange = true;
			}else if(hrs == preferredEndHrs){
				if(mins < preferredEndMins){
					inRange = true;
				}
			}
		}else if(hrs == preferredStartHrs){
			if(mins < preferredStartMins){
				inRange = false;
				return inRange;
			}
			if(hrs < preferredEndHrs){
				inRange = true;
			}else if(hrs == preferredEndHrs){
				if(mins < preferredEndMins){
					inRange = true;
				}
			}
		}
		
		return inRange;
	}
	
	/**
	 * This method will check whether the end time lies between preferred time 
	 * @param preferredStartHrs
	 * @param preferredStartMins
	 * @param preferredEndHrs
	 * @param preferredEndMins
	 * @param hrs
	 * @param mins
	 * @return
	 */
	private boolean isEndTimeInRange(int preferredStartHrs,
			int preferredStartMins, int preferredEndHrs, int preferredEndMins,
			int hrs, int mins) {
		boolean inRange = false;
		
		if(hrs > preferredStartHrs){
			if(hrs < preferredEndHrs){
				inRange = true;
			}else if(hrs == preferredEndHrs){
				if(mins < preferredEndMins){
					inRange = true;
				}
			}
		}else if(hrs == preferredStartHrs){
			if(mins > preferredStartMins){
				inRange = true;
				return inRange;
			}
			if(hrs > preferredEndHrs){
				inRange = true;
			}else if(hrs == preferredEndHrs){
				if(mins > preferredEndMins){
					inRange = true;
				}
			}
		}
		
		return inRange;
	}
		/*public static void main(String[] args){
		List<TimeSlot> timeSlotList = new ArrayList<TimeSlot>();
		
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setStartTime("12:00");
		timeSlot.setEndTime("12:20");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		timeSlot.setStartTime("12:20");
		timeSlot.setEndTime("12:40");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		timeSlot.setStartTime("12:40");
		timeSlot.setEndTime("13:00");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		//timeSlot.setStartTime("10:00");
		timeSlot.setStartTime("13:00");
		//timeSlot.setEndTime("11:00");
		timeSlot.setEndTime("13:20");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		//timeSlot.setStartTime("11:00");
		timeSlot.setStartTime("13:20");
		//timeSlot.setEndTime("12:00");
		timeSlot.setEndTime("13:40");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		//timeSlot.setStartTime("12:00");
		timeSlot.setStartTime("13:40");
		//timeSlot.setEndTime("13:00");
		timeSlot.setEndTime("14:00");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		//timeSlot.setStartTime("14:00");
		timeSlot.setStartTime("14:00");
		//timeSlot.setEndTime("15:00");
		timeSlot.setEndTime("14:20");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		//timeSlot.setStartTime("15:00");
		timeSlot.setStartTime("14:20");
		//timeSlot.setEndTime("16:00");
		timeSlot.setEndTime("14:40");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		timeSlot.setStartTime("14:40");
		timeSlot.setEndTime("15:00");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		timeSlot.setStartTime("15:00");
		timeSlot.setEndTime("15:20");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		timeSlot.setStartTime("15:20");
		timeSlot.setEndTime("15:40");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		timeSlot = new TimeSlot();
		timeSlot.setStartTime("15:40");
		timeSlot.setEndTime("16:00");
		timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
		timeSlotList.add(timeSlot);
		
		String preferredFromTime = "16:30";
		String preferredToTime = "17:30";
		
		boolean inRange = false;
		long beforeExec = System.currentTimeMillis();
		for(TimeSlot slot : timeSlotList){
			System.out.println("---------------------------------------------------------");
			inRange = slot.isTimeSlotInPreferredTimeRange(
					preferredFromTime, preferredToTime);
			System.out.println("in range for timeslot ("+slot.getStartTime()+"-"+slot.getEndTime()+") is="+inRange);
		}
		long afterExec = System.currentTimeMillis();
		System.out.println("total execution time="+(afterExec - beforeExec));
		/*long beforeExec = System.currentTimeMillis();
		inRange = timeSlot.isTimeSlotInPreferredTimeRange(preferredFromTime, preferredToTime);
		long afterExec = System.currentTimeMillis();
		System.out.println(inRange);
		System.out.println(afterExec - beforeExec);
	}*/

	/**
	 * This method checks if the given object is equal
	 * to this object
	 * start time and end time are alone needed for
	 * the comparison
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		if(!(obj instanceof TimeSlot)){
			return equals;
		}
		String tempStartTime = ((TimeSlot)obj).getStartTime();
		String tempEndTime = ((TimeSlot)obj).getEndTime();
		if ((tempStartTime != null && tempStartTime.equals(this.startTime))
				&& (tempEndTime != null && tempEndTime.equals(this.endTime))) {
			equals = true;
		}
		
		return equals;
	}
	
	
	
}
