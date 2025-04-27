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
package eIPAD.chartsummary.currentmedications.daoimpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.daoimpl.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.currentmedications.healthobject.*;
/*import eIPAD.chartsummary.currentmedications.request.*;*/
import eIPAD.chartsummary.currentmedications.response.*;
import eIPAD.chartsummary.currentmedications.dao.*;
/**
 * @author GaneshkumarC modified by Vivek C - 31/03/2015
 *
 */
public class CurrentMedicationDAOImpl extends GenericDAOImpl implements CurrentMedicationDAO{
	public CurrentMedicationRes getCurrentMedicationDetails(PatContext patientContext, String filterByVal)
	{
		ErrorInfo errorInfo;
		Connection connection 		= null;
		Statement stmt				= null;
		ResultSet resultSet 		= null;
		String locale = "";
		String strPatientId = "";
		
		StringBuffer sqlStr = new StringBuffer("");
		CurrentMedicationRes oCMRes = new CurrentMedicationRes();
		List<CurrentMedicationHO> oLstCMHO = new ArrayList<CurrentMedicationHO>();
		//ErrorInfo oErrInfo = new ErrorInfo();
		
		
		if(patientContext != null) 
		{
			String facilityId = patientContext.getFacilityId();
			
			ArrayList<String> queryValues = getConfigurationQueryValues(facilityId);
			
			String ALLOW_RENEW_FROM_CHART_SUMM_YN= queryValues.get(0);
			String SINGLE_CONT_RENEW_HRS_BEHIND= queryValues.get(1);
			String SINGLE_CONT_RENEW_HRS_AHEAD= queryValues.get(2);
			String orderId = null;
			String prevOrderId = null;
			int count =0;
			strPatientId = checkForNull(patientContext.getPatientId());
			locale =  checkForNull(patientContext.getLocale());
			String splitFluidYN = "";
			ArrayList<CurMedMultipleFlowRateHO> multiFlowRateDetails = new ArrayList<CurMedMultipleFlowRateHO>();
			//oErrInfo.setErrorType(Errors.COMMON_SUCCESS, locale);
			
			
			sqlStr.append(" SELECT   b.order_id, g.order_line_num, a.DRUG_CODE DRUG_CODE,decode(DRUG_YN, 'Y',( select form_desc from PH_FORM_LANG_VW where form_code=e.form_code and  ");
			sqlStr.append(" language_id='"+locale+"'),'') form_desc,e.drug_desc drug_desc,DECODE (drug_yn, 'Y', DECODE (a.split_yn, 'Y', '(Divided)',d.freq_desc), '') freq_desc, ");
			sqlStr.append(" decode(DRUG_YN, 'Y', a.DURATION,'') duration, c.durn_desc duration_desc,decode (g.SLIDING_SCALE_YN ,'Y','Sliding Scale',RTRIM (RTRIM (TO_CHAR (a.dosage, ");
			sqlStr.append(" '9999999999999990.999999999999'), '0'), '.') ||' ' || ph_get_uom_display ('"+facilityId+"', a.dosage_uom_code,'"+locale+"') ) dosage_uom_code, ");
			sqlStr.append(" decode(DRUG_YN, 'Y', TO_CHAR (a.start_date, 'DD/MM/YYYY HH24:MI'),'') start_date , decode(DRUG_YN, 'Y', TO_CHAR (a.end_date, 'DD/MM/YYYY HH24:MI'),'') ");
			sqlStr.append(" end_date,b.iv_prep_yn,( case when ('"+ALLOW_RENEW_FROM_CHART_SUMM_YN+"' ='Y' and a.end_date between (sysdate- '"+SINGLE_CONT_RENEW_HRS_BEHIND+"'/24) and ");
			sqlStr.append(" (sysdate+'"+SINGLE_CONT_RENEW_HRS_AHEAD+"'/24) ) then 'Y' else 'N' end ) renew_yn, a.route_code route,decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_route(a.route_code,f.language_id,'1')) ROUTE_DESC,i.long_desc order_desc,  ");
			sqlStr.append(" (CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN b.CAN_REASON IS NOT NULL  THEN 'HOLD' */ WHEN o.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN o.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN o.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN a.START_DATE AND a.END_DATE AND (NVL (a.TOT_ISSUED_QTY, 0) - NVL (a.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) status,  ");
			sqlStr.append(" o.ORDER_LINE_STATUS line_status, A.RETURNED_QTY returned_qty,decode(a.patient_class,null,'XT',a.patient_class) patient_class,b.DISCHARGE_IND dischargeMed, g.infuse_over infusion_Time, g.infuse_over_unit infuse_over_unit, g.infusion_rate infusion_rate,g.infusion_vol_str_unit infusion_vol_str_unit, g.infusion_per_unit infusion_per_unit, g.MFR_YN splitFluidMedication_YN, RTRIM(RTRIM(TO_CHAR(o.order_qty,'9999999999999990.999999999999'),'0'),'.') || ' ' || PH_GET_UOM_DISPLAY( '"+locale+"' ,o.order_uom, '"+facilityId+"' ) order_qty   FROM ph_patient_drug_profile a,or_order ");
			sqlStr.append(" b,am_duration_type_lang_vw c,am_frequency_lang_vw d,ph_drug_lang_vw e,PH_GENERIC_NAME_LANG_VW f, or_order_line_ph g, OR_ORDER_STATUS_CODE_LANG_VW i, OR_ORDER_LINE o WHERE a.patient_id = '"+strPatientId+"' AND ");
			sqlStr.append(" e.language_id='"+locale+"' AND a.orig_order_id = NVL ('', a.orig_order_id) AND b.order_id = a.orig_order_id and a.orig_order_id =g.ORDER_ID and ");
			sqlStr.append(" a.ORIG_ORDER_LINE_NO =g.ORDER_LINE_NUM AND TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE)  AND a.discont_date_time IS NULL AND a.on_hold_date_time IS ");
			sqlStr.append(" NULL AND d.freq_code(+) = a.freq_code AND e.drug_code = a.drug_code AND f.generic_id = a.generic_id AND c.durn_type(+) =a.durn_type AND cancel_yn = 'N' AND ");
			sqlStr.append(" cancel_date_time IS NULL and e.drug_yn='Y' and d.language_id = '"+locale+"' and c.language_id = '"+locale+"' and b.order_status=i.order_status_code and a.ORIG_ORDER_LINE_NO = o.ORDER_LINE_NUM and b.ORDER_ID = o.ORDER_ID and i.language_id='"+locale+"' and f.language_id='"+locale+"'   ");
			
			if(filterByVal.equals("all"))
				sqlStr.append(" ORDER BY b.ord_date_time, orig_order_id,orig_order_line_no ");
			else 
				if(filterByVal.equals("norRx"))
					sqlStr.append(" and b.IV_PREP_YN is null ORDER BY b.ord_date_time, orig_order_id,orig_order_line_no ");
			else
			if(filterByVal.equals("comRx"))
				sqlStr.append(" and b.IV_PREP_YN='6' ORDER BY b.ord_date_time, orig_order_id,orig_order_line_no ");
			
			else
				if(filterByVal.equals("IVRx"))
					sqlStr.append(" and b.IV_PREP_YN='1' ORDER BY b.ord_date_time, orig_order_id,orig_order_line_no ");
					//sqlStr.append(" and b.IV_PREP_YN='5' ORDER BY b.ord_date_time, orig_order_id,orig_order_line_no ");
			
			try
			{
				connection = createConnection();
				if(connection != null)
				{
					stmt = connection.createStatement();
				}
				if(stmt != null)
				{
					resultSet = stmt.executeQuery(sqlStr.toString());
				}
				if(resultSet != null)
				{
					while(resultSet.next())
					{
						CurrentMedicationHO oCmHO = new CurrentMedicationHO();
						orderId = checkForNull(resultSet.getString("order_id"));
						oCmHO.setOrderId(checkForNull(resultSet.getString("order_id")));
						oCmHO.setFormDesc(checkForNull(resultSet.getString("form_desc")));
						oCmHO.setDrugName(checkForNull(resultSet.getString("drug_desc")));
						oCmHO.setFrequency(checkForNull(resultSet.getString("freq_desc")));
						oCmHO.setDuration(checkForNull(resultSet.getString("duration")));
						oCmHO.setDuration_desc(checkForNull(resultSet.getString("duration_desc")));
						oCmHO.setDosageDetails(checkForNull(resultSet.getString("dosage_uom_code")));
						oCmHO.setStartDate(checkForNull(resultSet.getString("start_date")));
						oCmHO.setEndDate(checkForNull(resultSet.getString("end_date")));
						oCmHO.setPrepYN(checkForNull(resultSet.getString("iv_prep_yn")));
						oCmHO.setRoute(checkForNull(resultSet.getString("route")));
						oCmHO.setRouteDesc(checkForNull(resultSet.getString("ROUTE_DESC")));
						oCmHO.setOrderDesc(checkForNull(resultSet.getString("order_desc")));
						oCmHO.setLineStatus(checkForNull(resultSet.getString("line_status")));
						oCmHO.setReturnedQty(checkForNull(resultSet.getString("returned_qty")));
						oCmHO.setStatus(checkForNull(resultSet.getString("status")));
						oCmHO.setPatientClass(checkForNull(resultSet.getString("patient_class")));
						oCmHO.setDischargeMed(checkForNull(resultSet.getString("dischargeMed")));
						oCmHO.setInfusionTime(checkForNull(resultSet.getString("infusion_Time")));
						oCmHO.setInfusionOverUnit(checkForNull(resultSet.getString("infuse_over_unit")));
						oCmHO.setInfusionPerUnit(checkForNull(resultSet.getString("infusion_per_unit")));
						oCmHO.setInfusionVolStrUnit(checkForNull(resultSet.getString("infusion_vol_str_unit")));
						oCmHO.setInfusionRate(checkForNull(resultSet.getString("infusion_rate")));
						oCmHO.setOrderQty(checkForNull(resultSet.getString("order_qty")));
						oCmHO.setSplitFluidMedicationYN(checkForNull(resultSet.getString("splitFluidMedication_YN"))); 
						splitFluidYN = checkForNull(resultSet.getString("splitFluidMedication_YN"));
						
						if(splitFluidYN.equalsIgnoreCase("Y")){
							multiFlowRateDetails =	getFulidSplitMedicationDetails(locale,orderId);
							oCmHO.setMulitpleFlowRate(multiFlowRateDetails);
						}
						
						if(!orderId.equals(prevOrderId)){
							count++;
						}
						
						//oCmHO.setCount(count);
						oLstCMHO.add(oCmHO);
						
						prevOrderId= orderId;
					}
					oCMRes.setCurrentMedicationList(oLstCMHO);
					oCMRes.setCount(count);
				}
				
				if(oLstCMHO.size() <= 0){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.CURRENT_MEDICATION_EMPTY_DATA,locale);
					oCMRes.getErrorsList().add(errorInfo);
				}
				else{
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
					oCMRes.getErrorsList().add(errorInfo);
				}
				
				if(resultSet != null)
					resultSet.close();
				if(stmt != null)
				{
					stmt.close();
				}
				
				
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				oCMRes.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				oCMRes.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(connection);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			oCMRes.getErrorsList().add(errorInfo);
		}
		
		return oCMRes;
		
	}
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
	
	private ArrayList<String> getConfigurationQueryValues(String facilityId){
		
		Connection connection 		= null;
		Statement stmt				= null;
		ResultSet resultSet 		= null;
		ArrayList<String> queryValues = new ArrayList<String>();
		
		StringBuffer sqlStr = new StringBuffer("");
		
		sqlStr.append(" SELECT (case when( b.single_cont_renew_hrs_behind is null or b.single_cont_renew_hrs_ahead is null) then 'N'else  a.allow_renew_from_chart_summ_yn end) "); 
		sqlStr.append(" allow_renew_from_chart_summ_yn, b.single_cont_renew_hrs_behind,b.single_cont_renew_hrs_ahead FROM ph_facility_param a, or_param_by_facility b WHERE A.FACILITY_ID='"+facilityId+"' AND b.operating_facility_id = a.facility_id ");
		try 
		{
			connection = createConnection();
			if(connection != null)
			{
				stmt = connection.createStatement();
			}
			if(stmt != null)
			{
				resultSet = stmt.executeQuery(sqlStr.toString());
			}
			if(resultSet != null)
			{
				while(resultSet.next())
				{
				 String ALLOW_RENEW_FROM_CHART_SUMM_YN =resultSet.getString("ALLOW_RENEW_FROM_CHART_SUMM_YN");
				 String SINGLE_CONT_RENEW_HRS_BEHIND = resultSet.getString("SINGLE_CONT_RENEW_HRS_BEHIND");
				 String SINGLE_CONT_RENEW_HRS_AHEAD = resultSet.getString("SINGLE_CONT_RENEW_HRS_AHEAD");
				 
				 queryValues.add(ALLOW_RENEW_FROM_CHART_SUMM_YN);
				 queryValues.add(SINGLE_CONT_RENEW_HRS_BEHIND);
				 queryValues.add(SINGLE_CONT_RENEW_HRS_AHEAD);		 
				}
			
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			int conCloseFailure = closeConnection(connection,stmt,resultSet);
			if(conCloseFailure > 0)
			{
				System.out.println("Connection not closed in the method eIPAD.chartsummary.allergies.daoimpl.AllergyDAOImpl.getAllergyDetails");
			}
		}
		return queryValues ;
}
	
	private ArrayList<CurMedMultipleFlowRateHO> getFulidSplitMedicationDetails(String locale, String orderId){
		
		ArrayList<CurMedMultipleFlowRateHO> fluidsplitDetails = new ArrayList<CurMedMultipleFlowRateHO>();
		
		Connection connection 		= null;
		Statement stmt				= null;
		ResultSet resultSet 		= null;
		
		
		StringBuffer sqlStr = new StringBuffer("");
		
		sqlStr.append(" select TOT_STRENGTH, TOT_STRENGTH_UOM, INFUSE_OVER, INFUSE_OVER_UNIT, INFUSION_RATE, INFUSION_VOL_STR_UNIT ,am_get_desc.am_uom(INFUSION_VOL_STR_UNIT, '"+locale+"' , 2 ) INFUSION_VOL_STR_UNIT_DESC,INFUSION_PER_UNIT, ADMIN_RATE_DETAIL, TO_CHAR (SCH_START_DATE_TIME, 'DD/MM/YYYY HH24:MI') START_DATE_TIME, TO_CHAR (SCH_END_DATE_TIME, 'DD/MM/YYYY HH24:MI') END_DATE_TIME, GAP_DURATION_IN_HRS from OR_ORDER_LINE_PH_MFR where  ORDER_ID='"+orderId+"' ");
		try 
		{
			connection = createConnection();
			if(connection != null)
			{
				stmt = connection.createStatement();
			}
			if(stmt != null)
			{
				resultSet = stmt.executeQuery(sqlStr.toString());
			}
			if(resultSet != null)
			{
				while(resultSet.next())
				{
					CurMedMultipleFlowRateHO multiFlowRateHO = new CurMedMultipleFlowRateHO();
					multiFlowRateHO.setTotalStrength(checkForNull(resultSet.getString("TOT_STRENGTH")));
					multiFlowRateHO.setTotStrengthUOM(checkForNull(resultSet.getString("TOT_STRENGTH_UOM")));
					multiFlowRateHO.setInfuseOver(checkForNull(resultSet.getString("INFUSE_OVER")));
					multiFlowRateHO.setInfuseOverUnit(checkForNull(resultSet.getString("INFUSE_OVER_UNIT")));
					multiFlowRateHO.setInfusionRate(checkForNull(resultSet.getString("INFUSION_RATE")));
					multiFlowRateHO.setInfusionVolStrUnit(checkForNull(resultSet.getString("INFUSION_VOL_STR_UNIT")));
					multiFlowRateHO.setInfusionVolStrUnitDesc(checkForNull(resultSet.getString("INFUSION_VOL_STR_UNIT_DESC")));
					multiFlowRateHO.setInfusionPerUnit(checkForNull(resultSet.getString("INFUSION_PER_UNIT")));
					multiFlowRateHO.setStartDateTime(checkForNull(resultSet.getString("START_DATE_TIME")));
					multiFlowRateHO.setEndDateTime(checkForNull(resultSet.getString("END_DATE_TIME")));
					multiFlowRateHO.setGapInHrs(checkForNull(resultSet.getString("GAP_DURATION_IN_HRS")));
					
					fluidsplitDetails.add(multiFlowRateHO);
				}
			
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			int conCloseFailure = closeConnection(connection,stmt,resultSet);
			if(conCloseFailure > 0)
			{
				System.out.println("Connection not closed in the method eIPAD.chartsummary.allergies.daoimpl.AllergyDAOImpl.getAllergyDetails");
			}
		}
		
		return fluidsplitDetails; 
	}
	
}
