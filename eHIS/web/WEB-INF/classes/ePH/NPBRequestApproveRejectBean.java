/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;

import java.io.* ;
import java.util.* ; 
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import oracle.sql.*;

public class NPBRequestApproveRejectBean extends PhAdapter implements Serializable {

	protected String locale = null;
	protected HashMap NPBRequestDtlList = null;

	public NPBRequestApproveRejectBean() {
        try {
			initialize();
			doCommon();
        }
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void doCommon() throws Exception {
	}

	public void initialize() {
	}

	public HashMap getNPBRequestDtlList(){
		return this.NPBRequestDtlList;
	}
	public HashMap getNPBRequestDtlList(String RequestNo){
		if(this.NPBRequestDtlList!=null && this.NPBRequestDtlList.containsKey(RequestNo)){
			return (HashMap)(this.NPBRequestDtlList.get(RequestNo));
		}
		return null;
	}
	public void setNPBRequestDtlList(HashMap NPBRequestDtlList){
		this.NPBRequestDtlList = NPBRequestDtlList;
	}
	public void setNPBRequestDtlList(String RequestNo, HashMap  NPBRequestDtl){
		if(this.NPBRequestDtlList!=null && this.NPBRequestDtlList.containsKey(RequestNo)){
			this.NPBRequestDtlList.put(RequestNo, NPBRequestDtl);
		}
	}
	public void setAll(Hashtable NPBRequestDetails){
		if(NPBRequestDetails.containsKey("mode"))
			setMode((String)NPBRequestDetails.get("mode")) ;
	} 
	public void clear(){
		this.NPBRequestDtlList = null;
	}

	public String getPatientIDLength(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet			= pstmt.executeQuery(); 
			
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}		

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
				pat_txt_length	=e.toString();e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			} 
		}
		return pat_txt_length;	
	}
	public ArrayList getNPBRequestList(String patient_id, String req_pract_id, String drugName,String drugCode,String reqStatus, String reqFromDate,String reqToDate ){
		ArrayList	NPBReqFormList  = new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String  sqlstr="";
		HashMap NPBRequestDtl = null;
		HashMap NPBRequestDtlList = new HashMap();
		StringBuffer tmpsqlstr= new StringBuffer();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection	= getConnection() ;
			sqlstr = "SELECT NPBR.REQUEST_NO ,NPBR.PATIENT_ID ,NPBR.REQUEST_FACILITY_ID ,NPBR.REQUEST_ENCOUNTER_ID ,NPBR.REQUEST_PRACT_ID, to_char(npbr.request_date_time,'DD/MM/YYYY HH24:MI') REQUEST_DATE_TIME,NPBR.REQUEST_STATUS ,NPBR.REQUEST_DRUG_CODE ,NPBR.REQUEST_DRUG_NAME , NPBR.APPROVED_DRUG_CODE, NPBR.REQUEST_FORM_ID  ,NPBR.REQUEST_FORM_CONTENT, to_char(NPBR.DRUG_VALIDITY_DATE, 'dd/mm/yyyy')DRUG_VALIDITY_DATE , NPBR.REQUEST_CAN_DATE_TIME ,NPBR.REQUEST_CAN_BY_ID ,(select reason_desc from PH_MEDN_TRN_REASON_LANG_VW where appl_trn_type = 'CN' and reason_code = NPBR.REQUEST_CAN_REASON and language_id = ?) REQUEST_CAN_REASON , NPBR.REQUEST_ACK_REASON ,NPBR.REQUEST_REJ_REASON ,NPBR.REQUEST_APRV_REASON ,NPBR.REQUEST_QUANTITY ,NPBR.REQUEST_QTY_UOM_CODE, CON.CONSENT_FORM_LABEL,  (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_PRACT_ID AND LANGUAGE_ID=?) REQUEST_PRACT_NAME, (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_REJ_BY_ID AND LANGUAGE_ID=?) REJECT_PRACT_NAME, (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_CAN_BY_ID AND LANGUAGE_ID=?) CAN_PRACT_NAME, (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_ACK_BY_ID AND LANGUAGE_ID=?) ACK_PRACT_NAME,(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_APRV_BY_ID AND LANGUAGE_ID=?) APR_PRACT_NAME,(SELECT NVL (DECODE (?, 'en', c.patient_name, patient_name_loc_lang) ,PATIENT_NAME) ||', ' || get_age (c.date_of_birth) ||', '|| DECODE (c.sex, 'M', 'male', 'F', 'female', 'unknown') FROM  mp_patient c  WHERE  c.patient_id = npbr.patient_id ) patient_dtl  FROM PH_NPB_DRUG_REQUEST NPBR, OR_CONSENT_FORM_LANG_VW CON WHERE NPBR.REQUEST_FORM_ID= CON.CONSENT_FORM_ID  AND CON.CONSENT_TYPE='N' AND CON.EFF_STATUS='E' AND CON.LANGUAGE_ID=? ";
			if( patient_id !=null && !patient_id.equals(""))
				tmpsqlstr.append(" AND NPBR.PATIENT_ID = '" +patient_id+"'");
			if( req_pract_id !=null && !req_pract_id.equals(""))
				tmpsqlstr.append("  AND NPBR.REQUEST_PRACT_ID= '"+req_pract_id+"' ");

			tmpsqlstr.append(" AND NPBR.REQUEST_DATE_TIME between to_date('"+reqFromDate+"'||'00:00', 'DD/MM/YYYY HH24:MI') AND  to_date('"+reqToDate+"'||'23:59', 'DD/MM/YYYY HH24:MI') ");

			if(!drugCode.equals(""))
				tmpsqlstr.append( " AND NPBR.REQUEST_DRUG_CODE='"+drugCode+"' ");
			else if (!drugName.equals(""))
				tmpsqlstr.append(" AND upper( NPBR.REQUEST_DRUG_NAME) like upper('"+drugName+"%') ");
			
			if(reqStatus.equals("AL"))
				tmpsqlstr.append(" AND NPBR.REQUEST_STATUS <> 'C' " );
			else
				tmpsqlstr.append(" AND NPBR.REQUEST_STATUS ='"+reqStatus+"' " );
			sqlstr = sqlstr+ tmpsqlstr.toString()+"  Order by  npbr.request_no";
			pstmt		= connection.prepareStatement( sqlstr ) ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12A") ) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			pstmt.setString(7,locale);
			pstmt.setString(8,locale);
			//pstmt.setString(8,login_facility_id);
			resultSet	= pstmt.executeQuery();

			while ( resultSet != null && resultSet.next() ) {
				NPBRequestDtl = new HashMap();
				NPBRequestDtl.put("REQUEST_NO",resultSet.getString("REQUEST_NO"));
				NPBRequestDtl.put("PATIENT_ID",resultSet.getString("PATIENT_ID"));
				NPBRequestDtl.put("REQUEST_FACILITY_ID",resultSet.getString("REQUEST_FACILITY_ID"));
				NPBRequestDtl.put("REQUEST_PRACT_ID",resultSet.getString("REQUEST_PRACT_ID"));
				NPBRequestDtl.put("REQUEST_DATE_TIME",resultSet.getString("REQUEST_DATE_TIME"));
				NPBRequestDtl.put("REQUEST_STATUS",resultSet.getString("REQUEST_STATUS"));
				NPBRequestDtl.put("REQUEST_DRUG_CODE",resultSet.getString("REQUEST_DRUG_CODE"));
				NPBRequestDtl.put("REQUEST_DRUG_NAME",resultSet.getString("REQUEST_DRUG_NAME"));
				NPBRequestDtl.put("APPROVED_DRUG_CODE",resultSet.getString("APPROVED_DRUG_CODE"));
				NPBRequestDtl.put("REQUEST_FORM_ID",resultSet.getString("REQUEST_FORM_ID"));
				NPBRequestDtl.put("REQUEST_FORM_CONTENT",resultSet.getString("REQUEST_FORM_CONTENT"));
				NPBRequestDtl.put("DRUG_VALIDITY_DATE",resultSet.getString("DRUG_VALIDITY_DATE"));
				//NPBRequestDtl.put("REQUEST_CAN_DATE_TIME",resultSet.getString("REQUEST_CAN_DATE_TIME"));
				//NPBRequestDtl.put("REQUEST_CAN_BY_ID",resultSet.getString("REQUEST_CAN_BY_ID"));
				NPBRequestDtl.put("REQUEST_CAN_REASON",resultSet.getString("REQUEST_CAN_REASON"));
				//NPBRequestDtl.put("REQUEST_ACK_DATE_TIME",resultSet.getString("REQUEST_ACK_DATE_TIME"));
				NPBRequestDtl.put("REQUEST_ACK_REASON",resultSet.getString("REQUEST_ACK_REASON"));
				//NPBRequestDtl.put("REQUEST_ACK_BY_ID",resultSet.getString("REQUEST_ACK_BY_ID"));
				//NPBRequestDtl.put("REQUEST_REJ_DATE_TIME",resultSet.getString("REQUEST_REJ_DATE_TIME"));
				//NPBRequestDtl.put("REQUEST_REJ_BY_ID",resultSet.getString("REQUEST_REJ_BY_ID"));
				NPBRequestDtl.put("REQUEST_REJ_REASON",resultSet.getString("REQUEST_REJ_REASON"));
				//NPBRequestDtl.put("REQUEST_APRV_DATE_TIME",resultSet.getString("REQUEST_APRV_DATE_TIME"));
				//NPBRequestDtl.put("REQUEST_APRV_BY_ID",resultSet.getString("REQUEST_APRV_BY_ID"));
				NPBRequestDtl.put("REQUEST_APRV_REASON",resultSet.getString("REQUEST_APRV_REASON"));
				NPBRequestDtl.put("REQUEST_QUANTITY",resultSet.getString("REQUEST_QUANTITY"));
				NPBRequestDtl.put("REQUEST_QTY_UOM_CODE",resultSet.getString("REQUEST_QTY_UOM_CODE"));
				NPBRequestDtl.put("REQUEST_FORM_NAME",resultSet.getString("consent_form_label"));
				NPBRequestDtl.put("REQUEST_PRACT_NAME",resultSet.getString("REQUEST_PRACT_NAME"));
				NPBRequestDtl.put("REJECT_PRACT_NAME",resultSet.getString("REJECT_PRACT_NAME"));
				NPBRequestDtl.put("CAN_PRACT_NAME",resultSet.getString("CAN_PRACT_NAME"));
				NPBRequestDtl.put("ACK_PRACT_NAME",resultSet.getString("ACK_PRACT_NAME"));
				NPBRequestDtl.put("APR_PRACT_NAME",resultSet.getString("APR_PRACT_NAME"));
				NPBRequestDtl.put("PATIENT_DTL",resultSet.getString("PATIENT_DTL"));
				NPBReqFormList.add(NPBRequestDtl);
				NPBRequestDtlList.put(resultSet.getString("REQUEST_NO"), NPBRequestDtl);
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){ 
				es.printStackTrace() ;
			}
		}
		setNPBRequestDtlList(NPBRequestDtlList);
		return NPBReqFormList;
	}

	public HashMap modify() {
		locale= getLanguageId()==null?"en":getLanguageId();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		String  selectYN="";  //tmpNBPFormID= "", Removed for IN063877
		HashMap NPBRequestDtlList =  getNPBRequestDtlList();
		ArrayList NPBDtlList	=	new ArrayList();
		HashMap modifyNPBDtl = new HashMap();
		HashMap NPBDtl = null;

		HashMap tabData	= new HashMap() ;
		HashMap sqlMap		= new HashMap() ;
		try {
			List reqNoList = new ArrayList(NPBRequestDtlList.keySet());
			for(int reqNoCount=0; reqNoCount<reqNoList.size(); reqNoCount++){ 
				NPBDtl = (HashMap)NPBRequestDtlList.get((String) reqNoList.get(reqNoCount));
				selectYN = (String)NPBDtl.get("SELECTEDYN");
				if(selectYN!=null && selectYN.equals("Y"))
					NPBDtlList.add(NPBDtl);
			}
			modifyNPBDtl.put("NPBDtlList",NPBDtlList);
			modifyNPBDtl.put("login_by_id",login_by_id);
			modifyNPBDtl.put("login_at_ws_no",login_at_ws_no);
			modifyNPBDtl.put("login_facility_id",login_facility_id);
			modifyNPBDtl.put("locale",locale);

			tabData.put("NPBRequestDetail", modifyNPBDtl );
			tabData.put("properties", getProperties() );
			tabData.put("language_id",locale);
			 
			sqlMap.put( "SQL_PH_NPBREQUEST_APP_REJ_UPDATE", "UPDATE PH_NPB_DRUG_REQUEST SET REQUEST_STATUS=? , REQUEST_DRUG_CODE= ?, REQUEST_DRUG_NAME= ?, APPROVED_DRUG_CODE= decode(?,'J',  APPROVED_DRUG_CODE,?) , DRUG_VALIDITY_DATE =decode(?,'J', DRUG_VALIDITY_DATE, to_Date(?,'dd/mm/yyyy')),  REQUEST_ACK_DATE_TIME=decode(?,'A', sysdate, REQUEST_ACK_DATE_TIME) ,REQUEST_ACK_BY_ID =decode(?,'A',?,REQUEST_ACK_BY_ID), REQUEST_ACK_REASON =decode(?,'A', ?,REQUEST_ACK_REASON) ,REQUEST_REJ_DATE_TIME =decode(?,'J', sysdate, REQUEST_REJ_DATE_TIME) ,REQUEST_REJ_BY_ID =decode(?,'J',?,REQUEST_REJ_BY_ID) , REQUEST_REJ_REASON =decode(?,'J', ?,REQUEST_REJ_REASON) ,REQUEST_APRV_DATE_TIME =decode(?,'P', sysdate, REQUEST_APRV_DATE_TIME) , REQUEST_APRV_BY_ID =decode(?,'P',?,REQUEST_APRV_BY_ID) ,REQUEST_APRV_REASON  =decode(?,'P',?,REQUEST_APRV_REASON), MODIFIED_BY_ID =? ,MODIFIED_DATE  =sysdate,MODIFIED_AT_WS_NO  =?,MODIFIED_FACILITY_ID =?  WHERE REQUEST_NO=?");
			 
			/*
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_NPBREQUEST" ),NPBRequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			*/
			HashMap result = localModify( tabData, sqlMap ) ;
			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(locale,(String) result.get( "msgid" ),"PH"));
			}
			else {
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(locale,"EXCEPTION_OCCURED_WHILE_INSERTION","PH")+" : "+(String)map.get("flag") ) ;
			}
		}
		catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;
		}
		return map ;
	}
	private HashMap localModify( HashMap tabData , HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "" ) ;
		Connection connection					= null ;
		PreparedStatement pstmt_update	= null ;
		int  indxCount=1;//  count=0, Removed for IN063877
		ResultSet resultSet = null ;
		HashMap modifyNPBDtl = (HashMap) tabData.get("NPBRequestDetail");
		ArrayList NPBDtlList	=	null;
		HashMap NPBDtl = null;
		String request_no="", req_status="", validityDate="", remarks="", appr_drug_code, req_drug_code, req_drug_name;
		try {
			connection	= getConnection() ;
			NPBDtlList = (ArrayList)modifyNPBDtl.get("NPBDtlList");
			pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQL_PH_NPBREQUEST_APP_REJ_UPDATE"));
			for(int i=0;i<NPBDtlList.size();i++){
				indxCount = 1;
				NPBDtl = (HashMap)NPBDtlList.get(i);
				request_no = (String)NPBDtl.get("REQUEST_NO")==null?"":(String)NPBDtl.get("REQUEST_NO");
				req_status = (String)NPBDtl.get("REQUEST_STATUS")==null?"R":(String)NPBDtl.get("REQUEST_STATUS");
				validityDate = (String)NPBDtl.get("DRUG_VALIDITY_DATE")==null?"":(String)NPBDtl.get("DRUG_VALIDITY_DATE");
				remarks = (String)NPBDtl.get("NPBREMARKS")==null?"":(String)NPBDtl.get("NPBREMARKS");
				appr_drug_code = (String)NPBDtl.get("APPROVED_DRUG_CODE")==null?"":(String)NPBDtl.get("APPROVED_DRUG_CODE");
				req_drug_code = (String)NPBDtl.get("REQUEST_DRUG_CODE")==null?"":(String)NPBDtl.get("REQUEST_DRUG_CODE");
				req_drug_name = (String)NPBDtl.get("REQUEST_DRUG_NAME")==null?"":(String)NPBDtl.get("REQUEST_DRUG_NAME");
				pstmt_update.setString(indxCount++,req_status);
				pstmt_update.setString(indxCount++, appr_drug_code);
				pstmt_update.setString(indxCount++, req_drug_name);
				pstmt_update.setString(indxCount++, req_status); //based in req_status APPROVED_DRUG_CODE will be updated
				pstmt_update.setString(indxCount++, appr_drug_code);
				pstmt_update.setString(indxCount++, req_status); //based in req_status validityDate will be updated
				pstmt_update.setString(indxCount++, validityDate);

				pstmt_update.setString(indxCount++, req_status); //based in req_status REQUEST_ACK_DATE_TIME will be updated
				pstmt_update.setString(indxCount++, req_status); //based in req_status REQUEST_ACK_BY_ID will be updated
				pstmt_update.setString(indxCount++, login_by_id);
				pstmt_update.setString(indxCount++, req_status); //based in req_status REQUEST_ACK_REASON will be updated
				pstmt_update.setString(indxCount++, remarks);

				pstmt_update.setString(indxCount++, req_status); //based in req_status REQUEST_REJ_DATE_TIME will be updated
				pstmt_update.setString(indxCount++, req_status); //based in req_status REQUEST_REJ_BY_ID will be updated
				pstmt_update.setString(indxCount++, login_by_id);
				pstmt_update.setString(indxCount++, req_status); //based in req_status REQUEST_REJ_REASON will be updated
				pstmt_update.setString(indxCount++, remarks);

				pstmt_update.setString(indxCount++, req_status); //based in req_status REQUEST_APRV_DATE_TIME will be updated
				pstmt_update.setString(indxCount++, req_status); //based in req_status REQUEST_APRV_BY_ID will be updated
				pstmt_update.setString(indxCount++, login_by_id);
				pstmt_update.setString(indxCount++, req_status); //based in req_status REQUEST_APRV_REASON will be updated
				pstmt_update.setString(indxCount++, remarks);

				pstmt_update.setString(indxCount++,login_by_id);
				pstmt_update.setString(indxCount++,login_at_ws_no);
				pstmt_update.setString(indxCount++,login_facility_id);
				pstmt_update.setString(indxCount++, request_no);
				pstmt_update.addBatch();
			}
			int[] result = pstmt_update.executeBatch() ;
			boolean modify_rec = true;
			for (int i=0;i<result.length ;i++ ){
				if(result[i]<0  && result[i] != -2 ){
					modify_rec=false;
					break;
				}
				else{
					modify_rec=true;
				}
			}

			if (! modify_rec ) {
				connection.rollback();
				map.put( "message", getMessage(locale,"EXCEPTION_OCCURED_WHILE_INSERTION","PH")+" : "+(String)map.get("flag") ) ;
			}
			else {
				map.put( "result", new Boolean( true ) ) ;
				map.put("msgid","RECORD_INSERTED" ) ;
				map.put( "message", getMessage(locale,"RECORD_MODIFIED","PH") ) ;
				connection.commit();
			}
		}//end of try
		catch( Exception e ) {
			e.printStackTrace();
			map.put( "msgid", getMessage(getLanguageId(), "EXCEPTION_OCCURED_WHILE_INSERTION" ,"PH") ) ;
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement( pstmt_update ) ;
				closeConnection( connection );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}
}
