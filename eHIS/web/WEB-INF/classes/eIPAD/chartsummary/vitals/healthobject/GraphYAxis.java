/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;

public class GraphYAxis implements java.io.Serializable{

	/**
	 * This class is used to hold Y axis values for a graph. 
	 */
	private static final long serialVersionUID = 1L;
	
	protected double resultNumber;
	
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
