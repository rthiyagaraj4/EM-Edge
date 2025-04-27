/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
14/03/2014     IN041644		Nijitha S											Prescription Authorization of Drugs Based on Rules										
25/03/2014	   IN048075		Nijitha S											Bru-Hims-CRF-385											
28/03/2014	   IN048202		Nijitha S											Bru-Hims-CRF-385											
01/04/2014	   IN048252		Nijitha S											Bru-Hims-CRF-385											
23/10/2019    IN071315	    Nijitha S  		   23/10/2019  		Ramesh G		GHL-CRF-0607											
-------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR.ORAuthoriseOrder;

import java.rmi.* ;
import java.text.DateFormat;//IN041644
import java.text.SimpleDateFormat;//IN041644
import java.util.* ;
import java.sql.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORAuthoriseOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORAuthoriseOrder"
*	local-jndi-name="ORAuthoriseOrder"
*	impl-class-name="eOR.ORAuthoriseOrder.ORAuthoriseOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORAuthoriseOrder.ORAuthoriseOrderLocal"
*	remote-class="eOR.ORAuthoriseOrder.ORAuthoriseOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORAuthoriseOrder.ORAuthoriseOrderLocalHome"
*	remote-class="eOR.ORAuthoriseOrder.ORAuthoriseOrderHome"
*	generate= "local,remote"
*
*
*/

public class ORAuthoriseOrderManager extends OrEJBSessionAdapter {
    //SessionContext context ;
	PreparedStatement pstmt = null ;

	StringBuffer traceVals = new StringBuffer();

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert( HashMap tabData, HashMap sqlMap ) {

		//System.out.println("###in ORAuthoriseOrderManager.java,insert()###");

		Connection connection = null ;
		StringBuffer messages = new StringBuffer() ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;


		try {
			connection = getConnection((Properties)tabData.get( "properties" ) ) ;
			connection.setAutoCommit( false ) ;

			map = updateValues(connection, tabData, sqlMap);

		 } catch( Exception e ) {
			traceVals.append("Exception if any -- "+e);

			try {
				connection.rollback() ;
			} catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}

			messages.append( e.getMessage() ) ;
			System.err.println(e.getMessage() );
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
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}

	//	map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;
	}

	
	public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap){
		//System.out.println("###in ORAuthoriseOrderManager.java,updateValues()###");
		PreparedStatement pstmt 	= null;
		ResultSet resultSet			= null;
		CallableStatement cstmt 	= null;
		StringBuffer messages = new StringBuffer() ;
		//String bill_yn		 = "";
		String err_message	 = "";
		String sql_or_bl_without_order_catalog = "";
		String order_set_status_query = "";
		String update_order_set_status="";
		String update_order_set_line_status="";
		boolean bill_mess	 = true;
		HashMap map = new HashMap() ;

		//traceVals.append("====rconnection * >"+connection);
		int count =0;
		int cnt=0;
		int lineIndex = 0;//IN041644
		count = Integer.parseInt((String)tabData.get("totalCount"));
		cnt 	= Integer.parseInt((String)tabData.get("lineCount"));
		int int_total_records =0;//IN048252
		int_total_records = Integer.parseInt((String)tabData.get("int_total_records"));//IN048252
		

		//traceVals.append("====count *>"+count);
		String[] updt_vals = new String[5];
		int result = 0;
		String cont_order_ind = "";
		String order_status_code = "";
		String order_set_id="";
		String order_set_bill_yn="";
		String order_set_status_type="";
		String order_set_status_type_code="";
		
		
		try{
		for(int i=0; i<count; i++){
			//traceVals.append("i value => "+i);
			updt_vals = (String[])tabData.get("data"+i);
			cont_order_ind = (String)tabData.get("cont_order_ind"+i);
			cont_order_ind = cont_order_ind.trim();
			//traceVals.append("====???updt_vals >"+updt_vals.length);
			//System.out.println("authorise order >> cont_order_ind >>"+cont_order_ind);
			pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_COMPLETE_STATUS") ) ;
			if(updt_vals.length == 5) // Set the order_id
				pstmt.setString(1, updt_vals[4]);
			else
			    pstmt.setString(1, updt_vals[3]);
			    pstmt.setString(2, "AUTHORIZE");
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // If it returns orderstatus code , then update with the order_status_code else it will comes as "FALSE" , then proceed with the status  which came from the bean
			{
				while(resultSet.next())
				{
					order_status_code = resultSet.getString( "status" )  ;
				}
			}
			closeResultSet( resultSet);
			closeStatement( pstmt ) ;
 
			if(order_status_code==null || order_status_code.equals("") || order_status_code.equals("FALSE") ) order_status_code = "";

			if(order_status_code.equals("")) //Then put the order_status_code from the bean
			   order_status_code = updt_vals[0];

			if(updt_vals.length == 5){
					pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_AUTHORISE_ORDER_CANCEL_WITH_CONSENT_REQD") ) ;

					pstmt.setString( 1, order_status_code ) ;
					pstmt.setString( 2, updt_vals[1] ) ;
					pstmt.setString( 3, updt_vals[2]) ;
					pstmt.setString( 4, updt_vals[3] ) ;
					pstmt.setString( 5, ((String)tabData.get("login_by_id")) ) ;
					pstmt.setString( 6, ((String)tabData.get("login_at_ws_no"))) ;
					pstmt.setString( 7, ((String)tabData.get("login_facility_id")) ) ;
					pstmt.setString( 8, updt_vals[4] ) ;

					pstmt.executeUpdate();

					closeStatement( pstmt ) ;
		 
					if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
						pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_AUTHORISE_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN") ) ;

						pstmt.setString( 1, order_status_code ) ;
						pstmt.setString( 2, updt_vals[1] ) ;
						pstmt.setString( 3, updt_vals[2]) ;
						pstmt.setString( 4, updt_vals[3] ) ;
						pstmt.setString( 5, ((String)tabData.get("login_by_id")) ) ;
						pstmt.setString( 6, ((String)tabData.get("login_at_ws_no"))) ;
						pstmt.setString( 7, ((String)tabData.get("login_facility_id")) ) ;
						pstmt.setString( 8, updt_vals[4] ) ;

						result = pstmt.executeUpdate();

				 		closeStatement( pstmt ) ;
				 	}

			} else if(updt_vals.length == 4){

					pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_AUTHORISE_ORDER_CANCEL_WITHOUT_CONSENT_REQD") ) ;

					pstmt.setString( 1, order_status_code ) ;
					pstmt.setString( 2, updt_vals[1]) ;
					pstmt.setString( 3, updt_vals[2] ) ;
					pstmt.setString( 4, ((String)tabData.get("login_by_id")) ) ;
					pstmt.setString( 5, ((String)tabData.get("login_at_ws_no"))) ;
					pstmt.setString( 6, ((String)tabData.get("login_facility_id")) ) ;
					pstmt.setString( 7, updt_vals[3] ) ;

					pstmt.executeUpdate();

		 			closeStatement( pstmt ) ;
 

					if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
						//System.out.println(">> Authorise order when inthe  caase ofd DR or CR  1 without consenen");
						pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_AUTHORISE_ORDER_CANCEL_WITHOUT_CONSENT_REQD_FREQ_EXPLN") ) ;

						pstmt.setString( 1, order_status_code ) ;
						pstmt.setString( 2, updt_vals[1]) ;
						pstmt.setString( 3, updt_vals[2] ) ;
						pstmt.setString( 4, ((String)tabData.get("login_by_id")) ) ;
						pstmt.setString( 5, ((String)tabData.get("login_at_ws_no"))) ;
						pstmt.setString( 6, ((String)tabData.get("login_facility_id")) ) ;
						pstmt.setString( 7, updt_vals[3] ) ;

						result = pstmt.executeUpdate();

					 	closeStatement( pstmt ) ;
			 		}
			}
		}
		//result = pstmt.executeBatch();
	//	traceVals.append("====result of first  >"+result.length);

		for(int i=0; i<cnt; i++){
			
			updt_vals = (String[])tabData.get("lineData"+i);
			pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_COMPLETE_STATUS") ) ;
			pstmt.setString(1, updt_vals[1]);
			pstmt.setString(2, "AUTHORIZE");
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // If it returns orderstatus code , then update with the order_status_code else it will comes as "FALSE" , then proceed with the status  which came from the bean
			{
				while(resultSet.next())
				{
					order_status_code = resultSet.getString( "status" )  ;
				}
			}
			closeResultSet( resultSet);
			closeStatement( pstmt ) ;
 
			if(order_status_code==null || order_status_code.equals("") || order_status_code.equals("FALSE") ) order_status_code = "";

			if(order_status_code.equals("")) //Then put the order_status_code from the bean
			   order_status_code = updt_vals[0];

			pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_AUTHORISE_ORDER_UPDATE_ORDER_LINE") ) ;

			pstmt.setString( 1, order_status_code ) ;
			pstmt.setString( 2, ((String)tabData.get("login_by_id")) ) ;
			pstmt.setString( 3, ((String)tabData.get("login_at_ws_no"))) ;
			pstmt.setString( 4, ((String)tabData.get("login_facility_id")) ) ;
			pstmt.setString( 5, updt_vals[1] ) ;

			result = pstmt.executeUpdate();

			closeStatement( pstmt ) ;
 
			if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
				//System.out.println(">> authorise order when inthe  caase ofd DR or CR line level ");
				pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_OR_AUTHORISE_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN") ) ;

				pstmt.setString( 1, order_status_code ) ;
				pstmt.setString( 2, ((String)tabData.get("login_by_id")) ) ;
				pstmt.setString( 3, ((String)tabData.get("login_at_ws_no"))) ;
				pstmt.setString( 4, ((String)tabData.get("login_facility_id")) ) ;
				pstmt.setString( 5, updt_vals[1] ) ;

				//System.out.println(">> updt_vals[0]" + updt_vals[0]);
				//System.out.println(">> updt_vals[1]" + updt_vals[1]);

				pstmt.executeUpdate();
 
				closeStatement( pstmt ) ;
 
			}

			if(result > 0)
			{
				// Billing
				try{
						
						order_set_id=updt_vals[3];
						if(order_set_id==null)order_set_id="";
						order_set_bill_yn=updt_vals[4];
						if(order_set_bill_yn==null)order_set_bill_yn="";
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

						sql_or_bl_without_order_catalog = (String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG");
						cstmt = connection.prepareCall("{ "+sql_or_bl_without_order_catalog+" }");
						cstmt.setString(1, ((String)tabData.get("login_facility_id")));
						if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
						{
							cstmt.setString(2, updt_vals[3]);							
						}
						else
						{
							cstmt.setString(2, updt_vals[1]);
						}

						cstmt.setString(3, null);
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
							if(updt_vals[2]!=null && updt_vals[2].equals("Y")) // SpecialApproved
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
						//bill_yn 		= cstmt.getString(7);
						err_message 	= cstmt.getString(8);
						if(err_message!=null && err_message!="null" && !err_message.equals(""))
						{
							result 			= 0;
							bill_mess	 	= false;
							messages.append( err_message ) ;
						} // End of if !err_message
			 
						closeStatement( cstmt ) ;

				}catch(Exception e)
				{
					result = 0;
					System.err.println("Billing"+e.toString());
				}
			}
		}
		//result = pstmt.executeBatch();
		//traceVals.append("====result of first  >"+result.length);

		//System.out.println("authorise result >>"+result);
		//CRF 358 Starts
		
			String patient_id = "";
			String encounter_id = "";
			String order_date_time = "";
			String ordering_pract_name = "";
			String ordering_facility_id = "";
			String ord_auth_reqd_yn = "";
			String order_author_overrule_check = "";
			String ord_catalog = "";
			String order_id = "";
			String or_order_line = "";
			int qryIndex = 0;
			String order_authorisation_rule = "";
			int auth_durn_val = 0;
			String auth_durn_type = "";
			String auth_end_date = "";
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			java.util.Date order_date;//IN048075
			int his_dupli_count = 0;
			String[] authorisation_vals = new String[11];
			for (int j = 0; j < int_total_records; j++) {//IN048252
			if(null!=tabData.get("lineIndex"+j)){//IN048252
			lineIndex = (Integer) tabData.get("lineIndex"+j);//IN048202
			for (int i = 1; i <= lineIndex; i++) {
				qryIndex = 0;
				try {
					authorisation_vals = (String[])tabData.get("authorisationData"+i+j);//IN048202
					patient_id =authorisation_vals[0];
					encounter_id = authorisation_vals[1];
					order_date_time = authorisation_vals[2];
					order_date =dateFormat.parse(order_date_time);//IN048075
					ordering_pract_name = authorisation_vals[3];
					ordering_facility_id = authorisation_vals[4];
					ord_auth_reqd_yn =  authorisation_vals[7];
					ord_catalog = authorisation_vals[5];
					order_id = authorisation_vals[6];
					or_order_line =  authorisation_vals[10];
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(order_date);//IN048075
					if ("Y".equals(ord_auth_reqd_yn)) {

						order_authorisation_rule = (String) sqlMap
								.get("SQL_OR_ORDER_ENTRY_AUTHORISATION_RULE");
						pstmt = connection
								.prepareStatement(order_authorisation_rule);

						pstmt.setString(++qryIndex,authorisation_vals[9]);

						pstmt.setString(++qryIndex,authorisation_vals[8]);
						pstmt.setString(++qryIndex, "*ALL");

						pstmt.setString(++qryIndex, ord_catalog);
						pstmt.setString(++qryIndex, "*ALL");
						resultSet = pstmt.executeQuery();
						while (resultSet.next())
						{
							auth_durn_val = resultSet.getInt("AUTH_DURN_VAL");
							auth_durn_type = resultSet
									.getString("AUTH_DURN_TYPE");

						}
						qryIndex = 0;
						closeStatement(pstmt);
						closeResultSet(resultSet);
						
						if(auth_durn_val!=0 && !"".equals(auth_durn_type) )
						{	
								auth_end_date = getAuthorisationEnddate(
									auth_durn_val, auth_durn_type,
									auth_end_date, dateFormat,
									calendar);
								order_author_overrule_check = (String) sqlMap
									.get("ORDER_ENTRY_AUTHORISATION_OVERRULE_CHECK");
								pstmt = connection
									.prepareStatement(order_author_overrule_check);
								
								pstmt.setString(++qryIndex, ord_catalog);
								pstmt.setString(++qryIndex, patient_id);
								pstmt.setString(++qryIndex, ordering_pract_name);
								resultSet = pstmt.executeQuery();
								while (resultSet.next()) {
									his_dupli_count = resultSet.getInt("DUPLICATE_COUNT");
								}
								
								qryIndex = 0;
								closeStatement(pstmt);
								closeResultSet(resultSet);
								
								if(his_dupli_count > 0)
								{
									deleteOverruleHis(connection,
											sqlMap, patient_id,
											ordering_pract_name, ord_catalog,
											qryIndex);
									
									qryIndex = 0;
									closeStatement(pstmt);
									closeResultSet(resultSet);
									
									insertAuthorisationHis(
											connection, tabData, sqlMap,
											pstmt, patient_id,
											encounter_id, order_date_time,
											ordering_pract_name,
											ordering_facility_id,
											ord_catalog, order_id,
											or_order_line, qryIndex,
											auth_end_date);
									
								}
								else if(his_dupli_count == 0){
								
									qryIndex = 0;
									closeStatement(pstmt);
									closeResultSet(resultSet);
										
									insertAuthorisationHis(
											connection, tabData, sqlMap,
											pstmt, patient_id,
											encounter_id, order_date_time,
											ordering_pract_name,
											ordering_facility_id,
											ord_catalog, order_id,
											or_order_line, qryIndex,
											auth_end_date);
								}
						}
					}

				} catch (Exception e) {
					System.err
							.println("Error While Validating Authorisation History"+e.toString());
					e.printStackTrace();
				}

			}
		  }//IN048252
		}
		//CRF 358 Ends

		if ( result< 1 ) {
			map.put( "result", new Boolean( false ) ) ;
			connection.rollback();
			map.put( "message", "Operation failure ..." ) ;

		} else  {
			connection.commit() ;
			map.put( "result", new Boolean( true ) ) ;
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
			System.err.println("Failed"+e.toString());
		}
		finally{
			try{

				closeResultSet( resultSet);
				closeStatement( pstmt ) ;
				closeStatement( cstmt ) ;
		  	  } catch(Exception e) {
				  System.err.println("Finally"+e);
			  }
		}
		map.put( "message", messages.toString() ) ;

		return map;
	}

	//IN041644 Starts
	private void deleteOverruleHis(Connection connection,
			HashMap sqlMap, String patient_id, String ordering_pract_name,
			String ord_catalog, int qryIndex) throws SQLException {
		try{
			PreparedStatement pstmt;
			String order_author_overrule_delete;
			order_author_overrule_delete = (String) sqlMap
					.get("ORDER_ENTRY_AUTHORISATION_OVERRULE_DELETE");
			
			pstmt = connection
					.prepareStatement(order_author_overrule_delete);
			pstmt.setString(++qryIndex, ord_catalog);
			pstmt.setString(++qryIndex, patient_id);
			pstmt.setString(++qryIndex, ordering_pract_name);
			pstmt.executeUpdate();
			 if (pstmt != null)pstmt.close();//15950
		}catch (Exception e) {
			System.err
			.println("Error While Deleting Authorisation History"+e.toString());
			e.printStackTrace();
		}
		
	}
	private void insertAuthorisationHis(Connection connection,
			HashMap tabData, HashMap sqlMap, PreparedStatement pstmt,
			String patient_id, String encounter_id, String order_date_time,
			String ordering_pract_name, String ordering_facility_id,
			String ord_catalog, String order_id, String or_order_line,
			int qryIndex, String auth_end_date) throws SQLException {
		try{
			String order_authorisation_his;
			if (!"".equals(auth_end_date))
			{
				order_authorisation_his = (String) sqlMap
						.get("SQL_OR_ORDER_ENTRY_AUTHORISATION_HISTORY");
				pstmt = connection
						.prepareStatement(order_authorisation_his);
				pstmt.setString(++qryIndex, patient_id);
				pstmt.setString(++qryIndex, ord_catalog);
				pstmt.setString(++qryIndex, ordering_pract_name);
				pstmt.setString(++qryIndex, ordering_facility_id);
				pstmt.setString(++qryIndex, encounter_id);
				pstmt.setString(++qryIndex, order_id);
				pstmt.setString(++qryIndex, or_order_line);
				pstmt.setString(
						++qryIndex,
						 ((String) tabData.get("login_by_id")));
				pstmt.setString(++qryIndex, order_date_time);//IN048075
				pstmt.setString(++qryIndex, order_date_time);
				pstmt.setString(++qryIndex,auth_end_date);
				pstmt.setString(++qryIndex,
						((String) tabData.get("login_by_id")));
				pstmt.setString(++qryIndex,
						((String) tabData.get("login_at_ws_no")));
				pstmt.setString(++qryIndex,
						((String) tabData.get("login_facility_id")));
				pstmt.setString(++qryIndex,
						((String) tabData.get("login_by_id")));
				pstmt.setString(++qryIndex,
						((String) tabData.get("login_at_ws_no")));
				pstmt.setString(++qryIndex,
						((String) tabData.get("login_facility_id")));
				pstmt.executeUpdate();
				if (pstmt != null)pstmt.close();//15950
			}
		}
		catch (Exception e) {
			System.err
			.println("Error While Inserting Authorisation History"+e.toString());
			e.printStackTrace();
		}
		
	}


	private String getAuthorisationEnddate(int auth_durn_val,
			String auth_durn_type, String auth_end_date, DateFormat dateFormat,
			Calendar calendar) {
		if ("D".equals(auth_durn_type)) {
			calendar.add(Calendar.DATE, auth_durn_val);
			//auth_end_date = getDate(calendar);
			auth_end_date = dateFormat.format(calendar.getTime());
		} else if ("H".equals(auth_durn_type)) {
			calendar.add(Calendar.HOUR_OF_DAY,
					auth_durn_val);
			//auth_end_date = getDate(calendar);
			auth_end_date = dateFormat.format(calendar.getTime());
		} else if ("M".equals(auth_durn_type)) {
			calendar.add(Calendar.MINUTE, auth_durn_val);
			//auth_end_date = getDate(calendar);
			auth_end_date = dateFormat.format(calendar.getTime());
		} else if ("W".equals(auth_durn_type)) {
			calendar.add(Calendar.WEEK_OF_MONTH,
					auth_durn_val);
			//auth_end_date = getDate(calendar);
			auth_end_date = dateFormat.format(calendar.getTime());
		} else if ("L".equals(auth_durn_type)) {
			calendar.add(Calendar.MONTH, auth_durn_val);
			//auth_end_date = getDate(calendar);
			auth_end_date = dateFormat.format(calendar.getTime());
		} else if ("Y".equals(auth_durn_type)) {
			calendar.add(Calendar.YEAR, auth_durn_val);
			//auth_end_date = getDate(calendar);
			auth_end_date = dateFormat.format(calendar.getTime());
		}
		return auth_end_date;
	}
	//IN041644 Ends
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
}


