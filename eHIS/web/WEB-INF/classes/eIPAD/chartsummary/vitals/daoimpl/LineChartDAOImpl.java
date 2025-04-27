/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.daoimpl;

import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.Map.Entry;

import eIPAD.chartsummary.vitals.healthobject.*;
import eIPAD.chartsummary.vitals.request.*;
import eIPAD.chartsummary.vitals.response.*;
import eIPAD.chartsummary.vitals.dao.*; 
public class LineChartDAOImpl extends GenericDAOImpl implements LineChartDAO {
	public LineChartResponse getData(VitalsRequest oVitalsReq)
	{
		LineChartResponse oLineChartResponse = new LineChartResponse();
		Connection connection 		= null;
		PreparedStatement pStmt				= null;
		ResultSet resultSet 		= null;
		String locale = "en";
		String strPatientId = "";
		String encounterId = "";
		String facilityId = "";
		String patientClass = "";
		String chartId = "";
		StringBuffer sqlStr = new StringBuffer("");
		List<LineChartDM> lstLineChartDM = new ArrayList<LineChartDM>();
		ErrorInfo oErrInfo = new ErrorInfo();
		if(oVitalsReq != null && oVitalsReq.getChartId() != null && !oVitalsReq.getChartId().equals("") )
		{
			PatContext oPatContext = oVitalsReq.getPatientContext();
			if(oPatContext != null)
			{
				ArrayList<GraphXAxis> oGraphXAxisList;
				ArrayList<GraphYAxis> oGraphYAxisList;
				LineChartAxisContainer oLineChartAxisContainer;
				Map<LineChartDM,LineChartAxisContainer> mapLineChartDM = new LinkedHashMap<LineChartDM,LineChartAxisContainer>();
				facilityId = checkForNull(oPatContext.getFacilityId());
				strPatientId = checkForNull(oPatContext.getPatientId());
				locale =  checkForNull(oPatContext.getLocale());
				chartId = checkForNull(oVitalsReq.getChartId());//checkForNull(oPatContext.getLocale());
				patientClass = checkForNull(oPatContext.getPatientClass());
				encounterId = (oPatContext.getSelectedEncounterId() == null || oPatContext.getSelectedEncounterId().equals("")) ? oPatContext.getEncounterId() : oPatContext.getSelectedEncounterId();//checkForNull(oPatContext.getEncounterId());
				if(locale.equals(""))
				{
					locale = "en";
				}
				
				sqlStr.append(" SELECT dummydate, hist_rec_type, event_date_time, event_code,event_desc, rnum rankk, event_group_desc, result_num, uom,res_str,norm_ind,normal_low, normal_high, critical_low, critical_high,");
				sqlStr.append(" result_num_prefix, color_cell_ind, desc_cell_ind, symbol_legend_ind, encounter_id, normalcy_str, facility_id, TO_CHAR (result_num) result_num1, result_num_dec ");
				sqlStr.append(" FROM (SELECT a.event_date dummydate, TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') event_date_time,  TO_CHAR (event_date, 'YYYYMMDDHH24MISS') sort_event_date_time,");
				sqlStr.append(" a.hist_rec_type hist_rec_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, NVL (a.event_group, '*ALL') event_group, ");
				sqlStr.append("  NVL (e.long_desc, d.long_desc) event_group_desc, a.event_code event_code, ");
				sqlStr.append(" ROW_NUMBER () OVER (PARTITION BY a.event_code ORDER BY a.event_date DESC) rnum, ");
				sqlStr.append( "  cr_get_desc.cr_clin_event_mast (a.hist_rec_type,  a.event_code, a.event_code_type, '" +locale + "', '1'  ) event_desc,");
				sqlStr.append(" a.hist_data_type hist_data_type,   DECODE (NVL (result_num_dec, 0),  0, TO_CHAR (result_num),  TO_CHAR (result_num,  DECODE (result_num_dec, ");
				sqlStr.append( " 1, '999999990.0', 2, '999999990.90', 3, '999999990.900',  4, '999999990.9000',  5, '999999990.90000',  6, '999999990.900000', 7, '999999990.9000000',  8, '999999990.90000000', 9, '999999990.90000000',  0, '999999999', '999999999'  )  ) ) result_num, ");
				sqlStr.append( " a.result_num_uom uom,  a.result_str res_str,  a.normalcy_ind norm_ind, ");
				sqlStr.append(" DECODE (NVL (result_num_dec, 0),  0, TO_CHAR (a.normal_low), TO_CHAR (a.normal_low,  DECODE (result_num_dec,  1, '999999990.0', 2, '999999990.90',  3, '999999990.900',  4, '999999990.9000', 5, '999999990.90000',   6, '999999990.900000', 7, '999999990.9000000',  8, '999999990.90000000',  9, '999999990.90000000',  0, '999999999', '999999999'  )  ) ) normal_low, ");
				sqlStr.append(" DECODE (NVL (result_num_dec, 0),  0, TO_CHAR (a.normal_high), TO_CHAR (a.normal_high,  DECODE (result_num_dec,  1, '999999990.0', 2, '999999990.90',  3, '999999990.900',  4, '999999990.9000', 5, '999999990.90000',   6, '999999990.900000', 7, '999999990.9000000',  8, '999999990.90000000',  9, '999999990.90000000',  0, '999999999', '999999999'  )  ) ) normal_high, ");
				sqlStr.append(" DECODE (NVL (result_num_dec, 0),  0, TO_CHAR (a.critical_low), TO_CHAR (a.critical_low,  DECODE (result_num_dec,  1, '999999990.0', 2, '999999990.90',  3, '999999990.900',  4, '999999990.9000', 5, '999999990.90000',   6, '999999990.900000', 7, '999999990.9000000',  8, '999999990.90000000',  9, '999999990.90000000',  0, '999999999', '999999999'  )  ) ) critical_low, ");
				sqlStr.append(" DECODE (NVL (result_num_dec, 0),  0, TO_CHAR (a.critical_high), TO_CHAR (a.critical_high,  DECODE (result_num_dec,  1, '999999990.0', 2, '999999990.90',  3, '999999990.900',  4, '999999990.9000', 5, '999999990.90000',   6, '999999990.900000', 7, '999999990.9000000',  8, '999999990.90000000',  9, '999999990.90000000',  0, '999999999', '999999999'  )  ) ) critical_high, ");
				sqlStr.append("  a.status stat, REPLACE (d.short_desc, '''', '') sp_event_desc,  result_num_prefix, ");
				sqlStr.append("  (SELECT DECODE (a.normalcy_ind, high_str, high_color_code,  low_str, low_color_code,  crit_str, crit_color_code, abn_str, abn_color_code, crit_high_str, crit_high_color_code,  crit_low_str, crit_low_color_code,  'NONE'  ) FROM cr_clin_event_param) color_cell_ind, ");
				sqlStr.append("  (SELECT DECODE (a.normalcy_ind, high_str, high_str_desc,  low_str, low_str_desc, crit_str, crit_str_desc, abn_str, abn_str_desc, crit_high_str, crit_high_str_desc, crit_low_str, crit_low_str_desc, 'NONE'  )  FROM cr_clin_event_param) desc_cell_ind,");
				sqlStr.append("  (SELECT DECODE (a.normalcy_ind,  high_str, high_symbol_icon, low_str, low_symbol_icon,  crit_str, crit_symbol_icon, abn_str, abn_symbol_icon,  crit_high_str, crit_high_symbol_icon,  crit_low_str, crit_low_symbol_icon, 'NONE'  ) FROM cr_clin_event_param) symbol_legend_ind, ");
				sqlStr.append("  am_get_desc.am_practitioner (a.performed_by_id, '" + locale+"',  '1'  ) performed_by, a.encounter_id, a.normalcy_str, a.facility_id, TO_CHAR (result_num) result_num1, result_num_dec ");
				sqlStr.append("  FROM cr_encounter_detail a, cr_hist_rec_type b,  cr_event_class c, cr_clin_event_mast d,  cr_clin_event_group e  ");
				sqlStr.append(" WHERE b.hist_rec_type = a.hist_rec_type AND c.hist_rec_type = a.hist_rec_type  AND c.event_class = a.event_class AND d.hist_rec_type = a.hist_rec_type AND d.event_code = a.event_code  AND d.event_code_type = a.event_code_type AND e.hist_rec_type(+) = a.hist_rec_type AND e.event_group(+) = a.event_group AND e.event_group_type(+) = a.event_group_type AND a.patient_id = '" + strPatientId+ "' ");
				sqlStr.append("  and a.encounter_id = '" + encounterId +"' and a.PATIENT_CLASS = '" + patientClass +"'  and a.facility_id = '" + facilityId+"' AND NVL (a.status, '`') NOT IN ('S', 'E') ");
				sqlStr.append("  AND a.event_code IN ( SELECT a.discr_msr_id discr_msr_id  FROM ca_chart_section_comp a, am_discr_msr discr_msr, am_discr_msr_ref_rng_num b  WHERE a.chart_id = '" + chartId+"'  AND discr_msr.discr_msr_id = a.discr_msr_id AND discr_msr.ch_appl_yn = 'Y'  AND a.discr_msr_id = b.discr_msr_id(+)))  order by dummydate desc ");
				
				try
				{
					connection = createConnection();
					if(connection != null)
					{
						pStmt = connection.prepareStatement(sqlStr.toString());
						
					}
					if(pStmt != null){
						resultSet = pStmt.executeQuery();
					}
					if(resultSet != null)
					{
						while(resultSet.next())
						{
							LineChartDM oLineChartDM = new LineChartDM();
							GraphXAxis oGraphXAxis = new GraphXAxis();
							GraphYAxis oGraphYAxis = new GraphYAxis();
							DiscreteValue oDiscreteValue = null ;
							
							oLineChartDM.setEventCode(checkForNull(resultSet.getString("event_code")));
							oLineChartDM.setEventDescription(checkForNull(resultSet.getString("event_desc")));
							oLineChartDM.setNormalHigh(checkForNull(resultSet.getString("normal_high")));
							oLineChartDM.setNormalLow(checkForNull(resultSet.getString("normal_low")));
							oLineChartDM.setCriticalLow(checkForNull(resultSet.getString("critical_low")));
							oLineChartDM.setCriticalHigh(checkForNull(resultSet.getString("critical_high")));
							oLineChartDM.setUOM(checkForNull(resultSet.getString("uom")));
							oLineChartDM.setHistRecType(checkForNull(resultSet.getString("hist_rec_type")));
							oLineChartDM.setEventGroupDesc(checkForNull(resultSet.getString("event_group_desc")));
							
							if(checkForNull(resultSet.getString("rankk")).equals("1"))
							{
								oDiscreteValue = new DiscreteValue();
								oDiscreteValue.setResultNum(checkForNull(resultSet.getString("result_num1")));
								oDiscreteValue.setEventDateTime(checkForNull(resultSet.getString("event_date_time")));
								oDiscreteValue.setColorCellIndicator(checkForNull(resultSet.getString("color_cell_ind")));
								oDiscreteValue.setDescCellIndicator(checkForNull(resultSet.getString("desc_cell_ind")));
								oDiscreteValue.setNormalIndicator(checkForNull(resultSet.getString("norm_ind")));
								oDiscreteValue.setResultString(checkForNull(resultSet.getString("res_str")));
								oDiscreteValue.setSymbolLegend(checkForNull(resultSet.getString("symbol_legend_ind")));
								oDiscreteValue.setResultNumber(resultSet.getDouble("result_num"));
								oDiscreteValue.setEventDateTimestamp(resultSet.getTimestamp("dummydate") == null?null:resultSet.getTimestamp("dummydate"));
								//oGraphXAxis.setResultNum(oDiscreteValue.getResultNum());
								oGraphXAxis.setEventDateTime(oDiscreteValue.getEventDateTimestamp());
								//oGraphYAxis.setEventDateTime(oDiscreteValue.getEventDateTime());
								oGraphYAxis.setResultNumber(oDiscreteValue.getResultNumber());
								oLineChartDM.setCurrentDiscreteValue(oDiscreteValue);
								
							}
							else
							{
								//oGraphXAxis.setResultNum(checkForNull(resultSet.getString("result_num")));
								oGraphXAxis.setEventDateTime(resultSet.getTimestamp("dummydate") == null?null:resultSet.getTimestamp("dummydate"));
								oGraphYAxis.setResultNumber(resultSet.getDouble("result_num"));
								//oGraphYAxis.setEventDateTime(checkForNull(resultSet.getString("event_date_time")));
							}
							if(mapLineChartDM.containsKey(oLineChartDM))
							{
								//mapSparkLineDM.get(oSparkLineDM).add(oGraphXAxis);
								mapLineChartDM.get(oLineChartDM).getoGraphXAxisList().add(oGraphXAxis);
								mapLineChartDM.get(oLineChartDM).getoGraphYAxisList().add(oGraphYAxis);
								
								if(oDiscreteValue != null) // to assign the current discrete value to the linechart object present in the map.
								{
									LineChartAxisContainer objLineChartAxisContainer = mapLineChartDM.get(oLineChartDM);
									mapLineChartDM.remove(oLineChartDM);
									mapLineChartDM.put(oLineChartDM, objLineChartAxisContainer);
									
								}
							}
							else
							{
								oLineChartAxisContainer = new LineChartAxisContainer();
								oGraphXAxisList = new ArrayList<GraphXAxis>();
								oGraphYAxisList = new ArrayList<GraphYAxis>();
								oGraphXAxisList.add(oGraphXAxis);
								oGraphYAxisList.add(oGraphYAxis);
								oLineChartAxisContainer.setoGraphXAxisList(oGraphXAxisList);
								oLineChartAxisContainer.setoGraphYAxisList(oGraphYAxisList);
								mapLineChartDM.put(oLineChartDM, oLineChartAxisContainer);
							}
							int conCloseFailure = closeConnection(connection,pStmt,resultSet);
							if(conCloseFailure == 0)
							{
								resultSet = null;
								pStmt = null;
								connection = null;
							}
							Iterator<Entry<LineChartDM,LineChartAxisContainer>> iter = mapLineChartDM.entrySet().iterator();
							if(iter != null)
							{
								while(iter.hasNext())
								{
									Map.Entry<LineChartDM,LineChartAxisContainer> mEntry = iter.next();
									LineChartDM oLineChartDMEntry =  mEntry.getKey();
									LineChartAxisContainer oLineChartAxisContainerEntry = mEntry.getValue();
									oLineChartDMEntry.setLineChartAxisContainer(oLineChartAxisContainerEntry);
									lstLineChartDM.add(oLineChartDMEntry);
								}
							}
							
						}
					}
					if(lstLineChartDM != null && lstLineChartDM.size() == 0)
					{
						oErrInfo.setErrorType(Errors.COMMON_EMPTY_DATA, locale);
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
				}
				finally
				{
					int conCloseFailure = closeConnection(connection,pStmt,resultSet);
					if(conCloseFailure > 0 )
					{
						
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
		oLineChartResponse.getErrorsList().add(oErrInfo);
		return oLineChartResponse;
	}
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
}
