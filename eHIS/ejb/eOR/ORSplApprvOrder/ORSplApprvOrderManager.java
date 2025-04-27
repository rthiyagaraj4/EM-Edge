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
23/10/2019    	IN071315	    Nijitha S  		GHL-CRF-0607
--------------------------------------------------------------------------------------------------------------------
*/
package eOR.ORSplApprvOrder;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;

/**
*
* @ejb.bean
*	name="ORSplApprvOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORSplApprvOrder"
*	local-jndi-name="ORSplApprvOrder"
*	impl-class-name="eOR.ORSplApprvOrder.ORSplApprvOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORSplApprvOrder.ORSplApprvOrderLocal"
*	remote-class="eOR.ORSplApprvOrder.ORSplApprvOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORSplApprvOrder.ORSplApprvOrderLocalHome"
*	remote-class="eOR.ORSplApprvOrder.ORSplApprvOrderHome"
*	generate= "local,remote"
*
*
*/

public class ORSplApprvOrderManager extends OrEJBSessionAdapter {
   // SessionContext context ;
	PreparedStatement pstmt = null ;

	StringBuffer traceVals = new StringBuffer();

/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap insert( HashMap tabData, HashMap sqlMap ) {
//System.out.println("#######in insert() of ORSplApprvOrderManager.java########### ");
//System.out.println("#######in insert() of ORSplApprvOrderManager.java,tabData= "+tabData);
//System.out.println("#######in insert() of ORSplApprvOrderManager.java,sqlMap= "+sqlMap);
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
			 System.err.println("exception in ORSplApprvOrderManager.java insert()="+e);
			traceVals.append("Exception if any -- "+e);

			try {
				connection.rollback() ;
			} catch ( Exception ee ) {
				 System.err.println("exception in ORSplApprvOrderManager.java insert(),ee="+ee);
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
 //System.out.println("map in ORSplApprvOrderManager.java insert()="+map);
		return map ;
	}

	public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap){
		//System.out.println("###in ORSplApprvOrderManager,java ,updateValues(),tabData="+tabData);
		//System.out.println("###in ORSplApprvOrderManager,java ,updateValues(),sqlMap="+sqlMap);
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;
		PreparedStatement pstmt4 	= null;
		PreparedStatement pstmt5 	= null;
		PreparedStatement pstmt6 	= null;
		PreparedStatement pstmt7 	= null;
		PreparedStatement pstmt8 	= null;

		ResultSet resultSet			= null;
		CallableStatement cstmt 	= null;
		//String bill_yn		 = "";
		String err_message	 = "";
		//String sql_or_bl_without_order_catalog = "";
		String order_status_code = "";
		boolean bill_mess	 = true;
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;

	//	System.out.println("====rconnection * >"+connection);
		int count =0;
		int cnt=0;

		count = Integer.parseInt((String)tabData.get("totalCount"));
		cnt 	= Integer.parseInt((String)tabData.get("lineCount"));

	//	System.out.println("====count *>"+count);
		String[] updt_vals = new String[3];
		String[] updt_vals1 = new String[4];
		int result = 0;
		String cont_order_ind = "";
		String order_set_id="";
		String order_set_bill_yn="";
		String order_set_status_type="";
		String order_set_status_query = "";
		String update_order_set_status="";
		String update_order_set_line_status="";
		try{
			//sql_or_bl_without_order_catalog = (String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG");
			cstmt = connection.prepareCall("{ "+(String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG")+" }");
			pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_COMPLETE_STATUS") ) ;
			pstmt2 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_CANCEL_WITH_CONSENT_REQD") ) ;
			pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN") ) ;
			pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_CANCEL_WITHOUT_CONSENT_REQD") ) ;
			pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_CANCEL_WITHOUT_CONSENT_REQD_FREQ_EXPLN") ) ;
			pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_COMPLETE_STATUS") ) ;
			pstmt7 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_UPDATE_ORDER_LINE") ) ;
			pstmt8 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN") ) ;
		for(int i=0; i<count; i++){
			//traceVals.append("i value => "+i);
			updt_vals = (String[])tabData.get("data"+i);
			cont_order_ind = (String)tabData.get("cont_order_ind"+i);
			cont_order_ind = cont_order_ind.trim();
			/*System.out.println("====???updt_vals >"+updt_vals.length);
			System.out.println("authorise order >> cont_order_ind >>"+cont_order_ind);
			System.out.println("updt_vals[0] >>"+updt_vals[0]+"<<");
			System.out.println("updt_vals[1] >>"+updt_vals[1]+"<<");
			System.out.println("updt_vals[2] >>"+updt_vals[2]+"<<");
			System.out.println("ord_consent_reqd_yn >>"+(String)tabData.get("ord_consent_reqd_yn"));*/
			//pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_COMPLETE_STATUS") ) ;
			pstmt1.clearParameters();
			//System.out.println("pstmt1:1:"+ updt_vals[2] + ",2:"+ "APPROVE");
			pstmt1.setString(1, updt_vals[2]);
			pstmt1.setString(2, "APPROVE");
			resultSet	= pstmt1.executeQuery() ;
			if ( resultSet != null )    // If it returns orderstatus code , then update with the order_status_code else it will comes as "FALSE" , then proceed with the status  which came from the bean
			{
				//System.out.println("#####11111111");
				while(resultSet.next())
				{
					//System.out.println("#####22222222222");
					order_status_code = resultSet.getString( "status" )  ;
				}
			}
//System.out.println("#####order_status_code="+order_status_code);
			closeResultSet( resultSet);
			if(order_status_code==null || order_status_code.equals("") || order_status_code.equals("FALSE") ) order_status_code = "";

			if(order_status_code.equals("")) //Then put the order_status_code from the bean
			   order_status_code = updt_vals[0];

//System.out.println("#####ord_consent_reqd_yn="+(String)tabData.get("ord_consent_reqd_yn"));

			if((((String)tabData.get("ord_consent_reqd_yn")).equals("YES"))){
					//pstmt2 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_CANCEL_WITH_CONSENT_REQD") ) ;
					pstmt2.clearParameters();
                    //System.out.println("pstmt2:1:"+ order_status_code + ",2:"+ order_status_code + ",3:" + updt_vals[2].trim());
					pstmt2.setString( 1, order_status_code ) ;
					pstmt2.setString( 2, updt_vals[1].trim() ) ;
					pstmt2.setString( 3, ((String)tabData.get("login_by_id")) ) ;
					pstmt2.setString( 4, ((String)tabData.get("login_at_ws_no")) ) ;
					pstmt2.setString( 5, ((String)tabData.get("login_facility_id")) ) ;
					pstmt2.setString( 6, updt_vals[2].trim()) ;

					pstmt2.executeUpdate();

					if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
						//pstmt3 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN") ) ;
						pstmt3.clearParameters();
                        //System.out.println("pstmt3:1:"+ order_status_code + ",2:"+ updt_vals[1].trim() + ",3:" + updt_vals[2].trim());
						pstmt3.setString( 1, order_status_code ) ;
						pstmt3.setString( 2, updt_vals[1].trim() ) ;
						pstmt3.setString( 3, ((String)tabData.get("login_by_id")) ) ;
						pstmt3.setString( 4, ((String)tabData.get("login_at_ws_no")) ) ;
						pstmt3.setString( 5, ((String)tabData.get("login_facility_id")) ) ;
						pstmt3.setString( 6, updt_vals[2].trim()) ;

						pstmt3.executeUpdate();
					}
			} else if((((String)tabData.get("ord_consent_reqd_yn")).equals("NO"))){
	

					//pstmt4 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_CANCEL_WITHOUT_CONSENT_REQD") ) ;
					pstmt4.clearParameters();
                    //System.out.println("pstmt4:1:"+ order_status_code + ",2:"+ updt_vals[1].trim() + ",3:" + updt_vals[2].trim());
					pstmt4.setString( 1, order_status_code ) ;
					pstmt4.setString( 2, updt_vals[1].trim()) ;
					pstmt4.setString( 3, ((String)tabData.get("login_by_id")) ) ;
					pstmt4.setString( 4, ((String)tabData.get("login_at_ws_no")) ) ;
					pstmt4.setString( 5, ((String)tabData.get("login_facility_id")) ) ;
					pstmt4.setString( 6, updt_vals[2].trim() ) ;

					result = pstmt4.executeUpdate();
			//System.out.println("#####result of pstmt4.executeUpdate()="+result);
					if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
						//System.out.println(">> Authorise order when inthe  caase ofd DR or CR  1 without consenen");
						//pstmt5 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_CANCEL_WITHOUT_CONSENT_REQD_FREQ_EXPLN") ) ;
						pstmt5.clearParameters();
                        //System.out.println("pstmt5:1:"+ order_status_code + ",2:"+ updt_vals[1].trim() + ",3:" + updt_vals[2].trim());
						pstmt5.setString( 1, order_status_code ) ;
						pstmt5.setString( 2, updt_vals[1].trim()) ;
						pstmt5.setString( 3, ((String)tabData.get("login_by_id")) ) ;
						pstmt5.setString( 4, ((String)tabData.get("login_at_ws_no")) ) ;
						pstmt5.setString( 5, ((String)tabData.get("login_facility_id")) ) ;
						pstmt5.setString( 6, updt_vals[2].trim() ) ;

						pstmt5.executeUpdate();

					}
			}
		}

	//	System.out.println("====result of first  >"+result);

		for(int i=0; i<cnt; i++){
			updt_vals1 = (String[])tabData.get("lineData"+i);
			//System.out.println("COMES HERE ?????????>");
			//pstmt6 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_COMPLETE_STATUS") ) ;
			pstmt6.clearParameters();
			//System.out.println("pstmt6:1:"+ updt_vals1[1] + ",2:"+ "APPROVE");
			pstmt6.setString(1, updt_vals1[1]);
			pstmt6.setString(2, "APPROVE");
			resultSet	= pstmt6.executeQuery() ;
			if ( resultSet != null )    // If it returns orderstatus code , then update with the order_status_code else it will comes as "FALSE" , then proceed with the status  which came from the bean
			{
				while(resultSet.next())
				{
					//System.out.println("################");
					order_status_code = resultSet.getString( "status" )  ;
				}
			}
			//System.out.println("##### result of pstmt6,order_status_code="+order_status_code);
			closeResultSet( resultSet);
			if(order_status_code==null || order_status_code.equals("") || order_status_code.equals("FALSE") ) order_status_code = "";

			if(order_status_code.equals("")) //Then put the order_status_code from the bean
			   order_status_code = updt_vals1[0];


			//pstmt7 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_UPDATE_ORDER_LINE") ) ;
			pstmt7.clearParameters();
			//System.out.println("updt_vals1[0] >>"+updt_vals1[0]);
			//System.out.println("updt_vals1[1] >>"+updt_vals1[1]);
            //System.out.println("pstmt7:1:"+ order_status_code + ",2:"+ updt_vals1[1]);
			pstmt7.setString( 1, order_status_code ) ;
			pstmt7.setString( 2, ((String)tabData.get("login_by_id")) ) ;
			pstmt7.setString( 3, ((String)tabData.get("login_at_ws_no")) ) ;
			pstmt7.setString( 4, ((String)tabData.get("login_facility_id")) ) ;
			pstmt7.setString( 5, updt_vals1[1] ) ;

			result = pstmt7.executeUpdate();

			if(cont_order_ind.equals("DR") || cont_order_ind.equals("CR") ){
				//System.out.println(">> authorise order when inthe  caase ofd DR or CR line level ");
				//pstmt8 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_SPECIAL_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN") ) ;
				pstmt8.clearParameters();
				//System.out.println("pstmt8:1:"+ order_status_code + ",2:"+ updt_vals1[1]);
				pstmt8.setString( 1, order_status_code ) ;
				pstmt8.setString( 2, ((String)tabData.get("login_by_id")) ) ;
				pstmt8.setString( 3, ((String)tabData.get("login_at_ws_no")) ) ;
				pstmt8.setString( 4, ((String)tabData.get("login_facility_id")) ) ;
				pstmt8.setString( 5, updt_vals1[1] ) ;

				//System.out.println(">> updt_vals[0]" + updt_vals1[0]);
				//System.out.println(">> updt_vals[1]" + updt_vals1[1]);

				pstmt8.executeUpdate();

			}
//System.out.println("######result ofpstmt7="+result);
			if(result > 0)
			{
				// Billing
				try{
						//sql_or_bl_without_order_catalog = (String)sqlMap.get("SQL_OR_BL_WITHOUT_ORDER_CATALOG");
						//cstmt = connection.prepareCall("{ "+sql_or_bl_without_order_catalog+" }");
						order_set_id=updt_vals1[2];
						if(order_set_id==null)order_set_id="";
						order_set_bill_yn=updt_vals1[3];
						if(order_set_bill_yn==null)order_set_bill_yn="";
						order_set_status_query = (String)sqlMap.get("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE");
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

						cstmt.clearParameters();
						//System.out.println("cstmt");
						cstmt.setString(1, ((String)tabData.get("login_facility_id")));
						if((order_set_bill_yn.equalsIgnoreCase("Y"))&&(!(order_set_id.equals(""))))
						{
							cstmt.setString(2, updt_vals1[2]);
						}
						else
					   {
							cstmt.setString(2, updt_vals1[1]);
					   }
						cstmt.setString(3, null);
						cstmt.setString(4, "AUT");
						cstmt.setString(5, ((String)tabData.get("login_by_id")));
						cstmt.setString(6, ((String)tabData.get("login_at_ws_no")));

						cstmt.registerOutParameter( 7,  Types.VARCHAR ) ;
						cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
						cstmt.setString(9, "OR");//IN071315
						cstmt.execute();
						//bill_yn 		= cstmt.getString(7);
						err_message 	= cstmt.getString(8);
						//System.out.println("=err_message======"+err_message+"=======");
						if(err_message!=null && err_message!="null" && !err_message.equals(""))
						{
							result 			= 0;
							bill_mess	 	= false;
							messages.append( err_message ) ;
						} // End of if !err_message
					}catch(Exception e)
					{
						result = 0;
						System.err.println("Billing"+e.toString());
					}
			}
		}

		//System.out.println("######Final spl apprval result >>"+result);

		if ( result< 1 ) {
			map.put( "result", new Boolean( false ) ) ;
			connection.rollback();
			map.put( "message", "Operation failure ..." ) ;
			messages.append( "Insert Failed" ) ;

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
			System.out.println("Exception in EJB :"+e);
		} finally {
			try {
					closeResultSet( resultSet);
					closeStatement(pstmt1);
					closeStatement(pstmt2);
					closeStatement(pstmt3);
					closeStatement(pstmt4);
					closeStatement(pstmt5);
					closeStatement(pstmt6);
					closeStatement(pstmt7);
					closeStatement(pstmt8);
					closeStatement( cstmt ) ;
				} catch (Exception ee) {
					System.err.println("Finally"+ee);
				}
		}
		map.put( "message", messages.toString() ) ;

		return map;
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
}
