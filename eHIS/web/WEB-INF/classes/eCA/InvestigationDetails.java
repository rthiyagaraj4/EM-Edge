/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name                 	Rev.Date 		Rev.by 					Description
--------------------------------------------------------------------------------------------------------------
21/03/2023   42761      krishna Pranay      21/03/2023     Ramesh Goli        COMMON-ICN-0125
--------------------------------------------------------------------------------------------------------------
*/
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

public class InvestigationDetails implements java.io.Serializable {
	/**
	 * 
	 */	
	public List<InvestDetailsBean> getInvestDetails(PatientContext oPatientContext, int iChartType) throws Exception {
		List<InvestDetailsBean> sInvestList = new ArrayList<InvestDetailsBean>() ;
		if(oPatientContext != null && oPatientContext.request != null )
		{
			Connection connection 		= null;
			//PreparedStatement pstmt 	= null; //42761
			Statement stmt				= null;
			ResultSet resultSet 			= null;

			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
		//	String strRowCount = ""; //42761
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

			if (iChartType == 0) // To get list of vitals recorded for the patient
			{
				sqlStr.append(" Select operating_facility_id, patient_id, encounter_id, specimen_no, group_test_code, test_code,long_desc,section_code,numeric_result,short_desc,high_low_ind,low_value_critical,age_range_low,age_range_high, high_value_critical,added_date from ");
				sqlStr.append(" (select  c.operating_facility_id, c.patient_id, a.encounter_id, c.specimen_no, c.group_test_code, c.test_code, d.long_desc, c.section_code, c.numeric_result, e.short_desc, ");
				sqlStr.append(" c.high_low_ind, c.low_value_critical,c.age_range_low, c.age_range_high, c.high_value_critical, to_char(c.added_date,'YYYY/MM/DD') added_date,  ");
				sqlStr.append(" row_number() over(partition by d.long_desc order by c.added_date desc) rank_event_dt ");
				sqlStr.append(" from  rl_request_header a, rl_request_detail b, rl_test_result c, rl_test_code d, am_uom e  ");
				sqlStr.append(" where  a.operating_facility_id = b.operating_facility_id and a.operating_facility_id = c.operating_facility_id and a.patient_id = b.patient_id and a.patient_id = c.patient_id and ");
				sqlStr.append(" a.specimen_no = b.specimen_no and b.specimen_no = c.specimen_no and b.test_code = c.group_test_code and c.test_code  = d.test_code and  c.test_units = e.uom_code(+) and ");
				sqlStr.append(" c.operating_facility_id = '"+facility_id+"' and a.patient_id = '"+strPatientId+"' and a.encounter_id = '"+strEncounterId+"') ");
				sqlStr.append(" where rank_event_dt = 1 ");
			}
			else if ((iChartType == 1)||(iChartType == 2)||(iChartType == 3)) // Linear Gauge Chart
			{
				sqlStr.append(" Select operating_facility_id, patient_id, encounter_id, specimen_no, group_test_code, test_code,long_desc,section_code,numeric_result,short_desc,high_low_ind,low_value_critical,age_range_low,age_range_high, high_value_critical,added_date from ");
				sqlStr.append(" (select  c.operating_facility_id, c.patient_id, a.encounter_id, c.specimen_no, c.group_test_code, c.test_code, d.long_desc, c.section_code, c.numeric_result, e.short_desc, ");
				sqlStr.append(" c.high_low_ind, c.low_value_critical,c.age_range_low, c.age_range_high, c.high_value_critical, to_char(c.added_date,'YYYY/MM/DD') added_date,  ");
				sqlStr.append(" row_number() over(partition by d.long_desc order by c.added_date desc) rank_event_dt ");
				sqlStr.append(" from  rl_request_header a, rl_request_detail b, rl_test_result c, rl_test_code d, am_uom e  ");
				sqlStr.append(" where  a.operating_facility_id = b.operating_facility_id and a.operating_facility_id = c.operating_facility_id and a.patient_id = b.patient_id and a.patient_id = c.patient_id and ");
				sqlStr.append(" a.specimen_no = b.specimen_no and b.specimen_no = c.specimen_no and b.test_code = c.group_test_code and c.test_code  = d.test_code and  c.test_units = e.uom_code(+) and ");
				sqlStr.append(" c.operating_facility_id = '"+facility_id+"' and a.patient_id = '"+strPatientId+"' and a.encounter_id = '"+strEncounterId+"' and c.test_code = '"+strTestCode+"') ");
				sqlStr.append(" where rank_event_dt = 1 ");
			}
			else if (iChartType == 4) // Line Graph Chart
			{
				sqlStr.append(" select  c.operating_facility_id, c.patient_id, a.encounter_id, c.specimen_no, c.group_test_code, c.test_code, d.long_desc, c.section_code, c.numeric_result, e.short_desc, ");
				sqlStr.append(" c.high_low_ind, c.low_value_critical,c.age_range_low, c.age_range_high, c.high_value_critical, to_char(c.added_date,'YYYY/MM/DD') added_date  ");
				sqlStr.append(" from  rl_request_header a, rl_request_detail b, rl_test_result c, rl_test_code d, am_uom e  ");
				sqlStr.append(" where  a.operating_facility_id = b.operating_facility_id and a.operating_facility_id = c.operating_facility_id and a.patient_id = b.patient_id and a.patient_id = c.patient_id and ");
				sqlStr.append(" a.specimen_no = b.specimen_no and b.specimen_no = c.specimen_no and b.test_code = c.group_test_code and c.test_code  = d.test_code and  c.test_units = e.uom_code(+) and ");
				sqlStr.append(" c.operating_facility_id = '"+facility_id+"' and a.patient_id = '"+strPatientId+"' and a.encounter_id = '"+strEncounterId+"' and c.test_code = '"+strTestCode+"' ");
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

						InvestDetailsBean sInvest = new InvestDetailsBean();
						sInvest.setsFacilityID(((resultSet.getString("operating_facility_id") != null) ?resultSet.getString("operating_facility_id") : "")) ;
						sInvest.setsPatienID(((resultSet.getString("patient_id") != null) ?resultSet.getString("patient_id") : "")) ;
						sInvest.setsEncounterID(((resultSet.getString("encounter_id") != null) ?resultSet.getString("encounter_id") : "")) ;
						sInvest.setsSpecimenNo(((resultSet.getString("specimen_no") != null) ?resultSet.getString("specimen_no") : "")) ;
						sInvest.setsGroupTestCode(((resultSet.getString("group_test_code") != null) ?resultSet.getString("group_test_code") : "")) ;
						sInvest.setsTestCode(((resultSet.getString("test_code") != null) ?resultSet.getString("test_code") : "")) ;
						sInvest.setsLongDesc(((resultSet.getString("long_desc") != null) ?resultSet.getString("long_desc") : "")) ;
						sInvest.setsSectionCode(((resultSet.getString("section_code") != null) ?resultSet.getString("section_code") : "") );
						sInvest.setsNumericResult(((resultSet.getString("numeric_result") != null) ?resultSet.getString("numeric_result") : "")) ;		
						sInvest.setsShortDesc(((resultSet.getString("short_desc") != null) ?resultSet.getString("short_desc") : "")) ;
						sInvest.setsHighLowInd(((resultSet.getString("high_low_ind") != null) ?resultSet.getString("high_low_ind") : "")) ;
						sInvest.setsLowValueCritical(((resultSet.getString("low_value_critical") != null) ?resultSet.getString("low_value_critical") : "")) ;
						sInvest.setsAgeRangeLow(((resultSet.getString("age_range_low") != null) ?resultSet.getString("age_range_low") : "")) ;
						sInvest.setsAgeRangeHigh(((resultSet.getString("age_range_high") != null) ?resultSet.getString("age_range_high") : "")) ;
						sInvest.setsHighValueCritical(((resultSet.getString("high_value_critical") != null) ?resultSet.getString("high_value_critical") : "")) ;
						sInvest.setsAddedDate(((resultSet.getString("added_date") != null) ?resultSet.getString("added_date") : "")) ;
						sInvestList.add(sInvest);

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
		return sInvestList;
	}
}
