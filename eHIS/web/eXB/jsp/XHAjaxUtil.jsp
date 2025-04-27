<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=ISO-8859-1" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	Connection connection	= null;
	Statement statement		= null;
	ResultSet resultSet		= null;

	try 										   
	{				
		Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
		hash = (Hashtable)hash.get("SEARCH") ;
		String sqlQuery = (String)hash.get("query");
		String field = (String)hash.get("field");
		String toDisplay = (String)hash.get("toDisplay");
	//	System.out.println("toDisplay "+toDisplay);
			
		try
		{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp)
		{
			System.out.println("Error in calling getconnection method of XHAjaxUtil :"+exp.toString());
			exp.printStackTrace(System.err);		       
		}
		
		statement = connection.createStatement();
	//	System.out.println("(XHAjaxUtil:Query) "+sqlQuery);
		resultSet = statement.executeQuery(sqlQuery);
		
		while(resultSet.next())
		{	
			if(field != null)
			{
				String id	=	(String)resultSet.getString("code");
				String desc =	(String)resultSet.getString("name");
			//	System.out.println("id "+id+"desc "+desc);
				if("id".equalsIgnoreCase(toDisplay))
				{
					out.println("addOptions('"+id+"','"+id+"','"+field+"')");
				}
				else if("both".equalsIgnoreCase(toDisplay))
				{
					out.println("addOptions('"+id+"','"+id+"-"+desc+"','"+field+"')");
				}
				else
				{
					out.println("addOptions('"+id+"','"+desc+"','"+field+"')");
				}
			}
			else
			{
				out.println("Y");
				break;
			}
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
			es.printStackTrace(System.err) ;
		}
		if(connection!=null)
		{
			ConnectionManager.returnConnection(connection);
		}
	}
%>
