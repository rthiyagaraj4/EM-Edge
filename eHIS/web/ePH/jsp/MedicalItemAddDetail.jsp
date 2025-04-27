<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	
	
	String bean_id	="MedicalItemBean";
	String bean_name	="ePH.MedicalItemBean";
    String sql_ph_drug_select19	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT19");
    String link=request.getParameter("link");
    String Drug_code_value=request.getParameter("Drug_code_value");
    String mode=request.getParameter("mode");
	
   
	MedicalItemBean bean = (MedicalItemBean)getBeanObject(bean_id,bean_name ,request);
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/MedicalItem.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body  onKeyDown="lockKey()" topmargin="0" >
	<form name="MedicalItemAddDetailForm" id="MedicalItemAddDetailForm" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
						<th align="left" colspan="4"><fmt:message key="ePH.Add/ModifyTradeNamestoDrugs.label" bundle="${ph_labels}"/></th>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
						<td align="left">&nbsp;&nbsp;<input type="text" name="trade_name" id="trade_name" size="40"><input type="button" class="button" value="?" onclick="parent.searchTradeName(this);" name="trade_search" id="trade_search">&nbsp;<img src="../../eCommon/images/mandatory.gif">
						<input type="hidden" name="trade_id" id="trade_id" value=""></td>
						<td align="right" class="label"><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/></td>
						<td align="left">&nbsp;&nbsp;<input type="text" name="manufacturer_name" id="manufacturer_name" size="20" readOnly><input type="hidden" name="manufacturer_id" id="manufacturer_id" value=""></td>
						<td align="right" class="label" style="display:none"><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/><input type="hidden" name="disp_seq_no" id="disp_seq_no" maxlength="2" size="2" value="" class="NUMBER"></td>
					</tr>
					<tr>
						<td align="right" colspan="4"><input type="button" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class="button" name="del_butt" style="visibility:hidden" onClick="parent.addDetail(this,'<%=Drug_code_value%>');">
			            <input type="button" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class="button" onClick="parent.addDetail(this,'<%=Drug_code_value%>');" name="add_butt">
						<input type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button" onClick="parent.callReset()" name="reset_butt"></td>
					</tr>
				</table>
				<input type="hidden" name="sql_ph_drug_select19" id="sql_ph_drug_select19" value="<%=sql_ph_drug_select19%>">
				<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
				<input type="hidden" name="link" id="link" value="<%=link%>">
				<input type="hidden" name="bean_id" id="bean_id"		value="<%= bean_id %>">
                <input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
                <input type="hidden" name="mode" id="mode"	value="<%= mode %>">
</form>
</body>
</html>
<% putObjectInBean(bean_id,bean,request); %>


