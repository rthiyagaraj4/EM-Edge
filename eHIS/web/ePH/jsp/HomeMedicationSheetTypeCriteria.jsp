<!DOCTYPE html>
<!-- 
Developed by    :Arun Kumar M
Module/Function :HomeMedicationSheet
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<title>
	</title>
  <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id				= "HomeMednSheetBean" ;
		String bean_name			= "ePH.HomeMednSheetBean";
		HomeMednSheetBean bean		= (HomeMednSheetBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
		bean.clear();
%>
		<head>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="JavaScript" src="../../ePH/js/HomeMedicationSheetType.js"></script> 
			<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

		<body onKeyDown ='lockKey()' OnMouseDown='CodeArrest()'>
			<form name="HomeMednSheetTypeForm" id="HomeMednSheetTypeForm">
				<table id="tab" border="0" width="90%" cellspacing="0" cellpadding="0" align="left">
					<tr class="COMMON_TOOLBAR">
						<td width="12%" class="white">&nbsp;</td>
						<td class="label" width="20%"><fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
						<td class="feild" width='*'>&nbsp;
							<select name="home_medn_sheet_type" id="home_medn_sheet_type" onChange="Onchangehmemedntype(this)">
								<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------</option>
								<option value="I"><fmt:message key="ePH.Include.label" bundle="${common_labels}"/></option>
								<option value="S"><fmt:message key="ePH.Separate.label" bundle="${common_labels}"/></option>
								<option value="O"><fmt:message key="ePH.Only.label" bundle="${common_labels}"/></option>
							</select>
						</td>		
					</tr>
				</table>
				<br><br><br>
				<table border="0" width="40%" cellspacing="0" cellpadding="0"  id='tblTab' align="left" style='display:none;'>
					<tr>
						<td width="12%" class="white">&nbsp;</td>
						<td class="clicked"  width="44%" height="20" id="select_col">
						<a href="javascript:tabData(this,'S')" id="select" style="color:white;"><b>
						<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b> </a>
						</td>
						<td class="normal" width="44%" height="20" id="association_col">
						<a href="javascript:tabData(this,'A')" id="association" style='color:white;'><b>
						<fmt:message key="Common.Association.label" bundle="${common_labels}"/></b></a>
						</td>
					</tr>
			</table>	
		</form>
	</body>
</html>

