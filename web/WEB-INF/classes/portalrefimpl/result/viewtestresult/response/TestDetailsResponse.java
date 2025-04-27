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
package portalrefimpl.result.viewtestresult.response;

import java.util.ArrayList;
import java.util.List;

import portalrefimpl.common.response.BaseResponse;




/**
 * @author GRamamoorthy
 *
 */
public class TestDetailsResponse extends BaseResponse {

	private List<TestDetails> testDetailsList = new ArrayList<TestDetails>();

	/**
	 * @return the testDetailsList
	 */
	public List<TestDetails> getTestDetailsList() {
		return testDetailsList;
	}

	/**
	 * @param testDetailsList the testDetailsList to set
	 */
	public void setTestDetailsList(List<TestDetails> testDetailsList) {
		this.testDetailsList = testDetailsList;
	}
	
	
	
}
