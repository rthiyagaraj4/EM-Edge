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
17/09/2012    IN034298       Ramesh G    	Presently Category Coding is reflected on reports coming from LIS but not on reports printed from HIS(CA)  
19/12/2012    IN036018       Chowminya G    Order Request can not print out  - Existing Order Screen
08/01/2013    IN034751	     Chowminya G    After amend order, change data in clinical comments and date time. System don’t change data when print report. 
03/07/2013    IN039857		 Chowminya G    Print Button from result view page for LB order
17/07/2013    IN041760		 Chowminya G    Report not printed when we Print From Existing Orders if 3tier setup not done
22/07/2013    IN041760.1	 Chowminya G    Report not printed when we Print From Existing Orders if 3tier setup not done
24/01/2014	  IN046592		 Ramesh G		Manage Specimen is taking more than 40 seconds to complete after clicking on Record 
											when multiple records are selected. The response time is very slow.
22/04/2014    IN042962		 Chowminya      CRF:Print Order Sheet From Existing Orders		
25/02/2015	  IN053439		 Vijayakumar K	MMS-QF-SCF-0486 [IN:053439] - Not able to print the 
											result – showing status partial resulted and colour status Expired		
18/03/2015	  IN054500		Vijayakumar K	Specimen result report is not printing 
											for Order Tracking. Note: Specimen Result Report is printing form existing orders.		
------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------									
26/05/2015		IN054720	 Vijayakumar K  	04/06/2015		Ramesh Goli		ML-BRU-SCF-1580 [IN:054720]				
28/05/2015		IN052230		Karthi L										Order Management-Missing specimens-Dispatch Slip
28/7/2015       IN056438        Akbar           28/7/2015       Sunil Kumar KV  MMS-DM-SCF-0064
30/07/2015		IN056670	 Vijayakumar K		30/07/2015		Dinesh T		GHL-SCF-949 [IN:056670]					
23/11/2015	 	IN053846		Karthi L										The prescription printing automatically
01/04/2016		IN031526		Raja S											System does not print the record in Thai language. It prints 																				only in English.
04/04/2016		IN031524		Raja S											System does not print the records in both English and Thai 																					screen for normal days also.
26/07/2017	IN064835		Vijayakumar K									ML-MMOH-CRF-0578.1 [IN:064835]
15/12/2017	   IN065942	       Dinesh T	        15/12/2017	    Ramesh G		In Nuclear medicine  department we required the barcode functionality at the time of Registration of order,required patient Id,patient name,age,sex,register date and name of 																	study.
12/2/2018		IN065593	Kamalakannan G		12/2/2018		Ramesh G		print_struck_issue(AMS-SCF-0615)
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
07/09/2018   IN068616		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
21/05/2019   IN070426		Ramya Maddena    21/05/2019		Ramesh G		Ml-MMOH-SCF-1241
12/12/2019	 IN071160		Nijitha S						Ramesh G		GHL-SCF-1447
28/06/2020		IN071820		Ramesh G		28/06/2020		Ramesh G		ML-MMOH-SCF-1413
16/03/2021	 15950			Nijitha S										Common-ICN-0030		
24/02/2022	 25671			Ramesh G										NMC-JD-CRF-0091.2		
-------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.*;
import javax.servlet.http.*;                

import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.net.URL;//IN064835
import java.net.URLConnection;//IN064835

public class OnLinePrinting extends OrAdapter implements java.io.Serializable 
{

	protected String order_type_code 		= "";
	protected String order_type_desc 		= "";
	//protected String ord_consent_reqd_yn 	= "";
	protected String total_records 			= "";
	protected String includeESignature 			= ""; //25671
	//protected String pract_id 				= "";
	//protected String security_level 		= "";
	protected String facility_id 			= "";
	protected String specimen_no			= "";
	protected String order_line_num			= "";//IN061961
	protected String order_catalog_code			= "";//IN061961
	protected String view_by			= "";//IN061961
	//protected Hashtable allValues 			= new Hashtable();
	StringBuffer traceVals = new StringBuffer();
	//HttpServletRequest request				= null;
	//HttpServletResponse response			= null;
	//public String chk = "";
	//java.util.Properties props = null;
	//  public OnLinePrinting(){

	public OnLinePrinting()
	{
		//try{
			//traceVals.append("---------IN CONSTRUCTOR----" );
			//this.request = request;
			//this.response = response;
			//onlineReports	= new ecis.utils.OnlineReports() ;
 			//javax.servlet.http.HttpSession session = request.getSession(false);

			//java.util.Enumeration enum = session.getAttributeNames() ;
			//while( enum.hasMoreElements() )
			//{
			//String e_name = (String)enum.nextElement() ;

			//}
			//props = (Properties) session.getValue( "jdbc" );

		//}catch(Exception e){

		//	e.printStackTrace();
		//}
	}

	public void setMode(String mode)
	{					
		this.mode = mode;	
	}
	public void setTotalRecs(String total_records)
	{		
		this.total_records = total_records;	
	}
	//25671 Start.
	public void setIncludeESignature(String includeESignature)
	{		
		this.includeESignature = includeESignature;	
	}
	//25671 End.
	public void setFacilityId(String facility_id)
	{		
		this.facility_id = facility_id;	
	}

	public String getMode()
	{					
		return mode;	
	}
	public String getTotalRecs()
	{				
		return total_records;	
	}
	//25671 Start.
	public String getIncludeESignature()
	{
		return includeESignature;
	}
	//25671 End.
	public String getFacilityId()
	{				
		return facility_id;
	}

	public HashMap callOnlinePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		String   login_at_ws_no  =  p.getProperty("client_ip_address") ;//Ramesh
		HashMap map = new HashMap() ;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;		
		PreparedStatement pstmt1 	= null;	//IN034298
		CallableStatement pstmt2 	= null;	//IN034298
		PreparedStatement rep_pstmt 	= null;
		PreparedStatement rep_pstmt_ref 	= null;
		PreparedStatement pstmt_chldorderlst	= null;//IN053439
		PreparedStatement pstmt_specimen_no	 = null; //IN056670
		ResultSet resultSet 		= null;
		ResultSet resultSet1 		= null;		//IN034298
		ResultSet repResultSet 		= null;
		ResultSet repResultSetRef 		= null;
		ResultSet rschildor_lst 		= null;//IN053439
		ResultSet rs_specimen_no		= null; //IN056670
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		String order_id = "";
		String patient_class = "";
		String priority = "";
		setAll(hashValues);
		String includeESignature=getIncludeESignature(); //25671
		total_records	= checkForNull(total_records,"0");
		int int_total_records = Integer.parseInt(total_records);

		String print_ord_at_dest_yn 			= "";
		String ord_dest_routine_queue_dflt 		= "";
		String print_ord_at_src_yn 				= "";
		String ord_dest_routine_queue_2			= "";
		String location_type					= "";
		String location_code					= "";
		String report_id						= "";
		String failed_orders 					= "Order printing Rule is not defined for the following : ";
		int no_of_fails							= 0;
		String to_be_executed				 	= "";
		String module_id						= "OR";
		String order_entry						= "";
		String order_category                   = "";
		String c_report_id						= "";
		String p_user_name						= (String)session.getAttribute("login_user");
		String rep_group_ref					= "";
		ArrayList  repGroupRef					= new ArrayList();
		//ArrayList  PatIDList					= new ArrayList(); //checkstyle
		//String patient_id						= ""; //Checkstyle
		String child_order_id 					= ""; //IN053439
		String cont_order_ind					= ""; //IN053439

		String performing_facility_id			= "";	//IN054720
		String l_specimen_no					= ""; //IN056670
		String print_rule				 	    = "";	//IN053846
		String print_confirm_yn					= ""; 	//IN053846
		boolean continueFlow 					= true; //IN053846
		try 
		{
			connection = ConnectionManager.getConnection() ;
			//KAUH - Performaing issue - Akbar - start
			//rep_pstmt  = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ONLINE_REPORT_ID")) ;
			rep_pstmt  = connection.prepareStatement("SELECT DISTINCT  A.REP_GROUP_REF,B.CUST_REPORT_ID CUST_REPORT_ID FROM OR_ORDER A, OR_CUSTOM_REPORTS B WHERE A.ORDER_ID=? AND A.CUST_REPORT_ID=B.CUST_REPORT_ID(+)") ;
			//KAUH - Performaing issue - Akbar - ends
			//[IN056438]/Start
			//rep_pstmt_ref  = connection.prepareStatement("select rep_group_ref from or_order where order_id=?") ;
			rep_pstmt_ref  = connection.prepareStatement("select nvl(rep_group_ref,order_id) rep_group_ref from or_order where order_id=?") ;
			//[IN056438]/Ends
			order_entry = (String)hashValues.get("order_entry");
			print_confirm_yn = hashValues.get("print_confirm_yn")==null?"N":(String)hashValues.get("print_confirm_yn"); //IN053846
			if(order_entry==null) order_entry = "";
				order_entry = checkForNull(order_entry,"");

			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ONLINE_PRINTING") ) ;
			//pstmt_specimen_no = connection.prepareStatement("SELECT ACCESSION_NUM FROM OR_ORDER_LINE WHERE ORDER_ID = ? AND order_line_status IN (SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'OPER_RESULT_HYPER_LINK' AND a.order_status_type = b.order_status_type) AND ROWNUM = 1" ); //IN056670 //Commented  for IN068986
			pstmt_specimen_no = connection.prepareStatement("SELECT ACCESSION_NUM FROM OR_ORDER_LINE WHERE ORDER_ID = ? AND (order_line_status IN (SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'OPER_RESULT_HYPER_LINK' AND a.order_status_type = b.order_status_type)  OR (Order_Line_Status='RG' And Status_Hiperlink_Yn='Y'))  AND ROWNUM = 1" ); //IN068986
			String temSpecimen_no="";//IN065593
			//IN068616 Start.
			boolean isviewLineDtls = false;
			
			if(hashValues.containsKey("isviewLineDtls"))//IN068616 STARTS
			{
				isviewLineDtls             =((Boolean)hashValues.get("isviewLineDtls")).booleanValue();//IN061961
			}//IN068616 ENDS
			for(int i=0; i<int_total_records; i++)
			{
				String chk_val = ((String)hashValues.get("chk"+i));
				
				if(chk_val==null) 
					chk_val = "";
				if(chk_val.equalsIgnoreCase("on")) 
					chk_val="Y"; 
				//Included ViewOrder IN039857
				if( chk_val.equalsIgnoreCase("Y") || order_entry.equalsIgnoreCase("OrderEntry") || order_entry.equalsIgnoreCase("ViewOrder")) 
				{

					if(order_entry.equalsIgnoreCase("OrderEntry"))
					{
						facility_id = (String)hashValues.get("facility_id"+i);
						if(facility_id==null) 
							facility_id = "";
					} 
					else if(order_entry.equalsIgnoreCase("ExistingOrder")||order_entry.equalsIgnoreCase("ViewOrder"))  //Included ViewOrder IN039857
					{
						order_category = (String)hashValues.get("order_category"+i);
						if(order_category == null) 
							order_category = "";
					}
					else if(order_entry.equalsIgnoreCase("AuthoriseOrder")) 
					{
						order_category = (String)hashValues.get("order_category"+i);
						if(order_category == null)
						{
							order_category = "";
						}
					}

					order_type_code = (String)hashValues.get("ord_typ_code"+i);
					order_type_desc = (String)hashValues.get("ord_typ_desc"+i);
					patient_class  	= (String)hashValues.get("patient_class"+i);
					priority  		= (String)hashValues.get("priority"+i);
					order_id		= (String)hashValues.get("ord_id"+i);
					order_line_num		= (String)hashValues.get("order_line_num"+i);//IN061961
					order_catalog_code		= (String)hashValues.get("order_catalog_code"+i);//IN061961
					view_by                   =(String)hashValues.get("view_by"+i);//IN061961
					//IN054500 starts
					//cont_order_ind	= (String)hashValues.get("cont_order_ind"+i);    //IN053439 
					cont_order_ind	= checkForNull((String)hashValues.get("cont_order_ind"+i),"");
					//IN054500 ends
					performing_facility_id = checkForNull((String)hashValues.get("performing_facility_id"+i),""); //IN054720

					if(order_entry.equalsIgnoreCase("ExistingOrder")) 
					{
						rep_pstmt.setString(1 , order_id);
						repResultSet = rep_pstmt.executeQuery();

						if(repResultSet != null)    // Only one record for the module_id
						{
							while(repResultSet.next())
							{
								c_report_id	  = repResultSet.getString("CUST_REPORT_ID")==null?"":repResultSet.getString("CUST_REPORT_ID");				
							}
						}

						rep_pstmt_ref.setString(1 , order_id);
						repResultSetRef = rep_pstmt_ref.executeQuery();

						if(repResultSetRef != null)    // Only one record for the module_id
						{
							while(repResultSetRef.next())
							{
								rep_group_ref	  = repResultSetRef.getString("rep_group_ref")==null?"":repResultSetRef.getString("rep_group_ref");				
							}
						}
					}

					closeResultSet(repResultSet);
					closeResultSet(repResultSetRef);

					if(c_report_id==null) 
						c_report_id="";

					if(hashValues!=null && hashValues.containsKey("source_type"+i))
					{
						location_type	= (String)hashValues.get("source_type"+i);
					}
					else
					{
						location_type	= (String)hashValues.get("location_type"+i);					
					}

					location_code	= (String)hashValues.get("location_code"+i);

					//	location_code="CARD";
					if(order_type_desc == null)
						order_type_desc = "";
					
					//IN041760- Start - Moved the piece of code from the if(resultset.next()) condition as the Lab 2 tier report is not launched if 3 tier setup is not done. 
					//This below logic included for Lab order category alone and should be executed only if IBA lab module installed (2tier)
					pstmt1 = connection.prepareStatement( "SELECT EXT_IMAGE_APPL_ID FROM CA_EXT_IMAGE_APPL WHERE EXT_IMAGE_APPL_ID='IBARL'") ;
					resultSet1 = pstmt1.executeQuery() ;
					String checkIbarl_ = "";
					String error_code = "";
					if(resultSet1.next()){ checkIbarl_ = resultSet1.getString("EXT_IMAGE_APPL_ID");}
					
					closeResultSet(resultSet1); // Common-ICN-0092
					closeStatement( pstmt1 ) ; // Common-ICN-0092
					if("LB".equals(order_category) && "IBARL".equals(checkIbarl_)){
						try
						{
							//IN056670 starts
							//pstmt2 = connection.prepareCall("{ call RL_RES_REPORT_FOR_CA.ins_report_details(?,?,?,?,?,?,?) }");  
							 // pstmt2 = connection.prepareCall("{ call RL_RES_REPORT_FOR_CA.ins_report_details(?,?,?,?,?,?,?,?) }"); 
						if(isviewLineDtls &&  "L".equals(view_by)) //IN061961
							pstmt2 = connection.prepareCall("{ call RL_RES_REPORT_FOR_CA.ins_report_details(?,?,?,?,?,?,?,?,?,?) }");//IN061961
						else
							pstmt2 = connection.prepareCall("{ call RL_RES_REPORT_FOR_CA.ins_report_details(?,?,?,?,?,?,?,?,?,?) }");//IN061961
							//IN056670 ends
							//IN053439 starts
							/*pstmt2.setString(1, facility_id);
							pstmt2.setString(2, "RLRRSENQ");
							pstmt2.setString(3, order_id);
							pstmt2.setString(4, p_user_name);
							pstmt2.setString(5, (String)login_at_ws_no);
							pstmt2.setString(6, null);
							pstmt2.registerOutParameter( 7,  Types.VARCHAR ) ;
						
							pstmt2.execute() ;
							error_code = pstmt2.getString(7);
						
							error_code = checkForNull(error_code,"");
							error_code = error_code==null?"":error_code;
							*/
							
							if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR")) ) 
							{
								//IN056670 starts
								//pstmt_chldorderlst = connection.prepareStatement("SELECT ORDER_ID FROM OR_ORDER_LINE WHERE PARENT_ORDER_ID = ? AND order_line_status IN (SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'OPER_RESULT_HYPER_LINK' AND a.order_status_type = b.order_status_type)" );
								pstmt_chldorderlst = connection.prepareStatement("SELECT ORDER_ID,ACCESSION_NUM FROM OR_ORDER_LINE WHERE PARENT_ORDER_ID = ? AND order_line_status IN (SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'OPER_RESULT_HYPER_LINK' AND a.order_status_type = b.order_status_type)" );
								//IN056670 ends
								pstmt_chldorderlst.setString(1,order_id);
								rschildor_lst = pstmt_chldorderlst.executeQuery() ;
						
								if(rschildor_lst != null)    
								{
									while(rschildor_lst.next())
									{
										child_order_id	  = rschildor_lst.getString("ORDER_ID")==null?"":rschildor_lst.getString("ORDER_ID");
										l_specimen_no	  = checkForNull(rschildor_lst.getString("ACCESSION_NUM"),""); //IN056670
										//IN054720 starts
										//pstmt2.setString(1, facility_id);
									//	if(!temSpecimen_no.equals(l_specimen_no)){//IN065593
										boolean proceed_lab_print_indiv = false;
										
										if("LB".equals(order_category) && isviewLineDtls &&  "L".equals(view_by))
										{
											proceed_lab_print_indiv = 	true;						
										}
										else
										{
											if(!temSpecimen_no.equals(l_specimen_no)){//IN061961
												temSpecimen_no=l_specimen_no;//IN065593
												proceed_lab_print_indiv = true;						
											}
										}
										   if(proceed_lab_print_indiv){//IN061961 ends
										if(!"".equals(performing_facility_id))
											pstmt2.setString(1, performing_facility_id);
										else
											pstmt2.setString(1, facility_id);
										//IN054720 ends
										pstmt2.setString(2, "RLRRSENQ");
										pstmt2.setString(3, child_order_id);
										pstmt2.setString(4, p_user_name);
										pstmt2.setString(5, (String)login_at_ws_no);
										pstmt2.setString(6, null);
										//pstmt2.registerOutParameter( 7,  Types.VARCHAR ) ; //IN056670
										pstmt2.setString(7, l_specimen_no); //IN056670
										pstmt2.registerOutParameter( 8,  Types.VARCHAR ) ; //IN056670
										if(isviewLineDtls &&  "L".equals(view_by))//IN061961
											pstmt2.setString(9, order_catalog_code);//IN061961
										else
											pstmt2.setString(9, null);
										pstmt2.setString(10, includeESignature); //25671
										pstmt2.execute() ;
										//error_code = pstmt2.getString(7); //IN056670
										error_code = pstmt2.getString(8); //IN056670
										error_code = checkForNull(error_code,"");
										error_code = error_code==null?"":error_code;
										}//IN065593
									}
								}
								child_order_id = "";
								closeStatement(pstmt2);//15950 Fix
								closeStatement(pstmt_chldorderlst);//15950 Fix
								closeResultSet(rschildor_lst);
						
							}
							else
							{
								//IN056670 starts
								
								pstmt_specimen_no.setString(1,order_id);
								rs_specimen_no =pstmt_specimen_no.executeQuery();
								if(rs_specimen_no != null)    
								{
									if(rs_specimen_no.next())
									{
										l_specimen_no = checkForNull(rs_specimen_no.getString("ACCESSION_NUM"),"");
									}
								}
								//IN056670 ends
								//IN054720 starts
								//pstmt2.setString(1, facility_id);
								//if(!temSpecimen_no.equals(l_specimen_no)){//IN065593
								//IN061961 starts
								boolean proceed_lab_print_indiv = false;
								
								if("LB".equals(order_category) && isviewLineDtls &&  "L".equals(view_by))
								{
									proceed_lab_print_indiv = 	true;						
								}
								else
								{
									if(!temSpecimen_no.equals(l_specimen_no)){//IN061961
										temSpecimen_no=l_specimen_no;//IN065593										
										proceed_lab_print_indiv = true;						
									}
								}
								   if(proceed_lab_print_indiv){//IN061961 ends
									if(!"".equals(performing_facility_id))
										pstmt2.setString(1, performing_facility_id);
									else
										pstmt2.setString(1, facility_id);
									//IN054720 ends
									pstmt2.setString(2, "RLRRSENQ");
									pstmt2.setString(3, order_id);
									pstmt2.setString(4, p_user_name);
									pstmt2.setString(5, (String)login_at_ws_no);
									pstmt2.setString(6, null);
									//pstmt2.registerOutParameter( 7,  Types.VARCHAR ) ; //IN056670
									pstmt2.setString(7, l_specimen_no); //IN056670								
									pstmt2.registerOutParameter( 8,  Types.VARCHAR ) ; //IN056670
									if(isviewLineDtls &&  "L".equals(view_by))//IN061961
										pstmt2.setString(9, order_catalog_code);//IN061961
									else
										pstmt2.setString(9, null);
									pstmt2.setString(10, includeESignature); //25671
									pstmt2.execute() ;
									//error_code = pstmt2.getString(7); //IN056670
									error_code = pstmt2.getString(8); //IN056670
									error_code = checkForNull(error_code,"");
									error_code = error_code==null?"":error_code;
									l_specimen_no = ""; //IN056670
									closeResultSet(rs_specimen_no); //IN056670
								}//IN065593
							}
							//IN053439 ends
						}
						catch(Exception dummy)
						{
							dummy.printStackTrace();
						}
					}
					//IN041760 - End
					
					
					//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ONLINE_PRINTING") ) ;
					pstmt.clearParameters();
					pstmt.setString( 1, order_type_code ) ;
					pstmt.setString( 2, facility_id ) ;
					pstmt.setString( 3, patient_class) ;

					resultSet = pstmt.executeQuery() ;

					//IN041760.1 - Added this condition to bypass order sheet prints if print given from result completed hyper link
					if( resultSet.next() && !order_entry.equalsIgnoreCase("ViewOrder") ) 
					{
						print_ord_at_dest_yn 		= resultSet.getString("print_ord_at_dest_yn");
						ord_dest_routine_queue_dflt = resultSet.getString("ord_dest_routine_queue_dflt");
						print_ord_at_src_yn 		= resultSet.getString("print_ord_at_src_yn");
						//	ord_dest_routine_queue_1 	= resultSet.getString("ord_dest_routine_queue_1");
						ord_dest_routine_queue_2 	= resultSet.getString("ord_dest_routine_queue_2");
						print_rule				 	= resultSet.getString("PRINT_ORD_SHT_RULE_IND");	//IN053846
						if(ord_dest_routine_queue_dflt == null)
						{
							ord_dest_routine_queue_dflt = "";
						}

						if(!repGroupRef.contains(rep_group_ref))
						{
							//IN041760 - Start Commented the this piece of code to avoid the issue when the 3 tier is not configure.  
							//IN034298 Start
							//This below logic included for Lab order category alone and should be executed only if IBA lab module installed (2tier)
						/*	pstmt1 = connection.prepareStatement( "SELECT EXT_IMAGE_APPL_ID FROM CA_EXT_IMAGE_APPL WHERE EXT_IMAGE_APPL_ID='IBARL'") ;
							resultSet1 = pstmt1.executeQuery() ;
							String checkIbarl_ = "";
							String error_code = "";
							if(resultSet1.next()){ checkIbarl_ = resultSet1.getString("EXT_IMAGE_APPL_ID");}
							if("LB".equals(order_category) && "IBARL".equals(checkIbarl_)){
								try
								{
								pstmt2 = connection.prepareCall("{ call RL_RES_REPORT_FOR_CA.ins_report_details(?,?,?,?,?,?,?) }");  
								
								pstmt2.setString(1, facility_id);
								pstmt2.setString(2, "RLRRSENQ");
								pstmt2.setString(3, order_id);
								pstmt2.setString(4, p_user_name);
								pstmt2.setString(5, (String)login_at_ws_no);
								pstmt2.setString(6, null);
								pstmt2.registerOutParameter( 7,  Types.VARCHAR ) ;
								
								pstmt2.execute() ;
								error_code = pstmt2.getString(7);
								error_code = checkForNull(error_code,"");
								error_code = error_code==null?"":error_code;
								}
								catch(Exception dummy)
								{
									dummy.printStackTrace();
								}
							}*/
						//	if("".equals(error_code) ){ //IN036018
								// IN034298 End
							//Commented - IN041760 End
							//if(order_category.equals("PH") && !"S".equals(print_rule) || (!"C".equals(print_rule) && "N".equals(print_confirm_yn))){ // added for IN053846
							if(order_category.equals("PH") && order_entry.equalsIgnoreCase("AuthoriseOrder")) {
								if("O".equals(print_rule) || ("C".equals(print_rule) && "N".equals(print_confirm_yn))){ // added for IN053846
								continueFlow = false;
								}
							}
							if(continueFlow == true) {
							if((priority.trim()).equals("R") || (priority.trim()).equals("U"))
							{
								//print_ord_at_src_yn="Y";
								if((print_ord_at_dest_yn.trim()).equals("Y"))
								{
									if (order_category.equals("PH"))
									{
										report_id	= "PHBOPPRS";
										module_id	= "PH";
									} 
									else 
									{
										module_id = "OR";
										if((ord_dest_routine_queue_dflt.trim()).equals("1"))
										{
											report_id = "ORBORSHT";
										}
										else
										{
											report_id = "ORBORSHT";
										}
										if(!c_report_id.equals(""))
										{
											report_id = c_report_id;
										}
									}

									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,"L",ord_dest_routine_queue_2) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id",module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
							 	}

								if((print_ord_at_src_yn.trim()).equals("Y"))									
								{
									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id	= "PH";
									} 
									else 
									{
										module_id = "OR";
										report_id = "ORBORSRC";

										if(!c_report_id.equals(""))
										{
											report_id = c_report_id;
										}
									}

									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,location_type,location_code) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id", module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}
							}

							if((priority.trim()).equals("S"))
							{
								if((print_ord_at_dest_yn.trim()).equals("Y"))
								{
									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id   = "PH";
									} 
									else 
									{
										module_id = "OR";
										if((ord_dest_routine_queue_dflt.trim()).equals("1"))
										{
											report_id = "ORBORSHT";
										}
										else
										{
											report_id = "ORBORSHT";
										}
										if(!c_report_id.equals(""))
										{
											report_id = c_report_id;
										}
									}

									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,"L",ord_dest_routine_queue_2) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id", module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}

								if((print_ord_at_src_yn.trim()).equals("Y"))
								{
									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id	= "PH";
									} 
									else 
									{
										module_id = "OR";
										report_id = "ORBORSRC";

										if(!c_report_id.equals(""))
										{
											report_id = c_report_id;
										}
									}

									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,location_type,location_code) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id",module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}
							}
							to_be_executed = "1";
							} // added for IN053846
							repGroupRef.add(rep_group_ref);
							//IN034298 Start
							/*} //IN036018
							else{*/
							if(!"".equals(error_code) ){								
								if(no_of_fails == 0)
								{
									//failed_orders += order_type_desc ;
									failed_orders = failed_orders+error_code ;
								}
								else
								{
									//failed_orders += ", "+order_type_desc ;
									failed_orders =failed_orders+", "+error_code ;
								}
								no_of_fails = no_of_fails + 1;

								map.put( "failed_orders",failed_orders);
							}//IN036018
							//IN034298 End.
						}
					}
					else
					{
						if(no_of_fails == 0)
						{
							//failed_orders += order_type_desc ;
							failed_orders = failed_orders+order_type_desc ;
						}
						else
						{
							//failed_orders += ", "+order_type_desc ;
							failed_orders =failed_orders+", "+order_type_desc ;
						}
						no_of_fails = no_of_fails + 1;

						map.put( "failed_orders",failed_orders);
					}
					closeResultSet( resultSet ) ;
				}
			}


			String ReportOutput = "";
			try
			{
			if(!(to_be_executed.equals("")))
			{
				ReportOutput = onlineReports.execute( request, response );					
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if (no_of_fails != 0 )
			{
				//ReportOutput  = ReportOutput+failed_orders  ;	
				ReportOutput  = failed_orders  ;
			}

			if(!(to_be_executed.equals("")))
				map.put( "result", new Boolean( true ) ) ;
			else
				map.put( "result", new Boolean( false ) ) ;
			map.put( "message", ReportOutput) ;
			connection.commit(); //IN041760 
		} 
		catch ( Exception e )	
		{	
			connection.rollback(); //IN041760
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt1 ) ; //IN034298
			closeStatement( pstmt2 ) ; //IN034298
			closeStatement( rep_pstmt ) ;
			closeResultSet( resultSet1 ); //IN034298
			closeStatement( rep_pstmt_ref ) ;
			closeStatement( pstmt_chldorderlst ) ;//IN053439
			closeStatement( pstmt_specimen_no ) ;//IN056670
			closeResultSet( rschildor_lst ); //IN056670 missed to close in finally
			closeResultSet( rs_specimen_no ); //IN056670
			if(connection!=null)	
				ConnectionManager.returnConnection(connection);
		}
		map.put("traceVal", traceVals.toString());
		return map;
	}


	public HashMap printResultEntryReport(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		HashMap map = new HashMap() ;

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		String order_id = "";
		String patient_class = "";
		String priority = "";
		String location_type	= "";
		String location_code	= "";
		String report_srl_no	= "";
		//int result = 0;
	
		setAll(hashValues);

		traceVals.append("1");
		String report_id					= "ORBORREP";
		//String report_id					= "ORBORSHT";
		String print_res_at_dept_yn			= "";
		String res_dept_routine_queue_dflt	= "";
		String res_dept_routine_queue_1		= "";
		String res_dept_routine_queue_2		= "";
		String res_dept_stat_queue_dflt		= "";
		String res_dept_stat_queue_1		= "";
		String res_dept_stat_queue_2		= "";
		String print_res_patloc_yn			= "";
 
 		try
		{
			order_type_code = (String)hashValues.get("ord_typ_code");
			patient_class  	= (String)hashValues.get("patient_class");
			priority  		= (String)hashValues.get("priority");
			
			order_id		= (String)hashValues.get("ord_id");//removed by kavitha
			location_type	= (String)hashValues.get("source_type");
			location_code	= (String)hashValues.get("location_code");
			report_srl_no	= (String)hashValues.get("report_srl_no");
			
			//connection = ConnectionManager.getConnection( props ) ;
			connection = ConnectionManager.getConnection() ;

			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_REPORT_PRINTING") ) ;
			pstmt.setString( 1, order_type_code ) ;
			pstmt.setString( 2, facility_id ) ;
			pstmt.setString( 3, patient_class) ;
 
			resultSet = pstmt.executeQuery() ;
 			if( resultSet.next() )
			{	
				print_res_at_dept_yn		= resultSet.getString("print_res_at_dept_yn");
				res_dept_routine_queue_dflt = resultSet.getString("res_dept_routine_queue_dflt");
				res_dept_routine_queue_1	= resultSet.getString("res_dept_routine_queue_1");
				res_dept_routine_queue_2	= resultSet.getString("res_dept_routine_queue_2");
				res_dept_stat_queue_dflt	= resultSet.getString("res_dept_stat_queue_dflt");
				res_dept_stat_queue_1		= resultSet.getString("res_dept_stat_queue_1");
				res_dept_stat_queue_2		= resultSet.getString("res_dept_stat_queue_2");
				print_res_patloc_yn			= resultSet.getString("print_res_patloc_yn");


				if(print_res_at_dept_yn.trim().equals("Y"))
				{
					String location_code_from_qry = "";
					if(priority.trim().equals("R"))
					{
						if(res_dept_routine_queue_dflt.trim().equals("1"))
							location_code_from_qry = res_dept_routine_queue_1;
						else
							location_code_from_qry = res_dept_routine_queue_2;
					}
					else
					{
						if(res_dept_stat_queue_dflt.trim().equals("1"))
							location_code_from_qry = res_dept_stat_queue_1;
						else
							location_code_from_qry = res_dept_stat_queue_2;
					}
					ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",location_code_from_qry) ;
					report1.addParameter("p_facility_id",facility_id ) ;
					report1.addParameter("p_order_id",order_id) ;
					report1.addParameter("p_report_srl_no",report_srl_no);
					report1.addParameter("p_location_type","L");
					report1.addParameter("p_location_code",location_code_from_qry);
					report1.addParameter("p_language_id",language_id);
					report1.addParameter("p_module_id","OR");//IN036018
					onlineReports.add( report1) ;

					traceVals.append(" 1st Report Printed ");
				}

				if(print_res_patloc_yn.trim().equals("Y"))
				{
					report_id = "ORBRESRC";
					ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( facility_id, "OR",report_id,location_type,location_code) ;
					report2.addParameter("p_facility_id",facility_id ) ;
					report2.addParameter("p_order_id",order_id) ;
					report2.addParameter("p_report_srl_no",report_srl_no);
					report2.addParameter("p_location_type",location_type);
					report2.addParameter("p_location_code",location_code);
					report2.addParameter("p_language_id",language_id);
					report2.addParameter("p_module_id","OR");//IN036018
					onlineReports.add( report2) ;
					traceVals.append(" 2nd Report Printed ");
				}
			}
			else
			{

 				traceVals.append("!!!!!!NO RESULT SET!!!!!!!!!");
			}
			//String ReportOutput = onlineReports.execute( request, response );
			onlineReports.execute( request, response );

			traceVals.append("Reports Executed");
 		} 
		catch ( Exception e )
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null)	ConnectionManager.returnConnection(connection);
			//closeConnection(connection) ;
		}

		map.put("traceVal", traceVals.toString());
		return map;

	}


	/*  Specimen Order On Line Printing(Line)*/
	public void callSpecimenOnLinePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("I am IN OnLinePrintingClass callSpecimenOnLinePrint method.");
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
//		String login_at_ws_no = p.getProperty( "client_ip_address" ) ;//15950
		//HashMap map 				= new HashMap() ;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		setAll(hashValues);
		String order_id 			= "";
		//int result 					= 0;
		total_records				= checkForNull(total_records,"0");
		int int_total_records = Integer.parseInt(total_records);

		String location_type		= "";
		String location_code		= "";
		String report_id			= "ORBSPECI";
		//String order_entry			= checkForNull((String)hashValues.get("order_entry"),"");

		//int order_line_num			= 0; //Checkstyle
		//String order_catalog_code	= ""; //Checkstyle
		try 
		{
			connection = ConnectionManager.getConnection() ;
			//connection = ConnectionManager.getConnection( props ) ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ON_LINE_PRINT") ) ;
			for(int i=0; i<int_total_records; i++)
			{
				order_type_code = (String)hashValues.get("order_type_code"+i);
				order_id		= (String)hashValues.get("order_id"+i);
				
				location_type	= (String)hashValues.get("source_type"+i);
				location_code	= (String)hashValues.get("source_code"+i);
				specimen_no		= (String)hashValues.get("specimen_no"+i);
				//connection = getConnection() ;
				//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ON_LINE_PRINT") ) ;
				//pstmt.clearParameters();
				//pstmt.setString( 1, order_id ) ;

				//resultSet = pstmt.executeQuery() ;
				//while( resultSet!=null && resultSet.next() ) 
				//{
				//order_catalog_code 			= resultSet.getString("order_catalog_code");
				//order_line_num 				= resultSet.getInt("order_line_num");
				//Ramesh Start
				//connection = getConnection() ;
				ecis.utils.OnlineReport report1=null;
			/*	pstmt = connection.prepareStatement( "SELECT NVL(REPORT_EXEC_IND,'PC') EXECIND FROM RL_REPORTS WHERE REPORT_ID = 'RLRCOLBL' AND (OPERATING_FACILITY_ID = ? OR OPERATING_FACILITY_ID = '*A')" ) ;
				pstmt.clearParameters();
				pstmt.setString( 1, facility_id ) ;

				resultSet = pstmt.executeQuery() ;
				if( resultSet!=null){
					if(resultSet.next()){
						String report_exec_ind=(String)resultSet.getString("EXECIND");
						if("RC".equals(report_exec_ind)||"RS".equals(report_exec_ind))
							report_id="RLRCOLBL";
					}
				}
				//Ramesh End
				
				if("RLRCOLBL".equals(report_id)){
					report1= new ecis.utils.OnlineReport( facility_id, "RL",report_id,location_type,location_code) ;
					report1.addParameter("P_PGM_ID",report_id ) ;
					report1.addParameter("P_FACILITY_ID",facility_id) ;			
					report1.addParameter("P_SPECIMEN_NO",specimen_no) ;
					report1.addParameter("P_WS_NO",login_at_ws_no) ;
					report1.addParameter("P_SPEC_ORD_TYPE_CODE",order_type_code);
				
				}else{ */
					report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,location_type,location_code) ;
				report1.addParameter("p_facility_id",facility_id ) ;
				report1.addParameter("p_order_id",order_id) ;
				//report1.addParameter("p_order_catalog_code",order_catalog_code) ;
				report1.addParameter("p_order_catalog_code","") ;
				//report1.addParameter("p_order_line_num",String.valueOf(order_line_num)) ;
				report1.addParameter("p_order_line_num","1") ;
				report1.addParameter("p_user_name","");
				report1.addParameter("p_report_id",report_id);
				report1.addParameter("p_module_id","OR");
				report1.addParameter("p_language_id",language_id);
					//System.out.println("OnlinePrinting.java,report_id=>"+report_id);
				
				//}
				onlineReports.add( report1) ;
				//}
				//closeResultSet( resultSet ) ;
			}//end of for loop


			//String ReportOutput = "";ReportOutput = onlineReports.execute( request, response );

			onlineReports.execute( request, response );

			//map.put( "result", new Boolean( true ) ) ;
			//map.put( "message", ReportOutput) ;
			//System.out.println("I am OUT OnLinePrintingClass callSpecimenOnLinePrint method.");
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) 	ConnectionManager.returnConnection(connection);
			//closeConnection(connection) ;
		}
		//map.put("traceVal", traceVals.toString());
		//return map;

	}

	/*  Specimen Order On Line Printing */
	/* IN071820 Start..*/
	public void callSpecimenOnLinePrintReport(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//IN046592 Start.
		try{
			connection = ConnectionManager.getConnection() ;
			pstmt = connection.prepareStatement( "SELECT NO_OF_COLL_LABELS FROM RL_SPECIMEN_TYPE_CODE WHERE SPECIMEN_TYPE_CODE=?" ) ;
			setAll(hashValues);
			total_records				= checkForNull(total_records,"0");
			int int_total_records = Integer.parseInt(total_records);
			String report_id ="RLRCOLBL";
			ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
			String rerouting_printer = (String)hashValues.get("re_route_printer_id");//IN064835
			int totalRecords = 0;
			setSiteSpecificYN("HISTOLABEL");			
			
			if("".equals(rerouting_printer))//IN064835
			{//IN064835
				for(int i=0;i<int_total_records;i++){
					String language_id = ((String) hashValues.get( "language_id"+i ))== null ? "en" :(String)hashValues.get("language_id"+i);
					String specTypeCode = ((String) hashValues.get( "specimen_type"+i ))== null ? "" :(String)hashValues.get("specimen_type"+i);
					//System.out.println("OnLinePrinting.java---1046----specTypeCode----->"+specTypeCode);
					int number_of_copys = 1;
					
					pstmt.setString( 1, specTypeCode ) ;
					resultSet = pstmt.executeQuery() ;
					//System.out.println("OnLinePrinting.java---1051---Before---get the number_of_copys from db----->"+number_of_copys);
					if( resultSet.next() )
					{
						number_of_copys = Integer.parseInt(resultSet.getString("NO_OF_COLL_LABELS")==null?"1":(String)resultSet.getString("NO_OF_COLL_LABELS"));
						
					}
					//System.out.println("OnLinePrinting.java---1057---After---get the number_of_copys from db----->"+number_of_copys);
					
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					
					if(isSiteSpecific("HISTOLABEL")){
						pstmt = connection.prepareStatement( "SELECT COUNT(*) TOTALREC FROM RL_SECTION_CODE WHERE SECTION_IND = 'HI' AND USE_SAMPLE_ANATOMY_IND = 'SA' AND ORDER_TYPE_CODE=?" ) ;
						pstmt.setString( 1, (String)hashValues.get("order_type_code"+i) ) ;
						resultSet = pstmt.executeQuery() ;
						
						if( resultSet.next() )
						{
							totalRecords = Integer.parseInt(resultSet.getString("TOTALREC")==null?"0":(String)resultSet.getString("TOTALREC"));
							
						}
						if(totalRecords!=0)
							report_id = "RLRSPCHS";
					}
					
					for(int j=0;j<number_of_copys;j++){
						ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( (String)hashValues.get("facility_id"+i), "RL",report_id,(String)hashValues.get("source_type"+i),(String)hashValues.get("source_code"+i)) ;
						
						report1.addParameter("P_PGM_ID",report_id ) ;
						report1.addParameter("P_FACILITY",(String)hashValues.get("facility_id"+i)) ;
						/*System.out.println("=============totalRecords=========>"+totalRecords+"<===========>"+isSiteSpecific("HISTOLABEL"));
						if(totalRecords!=0 && isSiteSpecific("HISTOLABEL")){
							report1.addParameter("P_SPECIMEN_NO",(String)hashValues.get("specimen_no"+i)) ;
							System.out.println("--------P_SPECIMEN_NO----specimen_no---->"+(String)hashValues.get("specimen_no"+i));
						}else{
							*/
							report1.addParameter("P_SPECIMEN_NO",(String)hashValues.get("order_id"+i)) ;
							System.out.println("--------P_SPECIMEN_NO---order_id----->"+(String)hashValues.get("order_id"+i));
						//}
						report1.addParameter("P_WS_NO",(String)hashValues.get("login_at_ws_no"+i)) ;				
						report1.addParameter("p_spec_type_code",(String)hashValues.get("order_type_code"+i));
						report1.addParameter("p_language_id",language_id);						
						onlineReports.add( report1) ;
					}
				}	
			onlineReports.execute( request, response );			
			}//IN064835
			else
			{
				//System.out.println("OnLinePrinting.java---1046----specTypeCode----->"+specTypeCode);
				
				for(int i=0;i<int_total_records;i++){
					
					String language_id = ((String) hashValues.get( "language_id"+i ))== null ? "en" :(String)hashValues.get("language_id"+i);
					String specTypeCode = ((String) hashValues.get( "specimen_type"+i ))== null ? "" :(String)hashValues.get("specimen_type"+i);
					///System.out.println("OnLinePrinting.java---10789----specTypeCode----->"+specTypeCode);
					int number_of_copys = 1;
					//System.out.println("OnLinePrinting.java---1081---Before---get the number_of_copys from db----->"+number_of_copys);
					pstmt.setString( 1, specTypeCode ) ;
					resultSet = pstmt.executeQuery() ;
					if( resultSet.next() )
					{
						number_of_copys = Integer.parseInt(resultSet.getString("NO_OF_COLL_LABELS")==null?"1":(String)resultSet.getString("NO_OF_COLL_LABELS"));
						
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					
					if(isSiteSpecific("HISTOLABEL")){
						pstmt = connection.prepareStatement( "SELECT COUNT(*) TOTALREC FROM RL_SECTION_CODE WHERE SECTION_IND = 'HI' AND USE_SAMPLE_ANATOMY_IND = 'SA' AND ORDER_TYPE_CODE=?" ) ;
						pstmt.setString( 1, (String)hashValues.get("order_type_code"+i) ) ;
						resultSet = pstmt.executeQuery() ;
						
						if( resultSet.next() )
						{
							totalRecords = Integer.parseInt(resultSet.getString("TOTALREC")==null?"0":(String)resultSet.getString("TOTALREC"));
							
						}
						if(totalRecords!=0)
							report_id = "RLRSPCHS";
					}
					
					//System.out.println("OnLinePrinting.java---1089---After---get the number_of_copys from db----->"+number_of_copys);
					for(int j=0;j<number_of_copys;j++){
						ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( (String)hashValues.get("facility_id"+i), "RL",report_id,(String)hashValues.get("source_type"+i),(String)hashValues.get("source_code"+i)) ;
						
						report1.addParameter("P_PGM_ID",report_id ) ;
						report1.addParameter("P_FACILITY",(String)hashValues.get("facility_id"+i)) ;
						//report1.addParameter("P_SPECIMEN_NO",(String)hashValues.get("order_id"+i)) ;
						/*System.out.println("=============totalRecords=========>"+totalRecords+"<===========>"+isSiteSpecific("HISTOLABEL"));
						if(totalRecords!=0 && isSiteSpecific("HISTOLABEL")){
							report1.addParameter("P_SPECIMEN_NO",(String)hashValues.get("specimen_no"+i)) ;
							System.out.println("--------P_SPECIMEN_NO----specimen_no---->"+(String)hashValues.get("specimen_no"+i));
						}else{
						*/
							report1.addParameter("P_SPECIMEN_NO",(String)hashValues.get("order_id"+i)) ;
							System.out.println("--------P_SPECIMEN_NO---order_id----->"+(String)hashValues.get("order_id"+i));
						//}
						report1.addParameter("P_WS_NO",(String)hashValues.get("login_at_ws_no"+i)) ;				
					report1.addParameter("p_spec_type_code",(String)hashValues.get("order_type_code"+i));
						report1.addParameter("p_language_id",language_id);		
						//report1.addParameter("p_re_route_printer_id",rerouting_printer);
						onlineReports.add( report1) ;
					}
				}	
			
			
			executeSpecimenOnlinePrint(rerouting_printer, onlineReports, request, response );
			}
			//IN064835
		}catch ( Exception e )	
		{
			System.out.println(" OnLinePrinting.java======> " + e);
			e.printStackTrace() ;
			throw e ;
		} finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) 	ConnectionManager.returnConnection(connection);
		}
		
		/*
		String order_id = (String)hashValues.get("order_id");
		String facility_id =(String)hashValues.get("facility_id");
		String report_id ="RLRCOLBL";
		String location_type=(String)hashValues.get("source_type");
		String location_code=(String)hashValues.get("source_code");
		String specimen_no =(String)hashValues.get("specimen_no");
		String login_at_ws_no =(String)hashValues.get("login_at_ws_no");
		String spec_ord_type_code =(String)hashValues.get("order_type_code");
		String language_id = ((String) hashValues.get( "language_id" ))== null ? "en" :(String)hashValues.get("language_id");
		
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		try {			
			ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "RL",report_id,location_type,location_code) ;
			report1.addParameter("P_PGM_ID",report_id ) ;
			report1.addParameter("P_FACILITY",facility_id) ;
			report1.addParameter("P_SPECIMEN_NO",order_id) ;
			report1.addParameter("P_WS_NO",login_at_ws_no) ;
			//report1.addParameter("P_SPEC_ORD_TYPE_CODE",spec_ord_type_code);
			report1.addParameter("p_spec_type_code",spec_ord_type_code);
			report1.addParameter("p_language_id",language_id);			
			onlineReports.add( report1) ;			
			onlineReports.execute( request, response );				
		}catch ( Exception e )	
		{
			System.out.println(" OnLinePrinting.java======> " + e);
			e.printStackTrace() ;
			throw e ;
		} */
		//IN046592 End.
	}
	/* IN071820 End..*/	 
	public void callConsentFormOnlinePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		Connection connection 				= null;
		PreparedStatement pstmt 			= null;
		ResultSet resultSet 				= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;

		String order_id 					= "";
		String order_line_num				= "";
		String patient_class 				= "";
		String priority 					= "";

		String print_consent_yn 			= "";
//		String consent_routine_queue_dflt 	= "";
		String consent_routine_queue_1		= "";
		String consent_routine_queue_2		= "";
//		String rslt_msg 					= "";
//		String location_type				= "";
//		String location_code				= "";

		total_records						= checkForNull((String)hashValues.get("total_records"),"0");
		int int_total_records 				= Integer.parseInt(total_records);

		String report_id					= "ORBORCON";
		//String order_entry					= checkForNull((String)hashValues.get("order_entry"),"");

		try 
		{
				//connection = ConnectionManager.getConnection( props ) ;
			connection = ConnectionManager.getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CONSENT_FORM_PRINT") ) ;
			for(int i=0; i<int_total_records; i++)
			{
				order_id 		= (String)hashValues.get("order_id"+i);
				order_line_num 	= (String)hashValues.get("order_line_num"+i);
				order_type_code = (String)hashValues.get("order_type_code"+i);
				patient_class  	= (String)hashValues.get("patient_class"+i);
				priority  		= (String)hashValues.get("priority"+i);
				//location_type	= (String)hashValues.get("location_type"+i);
				//location_code	= (String)hashValues.get("location_code"+i);
				facility_id		= (String)hashValues.get("facility_id"+i);

				//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CONSENT_FORM_PRINT") ) ;
				pstmt.clearParameters();
				pstmt.setString( 1, order_type_code ) ;
				pstmt.setString( 2, facility_id ) ;
				pstmt.setString( 3, patient_class) ;

				resultSet = pstmt.executeQuery() ;

						
				while(resultSet!=null && resultSet.next() ) 
				{
					print_consent_yn 			= resultSet.getString("print_consent_yn");
//						consent_routine_queue_dflt 	= resultSet.getString("consent_routine_queue_dflt");
					consent_routine_queue_1 	= resultSet.getString("consent_routine_queue_1");
					consent_routine_queue_2 	= resultSet.getString("consent_routine_queue_2");


					if((print_consent_yn.trim()).equals("Y"))
					{
						if((priority.trim()).equals("R") || (priority.trim()).equals("U"))
						{
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",consent_routine_queue_1) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_order_id",order_id) ;
							report1.addParameter("p_order_line_num",order_line_num) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id",report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
						}
						else if((priority.trim()).equals("S"))
						{
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",consent_routine_queue_2) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_order_id",order_id) ;
							report1.addParameter("p_order_line_num",order_line_num) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id",report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
						}
					}
				}
				closeResultSet( resultSet ) ;
			}


			//String ReportOutput = "";
			onlineReports.execute( request, response );
				//ReportOutput = onlineReports.execute( request, response );

		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection);
			//closeConnection(connection) ;
		}
	}

	public void callOrderEntryPrint(Hashtable orderFormValues, Hashtable specimenValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
					//HttpSession session = request.getSession(false);
	//Properties p;		
	//p = (Properties) session.getValue("jdbc");	
	//String  language_id  = p.getProperty("LOCALE");
			//,Hashtable consentValues,
 			//HashMap map =  null;	//	map =  (HashMap)callOnlinePrint(orderFormValues);
 			// Call the callOrderFormOnlinePrint() method, to print the Order Form

		if(orderFormValues!=null && orderFormValues.size() > 0)
		{
			callOrderFormOnlinePrint(orderFormValues,request, response);
		}

		// Call the callConsentFormOrderEntryOnlinePrint() method , to print the Consent Form
		/*if(consentValues!=null && consentValues.size() > 0)
			callConsentFormOrderEntryOnlinePrint(consentValues,request, response);
		*/
		if(	specimenValues!=null && specimenValues.size() > 0)
		{
			callSpecimenOrderEntryOnLinePrint(specimenValues,request, response);
		}
	}

/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet )
	{
		//allValues = recordSet;
		if(recordSet.containsKey("facility_id"))
		{
			setFacilityId((String)recordSet.get("facility_id"));
		}

		if(recordSet.containsKey("total_recs"))
		{
			setTotalRecs((String)recordSet.get("total_recs"));
		}
		if(recordSet.containsKey("includeESignature"))
		{
			setIncludeESignature((String)recordSet.get("includeESignature"));
		}
		
		this.mode = (String)recordSet.get( "mode" );
	}

	/*  Specimen Order On Line Printing(Header)*/
	public void callSpecimenCollectOnLinePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response ) throws Exception
	{
		//System.out.println("I am IN OnLinePrintingClass callSpecimenCollectOnLinePrint method.");
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		setAll(hashValues);
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1 = null;
		//int result 						= 0;
		//total_records					= checkForNull(total_records,"0");
		//int int_total_records 			= Integer.parseInt(total_records);


		String date_from				= checkForNull((String)hashValues.get("date_from"));
		String date_to					= checkForNull((String)hashValues.get("date_to"));
		String priority					= checkForNull((String)hashValues.get("priority"));
		String location_type			= checkForNull((String)hashValues.get("location_type"));
		String locn						= checkForNull((String)hashValues.get("locn"));
		String locn1					= checkForNull((String)hashValues.get("locn1"));
		String order_type				= checkForNull((String)hashValues.get("order_type"));
		String order_type1				= checkForNull((String)hashValues.get("order_type1"));
		String option					= checkForNull((String)hashValues.get("option"));
		String select_specific_order	= checkForNull((String)hashValues.get("select_specific_order"));
		String patientId				= checkForNull((String)hashValues.get("patientId"));
		String order_id					= checkForNull((String)hashValues.get("order_id"));
		String encounter_id				= checkForNull((String)hashValues.get("encounter_id"));
		//String collection_list			= checkForNull((String)hashValues.get("collection_list"));
		String printLocationType		= checkForNull((String)hashValues.get("printLocationType"));
		String printLocation			= checkForNull((String)hashValues.get("printLocation"));

		//String specimen_no	= checkForNull((String)hashValues.get("specimen_no")); //Checkstyle
		//String login_at_ws_no = p.getProperty( "client_ip_address" ) ; //Checkstyle
		//String report_id				= "ORBSPECI";
		String report_id				= "";
		if (option.equals("D"))
		{
			report_id				= "ORRDPLST";
		} 
		else
		{
			report_id				= "ORRCOLST";
		}

		try 
		{
			//IN031524 Starts
			if (!language_id.equals("en"))
			{
				date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
				date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
				
			}
			//IN031524 Ends
			connection = ConnectionManager.getConnection() ;
		/*	//Ramesh Start				
				pstmt = connection.prepareStatement( "SELECT NVL(REPORT_EXEC_IND,'PC') EXECIND FROM RL_REPORTS WHERE REPORT_ID = 'RLRCOLBL' AND (OPERATING_FACILITY_ID = ? OR OPERATING_FACILITY_ID = '*A')" ) ;
				pstmt.clearParameters();
				pstmt.setString( 1, facility_id ) ;

				resultSet = pstmt.executeQuery() ;
				if( resultSet!=null){
					if(resultSet.next()){
						String report_exec_ind=(String)resultSet.getString("EXECIND");
						if("RC".equals(report_exec_ind)||"RS".equals(report_exec_ind))
							report_id="RLRCOLBL";
					}
				}
				//Ramesh End		
			
			if("RLRCOLBL".equals(report_id)){
				report1= new ecis.utils.OnlineReport( facility_id, "RL",report_id,printLocationType,printLocation) ;
				report1.addParameter("P_PGM_ID",report_id ) ;
				report1.addParameter("P_FACILITY_ID",facility_id) ;			
				report1.addParameter("P_SPECIMEN_NO",specimen_no) ;
				report1.addParameter("P_WS_NO",login_at_ws_no) ;
				report1.addParameter("P_SPEC_ORD_TYPE_CODE",order_type);
			
			}else{ */
				report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,printLocationType,printLocation) ;
				report1.addParameter("P_FACILITY_ID",facility_id ) ;
			report1.addParameter("P_DATE_FROM",date_from ) ;
			report1.addParameter("P_DATE_TO",date_to );
			report1.addParameter("P_PRIORITY",priority);
			report1.addParameter("P_LOCATION_TYPE",location_type);
			report1.addParameter("P_LOCATION_FROM",locn);
			report1.addParameter("P_LOCATION_TO",locn1);
			report1.addParameter("P_ORDER_TYPE_FROM",order_type);
			report1.addParameter("P_ORDER_TYPE_TO",order_type1);
			report1.addParameter("P_OPTION",option);
			report1.addParameter("P_SELECT_SPECIFIC_ORDER",(select_specific_order.equalsIgnoreCase("A"))?"":select_specific_order);
			report1.addParameter("P_PATIENT_ID",patientId);
			report1.addParameter("P_ORDER_ID",order_id);
			report1.addParameter("P_ENCOUNTER_ID",encounter_id);

			report1.addParameter("P_USER_NAME","");
			report1.addParameter("P_REPORT_ID",report_id);
			report1.addParameter("P_MODULE_ID","OR");
			report1.addParameter("p_language_id",language_id);
		//	}
			onlineReports.add( report1) ;

			//onlineReports.execute( request, response );
			//String ReportOutput = "";
			//ReportOutput = onlineReports.execute( request, response );
			onlineReports.execute( request, response );

			//map.put( "result", new Boolean( true ) ) ;
			//map.put( "message", ReportOutput) ;
			//map.put("message","");
			//System.out.println("I am OUT OnLinePrintingClass callSpecimenCollectOnLinePrint method.");
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) 	ConnectionManager.returnConnection(connection);
		}  
			//map.put("traceVal", traceVals.toString());
			//return map;
	}

/*  Specimen Order On Line Printing(Header)*/
	public void callSpecimenDispatchSlipOnLinePrint(HashMap hashValues, HttpServletRequest request, HttpServletResponse response ) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		//setAll(hashValues);
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		String period_from				= checkForNull((String)hashValues.get("period_from"));
		String period_to				= checkForNull((String)hashValues.get("period_to"));
		if(period_from!=null && period_from.length() > 10 )
			period_from					= period_from.substring(0,10); // only date
		if(period_to!=null && period_to.length() > 10 )
			period_to					= period_to.substring(0,10); // only date

		String print_locn_type			= checkForNull((String)hashValues.get("print_locn_type"));
		String print_locn				= checkForNull((String)hashValues.get("print_locn"));
		String patient_id				= checkForNull((String)hashValues.get("patient_id"));
		String location_type			= checkForNull((String)hashValues.get("location_type"));
		String locn						= checkForNull((String)hashValues.get("locn"));
		String locn1					= checkForNull((String)hashValues.get("locn1"));
		String priority					= checkForNull((String)hashValues.get("priority"));
		String facility_id				= checkForNull((String)hashValues.get("facility_id"));
		String ordered_location			= checkForNull((String)hashValues.get("ordered_location"));
		String print_sequ				= checkForNull((String)hashValues.get("print_sequ"));// IN052230
		String report_id				= "ORRDSLST";

  		try
  		{
			//IN031526 STARTS
  			if (!language_id.equals("en"))
			{
				period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
				period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
				
			}
			//IN031526 Ends
			ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id, print_locn_type, print_locn) ;
			
			report1.addParameter("p_date_from",period_from ) ;
			report1.addParameter("p_date_to",period_to );
			//IN031526 Starts
			report1.addParameter("p_from_date",period_from ) ;
			report1.addParameter("p_to_date",period_to );
			//IN031526 Ends
			report1.addParameter("p_patient_id",patient_id );
			report1.addParameter("p_source_type",location_type );
			report1.addParameter("p_source_code_from",locn );
			report1.addParameter("p_source_code_to",locn1 );
			report1.addParameter("p_priority",priority );
			report1.addParameter("p_facility_id",facility_id );
			report1.addParameter("p_department_code",ordered_location );
			report1.addParameter("p_report_id",report_id);
			report1.addParameter("p_module_id","OR");
			report1.addParameter("p_language_id",language_id);
			report1.addParameter("p_print_sequ",print_sequ); // IN052230

			
			onlineReports.add( report1) ;

			onlineReports.execute( request, response );

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		}  
	}

	public HashMap callOnlineRePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		HashMap map = new HashMap() ;
 
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		String order_id = "";
//		String patient_class = "";
//		String priority = "";
//		int result = 0;

		setAll(hashValues);
		total_records	= checkForNull(total_records,"0");
		int int_total_records = Integer.parseInt(total_records);
//		String print_ord_at_dest_yn 			= "";
//		String ord_dest_routine_queue_dflt 		= "";
//		String print_ord_at_src_yn 				= "";
//		String ord_dest_routine_queue_1			= "";
//		String ord_dest_routine_queue_2			= "";
//		String rslt_msg 						= "";
		String location_type					= "";
		String location_code					= "";
		String report_id						= "";
//		String failed_orders 					= "Order printing Rule is not defined for the following : ";
//		int no_of_fails							= 0;
		String to_be_executed				 	= "";
		String module_id						= "OR";
 		String order_entry						= "";
		String order_category                   = "";

		try 
		{

			order_entry = (String)hashValues.get("order_entry");
			if(order_entry==null) order_entry = "";
			order_entry = checkForNull(order_entry,"");

			for(int i=0; i<int_total_records; i++)
			{
				String chk_val = ((String)hashValues.get("chk"+i));
				if(chk_val==null) chk_val = "";
				if( chk_val.equalsIgnoreCase("Y") || order_entry.equalsIgnoreCase("OrderEntry"))
				{
					if(order_entry.equalsIgnoreCase("OrderEntry"))
					{
						facility_id = (String)hashValues.get("facility_id"+i);
						if(facility_id==null) facility_id = "";
					} 
					else if(order_entry.equalsIgnoreCase("ExistingOrder")) {
                        order_category = (String)hashValues.get("order_category"+i);
                        if(order_category == null) order_category = "";
                    }

 					order_type_code = (String)hashValues.get("ord_typ_code"+i);
					order_type_desc = (String)hashValues.get("ord_typ_desc"+i);
				//	patient_class  	= (String)hashValues.get("patient_class"+i);
				//	priority  		= (String)hashValues.get("priority"+i);
					order_id		= (String)hashValues.get("ord_id"	+i);
					location_type	= (String)hashValues.get("source_type");
					location_code	= (String)hashValues.get("location_code"+i);

					if(order_type_desc == null) order_type_desc = "";

					if(location_type.equals("L"))
					{
						if (order_category.equals("PH")) 
						{
							report_id	= "PHBOPPRS";
							module_id	= "PH";
						} 
						else 
						{
							module_id = "OR";
//                                    if((ord_dest_routine_queue_dflt.trim()).equals("1")){
							report_id = "ORBORSHT";
//    								}else{
//    									report_id = "ORBORSHT";
//    								}
						}

						ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,location_type,location_code) ;
						report1.addParameter("p_facility_id",facility_id ) ;
						report1.addParameter("p_order_id",order_id) ;
						report1.addParameter("p_user_name","");
						report1.addParameter("p_report_id",report_id);
						report1.addParameter("p_module_id",module_id);
						report1.addParameter("p_language_id",language_id);
						onlineReports.add( report1) ;
					} 
					else 
					{
						if (order_category.equals("PH")) 
						{
							report_id	= "PHBOPPRS";
							module_id	= "PH";
						} 
						else 
						{
							module_id = "OR";
							report_id = "ORBORSRC";
						}
						ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,location_type,location_code) ;
						report1.addParameter("p_facility_id",facility_id ) ;
						report1.addParameter("p_order_id",order_id) ;
						report1.addParameter("p_user_name","");
						report1.addParameter("p_report_id",report_id);
						report1.addParameter("p_module_id", module_id);
						report1.addParameter("p_language_id",language_id);
						onlineReports.add( report1) ;
					}

					to_be_executed = "1";
				}//end of if condition
			}//end of for loop
		 

			String ReportOutput = "";
			if(!(to_be_executed.equals("")))
			{
				ReportOutput = onlineReports.execute( request, response );
			}
 
			if(!(to_be_executed.equals("")))
				map.put( "result", new Boolean( true ) ) ;
			else
				map.put( "result", new Boolean( false ) ) ;
			map.put( "message", ReportOutput) ;
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		}  
		map.put("traceVal", traceVals.toString());
		return map;

	}


	public HashMap reprintResultEntryReport(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");

		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		traceVals.append("---------here in result entry report----");// + props);
		HashMap map = new HashMap() ;
 		String order_id = "";
	//	String patient_class = "";
	//	String priority = "";
		String location_type	= "";
		String location_code	= "";
		String report_srl_no	= "";
		//int result = 0;
		
		setAll(hashValues);

		traceVals.append("1");
		String report_id					= "ORBORREP";
 		traceVals.append("hashValues ???????."+hashValues);


		try
		{
			order_type_code = (String)hashValues.get("ord_typ_code");
//			patient_class  	= (String)hashValues.get("patient_class");
//			priority  		= (String)hashValues.get("priority");
			order_id		= (String)hashValues.get("ord_id");
			//location_type	= (String)hashValues.get("source_type");//IN070426
			location_type	= (String)hashValues.get("location_type");//IN070426
			location_code	= (String)hashValues.get("location_code");
			report_srl_no	= (String)hashValues.get("report_srl_no");


			if(location_type.equals("L"))
			{
				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,location_type,location_code) ;
				report1.addParameter("p_facility_id",facility_id ) ;
				report1.addParameter("p_order_id",order_id) ;
				report1.addParameter("p_report_srl_no",report_srl_no);
				report1.addParameter("p_location_type",location_type);
				report1.addParameter("p_location_code",location_code);
				report1.addParameter("p_language_id",language_id);
				onlineReports.add( report1) ;
				traceVals.append(" 1st Report Printed ");
			} 
			else 
			{
				report_id = "ORBRESRC";
				ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( facility_id, "OR",report_id,location_type,location_code) ;
				report2.addParameter("p_facility_id",facility_id ) ;
				report2.addParameter("p_order_id",order_id) ;
				report2.addParameter("p_report_srl_no",report_srl_no);
				report2.addParameter("p_location_type",location_type);
				report2.addParameter("p_location_code",location_code);
				report2.addParameter("p_language_id",language_id);
				onlineReports.add( report2) ;
				traceVals.append(" 2nd Report Printed ");
			}
 			//String ReportOutput = onlineReports.execute( request, response );
			onlineReports.execute( request, response );
			traceVals.append("Reports Executed");

		} 
		catch ( Exception e )
		{
			e.printStackTrace() ;
			throw e ;
		}  
		map.put("traceVal", traceVals.toString());
		return map;

	}

	public void callConsentFormOnlineRePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response ) throws Exception
	{
		 HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		String order_id 					= "";
		String order_line_num				= "";
//			String patient_class 				= "";
//			String priority 					= "";

//			String print_consent_yn 			= "";
//			String consent_routine_queue_dflt 	= "";
//			String consent_routine_queue_1		= "";
//			String consent_routine_queue_2		= "";
//			String rslt_msg 					= "";
		String location_type				= "";
		String location_code				= "";

		total_records						= checkForNull((String)hashValues.get("total_records"),"0");
		int int_total_records 				= Integer.parseInt(total_records);

		String report_id					= "ORBORCON";
 
		try 
		{
			for(int i=0; i<int_total_records; i++)
			{
				order_id 		= (String)hashValues.get("order_id"+i);
				order_line_num 	= (String)hashValues.get("order_line_num"+i);
				order_type_code = (String)hashValues.get("order_type_code"+i);
				//patient_class  	= (String)hashValues.get("patient_class"+i);
				//priority  		= (String)hashValues.get("priority"+i);
				location_type	= (String)hashValues.get("location_type"+i);
				location_code	= (String)hashValues.get("location_code"+i);
				facility_id		= (String)hashValues.get("facility_id"+i);

				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,location_type,location_code) ;
				report1.addParameter("p_facility_id",facility_id ) ;
				report1.addParameter("p_order_id",order_id) ;
				report1.addParameter("p_order_line_num",order_line_num) ;
				report1.addParameter("p_user_name","");
				report1.addParameter("p_report_id",report_id);
				report1.addParameter("p_module_id","OR");
				report1.addParameter("p_language_id",language_id);
				onlineReports.add( report1) ;
			}
			onlineReports.execute( request, response );


				//String ReportOutput = onlineReports.execute( request, response );

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		}  
	}

		// Print the Refusal Form
	public void callRefusalFormOnlinePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response ) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		Connection connection 				= null;
		PreparedStatement pstmt 			= null;
		ResultSet resultSet 				= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;

		String order_id 					= "";
		String order_line_num				= "";
		String patient_class 				= "";
		String priority 					= "";
		String patient_id					= "";
		String patient_srl_no				= "";

		String print_refusal_at_dest_yn		= "";
		String print_refusal_at_src_yn		= "";
		String print_refu_at_dest_locn		= "";
		//String refusal_dest_rout_queue_dflt = "";
		String refusal_dest_routine_queue_1	= "";
		String refusal_dest_stat_queue_1	= "";
		String location_type				= "";
		String location_code				= "";
		String report_id					= "ORBRFCON";
		String src_report_id				= "ORBRFSRC";
		total_records						= checkForNull((String)hashValues.get("total_records"),"0");
		int int_total_records 				= Integer.parseInt(total_records);
 
		try
		{
		
			connection = ConnectionManager.getConnection() ;

			for(int i=0; i<int_total_records; i++)
			{
				order_id 		= (String)hashValues.get("order_id"+i);
				order_line_num 	= (String)hashValues.get("order_line_num"+i);
				order_type_code = (String)hashValues.get("order_type_code"+i);
				patient_class  	= (String)hashValues.get("patient_class"+i);
				priority		= (String)hashValues.get("priority"+i);
				facility_id		= (String)hashValues.get("facility_id"+i);
				location_type	= (String)hashValues.get("location_type"+i);
				location_code	= (String)hashValues.get("location_code"+i);
				patient_id		= (String)hashValues.get("patient_id"+i);
				patient_srl_no	= (String)hashValues.get("srl_no"+i);

				if(order_id==null) order_id = "";
				if(order_line_num==null) order_line_num = "";
				if(order_type_code==null) order_type_code = "";
				if(patient_class==null) patient_class = "";
				if(priority==null) priority = "";
				if(facility_id==null) facility_id = "";
				if(location_type==null) location_type = "";
				if(location_code==null) location_code = "";

				if(order_id.equals("") && order_line_num.equals(""))
				{ // When order_id and line_num is not there
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_REPORTS_REFUSAL_LOCN_SELECT") ) ;
					pstmt.setString(1, facility_id);
					resultSet = pstmt.executeQuery() ;
					while(resultSet!=null && resultSet.next() ) 
					{
							print_refu_at_dest_locn 		= resultSet.getString("print_refu_at_dest_locn");
					}
					if(print_refu_at_dest_locn==null) print_refu_at_dest_locn = "";

					if(!print_refu_at_dest_locn.equals(""))
					{
						ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",print_refu_at_dest_locn) ;
						report1.addParameter("p_facility_id",facility_id ) ;
						report1.addParameter("p_srl_no",patient_srl_no) ;
						report1.addParameter("p_patient_id",patient_id) ;
						report1.addParameter("p_user_name","");
						report1.addParameter("p_report_id",report_id);
						report1.addParameter("p_module_id","OR");
						report1.addParameter("p_language_id",language_id);
						onlineReports.add( report1) ;
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				} 
				else 
				{
						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_REFUSAL_FORM_PRINT") ) ;
						pstmt.setString( 1, order_type_code ) ;
						pstmt.setString( 2, facility_id ) ;
						pstmt.setString( 3, patient_class) ;

						resultSet = pstmt.executeQuery() ;
						while(resultSet!=null && resultSet.next() )
						{
							print_refusal_at_dest_yn 		= resultSet.getString("print_refusal_at_dest_yn");
							print_refusal_at_src_yn			= resultSet.getString("print_refusal_at_src_yn");
//								refusal_dest_rout_queue_dflt 	= resultSet.getString("refusal_dest_rout_queue_dflt");
							refusal_dest_routine_queue_1	= resultSet.getString("refusal_dest_routine_queue_1");
							refusal_dest_stat_queue_1 		= resultSet.getString("refusal_dest_stat_queue_1");
							if((print_refusal_at_src_yn.trim()).equals("Y"))
							{
								if(!location_type.equals("") && !location_code.equals("")) 
								{ // Location_type and Location_code not null
									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",src_report_id,location_type,location_code) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_srl_no",patient_srl_no) ;
									report1.addParameter("p_patient_id",patient_id) ;
									report1.addParameter("p_user_name","");
									report1.addParameter("p_report_id",src_report_id);
									report1.addParameter("p_module_id","OR");
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}
							}

							if((print_refusal_at_dest_yn.trim()).equals("Y"))
							{
								if((priority.trim()).equals("R") || (priority.trim()).equals("U"))
								{
									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",refusal_dest_routine_queue_1) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_srl_no",patient_srl_no) ;
									report1.addParameter("p_patient_id",patient_id) ;
									report1.addParameter("p_user_name","");
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id","OR");
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}
								else if((priority.trim()).equals("S"))
								{
									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",refusal_dest_stat_queue_1) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_srl_no",patient_srl_no) ;
									report1.addParameter("p_patient_id",patient_id) ;
									report1.addParameter("p_user_name","");
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id","OR");
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}
							}
						}
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
					}
				}
				//String ReportOutput = onlineReports.execute( request, response );
				onlineReports.execute( request, response );
		} 
		catch ( Exception e )	
		{
				e.printStackTrace() ;
				throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
	} // End of callRefusalFormOnlinePrint

		// Print the Refusal Form
	public void callReferralFormOnlinePrint(Hashtable hashValues,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		Connection connection 				= null;
		PreparedStatement pstmt 			= null;
		ResultSet resultSet 				= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		String patient_class 				= "";
		String priority 					= "";
		String patient_id					= "";
		String patient_srl_no				= "";

		String print_referral_at_dest_yn	= "";
		String print_referral_at_src_yn		= "";
	//	String print_referral_at_dest_locn	= "";
	//	String referral_dest_rout_queue_dflt= "";
		String referral_dest_routine_queue_1= "";
		String referral_dest_stat_queue_1	= "";
		String location_type				= "";
		String location_code				= "";
		String report_id					= "";
		total_records						= checkForNull((String)hashValues.get("total_records"),"0");
		int int_total_records 				= Integer.parseInt(total_records);
		if(int_total_records==0)	int_total_records = 1;
 	 
		try 
		{
			connection = ConnectionManager.getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_REFERRAL_FORM_PRINT") ) ;
			// Atleast one time it should execute 
			for(int i=0; i<int_total_records; i++)
			{ 
				if(total_records.equals("0"))
				{ // When called from SEND OUT function in register order or task list order reporting
					order_type_code = (String)hashValues.get("order_type_code");
					patient_class  	= (String)hashValues.get("patient_class");
					priority		= (String)hashValues.get("priority");
					facility_id		= (String)hashValues.get("facility_id");
					location_type	= (String)hashValues.get("source_type");
					location_code	= (String)hashValues.get("source_code");
					patient_id		= (String)hashValues.get("patient_id");
					patient_srl_no	= (String)hashValues.get("srl_no");
				} 
				else 
				{
					order_type_code = (String)hashValues.get("order_type_code"+i);
					patient_class  	= (String)hashValues.get("patient_class"+i);
					priority		= (String)hashValues.get("priority"+i);
					facility_id		= (String)hashValues.get("facility_id"+i);
					location_type	= (String)hashValues.get("source_type"+i);
					location_code	= (String)hashValues.get("source_code"+i);
					patient_id		= (String)hashValues.get("patient_id"+i);
					patient_srl_no	= (String)hashValues.get("srl_no"+i);
				}

				if(order_type_code==null) order_type_code = "";
				if(patient_class==null) patient_class = "";
				if(priority==null) priority = "";
				if(facility_id==null) facility_id = "";
				if(location_type==null) location_type = "";
				if(location_code==null) location_code = "";

				pstmt.clearParameters();
				pstmt.setString( 1, order_type_code ) ;
				pstmt.setString( 2, facility_id ) ;
				pstmt.setString( 3, patient_class) ;

				resultSet = pstmt.executeQuery() ;

				while(resultSet!=null && resultSet.next() ) 
				{
					print_referral_at_dest_yn 		= resultSet.getString("print_referral_at_dest_yn");
					print_referral_at_src_yn		= resultSet.getString("print_referral_at_src_yn");
				//	referral_dest_rout_queue_dflt 	= resultSet.getString("referral_dest_rout_queue_dflt");
					referral_dest_routine_queue_1	= resultSet.getString("referral_dest_routine_queue_1");
					referral_dest_stat_queue_1 		= resultSet.getString("referral_dest_stat_queue_1");
				 
					if((print_referral_at_src_yn.trim()).equals("Y"))
					{
						if(!location_type.equals("") && !location_code.equals("")) 
						{ // Location_type and Location_code not null
							report_id = "ORBREFSR";
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,location_type,location_code) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_srl_no",patient_srl_no) ;
							report1.addParameter("p_patient_id",patient_id) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id",report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
						}
					}

					if((print_referral_at_dest_yn.trim()).equals("Y"))
					{
						if((priority.trim()).equals("R") || (priority.trim()).equals("U"))
						{
							report_id = "ORBREFDS";
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",referral_dest_routine_queue_1) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_srl_no",patient_srl_no) ;
							report1.addParameter("p_patient_id",patient_id) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id",report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
						}
						else if((priority.trim()).equals("S"))
						{
							report_id = "ORBREFDS";
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",referral_dest_stat_queue_1) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_srl_no",patient_srl_no) ;
							report1.addParameter("p_patient_id",patient_id) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id", report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
						}
					}
				 }
				closeResultSet( resultSet ) ;
			 }//end of for loop
			//String ReportOutput = onlineReports.execute( request, response );
			onlineReports.execute( request, response );
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) 	ConnectionManager.returnConnection(connection);
		}
	 } // End of callReferralFormOnlinePrint


		// Print the Consent Form
	public void callConsentOrderPrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		Connection connection 				= null;
		PreparedStatement pstmt 			= null;
		ResultSet resultSet 				= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;

		String order_id 					= "";
		String order_line_num				= "";
		String patient_class 				= "";
		String priority 					= "";
		String patient_id					= "";
		String patient_srl_no				= "";

		String print_consent_yn				= "";
		String print_consent_at_src_yn		= "";
		//			String print_refu_at_dest_locn		= "";
		//			String consent_routine_queue_dflt	= "";
		String consent_routine_queue_1		= "";
		//			String consent_routine_queue_2		= "";
		String consent_urg_stat_queue_1		= "";
		//		String consent_urg_stat_queue_2		= "";
		//		String consent_urg_stat_queue_dflt	= "";


		String location_type				= "";
		String location_code				= "";
		String report_id					= "ORBMOCON";
		total_records						= checkForNull((String)hashValues.get("total_records"),"0");
		int int_total_records 				= Integer.parseInt(total_records);


		try 
		{
			connection	= ConnectionManager.getConnection() ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CONSENT_FORM_PRINT") ) ;
			for(int i=0; i<int_total_records; i++){
			order_id 		= (String)hashValues.get("order_id"+i);
			order_line_num 	= (String)hashValues.get("order_line_num"+i);
			order_type_code = (String)hashValues.get("order_type_code"+i);
			patient_class  	= (String)hashValues.get("patient_class"+i);
			priority		= (String)hashValues.get("priority"+i);
			facility_id		= (String)hashValues.get("facility_id"+i);
			location_type	= (String)hashValues.get("location_type"+i);
			location_code	= (String)hashValues.get("location_code"+i);
			patient_id		= (String)hashValues.get("patient_id"+i);
			patient_srl_no	= (String)hashValues.get("srl_no"+i);

			if(order_id==null) order_id = "";
			if(order_line_num==null) order_line_num = "";
			if(order_type_code==null) order_type_code = "";
			if(patient_class==null) patient_class = "";
			if(priority==null) priority = "";
			if(facility_id==null) facility_id = "";
			if(location_type==null) location_type = "";
			if(location_code==null) location_code = "";


			pstmt.clearParameters();	
			pstmt.setString( 1, order_type_code ) ;
			pstmt.setString( 2, facility_id ) ;
			pstmt.setString( 3, patient_class) ;

			resultSet = pstmt.executeQuery() ;
			while(resultSet!=null && resultSet.next() ) 
			{
				print_consent_yn 			= resultSet.getString("print_consent_yn");
				print_consent_at_src_yn		= resultSet.getString("print_consent_at_src_yn");
				//							consent_routine_queue_dflt 	= resultSet.getString("consent_routine_queue_dflt");
				consent_routine_queue_1		= resultSet.getString("consent_routine_queue_1");
				consent_urg_stat_queue_1 	= resultSet.getString("consent_urg_stat_queue_1");




				if((print_consent_at_src_yn.trim()).equals("Y"))
				{
					if(!location_type.equals("") && !location_code.equals(""))
					{ // Location_type and Location_code not null
						ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,location_type,location_code) ;
						report1.addParameter("p_facility_id",facility_id ) ;
						report1.addParameter("p_srl_no",patient_srl_no) ;
						report1.addParameter("p_patient_id",patient_id) ;
						report1.addParameter("p_user_name","");
						report1.addParameter("p_report_id",report_id);
						report1.addParameter("p_module_id","OR");
						report1.addParameter("p_language_id",language_id);
						onlineReports.add( report1) ;
					}
				}

				if((print_consent_yn.trim()).equals("Y"))
				{
					if((priority.trim()).equals("R") || (priority.trim()).equals("U"))
					{
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",consent_routine_queue_1) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_srl_no",patient_srl_no) ;
							report1.addParameter("p_patient_id",patient_id) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id",report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
					}
					else if((priority.trim()).equals("S"))
					{
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",consent_urg_stat_queue_1) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_srl_no",patient_srl_no) ;
							report1.addParameter("p_patient_id",patient_id) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id",report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
					}
				}
			}
			closeResultSet( resultSet ) ;
		}
			//String ReportOutput = onlineReports.execute( request, response );
			onlineReports.execute( request, response );
	} 
	catch ( Exception e )	
	{
		e.printStackTrace() ;
		throw e ;
	} 
	finally 
	{
		closeResultSet( resultSet ) ;
		closeStatement( pstmt ) ;
		if(connection!=null) 	ConnectionManager.returnConnection(connection);
	}
 } // End of callConsentOrderPrint


		// To call the printing, for RD and OT
public void callRDOTOnLinePrint(HashMap hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
{
	HttpSession session = request.getSession(false);
	Properties p;		
	p = (Properties) session.getValue("jdbc");	
	String  language_id  = p.getProperty("LOCALE");

	ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
	String location_type					= "O"; // O Always
	String location_code					= "LOCN";  // location_code LOCN

	String order_category					= checkForNull((String)hashValues.get("order_category"));
	String report_id						= "";
	String appt_ref_num						= (String)hashValues.get("appt_ref_num");
	String facility_id						= (String)hashValues.get("facility_id");

	try 
	{
		if(order_category!=null && order_category.equals("RD")) 
		{ 
			report_id					= "RDRORNTF";//RDRNOTIF

			ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "RD",report_id,location_type,location_code) ;
			report1.addParameter("nd_facility_id",facility_id ) ;
			report1.addParameter("nd_appt_ref_num",appt_ref_num ) ;
			report1.addParameter("p_facility_id",facility_id ) ;
			report1.addParameter("p_report_id",report_id);
			report1.addParameter("p_module_id","RD");
			report1.addParameter("p_language_id",language_id);
			onlineReports.add( report1) ;
			onlineReports.execute( request, response );
		}
		else if(order_category!=null && order_category.equals("OT"))
		{
			report_id					= "OTRNOTIF";
			ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OT",report_id,location_type,location_code) ;

				report1.addParameter("nd_facility_id",facility_id ) ;
				report1.addParameter("nd_booking_num",appt_ref_num ) ;
				report1.addParameter("p_facility_id",facility_id ) ;
				report1.addParameter("p_report_id",report_id);
				report1.addParameter("p_module_id","OT");
				report1.addParameter("p_language_id",language_id);
				onlineReports.add( report1) ;
				onlineReports.execute( request, response );
		}
	} 
	catch ( Exception e )
	{

		e.printStackTrace() ;
		throw e ;
	}  
 } // End of callRDOTOnLinePrint
 

		public HashMap callConsentPrint(Hashtable orderFormValues, Hashtable consentFormValues, HttpServletRequest request, HttpServletResponse response) throws Exception{
			//HttpSession session = request.getSession(false);
	//Properties p;		
	//p = (Properties) session.getValue("jdbc");	
	//String  language_id  = p.getProperty("LOCALE");
			HashMap map =  null;
			map			=  (HashMap)callOnlinePrint(orderFormValues, request, response);
			if(consentFormValues!=null && consentFormValues.size() > 0)
				callConsentOrderPrint(consentFormValues, request, response);
			return map;
		}


	public HashMap callOrderFormOnlinePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		HashMap map = new HashMap() ;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement rep_pstmt 	= null;
		PreparedStatement rep_pl_pstmt 	= null;
		PreparedStatement rec_pl_pstmt 	= null;
		ResultSet resultSet 		= null;
		ResultSet repResultSet 		= null;
		ResultSet repPlaceResultSet 		= null;
		ResultSet recPlaceResultSet 		= null;
 		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		String order_id = "";
		String patient_class = "";
		String priority = "";
 		setAll(hashValues);
		total_records	= checkForNull(total_records,"0");
		int int_total_records = Integer.parseInt(total_records);
 		 				
		String print_ord_at_dest_yn 			= "";
		String ord_dest_routine_queue_dflt 		= "";
		String print_ord_at_src_yn 				= "";
 
		String ord_dest_routine_queue_2			= "";
 		String location_type					= "";
		String location_code					= "";
		String report_id						= "";
		String failed_orders 					= "Order printing Rule is not defined for the following : ";
		int no_of_fails							= 0;
		String to_be_executed				 	= "";
		String module_id						= "OR";
 		String order_entry						= "";
 		String patient_id						= "";

		String order_category                   = "";
		String trn_group_ref                   = "";
		String c_report_id						  ="";
		String pl_report_id						  ="";
		String rep_group_ref						  ="";
		String  p_user_name  =(String)session.getAttribute("login_user");
		//ArrayList patIDList                    = new ArrayList(); //Checkstyle
		String print_confirm_yn 			   = "N";//IN042962	
		String print_rule					   = "S";//IN042962	
	 
		try 
		{
			order_entry = (String)hashValues.get("order_entry");
			if(order_entry==null) order_entry = "";
			order_entry = checkForNull(order_entry,"");
			connection = ConnectionManager.getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ONLINE_PRINTING") ) ;

			if(order_entry.equalsIgnoreCase("OrderEntry"))
			{
				trn_group_ref = (String)hashValues.get("trn_group_ref");
				if(facility_id==null) facility_id = "";
				if(trn_group_ref==null) trn_group_ref = "";
				rep_pl_pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ONLINE_PLACE_ORDER_REPORT_ID")) ;
				//rec_pl_pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ONLINE_PRINT_PLACE_ORDER_RECORDS")) ;
				//rec_pl_pstmt = connection.prepareStatement("SELECT a.patient_id, a.SOURCE_TYpE,a.SOURCE_CODE,a.ORDER_ID,b.ORDER_TYPE_CODE,a.ORDERING_FACILITY_ID,a.patient_class,a.priority,a.order_category,b.short_desc order_type_desc FROM OR_ORDER a,or_order_type b WHERE a.order_type_code=b.order_type_code and REP_GROUP_REF=? AND ROWNUM=1") ;
				//rec_pl_pstmt = connection.prepareStatement("SELECT a.patient_id, a.SOURCE_TYpE,a.SOURCE_CODE,a.ORDER_ID,b.ORDER_TYPE_CODE,a.ORDERING_FACILITY_ID,a.patient_class,a.priority,a.order_category,b.short_desc order_type_desc FROM OR_ORDER a,or_order_type b WHERE a.order_type_code=b.order_type_code and REP_GROUP_REF=?	AND ROWNUM=1");//Commentted [IN034751]
				//rec_pl_pstmt = connection.prepareStatement("SELECT a.patient_id, a.source_type, a.source_code, a.order_id,b.order_type_code, a.ordering_facility_id, a.patient_class, a.priority,a.order_category, b.short_desc order_type_desc FROM or_order a, or_order_type b,or_order_line c WHERE c.order_type_code = b.order_type_code   AND c.rep_group_ref = ? and a.order_id=c.order_id") ;
				rec_pl_pstmt = connection.prepareStatement("select * from (SELECT a.patient_id, a.source_type, a.source_code, a.order_id, b.order_type_code, a.ordering_facility_id, a.patient_class, a.priority, a.order_category, b.short_desc order_type_desc,a.ORD_DATE_TIME  FROM or_order a, or_order_type b WHERE a.order_type_code = b.order_type_code AND rep_group_ref = ? order by order_id desc) where rownum =1 ");//[IN034751]				
				rep_pl_pstmt.setString(1,trn_group_ref);
				repPlaceResultSet = rep_pl_pstmt.executeQuery();

				//if(repPlaceResultSet != null)    // Only one record for the module_id
				//{
				while(repPlaceResultSet.next())
				{
					pl_report_id = repPlaceResultSet.getString("CUST_REPORT_ID");
					rep_group_ref = repPlaceResultSet.getString("REP_GROUP_REF");
					if(pl_report_id==null)
						pl_report_id ="";					
								
				rec_pl_pstmt.setString(1,rep_group_ref);
				recPlaceResultSet = rec_pl_pstmt.executeQuery();

				while(recPlaceResultSet.next())
				{	
					location_type = recPlaceResultSet.getString("source_type");
					location_code = recPlaceResultSet.getString("source_code");
					facility_id = recPlaceResultSet.getString("ordering_facility_id");
					order_type_code = recPlaceResultSet.getString("order_type_code");
					order_id = recPlaceResultSet.getString("order_id");
					patient_class = recPlaceResultSet.getString("patient_class");
					order_category = recPlaceResultSet.getString("order_category");
					order_type_desc = recPlaceResultSet.getString("order_type_desc");
					priority = recPlaceResultSet.getString("priority");
					patient_id = recPlaceResultSet.getString("patient_id");

						pstmt.clearParameters();
						pstmt.setString( 1, order_type_code ) ;
						pstmt.setString( 2, facility_id ) ;
						pstmt.setString( 3, patient_class) ;
						resultSet = pstmt.executeQuery() ;

						if( resultSet.next() ) 
						{
							print_ord_at_dest_yn 		= resultSet.getString("print_ord_at_dest_yn");
							ord_dest_routine_queue_dflt = resultSet.getString("ord_dest_routine_queue_dflt");
							print_ord_at_src_yn 		= resultSet.getString("print_ord_at_src_yn");
						//	ord_dest_routine_queue_1 	= resultSet.getString("ord_dest_routine_queue_1");
							ord_dest_routine_queue_2 	= resultSet.getString("ord_dest_routine_queue_2");
							print_rule				 	= resultSet.getString("PRINT_ORD_SHT_RULE_IND");	//IN042962
						
							if(ord_dest_routine_queue_dflt == null)
							{
								ord_dest_routine_queue_dflt = "";
							}
						print_confirm_yn = (String)hashValues.get("confirm_reqd_YN");//IN042962	
						//IN042962 Start.
							/*
							When below Conditions is true Order Sheet Printing.
								1. Print_rule equals "S".
								2. Print_rule equals "C" and print_cofirm_yn equlas "Y".
							When below Conditions is true Order Sheet Not Printing.
								1. Print_rule equals "C" and print_cofirm_yn equlas "N".
								2. Print_rule equals "O".
								
							S --- Silent, C --- Confirmation , O --- Offilne
							*/
						if("S".equals(print_rule) || ("C".equals(print_rule) && "Y".equals(print_confirm_yn)))
						{	
						//IN042962 End.
							if((priority.trim()).equals("R") || (priority.trim()).equals("U"))
							{
								if((print_ord_at_dest_yn.trim()).equals("Y"))
								{
									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id	= "PH";
									} 
									else 
									{
										module_id = "OR";
										if((ord_dest_routine_queue_dflt.trim()).equals("1"))
										{
											if(pl_report_id.equals(""))
											{
												report_id = "ORBORSHT";
											}
											else
											{
												report_id = pl_report_id;
											}
										}
										else
										{
											if(pl_report_id.equals(""))
											{
												report_id = "ORBORSHT";
											}
											else
											{
												report_id = pl_report_id;
											}
										}
									}
									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,"L",ord_dest_routine_queue_2) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id",module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
									
								}

								if((print_ord_at_src_yn.trim()).equals("Y"))
								{
									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id	= "PH";
									} 
									else 
									{
										module_id = "OR";
										if(pl_report_id.equals(""))
										{
											report_id = "ORBORSRC";
										}
										else
										{
											report_id = pl_report_id;
										}
									}
									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,location_type,location_code) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id", module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
									}
							}

							if((priority.trim()).equals("S"))
							{
								if((print_ord_at_dest_yn.trim()).equals("Y"))
								{
									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id   = "PH";
									} 
									else 
									{
										module_id = "OR";
										if((ord_dest_routine_queue_dflt.trim()).equals("1"))
										{
											if(pl_report_id.equals(""))
											{
												report_id = "ORBORSHT";
											}
											else
											{
												report_id = pl_report_id;
											}
										}
										else
										{
											if(pl_report_id.equals(""))
											{
												report_id = "ORBORSHT";
											}
											else
											{
												report_id = pl_report_id;
											}
										}
									}
									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,"L",ord_dest_routine_queue_2) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id", module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}

								if((print_ord_at_src_yn.trim()).equals("Y"))
								{

									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id	= "PH";
									} 
									else 
									{
										module_id = "OR";
										if(pl_report_id.equals(""))
										{
											report_id="ORBORSRC";
										}
										else
										{
											report_id = pl_report_id;
										}
									}

									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,location_type,location_code) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id",module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
									}
							}
							to_be_executed = "1";
							}//IN042962 condition closed here	
						}
						else
						{

							if(no_of_fails == 0)
							{
								failed_orders =failed_orders+order_type_desc ;
							}
							else
							{
								failed_orders = failed_orders+", "+order_type_desc ;
							}
							no_of_fails = no_of_fails + 1;
							map.put( "failed_orders",failed_orders);
						}
				}
				if (recPlaceResultSet != null)recPlaceResultSet.close();//15950						
				}						
				closeResultSet(repPlaceResultSet);
				closeResultSet(recPlaceResultSet);
				closeStatement(rep_pl_pstmt);
				closeStatement(rec_pl_pstmt);
				closeStatement(pstmt);//15950

			}
			
			//KAUH - Performaing issue - Akbar - start
			//rep_pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ONLINE_REPORT_ID")) ;
			rep_pstmt  = connection.prepareStatement("SELECT DISTINCT  A.REP_GROUP_REF,B.CUST_REPORT_ID CUST_REPORT_ID FROM OR_ORDER A, OR_CUSTOM_REPORTS B WHERE A.ORDER_ID=? AND A.CUST_REPORT_ID=B.CUST_REPORT_ID(+)");
			//KAUH - Performaing issue - Akbar - ends
			
			//What is the necessity of the below code,starts
			for(int i=0; i<int_total_records; i++)
			{
				String chk_val = ((String)hashValues.get("chk"+i));
				if(chk_val==null) chk_val = "";
				if( chk_val.equalsIgnoreCase("Y") || order_entry.equalsIgnoreCase("OrderEntry"))
				{
					/*if(order_entry.equalsIgnoreCase("OrderEntry"))
					{
						facility_id = (String)hashValues.get("facility_id"+i);
						if(facility_id==null) facility_id = "";
					} 
					else*/
					if(order_entry.equalsIgnoreCase("ExistingOrder")) 
					{
						order_category = (String)hashValues.get("order_category"+i);
						if(order_category == null) order_category = "";
					
						order_type_code = (String)hashValues.get("ord_typ_code"+i);
						order_type_desc = (String)hashValues.get("ord_typ_desc"+i);
						patient_class  	= (String)hashValues.get("patient_class"+i);
						priority  		= (String)hashValues.get("priority"+i);
						order_id		= (String)hashValues.get("ord_id"	+i);

						rep_pstmt.setString(1,order_id);
						repResultSet = rep_pstmt.executeQuery();

						if(repResultSet != null)    // Only one record for the module_id
						{
							while(repResultSet.next())
							{
								c_report_id = repResultSet.getString("CUST_REPORT_ID");
							}
						}
						closeResultSet(repResultSet);

						if(c_report_id==null)c_report_id ="";
						if(hashValues!=null && hashValues.containsKey("source_type"))
							location_type	= (String)hashValues.get("source_type");
						else
							location_type	= (String)hashValues.get("location_type"+i);

						location_code	= (String)hashValues.get("location_code"+i);
						if(order_type_desc == null) order_type_desc = "";

						//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ONLINE_PRINTING") ) ;
						pstmt.clearParameters();
						pstmt.setString( 1, order_type_code ) ;
						pstmt.setString( 2, facility_id ) ;
						pstmt.setString( 3, patient_class) ;

						resultSet = pstmt.executeQuery() ;
						if( resultSet.next() ) 
						{	
							print_ord_at_dest_yn 		= resultSet.getString("print_ord_at_dest_yn");
							ord_dest_routine_queue_dflt = resultSet.getString("ord_dest_routine_queue_dflt");
							print_ord_at_src_yn 		= resultSet.getString("print_ord_at_src_yn");
						//	ord_dest_routine_queue_1 	= resultSet.getString("ord_dest_routine_queue_1");
							ord_dest_routine_queue_2 	= resultSet.getString("ord_dest_routine_queue_2");

							if(ord_dest_routine_queue_dflt == null)
							{
								ord_dest_routine_queue_dflt = "";
							}

							if((priority.trim()).equals("R") || (priority.trim()).equals("U"))
							{
								if((print_ord_at_dest_yn.trim()).equals("Y"))
								{
									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id	= "PH";
									} 
									else 
									{
										module_id = "OR";
										if((ord_dest_routine_queue_dflt.trim()).equals("1"))
										{
											if(c_report_id.equals(""))
											{
												report_id = "ORBORSHT";
											}
											else
											{
												report_id = c_report_id;
											}
										}
										else
										{
											if(c_report_id.equals(""))
											{
												report_id = "ORBORSHT";
											}
											else
											{
												report_id = c_report_id;
											}
										}
									}

									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,"L",ord_dest_routine_queue_2) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id",module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}

								if((print_ord_at_src_yn.trim()).equals("Y"))
								{
									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id	= "PH";
									} 
									else 
									{
										module_id = "OR";
										if(c_report_id.equals(""))
										{
											report_id = "ORBORSRC";
										}
										else
										{
											report_id = c_report_id;
										}
									}
									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,location_type,location_code) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id", module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}
							}

							if((priority.trim()).equals("S"))
							{
								if((print_ord_at_dest_yn.trim()).equals("Y"))
								{
									if (order_category.equals("PH")) 
									{
										report_id	= "PHBOPPRS";
										module_id   = "PH";
									} 
									else 
									{
										module_id = "OR";
										if((ord_dest_routine_queue_dflt.trim()).equals("1"))
										{
											if(c_report_id.equals(""))
											{
												report_id = "ORBORSHT";
											}
											else
											{
												report_id = c_report_id;
											}
										}
										else
										{
											if(c_report_id.equals(""))
											{
												report_id = "ORBORSHT";
											}
											else
											{
												report_id = c_report_id;
											}
										}
									}
	
									ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,"L",ord_dest_routine_queue_2) ;
									report1.addParameter("p_facility_id",facility_id ) ;
									report1.addParameter("p_order_id",order_id) ;
									report1.addParameter("p_user_name",p_user_name);
									report1.addParameter("p_report_id",report_id);
									report1.addParameter("p_module_id", module_id);
									report1.addParameter("p_language_id",language_id);
									onlineReports.add( report1) ;
								}

								if((print_ord_at_src_yn.trim()).equals("Y"))
								{

										if (order_category.equals("PH")) 
										{
											report_id	= "PHBOPPRS";
											module_id	= "PH";
										} 
										else 
										{
											module_id = "OR";
											if(c_report_id.equals(""))
											{
												report_id = "ORBORSRC";
									}
									else
									{
										report_id = c_report_id;
									}
								}

								ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,location_type,location_code) ;
								report1.addParameter("p_facility_id",facility_id ) ;
								report1.addParameter("p_order_id",order_id) ;
								report1.addParameter("p_user_name",p_user_name);
								report1.addParameter("p_report_id",report_id);
								report1.addParameter("p_module_id",module_id);
								report1.addParameter("p_language_id",language_id);
								onlineReports.add( report1) ;
							}
						}
						to_be_executed = "1";
					}
					else
					{
						if(no_of_fails == 0)
						{
							//failed_orders += order_type_desc ;
							failed_orders =failed_orders+order_type_desc ;
						}
						else
						{
							//failed_orders += ", "+order_type_desc ;
							failed_orders = failed_orders+", "+order_type_desc ;
						}
						no_of_fails = no_of_fails + 1;

						map.put( "failed_orders",failed_orders);
					}
					closeResultSet( resultSet ) ;
				  }
				}//end of if condition
			}//end of for loop
			//?,ends,
			closeStatement(rep_pstmt);
		
			String ReportOutput = "";
			if(!(to_be_executed.equals("")))
			{
				ReportOutput = onlineReports.execute( request, response );
			}
			if (no_of_fails != 0 )
			{
				ReportOutput  = ReportOutput+failed_orders  ;
			}
			 
			if(!(to_be_executed.equals("")))
				map.put( "result", new Boolean( true ) ) ;
			else
				map.put( "result", new Boolean( false ) ) ;
			map.put( "message", ReportOutput) ;
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet( resultSet ) ;
			closeResultSet( repResultSet ) ;
			closeStatement( pstmt ) ;
			closeStatement( rep_pstmt ) ;
			if(connection!=null) 	ConnectionManager.returnConnection(connection);
			//closeConnection(connection) ;
		}
		map.put("traceVal", traceVals.toString());
		return map;

	}
	   
	   // To print the consent form for the order_entry
	public void callConsentFormOrderEntryOnlinePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		Connection connection 				= null;
		PreparedStatement pstmt 			= null;
		ResultSet resultSet 				= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;

		String order_id 					= "";
		String order_line_num				= "";
		String patient_class 				= "";
		String priority 					= "";

		String print_consent_yn 			= "";
		String print_consent_at_src_yn		= "";
		String location_type				= "", location_code = "";

		String consent_routine_queue_1		= "";
		String consent_routine_queue_2		= "";
		total_records						= checkForNull((String)hashValues.get("total_records"),"0");
		int int_total_records 				= Integer.parseInt(total_records);
		String report_id					= "ORBORCON";
		String source_report_id				= "ORBCONSR";
		//String order_entry					= checkForNull((String)hashValues.get("order_entry"),"");
 
		try 
		{
			//connection = ConnectionManager.getConnection( props ) ;
			connection	= ConnectionManager.getConnection() ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CONSENT_FORM_PRINT") ) ;

			for(int i=0; i<int_total_records; i++)
			{
				order_id 		= (String)hashValues.get("order_id"+i);
				order_line_num 	= (String)hashValues.get("order_line_num"+i);
				order_type_code = (String)hashValues.get("order_type_code"+i);
				patient_class  	= (String)hashValues.get("patient_class"+i);
				priority  		= (String)hashValues.get("priority"+i);
				location_type	= (String)hashValues.get("location_type"+i);
				location_code	= (String)hashValues.get("location_code"+i);
				facility_id		= (String)hashValues.get("facility_id"+i);


				//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CONSENT_FORM_PRINT") ) ;
				pstmt.clearParameters();
				pstmt.setString( 1, order_type_code ) ;
				pstmt.setString( 2, facility_id ) ;
				pstmt.setString( 3, patient_class) ;

				resultSet = pstmt.executeQuery() ;

				while(resultSet!=null && resultSet.next() ) 
				{
					print_consent_yn 			= resultSet.getString("print_consent_yn");
					print_consent_at_src_yn		= resultSet.getString("print_consent_at_src_yn");
//						consent_routine_queue_dflt 	= resultSet.getString("consent_routine_queue_dflt");
					consent_routine_queue_1 	= resultSet.getString("consent_routine_queue_1");
					consent_routine_queue_2 	= resultSet.getString("consent_routine_queue_2");

					if((print_consent_yn.trim()).equals("Y"))
					{
						if((priority.trim()).equals("R") || (priority.trim()).equals("U"))
						{
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",consent_routine_queue_1) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_order_id",order_id) ;
							report1.addParameter("p_order_line_num",order_line_num) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id",report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
						}
						else if((priority.trim()).equals("S"))
						{
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,"L",consent_routine_queue_2) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_order_id",order_id) ;
							report1.addParameter("p_order_line_num",order_line_num) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id",report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
						}
					}

					if(print_consent_at_src_yn.equals("Y"))
					{
						if(!location_type.equals("") && !location_code.equals("")) 
						{ // Location_type and Location_code not null
							ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",source_report_id,location_type,location_code) ;
							report1.addParameter("p_facility_id",facility_id ) ;
							report1.addParameter("p_order_id",order_id) ;
							report1.addParameter("p_order_line_num",order_line_num) ;
							report1.addParameter("p_user_name","");
							report1.addParameter("p_report_id",source_report_id);
							report1.addParameter("p_module_id","OR");
							report1.addParameter("p_language_id",language_id);
							onlineReports.add( report1) ;
						}
					}
				}
				closeResultSet( resultSet ) ;
			}
			onlineReports.execute( request, response );
				//ReportOutput = onlineReports.execute( request, response );
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) 	ConnectionManager.returnConnection(connection);
			//closeConnection(connection) ;
		}
	}

	// To print from the specimen form
	public void callSpecimenOrderEntryOnLinePrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		setAll(hashValues);
		String order_id 			= "";
		total_records				= checkForNull(total_records,"0");
		int int_total_records		= Integer.parseInt(total_records);
		String location_type		= "";
		String location_code		= "";
		String report_id			= "ORBSPECI";
		//String order_entry			= checkForNull((String)hashValues.get("order_entry"),"");

		//int order_line_num			= 0;//Checkstyle
		//String order_catalog_code	= "";//Checkstyle
	
		try 
		{
			connection = ConnectionManager.getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ON_LINE_PRINT") ) ;
			for(int i=0; i<int_total_records; i++)
			{
				order_type_code = (String)hashValues.get("order_type_code"+i);
				order_id		= (String)hashValues.get("order_id"+i);
				location_type	= (String)hashValues.get("source_type"+i);
				location_code	= (String)hashValues.get("source_code"+i);
				facility_id		= (String)hashValues.get("facility_id"+i);
				if((order_id.trim().substring(2,4)).equals("XT"))
				{
					location_type	= "L";
					location_code	= "LOCN";
					report_id		= "ORBSPEXT";
				}
				//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ON_LINE_PRINT") ) ;

				/*pstmt.clearParameters();
				pstmt.setString( 1, order_id ) ;
				resultSet = pstmt.executeQuery() ;
				while( resultSet!=null && resultSet.next() ) 
				{
					order_catalog_code 			= resultSet.getString("order_catalog_code");
					order_line_num 				= resultSet.getInt("order_line_num");
				}
				closeResultSet( resultSet ) ;*/

				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,location_type,location_code) ;
				report1.addParameter("p_facility_id",facility_id ) ;
				report1.addParameter("p_order_id",order_id) ;
				//report1.addParameter("p_order_catalog_code",order_catalog_code) ;
				report1.addParameter("p_order_catalog_code","") ;
				//report1.addParameter("p_order_line_num",String.valueOf(order_line_num)) ;
				report1.addParameter("p_order_line_num","1") ;
				report1.addParameter("p_user_name","");
				report1.addParameter("p_report_id",report_id);
				report1.addParameter("p_module_id","OR");
				report1.addParameter("p_language_id",language_id);
				onlineReports.add( report1) ;
				
			}//end of for loop

	//		String Report_output="";
	//		Report_output =	onlineReports.execute( request, response );
			onlineReports.execute( request, response );

 
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection);
			//closeConnection(connection) ;
		}

	}

	/*  Billing Refund Report On Line Printing(Line)
	Added By Uma on 10/14/2009 for SRR20056-CRF-195
	*/
	public void callCancelOrderPrint(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		String  p_user_name  =(String)session.getAttribute("login_user");
			
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		setAll(hashValues);
		String order_id 			= "";
		//int result 					= 0;
		total_records				= checkForNull(total_records,"0");
		int int_total_records = Integer.parseInt(total_records);
		
		String location_type		= "";
		String location_code		= "";
		String report_id			= "ORDISRFD";
		String order_line_num			="";
		String facility_id			="";
		String cont_order_ind = "P";
		
  		try 
		{
				connection = ConnectionManager.getConnection() ;
				pstmt = connection.prepareStatement("select source_code,source_type,cont_order_ind from or_order where order_id=?"); //OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_LOCATION_DETAILS") ) ;
				for(int i=0; i<int_total_records; i++)
				{
					facility_id = (String)hashValues.get("p_facility_id"+i);
					order_id   = (String)hashValues.get("p_order_id"+i);
					order_line_num  = (String)hashValues.get("p_order_line_num"+i);
					
					pstmt.clearParameters();
					pstmt.setString( 1, order_id ) ;
					resultSet = pstmt.executeQuery() ;
					while( resultSet!=null && resultSet.next() ) 
					{
						location_type	= (String)resultSet.getString("source_type");
						location_code	= (String)resultSet.getString("source_code");
						cont_order_ind	= (String)resultSet.getString("cont_order_ind");
					}
					closeResultSet(resultSet);
					updateOrderLineReportDetails(connection,order_id,order_line_num);
					if((cont_order_ind.equalsIgnoreCase("CR"))||((cont_order_ind.equalsIgnoreCase("DR"))))
					{
						cont_order_ind = "P";
					}
					else
					{
						cont_order_ind = "C";
					}
						
					ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "OR",report_id,location_type,location_code) ;
					report1.addParameter("p_facility_id",facility_id ) ;
					report1.addParameter("p_order_id",order_id) ;
					report1.addParameter("p_order_line_num",order_line_num) ;
					report1.addParameter("p_user_name",p_user_name);
					report1.addParameter("p_report_id",report_id);
					report1.addParameter("p_module_id","OR");
					report1.addParameter("p_language_id",language_id);
					report1.addParameter("p_ord_type",cont_order_ind);

					onlineReports.add( report1) ;
				}
					
				closeResultSet( resultSet ) ;
				//end of for loop				
				//String ReportOutput = "";ReportOutput = onlineReports.execute( request, response );

  				onlineReports.execute( request, response );
				//map.put( "result", new Boolean( true ) ) ;
				//map.put( "message", ReportOutput) ;
  				connection.commit();//IN071160
			} 
			catch ( Exception e )	
			{
				connection.rollback();//IN071160
				e.printStackTrace() ;
				throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) 	ConnectionManager.returnConnection(connection);
				//closeConnection(connection) ;
			}
		}

		public void updateOrderLineReportDetails(Connection connection,String order_id,String order_line_num) throws Exception
		{
			PreparedStatement pstmt = null;
			String sql = "update or_order_line set discontinue_refund_yn='Y', dicontinue_refund_date = sysdate where order_id=? and order_line_num=?";
			try
			{
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1 , order_id);
				pstmt.setString(2 , order_line_num);
				pstmt.executeUpdate();
				if (pstmt != null)pstmt.close();//15950
			}
			catch ( Exception e )
			{
				e.printStackTrace();
			}
			finally{
				closeStatement( pstmt ) ; // Common-ICN-0092
			}
		}
		//IN064835 starts
		public String executeSpecimenOnlinePrint(String rerouting_printer,ecis.utils.OnlineReports onlineReports, HttpServletRequest request, HttpServletResponse response ) {
			 
			if ( onlineReports.getReports() == null ) return "Null Value" ;
			String result = "" ;
			
			for( Enumeration e = (onlineReports.getReports()).elements(); e.hasMoreElements(); ) {
			
				ecis.utils.OnlineReport report = (ecis.utils.OnlineReport) e.nextElement() ;
				result = result + processSpecimenOnlinePrint(rerouting_printer, report, request, response ) ;
			}
			result += "<center><b>Report Generated Successfully....</b></center>" ;
			return result ;
		}
		public String processSpecimenOnlinePrint(String p_rerouting_printer,ecis.utils.OnlineReport onlineReport, HttpServletRequest request, HttpServletResponse response)
		{
			
			
			String result       = "<br> " ;
	        Connection con = null;
			Statement stmt= null;
			ResultSet rset=null;
			PreparedStatement pstmt=null;
			CallableStatement cs=null;
	        try {
	            HttpSession session = request.getSession( false ) ;			
	            String reportServer = (String) session.getValue( "report_server" ) ;				
	            String userid       = (String) session.getValue( "report_connect_string" ) ;			

	            String url          = "" ;
	            String report       = "" ;
	            String server       = "" ;
	            String copies       = "" ;
	            String report_mode  = "" ;
	            String queue_name   = "" ;
	            String report_tool  = "" ;
	            String status       = "" ; 
	            String message      = "" ;
				String rep_debug_YN="N"; 
				
				String module_id        = onlineReport.getModuleId() ;
				
	            String report_id        = onlineReport.getReportId() ;
				
	            String dest_locn_type   = onlineReport.getLocationType() ;
				
	            String dest_locn_code   = onlineReport.getLocationCode() ;
				
	            String facility_id  = onlineReport.getFacilityId() ;
	            
	            String reroute_printer = p_rerouting_printer;
				
				Properties p = (Properties) session.getValue( "jdbc" ) ;

				String ws_no = p.getProperty( "client_ip_address" ) ;

	            String report_option    = "P" ;
	
	            String app_server_ip    = "" ;	            
	
				String rep_server_key    = "" ;
	            if ( reportServer       == null ) reportServer  = "" ;
	            if ( userid         == null ) userid        = "" ;
	            if ( ws_no          == null ) ws_no     = "" ;
				
	            con = ConnectionManager.getConnection(request);
				
	            
	            cs = con.prepareCall( "{ call OR_SPECIMEN_REPORT_REROUTING( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;
				
				System.out.println("module_id"+module_id+"report_id"+report_id+"dest_locn_type"+dest_locn_type+"dest_locn_code"+dest_locn_code+"facility_id"+facility_id+"ws_no"+ws_no+"report_option"+report_option+"reportServer"+reportServer+"userid"+userid);	
	            cs.setString( 1,    module_id ) ;
	            cs.setString( 2,    report_id ) ;
	            cs.setString( 3,    dest_locn_type ) ;
	            cs.setString( 4,    dest_locn_code ) ;
	            cs.setString( 5,    facility_id ) ;
	            cs.setString( 6,    ws_no ) ;
	            cs.setString( 7,    report_option ) ;
	            if("".equals(reroute_printer))
	            {
	            	cs.setString( 8,    null ) ;
	            }
	            else
	            {
	            	cs.setString( 8,    reroute_printer ) ;
	            }
	            cs.registerOutParameter( 9,  Types.VARCHAR ) ;
	            cs.registerOutParameter( 10,  Types.VARCHAR ) ;
	            cs.registerOutParameter( 11, Types.VARCHAR ) ;
	            cs.registerOutParameter( 12, Types.VARCHAR ) ;
	            cs.registerOutParameter( 13, Types.VARCHAR ) ;
	            cs.registerOutParameter( 14, Types.VARCHAR ) ;
	            cs.registerOutParameter( 15, Types.VARCHAR ) ;
	            cs.registerOutParameter( 16, Types.VARCHAR ) ;	
	            cs.registerOutParameter( 17, Types.VARCHAR ) ;
				cs.registerOutParameter( 18, Types.VARCHAR ) ; 
	            cs.execute() ;

	            report  = cs.getString( 9 ) ;
	            server  = cs.getString( 10 ) ;
	            copies  = cs.getString( 11 ) ;			
	            report_mode = cs.getString( 12 ) ;
	            queue_name  = cs.getString( 13 ) ;
				queue_name=queue_name.trim();
	            report_tool = cs.getString( 14 ) ;
	            status  = cs.getString( 15 ) ;
	            message = cs.getString( 16 ) ;
	            app_server_ip = cs.getString( 17 ) ;
	            rep_server_key = cs.getString( 18 ) ;

	            reportServer = "http://" + app_server_ip + reportServer ;

				try{
					stmt=con.createStatement();

					rset	=stmt.executeQuery("select DEBUG_YN from SM_REPORT where report_id='"+report_id+"' and MODULE_ID='"+module_id+"'");

						
					if(rset!=null && rset.next()){
						rep_debug_YN = rset.getString("DEBUG_YN");
					}
				}catch(Exception ex){
					rep_debug_YN="N";
				}
				
	            if ( queue_name.startsWith( "\\\\\\\\" ) ) {
	                String s1 = queue_name.substring( 4 ) ;

	                int index = s1.indexOf( "\\\\" ) ;
	                String s2 = s1.substring( 0, index ) ;
	                String s3 = s1.substring( index+2 ) ;

	                String result_queue = "\\\\" + s2 + "\\" + s3 ;
	                queue_name = result_queue ;


	            }
	
	            if (onlineReport.getParameters().indexOf("copies") == -1)
	    		{
	    			int cop = 0;
	    			if(copies == null || copies.equals(""))
	    				copies="1";
	    			cop=Integer.parseInt(copies);

	                url = reportServer  +"?report="      + report ;
	    			if(rep_server_key==null || rep_server_key.equals("null") ||  rep_server_key.equals("")){ //PMG2012-CRF-0027 IN:037658
	    						url=url+"+userid=" 		+ userid;
	    					}else{
	    						url=url+"+cmdkey=" 		+ rep_server_key;
	    					}
	    					url=url+"+server="      + server        +
	                    "+destype=printer+COPIES="+cop+
	                    "+desname="     + queue_name    +
	                    "+recursive_load=no"+
	                    "+"         + onlineReport.getParameters() ;
					
				if(rep_debug_YN.equals("Y")){
					
					int ins_count=0;
					 con.setAutoCommit(false);
					 try{
						 pstmt = con.prepareStatement("insert into SM_PROC_MSG (OPERATING_FACILITY_ID,PROC_ID,APP_MSG,MSG_DATE_TIME,FAILED_PROC_ID,APP_KEY) values (?,?,?,sysdate,'DBGRP',?)");
						 pstmt.setString(1,module_id);
						 pstmt.setString(2,report_id);
						 pstmt.setString(3,url);
						 pstmt.setString(4,ws_no);
						 ins_count	= pstmt.executeUpdate();
						 closeStatement( pstmt ) ; // Common-ICN-0092
					 }catch (Exception ex){
						
						 pstmt = con.prepareStatement("insert into SM_PROC_MSG (OPERATING_FACILITY_ID,PROC_ID,APP_MSG,MSG_DATE_TIME,FAILED_PROC_ID,APP_KEY) values (?,?,?,sysdate,'DBGRP',?)");
						 pstmt.setString(1,module_id);
						 pstmt.setString(2,report_id);
						 pstmt.setString(3,"Error in inserting for user ="+userid+" COPIES ="+cop +"desname  = "+ queue_name);
						  pstmt.setString(4,ws_no);
						 ins_count	=pstmt.executeUpdate();
						 closeStatement( pstmt ) ; // Common-ICN-0092

					 }
					 con.commit();
				}
		

				for (int i=0;i<1;i++){
					URL reportUrl = new URL( url ) ;

					URLConnection urlConnection = reportUrl.openConnection() ;
					BufferedReader br = new BufferedReader(
									new InputStreamReader(
										urlConnection.getInputStream()
										) ) ;

					String line = "" ;
					String output = "" ;	
				
					while( (line = br.readLine() ) != null ) {
						output = output + line ;
					}

					int start = output.indexOf( "<PRE>" ) ;
					int end   = output.lastIndexOf( "</PRE>" ) ;

					if ( start != -1 ) {
						String error = output.substring( start+5, end ) ;
						result += error ;
					}
					br.close();	
				}

			}
			else{
				
				StringTokenizer tok = new StringTokenizer(onlineReport.getParameters(),"+");
				String parameters = "";
				String copiesTok = "";
				while(tok.hasMoreTokens()){
					String tok1 = tok.nextToken();
					if (tok1.startsWith("copies")){
						copiesTok = tok1;
					}else{
						if (parameters.equals(""))parameters = tok1;
						else parameters = parameters+"+"+tok1;
					}
				}

	            url = reportServer  + "?report="      + report;

				String noCop = copiesTok.substring(copiesTok.indexOf("=")+1);
				int cop = Integer.parseInt(noCop);

				if(rep_server_key==null || rep_server_key.equals("null") || rep_server_key.equals("")){ //PMG2012-CRF-0027 IN:037658
							url=url+"+userid=" 		+ userid;
						}else{
							url=url+"+cmdkey=" 		+ rep_server_key;
						}
						url=url+"+server="      + server        +
	                "+destype=printer+COPIES="+cop+
	                "+desname="     + queue_name    +             
	                "+recursive_load=no"+
	                "+"         + parameters ;			
					
					if(rep_debug_YN.equals("Y")){
						
						int ins_count=0;
						 con.setAutoCommit(false);
						 try{
							 pstmt = con.prepareStatement("insert into SM_PROC_MSG (OPERATING_FACILITY_ID,PROC_ID,APP_MSG,MSG_DATE_TIME,FAILED_PROC_ID,APP_KEY) values (?,?,?,sysdate,'DBGRP1',?)");
							 pstmt.setString(1,module_id);
							 pstmt.setString(2,report_id);
							 pstmt.setString(3,url);
							  pstmt.setString(4,ws_no);
							 ins_count	= pstmt.executeUpdate();					 
						 }catch (Exception ex){
							
							 pstmt = con.prepareStatement("insert into SM_PROC_MSG (OPERATING_FACILITY_ID,PROC_ID,APP_MSG,MSG_DATE_TIME,FAILED_PROC_ID,APP_KEY) values (?,?,?,sysdate,'DBGRP1',?)");
							 pstmt.setString(1,module_id);
							 pstmt.setString(2,report_id);
							 pstmt.setString(3,"Error in inserting for user ="+userid+" COPIES ="+cop +"desname  = "+ queue_name);
							  pstmt.setString(4,ws_no);
							 ins_count	=pstmt.executeUpdate();
							 

						 }
						 con.commit();
					}
					
					for (int i=0;i<1;i++){						
						URL reportUrl = new URL( url ) ;

						URLConnection urlConnection = reportUrl.openConnection() ;
						BufferedReader br = new BufferedReader(
										new InputStreamReader(
											urlConnection.getInputStream()
											) ) ;
						
							String line = "" ;
							String output = "" ;
							
							while( (line = br.readLine() ) != null ) {
								output = output + line ;								
							}
							
							int start = output.indexOf( "<PRE>" ) ;
							int end   = output.lastIndexOf( "</PRE>" ) ;

							if ( start != -1 ) {
								String error = output.substring( start+5, end ) ;
								result += error ;
							}
						br.close();	
					}
				}

				closeResultSet(rset);// Common-ICN-0092
				if(cs!=null)	cs.close();
				closeStatement( stmt ) ; // Common-ICN-0092
				closeStatement( pstmt ) ; // Common-ICN-0092

	        } catch ( Exception e ) {
	            result += e.toString();
	            e.printStackTrace() ;
				System.err.println("my error 292-->"+e);
				System.out.println("my onlinereports.java 292-->"+e);

	        }finally{
				if(con!=null) ConnectionManager.returnConnection(con, request);
	        }
	        return result ;			
		}
		//IN064835 ends
	
	//IN065942, starts	
	public void printRegOrdLabel(Hashtable print_label_values,HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String  language_id  = p.getProperty("LOCALE");
		String report_id = "ORRGSTLA",reg_label_to_be_executed="";
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		boolean result = false;
		String facility_id, order_id, module_id,func_name;
    	String order_line_num, pract_type;
		int prn_reg_lab_cnt = Integer.parseInt((String)print_label_values.get("prn_lab_cnt"));
    	String reportAvailYN = "N";

    	try
	    {
			facility_id = (String) print_label_values.get("facility_id");
			module_id = (String) print_label_values.get("module_id");
			pract_type = (String) print_label_values.get("pract_type");
			func_name = checkForNull((String) print_label_values.get("func_name"),"");


			for(int prn_reg_lab_ind=0; prn_reg_lab_ind < prn_reg_lab_cnt; prn_reg_lab_ind++)
			{		        						
				order_id = (String) print_label_values.get("order_id"+prn_reg_lab_ind);
				order_line_num = print_label_values.get("order_line_no"+prn_reg_lab_ind).toString();				
				
				try
				{
					ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, module_id,report_id,"","");
					report1.addParameter("p_facility_id",facility_id );
					report1.addParameter("p_order_id",order_id);
					report1.addParameter("p_order_line_num",order_line_num);
					report1.addParameter("p_report_id",report_id);
					report1.addParameter("p_module_id",module_id);
					report1.addParameter("p_pract_type",pract_type);
					report1.addParameter("p_language_id",language_id);
					report1.addParameter("p_func_name",func_name);
					result = onlineReports.add( report1);
					reportAvailYN = "Y";
				}
				catch(Exception e)
				{
					e.printStackTrace();
					reportAvailYN = "N";
				}	
			}
					
			if(prn_reg_lab_cnt>0)
			{
				if(result && "Y".equals(reportAvailYN))
					reg_label_to_be_executed = onlineReports.execute( request, response );
			}
	    }
		catch(Exception e)
	    {
			e.printStackTrace();
		}
	}
	//IN065942, ends
	
}