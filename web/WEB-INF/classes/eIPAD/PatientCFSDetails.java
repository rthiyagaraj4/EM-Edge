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

public class PatientCFSDetails implements java.io.Serializable {
	public List<PatientCFS> getPatientCFS(PatientContext oPatientContext) throws Exception {
		List<PatientCFS> oPatientCFSList = new ArrayList<PatientCFS>() ;
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
			/*
			sqlStr.append("select event_desc,care_flow_detail,desc_cell_ind,RESULT_NUM, COLOR_CELL_IND, normal_range_symbol, normal_low,normal_high, count(*) over() TOTL_ROW_CNT   from  ( SELECT b.short_desc event_desc,   EVENT_DATE, RESULT_NUM,  ROW_NUMBER() OVER(PARTITION BY b.short_desc ORDER BY EVENT_DATE DESC) RANK_EVENT_DT, NVL(RESULT_NUM_PREFIX,'')   ||NVL(RESULT_NUM,'') ||NVL(RESULT_STR,'') ||' ' ||NVL(RESULT_NUM_UOM,'') care_flow_detail, NORMAL_LOW, NORMAL_HIGH,");
			sqlStr.append(" (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR, crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR, crit_low_str_desc) DESC_CELL_IND FROM CR_CLIN_EVENT_PARAM ) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol FROM cr_encounter_detail a, CR_CLN_EVT_MST_LANG_VW b, CR_EVENT_CLASS_LANG_VW C, CR_CLN_EVT_GRP_LANG_VW e ");
			sqlStr.append(" WHERE a.hist_rec_type = 'PTCR' AND b.hist_rec_type = a.hist_rec_type AND b.event_code  = a.event_code AND b.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE AND b.language_id = '" +locale + "' AND e.hist_rec_type(+)  = A.hist_rec_type AND e.event_group(+) = A.event_group AND e.EVENT_GROUP_TYPE(+) = a.EVENT_GROUP_TYPE AND e.language_id(+) = '" + locale + "' AND c.hist_rec_type = a.hist_rec_type");
			sqlStr.append(" AND c.event_class  = a.event_class AND c.language_id = '" + locale+ "' AND patient_id  = '" + strPatientId + "' AND (FACILITY_ID,ENCOUNTER_ID) IN (SELECT FACILITY_ID, ENCOUNTER_ID FROM (SELECT FACILITY_ID, ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO FROM PR_ENCOUNTER WHERE patient_id= '" + strPatientId + "' ) WHERE RANK_NO < 5 ) AND A.HIST_REC_TYPE='PTCR' and (nvl(A.PROTECTION_IND,'N')!='Z' )");
			sqlStr.append(" and nvl(a.STATUS,'`') not in('S','E') order by EVENT_DATE desc,c.SHORT_DESC,request_num_seq,e.short_desc,a.event_group,b.short_desc,a.event_code ) where RANK_EVENT_DT = 1  ");
	*/
			sqlStr.append("select event_desc,care_flow_detail,result_num,COLOR_CELL_IND,normal_range_symbol,desc_cell_ind,normal_low,normal_high,count(*) over() TOTL_ROW_CNT from ");
			sqlStr.append(" (SELECT   event_date dummydate, c.short_desc event_class,b.short_desc event_desc, e.short_desc event_group_desc,TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') event_date,ROW_NUMBER() OVER(PARTITION BY b.short_desc ORDER BY event_date DESC) RANK_EVENT_DT, result_num, NVL (result_num_prefix, '') || NVL (result_num, '')|| NVL (result_str, '')|| ' '|| NVL (result_num_uom, '') care_flow_detail,normal_low, normal_high, a.ext_image_appl_id, a.ext_image_obj_id,a.contr_sys_id, a.accession_num, a.contr_sys_event_code,NVL ((SELECT hist_data  FROM cr_encounter_detail_txt WHERE hist_rec_type = a.hist_rec_type AND contr_sys_id = a.contr_sys_id ");
			sqlStr.append("	AND accession_num = a.accession_num AND contr_sys_event_code = a.contr_sys_event_code  AND DBMS_LOB.getlength (hist_data) > 0),'' ) text_exisits, a.normalcy_ind,(SELECT DECODE (a.normalcy_ind,high_str, high_color_code,low_str, low_color_code,crit_str, crit_color_code,abn_str, abn_color_code,crit_high_str, crit_high_color_code,crit_low_str, crit_low_color_code,'NONE' ) FROM cr_clin_event_param) color_cell_ind,(SELECT DECODE (a.normalcy_ind,high_str, high_str_desc,low_str, low_str_desc,crit_str, crit_str_desc,abn_str, abn_str_desc,crit_high_str, crit_high_str_desc,crit_low_str, crit_low_str_desc ");
			sqlStr.append("  ) desc_cell_ind FROM cr_clin_event_param) desc_cell_ind,(SELECT DECODE (a.normalcy_ind, high_str, high_symbol_icon,low_str, low_symbol_icon,crit_str, crit_symbol_icon,abn_str, abn_symbol_icon,crit_high_str, crit_high_symbol_icon, crit_low_str, crit_low_symbol_icon,'NONE' )FROM cr_clin_event_param) normal_range_symbol,a.hist_data_type, a.normalcy_str,a.hist_rec_type FROM cr_encounter_detail a, cr_cln_evt_mst_lang_vw b,cr_event_class_lang_vw c,cr_cln_evt_grp_lang_vw e WHERE a.hist_rec_type = 'PTCR' AND b.hist_rec_type = a.hist_rec_type AND b.event_code = a.event_code  AND b.event_code_type = a.event_code_type  AND b.language_id = '" + locale + "' ");
	        sqlStr.append(" AND e.hist_rec_type(+) = a.hist_rec_type AND e.event_group(+) = a.event_group AND e.event_group_type(+) = a.event_group_type AND e.language_id(+) = '" + locale + "' AND c.hist_rec_type = a.hist_rec_type AND c.event_class = a.event_class AND c.language_id = '" + locale + "' AND patient_id = '" + strPatientId + "' AND (facility_id, encounter_id) IN ( SELECT facility_id, encounter_id  FROM (SELECT facility_id, encounter_id, ROW_NUMBER () OVER (ORDER BY visit_adm_date_time DESC) rank_no FROM pr_encounter WHERE patient_id = '" + strPatientId + "')  WHERE rank_no < 5) AND a.hist_rec_type = 'PTCR' AND NVL (a.status, '`') NOT IN ('S', 'E') ORDER BY dummydate DESC, c.short_desc,  request_num_seq, e.short_desc, a.event_group, b.short_desc,a.event_code) ");
	        sqlStr.append(" where RANK_EVENT_DT = 1 ");
		   
			
	
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						PatientCFS oPatientCFS = new PatientCFS();
						
						oPatientCFS.setsDesc(((resultSet.getString("event_desc") != null) ?resultSet.getString("event_desc") : "")) ;
						oPatientCFS.setsCareFlowDetail(((resultSet.getString("care_flow_detail") != null) ?resultSet.getString("care_flow_detail") : "")) ;		
						oPatientCFS.setsCount(((resultSet.getString("TOTL_ROW_CNT") != null) ?resultSet.getString("TOTL_ROW_CNT") : "0")) ;
						oPatientCFS.setsDescCellIndicator(((resultSet.getString("desc_cell_ind") != null) ?resultSet.getString("desc_cell_ind") : "")) ;
						oPatientCFS.setsResultNum(((resultSet.getString("result_num") != null && !resultSet.getString("result_num").equals("")) ?resultSet.getString("result_num") : "0")) ;
						oPatientCFS.setsColorCellIndicator(((resultSet.getString("COLOR_CELL_IND") != null) ?resultSet.getString("COLOR_CELL_IND") : "")) ;
						oPatientCFS.setsNormalRangeSymbol(((resultSet.getString("normal_range_symbol") != null) ?resultSet.getString("normal_range_symbol") : "") );
						oPatientCFS.setsNormalLow(((resultSet.getString("normal_low") != null) ?resultSet.getString("normal_low") : "") );
						oPatientCFS.setsNormalHigh(((resultSet.getString("normal_high") != null) ?resultSet.getString("normal_high") : "")) ;
						
						oPatientCFSList.add(oPatientCFS);
						
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
		return oPatientCFSList;
	}
	public List<PatientCFS> getPatientCFSDetails(PatientContext oPatientContext) throws Exception {
		List<PatientCFS> oPatientCFSList = new ArrayList<PatientCFS>() ;
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
	
			sqlStr.append(" SELECT   event_date dummydate, c.short_desc event_class,b.short_desc event_desc, e.short_desc event_group_desc,TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') event_date, result_num, NVL (result_num_prefix, '') || NVL (result_num, '')|| NVL (result_str, '')|| ' '|| NVL (result_num_uom, '') care_flow_detail,normal_low, normal_high, a.ext_image_appl_id, a.ext_image_obj_id,a.contr_sys_id, a.accession_num, a.contr_sys_event_code,NVL ((SELECT hist_data  FROM cr_encounter_detail_txt WHERE hist_rec_type = a.hist_rec_type AND contr_sys_id = a.contr_sys_id ");
			sqlStr.append("	AND accession_num = a.accession_num AND contr_sys_event_code = a.contr_sys_event_code  AND DBMS_LOB.getlength (hist_data) > 0),'' ) text_exisits, a.normalcy_ind,(SELECT DECODE (a.normalcy_ind,high_str, high_color_code,low_str, low_color_code,crit_str, crit_color_code,abn_str, abn_color_code,crit_high_str, crit_high_color_code,crit_low_str, crit_low_color_code,'NONE' ) FROM cr_clin_event_param) color_cell_ind,(SELECT DECODE (a.normalcy_ind,high_str, high_str_desc,low_str, low_str_desc,crit_str, crit_str_desc,abn_str, abn_str_desc,crit_high_str, crit_high_str_desc,crit_low_str, crit_low_str_desc ");
			sqlStr.append("  ) desc_cell_ind FROM cr_clin_event_param) desc_cell_ind,(SELECT DECODE (a.normalcy_ind, high_str, high_symbol_icon,low_str, low_symbol_icon,crit_str, crit_symbol_icon,abn_str, abn_symbol_icon,crit_high_str, crit_high_symbol_icon, crit_low_str, crit_low_symbol_icon,'NONE' )FROM cr_clin_event_param) normal_range_symbol,a.hist_data_type, a.normalcy_str,a.hist_rec_type FROM cr_encounter_detail a, cr_cln_evt_mst_lang_vw b,cr_event_class_lang_vw c,cr_cln_evt_grp_lang_vw e WHERE a.hist_rec_type = 'PTCR' AND b.hist_rec_type = a.hist_rec_type AND b.event_code = a.event_code  AND b.event_code_type = a.event_code_type  AND b.language_id = '" + locale + "' ");
	        sqlStr.append(" AND e.hist_rec_type(+) = a.hist_rec_type AND e.event_group(+) = a.event_group AND e.event_group_type(+) = a.event_group_type AND e.language_id(+) = '" + locale + "' AND c.hist_rec_type = a.hist_rec_type AND c.event_class = a.event_class AND c.language_id = '" + locale + "' AND patient_id = '" + strPatientId + "' AND (facility_id, encounter_id) IN ( SELECT facility_id, encounter_id  FROM (SELECT facility_id, encounter_id, ROW_NUMBER () OVER (ORDER BY visit_adm_date_time DESC) rank_no FROM pr_encounter WHERE patient_id = '" + strPatientId + "')  WHERE rank_no < 5) AND a.hist_rec_type = 'PTCR' AND NVL (a.status, '`') NOT IN ('S', 'E') ORDER BY dummydate DESC, c.short_desc,  request_num_seq, e.short_desc, a.event_group, b.short_desc,a.event_code ");
		     
		   
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
						
						PatientCFS oPatientCFS = new PatientCFS();
						
						oPatientCFS.setsEventDate(((resultSet.getString("event_date") != null) ?resultSet.getString("event_date") : "")) ;
						oPatientCFS.setsEventClass(((resultSet.getString("event_class") != null) ?resultSet.getString("event_class") : "")) ;
						oPatientCFS.setsEventGroupDesc(((resultSet.getString("event_group_desc") != null) ?resultSet.getString("event_group_desc") : "")) ;
						oPatientCFS.setsDesc(((resultSet.getString("event_desc") != null) ?resultSet.getString("event_desc") : "")) ;
						oPatientCFS.setsCareFlowDetail(((resultSet.getString("care_flow_detail") != null) ?resultSet.getString("care_flow_detail") : "")) ;		
					
						oPatientCFS.setsDescCellIndicator(((resultSet.getString("desc_cell_ind") != null) ?resultSet.getString("desc_cell_ind") : "")) ;
						oPatientCFS.setsResultNum(((resultSet.getString("RESULT_NUM") != null && !resultSet.getString("RESULT_NUM").equals("")) ?resultSet.getString("RESULT_NUM") : "0")) ;
						oPatientCFS.setsColorCellIndicator(((resultSet.getString("COLOR_CELL_IND") != null) ?resultSet.getString("COLOR_CELL_IND") : "")) ;
						oPatientCFS.setsNormalRangeSymbol(((resultSet.getString("normal_range_symbol") != null) ?resultSet.getString("normal_range_symbol") : "") );
						oPatientCFS.setsNormalLow(((resultSet.getString("normal_low") != null) ?resultSet.getString("normal_low") : "") );
						oPatientCFS.setsNormalHigh(((resultSet.getString("normal_high") != null) ?resultSet.getString("normal_high") : "")) ;
						oPatientCFS.setsContrSysID(((resultSet.getString("CONTR_SYS_ID") != null) ?resultSet.getString("CONTR_SYS_ID") : ""));
						oPatientCFS.setsAccessionNum(((resultSet.getString("ACCESSION_NUM") != null) ?resultSet.getString("ACCESSION_NUM") : ""));
						oPatientCFS.setsContrSysEventCode(((resultSet.getString("CONTR_SYS_EVENT_CODE") != null) ?resultSet.getString("CONTR_SYS_EVENT_CODE") : ""));
						oPatientCFS.setsTextExist(((resultSet.getString("text_exisits") != null) ?resultSet.getString("text_exisits") : ""));
						oPatientCFS.setsHistRecType(((resultSet.getString("hist_rec_type") != null) ?resultSet.getString("hist_rec_type") : ""));
						oPatientCFSList.add(oPatientCFS);
						
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
		return oPatientCFSList;
	}


}
