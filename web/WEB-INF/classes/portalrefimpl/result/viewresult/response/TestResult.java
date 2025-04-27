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
package portalrefimpl.result.viewresult.response;

import java.text.SimpleDateFormat;
import java.util.Date;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.model.BaseTestResult;
import portalrefimpl.result.ResultConstants;

/**
 * This class stores the data for a test result
 * This class extends BaseTestResult class.
 * This class is used to represent individual test results
 * in the viewResult service
 * @author GRamamoorthy
 *
 */
public class TestResult extends BaseTestResult {

	/**
	 * Stores the results publish date
	 */
	private Date resultPublishDate = null;
	
	/**
	 * Stores the notes content
	 */
	private String notesContent = null;
	
	private String resultValue = null;
	
	private String resultUOM = null;
	
	private String normalLowValue = null;
	
	private String normalHighValue = null;
	
	private String criticalLowValue = null;
	
	private String criticalHighValue = null;
	
	private String resultStrValue = null;
	
	private String practitionerId = null;
	
	private String reportingPractitionerId = null;
	

	// indexes for the individual states
	public static final int CRITICAL_LOW_INDEX = 0;
	public static final int LOW_INDEX = 1;
	public static final int NORMAL_INDEX = 2;
	public static final int HIGH_INDEX = 3;
	public static final int CRITICAL_HIGH_INDEX = 4;
	public static final int CRITICAL_INDEX = 5;
	
	
	/**
	 * @return the resultPublishDate
	 */
	public Date getResultPublishDate() {
		return resultPublishDate;
	}

	/**
	 * @param resultPublishDate the resultPublishDate to set
	 */
	public void setResultPublishDate(Date resultPublishDate) {
		this.resultPublishDate = resultPublishDate;
	}

	/**
	 * @return the notesContent
	 */
	public String getNotesContent() {
		return notesContent;
	}

	/**
	 * @param notesContent the notesContent to set
	 */
	public void setNotesContent(String notesContent) {
		this.notesContent = notesContent;
	}

	/**
	 * @return the resultValue
	 */
	public String getResultValue() {
		return resultValue;
	}

	/**
	 * @param resultValue the resultValue to set
	 */
	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	/**
	 * @return the normalLowValue
	 */
	public String getNormalLowValue() {
		return normalLowValue;
	}

	/**
	 * @param normalLowValue the normalLowValue to set
	 */
	public void setNormalLowValue(String normalLowValue) {
		this.normalLowValue = normalLowValue;
	}

	/**
	 * @return the normalHighValue
	 */
	public String getNormalHighValue() {
		return normalHighValue;
	}

	/**
	 * @param normalHighValue the normalHighValue to set
	 */
	public void setNormalHighValue(String normalHighValue) {
		this.normalHighValue = normalHighValue;
	}

	/**
	 * @return the criticalLowValue
	 */
	public String getCriticalLowValue() {
		return criticalLowValue;
	}

	/**
	 * @param criticalLowValue the criticalLowValue to set
	 */
	public void setCriticalLowValue(String criticalLowValue) {
		this.criticalLowValue = criticalLowValue;
	}

	/**
	 * @return the criticalHighValue
	 */
	public String getCriticalHighValue() {
		return criticalHighValue;
	}

	/**
	 * @param criticalHighValue the criticalHighValue to set
	 */
	public void setCriticalHighValue(String criticalHighValue) {
		this.criticalHighValue = criticalHighValue;
	}

	/**
	 * @return the resultStrValue
	 */
	public String getResultStrValue() {
		return resultStrValue;
	}

	/**
	 * @param resultStrValue the resultStrValue to set
	 */
	public void setResultStrValue(String resultStrValue) {
		this.resultStrValue = resultStrValue;
	}

	/**
	 * @return the resultUOM
	 */
	public String getResultUOM() {
		return resultUOM;
	}

	/**
	 * @param resultUOM the resultUOM to set
	 */
	public void setResultUOM(String resultUOM) {
		this.resultUOM = resultUOM;
	}

	/**
	 * @return the practitionerId
	 */
	public String getPractitionerId() {
		return practitionerId;
	}

	/**
	 * @param practitionerId the practitionerId to set
	 */
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}

	/**
	 * @return the reportingPractitionerId
	 */
	public String getReportingPractitionerId() {
		return reportingPractitionerId;
	}

	/**
	 * @param reportingPractitionerId the reportingPractitionerId to set
	 */
	public void setReportingPractitionerId(String reportingPractitionerId) {
		this.reportingPractitionerId = reportingPractitionerId;
	}

	/**
	 * This method returns XML representation of this object and its contents
	 * @return
	 */
	public String getXMLContent(){
		StringBuffer xmlBuffer = new StringBuffer();
		// start the "result" tag within which
		// all other tags will be housed
		xmlBuffer.append(PortalHelper
				.getXMLStartTag(ResultConstants.TR_RESPONSE_RESULT_XML_TAG));
		
		// append the order tag
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_ORDER_XML_TAG, order));
		
		// append the result value
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_VALUE_XML_TAG, resultValue));
		// append the result UOM
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_UOM_XML_TAG, resultUOM));
		// result str
		xmlBuffer.append(getXMLStartTag(ResultConstants.TR_RESPONSE_RESULT_STR_XML_TAG));
		String tempResultStrValue = "";
		if(resultStrValue != null && !resultStrValue.trim().equals("")){
			tempResultStrValue = PortalConstants.CHARDATA_START_KEY;
			tempResultStrValue += resultStrValue;
			tempResultStrValue += PortalConstants.CHARDATA_END_KEY;
		}
		xmlBuffer.append(tempResultStrValue);
		xmlBuffer.append(getXMLEndTag(ResultConstants.TR_RESPONSE_RESULT_STR_XML_TAG));
		/*xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_STR_XML_TAG,resultStrValue));*/
		// publish date
		String publishDateString = "";
		if(resultPublishDate != null){
			publishDateString = PortalHelper.getDateAsString(resultPublishDate,
					ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);	
		}
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_PUBLISHDATE_XML_TAG,
				publishDateString));
		// practitioner id
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_PRACTITIONERID_XML_TAG,
				practitionerId));
		// reporting practitioner id
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_REPORTINGPRACTID_XML_TAG,
				reportingPractitionerId));
		// notes
		xmlBuffer.append(getXMLStartTag(ResultConstants.TR_RESPONSE_RESULT_NOTES_XML_TAG));
		String tempNotes = "";
		if(notesContent != null && !notesContent.trim().equals("")){
			tempNotes = PortalConstants.CHARDATA_START_KEY;
			tempNotes += notesContent;
			tempNotes += PortalConstants.CHARDATA_END_KEY;
		}
		xmlBuffer.append(tempNotes);
		xmlBuffer.append(getXMLEndTag(ResultConstants.TR_RESPONSE_RESULT_NOTES_XML_TAG));
		
		/*xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_NOTES_XML_TAG,
				notesContent));*/
		// normal low
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_NORMALLOW_XML_TAG,
				normalLowValue));
		// normal high
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_NORMALHIGH_XML_TAG,
				normalHighValue));
		// critical low
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_CRITICALLOW_XML_TAG,
				criticalLowValue));
		// critical high
		xmlBuffer.append(PortalHelper.getCompleteXMLTag(
				ResultConstants.TR_RESPONSE_RESULT_CRITICALHIGH_XML_TAG,
				criticalHighValue));
		
		// finally close the "result" tag
		xmlBuffer.append(PortalHelper
				.getXMLEndTag(ResultConstants.TR_RESPONSE_RESULT_XML_TAG));
		
		return xmlBuffer.toString();
	}
	
	/**
	 * 
	 * @param tagKey
	 * @return
	 */
	private String getXMLStartTag(String tagKey){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append(PortalConstants.OPEN_XML_TAG);
		xmlBuffer.append(tagKey);
		xmlBuffer.append(PortalConstants.XML_CLOSE_TAG);
		
		return xmlBuffer.toString();
	}
	
	/**
	 * 
	 * @param tagKey
	 * @return
	 */
	private String getXMLEndTag(String tagKey){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append(PortalConstants.CLOSE_XML_TAG);
		xmlBuffer.append(tagKey);
		xmlBuffer.append(PortalConstants.XML_CLOSE_TAG);
		
		return xmlBuffer.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String getDisplayPublishDate(String format){
		String displayValue = "";
		if(resultPublishDate != null){
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			displayValue = dateFormat.format(resultPublishDate);
		}
		
		return displayValue;
	}
	
	/**
	 * 
	 * @param format
	 * @return
	 */
	public String getDisplayPublishTime(String format){
		String displayValue = "";
		if(resultPublishDate != null){
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			displayValue = dateFormat.format(resultPublishDate);
			int index = displayValue.indexOf(":");
			String hrStr = "";
			int hr = 0;
			String ampmStr = "am";
			if(index >= 0){
				hrStr = displayValue.substring(0, index);
				try {
					hr = Integer.parseInt(hrStr);
				} catch (NumberFormatException e) {
					hr = -1;
				}
				
				if(hr >= 12 && hr<=23){
					ampmStr = "pm";
				}
			}
			displayValue += ampmStr;
		}
		return displayValue;
	}
	
	
	/**
	 * This method returns a boolean array which represents
	 * the type of the result
	 * the boolean array is an array of 6 boolean flag
	 * array[0] - holds the boolean state of critical low result
	 * array[1] - holds the boolean state of low result
	 * array[2] - holds the boolean state of normal result
	 * array[3] - holds the boolean state of high result
	 * array[4] - holds the boolean state of critical high result
	 * array[5] - holds the boolean state of critical result 
	 * @return
	 */
	public boolean[] getResultBoolean(){
		final int TOTAL_RESULTS = 6;
		
		// boolean array storing the type of result
		boolean[] resultBools = new boolean[TOTAL_RESULTS];
		
		if(resultValue != null && !resultValue.trim().equals("")){
			int resultIntValue = PortalHelper.getIntegerValue(resultValue, 0);
			// check the value - if it is 0 it means
			// that result value is string
			// hence return all false boolean value
			if(resultIntValue == 0){
				resultBools[CRITICAL_LOW_INDEX] = false;
				resultBools[LOW_INDEX] = false;
				resultBools[NORMAL_INDEX] = false;
				resultBools[HIGH_INDEX] = false;
				resultBools[CRITICAL_HIGH_INDEX] = false;
				resultBools[CRITICAL_INDEX] = false;
				return resultBools;
			}
			
			int criticalLow = 0;
			// check for critical low value
			if(criticalLowValue != null && !criticalLowValue.trim().equals("")){
				criticalLow = PortalHelper.getIntegerValue(criticalLowValue, 0);
				if(resultIntValue != 0 && resultIntValue < criticalLow){
					resultBools[CRITICAL_LOW_INDEX] = true; 
				}
			}
			
			// check for low value
			int normalLow = 0;
			if(normalLowValue != null && !normalLowValue.trim().equals("")){
				normalLow = PortalHelper.getIntegerValue(normalLowValue, 0);
				if(resultIntValue != 0 && resultIntValue < normalLow){
					resultBools[LOW_INDEX] = true;
				}
			}
			
			// check for high value
			int normalHigh = 0;
			if(normalHighValue != null && !normalHighValue.trim().equals("")){
				normalHigh = PortalHelper.getIntegerValue(normalHighValue, 0);
				if(resultIntValue != 0 && resultIntValue > normalHigh){
					resultBools[HIGH_INDEX] = true;
				}
			}
			
			// check for normal value
			if (resultIntValue != 0
					&& (resultIntValue > normalLow && resultIntValue < normalHigh)) {
				resultBools[NORMAL_INDEX] = true;
			}
			
			// check for critical high value
			int criticalHigh = 0;
			if(criticalHighValue != null && !criticalHighValue.trim().equals("")){
				criticalHigh = PortalHelper.getIntegerValue(criticalHighValue, 0);
				if(resultIntValue != 0 && resultIntValue > criticalHigh){
					resultBools[CRITICAL_HIGH_INDEX] = true;
				}
			}
			
			// check for critical value
			if (resultIntValue != 0
					&& (resultIntValue == criticalLow || resultIntValue == criticalHigh)) {
				resultBools[CRITICAL_INDEX] = true;
			}
			
		}
			
		return resultBools;
	}
	
}
