/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.daoimpl;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import eIPAD.chartsummary.CLEventHistory.dao.ClinicalEventsDAO;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventDataFieldsItem;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventDateCountItem;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventFieldItem;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventHistItemCount;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventHistItemCountDets;
import eIPAD.chartsummary.CLEventHistory.request.ClinicalEventsFilterRequest;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventDatewiseCountResponse;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventHistDataResponse;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventsFieldResponse;
import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;

/**
 * @author saraswathir
 *
 */
public class ClinicalEventsDAOImpl extends GenericDAOImpl implements ClinicalEventsDAO{
	public ClinicalEventDatewiseCountResponse getDatewiseEventsCount(ClinicalEventsFilterRequest filterReq){
		ClinicalEventDatewiseCountResponse response = new ClinicalEventDatewiseCountResponse();
		ArrayList<ClinicalEventDateCountItem> datewiseEventList = new ArrayList<ClinicalEventDateCountItem>();
		ErrorInfo errorInfo;
		String locale = "en";
		PatContext patientContext = filterReq.getPatientContext();
		if(patientContext != null){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			String patientId = patientContext.getPatientId();
			String practId = patientContext.getLoggedInUser();
			String respId = patientContext.getResponsibilityID();
			
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			
			StringBuffer encounterParam_csv = new StringBuffer("");
			ArrayList<String> encIdList = filterReq.getEncounterIdList();
			if(encIdList != null && encIdList.size()>0){
				
				for(int i=0;i<encIdList.size();i++){
					if(encIdList.size()>i+1)
						encounterParam_csv.append("?,");
					else
						encounterParam_csv.append("?");
				}
			}
			
			StringBuffer countQuery = new StringBuffer("Select to_char(a.event_date,'YYYY/MM/DD') e_date, a.event_date, a.hist_rec_type, b.short_desc hist_rec_type_desc, a.encounter_id, f.patient_class From cr_encounter_detail a , CR_HIS_RECTYP_LNG_VW b , (SELECT FACILITY_ID,patient_class,ENCOUNTER_ID,VISIT_ADM_DATE_TIME, EPISODE_ID,OP_EPISODE_VISIT_NUM FROM PR_ENCOUNTER WHERE PATIENT_ID= ? ) F where  F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR	(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,'')='A'))  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y'  and nvl(a.STATUS,'`') not in('S','E')  and  b.hist_rec_type=a.hist_rec_type and  b.language_id = ? ");
			if(filterReq.getEncounterIdList() != null && filterReq.getEncounterIdList().size()>0){
				countQuery.append(" and a.encounter_id in (");
				countQuery.append(encounterParam_csv);
				countQuery.append(" ) ");
			}
			
			if(filterReq.getPatientClass() != null && !filterReq.getPatientClass().equals("")){
				countQuery.append(" and f.patient_class = ? ");
			}
			if(filterReq.getHistoryType() != null && !filterReq.getHistoryType().equals("")){
				countQuery.append(" and a.hist_rec_type = ? ");
			}
			if(filterReq.getFromDate() != null && !filterReq.getFromDate().equals("")){
				countQuery.append(" and to_date(to_char(a.event_date,'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy') ");
			}			
			if(filterReq.getToDate() != null && !filterReq.getToDate().equals("")){				
				countQuery.append(" and to_date(to_char(a.event_date,'dd/mm/yyyy'),'dd/mm/yyyy') <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy') ");
			}
			countQuery.append(" order by  e_date desc, hist_rec_type_desc");
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					int paramCount = 0;
					pstmt=con.prepareStatement(countQuery.toString());
					pstmt.setString(++paramCount, patientId);
					pstmt.setString(++paramCount, patientId);
					pstmt.setString(++paramCount, respId);
					pstmt.setString(++paramCount, practId);
					pstmt.setString(++paramCount, respId);
					pstmt.setString(++paramCount, locale);
					if(filterReq.getEncounterIdList() != null && filterReq.getEncounterIdList().size()>0){
						for(int i=0;i<encIdList.size();i++){
							pstmt.setString(++paramCount,encIdList.get(i) );
						}
					}
					
					
					if(filterReq.getPatientClass() != null && !filterReq.getPatientClass().equals("")){
						pstmt.setString(++paramCount, filterReq.getPatientClass());
					}
					if(filterReq.getHistoryType() != null && !filterReq.getHistoryType().equals("")){
						pstmt.setString(++paramCount, filterReq.getHistoryType());
					}
					if(filterReq.getFromDate() != null && !filterReq.getFromDate().equals("")){
						pstmt.setString(++paramCount, filterReq.getFromDate());
					}
					if(filterReq.getToDate() != null && !filterReq.getToDate().equals("")){
						pstmt.setString(++paramCount, filterReq.getToDate());
					}
					
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						int count = 0;
						String histType;
						String str_eventDate;
						String histTypeDesc;
						String encounterId;
						String patientClass;
						String str_eventDatePrev = "";
						String historyTypePrev = "";
						Date eventDateTime;
						Date eventDate;
						ClinicalEventDateCountItem clinicalEventDateCountItem = new ClinicalEventDateCountItem();
						SimpleDateFormat eventDateSdf = new SimpleDateFormat("yyyy/MM/dd");
						while(rs.next()){
							histType = rs.getString("hist_rec_type");
							str_eventDate = rs.getString("e_date"); // YYYY/MM/DD
							eventDateTime = rs.getDate("event_date");
							histTypeDesc = rs.getString("hist_rec_type_desc"); 
							encounterId = rs.getString("encounter_id");
							patientClass = rs.getString("patient_class"); 
							
							eventDate = eventDateSdf.parse(str_eventDate);
							ClinicalEventHistItemCountDets eventDetails = new ClinicalEventHistItemCountDets();
							eventDetails.setEventDate(eventDate);
							eventDetails.setEventDateTime(eventDateTime);
							eventDetails.setHistType(histType);
							eventDetails.setHistDesc(histTypeDesc);
							eventDetails.setPatientClass(patientClass);
							eventDetails.setEncounterId(encounterId);
							if(!str_eventDatePrev.equals(str_eventDate)){
								clinicalEventDateCountItem = new ClinicalEventDateCountItem();
								clinicalEventDateCountItem.setEventDate(eventDate);
								datewiseEventList.add(clinicalEventDateCountItem);
								
								count = 0;
								count++;
								ClinicalEventHistItemCount clinicalEventHistItemCount = new ClinicalEventHistItemCount();
								clinicalEventHistItemCount.setHistType(histType);
								clinicalEventHistItemCount.setHistDesc(histTypeDesc);
								clinicalEventHistItemCount.setCount(count);
								clinicalEventHistItemCount.getEventDetailsList().add(eventDetails);
								clinicalEventDateCountItem.getEventItemsCount().add(clinicalEventHistItemCount);
							}else{
								if(!historyTypePrev.equals(histType)){
									count = 0;
									count ++;
									ClinicalEventHistItemCount clinicalEventHistItemCount = new ClinicalEventHistItemCount();
									clinicalEventHistItemCount.setHistType(histType);
									clinicalEventHistItemCount.setHistDesc(histTypeDesc);
									clinicalEventHistItemCount.setCount(count);
									clinicalEventHistItemCount.getEventDetailsList().add(eventDetails);
									clinicalEventDateCountItem.getEventItemsCount().add(clinicalEventHistItemCount);
								}else{
									ClinicalEventHistItemCount clinicalEventHistItemCount_compare = new ClinicalEventHistItemCount();
									clinicalEventHistItemCount_compare.setHistType(histType);
									int itemIndex = clinicalEventDateCountItem.getEventItemsCount().indexOf(clinicalEventHistItemCount_compare);
									ClinicalEventHistItemCount clinicalEventHistItemCount = clinicalEventDateCountItem.getEventItemsCount().get(itemIndex);
									clinicalEventHistItemCount.getEventDetailsList().add(eventDetails);
									count ++;
									clinicalEventHistItemCount.setCount(count);
									
								}
								
							}
							
							
							str_eventDatePrev = str_eventDate;
							historyTypePrev = histType;
						}
						response.setDatewiseEventList(datewiseEventList);
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
				
			}
		}else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
		
	}
	

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.CLEventHistory.dao.ClinicalEventsDAO#getDatewiseSelectedEvents(eIPAD.chartsummary.common.healthobject.PatContext, java.lang.String, java.lang.String)
	 */

	public ClinicalEventHistDataResponse getClinicalEventHistDataResponse(ClinicalEventsFilterRequest filterReq) {

		ClinicalEventHistDataResponse response = new ClinicalEventHistDataResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		PatContext patientContext = filterReq.getPatientContext();
		if(patientContext != null){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			String patientId = patientContext.getPatientId();
			String practId = patientContext.getLoggedInUser();
			String respId = patientContext.getResponsibilityID();
			String facId = patientContext.getFacilityId();
			ArrayList<ClinicalEventDataFieldsItem> clinicalEventDataFieldsItems= new ArrayList<ClinicalEventDataFieldsItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer encounterParam_csv = new StringBuffer("");
			ArrayList<String> encIdList = filterReq.getEncounterIdList();
			if(encIdList != null && encIdList.size()>0){
				
				for(int i=0;i<encIdList.size();i++){
					if(encIdList.size()>i+1)
						encounterParam_csv.append("?,");
					else
						encounterParam_csv.append("?");
				}
			}
			StringBuffer histDataQuery = new StringBuffer("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,event_date,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,f.patient_class,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type, ?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y'  and nvl(a.STATUS,'`') not in('S','E') and a.facility_id =  ? ");
			if(filterReq.getSelectedDate()!=null && !filterReq.getSelectedDate().equals("")){
				histDataQuery.append(" and  trunc(a.event_date)= to_date(?,'dd/mm/yyyy') ");
			}
			if(filterReq.getEncounterIdList() != null && filterReq.getEncounterIdList().size()>0){
				histDataQuery.append(" and a.encounter_id in (");
				histDataQuery.append(encounterParam_csv);
				histDataQuery.append(" ) ");
			}
			if(filterReq.getPatientClass() != null && !filterReq.getPatientClass().equals("")){
				histDataQuery.append(" and f.patient_class = ? ");
			}
			if(filterReq.getHistoryType() != null && !filterReq.getHistoryType().equals("")){
				histDataQuery.append(" and a.hist_rec_type = ? ");
			}
			histDataQuery.append("ORDER BY a.hist_rec_type, a.event_class, event_date DESC ");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					int paramCount = 0;
					pstmt=con.prepareStatement(histDataQuery.toString());
					pstmt.setString(++paramCount, locale);
					pstmt.setString(++paramCount, locale);
					pstmt.setString(++paramCount, locale);
					pstmt.setString(++paramCount, locale);
					pstmt.setString(++paramCount, locale);
					pstmt.setString(++paramCount, locale);
					pstmt.setString(++paramCount, patientId);
					pstmt.setString(++paramCount, practId);
					pstmt.setString(++paramCount, respId);
					pstmt.setString(++paramCount, facId);
					if(filterReq.getSelectedDate()!=null && !filterReq.getSelectedDate().equals("")){
						pstmt.setString(++paramCount, filterReq.getSelectedDate());
					}
					if(filterReq.getEncounterIdList() != null && filterReq.getEncounterIdList().size()>0){
						for(int i=0;i<encIdList.size();i++){
							pstmt.setString(++paramCount,encIdList.get(i));
						}
					}
					if(filterReq.getPatientClass() != null && !filterReq.getPatientClass().equals("")){
						pstmt.setString(++paramCount, filterReq.getPatientClass());
					}
					if(filterReq.getHistoryType() != null && !filterReq.getHistoryType().equals("")){
						pstmt.setString(++paramCount, filterReq.getHistoryType());
					}
					
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						
							
						String histRecType;
						String histRecTypeDesc;
						String histDataType;
						String eventClass;
						String eventClassDesc;
						String eventGroup;
						String eventGroupDesc;
						String eventCode;
						String eventDesc;
						String accessionNum;
						Date eventDateTime;
						String resultNumPrefix;
						String resultNum;
						String resultNumUom;
						String resultStr;
						String normalcyInd;
						String normalLow;
						String normalHigh;
						String criticalLow;
						String criticalHigh;
						String performedById;
						String clinicianShortName;
						String encounterId;
						String histData;
						String normalcyStr;
						String facilityId;
						String eventCodeType;
						String  contr_sys_event_code;
						String extImageObjId;
						Clob note;
						double normalLow_dbl = 0;
						double normalHigh_dbl = 0;
						double resDbl = 0;
						String patient_class;
						String deciresult;
						String decival;
						String result_uom;
						
						while(rs.next()){
							
							 normalLow_dbl = 0;
							 normalHigh_dbl = 0;
							 resDbl = 0; 
							 histRecType= rs.getString("hist_rec_type")==null?"":rs.getString("hist_rec_type");
							 histRecTypeDesc= rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");
							 histDataType =   rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
							 eventClass= rs.getString("event_class")==null?"":rs.getString("event_class");
							 eventClassDesc= rs.getString("event_class_desc")==null?"":rs.getString("event_class_desc");
							 eventGroup= rs.getString("event_group")==null?"":rs.getString("event_group");
							 eventGroupDesc=rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");
							 eventCode= rs.getString("event_code")==null?"":rs.getString("event_code");
							 eventDesc= rs.getString("event_desc")==null?"":rs.getString("event_desc");
							 
							 eventGroup= rs.getString("EVENT_GROUP")==null?"":rs.getString("EVENT_GROUP");
							 accessionNum= rs.getString("accession_num")==null?"":rs.getString("accession_num");
							 String DateTime=  rs.getString("event_date_time")==null?"":rs.getString("event_date_time");
							 contr_sys_event_code= rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code");
						
							 eventDateTime = new Date(DateTime);					 			 
							 resultNumPrefix=  rs.getString("RESULT_NUM_PREFIX")==null?"":rs.getString("RESULT_NUM_PREFIX");
						
							 resultNumUom=rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
							 resultStr=rs.getString("result_str")==null?"":rs.getString("result_str");
							
							 
							 normalcyInd=rs.getString("normalcy_ind")==null?"":rs.getString("normalcy_ind");
							 normalLow = rs.getString("normal_low")==null?"":rs.getString("normal_low");
							 normalHigh= rs.getString("normal_high")==null?"":rs.getString("normal_high");
							 criticalLow= rs.getString("critical_low")==null?"":rs.getString("critical_low");
							 criticalHigh= rs.getString("critical_high")==null?"":rs.getString("critical_high");
							 performedById=  rs.getString("performed_by_id")==null?"":rs.getString("performed_by_id");
							 clinicianShortName= rs.getString("clinician_short_name")==null?"":rs.getString("clinician_short_name");
							 encounterId=	 rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
							 histData=  rs.getString("HIST_DATA")==null?"":rs.getString("HIST_DATA");
							 note  = rs.getClob("HIST_DATA");
							 normalcyStr=   rs.getString("NORMALCY_STR")==null?"":rs.getString("NORMALCY_STR");
							 facilityId=  rs.getString("FACILITY_ID")==null?"":rs.getString("FACILITY_ID");
							 eventCodeType= rs.getString("EVENT_CODE_TYPE")==null?"":rs.getString("EVENT_CODE_TYPE");
							 extImageObjId= rs.getString("EXT_IMAGE_OBJ_ID")==null?"":rs.getString("EXT_IMAGE_OBJ_ID");
							 patient_class=rs.getString("patient_class")==null?"":rs.getString("patient_class");
							 
							 resultNum = rs.getString("RESULT_NUM") == null ? "0" : rs.getString("RESULT_NUM");
							 
							 
							 String numFormat = "&nbsp;&nbsp;&nbsp;&nbsp;";
							 String numFormatValues = "&nbsp;&nbsp;&nbsp;&nbsp;";
								if(rs.getString("RESULT_NUM_PREFIX") != null && !(rs.getString("RESULT_NUM_PREFIX")).equals(""))
								
								{
									numFormat= numFormat +  rs.getString("RESULT_NUM_PREFIX");
								}
						
								if(rs.getString("RESULT_NUM_PREFIX") != null && !(rs.getString("RESULT_NUM_PREFIX")).equals(""))
									
								{
									numFormatValues= numFormatValues +  rs.getString("RESULT_NUM_PREFIX");
								}
								
								
								
								deciresult =rs.getString("RESULT_NUM1") == null ? "0" : rs.getString("RESULT_NUM1");//IN037900
								decival = rs.getString("RESULT_NUM_DEC") == null ? "0" : rs.getString("RESULT_NUM_DEC");//IN037900
								
								
								

								if(decival.length()>0 && deciresult.length()> 9)	
									numFormat= numFormat +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ (rs.getString("RESULT_NUM1")==null?"":rs.getString("RESULT_NUM1"))+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
								else
									numFormat= numFormat +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ (rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM"))+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));

								
								result_uom = rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
								System.out.println("xxx" + numFormat);
								
								
								
								if(decival.length()>0 && deciresult.length()> 9)	
									numFormatValues= numFormatValues +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ (rs.getString("RESULT_NUM1")==null?"":rs.getString("RESULT_NUM1"));
								else
									numFormatValues= numFormatValues +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ (rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM"));

								
								
											  
							ClinicalEventDataFieldsItem fieldItem = new ClinicalEventDataFieldsItem();
							fieldItem.setDeciresult(deciresult);
							fieldItem.setDecival(decival);
							fieldItem.setResult_uom(result_uom);						
							fieldItem.setResult_Number_values(numFormatValues);
											
							
							fieldItem.setEventDateTime(eventDateTime);
							fieldItem.setHistRecType(histRecType);
							fieldItem.setHistRecTypeDesc(histRecTypeDesc);
							fieldItem.setHistDataType(histDataType);
							fieldItem.setEventClass(eventClass);
							fieldItem.setEventClassDesc(eventClassDesc);
							fieldItem.setEventGroup(eventCode);
							fieldItem.setEventGroup(eventGroup);
							fieldItem.setEventGroupDesc(eventGroupDesc);
							fieldItem.setEventCode(eventCode);
							fieldItem.setEventDesc(eventDesc);
							fieldItem.setAccessionNum(accessionNum);
							fieldItem.setResultNumPrefix(resultNumPrefix);
							fieldItem.setResultNum(resultNum);
							fieldItem.setResultNumUom(resultNumUom);
							fieldItem.setResultStr(resultStr);
							fieldItem.setNormalcyInd(normalcyInd);
							fieldItem.setNormalLow(normalLow);
							fieldItem.setNormalHigh(normalHigh);
							fieldItem.setCriticalLow(criticalLow);
							fieldItem.setCriticalHigh(criticalHigh);
							fieldItem.setPerformedById(performedById);
							fieldItem.setClinicianShortName(clinicianShortName);
							fieldItem.setEncounterId(encounterId);
							fieldItem.setHistData(histData);
							fieldItem.setNormalcyStr(normalcyStr);
							fieldItem.setFacilityId(facilityId);
							fieldItem.setContr_sys_event_code(contr_sys_event_code);
							fieldItem.setEventCodeType(eventCodeType);
							fieldItem.setExtImageObjId(extImageObjId);
							fieldItem.setEventDateTimeStr(DateTime);
							
							fieldItem.setNote(note);
							
							fieldItem.setPatient_class(patient_class);
							clinicalEventDataFieldsItems.add(fieldItem);	
						 }
				 
						response.setEventDataList(clinicalEventDataFieldsItems);
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while performing getClinicalEventHistDataResponse" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
				
			}
		}else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
		
	
		
	}

	public ClinicalEventsFieldResponse getEventHistoryTypeList(PatContext patientContext){
		ClinicalEventsFieldResponse response = new ClinicalEventsFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			String practID = patientContext.getClinicianId();
			String patientID = patientContext.getPatientId();
			String facilityID = patientContext.getFacilityId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			ArrayList<ClinicalEventFieldItem> fieldItems = new ArrayList<ClinicalEventFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer query = new StringBuffer();
			
			
			query.append(" select distinct hist_rec_type , hist_rec_type_desc  from ( ");
			query.append(" select a.hist_rec_type, CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'en','1') hist_rec_type_desc, a.patient_class, ");
			query.append(" decode(a.patient_class, 'DC','DayCare','EM','Emergency','IP','Inpatient','OP','Outpatient') patient_class_desc ");
			query.append(" From cr_encounter_detail a, PR_ENCOUNTER F ");
			query.append(" where a.patient_id = '" + patientID + "' AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
			query.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code, ");
			query.append(" a.hist_rec_type,'" + practID + "','CA',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' ");
			query.append(" and nvl(a.STATUS,'`') not in('S','E') and   a.facility_id = '" + facilityID + "' ) ");
			query.append(" order by  hist_rec_type_desc ");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(query.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String code;
						String desc;
						ClinicalEventFieldItem fieldItem;
						while(rs.next())
						{
							code = rs.getString("hist_rec_type")==null?"":rs.getString("hist_rec_type");
							desc = rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");
							fieldItem = new ClinicalEventFieldItem();
							fieldItem.setCode(code);
							fieldItem.setDesc(desc);
							fieldItems.add(fieldItem);
						}
						response.setFieldItems(fieldItems);
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while performing getEventHistoryTypeList " +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
	}
	
	public ClinicalEventsFieldResponse getEventsPatientClassList(PatContext patientContext){
		ClinicalEventsFieldResponse response = new ClinicalEventsFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			String practID = patientContext.getClinicianId();
			String patientID = patientContext.getPatientId();
			String facilityID = patientContext.getFacilityId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			ArrayList<ClinicalEventFieldItem> fieldItems = new ArrayList<ClinicalEventFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer query = new StringBuffer();
			
			query.append(" select distinct  patient_class, short_desc  from( ");
			query.append(" select a.patient_class, ");
			query.append(" decode(a.patient_class, 'DC','DayCare','EM','Emergency','IP','Inpatient','OP','Outpatient') short_desc ");
			query.append(" From cr_encounter_detail a, PR_ENCOUNTER F ");
			query.append(" where a.patient_id = '" + patientID + "'  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
			query.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code, ");
			query.append(" a.hist_rec_type,'" + practID + "','CA',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' ");
			query.append(" and nvl(a.STATUS,'`') not in('S','E') and   a.facility_id = '" + facilityID + "' ) ");
			query.append(" order by  short_desc ");
			
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(query.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String code;
						String desc;
						ClinicalEventFieldItem fieldItem;
						while(rs.next())
						{
							code = rs.getString("patient_class")==null?"":rs.getString("patient_class");
							desc = rs.getString("short_desc")==null?"":rs.getString("short_desc");
							fieldItem = new ClinicalEventFieldItem();
							fieldItem.setCode(code);
							fieldItem.setDesc(desc);
							fieldItems.add(fieldItem);
						}
						response.setFieldItems(fieldItems);
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching frequently accessed notes" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
	}
	
	

}
