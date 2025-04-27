/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultreport.svc;

import portal.result.viewtestresultreport.request.TestReportRequest;
import portal.result.viewtestresultreport.response.TestReportResponse;

/**
 *  This interface defines a method for getting test reports
 * 
 * @author skrishnared2
 *
 */
public interface TestReportSvc {

	/**
	 * Service method for retrieving test result details
	 * @param request
	 * @return
	 */
	public TestReportResponse getTestReport(TestReportRequest request);
}
