/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.results.daoimpl;

import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.results.healthobject.ResultGroupItem;
import eIPAD.chartsummary.results.healthobject.ResultHO;
import eIPAD.chartsummary.results.healthobject.ResultSubCategory;
import eIPAD.chartsummary.results.healthobject.ResultValue;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.results.dao.ResultsDAO;
import eIPAD.chartsummary.results.request.ResultsCatConstants;
import eIPAD.chartsummary.results.request.ResultsRequest;
import eIPAD.chartsummary.results.response.ResultsResponse;

public class ResultsDAOImpl extends GenericDAOImpl implements ResultsDAO{ 

	public ResultsResponse getResultDetails(ResultsRequest resReq){
		ResultsResponse resResp = new ResultsResponse();
		ErrorInfo errorInfo= new ErrorInfo();
		String locale = "en";
		
		if(resReq != null){
			PatContext rPatContext = resReq.getPatientContext();
			if(rPatContext != null){
				locale = (rPatContext.getLocale() == null || rPatContext.getLocale().equals("")) ? "en": rPatContext.getLocale();
				String patientId = rPatContext.getPatientId();
				String encounterId =(rPatContext.getSelectedEncounterId() == null || rPatContext.getSelectedEncounterId().equals("")) ? rPatContext.getEncounterId() : rPatContext.getSelectedEncounterId();
				String facilityId = rPatContext.getFacilityId();
				String pracType = rPatContext.getPracType();
				String practId = rPatContext.getClinicianId();
				ArrayList<String> reqCatList = resReq.getCategories();
				String reqResDataType = resReq.getResultsType();
				
				ArrayList<ResultHO> resultsList = new ArrayList<ResultHO>();
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				String normIndConstsQuery = "select HIGH_STR, LOW_STR, CRIT_STR, ABN_STR, CRIT_HIGH_STR, CRIT_LOW_STR from CR_CLIN_EVENT_PARAM where MODULE_ID='CA'";
				
				StringBuffer getResultsQuery = new StringBuffer("");
				getResultsQuery.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time,B.short_desc hist_rec_type_desc, ");
				getResultsQuery.append(" C.short_desc event_class_desc, A.event_class event_class_code, DECODE(A.event_code,A.event_group,NULL,E.short_desc)  event_group_desc, a.event_group event_group_code, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, ");
				getResultsQuery.append(" A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE ");
				getResultsQuery.append(" HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and ");
				getResultsQuery.append(" dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, ");
				/*getResultsQuery.append(" (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND, ");
				getResultsQuery.append(" (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, ");*/
				getResultsQuery.append(" a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') reported_by, ");
				getResultsQuery.append(" d.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = '"+practId+"' and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID ");
				getResultsQuery.append(" and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID ");
				getResultsQuery.append(" FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE B.LANGUAGE_ID = '"+locale+"' ");
				getResultsQuery.append(" AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = '"+locale+"' AND D.LANGUAGE_ID = '"+locale+"' ");
				getResultsQuery.append(" AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= '"+locale+"'  AND ");
				getResultsQuery.append(" e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id='"+patientId+"' ");
				getResultsQuery.append(" and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) ");
				getResultsQuery.append(" in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER ");
				getResultsQuery.append(" where patient_id= '"+patientId+"' )  )AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' ) and nvl(a.STATUS,'`') not in('S','E')  and encounter_id='"+encounterId+"' ");//
				if(reqCatList!= null && !reqCatList.isEmpty()){
					StringBuffer catCsv = new StringBuffer("");
					for(int i=0;i<reqCatList.size();i++){
						if(i == 0){
							catCsv.append(" '"+reqCatList.get(i)+"' ");
						}
						else{
							catCsv.append(", '"+reqCatList.get(i)+"' ");
						}
						
					}
					getResultsQuery.append(" and A.hist_rec_type in ("+catCsv+") ");
				}
				
				//only numeric results are needed for graph view
				if(!reqResDataType.equals(ResultsCatConstants.RESULTDATATYPE_ALL)){
					getResultsQuery.append(" and A.hist_data_type in ('"+reqResDataType+"') ");
				}
				
				getResultsQuery.append(" order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code ");
				
				try{
					con = createConnection();
					if(con == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						resResp.getErrorsList().add(errorInfo);
					}
					else{
						 String NORM_STR = "N", HIGH_STR = "H", LOW_STR = "L", CRIT_STR = "C", ABN_STR = "A", CRIT_HIGH_STR = "G", CRIT_LOW_STR = "S"; //values already present in CR_CLIN_EVENT_PARAM table
						
						pstmt=con.prepareStatement(normIndConstsQuery.toString());
						rs = pstmt.executeQuery();
						if(rs!=null){
							while(rs.next()){
								HIGH_STR = rs.getString("HIGH_STR")==null?"H":rs.getString("HIGH_STR");
								LOW_STR = rs.getString("LOW_STR")==null?"L":rs.getString("LOW_STR");
								CRIT_STR = rs.getString("CRIT_STR")==null?"C":rs.getString("CRIT_STR");
								ABN_STR = rs.getString("ABN_STR")==null?"A":rs.getString("ABN_STR");
								CRIT_HIGH_STR = rs.getString("CRIT_HIGH_STR")==null?"G":rs.getString("CRIT_HIGH_STR");
								CRIT_LOW_STR = rs.getString("CRIT_LOW_STR")==null?"S":rs.getString("CRIT_LOW_STR");
							}
						}
						
						if (rs != null) rs.close();
						if (pstmt != null) pstmt.close();
						
						pstmt=con.prepareStatement(getResultsQuery.toString());
						rs = pstmt.executeQuery();
						
						if(rs == null){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
							resResp.getErrorsList().add(errorInfo);
						}
						else{
							Date eventDateTimestamp; //query col event_date
							String eventDate; //query col event_date_time
							String eventTime; //query col event_time
							String resCatName; //query col hist_rec_type_desc
							String resSubCatName; //query col event_class_desc
							String resSubCatCode; //query col event_class_code
							String resGroupName; //query col event_group_desc
							String resGroupCode; //query col event_group_code
							String resName; //query col event_desc
							String resCode;//query col contr_sys_event_code
							String resDataType; //query col hist_data_type
							String resNumPrefix; //query col RESULT_NUM_PREFIX
							double resDbl; //query col result_num
							String resStr; //result_str
							String accessionNum; //accession_num
							String contrSysId; //contr_sys_id
							String resNumUom; //query col result_num_uom
							String normalLowStr;
							double normalLow; //query col NORMAL_LOW
							String normalHighStr;
							double normalHigh; //query col NORMAL_HIGH
							double criticalLow; //query col CRITICAL_LOW
							double criticalHigh; //query col CRITICAL_HIGH
							String normInd; //query col normalcy_ind
							boolean textExists = false; //query col text_exisits
							String textExistsYN;
							String resCatCode; //query col hist_rec_type
							String resPerformedBy; //query col event_date
							
							//Initializing the results data structure
							ArrayList<ResultHO> resultItems = new ArrayList<ResultHO>();
							//resResp.setResults(resultItems);
							//ResultHO resultHO = new ResultHO();
							//ResultSubCategory resultSubCategory = new ResultSubCategory();
							//ResultGroup resultGroup = new res
							
							ResultHO curResultHO;
							ResultSubCategory curResultSubCategory;
							ResultGroupItem curResultGroupItem;
							ResultValue curResultValue;
							ArrayList<ResultSubCategory> curResultSubCategoryList;
							ArrayList<ResultGroupItem> curResultGroupItemList;
							int curResultHOIndex;
							int curResSubCatIndex;
							int curResGrpItemIndex;
							
							while(rs.next()){
								eventDateTimestamp = rs.getTimestamp("event_date")==null?null:rs.getTimestamp("event_date");
								eventDate = rs.getString("event_date_time")==null?"":rs.getString("event_date_time");
								eventTime = rs.getString("event_time")==null?"":rs.getString("event_time");
								resCatName = rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");
								resSubCatName = rs.getString("event_class_desc")==null?"":rs.getString("event_class_desc");
								resSubCatCode = rs.getString("event_class_code")==null?"":rs.getString("event_class_code");
								resGroupName = rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");
								resGroupCode = rs.getString("event_group_code")==null?"":rs.getString("event_group_code");
								resName = rs.getString("event_desc")==null?"":rs.getString("event_desc");
								resCode = rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code");
								resDataType = rs.getString("hist_data_type")==null?"":rs.getString("hist_data_type");
								resNumPrefix = rs.getString("RESULT_NUM_PREFIX")==null?"":rs.getString("RESULT_NUM_PREFIX");
								accessionNum = rs.getString("accession_num")==null?"":rs.getString("accession_num");
								contrSysId = rs.getString("contr_sys_id")==null?"":rs.getString("contr_sys_id");
								resDbl = 0;
								normalLow = 0;
								normalHigh = 0;
								criticalLow = 0;
								criticalHigh = 0;
								resStr="";
								if(resDataType.equals("NUM")){
									resDbl = rs.getDouble("result_num");
								}else if(resDataType.equals("STR")){
									resStr = rs.getString("result_str")==null?"":rs.getString("result_str");
								}
								resNumUom = rs.getString("result_num_uom")==null?"":rs.getString("result_num_uom");
								normalLowStr = rs.getString("NORMAL_LOW")==null?"":rs.getString("NORMAL_LOW");
								normalLow = rs.getDouble("NORMAL_LOW");
								normalHighStr = rs.getString("NORMAL_HIGH")==null?"":rs.getString("NORMAL_HIGH");
								normalHigh = rs.getDouble("NORMAL_HIGH");
								criticalLow = rs.getDouble("CRITICAL_LOW");
								criticalHigh = rs.getDouble("CRITICAL_HIGH");
								normInd = rs.getString("normalcy_ind")==null?"":rs.getString("normalcy_ind");
								
								//for ascertaining if the result is normal we perform the below logic. 
								//whereas in case of non normal results, the normalcy indicator value will be already available in the db
								if(normInd.equals("")||normInd.equals(".")){
									if(normInd.equals(".")){
										//set normalcy as normal
										normInd = NORM_STR;
									}
									else if(resDataType.equals("NUM")){
										if(!normalLowStr.equals("") && !normalHighStr.equals("") && resDbl>0){
											if(resDbl >= normalLow && resDbl <= normalHigh){
												normInd = NORM_STR;
											}
										}
										else if(normalLowStr.equals("") && !normalHighStr.equals("") && resDbl>0){
											if(resDbl <= normalHigh){
												normInd = NORM_STR;
											}
										}
										else if(!normalLowStr.equals("") && normalHighStr.equals("") && resDbl>0){
											if(resDbl >= normalLow ){
												normInd = NORM_STR;
											}
										}
									}
								}
								textExistsYN = rs.getString("text_exisits")==null?"N":rs.getString("text_exisits");
								if(textExistsYN.equals("Y")){
									textExists = true;
								}
								resCatCode = rs.getString("hist_rec_type")==null?"":rs.getString("hist_rec_type");
								resPerformedBy = rs.getString("reported_by")==null?"":rs.getString("reported_by");
								
								//forming the ResultHO object
								curResultHO = new ResultHO();
								curResultHO.setCategoryCode(resCatCode);
								curResultHO.setCategoryName(resCatName);
								
								//forming the ResultSubCategory object
								curResultSubCategory = new ResultSubCategory();
								curResultSubCategory.setSubCategoryCode(resSubCatCode);
								curResultSubCategory.setSubCategoryName(resSubCatName);
								
								////forming the ResultGroupItem object
								curResultGroupItem = new ResultGroupItem();
								curResultGroupItem.setResultGroupName(resGroupName);
								curResultGroupItem.setResultGroupCode(resGroupCode);
								curResultGroupItem.setResultName(resName);
								curResultGroupItem.setResultCode(resCode);
								curResultGroupItem.setResultUom(resNumUom);
								curResultGroupItem.setResultDataType(resDataType);
								curResultGroupItem.setResultNumPrefix(resNumPrefix);
								curResultGroupItem.setNormalLow(normalLow);
								curResultGroupItem.setNormalHigh(normalHigh);
								curResultGroupItem.setCriticalLow(criticalLow);
								curResultGroupItem.setCriticalHigh(criticalHigh);
								curResultGroupItem.setContrSysId(contrSysId);
								//curResultGroupItem.getResValues().add(curResultValue);
								
								//forming the ResultValue object
								curResultValue = new ResultValue();
								curResultValue.setDate(eventDate);
								curResultValue.setTime(eventTime);
								curResultValue.setDblValue(resDbl);
								curResultValue.setStrValue(resStr);
								if(normInd.equals(NORM_STR)){
									curResultValue.setNormalcyInd(ResultValue.Normalcy.NORMAL);
								}
								else if(normInd.equals(HIGH_STR)){
									curResultValue.setNormalcyInd(ResultValue.Normalcy.HIGH);
								}
								else if(normInd.equals(LOW_STR)){
									curResultValue.setNormalcyInd(ResultValue.Normalcy.LOW);
								}
								else if(normInd.equals(CRIT_STR)){
									curResultValue.setNormalcyInd(ResultValue.Normalcy.CRITICAL);
								}
								else if(normInd.equals(ABN_STR)){
									curResultValue.setNormalcyInd(ResultValue.Normalcy.ABNORMAL);
								}
								else if(normInd.equals(CRIT_HIGH_STR)){
									curResultValue.setNormalcyInd(ResultValue.Normalcy.CRITICALHIGH);
								}
								else if(normInd.equals(CRIT_LOW_STR)){
									curResultValue.setNormalcyInd(ResultValue.Normalcy.CRITICALLOW);
								}
								else{
									curResultValue.setNormalcyInd(ResultValue.Normalcy.UNKNOWN);
								}
								curResultValue.setPerformedBy(resPerformedBy);
								curResultValue.setTextExists(textExists);
								curResultValue.setEventTimestamp(eventDateTimestamp);
								curResultValue.setAccessionNum(accessionNum);
								
								//putting the values into the data structure
								curResultHOIndex = resultItems.indexOf(curResultHO);
								//if ResultHO obj is found
								if(curResultHOIndex >= 0){
									curResultHO = resultItems.get(curResultHOIndex);
									curResultSubCategoryList = curResultHO.getResSubCat();
									
									//check if ResultSubCategory Object is found
									curResSubCatIndex = curResultSubCategoryList.indexOf(curResultSubCategory);
									if(curResSubCatIndex>=0){
										//ResultSubCategory object exists
										curResultSubCategory = curResultSubCategoryList.get(curResSubCatIndex);
										curResultGroupItemList = curResultSubCategory.getResGrpItems();
										curResGrpItemIndex = curResultSubCategory.getResGroupItemIndex(resGroupCode, resCode);
										
										if(curResGrpItemIndex>=0){
											//Item with matching group code and result code is found
											//Forming the ResultValue obj and setting it to the ResultGroupItem's ResultValue List
											curResultGroupItem = curResultGroupItemList.get(curResGrpItemIndex);
											curResultGroupItem.getResValues().add(curResultValue);
										}
										else{
											//Item with matching group code and result code is not found
											curResultGroupItem.getResValues().add(curResultValue);
											//if there is no groupcode add it to the end of list
											if(resGroupCode==null || resGroupCode.equals("")){
												curResultSubCategory.getResGrpItems().add(curResultGroupItem);
											}
											else{
												//if it has group code then add it to the end of the items under current group code
												curResGrpItemIndex = curResultGroupItemList.lastIndexOf(curResultGroupItem);
												if(curResGrpItemIndex>=0){
													curResultSubCategory.getResGrpItems().add(curResGrpItemIndex+1,curResultGroupItem);
												}
												else{
													// no items with this group code exists, hence add it to the end of the list
													curResultSubCategory.getResGrpItems().add(curResultGroupItem);
												}
											}
										}
									}
									else{
										curResultGroupItem.getResValues().add(curResultValue);
										curResultSubCategory.getResGrpItems().add(curResultGroupItem);
										curResultHO.getResSubCat().add(curResultSubCategory);
									}
								}
								else{ 									
									curResultGroupItem.getResValues().add(curResultValue);
									curResultSubCategory.getResGrpItems().add(curResultGroupItem);
									curResultHO.getResSubCat().add(curResultSubCategory);
									resultItems.add(curResultHO);
								}
							}
							resResp.setResults(resultItems);
							if(resultItems.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.RESULTS_EMPTY_DATA,locale);
								resResp.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								resResp.getErrorsList().add(errorInfo);
							}
						}
					}
				}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					resResp.getErrorsList().add(errorInfo);
				}
				catch(Exception e){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
					resResp.getErrorsList().add(errorInfo);
				}
				finally{
					int conCloseFailure = closeConnection(con,pstmt,rs);
				}
			}
			else{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
				resResp.getErrorsList().add(errorInfo);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			resResp.getErrorsList().add(errorInfo);
		}
		
		return resResp;
	}
	
	public int getResultsCount(PatContext patContext, ArrayList<String> catList, String resDataType){
		int count = 0;
		if(patContext!=null){
			String patientId = patContext.getPatientId();
			String encounterId =(patContext.getSelectedEncounterId() == null || patContext.getSelectedEncounterId().equals("")) ? patContext.getEncounterId() : patContext.getSelectedEncounterId();
			StringBuffer getResultsCountQuery = new StringBuffer("");
			getResultsCountQuery.append("select count(*) count from CR_ENCOUNTER_DETAIL where patient_id='"+patientId+"'  and  nvl(STATUS,'`') not in('S','E') and encounter_id='"+encounterId+"' and event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' ) and hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) ");
			if(catList != null && !catList.isEmpty()){
				StringBuffer catCsv = new StringBuffer("");
				for(int i=0;i<catList.size();i++){
					if(i == 0){
						catCsv.append(" '"+catList.get(i)+"' ");
					}
					else{
						catCsv.append(", '"+catList.get(i)+"' ");
					}
					
				}
				getResultsCountQuery.append(" and hist_rec_type in ("+catCsv+") ");
			}
			if(!resDataType.equals(ResultsCatConstants.RESULTDATATYPE_ALL)){
				getResultsCountQuery.append(" and hist_data_type in ('"+resDataType+"') ");
			}
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				con = createConnection();
				if(con == null){
					return count;
				}
				else{
					pstmt=con.prepareStatement(getResultsCountQuery.toString());
					rs = pstmt.executeQuery();
					if(rs != null){
						while(rs.next())
						{
							count = rs.getInt("count");
						}
					}
				}
			}
			catch(Exception e){
				count = -1;
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
				
			}
			
		}
		return count;
	}
	
	/**
	 * Query taken from FlowSheetTextMain.jsp
	 * @param histRecType
	 * @param contSysId
	 * @param accessionNum
	 * @param contrSysEventCode
	 * @return
	 */
	public String getResultNotes(String histRecType, String contSysId, String accessionNum, String contrSysEventCode){
		
		StringBuffer resultNotes = new StringBuffer("");
		StringBuffer getResultNotesQuery = new StringBuffer("");
		getResultNotesQuery.append("SELECT B.HIST_DATA,A.HIST_DATA_TYPE FROM CR_ENCOUNTER_DETAIL A, CR_ENCOUNTER_DETAIL_TXT B WHERE A.HIST_REC_TYPE = '"+histRecType+"' AND A.CONTR_SYS_ID = '"+contSysId+"' ");
		getResultNotesQuery.append(" AND A.ACCESSION_NUM = '"+accessionNum+"' AND A.CONTR_SYS_EVENT_CODE = '"+contrSysEventCode+"' AND B.HIST_REC_TYPE = A.HIST_REC_TYPE AND B.CONTR_SYS_ID = A.CONTR_SYS_ID  ");
		getResultNotesQuery.append(" AND B.ACCESSION_NUM = A.ACCESSION_NUM  AND B.CONTR_SYS_EVENT_CODE = A.CONTR_SYS_EVENT_CODE ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Clob note = null;
		try{
			con = createConnection();
			if(con == null){
				return resultNotes.toString();
			}
			else{
				pstmt=con.prepareStatement(getResultNotesQuery.toString());
				rs = pstmt.executeQuery();
				if(rs != null){
					if(rs.next())
					{
						note=rs.getClob("HIST_DATA");
						if(note!=null){
							BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
							String line = null;
							while((line=r.readLine()) != null)
							{
								resultNotes.append(line);
								resultNotes.append("\n");
							}
						}
					}
				}
			}
		}
		catch(Exception e){
			resultNotes = new StringBuffer("");
		}
		finally{
			int conCloseFailure = closeConnection(con,pstmt,rs);
			
		}
		
	
	return resultNotes.toString();
	
	}
}
