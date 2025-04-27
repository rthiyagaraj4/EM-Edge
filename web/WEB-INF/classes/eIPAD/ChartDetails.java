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



public class ChartDetails implements java.io.Serializable {
	private ArrayList<String> stringArray = null;
	public List<ChartType> getChartForCombo(PatientContext oPatientContext) throws Exception {
		List<ChartType> oChartList = new ArrayList<ChartType>() ;
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
			
			
			sqlStr.append(" SELECT a.chart_id, a.short_desc FROM ca_chart_lang_vw a  WHERE a.eff_status = 'E' AND language_id = '"+ locale +"'");
			sqlStr.append(" AND EXISTS (SELECT 1 FROM ca_chart_section_comp WHERE chart_id = a.chart_id) ");
			sqlStr.append(" AND EXISTS ( SELECT 1 FROM ca_chart_applicablity  WHERE (patient_class = '*A' OR patient_class = 'IP') AND (   speciality_code = '*ALL' ");
			sqlStr.append(" OR speciality_code =  NVL ((SELECT specialty_code  FROM pr_encounter WHERE facility_id = '" + facility_id + "' AND encounter_id = '" + strEncounterId + "'), '*ALL'  )  ) ");
			sqlStr.append("  AND (pract_type = '*A' OR pract_type = NULL)  AND (locn_type_ind = '*' OR locn_type_ind = NULL)  AND (locn_code = '*ALL' OR locn_code = NULL)  AND (   age_group_code = '*ALL' OR EXISTS ( ");
			sqlStr.append("  SELECT 1 FROM am_age_group ia, mp_patient ib WHERE ia.age_group_code = ca_chart_applicablity.age_group_code AND ib.patient_id = '" + strPatientId + "' ");
			sqlStr.append(" AND TRUNC (SYSDATE) - TRUNC (ib.date_of_birth)  BETWEEN DECODE (ia.age_unit, 'H', CASE WHEN (TRUNC (SYSDATE) - TRUNC (ib.date_of_birth)  ) = 0 THEN 0 * ia.min_age ");
			sqlStr.append(" WHEN (  (  TRUNC (SYSDATE)  - TRUNC (ib.date_of_birth) ) * 24 ) BETWEEN ia.min_age  AND ia.max_age THEN ia.min_age  END, 'D', ia.min_age, 'M', 30 * ia.min_age, 'Y', 365 * ia.min_age )");
			sqlStr.append(" AND DECODE (ia.age_unit, 'H', ia.max_age,  'D', ia.max_age,  'M', 30 * ia.max_age, 'Y', 365 * ia.max_age ) AND NVL (ia.gender, ib.sex) = ib.sex) )  AND chart_id = a.chart_id) ORDER BY 2");
			
	
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if (resultSet != null) 
					{
						resultSet.close();  
					}
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
					
						ChartType oChartType = new ChartType();
						oChartType.setChartId(((resultSet.getString("chart_id") != null) ? resultSet.getString("chart_id") : ""));
						oChartType.setChartDesc(((resultSet.getString("short_desc") != null) ? resultSet.getString("short_desc") : ""));
						oChartList.add(oChartType);
						
						
						
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
		return oChartList;
	}
	
	private List<ChartConfig> getConfig(PatientContext oPatientContext) throws Exception {
		List<ChartConfig> oChartConfigList = new ArrayList<ChartConfig>() ;
		if(oPatientContext != null && oPatientContext.request != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			PreparedStatement pstmtColor 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			ResultSet rsColor = null;
			ResultSet rsCombo = null;
			ResultSet rsIndicators = null;
			Statement stmtCombo				= null;
			PreparedStatement pstmt1 = null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String dob = "";
			String Sex = "";
			String highStr = "", lowStr = "", cricHighStr = "", cricLowStr = "";
			int nLoopcount = 0;
			/*
			String facility_id= ""; 
			String clinicianId = "" ;
			String strPracType = "";
			String strRowCount = "";
			String strPatientId = "";
			String strEncounterId = "";
			*/
			HttpServletRequest request = oPatientContext.request;
			/*
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
			*/
			if(oPatientContext.sDob != null )
			{
				dob = oPatientContext.sDob;
			}
			if(oPatientContext.sGender != null )
			{
				Sex = oPatientContext.sGender;
			}
			//sqlStr.append(" SELECT a.chart_id, a.short_desc FROM ca_chart_lang_vw a  WHERE a.eff_status = 'E' AND language_id = '"+ locale +"'");
			sqlStr.append(" SELECT   a.panel_id section_id, am_get_desc.am_discr_msr (a.panel_id,'en', '2') section_desc, a.discr_msr_id discr_msr_id, am_get_desc.am_discr_msr (a.discr_msr_id,'en', '2') discr_msr_desc, ");
			sqlStr.append(" b.NUM_DFLT_RESULT Default_Value, b.NUM_UOM Units, discr_msr.result_type result_type, a.panel_disp_order_seq display_order_seq,          a.discr_disp_order_seq order_srl_no, a.default_display_yn,");
			sqlStr.append(" a.summary_type, a.summry_column, a.sum_yn, CA_GET_FORMULA_STRING(a.FORMULA_DEF) formula_def,a.mandatory_yn, num_digits_max, num_digits_min,  num_digits_dec,  MIN_VALUE, MAX_VALUE,ref_range_type,ASSOCIATE_SCORE_YN FROM ca_chart_section_comp a, am_discr_msr discr_msr, AM_DISCR_MSR_REF_RNG_NUM b ");
			sqlStr.append(" WHERE a.chart_id ='" +oPatientContext.sChartId + "' AND discr_msr.discr_msr_id = a.discr_msr_id AND discr_msr.ch_appl_yn = 'Y' AND  a.discr_msr_id = b.discr_msr_id(+) ORDER BY a.panel_disp_order_seq, a.discr_disp_order_seq ");
	
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {
					
						ChartConfig oChartConfig = new ChartConfig();
						
						String sectionId = resultSet.getString("section_id");
						String sectionDesc = resultSet.getString("section_desc");
						String discMsrId = resultSet.getString("discr_msr_id");
					    String discMsrDesc = resultSet.getString("discr_msr_desc");
						String defaultValue = resultSet.getString("Default_Value");
						String units = resultSet.getString("Units");
						String resultType = resultSet.getString("result_type");
						String displayOrderSequence = resultSet.getString("display_order_seq"); 
						String orderSeqNo = resultSet.getString("order_srl_no");
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
					    
						oChartConfig.setSectionId(((sectionId != null) ? sectionId  : ""));
						oChartConfig.setSectionDesc(((sectionDesc != null) ? sectionDesc  : "")) ;
						oChartConfig.setDiscMsrId((( discMsrId != null) ?  discMsrId  : ""));
						oChartConfig.setDiscMsrDesc(((discMsrDesc != null ) ? discMsrDesc :""));
						oChartConfig.setDefaultValue(((defaultValue != null) ? defaultValue : "" ));
						oChartConfig.setUnits(((units != null) ? units : ""));
						oChartConfig.setResultType(((resultType != null) ? resultType : ""));
						oChartConfig.setDisplayOrderSequence(((displayOrderSequence != null) ? displayOrderSequence : ""));
						oChartConfig.setOrderSeqNo(((orderSeqNo  != null) ? orderSeqNo : ""));
						oChartConfig.setDefaultDisplayYN(defaultDisplayYN);
						oChartConfig.setSummaryType(((summaryType != null) ? summaryType : "" ));
						oChartConfig.setSummaryColumn(((summaryColumn != null) ? summaryColumn : ""  ));
						oChartConfig.setSumYN(((sumYN != null) ? sumYN : ""));
						oChartConfig.setFormulaDef(((formulaDef != null) ? formulaDef : ""));
						oChartConfig.setMandatoryYN(((mandatoryYN != null ) ? mandatoryYN : ""));
						oChartConfig.setNumDigitsMax(((numDigitsMax != null) ? numDigitsMax : "" ));
						oChartConfig.setNumDigitsMin(((numDigitsMin != null )? numDigitsMin : ""));
						oChartConfig.setNumDigitsDecimal(((numDigitsDecimal != null) ? numDigitsDecimal : ""));
						oChartConfig.setMinValue(((minValue != null) ? minValue : ""));
						oChartConfig.setMaxValue(((maxValue != null)? maxValue : "" ));
						oChartConfig.setRefRangeType(((refRangeType != null)? refRangeType : "" ));
						oChartConfig.setAssociateScoreYN(((ASSOCIATE_SCORE_YN != null)? ASSOCIATE_SCORE_YN : "" ));
						List<ChartCombo> oChartComboList = new ArrayList<ChartCombo>();
						if(resultType != null && resultType.equals("L"))
						{
							if(discMsrId != null && !discMsrId.equals(""))
							{
								
								
								StringBuffer sqlChartCombo = new StringBuffer("");
								sqlChartCombo.append(" select ref_rng_desc, NORM_ABNORM_IND, DFLT_YN, NUMERIC_VALUE REF_RANGE_SEQ from ");
								sqlChartCombo.append(" AM_DISCR_MSR_RF_RNG_LS_LANG_VW where discr_msr_id = '" + discMsrId + "' and language_id = '" +locale  + "' order by SORT_ORDER,ref_rng_desc ");
								if(connection != null)
								{
									stmtCombo = connection.createStatement();
								}
								if (rsCombo != null) 
								{
									rsCombo.close();  
								}
								if(stmtCombo != null)
									rsCombo = stmtCombo.executeQuery(sqlChartCombo.toString());
								
								while ( rsCombo != null && rsCombo.next() ) {
									ChartCombo oChartCombo = new ChartCombo();
									
									String refRangeDesc = rsCombo.getString("ref_rng_desc");
									String normAbnormIndicator = rsCombo.getString("NORM_ABNORM_IND");
									String dfltYN = rsCombo.getString("DFLT_YN");
									String refRangeSeq = rsCombo.getString("REF_RANGE_SEQ");
									
									oChartCombo.setRefRangeDesc(((refRangeDesc != null) ? refRangeDesc : ""));
									oChartCombo.setNormAbnormIndicator(((normAbnormIndicator != null) ? normAbnormIndicator : ""));
									oChartCombo.setDfltYN(((dfltYN != null) ? dfltYN : ""));
									oChartCombo.setRefRangeSeq(((refRangeSeq != null ) ? refRangeSeq : ""));
									oChartComboList.add(oChartCombo);
									
									
								}
								 if (rsCombo != null) 
								 {
										rsCombo.close();  
								 }
								 if(stmtCombo != null)
								 {
									 stmtCombo.close();
								 }
								
								
							}
						}
						
						if(oChartComboList != null && oChartComboList.size() > 0)
						{
							oChartConfig.setChartComboList(oChartComboList);
						}
						String sql1 = "select num_uom, num_ref_low, num_ref_high, num_crit_low, num_crit_high, ref_range_seq,NUM_DFLT_RESULT from am_discr_msr_ref_rng_num WHERE discr_msr_id= ? ";
						String sql2 = sql1 + " and ( to_date( ?,'dd/mm/yyyy') <=  decode(START_AGE_UNITS,'D',trunc(sysdate)-START_AGE,'M',add_months(trunc(sysdate),-1*START_AGE),'Y',add_months(trunc(sysdate),-12*START_AGE)))  and ( to_date( ?,'dd/mm/yyyy') >=  decode(END_AGE_UNITS,'D',trunc(sysdate)-END_AGE,'M',add_months(trunc(sysdate),-1*END_AGE),'Y',add_months(trunc(sysdate),-12*END_AGE)) )and PATIENT_SEX = ? ";
						if(oChartConfig.getRefRangeType().equals("M"))
		                {
							if(connection != null)
		                    pstmt1 = connection.prepareStatement(sql2);
		                }
						else
						{
							if(connection != null)
			                pstmt1 = connection.prepareStatement(sql1);
						}
						
						if(oChartConfig.getRefRangeType().equals("M"))
		                {
		                    pstmt1.setString(1,discMsrId);
		                    pstmt1.setString(2,dob);
		                    pstmt1.setString(3,dob);
		                    pstmt1.setString(4,Sex);
		                }
						else
						{
							pstmt1.setString(1,discMsrId);
						}
						if(pstmt1 != null)
						{
							 rsIndicators = pstmt1.executeQuery();
						}
						String UOM = "";
						String normalLow = "";
						String normalHigh = "";
						String criticalLow = "";
						String criticalHigh = "";
						String num_dflt_result = "";
						while( rsIndicators != null &&  rsIndicators.next())
						{
							/*
							String UOM = checkForNull(rsIndicators.getString(1));
							String NORMAL_LOW = checkForNull(rsIndicators.getString(2));
							String NORMAL_HIGH = checkForNull(rsIndicators.getString(3));
							String CRITICAL_LOW = checkForNull(rsIndicators.getString(4));
							String CRITICAL_HIGH = checkForNull(rsIndicators.getString(5));
							String NUM_DFLT_RESULT =checkForNull(rsIndicators.getString(7));
							*/
							 UOM = checkForNull(rsIndicators.getString(1));
							 normalLow = checkForNull(rsIndicators.getString(2));
							 normalHigh = checkForNull(rsIndicators.getString(3));
							 criticalLow = checkForNull(rsIndicators.getString(4));
							 criticalHigh = checkForNull(rsIndicators.getString(5));
							 num_dflt_result =checkForNull(rsIndicators.getString(7));
							
							/*
							oChartConfig.setUOM(UOM);
							oChartConfig.setNormalLow(NORMAL_LOW);
							oChartConfig.setNormalHigh(NORMAL_HIGH);
							oChartConfig.setCriticalLow(CRITICAL_LOW);
							oChartConfig.setCriticalHigh(CRITICAL_HIGH);
							oChartConfig.setNumDfltResult(NUM_DFLT_RESULT);
							*/
							 oChartConfig.setUOM(UOM);
							 oChartConfig.setNormalLow(normalLow);
							 oChartConfig.setNormalHigh(normalHigh);
							 oChartConfig.setCriticalLow(criticalLow);
							 oChartConfig.setCriticalHigh(criticalHigh);
							 oChartConfig.setNumDfltResult(num_dflt_result);
							
						}
						if(rsIndicators != null)
						{
							rsIndicators.close();
						}
						if(pstmt1 != null);
						{
							pstmt1.close();
						}
						/*
						if(resultType != null && resultType.equals("A"))
						{
							String summationFormula = "";
							String ChartID_DiscID = oChartConfig.getSectionId() + "_" + oChartConfig.getDiscMsrId();
							summationFormula = constructFormula(oChartConfig.getFormulaDef(),oChartConfig.getSectionId(),"S",ChartID_DiscID);
							oChartConfig.setSummationFormula(((summationFormula != null)? summationFormula : "" ));
						}
						*/
						if(resultType != null)
						{
							
							if(resultType.equals("N") || resultType.equals("I") )
							{
								
								String normalInd = "";
								//if(num_dflt_result != null && !num_dflt_result.equals(""))
								//{
								//	String highStr = "", lowStr = "", cricHighStr = "", cricLowStr = "";
								if(nLoopcount == 0)
								{
									if(connection != null)
									{
										pstmtColor = connection.prepareStatement("select HIGH_STR,LOW_STR,CRIT_HIGH_STR,CRIT_LOW_STR from cr_clin_event_param");
									}
									if(pstmtColor != null)
									{
										rsColor = pstmtColor.executeQuery();
										while(rsColor  != null && rsColor.next())
										{
											highStr = checkForNull(rsColor.getString("HIGH_STR"));
											lowStr = checkForNull(rsColor.getString("LOW_STR"));
											cricHighStr = checkForNull(rsColor.getString("CRIT_HIGH_STR"));
											cricLowStr = checkForNull(rsColor.getString("CRIT_LOW_STR"));
											/*
											oChartConfig.setHighStr(highStr);
											oChartConfig.setLowStr(lowStr);
											oChartConfig.setCriticalHighStr(cricHighStr);
											oChartConfig.setCriticalLowStr(cricLowStr);
											*/
											
											
										}
										if(rsColor != null)rsColor.close();
										if(pstmtColor != null)pstmtColor.close();
									}
								}
									oChartConfig.setHighStr(highStr);
									oChartConfig.setLowStr(lowStr);
									oChartConfig.setCriticalHighStr(cricHighStr);
									oChartConfig.setCriticalLowStr(cricLowStr);
									if(num_dflt_result != null && !num_dflt_result.equals(""))
									{
										if(Float.parseFloat(num_dflt_result) != 0)
										{
											
											if((!normalLow.equals("") && Float.parseFloat(normalLow) != 0) && (!normalHigh.equals("") && Float.parseFloat(normalHigh) != 0) && (!criticalLow.equals("") && Float.parseFloat(criticalLow) != 0) &&  (!criticalHigh.equals("") && Float.parseFloat(criticalHigh) != 0))
											{
												if(Float.parseFloat(num_dflt_result) >= Float.parseFloat(criticalLow) && Float.parseFloat(num_dflt_result) < Float.parseFloat(normalLow))
												{
													normalInd = lowStr;
												}
												else if(Float.parseFloat(num_dflt_result) > Float.parseFloat(criticalHigh))
												{
													normalInd = cricHighStr;
												}
												else if(Float.parseFloat(num_dflt_result) < Float.parseFloat(criticalLow))
												{
													normalInd = cricLowStr;
												}
												else if(Float.parseFloat(num_dflt_result) > Float.parseFloat(normalHigh) && Float.parseFloat(num_dflt_result) <= Float.parseFloat(criticalHigh))
												{
													normalInd = highStr;
												}
											}
											else
											{
												if(!normalLow.equals("") && Float.parseFloat(normalLow) != 0)
												{	
													if(!criticalLow.equals("") && Float.parseFloat(criticalLow) != 0)
													{
														if(Float.parseFloat(num_dflt_result) < Float.parseFloat(criticalLow)) 								normalInd = cricLowStr;
														else if((Float.parseFloat(num_dflt_result) >= Float.parseFloat(criticalLow))&&(Float.parseFloat(num_dflt_result) < Float.parseFloat(normalLow)))
															normalInd = lowStr;
													}
													else if(Float.parseFloat(num_dflt_result) < Float.parseFloat(normalLow)) normalInd = lowStr;
												}
	
												if(!normalHigh.equals("") && Float.parseFloat(normalHigh) != 0)
												{	
													if(!criticalHigh.equals("") && Float.parseFloat(criticalHigh) != 0)
													{
														if(Float.parseFloat(num_dflt_result) > Float.parseFloat(criticalHigh)) 
															normalInd = cricHighStr;
														else if((Float.parseFloat(num_dflt_result) <= Float.parseFloat(criticalHigh))&&(Float.parseFloat(num_dflt_result) > Float.parseFloat(normalHigh)))
															normalInd = highStr;	
													}
													else if(Float.parseFloat(num_dflt_result) > Float.parseFloat(normalHigh)) normalInd = highStr;					
												}
											}	
										}
										
								}//num deft
								normalInd = checkForNull(normalInd);
								oChartConfig.setNormalIndicator(normalInd);
								
							}//nORI
						}//resulttype != null
						nLoopcount = nLoopcount + 1;
						oChartConfigList.add(oChartConfig);
						
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 if (rsCombo != null) 
					 {
							rsCombo.close();  
					 }
					 if(stmtCombo != null)
					 {
						 stmtCombo.close();
					 }
					 if(rsIndicators != null)
						{
							rsIndicators.close();
						}
						if(pstmt1 != null)
						{
							pstmt1.close();
						}
						if(rsColor != null)rsColor.close();
						if(pstmtColor != null)pstmtColor.close();
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oChartConfigList;
	}
	private String constructFormula(String formula, String groups ,String flagString)
    {
		//groups = groups;

        StringBuffer sourceBuffer=null;
        String finalFormula = formula;

        String tempFormula = "";
        String tempString = "";
       
        //String emptyString = "\"\"";
        String emptyString = "";
        String tempToken ="";
        int indexValue=0;
        int dummyI=0;
        int dummyJ=0;
        indexValue =finalFormula.indexOf(tempString);
        if(!formula.equals(""))
        {

                if(flagString.equals("S")){
                    for(int indexI = 0; indexI < stringArray.size();indexI++)
                    {
                        tempString = checkForNull((String)stringArray.get(indexI)) ;

                        tempToken = "$$$" + tempString + "###";
                        dummyI = 0;
                        while((indexValue =finalFormula.indexOf(tempToken,dummyI)) !=-1 && dummyI <=finalFormula.length())
                        {
                                 sourceBuffer= new StringBuffer(finalFormula);
                                 // tempFormula =  "((eval(\"document.forms[0].custom_"+tempString+"\") == null)? 0 : eval(\"document.forms(0).custom_"+tempString+".value\")=="+emptyString+" ? 0 :parseFloat(eval(\"document.forms(0).custom_"+tempString+".value\")))";
                                // tempFormula =  "((eval(\"document.forms[0].custom_"+tempString+"\") == null)? 0 : eval(\"document.forms[0].custom_"+tempString+".value\")=="+emptyString+" ? 0 :parseFloat(eval(\"document.forms[0].custom_"+tempString+".value\")))";
                                 tempFormula =  "((eval('document.forms[0].custom_"+tempString + "') == null)? 0 : " + " eval('document.forms[0].custom_"+tempString+ ".value '" + " ) " + " == "  + "''"  + "? 0 :parseFloat(eval(" + " document.forms[0].custom_"+tempString+".value" + ")))";
                            sourceBuffer=sourceBuffer.replace(indexValue,indexValue + tempToken.length(),tempFormula);
                            finalFormula =  sourceBuffer.toString(); dummyJ =  finalFormula.indexOf(tempFormula,dummyI);
                            dummyI =dummyI +dummyJ + tempFormula.length() + 1;

                        }
                    }
                }
                else
                {
                   for(int indexI = 0; indexI < stringArray.size();indexI++)
                    {
                        tempString = checkForNull((String)stringArray.get(indexI));
                            tempToken = "$$$" + tempString + "###";
                            dummyI = 0;
                        while((indexValue =finalFormula.indexOf(tempToken,dummyI)) !=-1 && dummyI <=finalFormula.length())
                        {
                            sourceBuffer= new StringBuffer(finalFormula);
							//tempFormula ="((eval(\"parent.ChartRecordingDetailFrame.document.forms(0).custom_"+tempString+"\") == null)? 0 : eval(\"parent.ChartRecordingDetailFrame.document.forms(0).custom_"+tempString+".value\")=="+emptyString+" ? 0 :parseFloat(eval(\"parent.ChartRecordingDetailFrame.document.forms(0).custom_"+tempString+".value\")) )";
                            tempFormula ="((eval(\"parent.ChartRecordingDetailFrame.document.forms[0].custom_"+tempString+"\") == null)? 0 : eval(\"parent.ChartRecordingDetailFrame.document.forms[0].custom_"+tempString+".value\")=="+emptyString+" ? 0 :parseFloat(eval(\"parent.ChartRecordingDetailFrame.document.forms[0].custom_"+tempString+".value\")) )";
                            sourceBuffer=sourceBuffer.replace(indexValue,indexValue +tempToken.length(),tempFormula);
                            finalFormula =  sourceBuffer.toString();
                            dummyJ =  finalFormula.indexOf(tempFormula,dummyI);
                            dummyI =dummyI +dummyJ + tempFormula.length() + 1;

                        }
                    }
                }
        }

        return finalFormula;
    }    //********************************************************************************//
	public List<ChartConfig> getChartConfig(PatientContext oPatientContext) throws Exception {
		List<ChartConfig> oChartConfigList  = new ArrayList<ChartConfig>() ;
		
	
			try {
				oChartConfigList = getConfig(oPatientContext);
				int nListsize = 0;
				ChartConfig oChartConfig = null;
				int nLoopcount = 0;
				int nLoopCount1 = 0;
				
				String textName="";
				String summationFormula = "";
				stringArray = new ArrayList<String>();
				if(oChartConfigList != null )
				{
					nListsize = oChartConfigList.size();
				}
				if(nListsize > 0)
				{
					for(nLoopcount = 0; nLoopcount < nListsize; nLoopcount++)
					{
						oChartConfig = oChartConfigList.get(nLoopcount);
						if(oChartConfig != null)
						{
							textName = oChartConfig.getSectionId()+"_"+oChartConfig.getDiscMsrId();
							stringArray.add(nLoopcount,textName);
						}
					}
					for(nLoopCount1 = 0; nLoopCount1 < nListsize; nLoopCount1++)
					{
						oChartConfig = oChartConfigList.get(nLoopCount1);
						if(oChartConfig != null && oChartConfig.getResultType() != null && oChartConfig.getResultType().equals("A"))
						{
							summationFormula = constructFormula(oChartConfig.getFormulaDef(),oChartConfig.getSectionId(),"S");
							summationFormula = checkForNull(summationFormula);
							
							oChartConfig.setSummationFormula(summationFormula);
							oChartConfigList.set(nLoopCount1, oChartConfig);
							
						}
					}
					
				}
				
				  
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					
			 
			}
		
		return oChartConfigList;
	}


	 private String checkForNull(String strParam)
	    {
	            String str ="";
	            if(strParam!=null && strParam.length() >0)
	            str = strParam;
	            return str;
	    }
}
