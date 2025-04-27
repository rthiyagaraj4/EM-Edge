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
package portal.result.viewtestresult.request;

import portal.common.request.BaseRequest;


/**
 * This class provides the list of parameters that 
 * have to be passed as a part of URL parameters while
 * invoking the TestResult service
 * 
 * @author Sandhya
 */
public class TestResultRequest extends BaseRequest {

	// instance variables
	private int resultSetSize;
	
	/**
	 * @return the resultSetSize
	 */
	public int getResultSetSize() {
		return resultSetSize;
	}
	
	/**
	 * @param resultSetSize the resultSetSize to set
	 */
	public void setResultSetSize(int resultSetSize) {
		this.resultSetSize = resultSetSize;
	}

}
