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
package portalrefimpl.result;



import portalrefimpl.result.detailedresult.response.ResultStatus;

/**
 * @author GRamamoorthy
 *
 */
public class ResultHelper {

	/**
	 * This utility method gets the result status enum	
	 * @param resultStatusString
	 * @return
	 */
	public static ResultStatus getResultStatus(String resultStatusString){
		ResultStatus resultStatus = ResultStatus.INPROGRESS;
		if (resultStatusString != null
				&& ResultConstants.DETAILED_TESTRESULT_STATUS_VALUE
						.equalsIgnoreCase(resultStatusString)) {
			resultStatus = ResultStatus.COMPLETED;
		}
		
		return resultStatus;
	}
	
}
