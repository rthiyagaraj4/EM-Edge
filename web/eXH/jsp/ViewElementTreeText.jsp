<!DOCTYPE html>
 <HTML>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page import = "java.util.*,java.io.*,java.lang.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js" ></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
<script language='javascript' src='../../eXH/js/ViewServerProcessErrors.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()' >
<%

Connection dbConn = null;
Statement stmt = null; 
ResultSet rs = null;
String eventName=XHDBAdapter.checkNull(request.getParameter("event"));
String Element_desc="";
try
{ 
	dbConn = ConnectionManager.getConnection(request);
}
catch(Exception w)
{
	System.out.println("Errors in ViewElementTreeText.jsp "+w);
}
try
{
	String sqlstr="Select ELEMENT_DESC FROM XH_ELEMENT_CROSSREF where ELEMENT_NAME='"+eventName+"' ";
	stmt= dbConn.createStatement();
	//System.out.println(sqlstr);
	rs = stmt.executeQuery(sqlstr);
	while(rs.next())
	{
		//System.out.println(XHIdentify.returnvalue(rs.getClob(1)));
		Element_desc=XHIdentify.returnvalue(rs.getClob(1)); 
	}   
}
catch(Exception e)
{
	System.out.println("Errors in ViewElementTreeText.jsp "+e);
}
finally
	{
	 try{
			if(rs!=null)	   
			{
				rs.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
			ConnectionManager.returnConnection(dbConn);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewElementTreeText.jsp :"+ex.toString());
		   ex.printStackTrace(System.err); }
	} 



 %> 
<table cellspacing=0 cellpadding=3 width="100%" align="center"> 
<tr>
	<td class=label><%=eventName%> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td> 
</tr> 
<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="35" COLS="65" readOnly><%=java.net.URLDecoder.decode(Element_desc)%></TEXTAREA></td> 
</tr> 
</table>
</BODY>
</HTML> 

