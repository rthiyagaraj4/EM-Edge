/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.resulttype.response;

/**
 * This class is used in Result Type response as an element of Result Type
 * 
 * @author vkodancha
 * 
 */
public class ResultType {

	/**
	 * constructor
	 * @param resultTypeId
	 * @param resultName
	 */
	public ResultType(String resultTypeId, String resultName) {
		this.resultTypeId = resultTypeId;
		this.resultName = resultName;
	}

	// instance variables
	private String resultTypeId;
	private String resultName;

	/**
	 * @return the resultTypeId
	 */
	public String getResultTypeId() {
		return resultTypeId;
	}

	/**
	 * @return the resultName
	 */
	public String getResultName() {
		return resultName;
	}
	/**
	 * over ridden for logging purpose
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("resultTypeId :"+resultTypeId);
		sb.append("resultName :"+resultName);
		return super.toString();
	}
}
