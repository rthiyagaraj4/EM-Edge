/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.results.healthobject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



/**
 * @author SaraswathiR 
 *
 */
public class ResultGroupItem {

	private String resultGroupName;
	private String resultGroupCode;
	private String resultName;
	private String resultCode;
	private String resultUom;
	private String resultDataType;
	private String resultNumPrefix;
	private double normalLow;
	private double normalHigh;
	private double criticalLow;
	private double criticalHigh;
	private String contrSysId;
	private ArrayList<ResultValue> resValues = new ArrayList<ResultValue>();
	
	//This method is for forming the tabular view in UI
	//Assumption is that the parameter dates is sorted in descending order
	public ArrayList<ResultValue> getResValuesForDates(ArrayList<Date> dates){
		
		ResultValue emptyResValue = new ResultValue();
		ArrayList<ResultValue> resValAllDates = new ArrayList<ResultValue>();
		//to identify an empty value
		emptyResValue.setAccessionNum("NULL");
		emptyResValue.setDate("NULL");
		for(int m=0,n=0;m<dates.size();m++,n++){
			if(n>=resValues.size()){
				resValAllDates.add(emptyResValue);
			}
			else if(dates.get(m).equals(resValues.get(n).getEventTimestamp())){
				resValAllDates.add(resValues.get(n));
			}
			else{
				n--;
				resValAllDates.add(emptyResValue);
			}
			
			
		}
		
		return resValAllDates;
	}
	public String getResultValuesCSV(){
		StringBuffer csv = new StringBuffer("");
		if(resValues!= null && !resValues.isEmpty()){
			for(int i=0;i<resValues.size();i++){
				if(i == 0){
					csv.append(resValues.get(i).getDblAsStrValue());
				}
				else{
					csv.append(","+resValues.get(i).getDblAsStrValue());
				}
				
			}
		}
		return csv.toString();
	}
	public String getResultDateCSV(){
		StringBuffer csv = new StringBuffer("");
		if(resValues!= null && !resValues.isEmpty()){
			for(int i=0;i<resValues.size();i++){
				if(i == 0){
					csv.append(resValues.get(i).getDate());
				}
				else{
					csv.append(","+resValues.get(i).getDate());
				}
				
			}
		}
		return csv.toString();
	}
	
	public String getResultDateCSV(String dateFormat){
		StringBuffer csv = new StringBuffer("");
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try{
			if(resValues!= null && !resValues.isEmpty()){
				for(int i=0;i<resValues.size();i++){
					if(i == 0){
						csv.append(sdf.format(resValues.get(i).getEventTimestamp()));
					}
					else{
						csv.append(","+sdf.format(resValues.get(i).getEventTimestamp()));
					}
					
				}
			}
		}
		catch(Exception e){
			//in case of parse exception don't apply any date format and return plain CSV
			csv.append(getResultDateCSV());
		}
		return csv.toString();
	}
	//if resultGroupCode is equal then two ResultGroupItem objects are equal
	public boolean equals(Object obj){
		if(obj instanceof ResultGroupItem){
			ResultGroupItem resItem = (ResultGroupItem)obj;
			if(resItem.getResultGroupCode().equals(this.getResultGroupCode())){
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 * @return the resultName
	 */
	public String getResultName() {
		return resultName;
	}
	/**
	 * @param resultName the resultName to set
	 */
	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * @return the resultGroupName
	 */
	public String getResultGroupName() {
		return resultGroupName;
	}
	/**
	 * @param resultGroupName the resultGroupName to set
	 */
	public void setResultGroupName(String resultGroupName) {
		this.resultGroupName = resultGroupName;
	}
	/**
	 * @return the resultGroupCode
	 */
	public String getResultGroupCode() {
		return resultGroupCode;
	}
	/**
	 * @param resultGroupCode the resultGroupCode to set
	 */
	public void setResultGroupCode(String resultGroupCode) {
		this.resultGroupCode = resultGroupCode;
	}
	/**
	 * @return the resultUom
	 */
	public String getResultUom() {
		return resultUom;
	}
	/**
	 * @param resultUom the resultUom to set
	 */
	public void setResultUom(String resultUom) {
		this.resultUom = resultUom;
	}
	/**
	 * @return the resultDataType
	 */
	public String getResultDataType() {
		return resultDataType;
	}
	/**
	 * @param resultDataType the resultDataType to set
	 */
	public void setResultDataType(String resultDataType) {
		this.resultDataType = resultDataType;
	}

	/**
	 * @return the resultNumPrefix
	 */
	public String getResultNumPrefix() {
		return resultNumPrefix;
	}
	/**
	 * @param resultNumPrefix the resultNumPrefix to set
	 */
	public void setResultNumPrefix(String resultNumPrefix) {
		this.resultNumPrefix = resultNumPrefix;
	}

	/**
	 * @return the resValues
	 */
	public ArrayList<ResultValue> getResValues() {
		return resValues;
	}

	/**
	 * @param resValues the resValues to set
	 */
	public void setResValues(ArrayList<ResultValue> resValues) {
		this.resValues = resValues;
	}

	/**
	 * @return the normalLow
	 */
	public double getNormalLow() {
		return normalLow;
	}

	/**
	 * @param normalLow the normalLow to set
	 */
	public void setNormalLow(double normalLow) {
		this.normalLow = normalLow;
	}

	/**
	 * @return the normalHigh
	 */
	public double getNormalHigh() {
		return normalHigh;
	}

	/**
	 * @param normalHigh the normalHigh to set
	 */
	public void setNormalHigh(double normalHigh) {
		this.normalHigh = normalHigh;
	}

	/**
	 * @return the criticalLow
	 */
	public double getCriticalLow() {
		return criticalLow;
	}

	/**
	 * @param criticalLow the criticalLow to set
	 */
	public void setCriticalLow(double criticalLow) {
		this.criticalLow = criticalLow;
	}

	/**
	 * @return the criticalHigh
	 */
	public double getCriticalHigh() {
		return criticalHigh;
	}

	/**
	 * @param criticalHigh the criticalHigh to set
	 */
	public void setCriticalHigh(double criticalHigh) {
		this.criticalHigh = criticalHigh;
	}

	/**
	 * @return the contrSysId
	 */
	public String getContrSysId() {
		return contrSysId;
	}

	/**
	 * @param contrSysId the contrSysId to set
	 */
	public void setContrSysId(String contrSysId) {
		this.contrSysId = contrSysId;
	}
}
