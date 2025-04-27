/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.*;
import javax.servlet.http.*;

import eCA.*;
import eCommon.Common.*;
import webbeans.eCommon.*;

public class VitalDetails implements java.io.Serializable {
	/**
	 * 
	 */	
	public List<VitalDetailsBean> getVitalsDetails(PatientContext oPatientContext, int iChartType) throws Exception {
		List<VitalDetailsBean> sVitalsList = new ArrayList<VitalDetailsBean>() ;
		if(oPatientContext != null && oPatientContext.request != null )
		{
			Connection connection 		= null;
//			PreparedStatement pstmt 	= null;  //Common-ICN-0092  
			Statement stmt				= null;
			ResultSet resultSet 			= null;

			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
//			String strRowCount = "";  //Common-ICN-0092  
			String strPatientId = "";
			String strEncounterId = "";
			String strTestCode = "";

			//int iChartType = 1; // 1 - Normal Text, 2 - Normal Table, 3 - Linear Gauge Chart, 4 - Line Graph Chart
			//HttpSession session = oPatientContext.session;

			HttpServletRequest request = oPatientContext.request;

			if(oPatientContext.sFacilityId  != null && !oPatientContext.sFacilityId.equals(""))
			{
				facility_id = oPatientContext.sFacilityId;
			}			
			if(oPatientContext.sPatientId != null && !oPatientContext.sPatientId.equals(""))
			{
				strPatientId = oPatientContext.sPatientId;
			}
			if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
			{
				strEncounterId = oPatientContext.sEncounterId;
			}
			if(oPatientContext.sTestCode != null && !oPatientContext.sTestCode.equals(""))
			{
				strTestCode = oPatientContext.sTestCode;
			}

			System.out.println(" - - - iChartType - - - "+iChartType);
			
			if (iChartType == 0) // To get list of vitals recorded for the patient
			{
				System.out.println(" - - - iChartType - - - 0 ");
				sqlStr.append(" Select facility_id, patient_id, encounter_id, discr_msr_id, short_desc, discr_msr_panel_or_form_id,discr_msr_result_type,discr_msr_result_num,discr_msr_result_num_uom,discr_msr_result_str, normal_low,normal_high,critical_low,critical_high,added_date from ");
				sqlStr.append(" ( Select facility_id, patient_id, encounter_id, a.discr_msr_id discr_msr_id, b.short_desc short_desc, discr_msr_panel_or_form_id, discr_msr_result_type, discr_msr_result_num,discr_msr_result_num_uom,discr_msr_result_str,critical_low,normal_low,normal_high,critical_high, a.added_date, ");
				sqlStr.append(" row_number() over(partition by b.short_desc order by a.added_date desc) rank_event_dt ");
				sqlStr.append(" from ca_encntr_discr_msr a, am_discr_msr b ");
				sqlStr.append(" where a.discr_msr_id = b.discr_msr_id and facility_id = '"+facility_id+"'  and a.patient_id = '"+strPatientId+"' and encounter_id = '"+strEncounterId+"' and discr_msr_result_type in ('I','N')) ");
				sqlStr.append(" where rank_event_dt = 1 ");
			}
			else if ((iChartType == 1)||(iChartType == 2)||(iChartType == 3)) // Linear Gauge Chart
			{
				System.out.println(" - - - iChartType - - - 1/2/3 ");
				sqlStr.append(" Select facility_id, patient_id, encounter_id, discr_msr_id, short_desc, discr_msr_panel_or_form_id,discr_msr_result_type,discr_msr_result_num,discr_msr_result_num_uom,discr_msr_result_str, normal_low,normal_high,critical_low,critical_high,added_date from ");
				sqlStr.append(" ( Select facility_id, patient_id, encounter_id, a.discr_msr_id discr_msr_id, b.short_desc short_desc, discr_msr_panel_or_form_id, discr_msr_result_type, discr_msr_result_num,discr_msr_result_num_uom,discr_msr_result_str,critical_low,normal_low,normal_high,critical_high, a.added_date, ");
				sqlStr.append(" row_number() over(partition by b.short_desc order by a.added_date desc) rank_event_dt ");
				sqlStr.append(" from ca_encntr_discr_msr a, am_discr_msr b ");
				sqlStr.append(" where a.discr_msr_id = b.discr_msr_id and facility_id = '"+facility_id+"'  and a.patient_id = '"+strPatientId+"' and encounter_id = '"+strEncounterId+"' and discr_msr_id = '"+strTestCode+"' and discr_msr_result_type in ('I','N')) ");
				sqlStr.append(" where rank_event_dt = 1 ");
			}
			else if (iChartType == 4) // Line Graph Chart
			{
				System.out.println(" - - - iChartType - - - 4 ");
				sqlStr.append(" Select facility_id, patient_id, encounter_id, a.discr_msr_id discr_msr_id, b.short_desc short_desc, discr_msr_panel_or_form_id, discr_msr_result_type, discr_msr_result_num,discr_msr_result_num_uom,discr_msr_result_str,critical_low,normal_low,normal_high,critical_high,a.added_date ");
				sqlStr.append(" from ca_encntr_discr_msr a, am_discr_msr b ");
				sqlStr.append(" where a.discr_msr_id = b.discr_msr_id and facility_id = '"+facility_id+"'  and a.patient_id = '"+strPatientId+"' and encounter_id = '"+strEncounterId+"' and discr_msr_id = '"+strTestCode+"' and discr_msr_result_type in ('I','N') ");
			}			
						

			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}				
					
					System.out.println(" - - - sqlStr.toString() - - - "+sqlStr.toString());
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {

						VitalDetailsBean sVitals = new VitalDetailsBean();
						sVitals.setsPatienID(((resultSet.getString("patient_id") != null) ?resultSet.getString("patient_id") : "")) ;
						sVitals.setsEncounterID(((resultSet.getString("encounter_id") != null) ?resultSet.getString("encounter_id") : "")) ;
						sVitals.setsFacilityID(((resultSet.getString("facility_id") != null) ?resultSet.getString("facility_id") : "")) ;
						sVitals.setsDiscrMsrId(((resultSet.getString("discr_msr_id") != null) ?resultSet.getString("discr_msr_id") : "")) ;
						sVitals.setsShortDesc(((resultSet.getString("short_desc") != null) ?resultSet.getString("short_desc") : "")) ;
						sVitals.setsDiscrMsrPanelId(((resultSet.getString("discr_msr_panel_or_form_id") != null) ?resultSet.getString("discr_msr_panel_or_form_id") : "")) ;
						sVitals.setsDiscrMsrResultType(((resultSet.getString("discr_msr_result_type") != null) ?resultSet.getString("discr_msr_result_type") : "")) ;
						sVitals.setlDiscrMsrResultNum(((resultSet.getString("discr_msr_result_num") != null) ?resultSet.getString("discr_msr_result_num") : "") );
						sVitals.setsDiscrMsrResultNumUom(((resultSet.getString("discr_msr_result_num_uom") != null) ?resultSet.getString("discr_msr_result_num_uom") : "")) ;		
						sVitals.setsDiscrMsrResultStr(((resultSet.getString("discr_msr_result_str") != null) ?resultSet.getString("discr_msr_result_str") : "")) ;
						sVitals.setsCriticalLow(((resultSet.getString("critical_low") != null) ?resultSet.getString("critical_low") : "")) ;
						sVitals.setsNormalLow(((resultSet.getString("normal_low") != null) ?resultSet.getString("normal_low") : "")) ;
						sVitals.setsNormalHigh(((resultSet.getString("normal_high") != null) ?resultSet.getString("normal_high") : "")) ;
						sVitals.setsCriticalHigh(((resultSet.getString("critical_high") != null) ?resultSet.getString("critical_high") : "")) ;
						sVitals.setsAddedDate(((resultSet.getString("added_date") != null) ?resultSet.getString("added_date") : "")) ;
						sVitals.setiChartType(1) ;
						sVitalsList.add(sVitals);

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
		return sVitalsList;
	}
}
