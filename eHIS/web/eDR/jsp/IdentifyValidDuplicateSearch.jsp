<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ page import="eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/IdentifyValidDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad="search_form.patient_id.focus()" onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<form name='search_form' id='search_form'>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String patient_id	= "";
	String modal		= "";
	String str			= "";

	int pat_id_length	= 0;

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		patient_id	= request.getParameter("patient_id");
		modal		= request.getParameter("modal");
		
		

		if(modal==null || modal.equals("null"))
			modal="N";

		if(patient_id == null) patient_id = "";
		
		str = "select patient_id_length from mp_param";
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			pat_id_length = rs.getInt("patient_id_length");
		}

		%>
		
		 <%	if(modal != null && modal.equals("Y")) { %>
		
	<table border=0 width=100% cellspacing=0 id='dum'>
			<tr><td class='label' colspan='2'>&nbsp;</td></tr>
	</table>
		<% } %>
	
	<table border='0' width='100%' cellspacing='0' id='query'>
	 		
		<tr><th class='columnheader' colspan='3' style="text-align:left;"><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></th></tr>
			
		<tr>
			<td class='label' colspan=1 ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				
			<td class='fields' >
				<input type='text' size=20 maxlength='<%=pat_id_length%>' name='patient_id' value='<%=patient_id%>' onBlur="touppercase(this)"><input type='button' name='patient_search_button' id='patient_search_button' value='?' class='button' onClick="callPatientSearch()">
				</td>
				
			<td class='button' ><input type=button class=button name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDuplicatesGroups()">
				</td>
		</tr>
			
		<tr><td class='label' colspan='3'>&nbsp;</td></tr>
 	</table>
					<input type="hidden" name="modal" id="modal" value='<%=modal%>'>
		</form>
		<%

		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
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

