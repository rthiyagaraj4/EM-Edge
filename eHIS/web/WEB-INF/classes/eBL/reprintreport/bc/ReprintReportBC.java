/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.reprintreport.bc;

import eBL.reprintreport.dao.ReprintReportDAO;
import eBL.reprintreport.dao.ReprintReportDAOImpl;
import eBL.reprintreport.request.ReprintRequest;
import eBL.reprintreport.response.ReprintResponse;

public class ReprintReportBC {
	
	ReprintReportDAO reprintDao = null;

	public ReprintResponse insertToProgParamBulk(ReprintRequest request){
		ReprintResponse response = null;
		reprintDao = new ReprintReportDAOImpl();
		response = reprintDao.insertToProgParamBulk(request);
		return response;
	}
	
}
