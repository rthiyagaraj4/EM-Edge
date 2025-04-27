<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eSS.*, eSS.Common.* , eCommon.Common.*"  contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import="eSS.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			 =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale= (String)session.getAttribute("LOCALE");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/Autoclaving.js"></script>
		<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onLoad='FocusFirstElement();formAutoclavingQueryCriteria.submit();' onMouseDown='CodeArrest();'>
	<%
		String mode					=	request.getParameter( "mode" ) ;
		String bean_id				=	"autoclavingBean" ;
		String bean_name			=	"eSS.AutoclavingBean";

		AutoclavingBean bean		=	(AutoclavingBean) getBeanObject( bean_id,  bean_name, request);  
		bean.clear();
		bean.setMode(mode) ;
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setLoginById((String)session.getAttribute("login_user")) ;
		bean.setLanguageId(locale);
		bean.setMode(mode) ;
		bean.initSsParameter();
		bean.initStore_code();
	%>
		<form name="formAutoclavingQueryCriteria" id="formAutoclavingQueryCriteria" action="../../eSS/jsp/AutoclavingQueryResult.jsp" method="post" target="frameAutoclavingQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td align="left" class="label"><fmt:message key="eSS.AutoclaveUnit.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="autoclave_wash_unit_code" id="autoclave_wash_unit_code">
							<%=bean.getAutoclave_wash_unit_code_List()%></select>
							</td>
					<td align="left" class="label"><fmt:message key="eSS.LoadNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="load_no" id="load_no" value="" size='8' maxLength='8' class="NUMBER" onKeyPress="return isValidInteger();"></td>
					<td align="left" class="label"><fmt:message key="eSS.AutoclaveDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="autoclave_date" id="autoclave_date" value="" size='10' maxLength='10'  onBlur="CheckDate(this);">&nbsp;
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('autoclave_date');"></img></td>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="store_code" id="store_code" >
							<%=bean.getStore_code_List()%></select>
							</td>
					<td align="left" class="label"><fmt:message key="eSS.Entry.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="entry_completed_yn" id="entry_completed_yn" >
						<option value='%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>		
						<option value='Y' selected><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>		
						<option value='N'>Not completed</option>		
						</select>
					</td>
 					<td align="left" class="label"> </td>
					<td class="label">&nbsp;<input type='button' class='Button' value='Search' name='search' id='search' onClick='searchResult();'></td>
				</tr>
			</table>
			<br>
			<input type='hidden' name="sysdate" id="sysdate" value="<%=bean.getSSParameter().get("SYS_DATE").toString()%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="autoclave_wash_unit_code,load_no">
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

