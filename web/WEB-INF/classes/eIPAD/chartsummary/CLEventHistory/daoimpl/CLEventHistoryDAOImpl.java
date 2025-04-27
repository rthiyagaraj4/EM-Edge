/**
 *  @author poorani
 */
package eIPAD.chartsummary.CLEventHistory.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eIPAD.chartsummary.CLEventHistory.dao.CLEventHistoryDAO;
import eIPAD.chartsummary.CLEventHistory.healthobject.CLEventHistoryItemHO;
import eIPAD.chartsummary.CLEventHistory.response.CLEventHistoryResponse;
import eIPAD.chartsummary.CLEventHistory.request.*;


import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;

public class CLEventHistoryDAOImpl extends GenericDAOImpl implements CLEventHistoryDAO{
	
	public CLEventHistoryResponse getEventHisList(PatContext patientContext){
		CLEventHistoryResponse response = new CLEventHistoryResponse();
		//CLEventHistoryRequest oClnReq = new CLEventHistoryRequest(); for taking date
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String respId = patientContext.getResponsibilityID();
			String loggedInUser = patientContext.getLoggedInUser();
			String strPatientId = patientContext.getPatientId();
			String facilityId = patientContext.getFacilityId();
			
			
			ArrayList<CLEventHistoryItemHO> eventHisListforPanel = new ArrayList<CLEventHistoryItemHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			StringBuffer sqlStr = new StringBuffer("");
			sqlStr.append(" SELECT TO_CHAR (event_date, 'DD MON YYYY') dis_event_date, event_date , ");
			sqlStr.append(" COUNT(event_date) NoteCount, HIST_REC_TYPE, wm_concat(ACCESSION_NUM) AS ACCESSION_NUM ");
			sqlStr.append(" FROM( ");
			sqlStr.append(" SELECT a.HIST_REC_TYPE HIST_REC_TYPE, TO_DATE(TO_CHAR (a.event_date, 'DD MON YYYY')) event_date,  ");
			sqlStr.append(" a.ACCESSION_NUM FROM cr_encounter_detail a, ca_encntr_note b " );
			sqlStr.append("	WHERE a.patient_id = '" + strPatientId + "' ");
			sqlStr.append(" AND a.HIST_REC_TYPE = 'CLNT' ");
			sqlStr.append(" AND a.PATIENT_CLASS ='IP' ");
			sqlStr.append(" AND a.FACILITY_ID = '" + facilityId + "' ");
			sqlStr.append(" AND a.ACCESSION_NUM = b.ACCESSION_NUM ");
			sqlStr.append(" AND b.event_status NOT IN ('9') ");
			sqlStr.append(" ) ");
			sqlStr.append(" GROUP BY event_date, HIST_REC_TYPE " );
			sqlStr.append("	ORDER BY event_date DESC ");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(sqlStr.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String date ;
						String count;
						String Acc;
						
						
						
						while(rs.next())
						{

							date=rs.getString("dis_event_date")==null?"":rs.getString("dis_event_date");
							count=rs.getString("NoteCount")==null?"":rs.getString("NoteCount");
							Acc=rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
							
							CLEventHistoryItemHO cnEventsList = new CLEventHistoryItemHO();
							cnEventsList.setItemCode(date);
							cnEventsList.setItemCount(count);
							cnEventsList.setAssertionNo(Acc);
							eventHisListforPanel.add(cnEventsList);
						}
							
							response.setCLEventsList(eventHisListforPanel);
							if(eventHisListforPanel.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
							
						}
					}
		}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching the list" +e);
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
	
	
	
	
	
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }

}
