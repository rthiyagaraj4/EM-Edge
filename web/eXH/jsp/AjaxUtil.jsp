<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 

<%
	Connection connection	= null;
	Statement statement		= null;
	ResultSet resultSet		= null;

	try 										   
	{		
	//	String func_mode = request.getParameter("func_mode");	
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		String module_id = (String) hash.get( "base_unit" );

		//System.out.println("Module ID "+module_id);
	
		String sqlQuery = 
			"SELECT DISTINCT INTERFACE_MODULE_ID, INTERFACE_DESC FROM XH_INTERFACE WHERE MODULE_ID='"+module_id+"'";
		System.out.println("(AjaxUtil.jsp:sqlInterfaceModuleQuery) "+sqlQuery);
		try												   
		{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp)
		{
			System.out.println("Error in calling getconnection method of AjaxUtil :"+exp.toString());
			exp.printStackTrace(System.err);		       
		}
		
		statement = connection.createStatement();
		
		resultSet = statement.executeQuery(sqlQuery);
		
		while(resultSet.next())
		{
		//	System.out.println("SubModule "+resultSet.getString("INTERFACE_MODULE_ID"));
			String id	=	(String)resultSet.getString("INTERFACE_MODULE_ID");
			String desc =	(String)resultSet.getString("INTERFACE_DESC");
			out.println("addOption('"+id+"','"+desc+"')");
		}

	}
	catch (Exception e) 
	{
		e.printStackTrace() ;
	}
	finally
	{
		try
		{
			 if(resultSet!=null) resultSet.close();
			 if(statement!=null) statement.close();
		}
		catch(Exception es)
		{
			es.printStackTrace() ;
		}
		if(connection!=null)
		{
			ConnectionManager.returnConnection(connection);
		}
	}



%>
