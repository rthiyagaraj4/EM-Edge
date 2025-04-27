<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	 <%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src='../../eCA/js/PatEncBanner.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()" >
		<form name='patEncBannerHdrForm' id='patEncBannerHdrForm'>
			<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
				<tr>
					<td class='label'> <fmt:message key="eCA.BannerType.label" bundle='${ca_labels}'/>
						<select name='patEncList' id='patEncList' onchange="loadPatEncBanner()">
							<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle='${common_labels}'/>----</option>
							<option value='P'><fmt:message key="eCA.PatientContextBanner.label" bundle='${ca_labels}'/></option>
							<option value='E'><fmt:message key="eCA.EncounterContextBanner.label" bundle='${ca_labels}'/></option>
						</select>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

