/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------
?             100            ?           created
20/09/2012    IN034894        Chowminya G     CRF-CA- Bru-HIMS-CRF-121/02- Status of Order is not Updated
10/09/2012    IN035550        Chowminya G     CRF-CA- Bru-HIMS-CRF-121/07- When a single Order is cancelled
18/01/2013		IN037372		Ramesh G		Oracle 11g Weblogic compilation.
21/02/2013	  IN037939		vijayakumark	  Issue 1: System is not allowing the user to define the Consent form from the ‘Existing Orders’ Function.
23/10/2019    IN071315	    Nijitha S  		   23/10/2019  		Ramesh G		GHL-CRF-0607	
-------------------------------------------------------------------------------------------------------
*/
package eOR.ORConsentOrder;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import java.io.*;
//import oracle.sql.CLOB;  //[IN037372]
import javax.ejb.* ;
import javax.transaction.* ;
import eOR.Common.* ;
/**
*
* @ejb.bean
*	name="ORConsentOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORConsentOrder"
*	local-jndi-name="ORConsentOrder"
*	impl-class-name="eOR.ORConsentOrder.ORConsentOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORConsentOrder.ORConsentOrderLocal"
*	remote-class="eOR.ORConsentOrder.ORConsentOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORConsentOrder.ORConsentOrderLocalHome"
*	remote-class="eOR.ORConsentOrder.ORConsentOrderHome"
*	generate= "local,remote"
*
*
*/

public class ORConsentOrderManager extends OrEJBSessionAdapter {
//    SessionContext context ;
	PreparedStatement pstmt = null ;

	StringBuffer traceVals = new StringBuffer();
	private LinkedHashMap consents_details			= new LinkedHashMap();
	private LinkedHashMap consents_update			= new LinkedHashMap();
	private LinkedHashMap consents_modify			= new LinkedHashMap();
	private LinkedHashMap consent_order_line_num			= new LinkedHashMap();
	/**
* @ejb.interface-method
*	 view-type="both"
*/
	
	public HashMap insert( HashMap tabData, HashMap sqlMap ) 
	{
		Connection connection = null ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		if(tabData.containsKey("function_from") && ((String)tabData.get("function_from")).equals("EXISTING_MULTI_CONSENT"))
		{

			consents_details=(LinkedHashMap)tabData.get("consents_details");
			consent_order_line_num=(LinkedHashMap)tabData.get("consent_order_line_num");
			consents_update=(LinkedHashMap)tabData.get("consents_update");
			consents_modify=(LinkedHashMap)tabData.get("consents_modify");
			
			map=existingConsentDetails(tabData,sqlMap);
		}
		else
		{
		
		StringBuffer messages = new StringBuffer() ;

		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;


		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;
			if(tabData.containsKey( "multi_consent_dtl" ))
			{
				map = multiconsentInsert(connection, tabData, sqlMap);
			}
			else
			{
				map = updateValues(connection, tabData, sqlMap);
			}	

		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);
			try {
				connection.rollback() ;
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {
				if ( pstmt != null ) {
					pstmt.close() ;
				}
				if(connection != null) {
					closeConnection(connection,(Properties)tabData.get( "properties" ));
				}
			} catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}

		//map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;
		}
		consents_details.clear();
		consent_order_line_num.clear();
		consents_update.clear();
		consents_modify.clear();

		return map ;
		
	}

public HashMap existingConsentDetails(HashMap tabDataParam,HashMap sqlMap)
{
	
	Connection connection = null ;
	PreparedStatement consent_insert 		= null;
	PreparedStatement consent_modify 	= null;
	PreparedStatement consent_delete 	= null;
	//PreparedStatement consent_delete 	= null;
	//ResultSet resultSet				= null;
	Set s;
	Iterator it;

	String login_by_id = "";
	String login_at_ws_no = "";
	String login_facility_id = "";
	int count1=0;
	int count2=0;
	int count3=0;
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
		/*String consent_form_id=null;
		String consent_form_stage=null;
		String default_chk=null;
		String seq_num=null;
		String total_rec_avail=null;
		String total_consents_req=null;
		String ord_catalog_code=null;
		String befOrder=null;
		String befRegn=null;*/
	String order_id=null;
	String order_line_num=null;
	String viewBy=null;
		/*String variable_stage=null;
		int consents_reccount = consents_details.size();
		int update_recount = consents_update.size();
		int modify_recount = consents_modify.size();*/
	viewBy=(String)consents_details.get("viewBy");
	//if(viewBy.equals("line")) //Commented --[IN034894]
	//{
	order_line_num=(String)consents_details.get("order_line_num");
	//}
	order_id=(String)consents_details.get("order_id");
	
	HashMap Hmap = new HashMap() ;
	Properties pt = null ;
	try
	{
		Hmap.put( "result", new Boolean( false ) ) ;
		Hmap.put( "flag", "insert" ) ;
		
		pt = (Properties)tabDataParam.get( "properties" ) ;
		login_at_ws_no =(((String)tabDataParam.get("login_at_ws_no")).equals(""))?null:((String)tabDataParam.get("login_at_ws_no"));
		login_by_id =(((String)tabDataParam.get("login_by_id")).equals(""))?null:((String)tabDataParam.get("login_by_id"));
		login_facility_id =(((String)tabDataParam.get("login_facility_id")).equals(""))?null:((String)tabDataParam.get("login_facility_id"));
		
		String SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT	   =(String)sqlMap.get("SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT");
		String SQL_OR_MULTI_CONSENT_FORM_DRAFT_MODIFY =(String)sqlMap.get("SQL_OR_MULTI_CONSENT_FORM_DRAFT_MODIFY");
		String SQL_OR_MULTI_CONSENT_FORM_DRAFT_DELETE_FORM =(String)sqlMap.get("SQL_OR_MULTI_CONSENT_FORM_DRAFT_DELETE_FORM");
		String SQL_OR_MULTI_CONSENT_FORM_DRAFT_AVAILABLE =(String)sqlMap.get("SQL_OR_MULTI_CONSENT_FORM_DRAFT_AVAILABLE");
		connection = getConnection(pt) ;
		consent_insert = connection.prepareStatement(SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT);
		consent_modify = connection.prepareStatement(SQL_OR_MULTI_CONSENT_FORM_DRAFT_MODIFY);
		consent_delete = connection.prepareStatement(SQL_OR_MULTI_CONSENT_FORM_DRAFT_DELETE_FORM);
		s = consents_update.entrySet();
		it = s.iterator();
		while (it.hasNext())
		{
			String temp_value1=it.next().toString();
			String[] hashValues1=temp_value1.split("=");
			String[] keys1=hashValues1[0].split("!!");
			String[] values1=hashValues1[1].split("!!");
			String arrChkAvailable[]  =  new String[3] ;
			arrChkAvailable[0]=order_id;
			//IN037939 starts uncommented
			if(viewBy.equals("header")) //Commented --[IN034894] 
			{
				order_line_num=(String)consent_order_line_num.get(keys1[0]);
			}
			//IN037939 ends uncommented
			arrChkAvailable[1]=order_line_num;
			arrChkAvailable[2]=values1[0];
			if(!(consents_modify.containsKey(hashValues1[0]))  && values1[2].equals("Y") && !(checkRecordsAvailable(arrChkAvailable,connection,SQL_OR_MULTI_CONSENT_FORM_DRAFT_AVAILABLE)) )
			{			
				consents_modify.put(hashValues1[0],hashValues1[1]);
			}
		}
		s = consents_modify.entrySet();
		it = s.iterator();
		while (it.hasNext())
		{
			String temp_value=it.next().toString();
			String[] hashValues=temp_value.split("=");
						
			if(consents_update.containsKey(hashValues[0]))
			{
				if(!(consents_update.get(hashValues[0]).equals(hashValues[1])))
				{

					String values_prev=consents_update.get(hashValues[0]).toString();
					String[] value_prev=values_prev.split("!!");
					String[] keys=hashValues[0].split("!!");
					String[] values=hashValues[1].split("!!");
				
					if(values[2].equals("Y"))
					{
							//IN037939 starts uncommented
							if(viewBy.equals("header")) //Commented --[IN034894]
							{
									order_line_num=(String)consent_order_line_num.get(keys[0]);
							}
							//IN037939 ends uncommented
							String arrChkAvailable[]  =  new String[3] ;
							arrChkAvailable[0]=order_id;
							arrChkAvailable[1]=order_line_num;
							arrChkAvailable[2]=values[0];

							if(checkRecordsAvailable(arrChkAvailable,connection,SQL_OR_MULTI_CONSENT_FORM_DRAFT_AVAILABLE))
							{
									consent_modify.setString(1 ,values[1]);
									consent_modify.setString(2 ,login_by_id);
									consent_modify.setString(3 ,login_at_ws_no);
									consent_modify.setString(4 ,login_facility_id);
									consent_modify.setString(5 ,order_id);
									consent_modify.setString(6 ,order_line_num);
									consent_modify.setString(7 ,values[0]);
									consent_modify.addBatch();
									count1++;
							}
							else
							{
									consent_delete.setString(1 ,order_id);
									consent_delete.setString(2 ,order_line_num);
									consent_delete.setString(3 ,value_prev[0]);
									consent_delete.addBatch();
									consent_insert.setString(1 ,order_id);
									consent_insert.setString(2 ,order_line_num);
									consent_insert.setString(3 ,values[0]);
									consent_insert.setString(4 ,values[1]);
									consent_insert.setString(5 ,login_by_id);
									consent_insert.setString(6 ,login_at_ws_no);
									consent_insert.setString(7 ,login_facility_id);
									consent_insert.setString(8 ,login_by_id);
									consent_insert.setString(9,login_at_ws_no);
									consent_insert.setString(10,login_facility_id);
									consent_insert.addBatch();
									count3++;
							}
							
					}
					else
					{
					
						consent_delete.setString(1 ,order_id);
						if(viewBy.equals("header"))
						{
							order_line_num=(String)consent_order_line_num.get(keys[0]);
						}
				
						consent_delete.setString(2 ,order_line_num);
						consent_delete.setString(3 ,values[0]);
						consent_delete.addBatch();
						count1++;
					}
				}
				else
				{
					String[] keys=hashValues[0].split("!!");
					String[] values=hashValues[1].split("!!");
					if(values[2].equals("Y"))
					{
						//IN037939 starts uncommented
						if(viewBy.equals("header")) //Commented --[IN034894]
						{
							order_line_num=(String)consent_order_line_num.get(keys[0]);
						}
						//IN037939 ends uncommented
						String arrChkAvailable[]  =  new String[3] ;
						arrChkAvailable[0]=order_id;
						arrChkAvailable[1]=order_line_num;
						arrChkAvailable[2]=values[0];
						if(checkRecordsAvailable(arrChkAvailable,connection,SQL_OR_MULTI_CONSENT_FORM_DRAFT_AVAILABLE))
						{
						
							consent_modify.setString(1 ,values[1]);
							consent_modify.setString(2 ,login_by_id);
							consent_modify.setString(3 ,login_at_ws_no);
							consent_modify.setString(4 ,login_facility_id);
							consent_modify.setString(5 ,order_id);
							consent_modify.setString(6 ,order_line_num);
							consent_modify.setString(7 ,values[0]);
							consent_modify.addBatch();
							count1++;
						}
						else
						{
						
							consent_insert.setString(1 ,order_id);
							consent_insert.setString(2 ,order_line_num);
							consent_insert.setString(3 ,values[0]);
							consent_insert.setString(4 ,values[1]);
							consent_insert.setString(5 ,login_by_id);
							consent_insert.setString(6 ,login_at_ws_no);
							consent_insert.setString(7 ,login_facility_id);
							consent_insert.setString(8 ,login_by_id);
							consent_insert.setString(9,login_at_ws_no);
							consent_insert.setString(10,login_facility_id);
							consent_insert.addBatch();
							count2++;
						}
					}
				}
			}
			else
			{
				String[] keys=hashValues[0].split("!!");
				String[] values=hashValues[1].split("!!");
				consent_insert.setString(1 ,order_id);
				//IN037939 starts uncommented
				if(viewBy.equals("header")) //Commented --[IN034894]
				{
						order_line_num=(String)consent_order_line_num.get(keys[0]);
				}
				//IN037939 ends uncommented
				consent_insert.setString(2 ,order_line_num);
				consent_insert.setString(3 ,values[0]);
				consent_insert.setString(4 ,values[1]);
				consent_insert.setString(5 ,login_by_id);
				consent_insert.setString(6 ,login_at_ws_no);
				consent_insert.setString(7 ,login_facility_id);
				consent_insert.setString(8 ,login_by_id);
				consent_insert.setString(9,login_at_ws_no);
				consent_insert.setString(10,login_facility_id);
				consent_insert.addBatch();
				count2++;
			}
		}
			//int updatedCounts1[]	= {} ;
			//int	 updatedCounts2[]	= {} ;
		boolean updateinsert=false;
		boolean updatemodify=false;
		try
		{
			if(count2>0&&count3>0)
			{
				consent_delete.executeBatch();
				consent_insert.executeBatch();
				updateinsert=true;
			}
			else
			{
				if(count2>0)
				{
					consent_insert.executeBatch();
					updateinsert=true;
				}
				if(count1>0)
				{
					consent_modify.executeBatch();
					consent_delete.executeBatch();
					updatemodify=true;
				}
				if(count3>0)
				{
					consent_delete.executeBatch();
					consent_insert.executeBatch();
					updateinsert=true;
				}
			}
		}
		catch(Exception e)
		{		
			e.printStackTrace();
				connection.rollback();
				traceVal.append(e.getMessage());
				Hmap.put( "traceVal", traceVal.toString() ) ;
				Hmap.put( "result", new Boolean( false ) ) ;
				messages.append( "Insert Failed" ) ;
				return Hmap ;
		}
		if(updateinsert || updatemodify)
		{
			connection.commit();
			Hmap.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
		}
		else 
		{
			connection.rollback();
			Hmap.put( "result", new Boolean( false ) ) ;
			messages.append( "NO_CHANGE_TO_SAVE" ) ;
		}

	}
	catch( Exception e )
	{
		traceVal.append("In Exception==");
		e.printStackTrace();
		traceVal.append(e.getMessage());
		Hmap.put( "traceVal", traceVal.toString() ) ;
		
		try 
		{
			connection.rollback();
			closeConnection( connection,pt);
		} 
		catch ( Exception ee ) 
		{
			ee.printStackTrace();
			messages.append(ee.getMessage() ) ;
		}
		if (e instanceof java.lang.NullPointerException || (((String)e.getMessage()).indexOf("Index: 0, Size: 0") != -1))
		{
			messages.delete(0, messages.length());
			messages.append("Cannot Update. Try Again Later...");
		}
		else
			messages.append( e.getMessage() ) ;
		e.printStackTrace() ;
	} 
	finally
	{
		try 
		{
			closeStatement(consent_insert);
			closeStatement(consent_modify);
			closeStatement(consent_delete);
			closeConnection( connection ,pt);
		}
		catch ( Exception fe ) 
		{
			fe.printStackTrace() ;
		}
	}
	Hmap.put( "message", messages.toString() ) ;
	Hmap.put( "traceVal", traceVal.toString() ) ;
	return Hmap ;
}

private boolean checkRecordsAvailable(String arr[],Connection con,String sql) throws Exception
	{
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs	         = null ;
	boolean availFlag = false ;
	try{
		
		int size				= arr.length ;
		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
		}
		rs = pstmt.executeQuery();

		int count = 0;

		if(rs.next())
		{
			count = rs.getInt(1);
		}

		if(count > 0)
		availFlag = true ;
		}catch(Exception e){
				traceVal.append(e);
				messages.append(e.getMessage());
				throw e;
	 }
	 finally{
		 try{
			closeResultSet( rs);
			closeStatement( pstmt ) ;
		 }catch(Exception ee){ee.printStackTrace();}
	 }
	 return availFlag;
	}

public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap){

	PreparedStatement pstmt 		= null;
	PreparedStatement pstmt_clob 	= null;
	ResultSet resultSet				= null;
	ResultSet resultSet1			= null;
	CallableStatement cstmt 		= null;
	
	PreparedStatement pstmt1 		= null;//--[IN034894]
	ResultSet resultSet2				= null;//--[IN034894]
//	String bill_yn		 = "";
	String err_message	 = "";
	String error_code	 = "";
	String sys_message_id	 = "";
	String error_text	 = "";
	String sql_or_bl_without_order_catalog = "";
	String sql_or_bl_check_orderable_billed = "";
	String sql_or_order_entry_get_bill_for_facility = "";
	String bill_for_facility_yn = "";
	String bill_charge_yn="";
	boolean bill_mess	 = true;
	HashMap map = new HashMap() ;

	HashMap updtmap = new HashMap() ;
	
	//Hashtable printValues = new Hashtable();
	StringBuffer messages = new StringBuffer() ;

	traceVals.append("====rconnection * >"+connection);
	int count =0;
	//int cnt=0;
//	int printCount	= 0;
	ArrayList sortList = (ArrayList)tabData.get("traverse_list");
	ArrayList arrangedList = (ArrayList)tabData.get("DataMap");
	count = Integer.parseInt((String)tabData.get("totalCount"));
	//cnt 	= Integer.parseInt((String)tabData.get("lineCount"));

	traceVals.append("====count *>"+count); 
	String[] updt_vals = new String[6];
	String[] updt_refusal = new String[24];
	HashMap consentDetail = new HashMap();
	HashMap consentFrmId = new HashMap();
	String consentDetailIndex = "";
	String order_status_code 	= "";
	String order_line_num = "";
	String order_catalog_code ="";
	String consent_form_id	  = "";
//	String srl_no = "";
	int result = 0;
// 	int result1=0;
	String cont_order_ind = "";
	HashMap consent_ref_seq = new HashMap();
	String ref_key = "";
//	String index = "0";
	try{
	int i =0;
	for(int x=0; x<count; x++){
		traceVals.append("i value => "+i);
		i =  Integer.parseInt((String)sortList.get(x));
		ref_key = (String)updtmap.get(""+i);
	updtmap = (HashMap)arrangedList.get(i);
/****************************************************************************************/
updt_refusal		= (String[])updtmap.get("consent_data"+i);
consentDetail		= (HashMap)updtmap.get("consentDetail"+i);
consentDetailIndex  = (String)updtmap.get("consentDetailIndex"+i);
consentFrmId		= (HashMap)updtmap.get("consentFrmId"+i);
if(consentDetailIndex==null) consentDetailIndex = "";


String pat_id		=  updt_refusal[0] ;
String ord_id		=  updt_refusal[4] ;
String consent_dets = updt_refusal[6] ;   // Not used.
//String consent_form_list = updt_refusal[16] ;   
String login_facility= (String)tabData.get("login_facility_id");
String login_by_id= (String)tabData.get("login_by_id");
String login_at_ws_no= (String)tabData.get("login_at_ws_no");
String regn_reqd_yn = updt_refusal[21] ;
String appt_reqd_yn = updt_refusal[22] ;
String consent_stage = updt_refusal[23] ;

order_line_num =  updt_refusal[20] ;
java.io.BufferedWriter	bw	= null;

int consent_ref_id = 0;
String order_set_id="";
String order_set_bill_yn="N";
String order_set_status_query = "";
String update_order_set_status="";
String update_order_set_line_status="";
String order_set_status_type="";
String order_set_status_type_code="";
//--[IN034894] -  Start
//pstmt1 = connection.prepareStatement( "Select order_catalog_code,order_line_num from or_order_line where order_id = ?  ") ;
pstmt1 = connection.prepareStatement( "Select order_catalog_code,order_line_num from or_order_line where order_id = ? and order_line_status <> (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('99'))") ; //--[IN035550]
pstmt1.setString(1, ord_id);
resultSet2 = pstmt1.executeQuery() ;
while ( resultSet2 != null && resultSet2.next() ) 
{
	order_line_num		= resultSet2.getString( "order_line_num" )  ;
	order_catalog_code	= resultSet2.getString( "order_catalog_code" )  ;
	
	
//--[IN034894] - End
pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REFUSAL_ORDER_ORDER_DTLS_SELECT") ) ;
//pstmt = connection.prepareStatement(   ("SELECT order_line_num,  order_catalog_code,catalog_synonym_dc,order_type_code order_type_code,(select consent_form_id from or_order_catalog where order_catalog_code = a.order_catalog_code) consent_form_id  from or_order_line a where order_id = ? and order_line_num= ? and  a.ord_consent_reqd_yn = 'Y' and (order_line_status = ( select order_status_code from or_order_status_code where order_status_type in ('00')) or ord_consent_status='P') order by order_line_num") ) ;

pstmt.setString(1, ord_id);
pstmt.setString(2, order_line_num);
resultSet = pstmt.executeQuery() ;

while ( resultSet != null && resultSet.next() ) {
	order_line_num		= resultSet.getString( "order_line_num" )  ;
	order_catalog_code	= resultSet.getString( "order_catalog_code" )  ;
	consent_form_id		= resultSet.getString( "consent_form_id" )  ;
	consent_dets		= "";

	if(consentFrmId!=null && consentFrmId.containsKey(consentDetailIndex))
		consent_form_id = (String)consentFrmId.get(consentDetailIndex);  
	

  	if(consentDetail!=null && consentDetail.containsKey(consentDetailIndex+consent_form_id)){
 		consent_dets =(String)consentDetail.get(consentDetailIndex+consent_form_id);
 		if(consent_dets==null) consent_dets="";
  	}
	if(consent_form_id==null) consent_form_id="";
	if(consent_dets==null) consent_dets="";
  	
	if(updt_refusal[17]==null) updt_refusal[17]="";
	if(updt_refusal[18]==null) updt_refusal[18]="";
	if(updt_refusal[19]==null) updt_refusal[19]="";
	if(consent_stage==null) consent_stage="";
	if(consent_stage.equals("Release"))
		consent_stage = "A";
	else if(consent_stage.equals("Registration"))
		consent_stage = "R";


	
/***************************************************************************************/
/**************new table insert starts*************************************************************************/
	if(updt_refusal[18].equals("")){
		pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_MULTI_CONSENT_SEQ_NO") ) ;

		resultSet1 = pstmt.executeQuery() ;

		while ( resultSet1 != null && resultSet1.next() ) {
			consent_ref_id = resultSet1.getInt( 1 )  ;
		}
		consent_ref_seq.put(consentDetailIndex, consent_ref_id+"");
		
		closeResultSet( resultSet1) ;
		closeStatement(pstmt);
		if(consent_stage.equals("")){
			pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_MULTI_CONSENT_GET_STAGE") ) ;
			
			pstmt.setString( 1, ord_id ) ;									// ORDER_ID   
			pstmt.setString( 2, order_line_num ) ;							// ORDER_LINE_NUM 
			pstmt.setString( 3, consent_form_id ) ;							// FORM_ID 

			resultSet1 = pstmt.executeQuery() ;

			while ( resultSet1 != null && resultSet1.next() ) {
				consent_stage = resultSet1.getString( 1 )  ;
			}
			if(consent_stage==null) consent_stage="";
			
			closeResultSet( resultSet1) ;
			closeStatement(pstmt);

			if(consent_stage.equals("")){
				pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_MULTI_CONSENT_GET_STAGE2") ) ;
			
				pstmt.setString( 1, order_catalog_code ) ;						// ORDER_CATALOG_CODE   
				pstmt.setString( 2, consent_form_id ) ;							// FORM_ID 

				resultSet1 = pstmt.executeQuery() ;

				while ( resultSet1 != null && resultSet1.next() ) {
					consent_stage = resultSet1.getString( 1 )  ;
				}
				if(consent_stage==null) consent_stage="";
				
				closeResultSet( resultSet1) ;
				closeStatement(pstmt);
			}
		}
		
		pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_MULTI_CONSENT_REF_HDR_INSERT") ) ;

		pstmt.setString( 1, String.valueOf(consent_ref_id) ) ; // CONSENT_REF_ID
		pstmt.setString( 2, "C" ) ;						// TYPE
		pstmt.setString( 3, consent_form_id ) ;			// FORM_ID
		pstmt.setString( 4, (updt_refusal[11].equals("")?"S":"R") ) ; // GIVEN_PERSON_TYPE
		pstmt.setString( 5, updt_refusal[5] ) ;        // GIVEN_PERSON_NAME         
		pstmt.setString( 6, updt_refusal[11] ) ;	   // GIVEN_RELATIONSHIP_CODE   
		pstmt.setString( 7,	updt_refusal[7] ) ;		   // TAKEN_PRACT_ID             
		pstmt.setString( 8,	updt_refusal[8]  ) ;	   // TAKEN_DATE_TIME            
		pstmt.setString( 9, updt_refusal[9] ) ;		   // REMARKS                    
		pstmt.setString( 10, updt_refusal[0]) ;		   // PATIENT_ID                
		pstmt.setString( 11, login_facility);		   // FACILITY_ID               
		pstmt.setString( 12, updt_refusal[2] ) ;	   // ENCOUNTER_ID              
		pstmt.setString( 13, updt_refusal[3] ) ;	   // PATIENT_CLASS              
		pstmt.setString( 14, login_by_id  ) ;		   // ADDED_BY_ID              
		pstmt.setString( 15, login_at_ws_no ) ;		   // ADDED_AT_WS_NO
		pstmt.setString( 16, login_facility ) ;		   // ADDED_FACILITY_ID        
		pstmt.setString( 17, login_by_id );			   // MODIFIED_BY_ID       
		pstmt.setString( 18, login_at_ws_no ) ;		   // MODIFIED_AT_WS_NO      
		pstmt.setString( 19, login_facility ) ;		   // MODIFIED_FACILITY_ID    

		pstmt.executeUpdate();
		closeStatement(pstmt);

		pstmt_clob = connection.prepareStatement( (String)sqlMap.get("SQL_OR_MULTI_CONSENT_CLOB_UPDATE") ) ;

		pstmt_clob.setString( 1, pat_id ) ;
		pstmt_clob.setString( 2, String.valueOf(consent_ref_id) ) ;
		pstmt_clob.setString( 3, consent_form_id ) ;

		resultSet1 = pstmt_clob.executeQuery() ;

		while ( resultSet1 != null && resultSet1.next() ) {
			//Web logic Conversion -- [IN037372] Start.
			//CLOB clb = (CLOB)resultSet1.getClob("FORM_CONTENT");
			//bw   = new BufferedWriter(clb.getCharacterOutputStream());
			
			java.sql.Clob clb = (java.sql.Clob)resultSet1.getClob("FORM_CONTENT");
			bw   = new BufferedWriter(clb.setCharacterStream(0));
			//Web logic Conversion -- [IN037372] End.
			bw.write(consent_dets,0,consent_dets.length());
			bw.flush();
			bw.close();
		}
		closeResultSet( resultSet1 ) ;
		closeStatement(pstmt_clob);

	}else if(!updt_refusal[18].equals("")){
		if(updt_refusal[17].equals("C"))
			consent_ref_id	= Integer.parseInt((String)consent_ref_seq.get((Integer.parseInt(updt_refusal[18])-1)+""));
		else if(updt_refusal[17].equals("E"))
			consent_ref_id	= Integer.parseInt((String)updt_refusal[18]);
		
	}
	if (updt_refusal[17].equals("E") && !updt_refusal[18].equals(""))
	{
		pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSENT_RECORD_EXISTING_CONSENT") ) ;
		String[] existing_rec =  updt_refusal[19].split("~");
		String ex_order_id ="";
		String ex_order_line_num ="";
		if(existing_rec.length == 2){
			ex_order_id = existing_rec[0];
			ex_order_line_num = existing_rec[1];
		}
		pstmt.setString( 1, ord_id ) ;									// ORDER_ID   
		pstmt.setString( 2, order_line_num ) ;							// ORDER_LINE_NUM  
		pstmt.setString( 3, order_catalog_code ) ;						// ORDER_CATALOG_CODE     
		if( updt_refusal[10]!=null &&  updt_refusal[10].length() > 59)	          
			pstmt.setString( 4,  updt_refusal[10].substring(0,59)) ;	// ORDER_CATALOG_DESC           
		else															          
			pstmt.setString( 4,  updt_refusal[10] ) ;					// ORDER_CATALOG_DESC     
		pstmt.setString( 5,	login_by_id  ) ;							// ADDED_BY_ID              
		pstmt.setString( 6, login_at_ws_no ) ;							// ADDED_AT_WS_NO
		pstmt.setString( 7, login_facility) ;							// ADDED_FACILITY_ID        
		pstmt.setString( 8, login_by_id);								// MODIFIED_BY_ID       
		pstmt.setString( 9, login_at_ws_no ) ;							// MODIFIED_AT_WS_NO      
		pstmt.setString( 10, login_facility) ;							// MODIFIED_FACILITY_ID      
		pstmt.setString( 11, String.valueOf(consent_ref_id) ) ;			// CONSENT_REF_ID    
		pstmt.setString( 12, ex_order_id ) ;							// EXISTING ORDER_ID   
		pstmt.setString( 13, ex_order_line_num ) ;						// EXISTING ORDER_LINE_NUM  
		
		try{
		pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		closeStatement(pstmt);
	}else{
		
		pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_MULTI_CONSENT_REF_DTL_INSERT") ) ;

		pstmt.setString( 1, String.valueOf(consent_ref_id) ) ;			// CONSENT_REF_ID    
		pstmt.setString( 2, ord_id ) ;									// ORDER_ID   
		pstmt.setString( 3, order_line_num ) ;							// ORDER_ID  
		pstmt.setString( 4, "C" ) ;										// TYPE  
		pstmt.setString( 5, consent_form_id ) ;                         // FORM_ID           
		pstmt.setString( 6, order_catalog_code ) ;						// ORDER_CATALOG_CODE     
		if( updt_refusal[10]!=null &&  updt_refusal[10].length() > 59)	          
			pstmt.setString( 7,  updt_refusal[10].substring(0,59)) ;	// ORDER_CATALOG_DESC           
		else															          
			pstmt.setString( 7,  updt_refusal[10] ) ;					// ORDER_CATALOG_DESC           
																		              
		pstmt.setString( 8,	login_by_id  ) ;							// ADDED_BY_ID              
		pstmt.setString( 9, login_at_ws_no ) ;							// ADDED_AT_WS_NO  
		pstmt.setString( 10, login_facility) ;							// ADDED_FACILITY_ID        
		pstmt.setString( 11, login_by_id);								// MODIFIED_BY_ID       
		pstmt.setString( 12, login_at_ws_no ) ;							// MODIFIED_AT_WS_NO      
		pstmt.setString( 13, login_facility) ;							// MODIFIED_FACILITY_ID      
		pstmt.setString( 14, consent_stage) ;							// CONSENT_STAGE      
		
		
		try{
		 pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		closeStatement(pstmt);

	}

}
/***************************************************************************************/

		updt_vals 		= (String[])updtmap.get("data"+i);
		cont_order_ind 	= (String)updtmap.get("cont_order_ind"+i);
		traceVals.append("updt_vals length => "+updt_vals.length);
		cont_order_ind = cont_order_ind.trim();

		pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_COMPLETE_STATUS") ) ;
		pstmt.setString(1, updt_vals[1]);
		pstmt.setString(2, "CONSENT");
		resultSet	= pstmt.executeQuery() ;
		if ( resultSet != null )    // If it returns orderstatus code , then update with the order_status_code else it will comes as "FALSE" , then proceed with the status  which came from the bean
		{
			while(resultSet.next())
			{
				order_status_code = resultSet.getString( "status" )  ;
			}
		}
		closeResultSet( resultSet ) ;
		closeStatement(pstmt);


		if(order_status_code==null || order_status_code.equals("") || order_status_code.equals("FALSE") )
			order_status_code = "";
		
		traceVals.append(",before order_status_code => "+order_status_code);

		pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_MULTI_CONSENT_WITH_CONSENT_STATUS") ) ;
					
		pstmt.setString(1, ord_id);				// ORDER_ID
		pstmt.setString(2, order_line_num);		// ORDER_LINE_NUM
		pstmt.setString(3, order_catalog_code); // ORDER_CATALOG_CODE
		resultSet	= pstmt.executeQuery() ;
		boolean update_flag = false,update_consent_flag= true;
		String ord_consent_status = "C";
		String consent_recorded_br = "0",num_of_consent_req_bo = "", num_of_consent_req_br="", consent_recorded_bo = "0";
	//	int tmp_cnt = 0 ;
		while(resultSet != null && resultSet.next())
		{	
			consent_recorded_bo = checkForNull(resultSet.getString( "CONSENTS_RECORDED_BO" ), "0");
			consent_recorded_br = checkForNull(resultSet.getString( "CONSENTS_RECORDED_BR" ), "0");
			num_of_consent_req_bo = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BO" ),"0");
			num_of_consent_req_br = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BR" ),"0");


	
			if( Integer.parseInt(num_of_consent_req_bo) > 1 ){
				order_status_code= Integer.parseInt(num_of_consent_req_bo ) == (Integer.parseInt(consent_recorded_bo ))?"":"PC";
				if(order_status_code.equals("") && Integer.parseInt(num_of_consent_req_br)>0)
					update_flag = true;
				
			}else if (Integer.parseInt(num_of_consent_req_bo) == 1 && Integer.parseInt(num_of_consent_req_br) > 0 )
			{
				if(Integer.parseInt(num_of_consent_req_bo) == Integer.parseInt(consent_recorded_bo ) )
					update_flag = true;
				else
					update_flag = false;
			}
			if( Integer.parseInt(num_of_consent_req_bo ) == Integer.parseInt(consent_recorded_bo ) ){
				update_consent_flag = true;
			}else
				update_consent_flag = false;

			if(Integer.parseInt(num_of_consent_req_bo) == Integer.parseInt(consent_recorded_bo) && Integer.parseInt(num_of_consent_req_br) > 0 && Integer.parseInt(num_of_consent_req_br) == (Integer.parseInt(consent_recorded_br)) )
				ord_consent_status = "C";
			else
				ord_consent_status = "P";	
				
			/*if( ( Integer.parseInt(num_of_consent_req_bo ) == (Integer.parseInt(consent_recorded_bo )) ) && ( Integer.parseInt(num_of_consent_req_br ) == Integer.parseInt(consent_recorded_br ) ) )
					update_consent_flag = true;
			else
					update_consent_flag = false;*/
		}

 		closeResultSet( resultSet) ;
		closeStatement(pstmt);

		if(update_flag){
			pstmt = connection.prepareStatement((String)sqlMap.get("SQL_OR_MULTI_CONSENT_ORDER_LINE_CONSENT_STAGE_UPDATE") ) ;

			pstmt.setString( 1, "R");			//ORD_CONSENT_STAGE
			pstmt.setString( 2, login_by_id);	//modified_by_id		
			pstmt.setString( 3, login_at_ws_no ) ;  //modified_at_ws_no
			pstmt.setString( 4, login_facility ) ;//modified_facility_id
			pstmt.setString( 5, ord_id ) ; //order_id
			pstmt.setString( 6, order_line_num ) ; //order_line_num
			
			result = pstmt.executeUpdate();
			closeStatement(pstmt);

		}
		
		if(order_status_code.equals("")) //Then put the order_status_code from the bean
		   order_status_code = updt_vals[0];
		updt_vals = (String[])updtmap.get("lineData"+i);
		/******/
		String ord_consent_stage="";//(String)sqlMap.get("SQL_OR_CONSENT_ORDER_UPDATE_CONSENT_STATUS") ) ;
		pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSENT_ORDER_WITH_CONSENT_STAGE") ) ;
		pstmt.setString( 1, ord_id ) ;
		pstmt.setString( 2, order_line_num ) ;
		resultSet1 = pstmt.executeQuery() ;

		while ( resultSet1 != null && resultSet1.next() ) {
			ord_consent_stage= resultSet1.getString( "ord_consent_stage" )  ;
		}

		if((ord_consent_stage == null) || ord_consent_stage.equals("null") )
			ord_consent_stage = "";
		closeResultSet( resultSet1) ;
		closeStatement(pstmt);
		/******/
		if (regn_reqd_yn.equals("Y"))
		{
			if (ord_consent_stage.equals("R") && ord_consent_status.equals("P") || appt_reqd_yn.equals("Y"))
			{
				pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_STATUS_CODE_FOR_STATUS_TYPE") ) ;
				pstmt.setString(1,"10");
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					order_status_code= resultSet.getString( "order_status_code" )  ;
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			
		}
 		
		String p_order_status_code = "";
	/*	pstmt = connection.prepareStatement((String)sqlMap.get("SQL_OR_ORDER_GET_STATUS_CODE") ) ;
		pstmt.setString( 1, ord_id);		
		resultSet = pstmt.executeQuery() ;

		if ( resultSet != null && resultSet.next() ) {
			p_order_status_code= resultSet.getString( 1 )  ; //order_status_code
			p_order_status_code = (p_order_status_code==null)?"":p_order_status_code;
		}
	*/ boolean there=false;
				
		if(ord_consent_stage.equals("R")){
			//if (regn_reqd_yn.equals("Y")){
				//String sql="select 1 from  OR_ORDER A, or_order_status_code B WHERE ORDER_ID=? AND A.ORDER_STATUS=B.ORDER_STATUS_CODE AND B.ORDER_STATUS_TYPE <(select ORDER_STATUS_TYPE  from or_order_status_code where ORDER_STATUS_CODE=?)";
				String sql="select 1 from  OR_ORDER_LINE A, or_order_status_code B WHERE A.ORDER_ID=?  AND A.ORDER_LINE_NUM=? AND A.ORDER_LINE_STATUS=B.ORDER_STATUS_CODE AND B.ORDER_STATUS_TYPE <(select ORDER_STATUS_TYPE  from or_order_status_code where ORDER_STATUS_CODE=?)";
				there=false;
				pstmt = connection.prepareStatement(sql);
				pstmt.setString( 1, updt_vals[1] ) ;
				pstmt.setString( 2, order_line_num) ;
				pstmt.setString( 3, order_status_code) ;
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					there=true;
				}
				closeResultSet( resultSet ) ;
				closeStatement(pstmt);
				if(there)
				{
				pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE_STAGE") ) ;

				pstmt.setString( 1, order_status_code ) ;
				pstmt.setString( 2, login_by_id ) ;
				pstmt.setString( 3, login_at_ws_no ) ;
				pstmt.setString( 4, login_facility ) ;
				pstmt.setString( 5, updt_vals[1] ) ;
				pstmt.setString( 6, order_line_num ) ;			
		
  				result = pstmt.executeUpdate();
				
				closeStatement(pstmt);
				}
				else
				result=1;
			//}
			pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSENT_ORDER_UPDATE_CONSENT_STATUS") ) ;

			pstmt.setString( 1, ord_consent_status ) ;  // "C"   -- previously by default
			pstmt.setString( 2, login_by_id ) ;
			pstmt.setString( 3, login_at_ws_no ) ;
			pstmt.setString( 4, login_facility ) ;
			pstmt.setString( 5, ord_id ) ;
			pstmt.setString( 6, order_line_num ) ;	

			result = pstmt.executeUpdate();
			closeStatement(pstmt);

			p_order_status_code = getStatusCode(connection, ord_id, (String)sqlMap.get("SQL_OR_ORDER_GET_STATUS_CODE"));
			if(p_order_status_code == null || p_order_status_code.equals(""))
				p_order_status_code =  order_status_code ;		
					    
				String sql1="select 1 from  OR_ORDER A, or_order_status_code B WHERE A.ORDER_ID=? AND A.ORDER_STATUS=B.ORDER_STATUS_CODE AND B.ORDER_STATUS_TYPE <(select ORDER_STATUS_TYPE  from or_order_status_code where ORDER_STATUS_CODE=?)";
				there=false;
				pstmt = connection.prepareStatement(sql1);
				pstmt.setString( 1, ord_id ) ;
				pstmt.setString( 2, p_order_status_code) ;
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					there=true;
				}
				closeResultSet( resultSet ) ;
				closeStatement(pstmt);

			//	String tempSql="select 1 from  OR_ORDER A, or_order_status_code B WHERE A.ORDER_ID=? AND A.ORDER_CATEGORY = 'PH' A.ORDER_STATUS=B.ORDER_STATUS_CODE AND B.ORDER_STATUS_TYPE <(select ORDER_STATUS_TYPE  from or_order_status_code where ORDER_STATUS_CODE=?)";

				if(there)
			{
			pstmt = connection.prepareStatement((String)sqlMap.get("SQL_OR_CONSENT_ORDER_UPDATE_CONSENT_BY_ID") ) ;

			pstmt.setString( 1, p_order_status_code);			
			pstmt.setString( 2, ((String)tabData.get("login_by_id")));			
			pstmt.setString( 3, login_by_id ) ;
			pstmt.setString( 4, login_at_ws_no ) ;
			pstmt.setString( 5, login_facility ) ;
			pstmt.setString( 6, ord_id ) ;

			result = pstmt.executeUpdate();


			closeStatement(pstmt);
			}
			else
			result=1;

		}

 		if( (!ord_consent_stage.equals("R") || cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ) && update_consent_flag)
		{
			String sql2="select 1 from  OR_ORDER_LINE A, or_order_status_code B WHERE A.ORDER_ID=?  AND A.ORDER_LINE_NUM=? AND A.ORDER_LINE_STATUS=B.ORDER_STATUS_CODE AND B.ORDER_STATUS_TYPE <(select ORDER_STATUS_TYPE  from or_order_status_code where ORDER_STATUS_CODE=?)";
				there=false;
				pstmt = connection.prepareStatement(sql2);
				pstmt.setString( 1, updt_vals[1] ) ;
				pstmt.setString( 2, order_line_num) ;
				pstmt.setString( 3, order_status_code) ;
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					there=true;
				}
				closeResultSet( resultSet ) ;
				closeStatement(pstmt);
				if(there)
			{
			pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE") ) ;

			pstmt.setString( 1, order_status_code ) ;
			pstmt.setString( 2, login_by_id ) ;
			pstmt.setString( 3, login_at_ws_no ) ;
			pstmt.setString( 4, login_facility ) ;
			pstmt.setString( 5, updt_vals[1] ) ;
			pstmt.setString( 6, order_line_num ) ;	

  			result = pstmt.executeUpdate();
			closeStatement(pstmt);
			}
			else
				result=1;

			p_order_status_code = getStatusCode(connection, ord_id, (String)sqlMap.get("SQL_OR_ORDER_GET_STATUS_CODE"));
			if(p_order_status_code == null || p_order_status_code.equals(""))
				p_order_status_code =  order_status_code ;
				String sql3="select 1 from  OR_ORDER A, or_order_status_code B WHERE a.ORDER_ID=? AND A.ORDER_STATUS=B.ORDER_STATUS_CODE AND B.ORDER_STATUS_TYPE <(select ORDER_STATUS_TYPE  from or_order_status_code where ORDER_STATUS_CODE=?)";
				there=false;
				pstmt = connection.prepareStatement(sql3);
				pstmt.setString( 1, updt_vals[1] ) ;
				pstmt.setString( 2, p_order_status_code) ;
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					there=true;
				}
				closeResultSet( resultSet ) ;
				closeStatement(pstmt);
				if(there)
				{
				pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSENT_ORDER_CANCEL_WITH_CONSENT_REQD") ) ;

				pstmt.setString( 1, p_order_status_code ) ;
				//***pstmt.setString( 2, updt_vals[1] ) ;
				pstmt.setString( 2, updt_refusal[7] ) ;
				pstmt.setString( 3, login_by_id ) ;
				pstmt.setString( 4, login_at_ws_no ) ;
				pstmt.setString( 5, login_facility ) ;
				pstmt.setString( 6, updt_vals[1] ) ;
				
				pstmt.executeUpdate();
				closeStatement(pstmt);
				}
			
				
		}
		if(!update_consent_flag)
			result = 1;

 		//if( (cont_order_ind.equals("DR") || cont_order_ind.equals("CR")) && update_consent_flag){
 		if( cont_order_ind.equals("DR")  && update_consent_flag)
		{

		 	pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSENT_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN") ) ;

			pstmt.setString( 1, p_order_status_code) ;
			//**pstmt.setString( 2, updt_vals[1] ) ;
			pstmt.setString( 2, updt_refusal[7] ) ;
			pstmt.setString( 3, login_by_id ) ;
			pstmt.setString( 4, login_at_ws_no ) ;
			pstmt.setString( 5, login_facility ) ;
			pstmt.setString( 6, updt_vals[1] ) ;

			pstmt.executeUpdate();
 			closeStatement(pstmt);
			if(ord_consent_stage.equals("R"))
				pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN_STAGE") ) ;	
			else
				pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN") ) ;

			pstmt.setString( 1, order_status_code ) ;
			pstmt.setString( 2, login_by_id ) ;
			pstmt.setString( 3, login_at_ws_no ) ;
			pstmt.setString( 4, login_facility ) ;
			pstmt.setString( 5, updt_vals[1] ) ;
 			result = pstmt.executeUpdate();
			closeStatement(pstmt);
		}
		
		if(!update_consent_flag)
			result = 1;

 		if(result > 0)
		{
			// Billing
			try
			{
			
				//if(!ord_consent_stage.equals("R")) 
					 //Add this condition on 20/11/2007 to handle the chargeing for consent before registration case
				//{
						sql_or_order_entry_get_bill_for_facility=(String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_BILL_FOR_FACILITY");
						pstmt = connection.prepareStatement(sql_or_order_entry_get_bill_for_facility);
						pstmt.setString( 1, ((String)tabData.get("login_facility_id"))) ;
						resultSet = pstmt.executeQuery() ;
						if ( resultSet != null && resultSet.next() ) 
						{
							bill_for_facility_yn=resultSet.getString("bl_module_yn");
						}
						closeResultSet( resultSet ) ;
						closeStatement(pstmt);

						order_set_id=updt_vals[4];
						if(order_set_id==null)order_set_id="";
						order_set_bill_yn=updt_vals[5];
						if(order_set_bill_yn==null)order_set_bill_yn="";
						
						if(bill_for_facility_yn.equalsIgnoreCase("Y"))
						{					
								
								sql_or_bl_check_orderable_billed=(String)sqlMap.get("SQL_OR_BL_CHECK_ORDERABLE_BILLED");
								cstmt = connection.prepareCall("{ "+sql_or_bl_check_orderable_billed+" }");
								cstmt.setString(1, ((String)tabData.get("login_facility_id")));
								cstmt.setString(2,"OR");
								if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
								{
									cstmt.setString(3, updt_vals[4]);
									cstmt.setString(4,"1");
								}
								else
								{
									cstmt.setString(3, updt_vals[1]);
									cstmt.setString(4, order_line_num);
								}
								cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;
								cstmt.registerOutParameter( 6,  Types.VARCHAR ) ;
								cstmt.registerOutParameter( 7,  Types.VARCHAR ) ;
								cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
								cstmt.execute();
								bill_charge_yn=cstmt.getString(5);
								error_code=cstmt.getString(6);
								sys_message_id=cstmt.getString(7);
								error_text=cstmt.getString(8);
								if(error_code!=null && error_code!="null" && !error_code.equals("") && sys_message_id!=null && sys_message_id!="null" && !sys_message_id.equals("") && error_text!=null && error_text!="null" && !error_text.equals(""))
								{
									result 			= 0;
									bill_mess	 	= false;
									messages.append(error_text ) ;
								} // End of if !err_message

								closeStatement(cstmt);
						}
			}
			catch(Exception e)
		{
				result = 0;
				e.printStackTrace();
		}
	}

		if(result > 0)
		{
			// Billing
			try
			{
						order_set_status_query = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE");
						String order_set_status_query_code = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE");
						update_order_set_status = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS");
						update_order_set_line_status = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS");
						
						if((!(order_set_status_query.equals("")))&&(order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
						{
								pstmt=connection.prepareStatement(order_set_status_query);
								pstmt.setString(1,order_set_id.trim());
								resultSet=pstmt.executeQuery();
								while(resultSet.next())
								 {
									order_set_status_type=resultSet.getString("order_set_status");
								 }
								closeStatement(pstmt);
								closeResultSet(resultSet);
									
								if(order_set_status_type==null) order_set_status_type="";
								pstmt=connection.prepareStatement(order_set_status_query_code);
								pstmt.setString(1,order_set_status_type);
								resultSet=pstmt.executeQuery();
								while(resultSet.next())
								 {
									order_set_status_type_code=resultSet.getString("order_status_type");
								 }
					
								closeStatement(pstmt);
								closeResultSet(resultSet);
									
								if(order_set_status_type_code==null) order_set_status_type_code="";
						}
						if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
						{
								pstmt=connection.prepareStatement(update_order_set_status);
								pstmt.setString(1,order_set_status_type.trim());
								pstmt.setString(2,order_set_id.trim());
								pstmt.executeUpdate();
								closeStatement(pstmt);
								pstmt=connection.prepareStatement(update_order_set_line_status);
								pstmt.setString(1,order_set_status_type.trim());
								pstmt.setString(2,order_set_id.trim());
								pstmt.setString(3,"1");
								pstmt.executeUpdate();
								closeStatement(pstmt);
						}

						if(bill_charge_yn.equalsIgnoreCase("N"))
						{
							sql_or_bl_without_order_catalog = (String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG");
							cstmt = connection.prepareCall("{ "+sql_or_bl_without_order_catalog+" }");
							cstmt.setString(1, ((String)tabData.get("login_facility_id")));
							if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
							{
								cstmt.setString(2, updt_vals[4]);
								cstmt.setString(3,"1");
							}
							else
							{
								cstmt.setString(2, updt_vals[1]);
								cstmt.setString(3, order_line_num);
							}
							if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
							{
								if(order_set_status_type_code.equals("00")||order_set_status_type_code.equals("03")||order_set_status_type_code.equals("05"))
								 {
										cstmt.setString(4, "PAT");
								 }
								 else
								 {
										cstmt.setString(4, "AUT");
								 }
							}
							else
							{
								if((updt_vals[2]!=null && updt_vals[2].equals("Y"))||((updt_vals[3]!=null && updt_vals[3].equals("Y")))) // SpecialApproved or authorization required 
									cstmt.setString(4, "PAT");
								else
									cstmt.setString(4, "AUT");
							}
							cstmt.setString(5, ((String)tabData.get("login_by_id")));
							cstmt.setString(6, ((String)tabData.get("login_at_ws_no")));

							cstmt.registerOutParameter( 7,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
							cstmt.setString(9, "OR");//IN071315
							
							cstmt.execute();
			//				bill_yn 		= cstmt.getString(7);
							err_message 	= cstmt.getString(8);
							if(err_message!=null && err_message!="null" && !err_message.equals(""))
							{
								result 			= 0;
								bill_mess	 	= false;
								messages.append( err_message ) ;
							} // End of if !err_message
							closeStatement(cstmt);
					}
			}catch(Exception e)
			{
				result = 0;
				e.printStackTrace();
			}
		}


		traceVals.append("result@@=> "+result);
	}

	if (resultSet2 != null)resultSet2.close();//15950
	if (pstmt1 != null)pstmt1.close();//15950
	}//--[IN034894]
	//printValues.put("total_records",Integer.toString(printCount));
	//traceVals.append(",printValues@@=> "+printValues);
 	if ( result< 1 ) 
	{
		connection.rollback();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "Operation failure ..." ) ;
		messages.append( "Insert Failed" ) ;

	} 
	else 
	{
 
	// Added By Sridhar Reddy to Temparory fix  PH issue for IV Fluids_Drugs consent record on 14/03/2010 at Bangkok (Siriraj Walk Through) Later PH has to fix this issue from their side.		
		String tempSql = "SELECT 1 FROM or_order a, or_order_line b WHERE a.order_id = ? AND b.order_id = a.order_id AND b.order_line_status = 'PC' AND b.ord_consent_reqd_yn = 'N' AND A.ORDER_CATEGORY = 'PH'";
		PreparedStatement tempPstmt 				= null,tempPstmt1 = null,tempPstmt2 = null,tempPstmt3 = null ;
		ResultSet tempRs 				= null,tempRs1=null ;
		boolean tempUpdate = false;
		int tempPH = 0,tempPH1 = 0;
		try
		{
			tempPstmt = connection.prepareStatement(tempSql);
			tempPstmt.setString(1,updt_vals[1]);			
			tempRs = tempPstmt.executeQuery();
			if (tempRs.next())
			{
				tempSql = " UPDATE or_order_line SET order_line_status = ? WHERE order_id = ? AND order_line_status = 'PC' AND ord_consent_reqd_yn = 'N' AND ORDER_CATEGORY = 'PH'";
				tempPstmt1 = connection.prepareStatement(tempSql);
				tempPstmt1.setString(1,order_status_code);			
				tempPstmt1.setString(2,updt_vals[1]);			
				tempPH = tempPstmt1.executeUpdate();

				tempSql = "SELECT 1 FROM or_order a, or_order_line b WHERE a.order_id = ? AND b.order_id = a.order_id AND b.order_line_status = 'PC' AND b.ord_consent_reqd_yn = 'Y' AND A.ORDER_CATEGORY = 'PH'";

				tempPstmt2 = connection.prepareStatement(tempSql);
				tempPstmt2.setString(1,updt_vals[1]);			
				tempRs1 = tempPstmt2.executeQuery();
				if (tempRs1.next())
				{
					tempUpdate = true;					
				}
				if (!tempUpdate)
				{					
					tempSql = "UPDATE or_order SET ORDER_STATUS = ? WHERE order_id = ? AND ORDER_CATEGORY = 'PH'";
					tempPstmt3 = connection.prepareStatement(tempSql);
					tempPstmt3.setString(1,order_status_code);			
					tempPstmt3.setString(2,updt_vals[1]);			
					tempPH1 = tempPstmt3.executeUpdate();
				}
			}		 
			
			if (tempRs != null)tempRs.close();
			if (tempRs1 != null)tempRs1.close();
			if (tempPstmt1 != null)tempPstmt1.close();
			if (tempPstmt2 != null)tempPstmt2.close();
			if (tempPstmt3 != null)tempPstmt3.close();
			if (tempPstmt != null)tempPstmt.close();		
		}
		catch (Exception tempE)
		{
			tempE.printStackTrace();
		}
		//END
		connection.commit() ;
		map.put( "result", new Boolean( true ) ) ;
		//map.put("printValues",printValues);

		if(bill_mess)
		{
			map.put( "message", "Operation Completed Successfully..." ) ;
			messages.append( "RECORD_MODIFIED" ) ;
		}
		else
		{
			map.put( "message", err_message ) ;
			messages.append( "RECORD_MODIFIED" ) ;
		}
		//messages.append( "Operation Completed Successfully..." ) ;
	}
	
	}catch(Exception e){
		e.printStackTrace();
 	} finally {
		try {
 			closeResultSet( resultSet ) ;
			closeResultSet( resultSet2 ) ;
			closeResultSet( resultSet1 ) ;
			closeStatement( pstmt);
			closeStatement( pstmt1);
			closeStatement( pstmt_clob);
			closeStatement( cstmt ) ;
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVals.toString() ) ;
	return map;
}
/**
* @ejb.interface-method
*	 view-type="both"
*/
public HashMap multiconsentInsert(Connection connection, HashMap tabData, HashMap sqlMap){
	PreparedStatement pstmt = null,pstmt_del = null;
	CallableStatement cstmt = null;
	int count = Integer.parseInt((String)tabData.get("totalCount"));  //totalCount
	HashMap map = new HashMap() ;
	HashMap multiConData =  (HashMap)tabData.get("multi_consent_dtl"); 
	String order_id		  = (String)tabData.get("order_id");
	String order_line_num = (String)tabData.get("order_line_num");
	String login_by_id	  = (String)tabData.get("login_by_id");
	String login_at_ws_no = (String)tabData.get("login_at_ws_no");
	String login_facility_id = (String)tabData.get("login_facility_id");
	
	try{

		pstmt_del = connection.prepareStatement((String)sqlMap.get("SQL_OR_MULTI_CONSENT_FORM_DRAFT_DELETE"));
			
		
		pstmt = connection.prepareStatement((String)sqlMap.get("SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT"));
		for(int i=0;i<count;i++){
			pstmt_del.setString(1, order_id);  //order_id
			pstmt_del.setString(2, order_line_num); //order_line_num
			//pstmt_del.setString(3, (String)multiConData.get("consent_form_id"+i));  //consent_form_id
			pstmt_del.executeUpdate();


			pstmt.setString(1, order_id);  //order_id
			pstmt.setString(2, order_line_num); //order_line_num
			pstmt.setString(3, (String)multiConData.get("consent_form_id"+i));
			pstmt.setString(4, (String)multiConData.get("consent_stage"+i));
			pstmt.setString(5, login_by_id); 
			pstmt.setString(6, login_at_ws_no);    
			pstmt.setString(7, login_facility_id); 
			pstmt.setString(8, login_by_id); 
			pstmt.setString(9, login_at_ws_no);    
			pstmt.setString(10,login_facility_id); 
			pstmt.addBatch();
		}
		boolean consent_update = false;
		try{

		int[] updatebatch = pstmt.executeBatch();
		
		
		/*
		if((updatebatch.length > 0)){ //check updation in SYN
			consent_update= true ;
		}else if((updatebatch.length == (-3))){
			consent_update= false ;
		}*/
		for (int i=0;i<updatebatch.length ;i++ )
		{
			if(updatebatch[i] !=-2 && updatebatch[i] < 0) // -3 if it fails
			{
				consent_update=false;
				break;
			}
			else consent_update=true;
		} 
		
		cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_ASSOCIATE_CONSENT")+" }");
		cstmt.setString(1, order_id);			//order_id             
		cstmt.setString(2, order_line_num);		//order_line_num  
		cstmt.execute();


		}catch(Exception e){
			e.printStackTrace();
		}
		if(consent_update){
			connection.commit() ;
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", "RECORD_MODIFIED" ) ;
		}else{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", "Insert Failed" ) ;
		}

	}catch(Exception e){
		map.put( "message", e.getMessage() ) ;
		e.printStackTrace();
 	} finally {
		try {
			closeStatement( pstmt_del);
 			closeStatement( pstmt);
			closeStatement( cstmt ) ;
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	
	return map;

}
/**
* @ejb.interface-method
*	 view-type="both"
*/
private String getStatusCode(Connection connection, String order_id, String query)throws Exception{

	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String order_status_code= "";
	
	
	try{
		
		pstmt = connection.prepareStatement( query ) ;
		pstmt.setString( 1, order_id);		 
		resultSet = pstmt.executeQuery() ;

		if ( resultSet != null && resultSet.next() ) {
			order_status_code= resultSet.getString( 1 )  ; //order_status_code
			order_status_code = (order_status_code==null)?"":order_status_code;
		}
	
			

	}catch(Exception e){
		e.printStackTrace();
 	} finally {
		closeResultSet( resultSet ) ;
		closeStatement(pstmt);
	}
	
	return order_status_code;

}

/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify( HashMap tabData, HashMap sqlMap ) {

		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap delete( HashMap tabData, HashMap sqlMap ) {

		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}
	// Check For Null and If value is there return it, other wise return the default value..
	private String checkForNull( String inputString, String defaultValue)
	{
	    return ( inputString == null || inputString.equals("") )?defaultValue : inputString;
    }
	
}

