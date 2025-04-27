<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.FillingPersonDetail.label" bundle="${ph_labels}"/></title>
	</head>
	<body onMouseDown="CodeArrest()" onLoad='setFocus(document.DispMedicationFillPersonDetail.btnOk);'>
		<form name="DispMedicationFillPersonDetail" id="DispMedicationFillPersonDetail" >
<%
			String  bean_id				= request.getParameter("bean_id");
			String  bean_name			= request.getParameter("bean_name");
			bean_id				=	"DispMedicationAllStages" ;
			bean_name			=	"ePH.DispMedicationAllStages";
			
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
			//bean.setLanguageId(locale);
			String FilledPersonName="";
			if(bean.getUserAuthPINRequiredYN().equals("Y") && !bean.getAuthUserID().equals(""))
				 FilledPersonName = bean.getAuthUserName(bean.getAuthUserID());
			else
				 FilledPersonName = bean.getFilledPersonName();
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<td class="label" nowrap><fmt:message key="ePH.FilledPersonName.label" bundle="${ph_labels}"/></td><td><input type="text" name="fill_person_name" id="fill_person_name" value="<%=FilledPersonName%>" size="60" maxlength="60" readonly><img src="../../eCommon/images/mandatory.gif" align="center"></td>
				</tr>
				<tr>
					<td colspan='2'>
					<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button"  onClick="callFillPersonInsert(DispMedicationFillPersonDetail);" name='btnOk' onKeyPress='ok_enter_event(event, this);'>
					</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		</form>
	</body>
	<script>
	function setFocus(obj){ //Added for AMS-CRF-0009[IN:030935]
		obj.focus();
		//document.DispMedicationFillPersonDetail.btnOk.focus();
	}
	</script>
</html>
<%
//putObjectInBean(bean_id,bean,request);
%>

