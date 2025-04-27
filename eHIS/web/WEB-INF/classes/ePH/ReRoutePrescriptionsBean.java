/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*  
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
24/02/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ 

//This file is saved on 04/06/2007 

package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class ReRoutePrescriptionsBean extends PhAdapter implements Serializable {

	protected ArrayList all_records = new ArrayList();
	protected HashMap record_status	= new HashMap();
	protected HashMap external_records=new HashMap();//Added for HSA-CRF-0155 [IN048487]
	protected Hashtable hashMultiple;

	String disp_locn			= "";
	String ws_st			= "";
	public ReRoutePrescriptionsBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {		
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
		
	}

	// setAll method to set all the values
	public void setAll(Hashtable recordSetMultiple){
		hashMultiple = recordSetMultiple ;
	} 
	public Hashtable getAllValues(){//Added Set and Get Methods for HSA-CRF-0155 [IN048487]-Start
		return hashMultiple;
	}
	public HashMap getExternalDetails() {
		return external_records;
	}
	public void setExternalDetails(HashMap external_records) {
		this.external_records = external_records;
	}//Added Set and Get Methods for HSA-CRF-0155 [IN048487]-End

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public ArrayList getPatientDetails(String id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
	
		ArrayList	records		=	new ArrayList();

		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT2") ) ;Commented for  RMMS ADHOC TESTING
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT8") ) ;//Added for  MMS ADHOC TESTING
			//pstmt.setString(1,id);Commented for  Retesting MMS
			pstmt.setString(1,getLanguageId());//Added for  Retesting MMS
			pstmt.setString(2,id);//Added for  Retesting MMS
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("PATIENT_NAME"));
				records.add(resultSet.getString("AGE"));
				records.add(resultSet.getString("SEX"));
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch(Exception e){
			records.add(e.toString()); e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}		
		}
		return records;	
	}

	public ArrayList getResult(String patient_id,String dt_from,String dt_to,String disp_locn,String OrderId,String locale){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList result =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			// query modified for IN22179 for restricting expired orders  --22/06/2010--
			//pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_ORDER_SELECT" )) ;
			String query ="SELECT distinct A.ORDER_ID, TO_CHAR(A.ORD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORDER_DATE, B.SHORT_DESC ORDER_STATUS_DESC, C.SHORT_DESC CURR_DISP_LOCN_DESC, A.TRN_GROUP_REF,A.ORDER_STATUS,(SELECT DECODE(NVL(COUNT(*),0),0,'N','Y') FROM OR_ORDER_LINE_PH D WHERE D.ORDER_ID = A.ORDER_ID AND D.NEXT_COLLECTION_DATE IS NOT NULL)  BMS_ORDER_YN FROM OR_ORDER A, OR_ORDER_STATUS_CODE_LANG_VW B, PH_DISP_LOCN_LANG_VW C, PH_PATIENT_DRUG_PROFILE D WHERE A.PATIENT_ID = ? AND A.PATIENT_ID =D.PATIENT_ID AND A.ORDER_ID =D.ORIG_ORDER_ID AND TRUNC (NVL (d.end_date, SYSDATE)) >= TRUNC (SYSDATE)AND A.ORDER_CATEGORY = 'PH'AND trunc(A.ORD_DATE_TIME) BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND A.PERFORMING_DEPTLOC_CODE = ?  AND A.ORDER_ID = NVL(?,A.ORDER_ID) AND A.ORDER_STATUS IN ('OS', 'DP', 'RG', 'VF', 'UC','DF','DC','CN','DD','DE') AND A.ORDER_STATUS = B.ORDER_STATUS_CODE AND B.LANGUAGE_ID = ? AND C.FACILITY_ID = A.PERFORMING_FACILITY_ID AND C.DISP_LOCN_CODE = A.PERFORMING_DEPTLOC_CODE  AND C.LANGUAGE_ID = ? AND ph_reroute_order_allow_yn(a.order_id) ='Y'  ORDER BY A.ORDER_ID"; //('OS', 'DP', 'RG', 'VF', 'UC','DF','DC','CN') & AND ph_reroute_order_allow_yn(a.order_id) ='Y' for ML-BRU-SCF-0398 [IN034931]
			// trunc @ trunc(A.ORD_DATE_TIME) added SRR20056-SCF-7725.1   28789 
			pstmt = connection.prepareStatement(query) ;
			 pstmt.setString(1,patient_id);
			 pstmt.setString(2,dt_from);
			 pstmt.setString(3,dt_to);
			 pstmt.setString(4,disp_locn);
			 pstmt.setString(5,OrderId);
			 pstmt.setString(6,locale);
			 pstmt.setString(7,locale);
			 resultSet   = pstmt.executeQuery() ;

			while (resultSet.next()){
				result.add(resultSet.getString("order_id"));
				result.add(resultSet.getString("order_date"));
				result.add(resultSet.getString("order_status_desc"));
				result.add(resultSet.getString("curr_disp_locn_desc"));
				result.add(resultSet.getString("order_status"));
				result.add(resultSet.getString("bms_order_yn"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return result;
	}

	public ArrayList getDispLocnList(String facility_id,String appl_user_id ,String locale){
		Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList DispLocnList =		new ArrayList();
		try {
			connection	 = getConnection() ;
			// QUERY MODIFIED (added order by) BY CHANDRASHEKAR A FOR THE INCIDENT NO SRR20056-SCF-7215 in PHRepository.java
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_DISP_LOCN_SELECT" )) ;
			//  pstmt			 = connection.prepareStatement("select a.disp_locn_code, a.short_desc  from ph_disp_locn_lang_vw a where a.facility_id =? and a.eff_status = 'E' and a.language_id =? and exists (select b.disp_locn_code from ph_disp_rights b where b.facility_id =? and b.appl_user_id =? and b.disp_locn_code = a.disp_locn_code  and b.reroute_order_yn ='Y')") ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,appl_user_id);
			resultSet   = pstmt.executeQuery() ;
			while (resultSet.next()) {
				DispLocnList.add(resultSet.getString("disp_locn_code"));
				DispLocnList.add(resultSet.getString("short_desc"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return DispLocnList;
	  }
	public ArrayList getFacilityList(String facility_id,String locale){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList FacilityList =		new ArrayList();
		
		try {
		connection	 = getConnection() ;
         pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_SM_FACILITY_SELECT" )) ;
	      //pstmt			 = connection.prepareStatement("select facility_id, facility_name from sm_facility_param_lang_vw  where facility_id = ? and status = 'E' and language_id = ?") ;
			 pstmt.setString(1,facility_id);
			 pstmt.setString(2,locale);

			 resultSet   = pstmt.executeQuery() ;

			while (resultSet.next()) {
				
				FacilityList.add(resultSet.getString("facility_id"));
				FacilityList.add(resultSet.getString("facility_name"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return FacilityList;
	}
	
	public ArrayList getReasonList(String locale) {
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList ReasonList =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_MEDN_TRN_REASON_SELECT" )) ;
	         // pstmt			 = connection.prepareStatement("select REASON_CODE, REASON_DESC from ph_medn_trn_reason_lang_vw  where appl_trn_type = 'RR'  and eff_status = 'E' order by reason_desc") ;
			 pstmt.setString(1,locale);
			 resultSet   = pstmt.executeQuery() ;

			while (resultSet.next()) {
				
				ReasonList.add(resultSet.getString("REASON_CODE"));
				ReasonList.add(resultSet.getString("REASON_DESC"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return ReasonList;
	  }

	public ArrayList getPatientDetails1(String id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
	
		ArrayList	records		=	new ArrayList();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT2") ) ;
			pstmt.setString(1,id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("PATIENT_NAME"));
				records.add(resultSet.getString("AGE"));
				records.add(resultSet.getString("GENDER"));
			}
		}
		catch(Exception e){
			records.add(e.toString());
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
		return records;	
	}

	public HashMap insert() {

		Connection connection				= null ;
		CallableStatement cstmtReRoute	= null;
		HashMap map						= new HashMap() ;
		boolean break_loop_flag           = false; 
		String message="";
	
		ArrayList insertRow				= new ArrayList();
		int tot_rec=Integer.parseInt((String)hashMultiple.get("tot_record_count"));
		HashMap ext_record=getExternalDetails();//Added for HSA-CRF-0155 [IN048487]
		String disp_qty="";//Added for HSA-CRF-0155 [IN048487]
		try{
			connection	= getConnection();
			for(int i=1;i<=tot_rec;i++){//changed 8 to 9  for Bru-HIMS-CRF-090 [IN:029956]
				if (((String)hashMultiple.get("chk_"+ i)).trim().equals("Y")){
					insertRow.add( (String)hashMultiple.get(("facility_id_"+i) )) ; //0
					insertRow.add( (String)hashMultiple.get(("disp_locn_"+i) )) ;
					insertRow.add( (String)hashMultiple.get(("OrderId_" + i)) ) ;
					insertRow.add( (String)hashMultiple.get(("OrderStatus_" + i)) ) ;
					insertRow.add( (String)hashMultiple.get(("P_BMS_ORDER_YN_" + i)) ) ;
					insertRow.add( (String)hashMultiple.get(("rcode_" + i)) ) ; //5
					insertRow.add( (String)hashMultiple.get(("ReRouteDisp_Id_" + i)) ) ;
					insertRow.add( (String)hashMultiple.get(("dis_mend_" + i)) ) ;  //added  for Bru-HIMS-CRF-090 [IN:029956]
					insertRow.add( login_facility_id) ;  //added  for ML-BRU-SCF-1191 [IN:045649] //8
					insertRow.add( login_by_id ) ;  //added  for ML-BRU-SCF-1191 [IN:045649]
					insertRow.add( login_at_ws_no) ;  //added  for ML-BRU-SCF-1191 [IN:045649] //10
					insertRow.add( (String)hashMultiple.get(("prescription_type_"+i) )) ;//11 Added for HSA-CRF-0155 [IN048487]
					insertRow.add( (String)ext_record.get(("EXT_FACILITY"))) ;//12 Added for HSA-CRF-0155 [IN048487]
					insertRow.add( (String)ext_record.get(("NEXT_COLLECTION_DATE") )) ;//13 Added for HSA-CRF-0155 [IN048487]
					insertRow.add( (String)ext_record.get(("EXTBMSREASON") )) ;//14 Added for HSA-CRF-0155 [IN048487]
					insertRow.add( (String)ext_record.get(("REFERRAL_REMARKS") )) ;//15 Added for HSA-CRF-0155 [IN048487]
					insertRow.add( (String)ext_record.get(("PRACTIONER_ID") )) ;//16 Added for HSA-CRF-0155 [IN048487]
					disp_qty=getDispQty((String)hashMultiple.get(("OrderId_" + i)));
					insertRow.add( disp_qty);//17 Added for HSA-CRF-0155 [IN048487]
				}
			}
			//System.err.println("ReRoutePrescriptionsBean.java===323===insertRow===BSP-SCF-0057===>"+insertRow);
			if(insertRow.size()>0){
				cstmtReRoute = connection.prepareCall("{call ph_reroute_order(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//?,?,?,?,?,?,?,?,?,?,?,? to ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? for HSA-CRF-0155 [IN048487] 
				for(int j=0;j<insertRow.size();j+=18){ // changed 7 to 9  for Bru-HIMS-CRF-090 [IN:029956] And Increase the Size from 11 To 18 for HSA-CRF-0155 [IN048487]
					cstmtReRoute.setString(1,(String)insertRow.get(j));	
					cstmtReRoute.setString(2,(String)insertRow.get(j+1));	
					cstmtReRoute.setString(3,(String)insertRow.get(j+2));	
					cstmtReRoute.setString(4,(String)insertRow.get(j+3));	
					cstmtReRoute.setString(5,(String)insertRow.get(j+4));	
					cstmtReRoute.setString(6,(String)insertRow.get(j+5));	
					cstmtReRoute.setString(7,(String)insertRow.get(j+6));
					cstmtReRoute.setString(8,(String)insertRow.get(j+7)); //added  for Bru-HIMS-CRF-090 [IN:029956] 
					cstmtReRoute.registerOutParameter(9,Types.VARCHAR );
					cstmtReRoute.setString(10,(String)insertRow.get(j+8));	//added  for ML-BRU-SCF-1191 [IN:045649]
					cstmtReRoute.setString(11,(String)insertRow.get(j+9));//added  for ML-BRU-SCF-1191 [IN:045649]
					cstmtReRoute.setString(12,(String)insertRow.get(j+10)); //added  for ML-BRU-SCF-1191 [IN:045649]
					cstmtReRoute.setString(13,(String)insertRow.get(j+11));//Added for HSA-CRF-0155 [IN048487]
					cstmtReRoute.setString(14,(String)insertRow.get(j+12)); //Added for HSA-CRF-0155 [IN048487]
					cstmtReRoute.setString(15,(String)insertRow.get(j+13)); //Added for HSA-CRF-0155 [IN048487]
					cstmtReRoute.setString(16,(String)insertRow.get(j+14)); //Added for HSA-CRF-0155 [IN048487]
					cstmtReRoute.setString(17,(String)insertRow.get(j+15));//Added for HSA-CRF-0155 [IN048487] 
					cstmtReRoute.setString(18,(String)insertRow.get(j+16)); //Added for HSA-CRF-0155 [IN048487]
					cstmtReRoute.setString(19,(String)insertRow.get(j+17)); //Added for HSA-CRF-0155 [IN048487]

					cstmtReRoute.execute();
					message=cstmtReRoute.getString(9); //changed 8 to 9  for Bru-HIMS-CRF-090 [IN:029956]
					if(message!=null){				  
						break_loop_flag =false;
						break;
					}
					else{
						break_loop_flag=true;
					}
				} 
			}				
			
			if(!break_loop_flag){
				connection.rollback();					
				map.put("flag", "0");
				map.put("result", new Boolean( false) ) ;
				map.put("message", "Error During Insertion into OR_ORDER "+message);						   
			}
			else {
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;		
				map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
				map.put("flag","0");
			}				
		}
		catch(Exception e){
			e.printStackTrace();
			map.put("flag", "0");
			map.put("result", new Boolean( false) ) ;
			map.put("message","Error During Insertion into OR_ORDER");
			try{
			   connection.rollback();
			}
			catch( Exception es){
				es.printStackTrace();
			}
		}
		finally{
			try {
				closeStatement(cstmtReRoute);
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}	
		return map ;
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
				es.printStackTrace();} 
			}
			return pat_txt_length;	
	  }

	//the below method is  added  for Bru-HIMS-CRF-090 [IN:029956]
	public ArrayList getResultMultiFacility(String patient_id,String OrderId,String locale) {
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList result =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			// query modified for IN22179 for restricting expired orders  --22/06/2010--
			//pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_ORDER_SELECT" )) ;
			//String query ="SELECT distinct A.ORDER_ID, TO_CHAR(A.ORD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORDER_DATE, B.SHORT_DESC ORDER_STATUS_DESC, C.SHORT_DESC CURR_DISP_LOCN_DESC, A.TRN_GROUP_REF,A.ORDER_STATUS,(SELECT DECODE(NVL(COUNT(*),0),0,'N','Y') FROM OR_ORDER_LINE_PH D WHERE D.ORDER_ID = A.ORDER_ID AND D.NEXT_COLLECTION_DATE IS NOT NULL)  BMS_ORDER_YN,d.facility_id,A.PERFORMING_FACILITY_ID,c.disp_locn_code,A.DISCHARGE_IND,A.PATIENT_CLASS FROM OR_ORDER A, OR_ORDER_STATUS_CODE_LANG_VW B, PH_DISP_LOCN_LANG_VW C, PH_PATIENT_DRUG_PROFILE D WHERE A.PATIENT_ID = ? AND A.PATIENT_ID =D.PATIENT_ID AND A.ORDER_ID =D.ORIG_ORDER_ID AND TRUNC (NVL (d.end_date, SYSDATE)) >= TRUNC (SYSDATE)AND A.ORDER_CATEGORY = 'PH' AND  A.ORDER_ID = NVL(?,A.ORDER_ID) AND A.ORDER_STATUS IN ('OS', 'DP', 'RG', 'VF', 'UC','DF','DC','CN') AND A.ORDER_STATUS = B.ORDER_STATUS_CODE AND B.LANGUAGE_ID = ? AND C.FACILITY_ID = A.PERFORMING_FACILITY_ID AND C.DISP_LOCN_CODE = A.PERFORMING_DEPTLOC_CODE AND A.PATIENT_CLASS=D.PATIENT_CLASS AND C.LANGUAGE_ID = ? AND ph_reroute_order_allow_yn(a.order_id) ='Y'  ORDER BY A.ORDER_ID"; // Added ('OS', 'DP', 'RG', 'VF', 'UC','DF','DC','CN') & AND ph_reroute_order_allow_yn(a.order_id) ='Y' for ML-BRU-SCF-0398 [IN034931] & Query Changed for HSA-CRF-0155 [IN048487]
			// trunc @ trunc(A.ORD_DATE_TIME) added SRR20056-SCF-7725.1   28789 
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_RESULT_MULTI_FACILITY_SELECT")) ;//added for HSA-CRF-0155 [IN048487]
			pstmt.setString(1,locale);//moved feom 4th to 1st for HSA-CRF-0155 [IN048487]
			pstmt.setString(2,locale);//moved feom 4th to 1st for HSA-CRF-0155 [IN048487]
			pstmt.setString(3,patient_id);
			pstmt.setString(4,OrderId);
			pstmt.setString(5,locale);
			resultSet   = pstmt.executeQuery() ;
			while (resultSet.next()){
				result.add(resultSet.getString("order_id"));
				result.add(resultSet.getString("order_date"));
				result.add(checkForNull(resultSet.getString("order_status_desc")));
				result.add(checkForNull(resultSet.getString("curr_disp_locn_desc")));
				result.add(resultSet.getString("order_status"));
				result.add(resultSet.getString("bms_order_yn"));
				result.add(checkForNull(resultSet.getString("PERFORMING_FACILITY_ID")));
				result.add(checkForNull(resultSet.getString("performing_deptloc_code")));
				result.add(resultSet.getString("DISCHARGE_IND"));  //added  for Bru-HIMS-CRF-090 [IN:029956]
				result.add(resultSet.getString("patient_class")); //added for HSA-CRF-0155 [IN048487]
				result.add(checkForNull(resultSet.getString("REF_FACILITY"))); //added for HSA-CRF-0155 [IN048487]
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return result;
	}

	//the below method added  for Bru-HIMS-CRF-090 [IN:029956]
	public String getFacilityName(String facility_id,String locale){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		//ArrayList FacilityList =		new ArrayList();
		String facilityName			="";
	
		try {
			connection	 = getConnection() ;
			//pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_SM_FACILITY_SELECT" )) ;
			pstmt			 = connection.prepareStatement("select facility_name from sm_facility_param_lang_vw  where facility_id = ? and status = 'E' and language_id = ?") ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);

			resultSet   = pstmt.executeQuery() ;
			while (resultSet.next()) {
				facilityName= (String)resultSet.getString("facility_name");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return facilityName;
	}
	//the below method is added  for Bru-HIMS-CRF-090 [IN:029956]
	public ArrayList getMultiFacilityList(String user_id,String locale){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList FacilityList =		new ArrayList();

		try {
			connection	 = getConnection() ;
			//pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_SM_FACILITY_SELECT" )) ;
			// pstmt			 = connection.prepareStatement("SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = 'PH') ORDER BY 2") ;
			pstmt			 = connection.prepareStatement("SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE /*appl_user_id = ? AND  commented appl_user_id for [IN:33903]*/(TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = 'PH') ORDER BY 2") ;
			 
			pstmt.setString(1,locale);
			//pstmt.setString(2,user_id); //commented for [IN:33903]
			resultSet   = pstmt.executeQuery() ;
			while (resultSet.next()) {
				FacilityList.add(resultSet.getString("facility_id"));
				FacilityList.add(resultSet.getString("facility_name"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return FacilityList;
	}

	//the below method is added  for Bru-HIMS-CRF-090 [IN:029956]
	public String getPatientName(String patient_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String patient_name		= "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43")) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patient_id);
            resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				patient_name		=	resultSet.getString("PATIENT_NAME");	
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
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return patient_name;
	}
	//the below method is added  for Bru-HIMS-CRF-090 [IN:029956]
	public ArrayList getHtWt(String patient_id)	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList ht_wt			= new ArrayList();
		//String sql_str			=	null; //Commented for common-icn-0048
		try{
			connection			= getConnection() ;
			//	sql_str				= PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT70");
			pstmt				= connection.prepareStatement("SELECT HEIGHT,HEIGHT_UOM,WEIGHT,WEIGHT_UOM,PATIENT_CLASS,ENCOUNTER_ID FROM PH_PATIENT_DRUG_PROFILE WHERE PATIENT_ID=? AND SRL_NO=(SELECT MAX(SRL_NO) FROM PH_PATIENT_DRUG_PROFILE WHERE PATIENT_ID=?)") ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,patient_id);
			resultSet	= pstmt.executeQuery();

			if ( resultSet != null && resultSet.next() ) {
				ht_wt.add(checkForNull(resultSet.getString("HEIGHT")));
				ht_wt.add(checkForNull(resultSet.getString("HEIGHT_UOM")));
				ht_wt.add(checkForNull(resultSet.getString("WEIGHT")));
				ht_wt.add(checkForNull(resultSet.getString("WEIGHT_UOM")));
				ht_wt.add(checkForNull(resultSet.getString("PATIENT_CLASS"))); //newly added by manickam
				ht_wt.add(checkForNull(resultSet.getString("ENCOUNTER_ID"))); //newly added by manickam
			}
		}
		catch(Exception e){
			e.printStackTrace();
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
		return ht_wt;
	}

	//the below method is added  for Bru-HIMS-CRF-090 [IN:029956]
	public ArrayList getAgeSex(String patient_id)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList age_sex		= new ArrayList();
		try{
			connection			= getConnection() ;
			//sql_str				= PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT70");
			pstmt				= connection.prepareStatement("select GET_AGE(DATE_OF_BIRTH) AGE, SEX from mp_patient where patient_id=?") ;
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery();

			if ( resultSet != null && resultSet.next() ) {
				age_sex.add(checkForNull(resultSet.getString("AGE")));
				age_sex.add(checkForNull(resultSet.getString("SEX")));
			}
		}
		catch(Exception e){
			e.printStackTrace();
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
		return age_sex;
	}

	//the below method is added  for Bru-HIMS-CRF-090 [IN:029956]
	public String getPendngOrderCnt(String patient_id){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null;
		String pndng_order_cnt	= "";
		try {
			connection = getConnection() ;
		//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT156") ) ;
			pstmt = connection.prepareStatement("SELECT COUNT(*) POCNT FROM OR_ORDER A WHERE PATIENT_ID = ? AND ORDER_CATEGORY = 'PH' /*AND ORDER_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('00','03','05')) */ AND EXISTS (SELECT ORDER_ID FROM OR_ORDER_LINE WHERE ORDER_ID =A.ORDER_ID AND ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('00','03','05')) AND END_DATE_TIME >= SYSDATE)"); //OR_ORDER_STATUS_CODE part of SQL Commented for HSA-CRF-0136 [IN:048412]- [IN:049363]
			pstmt.setString(1,patient_id);
			//pstmt.setString(2,disp_locn);
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				pndng_order_cnt = resultSet.getString("POCNT") == null ? "":resultSet.getString("POCNT");
			}
		}
		 catch ( Exception e ) {
			e.printStackTrace() ;
		 }
		 finally {
			 try {
				 closeResultSet( resultSet ) ;
				 closeStatement( pstmt ) ;
				 closeConnection( connection );
			 }
			 catch(Exception es) { 
				 es.printStackTrace();
			}
		}
		return pndng_order_cnt;
	}
	// the below method is added  for Bru-HIMS-CRF-090 [IN:029956]
	public String getViewPatientHistoryYN(String user_id,String disp_locn_code,String facility_id){
	Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null;
		String viewPatientHisYN	= "N";
		int view_pat_hist_yn_count = 0; //Added for ML-BRU-SCF-1113 [IN:044717]
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT156") ) ;
			//pstmt = connection.prepareStatement("select VIEW_PAT_HIST_YN from PH_DISP_RIGHTS where facility_id=? and disp_locn_code=? and appl_user_id=?"); //Commented for ML-BRU-SCF-1113 [IN:044717]
			pstmt = connection.prepareStatement("select count (VIEW_PAT_HIST_YN) VIEW_PAT_HIST_YN from PH_DISP_RIGHTS where facility_id=? and disp_locn_code in ( "+disp_locn_code+" ) and appl_user_id=? and VIEW_PAT_HIST_YN='Y'");  //Added for ML-BRU-SCF-1113 [IN:044717]
			pstmt.setString(1,facility_id);
			//pstmt.setString(2,disp_locn_code);
			pstmt.setString(2,user_id);
			resultSet = pstmt.executeQuery() ;
			if( resultSet != null && resultSet.next() ) {
				view_pat_hist_yn_count = resultSet.getInt("VIEW_PAT_HIST_YN");
			}
		}
		 catch ( Exception e ) {
			e.printStackTrace() ;
		 }
		 finally {
			 try {
				 closeResultSet( resultSet ) ;
				 closeStatement( pstmt ) ;
				 closeConnection( connection );
			 }
			 catch(Exception es) { 
				 es.printStackTrace();
			}
		}
		if(view_pat_hist_yn_count>0) //added for ML-BRU-SCF-1113 [IN:044717]
			viewPatientHisYN="Y";
		return viewPatientHisYN;
	}

	//the below method is  added for Bru-HIMS-CRF-090 [IN:029956]
	public ArrayList getDispenseLocation(String user_id,String facility_id){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null;
		ArrayList disp_loc_codes	= new ArrayList();
		try {
			connection = getConnection() ;
		//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT156") ) ;
			//pstmt = connection.prepareStatement("select a.disp_locn_code DISP_LOCN_CODE,b.short_desc DISP_LOCN_DESC from PH_DISP_RIGHTS a,ph_disp_locn b where a.facility_id=b.facility_id and a.disp_locn_code=b.disp_locn_code and a.appl_user_id=? and a.facility_id=? ");

		//	pstmt.setString(1,user_id);
			//pstmt.setString(2,facility_id);
			pstmt = connection.prepareStatement("select disp_locn_code disp_locn_code, short_desc disp_locn_desc from ph_disp_locn_lang_vw where facility_id=? and language_id=? and EFF_STATUS='E' ");//Added and EFF_STATUS='E' for  ML-BRU-SCF-1034 by D.Srikanth
			pstmt.setString(1,facility_id);
			pstmt.setString(2,getLanguageId());
			
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				disp_loc_codes.add(checkForNull(resultSet.getString("DISP_LOCN_CODE")));
				disp_loc_codes.add(checkForNull(resultSet.getString("DISP_LOCN_DESC")));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return disp_loc_codes;
	}

	//added for Bru-HIMS-CRF-090 [IN:029956] 
	//getting HomeMecdicationYn
	public int getHomeMecdicationYn(String encounter_id,String facility_id){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		encounter_id = encounter_id.trim();
		int take_home_count    = 0;
		//		int	rec_count=0;
		try{
			connection = getConnection() ;
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT11");
			pstmt				= connection.prepareStatement(sql_query) ;

			if(encounter_id == "" || encounter_id == null ||encounter_id.equals("DUMMYENCOUNTERID"))
				encounter_id = "0";
			//double enc_id=Long.parseLong(encounter_id);
			pstmt.setString(1,encounter_id);
			pstmt.setString(2,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				take_home_count=resultSet.getInt(1);
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
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
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return take_home_count;
	}
	public ArrayList getOtherRefFacility() {//Added for HSA-CRF-0155 [IN048487]-Start 
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ; 
		ArrayList	ref_facility	=	new ArrayList() ;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_REF_FACILITY_SELECT"));
			pstmt.setString(1,getLanguageId());
			resultSet	        = pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
				ref_facility.add(resultSet.getString("referral_code"));
				ref_facility.add(resultSet.getString("short_desc"));
			}						
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return ref_facility;	
	}
 public ArrayList getBMSReasons(String locale){
		Connection connection		= null;
		PreparedStatement pstmt		= null;
		ResultSet rs		= null;
		//int cnt			= 0; //Commented for common-icn-0048
		ArrayList alBMSReasons = new ArrayList();
		if(locale == null || locale.equals(""))
			locale = getLanguageId();
		try {
			connection	= getConnection() ;

			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISPMEDN_BMS_REASONS_SELECT"));
			pstmt.setString(1,locale);			
			rs = pstmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					alBMSReasons.add(rs.getString("reason_code"));
					alBMSReasons.add(rs.getString("reason_desc"));
				}			
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( rs) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch( Exception e1){
				e1.printStackTrace() ;
			}
		}
		return alBMSReasons;
	}
	
	public String getFunctRollID(String login_by_id)throws Exception{
		String funct_role_id	="";
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT146") ) ;
			pstmt.setString(1,login_by_id);
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				funct_role_id=resultSet.getString("func_role_id") == null ? "":resultSet.getString("func_role_id");
				
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return funct_role_id;
	}

	public String getPractitionerName(String pract_id){
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;	
		String pact_name		= "";
	
		try {
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_PRACT_SELECT")) ;
			pstmt.setString(1,pract_id);
			pstmt.setString(2,language_id);
			resultSet	= pstmt.executeQuery() ;
			while (resultSet.next()){
				pact_name		=	resultSet.getString("PRACTITIONER_NAME");	
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
				}catch(Exception es){es.printStackTrace();}
		}
		return pact_name;
	}
	
	public String getTodaysDate(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		String today_date="";
		try{
			connection	= getConnection() ;
			pstmt		=connection.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') TODAY,TO_CHAR(SYSDATE,'DD/MM/YYYY hh24:mi') TODAY_DATE_TIME,TO_CHAR(SYSDATE+365,'DD/MM/YYYY') DATE_PLUS_365 , TO_CHAR(SYSDATE+30,'DD/MM/YYYY') DATE_PLUS_30, TO_CHAR(SYSDATE-30,'DD/MM/YYYY') DATE_minus_30 FROM DUAL");
			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				today_date			=	resultSet.getString("TODAY");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return today_date;
	}
	
	public String getDispQty(String order_id){
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;	
		String disp_qty		= "";
	
		try {
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DTL_DISP_QTY_SELECT")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				disp_qty		=	checkForNull(resultSet.getString("DISP_QTY"));
			}
			 if(disp_qty.equals(""))
				 disp_qty="0";
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
				}catch(Exception es){es.printStackTrace();}
		}
		return disp_qty;
	}
//Added for HSA-CRF-0155 [IN048487]-End
//Added for MOHE-CRF-0074		
	public ArrayList getRegionCheckExt(String region_code){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList result =		new ArrayList();

		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement("SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE /*appl_user_id = ? AND  commented appl_user_id for [IN:33903]*/(TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = 'PH') AND region_code= ? ORDER BY 2") ;
			pstmt.setString(1,language_id);
			pstmt.setString(2,region_code);
			resultSet   = pstmt.executeQuery() ;
			while (resultSet!=null && resultSet.next()) {
				result.add(resultSet.getString("FACILITY_ID")==null?"":resultSet.getString("FACILITY_ID"));
				result.add(resultSet.getString("FACILITY_NAME")==null?"":resultSet.getString("FACILITY_NAME"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return result;
	}
	//Added for MOHE-CRF-0074
}
