<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<html>
<head>
</head>
<BODY CLASS="MESSAGE" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<p align="left"> 
<%	
Connection con = null;
try
{
	request.setCharacterEncoding("UTF-8");
	// Added by Sridhar on 2 JULY 2004
	// Function chkPractRole will check whether the selected Practitioner is an Consultant Practitioner or not...IF 'Yes'.. then user will have to select another practitioner..

	con = ConnectionManager.getConnection(request);
	String facility_id		= (String) session.getValue( "facility_id" );
	String Function			= checkForNull(request.getParameter( "Function" ));
	String Criteria			= checkForNull(request.getParameter( "criteria" ));
	String Encounter_ID		= checkForNull(request.getParameter( "encounter_ID" ));
	String Practitioner_ID	= checkForNull(request.getParameter( "pract_ID" ));

	
if(Criteria.equals("chkPractRole"))
{
	StringBuffer roleSql = new StringBuffer();
	roleSql.append(" select practitioner_id FROM PR_ENCOUNTER_PRACT WHERE operating_facility_id = '"+facility_id+"' AND encounter_id = '"+Encounter_ID+"' and PRACTITIONER_ROLE in ('2','3') and ROLE_END_TIME is null ORDER BY practitioner_id ");
	
	Statement roleStmt	= null;
	ResultSet roleRS	= null;

	roleStmt= con.createStatement();
	roleRS	= roleStmt.executeQuery(roleSql.toString());
	
	String pract_ID = "";
	String result = "proceed";

	if(roleRS != null)
	{
		while(roleRS.next())
		{
			pract_ID = roleRS.getString("practitioner_id");
			if(pract_ID.equals(Practitioner_ID)) 
				result = "CannotProceed";	
		}
	}

	if(result.equals("CannotProceed"))
	{
		%>
		<script>alert(getMessage('CONSULT_PRACT_CANT_ASSIGN','IP'));</script>
		<%
		if(Function.equals("TransferPatientIn"))
			out.println("<script>parent.frames[2].document.forms[0].practitioner_desc.value=''</script>");
		else
			out.println("<script>parent.frames[1].document.forms[0].pract_desc.value=''</script>");
	}

	if(roleRS	!= null) roleRS.close();
	if(roleStmt	!= null) roleStmt.close();
}
else
{
	String error=request.getParameter( "err_num" );
	if ( error != null ) 
	{	
		String queryString = (String) session.getValue( "queryString" ) ;
		if ( queryString == null ) queryString = "" ;

		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		if ( error_value.equals( "1" ) )
		out.println( "<script language='JavaScript'>onsuccess();</script>" ) ;
	}
}
	}
	catch(Exception e){out.println("eror" + e);}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</p> 
</BODY>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

