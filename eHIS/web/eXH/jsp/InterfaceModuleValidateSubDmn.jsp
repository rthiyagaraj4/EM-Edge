<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
 
<%

		Connection connection	=  null;
		Statement statement		=  null;
		ResultSet resultSet		=  null;

		try 
		{

			String func_mode			=  request.getParameter("func_mode");
//				System.out.println("InterfaceModuleValidateSubDmn.jsp : "+func_mode);
			Hashtable hash				=  (Hashtable)xmlObj.parseXMLString( request ) ;
			hash								=  (Hashtable)hash.get( "SEARCH" ) ;

			if(func_mode!= null && func_mode.equals("chkTables")) 
			{
				String sub_domain		 = (String) hash.get( "base_unit" );
//					System.out.println("InterfaceModuleValidateSubDmn.jsp sub_domain: "+sub_domain);
//				String sql = "SELECT * FROM ALL_OBJECTS WHERE object_type='TABLE' AND OBJECT_NAME LIKE '"+sub_domain+"%"+"' AND OWNER='IBAEHIS' ";
				String sql = "SELECT * FROM ALL_OBJECTS WHERE object_type='TABLE' AND OBJECT_NAME LIKE '"+sub_domain+"%"+"' AND OWNER='MEDICOM' ";
					//System.out.println("sql : "+sql);


				connection=ConnectionManager.getConnection();
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
				resultSet = statement.executeQuery(sql);	
				resultSet.last();
				int rowcount = resultSet.getRow();
//					System.out.println("rowcount : "+rowcount);
				out.println("dispchkTables('"+rowcount+"')");
			} // end of chkTables
		}
		catch (Exception e) 
		{
		//	System.out.println(" (InterfaceModuleValidateSubDmn.jsp:sqlall_objectsQuery)  : "+sql);
			e.printStackTrace() ;
		}
		finally
		{
			try{
					 if(resultSet!=null) resultSet.close();
					 if(statement!=null) statement.close();
				}catch(Exception es){
					es.printStackTrace() ;
				}
				if(connection!=null){
					ConnectionManager.returnConnection(connection);
				}
		}

%>
