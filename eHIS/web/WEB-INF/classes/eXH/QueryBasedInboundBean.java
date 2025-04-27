/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
/**
 * Bean Class used to represent the XH Query Based Inbound Bean
 *
 */

public class QueryBasedInboundBean implements java.io.Serializable
{
  public static String strBeanName = "XH_QUERY_BASED_INBOUND";

  ArrayList	modules	= new ArrayList();  

/**
   * Method to get bean Object
   * @param 
   */
  public static QueryBasedInboundBean getBean(String strBeanName,
														  HttpServletRequest request,
														  HttpSession session)
  {
//	System.out.println("QryBsdInb strBeanName : "+strBeanName);
	
	QueryBasedInboundBean xhBean = null;
    String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
    if(action.equals("S")||action.equals("0"))
    {
	   session.removeAttribute(strBeanName); 
	   xhBean = new QueryBasedInboundBean();
	   session.setAttribute(strBeanName,xhBean);
	}
	else{
   	   xhBean = (QueryBasedInboundBean) session.getAttribute("strBeanName");
	}
//	System.out.println("QryBsdInb xhBean : "+xhBean);
    return xhBean;
  }

/**
   * Method to retrieve all modules names
   * @param  
   */
//  public ArrayList getModules(Connection connection)
  public ArrayList getModules()
  {
	Connection conn = ConnectionManager.getConnection(); 
  //  conn = connection;
    String qryModules = "select 'CR' from dual union SELECT distinct module_id FROM sm_function";
   
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    try{
      pstmt = conn.prepareStatement(qryModules);
      rset = pstmt.executeQuery();
      while(rset.next()){
//		  System.out.println("QueryBasedInboundBean Mod Name : "+rset.getString(1));
		  modules.add(rset.getString(1));
	  }
	// ArrayList tab_test = getTables("AE");
	// System.out.println("tab_test --- "+tab_test);
    }
    catch(Exception exp){
       System.out.println("Error in populatexhcodedesc method of xhapplicationcontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
	finally{
		try{
	      if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();
		  if(conn != null) ConnectionManager.returnConnection(conn);

		}
		catch(Exception es){
				es.printStackTrace() ;
		}
	}
	return modules;
  }

  /*********** Display Query Based Inbound Header Records ***************/

	public HashMap getHeaderData(){
		Connection connection = ConnectionManager.getConnection(); 
		Statement stmt = null;
		ResultSet rs   = null;

		HashMap application	= new HashMap();
		HashMap facility	= new HashMap();
		HashMap event		= new HashMap();
		HashMap segment		= new HashMap();
		HashMap inboundApi	= new HashMap();
		HashMap qryinbheader = new HashMap();

		String qry = "SELECT A.APPLICATION_ID,C.APPLICATION_NAME,A.FACILITY_ID,D.FACILITY_NAME,A.EVENT_TYPE, EVENT_NAME ,A.SEGMENT_ID,SEGMENT_NAME, A.INBOUND_API, B.API_DESC FROM XH_INBOUND_HEADER A,XH_API B,XH_APPLICATION C,SM_FACILITY_PARAM_LANG_VW D,XH_EVENT_TYPE_segment E, XH_SEGMENT F , XH_EVENT_TYPE G WHERE  A.APPLICATION_ID=C.APPLICATION_ID AND A.FACILITY_ID=D.FACILITY_ID AND A.EVENT_TYPE=E.EVENT_TYPE(+)  and a.segment_ID = E.SEGMENT_TYPE (+) AND  A.INBOUND_API=B.API_CODE AND D.language_id='en' AND a.segment_ID = F.SEGMENT_TYPE AND A.EVENT_TYPE = G.EVENT_TYPE ";

		try{
		stmt = connection.createStatement();
		rs = stmt.executeQuery(qry);

			while(rs.next()){
				application.put(rs.getString(1),rs.getString(2));
				facility.put(rs.getString(3),rs.getString(4));
				event.put(rs.getString(5),rs.getString(6));
				segment.put(rs.getString(7),rs.getString(8));
				inboundApi.put(rs.getString(9),rs.getString(10));
			}		
		}
     
	 	catch ( Exception e )	{
			System.err.println( "Error in retrieving header values :" ) ;
			e.printStackTrace() ;
		} 
		finally {
			try{
			     if(rs!=null) rs.close();
				 if(stmt!=null) stmt.close();
				 if(connection != null) ConnectionManager.returnConnection(connection);
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		qryinbheader.put("Application",application);
		qryinbheader.put("Facility",facility);			
		qryinbheader.put("Event",event);
		qryinbheader.put("Segment",segment);
		qryinbheader.put("InboundApi",inboundApi);

		return qryinbheader;
	}

  /*********** Retrieve Table Names based on the selected Module ***************/
	public ArrayList getTables(String mod_name){
		
		Connection connection = ConnectionManager.getConnection(); 
		mod_name = mod_name+"%";
		ArrayList table_names	= new ArrayList();

		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;   
		
		try{
			String tblQuery = "select object_name from all_objects where object_type='TABLE' and object_name like ?" ;
//				System.out.println(" connection : "+connection);
			pstmt = connection.prepareStatement(tblQuery) ;
			pstmt.setString(1,mod_name.trim());
			resultSet	= pstmt.executeQuery();
//				System.out.println(" resultSet.next() : "+resultSet.next());
			while ( resultSet != null && resultSet.next() ) {
				table_names.add(resultSet.getString(1));
			}
		} 
		catch ( Exception e )	{
			System.err.println( "Error retrieving tables :" ) ;
			e.printStackTrace() ;
		} 
		finally {
			try{
			     if(resultSet!=null) resultSet.close();
				 if(pstmt!=null) pstmt.close();
				 if(connection != null) ConnectionManager.returnConnection(connection);
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
//		System.out.println(" tabl_name array: "+table_names);
		return table_names;
	}

	  /*********** Retrieve Column Names based on the selected Table ***************/
	public HashMap getCols(String tbl_name){
		
		Connection connection = ConnectionManager.getConnection(); 
		ArrayList col_names	= new ArrayList();
		ArrayList col_types	= new ArrayList();
		HashMap   col_result= new HashMap();
		

		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		
//			System.out.println(" getCols tbl_name : "+tbl_name);
		try{
			String tblQuery = "SELECT * from "+tbl_name;
//				System.out.println(" getCols tblQuery : "+tblQuery);
 			pstmt = connection.prepareStatement(tblQuery) ;
			resultSet	= pstmt.executeQuery();

		    ResultSetMetaData rsmd = resultSet.getMetaData();
	        int col = rsmd.getColumnCount();
	
		    for (int i=1; i <= col; i++){
			  String col_name = rsmd.getColumnName(i);
			  String col_type = rsmd.getColumnTypeName(i);
				col_names.add(col_name);
				col_types.add(col_type);
			}
				col_result.put("colNames",col_names);
				col_result.put("colTypes",col_types);
		} 
		catch ( Exception e )	{
			System.err.println( "Error retrieving Columns :" ) ;
			e.printStackTrace() ;
		} 
		finally {
			try{
			     if(resultSet!=null) resultSet.close();
				 if(pstmt!=null) pstmt.close();
				 if(connection != null) ConnectionManager.returnConnection(connection);
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}

		return col_result;
	}

  
}//end of class
