/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultdetails.response;

import java.util.ArrayList;
import java.util.List;

import portal.common.response.BaseResponse;


/**
 * Response class for testResult details
 * 
 * @author skrishnared2
 *
 */
public class TestResultDetailsResponse extends BaseResponse{

	private List<TestResultDetails> testResultDetailsList = new ArrayList<TestResultDetails>();

	/**
	 * @return the testResultDetailsList
	 */
	public List<TestResultDetails> getTestResultDetailsList() {
		return testResultDetailsList;
	}

	/**
	 * @param testResultDetailsList the testResultDetailsList to set
	 */
	public void setTestResultDetailsList(
			List<TestResultDetails> testResultDetailsList) {
		this.testResultDetailsList = testResultDetailsList;
	}
	
	/**
	 * This method is over ridden for logging purpose
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		if(this.testResultDetailsList!=null && !this.testResultDetailsList.isEmpty()){
			for (TestResultDetails testResultDetails : testResultDetailsList) {
				sb.append(testResultDetails.toString());
			}
		}
		return sb.toString();
	}
	
}
