<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,webbeans.eCommon.*" %>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eOA/js/WaitListInvitation.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
try
{
%>
		<html>
		<head>
		</head>
		<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='seacr_collapse_form' id='seacr_collapse_form' >
		
<table name='waitMgmtTable1' id='waitMgmtTable1' width='100%' align='center' cellpadding='0' cellspacing='0' border='0'>
			
			<tr>	
					
					<td width='95%' class='bodycolorfilled'></td>
					
					<td class=button  nowrap ><input type='Button' class='button' name='invitation_list' id='invitation_list' value='<fmt:message key="Common.invitationlist.label" bundle="${common_labels}"/>' onclick='invoke_invitation();'>&nbsp;<input type='button' name='Select' id='Select' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='callResult();' tabindex=12>&nbsp;<input type=button name='Clear' id='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='ClearForms();' tabindex=13></td>
			</tr>
</table>
	</form>
	</body>
	</html>

			
<%}catch(Exception e){
	//out.println("asdsad :" +e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	
}
%>

