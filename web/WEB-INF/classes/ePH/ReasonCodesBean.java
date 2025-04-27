/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
09/06/2020	IN072715     Haribabu	     								 MMS-DM-CRF-0165
--------------------------------------------------------------------------------------------------------------------
*/
 //saved on 08/11/2005
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
//import javax.rmi.* ;
//import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class ReasonCodesBean extends PhAdapter implements Serializable {
	

//	java.util.Properties p=null;

	protected String appl_trn_type = "";
	protected String appl_trn_type_desc = "";
	protected String reason_code = "";
	protected String reason_desc = "";
	protected String eff_status  = "";
	protected String QAP_report  = "";
	protected String remarks	 = "";

	public ReasonCodesBean() {
		try {
			doCommon();
		}
		catch(Exception e) {e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */
	public void clear() {
		super.clear() ;
	}

	private void doCommon() throws Exception {
	}

	/* Over-ridden Adapter methods end here */

	
	public void setApplTrnType(String appl_trn_type){
		this.appl_trn_type = appl_trn_type;
	}
	public void setReasonCode(String reason_code){
		this.reason_code = reason_code;
	}
	public void setReasonDesc(String reason_desc){
		this.reason_desc = reason_desc;
	}
	public void setEffStatus(String eff_status){
		if (eff_status.equals("") || eff_status==null ){
			eff_status="D";
		}
		this.eff_status = eff_status;
	}
    public void setQAP(String QAP_report){
	
	this.QAP_report=QAP_report;
	
	}
     
	public void setApplTrnTypeDesc(String appl_trn_type_desc){
		this.appl_trn_type_desc = appl_trn_type_desc;
	}
	//code added for remarks....on 6/6/2004
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}

	public String getApplTrnType(){
		return appl_trn_type;
	}
	public String getReasonCode(){
		return reason_code;
	}
	public String getReasonDesc(){
		return reason_desc;
	}
	public String getEffStatus(){
		return eff_status;
	}
	public String getQAP(){
	  return QAP_report;
	}


	public String getApplTrnTypeDesc(){
		return appl_trn_type_desc;
	}
	//code added for remarks... 6/6/2004
	public String getRemarks(){
		return remarks;
	}

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}


	// setAll method to set all the values
	public void setAll(Hashtable recordSet)
	{
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		if(recordSet.containsKey("appl_trn_type"))
			setApplTrnType((String)recordSet.get("appl_trn_type")) ;
		if(recordSet.containsKey("reason_code"))
			setReasonCode((String)recordSet.get("reason_code")) ;
		if(recordSet.containsKey("reason_desc"))
			setReasonDesc((String)recordSet.get("reason_desc")) ;
		if(recordSet.containsKey("eff_status"))
			setEffStatus((String)recordSet.get("eff_status"));
		if(recordSet.containsKey("remarks")){ 
//added for  SKR-SCF-0155 -IN029192 -start
			String tmpRematks = (String)recordSet.get("remarks");
			try{
				if(tmpRematks !=null && !tmpRematks.equals(""))
					tmpRematks = java.net.URLDecoder.decode(tmpRematks,"UTF-8");
			}
			catch(Exception e){
				e.printStackTrace();
			}
//added for  SKR-SCF-0155 -IN029192 -end
			setRemarks(tmpRematks);
		}
		if(recordSet.containsKey("QAP_report")){
//			setQAP((String)recordSet.get("QAP_report"));
		String qap_stat = (String)recordSet.get( "QAP_report" );
			if( !(qap_stat.equals("")))
			setQAP("Y") ;
			else
			setQAP("N") ;
			}
	}

	public void loadData() throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
		pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REASON_CODES_SELECT3") );
			pstmt.setString( 1, getApplTrnType().trim() ) ;
			pstmt.setString( 2, getReasonCode().trim() ) ;
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {

			

				setApplTrnType( resultSet.getString("APPL_TRN_TYPE" ));
				setReasonCode( resultSet.getString("REASON_CODE" ));
				setReasonDesc( resultSet.getString("REASON_DESC" ));
				setEffStatus( resultSet.getString("EFF_STATUS"));	
				setQAP(resultSet.getString("APPL_FOR_QAP_REPORT_YN"));
				setRemarks( resultSet.getString("REMARKS"));
				String strReasonCode = checkForNull(resultSet.getString("APPL_TRN_TYPE")).trim();
				
				if (strReasonCode.equals("R")) {
					setApplTrnTypeDesc("MedicationReissue");
				} else if (strReasonCode.equals("T")) {
					setApplTrnTypeDesc("MedicationReturn");
				} else if (strReasonCode.equals("H")) {
					setApplTrnTypeDesc("MedicationHold");
				} else if (strReasonCode.equals("A")) {
					setApplTrnTypeDesc("Allocation");
				} else if(strReasonCode.equals("F")) {
					setApplTrnTypeDesc("Filling");
				} else if(strReasonCode.equals("D")) {
					setApplTrnTypeDesc("Delivery"); 
				} else if(strReasonCode.equals("O")) {
					setApplTrnTypeDesc("AmendOrder");
				} else if(strReasonCode.equals("M")) {
					setApplTrnTypeDesc("Administration");
				} else if(strReasonCode.equals("RP")) {
					setApplTrnTypeDesc("ReleaseBatchPatient");
				} else if(strReasonCode.equals("RO")) {
					setApplTrnTypeDesc("ReleaseBatchOthers");
				} else if(strReasonCode.equals("E")) {
					setApplTrnTypeDesc("ADRReason");
				} else if(strReasonCode.equals("TD") ) {
					setApplTrnTypeDesc("TDMOrder");
				}else if(strReasonCode.equals("RR") ) {
					setApplTrnTypeDesc("ReroutePrescription");
				}else if(strReasonCode.equals("CO") ) {
					setApplTrnTypeDesc("CompleteOrder");
				}else if(strReasonCode.equals("OB") ) {
					setApplTrnTypeDesc("OverRideBMS");
				}else if(strReasonCode.equals("BR") ) {
					setApplTrnTypeDesc("BalanceMedicationRemarks");
				}else if(strReasonCode.equals("DM") ) {
					setApplTrnTypeDesc("DosageChangeinMAR");
				}
				else if(strReasonCode.equals("PR") ) {
					setApplTrnTypeDesc("PRNRemarks");
				}
				else if(strReasonCode.equals("CN") ) {
					setApplTrnTypeDesc("CancelNPBRequest");
				}
				else if(strReasonCode.equals("AC") ) { //code added for HSA-CRF-0005[40601] -- Start 
					setApplTrnTypeDesc("ADRCancelReason");
				}
				else if(strReasonCode.equals("AI") ) {
					setApplTrnTypeDesc("ADRInErrorReason"); 
				} //code added for HSA-CRF-0005[40601] -- End 
				else if(strReasonCode.equals("CM") ) {//ADDED FOR JD-CRF-0200
					setApplTrnTypeDesc("CancelMarAdminstration"); 
				}
				else if(strReasonCode.equals("MR") ) {//ADDED FOR MMS-KH-CRF-0010
					setApplTrnTypeDesc("MarAdminstrationRemarks"); 
				}else if(strReasonCode.equals("NP") ) {//GHL-CRF-0618
					setApplTrnTypeDesc("NotPreferedItemRemarks"); 
				}
				//Added for IN:072715 start
				else if(strReasonCode.equals("AO") ) {
					setApplTrnTypeDesc("AllergyOverrideReason"); 
				}
				else if(strReasonCode.equals("BD") ) {
					setApplTrnTypeDesc("BeyondDoseLimitOverrideReason"); 
				}
				else if(strReasonCode.equals("DP") ) {
					setApplTrnTypeDesc("DuplicateDrugOverrideReason"); 
				}
				else if(strReasonCode.equals("DD") ) {
					setApplTrnTypeDesc("Drug-DrugInteractionOverrideReason"); 
				}
				else if(strReasonCode.equals("DF") ) {
					setApplTrnTypeDesc("Drug-FoodInteractionOverrideReason"); 
				}
				else if(strReasonCode.equals("DL") ) {
					setApplTrnTypeDesc("Drug-LabInteractionOverrideReason"); 
				}else if(strReasonCode.equals("DI") ) {//Added for MMS-DM-CRF-0229
					setApplTrnTypeDesc("Drug-DiseaseOverrideReason"); 
				}
				//Added for IN:072715 start end
			}			
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
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
	}

	public HashMap insert() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
//		StringBuffer sb= new StringBuffer();
		try{
			insertData.add( appl_trn_type.trim() ) ;
			insertData.add( reason_code.trim() ) ;
			insertData.add(	reason_desc.trim() ) ;
			insertData.add( eff_status.trim()) ;
			
		
			
			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;
			insertData.add(remarks);
			insertData.add(QAP_report.trim());
			whereData.add( appl_trn_type.trim() ) ;
			whereData.add( reason_code.trim() ) ;
			
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_REASON_CODES_SELECT1") );
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_REASON_CODES_INSERT") );

//			SingleTableHandlerHome home = null;
//			SingleTableHandlerRemote remote = null;
			try {
				/* InitialContext context = new InitialContext() ;
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
					if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					else
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH")) ;
				}
			}
			catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
		}
		catch(Exception e){
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
		//	map.put("flag",sb.toString());
			e.printStackTrace() ;
		}
/*		finally {
			try {} 
			catch( Exception ee ){
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}//finally*/
		
		return map ;
	}

	public HashMap modify() {
	
		StringBuffer debug =new StringBuffer();
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList modifyData = new ArrayList() ;

		modifyData.add( reason_desc ) ;
		modifyData.add( eff_status ) ;
		
		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add(getRemarks());
		modifyData.add(QAP_report);
		modifyData.add( appl_trn_type) ;
		modifyData.add( reason_code) ;
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

		HashMap sqlMap = new HashMap() ;
		try{
		sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_REASON_CODES_UPDATE") );
		}catch(Exception e){
			e.printStackTrace();
		}

//		SingleTableHandlerHome home = null;
//		SingleTableHandlerRemote remote = null;


		try {
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			debug.append("BEFOER CREATE(IN MODIFY)");
			remote = home.create() ;
			debug.append("BEFOER MODIFY");
			map = remote.modify( tabData, sqlMap ) ;*/

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



			debug.append("After MODIFY:::"+(Boolean) map.get( "result" ));

			if( ((Boolean) map.get( "result" )).booleanValue() )
			{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH")) ;
				map.put( "flag",debug.toString());
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", (map.get("msgid"))) ;
				map.put( "flag",debug.toString());
			}
		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		} 
		/*finally {
			try {
			//	if( remote != null )
			//		remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		return map ;	
	}

	public HashMap delete() {
			
	//	StringBuffer debug =new StringBuffer();

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map ;
	}

public String getPrnRemarkForDrug()throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String  max_length_prn_reason =""; 
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement("SELECT max_length_prn_reason from ph_param") ;
			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){				
				max_length_prn_reason = ((resultSet.getString("max_length_prn_reason")==null) || (resultSet.getString("max_length_prn_reason").equals("")))?"255":resultSet.getString("max_length_prn_reason");	
				
			}	
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return max_length_prn_reason;
		
	}



}
