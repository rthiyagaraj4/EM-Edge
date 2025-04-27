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
public class PanelConfigDAOImpl extends GenericDAOImpl implements PanelConfigDAO {
	public VitalsPanelResponse getPanelConfig(VitalsRequest oVitalsReq)
	{
		VitalsPanelResponse oVitalsPanelResponse = new VitalsPanelResponse();
		
		Connection connection 		= null;

		PreparedStatement pStmt				= null;
		PreparedStatement pStmtCombo				= null;
		PreparedStatement pStmtNormalcyValue				= null;
		PreparedStatement pStmtNormalcyIndicator				= null;
		
		ResultSet resultSet 		= null;
		ResultSet resultSetCombo 		= null;
		ResultSet resultSetNormalcyValue 		= null;
		ResultSet rsIndicators		= null;
		
		String locale = "en";
		String chartId = "";
		StringBuffer sqlStr = new StringBuffer("");
		//List<VitalsConfig> listVitalsConfig = new ArrayList<VitalsConfig>();
		ErrorInfo oErrInfo = new ErrorInfo();
		List<VitalsPanel> vitalsPanelList = new ArrayList<VitalsPanel>();
		
		if(oVitalsReq != null && oVitalsReq.getChartId() != null && !oVitalsReq.getChartId().equals("") )
		{
			PatContext oPatContext = oVitalsReq.getPatientContext();
			if(oPatContext != null)
			{
				//StringBuffer sqlChartCombo = new StringBuffer("");
				//StringBuffer sqlNormalcyIndicator = new StringBuffer("");
				
				Map<VitalsPanel,List<VitalsConfig>> vitalsPanelMap = new LinkedHashMap<VitalsPanel,List<VitalsConfig>>();
				locale =  checkForNull(oPatContext.getLocale());
				chartId = checkForNull(oVitalsReq.getChartId());
				List<VitalsConfig> vitalsConfigList;
				
				if(locale.equals(""))
				{
					locale = "en";
				}
				sqlStr.append(" SELECT   a.panel_id section_id, am_get_desc.am_discr_msr (a.panel_id,'" + locale+"', '2') section_desc, a.discr_msr_id discr_msr_id, am_get_desc.am_discr_msr (a.discr_msr_id,'" + locale+"', '2') discr_msr_desc, ");
				sqlStr.append(" b.NUM_DFLT_RESULT Default_Value, b.NUM_UOM Units, discr_msr.result_type result_type, a.panel_disp_order_seq display_order_seq,          a.discr_disp_order_seq order_srl_no, a.default_display_yn,");
				sqlStr.append(" a.summary_type, a.summry_column, a.sum_yn, CA_GET_FORMULA_STRING(a.FORMULA_DEF) formula_def,a.mandatory_yn, num_digits_max, num_digits_min,  num_digits_dec,  MIN_VALUE, MAX_VALUE,ref_range_type,ASSOCIATE_SCORE_YN FROM ca_chart_section_comp a, am_discr_msr discr_msr, AM_DISCR_MSR_REF_RNG_NUM b ");
				//sqlStr.append(" WHERE a.chart_id ='" + chartId + "' AND discr_msr.discr_msr_id = a.discr_msr_id AND discr_msr.ch_appl_yn = 'Y' AND  a.discr_msr_id = b.discr_msr_id(+) ORDER BY a.panel_disp_order_seq, a.discr_disp_order_seq ");
				sqlStr.append(" WHERE a.chart_id ='" + chartId + "' AND discr_msr.discr_msr_id = a.discr_msr_id AND discr_msr.ch_appl_yn = 'Y' AND  a.discr_msr_id = b.discr_msr_id(+)  ");
				if(oVitalsReq.getFilterByEventCode() != null && !oVitalsReq.getFilterByEventCode().equals(""))
				{
					if(oVitalsReq.getFilterByEventCode().indexOf(",") == -1)
					{
						sqlStr.append(" AND a.discr_msr_id = '" + oVitalsReq.getFilterByEventCode() + "' ");
					}
					else
					{
						sqlStr.append(" AND a.discr_msr_id in ( " );
						StringTokenizer st = null;
						st = new StringTokenizer(oVitalsReq.getFilterByEventCode(),",");
						int nTokenCount = 0;
						while (st.hasMoreTokens())
						{
							if(nTokenCount == 0)
							{
								sqlStr.append(" '" +st.nextElement() + "'");
							}
							else
							{
								sqlStr.append(" , '" +st.nextElement() + "'");
							}
							nTokenCount++;
							
						}
						sqlStr.append( " ) ");
					}
				}
				sqlStr.append(" ORDER BY a.panel_disp_order_seq, a.discr_disp_order_seq ");
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
							VitalsPanel oVitalsPanel = new VitalsPanel();
							VitalsConfig oVitalsConfig = new VitalsConfig();
							
							String sectionId = resultSet.getString("section_id");
							String sectionDesc = resultSet.getString("section_desc");
							String discMsrId = resultSet.getString("discr_msr_id");
						    String discMsrDesc = resultSet.getString("discr_msr_desc");
						    String units = resultSet.getString("Units");
						    String defaultValue = resultSet.getString("Default_Value");
							String displayOrderSequence = resultSet.getString("display_order_seq"); 
							String orderSeqNo = resultSet.getString("order_srl_no");
							String resultType = resultSet.getString("result_type");
							String defaultDisplayYN = resultSet.getString("default_display_yn");
							String summaryType = resultSet.getString("summary_type");
							String summaryColumn = resultSet.getString("summry_column");
							String sumYN = resultSet.getString("sum_yn");
							String formulaDef = resultSet.getString("formula_def");
							String mandatoryYN = resultSet.getString("mandatory_yn");
							String numDigitsMax = resultSet.getString("num_digits_max");
							String numDigitsMin = resultSet.getString("num_digits_min");
							String numDigitsDecimal = resultSet.getString("num_digits_dec");
							String minValue = resultSet.getString("MIN_VALUE");
							String maxValue = resultSet.getString("MAX_VALUE");
						    String refRangeType = resultSet.getString("ref_range_type");
						    String ASSOCIATE_SCORE_YN = resultSet.getString("ASSOCIATE_SCORE_YN");
							
							oVitalsPanel.setSectionId(((sectionId != null) ? sectionId  : ""));
							oVitalsPanel.setSectionDesc(((sectionDesc != null) ? sectionDesc  : "")) ;
							
							oVitalsConfig.setSectionId(((sectionId != null) ? sectionId  : ""));
							oVitalsConfig.setSectionDesc(((sectionDesc != null) ? sectionDesc  : "")) ;
							oVitalsConfig.setDiscreteMeasureId((( discMsrId != null) ?  discMsrId  : ""));
							oVitalsConfig.setDiscreteMeasureDesc(((discMsrDesc != null ) ? discMsrDesc :""));
							oVitalsConfig.setDefaultValue(((defaultValue != null) ? defaultValue : "" ));
							oVitalsConfig.setUnits(((units != null) ? units : ""));
							oVitalsConfig.setPanelOrderSequence(((displayOrderSequence != null) ? displayOrderSequence : ""));
							oVitalsConfig.setDiscOrderSequence(((orderSeqNo  != null) ? orderSeqNo : ""));
							oVitalsConfig.setResultType(((resultType != null) ? resultType : ""));
							oVitalsConfig.setDefaultDisplayYN(defaultDisplayYN);
							oVitalsConfig.setSummaryType(((summaryType != null) ? summaryType : "" ));
							oVitalsConfig.setSummaryColumn(((summaryColumn != null) ? summaryColumn : ""  ));
							oVitalsConfig.setSumYN(((sumYN != null) ? sumYN : ""));
							oVitalsConfig.setFormulaDef(((formulaDef != null) ? formulaDef : ""));
							oVitalsConfig.setMandatoryYN(((mandatoryYN != null ) ? mandatoryYN : ""));
							oVitalsConfig.setNumDigitsMax(((numDigitsMax != null) ? numDigitsMax : "" ));
							oVitalsConfig.setNumDigitsMin(((numDigitsMin != null )? numDigitsMin : ""));
							oVitalsConfig.setNumDigitsDecimal(((numDigitsDecimal != null) ? numDigitsDecimal : ""));
							oVitalsConfig.setMinValue(((minValue != null) ? minValue : ""));
							oVitalsConfig.setMaxValue(((maxValue != null)? maxValue : "" ));
							oVitalsConfig.setRefRangeType(((refRangeType != null)? refRangeType : "" ));
							oVitalsConfig.setAssociateScoreYN(((ASSOCIATE_SCORE_YN != null)? ASSOCIATE_SCORE_YN : "" ));
							
							//to fill the combo box with values
							if(oVitalsConfig.getResultType() != null && oVitalsConfig.getResultType().equals("L"))
							{
								List<ChartCombo> oChartComboList = new ArrayList<ChartCombo>();
								if(oVitalsConfig.getDiscreteMeasureId() != null && !oVitalsConfig.getDiscreteMeasureId().equals(""))
								{
									StringBuffer sqlChartCombo = new StringBuffer("");
									sqlChartCombo.append(" select ref_rng_desc, NORM_ABNORM_IND, DFLT_YN, NUMERIC_VALUE REF_RANGE_SEQ from ");
									sqlChartCombo.append(" AM_DISCR_MSR_RF_RNG_LS_LANG_VW where discr_msr_id = '" + oVitalsConfig.getDiscreteMeasureId() + "' and language_id = '" +locale  + "' order by SORT_ORDER,ref_rng_desc ");
									
									//connectionCombo = createConnection();
									if(connection != null)
									{
										pStmtCombo = connection.prepareStatement(sqlChartCombo.toString());
										
									}
									if(pStmtCombo != null)
									{
										resultSetCombo = pStmtCombo.executeQuery();
									}
									if(resultSetCombo != null)
									{
										while(resultSetCombo.next())
										{
											ChartCombo oChartCombo = new ChartCombo();
											
											String refRangeDesc = resultSetCombo.getString("ref_rng_desc");
											String normAbnormIndicator = resultSetCombo.getString("NORM_ABNORM_IND");
											String dfltYN = resultSetCombo.getString("DFLT_YN");
											String refRangeSeq = resultSetCombo.getString("REF_RANGE_SEQ");
											
											oChartCombo.setRefRangeDesc(((refRangeDesc != null) ? refRangeDesc : ""));
											oChartCombo.setNormAbnormIndicator(((normAbnormIndicator != null) ? normAbnormIndicator : ""));
											oChartCombo.setDfltYN(((dfltYN != null) ? dfltYN : ""));
											oChartCombo.setRefRangeSeq(((refRangeSeq != null ) ? refRangeSeq : ""));
											
											oChartComboList.add(oChartCombo);
											
										}
										closeConnection(resultSetCombo);
										closeConnection(pStmtCombo);
									
										
										if(oChartComboList != null && oChartComboList.size() > 0)
										{	
											oVitalsConfig.setChartComboList(oChartComboList);
										}
									}
								}
								
							}//if combo resultype
							
							//-----to fill normal high and low values------
							
							String sql1 = " select num_uom, num_ref_low, num_ref_high, num_crit_low, num_crit_high, ref_range_seq,NUM_DFLT_RESULT from am_discr_msr_ref_rng_num WHERE discr_msr_id= ? ";
							String sql2 = sql1 + " and ( to_date( ?,'dd/mm/yyyy') <=  decode(START_AGE_UNITS,'D',trunc(sysdate)-START_AGE,'M',add_months(trunc(sysdate),-1*START_AGE),'Y',add_months(trunc(sysdate),-12*START_AGE)))  and ( to_date( ?,'dd/mm/yyyy') >=  decode(END_AGE_UNITS,'D',trunc(sysdate)-END_AGE,'M',add_months(trunc(sysdate),-1*END_AGE),'Y',add_months(trunc(sysdate),-12*END_AGE)) )and PATIENT_SEX = ? ";
							
							if(oVitalsConfig.getRefRangeType() != null && oVitalsConfig.getRefRangeType().equals("M"))
							{
								if(connection != null)
								{
									pStmtNormalcyIndicator = connection.prepareStatement(sql2);
								}
								if( pStmtNormalcyIndicator != null)
								{
									pStmtNormalcyIndicator.setString(1,oVitalsConfig.getDiscreteMeasureId());
									pStmtNormalcyIndicator.setString(2,oPatContext.getDob());
									pStmtNormalcyIndicator.setString(3,oPatContext.getDob());
									pStmtNormalcyIndicator.setString(4,oPatContext.getGender());
								}
							}
							else
							{
								if(connection != null)
								{
									pStmtNormalcyIndicator = connection.prepareStatement(sql1);
								}
								if( pStmtNormalcyIndicator != null)
								{
									pStmtNormalcyIndicator.setString(1,oVitalsConfig.getDiscreteMeasureId());
								}
							}   
							
							if( pStmtNormalcyIndicator != null)
							{
								rsIndicators = pStmtNormalcyIndicator.executeQuery();
							}
							
							String UOM = "";
							String normalLow = "";
							String normalHigh = "";
							String criticalLow = "";
							String criticalHigh = "";
							String num_dflt_result = "";
							
							if(rsIndicators != null)
							{
								while(  rsIndicators.next())
								{
									 UOM = checkForNull(rsIndicators.getString(1));
									 normalLow = checkForNull(rsIndicators.getString(2));
									 normalHigh = checkForNull(rsIndicators.getString(3));
									 criticalLow = checkForNull(rsIndicators.getString(4));
									 criticalHigh = checkForNull(rsIndicators.getString(5));
									 num_dflt_result =checkForNull(rsIndicators.getString(7));
									 
									 oVitalsConfig.setUOM(UOM);
									 oVitalsConfig.setNormalLow(normalLow);
									 oVitalsConfig.setNormalHigh(normalHigh);
									 oVitalsConfig.setCriticalLow(criticalLow);
									 oVitalsConfig.setCriticalHigh(criticalHigh);
									 oVitalsConfig.setNumDfltResult(num_dflt_result);
								}
								closeConnection(rsIndicators);
								closeConnection(pStmtNormalcyIndicator);
							}
							//----------normal high and low values end--------------
							
							if(vitalsPanelMap.containsKey(oVitalsPanel))
							{
								vitalsPanelMap.get(oVitalsPanel).add(oVitalsConfig);
							}
							else
							{
								vitalsConfigList = new ArrayList<VitalsConfig>();
								vitalsConfigList.add(oVitalsConfig);
								vitalsPanelMap.put(oVitalsPanel, vitalsConfigList);
							}
							
						}//parent while loop.
						
						//--------to get the high and low str from configuration.
						if(connection != null)
						{
							pStmtNormalcyValue = connection.prepareStatement("select HIGH_STR,LOW_STR,CRIT_HIGH_STR,CRIT_LOW_STR from cr_clin_event_param");
							if(pStmtNormalcyValue != null)
							{
								resultSetNormalcyValue = pStmtNormalcyValue.executeQuery();
								if(resultSetNormalcyValue != null)
								{
									NormalcyIndicator oNormalcyIndicator = new NormalcyIndicator();
									while(resultSetNormalcyValue.next())
									{
										oNormalcyIndicator.setHighValueDescription(checkForNull(resultSetNormalcyValue.getString("HIGH_STR")));
										oNormalcyIndicator.setLowValueDescription(checkForNull(resultSetNormalcyValue.getString("LOW_STR")));
										oNormalcyIndicator.setCriticalHighDescription(checkForNull(resultSetNormalcyValue.getString("CRIT_HIGH_STR")));
										oNormalcyIndicator.setCriticalLowDescription(checkForNull(resultSetNormalcyValue.getString("CRIT_LOW_STR")));
									}
									oVitalsPanelResponse.setNormalcyIndicator(oNormalcyIndicator);
									
								}
							}
							closeConnection(resultSetNormalcyValue);
							closeConnection(pStmtNormalcyValue);
						}
						closeConnection(connection,pStmt,resultSet);
						Iterator<Entry<VitalsPanel,List<VitalsConfig>>> iter = vitalsPanelMap.entrySet().iterator();
						if(iter != null)
						{
							while (iter.hasNext()) {
								
								Map.Entry<VitalsPanel,List<VitalsConfig>> mEntry = iter.next();
								VitalsPanel oVitalsPanelEntry = mEntry.getKey();
								List<VitalsConfig> vitalsConfigListEntry = mEntry.getValue();
								oVitalsPanelEntry.setVitalsConfigList(vitalsConfigListEntry);
								vitalsPanelList.add(oVitalsPanelEntry);
								
							}
						}
						if(vitalsPanelList != null && vitalsPanelList.size() == 0)
						{
							oErrInfo.setErrorType(Errors.COMMON_EMPTY_DATA, locale);
						}
						
						
						
					}// if resultset not equal to null
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
				}
				finally
				{
					closeConnection(resultSetCombo);
					closeConnection(pStmtCombo);
					
					closeConnection(rsIndicators);
					closeConnection(pStmtNormalcyIndicator);
					
					closeConnection(resultSetNormalcyValue);
					closeConnection(pStmtNormalcyValue);
					
					closeConnection(connection,pStmt,resultSet);
					
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
		oVitalsPanelResponse.setListVitalsPanel(vitalsPanelList);
		oVitalsPanelResponse.getErrorsList().add(oErrInfo);
		return oVitalsPanelResponse;
	}
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }

}
