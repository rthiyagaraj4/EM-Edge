<!DOCTYPE html>

  <%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page contentType="text/html;charset=UTF-8" import=" ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes start --%>
<html>
<head>
	<%
	  request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
	
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>		
		<fmt:message key="ePH.StabilityInformation.label" bundle="${ph_labels}"/>
	</title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

	String sDrugCode				= request.getParameter("drug_code");
	String sRfId					= request.getParameter("rf_id");
	String bean_id					= "DispMedicationBean" ;
	String bean_name				= "ePH.DispMedicationBean";
	DispMedicationBean bean			= (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String stability_info			= bean.getStabilityInfo(sDrugCode,sRfId);
	if(stability_info == null)
	{
		stability_info = "";		
	}
%>
<form name="frmDispMedicationWSStabilityInfo" id="frmDispMedicationWSStabilityInfo">
	<table cellpadding="0" cellspacing="0" width="103%" align="center" border="0" id="wsstabilityinfo">
		<tr>
			<td>
				<textarea cols="50" rows="6" disabled><%=stability_info%>
				</textarea>
			</td>
		</tr>
		<tr>
			<td align="right">
				<input type="button" name="btnClose" id="btnClose" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="button" onClick="window.close()">
			</td>
		</tr>		
	</table>
</form>
</body>
</html>

