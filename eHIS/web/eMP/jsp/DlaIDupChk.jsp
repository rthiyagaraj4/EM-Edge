<!DOCTYPE html>
<html>
<head>	

<%@ page import = "java.util.*,java.sql.*,java.net.*" %>
<%@ page import ="webbeans.eCommon.ConnectionManager,webbeans.eCommon.*"%>
<%@ page import = "eMP.DLAInterfaceUtil" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8"); 
//String locale = ((String)session.getAttribute("LOCALE"));
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title><fmt:message key="eMP.Dlainterfacesearch.label" bundle="${mp_labels}"/></title>

<%

Connection sqlServerConn = null;
PreparedStatement isExistingPStmt = null;
ResultSet isExistingRSet = null;

boolean dlaRequest = false;

String national_id = request.getParameter("national_id");
String patient_id = request.getParameter("patient_id");

String tempQuery = "";

try
{

	sqlServerConn = ConnectionManager.getConnection();						
	tempQuery = DLAInterfaceUtil.getOracleDBQueryByNationalID();



	isExistingPStmt = sqlServerConn.prepareStatement(tempQuery);
	isExistingPStmt.setString(1,national_id.trim());													
	isExistingRSet = isExistingPStmt.executeQuery();



	if(isExistingRSet.next())
	{												
		String pat_id = isExistingRSet.getString(2);
		if(pat_id != null && pat_id.equalsIgnoreCase(patient_id))
		{
		
			dlaRequest = true;
		}
		else
		{
			dlaRequest = false;
		}
	}
	else
	{
		dlaRequest = true;
	}
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{	
	try
	{
		if(isExistingPStmt != null) isExistingPStmt.close();
		if(isExistingRSet != null) isExistingRSet.close();
		if(sqlServerConn != null) ConnectionManager.returnConnection(sqlServerConn);
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
}
	
if(dlaRequest)
{
	RequestDispatcher disp = session.getServletContext().getRequestDispatcher("/eMP/jsp/DlaInterfaceMain.jsp?display=details&national_id="+national_id+"&isFromOracleDB=false");
	disp.forward(request,response);
}
else
{
	RequestDispatcher disp = session.getServletContext().getRequestDispatcher("/eMP/jsp/DlaInterfaceMain.jsp?display=details&national_id="+national_id+"&isFromOracleDB=true");
	disp.forward(request,response);
}

%>

</form>

</html>
