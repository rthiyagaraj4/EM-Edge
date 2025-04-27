<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/EditDispLabel.js"></script> 
		<script language="javascript" src="../js/DrugNameCommonLookup.js"></script> 
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="focusOnPatientField()" topmargin="0"> 
<%
		String	bean_id			=	"EditDispLabelBean" ;
		String	bean_name		=	"ePH.EditDispLabelBean";
		EditDispLabelBean bean = (EditDispLabelBean)getBeanObject( bean_id,bean_name,request);
		bean.setLanguageId(locale);
		String sys_date=(String) com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		bean.getEditLabelDefltValues(); //Added for Bru-HIMS-CRF-414 [IN045554]
%>
		<form name="FormEditDispLabelQryCriteria" id="FormEditDispLabelQryCriteria">
			<table cellpadding="0.5" cellspacing="1" width="100%" align="center" border="0" topmargin="0">
				<tr>
					<td  class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td >	<input type="text" name="patient_id" id="patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="18" value="" onKeyPress="uppercase()" onBlur="callPatientSearchTabOut()"><input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()" >
					</td>
					<td  class="label" nowrap><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
					<td align="left"><input type="text" name="Dispense_No" id="Dispense_No" size="15"  maxlength="15" ></td>
					<td class="label" nowrap>	<fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></td>
					<td><input type=text  name="Dispense_Date" id="Dispense_Date" size=8 maxlength="10" onBlur="validateDate(FormEditDispLabelQryCriteria,this,'<%=locale%>')" value=""><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('Dispense_Date');"></TD>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td COLSPAN="4">&nbsp;</td>
					<td align='right'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="loadQueryResultPage(FormEditDispLabelQryCriteria)"></td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<input type="hidden" name="system_date" id="system_date" value="<%=sys_date%>">
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html> 

