/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;

import java.util.Date;

public class DiscreteValue implements java.io.Serializable {

	/**
	 * This class holds the discrete values. 
	 */
	private static final long serialVersionUID = 1L;
	private String eventDateTime;
	private String resultNum;
	private String rank;
	private String colorCellIndicator;
	private String descCellIndicator;
	private String symbolLegend;
	private String normalIndicator;
	private String resultString;
	private Date eventDateTimestamp;
	private double resultNumber;
	/**
	 * @return the eventDateTime
	 */
	public String getEventDateTime() {
		return eventDateTime;
	}
	/**
	 * @param eventDateTime the eventDateTime to set
	 */
	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}
	/**
	 * @return the resultNum
	 */
	public String getResultNum() {
		return resultNum;
	}
	/**
	 * @param resultNum the resultNum to set
	 */
	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	/**
	 * @return the colorCellIndicator
	 */
	public String getColorCellIndicator() {
		return colorCellIndicator;
	}
	/**
	 * @param colorCellIndicator the colorCellIndicator to set
	 */
	public void setColorCellIndicator(String colorCellIndicator) {
		this.colorCellIndicator = colorCellIndicator;
	}
	/**
	 * @return the descCellIndicator
	 */
	public String getDescCellIndicator() {
		return descCellIndicator;
	}
	/**
	 * @param descCellIndicator the descCellIndicator to set
	 */
	public void setDescCellIndicator(String descCellIndicator) {
		this.descCellIndicator = descCellIndicator;
	}
	/**
	 * @return the symbolLegend
	 */
	public String getSymbolLegend() {
		return symbolLegend;
	}
	/**
	 * @param symbolLegend the symbolLegend to set
	 */
	public void setSymbolLegend(String symbolLegend) {
		this.symbolLegend = symbolLegend;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the normalIndicator
	 */
	public String getNormalIndicator() {
		return normalIndicator;
	}
	/**
	 * @param normalIndicator the normalIndicator to set
	 */
	public void setNormalIndicator(String normalIndicator) {
		this.normalIndicator = normalIndicator;
	}
	/**
	 * @return the resultString
	 */
	public String getResultString() {
		return resultString;
	}
	/**
	 * @param resultString the resultString to set
	 */
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	/**
	 * @return the eventDateTimestamp
	 */
	public Date getEventDateTimestamp() {
		return eventDateTimestamp;
	}
	/**
	 * @param eventDateTimestamp the eventDateTimestamp to set
	 */
	public void setEventDateTimestamp(Date eventDateTimestamp) {
		this.eventDateTimestamp = eventDateTimestamp;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Date)
		{
			Date oDate = (Date)obj;
			if(oDate.equals(this.eventDateTimestamp))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		return false;
	}
	public int hashCode() {
		return this.eventDateTimestamp.hashCode();
	}
	/**
	 * @return the resultNumber
	 */
	public double getResultNumber() {
		return resultNumber;
	}
	/**
	 * @param resultNumber the resultNumber to set
	 */
	public void setResultNumber(double resultNumber) {
		this.resultNumber = resultNumber;
	}

}
