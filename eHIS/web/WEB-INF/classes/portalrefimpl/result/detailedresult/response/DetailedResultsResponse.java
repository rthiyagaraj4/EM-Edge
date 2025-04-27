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
package portalrefimpl.result.detailedresult.response;

import java.util.List;

import portalrefimpl.common.response.BaseResponse;

/**
 * This is the response class storing the detailed results
 * This class extends BaseResponse class
 * @author GRamamoorthy
 *
 */
public class DetailedResultsResponse extends BaseResponse {

	private List<DetailedResult> testResultList = null;

	/**
	 * @return the testResultList
	 */
	public List<DetailedResult> getTestResultList() {
		return testResultList;
	}

	/**
	 * @param testResultList the testResultList to set
	 */
	public void setTestResultList(List<DetailedResult> testResultList) {
		this.testResultList = testResultList;
	}
	
	
	
}
