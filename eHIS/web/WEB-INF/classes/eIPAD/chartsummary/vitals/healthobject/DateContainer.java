/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;

import java.util.*;
public class DateContainer implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Date> dateList;
	/**
	 * @return the dateList 
	 */
	public List<Date> getDateList() {
		return dateList;
	}
	/**
	 * @param dateList the dateList to set
	 */
	public void setDateList(List<Date> dateList) {
		this.dateList = dateList;
	}

}
	

