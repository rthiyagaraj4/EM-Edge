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
package eIPAD.chartsummary.results.dao;

import java.util.ArrayList;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.results.request.ResultsRequest;
import eIPAD.chartsummary.results.response.ResultsResponse;

/**
 * @author SaraswathiR 
 *
 */
public interface ResultsDAO {

	public ResultsResponse getResultDetails(ResultsRequest resReq);
	public int getResultsCount(PatContext patContext, ArrayList<String> catList, String resDataType);
	public String getResultNotes(String histRecType, String contSysId, String accessionNum, String contrSysEventCode);
}
