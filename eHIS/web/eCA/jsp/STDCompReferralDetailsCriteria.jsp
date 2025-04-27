<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.EncounterRadioButtons.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCA/js/STDCompReferralDetails.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<form name='refDetRadBtnsForm' id='refDetRadBtnsForm'>
		<%
				String encounterID = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
				//out.println("<script>alert('"+encounterID+"')</script>");
				String facilityID = (String)session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");

		%>
			<table cellpadding='3' cellspacing='0' border='0' width='100%'>
				<tr>
					<td class='Label'  width='20%' ><B><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></B> </td>
					<td class='fileds' width='20%' align='right'><input type='radio' name='encBtn' id='encBtn' value='C' checked onclick='loadDetailPage(this)'></td>
					<td class='Label'  width='20%'><fmt:message key="Common.CurrentEncounter.label" bundle="${ca_labels}"/></td>
					<td class='fileds' width='20%' align='right'><input type='radio' name='encBtn' id='encBtn' value='N' onclick='loadDetailPage(this)'></td>
					<td class='Label'  width='20%' ><fmt:message key="eCA.New.label" bundle="${ca_labels}"/></td>
				</tr>
			</table>

			<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityID%>'>
			<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounterID%>'>

		</form>
	</body>
</html>

