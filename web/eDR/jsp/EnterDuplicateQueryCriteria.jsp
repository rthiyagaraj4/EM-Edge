<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" import="eDR.*" %>
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

	<script language='javascript' src='../../eDR/js/EnterDuplicatesPatientID.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js"></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>	
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="search_form1.patient_id1.focus()" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet	rs			= null;
	String function_name    = "";   
	
	//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
	Boolean isMergeDeceasedPatIdAppl = false;
	
try
{
	con = ConnectionManager.getConnection(request);
	stmt					=con.createStatement();

	isMergeDeceasedPatIdAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"DR","MERGE_DECEASED_PATIENTID");//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815

	String patient_id = "";
	patient_id = request.getParameter("patient_id");
	function_name = request.getParameter("function_name");
	if(patient_id==null)patient_id="";
	String str="";
	int pat_id_length=0;
	int pat_id_size=0;

	str = "select patient_id_length from mp_param";
	rs = stmt.executeQuery(str);
	
	while (rs.next())
	{
		pat_id_length = rs.getInt("patient_id_length");
	}
		pat_id_size = pat_id_length + 2;
%>
 <form name='search_form1' id='search_form1'>
	<table border=0 width='100%' cellspacing=0 id='query'>
 		
		<tr><th class='columnheader' colspan='5' ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></th>	</tr>
		
		<tr><td class='label' height='3' colspan='5'></td></tr>
		
		<tr>
			<td class=label colspan=1 ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			
			<td class='fields'>
				<input type='text' size=20 maxlength="<%=pat_id_length%>" name='patient_id1' value='<%=patient_id%>' onKeyPress="return CheckForSpecChars(event)" onBlur="makeValidQueryCriteria(this);callPatientLine1(this,'ENTER_DUPLICATE1')" ><input type='button' name='patient_search_button' id='patient_search_button' value='?' class='button' onClick="callPatientSearch1()">
				<input type=hidden name='mode' id='mode' value='first'></td>
			
			<td class=label colspan=1  ></td>
			
			<td class='label' ></td>
			
			<td class='button' >
				<input type=button class=button name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResult()">		
				<input type=button class=button name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="callClear();" >
			</td>
			
		<tr><td class='label' colspan='5'></td></tr>
		<input type='hidden' name='function_name' id='function_name' value='<%=function_name%>'>

		<!--Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815-->
		<input type='hidden' name='isMergeDeceasedPatIdAppl' id='isMergeDeceasedPatIdAppl' value='<%=isMergeDeceasedPatIdAppl%>'>

 	</table>
</form>
<%		
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception e :"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='reset5' id='reset5' value='reset1'>
</body>
</html>

