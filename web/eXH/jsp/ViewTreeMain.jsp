<!DOCTYPE html>
<%@ page import = "java.util.*" %> 
<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.*,oracle.jdbc.driver.*" %>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% 
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String params = request.getQueryString()+"&rule=R&rule2=H"; 
	String url2 =""; 
	String img = XHDBAdapter.checkNull(request.getParameter("img"));  									  
	Properties p = (Properties) session.getValue("jdbc");
	String loggedUser = p.getProperty("login_user");
	String url1 = "../../eXH/jsp/ViewTree.jsp?"+params; 
	Connection connection = null; 
	boolean authToElement = false;															   
	try																							 
	{												   
		if(connection == null) connection = ConnectionManager.getConnection();
	}
	catch(Exception e)
	{
		System.out.println("Error in Connection dbrealted  ViewTreeMain.jsp Exception :"+e);							    
	}
    String authSql = "SELECT ELEMENT_DESC_YN FROM xh_authorized_user WHERE UPPER(LOGIN_NAME)=UPPER('"+loggedUser+"')"; 
	ResultSet authRS = null;
	try
	{
		authRS = connection.createStatement().executeQuery(authSql);
		if(authRS.next())
		{		
			String strele_desc_yn = authRS.getString("ELEMENT_DESC_YN");
			if(strele_desc_yn != null && strele_desc_yn.equalsIgnoreCase("Y")) authToElement = true;	
		}
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		
	try{
		if(authRS != null) authRS.close();
		ConnectionManager.returnConnection(connection);
	   }catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewTreeMain.jsp :"+ex.toString());
	ex.printStackTrace(System.err); }
	}
    url2 = "../../eCommon/html/blank.html";
%> 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title><fmt:message key="eXH.MessageViewer.Label" bundle="${xh_labels}"/></title> 
<%if(img.equals("Y"))
{%>
<iframe name='f_query_message_viewer' id='f_query_message_viewer' src='<%=url1%>' frameborder=2  noresize scrolling='auto' style='height:97vh;width:97vw'></iframe>
	<%
}else												 
{
		if(authToElement)														 
	{
		%>													   
<iframe name='f_query_message_viewer' id='f_query_message_viewer' src='<%=url1%>' frameborder=2  noresize scrolling='auto'style='height:50vh;width:98w'></iframe>
<iframe name='f_query_message_text' id='f_query_message_text' src="<%=url2%>" frameborder=2 noresize scrolling='auto' style='height:48vh;width:98vw'></iframe>
<%}
		else
	{
			%>
			<iframe name='f_query_message_viewer' id='f_query_message_viewer' src='<%=url1%>' frameborder=2  noresize scrolling='auto' style='height:98vh;width:98vw'></iframe>
<%}
}%>													    
</html>		   															    

