/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD;
import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.*;
import javax.servlet.http.*;

import eIPAD.HealthObjects.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;
public class ProcedureDetails implements java.io.Serializable  {
	public List<ProcedureDet> getProcedureDet(PatientContext oPatientContext) throws Exception {
		List<ProcedureDet> oProcedureDetList = new ArrayList<ProcedureDet>() ;
		if(oPatientContext != null && oPatientContext.request != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strRowCount = "";
			String strPatientId = "";
			String strEncounterId = "";
			HttpServletRequest request = oPatientContext.request;
			
			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}
			if(oPatientContext.sClinicianId != null && !oPatientContext.sClinicianId.equals("") )
			{
				clinicianId  = oPatientContext.sClinicianId;
			}
			if(oPatientContext.sPracType != null && !oPatientContext.sPracType.equals(""))
			{
				strPracType = oPatientContext.sPracType;
			}
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
			sqlStr.append("SELECT proc_narration,proc_date, practitioner_name,COUNT(*) OVER() TOTL_ROW_CNT FROM ");
			sqlStr.append("(SELECT a.proc_narration,TO_CHAR (a.proc_date,'dd/mm/yyyy hh24:mi') proc_date,am_get_desc.am_practitioner (a.practitioner_id,'" + locale+ "','1' ) practitioner_name ");
			sqlStr.append(" FROM pr_encounter_procedure a WHERE a.facility_id = '" + facility_id + "' AND a.patient_id = '" + strPatientId + "' AND NVL (error_yn, 'N') != 'Y' ");
			sqlStr.append(" ORDER BY a.proc_date DESC) ");
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						ProcedureDet oProcedureDet = new ProcedureDet();
						
						oProcedureDet.setsProcNarration(((resultSet.getString("proc_narration") != null) ?resultSet.getString("proc_narration") : "") );
						
						
						
						oProcedureDet.setsProcDate(((resultSet.getString("proc_date") != null) ?resultSet.getString("proc_date") : "")) ;	
						oProcedureDet.setsPracName(((resultSet.getString("practitioner_name") != null) ?resultSet.getString("practitioner_name") : "")) ;	
						oProcedureDet.setsProcedureCount(((resultSet.getString("TOTL_ROW_CNT") != null) ?resultSet.getString("TOTL_ROW_CNT") : "0")) ;
						oProcedureDetList.add(oProcedureDet);
						
				}
			} catch ( Exception e )	{
				System.out.println(sqlStr.toString());
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oProcedureDetList;
	}
	public List<ProcedureDet> getProcedureDetails(PatientContext oPatientContext) throws Exception {
		List<ProcedureDet> oProcedureDetList = new ArrayList<ProcedureDet>() ;
		if(oPatientContext != null && oPatientContext.request != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String strPracType = "";
			String strRowCount = "";
			String strPatientId = "";
			String strEncounterId = "";
			HttpServletRequest request = oPatientContext.request;
			
			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}
			if(oPatientContext.sClinicianId != null && !oPatientContext.sClinicianId.equals("") )
			{
				clinicianId  = oPatientContext.sClinicianId;
			}
			if(oPatientContext.sPracType != null && !oPatientContext.sPracType.equals(""))
			{
				strPracType = oPatientContext.sPracType;
			}
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
			sqlStr.append("SELECT RTRIM (proc_code) proc_code, short_desc Procedure_Description, TO_CHAR (a.proc_date,'dd/mm/yyyy hh24:mi') proc_date, TO_CHAR (end_datetime,'dd/mm/yyyy hh24:mi') end_date_time, ");
			sqlStr.append(" decode(a.CURR_STATUS, 'R', 'Recorded','M', 'Modified') Status,  am_get_desc.am_practitioner (a.practitioner_id, '" + locale+ "', '1' ) practitioner_name, am_get_desc.am_practitioner (a.anaesthetist1, ");
		    sqlStr.append(" '" + locale+ "','1') anaesthetist, AM_GET_DESC.AM_ANAESTHESIA(ANAESTHESIA_CODE,'" + locale+ "','1')  anaesthesia FROM pr_encounter_procedure a, mr_term_code WHERE RTRIM (proc_code) IS NOT NULL  AND patient_id ='" + strPatientId + "' ");
			sqlStr.append(" AND srl_no IS NOT NULL AND term_code = RTRIM (proc_code)  AND term_set_id = a.proc_code_scheme ");  
		    sqlStr.append(" ORDER BY a.proc_date DESC ");
		  
		    		
		  
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						ProcedureDet oProcedureDet = new ProcedureDet();
						oProcedureDet.setsProcCode(((resultSet.getString("proc_code") != null) ?resultSet.getString("proc_code") : "") );
						oProcedureDet.setsProcDesc(((resultSet.getString("Procedure_Description") != null) ?resultSet.getString("Procedure_Description") : "") );
						oProcedureDet.setsProcDate(((resultSet.getString("proc_date") != null) ?resultSet.getString("proc_date") : "")) ;
						oProcedureDet.setsEndDate(((resultSet.getString("end_date_time") != null) ?resultSet.getString("end_date_time") : "")) ;
						oProcedureDet.setsStatus(((resultSet.getString("Status") != null) ?resultSet.getString("Status") : "")) ;
						oProcedureDet.setsPracName(((resultSet.getString("practitioner_name") != null) ?resultSet.getString("practitioner_name") : "")) ;	
						oProcedureDet.setsAnaesthetist(((resultSet.getString("anaesthetist") != null) ?resultSet.getString("anaesthetist") : "")) ;
						oProcedureDet.setsAnaesthesia(((resultSet.getString("anaesthesia") != null) ?resultSet.getString("anaesthesia") : "")) ;
						oProcedureDetList.add(oProcedureDet);
						
				}
			} catch ( Exception e )	{
				System.out.println(sqlStr.toString());
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oProcedureDetList;
	}

}
