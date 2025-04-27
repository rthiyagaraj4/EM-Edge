<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.text.*,webbeans.eCommon.*" %>
<%
request.setCharacterEncoding("UTF-8");
Connection con=null;
Statement stmt   	= null ;
ResultSet rset	   	= null;

try{
	con = ConnectionManager.getConnection(request);
	stmt   	= con.createStatement() ;
int pat_id_len=0;

			rset=stmt.executeQuery("Select Patient_Id_Length,Nat_Id_Length,alt_id1_length, pat_name_as_multipart_yn from mp_param");
			if(rset!=null && rset.next())
				{
			pat_id_len=rset.getInt("Patient_Id_Length");
				}


	%>

	<html>
	<head>
	<script language='javascript' src='../../eOA/js/QueryWaitListAudit.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	 <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body  onload="focus();" OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="QueryLocnForDay" id="QueryLocnForDay">
	<table  width='100%' cellspacing='0' cellpadding='0' border='0' >

	<tr>
		<td class='label' nowrap><fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/></td>
		
		<td class='fields' nowrap>
			<input type=text name='WaitListNo' id='WaitListNo' size='10' maxlength='12' value='' >
			<img  src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>

		<td  class='label' nowrap><fmt:message key="eOA.InvitedDate.label" bundle="${oa_labels}"/></td>

		<td class='fields' nowrap>
				
			<input type='text' name='invDate' id='invDate'  value='' size='10' maxlength='10' onBlur="ValidateDate(this);" ><img  style="cursor:pointer" id='img1'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].invDate.focus();return showCalendar('invDate');">
				
		</td>
		

	</tr>

	<tr>
		<td class='label' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>

		<td class='fields' >
			<input type=text name='patientid' id='patientid' size='<%=pat_id_len%>'  maxlength='<%=pat_id_len%>' value='' onblur='changeCase(this);' ><input type=button name='commonLookup' id='commonLookup' value='?' class='button' onclick='callPatientSearch(); '>
		</td>

		<td class='label' nowrap ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>

		<td class='fields' >
			<input type=text name='patientName' id='patientName' size='40' maxlength='60' value='' >
		</td>
</tr>
<tr>
		<td class='button' colspan='4' align="right">
			<input type='button' class='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' OnClick='CallResult()'>&nbsp;<input type='button' class='button' name='Cancel' id='Cancel' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' OnClick='CancelResult()'>	
		</td>
</tr>

	

			</table>
<%
	if(rset !=null)rset.close();
	if(stmt !=null)stmt.close();
}catch(Exception es){
//out.println(es.toString());
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
	ConnectionManager.returnConnection(con,request);
}
%>

</body>
</html>

