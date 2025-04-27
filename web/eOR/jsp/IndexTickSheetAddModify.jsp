<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.*, eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/IndexTickSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>

</head>

<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'; onLoad="document.forms[0].order_category.focus();">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "indexticksheet" ;
	String bean_name = "eOR.IndexTickSheet";
	//String readOnly = "" ;
	//String disabled = "" ;
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexTickSheet bean = (IndexTickSheet)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//boolean clearDBbean		=  bean.clearDBRec();
	bean.clearDBRec();
	/* Initialize Function specific end */
%>


<form name="formIndexTickShAddMod" id="formIndexTickShAddMod" >
<table cellpadding=3 cellspacing=0 border='0' width="100%" align="center">
<tr>
	<td class="label" width='35%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name="order_category" id="order_category" onChange="fillComboOptions(this);">
		<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=bean.getComboOptionsOrCat()%>
	</select><img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
	</td>
</tr>
<tr>
	<td class="label" ><fmt:message key="eOR.TickSheet.label" bundle="${or_labels}"/></td>
	<td id="tick_sheet_opt" name="tick_sheet_opt" class='fields'><select name="tick_sheet_id" id="tick_sheet_id" onChange="" >
		<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=bean.getComboOptionsOrCat()%>
	</select><img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.IndexType.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name="index_type" id="index_type" onChange="loadDtlFrame(this, document.forms[0].order_category, document.forms[0].tick_sheet_id);">
		<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<option value="F"><fmt:message key="eOR.BySource.label" bundle="${or_labels}"/></option>
		<option value="S"><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
		<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
	</select><img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
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

</form>
</body>

</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


