<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/IndexOrderCareSet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "indexordercareset" ;
	String bean_name = "eOR.IndexOrderCareSetBean";
	//String readOnly = "" ;
	//String disabled = "" ;
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;

	/* Mandatory checks end */

	/* Initialize Function specific start */

	IndexOrderCareSetBean bean = (IndexOrderCareSetBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clearDBRec();
	//boolean clearDBbean	= bean.clearDBRec();
	/* Initialize Function specific end */
%>

<form name="index_order_care_set_add_modify" id="index_order_care_set_add_modify" >
<table cellpadding=3 cellspacing=0 border='0' width="100%" height='100%' align="center">
<tr><td colspan="2"><input type="hidden" name="order_category" id="order_category" value="temp"></td></tr>
<tr>
	<td  class="label"  width='30%'><fmt:message key="eOR.OrderSet.label" bundle="${or_labels}"/></td>
	<td  id="care_set_td" class='fields'>
		<select name="care_set_id" id="care_set_id" onChange="loadDtlFrame(index_type, this, document.forms[0].care_set_id);" id="care_set_select" >
			<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%=bean.getComboOptionsCareSet()%>
		</select>
		<img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.IndexType.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<select name="index_type" id="index_type" onChange="loadDtlFrame(this, document.forms[0].order_category, document.forms[0].care_set_id);">
			<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value="F"><fmt:message key="eOR.BySource.label" bundle="${or_labels}"/></option>
			<option value="S"><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
			<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			<option value="D"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></option>
		</select>
		<img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	</td>
</tr>
</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="SelectYNStr" id="SelectYNStr" value="">
<input type="hidden" name="facility_id" id="facility_id" value="">
<input type="hidden" name="source_type" id="source_type" value="">
<input type="hidden" name="diagnosis_code" id="diagnosis_code" value="">
<input type="hidden" name="diag_code_scheme" id="diag_code_scheme" value="">
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

