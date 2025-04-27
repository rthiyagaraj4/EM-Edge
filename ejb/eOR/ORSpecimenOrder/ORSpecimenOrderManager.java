/*
=======
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
24/07/2012    IN034206       Chowminya G    Incident No: IN034206 - <Specimen No's are getting generated wrongly for NEONATE and Interval Tests> 
21/08/2012    IN034688       Dinesh T	    Exception handling is done in this function
27/09/2012    IN034769       Dinesh T	    Exception handling is done in this function,Ordering and Performing facility is added to the procedure call
08/10/2012	  IN034769		 Ramesh G	ML-BRU-SCF-0371 
06/06/2013	  IN035837		 Karthi L 		Requirement for managing future order and specimen number generation.[Bru-HIMS-CRF-320]
18/06/2013	  IN040973		 Karthi L 		 Future Order icon is displayed even after the start date and time is changed to current date and time
26/06/2013	  IN041200		 Karthi L		In Existing Orders the current date is not updated
26/08/2013	  IN041340		 Ramesh G		Bru-HIMS-CRF-363.1
03/09/2013    MOHBRU-EMR	 Akbar			Issue: Ord_fac & Perf_fac values passed same as Perf_fac for specimen no generation
19/09/2013	  IN043570		 Ramesh			Linked issue for Bru-HIMS-CRF-363.1
27/09/2013    IN043805	     ChowminyaG		RL-Interval Tests-Redirect Order-Multifacility
09/10/2013    MOHBRU-EMR	 Akbar			Issue: login_fac value to be passes along with ord & perf fac for specimen no generation
24/12/2013	  IN045807		Chowminya		Interval Tests-Multifacility-Specimens generating wrongly
07/01/2014    IN046180		 Chowminya		 "New List" option list the orders for which "Collection Bar code" label already generated	
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------------
24/02/2014	  IN047220	   Chowminya	24/02/2014       Ramesh			Label printed for New list n record Collection, should print only for Newlist
28/04/2014	  IN048703	   Nijithas										GHL-SCF-807
12/11/2014	  IN052417     Chowminya									Lab Order Registration screen gives the error message
03/08/2015		IN055586	Akbar										Neonatal order - when specimen no generated at facility mark as 'Child' 
19/08/2016		IN059646	Raja S										ML-BRU-SCF-1676
26/07/2017	IN064835		Vijayakumar K									ML-MMOH-CRF-0578.1 [IN:064835]	
31/07/2017	IN065295		Dinesh T	31/10/2017		Ramesh G		Requirement of Dashboard function for Lab Central 																				Reception (CRR) Users to check the exact sample status.
28/06/2020		IN071820		Ramesh G		28/06/2020		Ramesh G		ML-MMOH-SCF-1413	
08/07/2020     IN072184          Chandrashekar raju     	08/07/2020       Ramesh G      Modified for MMS-DM-CRF-0157.2
--------------------------------------------------------------------------------------------------------------------------------
*/  
package eOR.ORSpecimenOrder;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;
import eCommon.Common.*;
import java.io.*;//IN034688
import java.text.DateFormat; // added for IN035837 [CRF320 ]
import java.text.SimpleDateFormat; // added for IN035837 [CRF320 ]
import java.util.Date; // added for IN035837 [CRF320 ]
import com.ehis.util.*;
/**
*
* @ejb.bean
*	name="ORSpecimenOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORSpecimenOrder"
*	local-jndi-name="ORSpecimenOrder"
*	impl-class-name="eOR.ORSpecimenOrder.ORSpecimenOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORSpecimenOrder.ORSpecimenOrderLocal"
*	remote-class="eOR.ORSpecimenOrder.ORSpecimenOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORSpecimenOrder.ORSpecimenOrderLocalHome"
*	remote-class="eOR.ORSpecimenOrder.ORSpecimenOrderHome"
*	generate= "local,remote"
*
*
*/

public class ORSpecimenOrderManager extends OrEJBSessionAdapter {
  //  SessionContext context ;
  //	PreparedStatement pstmt = null ;

	StringBuffer traceVals = new StringBuffer();

/**
* @ejb.interface-method
*	 view-type="both"
*/
public HashMap insert( HashMap tabData, HashMap sqlMap ) {
HashMap map = new HashMap() ;
map.put( "result", new Boolean( false ) ) ;
map.put( "flag", "") ;
map.put("report_exec_ind","");		//[IN032796]
map.put("specimen_no","");			//[IN032796]
int count_records =0;			//[IN032796]
Hashtable stored_values  = new Hashtable();
HashMap barcode_remarks =new HashMap();//Added for IN072184
CallableStatement cs = null;	//Added for IN072184
//StringBuffer messages = new StringBuffer();
//String[] updt_dtl = new String[20];
String[] updt_dtl = null;
Connection connection = null;
CallableStatement cstmt_freq_expl 	= null;
CallableStatement cstmt				= null;
PreparedStatement pstmt1 			= null;
PreparedStatement pstmt2 			= null;
PreparedStatement pstmt3            = null;
ResultSet resultSet                 = null;
String coll_label_gen_rule	= "X";
String specimen_no			= "";
String report_exec_ind		= "PC";	//[IN032796]
String error_code			= "";	//[IN032796]
String option_list			= "";
String user_id_pwd			= "";
String re_route_printer_id = "";//IN064835
int count 	= 0;
int result 	= 0;
int k		= 0;

//IN034769,starts
Properties l_props;
String l_language_id = "";
//IN034769,ends
// final String SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST						= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST"); Checkstyle
final String SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST_DATE				= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST_DATE");
//final String SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND					= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND"); //Checkstyle
final String SQL_OR_ORDER_ENTRY_SPECIMEN_GEN						= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_SPECIMEN_GEN");
//	final String SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT					= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT");
final String SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER					= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER");
final String SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER_LINE				= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER_LINE");
final String SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_DATE				= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_DATE");
//      final String SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO		    = (String) sqlMap.get("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO");
//      final String SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO	= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO");
final String SQL_OR_SPECIMEN_ORDER_UPDATE_INTERVAL_TESTS			= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_INTERVAL_TESTS");
final String SQL_OR_SPECIMEN_UPDATE_SPECIMEN_NO						= (String) sqlMap.get("SQL_OR_SPECIMEN_UPDATE_SPECIMEN_NO");
//final String SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_NEW_LIST_AUTO_COLLECT_NO	= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_NEW_LIST_AUTO_COLLECT_NO");//Checkstyle

final String SQL_OR_SPECIMEN_ORDER_ACCESSION_NUM_SELECT				= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_ACCESSION_NUM_SELECT");
final String SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER_LINE	= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER_LINE");
final String SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER			= (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER");
final String SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_RECORD_COLLECTION  = (String) sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_RECORD_COLLECTION");
//final String SQL_OR_CHECK_MODULE_INSTALL_YN			= (String) sqlMap.get("SQL_OR_CHECK_MODULE_INSTALL_YN");
final String SQL_OR_ORDER_ENTRY_RL_NEONATES_UPD_COLLECTION			= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_RL_NEONATES_UPD_COLLECTION");
final String SQL_OR_ORDER_ENTRY_RL_NEONATES							= (String) sqlMap.get("SQL_OR_ORDER_ENTRY_RL_NEONATES");

try{
	String auto_collect	 = ((String)tabData.get("auto_collect"));
	//IN034769,starts
	l_props = (Properties)tabData.get( "properties" );
	l_language_id = (String)l_props.getProperty("LOCALE");
	//IN034769,ends
	connection = getConnection((Properties)tabData.get( "properties" ) ) ;
	count	   =  Integer.parseInt(((String)tabData.get("count")));	 // Total count
	connection.setAutoCommit( false ) ;
	StringBuffer sbFailedRecs = new StringBuffer();
	int nSuccessRec		=		0;
	int nFailedRec		=		0;
	result = 1;
	String accession_num = "";
	String[] gen_rule_no		= new String[2];
	re_route_printer_id = ((String)tabData.get("re_route_printer_id"));//IN064835
	
	cstmt_freq_expl = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_SPECIMEN_GEN+" }");

	for(int i=0;i<count;i++){
		
		updt_dtl 		= (String[])tabData.get("data"+i);
		option_list		= (String)tabData.get("option_list");
		
		if(option_list.equalsIgnoreCase("N") || option_list.equalsIgnoreCase("C") )
		{ 
			if(updt_dtl[6].equalsIgnoreCase("P") ) // coll_label_gen_rule if "P"
			{
				try{
					closeStatement( pstmt3 );
					pstmt3 = connection.prepareStatement(SQL_OR_SPECIMEN_ORDER_ACCESSION_NUM_SELECT);
					accession_num = "";
					
					pstmt3.setString(1,updt_dtl[0]);
					resultSet = pstmt3.executeQuery();
				
					while (resultSet.next()) {
						accession_num = resultSet.getString(1);
						if (accession_num == null) accession_num = "";
					}
					closeStatement( pstmt3 );
					closeResultSet( resultSet );


					if (accession_num.equals("")) {
						
						//[IN041340] gen_rule_no = generateSpecimenNo(connection,updt_dtl[1],updt_dtl[2],updt_dtl[3],updt_dtl[8],updt_dtl[5],updt_dtl[4],updt_dtl[7],updt_dtl[23],updt_dtl[14],(String)tabData.get("login_facility_id"),updt_dtl[14],l_language_id);//IN034769
						//MOHBRU-EMR gen_rule_no = generateSpecimenNo(connection,updt_dtl[1],updt_dtl[2],updt_dtl[3],updt_dtl[8],updt_dtl[5],updt_dtl[4],updt_dtl[7],updt_dtl[23],updt_dtl[14],(String)tabData.get("login_facility_id"),updt_dtl[14],l_language_id,((String)tabData.get("login_at_ws_no")));//IN041340
						gen_rule_no = generateSpecimenNo(connection,updt_dtl[1],updt_dtl[2],updt_dtl[3],updt_dtl[8],updt_dtl[5],updt_dtl[4],updt_dtl[7],updt_dtl[23],updt_dtl[22],(String)tabData.get("login_facility_id"),updt_dtl[14],l_language_id,((String)tabData.get("login_at_ws_no")));//MOHBRU-EMR
						coll_label_gen_rule 	= gen_rule_no[0];
						specimen_no 			= gen_rule_no[1];
						report_exec_ind			= gen_rule_no[2];		//Ramesh
						error_code				= gen_rule_no[3];		//Ramesh
						if(coll_label_gen_rule==null) coll_label_gen_rule = "X";
						if(specimen_no==null) specimen_no = "";
										
					} 
					else 
					{
						  coll_label_gen_rule = "G";
						  specimen_no = accession_num;
					}
				}
				catch(Exception e)
				{
					result = 0;
					e.printStackTrace();
					map.put("message",e.getMessage());//IN034688
				}
				// Moved the below code to line no : 243
				/*	if(result > 0)
					{

						pstmt1 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST) ;
						pstmt1.setString( 1, coll_label_gen_rule ) ;
						if(option_list.equalsIgnoreCase("N"))
							pstmt1.setString(2, auto_collect); // "Y" or "N" 
						else 
							pstmt1.setString(2, "Y");  // For record collection 
						if (updt_dtl[15].equals("-1"))
							pstmt1.setString( 3, updt_dtl[9] ) ;
						else {
							StringTokenizer stknizer = new StringTokenizer(updt_dtl[9],"~");
							if (stknizer.hasMoreTokens()) {
								String token = stknizer.nextToken();
								pstmt1.setString(3,token);
							} /*else {
								pstmt1.setString(2,null);
							}
						}
						pstmt1.setString( 4, updt_dtl[16] ) ;
						pstmt1.setString( 5, updt_dtl[17] ) ;

						pstmt1.setString( 6, ((String)tabData.get("login_by_id")) ) ;   
						pstmt1.setString( 7, ((String)tabData.get("login_at_ws_no"))  ) ; 
						pstmt1.setString( 8, ((String)tabData.get("login_facility_id"))  ) ; 
						pstmt1.setString( 9, updt_dtl[0]  ) ;
						
						result = pstmt1.executeUpdate();

						closeStatement( pstmt1 ) ;

					}*/

					if(result>0 && option_list.equalsIgnoreCase("N") &&  auto_collect.equals("Y")) 
					{
						/*pstmt1 = connection.prepareStatement(SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND ) ;
						pstmt1.setString( 1, specimen_no ) ;
						pstmt1.setString( 2, ((String)tabData.get("login_by_id")) ) ;   
						pstmt1.setString( 3, ((String)tabData.get("login_at_ws_no"))  ) ; 
						pstmt1.setString( 4, ((String)tabData.get("login_facility_id"))  ) ; 
						pstmt1.setString( 5, updt_dtl[0]  ) ;
						result = pstmt1.executeUpdate();
						closeStatement( pstmt1 ) ;*/
						//result = updateOrderLineSpecimen(connection,specimen_no,((String)tabData.get("login_by_id")),((String)tabData.get("login_at_ws_no")),((String)tabData.get("login_facility_id")),updt_dtl[0]);// Commented for IN059646
						result = updateOrderLineSpecimen(connection,specimen_no,((String)tabData.get("login_by_id")),((String)tabData.get("login_at_ws_no")),((String)tabData.get("login_facility_id")),updt_dtl[0],updt_dtl[9]); //Added for IN059646
						//IN046180 - Start Added for Auto_Collection scenario
						if(result > 0)
						{
							pstmt1 = connection.prepareStatement( "update or_order_line_lb set  COLL_LABEL_GEN_RULE = 'G', COLL_LABEL_GEN_DATE_TIME      = to_date(?,'dd/mm/yyyy hh24:mi'), SPECIMEN_COLLECT_YN='Y',SPECIMEN_COLLECT_DATE_TIME      = to_date(?,'dd/mm/yyyy hh24:mi'),SPECIMEN_COLLECTED_BY =?, COLL_REQD_YN='Y',SPECIMEN_COLLECT_REMARKS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?   where ordeR_id = ?") ;
							String specimenDate = "";
							if (updt_dtl[15].equals("-1")){
								pstmt1.setString( 1, updt_dtl[9] ) ;   // Specimen collection date and time
								pstmt1.setString( 2, updt_dtl[9] );
							}else {
								StringTokenizer stknizer = new StringTokenizer(updt_dtl[9],"~");
								if (stknizer.hasMoreTokens()) {
									specimenDate = stknizer.nextToken();
									pstmt1.setString(1,specimenDate);
									pstmt1.setString(2,specimenDate);
								}
							}
							pstmt1.setString( 3, updt_dtl[16] ) ;
							pstmt1.setString( 4, updt_dtl[17] ) ;

							pstmt1.setString( 5, ((String)tabData.get("login_by_id")) ) ;   
							pstmt1.setString( 6, ((String)tabData.get("login_at_ws_no"))  ) ;
							pstmt1.setString( 7, ((String)tabData.get("login_facility_id"))  ) ; 

							pstmt1.setString( 8, updt_dtl[0]  ) ;
							
							result = pstmt1.executeUpdate();
							closeStatement( pstmt1 ) ;
							
						}
						//IN046180 - End Added for Auto_Collection scenario
						/*if(result > 0 )
						{
							pstmt2 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER) ;
							pstmt2.setString( 1, ((String)tabData.get("login_by_id")) ) ;   
							pstmt2.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ; 
							pstmt2.setString( 3, ((String)tabData.get("login_facility_id"))  ) ; 
							pstmt2.setString( 4, updt_dtl[0]  ) ;  // Order Id
							result = pstmt2.executeUpdate(); 
							closeStatement( pstmt2 ) ;							
						}
						else
						{*/
						if(!(result > 0 ))
						{
							/*Added by Uma on 2/3/2010*/
							for(int z=0;z<3;z++)
							{
								//[IN041340]gen_rule_no = generateSpecimenNo(connection,updt_dtl[1],updt_dtl[2],updt_dtl[3],updt_dtl[8],updt_dtl[5],updt_dtl[4],updt_dtl[7],updt_dtl[23],updt_dtl[14],(String)tabData.get("login_facility_id"),updt_dtl[14],l_language_id);//IN034769
								//MOHBRU-EMR gen_rule_no = generateSpecimenNo(connection,updt_dtl[1],updt_dtl[2],updt_dtl[3],updt_dtl[8],updt_dtl[5],updt_dtl[4],updt_dtl[7],updt_dtl[23],updt_dtl[14],(String)tabData.get("login_facility_id"),updt_dtl[14],l_language_id,((String)tabData.get("login_at_ws_no")));//IN041340
								gen_rule_no = generateSpecimenNo(connection,updt_dtl[1],updt_dtl[2],updt_dtl[3],updt_dtl[8],updt_dtl[5],updt_dtl[4],updt_dtl[7],updt_dtl[23],updt_dtl[22],(String)tabData.get("login_facility_id"),updt_dtl[14],l_language_id,((String)tabData.get("login_at_ws_no")));//MOHBRU-EMR 
								coll_label_gen_rule 	= gen_rule_no[0];
								specimen_no 			= gen_rule_no[1];
								report_exec_ind			= gen_rule_no[2];		//Ramesh
								error_code				= gen_rule_no[3];		//Ramesh
								
								if(coll_label_gen_rule==null) coll_label_gen_rule = "X";
								if(specimen_no==null) specimen_no = "";

								//result = updateOrderLineSpecimen(connection,specimen_no,((String)tabData.get("login_by_id")),((String)tabData.get("login_at_ws_no")),((String)tabData.get("login_facility_id")),updt_dtl[0]);// commented for IN059646
								result = updateOrderLineSpecimen(connection,specimen_no,((String)tabData.get("login_by_id")),((String)tabData.get("login_at_ws_no")),((String)tabData.get("login_facility_id")),updt_dtl[0],updt_dtl[9]); //Added for IN059646


								if(result>0)
								{
									z = 3;
								}
							}
							
							if(!(result>0))
							{
							/*Ends Here*/
								connection.rollback();
								sbFailedRecs.append(updt_dtl[0] + ",");
								nFailedRec++;
								result = 1;
								continue;
							}
						}	
						/*Added by Uma on 2/3/2010*/
						if(result > 0 )
						{
							pstmt2 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER) ;
							pstmt2.setString( 1, ((String)tabData.get("login_by_id")) ) ;   
							pstmt2.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ; 
							pstmt2.setString( 3, ((String)tabData.get("login_facility_id"))  ) ; 
							pstmt2.setString( 4, updt_dtl[0]  ) ;  // Order Id
							result = pstmt2.executeUpdate(); 
							closeStatement( pstmt2 ) ;							
						}
						else
						{
							connection.rollback();
							sbFailedRecs.append(updt_dtl[0] + ",");
							nFailedRec++;
							result = 1;
							continue;
						}
						/*Ends Here*/
					} 
					else if(result>0 && option_list.equalsIgnoreCase("N") &&  auto_collect.equals("N")) 
					{
						//result = updateOrderLine(connection,specimen_no,((String)tabData.get("login_by_id")),((String)tabData.get("login_at_ws_no")),((String)tabData.get("login_facility_id")),updt_dtl[0]);  // commented for IN035837 [CRF320 ]
						result = updateOrderLine(connection,specimen_no,((String)tabData.get("login_by_id")),((String)tabData.get("login_at_ws_no")),((String)tabData.get("login_facility_id")),updt_dtl[0],((String)tabData.get("curr_sys_date")),updt_dtl[24], l_language_id); // modified for IN035837 [CRF320]  //IN041200
						/*pstmt2 = connection.prepareStatement(SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_NEW_LIST_AUTO_COLLECT_NO ) ;
						pstmt2.setString( 1, specimen_no ) ;
						pstmt2.setString( 2, ((String)tabData.get("login_by_id")) ) ;   
						pstmt2.setString( 3, ((String)tabData.get("login_at_ws_no"))  ) ; 
						pstmt2.setString( 4, ((String)tabData.get("login_facility_id"))  ) ; 
						pstmt2.setString( 5, updt_dtl[0]  ) ;
						result = pstmt2.executeUpdate();

						closeStatement( pstmt2 ) ;*/

					} 

					/*if(result > 0)
					{
						pstmt1 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST) ;
						pstmt1.setString( 1, coll_label_gen_rule ) ;
						if(option_list.equalsIgnoreCase("N"))
							pstmt1.setString(2, auto_collect); // "Y" or "N" 
						else 
							pstmt1.setString(2, "Y");  // For record collection 
						if (updt_dtl[15].equals("-1"))
							pstmt1.setString( 3, updt_dtl[9] ) ;
						else 
						{
							StringTokenizer stknizer = new StringTokenizer(updt_dtl[9],"~");
							if (stknizer.hasMoreTokens()) 
							{
								String token = stknizer.nextToken();
								pstmt1.setString(3,token);
							} /*else {
								pstmt1.setString(2,null);
							}*/
						/*}
						pstmt1.setString( 4, updt_dtl[16] ) ;
						pstmt1.setString( 5, updt_dtl[17] ) ;
						pstmt1.setString( 6, ((String)tabData.get("login_by_id")) ) ;   
						pstmt1.setString( 7, ((String)tabData.get("login_at_ws_no"))  ) ; 
						pstmt1.setString( 8, ((String)tabData.get("login_facility_id"))  ) ; 
						pstmt1.setString( 9, updt_dtl[0]  ) ;						
						result = pstmt1.executeUpdate();
						closeStatement( pstmt1 ) ;
					}
					else						
					{
						/*Ends Here*/
					/*Added by Uma on 2/3/2010*/
					if(!(result > 0 ))
				   {
						/*Added by Uma on 2/3/2010*/
						for(int zk=0;zk<3;zk++)
						{
							//[IN041340]gen_rule_no = generateSpecimenNo(connection,updt_dtl[1],updt_dtl[2],updt_dtl[3],updt_dtl[8],updt_dtl[5],updt_dtl[4],updt_dtl[7],updt_dtl[23],updt_dtl[14],(String)tabData.get("login_facility_id"),updt_dtl[14],l_language_id);//IN034769
							//MOHBRU-EMR gen_rule_no = generateSpecimenNo(connection,updt_dtl[1],updt_dtl[2],updt_dtl[3],updt_dtl[8],updt_dtl[5],updt_dtl[4],updt_dtl[7],updt_dtl[23],updt_dtl[14],(String)tabData.get("login_facility_id"),updt_dtl[14],l_language_id,((String)tabData.get("login_at_ws_no")));//IN041340
							gen_rule_no = generateSpecimenNo(connection,updt_dtl[1],updt_dtl[2],updt_dtl[3],updt_dtl[8],updt_dtl[5],updt_dtl[4],updt_dtl[7],updt_dtl[23],updt_dtl[22],(String)tabData.get("login_facility_id"),updt_dtl[14],l_language_id,((String)tabData.get("login_at_ws_no")));//MOHBRU-EMR
							coll_label_gen_rule 	= gen_rule_no[0];
							specimen_no 			= gen_rule_no[1];
							report_exec_ind			= gen_rule_no[2];		//Ramesh
							error_code				= gen_rule_no[3];		//Ramesh
							
							if(coll_label_gen_rule==null) coll_label_gen_rule = "X";
							if(specimen_no==null) specimen_no = "";

							//result = updateOrderLineSpecimen(connection,specimen_no,((String)tabData.get("login_by_id")),((String)tabData.get("login_at_ws_no")),((String)tabData.get("login_facility_id")),updt_dtl[0]); // commented for IN059646
							result = updateOrderLineSpecimen(connection,specimen_no,((String)tabData.get("login_by_id")),((String)tabData.get("login_at_ws_no")),((String)tabData.get("login_facility_id")),updt_dtl[0],updt_dtl[9]); // Added for IN059646


							if(result>0)
							{
								zk = 3;
							}
						}
						if(!(result>0))
						{
						/*Ends Here*/
							connection.rollback();
							sbFailedRecs.append(updt_dtl[0] + ",");
							nFailedRec++;
							result = 1;
							continue;	
						}
					}
					/*Added by Uma on 2/3/2010 */
					//IN046180 Added if condition to avoid duplicated data in order action table 
					if(auto_collect.equals("N"))
					{	
						if(result > 0 )
						{
							//pstmt1 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST) ;//IN065295
							pstmt1 = connection.prepareStatement( " UPDATE OR_ORDER_LINE_LB SET  COLL_LABEL_GEN_RULE            = ? ,COLL_LABEL_GEN_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'), MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID = ? " ) ;//IN065295
							pstmt1.setString( 1, coll_label_gen_rule ) ;
							//IN065295, starts
							/*if(option_list.equalsIgnoreCase("N"))
								pstmt1.setString(2, auto_collect); // "Y" or "N" 
							else 
								pstmt1.setString(2, "Y");  // For record collection */

							/*pstmt1.setString(2, "Y");

							if (updt_dtl[15].equals("-1"))
								pstmt1.setString( 3, updt_dtl[9] ) ;
							else 
							{
								StringTokenizer stknizer = new StringTokenizer(updt_dtl[9],"~");
								if (stknizer.hasMoreTokens()) 
								{
									String token = stknizer.nextToken();
									pstmt1.setString(3,token);
								} 
							}*/
							/*pstmt1.setString( 4, updt_dtl[16] ) ;
							pstmt1.setString( 5, updt_dtl[17] ) ;
							pstmt1.setString( 6, ((String)tabData.get("login_by_id")) ) ;   
							pstmt1.setString( 7, ((String)tabData.get("login_at_ws_no"))  ) ; 
							pstmt1.setString( 8, ((String)tabData.get("login_facility_id"))  ) ; 
							pstmt1.setString( 9, updt_dtl[0]  ) ;*/

							if (updt_dtl[15].equals("-1"))
								pstmt1.setString( 2, updt_dtl[9] ) ;
							else 
							{
								StringTokenizer stknizer = new StringTokenizer(updt_dtl[9],"~");
								if (stknizer.hasMoreTokens()) 
								{
									String token = stknizer.nextToken();
									pstmt1.setString(2,token);
								} 
							}
							pstmt1.setString( 3, ((String)tabData.get("login_by_id")) ) ;   
							pstmt1.setString( 4, ((String)tabData.get("login_at_ws_no"))  ) ; 
							pstmt1.setString( 5, ((String)tabData.get("login_facility_id"))  ) ; 
							pstmt1.setString( 6, updt_dtl[0]  ) ;
							//IN065295, ends

							result = pstmt1.executeUpdate();
							closeStatement( pstmt1 ) ;
						}
						else
					   {
							connection.rollback();
							sbFailedRecs.append(updt_dtl[0] + ",");
							nFailedRec++;
							result = 1;
							continue;				
					   }
					}
				   /*Ends Here*/

					if(result>0 && option_list.equalsIgnoreCase("C")) {
						pstmt2 = connection.prepareStatement(SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_RECORD_COLLECTION ) ;
						pstmt2.setString( 1, ((String)tabData.get("login_by_id")) ) ;   
						pstmt2.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ; 
						pstmt2.setString( 3, ((String)tabData.get("login_facility_id"))  ) ; 
						pstmt2.setString( 4, updt_dtl[0]  ) ;
						result = pstmt2.executeUpdate();

						closeStatement( pstmt2 ) ;
						if(result > 0 ){
								pstmt2 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER) ;
								pstmt2.setString( 1, ((String)tabData.get("login_by_id")) ) ;   
								pstmt2.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ; 
								pstmt2.setString( 3, ((String)tabData.get("login_facility_id"))  ) ; 
								pstmt2.setString( 4, updt_dtl[0]  ) ;  // Order Id
								result = pstmt2.executeUpdate();

								closeStatement( pstmt2 ) ;
						}
					}

					if(result > 0 && !specimen_no.equals("")&& updt_dtl[19].equals("Y"))
					{
						pstmt1 = connection.prepareStatement(SQL_OR_SPECIMEN_ORDER_UPDATE_INTERVAL_TESTS);
						if (!updt_dtl[15].equals("-1")) {
							StringTokenizer stknizer1 = new StringTokenizer(updt_dtl[9],"~");
							StringTokenizer stknizer2 = new StringTokenizer(updt_dtl[15],"~");
							while (stknizer1.hasMoreTokens()) {
								String seqDate = stknizer1.nextToken();
								String seqNo   = stknizer2.nextToken();
								
								pstmt1.setString(1, seqDate);
								/*pstmt1.setString(2, ((String)tabData.get("login_by_id")) ) ;   
								pstmt1.setString(3, ((String)tabData.get("login_at_ws_no"))  ) ; 
								pstmt1.setString(4, ((String)tabData.get("login_facility_id"))  ) ; */
								pstmt1.setString(2, updt_dtl[0]);
								pstmt1.setString(3, seqNo);
								result = pstmt1.executeUpdate();
							}
						}
						closeStatement( pstmt1 ) ;
					}
			}
			else if(updt_dtl[6].equalsIgnoreCase("G")) // If it is "G"
			{
				if(result > 0)
				{
					pstmt1 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_FIRST_DATE) ;
					String specimenDate = "";
					if (updt_dtl[15].equals("-1")){
						pstmt1.setString( 1, updt_dtl[9] ) ;   // Specimen collection date and time
						pstmt1.setString( 2, updt_dtl[9] );
					}else {
						StringTokenizer stknizer = new StringTokenizer(updt_dtl[9],"~");
						if (stknizer.hasMoreTokens()) {
							specimenDate = stknizer.nextToken();
							pstmt1.setString(1,specimenDate);
							pstmt1.setString(2,specimenDate);
						}
					}
					pstmt1.setString( 3, updt_dtl[16] ) ;
					pstmt1.setString( 4, updt_dtl[17] ) ;

					pstmt1.setString( 5, ((String)tabData.get("login_by_id")) ) ;   
					pstmt1.setString( 6, ((String)tabData.get("login_at_ws_no"))  ) ;
					pstmt1.setString( 7, ((String)tabData.get("login_facility_id"))  ) ; 

					pstmt1.setString( 8, updt_dtl[0]  ) ;
					
					result = pstmt1.executeUpdate();
					closeStatement( pstmt1 ) ;
					
				}
				
				// change the line status & header_status
				if(result > 0)
				{
					pstmt1 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER_LINE) ;
					pstmt1.setString( 1, ((String)tabData.get("login_by_id")) ) ;   
					pstmt1.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ;
					pstmt1.setString( 3, ((String)tabData.get("login_facility_id"))  ) ; 
					pstmt1.setString( 4, updt_dtl[0]  ) ;  // Order Id
					result = pstmt1.executeUpdate();
					closeStatement( pstmt1 ) ;

					if(result > 0 ){
							pstmt2 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER) ;
							pstmt2.setString( 1, ((String)tabData.get("login_by_id")) ) ;   
							pstmt2.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ; 
							pstmt2.setString( 3, ((String)tabData.get("login_facility_id"))  ) ; 
							pstmt2.setString( 4, updt_dtl[0]  ) ;  // Order Id
							result = pstmt2.executeUpdate();

							closeStatement( pstmt2 ) ;
					}

					if(result > 0) {
						pstmt1 = connection.prepareStatement(SQL_OR_SPECIMEN_ORDER_UPDATE_INTERVAL_TESTS);
						if (!updt_dtl[15].equals("-1")) {
							StringTokenizer stknizer1 = new StringTokenizer(updt_dtl[9],"~");
							StringTokenizer stknizer2 = new StringTokenizer(updt_dtl[15],"~");
							while (stknizer1.hasMoreTokens() && stknizer2.hasMoreTokens() ) {
							//while (stknizer1.hasMoreTokens()) {
								String seqDate = stknizer1.nextToken();
								String seqNo   = stknizer2.nextToken();
								
								pstmt1.setString(1, seqDate);
								pstmt1.setString(2, updt_dtl[0]);
								pstmt1.setString(3, seqNo);
								result = pstmt1.executeUpdate();
								
							}
						}
						closeStatement( pstmt1 ) ;
					}
				}

			}
			else if (updt_dtl[6].equalsIgnoreCase("X")) //If it is "X"
			{
				if (result > 0) {
					pstmt1 = connection.prepareStatement(SQL_OR_SPECIMEN_ORDER_UPDATE_SECOND_DATE);
					String specimenDate = "";
					if (updt_dtl[15].equals("-1")) {
						specimenDate = updt_dtl[9];
						pstmt1.setString(1, specimenDate);
						pstmt1.setString(2, specimenDate);
					} else {
						StringTokenizer stknizer = new StringTokenizer(updt_dtl[9],"~");
						if (stknizer.hasMoreTokens()) {
							specimenDate = stknizer.nextToken();
							pstmt1.setString(1,specimenDate);
							pstmt1.setString(2,specimenDate);
						} /*else {
							pstmt1.setString(1,null);
							pstmt1.setString(2,null);
						}*/
					}
					pstmt1.setString(3, updt_dtl[16]);
					pstmt1.setString(4, updt_dtl[17]);
					String order_id = updt_dtl[0];
					pstmt1.setString( 5, ((String)tabData.get("login_by_id")) ) ;   
					pstmt1.setString( 6, ((String)tabData.get("login_at_ws_no"))  ) ; 
					pstmt1.setString( 7, ((String)tabData.get("login_facility_id"))  ) ; 

					pstmt1.setString(8, order_id);
					
					result = pstmt1.executeUpdate();
					closeStatement( pstmt1 ) ;
					
				}
				
				if(result > 0) {
					
					pstmt1 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER_LINE) ;
					pstmt1.setString( 1, ((String)tabData.get("login_by_id")) ) ;   
					pstmt1.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ; 
					pstmt1.setString( 3, ((String)tabData.get("login_facility_id"))  ) ;
					pstmt1.setString( 4, updt_dtl[0]  ) ;  // Order Id
					result = pstmt1.executeUpdate();

					closeStatement( pstmt1 ) ;

					if(result > 0 ){
							pstmt2 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER) ;
							pstmt2.setString( 1, ((String)tabData.get("login_by_id")) ) ;   
							pstmt2.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ; 
							pstmt2.setString( 3, ((String)tabData.get("login_facility_id"))  ) ; 
							pstmt2.setString( 4, updt_dtl[0]  ) ;  // Order Id
							result = pstmt2.executeUpdate();
							closeStatement( pstmt2 ) ;
							
					}

					if(result > 0){
						pstmt1 = connection.prepareStatement(SQL_OR_SPECIMEN_ORDER_UPDATE_INTERVAL_TESTS);
						
						
						if (!updt_dtl[15].equals("-1")) {
							
							StringTokenizer stknizer1 = new StringTokenizer(updt_dtl[9],"~");
							StringTokenizer stknizer2 = new StringTokenizer(updt_dtl[15],"~");
							while (stknizer1.hasMoreTokens() && stknizer2.hasMoreTokens()) {
								String seqDate = stknizer1.nextToken();
								String seqNo   = stknizer2.nextToken();
								
								pstmt1.setString(1, seqDate);
								/*pstmt1.setString(2, ((String)tabData.get("login_by_id")) ) ;   
								pstmt1.setString(3, ((String)tabData.get("login_at_ws_no"))  ) ; 
								pstmt1.setString(4, ((String)tabData.get("login_facility_id"))  ) ; */
								pstmt1.setString(2, updt_dtl[0]);
								pstmt1.setString(3, seqNo.trim());
								result = pstmt1.executeUpdate();
								
							}
						}
						
						closeStatement( pstmt1 ) ;
					}
				}
			}

			// change for all.in the header level
			//if(result > 0) // Except dispatch
			//{
			//	pstmt1 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_OR_ORDER) ;
			//	pstmt1.setString( 1, updt_dtl[0]  ) ;  // Order Id
			//	result = pstmt1.executeUpdate();
			//}
			// Call the rl procedures

		  // if(((String)tabData.get("lb_module")).equalsIgnoreCase("Y") && updt_dtl[10].equalsIgnoreCase("LB") && !updt_dtl[12].equals("DR")) // col_label_gen_rule = 'P' changed on 7/16/2007 for lb_module by uma
		   if(updt_dtl[23].equalsIgnoreCase("IBARL")&& updt_dtl[10].equalsIgnoreCase("LB") && !updt_dtl[12].equals("DR")) // col_label_gen_rule = 'P' added on 7/16/2007 instead of lb_module
		   {
			   try
			   {
				  if(!specimen_no.equals("") )
				  {
					/* cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO+" }");
					 cstmt.setString(1, updt_dtl[13]);  // CATALOG_CODE
					 cstmt.setString(2, updt_dtl[14]); // PERFORMING_FACILITY_ID
					 cstmt.setString(3, updt_dtl[0]); // Order Id
					 cstmt.setString(4, updt_dtl[7]);    // ORDER_TYPE_CODE
					 cstmt.setString(5, specimen_no);
					 cstmt.setString(6, "N");	// INTERVAL_TEST_YN
					 cstmt.execute();
					*/	
					 cstmt = connection.prepareCall("{"+SQL_OR_SPECIMEN_UPDATE_SPECIMEN_NO+"}");
					 
					 cstmt.setString(1, updt_dtl[14]);// PERFORMING_FACILITY_ID
					 cstmt.setLong(2, Long.parseLong(specimen_no)); //IN034688
					 cstmt.setString(3, updt_dtl[0]); //Order ID
					 cstmt.setString(4, updt_dtl[7]); //ORDER_TYPE_CODE
					 cstmt.setString(5,((String)tabData.get("auto_collect")));//Auto-Update Collection Date & Time
					 //cstmt.setString(6, updt_dtl[22]);// Ordering_facility_id //--[IN034206]
					 cstmt.setString(6, ((String)tabData.get("login_facility_id")));// IN045807 Passing login_facility instead of Ordering_facility_id
					 cstmt.setString(7, ((String)tabData.get("login_at_ws_no"))  ) ;  //---[IN041340]
					 cstmt.execute();

					 closeStatement( cstmt ) ;
				  }
				 /* else
				  {
					  cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO+" }");
					  cstmt.setString(1, updt_dtl[13]);  // CATALOG_CODE
					  cstmt.setString(2, updt_dtl[14]); // PERFORMING_FACILITY_ID
					  cstmt.setString(3, updt_dtl[0]); 	//Order ID						 						
					  cstmt.setString(4, updt_dtl[7]);    // ORDER_TYPE_CODE
					  cstmt.setString(5, "N");		// INTERVAL_TEST_YN
					  cstmt.execute(); 
				  } */
			   }catch(Exception ee)
			   {
					result = 0;
					ee.printStackTrace();
					map.put("message",ee.getMessage());//IN034688
			   }
		   }	// End of lb_module
		}else {
			 coll_label_gen_rule = updt_dtl[6];
		 } // option_list

		if(result > 0 )
		{
			if(option_list.equalsIgnoreCase("D")) {
				pstmt2 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_DTLS") ) ;
				StringTokenizer stknizer1 = new StringTokenizer(updt_dtl[9],"~");
				StringTokenizer stknizer2 = new StringTokenizer(updt_dtl[18],"~");
				
				while (stknizer1.hasMoreTokens()) {
					String seqDate = stknizer1.nextToken();
					String seqNo   = stknizer2.nextToken();
					
					pstmt2.setString(1, seqDate);
					pstmt2.setString(2, updt_dtl[16]);
					pstmt2.setString(3, seqNo.trim());
					pstmt2.setString(4, updt_dtl[17]);
					pstmt2.setString(5, ((String)tabData.get("login_by_id")) ) ;   
					pstmt2.setString(6, ((String)tabData.get("login_at_ws_no"))  ) ; 
					pstmt2.setString(7, ((String)tabData.get("login_facility_id"))  ) ; 

					pstmt2.setString(8, updt_dtl[0]);
					result = pstmt2.executeUpdate();
					
				}
				closeStatement( pstmt2 ) ;

				if(result > 0 ) { // Update the status for the Line and the Header as Specimen collected
					pstmt1 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER_LINE) ;
					pstmt1.setString( 1, ((String)tabData.get("login_by_id")) ) ;  // Order Id
					pstmt1.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ;   
					pstmt1.setString( 3, ((String)tabData.get("login_facility_id"))  ) ;  // Order Id
					pstmt1.setString( 4, updt_dtl[0]  ) ;  // Order Id
					result = pstmt1.executeUpdate();

					closeStatement( pstmt1 ) ;

					// change for all.in the header level
					if(result > 0 ){
						pstmt1 = connection.prepareStatement( SQL_OR_SPECIMEN_ORDER_UPDATE_DISPATCH_OR_ORDER) ;
						pstmt1.setString( 1, ((String)tabData.get("login_by_id")) ) ;  // Order Id
						pstmt1.setString( 2, ((String)tabData.get("login_at_ws_no"))  ) ;   
						pstmt1.setString( 3, ((String)tabData.get("login_facility_id"))  ) ;  // Order Id
						pstmt1.setString( 4, updt_dtl[0]  ) ;  // Order Id
						result = pstmt1.executeUpdate();
						
						closeStatement( pstmt1 ) ;
					}
				}
				
			} else {
				//if(((String)tabData.get("lb_module")).equalsIgnoreCase("Y") && updt_dtl[10].equalsIgnoreCase("LB") && coll_label_gen_rule.equalsIgnoreCase("G")) // col_label_gen_rule = 'G' changed on 7/16/2007 for lb_module instal by uma 
				if((updt_dtl[23].equalsIgnoreCase("IBARL") && updt_dtl[10].equalsIgnoreCase("LB") && coll_label_gen_rule.equalsIgnoreCase("G"))||(updt_dtl[23].equalsIgnoreCase("IBARL") && updt_dtl[10].equalsIgnoreCase("LB") && option_list.equalsIgnoreCase("R"))) // col_label_gen_rule = 'G'added on 7/16/2007 instead of lb_module 
				{
				//	user_id_pwd = "RLrcoLBL "+((String)tabData.get("user_id"))+"/"+((String)tabData.get("user_password"))+"@"+((String)tabData.get("database_name"))+" "+((String)tabData.get("session_id"))+" "+((String)tabData.get("curr_sys_date"))+" "+((String)tabData.get("login_facility_id")) + " "+ updt_dtl[7]+" "+updt_dtl[0] +" "+updt_dtl[1]+" "+ updt_dtl[2];
					user_id_pwd = "RLrcoLBL "+((String)tabData.get("user_id"))+"/"+((String)tabData.get("user_password"))+"@"+((String)tabData.get("database_name"))+" "+((String)tabData.get("session_id"))+" "+((String)tabData.get("curr_sys_date"))+" "+updt_dtl[22] + " "+ updt_dtl[7]+" "+updt_dtl[0] +" "+updt_dtl[1]+" "+ updt_dtl[2];
					if(option_list.equalsIgnoreCase("R")){
						//---IN043570/Start---
						String report_ind = "N";
						StringBuffer sb = new StringBuffer();
						sb.append("SELECT NVL(RL_INSTRUMENT_LABEL_PRINT.COLL_LABEL_YN, 'N') AS COLL_LABEL_YN ");
						sb.append("FROM RL_INSTRUMENT_LABEL_PRINT, RL_ONLINE_INSTRUMENT ");
						sb.append("WHERE RL_INSTRUMENT_LABEL_PRINT.operating_facility_id = ? ");
						sb.append("AND RL_INSTRUMENT_LABEL_PRINT.ws_no = ? ");
						sb.append("AND RL_INSTRUMENT_LABEL_PRINT.instrument_code = RL_ONLINE_INSTRUMENT.instrument_code ");
						sb.append("AND RL_INSTRUMENT_LABEL_PRINT.operating_facility_id = RL_ONLINE_INSTRUMENT.operating_facility_id ");
						sb.append("AND NVL(RL_ONLINE_INSTRUMENT.download_yn, 'N') = 'Y' ");
						pstmt2 = connection.prepareStatement( sb.toString());
						pstmt2.setString( 1, ((String)tabData.get("login_facility_id")) ) ;
						pstmt2.setString( 2, ((String)tabData.get("login_at_ws_no")) ) ;
						resultSet = pstmt2.executeQuery();
						if( resultSet!=null){
							if(resultSet.next()){
									report_ind= (String)resultSet.getString("COLL_LABEL_YN");
							}
						}
						closeStatement( pstmt2 ) ;
						if(resultSet!=null){resultSet.close();}
						if("N".equals(report_ind)){		
						//--IN043570/--end
						pstmt2 = connection.prepareStatement( "SELECT NVL(REPORT_EXEC_IND,'PC') EXECIND FROM RL_REPORTS WHERE REPORT_ID = 'RLRCOLBL' AND (OPERATING_FACILITY_ID = ? OR OPERATING_FACILITY_ID = '*A')");
						pstmt2.setString( 1, updt_dtl[22] ) ;
						resultSet = pstmt2.executeQuery();
						if( resultSet!=null){
							if(resultSet.next()){
									report_exec_ind= (String)resultSet.getString("EXECIND");
							}
						}
						closeStatement( pstmt2 ) ;
						//--IN043570/--start
							if(resultSet!=null){resultSet.close();}
						
						}else{
							report_exec_ind = "!~";
						}
						//--IN043570/--end
					}
					//Added if condition to restrict the label print for "New list" option alone IN047220
					if(!"C".equalsIgnoreCase(option_list))
					{
						if("PC".equals(report_exec_ind))
						{
							pstmt2 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT") ) ;
							//pstmt2.setString( 1, ((String)tabData.get("login_facility_id")) ) ;
							pstmt2.setString( 1, updt_dtl[22] ) ;
							pstmt2.setString( 2, ((String)tabData.get("login_by_id")) ) ;
							pstmt2.setString( 3, ((String)tabData.get("login_at_ws_no")) ) ;
							pstmt2.setString( 4, ((String)tabData.get("login_at_ws_no")) ) ;
							pstmt2.setString( 5, ((String)tabData.get("session_id"))  ) ;
							pstmt2.setString( 6, ((String)tabData.get("curr_sys_date")) ) ;   // request_date
							pstmt2.setString( 7, user_id_pwd ) ;
							pstmt2.setString( 8, re_route_printer_id ) ;//IN064835
							result = pstmt2.executeUpdate();
							closeStatement( pstmt2 ) ;
						}else if("RC".equals(report_exec_ind)||"RS".equals(report_exec_ind))
						{
							map.put("report_exec_ind"+count_records,report_exec_ind);	
							//map.put("specimen_no"+count_records,specimen_no);
							map.put("specimen_no"+count_records,updt_dtl[25]);
							map.put("order_id_"+count_records,updt_dtl[0]);
							map.put("source_type"+count_records,updt_dtl[1]);	 // source_type
							map.put("source_code"+count_records,updt_dtl[2]);	 // source_code
							map.put("order_type_code"+count_records,updt_dtl[7]);	 // order_type_code
							map.put("orderingFacility"+count_records,updt_dtl[22]);	 // orderingFacility    //IN034769
							map.put("specimen_type"+count_records,updt_dtl[3]);	//IN071820
							count_records++;		//[IN032796]
							map.put("count_records",count_records);
						}
					}//IN047220
				}	
				//else if(((String)tabData.get("lb_module")).equalsIgnoreCase("N") && updt_dtl[10].equalsIgnoreCase("LB") && coll_label_gen_rule.equalsIgnoreCase("G")) // col_label_gen_rule != 'G'changed on 7/16/2007 for lb_module by uma 
				else if(!updt_dtl[23].equalsIgnoreCase("IBARL") && updt_dtl[10].equalsIgnoreCase("LB") && coll_label_gen_rule.equalsIgnoreCase("G")) // col_label_gen_rule != 'G'added on 7/16/2007 instead of lb_module
				{
					stored_values.put("order_id"+k,updt_dtl[0]);	 // order_id
					stored_values.put("source_type"+k,updt_dtl[1]);	 // source_type
					stored_values.put("source_code"+k,updt_dtl[2]);	 // source_code
					stored_values.put("priority"+k,updt_dtl[5]);	 // priority
					stored_values.put("order_type_code"+k,updt_dtl[7]);	 // order_type_code
					stored_values.put("patient_class"+k,updt_dtl[11]);	 // patient_class
					k++;
					
				}
			}
			
		}
		
		/*********************/
		
		
		if(option_list.equalsIgnoreCase("N") || option_list.equalsIgnoreCase("C")){
			/*pstmt3 = connection.prepareStatement( SQL_OR_CHECK_MODULE_INSTALL_YN) ;
			pstmt3.setString(1,"RL");
			resultSet = pstmt3.executeQuery();
			String install_yn ="";
			while (resultSet.next()) {
				install_yn = resultSet.getString(1);
				if (install_yn == null) install_yn = "N";
			}
		
			closeResultSet( resultSet );
			closeStatement( pstmt3 );
			closeStatement( cstmt ) ;*/

//			if (install_yn.equals("Y") ) {changed on 7/16/2007 for lb_instal_yn 
			if(updt_dtl[23].equalsIgnoreCase("IBARL")){
				String baby_spec_collect_date_time ="";
				String mother_spec_collect_dt_time ="";
				//if (updt_dtl[15].equals("-1")) {
				if(option_list.equalsIgnoreCase("N")){
					//updt_dtl[20]   is mother_patient_id
					//updt_dtl[21]	 is mother_patient_name
					if(!updt_dtl[20].equals("") || !updt_dtl[21].equals("")) {
						cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_RL_NEONATES+" }");

						cstmt.setString(1, ((String)tabData.get("login_facility_id")) );	// I_ORDERING_FACILITY_ID
						cstmt.setString(2, updt_dtl[14].trim() );							// PERFORMING_FACILITY_ID
						cstmt.setString(3, updt_dtl[0].trim() );							// I_ORDER_ID
						cstmt.setString(4, updt_dtl[7].trim() );							// I_ORDER_TYPE_CODE
						cstmt.setString(5, updt_dtl[20].trim() );							// I_PATIENT_ID
						cstmt.setString(6, updt_dtl[21].trim() );							// I_NN_PATIENT_NAME
						cstmt.setLong(7, Long.parseLong(specimen_no) );						// I_BABY_SPEC_NO
						cstmt.execute();	
						closeStatement( cstmt );
					}

				}else if (option_list.equalsIgnoreCase("C")) {
					StringTokenizer stknizer = new StringTokenizer(updt_dtl[9],"~");
					if (stknizer.hasMoreTokens() && option_list.equalsIgnoreCase("C")) {
						
						if(stknizer.countTokens() > 1){
							baby_spec_collect_date_time =stknizer.nextToken();
							mother_spec_collect_dt_time =stknizer.nextToken();
						}else{
							// This part has been commented since it was generating additional specimen no which is not required after collection.
						/*	baby_spec_collect_date_time = getSysDate(connection );
							mother_spec_collect_dt_time = getSysDate(connection ); */
						}
						
					}else if(option_list.equalsIgnoreCase("N")){
						baby_spec_collect_date_time = getSysDate(connection );
						mother_spec_collect_dt_time = getSysDate(connection );
					
					}
					if(!baby_spec_collect_date_time.equals("") && !mother_spec_collect_dt_time.equals("") ){
						cstmt = connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_RL_NEONATES_UPD_COLLECTION+" }");
						cstmt.setString(1, updt_dtl[0].trim()); 			// I_ORDER_ID 
						cstmt.setString(2, updt_dtl[7].trim());				// I_ORDER_TYPE_CODE
						cstmt.setString(3, baby_spec_collect_date_time);	// I_BABY_SPEC_COLLECT_DATE_TIME
						cstmt.setString(4, mother_spec_collect_dt_time); 	// I_MOTHER_SPEC_COLLECT_DT_TIME
						cstmt.setString(5, ((String)tabData.get("login_facility_id")) );	// I_ORDERING_FACILITY_ID  -- Added for [ML-BRU-SCF-1614] - IN055586
						cstmt.execute();	
						
						closeStatement( cstmt );
					}
				}
				
			}// end of install_yn 
		}//end of option_list is New List
         //Adding start for IN072184
            barcode_remarks =(HashMap)tabData.get("barcode_remarks");

			System.err.println("barcode_remarks@@@@===="+barcode_remarks);

           if(barcode_remarks != null){
			   cs = connection.prepareCall("{call PR_INS_PR_BARCODE_SCAN_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?,?,?) }");
                 	cs.setString(1,((String)tabData.get("login_facility_id")));
	                cs.setString(2,((String)barcode_remarks.get("module_id")));
	                cs.setString(3,((String)barcode_remarks.get("menu_id")));
	                cs.setString(4,((String)barcode_remarks.get("sub_menu_id")));
	                cs.setString(5,((String)barcode_remarks.get("patient_id")));
	                cs.setString(6,((String)barcode_remarks.get("encounter_id")));
	                cs.setString(7,"");
                    cs.setString(8,((String)barcode_remarks.get("patient_class")));//Added for MMS-DM--CRF-0170.1
                    cs.setString(9,"");
                    cs.setString(10,"");
	                cs.setString(11,"");
	                cs.setString(12,"");
	                cs.setString(13,"");
	                cs.setString(14,"");
	                cs.setString(15,((String)barcode_remarks.get("entry_type")));
	                cs.setString(16,((String)barcode_remarks.get("resone_code")));
	                cs.setString(17,((String)barcode_remarks.get("resone_desc")));
	                cs.setString(18,((String)tabData.get("login_by_id")));
	                cs.setString(19,((String)tabData.get("login_at_ws_no")));
	                cs.setString(20,((String)tabData.get("login_facility_id")));
	                cs.setString(21,((String)tabData.get("login_by_id")));
	                cs.setString(22,((String)tabData.get("login_at_ws_no")));
	                cs.setString(23,((String)tabData.get("login_facility_id")));
	                cs.registerOutParameter(24,java.sql.Types.VARCHAR);
	                cs.execute();

					closeStatement( cs );

		   }//Adding end for IN072184

		
		/*********************/
		if(result < 1) 
		{
			map.put( "result", new Boolean( false ) ) ;
			connection.rollback();
			nFailedRec++;
			map.put ("message", " Failed... " +updt_dtl[0].trim());
   	    } 
		else  
		{
			connection.commit() ;
			nSuccessRec++;
			map.put( "result", new Boolean( true ) ) ;
			map.put( "stored_values",stored_values) ;
		}
	}

	if(k > 0 )
	{
		stored_values.put("total_recs", String.valueOf(k));
	}

	/******/

	/******/
	StringBuffer strMessage		=	 new StringBuffer();

	if (nSuccessRec > 0)
		strMessage.append("RECORD_MODIFIED");

	if ( nFailedRec > 0)
	{
		if(sbFailedRecs.length() > 0)
		{
			strMessage.append(" (Following orders are not processed: ");
			strMessage.append(sbFailedRecs.toString());
			strMessage.append( " - These would have been proccessed by another user)");
		}
	}

	map.put( "message", strMessage.toString()) ;

	/*if(result < 1) {
		map.put( "result", new Boolean( false ) ) ;
		connection.rollback();
		map.put( "message", "Failed..." ) ;
	} else  {
		connection.commit() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "Operation Completed Successfully..." ) ;
		map.put( "stored_values",stored_values) ;
		messages.append( "RECORD_MODIFIED" ) ;
	}*/
}catch(Exception e){
		e.printStackTrace();
		map.put("message",e.getMessage());//IN034688
		try{
			connection.rollback();
			}catch(Exception ee)
			{
				ee.printStackTrace();
				map.put("message",ee.getMessage());//IN034688
			}
	} finally {
		try {
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2) ;
				closeResultSet( resultSet );
				closeStatement( pstmt3 );
				closeStatement( cstmt ) ;
				closeStatement( cstmt_freq_expl ) ;
				closeStatement( cs );//Added for IN072184
				closeConnection( connection, (Properties)tabData.get( "properties" ) );
			} catch ( Exception fe ) {
				fe.printStackTrace() ;
				map.put("message",fe.getMessage());//IN034688
			}
		//map.put( "message", messages.toString() ) ;
	}
		return map;
	}
	
	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify( HashMap tabData, HashMap sqlMap ) 
	{
		StringBuffer messages = new StringBuffer() ;
		PreparedStatement updateLocnPsmt = null;
		PreparedStatement updateRLIntLocnPsmt = null;//IN043805
		int[] updatedRows = {};
		Connection con = null;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;
		try
		{
			con = getConnection((Properties)tabData.get( "properties" ) );
			updateLocnPsmt = con.prepareStatement((String)sqlMap.get("SQL_OR_UPDATE_PERFORM_LOCN"));
			updateRLIntLocnPsmt = con.prepareStatement((String)sqlMap.get("SQL_OR_UPDATE_PERFORM_LOCN_LB_INTERVAL"));//IN043805
			int totalRecords = Integer.parseInt((String)tabData.get("totalRecords"));
			
			String modifiedById = (String)tabData.get("login_by_id");
			String loginFacilityId = (String)tabData.get("login_facility_id");
			String currDate = (String)tabData.get("curr_sys_date");
			String modifiedAtWS = (String)tabData.get("login_at_ws_no");
			String rl_interval_yn = "N"; //IN043805
			for(int i=0;i<totalRecords;i++)
			{
				String[] data = (String[])tabData.get("data"+i);
				updateLocnPsmt.setString(1,data[0]);
				updateLocnPsmt.setString(2,data[1]);
				updateLocnPsmt.setString(3,modifiedById);
				updateLocnPsmt.setString(4,loginFacilityId);
				updateLocnPsmt.setString(5,currDate);
				updateLocnPsmt.setString(6,modifiedAtWS);
				updateLocnPsmt.setString(7,data[2]);			
				updateLocnPsmt.addBatch();
				//IN043805 - Start
				rl_interval_yn = getRLInteralRecordCount(con,data[2]);
				if("Y".equals(rl_interval_yn))
				{	
					updateRLIntLocnPsmt.setString(1,data[0]);
					updateRLIntLocnPsmt.setString(2,data[2]);			
					updateRLIntLocnPsmt.addBatch();
				}
				//IN043805 - End
			}
			
			updatedRows = updateLocnPsmt.executeBatch();
			//IN043805 - Start
			if(updatedRows.length == totalRecords)
				updateRLIntLocnPsmt.executeBatch();
			//IN043805 - End
			if(totalRecords != 0)
			{
				map.put( "result", new Boolean( true ) );
				map.put( "callOnSuccess", new Boolean( true ) ) ;
				if(updatedRows.length == totalRecords)
				{
					map.put( "message","Operation Completed successfully") ;				
				}
				else
				{
					map.put( "message","Operation Completed Partially") ;				
				}
				con.commit();
			}
			else
			{
				map.put( "result", new Boolean( false ) );
				map.put( "callOnSuccess", new Boolean( false ) ) ;
				map.put( "message","Operation Failed") ;
				con.rollback();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			map.put("message",e.getMessage());//IN034688
		}
		finally
		{
			try
			{
				closeStatement(updateRLIntLocnPsmt);//15950 Fix
				closeStatement( updateLocnPsmt ) ;
				closeConnection( con, (Properties)tabData.get( "properties" ) );			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				map.put("message",e.getMessage());//IN034688
			}
			
		}
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
	private String getSysDate(Connection connection ) throws Exception {
		//Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String 	currentDate = "";


		try {
			//connection = connection = getConnection((Properties) properties ) ;
			pstmt = connection.prepareStatement( CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate = resultSet.getString("sys_date_time")  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				//closeConnection( connection, (Properties) properties );
		}
		return currentDate ;


	}
	private String checkForNull( String val, String dflt_val)
	{
	    if ( val == null || val.equals(""))
	    	return dflt_val;
	    else
		 	return val;
    }

	/*Added by Uma on 2/3/2010 for Specimen Label Generation*/
	public String[] generateSpecimenNo(Connection connection,String L_SOURCE_TYPE,String L_SOURCE_CODE,String L_SPECIMEN_TYPE,String L_SPECIMEN_COLLECT_YN,String L_URGENCY_INDICATOR,String  L_TEST_DATE_TIME,String V_ORDER_TYPE_CODE,String v_dest_appl_id,String V_FACILITY_ID,String facility_id,String perf_facility_id,String language_id,String login_at_ws_no)  throws Exception//IN034769
	{
		CallableStatement cstmt_freq_expl 	= null;
		//ResultSet resultSet 										= null; //Checkstyle
		String coll_label_gen_rule												= "";
		String specimen_no									= "";
		String report_exec_ind				= "";
		String error_code					= "";
		String[] spec_details = new String[4];
		//IN034769,starts
		String l_failure_msg = "";
		//IN034769,ends
		try
		{
				String sql = (String)OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIMEN_GEN");
				cstmt_freq_expl = connection.prepareCall("{ "+sql+" }");
				cstmt_freq_expl.setString(1,L_SOURCE_TYPE);									//	L_SOURCE_TYPE,             
				cstmt_freq_expl.setString(2,L_SOURCE_CODE);									//	L_SOURCE_CODE,             
				cstmt_freq_expl.setString(3,L_SPECIMEN_TYPE);									//	L_SPECIMEN_TYPE,           
				cstmt_freq_expl.setString(4,L_SPECIMEN_COLLECT_YN);									//	L_SPECIMEN_COLLECT_YN,     
				cstmt_freq_expl.setString(5,L_URGENCY_INDICATOR);									//	L_URGENCY_INDICATOR,  
				cstmt_freq_expl.setString(6,L_TEST_DATE_TIME);									//	L_TEST_DATE_TIME,          
				cstmt_freq_expl.setString(7,null);											//	L_SECTION_CODE,            
				cstmt_freq_expl.setString(8,V_ORDER_TYPE_CODE);									//	V_ORDER_TYPE_CODE, 
				cstmt_freq_expl.setString(9,v_dest_appl_id);									//	v_dest_appl_id, 
				cstmt_freq_expl.registerOutParameter(10,java.sql.Types.VARCHAR);				//	L_COLL_LABEL_GEN_RULE,     
				cstmt_freq_expl.registerOutParameter(11,java.sql.Types.VARCHAR);			//	L_SPECIMEN_NO,             
				//MOHBRU-EMR - 09/10/2013 /Start
				//cstmt_freq_expl.setString(12, checkForNull(V_FACILITY_ID,facility_id)+"-"+perf_facility_id);	//IN034769	V_FACILITY_ID - Performing facility id
				cstmt_freq_expl.setString(12, checkForNull(V_FACILITY_ID,facility_id)+"-"+perf_facility_id+"-"+facility_id);   //ord_fac & perf_fac & login_fac
				//MOHBRU-EMR - 09/10/2013 /End
				cstmt_freq_expl.setString(13, "N");											//	V_MODE                     
				cstmt_freq_expl.registerOutParameter(14,java.sql.Types.VARCHAR);				//	L_REPORT_EXEC_IND,     [IN032796]
				cstmt_freq_expl.registerOutParameter(15,java.sql.Types.VARCHAR);			//	L_ERROR_CODE 			 	[IN032796]
				cstmt_freq_expl.setString(16,login_at_ws_no);								// LOGIN_AT_WS_NO				[IN041340]
				cstmt_freq_expl.execute();
				coll_label_gen_rule 	= cstmt_freq_expl.getString(10);
				specimen_no 		 = cstmt_freq_expl.getString(11);
				report_exec_ind		 = cstmt_freq_expl.getString(14);		//[IN032796]
				error_code			 = cstmt_freq_expl.getString(15);		//[IN032796]
				if(coll_label_gen_rule==null) coll_label_gen_rule = "X";
				if(specimen_no==null) specimen_no = "";
				spec_details[0] = coll_label_gen_rule;
				spec_details[1] = specimen_no;
				spec_details[2] = report_exec_ind;							//[IN032796]
				spec_details[3] = error_code;								//[IN032796]
				if(error_code==null)//IN034769
					error_code="";//IN034769

				if(!error_code.equals(""))//IN034769,starts
				{
					l_failure_msg = getMessageFromDB(error_code,connection,language_id);
					throw new Exception(l_failure_msg);
					//IN034769,ends
				}//IN034688,ends
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeStatement( cstmt_freq_expl ) ;
		}
		return spec_details;
	}

	//public int updateOrderLineSpecimen(Connection connection,String specimen_no,String login_by_id,String login_at_ws_no,String login_facility_id,String order_id)  throws Exception //commented for IN059646
	public int updateOrderLineSpecimen(Connection connection,String specimen_no,String login_by_id,String login_at_ws_no,String login_facility_id,String order_id,String specimen_date_time )  throws Exception  //modified for IN059646
	{
		PreparedStatement pstmt 	= null;
		int result = 0;
		//String future_order_yn = "N";  //IN059646 //Checkstyle
		int i = 0;  //IN059646
		try
		{
			//IN046180  modified the query
			//pstmt = connection.prepareStatement("Update or_order_line a set accession_num =?,  accession_line_num = order_line_num, order_line_status =nvl( (select order_status_code from or_order_status_code where order_status_type = '20' and not exists (select 1 from or_order_status_code where order_status_code=a.order_line_status and order_type_code>'20')),order_line_status), MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where order_id =? and order_line_status not in (select  order_status_code from or_order_status_code where order_status_type in ('99')) and not exists (select 1 from or_order_line ia,or_order ib where ia.accession_num =? and ia.order_id=ib.order_id and (ib.order_id != ? and ib.performing_facility_id = ?))") ;
			//pstmt = connection.prepareStatement("Update or_order_line a set accession_num =?,  accession_line_num = order_line_num, order_line_status =nvl( (select order_status_code from or_order_status_code where order_status_type = '20' and not exists (select 1 from or_order_status_code where order_status_code=a.order_line_status and ORDER_STATUS_TYPE>'20')),order_line_status), MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where order_id =? /*and order_line_status not in (select  order_status_code from or_order_status_code where order_status_type in ('99'))*/ and not exists (select 1 from or_order_line ia,or_order ib where ia.accession_num =? and ia.order_id=ib.order_id and (ib.order_id != ? and ib.performing_facility_id = ?))") ;
			//IN052417 commented the order_line_status condition to update specimen no to cancelled catalog of a order also //Commented for IN059646
			pstmt = connection.prepareStatement("Update or_order_line a set accession_num =?, future_order_yn = ?, accession_line_num = order_line_num, order_line_status =nvl( (select order_status_code from or_order_status_code where order_status_type = '20' and not exists (select 1 from or_order_status_code where order_status_code=a.order_line_status and ORDER_STATUS_TYPE>'20')),order_line_status), START_DATE_TIME = TO_DATE (?, 'dd/mm/yyyy hh24:mi'), MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where order_id =? /*and order_line_status not in (select  order_status_code from or_order_status_code where order_status_type in ('99'))*/ and not exists (select 1 from or_order_line ia,or_order ib where ia.accession_num =? and ia.order_id=ib.order_id and (ib.order_id != ? and ib.performing_facility_id = ?))") ; // modified for IN059646
			
/*
			pstmt.setString( 1, specimen_no) ;
			pstmt.setString( 2, login_by_id) ;   
			pstmt.setString( 3, login_at_ws_no) ; 
			pstmt.setString( 4, login_facility_id) ; 
			pstmt.setString( 5, order_id) ;
			pstmt.setString( 6, specimen_no) ;
			pstmt.setString( 7, order_id) ;
			pstmt.setString( 8, login_facility_id) ;
*/
//IN059646 Starts
			pstmt.setString( ++i, specimen_no) ;
			pstmt.setString( ++i, "N");  //Changed future flag to N
			pstmt.setString( ++i, specimen_date_time) ;   //update start date to current date
			pstmt.setString( ++i, login_by_id) ;   
			pstmt.setString( ++i, login_at_ws_no) ; 
			pstmt.setString( ++i, login_facility_id) ; 
			pstmt.setString( ++i, order_id) ;
			pstmt.setString( ++i, specimen_no) ;
			pstmt.setString( ++i, order_id) ;
			pstmt.setString( ++i, login_facility_id) ;
//IN059646 Ends
			result = pstmt.executeUpdate();
			closeStatement( pstmt ) ;
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeStatement( pstmt ) ;
		}
		return result;
	}

	//public int updateOrderLine(Connection connection,String specimen_no,String login_by_id,String login_at_ws_no,String login_facility_id,String order_id)  throws Exception  // commented for IN035837 [CRF320 ]
	public int updateOrderLine(Connection connection,String specimen_no,String login_by_id,String login_at_ws_no,String login_facility_id,String order_id,String curr_sys_date, String start_date, String locale)  throws Exception // modified for IN035837 [CRF320 ] IN041200
	{
		PreparedStatement pstmt 	= null;
		int result = 0;
		try
		{
			// modified for IN035837 [CRF320] - START //IN041200
			/*DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy HH:mm");
			Date start_date_con = formatter.parse(start_date);
			Date curr_sys_date_con = formatter.parse(curr_sys_date);  */
			String future_order_yn = "N"; //IN040973
			//if(curr_sys_date_con.before(start_date_con)) 
			//IN041200
			if(DateUtils.isBefore(curr_sys_date,start_date,"DMYHM",locale)){
				//pstmt = connection.prepareStatement("Update or_order_line set accession_num =?,  accession_line_num = order_line_num,  START_DATE_TIME = SYSDATE, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where order_id =? and not exists (select 1 from or_order_line ia, or_order ib where ia.accession_num =? and ia.order_id = ib.order_id and (ib.order_id != ? and ib.performing_facility_id = ?))") ;	 //IN040973
				//pstmt = connection.prepareStatement("Update or_order_line set future_order_yn = ?, accession_num =?,  accession_line_num = order_line_num,  START_DATE_TIME = SYSDATE, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where order_id =? and not exists (select 1 from or_order_line ia, or_order ib where ia.accession_num =? and ia.order_id = ib.order_id and (ib.order_id != ? and ib.performing_facility_id = ?))") ;	 //IN040973
				pstmt = connection.prepareStatement("Update or_order_line set future_order_yn = ?, accession_num =?,  accession_line_num = order_line_num,  START_DATE_TIME = TO_DATE (TO_CHAR(SYSDATE, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi' ), MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where order_id =? and order_category='LB' and not exists (select 1 from or_order_line ia, or_order ib where ia.accession_num =? and ia.order_id = ib.order_id  and ia.order_category = ib.order_category and ia.order_category ='LB' and (ib.order_id != ? and ib.performing_facility_id = ?))") ;	 //IN048703
			}
			else {
				pstmt = connection.prepareStatement("Update or_order_line set accession_num =?,  accession_line_num = order_line_num, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where order_id =?  and order_category='LB'  and not exists (select 1 from or_order_line ia, or_order ib where ia.accession_num =? and ia.order_id = ib.order_id and ia.order_category = ib.order_category and ia.order_category ='LB' and (ib.order_id != ? and ib.performing_facility_id = ?))") ;						
			}
			// modified for IN035837 [CRF320] - END
			int i = 0;					
			/*
			pstmt.setString( 1, specimen_no ) ;
			pstmt.setString( 2, login_by_id ) ;   
			pstmt.setString( 3, login_at_ws_no ) ; 
			pstmt.setString( 4, login_facility_id  ) ; 
			pstmt.setString( 5, order_id ) ;
			pstmt.setString( 6, specimen_no  ) ;
			pstmt.setString( 7, order_id ) ;
			pstmt.setString( 8, login_facility_id ) ;
			*/  //IN040973
			//if(curr_sys_date_con.before(start_date_con)) { //IN041200
			if(DateUtils.isBefore(curr_sys_date,start_date,"DMYHM",locale)){	
				pstmt.setString( ++i, future_order_yn ) ;
			}
			pstmt.setString( ++i, specimen_no ) ;
			pstmt.setString( ++i, login_by_id ) ;   
			pstmt.setString( ++i, login_at_ws_no ) ; 
			pstmt.setString( ++i, login_facility_id  ) ; 
			pstmt.setString( ++i, order_id ) ;
			pstmt.setString( ++i, specimen_no  ) ;
			pstmt.setString( ++i, order_id ) ;
			pstmt.setString( ++i, login_facility_id ) ;
			result = pstmt.executeUpdate();
			closeStatement( pstmt ) ;
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeStatement( pstmt ) ;
		}
		return result;
	}
	
	//IN034769,starts
	public String getMessageFromDB(String messageRef,Connection con,String language_id)
	{
		PreparedStatement msgPrepStmet = null;
		ResultSet msgResSet = null;
		String l_failure_message = "";
		
		try
		{
			msgPrepStmet = con.prepareStatement("SELECT MESSAGE_TEXT_SYSDEF FROM SM_MESSAGE_LANG_VW WHERE MESSAGE_REF = ? and language_id = ?");
			msgPrepStmet.setString( 1, messageRef ) ;			
			msgPrepStmet.setString( 2, language_id ) ;			

			msgResSet = msgPrepStmet.executeQuery();

			while(msgResSet.next())
			{
				l_failure_message = msgResSet.getString("MESSAGE_TEXT_SYSDEF");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet( msgResSet );
				closeStatement( msgPrepStmet );					
			}
			catch (Exception ie)
			{
				ie.printStackTrace();
			}
		}

		return l_failure_message;
	}
	//IN034769,ends
	//IN043805 - Start
	public String  getRLInteralRecordCount(Connection connection, String order_id) throws Exception 
	{
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String rl_interval_YN		= "N";
		int count					= 0;

		try 
		{
			pstmt = connection.prepareStatement("SELECT count(*) FROM RL_INTERVAL_TEST_SPECIMENS WHERE order_id = ? ") ;
			pstmt.setString(1,order_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null )   
			{
				if(resultSet.next())
				{
					count	 = resultSet.getInt(1);
				}
			}	
			
			if(count > 0)
				rl_interval_YN = "Y";
			else
				rl_interval_YN = "N";
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
				throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
		}

		return rl_interval_YN;
	}
	//IN043805 - End
}
