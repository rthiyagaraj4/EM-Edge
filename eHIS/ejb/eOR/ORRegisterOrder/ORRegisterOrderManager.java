/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
18/01/2013		IN037372		Ramesh G		Oracle 11g Weblogic compilation.
23/10/2019    	IN071315	    Nijitha S  		GHL-CRF-0607
--------------------------------------------------------------------------------------------------------------------
*/
package eOR.ORRegisterOrder;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import java.io.*;
//import oracle.sql.CLOB; //[IN037372]

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORRegisterOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORRegisterOrder"
*	local-jndi-name="ORRegisterOrder"
*	impl-class-name="eOR.ORRegisterOrder.ORRegisterOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORRegisterOrder.ORRegisterOrderLocal"
*	remote-class="eOR.ORRegisterOrder.ORRegisterOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORRegisterOrder.ORRegisterOrderLocalHome"
*	remote-class="eOR.ORRegisterOrder.ORRegisterOrderHome"
*	generate= "local,remote"
*
*
*/

public class ORRegisterOrderManager extends OrEJBSessionAdapter 
{
   // SessionContext context ;
	PreparedStatement pstmt = null ;

	StringBuffer traceVals = new StringBuffer();
	String p_user			= "";
	String p_ws_no			= "";
	String p_facility_id	= "";

	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap insert( HashMap tabData, HashMap sqlMap ) 
	{

		Connection connection = null ;
		//StringBuffer messages = new StringBuffer() ; //Checkstyle

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;


		try 
		{
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;

			map = updateValues(connection, tabData, sqlMap);

		 } 
		 catch( Exception e ) 
		 {
			traceVals.append("Exception if any -- "+e);

			try 
			{
				connection.rollback() ;
			} 
			catch ( Exception ee ) 
			{
				//messages.append( ee.getMessage() ) ; Checkstyle
				traceVals.append("Exception if any -- "+ee.getMessage());
			}

			//messages.append( e.getMessage() ) ; //Checkstyle
			e.printStackTrace() ;
		} 
		finally 
		{
			try 
			{
				if ( pstmt != null ) 
				{
					pstmt.close() ;
				}
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

		//map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}


	public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap)
	{

		//StringBuffer messages				= new StringBuffer() ; //Checkstyle
		PreparedStatement pstmt1 			= null;
		PreparedStatement pstmt2 			= null;
		PreparedStatement pstmt3 			= null;
		PreparedStatement pstmt4 			= null;
		PreparedStatement pstmt5 			= null;
		PreparedStatement pstmt6 			= null;
		PreparedStatement pstmt7 			= null;
		PreparedStatement pstmt8 			= null;
		PreparedStatement pstmt_set_status 	= null;
		CallableStatement cstmt				= null;
		String order_set_id					="";
		String order_set_bill_yn			="N";
		String order_set_status_query	    = "";
		String update_order_set_status		="";
		String update_order_set_line_status	="";
		String order_set_status_type		="";
		ResultSet resultSet 				= null;
		ResultSet billResultSet 			= null;
		ResultSet resultset_status 			= null;
		HashMap map							= new HashMap() ;

		//String message 				= "";

		traceVals.append("====rconnection * >"+connection);
		int count =0;

		count = Integer.parseInt((String)tabData.get("totalCount"));
		

		traceVals.append("====count *>"+count);

		String[] updt_vals					= new String[11];
		String view_by						= "";
		String cont_order_ind			    = "";
		HashMap bill_dtls                   = new HashMap();
		int result							= 0;
		try
		{		

			cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") +" }");
			pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT") ) ;
			pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT_FREQ_EXPL") ) ;
			pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT_LINE") ) ;
			pstmt2 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_LINE_CHK_OTHER_ORDER") ) ;
			pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_LINE_CHK_OTHER_ORDER_UPDT") ) ;
			pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT_HDR_FREQ_EXPL") ) ;
			pstmt7 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT_HDR") ) ;
			order_set_status_query = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE");
			update_order_set_status = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS");
			update_order_set_line_status = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS");
			String bill_sql = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN");
			pstmt8 = connection.prepareStatement(bill_sql) ;
			pstmt_set_status = connection.prepareStatement("select order_status from or_order where order_id=?");

			//Billing related parameters - start
			String p_order_id					= "";
			String p_order_line_num				= "";
			String p_mode						= "REG";
			String p_error_message				= "";
			String p_bill_yn					= "";
			//String mod_physician_id             = ""; //Checkstyle
		
			//Billing related parameters - end

			for(int i=0; i<count; i++)
			{
				updt_vals = (String[])tabData.get("data"+i);
				view_by   = (String)tabData.get("view_by"+i);
				cont_order_ind   = (String)tabData.get("cont_order_ind"+i);
				bill_dtls   = (HashMap)tabData.get("bill_dtls"+i);
				System.out.println("bill_dtls 193"+bill_dtls);

				p_order_id			= updt_vals[1].trim();
				p_order_line_num	= updt_vals[2].trim();
				p_facility_id		= updt_vals[3].trim();
				p_user				= updt_vals[4].trim();
				p_ws_no				= updt_vals[5].trim();
			
				pstmt8.setString(1, p_order_id);
				pstmt8.setString(2, p_order_line_num);
				
				billResultSet = pstmt8.executeQuery();
				if (billResultSet.next()) 
				{
					p_bill_yn	= billResultSet.getString("bill_yn");
				}
				closeResultSet(billResultSet);				
				
				//Billing Procedure - Start
				//cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG") +" }");

				traceVals.append("====SQLLLLLLLLL : *>"+(String)sqlMap.get("SQL_OR_REGISTER_ORDER_LINE_CHK_OTHER_ORDER"));
				traceVals.append("====view_by*>"+view_by);

				if((view_by.trim()).equals("H"))
				{


					traceVals.append("====comes here*inside header >" +updt_vals[0]+" = " + updt_vals[1]);
					cont_order_ind = cont_order_ind.trim();

					//pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT") ) ;
					pstmt4.clearParameters();
					pstmt4.setString( 1, updt_vals[0].trim() ) ;
					pstmt4.setString( 2, updt_vals[6].trim() ) ;
					pstmt4.setString( 3, p_user ) ;
					pstmt4.setString( 4, p_ws_no ) ;
					pstmt4.setString( 5, p_facility_id ) ;
					pstmt4.setString( 6, updt_vals[1].trim() ) ;

					try
					{
						result = pstmt4.executeUpdate();
					}
					catch(Exception ex)
					{
						ex.printStackTrace();

						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						map.put( "message","pstmt4 Failed" ) ;
						return map;
					}
					traceVals.append("====first result *>"+result);

					if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") )
					{

						//pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT_FREQ_EXPL") ) ;
						pstmt6.clearParameters();
						pstmt6.setString( 1, updt_vals[0].trim() ) ;
						pstmt6.setString( 2, updt_vals[6].trim() ) ;
						pstmt6.setString( 3, p_user ) ;
						pstmt6.setString( 4, p_ws_no ) ;
						pstmt6.setString( 5, p_facility_id ) ;
						pstmt6.setString( 6, updt_vals[1].trim() ) ;

						try
						{
							pstmt6.executeUpdate();
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message","pstmt6 Failed" ) ;
							return map;
						}
						
					}

					if(result >=1)
					{
						if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") )
						{
							//pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT_HDR_FREQ_EXPL") ) ;
							pstmt5.clearParameters();
							pstmt5.setString( 1, updt_vals[0].trim()  ) ;
							pstmt5.setString( 2, p_user ) ;
							pstmt5.setString( 3, p_ws_no ) ;
							pstmt5.setString( 4, p_facility_id ) ;
							pstmt5.setString( 5, updt_vals[1].trim()  ) ;

							try
							{
								pstmt5.executeUpdate();
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								map.put( "message","pstmt5 failed" ) ;
								return map;
							}
						}
						//else
						{

							//pstmt7 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT_HDR") ) ;
							pstmt7.clearParameters();
							pstmt7.setString( 1, updt_vals[0].trim()  ) ;
							pstmt7.setString( 2, p_user ) ;
							pstmt7.setString( 3, p_ws_no ) ;
							pstmt7.setString( 4, p_facility_id ) ;
							pstmt7.setString( 5, updt_vals[1].trim()  ) ;

							try
							{
								pstmt7.executeUpdate();
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
								map.put( "result", new Boolean( false ) ) ;
								connection.rollback();
								map.put( "message","pstmt7 Failed" ) ;
								return map;
							}
						}

						//pstmt5.setString( 1, updt_vals[0].trim()  ) ;
						//pstmt5.setString( 2, updt_vals[1].trim()  ) ;

						//pstmt5.executeUpdate();
						//result = pstmt5.executeUpdate();
					}
					traceVals.append("====result *>"+result);
				}
				else if ((view_by.trim()).equals("L"))
				{


					traceVals.append("====comes here*inside Line>"+updt_vals[0]+" = "+updt_vals[1] +" = "+ updt_vals[2]);
					//pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_UPDT_LINE") ) ;
					pstmt1.clearParameters();
					pstmt1.setString( 1, updt_vals[0].trim() ) ;
					pstmt1.setString( 2, p_user ) ;
					pstmt1.setString( 3, p_ws_no ) ;
					pstmt1.setString( 4, p_facility_id ) ;
					pstmt1.setString( 5, updt_vals[1].trim() ) ;
					pstmt1.setString( 6, updt_vals[2].trim() ) ;


					try
					{					
						result = pstmt1.executeUpdate();
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						map.put( "message","pstmt1 Failed" ) ;
						return map;
					}
					traceVals.append("====comes here* toooo>"+updt_vals[1]+"< = >"+updt_vals[2] +"<result : "+result);
					//==============================


					//pstmt2 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_LINE_CHK_OTHER_ORDER") ) ;
					pstmt2.clearParameters();
					int no_of_recs = 0;
					pstmt2.setString( 1, updt_vals[1].trim() ) ;
					pstmt2.setString( 2, updt_vals[2].trim() ) ;

					try
					{
				 		resultSet= pstmt2.executeQuery();

						if(resultSet.next())
							no_of_recs = resultSet.getInt(1);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						map.put( "message","pstmt2 Failed" ) ;
						return map;
					}
					finally
					{
						closeResultSet( resultSet ) ;
					}

//					resultSet.next();
//					no_of_recs = resultSet.getInt(1);
					//==============================
					traceVals.append("====no_of_recs*>" +no_of_recs+"<sdf");

					if(no_of_recs>=1) 
					{
						result=0;
						//pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_LINE_CHK_OTHER_ORDER_UPDT") ) ;
						pstmt3.clearParameters();
						pstmt3.setString( 1, updt_vals[0].trim()  ) ;
						pstmt3.setString( 2, updt_vals[6].trim()  ) ;
						pstmt3.setString( 3, p_user ) ;
						pstmt3.setString( 4, p_ws_no ) ;
						pstmt3.setString( 5, p_facility_id ) ;
						pstmt3.setString( 6, updt_vals[1].trim()  ) ;

						try
						{
							result = pstmt3.executeUpdate();
						}						
						catch(Exception ex)
						{
							ex.printStackTrace();
							map.put( "result", new Boolean( false ) ) ;
							connection.rollback();
							map.put( "message","pstmt3 Failed" ) ;
							return map;
						}
					}

					traceVals.append("====view_by fourth is L here*>" +updt_vals[2]+"<sdf");
				}				

				order_set_id=updt_vals[9].trim();
				if(order_set_id==null)order_set_id="";
				order_set_bill_yn=updt_vals[10].trim();
				if(order_set_bill_yn==null)order_set_bill_yn="";
			
				//if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&(order_set_status_type_code.equalsIgnoreCase("25"))||(order_set_bill_yn.equalsIgnoreCase("N")))
				//{
				if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
				{
				  pstmt_set_status.setString(1,order_set_id);
				  resultset_status = pstmt_set_status.executeQuery();
				  while(resultset_status.next())
				  {
					 order_set_status_type = resultset_status.getString("order_status");
				  }
				  closeStatement(pstmt_set_status);
				  closeResultSet(resultset_status);	
				}
						
				  if(order_set_status_type==null) order_set_status_type="";
				   //if(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((order_set_status_type.equalsIgnoreCase("RG"))))||((order_set_bill_yn.equalsIgnoreCase("N"))&&(order_set_id.equals(""))))
				  if(((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((order_set_status_type.equalsIgnoreCase("RG"))))||((order_set_bill_yn.equalsIgnoreCase("N"))))
				  {
					cstmt.clearParameters();
					cstmt.setString(1, p_facility_id); 					// P_FACILITY_ID
					if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals("")))&&((order_set_status_type.equalsIgnoreCase("RG"))))
					{

						cstmt.setString(2, order_set_id);						// P_ORDER_ID
						cstmt.setString(3, "1");				// P_ORDER_LINE_NUM
					}
					else
					{

						cstmt.setString(2, p_order_id);						// P_ORDER_ID
						cstmt.setString(3, p_order_line_num);				// P_ORDER_LINE_NUM
					}

					cstmt.setString(4, p_mode); 						// P_MODE
					cstmt.setString(5, p_user);							// P_USER
					cstmt.setString(6, p_ws_no);						// P_WS_NO
					cstmt.registerOutParameter( 7,  Types.VARCHAR ) ; 	// P_BILL_YN
					cstmt.registerOutParameter( 8,  Types.VARCHAR ) ; 	// P_ERROR_MESSAGE
					cstmt.setString(9, "OR");//IN071315					
					try
					{
						cstmt.execute();
					}
					catch(Exception ex)
					{

						ex.printStackTrace();

						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						map.put( "message","Billin Procedure Failed" ) ;
						return map;
					}
					p_error_message	= cstmt.getString(8);  // message

					if(p_error_message!=null && !p_error_message.equals(""))
					{
						result = 0;
					}
					else 
					{
						result = 1;
					}

					if ( result < 1 ) 
					{

						traceVals.append("====ROLLBACK");
						map.put( "result", new Boolean( false ) ) ;
						connection.rollback();
						map.put( "message",p_error_message ) ;
						return map;
					}
				}
				//Billing Procedure - End
			//}

			traceVals.append("====result*>"+result);

			if ( result < 1 ) 
			{
				traceVals.append("====ROLLBACK");
				map.put( "result", new Boolean( false ) ) ;
				connection.rollback();
				map.put( "message", "Operation failure ..." ) ;
			} 
			else  
			{


				traceVals.append("====COMMIT");
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "RECORD_MODIFIED" ) ;
				//messages.append( "RECORD_MODIFIED" ) ;
				//messages.append( "Operation Completed Successfully..." ) ;
			}


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
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeStatement( pstmt3 ) ;
				closeStatement( pstmt4 ) ;
				closeStatement( pstmt5 ) ;
				closeStatement( pstmt6 ) ;
				closeStatement( pstmt7 ) ;
				closeStatement( pstmt8 ) ;
				closeStatement( pstmt_set_status ) ;
				closeStatement(cstmt);
			
			}
			catch(Exception ee) 
			{
				ee.printStackTrace();

			}
		}

		//map.put( "message", messages.toString() ) ;
		return map;
	}

	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify( HashMap tabData, HashMap sqlMap ) {

		/*StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;

		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;*/

		Connection connection = null ;
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;


		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;
			map = updateModifyValues(connection, tabData, sqlMap);

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
					connection = null ;
				}
			} catch ( Exception fe ) {

				fe.printStackTrace() ;
			}
		}

		//map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}

	public HashMap updateModifyValues(Connection connection, HashMap tabData, HashMap sqlMap)
	{
		StringBuffer messages = new StringBuffer() ;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;
		PreparedStatement pstmt4 	= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt_clob 	= null;
		PreparedStatement pstmt_order 	= null;
		ResultSet resultSet				= null;
		HashMap map = new HashMap() ;
		Hashtable printVal = new Hashtable();
		java.io.BufferedWriter	bw	= null;
	//	String message 				= "";
		int result = 0;
		//int printCount	= 0;
		String srl_no = "";
		//String[] updt_data = new String[6];

		
		try
		{
			String order_id 				= (String)tabData.get("order_id");
			String order_line_num			= (String)tabData.get("order_line_num");
			if(order_line_num ==null) order_line_num = "";
			String order_type_code			= (String)tabData.get("order_type_code");
			String patient_id 				= (String)tabData.get("patient_id");
			String patient_class			= (String)tabData.get("patient_class");
			String order_catalog_code		= (String)tabData.get("order_catalog_code");
			String order_catalog_desc		= (String)tabData.get("order_catalog_desc");
			String encounter_id				= (String)tabData.get("encounter_id");
			String priority					= (String)tabData.get("priority");
			String performing_facility		= (String)tabData.get("performing_facility");
			String performing_location		= (String)tabData.get("performing_location");
		//	String performing_location_type		= (String)tabData.get("performing_location_type");
			String function_from			= (String)tabData.get("function_from");
			String ref_facility_id			= (String)tabData.get("ref_facility_id");
			String ref_date_time			= (String)tabData.get("ref_date_time");
			String ref_sent_pract_id		= (String)tabData.get("ref_sent_pract_id");
			String ref_sent_remarks			= (String)tabData.get("ref_sent_remarks");
			String ref_report_pract_id		= (String)tabData.get("ref_report_pract_id");
			String ref_report_date_time		= (String)tabData.get("ref_report_date_time");
			String ref_recieved_date_time	= (String)tabData.get("ref_recieved_date_time");
			String ref_recieved_pract_id	= (String)tabData.get("ref_recieved_pract_id");
			String ref_recieved_remarks		= (String)tabData.get("ref_recieved_remarks");
			String ref_form_content			= (String)tabData.get("ref_form_content");
			String ref_form_id				= (String)tabData.get("ref_form_id");
			//String location_type			= (String)tabData.get("location_type");
			//String locn						= (String)tabData.get("locn");
			String source_type				= (String)tabData.get("source_type");
			String source_code				= (String)tabData.get("source_code");
			String login_facility_id		= (String)tabData.get("login_facility_id");
			String login_by_id				= (String)tabData.get("login_by_id");
			String login_at_ws_no			= (String)tabData.get("login_at_ws_no");
			String sql						=  "";

			if (function_from.equals("CHANGE_PERFORM_LOCN")) 
			{
				pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_PERFROM_LOCN_UPDATE") ) ;
				pstmt1.setString(1, performing_facility);
				pstmt1.setString(2, performing_location);
				pstmt1.setString(3, order_id);
				result = pstmt1.executeUpdate();
 				closeStatement( pstmt1 ) ;
			} 
			else if (function_from.equals("SENT_OUT")) 
			{
				sql					=  (String)sqlMap.get("SQL_OR_REGISTER_ORDER_SENT_OUT_DTL_UPDATE");
				if(!order_line_num.equals(""))
				{
					sql = sql.replace ( "&&ORDERLINE##"," and order_line_num = ?" );
				}
				else
				{
					sql = sql.replace ( "&&ORDERLINE##"," ");
				}
				pstmt2 = connection.prepareStatement( sql ) ;
				pstmt2.setString( 1 , "98");
				pstmt2.setString( 2 , login_by_id) ;
				pstmt2.setString( 3 , login_at_ws_no);
				pstmt2.setString( 4 , login_facility_id ) ;
				pstmt2.setString( 5 , ref_facility_id);
				pstmt2.setString( 6 , ref_date_time);
				pstmt2.setString( 7 , ref_sent_pract_id);
				pstmt2.setString( 8 , ref_sent_remarks);
				pstmt2.setString( 9 , order_id);
				if(!order_line_num.equals(""))
				{
					pstmt2.setString( 10 , order_line_num);
				}
				result = pstmt2.executeUpdate();
				
				closeStatement( pstmt2 ) ;
				
				String status_code_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_STATUS_CODE");
				String p_order_status_code =(String) getStatusCode(connection,order_id,status_code_sql);


				if(!p_order_status_code.equals("SE"))
				{
					pstmt_order = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS"));
					pstmt_order.clearParameters();
					pstmt_order.setString( 1, p_order_status_code ) ;
					pstmt_order.setString( 2, order_id.trim()) ;
					pstmt_order.executeUpdate() ;	
					
					closeStatement( pstmt_order ) ;

				}
				else
				{

					pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_SENT_OUT_HDR_UPDATE") ) ;
					pstmt3.setString(1, "98");
					pstmt3.setString(2, ref_facility_id);
					pstmt3.setString(3, ref_date_time);
					pstmt3.setString(4, ref_sent_pract_id);
					pstmt3.setString(5, ref_sent_remarks);
					pstmt3.setString(6, order_id.trim());
					result = pstmt3.executeUpdate();				

					closeStatement( pstmt3 ) ;
				}
				
				
				if(result>0)
				{
					pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REFUSAL_ORDER_SRL_NO") ) ;
					pstmt4.setString( 1, patient_id ) ;
					resultSet = pstmt4.executeQuery() ;

					while ( resultSet != null && resultSet.next() ) 
					{
						srl_no= resultSet.getString( "SRL_NO" )  ;
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt4 ) ;

					if(srl_no== null)
						srl_no = "1";
					if(ref_form_content==null) ref_form_content="";

					pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_INSERT_OR_REFUSAL_ORDERABLE") ) ;

					pstmt.setString( 1, patient_id ) ;
					pstmt.setString( 2, srl_no ) ;
					pstmt.setString( 3, login_facility_id ) ;
					pstmt.setString( 4, encounter_id ) ;
					pstmt.setString( 5, patient_class ) ;
					pstmt.setString( 6, order_id ) ;
					pstmt.setString( 7,	order_line_num ) ;
					pstmt.setString( 8,	order_catalog_code  ) ;
					pstmt.setString( 9, order_catalog_desc ) ;
					pstmt.setString( 10, login_by_id) ;
					pstmt.setString( 11, login_at_ws_no);
					pstmt.setString( 12, login_facility_id ) ;
					pstmt.setString( 13, login_by_id) ;
					pstmt.setString( 14, login_at_ws_no);
					pstmt.setString( 15, login_facility_id ) ;
					pstmt.setString( 16, ref_form_id ) ;
					pstmt.setString( 17, ref_date_time ) ;
					pstmt.setString( 18, ref_sent_remarks ) ;
					//pstmt.setString( 20, ref_form_content ) ;
								
					result = pstmt.executeUpdate();
				
					pstmt_clob = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_FORM_UPDATE_CLOB") ) ;

					pstmt_clob.setString( 1, patient_id ) ;
					pstmt_clob.setString( 2, srl_no ) ;
					//pstmt_clob.setString( 3, order_line_num ) ;

					resultSet = pstmt_clob.executeQuery() ;

					while ( resultSet != null && resultSet.next() ) 
					{
					//Web logic Conversion -- [IN037372] Start.
						//CLOB clob = (CLOB)resultSet.getClob("referral_form_content");
						//bw   = new BufferedWriter(clob.getCharacterOutputStream());
						
						java.sql.Clob clob = (java.sql.Clob)resultSet.getClob("referral_form_content");
						bw   = new BufferedWriter(clob.setCharacterStream(0));
					//Web logic Conversion -- [IN037372] End.
						bw.write(ref_form_content,0,ref_form_content.length());
						bw.flush();
						bw.close();
					}
					printVal.put("order_id",order_id);
					printVal.put("order_line_num",order_line_num);
					printVal.put("patient_id",patient_id);
					printVal.put("srl_no",srl_no);
					printVal.put("patient_class",patient_class);
					printVal.put("order_type_code",order_type_code);
					printVal.put("priority",priority);
					printVal.put("source_type",source_type);
					printVal.put("source_code",source_code);
					printVal.put("facility_id",login_facility_id);
					//printCount++;

				}	
			} 
			else if (function_from.equals("RECEIVE_RESULT")) 
			{

				sql					=  (String)sqlMap.get("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_DTL_UPDATE");
				if(!order_line_num.equals(""))
				{
					sql = sql.replace ( "&&ORDERLINE##"," and order_line_num = ?" );
				}
				else
				{
					sql = sql.replace ( "&&ORDERLINE##"," ");
				}
				pstmt2 = connection.prepareStatement( sql ) ;
				pstmt2.setString(1, "25");
				pstmt2.setString(2, "25");
				pstmt2.setString(3, login_by_id) ;
				pstmt2.setString(4, login_at_ws_no);
				pstmt2.setString(5, login_facility_id ) ;
				pstmt2.setString(6, ref_report_pract_id);
				pstmt2.setString(7, ref_report_date_time);
				pstmt2.setString(8, ref_recieved_date_time);
				pstmt2.setString(9, ref_recieved_pract_id);
				pstmt2.setString(10, ref_recieved_remarks);
				pstmt2.setString(11, order_id);
				if(!order_line_num.equals(""))
				{
					pstmt2.setString( 12 , order_line_num);
				}
				result = pstmt2.executeUpdate();
				
				closeStatement( pstmt2 ) ;

				String status_code_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_STATUS_CODE");
				String p_order_status_code =(String) getStatusCode(connection,order_id,status_code_sql);

				if(!p_order_status_code.equals("RG"))
				{
					pstmt_order = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS"));
					pstmt_order.clearParameters();
					pstmt_order.setString( 1, p_order_status_code ) ;
					pstmt_order.setString( 2, order_id.trim()) ;
					pstmt_order.executeUpdate() ;	
					
					closeStatement( pstmt_order ) ;

				}
				else
				{

					pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_REGISTER_ORDER_RECEIVE_RESULT_HDR_UPDATE") ) ;
					pstmt3.setString(1, "25");
					pstmt3.setString(2, "25");
					pstmt3.setString(3, ref_report_pract_id);
					pstmt3.setString(4, ref_report_date_time);
					pstmt3.setString(5, ref_recieved_date_time);
					pstmt3.setString(6, ref_recieved_pract_id);
					pstmt3.setString(7, ref_recieved_remarks);
					pstmt3.setString(8, order_id);
					result = pstmt3.executeUpdate();

					closeStatement( pstmt3 ) ;
				}
			}

			traceVals.append("====result*>"+result);

			if ( result < 1 ) 
			{
				traceVals.append("====ROLLBACK");
				map.put( "result", new Boolean( false ) ) ;
				connection.rollback();
				map.put( "message", "Operation failure ..." ) ;

			} 
			else  
			{
				traceVals.append("====COMMIT");
				connection.commit() ;
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "Operation Completed Successfully..." ) ;
				messages.append( "RECORD_MODIFIED" ) ;
				map.put("printVal",printVal);
				//messages.append( "Operation Completed Successfully..." ) ;
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
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeStatement( pstmt3 ) ;
				closeStatement( pstmt4 ) ;
				closeStatement(pstmt);
				closeStatement(pstmt_clob);
			}
			catch(Exception ee) 
			{
				ee.printStackTrace();
			}
		}

		map.put( "message", messages.toString() ) ;
		return map;
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
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}
/**Added by Uma on 7/8/2010 for IN022536
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
}
