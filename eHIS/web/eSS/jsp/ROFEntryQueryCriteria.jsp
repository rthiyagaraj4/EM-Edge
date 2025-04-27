<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.ROFEntryBean" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
<%
			request.setCharacterEncoding("UTF-8");
			String locale=(String)session.getAttribute("LOCALE");
			String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ROFEntry.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String mode				=		request.getParameter("mode");
		String bean_id			=		"rofEntryBean";
		String bean_name		=		"eSS.ROFEntryBean";
		String function_id		=		request.getParameter("function_id");

		
		ROFEntryBean bean		=		(ROFEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.clear();
		bean.setMode(mode);
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(function_id));
	%>
	<body onLoad="FocusFirstElement();document.formROFEntryQueryCriteria.submit();"onMouseDown="CodeArrest()">
		<form name="formROFEntryQueryCriteria" id="formROFEntryQueryCriteria" action="../../eSS/jsp/ROFEntryQueryResult.jsp" method="post" target="frameROFEntryQueryResult" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' >
			<tr>
				<td class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"  ><%=bean.getDefaultDocTypes()%></select></td>
				<td class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type="text" name="doc_no" id="doc_no" class="NUMBER" maxLength="8" size="8" onKeyPress="return isValidInteger();"></td>
				<td class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" maxLength="10" size="10" value= "" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img></td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="store_code" id="store_code"><%=bean.getStoreCodes()%></select></td> 
				<td class="label"><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="service_location_code" id="service_location_code"><%=bean.getServiceLocations()%></select></td> 
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="eSS.Sterilization.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="sterilize_yn" id="sterilize_yn"><option value="Y"><fmt:message key="Common.required.label" bundle="${common_labels}"/></option><option value="N"><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option><option value="%" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option></select></td> 
				<td class="label"><fmt:message key="eSS.Washing.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="wash_yn" id="wash_yn"><option value="Y"><fmt:message key="Common.required.label" bundle="${common_labels}"/></option><option value="N"><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option><option value="%" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option></select></td>
				<td class="label"><fmt:message key="eSS.Packing.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="pack_yn" id="pack_yn"><option value="Y"><fmt:message key="Common.required.label" bundle="${common_labels}"/></option><option value="N"><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option><option value="%" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option></select></td>
			</tr>
			
			<tr>
				<td colspan='4' >&nbsp;</td>
				<td colspan='2' ><input type='button' class='Button' value='Search' name='search' id='search' onClick='searchResult()'></td>
			</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			
			<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>">
			<input type="hidden" name="function_id" id="function_id"		value="<%=function_id%>">
			<input type='hidden' name="trn_type" id="trn_type"		value="ROF">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns"  value="doc_type_code,doc_no">
		</form>
	</body>
	<%	putObjectInBean(bean_id,bean,request);%>
</html>

