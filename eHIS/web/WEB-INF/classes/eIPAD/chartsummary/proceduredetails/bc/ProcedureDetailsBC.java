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
package eIPAD.chartsummary.proceduredetails.bc;

/**
 * @author GaneshkumarC 
 *
 */
import eIPAD.chartsummary.proceduredetails.dao.*;
import eIPAD.chartsummary.proceduredetails.daoimpl.*;
import eIPAD.chartsummary.proceduredetails.request.*;
import eIPAD.chartsummary.proceduredetails.response.*;

public class ProcedureDetailsBC {
	public ProcedureDetailsResponse getProcedureDetails(ProcedureDetailsRequest oProcDtlsReq)
	{
		ProcedureDetailsResponse oProcDtlRes;
		ProcedureDetailsDAO oProcDtlDAO = new ProcedureDetailsDAOImpl();
		oProcDtlRes = oProcDtlDAO.getProcedureDetails(oProcDtlsReq);
		return oProcDtlRes;
	}

}
