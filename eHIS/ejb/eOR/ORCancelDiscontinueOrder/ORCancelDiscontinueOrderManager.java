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
24/10/2011    IN029354       Chowminya G    Incident No: IN029354 - <ViewBy header-issue when displaying Discontinue status> 
14/07/2012    IN029128       Chowminya G    Incident No: IN029128 - <Unable to Resume a frequency order from Hold/Prov Status> 
12/12/2012    IN034088       Chowminya G    Incident No: IN034088 - <Unable to cancel OT orders in line view - bypass appt check> \
01/03/2013    IN023395       Mahesh K       Incident No: IN023395 - <CRF : RUT-CRF-0012>
03/04/2013    IN039096       Chowminya G    Services not getting listed though more than one quantity defined in the package during successive encounters
07/08/2013	  IN042100       Chowminya G    Ph Category  -  Hold Order Option line level with MAR status P	
20/09/2013    IN039096.1     Chowminya G    Services not getting listed though more than one quantity defined in the package during successive encounters
23/10/2013    IN042290       Chowminya		RL Module added new parameter
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
26/05/2014	IN049280		Karthi L		26/05/2014		Karthi			Status of the order at header level is not same with status show at Item details
24/06/2014	IN049782		Chowminya		24/06/2014		Akbar			Regression OR - Cancel Orders - Group
29/08/2014	IN049737	    Chowminya	 					                MMS-CRF-194.1 Unbilled services will be regrouped into a new order
26/02/2015	IN003522		Ramesh G			26/02/2015		Akbar
09/02/2017	IN063457		Karthi L										Order disappears when user Resumes the Partially Resulted Order.
10/07/2017	IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555				
05/09/2017	IN007189		Raja S			05/09/2017		Ramesh G		OR-Common-Existing Order [IN:007189]			
19/10/2017	IN065324		Dinesh T		19/10/2017		Ramesh G		To display the price in OR screen and 																						the billing status in Manage Specimen 																						screen
14/10/2019  IN071315	    Nijitha S   					Ramesh G		GHL-CRF-0607
12/12/2019	IN071160		Nijitha S						Ramesh G		GHL-SCF-1447
03/01/2020	IN072112		Nijitha S						Ramesh G		Order Cancellation is not allowed
16/1/2020	IN072119		Shazana									SKR-SCF-1304 - TO display Order catalog and status correctly
12/02/2020	IN072311		Nijitha S 		12/02/2020		Ramesh G		TBMC-SCF-0159
25/02/2020	IN071160		Nijitha S 		25/02/2020		Ramesh G		GHL-SCF-1447
25/03/2020	IN072752		Nijitha S	25/03/2020	Ramesh G	ML-MMOH-CRF-1229/12
28/04/2020	IN072922		Nijitha S                                       MMS-KH-SCF-0068
22/06/2020	IN073192 		SIVABAGYAM M		22/06/2020		RAMESH G	OR-Common-Task List-Not Done 
21/07/2020  	IN073528	sivabagyam M 	21/06/2020		Ramesh G		Regression - PHIS-PH-Alpha - Unable to Cancel the Order getting exception
27/07/2020  IN072727		Nijitha S  		27/07/2020		Ramesh G		ML-MMOH-CRF-1461.1
19/11/2020	8004		Nijitha S	19/11/2020	Remesh G	ML-MMOH-CRF-1461.3 
07/01/2020	12123		Nijitha S	07/01/2020	Nijitha S	ML-MMOH-SCF-1702-TF
21/01/2021  12437			Nijitha S			21/01/2021		Nijitha S	   ML-MMOH-CRF-1596-TF-US001
03/05/2021	17091			Nijitha S		03/05/2021		Nijitha S		NMC-JD-SCF-0182-TF 
-------------------------------------------------------------------------------------------------------------------------------
*/ 
package eOR.ORCancelDiscontinueOrder;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import java.io.*;
import java.net.*;
import oracle.sql.*;
import eOR.Common.* ;

import javax.ejb.* ;
import javax.transaction.* ;

/**
*
* @ejb.bean
*	name="ORCancelDiscontinueOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORCancelDiscontinueOrder"
*	local-jndi-name="ORCancelDiscontinueOrder"
*	impl-class-name="eOR.ORCancelDiscontinueOrder.ORCancelDiscontinueOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORCancelDiscontinueOrder.ORCancelDiscontinueOrderLocal"
*	remote-class="eOR.ORCancelDiscontinueOrder.ORCancelDiscontinueOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORCancelDiscontinueOrder.ORCancelDiscontinueOrderLocalHome"
*	remote-class="eOR.ORCancelDiscontinueOrder.ORCancelDiscontinueOrderHome"
*	generate= "local,remote"
*
*
*/
public class ORCancelDiscontinueOrderManager extends OrEJBSessionAdapter 
{
	PreparedStatement pstmt = null ;
	CallableStatement cstmt		= null;
	String[] updt_values1 ;
	String[] updt_values2 ;
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap insert( HashMap tabData, HashMap sqlMap ) 
	{
		Connection connection = null ;
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;	

		try 
		{
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;
			
			if(tabData.containsKey("source"))
			{
				if(((String)tabData.get("source")).equals("discontinue_head_vals"))
				{//these key -value pair is defined in the Bean
					map  = discontinueHeadValues(connection, tabData, sqlMap);
				}
				else if(((String)tabData.get("source")).equals("cancel_order"))
				{
					map = updateValues(connection, tabData, sqlMap);
				}
				else if(((String)tabData.get("source")).equals("resume_order"))
				{
					map = resumeOrder(connection, tabData, sqlMap);
				}
				else if(((String)tabData.get("source")).equals("future_order") || ((String)tabData.get("source")).equals("unbilled_order_split")) //IN049737 added for unbilled_order_split
				{
					map = futureOrder(connection, tabData, sqlMap);
				}
				else
				{
					map  = updateLineValues(connection, tabData, sqlMap);
				}
			}
			else
			{
				map  = updateLineValues(connection, tabData, sqlMap);
			}
		}
		catch( Exception e ) 
		{
			try 
			{
				connection.rollback() ;
			}
			catch ( Exception ee ) 
			{
				messages.append( ee.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		}
		finally 
		{
			try 
			{
				closeStatement( cstmt ) ;
				closeStatement( pstmt ) ;
				
				if(connection != null) 
				{
					closeConnection(connection,(Properties)tabData.get( "properties" ));
					connection = null ;
				}
			}
			catch ( Exception fe ) 
			{
				fe.printStackTrace() ;
			}
		}
		return map ;
	}
	//this is also used to in the case of HOLD functionality

	public HashMap discontinueHeadValues(Connection connection, HashMap tabData, HashMap sqlMap)
	{
		PreparedStatement pstmt4 	= null;
		PreparedStatement pstmt5 	= null;
		PreparedStatement pstmtupd 	= null;
		PreparedStatement pstmt7 	= null;
		PreparedStatement pstmt71 	= null;
		PreparedStatement pstmt_set_status 	= null;
		ResultSet resultSet 		= null;
		ResultSet resultSet71		= null;
		ResultSet resultset_status		= null;
		HashMap map = new HashMap() ;
		String message 				= "";
		String[] updt_vals2 ;
		String cont_order_ind = "";
		String which_place = "";
		String currentDate = (String)tabData.get("currentDate");
		int result = 1;
		String Order_ID		= "";
		String strOperation				= "";
		String Pract_ID					= "";
		String order_cat				= "";
		String strRemarks				= "";
		String appt_ref_num				= "";
		String User_ID					= "";
		String Facility_ID				= "";
		String Ws_No					= "";
		//Billing related parameters - start
		String p_facility_id			= "";
		String p_order_id				= "";
		String p_order_line_num			= "";
		String p_mode					= "DIS";
		String p_user					= "";
		String p_ws_no					= "";
		String p_error_message			= "";
		//Billing related parameters - end
		String order_set_id				= "";
		String order_set_bill_yn		= "N";
		String order_set_status_type	= "";
		String bill_yn					= "";
		String print_billing_report_yn  = "";
		String print_report_yn			= "";
		String p_error_code				= "";
		String p_error_level			= "";
		String p_error_text				= "";
		String cancel_allow_yn			= "";
		Hashtable print_report_values 	= new Hashtable(); //Global  // For On Line Printing(Billing Report Details)
		int print_report_count          = 0;
		String total_line_num           = "";
		int bill_yn_count               = 0;
		int cancel_allow_count          = 0;
		int insert_valid                = 1;
		String p_err_text	            = "";

		try
		{
			updt_vals2 		= (String[])tabData.get("updt_line");
			cont_order_ind 	= (String)tabData.get("cont_order_ind");
			cont_order_ind = cont_order_ind.trim();
			//String order_status = (String)tabData.get("order_status"); //Checkstyle
			which_place = (String)tabData.get("which_place");
		String p_called_from_ca = (String)tabData.get("p_called_from_ca");//IN071315
			if(updt_vals2[0]==null) updt_vals2[0]="";
			if(updt_vals2[1]==null) updt_vals2[1]="";
			if(updt_vals2[2]==null) updt_vals2[2]="";
			if(updt_vals2[3]==null) updt_vals2[3]="";
			if(updt_vals2[4]==null) updt_vals2[4]="";
			if(updt_vals2[5]==null) updt_vals2[5]="";
			if(updt_vals2[6]==null) updt_vals2[6]="";
			if(updt_vals2[7]==null) updt_vals2[7]="";
			if(updt_vals2[8]==null) updt_vals2[8]="";
			if(updt_vals2[9]==null) updt_vals2[9]="";
			if(updt_vals2[10]==null) updt_vals2[10]="";
			if(updt_vals2[11]==null) updt_vals2[11]="";
			if(updt_vals2[12]==null) updt_vals2[12]="";
			if(updt_vals2[13]==null) updt_vals2[13]="";
			String Refund = (String)updt_vals2[13];
			
			
			Order_ID	= updt_vals2[2].trim();
			order_cat	= updt_vals2[10].trim();
			order_set_id	= updt_vals2[11].trim();
			order_set_bill_yn	= updt_vals2[12].trim();

			
            if(((String)tabData.get("source")).equals("discontinue_head_vals"))
			{
				/*Added by Uma on 3/30/2010 for IN020384*/
				if(which_place.equals("hold_head_rec"))
				{
					strOperation	= "H";
				}
				else
				{
            		strOperation	= "D";
				}
				/*Ends Here by Uma on 3/30/2010 for IN020384*/
			}
            else if(which_place.equals("hold_head_rec"))
			{
            	strOperation	= "H";
				
			}		
			
            Pract_ID	= updt_vals2[1].trim();
            strRemarks	= updt_vals2[0].trim();
            User_ID		= updt_vals2[4].trim();
            Facility_ID	= updt_vals2[6].trim();
            Ws_No		= updt_vals2[5].trim();
			appt_ref_num= updt_vals2[7];
			
			if(appt_ref_num == null)
				appt_ref_num="";
			
			p_facility_id		= Facility_ID;
            p_order_id			= Order_ID;
            p_user				= User_ID;
            p_ws_no				= Ws_No;
			String fpp_yn=updt_vals2[14];//IN072752
			String fpp_category=updt_vals2[15];//IN072752

			//Discontinue Function Check - Start
			pstmt7 = connection.prepareStatement("select nvl(PRINT_BILLING_REPORT_YN,'N') print_billing_report_yn from or_param_by_facility where operating_facility_id=?");
			pstmt7.setString(1, p_facility_id);
			resultSet = pstmt7.executeQuery();

			if (resultSet.next()) 
			{
				print_billing_report_yn	= resultSet.getString("print_billing_report_yn")==null?"N":resultSet.getString("print_billing_report_yn");
			}	
			
			closeStatement(pstmt7) ;
			closeResultSet(resultSet) ;		

			pstmt71 = connection.prepareStatement("select order_line_num from or_order_line where order_id=?");
			
			if(order_set_bill_yn.equalsIgnoreCase("Y"))
				pstmt71.setString(1, order_set_id);
			else
				pstmt71.setString(1, p_order_id);

			resultSet71 = pstmt71.executeQuery();
			
			while(resultSet71.next()) 
			{
				total_line_num =  (String)resultSet71.getString("order_line_num");
				String bill_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
				pstmt7 = connection.prepareStatement(bill_sql) ;

				if(order_set_bill_yn.equalsIgnoreCase("Y"))
				{
					pstmt7.setString(1, order_set_id);
					pstmt7.setString(2, "1");
				}
				else
				{
					pstmt7.setString(1, p_order_id);
					pstmt7.setString(2, total_line_num);
				}

				resultSet = pstmt7.executeQuery();

				if (resultSet.next()) 
				{
					bill_yn	= resultSet.getString("bill_yn");
					cont_order_ind	= resultSet.getString("cont_order_ind");
				}

				closeStatement(pstmt7) ;
				closeResultSet(resultSet) ;

				if(bill_yn.equalsIgnoreCase("Y"))
				{
					bill_yn_count ++;
				}			

				if(((bill_yn.equalsIgnoreCase("Y"))||(order_set_bill_yn.equalsIgnoreCase("Y")))&&Refund.equalsIgnoreCase("Y"))
				{
					String p_subs_module_id		 = "";
					String p_subs_regn_num		 = "";
					String p_subs_regn_line_num = "";
					String p_err_code					 = "";
					String p_sys_message_id		 = "";
					CallableStatement cstmt_sub_module_dtls = null;
					CallableStatement cstmt_cancel_allow_yn 	= null;
					CallableStatement cstmt_freq_order 	= null;

					try
					{
						if((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))
						{
							cstmt_freq_order = connection.prepareCall("{call OR_FREQ_ORD_CAN_DIS(?,?,?,?,?,?,?,?,?,?) }");
							cstmt_freq_order.setString(1, p_order_id);// P_ORDER_ID
							cstmt_freq_order.setString(2, total_line_num);// P_ORDER_LINE_NUM
							cstmt_freq_order.setString(3, p_facility_id);// P_FACILITY_ID
							cstmt_freq_order.setString(4, p_mode);// P_FACILITY_ID
							cstmt_freq_order.setString(5, p_user);// P_FACILITY_ID
							cstmt_freq_order.setString(6, p_ws_no);// P_FACILITY_ID
							cstmt_freq_order.registerOutParameter( 7,  Types.VARCHAR ) ;//P_PRINT_YN
							cstmt_freq_order.registerOutParameter( 8,  Types.VARCHAR ) ;// P_ERR_CODE
							cstmt_freq_order.registerOutParameter( 9,  Types.VARCHAR ) ;// P_SYS_MESSAGE_ID
							cstmt_freq_order.registerOutParameter( 10,  Types.VARCHAR ) ;// P_ERROR_TEXT	
							cstmt_freq_order.execute();
							print_report_yn	= cstmt_freq_order.getString(7)==null?"N":cstmt_freq_order.getString(7);// P_PRINT_YN
							p_error_code	= cstmt_freq_order.getString(8)==null?"":cstmt_freq_order.getString(8);// P_ERR_CODE
							p_sys_message_id	= cstmt_freq_order.getString(9)==null?"":cstmt_freq_order.getString(9);// P_SYS_MESSAGE_ID
							p_err_text	= cstmt_freq_order.getString(10)==null?"":cstmt_freq_order.getString(10);// P_ERROR_TEXT
							closeStatement( cstmt_freq_order ) ;				

							if(p_error_code==null) 
								p_error_code="";

							if(p_error_code.equals(""))	
							{
								if((print_report_yn.equalsIgnoreCase("Y"))&&(print_billing_report_yn.equalsIgnoreCase("Y")))
								{
									print_report_values.put("p_facility_id"+print_report_count,p_facility_id);
									print_report_values.put("p_order_id"+print_report_count,p_order_id);
									print_report_values.put("p_order_line_num"+print_report_count,total_line_num);
									print_report_values.put("print_report_yn"+print_report_count,print_report_yn);
									//map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
									print_report_count++;
									print_report_values.put("total_recs",String.valueOf(print_report_count)); 		
								}

								if(print_report_count>0)
								{
									map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
								}
							}

							if(p_error_code==null) 
								p_error_code="";
							
							if(p_err_text==null) 
								p_err_text="";

							if(p_err_text!=null && !p_err_text.equals(""))
								result = 0;
							else 
								result = 1;
							
							if ( result < 1 ) 
							{
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								map.put( "message",p_err_text ) ;
								return map;
							}
							else if(!p_error_code.equals(""))	
							{
								result = 0;
								map.put( "result", new Boolean( false ) ) ;
								map.put("message", p_error_code) ;
								connection.rollback();
								return map;
							}	 
							else
							{
								map.put( "result", new Boolean( true ) ) ;
								map.put("message", "RECORD_MODIFIED") ;
								connection.commit();
								return map;
							}
						}
						else
						{
							cstmt_sub_module_dtls			= connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_SEC_KEY_FOR_PRIM_KEY(?,?,?,?,?,?,?,?,?) }");
							cstmt_sub_module_dtls.setString(1, p_facility_id);									    // P_FACILITY_ID

							if(order_set_bill_yn.equalsIgnoreCase("Y"))
							{
								cstmt_sub_module_dtls.setString(2, order_set_id);										// P_ORDER_ID
								cstmt_sub_module_dtls.setString(3, "1");						    // P_ORDER_LINE_NUM
							}
							else
							{
								cstmt_sub_module_dtls.setString(2, p_order_id);										// P_ORDER_ID
								cstmt_sub_module_dtls.setString(3, total_line_num);						    // P_ORDER_LINE_NUM
							}
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
							p_err_code	= cstmt_sub_module_dtls.getString(7);				                    // P_ERR_CODE
							p_sys_message_id	= cstmt_sub_module_dtls.getString(8);				        // P_SYS_MESSAGE_ID
							p_error_text	= cstmt_sub_module_dtls.getString(9);				                    // P_ERROR_TEXT

							if((p_err_code!=null && p_err_code!="null" && !p_err_code.equals(""))&&(p_sys_message_id!=null && p_sys_message_id!="null" && !p_sys_message_id.equals("")))
							{
								result = 0;
							}
							else
							{
								cstmt_cancel_allow_yn = connection.prepareCall("{ ? = call  BL_PROC_ITEM_VALIDATIONS_MP.IS_CANCEL_ORDER_ALLOWED_YN(?,?,?,?,?,?,?,?,?,?,?)}");
								cstmt_cancel_allow_yn.registerOutParameter(1,java.sql.Types.VARCHAR);
								cstmt_cancel_allow_yn.setString(2,p_facility_id);
								//IN071315 Starts
								//cstmt_cancel_allow_yn.setString(3,"OR");
								if("Y".equals(p_called_from_ca)){
									cstmt_cancel_allow_yn.setString(3,"OR|CA");
									System.out.println("ORCancelDiscontinueOrderManager.java:if467p_called_from_ca"+p_called_from_ca);
								}
								else{
									System.out.println("ORCancelDiscontinueOrderManager.java:else472p_called_from_ca"+p_called_from_ca);
									cstmt_cancel_allow_yn.setString(3,"OR|OR");
								}
								//IN071315 Starts
								if(order_set_bill_yn.equalsIgnoreCase("Y"))
								{
									cstmt_cancel_allow_yn.setString( 4 , order_set_id);										// P_ORDER_ID
									cstmt_cancel_allow_yn.setString( 5 , "1");						    // P_ORDER_LINE_NUM
								}
								else
								{
									cstmt_cancel_allow_yn.setString(4,p_order_id);
									cstmt_cancel_allow_yn.setString(5,total_line_num);
								}

								cstmt_cancel_allow_yn.setString(6,p_subs_module_id);
								cstmt_cancel_allow_yn.setString(7,p_subs_regn_num);
								cstmt_cancel_allow_yn.setString(8,p_subs_regn_line_num);
								cstmt_cancel_allow_yn.registerOutParameter(9,java.sql.Types.VARCHAR);
								cstmt_cancel_allow_yn.registerOutParameter(10,java.sql.Types.VARCHAR);
								cstmt_cancel_allow_yn.registerOutParameter(11,java.sql.Types.VARCHAR);
								cstmt_cancel_allow_yn.registerOutParameter(12,java.sql.Types.VARCHAR);
								cstmt_cancel_allow_yn.execute();							
								cancel_allow_yn = cstmt_cancel_allow_yn.getString(1);	
								print_report_yn = cstmt_cancel_allow_yn.getString(9);	
								p_error_code = cstmt_cancel_allow_yn.getString(10);	
								p_error_level = cstmt_cancel_allow_yn.getString(11);	
								p_err_text = cstmt_cancel_allow_yn.getString(12);	
							}
							
							print_report_yn = (print_report_yn==null)?"N":print_report_yn;
							p_error_code = (p_error_code==null)?"":p_error_code;
							p_error_level = (p_error_level==null)?"":p_error_level;
							p_error_text = (p_err_text==null)?"":p_err_text;
							cancel_allow_yn = (cancel_allow_yn==null)?"":cancel_allow_yn;
							
							if(p_error_code==null) 
								p_error_code="";
							
							if(p_err_text==null) 
								p_err_text="";
							
							if(!p_error_code.equals(""))	
							{
								insert_valid = 0;				  
								result = 0;
								map.put("message", p_error_code) ;
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								return map;			   
							}
							else if(!p_err_text.equals(""))
							{
								insert_valid = 0;	
								result = 0;
								map.put("message", p_err_text) ;
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								return map;			
							}
							else
							{
								result = 1;
								insert_valid = 1;
							}  
						}
					}
					catch(Exception ce)
					{  
						ce.printStackTrace();
					}
				}		

				if(cancel_allow_yn.equalsIgnoreCase("Y"))
				{
					cancel_allow_count ++;
				}
				if(bill_yn_count==cancel_allow_count)
				{
					cancel_allow_yn = "Y";
				}

				if((((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))||(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))))&&(Refund.equalsIgnoreCase("Y")))
				{

					if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
					{
						if((print_report_yn.equalsIgnoreCase("Y"))&&(print_billing_report_yn.equalsIgnoreCase("Y")))
						{
							print_report_values.put("p_facility_id"+print_report_count,p_facility_id);
							
							if(order_set_bill_yn.equalsIgnoreCase("Y"))
							{
								print_report_values.put("p_order_id"+print_report_count,order_set_id);
								print_report_values.put("p_order_line_num"+print_report_count,"1");
							}
							else
							{
								print_report_values.put("p_order_id"+print_report_count,p_order_id);
								print_report_values.put("p_order_line_num"+print_report_count,total_line_num);
							}
							print_report_values.put("print_report_yn"+print_report_count,print_report_yn);	
							print_report_count++;
							print_report_values.put("total_recs",String.valueOf(print_report_count)); 	
						}					
					}
				}
				//IN071160 Starts
				if(((String)tabData.get("source")).equals("discontinue_head_vals")&& (result>=1)) 
				{
					if((order_set_bill_yn.equalsIgnoreCase("N"))&&(bill_yn.equalsIgnoreCase("Y"))&&Refund.equalsIgnoreCase("Y"))
					//if((((!(order_set_status_query.equals("")))&&(order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((order_set_status_type.equalsIgnoreCase("CN"))||((order_set_status_type.equalsIgnoreCase("DC")))))||(order_set_bill_yn.equalsIgnoreCase("N"))||(bill_yn.equalsIgnoreCase("Y")))&&Refund.equalsIgnoreCase("Y"))
					{
						if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
						{
							//cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?)}");//IN071315//IN072752
							cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?,?,?)}");//IN071315//IN072752
							cstmt.setString(1, p_facility_id);
							cstmt.setString(2, p_order_id);						// P_ORDER_ID
							cstmt.setString(3, p_order_line_num);				// P_ORDER_LINE_NUM
							cstmt.setString(4, p_mode); 						// P_MODE
							cstmt.setString(5, p_user);							// P_USER
							cstmt.setString(6, p_ws_no);						// P_WS_NO
							cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
							cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
							cstmt.setString(9, "N");						// FUTURE
							cstmt.setString(10, "Y");						// INCLUDE_CANCEL
							//IN071315 Starts
							if("Y".equals(p_called_from_ca))
								cstmt.setString(11, "CA");
							else
								cstmt.setString(11, "OR");
							//IN071315 Ends
							cstmt.setString(12, fpp_yn);//IN072752
							cstmt.setString(13, fpp_category);//IN072752
							cstmt.execute();
							p_error_message	= cstmt.getString(8);  // message

							try 
							{
								closeStatement( cstmt ) ;
							}
							catch ( Exception fe ) 
							{
								fe.printStackTrace() ;
							}	
							if(p_error_message!=null && !p_error_message.equals(""))
								result = 0;
							else 
								result = 1;
						}
					}

					if ( result < 1 ) 
					{
						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						map.put( "message",p_error_message ) ;
						return map;
					}
					//Billing Procedure - End
				} 
			}
			if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
			{
				if(print_report_count>0)
				{
					map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
				}
			}
			closeStatement(pstmt71) ;
			closeResultSet(resultSet71) ;		 

			if((((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))||((bill_yn.equalsIgnoreCase("Y")&&((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))))||((bill_yn.equalsIgnoreCase("Y"))&&(Refund.equalsIgnoreCase("N")||(Refund.equalsIgnoreCase("")))))||(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))))||(bill_yn.equalsIgnoreCase("N")&&(!p_order_id.equals("")))||(order_set_bill_yn.equalsIgnoreCase("N")&&(!order_set_id.equals(""))))
			{  
				String resultValue	= "";

				if(((String)tabData.get("source")).equals("discontinue_head_vals") && (Order_ID.substring(0,2).equals("RD"))) 
				{
					pstmt7 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_DISCONTINUE_ORDER_RD_FUNC") ) ;
					pstmt7.setString(1, p_order_id);
					pstmt7.setString(2, p_order_line_num);
					resultSet = pstmt7.executeQuery();

					if (resultSet.next()) 
					{
						resultValue	= resultSet.getString(1);
					}
					closeStatement( pstmt7 ) ;
				}

				if ((resultValue!=null) && (!resultValue.equals("")) && (!resultValue.equalsIgnoreCase("TRUE"))) 
				{
					map.put( "result", new Boolean( false ) ) ;
					connection.rollback();
					
					if(resultValue!=null && !resultValue.equals(""))
						map.put( "message",resultValue ) ;
					else
						map.put( "message", "Operation failure ..." ) ;
					return map;
				}
				//Discontinue Function Check - End
				
				if(((String)tabData.get("source")).equals("discontinue_head_vals")) 
				{
					if(appt_ref_num!=null && !appt_ref_num.equals(""))
					{
						//Billing Procedure - Start
						cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_OA_CANCEL_APPOINTMENT") +" }");
						cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
						cstmt.setString(2, appt_ref_num);							// APPTREFNO
						cstmt.setString(3, null);							// PATIENTID
						cstmt.setString(4, null); 							// REASON
						cstmt.setString(5, null);							// ALCN_CRITERIA
						cstmt.setString(6, null);							// PAT_CAT
						cstmt.setString(7, p_facility_id);					// ADDEDFACILITYID
						cstmt.setString(8, p_ws_no);						// ADDEDATWORKSTATION
						cstmt.setString(9, null);							// FORCED
						cstmt.setString(10, p_user);							// USERID
						cstmt.registerOutParameter( 11,  Types.VARCHAR ) ; 	// RESULT 
						cstmt.execute();
						p_error_message	= cstmt.getString(11);  // message

						try 
						{
							closeStatement( cstmt ) ;
						}
						catch ( Exception fe ) 
						{
							fe.printStackTrace() ;
						}	

						if(p_error_message!=null && !p_error_message.equals(""))
							result = 0;
						else 
							result = 1;

						if ( result < 1 ) 
						{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message",p_error_message ) ;
							return map;
						}
					}
				}//OA Appt Procedure - End

				if(((String)tabData.get("source")).equals("discontinue_head_vals") && order_cat.equals("LB"))
				{
					cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_DISCONTINUE_ORDER_PROC") +" }");
					cstmt.setString(1, "O"); 	// P_HEADER_LINE_LEVEL
					cstmt.setString(2, updt_vals2[2].trim() );			// Order Id
					cstmt.setString(3, "");	// line_num
					cstmt.registerOutParameter( 4,  Types.VARCHAR ) ;
					cstmt.setString( 5, p_user ) ;//IN042290 - RL Module added new parameter
					cstmt.execute();
					message	= cstmt.getString(4);  // message
					//added by kavitha 17.12.2004

					try
					{	
						closeStatement( cstmt ) ;
					}
					catch ( Exception fe ) 
					{
						fe.printStackTrace() ;
					}	
					//end of added by kavitha 17.12.2004

					if(message!=null && !message.equals(""))
						result = 0;
					else 
						result = 1;
				}

				if ( result < 1 && (((String)tabData.get("source")).equals("discontinue_head_vals"))) 
				{
					map.put( "result", new Boolean( false ) ) ;
					connection.rollback();
					result = 0; //Added By Jyothi on 14/05/2010 to fix 20588

					if(message!=null && !message.equals(""))
						map.put( "message",message ) ;
					else
						map.put( "message", "Operation failure ..." ) ;
				} 
				else if (result >= 1 || (!((String)tabData.get("source")).equals("discontinue_head_vals"))) 
				{	
					pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1") ) ;
					
					if(which_place.equals("hold_head_rec"))
					{
						pstmtupd = connection.prepareStatement("update or_order set prev_order_status = order_status where order_id = ?");
						pstmtupd.setString(1, updt_vals2[2].trim()) ;
						pstmtupd.executeUpdate();
						closeStatement(pstmtupd);
						pstmt4.setString( 1, "45") ;
						pstmt4.setString( 2, updt_vals2[0].trim() ) ;
						pstmt4.setString( 3, p_user ) ;
						pstmt4.setString( 4, p_ws_no ) ;
						pstmt4.setString( 5, p_facility_id ) ;
						pstmt4.setString( 6, updt_vals2[2].trim() ) ;
					}
					else if(((String)tabData.get("source")).equals("discontinue_head_vals") && (!(which_place.equals("hold_head_rec"))) )
					{
						pstmt4.setString( 1, "93") ;
						pstmt4.setString( 2, updt_vals2[0].trim() ) ;
						pstmt4.setString( 3, p_user ) ;
						pstmt4.setString( 4, p_ws_no ) ;
						pstmt4.setString( 5, p_facility_id ) ;
						pstmt4.setString( 6, updt_vals2[2].trim() ) ;
					}
					result = pstmt4.executeUpdate();
					closeStatement( pstmt4 ) ;

					if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR") )&& (!Order_ID.substring(0,2).equals("PH")))
					{
						pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN") ) ;

						if(which_place.equals("hold_head_rec"))
						{
						/*	pstmtupd = connection.prepareStatement("update or_order set prev_order_status = order_status where order_id = ?");
							pstmtupd.setString(1, updt_vals2[2].trim()) ;
							pstmtupd.executeUpdate();
							closeStatement(pstmtupd);*///Modified -- [IN029128]
							pstmt4.setString( 1, "45") ;
							pstmt4.setString( 2, updt_vals2[0].trim() ) ;
							pstmt4.setString( 3, p_user ) ;
							pstmt4.setString( 4, p_ws_no ) ;
							pstmt4.setString( 5, p_facility_id ) ;
							pstmt4.setString( 6, updt_vals2[2].trim() ) ;
						}
						else if(((String)tabData.get("source")).equals("discontinue_head_vals") && (!(which_place.equals("hold_head_rec"))) )
						{
							pstmt4.setString( 1, "93") ;
							pstmt4.setString( 2, updt_vals2[0].trim() ) ;
							pstmt4.setString( 3, p_user ) ;
							pstmt4.setString( 4, p_ws_no ) ;
							pstmt4.setString( 5, p_facility_id ) ;
							pstmt4.setString( 6, updt_vals2[2].trim() ) ;
						}
						pstmt4.executeUpdate();
						closeStatement( pstmt4 ) ;
					}  

					if(result >=1)
					{
						if(which_place.equals("hold_head_rec"))
						{
							pstmt5 = connection.prepareStatement("UPDATE or_order_line SET order_line_status = (SELECT order_Status_code FROM or_order_status_code WHERE order_Status_type =(?)) ,can_line_reason = (?), can_pract_id = (?), can_date_time = to_date((?),'dd/mm/yyyy hh24:mi'),auto_stop_date_time =to_date((?),'dd/mm/yyyy hh24:mi'), hold_pract_id = (?), hold_date_time = to_date((?),'dd/mm/yyyy hh24:mi'), resume_pract_id = (?), resume_date_time = to_date((?),'dd/mm/yyyy hh24:mi') , disc_pract_id =(?), disc_date_time = to_date((?),'dd/mm/yyyy hh24:mi'), modified_by_id=(?), modified_date=SYSDATE, modified_at_ws_no=(?), modified_facility_id=(?)  WHERE order_id = (?)");
							pstmtupd = connection.prepareStatement("update or_order_line set prev_order_line_status = order_line_status where order_id = ?");
							pstmtupd.setString(1, updt_vals2[2].trim()) ;
							pstmtupd.executeUpdate();
							closeStatement(pstmtupd);
							pstmt5.setString( 1, "45") ;
							pstmt5.setString( 2, updt_vals2[0].trim()  ) ;
							pstmt5.setString( 3, null ) ;
							pstmt5.setString( 4, null ) ;
							pstmt5.setString( 5, currentDate  ) ;
							pstmt5.setString( 6, updt_vals2[1].trim() ) ;
							pstmt5.setString( 7, currentDate ) ;
							pstmt5.setString( 8, null) ;
							pstmt5.setString( 9, null) ;
							pstmt5.setString( 10, null) ;
							pstmt5.setString( 11, null) ;
							pstmt5.setString( 12, p_user ) ;
							pstmt5.setString( 13, p_ws_no ) ;
							pstmt5.setString( 14, p_facility_id ) ;
							pstmt5.setString( 15, updt_vals2[2].trim()  ) ; // where clause
						}
						else if(((String)tabData.get("source")).equals("discontinue_head_vals") && (!(which_place.equals("hold_head_rec"))) )
						{
						//	pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2") ) ;//Commented For IN071160
							pstmt5 = connection.prepareStatement( "UPDATE or_order_line SET order_line_status = (SELECT order_Status_code FROM or_order_status_code WHERE order_Status_type =(?)) ,can_line_reason = (?), can_pract_id = (?), can_date_time = to_date((?),'dd/mm/yyyy hh24:mi'),auto_stop_date_time =to_date((?),'dd/mm/yyyy hh24:mi'), hold_pract_id = (?), hold_date_time = to_date((?),'dd/mm/yyyy hh24:mi'), resume_pract_id = (?), resume_date_time = to_date((?),'dd/mm/yyyy hh24:mi') , disc_pract_id =(?), disc_date_time = to_date((?),'dd/mm/yyyy hh24:mi'), result_line_status = (?), modified_by_id=(?), modified_date=SYSDATE, modified_at_ws_no=(?), modified_facility_id=(?), discontinue_refund_yn=(?)  WHERE order_id = (?)");//Added For IN071160
							pstmt5.setString( 1, "93") ;
							pstmt5.setString( 2, updt_vals2[0].trim()  ) ;
							pstmt5.setString( 3, null ) ;
							pstmt5.setString( 4, null ) ;
							pstmt5.setString( 5, currentDate  ) ;
							pstmt5.setString( 6, null ) ;
							pstmt5.setString( 7, null ) ;
							pstmt5.setString( 8, null) ;
							pstmt5.setString( 9, null) ;
							pstmt5.setString( 10, updt_vals2[1].trim()) ;
							pstmt5.setString( 11, currentDate) ;
							pstmt5.setString( 12, null) ;
							pstmt5.setString( 13, p_user ) ;
							pstmt5.setString( 14, p_ws_no ) ;
							pstmt5.setString( 15, p_facility_id ) ;
							pstmt5.setString( 16, "N" ) ;//IN071160
							pstmt5.setString( 17, updt_vals2[2].trim()) ; // where clause//IN071160
						}
						result = pstmt5.executeUpdate();
						closeStatement( pstmt5 ) ;

						if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ) && (!(Order_ID.substring(0,2)).equals("PH")))
						{
							pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN") ) ;

							if(which_place.equals("hold_head_rec"))
							{
								pstmt5 = connection.prepareStatement("UPDATE or_order_line SET order_line_status = (SELECT order_Status_code FROM or_order_status_code WHERE order_Status_type =(?)) ,can_line_reason = (?), can_pract_id = (?), can_date_time = to_date((?),'dd/mm/yyyy hh24:mi'),auto_stop_date_time =to_date((?),'dd/mm/yyyy hh24:mi'), hold_pract_id = (?), hold_date_time = to_date((?),'dd/mm/yyyy hh24:mi'), resume_pract_id = (?), resume_date_time = to_date((?),'dd/mm/yyyy hh24:mi') , disc_pract_id =(?), disc_date_time = to_date((?),'dd/mm/yyyy hh24:mi'), modified_by_id=(?), modified_date=SYSDATE, modified_at_ws_no=(?), modified_facility_id=(?)  WHERE order_id = (?)");
								/*pstmtupd = connection.prepareStatement("update or_order_line set prev_order_line_status = order_line_status where order_id = ?");
								pstmtupd.setString(1, updt_vals2[2].trim()) ;
								pstmtupd.executeUpdate();
								closeStatement(pstmtupd);*///Modified -- [IN029128]
								pstmt5.setString( 1, "45") ;
								pstmt5.setString( 2, updt_vals2[0].trim()  ) ;
								pstmt5.setString( 3, null ) ;
								pstmt5.setString( 4, null ) ;
								pstmt5.setString( 5, currentDate  ) ;
								pstmt5.setString( 6, updt_vals2[1].trim() ) ;
								pstmt5.setString( 7, currentDate ) ;
								pstmt5.setString( 8, null) ;
								pstmt5.setString( 9, null) ;
								pstmt5.setString( 10,  null ) ;
								pstmt5.setString( 11,null ) ;
								//pstmt5.setString( 12, order_status) ; //result_line_status - will hold the prev status of the order before holding
								pstmt5.setString( 12, p_user ) ;
								pstmt5.setString( 13, p_ws_no ) ;
								pstmt5.setString( 14, p_facility_id ) ;
								pstmt5.setString( 15, updt_vals2[2].trim()  ) ; // where clause
							}
							else if(((String)tabData.get("source")).equals("discontinue_head_vals") && (!(which_place.equals("hold_head_rec"))))
							{

								pstmt5.setString( 1, "93") ;
								pstmt5.setString( 2, updt_vals2[0].trim()  ) ;
								pstmt5.setString( 3, null ) ;
								pstmt5.setString( 4, null ) ;
								pstmt5.setString( 5, currentDate  ) ;
								pstmt5.setString( 6, null ) ;
								pstmt5.setString( 7, null ) ;
								pstmt5.setString( 8, null) ;
								pstmt5.setString( 9, null) ;
								pstmt5.setString( 10, updt_vals2[1].trim()) ;
								pstmt5.setString( 11, currentDate) ;
								pstmt5.setString( 12, null) ;
								pstmt5.setString( 13, p_user ) ;
								pstmt5.setString( 14, p_ws_no ) ;
								pstmt5.setString( 15, p_facility_id ) ;
								pstmt5.setString( 16, updt_vals2[2].trim()  ) ; // where clause
							}
							pstmt5.executeUpdate();
						}
					}
					//IN071160 Starts
					/*if(((String)tabData.get("source")).equals("discontinue_head_vals")&& (result>=1)) 
					{
						if((order_set_bill_yn.equalsIgnoreCase("N"))&&(bill_yn.equalsIgnoreCase("Y"))&&Refund.equalsIgnoreCase("Y"))
						//if((((!(order_set_status_query.equals("")))&&(order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((order_set_status_type.equalsIgnoreCase("CN"))||((order_set_status_type.equalsIgnoreCase("DC")))))||(order_set_bill_yn.equalsIgnoreCase("N"))||(bill_yn.equalsIgnoreCase("Y")))&&Refund.equalsIgnoreCase("Y"))
						{
							if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
							{
								cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?)}");//IN071315
								cstmt.setString(1, p_facility_id);
								cstmt.setString(2, p_order_id);						// P_ORDER_ID
								cstmt.setString(3, p_order_line_num);				// P_ORDER_LINE_NUM
								cstmt.setString(4, p_mode); 						// P_MODE
								cstmt.setString(5, p_user);							// P_USER
								cstmt.setString(6, p_ws_no);						// P_WS_NO
								cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
								cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
								cstmt.setString(9, "N");						// FUTURE
								cstmt.setString(10, "Y");						// INCLUDE_CANCEL
								//IN071315 Starts
								if("Y".equals(p_called_from_ca))
									cstmt.setString(11, "CA");
								else
									cstmt.setString(11, "OR");
								//IN071315 Ends
								cstmt.execute();
								p_error_message	= cstmt.getString(8);  // message

								try 
								{
									closeStatement( cstmt ) ;
								}
								catch ( Exception fe ) 
								{
									fe.printStackTrace() ;
								}	
								if(p_error_message!=null && !p_error_message.equals(""))
									result = 0;
								else 
									result = 1;
							}
						}

						if ( result < 1 ) 
						{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message",p_error_message ) ;
							return map;
						}
						//Billing Procedure - End
					} */
						//IN071160 Ends
					if ( result < 1 ) 
					{
						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						
						if(message!=null && !message.equals(""))
							map.put( "message",message ) ;
						else
							map.put( "message", "Operation failure ..." ) ;
					} 
					else  
					{
						if (Order_ID.substring(0,2).equals("PH")) 
						{
							cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_PH_PATIENTDRUGPROFILEUPDATE_PROC") +" }");
							cstmt.setString(1, Order_ID); 		// P_ORDERID
							cstmt.setString(2, "");				// P_ORDERLINENO
							cstmt.setString(3, strOperation);	// P_OPERATION
							cstmt.setString(4, ""); 			// P_REASONCODE
							cstmt.setString(5, strRemarks);		// P_REMARKS
							cstmt.setString(6, Pract_ID);		// P_PRACTITIONERID
							cstmt.setString(7, User_ID); 		// P_USERID
							cstmt.setString(8, Facility_ID);	// P_FACILITYID
							cstmt.setString(9, Ws_No);			// P_WSNO
							cstmt.registerOutParameter( 10,  Types.VARCHAR ) ; //P_ERRMSG
							cstmt.execute();
							message	= cstmt.getString(10);  // message

							if(message!=null && !message.equals(""))
								result = 0;
							else 
								result = 1;
						}

						closeStatement( cstmt ) ;
						if ( result < 1 ) 
						{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							
							if(message!=null && !message.equals(""))
								map.put( "message",message ) ;
							else
								map.put( "message", "Operation failure ..." ) ;
						} 
					}
				}

				/***************************************************/

				if (result >= 1)
				{
					connection.commit() ;
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", "RECORD_MODIFIED" ) ;
				}  
			}
			else
			{	
				
			}
		  
			if(result>0)
			{			   	 
				if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(cancel_allow_yn.equalsIgnoreCase("Y")))
				{	
					pstmt_set_status = connection.prepareStatement("select order_status from or_order where order_id=?");
					pstmt_set_status.setString(1,order_set_id);
					resultset_status = pstmt_set_status.executeQuery();
					while(resultset_status.next())
					{
						order_set_status_type= resultset_status.getString("order_status");
					}
					closeStatement(pstmt_set_status);
					closeResultSet(resultset_status);						 

					if(order_set_status_type==null) 
						order_set_status_type="";

					if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(cancel_allow_yn.equalsIgnoreCase("Y"))&&((order_set_status_type.equalsIgnoreCase("CN"))||((order_set_status_type.equalsIgnoreCase("DC")))))
					{
						//cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?)}");//IN071315//IN072752
						cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?,?,?)}");//IN071315 //IN072752
						cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
						cstmt.setString(2, order_set_id);						// P_ORDER_ID
						cstmt.setString(3, "1");				// P_ORDER_LINE_NUM
						cstmt.setString(4, p_mode); 						// P_MODE
						cstmt.setString(5, p_user);							// P_USER
						cstmt.setString(6, p_ws_no);						// P_WS_NO
						cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
						cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
						cstmt.setString(9, "N");						// FUTURE
						cstmt.setString(10, "Y");						// INCLUDE_CANCEL
						//IN071315 Starts
						if("Y".equals(p_called_from_ca))
							cstmt.setString(11, "CA");
						else
							cstmt.setString(11, "OR");
						//IN071315 Ends
						cstmt.setString(12 ,fpp_yn);//IN072752
						cstmt.setString(13, fpp_category);//IN072752
						cstmt.execute();
						p_error_message	= cstmt.getString(8);  // message

						try 
						{
							closeStatement( cstmt ) ;
						}
						catch ( Exception fe ) 
						{
							fe.printStackTrace() ;
						}	

						if(p_error_message!=null && !p_error_message.equals(""))
							result = 0;
						else 
							result = 1;

						if ( result < 1 ) 
						{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message",p_error_message ) ;
							return map;
						}
						else
						{
							result =1;
						}
					}
				}
			}
			if(result>0)
			{
				if((p_order_id.substring(0,2).equalsIgnoreCase("PH"))&&!(order_set_id.equals("")))
				{
					String login_by_id = (String)tabData.get("login_by_id");
					updateOncologyStatus(connection,order_set_id,login_by_id,"Header");
				}  

				map.put( "result", new Boolean( true ) ) ;
				map.put("message", "RECORD_MODIFIED") ;
				connection.commit();
				return map;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{				
				closeResultSet( resultSet ) ;
				closeStatement( pstmt5 ) ;
				closeStatement( pstmt4 ) ;
				closeStatement( pstmt7 ) ;
				closeStatement( pstmtupd ) ;
				closeStatement( cstmt ) ;
			}
			catch(Exception ee)
			{
				ee.printStackTrace() ;
			}
		}
		return map;
	}

	public HashMap updateLineValues(Connection connection, HashMap tabData, HashMap sqlMap)
	{
		PreparedStatement pstmt1 				= null;
		PreparedStatement pstmt2 				= null;
		PreparedStatement pstmt3 				= null;
		PreparedStatement pstmt6 				= null;
		PreparedStatement pstmt7 				= null;
		PreparedStatement pstmtupd 				= null;//IN042100
		PreparedStatement pstmt_set_status 	= null;
		ResultSet resultSet 							= null;
		ResultSet resultset_status 					= null;
		String message									= "";
		String stat											= "";
		HashMap map = new HashMap() ;
		String[] updt_vals1 ;
		String which_place = "";
		String currentDate = "";
		int result = 1;	
        String Order_ID		= "";
        String ord_typ_code	= "";
        String order_catalog_code	= "";
        String Line_Num		= "";
		String strOperation	= "";
		String Pract_ID		= "";
		String strRemarks	= "";
		String appt_ref_num	= "";
		String User_ID		= "";
		String Facility_ID 	= "";
		String Ws_No		= "";
		//Billing related parameters - start
		String p_facility_id	= "";
		String p_order_id		= "";
		String p_order_line_num	= "";
		String p_mode			= "";
		String p_user			= "";
		String p_ws_no			= "";
		//String p_bill_yn		= "";//removed
		String p_error_message	= "";
		String order_set_id="";
		String order_set_bill_yn="N";
		//Billing related parameters - end
		String order_set_status_type="";
		String bill_yn = "";
		String cont_order_ind = "";
		String print_billing_report_yn = "";
		String print_report_yn = "";
		String p_error_code = "";
		String p_error_level = "";
		String p_error_text = "";
		String cancel_allow_yn ="";
		Hashtable print_report_values 	= new Hashtable(); //Global  // For On Line Printing(Billing Report Details)
		int print_report_count = 0;
		int insert_valid = 1;
		try
		{
			updt_vals1 = (String[])tabData.get("updt_line");
		   	which_place = (String)tabData.get("which_place");
			cont_order_ind = (String)tabData.get("cont_order_ind");
			cont_order_ind = cont_order_ind.trim();
			currentDate = (String)tabData.get("currentDate");
			String order_status = (String)tabData.get("order_status");
			String p_called_from_ca = (String)tabData.get("p_called_from_ca");
			
			if(order_status==null) order_status = "";
			if(updt_vals1[0]==null) updt_vals1[0]="";
			if(updt_vals1[1]==null) updt_vals1[1]="";
			if(updt_vals1[2]==null) updt_vals1[2]="";
			if(updt_vals1[3]==null) updt_vals1[3]="";
			if(updt_vals1[4]==null) updt_vals1[4]="";
			if(updt_vals1[5]==null) updt_vals1[5]="";
			if(updt_vals1[6]==null) updt_vals1[6]="";
			if(updt_vals1[7]==null) updt_vals1[7]="";
			if(updt_vals1[8]==null) updt_vals1[8]="";
			if(updt_vals1[9]==null) updt_vals1[9]="";
			if(updt_vals1[11]==null) updt_vals1[11]="";
			if(updt_vals1[12]==null) updt_vals1[12]="";
			if(updt_vals1[13]==null) updt_vals1[13]="";

			String Refund = (String)updt_vals1[13];
			order_set_id	= updt_vals1[11].trim();
			order_set_bill_yn	= updt_vals1[12].trim();
            Order_ID	= updt_vals1[2].trim();
            Line_Num	= updt_vals1[3].trim();
            ord_typ_code	= updt_vals1[8].trim();
            order_catalog_code	= updt_vals1[9].trim();

			String fpp_yn=updt_vals1[14];//IN072752
			String fpp_category=updt_vals1[15];//IN072752
            if(which_place.trim().equals("discontinue_line_rec"))
            	strOperation	= "D";
            else if(which_place.equals("hold_line_rec"))
            	strOperation	= "H";
            else
            	strOperation	= "C";

            Pract_ID	= updt_vals1[1].trim();
            strRemarks	= updt_vals1[0].trim();
            User_ID		= updt_vals1[4].trim();
            Facility_ID	= updt_vals1[6].trim();
            Ws_No		= updt_vals1[5].trim();
			appt_ref_num= updt_vals1[7];

			if(appt_ref_num==null)
				appt_ref_num = "";
			
            p_facility_id		= Facility_ID;
            p_order_id			= Order_ID;
            p_order_line_num	= Line_Num;
            
			if(which_place.trim().equals("discontinue_line_rec"))
            	p_mode			= "DIS";
            else if(!which_place.equals("hold_line_rec"))
            	p_mode			= "CAN";
            
			p_user				= User_ID;
            p_ws_no				= Ws_No;
			//Discontinue Function Check - Start
			String resultValue	= "";

			pstmt7 = connection.prepareStatement("select nvl(PRINT_BILLING_REPORT_YN,'N') print_billing_report_yn from or_param_by_facility where operating_facility_id=?");
			pstmt7.setString(1, p_facility_id);
			resultSet = pstmt7.executeQuery();
			if (resultSet.next()) 
			{
				print_billing_report_yn	= resultSet.getString("print_billing_report_yn");
			}

			closeStatement(pstmt7) ;
			closeResultSet(resultSet) ;

			String bill_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
			pstmt7 = connection.prepareStatement(bill_sql) ;
			if(order_set_bill_yn.equalsIgnoreCase("Y"))
			{
				pstmt7.setString(1, order_set_id);
			    pstmt7.setString(2, "1");
			}
			else
			{
				pstmt7.setString(1, p_order_id);
				pstmt7.setString(2, p_order_line_num);
			}
			resultSet = pstmt7.executeQuery();
			if (resultSet.next()) 
			{
				bill_yn	= resultSet.getString("bill_yn");
				cont_order_ind	= resultSet.getString("cont_order_ind");
			}
			
			closeStatement(pstmt7) ;
			
			if(((bill_yn.equalsIgnoreCase("Y"))||(order_set_bill_yn.equalsIgnoreCase("Y")))&&Refund.equalsIgnoreCase("Y"))
			{
				String p_subs_module_id		 = "";
				String p_subs_regn_num		 = "";
				String p_subs_regn_line_num = "";
				String p_err_code					 = "";
				String p_sys_message_id		 = "";
				String p_err_text					 = "";
				CallableStatement cstmt_sub_module_dtls = null;
				CallableStatement cstmt_cancel_allow_yn 	= null;
				CallableStatement cstmt_freq_order 	= null;

				try
				{
					if((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))
					{
						cstmt_freq_order = connection.prepareCall("{call OR_FREQ_ORD_CAN_DIS(?,?,?,?,?,?,?,?,?,?) }");						
						cstmt_freq_order.setString(1, p_order_id);										// P_ORDER_ID
						cstmt_freq_order.setString(2, p_order_line_num);						    // P_ORDER_LINE_NUM
						cstmt_freq_order.setString(3, p_facility_id);									    // P_FACILITY_ID
						cstmt_freq_order.setString(4, p_mode);									    // P_FACILITY_ID
						cstmt_freq_order.setString(5, p_user);									    // P_FACILITY_ID
						cstmt_freq_order.setString(6, p_ws_no);									    // P_FACILITY_ID
						cstmt_freq_order.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_PRINT_YN
						cstmt_freq_order.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERR_CODE
						cstmt_freq_order.registerOutParameter( 9,  Types.VARCHAR ) ; 	// P_SYS_MESSAGE_ID
						cstmt_freq_order.registerOutParameter( 10,  Types.VARCHAR ) ; 	// P_ERROR_TEXT					
						cstmt_freq_order.execute();

						print_report_yn	= cstmt_freq_order.getString(7);						// P_PRINT_YN
						p_error_code	= cstmt_freq_order.getString(8);				// P_ERR_CODE
						p_sys_message_id	= cstmt_freq_order.getString(9);		// P_SYS_MESSAGE_ID
						p_err_text	= cstmt_freq_order.getString(10);				        // P_ERROR_TEXT
						
						closeStatement( cstmt_freq_order ) ;

						if(p_error_code==null) p_error_code="";
						if(p_error_code.equals(""))	
						{
							if((print_report_yn.equalsIgnoreCase("Y"))&&(print_billing_report_yn.equalsIgnoreCase("Y")))
							{
								 print_report_values.put("p_facility_id"+print_report_count,p_facility_id);
								 print_report_values.put("p_order_id"+print_report_count,p_order_id);
								 print_report_values.put("p_order_line_num"+print_report_count,p_order_line_num);
								 print_report_values.put("print_report_yn"+print_report_count,print_report_yn);
								 //map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
								 print_report_count++;
								 print_report_values.put("total_recs",String.valueOf(print_report_count)); 		
							}		
							if(print_report_count>0)
							{
								map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
							}
						}	
						if(p_error_code==null) p_error_code="";
						if(p_err_text==null) p_err_text="";
						if(p_err_text!=null && !p_err_text.equals(""))
							result = 0;
						else result = 1;
						if ( result < 1 ) 
						{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message",p_err_text ) ;
							return map;
						}
					   else if(!p_error_code.equals(""))	
					  {
						 map.put( "result", new Boolean( false ) ) ;
						 map.put("message", p_error_code) ;
						 connection.rollback();
					
						 return map;
					  }
					  else
					  {
							map.put( "result", new Boolean( true ) ) ;
							map.put("message", "RECORD_MODIFIED") ;
							connection.commit();
							return map;
					  }
					}
					else
					{
						cstmt_sub_module_dtls			= connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_SEC_KEY_FOR_PRIM_KEY(?,?,?,?,?,?,?,?,?) }");
						cstmt_sub_module_dtls.setString(1, p_facility_id);									    // P_FACILITY_ID
						if(order_set_bill_yn.equalsIgnoreCase("Y"))
						{
							cstmt_sub_module_dtls.setString(2, order_set_id);										// P_ORDER_ID
							cstmt_sub_module_dtls.setString(3, "1");						    // P_ORDER_LINE_NUM
						}
						else
						{
							cstmt_sub_module_dtls.setString(2, p_order_id);										// P_ORDER_ID
							cstmt_sub_module_dtls.setString(3, p_order_line_num);						    // P_ORDER_LINE_NUM
						}
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
						p_err_code	= cstmt_sub_module_dtls.getString(7);				                    // P_ERR_CODE
						p_sys_message_id	= cstmt_sub_module_dtls.getString(8);				        // P_SYS_MESSAGE_ID
						p_error_text	= cstmt_sub_module_dtls.getString(9);				                    // P_ERROR_TEXT
								
						if((p_err_code!=null && p_err_code!="null" && !p_err_code.equals(""))&&(p_sys_message_id!=null && p_sys_message_id!="null" && !p_sys_message_id.equals("")))
						{
						}
						else
						{
							 cstmt_cancel_allow_yn = connection.prepareCall("{ ? = call  BL_PROC_ITEM_VALIDATIONS_MP.IS_CANCEL_ORDER_ALLOWED_YN(?,?,?,?,?,?,?,?,?,?,?)}");
							cstmt_cancel_allow_yn.registerOutParameter(1,java.sql.Types.VARCHAR);

							cstmt_cancel_allow_yn.setString(2,p_facility_id);
							//IN071315 Starts 
							//cstmt_cancel_allow_yn.setString(3,"OR");
							if("Y".equals(p_called_from_ca)){
								System.out.println("1336");
								cstmt_cancel_allow_yn.setString(3,"OR|CA");
							}
							else{
								System.out.println("1340");
								cstmt_cancel_allow_yn.setString(3,"OR|OR");
							}
							//IN071315 Ends
							if(order_set_bill_yn.equalsIgnoreCase("Y"))
							{
								cstmt_cancel_allow_yn.setString( 4 , order_set_id);										// P_ORDER_ID
								cstmt_cancel_allow_yn.setString( 5 , "1");						    // P_ORDER_LINE_NUM
							}
							else
							{
								cstmt_cancel_allow_yn.setString(4,p_order_id);
								cstmt_cancel_allow_yn.setString(5,p_order_line_num);
							}
							cstmt_cancel_allow_yn.setString(6,p_subs_module_id);
							cstmt_cancel_allow_yn.setString(7,p_subs_regn_num);
							cstmt_cancel_allow_yn.setString(8,p_subs_regn_line_num);
							cstmt_cancel_allow_yn.registerOutParameter(9,java.sql.Types.VARCHAR);
							cstmt_cancel_allow_yn.registerOutParameter(10,java.sql.Types.VARCHAR);
							cstmt_cancel_allow_yn.registerOutParameter(11,java.sql.Types.VARCHAR);
							cstmt_cancel_allow_yn.registerOutParameter(12,java.sql.Types.VARCHAR);

							cstmt_cancel_allow_yn.execute();							
							cancel_allow_yn = cstmt_cancel_allow_yn.getString(1);	
							print_report_yn = cstmt_cancel_allow_yn.getString(9);	
							p_error_code = cstmt_cancel_allow_yn.getString(10);	
							p_error_level = cstmt_cancel_allow_yn.getString(11);	
							p_err_text = cstmt_cancel_allow_yn.getString(12);							
						}			
						print_report_yn = (print_report_yn==null)?"N":print_report_yn;
						p_error_code = (p_error_code==null)?"":p_error_code;
						p_error_level = (p_error_level==null)?"":p_error_level;
						p_error_text = (p_err_text==null)?"":p_err_text;
						cancel_allow_yn = (cancel_allow_yn==null)?"":cancel_allow_yn;
					}
				}catch(Exception ce)
				{
					ce.printStackTrace();
					//Handling Exception
					insert_valid = 0;
					result = 0;
					map.put( "result", new Boolean( false ) ) ;
					map.put("message", "Billing Procedure Failed") ;
					connection.rollback();
					return map; 
					//Handling Exception
				}

				if(!p_error_code.equals(""))	
				{
					insert_valid = 0;
					result = 0;
					map.put( "result", new Boolean( false ) ) ;
					map.put("message", p_error_code) ;
					connection.rollback();
					return map;
			   }
			   else
			   {
				   result =1;
				   insert_valid = 1;
			   }
			}
			
			if((((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))||(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))))&&(Refund.equalsIgnoreCase("Y")))
			{
				 if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
				 {
					   if((print_report_yn.equalsIgnoreCase("Y")&&(print_billing_report_yn.equalsIgnoreCase("Y"))))
					  {
						 print_report_values.put("p_facility_id"+print_report_count,p_facility_id);
						 if(order_set_bill_yn.equalsIgnoreCase("Y"))
						 {
							print_report_values.put("p_order_id"+print_report_count,order_set_id);
							print_report_values.put("p_order_line_num"+print_report_count,"1");
						 }
						 else
						 {
							 print_report_values.put("p_order_id"+print_report_count,p_order_id);
							print_report_values.put("p_order_line_num"+print_report_count,p_order_line_num);
						 }
						 print_report_values.put("print_report_yn"+print_report_count,print_report_yn);
						
						 print_report_count++;
						 print_report_values.put("total_recs",String.valueOf(print_report_count)); 			
					  }	
				}		    	
			}
			if(print_report_count>0)
			{
				map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)  
			}
			
			if(result>0)			
			{
				if((((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))||((bill_yn.equalsIgnoreCase("Y"))&&(Refund.equalsIgnoreCase("N")||(Refund.equalsIgnoreCase(""))))||((bill_yn.equalsIgnoreCase("Y"))&&((cont_order_ind.equalsIgnoreCase("DR"))||(cont_order_ind.equalsIgnoreCase("CR")))))||(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))))||(bill_yn.equalsIgnoreCase("N")&&(!p_order_id.equals("")))||(order_set_bill_yn.equalsIgnoreCase("N")&&(!order_set_id.equals(""))))
				{
					if(which_place.trim().equals("discontinue_line_rec")  && (Order_ID.substring(0,2).equals("RD"))) 
					{
						
						pstmt7 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_DISCONTINUE_ORDER_RD_FUNC") ) ;
						
						pstmt7.setString(1, p_order_id);
						pstmt7.setString(2, p_order_line_num);
						resultSet = pstmt7.executeQuery();
						if (resultSet.next()) 
						{
							resultValue	= resultSet.getString(1);
						}
					}
					// Start MMS-RY-SCF-0024 [IN:003522]
					if((Order_ID.substring(0,2).equals("RD")) &&(cont_order_ind.equals("DR") || cont_order_ind.equals("CR")) ){
						resultValue	="TRUE";
					}
					// End. MMS-RY-SCF-0024 [IN:003522]
					if ((resultValue!=null) && (!resultValue.equals("")) && (!resultValue.equalsIgnoreCase("TRUE"))) 
					{
						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();

						if(resultValue!=null && !resultValue.equals(""))
							map.put( "message",resultValue ) ;
						else
							map.put( "message", "Operation failure ..." ) ;
						return map;
					}//Discontinue Function Check - End		

					//Billing Procedure - Start
					if(!which_place.equals("hold_line_rec")) 
					{
						if(result!=0 && appt_ref_num!=null && !appt_ref_num.equals("") && !Order_ID.substring(0,2).equals("OT") && !Order_ID.substring(0,2).equals("RD")) //--[IN034088]
						{
							//Billing Procedure - Start
							closeStatement( cstmt ) ;
							cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_OA_CANCEL_APPOINTMENT") +" }");
 							cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
							cstmt.setString(2, appt_ref_num);					// APPTREFNO
							cstmt.setString(3, null);							// PATIENTID
							cstmt.setString(4, null); 							// REASON
							cstmt.setString(5, null);							// ALCN_CRITERIA
							cstmt.setString(6, null);							// PAT_CAT
							cstmt.setString(7, p_facility_id);					// ADDEDFACILITYID
							cstmt.setString(8, p_ws_no);						// ADDEDATWORKSTATION
							cstmt.setString(9, null);							// FORCED
							cstmt.setString(10, p_user);						// USERID
							cstmt.registerOutParameter( 11,  Types.VARCHAR ) ; 	// RESULT
 
							cstmt.execute();
							p_error_message	= cstmt.getString(11);  // message

							try 
							{
								closeStatement(cstmt);
							}
							catch ( Exception fe ) 
							{
								fe.printStackTrace() ;
							}

							if(p_error_message!=null && !p_error_message.equals(""))
								result = 0;
							else result = 1;

							if ( result < 1 ) 
							{
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								map.put( "message",p_error_message ) ;
								return map;
							}
						}//OA Appt Procedure - End
					}			

            if(which_place.trim().equals("discontinue_line_rec"))
		 	{
				closeStatement( cstmt ) ;
				cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_DISCONTINUE_ORDER_PROC") +" }");
				cstmt.setString(1, ""); 	// v_level
				cstmt.setString(2, updt_vals1[2].trim() );	// Order Id
				cstmt.setString(3, updt_vals1[3].trim());	// line_num
				cstmt.registerOutParameter( 4,  Types.VARCHAR ) ;
				cstmt.setString( 5, p_user ) ;//IN042290 - RL Module added new parameter
				cstmt.execute();
				message 	= cstmt.getString(4);  // message

				if(message!=null && !message.equals(""))
			  		result = 0;
			  	else result = 1;

				try {
						closeStatement(cstmt);
					}
					catch ( Exception fe ) {
						fe.printStackTrace() ;
					}
			}
			if ( result < 1 && (which_place.trim().equals("discontinue_line_rec"))) 
			{
				map.put( "result", new Boolean( false ) ) ;
				connection.rollback();
				insert_valid = 0; //Added By Jyothi on 14/05/2010 to fix 20588
				result = 0;
				if(message!=null && !message.equals(""))
					map.put( "message", message) ;
				else
					map.put( "message", "Operation failure ..." ) ;
			} 
			else if(result >= 1 || !(which_place.trim().equals("discontinue_line_rec"))) 
			{
				//pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE1") ) ;//Commented for IN071160
				pstmt3 = connection.prepareStatement("UPDATE  or_order_line SET order_line_status = (SELECT order_Status_code FROM or_order_status_code WHERE order_Status_type =(?)) , can_line_reason = (?) , can_pract_id = (?), can_date_time = to_date((?),'dd/mm/yyyy hh24:mi'),auto_stop_date_time =to_date((?),'dd/mm/yyyy hh24:mi'), hold_pract_id = (?), hold_date_time = to_date((?),'dd/mm/yyyy hh24:mi'), resume_pract_id = (?), resume_date_time = to_date((?),'dd/mm/yyyy hh24:mi') , disc_pract_id =(?), disc_date_time = to_date((?),'dd/mm/yyyy hh24:mi'), result_line_status = (?), discontinue_refund_yn=(?), modified_by_id=(?), modified_date=SYSDATE, modified_at_ws_no=(?), modified_facility_id=(?) WHERE order_id = (?) AND order_line_num  = (?)") ;//Added For IN071160
				if( which_place.trim().equals("discontinue_line_rec"))
				{
					pstmt3.setString( 1, "93") ; // discontinue code
					pstmt3.setString( 2, updt_vals1[0].trim()  ) ;
					pstmt3.setString( 3, null  ) ;
					pstmt3.setString( 4, null ) ;
					pstmt3.setString( 5, currentDate  ) ;
					pstmt3.setString( 6, null ) ;
					pstmt3.setString( 7, null ) ;
					pstmt3.setString( 8, null) ;
					pstmt3.setString( 9, null) ;
					pstmt3.setString( 10, updt_vals1[1].trim()) ;
					pstmt3.setString( 11, currentDate) ;
					pstmt3.setString( 12, null) ;
					pstmt3.setString( 13, "N") ;//IN071160
				} 
				else if( which_place.trim().equals("hold_line_rec"))
				{
					//IN042100 - Start
					pstmtupd = connection.prepareStatement("update or_order_line set prev_order_line_status = order_line_status where order_id = ?");
					pstmtupd.setString(1, updt_vals1[2].trim()) ;
					pstmtupd.executeUpdate();
					closeStatement(pstmtupd);
					//IN042100 - End
					pstmt3.setString( 1, "45") ; // Hold code
					pstmt3.setString( 2, updt_vals1[0].trim() ) ;
					pstmt3.setString( 3, null  ) ;
					pstmt3.setString( 4, null ) ;
					pstmt3.setString( 5, currentDate  ) ;
					pstmt3.setString( 6, updt_vals1[1].trim() ) ;
					pstmt3.setString( 7, currentDate ) ;
					pstmt3.setString( 8, null) ;
					pstmt3.setString( 9, null) ;
					pstmt3.setString( 10, null) ;
					pstmt3.setString( 11, null) ;
					pstmt3.setString( 12, order_status) ;
				} 
				//IN061903 start
				else if( which_place.trim().equals("not_done_line_rec"))
				{
					pstmtupd = connection.prepareStatement("update or_order_line set prev_order_line_status = order_line_status where order_id = ?");
					pstmtupd.setString(1, updt_vals1[2].trim()) ;
					pstmtupd.executeUpdate();
					closeStatement(pstmtupd);
					pstmt3.setString( 1, "26") ;
					pstmt3.setString( 2, updt_vals1[0].trim()  ) ;
					pstmt3.setString( 3, null  ) ;
					pstmt3.setString( 4, null ) ;
					pstmt3.setString( 5, currentDate  ) ;
					pstmt3.setString( 6, null ) ;
					pstmt3.setString( 7, null ) ;
					pstmt3.setString( 8, null) ;
					pstmt3.setString( 9, null) ;
					pstmt3.setString( 10, updt_vals1[1].trim()) ;
					pstmt3.setString( 11, currentDate) ;
					pstmt3.setString( 12, null) ;
				}
				//IN061903 ends
				else
				{
					pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE1") ) ;//IN072112
					pstmt3.setString( 1, "99") ; // cancel code
					pstmt3.setString( 2, updt_vals1[0].trim()  ) ;
					pstmt3.setString( 3, updt_vals1[1].trim()  ) ;
					pstmt3.setString( 4, currentDate ) ;
					pstmt3.setString( 5, currentDate  ) ;
					pstmt3.setString( 6, null ) ;
					pstmt3.setString( 7, null ) ;
					pstmt3.setString( 8, null) ;
					pstmt3.setString( 9, null) ;
					pstmt3.setString( 10, null) ;
					pstmt3.setString( 11, null) ;
					pstmt3.setString( 12, null  ) ;
				}
				//IN071160 STARTS
				/*pstmt3.setString( 13, p_user ) ;
				pstmt3.setString( 14, p_ws_no ) ;
				pstmt3.setString( 15, p_facility_id ) ;
				pstmt3.setString( 16, updt_vals1[2].trim()  ) ; // where clause
				pstmt3.setString( 17, updt_vals1[3].trim()  ) ;// where clause
				 */				
				if(which_place.trim().equals("discontinue_line_rec")){
					pstmt3.setString( 14, p_user ) ;
					pstmt3.setString( 15, p_ws_no ) ;
					pstmt3.setString( 16, p_facility_id ) ;
					pstmt3.setString( 17, updt_vals1[2].trim()  ) ; // where clause
					pstmt3.setString( 18, updt_vals1[3].trim()  ) ;// where clause
				}
				if(which_place.trim().equals("cancel_line_rec")){ //IN073528 starts
					pstmt3.setString( 13, p_user ) ;
					pstmt3.setString( 14, p_ws_no ) ;
					pstmt3.setString( 15, p_facility_id ) ;
					pstmt3.setString( 16, updt_vals1[2].trim()  ) ; // where clause
					pstmt3.setString( 17, updt_vals1[3].trim()  ) ;// where clause
				}// IN073528 ends
				else{
					pstmt3.setString( 13, Refund ) ;//IN073192 STARTS
					pstmt3.setString( 14, p_user ) ;
					pstmt3.setString( 15, p_ws_no ) ;
					pstmt3.setString( 16, p_facility_id ) ;
					pstmt3.setString( 17, updt_vals1[2].trim()  ) ; // where clause
					pstmt3.setString( 18, updt_vals1[3].trim()  ) ;// where clause//IN073192 ENDS
				}
				//IN071160 ENDS
				result = pstmt3.executeUpdate();

				closeStatement( pstmt3 ) ;

            //For Updating the Appt_ref_num and Appt_date_time with null
            if( which_place.trim().equals("cancel_line_rec")  && (!Order_ID.substring(0,2).equals("PH")))
			{
				pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE") ) ;
                pstmt6.setString( 1, p_user ) ;
				pstmt6.setString( 2, p_ws_no ) ;
				pstmt6.setString( 3, p_facility_id ) ;
            	pstmt6.setString( 4, p_order_id) ;
            	pstmt6.setString( 5, p_order_line_num) ;
            	pstmt6.executeUpdate();
 				closeStatement( pstmt6 ) ;
			}
			if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR"))  && (!Order_ID.substring(0,2).equals("PH")))
			{
				closeStatement( pstmt3 ) ;
				pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE1_FREQ_EXPLN") ) ;
                
				if( which_place.trim().equals("discontinue_line_rec"))
				{
					pstmt3.setString( 1, "93") ; // discontinue code
					pstmt3.setString( 2, updt_vals1[0].trim()  ) ;
					pstmt3.setString( 3, null  ) ;
					pstmt3.setString( 4, null ) ;
					pstmt3.setString( 5, currentDate  ) ;
					pstmt3.setString( 6, null ) ;
					pstmt3.setString( 7, null ) ;
					pstmt3.setString( 8, null) ;
					pstmt3.setString( 9, null) ;
					pstmt3.setString( 10, updt_vals1[1].trim()) ;
					pstmt3.setString( 11, currentDate) ;
					pstmt3.setString( 12, null  ) ;
				}
				else if( which_place.trim().equals("hold_line_rec"))
				{

					pstmt3.setString( 1, "45") ; // Hold code
					//pstmt3.setString( 2, null  ) ;
					pstmt3.setString( 2, updt_vals1[0].trim()  ) ;
					pstmt3.setString( 3, null  ) ;
					pstmt3.setString( 4, null ) ;
					pstmt3.setString( 5, currentDate  ) ;
					pstmt3.setString( 6, updt_vals1[1].trim() ) ;
					pstmt3.setString( 7, currentDate ) ;
					pstmt3.setString( 8, null) ;
					pstmt3.setString( 9, null) ;
					pstmt3.setString( 10, null) ;
					pstmt3.setString( 11, null) ;
					pstmt3.setString( 12, order_status  ) ;
				}
				else
				{
					pstmt3.setString( 1, "99") ; // cancel code
					pstmt3.setString( 2, updt_vals1[0].trim()  ) ;
					pstmt3.setString( 3, updt_vals1[1].trim()  ) ;
					pstmt3.setString( 4, currentDate ) ;
					pstmt3.setString( 5, currentDate  ) ;
					pstmt3.setString( 6, null ) ;
					pstmt3.setString( 7, null ) ;
					pstmt3.setString( 8, null) ;
					pstmt3.setString( 9, null) ;
					pstmt3.setString( 10, null) ;
					pstmt3.setString( 11, null) ;
					pstmt3.setString( 12, null  ) ;
				}
					pstmt3.setString( 13, p_user ) ;
					pstmt3.setString( 14, p_ws_no ) ;
					pstmt3.setString( 15, p_facility_id ) ;
					pstmt3.setString( 16, updt_vals1[2].trim()  ) ; // where clause
					pstmt3.setString( 17, updt_vals1[3].trim()  ) ;// where clause
					result = pstmt3.executeUpdate();

					closeStatement( pstmt3 ) ;

				//For Updating the Appt_ref_num and Appt_date_time with null
            	if( which_place.trim().equals("cancel_line_rec"))
				{
					closeStatement( pstmt6 ) ;	
					pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE_FREQ_EXPLN") ) ;
                    pstmt6.setString( 1, p_user ) ;
					pstmt6.setString( 2, p_ws_no ) ;
					pstmt6.setString( 3, p_facility_id ) ;
            		pstmt6.setString( 4, p_order_id) ;
            		pstmt6.setString( 5, p_order_line_num) ;
            		pstmt6.executeUpdate();

					closeStatement( pstmt6 ) ;

            	}
			}
			
			//--[IN029354] - Modified
			//String sql = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT");
			//String sql = "select order_id,order_line_status from or_order_line a where order_id = (?) and order_line_num not in (?) and order_line_Status in (select order_Status_code from or_ordeR_status_code where ordeR_status_type in ('99','97','96','95','90','85','80','75','70','65','60','55','54','52','25','20','15','10','05','03','00','23','35') and order_Status_code = a.order_line_status and rownum <=1)   order by order_line_status ASC"; // commented for IN49280
			String sql = "select order_id,order_line_status from or_order_line a where order_id = (?) and order_line_num not in (?) and order_line_Status in (select order_Status_code from or_ordeR_status_code where ordeR_status_type in ('99','97','96','95','90','85','80','75','70','65','60','55','54','52','25','20','15','10','05','03','00','23','35','56','58','36') and order_Status_code = a.order_line_status and rownum <=1)   order by order_line_status ASC"; // modified for IN49280 - Statuses 56 and 58 added(Dispense Complete & Dispense Partial),added status '36' FOR SKR-SCF-1304
			
			String hdr_code = "";

			
			int t = sql.lastIndexOf("?");
				if(updt_vals1[3].trim().equals("")||updt_vals1[3].trim().equals(null))
				updt_vals1[3]="1";

			sql  = sql.substring(0,t) + updt_vals1[3] + sql.substring(t+1)  ;
			pstmt2 = connection.prepareStatement( sql ) ;

			pstmt2.setString( 1, updt_vals1[2].trim()  ) ;
			closeResultSet( resultSet ) ; 
			resultSet = pstmt2.executeQuery();

			while(resultSet != null && resultSet.next() )
			{			// Returns one record, changed while from if
				hdr_code = resultSet.getString("order_line_status");
				if(hdr_code==null) hdr_code = "";
			}
	
			if( !hdr_code.equals("")) 
			{
				result=0;
				pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE2") ) ;
				
               /* User_ID		= updt_vals1[4].trim();
            Facility_ID	= updt_vals1[6].trim();
            Ws_No		= updt_vals1[5].trim();*/ 
				pstmt1.setString(1,hdr_code.trim() ) ;
				pstmt1.setString(2,User_ID);
				pstmt1.setString(3,Ws_No);	
				pstmt1.setString(4,Facility_ID);
				pstmt1.setString(5, updt_vals1[2].trim() ) ;

				result = pstmt1.executeUpdate();
				closeStatement( pstmt1 ) ;


				if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR"))  && (!Order_ID.substring(0,2).equals("PH")))
				{
					 
					pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE2_FREQ_EXPLN") ) ;
                    
					pstmt1.setString( 1, hdr_code.trim() ) ;
					pstmt1.setString( 2, p_user ) ;
					pstmt1.setString( 3, p_ws_no ) ;
					pstmt1.setString( 4, p_facility_id ) ;
					pstmt1.setString( 5, updt_vals1[2].trim() ) ;

					result = pstmt1.executeUpdate();
					closeStatement( pstmt1 ) ;
				}

			}
			else
			{
				result=0;
				closeStatement( pstmt1 ) ;
				pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE3") ) ;
				
				if( which_place.trim().equals("discontinue_line_rec"))
					pstmt1.setString( 1, "93") ; // discontinue code
				else if( which_place.trim().equals("hold_line_rec"))
					pstmt1.setString( 1, "45") ; // hold code
				//IN061903 start
				else if( which_place.trim().equals("not_done_line_rec"))
					pstmt1.setString( 1, "26") ; // Not Done
				//IN061903 ends
				else
					pstmt1.setString( 1, "99") ; // cancel code
				pstmt1.setString( 2, p_user ) ;
				pstmt1.setString( 3, p_ws_no ) ;
				pstmt1.setString( 4, p_facility_id ) ;
				pstmt1.setString( 5, updt_vals1[2].trim() ) ;
				result = pstmt1.executeUpdate();
				if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR"))  && (!Order_ID.substring(0,2).equals("PH"))){
					closeStatement( pstmt1 ) ;
					pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN") ) ;
					
					if( which_place.trim().equals("discontinue_line_rec"))
						pstmt1.setString( 1, "93") ; // discontinue code
					else if( which_place.trim().equals("hold_line_rec"))
						pstmt1.setString( 1, "45") ; // hold code
					//IN061903 start
					else if( which_place.trim().equals("not_done_line_rec"))
						pstmt1.setString( 1, "26") ; // Not Done
					//IN061903 ends
					else
						pstmt1.setString( 1, "99") ; // cancel code
					
					pstmt1.setString( 2, p_user ) ;
					pstmt1.setString( 3, p_ws_no ) ;
					pstmt1.setString( 4, p_facility_id ) ;
					pstmt1.setString( 5, updt_vals1[2].trim() ) ;
					pstmt1.executeUpdate();
					//result = pstmt1.executeUpdate();   //this is commented since in many cases it's not exploded properly 
					closeStatement( pstmt1 ) ;
				}
			}
			


			// Call the Procedure
		 /*if(result > 0 && which_place.trim().equals("discontinue_line_rec"))
		 {
			cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_DISCONTINUE_ORDER_PROC") +" }");
			cstmt.setString(1, ""); 	// v_level
			cstmt.setString(2, updt_vals1[2].trim() );	// Order Id
			cstmt.setString(3, updt_vals1[3].trim());	// line_num
			cstmt.registerOutParameter( 4,  Types.VARCHAR ) ;
			cstmt.execute();
			message 	= cstmt.getString(4);  // message
			if(message!=null && !message.equals(""))
			  result = 0;
		} */

	

			if ( result < 1 ) 
			{
				map.put( "result", new Boolean( false ) ) ;
				connection.rollback();
				if(message!=null && !message.equals(""))
					map.put( "message", message) ;
				else
					map.put( "message", "Operation failure ..." ) ;

			} 
			else  
			{
				if (Order_ID.substring(0,2).equals("PH")) 
				{
					closeStatement( cstmt ) ;
					cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_PH_PATIENTDRUGPROFILEUPDATE_PROC") +" }");
					
					cstmt.setString(1, Order_ID); 		// P_ORDERID
					cstmt.setString(2, Line_Num);		// P_ORDERLINENO
					cstmt.setString(3, strOperation);	// P_OPERATION
					cstmt.setString(4, ""); 			// P_REASONCODE
					cstmt.setString(5, strRemarks);		// P_REMARKS
					cstmt.setString(6, Pract_ID);		// P_PRACTITIONERID
					cstmt.setString(7, User_ID); 		// P_USERID
					cstmt.setString(8, Facility_ID);	// P_FACILITYID
					cstmt.setString(9, Ws_No);			// P_WSNO
					cstmt.registerOutParameter( 10,  Types.VARCHAR ) ; //P_ERRMSG
					cstmt.execute();
					message	= cstmt.getString(10);  // message
					if(message!=null && !message.equals(""))
				  		result = 0;
					else result = 1;
				}

				if ( result < 1 ) 
				{
					map.put( "result", new Boolean( false ) ) ;
					connection.rollback();
					if(message!=null && !message.equals(""))
						map.put( "message",message ) ;
					else
						map.put( "message", "Operation failure ..." ) ;

				}
			  }
			}
			

			if(result >= 1)
			{
				//which_place.trim().equals("discontinue_line_rec") ||
				if( which_place.trim().equals("cancel_line_rec"))
				{
					/*****************************************************************************/
					try	
					{
						closeResultSet(resultSet);
						pstmt1 = connection.prepareStatement((String)sqlMap.get("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt1.setString( 1, "RL" ) ;
						pstmt1.setString( 2, p_facility_id ) ;						
						resultSet = pstmt1.executeQuery();
						String rl_install_yn="";

						while(resultSet.next())
						{
							rl_install_yn = (String)resultSet.getString("operational_yn");

						}

					closeStatement(pstmt1);
					closeResultSet(resultSet);
					if( (Order_ID.substring(0,2).equals("LB")) && rl_install_yn.equals("Y") )
					{

						closeStatement( cstmt ) ;

						cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_SPECIMEN_ORDER_RL_NEONATES_SPEC_YN") +" }");
						cstmt.setString(1, p_order_id);
						cstmt.setString(2, ord_typ_code);
						cstmt.registerOutParameter(3,Types.VARCHAR);

						cstmt.execute();

						String neonate_spec_yn=cstmt.getString(3);

						closeStatement( cstmt ) ;
						if(neonate_spec_yn.equals("Y"))
						{
							if(which_place.trim().equals("cancel_line_rec"))
							{
						
								cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_CANCEL_ORDER_RL_CANCEL_SPECIMEN") +" }");
								cstmt.setString(1, "L");
								cstmt.setString(2, p_order_id);
								cstmt.setString(3, ord_typ_code);
								cstmt.setString(4, order_catalog_code);
								cstmt.registerOutParameter(5,Types.VARCHAR );//stat
								cstmt.registerOutParameter(6,Types.VARCHAR );//error_text
								cstmt.execute();
								stat	= cstmt.getString(5);  // stat
								message	= cstmt.getString(6);  // message
								if(stat!=null && stat.equals("E"))
									result = 0;
								else result = 1;	

								closeStatement( cstmt ) ;
							}
							/*else if(which_place.trim().equals("discontinue_line_rec")){

												
								cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_CANCEL_ORDER_RL_DISCONTINUE_REQUEST") +" }");

								cstmt.setString(1, "L");
								cstmt.setString(2, p_order_id);
								cstmt.setString(3, order_catalog_code);
								cstmt.registerOutParameter(4,Types.VARCHAR );//error_text
								cstmt.registerOutParameter(5,Types.VARCHAR );//stat

								cstmt.execute();

								message	= cstmt.getString(4);  // message

								if(message!=null && !message.equals(""))
									result = 0;
								else result = 1;	
								closeStatement( cstmt ) ;
							}*/
						}					
					}

					if ( result < 1 ) 
					{
						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						if(message!=null && !message.equals(""))
							map.put( "message",message ) ;
						else
							map.put( "message", "Operation failure ..." ) ;

					}
					
					//*******
				   }
				   catch(Exception e1)
				   {
					   e1.printStackTrace();
				   }
				}
				else 
				{
					if ( result < 1 ) 
					{
						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						map.put( "message",p_error_message ) ;
						return map;
					}
					//Billing Procedure - End
					/*if ( result < 1 ) 
					{
						traceVals.append("PH====ROLLBACK");

						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						if(message!=null && !message.equals(""))
							map.put( "message",message ) ;
						else
							map.put( "message", "Operation failure ..." ) ;

					}*/
					else
					{
						/*****************************************************************************/
						/*if(print_report_yn.equalsIgnoreCase("Y"))
					  {
						 print_report_values.put("p_facility_id",p_facility_id);
						 print_report_values.put("p_order_id",p_order_id);
						 print_report_values.put("p_order_line_num",p_order_line_num);
						 print_report_values.put("print_report_yn",print_report_yn);
						 map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
					  }		
						map.put("print_report_yn",print_report_yn);*/
						
						//connection.commit() ;
						//map.put( "result", new Boolean( true ) ) ;
						//map.put( "message", "RECORD_MODIFIED" ) ;
					
						//messages.append( "RECORD_MODIFIED" ) ;
						//messages.append( "Operation Completed Successfully..." ) ;
					  }

						/*if(print_report_yn.equalsIgnoreCase("Y"))
					   {
							 print_report_values.put("p_facility_id",p_facility_id);
							 print_report_values.put("p_order_id",p_order_id);
							 print_report_values.put("p_order_line_num",p_order_line_num);
							 print_report_values.put("print_report_yn",print_report_yn);
							 map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
						}		
						map.put("print_report_yn",print_report_yn);*/
						//connection.commit() ;
						//map.put( "result", new Boolean( true ) ) ;
						//map.put( "message", "RECORD_MODIFIED" ) ;			

				}
				/*Added by Uma on 1/21/2010 for IN018276*/
				if((result>=1)&&(!which_place.equals("hold_line_rec")))
				{
					  //if(((!(order_set_status_query.equals("")))&&(order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((order_set_status_type.equalsIgnoreCase("CN"))||((order_set_status_type.equalsIgnoreCase("DC")))))||(order_set_bill_yn.equalsIgnoreCase("N")))
					  if(order_set_bill_yn.equalsIgnoreCase("N")&&(bill_yn.equalsIgnoreCase("Y"))&&(Refund.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))
					  {
							//cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") +" }");
							if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
							{
								//cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?)}");//IN072752
								cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?,?,?)}");//071315//IN072752
								cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
								cstmt.setString(2, p_order_id);						// P_ORDER_ID
								cstmt.setString(3, p_order_line_num);				// P_ORDER_LINE_NUM
								cstmt.setString(4, p_mode); 						// P_MODE
								cstmt.setString(5, p_user);							// P_USER
								cstmt.setString(6, p_ws_no);						// P_WS_NO
								cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
								cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE	
								cstmt.setString(9, "N");						// FUTURE
								cstmt.setString(10, "Y");						// INCLUDE_CANCEL
								//IN071315 Starts
								if("Y".equals(p_called_from_ca))
									cstmt.setString(11, "CA");
								else
									cstmt.setString(11, "OR");
								//IN071315 Ends
								cstmt.setString(12, fpp_yn);//IN072752
								cstmt.setString(13, fpp_category);//IN072752
								cstmt.execute();
								p_error_message	= cstmt.getString(8);  // message
								
								
								if(p_error_message!=null && !p_error_message.equals(""))
									result = 0;
								else result = 1;

								try 
								{
									closeStatement(cstmt);
								}						
								catch ( Exception fe ) 
								{
									fe.printStackTrace() ;
								}
							  }
						}						
					}
					/*Ends Here*/
					if(p_error_message==null) p_error_message="";
					
				   if(!p_error_message.equals(""))	
				  {
					 insert_valid = 0;
					 result = 0;
					 map.put( "result", new Boolean( false ) ) ;
					 map.put("message", p_error_message) ;
					 connection.rollback();

					 return map;
				  }
				   else
				  {
					  insert_valid = 1;
					  result = 1;
					 /*map.put("message", "RECORD_MODIFIED") ;
					 map.put( "result", new Boolean( true ) ) ;
					 connection.commit();*/
				  

					//return map;
				  }
			  }
			  

		   }
		}
		   /*else
			{
				if(p_error_code==null) p_error_code="";
			    if(!p_error_code.equals(""))
				{
					 insert_valid = 0;
					map.put( "result", new Boolean( false ) ) ;
					connection.rollback();
					map.put("message", p_error_code) ;		
				    return map;
				}
				else
				{
					 insert_valid = 1;
					/*map.put( "result", new Boolean( true ) ) ;
					connection.commit();
					map.put( "message", "RECORD_MODIFIED") ;		
				    return map;
				}
			}*/
			
			if(result>0)
			{			   	 
		  		if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(cancel_allow_yn.equalsIgnoreCase("Y")))
				{
		 
					  pstmt_set_status = connection.prepareStatement("select order_status from or_order where order_id=?");
					  pstmt_set_status.setString(1,order_set_id);
					  resultset_status = pstmt_set_status.executeQuery();
					  while(resultset_status.next())
					  {
						 order_set_status_type= resultset_status.getString("order_status");
					  }
					  closeStatement(pstmt_set_status);
					  closeResultSet(resultset_status);						 
							
					  if(order_set_status_type==null) order_set_status_type="";

					if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(cancel_allow_yn.equalsIgnoreCase("Y"))&&((order_set_status_type.equalsIgnoreCase("CN"))||((order_set_status_type.equalsIgnoreCase("DC")))))
					{
						cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?)}");//071315
						cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
						cstmt.setString(2, order_set_id);						// P_ORDER_ID
						cstmt.setString(3, "1");				// P_ORDER_LINE_NUM
						cstmt.setString(4, p_mode); 						// P_MODE
						cstmt.setString(5, p_user);							// P_USER
						cstmt.setString(6, p_ws_no);						// P_WS_NO
						cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
						cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
						cstmt.setString(9, "N");						// FUTURE
						cstmt.setString(10, "Y");						// INCLUDE_CANCEL
						//IN071315 Starts
						if("Y".equals(p_called_from_ca))
							cstmt.setString(11, "CA");
						else
							cstmt.setString(11, "OR");
						//IN071315 Ends
						cstmt.execute();
						p_error_message	= cstmt.getString(8);  // message
					
						try 
						{
							closeStatement( cstmt ) ;
						}
						catch ( Exception fe ) 
						{
							fe.printStackTrace() ;
						}	
						if(p_error_message!=null && !p_error_message.equals(""))
							result = 0;
						else result = 1;
						if ( result < 1 ) 
						{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message",p_error_message ) ;
							return map;
						}
						else
						{
							result =1;
						}
				}
			}
		  }
		
		  if(result>0)
		  {
			  if((p_order_id.substring(0,2).equalsIgnoreCase("PH"))&&!(order_set_id.equals("")))
			  {
				   String login_by_id = (String)tabData.get("login_by_id");
				  updateOncologyStatus(connection,order_set_id,login_by_id,"Line");
			  }
		   }
		   //Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 15/02/2013
		   //start
		   if(result>0)
		  {
			  if((p_order_id.substring(0,2).equalsIgnoreCase("OT"))&&(which_place.trim().equals("cancel_line_rec")))
			  {
				String ip_result=UpdateIPBookingOrder(connection,p_order_id,Line_Num,p_user,p_ws_no,p_facility_id);
				if(!ip_result.equals(""))
					{
					map.put( "result", new Boolean( false ) ) ;
					connection.rollback();
					map.put( "message",ip_result) ;
					return map;
					}
			  }
			map.put( "result", new Boolean( true ) ) ;
			map.put("message", "RECORD_MODIFIED") ;
			connection.commit();
			return map;
		   }
		   //End
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			try
			{
				connection.rollback();
			}catch(Exception es)
			{
				es.printStackTrace() ;
			}
		}
		finally
		{
			try
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeStatement( pstmt3 ) ;
				closeStatement( pstmt6 ) ;
				closeStatement( pstmt7 ) ;
				closeStatement(cstmt);
			}
			catch(Exception ee)
			{
				ee.printStackTrace() ;
			}
		}
		return map;
	}

	public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap)
	{
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;
		PreparedStatement pstmt4 	= null;
		PreparedStatement pstmt5 	= null;
		PreparedStatement pstmt6 	= null;
		PreparedStatement pstmt7 	= null;
		PreparedStatement pstmt71 	= null;
		PreparedStatement pstmt_set_status 	= null;
		ResultSet resultSet 		= null;
		ResultSet resultSet71		= null;
		ResultSet resultset_status		= null;
		HashMap map = new HashMap() ;
		String message				= "";
		String stat				= "";
		int insert_valid = 1;
		int count =0;
		count = Integer.parseInt((String)tabData.get("totalCount"));
		//count--;
		//if(count == 0) count = 1; // this is done to handle the single record..to get into the for loop
		String[] updt_vals1 ;
		String[] updt_vals2 ;
		String currentDate = "";
		int result = 1;
		String hdr_code = "";
		String tmpStr = "";
		int i=0;
		String cancel_type = "";
		String cont_order_ind = "";	
		currentDate   = (String)tabData.get("currentDate");
		cancel_type   = (String)tabData.get("cancel_type");
		cont_order_ind= (String)tabData.get("cont_order_ind");
		String p_called_from_ca = (String)tabData.get("p_called_from_ca");
		tmpStr   = (String)tabData.get("tmpStr");
		//Billing related parameters - start
		String p_facility_id	= "";
		String p_order_id		= "";
		String ord_typ_code		= "";
		String p_order_line_num	= "";
		String p_mode			= "CAN";
		String p_user			= "";
		String p_ws_no			= "";
		String p_error_message	= "";
		String order_set_id="";
		String order_set_bill_yn="N";
		String bill_yn = "";
		String bill_on_regn_yn = "";
		String print_billing_report_yn = "";
		String print_report_yn = "";
		String p_error_code = "";
		String p_error_level = "";
		String p_error_text = "";
		String cancel_allow_yn ="";
		Hashtable print_report_values 	= new Hashtable(); //Global  // For On Line Printing(Billing Report Details)
		String total_line_num = "";
		String order_set_status_type="";
		//Billing related parameters - end
		int print_report_count = 0;
		int bill_yn_count= 0;
		int cancel_allow_count = 0;
		StringBuffer tracer = new StringBuffer();
		String fpp_yn = "";//IN072752
		String fpp_category = "";//IN072752

		try
		{
			do
			{	//IN049782 // added condition to avoid looping if it is header level cancel
				//if((cancel_type.trim()).equals("H")) 
				if((cancel_type.trim()).equals("H") && i== 0)
				{	
					updt_vals1 = (String[])tabData.get("head_data");
					updt_vals2 = (String[])tabData.get("line_data");
					updt_values1	= updt_vals1;
					updt_values2	= updt_vals2;
					p_order_id			= updt_vals1[0].trim();
					p_facility_id		= updt_vals1[4].trim();
					p_user				= updt_vals1[2].trim();
					p_ws_no				= updt_vals1[3].trim();
					ord_typ_code		= updt_vals1[5].trim();
					order_set_id		= updt_vals1[9].trim();
					order_set_bill_yn	= updt_vals1[10].trim();
					fpp_yn		= updt_vals2[5];//IN072752
					fpp_category	= updt_vals2[6];//IN072752
					pstmt7 = connection.prepareStatement("select nvl(PRINT_BILLING_REPORT_YN,'N') print_billing_report_yn from or_param_by_facility where operating_facility_id=?");
					pstmt7.setString(1, p_facility_id);
					resultSet = pstmt7.executeQuery();
					
					if (resultSet.next()) 
					{
						print_billing_report_yn	= resultSet.getString("print_billing_report_yn");
					}

					closeStatement(pstmt7) ;
					closeResultSet(resultSet) ;

					pstmt71 = connection.prepareStatement("select order_line_num from or_order_line where order_id=?");
					pstmt71.setString(1, p_order_id);
					resultSet71 = pstmt71.executeQuery();
					while(resultSet71.next()) 
					{
						total_line_num =  (String)resultSet71.getString("order_line_num");
						String bill_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
						pstmt7 = connection.prepareStatement(bill_sql) ;
						
						if(order_set_bill_yn.equalsIgnoreCase("Y"))
						{
							pstmt7.setString(1, order_set_id);
							pstmt7.setString(2, "1");
						}						
						else
						{
							pstmt7.setString(1, p_order_id);
							pstmt7.setString(2, total_line_num);
						}
						resultSet = pstmt7.executeQuery();

						if (resultSet.next()) 
						{
							bill_yn	= resultSet.getString("bill_yn");
							cont_order_ind	= resultSet.getString("cont_order_ind");
						}

						if(bill_yn.equalsIgnoreCase("Y"))
						{
							bill_yn_count ++;
						}
						closeStatement(pstmt7) ;
						closeResultSet(resultSet) ;
						tracer.append("\nCancelManager.java,2274,bill_sql=>"+bill_sql+",bill_yn=>"+bill_yn+" ,cont_order_ind=>"+cont_order_ind+",bill_on_regn_yn=>"+bill_on_regn_yn);
						if((bill_yn.equalsIgnoreCase("Y"))||(order_set_bill_yn.equalsIgnoreCase("Y")))
						{
							String p_subs_module_id		 = "";
							String p_subs_regn_num		 = "";
							String p_subs_regn_line_num = "";
							String p_err_code					 = "";
							String p_sys_message_id		 = "";
							String p_err_text					 = "";
							CallableStatement cstmt_sub_module_dtls = null;
							CallableStatement cstmt_cancel_allow_yn 	= null;
							CallableStatement cstmt_freq_order 	= null;

							try
							{
								if((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))
								{
									cstmt_freq_order = connection.prepareCall("{call OR_FREQ_ORD_CAN_DIS(?,?,?,?,?,?,?,?,?,?) }");

									cstmt_freq_order.setString(1, p_order_id);										// P_ORDER_ID
									cstmt_freq_order.setString(2, total_line_num);						    // P_ORDER_LINE_NUM
									cstmt_freq_order.setString(3, p_facility_id);									    // P_FACILITY_ID
									cstmt_freq_order.setString(4, p_mode);									    // P_FACILITY_ID
									cstmt_freq_order.setString(5, p_user);									    // P_FACILITY_ID
									cstmt_freq_order.setString(6, p_ws_no);									    // P_FACILITY_ID
									cstmt_freq_order.registerOutParameter( 7,  Types.VARCHAR ) ;// P_PRINT_YN
									cstmt_freq_order.registerOutParameter( 8,  Types.VARCHAR ) ;// P_ERR_CODE
									cstmt_freq_order.registerOutParameter( 9,  Types.VARCHAR ) ;// P_SYS_MESSAGE_ID
									cstmt_freq_order.registerOutParameter( 10,  Types.VARCHAR );// P_ERROR_TEXT					
									cstmt_freq_order.execute();

									print_report_yn	= cstmt_freq_order.getString(7);						// P_PRINT_YN
									p_error_code	= cstmt_freq_order.getString(8);				// P_ERR_CODE
									p_sys_message_id	= cstmt_freq_order.getString(9);		// P_SYS_MESSAGE_ID
									p_err_text	= cstmt_freq_order.getString(10);				        // P_ERROR_TEXT

									closeStatement(cstmt_freq_order) ;

									if(p_error_code==null) 
										p_error_code="";

									if(p_error_code.equals(""))	
									{
										if((print_report_yn.equalsIgnoreCase("Y"))&&(print_billing_report_yn.equalsIgnoreCase("Y")))
										{
											print_report_values.put("p_facility_id"+print_report_count,p_facility_id);
											print_report_values.put("p_order_id"+print_report_count,p_order_id);
											print_report_values.put("p_order_line_num"+print_report_count,total_line_num);
											print_report_values.put("print_report_yn"+print_report_count,print_report_yn);
											//map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
											print_report_count++;
											print_report_values.put("total_recs",String.valueOf(print_report_count)); 		
										}
										
										if(print_report_count>0)
										{
											map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
										}
									}
									
									if(p_error_code==null) 
										p_error_code="";
									
									if(p_err_text==null) 
										p_err_text="";

									if(p_err_text!=null && !p_err_text.equals(""))
										result = 0;
									else 
										result = 1;
									if ( result < 1 ) 
									{
										result = 0;
										map.put( "result", new Boolean( false ) ) ;
										connection.rollback();
										map.put( "message",p_err_text ) ;
										return map;
									}
									else if(!p_error_code.equals(""))	
									{
										result = 0;
										map.put( "result", new Boolean( false ) ) ;
										map.put("message", p_error_code) ;
										connection.rollback();
										return map;
									}
									else
									{
										result = 1;
										map.put("message", "RECORD_MODIFIED") ;
										map.put( "result", new Boolean( true ) ) ;
										connection.commit();
										return map;
									} 
								}
								else
								{
									cstmt_sub_module_dtls			= connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_SEC_KEY_FOR_PRIM_KEY(?,?,?,?,?,?,?,?,?) }");
									cstmt_sub_module_dtls.setString(1, p_facility_id);// P_FACILITY_ID
									if(order_set_bill_yn.equalsIgnoreCase("Y"))
									{
										cstmt_sub_module_dtls.setString( 2 , order_set_id);// P_ORDER_ID
										cstmt_sub_module_dtls.setString( 3 , "1");			
									}
									else
									{
										cstmt_sub_module_dtls.setString(2, p_order_id);// P_ORDER_ID
										cstmt_sub_module_dtls.setString(3, total_line_num);// P_ORDER_LINE_NUM
									}
									cstmt_sub_module_dtls.registerOutParameter( 4,  Types.VARCHAR ) ;// P_SUBS_MODULE_ID
									cstmt_sub_module_dtls.registerOutParameter( 5,  Types.VARCHAR ) ;// P_SUBS_REGN_NUM
									cstmt_sub_module_dtls.registerOutParameter( 6,  Types.VARCHAR ) ;// P_SUBS_REGN_LINE_NUM
									cstmt_sub_module_dtls.registerOutParameter( 7,  Types.VARCHAR ) ;// P_ERR_CODE
									cstmt_sub_module_dtls.registerOutParameter( 8,  Types.VARCHAR ) ;// P_SYS_MESSAGE_ID	
									cstmt_sub_module_dtls.registerOutParameter( 9,  Types.VARCHAR ) ;// P_ERROR_TEXT
									cstmt_sub_module_dtls.execute();
									p_subs_module_id	= cstmt_sub_module_dtls.getString(4);						// P_SUBS_MODULE_ID
									p_subs_regn_num	= cstmt_sub_module_dtls.getString(5);						    // P_SUBS_REGN_NUM
									p_subs_regn_line_num	= cstmt_sub_module_dtls.getString(6);				    // P_SUBS_REGN_LINE_NUM
									p_err_code	= cstmt_sub_module_dtls.getString(7);				                    // P_ERR_CODE
									p_sys_message_id	= cstmt_sub_module_dtls.getString(8);				        // P_SYS_MESSAGE_ID
									p_error_text	= cstmt_sub_module_dtls.getString(9);				                    // P_ERROR_TEXT

									if((p_err_code!=null && p_err_code!="null" && !p_err_code.equals(""))&&(p_sys_message_id!=null && p_sys_message_id!="null" && !p_sys_message_id.equals("")))
									{
									}
									else
									{
										cstmt_cancel_allow_yn = connection.prepareCall("{ ? = call  BL_PROC_ITEM_VALIDATIONS_MP.IS_CANCEL_ORDER_ALLOWED_YN(?,?,?,?,?,?,?,?,?,?,?)}");
										cstmt_cancel_allow_yn.registerOutParameter(1,java.sql.Types.VARCHAR);

										cstmt_cancel_allow_yn.setString(2,p_facility_id);
										//IN071315 Starts
										//cstmt_cancel_allow_yn.setString(3,"OR");
										if("Y".equals(p_called_from_ca)){
											cstmt_cancel_allow_yn.setString(3,"OR|CA");
										}
										else{
											cstmt_cancel_allow_yn.setString(3,"OR|OR");
										}
										//IN071315 Ends
										if(order_set_bill_yn.equalsIgnoreCase("Y"))
										{
											cstmt_cancel_allow_yn.setString( 4 , order_set_id);										// P_ORDER_ID
											cstmt_cancel_allow_yn.setString( 5 , "1");						    // P_ORDER_LINE_NUM
										}
										else
										{
											cstmt_cancel_allow_yn.setString(4,p_order_id);
											cstmt_cancel_allow_yn.setString(5,total_line_num);
										}
										cstmt_cancel_allow_yn.setString(6,p_subs_module_id);
										cstmt_cancel_allow_yn.setString(7,p_subs_regn_num);
										cstmt_cancel_allow_yn.setString(8,p_subs_regn_line_num);
										cstmt_cancel_allow_yn.registerOutParameter(9,java.sql.Types.VARCHAR);
										cstmt_cancel_allow_yn.registerOutParameter(10,java.sql.Types.VARCHAR);
										cstmt_cancel_allow_yn.registerOutParameter(11,java.sql.Types.VARCHAR);
										cstmt_cancel_allow_yn.registerOutParameter(12,java.sql.Types.VARCHAR);
										cstmt_cancel_allow_yn.execute();							
										cancel_allow_yn = cstmt_cancel_allow_yn.getString(1);	
										print_report_yn = cstmt_cancel_allow_yn.getString(9);	
										p_error_code = cstmt_cancel_allow_yn.getString(10);	
										p_error_level = cstmt_cancel_allow_yn.getString(11);	
										p_err_text = cstmt_cancel_allow_yn.getString(12);	
									}			
									print_report_yn = (print_report_yn==null)?"N":print_report_yn;
									p_error_code = (p_error_code==null)?"":p_error_code;
									p_error_level = (p_error_level==null)?"":p_error_level;
									p_error_text = (p_err_text==null)?"":p_err_text;
									cancel_allow_yn = (cancel_allow_yn==null)?"":cancel_allow_yn;
								}
							}
							catch(Exception ce)
							{
								ce.printStackTrace();
							}
						}

						if(cancel_allow_yn.equalsIgnoreCase("Y"))
						{
							cancel_allow_count ++;
						}
						if(bill_yn_count==cancel_allow_count)
						{
							cancel_allow_yn = "Y";
						}
						
						if(((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))||(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))))
						{	
							if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
							{
								if((print_report_yn.equalsIgnoreCase("Y")&&(print_billing_report_yn.equalsIgnoreCase("Y"))))
								{
									print_report_values.put("p_facility_id"+print_report_count,p_facility_id);
									if(order_set_bill_yn.equalsIgnoreCase("Y"))
									{
										print_report_values.put("p_order_id"+print_report_count,order_set_id);
										print_report_values.put("p_order_line_num"+print_report_count,"1");
									}
									else
									{
										print_report_values.put("p_order_id"+print_report_count,p_order_id);
										print_report_values.put("p_order_line_num"+print_report_count,total_line_num);
									}
									print_report_values.put("print_report_yn"+print_report_count,print_report_yn);

									print_report_count++;
									print_report_values.put("total_recs",String.valueOf(print_report_count)); 			
								}	
							}
						}
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 15/02/2013
				//Start 
				if(result>0)
					{
					if(p_order_id.substring(0,2).equals("OT"))
						{
						String ip_result=UpdateIPBookingOrder(connection,p_order_id,total_line_num,p_user,p_ws_no,p_facility_id);
						if(!ip_result.equals(""))
							{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message",ip_result) ;
							return map;
							}
						}
					}			
					//End	
						// Added for IN072311
						if(result >=1)
						{
							//if(((!(order_set_status_query.equals("")))&&(order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(order_set_status_type.equalsIgnoreCase("CN")))||(order_set_bill_yn.equalsIgnoreCase("N")))
							if((order_set_bill_yn.equalsIgnoreCase("N"))&&(bill_yn.equalsIgnoreCase("Y")))
							{
								if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
								{
									//Billing Procedure - Start
									//cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") +" }");
									//cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?)}");//IN071315//IN68314//IN072752
									cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?,?,?)}");//IN071315//IN68314//IN072752
									cstmt.setString(1, p_facility_id);
									cstmt.setString(2, p_order_id);// P_ORDER_ID
									cstmt.setString(3, p_order_line_num);//P_ORDER_LINE_NUM				
									cstmt.setString(4, p_mode); 						// P_MODE
									cstmt.setString(5, p_user);							// P_USER
									cstmt.setString(6, p_ws_no);						// P_WS_NO
									cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
									cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;// P_ERROR_MESSAGE
									cstmt.setString(9, "N");						// FUTURE
									cstmt.setString(10, "Y");						// INCLUDE_CANCEL
									//IN071315 Starts
									if("Y".equals(p_called_from_ca))
										cstmt.setString(11, "CA");
									else
										cstmt.setString(11, "OR");
									//IN071315 Ends
									cstmt.setString(12, fpp_yn);//IN072752
									cstmt.setString(13, fpp_category);//IN072752
									cstmt.execute();
									p_error_message	= cstmt.getString(8);  // message

									if(p_error_message!=null && !p_error_message.equals(""))
										result = 0;
									else 
										result = 1;

									closeStatement(cstmt);
								}
							}

							if ( result < 1 ) 
							{
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								map.put( "message",p_error_message ) ;
								return map;
							}
							//Billing Procedure - End
				   		}
						// IN072311 Ends
						
					}
					if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
					{
						if(print_report_count>0)
						{
							map.put("print_report_values",print_report_values); // For On Line Printing(Billing Details)
						}
					}
					closeStatement(pstmt71) ;
					closeResultSet(resultSet71) ;

					if(((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))||((bill_yn.equalsIgnoreCase("Y"))&&((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))))||(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))))||(bill_yn.equalsIgnoreCase("N")&&(!p_order_id.equals("")))||(order_set_bill_yn.equalsIgnoreCase("N")&&(!order_set_id.equals(""))))
					{	
						//if(result!=0 && updt_vals2[3]!=null && !updt_vals2[3].equals("") && (updt_vals1[6].equals("RD") && !updt_vals1[8].equals("Y") ||  updt_vals1[6].equals("OT") && !updt_vals1[7].equals("Y")))//17091
						if(result!=0 && updt_vals2[3]!=null && !updt_vals2[3].equals("") && (!updt_vals1[6].equals("RD") &&  !updt_vals1[6].equals("OT") )) //17091
						{
							//Billing Procedure - Start
							closeStatement( cstmt ) ; 
							cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_OA_CANCEL_APPOINTMENT") +" }");
							cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
							cstmt.setString(2, updt_vals2[3]);					// APPTREFNO
							cstmt.setString(3, null);							// PATIENTID
							cstmt.setString(4, null); 							// REASON
							cstmt.setString(5, null);							// ALCN_CRITERIA
							cstmt.setString(6, null);							// PAT_CAT
							cstmt.setString(7, p_facility_id);					// ADDEDFACILITYID
							cstmt.setString(8, p_ws_no);						// ADDEDATWORKSTATION
							cstmt.setString(9, null);							// FORCED
							cstmt.setString(10, p_user);							// USERID
							cstmt.registerOutParameter( 11,  Types.VARCHAR ) ; 	// RESULT
							cstmt.execute();
							p_error_message	= cstmt.getString(11);  // message
							
							if(p_error_message!=null && !p_error_message.equals(""))
								result = 0;
							else 
								result = 1;  

							closeStatement(cstmt);

							if ( result < 1 ) 
							{
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								map.put( "message",p_error_message ) ;
								return map;
							} 
						}
						// OA Apppt Procedure Ends

						pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1") ) ;
						pstmt4.setString( 1, "99") ;
						pstmt4.setString( 2, updt_vals1[1].trim() ) ;
						pstmt4.setString( 3, p_user ) ;
						pstmt4.setString( 4, p_ws_no ) ;
						pstmt4.setString( 5, p_facility_id ) ;
						pstmt4.setString( 6, updt_vals1[0].trim() ) ;
						result = pstmt4.executeUpdate();
						closeStatement( pstmt4 ) ;

						if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR"))  && (!p_order_id.substring(0,2).equals("PH")))
						{
							pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN") ) ;
							pstmt4.setString( 1, "99") ;
							pstmt4.setString( 2, updt_vals1[1].trim() ) ;
							pstmt4.setString( 3, p_user ) ;
							pstmt4.setString( 4, p_ws_no ) ;
							pstmt4.setString( 5, p_facility_id ) ;
							pstmt4.setString( 6, updt_vals1[0].trim() ) ;
							pstmt4.executeUpdate();
							closeStatement( pstmt4 ) ;
						}
						if(result >=1)
						{
							pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2") ) ;
							pstmt5.setString( 1, "99"  ) ;
							pstmt5.setString( 2, updt_vals2[0].trim()  ) ;
							pstmt5.setString( 3, updt_vals2[1].trim()  ) ;
							pstmt5.setString( 4, currentDate  ) ;
							pstmt5.setString( 5, currentDate  ) ;
							pstmt5.setString( 6, null ) ;
							pstmt5.setString( 7, null ) ;
							pstmt5.setString( 8, null) ;
							pstmt5.setString( 9, null) ;
							pstmt5.setString( 10, null) ;
							pstmt5.setString( 11, null) ;
							pstmt5.setString( 12, null) ;
							pstmt5.setString( 13, p_user ) ;
							pstmt5.setString( 14, p_ws_no ) ;
							pstmt5.setString( 15, p_facility_id ) ;
							pstmt5.setString( 16, updt_vals2[2].trim()) ; // where clause

							result = pstmt5.executeUpdate();
							closeStatement( pstmt5 ) ;

							//For Updating the Appt_ref_num and Appt_date_time with null
							if (!p_order_id.substring(0,2).equals("PH")) 
							{
								pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE") ) ;
								pstmt6.setString( 1, p_user ) ;
								pstmt6.setString( 2, p_ws_no ) ;
								pstmt6.setString( 3, p_facility_id ) ;
								pstmt6.setString( 4, p_order_id) ;
								pstmt6.setString( 5, null) ;
								pstmt6.executeUpdate();
								closeStatement( pstmt6 ) ;
							}

							if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR"))  && (!p_order_id.substring(0,2).equals("PH")))
							{
								closeStatement( pstmt5 ) ;
								pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN") ) ;
								pstmt5.setString( 1, "99"  ) ;
								pstmt5.setString( 2, updt_vals2[0].trim()  ) ;
								pstmt5.setString( 3, updt_vals2[1].trim()  ) ;
								pstmt5.setString( 4, currentDate  ) ;
								pstmt5.setString( 5, currentDate  ) ;
								pstmt5.setString( 6, null ) ;
								pstmt5.setString( 7, null ) ;
								pstmt5.setString( 8, null) ;
								pstmt5.setString( 9, null) ;
								pstmt5.setString( 10, null) ;
								pstmt5.setString( 11, null) ;
								pstmt5.setString( 12, null) ;
								pstmt5.setString( 13, p_user ) ;
								pstmt5.setString( 14, p_ws_no ) ;
								pstmt5.setString( 15, p_facility_id ) ;
								pstmt5.setString( 16, updt_vals2[2].trim()) ; // where clause

								pstmt5.executeUpdate();
								closeStatement(pstmt5);

								//For Updating the Appt_ref_num and Appt_date_time with null
								closeStatement( pstmt6 ) ;
								pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE_FREQ_EXPLN") ) ;

								pstmt6.setString( 1, p_user ) ;
								pstmt6.setString( 2, p_ws_no ) ;
								pstmt6.setString( 3, p_facility_id ) ;
								pstmt6.setString( 4, p_order_id) ;
								pstmt6.setString( 5, null) ;
								pstmt6.executeUpdate();
								closeStatement(pstmt6);
							}
						}
						// Commented for IN072311
						/*if(result >=1)
						{
							//if(((!(order_set_status_query.equals("")))&&(order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(order_set_status_type.equalsIgnoreCase("CN")))||(order_set_bill_yn.equalsIgnoreCase("N")))
							if((order_set_bill_yn.equalsIgnoreCase("N"))&&(bill_yn.equalsIgnoreCase("Y")))
							{
								if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
								{
									//Billing Procedure - Start
									//cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") +" }");
									cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?)}");//IN071315
									cstmt.setString(1, p_facility_id);
									cstmt.setString(2, p_order_id);// P_ORDER_ID
									cstmt.setString(3, p_order_line_num);//P_ORDER_LINE_NUM				
									cstmt.setString(4, p_mode); 						// P_MODE
									cstmt.setString(5, p_user);							// P_USER
									cstmt.setString(6, p_ws_no);						// P_WS_NO
									cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
									cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;// P_ERROR_MESSAGE
									cstmt.setString(9, "N");						// FUTURE
									cstmt.setString(10, "Y");						// INCLUDE_CANCEL
									//IN071315 Starts
									if("Y".equals(p_called_from_ca))
										cstmt.setString(11, "CA");
									else
										cstmt.setString(11, "OR");
									//IN071315 Ends
									cstmt.execute();
									p_error_message	= cstmt.getString(8);  // message

									if(p_error_message!=null && !p_error_message.equals(""))
										result = 0;
									else 
										result = 1;

									closeStatement(cstmt);
								}
							}

							if ( result < 1 ) 
							{
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								map.put( "message",p_error_message ) ;
								return map;
							}
							//Billing Procedure - End
				   		}*/
						// IN072311 Ends
						if(p_error_code==null) 
							p_error_code="";

						if(!p_error_code.equals(""))	
						{
							insert_valid =0;
							result = 0;
							map.put( "result", new Boolean( false ) ) ;
							map.put("message", p_error_code) ;
							connection.rollback();
							return map;
						}
						else
						{
							insert_valid =1;
							result =1;
						}
					}
					else
					{

						if(p_error_code==null) p_error_code="";
						if(!p_error_code.equals(""))	
						{
							insert_valid =0;
							result =0;
							map.put("message", p_error_code) ;
							map.put("result",new Boolean(false));
							connection.rollback();
							return map;
						}
						else
						{
							insert_valid =1;
							result =1;
						}
					}
					
					if(result>0)
					{			   	 
						if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(cancel_allow_yn.equalsIgnoreCase("Y")))
						{
						    pstmt_set_status = connection.prepareStatement("select order_status from or_order where order_id=?");
							pstmt_set_status.setString(1,order_set_id);
							resultset_status = pstmt_set_status.executeQuery();
							while(resultset_status.next())
							{
								order_set_status_type= resultset_status.getString("order_status");
							}
							closeStatement(pstmt_set_status);
							closeResultSet(resultset_status);						 

							if(order_set_status_type==null) 
								order_set_status_type="";

							if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(cancel_allow_yn.equalsIgnoreCase("Y"))&&((order_set_status_type.equalsIgnoreCase("CN"))))
							{
								cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?,?,?)}");//IN071315//IN072752
								cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
								cstmt.setString(2, order_set_id);						// P_ORDER_ID
								cstmt.setString(3, "1");				// P_ORDER_LINE_NUM
								cstmt.setString(4, p_mode); 						// P_MODE
								cstmt.setString(5, p_user);							// P_USER
								cstmt.setString(6, p_ws_no);						// P_WS_NO
								cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
								cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
								cstmt.setString(9, "N");						// FUTURE
								cstmt.setString(10, "Y");						// INCLUDE_CANCEL
								//IN071315 Starts
								if("Y".equals(p_called_from_ca))
									cstmt.setString(11, "CA");
								else
									cstmt.setString(11, "OR");
								//IN071315 Ends
								//IN068314 Starts
								cstmt.setString(12, fpp_yn);//IN072752
								cstmt.setString(13, fpp_category);//IN072752
								//IN068314 Ends
								cstmt.execute();
								p_error_message	= cstmt.getString(8);  // message

								try 
								{
									closeStatement( cstmt ) ;
								}
								catch ( Exception fe ) 
								{
									fe.printStackTrace() ;
								}
								
								if(p_error_message!=null && !p_error_message.equals(""))
									result = 0;
								else 
									result = 1;
								
								if ( result < 1 ) 
								{
									map.put( "result", new Boolean( false ) ) ;
									connection.rollback();
									map.put( "message",p_error_message ) ;
									return map;
								}
								else
								{
									map.put( "result", new Boolean( true ) ) ;
									map.put("message", "RECORD_MODIFIED") ;
									connection.commit();
									return map;
								}
							}
						}
					}
				}
				else if ((cancel_type.trim()).equals("L"))
				{  
					updt_vals1			= (String[])tabData.get("head_data"+i);
					updt_vals2			= (String[])tabData.get("line_data");
					updt_values1		= updt_vals1;
					updt_values2		= updt_vals2;
					p_order_id			= updt_vals1[2].trim();
					p_order_line_num	= updt_vals1[3].trim();
					p_facility_id		= updt_vals1[6].trim();
					p_user				= updt_vals1[4].trim();
					p_ws_no				= updt_vals1[5].trim();
					ord_typ_code		= updt_vals1[7].trim();
					order_set_id		= updt_vals1[11].trim();
					order_set_bill_yn	= updt_vals1[12].trim();
					fpp_yn = updt_vals2[4];//IN072752
					fpp_category= updt_vals2[5];//IN072752
					tracer.append("\nCancelManager.java,3063,p_order_id=>"+p_order_id+" p_order_line_num=>"+p_order_line_num+" p_facility_id=>"+p_facility_id+" p_user=>"+p_user+" p_ws_no=>"+p_ws_no+" ord_typ_code=>"+ord_typ_code+" order_set_id=>"+order_set_id+" order_set_bill_yn=>"+order_set_bill_yn);

					String order_set_status_type_code="";
					String order_set_status_query = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE");
					String order_set_status_query_code = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE");
					pstmt7 = connection.prepareStatement("select nvl(PRINT_BILLING_REPORT_YN,'N') print_billing_report_yn from or_param_by_facility where operating_facility_id=?");
					pstmt7.setString(1, p_facility_id);
					resultSet = pstmt7.executeQuery();
					
					if (resultSet.next()) 
					{
						print_billing_report_yn	= resultSet.getString("print_billing_report_yn");
						tracer.append("\nCancelManager.java,3078,print_billing_report_yn=>"+print_billing_report_yn);
					}

					closeStatement(pstmt7) ;
					closeResultSet(resultSet) ;

					String bill_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
					pstmt7 = connection.prepareStatement(bill_sql) ;

					if(order_set_bill_yn.equalsIgnoreCase("Y"))
					{
						pstmt7.setString(1, order_set_id);
						pstmt7.setString(2, "1");
					}
					else
					{
						pstmt7.setString(1, p_order_id);
						pstmt7.setString(2, p_order_line_num);
					}

					resultSet = pstmt7.executeQuery();
					
					if (resultSet.next()) 
					{
						bill_yn	= resultSet.getString("bill_yn");
						cont_order_ind	= resultSet.getString("cont_order_ind");
						tracer.append("\nCancelManager.java,2846,bill_sql=>"+bill_sql);
						tracer.append("\nCancelManager.java,3105,bill_yn=>"+bill_yn+" cont_order_ind=>"+cont_order_ind+",bill_on_regn_yn=>"+bill_on_regn_yn);
					}

					closeStatement(pstmt7) ;

					if((bill_yn.equalsIgnoreCase("Y"))||(order_set_bill_yn.equalsIgnoreCase("Y")))
					{
						String p_subs_module_id		 = "";
						String p_subs_regn_num		 = "";
						String p_subs_regn_line_num = "";
						String p_err_code					 = "";
						String p_sys_message_id		 = "";
						String p_err_text					 = "";
						CallableStatement cstmt_sub_module_dtls = null;
						CallableStatement cstmt_cancel_allow_yn 	= null;
						CallableStatement cstmt_freq_order 	= null;

						try
						{
							if((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))
							{
								cstmt_freq_order = connection.prepareCall("{call OR_FREQ_ORD_CAN_DIS(?,?,?,?,?,?,?,?,?,?) }");

								cstmt_freq_order.setString(1, p_order_id);								
								cstmt_freq_order.setString(2, p_order_line_num);						
								cstmt_freq_order.setString(3, p_facility_id);							
								cstmt_freq_order.setString(4, p_mode);								
								cstmt_freq_order.setString(5, p_user);								
								cstmt_freq_order.setString(6, p_ws_no);								
								cstmt_freq_order.registerOutParameter( 7,  Types.VARCHAR ) ;
								cstmt_freq_order.registerOutParameter( 8,  Types.VARCHAR ) ;
								cstmt_freq_order.registerOutParameter( 9,  Types.VARCHAR ) ;
								cstmt_freq_order.registerOutParameter( 10,  Types.VARCHAR ) ;
								cstmt_freq_order.execute();

								print_report_yn	= cstmt_freq_order.getString(7)==null?"N":cstmt_freq_order.getString(7);	
								p_error_code	= cstmt_freq_order.getString(8)==null?"": cstmt_freq_order.getString(8);
								p_sys_message_id	= cstmt_freq_order.getString(9)==null?"":cstmt_freq_order.getString(9);	
								p_err_text	= cstmt_freq_order.getString(10)==null?"":cstmt_freq_order.getString(10);	tracer.append("3198,print_report_yn"+print_report_yn+" p_err_text=>"+p_err_text+" p_error_code=>"+p_error_code+" p_sys_message_id=>"+p_sys_message_id);
								closeStatement( cstmt_freq_order ) ;
								
								if(p_error_code==null) 
									p_error_code="";

								if(p_error_code.equals(""))	
								{	
									if((print_report_yn.equalsIgnoreCase("Y"))&&(print_billing_report_yn.equalsIgnoreCase("Y")))
									{
										print_report_values.put("p_facility_id"+print_report_count,p_facility_id);
										print_report_values.put("p_order_id"+print_report_count,p_order_id);
										print_report_values.put("p_order_line_num"+print_report_count,p_order_line_num);
										print_report_values.put("print_report_yn"+print_report_count,print_report_yn);
										print_report_count++;
										print_report_values.put("total_recs",String.valueOf(print_report_count)); 		
									}		
									if(print_report_count>0)
									{
										map.put("print_report_values",print_report_values); 
									}
								}

								if(p_error_code==null) 
									p_error_code="";
								
								if(p_err_text==null) 
									p_err_text="";
								
								if(p_err_text!=null && !p_err_text.equals(""))
									result = 0;
								else 
									result = 1;

								if ( result < 1 ) 
								{
									map.put( "result", new Boolean( false ) ) ;
									connection.rollback();
									map.put( "message",p_err_text ) ;
									return map;
								}
								else if(!p_error_code.equals(""))	
								{
									result =0;
									map.put( "result", new Boolean( false ) ) ;
									map.put("message", p_error_code) ;
									connection.rollback();
									return map;
								}
								else
								{									  
									map.put("message", "RECORD_MODIFIED") ;
									map.put( "result", new Boolean( true ) ) ;
									connection.commit();
								}
							}
							else
							{
								cstmt_sub_module_dtls			= connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_SEC_KEY_FOR_PRIM_KEY(?,?,?,?,?,?,?,?,?) }");
								cstmt_sub_module_dtls.setString(1, p_facility_id);									    
								if(order_set_bill_yn.equalsIgnoreCase("Y"))
								{
									cstmt_sub_module_dtls.setString(2, order_set_id);					cstmt_sub_module_dtls.setString(3, "1");				
									cstmt_sub_module_dtls.setString(3, "1");						    // P_ORDER_LINE_NUM
								}
								else
								{
									cstmt_sub_module_dtls.setString(2, p_order_id);						
									cstmt_sub_module_dtls.setString(3, p_order_line_num);				
								}
								cstmt_sub_module_dtls.registerOutParameter( 4,  Types.VARCHAR ) ;
								cstmt_sub_module_dtls.registerOutParameter( 5,  Types.VARCHAR ) ;
								cstmt_sub_module_dtls.registerOutParameter( 6,  Types.VARCHAR ) ;
								cstmt_sub_module_dtls.registerOutParameter( 7,  Types.VARCHAR ) ;
								cstmt_sub_module_dtls.registerOutParameter( 8,  Types.VARCHAR ) ;
								cstmt_sub_module_dtls.registerOutParameter( 9,  Types.VARCHAR ) ;
								cstmt_sub_module_dtls.execute();
								p_subs_module_id	= cstmt_sub_module_dtls.getString(4);		
								p_subs_regn_num	= cstmt_sub_module_dtls.getString(5);			
								p_subs_regn_line_num	= cstmt_sub_module_dtls.getString(6);	
								p_err_code	= cstmt_sub_module_dtls.getString(7);				
								p_sys_message_id	= cstmt_sub_module_dtls.getString(8);		
								p_error_text	= cstmt_sub_module_dtls.getString(9);			

								tracer.append("\nCancelManager.java,3284,p_subs_module_id=>"+p_subs_module_id+" p_subs_regn_num=>"+p_subs_regn_num+" p_subs_regn_line_num=>"+p_subs_regn_line_num+" p_err_code=>"+p_err_code+" p_sys_message_id=>"+p_sys_message_id+" p_error_text=>"+p_error_text);
								
								if((p_err_code!=null && p_err_code!="null" && !p_err_code.equals(""))&&(p_sys_message_id!=null && p_sys_message_id!="null" && !p_sys_message_id.equals("")))
								{
								}
								else
								{
									cstmt_cancel_allow_yn = connection.prepareCall("{ ? = call  BL_PROC_ITEM_VALIDATIONS_MP.IS_CANCEL_ORDER_ALLOWED_YN(?,?,?,?,?,?,?,?,?,?,?)}");
									cstmt_cancel_allow_yn.registerOutParameter(1,java.sql.Types.VARCHAR);
								   	cstmt_cancel_allow_yn.setString(2,p_facility_id);
									//IN071315 Starts
									//cstmt_cancel_allow_yn.setString(3,"OR");
									if("Y".equals(p_called_from_ca)){
										cstmt_cancel_allow_yn.setString(3,"OR|CA");
										System.out.println("ORCancelDiscontinueOrderManager.java:if:3071p_called_from_ca"+p_called_from_ca);
										}
									else{
										System.out.println("ORCancelDiscontinueOrderManager.java:else3075p_called_from_ca"+p_called_from_ca);
										cstmt_cancel_allow_yn.setString(3,"OR|OR");
									}
									//IN071315 Ends
									if(order_set_bill_yn.equalsIgnoreCase("Y"))
									{
										cstmt_cancel_allow_yn.setString( 4 , order_set_id);				
										cstmt_cancel_allow_yn.setString( 5 , "1");						
									}
									else
									{
										cstmt_cancel_allow_yn.setString(4,p_order_id);
										cstmt_cancel_allow_yn.setString(5,p_order_line_num);
									}
									cstmt_cancel_allow_yn.setString(6,p_subs_module_id);
									cstmt_cancel_allow_yn.setString(7,p_subs_regn_num);
									cstmt_cancel_allow_yn.setString(8,p_subs_regn_line_num);
									cstmt_cancel_allow_yn.registerOutParameter(9,java.sql.Types.VARCHAR);
									cstmt_cancel_allow_yn.registerOutParameter(10,java.sql.Types.VARCHAR);
									cstmt_cancel_allow_yn.registerOutParameter(11,java.sql.Types.VARCHAR);
									cstmt_cancel_allow_yn.registerOutParameter(12,java.sql.Types.VARCHAR);

									cstmt_cancel_allow_yn.execute();							
									cancel_allow_yn = cstmt_cancel_allow_yn.getString(1);	
									print_report_yn = cstmt_cancel_allow_yn.getString(9);	
									p_error_code = cstmt_cancel_allow_yn.getString(10);	
									p_error_level = cstmt_cancel_allow_yn.getString(11);	
									p_err_text = cstmt_cancel_allow_yn.getString(12);	
									tracer.append("\nCancelManager.java,3272,cancel_allow_yn=>"+cancel_allow_yn+" print_report_yn=>"+print_report_yn+" p_error_code=>"+p_error_code+" p_error_level=>"+p_error_level+" p_err_text=>"+p_err_text);
								}			
								print_report_yn = (print_report_yn==null)?"N":print_report_yn;
								p_error_code = (p_error_code==null)?"":p_error_code;
								p_error_level = (p_error_level==null)?"":p_error_level;
								p_error_text = (p_err_text==null)?"":p_err_text;
								cancel_allow_yn = (cancel_allow_yn==null)?"":cancel_allow_yn;
							}
						}
						catch(Exception ce)
						{
							ce.printStackTrace();
						}
					}

					//if(((bill_yn.equalsIgnoreCase("Y"))&&(p_error_text!=null&&p_error_text.length()<0))||(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(p_error_text!=null&&p_error_text.length()<0)))||(bill_yn.equalsIgnoreCase("N"))||(order_set_bill_yn.equalsIgnoreCase("N")))
					if(((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))||(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y")))))
					{
					    if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
						{
							tracer.append("\nCancelManager.java,3292,print_report_yn=>"+print_report_yn+" print_billing_report_yn=>"+print_billing_report_yn);
							if((print_report_yn.equalsIgnoreCase("Y"))&&(print_billing_report_yn.equalsIgnoreCase("Y")))
							{
								print_report_values.put("p_facility_id"+print_report_count,p_facility_id);
								tracer.append("3344");
								if(order_set_bill_yn.equalsIgnoreCase("Y"))
								{
									print_report_values.put("p_order_id"+print_report_count,order_set_id);
									print_report_values.put("p_order_line_num"+print_report_count,"1");
								}
								else
								{
									print_report_values.put("p_order_id"+print_report_count,p_order_id);
									print_report_values.put("p_order_line_num"+print_report_count,p_order_line_num);
								}

								print_report_values.put("print_report_yn"+print_report_count,print_report_yn);	 
								print_report_count++;
								print_report_values.put("total_recs",String.valueOf(print_report_count)); 			
							}	
						}
					}

					if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
					{
						if(print_report_count>0)
						{
							map.put("print_report_values",print_report_values);
							tracer.append("\nCancelManager.java,3320,print_report_values=>"+print_report_values);
						}
					}

					if(((bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))||((bill_yn.equalsIgnoreCase("Y"))&&((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR")))))||(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(cancel_allow_yn.equalsIgnoreCase("Y"))))||(bill_yn.equalsIgnoreCase("N")&&(!p_order_id.equals("")))||(order_set_bill_yn.equalsIgnoreCase("N")&&(!order_set_id.equals(""))))
					{

					//	if(result!=0 && updt_vals2[2]!=null && !updt_vals2[2].equals("") && (updt_vals1[8].equals("RD") && !updt_vals1[10].equals("Y") ||  updt_vals1[8].equals("OT") && !updt_vals1[9].equals("Y")))
						if(result!=0 && updt_vals2[2]!=null && !updt_vals2[2].equals("") && (!updt_vals1[8].equals("RD") &&  !updt_vals1[8].equals("OT") )) //17091
						{
							tracer.append("\nCancelManager.java,3330");
							//Billing Procedure - Start
							closeStatement( cstmt ) ;
							cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_OA_CANCEL_APPOINTMENT") +" }");
							cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
							cstmt.setString(2, updt_vals2[2]);					// APPTREFNO
							cstmt.setString(3, null);							// PATIENTID
							cstmt.setString(4, null); 							// REASON
							cstmt.setString(5, null);							// ALCN_CRITERIA
							cstmt.setString(6, null);							// PAT_CAT
							cstmt.setString(7, p_facility_id);					// ADDEDFACILITYID
							cstmt.setString(8, p_ws_no);						// ADDEDATWORKSTATION
							cstmt.setString(9, null);							// FORCED
							cstmt.setString(10, p_user);							// USERID
							cstmt.registerOutParameter( 11,  Types.VARCHAR ) ; 	// RESULT
							cstmt.execute();
							p_error_message	= cstmt.getString(11);  // message
							
							if(p_error_message!=null && !p_error_message.equals(""))
								result = 0;
							else 
								result = 1;

							closeStatement(cstmt);

							if ( result < 1 ) 
							{
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								map.put( "message",p_error_message ) ;
								return map;
							}  
						}
						// OA Apppt Procedure Ends


						tracer.append("\nCancelManager.java,3367");
						pstmt3 = connection.prepareStatement((String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE1"));

						pstmt3.setString( 1, "99") ; // cancel code
						pstmt3.setString( 2, updt_vals1[0].trim()) ;
						pstmt3.setString( 3, updt_vals1[1].trim()) ;
						pstmt3.setString( 4, currentDate) ;
						pstmt3.setString( 5, currentDate) ;
						pstmt3.setString( 6, null) ;
						pstmt3.setString( 7, null) ;
						pstmt3.setString( 8, null) ;
						pstmt3.setString( 9, null) ;
						pstmt3.setString( 10, null) ;
						pstmt3.setString( 11, null) ;
						pstmt3.setString( 12, null) ;
						pstmt3.setString( 13, p_user) ;
						pstmt3.setString( 14, p_ws_no) ;
						pstmt3.setString( 15, p_facility_id ) ;
						pstmt3.setString( 16, updt_vals1[2].trim()) ;
						pstmt3.setString( 17, updt_vals1[3].trim()) ;
					   	tracer.append("\nCancelManager.java,3386,1=>99,2=>"+updt_vals1[0].trim()+",3=>"+updt_vals1[1].trim()+",4,5=>"+currentDate+"6,7,8,9,10,11,12=>null,13=>"+p_user+" ,14=>"+p_ws_no+" 15=>"+p_facility_id+" 16=>"+updt_vals1[2].trim()+"17=>"+updt_vals1[3].trim());
						result = pstmt3.executeUpdate();
						tracer.append("\nCancelManager.java,3387,result=>"+result);
						closeStatement( pstmt3 ) ;

						//For Updating the Appt_ref_num and Appt_date_time with null
						if (!p_order_id.substring(0,2).equals("PH")) 
						{
							closeStatement( pstmt6 ) ;
							pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE") ) ;
							pstmt6.setString( 1, p_user ) ;
							pstmt6.setString( 2, p_ws_no ) ;
							pstmt6.setString( 3, p_facility_id ) ;
							pstmt6.setString( 4, p_order_id) ;
							pstmt6.setString( 5, p_order_line_num) ;
							pstmt6.executeUpdate();
							tracer.append("\nCancelManager.java,3401,Qry=>"+sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE")+" p_user=>"+p_user+" p_ws_no=>"+p_ws_no+" p_facility_id=>"+p_facility_id+" p_order_id=>"+p_order_id+" p_order_line_num=>"+p_order_line_num);
							closeStatement( pstmt6 ) ;
						}
						
						if(result >=1)
						{
							tracer.append("\nCancelManager.java,3407,order_set_status_query=>"+order_set_status_query+" order_set_bill_yn=>"+order_set_bill_yn+" order_set_id=>"+order_set_id+" order_set_status_query_code=>"+order_set_status_query_code);
							if((!(order_set_status_query.equals("")))&&(order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
							{
								pstmt=connection.prepareStatement(order_set_status_query);
								pstmt.setString(1,order_set_id.trim());
								resultSet=pstmt.executeQuery();
								while(resultSet.next())
								{
									order_set_status_type=resultSet.getString("order_set_status");
								}
								tracer.append("\nCancelManager.java,3417,order_set_status_type=>"+order_set_status_type);

								closeStatement(pstmt);
								closeResultSet(resultSet);

								if(order_set_status_type==null) 
									order_set_status_type="";

								pstmt=connection.prepareStatement(order_set_status_query_code);
								pstmt.setString(1,order_set_status_type);
								resultSet=pstmt.executeQuery();
								while(resultSet.next())
								{
									order_set_status_type_code=resultSet.getString("order_status_type");
								}
								tracer.append("\nCancelManager.java,3432,order_set_status_type_code=>"+order_set_status_type_code);
								closeStatement(pstmt);
								closeResultSet(resultSet);

								if(order_set_status_type_code==null) 
									order_set_status_type_code="";
						  	}

							//Billing Procedure - Start
							closeStatement( cstmt ) ;

							if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
							{
								pstmt_set_status = connection.prepareStatement("select order_status from or_order where order_id=?");
								pstmt_set_status.setString(1,order_set_id);
								resultset_status = pstmt_set_status.executeQuery();
								while(resultset_status.next())
								{
									order_set_status_type= resultset_status.getString("order_status");
								}
								closeStatement(pstmt_set_status);
								closeResultSet(resultset_status);						 
								tracer.append("\nCancelManager.java,3470,order_set_status_type=>"+order_set_status_type);
								if(order_set_status_type==null) 
									order_set_status_type="";
							} //if(((!(order_set_status_query.equals("")))&&(order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(order_set_status_type.equalsIgnoreCase("CN")))||(order_set_bill_yn.equalsIgnoreCase("N")))
							if((order_set_bill_yn.equalsIgnoreCase("N"))&&(bill_yn.equalsIgnoreCase("Y")))
							{
								if(!((cont_order_ind.equalsIgnoreCase("CR"))||(cont_order_ind.equalsIgnoreCase("DR"))))
								{

									//cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") +" }");
									//cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?)}");//IN071315//INO68314//IN072752
									cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?,?,?)}");//IN071315//INO68314//IN072752
									tracer.append("\nCancelManager.java,3480");
									cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
									cstmt.setString(2, p_order_id);						// P_ORDER_ID
									cstmt.setString(3, p_order_line_num);// P_ORDER_LINE_NUM
									cstmt.setString(4, p_mode); 						// P_MODE
									cstmt.setString(5, p_user);							// P_USER
									cstmt.setString(6, p_ws_no);						// P_WS_NO
									cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
									cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;// P_ERROR_MESSAGE
									cstmt.setString(9, "N");						// FUTURE
									cstmt.setString(10, "Y");						// INCLUDE_CANCEL
									//IN071315 Starts
									if("Y".equals(p_called_from_ca))
										cstmt.setString(11, "CA");
									else
										cstmt.setString(11, "OR");
									//IN071315 Ends
									//IN068314 Starts
									cstmt.setString(12,fpp_yn );//IN072752
									cstmt.setString(13, fpp_category);//IN072752
									//IN068314 Ends
									cstmt.execute();
									p_error_message	= cstmt.getString(8);  // message
									
									tracer.append("\nCancelManager.java,p_facility_id=>"+p_facility_id+",p_order_id=>"+p_order_id+",p_order_line_num=>"+p_order_line_num+",p_mode=>"+p_mode+",p_mode=>"+p_mode+",p_user=>"+p_user+",p_ws_no=>"+p_ws_no+",9=>N"+",10=>Y");


									if(p_error_message!=null && !p_error_message.equals(""))
										result = 0;
									else 
										result = 1;

									closeStatement(cstmt);
									tracer.append("\nCancelManager.java,3520,result=>"+result);
									if ( result < 1 ) 
									{
										map.put( "result", new Boolean( false ) ) ;
										connection.rollback();
										map.put( "message",p_error_message ) ;
										return map;
									}
									//Billing Procedure - End
								}
							}
						}
						
						if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR"))   && (!p_order_id.substring(0,2).equals("PH")))
						{
							tracer.append("\nCancelManager.java,3536");
							closeStatement( pstmt3 ) ;
							pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE1_FREQ_EXPLN") ) ;
						  	pstmt3.setString( 1, "99") ; // cancel code
							pstmt3.setString( 2, updt_vals1[0].trim()  ) ;
							pstmt3.setString( 3, updt_vals1[1].trim()  ) ;
							pstmt3.setString( 4, currentDate ) ;
							pstmt3.setString( 5, currentDate  ) ;
							pstmt3.setString( 6, null ) ;
							pstmt3.setString( 7, null ) ;
							pstmt3.setString( 8, null) ;
							pstmt3.setString( 9, null) ;
							pstmt3.setString( 10, null) ;
							pstmt3.setString( 11, null) ;
							pstmt3.setString( 12, null) ;
							pstmt3.setString( 13, p_user ) ;
							pstmt3.setString( 14, p_ws_no ) ;
							pstmt3.setString( 15, p_facility_id ) ;
							pstmt3.setString( 16, updt_vals1[2].trim()  ) ;
							pstmt3.setString( 17, updt_vals1[3].trim()  ) ;
							pstmt3.executeUpdate();
							tracer.append("\nCancelManager.java,3556,sql=>"+(String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE1_FREQ_EXPLN")); 
							tracer.append("\nCancelManager.java,3558,99=>"+updt_vals1[0].trim()+"=>"+updt_vals1[1].trim()+"=>"+currentDate+"=>"+currentDate+"=>null=>null=>null=>null=>null=>null=>null=>"+p_user+"=>"+p_ws_no+"=>"+p_facility_id+"=>"+updt_vals1[2].trim()+"=>"+updt_vals1[3].trim());
							closeStatement( pstmt3 ) ;

							//For Updating the Appt_ref_num and Appt_date_time with null
							closeStatement( pstmt6 ) ;
							pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE_FREQ_EXPLN") ) ;
							tracer.append("\nCancelManager.java,3564,sql=>"+ (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE_FREQ_EXPLN") );
							pstmt6.setString( 1, p_user ) ;
							pstmt6.setString( 2, p_ws_no ) ;
							pstmt6.setString( 3, p_facility_id ) ;
							pstmt6.setString( 4, p_order_id) ;
							pstmt6.setString( 5, p_order_line_num) ;
							pstmt6.executeUpdate();
							closeStatement(pstmt6);
						}
						
						if(p_error_code==null) 
							p_error_code="";

						if(!p_error_code.equals(""))	
						{
							insert_valid =0;
							result =0;
							map.put( "result", new Boolean( false ) ) ;
							map.put("message", p_error_code) ;
							connection.rollback();
							return map;
						}
						else
						{		
							insert_valid =1;
							result =1;
						}
						tracer.append("\nCancelManager.java,3594,insert_valid=>"+insert_valid+",result=>"+result);
					}
					else
					{
						tracer.append("\nCancelManager.java,3599");
						if(p_error_code==null) p_error_code="";
						if(!p_error_code.equals(""))	
						{
							insert_valid = 0;
							result =0;
							map.put( "result", new Boolean( false ) ) ;
							map.put("message", p_error_code) ;
							connection.rollback();
							return map;
						}
						else
						{		
							insert_valid =1;
							result =1;							
						}
						tracer.append("\nCancelManager.java,3614,insert_valid=>"+insert_valid+",result=>"+result);
					}		
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 15/02/2013
				//Start			
				if(result>0)
					{
					if(p_order_id.substring(0,2).equals("OT"))
						{
						String ip_result=UpdateIPBookingOrder(connection,p_order_id,p_order_line_num,p_user,p_ws_no,p_facility_id);
						if(!ip_result.equals(""))	
							{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message",ip_result) ;
							return map;
							}
						}
					}	
				//End	
				}
				i++;
			}while(i<count);

			if((cancel_type.trim()).equals("L"))
			{  
				tracer.append("\n3717");
				updt_vals2 = (String[])tabData.get("line_data");
			   	String sql = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT");
			   	int t = sql.lastIndexOf("?");
				sql  = sql.substring(0,t) + tmpStr.trim() + sql.substring(t+1)  ;
			   	pstmt2 = connection.prepareStatement( sql ) ;
			   	pstmt2.setString( 1, (String)updt_vals2[1].trim()) ;
			   	resultSet = pstmt2.executeQuery();
				tracer.append("\nCancelManager.java,3692,sql=>"+sql+",updt_vals2[1]=>"+updt_vals2[1]);
				while(resultSet.next() )
				{
					hdr_code = resultSet.getString("order_line_status");
				}  
				tracer.append("\nCancelManager.java,3698,hdr_code=>"+hdr_code);
				if( !((hdr_code.trim()).equalsIgnoreCase(""))) 
				{
					result=0;
					tracer.append("\n3735");
					pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE2") ) ;
					pstmt1.setString( 1, hdr_code.trim() ) ;
					pstmt1.setString( 2, p_user.trim() ) ;
					pstmt1.setString( 3, p_ws_no.trim() ) ;
					pstmt1.setString( 4, p_facility_id.trim() ) ;
					pstmt1.setString( 5, updt_vals2[1].trim() ) ;
					tracer.append("\nCancelManager.java,sql=>"+sql+",hdr_code=>"+hdr_code+",p_user=>"+p_user+",p_ws_no=>"+p_ws_no+",p_facility_id=>"+p_facility_id+",updt_vals2[1]=>"+updt_vals2[1]);
					result = pstmt1.executeUpdate();

					closeStatement(pstmt1);
					
					if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR"))   && (!p_order_id.substring(0,2).equals("PH")))
					{
						tracer.append("\nCancelManager.java,3715");
						closeStatement( pstmt1 ) ;
						pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE2_FREQ_EXPLN") ) ;
						pstmt1.setString( 1, hdr_code.trim() ) ;
						pstmt1.setString( 2, p_user ) ;
						pstmt1.setString( 3, p_ws_no ) ;
						pstmt1.setString( 4, p_facility_id ) ;
						pstmt1.setString( 5, updt_vals2[1].trim() ) ;
						tracer.append("\nCancelManager.java,3724,sql=>"+(String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE2_FREQ_EXPLN"));
						pstmt1.executeUpdate();
						closeStatement(pstmt1);
					}  
				}
				else
				{  
					tracer.append("\nCancelManager.java,3730");
					result=0;
					closeStatement( pstmt1 ) ;
					pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE3") ) ;
					pstmt1.setString( 1, "99") ; // cancel code
					pstmt1.setString( 2, p_user ) ;
					pstmt1.setString( 3, p_ws_no ) ;
					pstmt1.setString( 4, p_facility_id ) ;
					pstmt1.setString( 5, updt_vals2[1].trim() ) ;
					result = pstmt1.executeUpdate();
					closeStatement(pstmt1);

					if((cont_order_ind.equals("DR") || cont_order_ind.equals("CR"))   && (!p_order_id.substring(0,2).equals("PH")))
					{
						tracer.append("\nCancelManager.java,3779");
						closeStatement( pstmt1 ) ;
						pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN") ) ;
						pstmt1.setString( 1, "99") ; // cancel code
						pstmt1.setString( 2, p_user ) ;
						pstmt1.setString( 3, p_ws_no ) ;
						pstmt1.setString( 4, p_facility_id ) ;
						pstmt1.setString( 5, updt_vals2[1].trim() ) ;  
						pstmt1.executeUpdate();
						closeStatement(pstmt1);
					}
				}
			}
		 	tracer.append("\nCancelManager.java,3758,result=>"+result);
			if ( result < 1 ) 
			{
				map.put( "result", new Boolean( false ) ) ;
				connection.rollback();
				map.put( "message", "Operation failure ..." ) ;
			}
			else  
			{
				i = 0;
				do 
				{
					if((cancel_type.trim()).equals("H"))
					{
						if (updt_values1[0].trim().substring(0,2).equals("PH")) 
						{
							closeStatement( cstmt ) ;
							cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_PH_PATIENTDRUGPROFILEUPDATE_PROC") +" }");

							cstmt.setString(1, updt_values1[0].trim()); 		// P_ORDERID
							cstmt.setString(2, "");								// P_ORDERLINENO
							cstmt.setString(3, "C");							// P_OPERATION
							cstmt.setString(4, ""); 							// P_REASONCODE
							cstmt.setString(5, updt_values1[1].trim());			// P_REMARKS
							cstmt.setString(6, updt_values2[1].trim());			// P_PRACTITIONERID
							cstmt.setString(7, updt_values1[2].trim()); 		// P_USERID
							cstmt.setString(8, updt_values1[4].trim());			// P_FACILITYID
							cstmt.setString(9, updt_values1[3].trim());			// P_WSNO
							cstmt.registerOutParameter( 10,  Types.VARCHAR ) ;	// P_ERRMSG
							cstmt.execute();
							message	= cstmt.getString(10);  // message

							if(message!=null && !message.equals("")) 
							{
								result = 0;
								break;
							}
							else 
								result = 1;
							
							try 
							{
								closeStatement(cstmt);
							}
							catch ( Exception fe ) 
							{
								fe.printStackTrace() ;
							}	
						}
					} 
					else if((cancel_type.trim()).equals("L"))
					{   
						tracer.append("\nCancelManager.java,3810");
						updt_vals1 = (String[])tabData.get("head_data"+i);
						closeStatement( cstmt ) ;
						cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_PH_PATIENTDRUGPROFILEUPDATE_PROC") +" }");
						if (updt_vals1[2].trim().substring(0,2).equals("PH")) 
						{
							cstmt.setString(1, updt_vals1[2].trim()); 		// P_ORDERID
							tracer.append("\nCancelManager.java,3817,order_id=>"+updt_vals1[2].trim()+"order_line_num=>"+updt_vals1[3].trim());
							cstmt.setString(2, updt_vals1[3].trim());			// P_ORDERLINENO
							cstmt.setString(3, "C");							// P_OPERATION
							cstmt.setString(4, "");				 				// P_REASONCODE
							cstmt.setString(5, updt_vals1[0].trim());			// P_REMARKS
							cstmt.setString(6, updt_vals1[1].trim());			// P_PRACTITIONERID
							cstmt.setString(7, updt_vals1[4].trim()); 			// P_USERID
							cstmt.setString(8, updt_vals1[6].trim());			// P_FACILITYID
							cstmt.setString(9, updt_vals1[5].trim());			// P_WSNO
							cstmt.registerOutParameter( 10,  Types.VARCHAR ) ;	// P_ERRMSG
							cstmt.execute();
							message	= cstmt.getString(10);  // message
							if(message!=null && !message.equals("")) 
							{
								result = 0;
								break;
							}
							else 
								result = 1;
						}
						try 
						{
							closeStatement(cstmt);
						}
						catch ( Exception fe ) 
						{
							fe.printStackTrace() ;
						}	
					}
					i++;
				}while(i<count);
				tracer.append("\nCancelManager.java,3848,result=>"+result);
				if (result < 1) 
				{
					map.put("result", new Boolean( false ) ) ;
					connection.rollback();
					
					if(message!=null && !message.equals(""))
						map.put("message",message ) ;
					else
						map.put("message", "Operation failure ..." ) ;
				} 
			}
			tracer.append("\nCancelManager.java,3860,result=>"+result);
			if(result >=1)
			{				
			   	if(p_order_id.substring(0,2).equals("LB"))
				{
					/*****************************************************************************/
					try	
					{	 
						closeResultSet(resultSet);
						pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
						pstmt1.setString( 1, "RL" ) ;
						pstmt1.setString( 2, p_facility_id ) ;						
						resultSet = pstmt1.executeQuery();
						String rl_install_yn="";

						while(resultSet.next())
						{
							rl_install_yn = (String)resultSet.getString("operational_yn");
						}
						tracer.append("\nCancelManager.java,3878,sql=>"+(String)sqlMap.get("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN")+"1=>RL,2=>"+p_facility_id+",rl_install_yn=>"+rl_install_yn);

						closeResultSet(resultSet);
						closeStatement(pstmt1);
						if( rl_install_yn.equals("Y") )
						{
							closeStatement( cstmt ) ;
							cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_SPECIMEN_ORDER_RL_NEONATES_SPEC_YN") +" }");
							cstmt.setString(1, p_order_id);
							cstmt.setString(2, ord_typ_code);
							cstmt.registerOutParameter(3,Types.VARCHAR);

							cstmt.execute();

							String neonate_spec_yn=cstmt.getString(3);

							closeStatement( cstmt ) ;
							tracer.append("\nCancelManager.java,3896,sql=>"+(String)sqlMap.get("SQL_OR_SPECIMEN_ORDER_RL_NEONATES_SPEC_YN")+"p_order_id=>"+p_order_id+",ord_typ_code=>"+ord_typ_code+",neonate_spec_yn=>"+neonate_spec_yn);

							if(neonate_spec_yn.equals("Y"))
							{
								cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_CANCEL_ORDER_RL_CANCEL_SPECIMEN") +" }");
								cstmt.setString(1, "O");
								cstmt.setString(2, p_order_id);
								cstmt.setString(3, ord_typ_code);
								cstmt.setString(4, null);
								cstmt.registerOutParameter(5,Types.VARCHAR );//stat
								cstmt.registerOutParameter(6,Types.VARCHAR );//error_text
								cstmt.execute();
								stat	= cstmt.getString(5);  
								message	= cstmt.getString(6);  
								tracer.append("\nCancelManager.java,3909,sql=>"+(String)sqlMap.get("SQL_OR_CANCEL_ORDER_RL_CANCEL_SPECIMEN")+"1=>O,2=>"+p_order_id+"=>"+ord_typ_code+",null,stat=>"+stat+"message=>"+message);
								if(stat!=null && stat.equals("E"))
									result = 0;
								else 
									result = 1;	

								closeStatement( cstmt ) ;
							}					
						}
						tracer.append("\nCancelManager.java,3919,result=>"+result);
						if ( result < 1 ) 
						{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							
							if(message!=null && !message.equals(""))
								map.put( "message",message ) ;
							else
								map.put( "message", "Operation failure ..." ) ;
						}
						else
						{							
							insert_valid =1;
							result =1;
							connection.commit() ;
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message", "RECORD_MODIFIED" ) ;
						}//*******
						tracer.append("\nCancelManager.java,3948,Record_Modified");
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
				else
				{				 
			   		insert_valid = 1;	
					result =1;
				}
			}		

			if ((cancel_type.trim()).equals("L"))
			{
				if(!((p_order_id.substring(0,2).equalsIgnoreCase("PH"))&&!(order_set_id.equals(""))))
				{
					tracer.append("\nCancelManager.java,3967");
					updateHeaderStatus(connection,p_order_id);
				}
			}
			if(result>0)
			{			   	 
				//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(cancel_allow_yn.equalsIgnore	Case("Y")))
				if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(cancel_allow_yn.equalsIgnoreCase("Y")))
				{
					tracer.append("\nCancelManager.java,3975");
					pstmt_set_status = connection.prepareStatement("select order_status from or_order where order_id=?");
					pstmt_set_status.setString(1,order_set_id);
					resultset_status = pstmt_set_status.executeQuery();
					while(resultset_status.next())
					{
						order_set_status_type= resultset_status.getString("order_status");
					}
					closeStatement(pstmt_set_status);
					closeResultSet(resultset_status);						 

					if(order_set_status_type==null) 
						order_set_status_type="";

					if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(cancel_allow_yn.equalsIgnoreCase("Y"))&&((order_set_status_type.equalsIgnoreCase("CN"))))
					{
						cstmt = connection.prepareCall("{call or_bl_without_order_catalog (?,?,?,?,?,?,?,?,?,?,?,?,?)}");//IN071315//IN072752
						cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
						cstmt.setString(2, order_set_id);						// P_ORDER_ID
						cstmt.setString(3, "1");				// P_ORDER_LINE_NUM
						cstmt.setString(4, p_mode); 						// P_MODE
						cstmt.setString(5, p_user);							// P_USER
						cstmt.setString(6, p_ws_no);						// P_WS_NO
						cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
						cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
						cstmt.setString(9, "N");						// FUTURE
						cstmt.setString(10, "Y");						// INCLUDE_CANCEL
						//IN071315 Starts
						if("Y".equals(p_called_from_ca))
							cstmt.setString(11, "CA");
						else
							cstmt.setString(11, "OR");
						//IN071315 Ends
						//IN068314 Starts
						cstmt.setString(12, fpp_yn);//IN072752
						cstmt.setString(13, fpp_category);//IN072752
						//IN068314 Ends
						cstmt.execute();
						p_error_message	= cstmt.getString(8);  // message
						tracer.append("4029,p_error_message=>"+p_error_message);
						tracer.append("4030,p_facility_id=>"+p_facility_id+" order_set_id=>"+order_set_id+" 1 "+" p_mode=> "+p_mode+" p_user=>"+p_user+" p_ws_no=> "+p_ws_no+" 9=>"+"N "+" 10=>"+"Y");

						try 
						{
							closeStatement( cstmt ) ;
						}
						catch ( Exception fe ) 
						{
							fe.printStackTrace() ;
						}
						
						if(p_error_message!=null && !p_error_message.equals(""))
							result = 0;
						else 
							result = 1;

						if ( result < 1 ) 
						{
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message",p_error_message ) ;
							return map;
						}
						else
						{
							insert_valid =1;
							result =1;
						}
					}
				}
			}
			tracer.append("\nCancelManager.java,4040,result=>"+result);
			if(result>0)
			{
				if ((cancel_type.trim()).equals("L"))
				{
					if((p_order_id.substring(0,2).equalsIgnoreCase("PH"))&&!(order_set_id.equals("")))
					{
						updateOncologyStatus(connection,order_set_id,p_user,"Line");
					}
				}
				else
				{
					if((p_order_id.substring(0,2).equalsIgnoreCase("PH"))&&!(order_set_id.equals("")))
					{
						updateOncologyStatus(connection,order_set_id,p_user,"Header");
					}
				}
				map.put( "result", new Boolean( true ) ) ;
				map.put("message", "RECORD_MODIFIED") ;
				connection.commit();
				return map;
			}
		}		 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//System.out.println("Tracing for CancelOrder=>"+tracer.toString());
			try
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeStatement( pstmt3 ) ;
				closeStatement( pstmt4 ) ;
				closeStatement( pstmt5 ) ;
				closeStatement( pstmt6 ) ;
				closeStatement(cstmt);
			}
			catch(Exception ee) 
			{
				ee.printStackTrace() ;
			}
		}
		return map;
	}

	//Added By Sridhar Reddy on 30/10/2009 SRR20056-CRF-0195
	private void updateHeaderStatus(Connection con,String p_order_id) throws Exception
	{
		//tracer.append("\nCancelManager.java,4091");
		PreparedStatement pstmt = null;		
		int recCnt = 0;	   
		//String sqlQuery = "select count(*) tot_cnt from OR_ORDER_LINE a where a.ORDER_ID =? and a.ORDER_LINE_STATUS = 'OS' ";Modified by Uma on 12/24/2009 for IN017611
		String sqlQuery = "select count(*) tot_cnt from OR_ORDER_LINE a where a.ORDER_ID =? and a.ORDER_LINE_STATUS in (select order_Status_code from or_ordeR_status_code where ordeR_status_type in ('99','97','96','95','90','85','80','75','70','65','60','55','54','52','25','20','15','10','05','03','00','23') and order_Status_code = a.order_line_status and rownum <=1)";
		pstmt = con.prepareStatement(sqlQuery);
		pstmt.setString(1,p_order_id);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next())
		{
			recCnt = rs.getInt(1);
		}
		
		if (rs != null)
			rs.close();
		
		if (pstmt != null)
			pstmt.close();	

		if (recCnt == 0)
		{
			sqlQuery = "update OR_ORDER  set ORDER_STATUS='CN'  where ORDER_ID =? ";
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1,p_order_id);
			//int result = pstmt.executeUpdate();
			pstmt.executeUpdate();
			
			if (pstmt != null)
				pstmt.close();	
		} 	
	}
	//End

	//Added By Uma on 12/28/2009 IN016826
	private void updateOncologyStatus(Connection connection,String order_set_id,String login_by_id,String from) throws Exception
	{ 
		PreparedStatement pstmt_onco_status =null;
		PreparedStatement pstmt_onco_order_status =null;
		PreparedStatement pstmt_onco_order_line_status =null;
		ResultSet resultset_onco =null;
		String L_order_status = "";
		String onco_order_status = "";
		String oncomsg = "";
		
		try
		{
			//if(from.equalsIgnoreCase("Header"))
			//
			onco_order_status = "SELECT  order_status L_order_status from or_order where order_set_id=? and ORDER_CATEGORY='PH' AND IV_PREP_YN  IN ('0','9') and exists (select 1 from or_order where order_set_id=? and order_status IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('99','93'))) AND ROWNUM=1";
			// }
			//else
			pstmt_onco_status = connection.prepareStatement(onco_order_status);
			pstmt_onco_status.setString(1,order_set_id);
			//if(from.equalsIgnoreCase("Header"))
			//{
			pstmt_onco_status.setString(2,order_set_id);
			//}
			// {
			resultset_onco = pstmt_onco_status.executeQuery();
			while(resultset_onco!=null && resultset_onco.next())
			{
				L_order_status = resultset_onco.getString("L_order_status");
			}
			closeResultSet(resultset_onco);
			if(L_order_status == null) 
				L_order_status = "";

			if(L_order_status.equals(""))
			{	
				onco_order_status = "SELECT  order_line_status L_order_status from or_order_line where order_id in (SELECT ORDER_ID FROM OR_ORDER WHERE order_set_id=? and ORDER_CATEGORY='PH' and IV_PREP_YN  IN ('0','9')) and order_line_status IN (SELECT  ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('99','93')) AND ROWNUM=1";
				// }
				if(pstmt_onco_status!=null)pstmt_onco_status.close();
					pstmt_onco_status = connection.prepareStatement(onco_order_status);
				
				pstmt_onco_status.setString(1,order_set_id);
				resultset_onco = pstmt_onco_status.executeQuery();
				
				while(resultset_onco!=null && resultset_onco.next())
				{
					L_order_status = resultset_onco.getString("L_order_status");
				}
			}

			oncomsg= "Due To Order Set Status Change";
			String update_onco_order_line="UPDATE OR_ORDER_LINE SET order_LINE_status=?,can_line_reason=?,modified_by_id=?,modified_date=sysdate where ORDER_ID IN (SELECT ORDER_ID FROM OR_ORDER WHERE order_set_id=? and ORDER_CATEGORY='PH' and IV_PREP_YN  IN ('0','9')) and order_line_status!=?";
			pstmt_onco_order_line_status = connection.prepareStatement(update_onco_order_line);
			pstmt_onco_order_line_status.setString(1,L_order_status);
			pstmt_onco_order_line_status.setString(2,oncomsg);
			pstmt_onco_order_line_status.setString(3,login_by_id);
			pstmt_onco_order_line_status.setString(4,order_set_id);
			pstmt_onco_order_line_status.setString(5,L_order_status);
			//int onco_order_line = pstmt_onco_order_line_status.executeUpdate();
			pstmt_onco_order_line_status.executeUpdate();
			String update_onco_order = "UPDATE OR_ORDER SET order_status=? where  order_set_id=? and ORDER_CATEGORY='PH' and IV_PREP_YN  IN ('0','9') and order_status!=?";
			pstmt_onco_order_status = connection.prepareStatement(update_onco_order);
			pstmt_onco_order_status.setString(1,L_order_status);
			pstmt_onco_order_status.setString(2,order_set_id);
			pstmt_onco_order_status.setString(3,L_order_status);
			//int onco_order = pstmt_onco_order_status.executeUpdate();
			pstmt_onco_order_status.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{ 
				if (resultset_onco != null)
					resultset_onco.close();

				if (pstmt_onco_status != null)
					pstmt_onco_status.close();
				
				if (pstmt_onco_order_status != null)
					pstmt_onco_order_status.close();
				
				if (pstmt_onco_order_line_status != null)
					pstmt_onco_order_line_status.close();	
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}							 
	}//Ends	

	public HashMap resumeOrder(Connection connection, HashMap tabData, HashMap sqlMap)
	{
		PreparedStatement pstmt1 	= null;
		CallableStatement cstmt 	= null;
		ResultSet resultSet 				= null;
		HashMap map = new HashMap() ;
		String message = "";
		//String[] user_info		=  (String[])tabData.get("updt_line");	
		String order_id		    = (String)tabData.get("order_id");
		String order_line_num   = (String)tabData.get("order_line_num");
		int result = 0;

		if(order_line_num == null || order_line_num.equals("null"))
			order_line_num = "";		

		try
		{
			// this if block is top resume the head level order
			if(!(order_line_num.equals("")))
			{
				pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_RESUME_ORDER_HEADER") ) ;
				pstmt1.setString( 1, (String)tabData.get("login_by_id"));		//login_by_id
				pstmt1.setString( 2, (String)tabData.get("login_at_ws_no"));	//login_at_ws_no
				pstmt1.setString( 3, (String)tabData.get("login_facility_id"));	//login_facility_id 
				pstmt1.setString( 4, order_id);
				//pstmt1.setString( 2, order_id); // commented for IN063457 //Commented again for IN007189
				pstmt1.setString( 5, order_id); // Added for IN007189
				result = pstmt1.executeUpdate();
				closeStatement( pstmt1 ) ;

				if(result>=1)
				{
					result=0;
					//pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_RESUME_ORDER_LINE") ) ;//Modified -- [IN029128] //IN042100
					//pstmt1 = connection.prepareStatement( "update or_order_line set order_line_status = prev_order_line_status,LAST_ACTION_REASON_DESC=null,can_line_reason = NULL, HOLD_PRACT_ID=null, HOLD_DATE_TIME=null,modified_by_id = ?, modified_date = sysdate , modified_at_ws_no = ?, modified_facility_id = ? WHERE order_id=(?) and order_line_num = ?" ) ;
					//pstmt1 = connection.prepareStatement( "update or_order_line set LAST_ACTION_REASON_DESC='',can_line_reason = '', HOLD_PRACT_ID='', HOLD_DATE_TIME='',modified_by_id = ?, modified_date = sysdate , modified_at_ws_no = ?, modified_facility_id = ? WHERE order_id=(?) and order_line_num = ?" ) ;//Commented for IN007189
					pstmt1 = connection.prepareStatement( "update or_order_line set order_line_status = prev_order_line_status,LAST_ACTION_REASON_DESC='',can_line_reason = '', HOLD_PRACT_ID='', HOLD_DATE_TIME='',modified_by_id = ?, modified_date = sysdate , modified_at_ws_no = ?, modified_facility_id = ? WHERE order_id=(?) and order_line_num = ?" ) ;//Modified for IN007189
					pstmt1.setString( 1, (String)tabData.get("login_by_id"));		//login_by_id
					pstmt1.setString( 2, (String)tabData.get("login_at_ws_no"));	//login_at_ws_no
					pstmt1.setString( 3, (String)tabData.get("login_facility_id"));	//login_facility_id 
					pstmt1.setString( 4, order_id);
					pstmt1.setString( 5, order_line_num);//IN042100
					result = pstmt1.executeUpdate();
					closeStatement( pstmt1 ) ;
				}
			}
			else
			{
				// else block will resume the line order
				// if the line order has only order to update..the nupdate the orderstatus of // the header correspondingly with the same line order status
			  	closeStatement( pstmt1 ) ;
				pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_RESUME_ORDER_HEADER") ) ;
				pstmt1.setString( 1, (String)tabData.get("login_by_id"));		//login_by_id
				pstmt1.setString( 2, (String)tabData.get("login_at_ws_no"));	//login_at_ws_no
				pstmt1.setString( 3, (String)tabData.get("login_facility_id"));	//login_facility_id 
				pstmt1.setString( 4, order_id);
				//pstmt1.setString( 2, order_id); // commented for IN063457 //Commented again for IN007189
				pstmt1.setString( 5, order_id); // Added for IN007189
				result = pstmt1.executeUpdate();
				closeStatement( pstmt1 ) ;
				//pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_ENTRY_RESUME_ORDER_LINE") ) ; //Modified -- [IN029128]
				//pstmt1 = connection.prepareStatement( "update or_order_line set order_line_status = prev_order_line_status,LAST_ACTION_REASON_DESC=null,can_line_reason = NULL, HOLD_PRACT_ID=null, HOLD_DATE_TIME=null,modified_by_id = ?, modified_date = sysdate , modified_at_ws_no = ?, modified_facility_id = ? WHERE order_id=(?)" ) ; // commented for IN063457 
				//pstmt1 = connection.prepareStatement( "update or_order_line set LAST_ACTION_REASON_DESC='',can_line_reason = '', HOLD_PRACT_ID='', HOLD_DATE_TIME='',modified_by_id = ?, modified_date = sysdate , modified_at_ws_no = ?, modified_facility_id = ? WHERE order_id=(?)" ) ; // modified for IN063457 //Commented for IN007189
				pstmt1 = connection.prepareStatement( "update or_order_line set order_line_status = prev_order_line_status,LAST_ACTION_REASON_DESC='',can_line_reason = '', HOLD_PRACT_ID='', HOLD_DATE_TIME='',modified_by_id = ?, modified_date = sysdate , modified_at_ws_no = ?, modified_facility_id = ? WHERE order_id=(?)" ) ; // Modified for IN007189
				pstmt1.setString( 1, (String)tabData.get("login_by_id"));		//login_by_id
				pstmt1.setString( 2, (String)tabData.get("login_at_ws_no"));	//login_at_ws_no
				pstmt1.setString( 3, (String)tabData.get("login_facility_id"));	//login_facility_id 
				pstmt1.setString( 4, order_id);
				result = pstmt1.executeUpdate();
				closeStatement( pstmt1 ) ;
				/*
			  	String sql = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT");
				int t = sql.lastIndexOf("?");
				sql  = sql.substring(0,t) + tmpStr.trim() + sql.substring(t+1)  ;
			   	pstmt2 = connection.prepareStatement( sql ) ;
				pstmt2.setString( 1, (String)updt_vals2[1].trim()) ;
			   	resultSet = pstmt2.executeQuery();*/
			}

			if ( result < 1 ) 
			{
				map.put( "result", new Boolean( false) ) ;
				connection.rollback();
				map.put( "message", "Operation failure ..." ) ;
			} 
			else  
			{
				/*Added by Uma on 3/30/2010 for IN020384*/
				if (order_id.substring(0,2).equals("PH")) 
				{
					cstmt = connection.prepareCall("{ "+(String)OrRepository.getOrKeyValue("SQL_OR_PH_PATIENTDRUGPROFILEUPDATE_PROC") +" }");
					cstmt.setString(1, order_id); 		// P_ORDERID
					cstmt.setString(2, "");				// P_ORDERLINENO
					cstmt.setString(3, "RH");	// P_OPERATION
					cstmt.setString(4, ""); 			// P_REASONCODE
					cstmt.setString(5, "");		// P_REMARKS
					cstmt.setString(6, "");		// P_PRACTITIONERID
					cstmt.setString(7, (String)tabData.get("login_by_id")); 		// P_USERID
					cstmt.setString(8, (String)tabData.get("login_facility_id"));	// P_FACILITYID
					cstmt.setString(9, (String)tabData.get("login_at_ws_no"));			// P_WSNO
					cstmt.registerOutParameter( 10,  Types.VARCHAR ) ; //P_ERRMSG
					cstmt.execute();
					message	= cstmt.getString(10);  // message

					if(message!=null && !message.equals(""))
						result = 0;
					else 
						result = 1;
				}
				if ( result < 1 ) 
				{
					map.put( "result", new Boolean( false) ) ;
					connection.rollback();
					map.put( "message", "Operation failure ..." ) ;
				}
				/*Ends Here by Uma on 3/30/2010 for IN020384*/
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "RECORD_MODIFIED" ) ;
				//messages.append( "RECORD_MODIFIED" ) ;
				//messages.append( "Operation Completed Successfully..." ) ;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			try
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( cstmt ) ;
			}
			catch(Exception ee) 
			{
				ee.printStackTrace() ;
			}
		}
		return map;
	}

/*Added by Uma for Future Order Function*/
	public HashMap futureOrder(Connection connection, HashMap tabData, HashMap sqlMap)
	{
		//CallableStatement cstmt_bl_ext_chrg_stage= null;
		CallableStatement cstmt_bl_ext_charge_stage= null;
		CallableStatement cstmt_billing_ext= null;
		CallableStatement cstmt_future_new_order= null;
		/*Added by Uma on 1/19/2010 for IN017420*/
		CallableStatement cstmt_frequency= null;
		/*Ends Here*/
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;
		PreparedStatement pstmt5 	= null;
		PreparedStatement pstmt6 	= null;
		PreparedStatement pstmt7 	= null;
		PreparedStatement pstmt8 	= null;
		PreparedStatement pstmt9 	= null;
		PreparedStatement pstmt11 	= null;//IN039096
		PreparedStatement cont_ord_ind_pstmt 	= null;
		ResultSet resultSet 				= null;
		ResultSet resultSet1 				= null;
		ResultSet resultSet3 				= null;
		ResultSet cont_ord_ind_resultset 				= null;
		ResultSet child_orders_resultset 				= null;
		int result_dtl		= 0;//IN039096
		HashMap map = new HashMap() ;
		String episode_type="";
		TreeMap ConData =  (TreeMap)tabData.get("future_value");
		String login_facility_id	=(String)tabData.get("login_facility_id") ;
		String patient_class=(String)tabData.get("p_patient_class");
		String linerecord="";
		boolean isBTViewBillDtls = Boolean.parseBoolean((String)tabData.get("isBTViewBillDtls"));//IN065324

		if (patient_class.equals("IP") || patient_class.equals("EA"))
			episode_type="I";
		else if(patient_class.equals("OP"))
			episode_type="O";
		else if(patient_class.equals("EM"))
			episode_type="E";
		else if(patient_class.equals("DC"))
			episode_type="D";
		else if(patient_class.equals("XT"))
			episode_type="R";

		String order_id="";
		String catalog_code="";
		String catalog_desc="";
		//String physician_id=""; //Checkstyle
		String err_message	= "";
		String sys_message_id	= "";		
		String err_code			=	"";
		HashMap bill_dtls				= null;
		String p_total_amt="";
		String incl_excl_action="";
		String incl_excl_action_orginal="";
		String	incl_excl_action_reason="";
		String bl_panel_str="";
		String error_message="";
		String Future_order_yn="";
		String charge_type_code="";
		StringBuffer error_messages=new StringBuffer();
		String statusyn="N";
		String complete_on_order_yn="N";
		String regn_reqd_yn="N";  
		boolean result = true;
		int count =0;
		int errcount=0;
		/*Added by Uma on 1/19/2010 for IN017420*/
		int cancel_count_line  = 0;
		int cancel_order_update  = 0;
		/*Ends Here*/
		//String no_of_occurance = ""; //Checkstyle
		String p_new_order_id = "";
		String p_order_error_message = "";
		String ord_pract_id ="";
		String quantity ="";
		String start_date_time = "";
		String temp_order_id = "";
		String billing_package_ref = "";//IN039096
		/*Added by Uma on 1/19/2010 for IN017420*/
		String cont_order_yn			= "";
		String frequency_val				= "";
		String duration_value				= "";
		String p_start_date_time		= "";
		String order_category			= "";
		String child_order_id				= "";
		String p_order_status_code	= "";
		String future_order_charge_later_yn	= "";
		/*Ends Here*/
		String billing_line_result			= "";
		count            = Integer.parseInt((String)tabData.get("totalCount"));
		//String locale = (String)tabData.get("locale");
		/*Added by Uma on 1/19/2010 for IN017420*/
		String status_code_sql = (String)sqlMap.get("SQL_OR_ORDER_GET_STATUS_CODE");
		String sql  = "";
		String bill_yn = "";
		String contr_mod_id = "";
		String mod_physician_id = "";
		/*Ends Here*/	
		Iterator tit = null;
		tit = new TreeSet (ConData.keySet()).iterator();
		String orderId = "";
		String tempOrderId = "";
		String orderlinenums = "";
		String orderlinenum = "";
		String keyno = "";
		String login_prac_id = "";//IN067484
		//IN049737 - Start
		String p_called_from = "";
		String p_called_from_ca =(String)tabData.get("p_called_from_ca"); //IN071315
		if("unbilled_order_split".equals((String)tabData.get("source")))
			p_called_from = "MS";
		//IN049737 - End
		TreeMap ordersMap = new TreeMap();
		boolean isProceed = false;//IN065324

		while(tit.hasNext())
		{
			keyno = (String)tit.next();
			orderId = keyno.substring(0,15);
			orderlinenum = keyno.substring(15);

			if(!orderId.equals(tempOrderId))
			{  
				tempOrderId = orderId;
				orderlinenums = "";
				if(!orderlinenums.equals(""))
					orderlinenums = orderlinenums + "|" +keyno.substring(15);
				else
					orderlinenums = keyno.substring(15);
			}
			else
			{
				if(!orderlinenums.equals(""))
					orderlinenums = orderlinenums + "|" +keyno.substring(15);
				else
					orderlinenums = keyno.substring(15);
			} 
			ordersMap.put(orderId,orderlinenums);
		}		

		try
		{
			pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_FUTURE_ORDER_SELECT")) ;
			//8004 Starts
			String orderlinesql  = "";
			//String orderlinefreqsql="";//12123 //Checkstyle
			//pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_FUTURE_ORDER_CANCEL_LINE")) ; 
			orderlinesql = "UPDATE  or_order_line SET order_line_status = (SELECT order_Status_code FROM or_order_status_code WHERE order_Status_type =('99')), modified_by_id=(?), modified_date=SYSDATE, modified_at_ws_no=(?), modified_facility_id=(?),can_line_reason=(?),can_pract_id=(?),can_date_time=sysdate,Cancelled_by_sys_yn=('Y'),order_set_id=null,order_set_line_num=null ,EXT_APPL_ACCESSION_NUM =''  ##FILTERMSGFLAG$$ WHERE order_id = (?) AND order_line_num  = (?)";//ML-MMOH-SCF-1653
			if("".equals(p_called_from))
			{
				orderlinesql = orderlinesql.replace("##FILTERMSGFLAG$$", " ,ORDER_MSG_FLAG = 'N' ");
			}
			else
			{
				orderlinesql = orderlinesql.replace("##FILTERMSGFLAG$$", " ");
			}
			pstmt3 = connection.prepareStatement(orderlinesql) ;
			//8004 Ends
			cont_ord_ind_pstmt			= connection.prepareStatement("select cont_order_ind cont_order_ind,freq_code frequency_val,durn_value duration_value,to_char(start_date_time,'dd/mm/YYYY HH24:MI') start_date_time,order_category order_category,future_order_charge_later_yn future_order_charge_later_yn from or_order_line where order_id=?");
			pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_FUTURE_ORDER_REG_COMPLETE")) ;
			cstmt_billing_ext			= connection.prepareCall("{ CALL BL_PROC_FOR_EXT_SERVICE_MP.PROCESS_INTERFACED_REC( ? ,? ,?, ?, ?, ? ,? ,?, ?, ?, ? ,? ,?)}");
			cstmt_bl_ext_charge_stage=connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE") +" }");		
			//12123 Starts
			//pstmt6 = connection.prepareStatement("UPDATE  or_order_line SET order_line_status = (SELECT order_Status_code FROM or_order_status_code WHERE order_Status_type =('99')), modified_by_id=(?), modified_date=SYSDATE, modified_at_ws_no=(?), modified_facility_id=(?),can_line_reason=(?),can_pract_id=(?),can_date_time=sysdate,Cancelled_by_sys_yn='Y',order_set_id=null,order_set_line_num=null WHERE parent_order_id=?") ;//12123// Commented for 12437
			/*orderlinefreqsql = "UPDATE  or_order_line SET order_line_status = (SELECT order_Status_code FROM or_order_status_code WHERE order_Status_type =('99')), modified_by_id=(?), modified_date=SYSDATE, modified_at_ws_no=(?), modified_facility_id=(?),can_line_reason=(?),can_pract_id=(?),can_date_time=sysdate,Cancelled_by_sys_yn='Y',order_set_id=null,order_set_line_num=null,EXT_APPL_ACCESSION_NUM ='' ##FILTERMSGFLAG$$ WHERE parent_order_id=?";//12123			
			if("".equals(p_called_from))
			{
				orderlinefreqsql = orderlinefreqsql.replace("##FILTERMSGFLAG$$", " ,ORDER_MSG_FLAG = 'N' ");
			}
			else
			{
				orderlinefreqsql = orderlinefreqsql.replace("##FILTERMSGFLAG$$", " ");
			}
			pstmt6 = connection.prepareStatement(orderlinefreqsql) ;*/// Commented for 12437
			//12123 Ends
			pstmt7 = connection.prepareStatement("select order_id child_order_id from or_order WHERE parent_order_id=?") ;
			pstmt9 = connection.prepareStatement("select order_id child_order_id from or_order WHERE parent_order_id=?") ;
			cstmt_frequency = connection.prepareCall("{CALL or_frequency_explosion(?,?,?,?,?,?,?,?)}");
			
			pstmt11 = connection.prepareStatement("UPDATE  bl_patient_charges_interface SET PRIMARY_KEY_MAIN =(?) , SEC_KEY_MAIN =(?) ,ENCOUNTER_ID = (?), modified_by_id=(?), modified_date=SYSDATE, modified_at_ws_no=(?), modified_facility_id=(?) WHERE PRIMARY_KEY_MAIN=?") ;//IN039096

			tit = new TreeSet (ConData.keySet()).iterator();
			int same_order_count = 1;  //IN049737

			while(tit.hasNext())
			{

				keyno = (String)tit.next();
				order_id = (String)keyno.substring(0,15);
				linerecord = (String)keyno.substring(15); 
				//int recordcount = 0; //Checkstyle
				
				closeResultSet(resultSet);

				if(order_id.equalsIgnoreCase(temp_order_id))
				{
					same_order_count++;
				}
				else
				{  
					temp_order_id       = order_id;//Only Once for the first order line it calls 
					same_order_count	= 1;
					cstmt_future_new_order = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_FUTURE_ORDER_NEW_ORDER") +" }");
					cstmt_future_new_order.setString(1,(String)order_id.trim());
					cstmt_future_new_order.setString(2,(String)order_id.substring(0,2));
					cstmt_future_new_order.setString(3,(String)tabData.get("p_patient_class"));
					cstmt_future_new_order.setString(4,(String)tabData.get("p_encounter_id"));
					cstmt_future_new_order.setString(5,(String)tabData.get("p_episode_id"));
					cstmt_future_new_order.setString(6,(String)tabData.get("p_episode_visit_num"));
					cstmt_future_new_order.setString(7,(String)tabData.get("p_source_type"));
					cstmt_future_new_order.setString(8,(String)tabData.get("p_source_code"));
					cstmt_future_new_order.setString(9,(String)ordersMap.get(order_id));
					cstmt_future_new_order.registerOutParameter( 10,  Types.VARCHAR ) ; 	// P_BILL_YN
					cstmt_future_new_order.registerOutParameter( 11,  Types.VARCHAR ) ;
					cstmt_future_new_order.setString(12,p_called_from);//IN049737
					cstmt_future_new_order.execute();
					p_new_order_id	= cstmt_future_new_order.getString(10);  // p_order_id

					p_order_error_message	= cstmt_future_new_order.getString(11);  // err_message

					if(p_order_error_message!=null && !p_order_error_message.equals(""))
					{
						result = false;
						map.put( "result", new Boolean( false) ) ;
						connection.rollback();
						error_messages.append(p_order_error_message);
						map.put( "message", p_order_error_message) ;
						errcount++;
					}
					closeStatement(cstmt_future_new_order);
				}

				if(result)
				{
					pstmt3.setString(1 , (String)tabData.get("login_by_id"));
					pstmt3.setString(2 , (String)tabData.get("login_at_ws_no"));
					pstmt3.setString(3 , login_facility_id);
					//Modified IN049737 - Start
					if("MS".equals(p_called_from))
						pstmt3.setString(4 , "Bill Unsettled Orders Splitted to New Order");
					else
						pstmt3.setString(4 , "Orders Linked to Current Encounter");
					//Modified IN049737 - End
					//pstmt3.setString(5 , (String)tabData.get("login_by_id")); 
					pstmt3.setString(5 , login_prac_id);
					pstmt3.setString(6 , (String)order_id.trim());
					pstmt3.setString(7 , (String)linerecord.trim());								
					cancel_count_line = pstmt3.executeUpdate();
					p_order_status_code =(String) getStatusCode(connection,order_id,status_code_sql);	
					sql  = (String)sqlMap.get("SQL_OR_FUTURE_ORDER_UPDATE_ORDER_STATUS");//IN072727 //8004
					//sql= "update or_order set order_status=?, modified_by_id=(?), modified_date=SYSDATE, modified_at_ws_no=(?), modified_facility_id=(?) ##FILTER$$ ##FILTERMSGFLAG$$ where order_id=?";//IN072727//8004
					if(p_order_status_code.equalsIgnoreCase("CN"))
					{
						sql = sql.replace("##FILTER$$", " ,order_set_id = null");
					}
					else
					{
						sql = sql.replace("##FILTER$$", " ");
					}
					//IN072727 Starts
					//8004 
				/*	if("".equals(p_called_from))
					{
						sql = sql.replace("##FILTERMSGFLAG$$", " ,ORDER_MSG_FLAG = 'N' ");
					}
					else
					{
						sql = sql.replace("##FILTERMSGFLAG$$", " ");
					}*/	//8004 
					//IN072727 Ends
					pstmt = connection.prepareStatement(sql);
					pstmt.setString( 1 ,  p_order_status_code ) ;
					pstmt.setString( 2 , (String)tabData.get("login_by_id"));
					pstmt.setString( 3 , (String)tabData.get("login_at_ws_no"));
					pstmt.setString( 4 , login_facility_id);
					pstmt.setString( 5 , (String)order_id.trim()) ;
					cancel_order_update  = pstmt.executeUpdate() ;	
					if (pstmt != null)pstmt.close();//15950
					/*Added by Uma on 1/19/2010 for IN017420 to cancel all the child orders*/
					cont_ord_ind_pstmt.setString(1,p_new_order_id);
					cont_ord_ind_resultset		=    cont_ord_ind_pstmt.executeQuery();

					while(cont_ord_ind_resultset!=null && cont_ord_ind_resultset.next())
					{
						cont_order_yn = cont_ord_ind_resultset.getString("cont_order_ind");
						frequency_val = cont_ord_ind_resultset.getString("frequency_val");
						duration_value = cont_ord_ind_resultset.getString("duration_value");
						p_start_date_time = cont_ord_ind_resultset.getString("start_date_time");
						order_category = cont_ord_ind_resultset.getString("order_category");
						future_order_charge_later_yn = cont_ord_ind_resultset.getString("future_order_charge_later_yn");
					}
					closeResultSet(cont_ord_ind_resultset);

					if((cont_order_yn.equalsIgnoreCase("CR") || cont_order_yn.equalsIgnoreCase("DR")))
					{
						// Commented for 12437 Starts 
/*
						pstmt6.clearParameters();
						pstmt6.setString(1,(String)tabData.get("login_by_id"));
						pstmt6.setString(2,(String)tabData.get("login_at_ws_no"));
						pstmt6.setString(3,login_facility_id);
						//Modified IN049737 - Start 
						if("MS".equals(p_called_from))
							pstmt6.setString(4,"Bill Unsettled Orders Splitted to New Order");
						else
							pstmt6.setString(4,"Orders Linked to Current Encounter");
						//Modified IN049737 - End
						pstmt6.setString(5,(String)tabData.get("login_by_id"));
						pstmt6.setString(6,(String)order_id.trim());
						cancel_count_line = pstmt6.executeUpdate();*/
						// Commented for 12437 Ends
						pstmt7.setString(1,(String)order_id.trim());
						child_orders_resultset = pstmt7.executeQuery();

						while(child_orders_resultset!=null && child_orders_resultset.next())
						{
							child_order_id = child_orders_resultset.getString("child_order_id");
							p_order_status_code =(String) getStatusCode(connection,order_id,status_code_sql);
							sql  = (String)sqlMap.get("SQL_OR_FUTURE_ORDER_UPDATE_ORDER_STATUS");

							if(p_order_status_code.equalsIgnoreCase("CN"))
							{
								sql = sql.replace("##FILTER$$", " ,order_set_id = null");
							}
							else
							{
								sql = sql.replace("##FILTER$$", " ");
							}
							pstmt8 = connection.prepareStatement(sql);
							pstmt8.setString( 1, p_order_status_code ) ;
							pstmt8.setString( 2 , (String)tabData.get("login_by_id"));
							pstmt8.setString( 3 , (String)tabData.get("login_at_ws_no"));
							pstmt8.setString( 4 , login_facility_id);
							pstmt8.setString( 5, (String)child_order_id.trim()) ;
							cancel_order_update  = pstmt8.executeUpdate() ;	
							if (pstmt8 != null)pstmt8.close();//15950
						}
						closeResultSet(child_orders_resultset);
					}
					/*Ends Here*/

					HashMap orderRecord =  new HashMap();
					orderRecord = (HashMap)ConData.get(keyno);
					String billdtls = "billing_revise_dtls"+keyno;
					bill_dtls = (HashMap)orderRecord.get(billdtls);

					order_id=(String)orderRecord.get("order_id");
					linerecord = (String)orderRecord.get("order_line_num");
					catalog_code=(String)orderRecord.get("catalog_code");
					catalog_desc=(String)orderRecord.get("catalog_desc");
					ord_pract_id=(String)orderRecord.get("ord_pract_id");
					start_date_time=(String)orderRecord.get("start_date_time");
					quantity=(String)orderRecord.get("quantity");					
					bill_yn = (String)orderRecord.get("bill_yn");
					contr_mod_id = (String)orderRecord.get("contr_mod_id");
					billing_package_ref = (String)orderRecord.get("billing_package_ref")==null?"":(String)orderRecord.get("billing_package_ref");

					//IN065324, starts
					if((isBTViewBillDtls && ("OP".equals(patient_class)|| "EM".equals(patient_class)) && contr_mod_id.equals("BT")) || !contr_mod_id.equals("BT"))
					{
						isProceed = true;
					}
					//IN065324, ends

					//if (bill_yn.equalsIgnoreCase("Y")&&!contr_mod_id.equals("BT"))//IN065324
					if (bill_yn.equalsIgnoreCase("Y") && isProceed)//IN065324
					{

						String login_by_id = (String)tabData.get("login_by_id");
						String login_at_ws_no = (String)tabData.get("login_at_ws_no");
						billing_line_result = cancelOrderBilling(connection,login_facility_id,order_id,linerecord,login_by_id,login_at_ws_no,p_called_from_ca);//IN071315 
						/*Added by Uma on 1/19/2010 for IN017420 to cancel all the billing child orders*/
						if((cont_order_yn.equalsIgnoreCase("CR") || cont_order_yn.equalsIgnoreCase("DR")))
						{
							pstmt9.setString(1,(String)order_id.trim());
							child_orders_resultset = pstmt9.executeQuery();
							
							while(child_orders_resultset!=null && child_orders_resultset.next())
							{
								child_order_id = child_orders_resultset.getString("child_order_id");
								billing_line_result = cancelOrderBilling(connection,login_facility_id,child_order_id,"1",login_by_id,login_at_ws_no,p_called_from_ca);//IN071315 
							} 
						}

						if(billing_line_result!=null && !billing_line_result.equals(""))
						{
						   	result = false;
							map.put( "result", new Boolean( false) ) ;
							connection.rollback();
							error_messages.append(billing_line_result);
						   	map.put( "message", billing_line_result) ;
							errcount++;
						}
						else
						{  
							result = true;
						}  
						closeResultSet(child_orders_resultset);
						/*Ends Here*/					

						pstmt5.setString(1,(String)catalog_code.trim());
						resultSet3=pstmt5.executeQuery();

						while(resultSet3!=null && resultSet3.next())
						{
							complete_on_order_yn = checkForNull(resultSet3.getString("complete_on_order_yn"),"N") ;
							regn_reqd_yn = checkForNull(resultSet3.getString("regn_reqd_yn"),"N") ;
						}
						closeResultSet(resultSet3);

						try
						{
							if(errcount==0)
							{
								/*Commented by Uma on 1/25/2010 for IN017420*/
								//order_id = p_new_order_id;
								/*Ends Here*/
								//linerecord = "1";
								cstmt_bl_ext_charge_stage.setString(1, ((String)tabData.get("login_facility_id")));	
								cstmt_bl_ext_charge_stage.setString(2,((String)tabData.get("p_patient_id")));					
								cstmt_bl_ext_charge_stage.setString(3,((String)tabData.get("p_encounter_id")));
								cstmt_bl_ext_charge_stage.setString( 4,((String)tabData.get("p_patient_class")) ) ; 	
								cstmt_bl_ext_charge_stage.setString( 5,(String)p_new_order_id) ;
								//Modified IN049737 - Start
								if("MS".equals(p_called_from))
									cstmt_bl_ext_charge_stage.setString( 6,String.valueOf(same_order_count) ) ;	
								else
									cstmt_bl_ext_charge_stage.setString( 6,(String)linerecord ) ;
								//Modified IN049737 - End	
								cstmt_bl_ext_charge_stage.setString( 7,(String)catalog_code ) ;	
								cstmt_bl_ext_charge_stage.setString( 8,(String)catalog_desc ) ;	
								cstmt_bl_ext_charge_stage.setString(9, start_date_time ) ;
								cstmt_bl_ext_charge_stage.setString(10,(String)quantity ) ;	
								
								if(bill_dtls != null)
								{
									p_total_amt		 = (String)bill_dtls.get("rate");
									incl_excl_action		 = (String)bill_dtls.get("incl_excl_action");
									incl_excl_action_orginal	 = (String)bill_dtls.get("incl_excl_action_orginal");
									Future_order_yn	 = (String)bill_dtls.get("Future_order_yn");

									if(incl_excl_action.equals(incl_excl_action_orginal))
									{
										incl_excl_action="";
									}
									else
									{
										incl_excl_action		 = (String)bill_dtls.get("incl_excl_action");
									}

									incl_excl_action_reason	 = (String)bill_dtls.get("incl_excl_action_reason");
									bl_panel_str			 = (String)bill_dtls.get("bl_panel_str");	
									mod_physician_id		 = (String)bill_dtls.get("mod_physician_id")==null?"":(String)bill_dtls.get("mod_physician_id");
									
									if(mod_physician_id==null) 
										mod_physician_id="";
								}

								cstmt_bl_ext_charge_stage.setString(11,(String)p_total_amt);	
								if (mod_physician_id.equals(""))
								{
									cstmt_bl_ext_charge_stage.setString(12, (String)ord_pract_id);	// PRACTITIONER_ID
								}
								else
								{
									cstmt_bl_ext_charge_stage.setString(12, mod_physician_id);	// PRACTITIONER_ID
								}
								cstmt_bl_ext_charge_stage.setString(13 ,(String)incl_excl_action);	
								// P_OVERRIDDEN_EXCL_INCL_IND 
								cstmt_bl_ext_charge_stage.setString(14 ,checkForNull((String)incl_excl_action_reason,""));
								cstmt_bl_ext_charge_stage.setString(15 ,bl_panel_str.trim());															// P_STR 
								cstmt_bl_ext_charge_stage.setString(16 , "N");															// P_FUTURE_ORDER_YN
								cstmt_bl_ext_charge_stage.setString(17,"N");								// P_FUTURE_ORDER_CHARGE_LATER_YN
								cstmt_bl_ext_charge_stage.setString(18, statusyn.trim());													// AUTH_CONSENT_APPROV_YN									
								cstmt_bl_ext_charge_stage.setString(19,regn_reqd_yn.trim());
								cstmt_bl_ext_charge_stage.setString(20,complete_on_order_yn.trim());									
								cstmt_bl_ext_charge_stage.setString(21, "N");																		// CANCEL_ON_ORDER_YN
								cstmt_bl_ext_charge_stage.setString(22, "N");																		// RESULT_ON_ORDER_YN
								cstmt_bl_ext_charge_stage.setString(23, "N");																	// AMEND_ON_ORDER_YN
								cstmt_bl_ext_charge_stage.setString(24, "N");																		// REGISTER_ON_ORDER_YN
								cstmt_bl_ext_charge_stage.setString(25, ((String)tabData.get("login_by_id")));										// USER
								cstmt_bl_ext_charge_stage.setString(26, ((String)tabData.get("login_at_ws_no")));									// WS_NO
								cstmt_bl_ext_charge_stage.registerOutParameter( 27,  Types.VARCHAR ) ;
								cstmt_bl_ext_charge_stage.registerOutParameter( 28,  Types.VARCHAR ) ;
								cstmt_bl_ext_charge_stage.setString(29, null);//IN072922
								cstmt_bl_ext_charge_stage.setString(30, null);	//IN072922
								cstmt_bl_ext_charge_stage.execute();
								error_message 		= checkForNull(cstmt_bl_ext_charge_stage.getString(27),"");										// P_ERROR_MESSAGE
								charge_type_code 	= checkForNull(cstmt_bl_ext_charge_stage.getString(28),"");										// P_charge_type_code
								if(! error_message.equals(""))
								{

									errcount++;
									result = false;
									map.put( "result", new Boolean( false) ) ;
									connection.rollback();
									map.put( "message", error_message) ;
									error_messages.append(error_message);
								}
							}
							if(errcount==0)
							{
								/*Added by Uma on 1/19/2010 for IN017420*/
								if((cont_order_yn.equalsIgnoreCase("CR") || cont_order_yn.equalsIgnoreCase("DR")))
								{  
									cstmt_frequency.clearParameters();
									cstmt_frequency.setString(1, p_new_order_id); 					// ORDER_ID
									cstmt_frequency.setString(2, frequency_val);							// FREQUENCY_CODE
									cstmt_frequency.setString(3, duration_value);						// DURATION_VALUE
									cstmt_frequency.setString(4, p_start_date_time);						// START_DATE_TIME
									cstmt_frequency.setString(5, order_category); 						// ORDER_CATEGORY
									cstmt_frequency.setString(6, (String)tabData.get("p_patient_class")); // PATIENT_CLASS
									cstmt_frequency.setString(7, cont_order_yn); 							// PASSED DR || CR
									// If it is an amend order pass as 'Y' other wise pass 'N' for New Orders
									cstmt_frequency.setString(8, "N"); 							// Pass it 'N' as New Order
									cstmt_frequency.execute();
								} // End of if cont_order_yn
							}
							/*Ends Here*/

							if(errcount==0)
							{	
								/*Added by Uma on 1/19/2010 for IN017420 to cancel all the billing orders*/
								if(!((cont_order_yn.equalsIgnoreCase("CR") || cont_order_yn.equalsIgnoreCase("DR"))&&(future_order_charge_later_yn.equalsIgnoreCase("Y"))))
								{
									/*Ends Here*/									
									cstmt_billing_ext.clearParameters();
									cstmt_billing_ext.setString(1,((String)tabData.get("login_facility_id"))); 	// FACILITY_ID
									cstmt_billing_ext.setString(2,((String)tabData.get("p_patient_id")));			// PATIENT_ID
									if( (((String)tabData.get("p_patient_class")).equalsIgnoreCase("IP")) || (((String)tabData.get("p_patient_class")).equalsIgnoreCase("EA")) )
										cstmt_billing_ext.setString(3, "I");										// EPISODE_TYPE
									else if( ((String)tabData.get("p_patient_class")).equalsIgnoreCase("DC")) 
										cstmt_billing_ext.setString(3, "D");										// EPISODE_TYPE
									else if( ((String)tabData.get("p_patient_class")).equalsIgnoreCase("EM")) 
									cstmt_billing_ext.setString(3, "E");										// EPISODE_TYPE
									else if( ((String)tabData.get("p_patient_class")).equalsIgnoreCase("OP")) 
										cstmt_billing_ext.setString(3, "O");										// EPISODE_TYPE
									else 
										cstmt_billing_ext.setString(3, "R");										// EPISODE_TYPE
									cstmt_billing_ext.setString(4,  checkForNull(((String)tabData.get("p_episode_id")),"0"));	// EPISODE_ID
									cstmt_billing_ext.setString(5,  checkForNull(((String)tabData.get("p_episode_visit_num")),"0")); // VISIT_NUM
									cstmt_billing_ext.setString(6, p_new_order_id);  
									//IN071315 Starts
									cstmt_billing_ext.setString(7,  "OR"); //IN072922		// SUBS_MODULE_ID
									/*if("Y".equals(p_called_from_ca)){
										cstmt_billing_ext.setString(7,"OR|CA");
										}
									else{
										cstmt_billing_ext.setString(7,"OR|OR");
									}*/
									//IN071315 Ends
									cstmt_billing_ext.setString(8,  null); 	// SUBS_REGN_NUM
									cstmt_billing_ext.setString(9,  ((String)tabData.get("login_by_id"))); 		// USER
									cstmt_billing_ext.setString(10, ((String)tabData.get("login_at_ws_no"))); 	// WS_NO
									cstmt_billing_ext.registerOutParameter( 11,  Types.VARCHAR ) ;
									cstmt_billing_ext.registerOutParameter( 12,  Types.VARCHAR ) ;
									cstmt_billing_ext.registerOutParameter( 13,  Types.VARCHAR ) ;
									cstmt_billing_ext.execute();
									err_code 		= checkForNull(cstmt_billing_ext.getString(11),"");  // ERR_CODE
									sys_message_id 		= checkForNull(cstmt_billing_ext.getString(12),"");  // SYS_MESSAGE_ID
									err_message		= checkForNull(cstmt_billing_ext.getString(13),"");  // ERROR_TEXT

									if(!err_code.equals("") && !err_code.equals("10"))// && !err_message.equals(""))
									{
										errcount++;
										result = false;
										map.put( "result", new Boolean( false) ) ;
										connection.rollback();
										map.put( "message", err_code) ;
										error_messages.append(err_code);
									} // End of if !err_message
									else if(!sys_message_id.equals("") )  //Query from the sm_message and display the message
									{
										errcount++;
										result = false;
										map.put( "result", new Boolean( false) ) ;
										connection.rollback();
										map.put( "message", sys_message_id) ;
										error_messages.append(sys_message_id);
									}
									else if(!err_message.equals("") )  //Query from the sm_message and display the message
									{
										errcount++;
										result = false;
										map.put( "result", new Boolean( false) ) ;
										connection.rollback();
										map.put( "message", err_message) ;
										error_messages.append(err_message);
									}
									/*Added by Uma on 1/19/2010 for IN017420 to cancel all the billing orders*/
								}
								/*Ends Here*/
							} 
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}//IN039096 - Start
					//else if(bill_yn.equalsIgnoreCase("N") && !billing_package_ref.equals(""))//IN039096.1
					if(!billing_package_ref.equals(""))
					{
						try
						{
							if(errcount==0)
							{
								pstmt11.clearParameters();
								pstmt11.setString(1,(String)p_new_order_id.trim());
								pstmt11.setString(2,(String)p_new_order_id.trim());
								pstmt11.setString(3,(String)tabData.get("p_encounter_id"));
								pstmt11.setString(4,(String)tabData.get("login_by_id"));
								pstmt11.setString(5,(String)tabData.get("login_at_ws_no"));
								pstmt11.setString(6,login_facility_id);
								pstmt11.setString(7,(String)order_id.trim());		
								result_dtl = pstmt11.executeUpdate();
								if(result_dtl > 0 ) 
									result = true; 
								else 
									result = false;
								if(! error_message.equals(""))
								{
									
									errcount++;
									result = false;
									map.put( "result", new Boolean( false) ) ;
									connection.rollback();
									map.put( "message", error_message) ;
									error_messages.append(error_message);
								}
							}
					
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					} //IN039096 - end
					
					closeResultSet(resultSet);
				}

				if(errcount==0) 
				{
					connection.commit() ;
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", "RECORD_MODIFIED" ) ;
				}
				else
				{
					map.put( "result", new Boolean( false) ) ;
					connection.rollback();
					if(error_messages.toString().length()>0)
					{
						ConData = new TreeMap();
						map.put( "message" , error_messages.toString());
					}
					else
					{
						map.put( "message" , "Operation failure ..." ) ;
					}
					error_messages.setLength(0);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		finally
		{
			try
			{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement(pstmt1);
				closeStatement(pstmt2);
				closeStatement(pstmt3);
				closeStatement(pstmt);
				closeStatement(cont_ord_ind_pstmt);
				closeStatement(pstmt5);
				closeStatement(pstmt6);
				closeStatement(pstmt7);
				closeStatement(pstmt8);
				closeStatement(pstmt9);
				closeStatement(pstmt11);//IN039096
				closeStatement( cstmt_bl_ext_charge_stage);
				closeStatement( cstmt_billing_ext);
				closeStatement(cstmt_frequency);
			}
			catch(Exception ee) 
			{
				ee.printStackTrace() ;
			}
		}
		return map;
	}
	/*Ends Here*/
	
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap modify( HashMap tabData, HashMap sqlMap ) 
	{
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;
		return map ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap delete( HashMap tabData, HashMap sqlMap ) 
	{
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;
		return map ;
	}

	private String checkForNull( String val)
	{
		String dflt_val="";

		if ( val == null || val.equals(""))
		{
			try
			{
				dflt_val =  java.net.URLEncoder.encode("^^","UTF-8");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			return dflt_val;
		}
		else
			return val;
    }

	private String checkForNull( String val, String dflt_val)
	{
		if ( val == null || val.equals(""))	
		{	
			try
			{
				val= dflt_val;	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return val;
	}	
/**
* @ejb.interface-method
*	 view-type="both"
*/
	private String getStatusCode(Connection connection, String order_id, String query)throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String order_status_code= "";
		
		try
		{
			pstmt = connection.prepareStatement(query) ;
			pstmt.setString( 1, order_id);		 
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) 
			{
				order_status_code= resultSet.getString( 1 )  ; //order_status_code
				order_status_code = (order_status_code==null)?"":order_status_code;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement(pstmt);
		}	
		return order_status_code;
	}

	/*Added by Uma on 1/19/2010 for IN017420 to cancel all the billing orders*/
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
	//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 15/02/2013
	//Start	
	private String UpdateIPBookingOrder(Connection con,String order_id,String order_line_no, String login_by_id,String login_at_ws_no,String login_facility_id) throws Exception
		{
		PreparedStatement pstmt=null;
		PreparedStatement upd_pstmt=null;
		ResultSet rset=null;
		String result="";
		try
			{
			pstmt=con.prepareStatement("select count(1) as cnt from ip_booking_list where order_id=? and order_line_no = ?  and patient_id = (select patient_id from or_order where  order_id = ? and rownum=1) ");
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			pstmt.setString(3,order_id);
			rset=pstmt.executeQuery();
			if(rset.next())
				{
				int cnt=rset.getInt("cnt");
				if(cnt>=1)
					{
					upd_pstmt=con.prepareStatement("UPDATE IP_BOOKING_LIST SET ORDER_ID=NULL ,ORDER_LINE_NO = NULL , OPER_CODE=NULL ,OPER_SHORT_DESC=NULL ,PREF_SURG_DATE=NULL,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_DATE=SYSDATE,MODIFIED_FACILITY_ID=?  WHERE ORDER_ID=? and ORDER_LINE_NO = ?");
					upd_pstmt.setString(1,login_by_id);
					upd_pstmt.setString(2,login_at_ws_no);
					upd_pstmt.setString(3,login_facility_id);
					upd_pstmt.setString(4,order_id);
					upd_pstmt.setString(5,order_line_no);
					int upd_cnt=upd_pstmt.executeUpdate();
					System.out.println("ORCancelDiscontinueOrderManager.java-----upd_cnt------->"+upd_cnt);
					upd_pstmt.close();	
					}
				}
			pstmt.close();
			rset.close();
			}
		catch(Exception e)	
			{
			result=e.toString();
			System.out.println("Exception occurred while Cancelling the Orders done against the IP Booking : "+e);
			e.printStackTrace();
			}
		finally
			{
			try
				{if(upd_pstmt!=null)
				upd_pstmt.close();
				if(pstmt!=null)
				pstmt.close();
				}
			catch(Exception e)	{}
			}
		return result;	
		}
	//End	
}
