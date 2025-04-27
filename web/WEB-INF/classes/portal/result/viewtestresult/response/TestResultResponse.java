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
package portal.result.viewtestresult.response;

import java.util.ArrayList;
import java.util.List;

import portal.common.response.BaseResponse;


/**
 * @author GRamamoorthy
 *
 */
public class TestResultResponse extends BaseResponse {

	private List<TestResult> testDetailsList = new ArrayList<TestResult>();

	/**
	 * @return the testDetailsList
	 */
	public List<TestResult> getTestDetailsList() {
		return testDetailsList;
	}

	/**
	 * @param testDetailsList the testDetailsList to set
	 */
	public void setTestDetailsList(List<TestResult> testDetailsList) {
		this.testDetailsList = testDetailsList;
	}
}
