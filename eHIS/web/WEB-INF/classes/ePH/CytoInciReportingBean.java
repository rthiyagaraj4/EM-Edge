/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 02.11.2005
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class CytoInciReportingBean extends PhAdapter implements Serializable {

	java.util.Properties p=null;
	
	protected String SeqNo				= "";
	protected String DATE_OF_INCIDENT	= "";
	protected String LOCN_TYPE			= "";
	protected String LOCN_CODE			= "";
	protected String INCIDENT_REMARKS   = "";
	protected String CAUSE_OF_SPILAGE   = "";
	protected String OTHER_REMARKS		= "";
	protected String WITNESS_ID			= "";
	protected String DOSAGE_FORM		= "";
	protected String VOLUME				= "";
	protected String WEIGHT				= "";
	protected String WEIGHT_UOM			= "";
	protected String DATE_RET_PHARMACY	= "";
	protected String DATE_REPLACED		= "";
	protected String REPORTED_BY_ID		= "";
	protected String REPORTED_REMARKS	= "";
	protected String CHECKED_BY_ID		= "";
	protected String DATE_OF_CHECK_REPO = "";
	protected String EFF_STATUS			= "";
	private Hashtable InsertDtl			= new Hashtable();

	public CytoInciReportingBean() {
		try {
			doCommon();
		}
		catch(Exception e) {}
	}

	/* Over-ridden Adapter methods start here */
	public void clear() {
		super.clear() ;
	}

	private void doCommon() throws Exception {
	}

	/* Over-ridden Adapter methods end here */

	public void setSeqNo(String SeqNo){
		this.SeqNo = SeqNo;
	}

	public String getLoggedInFacility()  {
		return login_facility_id;
	}
	public String getSeqNo()  {
		return SeqNo;
	}
	
	
	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	public String getSysdate(){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sys_date				= "";
		String sys_date_with_out_time="";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date=resultSet.getString(1);
				sys_date_with_out_time	= resultSet.getString("SYS_DATE");
				
			}
		
		}catch ( Exception e ) {
			sys_date+=e.toString();
			System.err.println( "Error sys_date  :"+e ) ;
			e.printStackTrace() ;
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){}
		}
		return sys_date;
	}

	// setAll method to set all the values
	public void setAll(Hashtable recordSet)
	{	
		InsertDtl=recordSet;
        if(!getLanguageId().equals("en")){
			String locale =getLanguageId();
           if((String)InsertDtl.get("inc_date")!=null){
			     InsertDtl.put("inc_date",com.ehis.util.DateUtils.convertDate((String)InsertDtl.get("inc_date"),"DMYHM",locale,"en"));
			}
			
			if((String)InsertDtl.get("return_dt")!=null){
			     InsertDtl.put("return_dt",com.ehis.util.DateUtils.convertDate((String)InsertDtl.get("return_dt"),"DMYHM",locale,"en"));
			}
			if((String)InsertDtl.get("replace_dt")!=null){
			     InsertDtl.put("replace_dt",com.ehis.util.DateUtils.convertDate((String)InsertDtl.get("replace_dt"),"DMYHM",locale,"en"));
			}
			if((String)InsertDtl.get("check_dt")!=null){
			     InsertDtl.put("check_dt",com.ehis.util.DateUtils.convertDate((String)InsertDtl.get("check_dt"),"DMYHM",locale,"en"));
			}
		} 
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		

	}

	public String getLocationDesc(String locn_code,String locn_type) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String facility_id = login_facility_id.trim();

		String location ="";

		try { 
			connection = getConnection() ;
			if(locn_type.equals("N"))
			{
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_NURSING_UNIT_SELECT" )) ;
				pstmt = connection.prepareStatement("SELECT LONG_DESC SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW IP_NURSING_UNIT WHERE EFF_STATUS='E' and FACILITY_ID=? and NURSING_UNIT_CODE =? AND LANGUAGE_ID =? ") ;
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locn_code);
				pstmt.setString(3,getLanguageId());
			}
			else if(locn_type.equals("C"))
			{
			//	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_OP_CLINIC_SELECT" )) ;
				pstmt = connection.prepareStatement("SELECT LONG_DESC SHORT_DESC FROM OP_CLINIC_LANG_VW OP_CLINIC WHERE EFF_STATUS='E'  AND CLINIC_TYPE='C' and FACILITY_ID=? AND CLINIC_CODE=? AND LANGUAGE_ID = ? ") ;
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locn_code);
				pstmt.setString(3,getLanguageId());
	
				
			}
			else if(locn_type.equals("P")){
			//	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REPORT_DISP_LOCATION" )) ;
				pstmt = connection.prepareStatement("SELECT SHORT_DESC SHORT_DESC FROM PH_DISP_LOCN_LANG_VW PH_DISP_LOCN WHERE EFF_STATUS='E' and facility_id =? AND DISP_LOCN_CODE=? AND LANGUAGE_ID = ?") ;
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locn_code);
				pstmt.setString(3,getLanguageId());
			
			}

			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
			location=resultSet.getString("SHORT_DESC");
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database"+e.toString() ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { }
		}
		return location;
	}

	public HashMap insert() {
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String seq_no="";
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		ArrayList insertData = new ArrayList() ;
	
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_CYTO_INCI_REPO_SELECT");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				seq_no=resultSet.getString(1);
						
			}
			if(seq_no==null) seq_no="";
			if(!seq_no.equals("")){
				setSeqNo(seq_no);
				insertData.add(seq_no);
				insertData.add( (String)InsertDtl.get("drug_code")==null?"":(String)InsertDtl.get("drug_code")) ;
				insertData.add( (String)InsertDtl.get("inc_date")==null?"":(String)InsertDtl.get("inc_date")) ;
				insertData.add( (String)InsertDtl.get("locn_type")==null?"":(String)InsertDtl.get("locn_type")) ;
				insertData.add( (String)InsertDtl.get("location1")==null?"":(String)InsertDtl.get("location1")) ;
				insertData.add( (String)InsertDtl.get("incident_desc")==null?"":(String)InsertDtl.get("incident_desc")) ;
				insertData.add( (String)InsertDtl.get("spill")==null?"":(String)InsertDtl.get("spill")) ;
				insertData.add( (String)InsertDtl.get("other_remarks")==null?"":(String)InsertDtl.get("other_remarks")) ;
				insertData.add( (String)InsertDtl.get("witness_id")==null?"":(String)InsertDtl.get("witness_id")) ;
				insertData.add( (String)InsertDtl.get("dosage_drug")==null?"":(String)InsertDtl.get("dosage_drug")) ;
				insertData.add( (String)InsertDtl.get("volume")==null?"":(String)InsertDtl.get("volume")) ;
				insertData.add( (String)InsertDtl.get("weight")==null?"":(String)InsertDtl.get("weight")) ;
				insertData.add( (String)InsertDtl.get("weight_uom")==null?"":(String)InsertDtl.get("weight_uom")) ;
				insertData.add( (String)InsertDtl.get("return_dt")==null?"":(String)InsertDtl.get("return_dt")) ;
				insertData.add( (String)InsertDtl.get("replace_dt")==null?"":(String)InsertDtl.get("replace_dt")) ;
				insertData.add( (String)InsertDtl.get("rep_person_id")==null?"":(String)InsertDtl.get("rep_person_id")) ;
				insertData.add( (String)InsertDtl.get("comment")==null?"":(String)InsertDtl.get("comment")) ;
				insertData.add( (String)InsertDtl.get("check_person_id")==null?"":(String)InsertDtl.get("check_person_id")) ;
				insertData.add( (String)InsertDtl.get("check_dt")==null?"":(String)InsertDtl.get("check_dt")) ;
				insertData.add( (String)InsertDtl.get("EFF_STATUS")==null?"":(String)InsertDtl.get("EFF_STATUS")) ;
								
				insertData.add( login_by_id.trim() ) ;
				insertData.add( login_at_ws_no.trim() ) ;
				insertData.add( login_facility_id.trim() ) ;
				insertData.add( login_by_id.trim() ) ;
				insertData.add( login_at_ws_no.trim() ) ;
				insertData.add( login_facility_id.trim() ) ;

				HashMap tabData = new HashMap() ;
				tabData.put( "properties", getProperties() );
				tabData.put( "InsertData",insertData);

				HashMap sqlMap = new HashMap() ;
				//sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_REQ_SELECT1"));
					
				sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_CYTO_INCI_REPO_INSERT"));

	//			SingleTableHandlerHome home = null;
	//			SingleTableHandlerRemote remote = null;
				try {
				
					/*InitialContext context = new InitialContext() ;
					Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

					home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
					remote = home.create() ;
					map = remote.insert( tabData, sqlMap ) ;*/


					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[] = new Object[2];
					argArray[0] = tabData;
					argArray[1] = sqlMap;

					Class [] paramArray = new Class[2];
					paramArray[0] = tabData.getClass(); ;
					paramArray[1] = sqlMap.getClass();

					map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					if( ((Boolean) map.get( "result" )).booleanValue() )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

					else{
						map.put( "message", "transaction failed") ;
					}

				
				}catch(Exception e) {
					System.err.println( "Error Calling EJB : "+e ) ;
					map.put( "message", e.getMessage()) ;
					e.printStackTrace() ;
				}
			}
		}
		catch(Exception e){
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} 
			catch( Exception ee ){
				System.err.println( "sql exception cought here");
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}
		map.put( "flag", "0" ) ;
		return map ;
	}

	public HashMap modify() {
	
		String seq_no="";
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		ArrayList modifyData = new ArrayList() ;

		try{
			seq_no= (String)InsertDtl.get("Seq_No")==null?"":(String)InsertDtl.get("Seq_No") ;
		//if(!seq_no.equals("")){
			setSeqNo(seq_no);
			
			modifyData.add( (String)InsertDtl.get("drug_code")==null?"":(String)InsertDtl.get("drug_code")) ;
			modifyData.add( (String)InsertDtl.get("inc_date")==null?"":(String)InsertDtl.get("inc_date")) ;
			modifyData.add( (String)InsertDtl.get("locn_type")==null?"":(String)InsertDtl.get("locn_type")) ;
			modifyData.add( (String)InsertDtl.get("location1")==null?"":(String)InsertDtl.get("location1")) ;
			modifyData.add( (String)InsertDtl.get("incident_desc")==null?"":(String)InsertDtl.get("incident_desc")) ;
			modifyData.add( (String)InsertDtl.get("spill")==null?"":(String)InsertDtl.get("spill")) ;
			modifyData.add( (String)InsertDtl.get("other_remarks")==null?"":(String)InsertDtl.get("other_remarks")) ;
			modifyData.add( (String)InsertDtl.get("witness_id")==null?"":(String)InsertDtl.get("witness_id")) ;
			modifyData.add( (String)InsertDtl.get("dosage_drug")==null?"":(String)InsertDtl.get("dosage_drug")) ;
			modifyData.add( (String)InsertDtl.get("volume")==null?"":(String)InsertDtl.get("volume")) ;
			modifyData.add( (String)InsertDtl.get("weight")==null?"":(String)InsertDtl.get("weight")) ;
			modifyData.add( (String)InsertDtl.get("weight_uom")==null?"":(String)InsertDtl.get("weight_uom")) ;
			modifyData.add( (String)InsertDtl.get("return_dt")==null?"":(String)InsertDtl.get("return_dt")) ;
			modifyData.add( (String)InsertDtl.get("replace_dt")==null?"":(String)InsertDtl.get("replace_dt")) ;
			modifyData.add( (String)InsertDtl.get("rep_person_id")==null?"":(String)InsertDtl.get("rep_person_id")) ;
			modifyData.add( (String)InsertDtl.get("comment")==null?"":(String)InsertDtl.get("comment")) ;
			modifyData.add( (String)InsertDtl.get("check_person_id")==null?"":(String)InsertDtl.get("check_person_id")) ;
			modifyData.add( (String)InsertDtl.get("check_dt")==null?"":(String)InsertDtl.get("check_dt")) ;
							
			modifyData.add( login_by_id.trim() ) ;
			modifyData.add( login_at_ws_no.trim() ) ;
			modifyData.add( login_facility_id.trim() ) ;
			modifyData.add(seq_no );

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",modifyData);

			HashMap sqlMap = new HashMap() ;
			//sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_REQ_SELECT1"));
				
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_CYTO_INCI_REPO_UPDATE"));

		//	SingleTableHandlerHome home = null;
		//	SingleTableHandlerRemote remote = null;
			try {

		/*		InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabData, sqlMap ) ;*/

		//		System.err.println("the results from map "+map);
				
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

				else{
					map.put( "message", "transaction failed") ;
				}
			
			}catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
	//	}
		}
		catch(Exception e){
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
		finally {
			try {} 
			catch( Exception ee ){
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}//finally
			map.put( "flag", "0" ) ;
		return map ;	
	}

	public HashMap delete() {
			
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		return map ;
	}
	public ArrayList getSearchDetails(String cyto_reported_fromdate,String cyto_reported_todate,String drug_code,String cyto_no,String ReportedBy,String locn_type,String locations ) throws Exception {
		

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList searchData = new ArrayList() ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue(
			"SQL_PH_ONCOLOGY_INCIDENT_RESULT"));// pass the query here
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,cyto_reported_fromdate);
			pstmt.setString(5,cyto_reported_todate);
			pstmt.setString(6,drug_code);
			pstmt.setString(7,drug_code);
			pstmt.setString(8,cyto_no);
			pstmt.setString(9,cyto_no);
			pstmt.setString(10,ReportedBy);
			pstmt.setString(11,ReportedBy);
			pstmt.setString(12,locn_type);
			pstmt.setString(13,locn_type);
			pstmt.setString(14,locations);
			pstmt.setString(15,locations);
			pstmt.setString(16,getLanguageId());
			
			resultSet = pstmt.executeQuery() ;
			
			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[7]; // depending on the no of columns u r fetching from the db alter the size
				record[0] = resultSet.getString( "INCIDENT_SEQ_NO" )  ;
				record[1] = resultSet.getString( "DRUG_CODE" )  ;
				record[2] = resultSet.getString( "DRUG_DESC" )  ;
				record[3] = resultSet.getString( "REPORTINGDATE" )  ;
				record[4] = resultSet.getString( "REPORTED_BY_ID" )  ;
				record[5] = resultSet.getString( "LOCATION" )  ;
				record[6] = resultSet.getString( "DOSAGEFORM" )  ;
				searchData.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return searchData;
	}


	public ArrayList getIncidentDtls(String Seq_no){
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;      
		String sqlQry				=	"";
		ArrayList	IncidentDtls	=	new ArrayList();
		//String date_of_incident		=	"";
		String date_of_replace		=	"";
		String date_of_return		=	"";
		String date_of_check		=	"";
		String locale				=	getLanguageId();
		try	{
			connection			= getConnection() ;
			
			sqlQry				= PhRepository.getPhKeyValue("SQL_PH_CYTO_INCI_REPO_SELECT1")  ;
					
			pstmt				= connection.prepareStatement(sqlQry);
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,Seq_no);
			pstmt.setString(5,getLanguageId());

			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				IncidentDtls.add(checkForNull(resultSet.getString("INCIDENT_SEQ_NO")));//0
				IncidentDtls.add(checkForNull(resultSet.getString("DRUG_CODE")));//1
               	IncidentDtls.add(checkForNull(resultSet.getString("DateOfIncident")));//2
				IncidentDtls.add(checkForNull(resultSet.getString("LOCN_TYPE")));//3
				IncidentDtls.add(checkForNull(resultSet.getString("LOCN_CODE")));//4
				IncidentDtls.add(checkForNull(resultSet.getString("INCIDENT_REMARKS")));//5
				IncidentDtls.add(checkForNull(resultSet.getString("CAUSE_OF_SPILAGE")));//6
				IncidentDtls.add(checkForNull(resultSet.getString("OTHER_REMARKS")));//7
				IncidentDtls.add(checkForNull(resultSet.getString("WITNESS_ID")));//8
				IncidentDtls.add(checkForNull(resultSet.getString("DOSAGE_FORM")));//9
				IncidentDtls.add(checkForNull(resultSet.getString("WEIGHT")));//10
				IncidentDtls.add(checkForNull(resultSet.getString("WEIGHT_UOM")));//11
                
				date_of_return =checkForNull(resultSet.getString("dateRetPharmacy"));
				if(!date_of_return.equals("")){
					date_of_return=com.ehis.util.DateUtils.convertDate(date_of_return,"DMYHM","en",locale);	
				}
				IncidentDtls.add(date_of_return);//12

				date_of_replace =checkForNull(resultSet.getString("dateReplaced"));
				if(!date_of_replace.equals("")){
					date_of_replace=com.ehis.util.DateUtils.convertDate(date_of_replace,"DMYHM","en",locale);
				}
				IncidentDtls.add(date_of_replace);//13

				IncidentDtls.add(checkForNull(resultSet.getString("REPORTED_BY_ID")));//14
				IncidentDtls.add(checkForNull(resultSet.getString("REPORTED_REMARKS")));//15
				IncidentDtls.add(checkForNull(resultSet.getString("CHECKED_BY_ID")));//16

				date_of_check =checkForNull(resultSet.getString("dateOfCheckRepo"));
				if(!date_of_check.equals("")){
					date_of_check=com.ehis.util.DateUtils.convertDate(date_of_check,"DMYHM","en",locale);
				}				
				IncidentDtls.add(date_of_check);//17
				IncidentDtls.add(checkForNull(resultSet.getString("VOLUME")));//18
				IncidentDtls.add(checkForNull(resultSet.getString("drug_desc")));//19
				IncidentDtls.add(checkForNull(resultSet.getString("witnessname")));//20
				IncidentDtls.add(checkForNull(resultSet.getString("reporterName")));//21
				IncidentDtls.add(checkForNull(resultSet.getString("CheckedBy")));//22		
			}
			
		}catch(Exception e){
			IncidentDtls.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){}
		}
		return IncidentDtls;
	}

	public String getUserName(String user_id){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String user_name="";

		try { 
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_SELECT31" )) ;
			pstmt.setString(1, user_id.trim());
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				user_name= resultSet.getString("APPL_USER_NAME");
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
			catch(Exception es) { }
		}
		return user_name;
	}
}
