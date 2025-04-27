<!DOCTYPE html>
<%
/*
-------------------------------------------------
Date		Edit History  Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
21/06/2016  IN035478	  Raja S				    30/04/2014			Alpha-CA- Error remarks are not displayed if it is marked as error from other facility.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection			con			=	null;
	PreparedStatement			stmt		=	null;
	ResultSet			rs			=	null;
	String remarks="";

	try
	{
		
		con				=	ConnectionManager.getConnection(request);
		String facility_id = checkForNull(request.getParameter("facility_id"));
		String accession_num = checkForNull(request.getParameter("accession_num"));
		/* Commented for IN035478 starts
		String  query = "SELECT ACTION_COMMENT FROM CA_ENCNTR_NOTE_AUDIT_LOG WHERE FACILITY_ID=? AND ACCESSION_NUM=? AND ACTION_TYPE='ER'"; 
		
		stmt = con.prepareStatement(query);
		stmt.setString(1, facility_id);
		stmt.setString(2, accession_num); 
		
		Commented for IN035478 ends */

		/*Added for IN035478 starts */
		String  query = "SELECT ACTION_COMMENT FROM CA_ENCNTR_NOTE_AUDIT_LOG WHERE ACCESSION_NUM=? AND ACTION_TYPE='ER'";
		stmt = con.prepareStatement(query);
		stmt.setString(1, accession_num);
		/*Added for IN035478 ends */
		rs = stmt.executeQuery();

		while(rs.next())
		{
			remarks=rs.getString(1);
		}
		
	
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1: "+e);//COMMON-ICN-0181
                   e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

%>
<html>
<head>
	<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script>
	 function closeWindow()
	 {
		window.close();
	 }
	</script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  class='CONTENT'>
	<center>
	<form name='RecClinicalNotesForwardForm' id='RecClinicalNotesForwardForm'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' >
		<tr><td class='fields' width='75%'><TEXTAREA NAME="action_comment" ROWS="3"  COLS="55" onKeyPress="checkMaxLimit(this,200);" readonly><%=remarks%></TEXTAREA></img></td></tr>
		<tr><td colspan=4 width='100%' align ='right'><input type='BUTTON' class='BUTTON' name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closeWindow();'>&nbsp;</td></tr>
		</table>
	</form>
	</center>
</body>
</html>

<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

%>

