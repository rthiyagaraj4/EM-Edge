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

public class ResultDetails implements java.io.Serializable {
	public List<Results> getResults(PatientContext oPatientContext) throws Exception {
		List<Results> oResultsList = new ArrayList<Results>() ;
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
			
			sqlStr.append("SELECT DISTINCT B.short_desc hist_rec_type_desc, Count(1) as hist_rec_type_count, sum(Count(1)) over() TOTL_ROW_CNT  FROM CR_ENCOUNTER_DETAIL A ,  CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C, CR_CLN_EVT_MST_LANG_VW d, CR_CLN_EVT_GRP_LANG_VW e ");
			sqlStr.append(" WHERE B.LANGUAGE_ID      = '" + locale + "'");
			sqlStr.append(" AND B.hist_rec_type      = A.hist_rec_type AND c.hist_rec_type = A.hist_rec_type AND C.event_class  = A.event_class AND C.LANGUAGE_ID = '" + locale + "' AND D.LANGUAGE_ID = '" +locale + "' AND d.hist_rec_type = A.hist_rec_type AND d.event_code = A.event_code AND D.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE ");
			sqlStr.append(" AND E.LANGUAGE_ID(+) = '" + locale + "' AND e.hist_rec_type(+) = A.hist_rec_type AND e.event_group(+) = A.event_group AND e.EVENT_GROUP_TYPE(+) = a.EVENT_GROUP_TYPE AND patient_id = '" + strPatientId + "'");
			sqlStr.append(" AND a.hist_rec_type  IN (SELECT NVL(HIST_REC_TYPE,'*') FROM or_order_category WHERE PREFERRED_VIEW_RESULT_YN='Y' ) AND (FACILITY_ID,ENCOUNTER_ID) IN (SELECT FACILITY_ID,  ENCOUNTER_ID  FROM (SELECT FACILITY_ID,  ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO FROM PR_ENCOUNTER");
			sqlStr.append( " WHERE patient_id= '" + strPatientId + "' )  WHERE RANK_NO < 3   ) AND a.event_class NOT     IN ('CNS$' ,'RFS$', 'RFR$' )  AND NVL(A.STATUS,'`') NOT IN('S','E')  GROUP BY B.short_desc ORDER BY HIST_REC_TYPE_DESC, hist_rec_type_count");
	
			
	
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						Results oResults = new Results();
						oResults.sResultDesc = ((resultSet.getString("hist_rec_type_desc") != null) ?resultSet.getString("hist_rec_type_desc") : "") ;
						oResults.sResultscount = ((resultSet.getString("hist_rec_type_count") != null) ?resultSet.getString("hist_rec_type_count") : "") ;		
						oResults.sCount = ((resultSet.getString("TOTL_ROW_CNT") != null) ?resultSet.getString("TOTL_ROW_CNT") : "0") ;
						oResultsList.add(oResults);
						
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oResultsList;
	}
	
	public List<Results> getResultDetails(PatientContext oPatientContext) throws Exception {
		List<Results> oResultsList = new ArrayList<Results>() ;
		if(oPatientContext != null && oPatientContext.request != null )
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
			//HttpSession session = oPatientContext.session;
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
			
			sqlStr.append("SELECT d.short_desc hist_rec_type_desc,accession_num,hist_data_type,a.event_class,a.result_num,a.event_code,a.contr_sys_id,");
			sqlStr.append(" (SELECT HIST_DATA  FROM cr_encounter_detail_txt  WHERE hist_rec_type = a.hist_rec_type  AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code and dbms_lob.getlength(hist_data)>0 )  hist_data,");
			sqlStr.append(" TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, b.short_desc event_desc,");
			sqlStr.append(" NVL(RESULT_NUM_PREFIX,'') || NVL(RESULT_NUM,'') || NVL(RESULT_STR,'') ||' '|| NVL(RESULT_NUM_UOM,'') care_flow_detail,normal_low,normal_high,");
			sqlStr.append(" (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR, crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,");
			sqlStr.append(" CRIT_LOW_STR,crit_low_str_desc) DESC_CELL_IND FROM CR_CLIN_EVENT_PARAM ) DESC_CELL_IND,");
			sqlStr.append(" (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,");
			sqlStr.append(" crit_high_color_code,CRIT_LOW_STR,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,");
			sqlStr.append(" (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,");
			sqlStr.append(" CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol,");
			sqlStr.append(" TO_CHAR(event_date,'hh24:mi') event_time, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, '" + locale + "' ,'1') reported_by,");
		    sqlStr.append(" DECODE(A.event_code, A.event_group,NULL, E.short_desc) event_group_desc, A.hist_rec_type");
		    sqlStr.append(" FROM CR_ENCOUNTER_DETAIL A , CR_CLN_EVT_MST_LANG_VW b, CR_EVENT_CLASS_LANG_VW C, CR_HIS_RECTYP_LNG_VW d, CR_CLN_EVT_GRP_LANG_VW e");
		    sqlStr.append(" WHERE");
		    sqlStr.append(" d.LANGUAGE_ID = '" + locale + "' ");
		    sqlStr.append(" AND d.hist_rec_type = A.hist_rec_type");			
		    sqlStr.append(" AND c.hist_rec_type = A.hist_rec_type");
		    sqlStr.append(" AND C.event_class  =  A.event_class");	
		    sqlStr.append(" AND C.LANGUAGE_ID = '" + locale + "' ");	
		    sqlStr.append(" AND b.LANGUAGE_ID = '" + locale + "' ");	
		    sqlStr.append(" AND b.hist_rec_type = A.hist_rec_type");		
		    sqlStr.append(" AND b.event_code = A.event_code");
		    sqlStr.append(" AND b.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE");
		    sqlStr.append(" AND E.LANGUAGE_ID(+) = '" + locale + "' ");	
		    sqlStr.append(" AND e.hist_rec_type(+) = A.hist_rec_type");	
		    sqlStr.append(" AND e.event_group(+) = A.event_group");
		    sqlStr.append(" AND e.EVENT_GROUP_TYPE(+)= a.EVENT_GROUP_TYPE");	
		    sqlStr.append(" AND patient_id = '" + strPatientId + "' ");
		    sqlStr.append(" AND d.hist_rec_type in (select hist_rec_type from or_order_category where PREFERRED_VIEW_RESULT_YN='Y' )");
		    sqlStr.append(" AND (FACILITY_ID,ENCOUNTER_ID) IN (SELECT FACILITY_ID, ENCOUNTER_ID FROM (SELECT FACILITY_ID, ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO FROM PR_ENCOUNTER WHERE patient_id = '" + strPatientId + "') WHERE RANK_NO < 3)");
		    sqlStr.append(" AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )");
		    sqlStr.append(" AND NVL(A.STATUS,'`') NOT IN('S','E')");
		    sqlStr.append(" ORDER BY HIST_REC_TYPE_DESC, a.event_date DESC, hist_rec_type, request_num_seq, event_group_desc, a.event_group, event_desc, a.event_code ");
		    
			
	       
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						Results oResults = new Results();
						oResults.sHistRecTypeDesc = ((resultSet.getString("hist_rec_type_desc") != null) ?resultSet.getString("hist_rec_type_desc") : "") ;
						oResults.sAccession_num = ((resultSet.getString("accession_num") != null) ?resultSet.getString("accession_num") : "") ;
						oResults.sHistDataType = ((resultSet.getString("hist_data_type") != null) ?resultSet.getString("hist_data_type") : "") ;
						oResults.sEventClass = ((resultSet.getString("event_class") != null) ?resultSet.getString("event_class") : "") ;
						oResults.sHistData = ((resultSet.getString("hist_data") != null) ?resultSet.getString("hist_data") : "") ;
						oResults.sEventDateTime = ((resultSet.getString("event_date_time") != null) ?resultSet.getString("event_date_time") : "") ;		
						oResults.sEventDesc = ((resultSet.getString("event_desc") != null) ?resultSet.getString("event_desc") : "") ;
						oResults.sCareFlowDetail = ((resultSet.getString("care_flow_detail") != null) ?resultSet.getString("care_flow_detail") : "") ;
						oResults.sDescCellIndicator = ((resultSet.getString("desc_cell_ind") != null) ?resultSet.getString("desc_cell_ind") : "") ;
						oResults.sResultNum = resultSet.getDouble("RESULT_NUM");
						//oResults.sResultNum = ((resultSet.getDouble("RESULT_NUM") != null && !resultSet.getDouble("RESULT_NUM").equals("")) ?resultSet.getString("RESULT_NUM") : "0") ;
						oResults.sColorCellIndicator = ((resultSet.getString("COLOR_CELL_IND") != null) ?resultSet.getString("COLOR_CELL_IND") : "") ;
						oResults.sNormalRangeSymbol = ((resultSet.getString("normal_range_symbol") != null) ?resultSet.getString("normal_range_symbol") : "") ;
						oResults.sNormalLow = ((resultSet.getString("normal_low") != null) ?resultSet.getString("normal_low") : "") ;
						oResults.sNormalHigh = ((resultSet.getString("normal_high") != null) ?resultSet.getString("normal_high") : "") ;
						oResults.sEventTime = ((resultSet.getString("event_time") != null) ?resultSet.getString("event_time") : "") ;
						oResults.sPatientClass = ((resultSet.getString("PATIENT_CLASS") != null) ?resultSet.getString("PATIENT_CLASS") : "") ;
						oResults.sReportedBy = ((resultSet.getString("reported_by") != null) ?resultSet.getString("reported_by") : "") ;
						oResults.sEventGroupDesc = ((resultSet.getString("event_group_desc") != null) ?resultSet.getString("event_group_desc") : "") ;
						oResults.sContrSysId = ((resultSet.getString("contr_sys_id") != null) ?resultSet.getString("contr_sys_id") : "") ;
						oResults.sContrSysEventCode = ((resultSet.getString("event_code") != null) ?resultSet.getString("event_code") : "") ;
						
						
						oResults.sHistRecType = ((resultSet.getString("hist_rec_type") != null) ?resultSet.getString("hist_rec_type") : "") ;
						oResultsList.add(oResults);
						
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		
		}
		return oResultsList;
	}
 
}
