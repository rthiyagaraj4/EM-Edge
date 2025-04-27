<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.NoteTypeForResponosibilityHeader.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		/** added by kishore kumar n on 11/12/2008  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/NoteTypeForResp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onLoad="document.formNoteTypeRespHdr.group_by.focus();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='formNoteTypeRespHdr' id='formNoteTypeRespHdr'>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr><td colspan='2'></td></tr>
		<tr>
			<td class='label' width='25%'><fmt:message key="eCA.AccessRightsfor.label" bundle="${ca_labels}"/></td>
			<td class='fields'><select name='group_by' id='group_by' onChange='return fetchDetailsRecords(this);'>
				<option value=""> ------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </option>	
				<option value="RS"><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></option>
				<option value="NT"><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option>
				<option value="PR"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value="SP"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>

			</select><img src="../../eCommon/images/mandatory.gif"></img></td>
		</tr>
		<tr><td colspan='4'></td></tr>
	</table>
				<!-- added by kishore kumar n on 11/12/2008  -->
				<%if(!imgUrl.equals("")){ %>
					 <img id='searchBoxBG' style='display' src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
				<!--ends here -->
</form>
</body>
</html>

