/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.resulttype.response;

import java.util.List;

import portal.common.response.BaseResponse;
/**
 * This class is used as the response object by Result Type service
 * 
 * @author vkodancha
 * 
 */
public class ResultTypeResponse extends BaseResponse {
	private List<ResultType> resultTypeList;

	/**
	 * @return the resultTypeList
	 */
	public List<ResultType> getResultTypeList() {
		return resultTypeList;
	}

	/**
	 * @param resultTypeList the resultTypeList to set
	 */
	public void setResultTypeList(List<ResultType> resultTypeList) {
		this.resultTypeList = resultTypeList;
	}
	
	/**
	 * over ridden for logging purpose
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (resultTypeList == null || resultTypeList.isEmpty()) {
			sb.append("resultTypeList is empty");
		} else {
			for (ResultType resultType : resultTypeList) {
				sb.append(resultType.toString());
			}
		}
		return sb.toString();

	}
}
