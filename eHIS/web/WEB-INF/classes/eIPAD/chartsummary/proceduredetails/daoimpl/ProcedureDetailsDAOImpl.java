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
package eIPAD.chartsummary.proceduredetails.daoimpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.daoimpl.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.proceduredetails.healthobject.*;
import eIPAD.chartsummary.proceduredetails.request.*;
import eIPAD.chartsummary.proceduredetails.dao.*;
import eIPAD.chartsummary.proceduredetails.response.*;
/**
 * @author GaneshkumarC 
 *
 */
public class ProcedureDetailsDAOImpl extends GenericDAOImpl implements ProcedureDetailsDAO {
	public ProcedureDetailsResponse getProcedureDetails(ProcedureDetailsRequest oProcDtlsReq)
	{
		Connection connection 		= null;
		Statement stmt				= null;
		PreparedStatement pStmt = null;
		ResultSet resultSet 		= null;
		String locale = "en";
		String strPatientId = "";
		String facilityId = "";
		StringBuffer sqlStr = new StringBuffer("");
		ErrorInfo oErrInfo = new ErrorInfo();
		
		List<ProcedureDetailsHO> lstProcDtls = new ArrayList<ProcedureDetailsHO>();
		ProcedureDetailsResponse oProcDtlRes = new ProcedureDetailsResponse();
		
		if(oProcDtlsReq != null)
		{
			PatContext oPatContext = oProcDtlsReq.getPatientContext();
			if(oPatContext != null)
			{
				strPatientId = checkForNull(oPatContext.getPatientId());
				locale =  checkForNull(oPatContext.getLocale());
				facilityId = checkForNull(oPatContext.getFacilityId());
				oErrInfo.setErrorType(Errors.COMMON_SUCCESS, locale);
				/*
				sqlStr.append("SELECT RTRIM (proc_code) proc_code, short_desc Procedure_Description, TO_CHAR (a.proc_date,'dd/mm/yyyy hh24:mi') proc_date, TO_CHAR (end_datetime,'dd/mm/yyyy hh24:mi') end_date_time, ");
				sqlStr.append(" decode(a.CURR_STATUS, 'R', 'Recorded','M', 'Modified') Status,  proc_code_scheme, am_get_desc.am_practitioner (a.practitioner_id, '" + locale+ "', '1' ) practitioner_name, am_get_desc.am_practitioner (a.anaesthetist1, ");
			    sqlStr.append(" '" + locale+ "','1') anaesthetist, AM_GET_DESC.AM_ANAESTHESIA(ANAESTHESIA_CODE,'" + locale+ "','1')  anaesthesia FROM pr_encounter_procedure a, mr_term_code WHERE RTRIM (proc_code) IS NOT NULL  AND patient_id ='" + strPatientId + "' ");
				sqlStr.append(" AND srl_no IS NOT NULL AND term_code = RTRIM (proc_code)  AND term_set_id = a.proc_code_scheme ");  
			    sqlStr.append(" ORDER BY a.proc_date DESC ");
			    */
				sqlStr.append(" SELECT   proc_code,a.proc_narration procedure_description, TO_CHAR (a.proc_date,'dd/mm/yyyy hh24:mi') proc_date,");
				sqlStr.append(" decode(a.CURR_STATUS, 'R', 'Recorded','M', 'Modified') Status, proc_code_scheme, am_get_desc.am_practitioner (a.practitioner_id, '" + locale+ "', '1' ) practitioner_name, ");
				sqlStr.append("  proc_date dummydate, a.srl_no srl_no, a.error_yn error_yn ");
				sqlStr.append("  FROM pr_encounter_procedure a ");
				sqlStr.append("  WHERE a.facility_id = '" + facilityId + "' AND a.patient_id = '" + strPatientId+"' AND NVL (error_yn, 'N') != 'Y' ORDER BY dummydate DESC ");
			    try
			    {
			    	connection = createConnection();
					if(connection != null)
					{
						//stmt = connection.createStatement();
					    pStmt = connection.prepareStatement(sqlStr.toString());
					}
					if(pStmt != null)
					{
						//resultSet = stmt.executeQuery(sqlStr.toString());
						resultSet = pStmt.executeQuery();
					}
					if(resultSet != null)
					{
						while(resultSet.next())
						{
							ProcedureDetailsHO oProcDtlHO = new ProcedureDetailsHO();
							
							oProcDtlHO.setProcedureCode(checkForNull(resultSet.getString("proc_code")));
							oProcDtlHO.setProcedureDescription(checkForNull(resultSet.getString("Procedure_Description")));
							oProcDtlHO.setProcedureDateTime(checkForNull(resultSet.getString("proc_date")));
							oProcDtlHO.setProcedureCodeScheme(checkForNull(resultSet.getString("proc_code_scheme")));
							oProcDtlHO.setStatus(checkForNull(resultSet.getString("Status")));
							oProcDtlHO.setPractitionerName(checkForNull(resultSet.getString("practitioner_name")));
							
							lstProcDtls.add(oProcDtlHO);
						}
					}
					if(lstProcDtls != null && lstProcDtls.size() == 0)
					{
						oErrInfo.setErrorType(Errors.PROCEDUREDETAILS_EMPTY_DATA, locale);
					}
					oProcDtlRes.setLstProcedureDetails(lstProcDtls);
					
			    }
			    catch(Exception e)
			    {
			    	
					e.printStackTrace();
					oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
			    }
			    finally
			    {
			    	int conCloseFailure = closeConnection(connection,pStmt,resultSet);
			    	if(conCloseFailure > 0)
					{
						System.out.println("Connection not closed in the method eIPAD.chartsummary.allergies.daoimpl.AllergyDAOImpl.getAllergyDetails");
					}
			    }
			}
			else
			{
				oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
			}
		}
		else
		{
			oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		//oProcDtlRes.setErrorInfo(oErrInfo);
		oProcDtlRes.getErrorsList().add(oErrInfo);
		return oProcDtlRes;
	}
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
}
