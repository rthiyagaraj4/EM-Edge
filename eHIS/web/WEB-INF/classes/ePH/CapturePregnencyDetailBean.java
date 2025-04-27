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
import javax.servlet.* ;
import javax.servlet.http.*;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class CapturePregnencyDetailBean extends PhAdapter implements Serializable {

	protected String lmp_date		="";
	protected String exp_preg_date		="";
	protected String act_preg_date	="";
	protected String preg_remarks	="";
	protected String preg_status			="";
	protected String pregnency_yn	="";
	protected String locale		="";
	protected String pract_id		    = "";
	protected String patient_id		    = "";
	protected String encounter_id		    = "";
	protected String srl_no		    = "";
	protected String curr_date				= "";
	protected HashMap hmPregRemarks = null;

	public String getLoggedInFacility(){
		return login_facility_id;
	}
	public void setCurrDate(String curr_date)	{
		this.curr_date	=	curr_date;
	}

	public String getCurrDate()	{
		return this.curr_date;
	}

	public String getPregRemarks(String key)	{
		if(this.hmPregRemarks != null && this.hmPregRemarks.containsKey(key) )
			return (String)this.hmPregRemarks.get(key);
		else 
			return null;
	}

	public String getPatientIDLength(){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
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
		return pat_txt_length;	
	}

	public String getDefaultEncounterId(String patient_id){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	default_encounter_id	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RETMEDICATION_CURRENT_ENCOUNTER_SELECT") ) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, patient_id);
			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				default_encounter_id	=	checkForNull(resultSet.getString("ENCOUNTER_ID"));
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
		return default_encounter_id;	
	}

		public ArrayList getEncounterIdDetails( String patient_id){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		ArrayList EncounterIdList = new ArrayList();
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_ENCOUNTER_LIST"));
			pstmt.setString(1, patient_id);
			pstmt.setString(2, login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				while(resultSet.next()){
					EncounterIdList.add(resultSet.getString("ENCOUNTER_ID"));
				}
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
		return EncounterIdList;
	}

	public ArrayList getLocationForEID( String encounter_id){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		ArrayList LocationList = new ArrayList();
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_LOCN_DTL"));
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, getLanguageId());
			pstmt.setString(3, login_facility_id);
			pstmt.setString(4, getLanguageId());
			pstmt.setString(5, getLanguageId());
			pstmt.setString(6, getLanguageId());
			pstmt.setString(7, login_facility_id);
			pstmt.setString(8, encounter_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				while(resultSet.next()){
					LocationList.add(resultSet.getString("CURRENT_LOCATION"));
					LocationList.add(resultSet.getString("ASSIGN_CARE_LOCN_CODE"));
					LocationList.add(resultSet.getString("attending_practitioner"));
					LocationList.add(resultSet.getString("admission_date"));
				}
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
		return LocationList;
	}

	public ArrayList getPatientDetails(String id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String localee=getLanguageId()==null?"en":getLanguageId();
		ArrayList	records		=	new ArrayList();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_PATIENT_DTL")) ; 
			pstmt.setString(1,localee);
			pstmt.setString(2,id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("PATIENT_NAME"));
				records.add(resultSet.getString("AGE"));
				records.add(resultSet.getString("GENDER"));
				records.add(checkForNull(resultSet.getString("date_of_birth")));
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
		return records;	
	}	
	public String getCalExpectedDeate(String lmp_date){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String exp_preg_date ="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_EDD")) ; 
			pstmt.setString(1,lmp_date);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				exp_preg_date=resultSet.getString("exp_preg_date");
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
		return exp_preg_date;	
	}	

	public void setAll( Hashtable recordSetMultiple ) {
		if(recordSetMultiple.containsKey("mode"))
				setMode((String)recordSetMultiple.get("mode")) ;
		if(recordSetMultiple.containsKey("lmp_date"))
			lmp_date = (String)recordSetMultiple.get("lmp_date") ;
		if(recordSetMultiple.containsKey("exp_date"))
			exp_preg_date = (String)recordSetMultiple.get("exp_date") ;
		if(recordSetMultiple.containsKey("act_del_date"))
			act_preg_date = (String)recordSetMultiple.get("act_del_date") ;
		if(recordSetMultiple.containsKey("preg_remarks"))
			preg_remarks = (String)recordSetMultiple.get("preg_remarks") ;
		if(recordSetMultiple.containsKey("pregnent_yn"))
			pregnency_yn = (String)recordSetMultiple.get("pregnent_yn") ;
		if(recordSetMultiple.containsKey("preg_status"))
			preg_status = (String)recordSetMultiple.get("preg_status") ;
		if(recordSetMultiple.containsKey("practitioner_id"))
			pract_id = (String)recordSetMultiple.get("practitioner_id") ;
		if(recordSetMultiple.containsKey("patient_id"))
			patient_id = (String)recordSetMultiple.get("patient_id") ;
		if(recordSetMultiple.containsKey("encounter_id"))
			encounter_id = (String)recordSetMultiple.get("encounter_id") ;
		if(recordSetMultiple.containsKey("srl_no"))
			srl_no = (String)recordSetMultiple.get("srl_no") ;
	}

	public HashMap insert() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "Insert UNDER CONSTRUCTION" ) ;
	//	ArrayList insertData = new ArrayList() ;    Removed for IN063877
	//	ArrayList whereData = new ArrayList() ;     Removed for IN063877
		Connection connection	= null ;
	    PreparedStatement pstmt		= null ;
		ResultSet resultSet		= null ; 

		HashMap sqlMap = new HashMap() ; 
		HashMap tabData = new HashMap() ;
		try{
			ArrayList insertRow = new ArrayList() ;
			//ArrayList whereRow = new ArrayList() ;  Removed for IN063877

			connection		= getConnection() ;
			connection.setAutoCommit(false);
			String srl_no="";		
			String str_qry	=PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_SELECT2");
			
			pstmt			= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,patient_id);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				srl_no=resultSet.getString("NEXT_SRL_NO");
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);

			if(pregnency_yn==null || pregnency_yn=="")
				pregnency_yn="N";
			if(exp_preg_date==null || exp_preg_date=="")
				exp_preg_date="";
			if(lmp_date==null || lmp_date=="")
				lmp_date="";

			insertRow.add(patient_id);
			insertRow.add(login_facility_id ) ;
			insertRow.add(encounter_id);
			insertRow.add(srl_no);
			insertRow.add(pregnency_yn);
			insertRow.add(com.ehis.util.DateUtils.convertDate(lmp_date, "DMY",getLanguageId(),"en"));//date convertion added for 40685
			insertRow.add(com.ehis.util.DateUtils.convertDate(exp_preg_date, "DMY",getLanguageId(),"en"));	//date convertion added for 40685		
			insertRow.add(com.ehis.util.DateUtils.convertDate(act_preg_date, "DMY",getLanguageId(),"en"));//date convertion added for 40685
			insertRow.add("");
			insertRow.add("");
			insertRow.add(pract_id);
			insertRow.add(preg_status);
			insertRow.add(preg_remarks);
			insertRow.add(login_by_id ) ;
			insertRow.add(login_at_ws_no ) ;
			insertRow.add(login_facility_id ) ;
			insertRow.add( login_by_id ) ;
			insertRow.add( login_at_ws_no ) ;
			insertRow.add( login_facility_id ) ;

			//insertData.add( insertRow ) ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertRow);
			sqlMap.put( "InsertSQL",PhRepository.getPhKeyValue( "SQL_PH_CA_PATIENT_PREGN_DTLS_INSERT" ));

			try {
				Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;
				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				else{
					if( ((String)map.get( "msgid" )).equals("CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					else
						map.put( "message", (map.get("msgid"))) ;
				}
			}
			catch(Exception e) {
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
		}
		catch(Exception e){
			System.err.println( "Error Calling EJB tabData: "+tabData ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
		finally{
			try{
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}		
		}
		return map ;
	}

	public HashMap modify() {
		
		StringBuffer debug = new StringBuffer();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "Insert UNDER CONSTRUCTION" ) ;
		ArrayList ModifyData = new ArrayList() ;
			HashMap tabData = new HashMap() ;
		try {
			if(pregnency_yn==null || pregnency_yn=="")
				pregnency_yn="N";
			if(exp_preg_date==null || exp_preg_date=="")
				exp_preg_date="";
			if(lmp_date==null || lmp_date=="")
				lmp_date="";

			ModifyData.add(pregnency_yn);
			ModifyData.add(com.ehis.util.DateUtils.convertDate(lmp_date, "DMY",getLanguageId(),"en"));//date convertion added for 40685
			ModifyData.add(com.ehis.util.DateUtils.convertDate(exp_preg_date, "DMY",getLanguageId(),"en"));	//date convertion added for 40685		
			ModifyData.add(com.ehis.util.DateUtils.convertDate(act_preg_date, "DMY",getLanguageId(),"en"));//date convertion added for 40685
			ModifyData.add(pract_id);
			ModifyData.add(preg_status);
			ModifyData.add(preg_remarks);
			ModifyData.add(login_by_id ) ;
			ModifyData.add(login_at_ws_no ) ;
			ModifyData.add(login_facility_id ) ;
			ModifyData.add(patient_id);
			ModifyData.add(login_facility_id ) ;
			ModifyData.add(srl_no);
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",ModifyData);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "ModifySQL",PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_UPDATE" ));
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag","0");
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH")) ;
				map.put( "flag","0");
			}
		}
		catch(Exception e) {
			System.err.println( "Error Calling EJB tabData: "+tabData ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag","0");
			e.printStackTrace() ;
		} 
		map.put("flag",debug.toString());
		return map ;	
	}


	public ArrayList getpregdetails(String patient_id,String encounter_id,String from,String to){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		String prevnextlink			= "";
		if(hmPregRemarks==null)
			hmPregRemarks = new HashMap();
		else
			hmPregRemarks.clear();
		int query_result_size		= 3;
		int start = 0 ;
		int end = 0 ;
		
		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
		long count=0;
		long i = 0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_SELECT")); 
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery(); 
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
				if(i <= end ) {
					records.add(resultSet.getString("PREGENANT_YN"));
					records.add(resultSet.getString("LMP_DATE"));
					records.add(resultSet.getString("EXPD_DELV_DATE"));
					records.add(resultSet.getString("ACTU_DELV_DATE"));
					records.add(resultSet.getString("PREGN_STATUS_IND"));
					records.add(resultSet.getString("PRACT_ID"));
					records.add(resultSet.getString("REMARKS"));
					records.add(resultSet.getString("SRL_NO"));
					hmPregRemarks.put(patient_id+"~"+resultSet.getString("SRL_NO"), resultSet.getString("REMARKS"));
				}
			}
			if( start != 1 )
				prevnextlink += "<td class='WHITE' align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 3 )
				prevnextlink += "<td class='WHITE' align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"')\">Next</a>" ;
			records.set(0,prevnextlink);
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
		return records;	
	}	

	public String getCalPregStage(String lmp_date){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String preg_week ="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_PREG_STAGE")) ; 
			pstmt.setString(1,lmp_date);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				preg_week=(resultSet.getString("preg_week").toString());
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
		return preg_week;	
	}
	public String getTrimster(String preg_week){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String trimster ="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_TRIMSTER")) ; 
			pstmt.setString(1,preg_week);
			pstmt.setString(2,preg_week);
			pstmt.setString(3,preg_week);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				trimster=(resultSet.getString("TRIMSTER"));
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
		return trimster;	
	}
	 public String getSysDate() {
		String to_day="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ADMN_DATE_SELECT5" )) ;
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					to_day= resultSet.getString( "today" );
				}
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

		return to_day;
	}

	public int getStatusCount(String patient_id){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		int count =0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_DTLS_STATUS_COUNT")) ; 
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				count=(resultSet.getInt("COUNT"));
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
		return count;	
	}

	public String getPractitionerName(String id,String locale) {
		String parct_name="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_CA_PATIENT_PREGN_DTLS_PRACT_SELECT" )) ;
			pstmt.setString(1,id);
			pstmt.setString(2,locale);
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					parct_name= resultSet.getString( "PRACTITIONER_NAME" );
				}
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

		return parct_name;
	}
	public ArrayList getFunctRollID(String login_by_id)throws Exception{
		ArrayList practDetails	=new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_CA_PRACT_SELECT") ) ;
			pstmt.setString(1,login_by_id);
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				practDetails.add(resultSet.getString("func_role_id") == null ? "":resultSet.getString("func_role_id"));
				practDetails.add(resultSet.getString("PRACTITIONER_NAME") == null ? "":resultSet.getString("PRACTITIONER_NAME"));
				
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
			 catch(Exception es) { 
				 es.printStackTrace();
			 }
		 }
		return practDetails;
	}
	public String getPregnencyDays(String lmp_date,String exp_preg_date){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String preg_days ="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CA_PATIENT_PREGN_NO_DAYE")) ; 
			pstmt.setString(1,exp_preg_date);
			pstmt.setString(2,lmp_date);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				preg_days=resultSet.getString("PREG_DAYS");
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
		return preg_days;	
	}	
}
