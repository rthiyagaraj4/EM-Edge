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

public class NPBRequestBean extends PhAdapter implements Serializable {

	protected ArrayList NPBFormList = null;
	protected String NPBReqFormId = null;
	protected String NPBReqFormText = null;
	protected String locale = null;
	protected Hashtable NPBRequestDetail = null;
	protected HashMap NPBRequestFormDetail = null;
	protected HashMap OrderDetails = null;

	public NPBRequestBean() {
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

	public ArrayList getNPBFormsList(){
		return this.NPBFormList;
	}
	public void setNPBFormsList(ArrayList NPBFormList){
		this.NPBFormList = NPBFormList;
	}

	public HashMap getOrderDetails(){
		return this.OrderDetails;
	}
	public void setOrderDetails(HashMap OrderDetails){
		this.OrderDetails = OrderDetails;
	}

	public String getNPBReqFormId(){
		return this.NPBReqFormId;
	}
	public void setNPBReqFormId(String NPBReqFormId){
		this.NPBReqFormId = NPBReqFormId;
	}

	public String getNPBReqFormText(){
		return this.NPBReqFormText;
	}
	public void setNPBReqFormText(String NPBReqFormText){
		this.NPBReqFormText = NPBReqFormText;
	}
	public String getConsentDetail(){
		return this.NPBReqFormText;
	}
	public HashMap getNPBRequestFormDetail(){
		return this.NPBRequestFormDetail;
	}
	public String getNPBRequestFormText(String RequestNo){
		if(this.NPBRequestFormDetail!=null && this.NPBRequestFormDetail.containsKey(RequestNo)){
			return (String)(this.NPBRequestFormDetail.get(RequestNo));
		}
		return null;
	}
	public void setNPBRequestFormDetail(HashMap NPBRequestFormDetail){
		this.NPBRequestFormDetail = NPBRequestFormDetail;
	}
	public void setNPBRequestFormText(String RequestNo, String NPBReqFormText){
		if(this.NPBRequestFormDetail!=null && this.NPBRequestFormDetail.containsKey(RequestNo)){
			this.NPBRequestFormDetail.put(RequestNo, NPBReqFormText);
		}
	}
	public void clear(){
		this.NPBFormList = null;
		this.NPBReqFormId = null;
		this.NPBReqFormText = null;
		this.NPBRequestDetail = null;
		this.NPBRequestFormDetail = null;
	}
	public void setAll(Hashtable NPBRequestDetail){
		if(NPBRequestDetail.containsKey("mode"))
			setMode((String)NPBRequestDetail.get("mode")) ;
		this.NPBRequestDetail = NPBRequestDetail ;
	} 
	public void loadNPBFormsList(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
		ResultSet resultSet = null;
		ArrayList NPBFormListTmp = new ArrayList();
		try{
			connection = getConnection() ;
            String sql_query			=  PhRepository.getPhKeyValue("SQL_PH_SELECT_NPB_REQUEST_FORM_LIST") ; 
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString( 1, getLanguageId());
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null ){
				while(resultSet.next()){
					NPBFormListTmp.add(checkForNull(resultSet.getString("consent_form_id")));
					NPBFormListTmp.add(checkForNull(resultSet.getString("consent_form_label")));
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		setNPBFormsList(NPBFormListTmp);
	}
	public String getConsentDetail(String NPBReqFormId,  String facility_id, String pat_id, String encntr_id) throws Exception {
	//String catalog_code, 
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		PreparedStatement pstmt_template= null;
		ResultSet resultSet 			= null;
		ResultSet resultSet_template	= null;
		String ConsentDet = "", consent_format="" ;

		if(!NPBReqFormId.equals(getNPBReqFormId())){
			java.sql.Clob	clob_notes_content	= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_NPB_REQUEST_FORM_CONTENT") ) ;
				pstmt.setString( 1, NPBReqFormId);
				resultSet = pstmt.executeQuery() ;
				if(resultSet.next()){
					clob_notes_content	=	(java.sql.Clob) resultSet.getObject("CONSENT_FORM_CONTENT");
					consent_format	=	 resultSet.getString("CONSENT_FORMAT");
					if(clob_notes_content!=null && clob_notes_content.length() > 0){
						ConsentDet = clob_notes_content.getSubString(1,( (int)clob_notes_content.length() ));
					}
					if(ConsentDet!=null && !ConsentDet.equals("") && consent_format.equals("E")) {
						ConsentDet		= getMnemonicDetails(pat_id, facility_id, encntr_id,  consent_format,  ConsentDet, getOrderDetails()); 
					}
					setNPBReqFormId(NPBReqFormId);
					setNPBReqFormText(ConsentDet);
				}//end of if -resultSet.next
			} catch ( Exception e )	{
				e.printStackTrace() ;
			} 
			finally {
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet_template ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_template ) ;
				closeConnection(connection);
			}
		}
		else
			ConsentDet = getNPBReqFormText();
		return ConsentDet;
	}
	public ArrayList loadQuantityUOM(){

		ArrayList	qtyUOMList  = new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT3") ) ;
			pstmt.setString(1,locale);
			resultSet	= pstmt.executeQuery();

			while ( resultSet != null && resultSet.next() ) {
				qtyUOMList.add(resultSet.getString("UOM_CODE"));
				qtyUOMList.add(resultSet.getString("SHORT_DESC"));
				qtyUOMList.add("");
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
		return qtyUOMList;
	}
	public ArrayList loadQuantityUOM(String drugCode){

		ArrayList	qtyUOMList  = new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String formCode = "", pres_base_uom="";
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT11") ) ;
			pstmt.setString(1,drugCode);
			resultSet	= pstmt.executeQuery();

			while ( resultSet != null && resultSet.next() ) {
				formCode = resultSet.getString("FORM_CODE");
				pres_base_uom = resultSet.getString("PRES_BASE_UOM");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12A") ) ;
			pstmt.setString(1,formCode);
			pstmt.setString(2,locale);		
			pstmt.setString(3,formCode);
			pstmt.setString(4,formCode);
			pstmt.setString(5,formCode);
			pstmt.setString(6,locale);		
			pstmt.setString(7,formCode);
			pstmt.setString(8,formCode);
			pstmt.setString(9,formCode);		
			pstmt.setString(10,locale);		
			resultSet	= pstmt.executeQuery();

			while ( resultSet != null && resultSet.next() ) {

				qtyUOMList.add(resultSet.getString("UOM_CODE"));
				qtyUOMList.add(resultSet.getString("SHORT_DESC"));
				if(pres_base_uom.equals(resultSet.getString("UOM_CODE")))
					qtyUOMList.add("Y");
				else
					qtyUOMList.add("N");
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
		return qtyUOMList;
	}

	public ArrayList loadCancelReason(){

		ArrayList	canReasonList  = new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_SELECT_NPB_REQUEST_CANCEL_REASON") ) ;
			pstmt.setString(1,locale);
			resultSet	= pstmt.executeQuery();

			while ( resultSet != null && resultSet.next() ) {
				canReasonList.add(resultSet.getString("REASON_CODE"));
				canReasonList.add(resultSet.getString("REASON_DESC"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
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
		return canReasonList;
	}

	public ArrayList getNPBRequestList(String patient_id, String encounter_id, String reqFromDate,String reqToDate, String drugName,String drugCode, String NPBReqFormId, String reqStatus ){
		ArrayList	NPBRequestList  = new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String  sqlstr="";
		HashMap NPBRequestDtl = null;
		HashMap NPBRequestFormDtl = new HashMap();
		StringBuffer tmpsqlstr= new StringBuffer();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection	= getConnection() ;
			sqlstr = "SELECT NPBR.REQUEST_NO ,NPBR.PATIENT_ID ,NPBR.REQUEST_FACILITY_ID ,NPBR.REQUEST_ENCOUNTER_ID ,NPBR.REQUEST_PRACT_ID, to_char(npbr.request_date_time,'DD/MM/YYYY HH24:MI') REQUEST_DATE_TIME,NPBR.REQUEST_STATUS ,NPBR.REQUEST_DRUG_CODE ,NPBR.REQUEST_DRUG_NAME ,NPBR.REQUEST_FORM_ID  ,NPBR.REQUEST_FORM_CONTENT , to_char(NPBR.REQUEST_CAN_DATE_TIME,'DD/MM/YYYY HH24:MI') REQUEST_CAN_DATE_TIME ,NPBR.REQUEST_CAN_BY_ID ,NPBR.REQUEST_CAN_REASON , to_char(NPBR.REQUEST_ACK_DATE_TIME,'DD/MM/YYYY HH24:MI') REQUEST_ACK_DATE_TIME, NPBR.REQUEST_ACK_BY_ID ,NPBR.REQUEST_ACK_REASON ,to_char(NPBR.REQUEST_REJ_DATE_TIME,'DD/MM/YYYY HH24:MI') REQUEST_REJ_DATE_TIME, NPBR.REQUEST_REJ_BY_ID ,NPBR.REQUEST_REJ_REASON ,to_char(NPBR.REQUEST_APRV_DATE_TIME,'DD/MM/YYYY HH24:MI') REQUEST_APRV_DATE_TIME, NPBR.REQUEST_APRV_BY_ID ,NPBR.REQUEST_APRV_REASON ,to_char(NPBR.REQUEST_AMEND_DATE_TIME,'DD/MM/YYYY HH24:MI') REQUEST_AMEND_DATE_TIME,NPBR.REQUEST_AMEND_BY_ID ,NPBR.REQUEST_QUANTITY ,NPBR.REQUEST_QTY_UOM_CODE, CON.CONSENT_FORM_LABEL, (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_PRACT_ID AND LANGUAGE_ID=?) REQUEST_PRACT_NAME, (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_REJ_BY_ID AND LANGUAGE_ID=?) REJECT_PRACT_NAME, (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_CAN_BY_ID AND LANGUAGE_ID=?) CAN_PRACT_NAME, (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_ACK_BY_ID AND LANGUAGE_ID=?) ACK_PRACT_NAME,(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=NPBR.REQUEST_APRV_BY_ID AND LANGUAGE_ID=?) APR_PRACT_NAME  FROM PH_NPB_DRUG_REQUEST NPBR, OR_CONSENT_FORM_LANG_VW CON WHERE NPBR.REQUEST_FORM_ID= CON.CONSENT_FORM_ID  AND CON.CONSENT_TYPE='N' AND CON.EFF_STATUS='E' AND CON.LANGUAGE_ID=? AND NPBR.PATIENT_ID=? AND NPBR.REQUEST_ENCOUNTER_ID=? AND NPBR.REQUEST_FACILITY_ID=?";
			if( !reqFromDate.equals("") && !reqToDate.equals("")){
				tmpsqlstr.append(" AND NPBR.REQUEST_DATE_TIME between to_date('"+reqFromDate+"'||'00:00', 'DD/MM/YYYY HH24:MI') AND  to_date('"+reqToDate+"'||'23:59', 'DD/MM/YYYY HH24:MI') ");
			}
			else{
				if(!reqFromDate.equals(""))
					tmpsqlstr.append(" AND NPBR.REQUEST_DATE_TIME > to_date('"+reqFromDate+"'||'00:00', 'DD/MM/YYYY HH24:MI') ");
				else if(!reqFromDate.equals(""))
					tmpsqlstr.append(" AND NPBR.REQUEST_DATE_TIME < to_date('"+reqToDate+"'||'23:59', 'DD/MM/YYYY HH24:MI') ");
			}
			if(!drugCode.equals(""))
				tmpsqlstr.append( " AND NPBR.REQUEST_DRUG_CODE='"+drugCode+"' ");
			else if (!drugName.equals(""))
				tmpsqlstr.append(" AND upper( NPBR.REQUEST_DRUG_NAME) like upper('"+drugName+"%') ");
			
			if(!NPBReqFormId.equals(""))
				tmpsqlstr.append(" AND NPBR.REQUEST_FORM_ID='"+NPBReqFormId+"' ");
			if(!reqStatus.equals("AL"))
				tmpsqlstr.append(" AND NPBR.REQUEST_STATUS ='"+reqStatus+"' " );
			sqlstr = sqlstr+ tmpsqlstr.toString();
			pstmt		= connection.prepareStatement( sqlstr ) ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12A") ) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			pstmt.setString(7,patient_id);
			pstmt.setString(8,encounter_id);		
			pstmt.setString(9,login_facility_id);
			resultSet	= pstmt.executeQuery();

			while ( resultSet != null && resultSet.next() ) {
				NPBRequestDtl = new HashMap();
				NPBRequestDtl.put("REQUEST_NO",resultSet.getString("REQUEST_NO"));
				NPBRequestDtl.put("REQUEST_FACILITY_ID",checkForNull(resultSet.getString("REQUEST_FACILITY_ID")));
				NPBRequestDtl.put("REQUEST_PRACT_ID",checkForNull(resultSet.getString("REQUEST_PRACT_ID")));
				NPBRequestDtl.put("REQUEST_DATE_TIME",checkForNull(resultSet.getString("REQUEST_DATE_TIME")));
				NPBRequestDtl.put("REQUEST_STATUS",checkForNull(resultSet.getString("REQUEST_STATUS")));
				NPBRequestDtl.put("REQUEST_DRUG_CODE",checkForNull(resultSet.getString("REQUEST_DRUG_CODE")));
				NPBRequestDtl.put("REQUEST_DRUG_NAME",checkForNull(resultSet.getString("REQUEST_DRUG_NAME")));
				NPBRequestDtl.put("REQUEST_FORM_ID",checkForNull(resultSet.getString("REQUEST_FORM_ID")));
				NPBRequestDtl.put("REQUEST_FORM_CONTENT",checkForNull(resultSet.getString("REQUEST_FORM_CONTENT")));
				NPBRequestDtl.put("REQUEST_CAN_DATE_TIME",checkForNull(resultSet.getString("REQUEST_CAN_DATE_TIME")));
				NPBRequestDtl.put("REQUEST_CAN_BY_ID",checkForNull(resultSet.getString("REQUEST_CAN_BY_ID")));
				NPBRequestDtl.put("REQUEST_CAN_REASON",checkForNull(resultSet.getString("REQUEST_CAN_REASON")));
				NPBRequestDtl.put("REQUEST_ACK_DATE_TIME",checkForNull(resultSet.getString("REQUEST_ACK_DATE_TIME")));
				NPBRequestDtl.put("REQUEST_ACK_REASON",checkForNull(resultSet.getString("REQUEST_ACK_REASON")));
				NPBRequestDtl.put("REQUEST_ACK_BY_ID",checkForNull(resultSet.getString("REQUEST_ACK_BY_ID")));
				NPBRequestDtl.put("REQUEST_REJ_DATE_TIME",checkForNull(resultSet.getString("REQUEST_REJ_DATE_TIME")));
				NPBRequestDtl.put("REQUEST_REJ_BY_ID",checkForNull(resultSet.getString("REQUEST_REJ_BY_ID")));
				NPBRequestDtl.put("REQUEST_REJ_REASON",checkForNull(resultSet.getString("REQUEST_REJ_REASON")));
				NPBRequestDtl.put("REQUEST_APRV_DATE_TIME",checkForNull(resultSet.getString("REQUEST_APRV_DATE_TIME")));
				NPBRequestDtl.put("REQUEST_APRV_BY_ID",checkForNull(resultSet.getString("REQUEST_APRV_BY_ID")));
				NPBRequestDtl.put("REQUEST_APRV_REASON",checkForNull(resultSet.getString("REQUEST_APRV_REASON")));
				NPBRequestDtl.put("REQUEST_QUANTITY",checkForNull(resultSet.getString("REQUEST_QUANTITY")));
				NPBRequestDtl.put("REQUEST_QTY_UOM_CODE",checkForNull(resultSet.getString("REQUEST_QTY_UOM_CODE")));
				NPBRequestDtl.put("REQUEST_FORM_NAME",checkForNull(resultSet.getString("consent_form_label")));
				NPBRequestDtl.put("REQUEST_PRACT_NAME",checkForNull(resultSet.getString("REQUEST_PRACT_NAME")));
				NPBRequestDtl.put("REJECT_PRACT_NAME",checkForNull(resultSet.getString("REJECT_PRACT_NAME")));
				NPBRequestDtl.put("CAN_PRACT_NAME",checkForNull(resultSet.getString("CAN_PRACT_NAME")));
				NPBRequestDtl.put("ACK_PRACT_NAME",checkForNull(resultSet.getString("ACK_PRACT_NAME")));
				NPBRequestDtl.put("APR_PRACT_NAME",checkForNull(resultSet.getString("APR_PRACT_NAME")));
				NPBRequestFormDtl.put(resultSet.getString("REQUEST_NO"),resultSet.getString("REQUEST_FORM_CONTENT"));
				NPBRequestList.add(NPBRequestDtl);
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
		setNPBRequestFormDetail(NPBRequestFormDtl);
		return NPBRequestList;
	}

	public String genOrderID() {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "",  NPBReqSeqNo="";
		StringBuffer NPBReqNo=new StringBuffer(login_facility_id);
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_SELECT_NPB_REQUEST_NO");
			pstmt				= connection.prepareStatement(sql_query) ;
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				NPBReqSeqNo = resultSet.getString("PH_NPB_REQ_NO");
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){}
		}
		int seqNoLength = NPBReqSeqNo.length();

		for(int i=1; i<(13-seqNoLength); i++){
			NPBReqNo.append("0");
		}
		NPBReqNo.append(NPBReqSeqNo);
		return NPBReqNo.toString();
	}

	public HashMap insert() {
		locale= getLanguageId()==null?"en":getLanguageId();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		String tmpNBPFormID= "";
		Hashtable NPBRequestDetail =  this.NPBRequestDetail;
		//HashMap orderDetails = null;  Removed for IN063877
		ArrayList mandatory_flds	=	new ArrayList();
		String str_date = "";
		String validity_period ="", validity_desc="", str_sql="";
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);

		HashMap tabData	= new HashMap() ;
		HashMap sqlMap		= new HashMap() ;
		try {
			str_sql =  "INSERT INTO PH_NPB_DRUG_REQUEST (REQUEST_NO ,PATIENT_ID ,REQUEST_FACILITY_ID ,REQUEST_ENCOUNTER_ID ,REQUEST_SOURCE_TYPE ,REQUEST_SOURCE_CODE ,REQUEST_PRACT_ID ,REQUEST_DATE_TIME ,REQUEST_STATUS ,REQUEST_DRUG_CODE ,REQUEST_DRUG_NAME ,REQUEST_FORM_ID ,REQUEST_FORM_CONTENT , DRUG_VALIDITY ,DRUG_VALIDITY_UNIT ,DRUG_VALIDITY_DATE ,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID ,MODIFIED_BY_ID ,MODIFIED_DATE ,MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID ,REQUEST_QUANTITY ,REQUEST_QTY_UOM_CODE ) VALUES (?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,empty_clob(),?,?,"; 
			tabData.put("properties", getProperties() );
			if(!locale.equals("en")){
				str_date = (String)NPBRequestDetail.get("reqDate")==null?"":(String)NPBRequestDetail.get("reqDate");
				if(!str_date.equals(""))
					NPBRequestDetail.put("reqDate", com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en"));
			}
			tmpNBPFormID = (String)NPBRequestDetail.get("NPBForm");
			if(!tmpNBPFormID.equals(getNPBReqFormId())){
				String pat_id = (String)NPBRequestDetail.get("patient_id");
				String encounter_id = (String)NPBRequestDetail.get("encounter_id");
				NPBRequestDetail.put("NPBFormText", getConsentDetail(tmpNBPFormID,login_facility_id, pat_id,encounter_id ));
			}
			else
				NPBRequestDetail.put("NPBFormText",getNPBReqFormText());
			validity_period = NPBRequestDetail.get("validity")==null?"":(String)NPBRequestDetail.get("validity");
			if(validity_period!=null && !validity_period.equals("")){
				validity_desc = NPBRequestDetail.get("ValidityDesc")==null?"D":(String)NPBRequestDetail.get("ValidityDesc");
				if(validity_desc.equals("D"))
					str_sql += "trunc(TO_DATE(?,'DD/MM/YYYY HH24:MI') + ?) ";
				else if(validity_desc.equals("W"))
					str_sql += "trunc(TO_DATE(?,'DD/MM/YYYY HH24:MI') + (7 * ?) ) ";
				else if(validity_desc.equals("M"))
					str_sql += "trunc(add_months(TO_DATE(?,'DD/MM/YYYY HH24:MI'), ?) )";
				else if(validity_desc.equals("Y"))
					str_sql += "trunc(add_months(TO_DATE(?,'DD/MM/YYYY HH24:MI') ,(12 * ?)))";
			}
			else
				str_sql += "? ";
			str_sql += ",?,sysdate,?,?,?,sysdate,?,?,?,?)";
			NPBRequestDetail.put("RequestNo",genOrderID());
			tabData.put("NPBRequestDetail", NPBRequestDetail );
			tabData.put("mandatory_flds",mandatory_flds);
			tabData.put("language_id",locale);
			 
			sqlMap.put("SQL_PH_NPBREQUEST_INSERT" , str_sql);
			sqlMap.put("SQL_PH_NPBREQUEST_UPDATE_CONTENT_CLOB" , "SELECT REQUEST_FORM_CONTENT FROM PH_NPB_DRUG_REQUEST WHERE REQUEST_NO=(?) ");
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
			HashMap result = localInsert( tabData, sqlMap ) ;
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

	private HashMap localInsert( HashMap tabData , HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "" ) ;
		Connection connection					= null ;
		PreparedStatement pstmt_insert	= null ;
		PreparedStatement pstmt_clob	= null ;
		java.io.BufferedWriter	bw	= null;
		int indxCount=1; //   count=0,  Removed for IN063877
		ResultSet resultSet = null ;
		ResultSet resultSetClob = null ;
		Hashtable NPBRequestDetail = (Hashtable) tabData.get("NPBRequestDetail");
		String validity_period =NPBRequestDetail.get("validity")==null?"":(String) NPBRequestDetail.get("validity");
		String RequestNo =NPBRequestDetail.get("RequestNo")==null?"":(String) NPBRequestDetail.get("RequestNo");
		String NPBFormText =NPBRequestDetail.get("NPBFormText")==null?"":(String) NPBRequestDetail.get("NPBFormText");

		try {
			connection	= getConnection() ;
			pstmt_insert=connection.prepareStatement((String) sqlMap.get( "SQL_PH_NPBREQUEST_INSERT"));

			pstmt_insert.setString(indxCount++, (String)NPBRequestDetail.get("RequestNo"));
			pstmt_insert.setString(indxCount++, (String)NPBRequestDetail.get("patient_id"));
			pstmt_insert.setString(indxCount++, login_facility_id);
			pstmt_insert.setString(indxCount++, (String)NPBRequestDetail.get("encounter_id"));
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("location_type"));
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("location_code"));
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("pract_id"));
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("reqDate"));
			pstmt_insert.setString(indxCount++,"R");
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("DrugCode"));
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("DrugName"));
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("NPBForm"));
			//pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("NPBFormText"));
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("validity"));
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("ValidityDesc"));
			if(validity_period!=null && !validity_period.equals("")){
				pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("reqDate"));
				pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("validity"));
			}
			else
				pstmt_insert.setString(indxCount++,"");
			pstmt_insert.setString(indxCount++,login_by_id);
			pstmt_insert.setString(indxCount++,login_at_ws_no);
			pstmt_insert.setString(indxCount++,login_facility_id);
			pstmt_insert.setString(indxCount++,login_by_id);
			pstmt_insert.setString(indxCount++,login_at_ws_no);
			pstmt_insert.setString(indxCount++,login_facility_id);
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("reqQty"));
			pstmt_insert.setString(indxCount++,(String)NPBRequestDetail.get("qty_desc"));
			int result = pstmt_insert.executeUpdate() ;
			if ( result<1 ) {
				connection.rollback();
				map.put( "message", getMessage(getLanguageId(),"EXCEPTION_OCCURED_WHILE_INSERTION","PH")+" : "+(String)map.get("flag") ) ;
			}
			else {
				pstmt_clob = connection.prepareStatement( (String)sqlMap.get("SQL_PH_NPBREQUEST_UPDATE_CONTENT_CLOB") ) ;
				pstmt_clob.setString( 1, RequestNo) ;
				resultSetClob = pstmt_clob.executeQuery() ;
				while ( resultSetClob != null && resultSetClob.next() ) {
					Clob clb = (Clob)resultSetClob.getClob("REQUEST_FORM_CONTENT");
					bw   = new BufferedWriter(clb.setCharacterStream(0));
					bw.write(NPBFormText,0,NPBFormText.length());
					bw.flush();
					bw.close();
				}
				closeResultSet( resultSetClob ) ;
				closeStatement(pstmt_clob);

				map.put( "result", new Boolean( true ) ) ;
				map.put("msgid","RECORD_INSERTED" ) ;
				map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
				connection.commit();
			}
		}//end of try
	
		catch( Exception e ) {
			map.put( "msgid", getMessage(getLanguageId(),"EXCEPTION_OCCURED_WHILE_INSERTION","PH") ) ;
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeResultSet(resultSetClob);
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_clob ) ;
				closeConnection( connection );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}

	public HashMap modify() {
		locale= getLanguageId()==null?"en":getLanguageId();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		String  changedYN, changedTXT; // tmpNBPFormID= "",  Removed for IN063877
		Hashtable NPBRequestDetail =  this.NPBRequestDetail;
		ArrayList NPBDtlList	=	new ArrayList();
		HashMap modifyNPBDtl = new HashMap();
		HashMap NPBDtl = null;

		HashMap tabData	= new HashMap() ;
		HashMap sqlMap		= new HashMap() ;
		try {
			int totRec = Integer.parseInt((String)NPBRequestDetail.get("totalRec")==null?"1":(String)NPBRequestDetail.get("totalRec"));
			for (int i=0; i<totRec ;i++ ){
				changedYN = (String)NPBRequestDetail.get("changed_"+i)==null?"":(String)NPBRequestDetail.get("changed_"+i);
				changedTXT = (String)NPBRequestDetail.get("formTXTchanged_"+i)==null?"":(String)NPBRequestDetail.get("formTXTchanged_"+i);
				if(changedYN.equals("Y") ||(changedTXT.equals("Y"))){
					NPBDtl = new HashMap();
					NPBDtl.put("REQUEST_NO",(String)NPBRequestDetail.get("request_no_"+i));
					NPBDtl.put("CHANGED",changedYN);
					NPBDtl.put("FORMTXTCHANGED",changedTXT);
					NPBDtl.put("CANCELCHK",(String)NPBRequestDetail.get("cancelchk_"+i));
					NPBDtl.put("CANCELREASON",(String)NPBRequestDetail.get("cancelReason_"+i));
					NPBDtl.put("REQUEST_FORM_CONTENT",getNPBRequestFormText((String)NPBRequestDetail.get("request_no_"+i)));
					NPBDtlList.add(NPBDtl);
				}
			}
			modifyNPBDtl.put("NPBDtlList",NPBDtlList);
			modifyNPBDtl.put("login_by_id",login_by_id);
			modifyNPBDtl.put("login_at_ws_no",login_at_ws_no);
			modifyNPBDtl.put("login_facility_id",login_facility_id);
			modifyNPBDtl.put("locale",locale);
			tabData.put("properties", getProperties() );
			tabData.put("NPBRequestDetail", modifyNPBDtl );
			tabData.put("language_id",locale);
		 
			sqlMap.put( "SQL_PH_NPBREQUEST_AMEND_CANCEL_UPDATE", "UPDATE PH_NPB_DRUG_REQUEST SET REQUEST_STATUS =?, REQUEST_CAN_DATE_TIME=decode(?,'C', sysdate,null), REQUEST_CAN_BY_ID =? ,REQUEST_CAN_REASON= nvl(?,REQUEST_CAN_REASON), REQUEST_AMEND_DATE_TIME=decode(?,'Y', sysdate, REQUEST_AMEND_DATE_TIME) ,REQUEST_AMEND_BY_ID =decode(?,'Y',?,REQUEST_AMEND_BY_ID),MODIFIED_BY_ID=? ,MODIFIED_DATE=sysdate ,MODIFIED_AT_WS_NO =?,MODIFIED_FACILITY_ID=? WHERE REQUEST_NO=?");
			sqlMap.put("SQL_PH_NPBREQUEST_UPDATE_CONTENT_CLOB" , "SELECT REQUEST_FORM_CONTENT FROM PH_NPB_DRUG_REQUEST WHERE REQUEST_NO=(?) ");
			 
			/*Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_NPBREQUEST" ),NPBRequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);*/

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
		PreparedStatement pstmt_update_clob	= null ;
		java.io.BufferedWriter	bw	= null;
		int  indxCount=1; // count=0, Removed for IN063877
		ResultSet resultSet = null ;
		ResultSet resultSetClob = null ;
		HashMap modifyNPBDtl = (HashMap) tabData.get("NPBRequestDetail");
		ArrayList NPBDtlList	=	null;
		HashMap NPBDtl = null;
		String changedYN="", changedTXT="", request_no="", request_form_content="";
		try {
			connection	= getConnection() ;
			NPBDtlList = (ArrayList)modifyNPBDtl.get("NPBDtlList");
			pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQL_PH_NPBREQUEST_AMEND_CANCEL_UPDATE"));
			for(int i=0;i<NPBDtlList.size();i++){
				indxCount = 1;
				NPBDtl = (HashMap)NPBDtlList.get(i);
				changedYN = (String)NPBDtl.get("CHANGED")==null?"":(String)NPBDtl.get("CHANGED");
				changedTXT = (String)NPBDtl.get("FORMTXTCHANGED")==null?"":(String)NPBDtl.get("FORMTXTCHANGED");
				request_no = (String)NPBDtl.get("REQUEST_NO")==null?"":(String)NPBDtl.get("REQUEST_NO");
				if(changedYN.equals("Y")){
					pstmt_update.setString(indxCount++, "C");
					pstmt_update.setString(indxCount++, "C");
					pstmt_update.setString(indxCount++, login_by_id);
					pstmt_update.setString(indxCount++, (String)NPBDtl.get("CANCELREASON"));
				}
				else{
					pstmt_update.setString(indxCount++, "R");
					pstmt_update.setString(indxCount++, "");
					pstmt_update.setString(indxCount++, "");
					pstmt_update.setString(indxCount++, "");
				}
				if(changedTXT.equals("Y")){
					//pstmt_update.setString(indxCount++,(String)NPBRequestDetail.get("REQUEST_FORM_CONTENT"));
					pstmt_update.setString(indxCount++,"Y");
					pstmt_update.setString(indxCount++, "Y");
					pstmt_update.setString(indxCount++, login_by_id);
				}
				else{
					//pstmt_update.setString(indxCount++,"");
					pstmt_update.setString(indxCount++, "");
					pstmt_update.setString(indxCount++, "");
					pstmt_update.setString(indxCount++, "");
				}
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
				pstmt_update_clob = connection.prepareStatement( (String)sqlMap.get("SQL_PH_NPBREQUEST_UPDATE_CONTENT_CLOB") ) ;
				for(int i=0;i<NPBDtlList.size();i++){
					NPBDtl = (HashMap)NPBDtlList.get(i);
					changedTXT = (String)NPBDtl.get("FORMTXTCHANGED")==null?"":(String)NPBDtl.get("FORMTXTCHANGED");
					request_no = (String)NPBDtl.get("REQUEST_NO")==null?"":(String)NPBDtl.get("REQUEST_NO");
					if(changedTXT.equals("Y")){
						request_form_content = (String)NPBDtl.get("REQUEST_FORM_CONTENT")==null?"":(String)NPBDtl.get("REQUEST_FORM_CONTENT");
						pstmt_update_clob.setString( 1, request_no) ;
						resultSetClob = pstmt_update_clob.executeQuery() ;
						while ( resultSetClob != null && resultSetClob.next() ) {
							CLOB clb = (CLOB)resultSetClob.getClob("REQUEST_FORM_CONTENT");
							bw   = new BufferedWriter(clb.getCharacterOutputStream());
							bw.write(request_form_content,0,request_form_content.length());
							bw.flush();
							bw.close();
						}
						closeResultSet( resultSetClob ) ;
					}
				}
				closeStatement(pstmt_update_clob);

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
				closeResultSet(resultSetClob);
				closeResultSet(resultSet);
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_update_clob ) ;
				closeConnection( connection );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}
}
