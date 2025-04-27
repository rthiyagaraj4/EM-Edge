<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History  Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
05/06/2018  IN67872	  Dinesh T	05/06/2018	Ramesh G			GHL-CRF-0497.1
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection			con			=	null;
	PreparedStatement			stmt		=	null;
	ResultSet			rs			=	null;
	String remarks="";

	try
	{
		
		con				=	ConnectionManager.getConnection(request);
		String accession_num = checkForNull(request.getParameter("accession_num"));
		String  query = "SELECT ACTION_COMMENT FROM CA_ENCNTR_NOTE_AUDIT_LOG WHERE ACCESSION_NUM=? AND ACTION_STATUS='RJ' order by added_date desc";
		stmt = con.prepareStatement(query);
		stmt.setString(1, accession_num);
		
		rs = stmt.executeQuery();

		if(rs.next())
		{
			remarks=rs.getString("ACTION_COMMENT");
		}
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1: "+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
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
	<form name='RecClinicalNotesRejectForm' id='RecClinicalNotesRejectForm'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' >
		<tr><td class='fields' width='75%'><TEXTAREA NAME="action_comment" ROWS="3"  COLS="55" onKeyPress="checkMaxLimit(this,200);" readonly><%=remarks%></TEXTAREA></img></td></tr>
		<tr><td colspan=4 width='100%' align ='right'><input type='BUTTON' class='BUTTON' name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closeWindow();'>&nbsp;</td></tr>
		</table>
	</form>
	</center>
</body>
</html>

