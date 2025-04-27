/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.OROrdersTab;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="OROrdersTab"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OROrdersTab"
*	local-jndi-name="OROrdersTab"
*	impl-class-name="eOR.OROrdersTab.OROrdersTabManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.OROrdersTab.OROrdersTabLocal"
*	remote-class="eOR.OROrdersTab.OROrdersTabRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.OROrdersTab.OROrdersTabLocalHome"
*	remote-class="eOR.OROrdersTab.OROrdersTabHome"
*	generate= "local,remote"
*
*
*/

public class OROrdersTabManager extends OrEJBSessionAdapter
{
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	//ResultSet resultSet = null;
	//SessionContext sessionContext = null;

/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap insert(HashMap tabData, HashMap sqlMap)
{
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		String patient_class = "";
		String practitioner_id = "";
		String func_id = "";
		//String facility_id = "";
		//String sys_tab_name = "";
		//String user_tab_name = "";
	//	int seq_number = 0;
		String Added_By_ID = "";
		String Added_At_Ws_No = "";
		String Added_Facility_ID = "";
		String Modified_By_ID = "";
		String Modified_At_Ws_No = "";
		String Modified_Facility_ID = "";
		//String applicable_yn = "";
		String SQL_OR_INDEX_ORDERTAB_INSERT = "";

		Vector sys_tab_names = new Vector();
		Vector user_tab_names = new Vector();
		Vector seq_nos = new Vector();
		Vector applicable_yns = new Vector();

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "insert" ) ;
		
		if(tabData.isEmpty())
		{
			//System.out.println("No Data Available");
			return null;
		}
		else
		{
			patient_class = (String )tabData.get("patient_class");
			practitioner_id = (String )tabData.get("practitioner_id");
			//facility_id = (String )tabData.get("facility_id");
			Added_By_ID = (String )tabData.get("Added_By_ID");
			Added_At_Ws_No = (String )tabData.get("Added_At_Ws_No");
			Added_Facility_ID = (String )tabData.get("Added_Facility_ID");
			Modified_By_ID = (String )tabData.get("Modified_By_ID");
			Modified_At_Ws_No = (String )tabData.get("Modified_At_Ws_No");
			Modified_Facility_ID = (String )tabData.get("Modified_Facility_ID");
			func_id = (String ) tabData.get("func_id");
			// SQL Query
			// to get the query from repository file
			SQL_OR_INDEX_ORDERTAB_INSERT = (String) sqlMap.get("SQL_OR_INDEX_ORDERTAB_INSERT");

			sys_tab_names = (Vector)tabData.get("sys_tab_name");
			user_tab_names = (Vector )tabData.get("user_tab_name");
			seq_nos = (Vector )tabData.get("seq_no");
			applicable_yns = (Vector )tabData.get("applicable_yn");
			int count = sys_tab_names.size();
			int resultCount = 0;

			try
			{
				connection = getConnection( (Properties)tabData.get( "properties" ));

				connection.setAutoCommit(false);  // avoide Committing the transaction automatically

				preparedStatement = connection.prepareStatement(SQL_OR_INDEX_ORDERTAB_INSERT);
				for(int i=0;i<count;i++)
				{
					preparedStatement.setString(1,practitioner_id);
					preparedStatement.setString(2,(String )sys_tab_names.get(i));
					preparedStatement.setString(3,(String )user_tab_names.get(i));
					preparedStatement.setInt(4,Integer.parseInt((String )seq_nos.get(i)));
					preparedStatement.setString(5,patient_class);
					preparedStatement.setString(6,(String )applicable_yns.get(i));
					preparedStatement.setString(7,Added_By_ID);
					preparedStatement.setString(8,Added_At_Ws_No);
					preparedStatement.setString(9,Added_Facility_ID);
					preparedStatement.setString(10,Modified_By_ID);
					preparedStatement.setString(11,Modified_At_Ws_No);
					preparedStatement.setString(12,Modified_Facility_ID);
					preparedStatement.setString(13,func_id);
					resultCount = preparedStatement.executeUpdate(); //execution of update query
				}
				
				// commiting the transaction
				if (resultCount != 0)
				{
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					messages.append( "RECORD_INSERTED" ) ;
				}
				else
				{
					connection.rollback();
					messages.append( "Insert Failed" ) ;
				}
			}
			catch(SQLException sqle)
			{
			try{
			connection.rollback();  // rollback the current transaction
			}catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			}
				sqle.printStackTrace();
				System.out.println(sqle.getMessage());
				messages.append("Insert Failed");
				traceVal.append(sqle.getMessage());
			}
			catch(Exception e)
			{
			try{
			connection.rollback();  // rollback the current transaction
			}catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			}
				e.printStackTrace();
				System.out.println(e.getMessage());
				messages.append("Insert Failed");
				traceVal.append(e.getMessage());
			}	
			finally
			{
				try{
				//closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection,(Properties)tabData.get( "properties" ));
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
					traceVal.append(e.getMessage());
				}
			}
		map.put( "message", messages.toString() ) ;
  		map.put( "invalidCode", "") ;
        map.put( "traceVal", traceVal.toString() ) ;
		messages.setLength(0);
		traceVal.setLength(0);
		return map;

		} // end of else
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

public HashMap modify(HashMap tabData, HashMap sqlMap)
{
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		String patient_class = "";
		String practitioner_id = "";
		String func_id = "";
		//String facility_id = "";
		//String sys_tab_name = "";
		//String user_tab_name = "";
		//int seq_number = 0;
		//String applicable_yn = "";
		String Added_By_ID = "";
		String Added_At_Ws_No = "";
		String Added_Facility_ID = "";
		String Modified_By_ID = "";
		String Modified_At_Ws_No = "";
		String Modified_Facility_ID = "";
		
		String SQL_OR_INDEX_ORDERTAB_UPDATE = "";
		String SQL_OR_INDEX_ORDERTAB_DELETE = "";

		Vector sys_tab_names = new Vector();
		Vector user_tab_names = new Vector();
		Vector seq_nos = new Vector();
		Vector applicable_yns = new Vector();
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "insert" ) ;
	
			//"tabData" contains all the values to be stored in Database
			
			patient_class = (String )tabData.get("patient_class");
			practitioner_id = (String )tabData.get("practitioner_id");
			func_id = (String ) tabData.get("func_id");

			/* Deleting the Records from the Table */
			SQL_OR_INDEX_ORDERTAB_DELETE = (String) sqlMap.get("SQL_OR_INDEX_ORDERTAB_DELETE");
			
			try{
				connection = getConnection( (Properties)tabData.get( "properties" ));

				connection.setAutoCommit(false);  // avoide Committing the transaction automatically

				preparedStatement = connection.prepareStatement(SQL_OR_INDEX_ORDERTAB_DELETE);
				preparedStatement.setString(1,practitioner_id);
				preparedStatement.setString(2,patient_class);
				preparedStatement.setString(3,func_id);

				preparedStatement.executeUpdate(); //execution of update query
				//int resCount = preparedStatement.executeUpdate(); //execution of update query

				closeStatement(preparedStatement);
				/* Modify operation starts */
			
				patient_class = (String )tabData.get("patient_class");
				practitioner_id = (String )tabData.get("practitioner_id");
				//facility_id = (String )tabData.get("facility_id");
				Added_By_ID = (String )tabData.get("Added_By_ID");
				Added_At_Ws_No = (String )tabData.get("Added_At_Ws_No");
				Added_Facility_ID = (String )tabData.get("Added_Facility_ID");
				Modified_By_ID = (String )tabData.get("Modified_By_ID");
				Modified_At_Ws_No = (String )tabData.get("Modified_At_Ws_No");
				Modified_Facility_ID = (String )tabData.get("Modified_Facility_ID");
				func_id = (String ) tabData.get("func_id");
				sys_tab_names = (Vector)tabData.get("sys_tab_name");
				user_tab_names = (Vector )tabData.get("user_tab_name");
				seq_nos = (Vector )tabData.get("seq_no");
				applicable_yns = (Vector )tabData.get("applicable_yn");
				int count = sys_tab_names.size();
				int resultCount = 0;

				SQL_OR_INDEX_ORDERTAB_UPDATE = (String) sqlMap.get("SQL_OR_INDEX_ORDERTAB_INSERT");

				
				preparedStatement = connection.prepareStatement(SQL_OR_INDEX_ORDERTAB_UPDATE);
				for(int i=0;i<count;i++)
				{
					preparedStatement.setString(1,practitioner_id);
					preparedStatement.setString(2,(String )sys_tab_names.get(i));
					preparedStatement.setString(3,(String )user_tab_names.get(i));
					preparedStatement.setInt(4,Integer.parseInt((String )seq_nos.get(i)));
					preparedStatement.setString(5,patient_class);
					preparedStatement.setString(6,(String )applicable_yns.get(i));
					preparedStatement.setString(7,Added_By_ID);
					preparedStatement.setString(8,Added_At_Ws_No);
					preparedStatement.setString(9,Added_Facility_ID);
					preparedStatement.setString(10,Modified_By_ID);
					preparedStatement.setString(11,Modified_At_Ws_No);
					preparedStatement.setString(12,Modified_Facility_ID);
					preparedStatement.setString(13,func_id);
					resultCount = preparedStatement.executeUpdate(); //execution of update query
				}
				if (resultCount != 0)
				{
					connection.commit();
					map.put( "result", new Boolean( true ) ) ;
					messages.append( "RECORD_MODIFIED" ) ;
				}
				else
				{
					connection.rollback();
					messages.append( "Modify Failed" ) ;
				}
			}
			catch(SQLException sqle)
			{
			try{
				connection.rollback();  // rollback the current transaction
			}catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			}
				sqle.printStackTrace();
				System.out.println(sqle.getMessage());
				messages.append("Modify Failed");
				traceVal.append(sqle.getMessage());
			}
			catch(Exception e)
			{
			try{
				connection.rollback();  // rollback the current transaction
			}catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			}
				e.printStackTrace();
				System.out.println(e.getMessage());
				messages.append("Modify Failed");
				traceVal.append(e.getMessage());
			}	
			finally
			{
				try{
				//closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection,(Properties)tabData.get( "properties" ));
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
					traceVal.append(e.getMessage());
				}
			}

			/* Modify operation Ends */
			
		map.put( "message", messages.toString() ) ;
  		map.put( "invalidCode", "") ;
        map.put( "traceVal", traceVal.toString() ) ;
		messages.setLength(0);
		traceVal.setLength(0);
		return map;
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	
public HashMap delete(HashMap tabData, HashMap sqlMap)
{
	
		HashMap map = new HashMap() ;
		StringBuffer messages = new StringBuffer();
		StringBuffer traceVal = new StringBuffer();
		map.put( "result", new Boolean( false ) );
		map.put( "flag", "") ;
		map.put( "callOnSuccess", new Boolean( false ) ) ;
		map.put( "message", messages.toString() ) ;

		//to get the query from repository file
		String SQL_OR_INDEX_ORDERTAB_DELETE = "";
		String patient_class = "";
		String practitioner_id = "";
		String func_id = "";
		if(tabData.isEmpty())
		{
			//System.out.println("No Data Available");
			return null;
		}
		else
		{
			//System.err.println("Entered into else of EJB");
			SQL_OR_INDEX_ORDERTAB_DELETE = (String) sqlMap.get("SQL_OR_INDEX_ORDERTAB_DELETE");
			practitioner_id = (String )tabData.get("practitioner_id");
			patient_class = (String )tabData.get("patient_class");
			func_id = (String )tabData.get("func_id");
			try{
				connection = getConnection( (Properties)tabData.get( "properties" ));

				connection.setAutoCommit(false);  // avoide Committing the transaction automatically

				preparedStatement = connection.prepareStatement(SQL_OR_INDEX_ORDERTAB_DELETE);
				preparedStatement.setString(1,practitioner_id);
				preparedStatement.setString(2,patient_class);
				preparedStatement.setString(3,func_id);
				int count = preparedStatement.executeUpdate(); //execution of update query
				// commiting the transaction
				if(count != 0)
					connection.commit();
				else
					connection.rollback();

				map.put("RecordCount",String.valueOf(count));
			}catch(SQLException sqle)
			{
				try{
				connection.rollback();  // rollback the current transaction
			}catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			}
				System.out.println(sqle.getMessage());
				sqle.printStackTrace();
			}
			catch(Exception e)
			{
				try{
				connection.rollback();  // rollback the current transaction
			}catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			}
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try{
				closeStatement(preparedStatement);
				closeConnection(connection,(Properties)tabData.get( "properties" ));
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
					traceVal.append(e.getMessage());
				}
		}
		messages.setLength(0);
		traceVal.setLength(0);
		
		return map ;
	 }// end of else
	}
}
