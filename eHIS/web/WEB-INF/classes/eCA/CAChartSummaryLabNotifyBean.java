/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
21/04/2016	IN059255			Karthi L							 				ML-MMOH-CRF-0329.1	
05/05/2016	IN060133 			Karthi L											ML-MMOH-CRF-0329.1	 
--------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import eOR.Common.* ;
import eCommon.Common.*;
import eOR.ORReviewResult.*;
import webbeans.eCommon.*;

public class CAChartSummaryLabNotifyBean extends OrAdapter implements
		Serializable {
	private String hist_rec_type;
	private String contr_sys_id;
	private String contr_sys_event_code;
	private String accession_num;
	private String review_type;
	private String create_date_time;
	private String review_remarks;
	private String normalcy_ind;
	private String practitioner_id;
	private String login_user_id;
	//private String language_id;
	public String getHist_rec_type() {
		return hist_rec_type;
	}
	public void setHist_rec_type(String hist_rec_type) {
		this.hist_rec_type = hist_rec_type;
	}
	public String getContr_sys_id() {
		return contr_sys_id;
	}
	public void setContr_sys_id(String contr_sys_id) {
		this.contr_sys_id = contr_sys_id;
	}
	public String getContr_sys_event_code() {
		return contr_sys_event_code;
	}
	public void setContr_sys_event_code(String contr_sys_event_code) {
		this.contr_sys_event_code = contr_sys_event_code;
	}
	public String getAccession_num() {
		return accession_num;
	}
	public void setAccession_num(String accession_num) {
		this.accession_num = accession_num;
	}
	public String getReview_type() {
		return review_type;
	}
	public void setReview_type(String review_type) {
		this.review_type = review_type;
	}
	public String getCreate_date_time() {
		return create_date_time;
	}
	public void setCreate_date_time(String create_date_time) {
		this.create_date_time = create_date_time;
	}
	public String getReview_remarks() {
		return review_remarks;
	}
	public void setReview_remarks(String review_remarks) {
		this.review_remarks = review_remarks;
	}
	public String getNormalcy_ind() {
		return normalcy_ind;
	}
	public void setNormalcy_ind(String normalcy_ind) {
		this.normalcy_ind = normalcy_ind;
	}
	public String getPractitioner_id() {
		return practitioner_id;
	}
	public void setPractitioner_id(String practitioner_id) {
		this.practitioner_id = practitioner_id;
	}
	public String getLogin_user_id() {
		return login_user_id;
	}
	public void setLogin_user_id(String login_user_id) {
		this.login_user_id = login_user_id;
	}
	
	public HashMap completePendReivew() throws Exception{
		HashMap logMsgMap = new HashMap() ;
		//StringBuffer tmpBuff = new StringBuffer();
		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;
		
		boolean local_ejbs = false;
		int cnt						= 1;
		String hist_rec_type 		= getHist_rec_type() == null?"":getHist_rec_type();
		String contr_sys_id 		= getContr_sys_id() == null?"":getContr_sys_id();
		String contr_sys_event_code = getContr_sys_event_code() == null?"":getContr_sys_event_code();
		String accession_num 		= getAccession_num() == null?"":getAccession_num();
		String review_type 			= getReview_type() == null?"":getReview_type();
		String create_date_time 	= getCreate_date_time() == null?"":getCreate_date_time();
		String review_remarks 		= getReview_remarks() == null?"":getReview_remarks();
		String normal_ind 			= getNormalcy_ind() == null?"":getNormalcy_ind();
		String practitioner_id 		= getPractitioner_id() == null?"":getPractitioner_id();
		String login_user_id 		= getLogin_user_id() == null?"":getLogin_user_id();
		String language_id 			= getLanguageId() == null?"":getLanguageId();
		try {
			String[] updt_data1 = new String[7];
			updt_data1[0] = hist_rec_type;
			updt_data1[1] = contr_sys_id;
			updt_data1[2] = contr_sys_event_code;
			updt_data1[3] = accession_num;
			updt_data1[4] = review_type;
			updt_data1[5] = create_date_time;
			updt_data1[6] = review_remarks;
			updt_map1.put("review_data0",updt_data1);
			updt_map1.put("pract_id",practitioner_id);
			updt_map1.put("login_by_id",login_user_id);
			updt_map1.put("totalCount",""+cnt);
			try{
				if(!normal_ind.equals("Y")) //IN033610
				{
					sqlMap.put("SQL_OR_RESULT_REVIEW_DELETE",OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_DELETE") );
					sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT",OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT") );
					sqlMap.put("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT",OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT") );
				}
				else //IN033610
				{
					sqlMap.put("SQL_OR_RESULT_REVIEW_DELETE","DELETE FROM CA_NOTIFY_REVIEW_PEND_LOG WHERE hist_rec_type=(?) AND accession_num = (?) AND pract_id=(?)" );
					sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT","INSERT INTO ca_notify_review_done_log (pract_id,hist_rec_type,contr_sys_id,accession_num,event_code,create_date_time,review_type,review_date_time,added_by_id,added_date,modified_by_id,modified_date,review_remarks,requested_by_pract_id) VALUES ((?),(?),(?),(?),(?),To_date((?),'dd/mm/yyyy hh24:mi'),(?),SYSDATE,(?),SYSDATE,(?),SYSDATE,(?),(?))" );
					sqlMap.put("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT","CALL OR_Notify_Reviewed_Pract( ? ,? ,?, ?, ? )" );
				}	
				}catch(Exception e){
				 	System.err.println("Exception in CAChartSummaryLabNotifyBean.java :  >"+e.getMessage());
				}


				//ORReviewResultHome home = null ;
				//ORReviewResultRemote remote = null ;

				try {
					updt_map1.put( "properties", getProperties() );
					
					/*InitialContext context = new InitialContext() ;
					Object object = context.lookup( OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI") ) ;
					home  = (ORReviewResultHome) PortableRemoteObject.narrow( object, ORReviewResultHome.class ) ;
					
					remote = home.create() ;

					//ORReviewResultsManager remote1 = new ORReviewResultsManager();
					traceVals.append(">>before EJB :  >"+updt_map1);
					map = remote.insert( updt_map1, sqlMap ) ;
					traceVals.append("map value   >"+map);
	                //System.out.println("traceVal="+traceVals.toString());*/
					local_ejbs = true;
					Object home =  com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ORReviewResult", ORReviewResultHome.class, local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[]	= new Object[2];
						argArray[0]		= updt_map1;
						argArray[1]		= sqlMap;
					Class [] paramArray = new Class[2];
						paramArray[0]	= updt_map1.getClass();
						paramArray[1]	= sqlMap.getClass();
					logMsgMap = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
							
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					
					if( ((Boolean) logMsgMap.get( "result" )).booleanValue() ){
						//map.put( "message", (String) map.get( "msgid" ));
						logMsgMap.put( "message", getMessage(language_id, (String) logMsgMap.get( "message" ), "SM")) ;
					}else{
						//map.put( "message", ((String) map.get("msgid"))) ;
						logMsgMap.put( "message", getMessage(language_id, (String) logMsgMap.get( "message" ), "Common")) ;
					}
					
					//map.put("traceVal", (String)tmpBuff.toString());
					//tmpBuff.setLength(0);
				} catch(Exception e) {
					System.err.println( " CAChartSummaryLabNotifyBean.java, Error Calling EJB : "+e ) ;
					logMsgMap.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
				} finally {
					clear();
					/*try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee ) {
						System.err.println( ee.getMessage() ) ;
						map.put( "message", ee.getMessage() ) ;
					}*/
				}
			
			
		} catch ( Exception e )	{
			e.printStackTrace();
			System.err.println( "208. Exception in CAChartSummaryLabNotifyBean.java => " + e.getMessage()) ;
			e.printStackTrace() ;
			throw e ;
		} 
		return logMsgMap;
	}
	public  String getReviewDetails(String histRecType, String contrSysId, String accessionNum, String eventCode, String notifyAlert, String practitioner_id) throws Exception{
		String reviewDetails = "";
		String reviewSQL = "";
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		if("Y".equalsIgnoreCase(notifyAlert)){
			reviewSQL = "SELECT REVIEW_TYPE, TO_CHAR (CREATE_DATE_TIME, 'dd/mm/yyyy hh24:mi') CREATE_DATE_TIME FROM CA_NOTIFY_REVIEW_PEND_LOG WHERE PRACT_ID = ? AND HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND ACCESSION_NUM = ? AND EVENT_CODE = ?";
		} else {
			reviewSQL = "SELECT REVIEW_TYPE, TO_CHAR (CREATE_DATE_TIME, 'dd/mm/yyyy hh24:mi') CREATE_DATE_TIME FROM CA_RESULT_REVIEW_PEND_LOG WHERE PRACT_ID = ? AND HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND ACCESSION_NUM = ? AND EVENT_CODE = ?"; 
		}
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(reviewSQL);
			pstmt.setString(1, practitioner_id);
			pstmt.setString(2, histRecType);
			pstmt.setString(3, contrSysId);
			pstmt.setString(4, accessionNum);
			pstmt.setString(5, eventCode);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				reviewDetails = resultSet.getString("review_type") + "~" + resultSet.getString("create_date_time");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.err.println(" 240. Exception in CAChartSummaryLabNotifyBean.java => " + ex.getMessage());
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
		return reviewDetails;
	}
	//IN060133 - Start
	public String getResultPendingDoneStatus(String pract_id, String accession_num, String hist_rec_type, String contr_sys_id, String event_code, String contr_sys_event_code, String normalcy_ind) throws Exception {
		String pendDoneStatus = "";
		String reviewResultNotifyQry = "";
		String contr_event_code = "";
		Connection connection = null;
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		try{
			if("C".equalsIgnoreCase(normalcy_ind)){
				reviewResultNotifyQry = "SELECT DECODE (DECODE ((SELECT   'P' FROM CA_RESULT_REVIEW_PEND_LOG WHERE PRACT_ID = ? AND ACCESSION_NUM = ? AND HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND EVENT_CODE = ? AND ROWNUM = 1), '', 'D'), 'D', DECODE ((SELECT   'D' FROM CA_RESULT_REVIEW_DONE_LOG WHERE PRACT_ID = ? AND ACCESSION_NUM = ? AND HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND CONTR_SYS_EVENT_CODE = ? AND ROWNUM = 1), '', 'N','D'), 'P') FOUND FROM DUAL";
				contr_event_code = contr_sys_event_code;
			}else{
				reviewResultNotifyQry = "SELECT DECODE (DECODE ((SELECT   'P' FROM CA_NOTIFY_REVIEW_PEND_LOG WHERE PRACT_ID = ? AND ACCESSION_NUM = ? AND HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND EVENT_CODE = ? AND ROWNUM = 1), '', 'D'), 'D', DECODE ((SELECT   'D' FROM CA_NOTIFY_REVIEW_DONE_LOG WHERE PRACT_ID = ? AND ACCESSION_NUM = ? AND HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND EVENT_CODE = ? AND ROWNUM = 1), '', 'N','D'), 'P') FOUND FROM DUAL";
				contr_event_code = event_code;
			}
 
			connection = getConnection();
			pStatment = connection.prepareStatement(reviewResultNotifyQry);
			pStatment.setString(1, pract_id);
			pStatment.setString(2, accession_num);
			pStatment.setString(3, hist_rec_type);
			pStatment.setString(4, contr_sys_id);
			pStatment.setString(5, event_code);
			pStatment.setString(6, pract_id);
			pStatment.setString(7, accession_num);
			pStatment.setString(8, hist_rec_type);
			pStatment.setString(9, contr_sys_id);
			pStatment.setString(10, contr_event_code);
			resultSet = pStatment.executeQuery();
			while(resultSet.next()){
				pendDoneStatus = resultSet.getString("FOUND");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.err.println(" 285. Exception in CAChartSummaryLabNotifyBean => " + ex.getMessage());
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			if(connection != null) connection.close();
		}
		return pendDoneStatus;
	}
	//IN060133 - End
}
