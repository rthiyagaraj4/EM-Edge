/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.results.healthobject;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SaraswathiR 
 *
 */
public class ResultValue {
	
	private Date eventTimestamp;
	private String date;
	private String time;
	private String strValue;
	private String accessionNum;
	private double dblValue;
	private Normalcy normalcyInd = Normalcy.UNKNOWN;
	private String performedBy;
	private boolean textExists;
	/**
	 * @return the date
	 */
	public enum Normalcy {
		NORMAL("N"), HIGH("H"), LOW("L"), CRITICAL("C"), ABNORMAL("A"), CRITICALHIGH("G"), CRITICALLOW("S"), UNKNOWN("U");
		private String normalcyCode;
		private Normalcy(String s){
			normalcyCode = s;
		}
		public String getNormalcyCode(){
			return normalcyCode;
		}
	}
	public String getDate() {
		return date;
	}
	public String getDate(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String formattedDate = sdf.format(eventTimestamp);
		return formattedDate;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the normalcyInd
	 */
	public Normalcy getNormalcyInd() {
		return normalcyInd;
	}
	/**
	 * @param normalcyInd the normalcyInd to set
	 */
	public void setNormalcyInd(Normalcy normalcyInd) {
		this.normalcyInd = normalcyInd;
	}
	/**
	 * @return the performedBy
	 */
	public String getPerformedBy() {
		return performedBy;
	}
	/**
	 * @param performedBy the performedBy to set
	 */
	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}
	/**
	 * @return the textExists
	 */
	public boolean isTextExists() {
		return textExists;
	}
	/**
	 * @param textExists the textExists to set
	 */
	public void setTextExists(boolean textExists) {
		this.textExists = textExists;
	}

	/**
	 * @return the strValue
	 */
	public String getStrValue() {
		return strValue;
	}
	/**
	 * @param strValue the strValue to set
	 */
	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}
	/**
	 * @return the dblValue
	 */
	public double getDblValue() {
		return dblValue;
	}
	/**
	 * @return the dblValue in string format
	 * without the extra .0 in the value
	 */
	public String getDblAsStrValue(){
		DecimalFormat df = new DecimalFormat("0.###");
		return df.format(dblValue).toString();
	}
	/**
	 * @param dblValue the dblValue to set
	 */
	public void setDblValue(double dblValue) {
		this.dblValue = dblValue;
	}
	/**
	 * @return the eventTimestamp
	 */
	public Date getEventTimestamp() {
		return eventTimestamp;
	}
	/**
	 * @param eventTimestamp the eventTimestamp to set
	 */
	public void setEventTimestamp(Date eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}
	/**
	 * @return the accessionNum
	 */
	public String getAccessionNum() {
		return accessionNum;
	}
	/**
	 * @param accessionNum the accessionNum to set
	 */
	public void setAccessionNum(String accessionNum) {
		this.accessionNum = accessionNum;
	}

}
