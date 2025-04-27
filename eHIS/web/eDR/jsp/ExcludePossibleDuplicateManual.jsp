<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
	Developed on   	   :  27/02/2001
	Module Name 	   :  eHIS/eDR
	Function Name	   :  Exclude Possible Patients
-->
 <%@ page import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" contentType="text/html;charset=UTF-8" %>
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
	<script language='javascript' src='../../eDR/js/ExcludePossibleDuplicates.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String name1	= "";
	String name2	= "";
	String str		= "";

	String patient_id1	= request.getParameter("patient_id1");	
	String patient_id2	= request.getParameter("patient_id2");
	if(patient_id1 == null || patient_id1.equals("undefined")) patient_id1	= "";
	if(patient_id2 == null || patient_id2.equals("undefined")) patient_id2	= "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		int pat_id_length	= 0;
		int pat_id_size		= 0;
		

		str = "SELECT patient_id_length FROM mp_param";
		rs = stmt.executeQuery(str);
		while(rs.next())
		{
			pat_id_length = rs.getInt("patient_id_length");
		} 

		 pat_id_size	= pat_id_length + 2;

		 
		 

%>
<body onLoad="FocusFirstElement()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<br><br><br><br><br><br><br><br><br>
		<form name='possible_duplicates' id='possible_duplicates' action='../../servlet/eDR.ExcludePossibleDuplicateServlet'  method='post' target='messageFrame'>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='50%'>
				<tr><th class='columnheader' colspan='4' align='left'><fmt:message key="eDR.NonDuplicates.label" bundle="${dr_labels}"/></th></tr>	
				<tr><td class='label' colspan='4'>&nbsp;</td></tr>
				<tr><td class='label' colspan='4'>&nbsp;</td></tr>
				<tr>
				<td class='label'  width='5%'>
					<%
					if(name1.equals(""))
					{
						%>
						<td class='label' width='45%'><fmt:message key="eDR.PatientID1.label" bundle="${dr_labels}"/></td>		
						<%
					}
					else
					{
						%>
						<td class='label'width='45%'><fmt:message key="eDR.PatientID1.label" bundle="${dr_labels}"/><a href='javascript:viewPatientDetails("<%=patient_id1%>")'>+</a></td>		
						<%
					}
					%>
					<td class='fields' width='25%' style="display:flex"><input type='text' size=20 maxlength=<%=pat_id_length%> value='<%=patient_id1%>'    name='patient_id1'  onKeyPress="return CheckForSpecChars(event)" onBlur="makeValidQueryCriteria(this);call_patient_id1('ExcludePossibleDuplicateManual',this)"><input type='button' class='Button' name='pat_search1' id='pat_search1' value='?' onclick="search_patient_ID1('ExcludePossibleDuplicateManual','<%=patient_id2%>');"> </td>
					<td class='label' width='25%'></td>		
				 </tr>	
				<tr height=4px>
					<td class=label align='right' width='5%'>		
					<td class='label' width='45%'></td>
					<td class='OTHLANGLABEL' id='pat_name1' width='25%'><%=name1%></td>
					<td class='label' width='25%'></td>		
				</tr>
				<tr>
					<td class='label'  width='5%'>	
					<% 
					if(name2.equals(""))
					{
						%>
						<td class='label'  width='45%'><fmt:message key="eDR.PatientID2.label" bundle="${dr_labels}"/></td>
						<%
					}
					else	
					{
						%>
						<td class='label'  width='45%'><fmt:message key="eDR.PatientID2.label" bundle="${dr_labels}"/><a href='javascript:viewPatientDetails("<%=patient_id2%>")'>+</a> </td>
						<%
					}
					%>
					<td class='fields'  width='25%'><input type='text'  value='<%=patient_id2%>' size='20' maxlength='<%=pat_id_length%>'  name='patient_id2'  onKeyPress="return CheckForSpecChars(event)"  onBlur="makeValidQueryCriteria(this);call_patient_id2('ExcludePossibleDuplicateManual',this);"><input type='button' class='Button' name='pat_search2' id='pat_search2' value='?' onclick="search_patient_ID2('ExcludePossibleDuplicateManual','<%=patient_id1%>');"></td>
					<td class='label'  width='25%' >&nbsp;</td>		
				</tr>	
				<tr>
					<td class='label' align='right' width='5%'>		
					<td class='label' width='45%'>&nbsp;</td>
					<td class='OTHLANGLABEL' id='pat_name2' width='25%'><%=name2%></td>
					<td class='label' align='right' width='25%'></td>		
				</tr>	
				<tr><td class='label' colspan='4'>&nbsp;</td></tr>
				<tr><td class='label' colspan='4'>&nbsp;</td></tr>
			</table>
			<input type='hidden' name='verify_pat1' id='verify_pat1' value='<%=patient_id1%>'>
			<input type='hidden' name='verify_pat2' id='verify_pat2' value='<%=patient_id2%>'>
			<input type='hidden' name='mode' id='mode' value='insert'> 
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

