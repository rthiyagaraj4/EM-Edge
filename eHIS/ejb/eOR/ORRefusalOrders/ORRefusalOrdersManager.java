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
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
09/09/2011   IN27555  		 Menaka		 IN27555  	<CA Record Refusal>New Refusal
													> After record refusal system display message “refusal content is not confirm. confirmed before continue” >		
12/12/2011    IN029211       Chowminya G    Incident No: IN029211 - <‘Record Refusal’ of order set then view ‘Existing Refusal’ system show only 1 order with multiple line> 
24/09/2012    IN034904       Chowminya G     CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record 			    Refusal			  											
18/01/2013	  IN037372		Ramesh G		Oracle 11g Weblogic compilation.
24/08/2013    IN030284	 	 Chowminya G 	CRF:To capture Pre-consultation orders in Appointment Scheduling														
30/12/2020	  8882			 Nijitha S		30/12/2020		Ramesh G		ML-MMOH-CRF-1571-US001														
---------------------------------------------------------------------------------------------------------------
*/ 
package eOR.ORRefusalOrders ;

import java.rmi.* ;
import java.util.* ;
import java.io.*;
import java.sql.* ;
//import oracle.sql.CLOB;
import javax.ejb.* ;

import eOR.Common.* ;


import javax.transaction.* ;

/**
*
* @ejb.bean
*	name="ORRefusalOrders"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORRefusalOrders"
*	local-jndi-name="ORRefusalOrders"
*	impl-class-name="eOR.ORRefusalOrders.ORRefusalOrdersManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORRefusalOrders.ORRefusalOrdersLocal"
*	remote-class="eOR.ORRefusalOrders.ORRefusalOrdersRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORRefusalOrders.ORRefusalOrdersLocalHome"
*	remote-class="eOR.ORRefusalOrders.ORRefusalOrdersHome"
*	generate= "local,remote"
*
*
*/

public class ORRefusalOrdersManager extends OrEJBSessionAdapter 
{
  //  SessionContext context ;

/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap insert( HashMap tabData, HashMap sqlMap ) 
	{
//System.out.println("####tabData="+tabData);
		Connection connection = null ;
		PreparedStatement pstmt_select= null ;
		PreparedStatement pstmt_select1=null;
		PreparedStatement pstmt_insert=null;
		PreparedStatement pstmt_update_reason = null;
		//PreparedStatement pstmt_update_reason_top = null;
		//PreparedStatement pstmt_duplicate	 = null;
		PreparedStatement pstmt_sel_consent=null;//--[IN034904]
		PreparedStatement pstmt_update1=null;
		PreparedStatement pstmt_update2=null;
		PreparedStatement pstmt_update = null;
//		PreparedStatement pstmt_can_billing = null;//8882 //Checkstyle
		ResultSet rset = null;
		ResultSet resultSet=null;
		ResultSet res = null;
		ResultSet rset_consent = null;//--[IN034904]

		StringBuffer traceVals = new StringBuffer();
		
		HashMap NoOfRecords = new HashMap();
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;

		//Hashtable printValues 	= new Hashtable() ;
		//int printCount 			= 0;

		String srlno="";
		//int result=0;
		int result1=0;
		int result2=0;
		//int result3=0;
		int counter=0;
		int t = 0;
		int result123[] = {};
		int result234[] = {};
/////////////////////////////////////////////
	//Values going to be returned to bean
/////////////////////////////////////////////
		int  total_records = 0;
		String order_id[] = {};
		String order_line_number[] = {};
		String order_type_code[] = {};
		String priority[] = {};
		String facility_id[] = {};
		String location_type[] = {};
		String location_code[] = {};
		String patient_id[] = {};
		String srl_no[] = {};
		String consent_val_chk = "";
/////////////////////////////////////////////
		String new_ord_num="";
		String hdr_code = "";
		String sql="";
		String ord_id="";
		StringTokenizer StrTokenCode = null;
		StringTokenizer StrTokenDesc = null;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "" ) ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		
		final String SQL_OR_REFUSAL_ORDER_SRL_NO  = (String) sqlMap.get( "SelectSQL" ) ;
		final String SQL_OR_REFUSAL_ORDER_INSERT = (String) sqlMap.get( "InsertSQL" );
		final String SQL_OR_ORDER_ENTRY_REFUSAL_CANCEL=(String) sqlMap.get("UpdateSQL");
		final String SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT=(String) sqlMap.get( "SelectSQL1" ) ;
		final String SQL_OR_ORDER_ENTRY_CANCEL_LINE2=(String) sqlMap.get("SelectSQL2");
		final String SQL_OR_ORDER_ENTRY_CANCEL_LINE3= (String) sqlMap.get("SelectSQL3");
		final String SQL_OR_REFUSAL_ORDER_CLOB= (String) sqlMap.get("SQL_OR_REFUSAL_ORDER_CLOB");
		final String SQL_OR_PLACE_ORDER_BILL_YN= (String) sqlMap.get("SQL_OR_PLACE_ORDER_BILL_YN");//8882

			//ArrayList newinsert=new ArrayList();
		traceVals.append("from first block");
		
		ArrayList insertData=(ArrayList) tabData.get("InsertData");
		
		Properties pt = (Properties)tabData.get( "properties" ) ;
		//IN030284 -Starts included if condition else block has the actual code
		if(((String)tabData.get("source")).equals("Appt_orders"))
		{
			map = insertOAData( tabData, sqlMap );
		}
		else 
		{ //IN030284 - Ends	
			if(insertData!=null)					
			{
				try
				{
					connection = getConnection(pt) ;
					connection.setAutoCommit( false ) ;
	
					traceVals.append("Inside If loop");
					String patientid=(String) insertData.get(0);
	
					pstmt_select= connection.prepareStatement(SQL_OR_REFUSAL_ORDER_SRL_NO);
					pstmt_select.setString(1,patientid);
					rset=pstmt_select.executeQuery();
					traceVals.append("result set value in select statement");
							
					while(rset != null && rset.next())
					{					
						srlno=rset.getString(1);
					}
	
					if(srlno==null || srlno.equals("null"))
					{								
						srlno="1";
					}
							
					pstmt_insert=connection.prepareStatement(SQL_OR_REFUSAL_ORDER_INSERT);
					traceVals.append("Insert Statement and srlno"+srlno);
					pstmt_update_reason=connection.prepareStatement(SQL_OR_ORDER_ENTRY_REFUSAL_CANCEL);
					pstmt_update = connection.prepareStatement(SQL_OR_REFUSAL_ORDER_CLOB);
					consent_val_chk = (String)insertData.get(26);//--[IN034904]
					
					ArrayList store_line_no=new ArrayList();
					if(!((String)insertData.get(7)).equals(""))
					{
						StringTokenizer st1=new StringTokenizer(((String)insertData.get(7)),":$#");
						while(st1.hasMoreElements())
						{
							store_line_no.add((String)st1.nextToken());
							counter=counter+1;
						}
					}
					
					if((store_line_no.size() >0) && (consent_val_chk.equals("")))
					{
	 					total_records = store_line_no.size();
				
						order_id = new String[total_records];
						order_line_number = new String[total_records];
						order_type_code = new String[total_records];
						priority = new String[total_records];
						facility_id = new String[total_records];
						location_type = new String[total_records];
						location_code = new String[total_records];
						patient_id = new String[total_records];
						srl_no = new String[total_records];
						for(int p=0;p<total_records;p++)
						{
							order_id[p] = (String)insertData.get(6);
							patient_id[p] = (String)insertData.get(0);
							facility_id[p] = (String)insertData.get(2);
							location_code[p] = (String)insertData.get(22);
							location_type[p] = (String)insertData.get(23);
							order_type_code[p] = (String)insertData.get(24);
							priority[p] = (String)insertData.get(25);
						}
								
	
						traceVals.append("Insert Statement and srlno"+store_line_no);
				
						String ord_line_num = "";
						StringTokenizer ST = null;
	
						StrTokenCode = new StringTokenizer((String)insertData.get(8),",");//--[IN029211]
						StrTokenDesc = new StringTokenizer((String)insertData.get(9),",");//--[IN029211]
						
						for(int i=0;i<store_line_no.size();i++)
						{
		
							ord_line_num =(String)store_line_no.get(i);
		
							ST = new StringTokenizer(ord_line_num,":$#");
							ord_line_num = ST.nextToken();
	
							order_line_number[i] = ord_line_num;
		
							int srlno1=Integer.parseInt(srlno)+i;
							traceVals.append("Inside for loop");
							
							if(StrTokenCode.hasMoreTokens())
							{
	 
							//while(StrTokenCode.hasMoreTokens())
							//{
								pstmt_insert.setString(1,(String)insertData.get(0));
								pstmt_insert.setString(2,(String)Integer.toString(srlno1));
								pstmt_insert.setString(3,(String)insertData.get(2));
								pstmt_insert.setString(4,(String)insertData.get(3));
								pstmt_insert.setString(5,(String)insertData.get(4));
								pstmt_insert.setString(6,(String)insertData.get(5));
								pstmt_insert.setString(7,(String)insertData.get(6));
								pstmt_insert.setString(8,ord_line_num);
								String token1 = (String )StrTokenCode.nextToken();
								String token2 = (String )StrTokenDesc.nextToken();
	
								pstmt_insert.setString(9,token1);
								pstmt_insert.setString(10,token2);
								pstmt_insert.setString(11,(String)insertData.get(10));
								pstmt_insert.setString(12,(String)insertData.get(11));
								pstmt_insert.setString(13,(String)insertData.get(12));
								pstmt_insert.setString(14,(String)insertData.get(13));
	
								pstmt_insert.setString(15,(String)insertData.get(14));
								pstmt_insert.setString(16,(String)insertData.get(15));
								pstmt_insert.setString(17,(String)insertData.get(16));
								//for insert modified date
								pstmt_insert.setString(18,(String)insertData.get(17));
								pstmt_insert.setString(19,(String)insertData.get(18));
					
								pstmt_insert.setString(20,(String)insertData.get(20));
							
								//result=pstmt_insert.executeUpdate();
								pstmt_insert.addBatch();
	
								/*printValues.put("patient_id"+printCount,(String)insertData.get(0));
								printValues.put("order_id"+printCount,(String)insertData.get(6));
								printValues.put("order_line_num"+printCount,ord_line_num);
								printValues.put("order_type_code"+printCount,(String)insertData.get(24));
								printValues.put("patient_class"+printCount,(String)insertData.get(4));
								printValues.put("priority"+printCount,(String)insertData.get(25));
								printValues.put("facility_id"+printCount,(String)insertData.get(2));
								printValues.put("location_type"+printCount,(String)insertData.get(23));
								printValues.put("location_code"+printCount,(String)insertData.get(22));
								printValues.put("srl_no"+printCount,Integer.toString(srlno1));
								printCount++;*/
	
							//}//end of while of tokenizer
							}//end of if
							else
							{
								pstmt_insert.setString(1,(String)insertData.get(0));
								pstmt_insert.setString(2,(String)Integer.toString(srlno1));
								pstmt_insert.setString(3,(String)insertData.get(2));
								pstmt_insert.setString(4,(String)insertData.get(3));
								pstmt_insert.setString(5,(String)insertData.get(4));
								pstmt_insert.setString(6,(String)insertData.get(5));
								pstmt_insert.setString(7,(String)insertData.get(6));
								pstmt_insert.setString(8,ord_line_num);
								pstmt_insert.setString(9,(String)insertData.get(8));
								pstmt_insert.setString(10,(String)insertData.get(9));
								pstmt_insert.setString(11,(String)insertData.get(10));
								pstmt_insert.setString(12,(String)insertData.get(11));
								pstmt_insert.setString(13,(String)insertData.get(12));
								pstmt_insert.setString(14,(String)insertData.get(13));
								pstmt_insert.setString(15,(String)insertData.get(14));
								pstmt_insert.setString(16,(String)insertData.get(15));
								pstmt_insert.setString(17,(String)insertData.get(16));
								//for insert modified date
								pstmt_insert.setString(18,(String)insertData.get(17));
								pstmt_insert.setString(19,(String)insertData.get(18));
								
								pstmt_insert.setString(20,(String)insertData.get(20));
								pstmt_insert.addBatch();
	
								/*printValues.put("patient_id"+printCount,(String)insertData.get(0));
								printValues.put("order_id"+printCount,(String)insertData.get(6));
								printValues.put("order_line_num"+printCount,ord_line_num);
								printValues.put("order_type_code"+printCount,(String)insertData.get(24));
								printValues.put("patient_class"+printCount,(String)insertData.get(4));
								printValues.put("priority"+printCount,(String)insertData.get(25));
								printValues.put("facility_id"+printCount,(String)insertData.get(2));
								printValues.put("location_type"+printCount,(String)insertData.get(23));
								printValues.put("location_code"+printCount,(String)insertData.get(22));
								printValues.put("srl_no"+printCount,Integer.toString(srlno1));
								printCount++;*/
							}
						
							result123 = pstmt_insert.executeBatch();
						
	
							String getSysDate=(String)insertData.get(19);
							pstmt_update_reason.setString(1,"99");
							pstmt_update_reason.setString(2,(String)insertData.get(10));//11
							pstmt_update_reason.setString(3,(String)insertData.get(12));//13
							pstmt_update_reason.setString(4,getSysDate);
							pstmt_update_reason.setString(5,getSysDate);
							pstmt_update_reason.setString(6,null);
							pstmt_update_reason.setString(7,null);
							pstmt_update_reason.setString(8,null);
							pstmt_update_reason.setString(9,null);
							pstmt_update_reason.setString(10,null);
							pstmt_update_reason.setString(11,null);
							pstmt_update_reason.setString(12,null);							
							pstmt_update_reason.setString(13,((String)insertData.get(16)));									
							pstmt_update_reason.setString(14,((String)insertData.get(17)));									
							pstmt_update_reason.setString(15,((String)insertData.get(18)));
							pstmt_update_reason.setString(16,(String)insertData.get(6));
							pstmt_update_reason.setString(17,ord_line_num);
					
							result1=pstmt_update_reason.executeUpdate();
										
										
	
						//Updating the Refusal Content
						pstmt_update.setString(1,(String)insertData.get(0));
	
						pstmt_update.setString(2,(String)Integer.toString(srlno1));
	
						String consent_content = (String)insertData.get(21);
					
	
						res = pstmt_update.executeQuery();
				
						while(res != null && res.next())
						{
							//Web logic Conversion -- [IN037372] Start.
							//CLOB clb = (CLOB)res.getClob("refusal_form_content");
							//BufferedWriter bw   = new BufferedWriter(clb.getCharacterOutputStream());
							
							java.sql.Clob clb = (java.sql.Clob)res.getClob("refusal_form_content");
							BufferedWriter bw   = new BufferedWriter(clb.setCharacterStream(0));
							//Web logic Conversion -- [IN037372] End.
							bw.write(consent_content,0,consent_content.length());
							bw.flush();
							bw.close();
	
						}
						closeResultSet(res);
	
						traceVals.append("from end updation block 11111");
						ord_id=(String)insertData.get(6);
						new_ord_num=new_ord_num+"'"+ord_line_num+"',";
	
	
					}
	  				
					if(result123.length > 0 && result1>0)
					{//p1
						int n=new_ord_num.length();
						new_ord_num=new_ord_num.substring(0,n-1);
						traceVals.append("The String val:"+new_ord_num);
	
	
	
						t= SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT.lastIndexOf("?");
						sql  = SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT.substring(0,t) + new_ord_num.trim() + SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT.substring(t+1)  ;
	
						pstmt_select1= connection.prepareStatement(sql);
						pstmt_select1.setString( 1,ord_id) ;
						resultSet = pstmt_select1.executeQuery();
	
						while(resultSet != null && resultSet.next() )
						{			// Returns one record
							hdr_code = resultSet.getString("order_line_status");
							if(hdr_code==null) hdr_code = "";
							traceVals.append("From result:");
						}
						
						if( !hdr_code.equals("")) 
						{
	
							result2=0;
							pstmt_update1 = connection.prepareStatement( SQL_OR_ORDER_ENTRY_CANCEL_LINE2) ;
							pstmt_update1.setString(1, hdr_code) ;
							pstmt_update1.setString(2,((String)insertData.get(16)));
							pstmt_update1.setString(3,((String)insertData.get(17)));						
							pstmt_update1.setString(4,((String)insertData.get(18)));
							pstmt_update1.setString(5, ord_id ) ;
	
							result2 = pstmt_update1.executeUpdate();
					}
					else
					{
						result2=0;
						pstmt_update2 = connection.prepareStatement(SQL_OR_ORDER_ENTRY_CANCEL_LINE3) ;
						pstmt_update2.setString(1, "99") ; // cancel code
						pstmt_update2.setString(2,(String)insertData.get(13));
						pstmt_update2.setString(3,(String)insertData.get(14));
						pstmt_update2.setString(4,(String)insertData.get(15));
						pstmt_update2.setString(5, ord_id) ;
						result2 = pstmt_update2.executeUpdate();
	
							traceVals.append("From Second:"+result2);
					}
						
					callBilling(connection, ord_id, SQL_OR_PLACE_ORDER_BILL_YN, insertData, ord_line_num);//8882
					
	
		}//p1
	
				}//--[IN034904]- Start
				else if(!consent_val_chk.equals(""))
				{
					String[] record				= null;
					ArrayList ConsentDtls		= new ArrayList();
					String ord_id_val 			= "";
					String pat_id_val 			= "";
					ord_id_val 					= (String)insertData.get(6);
					pat_id_val 					= (String)insertData.get(0);
					int srl_no1					= 0;
					
					pstmt_sel_consent = connection.prepareStatement("select ORDER_CATALOG_CODE,CATALOG_DESC,ORDER_LINE_NUM from or_order_line where order_id= ?") ;
					pstmt_sel_consent.setString( 1, ord_id_val);
						
					rset_consent = pstmt_sel_consent.executeQuery() ;
	
					while( rset_consent != null && rset_consent.next() ) 
					{
						record	  = new String[3];
						record[0] = rset_consent.getString("ORDER_CATALOG_CODE");
						record[1] = rset_consent.getString("CATALOG_DESC");
						record[2] = rset_consent.getString("ORDER_LINE_NUM");
						ConsentDtls.add(record)  ;
					}
					
					pstmt_sel_consent = connection.prepareStatement("Select nvl(max(SRL_NO),0) srl_no from OR_REFUSAL_ORDERABLE where patient_id = ?") ;
					pstmt_sel_consent.setString( 1, pat_id_val);
						
					rset_consent = pstmt_sel_consent.executeQuery() ;
	
					while( rset_consent != null && rset_consent.next() ) 
					{
						srl_no1 = Integer.valueOf(rset_consent.getString("srl_no"));
					}
		
					for(int i=0;i<ConsentDtls.size();i++)
					{
						srl_no1 = srl_no1+1;
						String[] record1 = (String[])ConsentDtls.get(i);
						
						pstmt_insert.setString(1,(String)insertData.get(0));
						pstmt_insert.setString(2,(String)Integer.toString(srl_no1));
						pstmt_insert.setString(3,(String)insertData.get(2));
						pstmt_insert.setString(4,(String)insertData.get(3));
						pstmt_insert.setString(5,(String)insertData.get(4));
						pstmt_insert.setString(6,(String)insertData.get(5));
						pstmt_insert.setString(7,(String)insertData.get(6));
						pstmt_insert.setString(8,(String)record1[2]);
						pstmt_insert.setString(9,(String)record1[0]);
						pstmt_insert.setString(10,(String)record1[1] );
						pstmt_insert.setString(11,(String)insertData.get(10));
						pstmt_insert.setString(12,(String)insertData.get(11));
						pstmt_insert.setString(13,(String)insertData.get(12));
						pstmt_insert.setString(14,(String)insertData.get(13));
						pstmt_insert.setString(15,(String)insertData.get(14));
						pstmt_insert.setString(16,(String)insertData.get(15));
						pstmt_insert.setString(17,(String)insertData.get(16));
						pstmt_insert.setString(18,(String)insertData.get(17));
						pstmt_insert.setString(19,(String)insertData.get(18));			
						pstmt_insert.setString(20,(String)insertData.get(20));
						pstmt_insert.addBatch();						
						
						result123 = pstmt_insert.executeBatch();
						
	
						String getSysDate=(String)insertData.get(19);
						pstmt_update_reason.setString(1,"99");
						pstmt_update_reason.setString(2,(String)insertData.get(10));//11
						pstmt_update_reason.setString(3,(String)insertData.get(12));//13
						pstmt_update_reason.setString(4,getSysDate);
						pstmt_update_reason.setString(5,getSysDate);
						pstmt_update_reason.setString(6,null);
						pstmt_update_reason.setString(7,null);
						pstmt_update_reason.setString(8,null);
						pstmt_update_reason.setString(9,null);
						pstmt_update_reason.setString(10,null);
						pstmt_update_reason.setString(11,null);
						pstmt_update_reason.setString(12,null);							
						pstmt_update_reason.setString(13,((String)insertData.get(16)));									
						pstmt_update_reason.setString(14,((String)insertData.get(17)));									
						pstmt_update_reason.setString(15,((String)insertData.get(18)));
						pstmt_update_reason.setString(16,(String)insertData.get(6));
						pstmt_update_reason.setString(17,record1[2]);
					
						result1=pstmt_update_reason.executeUpdate();
										
										
	
						//Updating the Refusal Content
						pstmt_update.setString(1,(String)insertData.get(0));
	
						pstmt_update.setString(2,(String)Integer.toString(srl_no1));
	
						String consent_content = (String)insertData.get(21);
					
	
						res = pstmt_update.executeQuery();
				
						while(res != null && res.next())
						{
						//Web logic Conversion -- [IN037372] Start.
							//CLOB clb = (CLOB)res.getClob("refusal_form_content");
							//BufferedWriter bw   = new BufferedWriter(clb.getCharacterOutputStream());
							
							java.sql.Clob clb = (java.sql.Clob)res.getClob("refusal_form_content");
							BufferedWriter bw   = new BufferedWriter(clb.setCharacterStream(0));
						//Web logic Conversion -- [IN037372] End.	
							bw.write(consent_content,0,consent_content.length());
							bw.flush();
							bw.close();
	
						}
						closeResultSet(res);
	
						ord_id=(String)insertData.get(6);
						new_ord_num=new_ord_num+"'"+record1[2]+"',";
					}
	  				
					if(result123.length > 0 && result1>0)
					{
						int n=new_ord_num.length();
						new_ord_num=new_ord_num.substring(0,n-1);
						traceVals.append("The String val:"+new_ord_num);
	
	
	
						t= SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT.lastIndexOf("?");
						sql  = SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT.substring(0,t) + new_ord_num.trim() + SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT.substring(t+1)  ;
			
						pstmt_select1= connection.prepareStatement(sql);
						pstmt_select1.setString( 1,ord_id) ;
						resultSet = pstmt_select1.executeQuery();
	
						while(resultSet != null && resultSet.next() )
						{			// Returns one record
							hdr_code = resultSet.getString("order_line_status");
							if(hdr_code==null) hdr_code = "";
						}
						
						if( !hdr_code.equals("")) 
						{
	
							result2=0;
							pstmt_update1 = connection.prepareStatement( SQL_OR_ORDER_ENTRY_CANCEL_LINE2) ;
							pstmt_update1.setString(1, hdr_code) ;
							pstmt_update1.setString(2,((String)insertData.get(16)));
							pstmt_update1.setString(3,((String)insertData.get(17)));						
							pstmt_update1.setString(4,((String)insertData.get(18)));
							pstmt_update1.setString(5, ord_id ) ;
	
							result2 = pstmt_update1.executeUpdate();
						}
						else
						{
							result2=0;
							pstmt_update2 = connection.prepareStatement(SQL_OR_ORDER_ENTRY_CANCEL_LINE3) ;
							pstmt_update2.setString(1, "99") ; // cancel code
							pstmt_update2.setString(2,(String)insertData.get(13));
							pstmt_update2.setString(3,(String)insertData.get(14));
							pstmt_update2.setString(4,(String)insertData.get(15));
							pstmt_update2.setString(5, ord_id) ;
							result2 = pstmt_update2.executeUpdate();
						}
	
					
					}
				}//--[IN034904] - End
				else
				{
					
					total_records = store_line_no.size();
					
					traceVals.append("Inside for loop else block");
					StrTokenCode = new StringTokenizer((String)insertData.get(8),",");
					StrTokenDesc = new StringTokenizer((String)insertData.get(9),",");
	
					if(StrTokenCode.hasMoreTokens())
					{
						pstmt_insert.setString(1,(String)insertData.get(0));
						pstmt_insert.setString(2,srlno);
						pstmt_insert.setString(3,(String)insertData.get(2));
						pstmt_insert.setString(4,(String)insertData.get(3));
						pstmt_insert.setString(5,(String)insertData.get(4));
						pstmt_insert.setString(6,(String)insertData.get(5));
						pstmt_insert.setString(7,(String)insertData.get(6));
						pstmt_insert.setString(8,(String)insertData.get(7));
						String token1 = (String )StrTokenCode.nextToken();
						String token2 = (String )StrTokenDesc.nextToken();
						pstmt_insert.setString(9,token1);
						pstmt_insert.setString(10,token2);
						pstmt_insert.setString(11,(String)insertData.get(10));
						pstmt_insert.setString(12,(String)insertData.get(11));
						pstmt_insert.setString(13,(String)insertData.get(12));
						pstmt_insert.setString(14,(String)insertData.get(13));
	
						pstmt_insert.setString(15,(String)insertData.get(14));
						pstmt_insert.setString(16,(String)insertData.get(15));
						pstmt_insert.setString(17,(String)insertData.get(16));
						//for insert modified date
						pstmt_insert.setString(18,(String)insertData.get(17));
						pstmt_insert.setString(19,(String)insertData.get(18));
	
						pstmt_insert.setString(20,(String)insertData.get(20));
						pstmt_insert.addBatch();
	
						/*printValues.put("patient_id"+printCount,(String)insertData.get(0));
						printValues.put("order_id"+printCount,(String)insertData.get(6));
						printValues.put("order_line_num"+printCount,(String)insertData.get(7));
						printValues.put("order_type_code"+printCount,(String)insertData.get(24));
						printValues.put("patient_class"+printCount,(String)insertData.get(4));
						printValues.put("priority"+printCount,(String)insertData.get(25));
						printValues.put("facility_id"+printCount,(String)insertData.get(2));
						printValues.put("location_type"+printCount,(String)insertData.get(23));
						printValues.put("location_code"+printCount,(String)insertData.get(22));
						printValues.put("srl_no"+printCount,srlno);
						printCount++;*/
					}//end of if tokenizer
					else
					{
						pstmt_insert.setString(1,(String)insertData.get(0));
						pstmt_insert.setString(2,srlno);
						pstmt_insert.setString(3,(String)insertData.get(2));
						pstmt_insert.setString(4,(String)insertData.get(3));
						pstmt_insert.setString(5,(String)insertData.get(4));
						pstmt_insert.setString(6,(String)insertData.get(5));
						pstmt_insert.setString(7,(String)insertData.get(6));
						pstmt_insert.setString(8,(String)insertData.get(7));
						pstmt_insert.setString(9,(String)insertData.get(8));
						pstmt_insert.setString(10,(String)insertData.get(9));
						pstmt_insert.setString(11,(String)insertData.get(10));
						pstmt_insert.setString(12,(String)insertData.get(11));
						pstmt_insert.setString(13,(String)insertData.get(12));
						pstmt_insert.setString(14,(String)insertData.get(13));
	
						pstmt_insert.setString(15,(String)insertData.get(14));
						pstmt_insert.setString(16,(String)insertData.get(15));
						pstmt_insert.setString(17,(String)insertData.get(16));
						//for insert modified date
						pstmt_insert.setString(18,(String)insertData.get(17));
						pstmt_insert.setString(19,(String)insertData.get(18));
	
		
						pstmt_insert.setString(20,(String)insertData.get(20));
						pstmt_insert.addBatch();
	
						/*printValues.put("patient_id"+printCount,(String)insertData.get(0));
						printValues.put("order_id"+printCount,(String)insertData.get(6));
						printValues.put("order_line_num"+printCount,(String)insertData.get(7));
						printValues.put("order_type_code"+printCount,(String)insertData.get(24));
						printValues.put("patient_class"+printCount,(String)insertData.get(4));
						printValues.put("priority"+printCount,(String)insertData.get(25));
						printValues.put("facility_id"+printCount,(String)insertData.get(2));
						printValues.put("location_type"+printCount,(String)insertData.get(23));
						printValues.put("location_code"+printCount,(String)insertData.get(22));
						printValues.put("srl_no"+printCount,srlno);
						printCount++;*/
					}
							
					result234 = pstmt_insert.executeBatch();
	
						//Updating the Refusal Content
					pstmt_update.setString(1,(String)insertData.get(0));
						
					pstmt_update.setString(2,srlno);
						
	
					String consent_content = (String)insertData.get(21);
						
					res = pstmt_update.executeQuery();
						
					while(res != null && res.next())
					{
					//Web logic Conversion -- [IN037372] Start.
						//CLOB clb = (CLOB)res.getClob("refusal_form_content");
						//BufferedWriter bw   = new BufferedWriter(clb.getCharacterOutputStream());
						
						java.sql.Clob clb = (java.sql.Clob)res.getClob("refusal_form_content");
						BufferedWriter bw   = new BufferedWriter(clb.setCharacterStream(0));					
					//Web logic Conversion -- [IN037372] End.	
						
						bw.write(consent_content,0,consent_content.length());
						bw.flush();
						bw.close();
							
					}
	
				}
	
										//if ( result < 1 && result1<1 && result2<1) {
				if ( result234.length <0 && result1<1 && result2<1) 
				{
					connection.rollback() ;
					messages.append( "Insert Failed" ) ;
				}
				else
				{
					connection.commit() ;
					map.put( "result", new Boolean( true ) ) ;
					//printValues.put("total_records",Integer.toString(printCount));
					//map.put("printValues",printValues);
					//map.put( "message", "Operation Completed Successfully..." ) ;
					messages.append( "RECORD_INSERTED" ) ;
	
				}
			}catch(Exception e)
			{
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally
			{
				try
				{
																	
					closeResultSet(res);
					closeResultSet(rset);
					closeResultSet(resultSet);
					closeResultSet(rset_consent);//--[IN034904]
					closeStatement(pstmt_select);
					closeStatement(pstmt_insert);
					closeStatement(pstmt_update_reason);
					closeStatement(pstmt_update);
					closeStatement(pstmt_select1);
					closeStatement(pstmt_update1);
					closeStatement(pstmt_update2);
					closeStatement(pstmt_sel_consent);//--[IN034904]
					if(connection != null) 
					{
						closeConnection( connection, pt );
					}
	
				}
				catch(Exception e)
				{
					messages.append( e.getMessage() ) ;
				}
	
			}
		}//end of if loop
			
	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVals.toString() ) ;

	NoOfRecords.put("total_records",String.valueOf(total_records));
	NoOfRecords.put("order_id",order_id);
	NoOfRecords.put("order_line_num",order_line_number);
	NoOfRecords.put("order_type_code",order_type_code);
	NoOfRecords.put("priority",priority);
	NoOfRecords.put("facility_id",facility_id);
	NoOfRecords.put("location_code",location_code);
	NoOfRecords.put("location_type",location_type);
	NoOfRecords.put("patient_id",patient_id);
	NoOfRecords.put("srl_no",srl_no);

	map.put( "NoOfRecords",NoOfRecords);
	}//IN030284 - end of else
	//System.out.println("###in ejb,map="+map);
	return map;
}
//8882 Starts	
private void callBilling(Connection connection, String ord_id, final String SQL_OR_PLACE_ORDER_BILL_YN,
		ArrayList insertData, String ord_line_num) throws SQLException {
	PreparedStatement pstmt_can_billing;
	String bill_yn = "";
	String cont_order_ind = "";
	String p_error_code="";
	String p_sys_message_id="";
	String p_err_text="";
	String p_subs_module_id = "";
	String p_subs_regn_num="";
	String p_subs_regn_line_num = "";
	String cancel_allow_yn = "";
	pstmt_can_billing= connection.prepareStatement(SQL_OR_PLACE_ORDER_BILL_YN);
	pstmt_can_billing.setString(1, ord_id);
	pstmt_can_billing.setString(2, ord_line_num);
	ResultSet rsbilling = pstmt_can_billing.executeQuery();
	while(rsbilling.next()){
		bill_yn = rsbilling.getString("BILL_YN");
		cont_order_ind = rsbilling.getString("cont_order_ind");
	}
	//Checkstyle Start.
	if(rsbilling!=null)
		rsbilling.close();
	if(pstmt_can_billing!=null)
		pstmt_can_billing.close();
	//Checkstyle end.
	if("Y".equals(bill_yn))
	{	
		if((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))
		{
			CallableStatement cstmt_freq_order 	= null;
			cstmt_freq_order = connection.prepareCall("{call OR_FREQ_ORD_CAN_DIS(?,?,?,?,?,?,?,?,?,?) }");
			
			cstmt_freq_order.setString(1, ord_id);										// P_ORDER_ID
			cstmt_freq_order.setString(2, ord_line_num);						    // P_ORDER_LINE_NUM
			cstmt_freq_order.setString(3, (String)insertData.get(15));									    // P_FACILITY_ID
			cstmt_freq_order.setString(4, "CAN");									    // P_mode
			cstmt_freq_order.setString(5, (String)insertData.get(13));									    // P_login_id
			cstmt_freq_order.setString(6, (String)insertData.get(14));									    // P_ws_no
			cstmt_freq_order.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_PRINT_YN
			cstmt_freq_order.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERR_CODE
			cstmt_freq_order.registerOutParameter( 9,  Types.VARCHAR ) ; 	// P_SYS_MESSAGE_ID
			cstmt_freq_order.registerOutParameter( 10,  Types.VARCHAR ) ; 	// P_ERROR_TEXT					
			cstmt_freq_order.execute();

			
			 p_error_code	= cstmt_freq_order.getString(8)==null?"":cstmt_freq_order.getString(8);				// P_ERR_CODE
			 p_sys_message_id	= cstmt_freq_order.getString(9)==null?"":cstmt_freq_order.getString(9);		// P_SYS_MESSAGE_ID
			 p_err_text	= cstmt_freq_order.getString(10)==null?"":cstmt_freq_order.getString(10);
			//Checkstyle Start.
			if(cstmt_freq_order!=null)
				cstmt_freq_order.close();
			//Checkstyle End.								
		}
		else{
			try
			{
				CallableStatement cstmt_sub_module_dtls 	= null;
				CallableStatement cstmt_cancel_allow_yn 	= null;
				cstmt_sub_module_dtls			= connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_SEC_KEY_FOR_PRIM_KEY(?,?,?,?,?,?,?,?,?) }");
				cstmt_sub_module_dtls.setString(1,(String)insertData.get(15));									    // P_FACILITY_ID
				cstmt_sub_module_dtls.setString(2, ord_id);										// P_ORDER_ID
				cstmt_sub_module_dtls.setString(3, ord_line_num);						    // P_ORDER_LINE_NUM
				cstmt_sub_module_dtls.registerOutParameter( 4,  Types.VARCHAR ) ; 	// P_SUBS_MODULE_ID
				cstmt_sub_module_dtls.registerOutParameter( 5,  Types.VARCHAR ) ; 	// P_SUBS_REGN_NUM
				cstmt_sub_module_dtls.registerOutParameter( 6,  Types.VARCHAR ) ; 	// P_SUBS_REGN_LINE_NUM
				cstmt_sub_module_dtls.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_ERR_CODE
				cstmt_sub_module_dtls.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_SYS_MESSAGE_ID	
				cstmt_sub_module_dtls.registerOutParameter( 9,  Types.VARCHAR ) ; 	// P_ERROR_TEXT
				cstmt_sub_module_dtls.execute();
				p_subs_module_id	= cstmt_sub_module_dtls.getString(4);						// P_SUBS_MODULE_ID
				p_subs_regn_num	= cstmt_sub_module_dtls.getString(5);						    // P_SUBS_REGN_NUM
				p_subs_regn_line_num	= cstmt_sub_module_dtls.getString(6);				    // P_SUBS_REGN_LINE_NUM
				p_error_code	= cstmt_sub_module_dtls.getString(7);				                    // P_ERR_CODE
				p_sys_message_id	= cstmt_sub_module_dtls.getString(8);				        // P_SYS_MESSAGE_ID
				p_err_text	= cstmt_sub_module_dtls.getString(9);				                    // P_ERROR_TEXT
				//Checkstyle Start.
				if(cstmt_sub_module_dtls!=null)
					cstmt_sub_module_dtls.close();
				//Checkstyle end.
				if((p_error_code!=null && p_error_code!="null" && !p_error_code.equals(""))&&(p_sys_message_id!=null && p_sys_message_id!="null" && !p_sys_message_id.equals("")))
				{
				}
				else
				{
					cstmt_cancel_allow_yn = connection.prepareCall("{ ? = call  BL_PROC_ITEM_VALIDATIONS_MP.IS_CANCEL_ORDER_ALLOWED_YN(?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt_cancel_allow_yn.registerOutParameter(1,java.sql.Types.VARCHAR);
			   		cstmt_cancel_allow_yn.setString(2,(String)insertData.get(15));
			   		cstmt_cancel_allow_yn.setString(3,"OR|CA");
					cstmt_cancel_allow_yn.setString(4,ord_id);
					cstmt_cancel_allow_yn.setString(5,ord_line_num.trim());
					cstmt_cancel_allow_yn.setString(6,p_subs_module_id);
					cstmt_cancel_allow_yn.setString(7,p_subs_regn_num);
					cstmt_cancel_allow_yn.setString(8,p_subs_regn_line_num);
					cstmt_cancel_allow_yn.registerOutParameter(9,java.sql.Types.VARCHAR);
					cstmt_cancel_allow_yn.registerOutParameter(10,java.sql.Types.VARCHAR);
					cstmt_cancel_allow_yn.registerOutParameter(11,java.sql.Types.VARCHAR);
					cstmt_cancel_allow_yn.registerOutParameter(12,java.sql.Types.VARCHAR);
				   	cstmt_cancel_allow_yn.execute();							
					cancel_allow_yn = cstmt_cancel_allow_yn.getString(1);	
					//print_report_yn = cstmt_cancel_allow_yn.getString(9);	
					p_error_code = cstmt_cancel_allow_yn.getString(10);	
				
					p_err_text = cstmt_cancel_allow_yn.getString(12);	
					//Checkstyle Start.
					if(cstmt_cancel_allow_yn!=null)
						cstmt_cancel_allow_yn.close();
					//Checkstyle End.
			  	}			
			
				p_error_code = (p_error_code==null)?"":p_error_code;
				p_err_text = (p_err_text==null)?"":p_err_text;
				cancel_allow_yn = (cancel_allow_yn==null)?"":cancel_allow_yn;
				if("Y".equals(cancel_allow_yn))
					cancelOrderBilling(connection, (String)insertData.get(15), ord_id, ord_line_num, (String)insertData.get(13), (String)insertData.get(14), "Y");
			}
			catch(Exception ce)
			{
				ce.printStackTrace();
			}
			
		}
		
	}
	//8882 Ends
}
/**
* @ejb.interface-method
*	 view-type="both"
*/
public HashMap modify( HashMap map, HashMap sqlMap ) 
{
	return map; 
}
/**
* @ejb.interface-method
*	 view-type="both"
*/
public HashMap delete( HashMap map, HashMap sqlMap ) 
{ 
	return map;
}

//IN030284 - Start
public HashMap insertOAData(  HashMap tabData, HashMap sqlMap  )
{
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	Connection connection 		= null;
	//String OrderCatalog = ""; //Checkstyle
	ArrayList OrderCatalogSelected = new ArrayList() ;
	//String patient_id = ""; //Checkstyle
	//String appt_status = ""; //Checkstyle
	int result[] = {};
	//String catalog = ""; //Checkstyle
	//String short_desc = ""; //Checkstyle
	//String order_type_code = ""; //Checkstyle
	//String order_category = ""; //Checkstyle
	StringBuffer messages = new StringBuffer() ;
	HashMap map = new HashMap() ;
	ArrayList insertData=(ArrayList) tabData.get("InsertData");
	int count = 0;
	int res_del = 0;
	Properties pt = (Properties)tabData.get( "properties" ) ;
	final String SQL_OR_APPT_ORDER_INSERT = (String) sqlMap.get( "InsertSQL" );
	final String SQL_OR_APPT_ORDER_COUNT = (String) sqlMap.get( "CountSQL" );
	final String SQL_OR_APPT_ORDER_DELETE = (String) sqlMap.get( "DeleteSQL" );
	try
	{
		connection	= getConnection((Properties)tabData.get( "properties" ));
		
		pstmt		= connection.prepareStatement( SQL_OR_APPT_ORDER_COUNT );
		pstmt.setString(1,(String)insertData.get(0));
		resultSet = pstmt.executeQuery();
		while(resultSet != null && resultSet.next() )
		{
			count = resultSet.getInt(1);
			if(count > 0)
			{
				pstmt		= connection.prepareStatement( SQL_OR_APPT_ORDER_DELETE );
				pstmt.setString(1,(String)insertData.get(0));
				res_del  = pstmt.executeUpdate();
			}
		}
		//Checkstyle Start.
		if(resultSet!=null);
			resultSet.close();
		if(pstmt!=null);
			pstmt.close();
		//Checkstyle end.	
			pstmt		= connection.prepareStatement( SQL_OR_APPT_ORDER_INSERT );
			OrderCatalogSelected = (ArrayList) tabData.get( "catalogs" );
			for(int i=0;i<OrderCatalogSelected.size();i++)
			{
				pstmt.setString(1,(String)insertData.get(0));
				pstmt.setString(2,(String)insertData.get(1));
				pstmt.setString(3,(String)OrderCatalogSelected.get(i));
				pstmt.setString(4,(String)insertData.get(2));
				pstmt.setString(5,(String)insertData.get(3));
				pstmt.setString(6,(String)insertData.get(4));
				pstmt.setString(7,(String)insertData.get(5));
				pstmt.setString(8,(String)insertData.get(6));
				pstmt.setString(9,(String)insertData.get(7));
				pstmt.setString(10,(String)insertData.get(8));
				pstmt.setString(11,(String)insertData.get(9));
				
				pstmt.addBatch();						
			}
			result = pstmt.executeBatch();
				
			if ( result.length <0) 
			{
				connection.rollback() ;
				messages.append( "Insert Failed" ) ;
			}
			else
			{
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_INSERTED" ) ;
	
			}
		//Checkstyle Start.
		if(pstmt!=null);
			pstmt.close();
		//Checkstyle end.
	 }
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	finally
	{
		try
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			if(connection != null) 
			{
				closeConnection( connection, pt );
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	map.put( "message", messages.toString() ) ;
	
	return map;
}
	//IN030284 Ends

//8882 Starts
public String cancelOrderBilling(Connection connection,String login_facility_id,String order_id,String linerecord,String login_by_id,String login_at_ws_no,String p_called_from_ca) throws Exception //IN071315
{
	CallableStatement cstmt_bl_ext_chrg_stage 	= null;
	String p_error_message									= "";
	int ferrcount													= 0;
	boolean result												= true;
	String billing_line_result	= "";

	try
	{
		cstmt_bl_ext_chrg_stage = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?)}");	//IN071315		
		cstmt_bl_ext_chrg_stage.setString(1, login_facility_id); 					// P_FACILITY_ID
		cstmt_bl_ext_chrg_stage.setString(2, order_id);						// P_ORDER_ID
		cstmt_bl_ext_chrg_stage.setString(3, linerecord);				// P_ORDER_LINE_NUM
		cstmt_bl_ext_chrg_stage.setString(4, "CAN"); 						// P_MODE
		cstmt_bl_ext_chrg_stage.setString(5, login_by_id);							// P_USER
		cstmt_bl_ext_chrg_stage.setString(6, login_at_ws_no);						// P_WS_NO
		cstmt_bl_ext_chrg_stage.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
		cstmt_bl_ext_chrg_stage.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
		cstmt_bl_ext_chrg_stage.setString(9, "N");						// FUTURE
		cstmt_bl_ext_chrg_stage.setString(10, "Y");						// INCLUDE_CANCEL
		//IN071315 Starts
		if("Y".equals(p_called_from_ca))
			cstmt_bl_ext_chrg_stage.setString(11, "CA");
		else
			cstmt_bl_ext_chrg_stage.setString(11, "OR");
		//IN071315 Ends
		cstmt_bl_ext_chrg_stage.execute();
		p_error_message	= cstmt_bl_ext_chrg_stage.getString(8);  // message
		
		if(p_error_message!=null && !p_error_message.equals(""))
		{
			ferrcount++;
			billing_line_result = p_error_message;
		}

		if ( ferrcount >0 ) 
		{
			result = false;
		}	
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
		throw e ;
	}
	finally 
	{
		closeStatement( cstmt_bl_ext_chrg_stage ) ;
	}
	return billing_line_result;
} 
//8882 Ends

}
