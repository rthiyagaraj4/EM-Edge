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
 * Bean Class used to represent the XH Element Segment Bean
 *
 */

public class ElementSegmentConfBean implements java.io.Serializable
{
  public static String strBeanName = "XH_ELEMENT_SEGMENT_CONF";

  ArrayList	modules	= new ArrayList();  

/**
   * Method to get bean Object
   * @param 
   */
  public static ElementSegmentConfBean getBean(String strBeanName,
														  HttpServletRequest request,
														  HttpSession session)
  {
	ElementSegmentConfBean xhBean = null;
    String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
    if(action.equals("S")||action.equals("0"))
    {
       session.removeAttribute(strBeanName); 
	   xhBean = new ElementSegmentConfBean();
	   session.setAttribute(strBeanName,xhBean);
	}
	else{
   	   xhBean = (ElementSegmentConfBean) session.getAttribute("strBeanName");
	}
    return xhBean;
  }

/**
   * Method to retrieve all modules names
   * @param  
   */
  public ArrayList getModules()
  {
	Connection conn = ConnectionManager.getConnection(); 
    String qryModules = "select 'CR' from dual union SELECT distinct module_id FROM sm_function";
   
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    try{
      pstmt = conn.prepareStatement(qryModules);
      rset = pstmt.executeQuery();
      while(rset.next()){
		  modules.add(rset.getString(1));
	  }
    }
    catch(Exception exp){
       System.out.println("Error in populatexhcodedesc method of xhapplicationcontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
	finally{
		try{
	      if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();
  		  ConnectionManager.returnConnection(conn);
		}
		catch(Exception es){
				es.printStackTrace() ;
		}
	}
	return modules;
  }

  /*********** Retrieve Table Names based on the selected Module ***************/
	public ArrayList getTables(String mod_name){
		
		Connection connection = ConnectionManager.getConnection(); 
		mod_name = mod_name+"%";
	
		ArrayList table_names	= new ArrayList();

		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;   
		
		try{
			String tblQuery = "select object_name from all_objects where object_name LIKE ? and (object_type='TABLE' OR object_type='VIEW')";
				pstmt = connection.prepareStatement(tblQuery) ;
			pstmt.setString(1,mod_name.trim());
			resultSet	= pstmt.executeQuery();
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
 		 		ConnectionManager.returnConnection(connection);
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
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
		

		try{
			String tblQuery = "SELECT * from "+tbl_name;
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
 		 		ConnectionManager.returnConnection(connection);
 		 		col_names.clear();
 		 		col_types.clear();
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}

		return col_result;
	}


  /*********** Retrieve StandardCode ***************/
	public ArrayList getStndCode(String conf_name){		
		Connection connection = ConnectionManager.getConnection(); 

		String stnd_code = "";
		String stnd_desc = "";
		ArrayList  result = new ArrayList();

		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;      
		String sql	= "";
		
		try{
			sql = "SELECT A.standard_code,B.standard_desc FROM XH_SEGMENT A,XH_STANDARD B WHERE A.segment_type='"+conf_name+"' AND A.STANDARD_CODE = B.STANDARD_CODE ";
 			pstmt = connection.prepareStatement(sql) ;
			resultSet	= pstmt.executeQuery();
			
			while ( resultSet != null && resultSet.next() ) {
				stnd_code = XHDBAdapter.checkNull(resultSet.getString(1));
				stnd_desc = XHDBAdapter.checkNull(resultSet.getString(2));
			}
			result.add(stnd_code);
			result.add(stnd_desc);
		} 
		catch ( Exception e )	{
			System.err.println( "Error retrieving Columns :" ) ;
			e.printStackTrace() ;
		} 
		finally {
			try{
			     if(resultSet!=null) resultSet.close();
				 if(pstmt!=null) pstmt.close();
		 		ConnectionManager.returnConnection(connection);
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return result;
	}
}//end of class
