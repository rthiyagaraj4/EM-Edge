<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/TransactionsOfMergeProcess.js'></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad="search_form.patient_id.focus()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
try
{
	con		= ConnectionManager.getConnection(request);
	stmt	= con.createStatement();

	String patient_id = "";
	patient_id = request.getParameter("patient_id");
	if(patient_id == null) patient_id = "";

	String str	= "";
	int pat_id_length	= 0;

	str = "select patient_id_length from mp_param";
	rs = stmt.executeQuery(str);
	while(rs.next())
	{
		pat_id_length = rs.getInt("patient_id_length");
	}
	%>
	 <form name='search_form' id='search_form'>
		<table border='0' width='100%' cellspacing='0' id='query'>
	 		
	<tr><th class='columnheader' colspan='3' ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></th></tr>
			<tr>
				<td class='label' colspan=1  ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields' >
				<input type='text' size=20 maxlength='<%=pat_id_length%>' name='patient_id' value='<%=patient_id%>' onBlur="ChangeUpperCase(this);">
				<input type='button' name='patient_search_button' id='patient_search_button' value='?' class='button' onClick="callPatientSearch()">
				</td>
				<td class='button'><input type=button class='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDuplicatesGroups()">
				</td>
			</tr>
			<tr><td class='label' colspan='3'>&nbsp;</td></tr>
	 	</table>
	</form>
	<%
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

