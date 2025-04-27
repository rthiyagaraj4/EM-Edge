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
package eIPAD.chartsummary.results.bc;

import java.util.ArrayList;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.results.dao.ResultsDAO;
import eIPAD.chartsummary.results.daoimpl.ResultsDAOImpl;
import eIPAD.chartsummary.results.request.ResultsRequest;
import eIPAD.chartsummary.results.response.ResultsResponse;

/**
 * @author SaraswathiR 
 *
 */
public class ResultsBC {
	public ResultsResponse getResultDetails(ResultsRequest resReq){
		ResultsResponse resultsResponse;
		ResultsDAO dao = new ResultsDAOImpl();
		resultsResponse = dao.getResultDetails(resReq);
		return resultsResponse;
	}
	
	public int getResultsCount(PatContext patContext, ArrayList<String> catList, String resDataType){
		int count = 0;
		ResultsDAO dao = new ResultsDAOImpl();
		count = dao.getResultsCount(patContext,catList, resDataType);
		return count;
	}
	public String getResultNotes(String histRecType, String contSysId, String accessionNum, String contrSysEventCode){
		String note;
		ResultsDAO dao = new ResultsDAOImpl();
		note = dao.getResultNotes(histRecType, contSysId, accessionNum, contrSysEventCode);
		return note;
	}
}
