<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%
		String locale=(String)session.getAttribute("LOCALE");
		request.setCharacterEncoding("UTF-8");
		String sStyle		 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/AutoclaveWashingUnitTest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onLoad='FocusFirstElement();formAutoclaveWashingUnitTestQueryCriteria.submit();'>
	<%
		String mode							=		request.getParameter( "mode" ) ;
		String bean_id						=		"autoclaveWashingUnitTestBean" ;
		String bean_name					=		"eSS.AutoclaveWashingUnitTestBean";
		String unit_type					=		request.getParameter("unit_type")==null?"A":request.getParameter("unit_type");
		AutoclaveWashingUnitTestBean bean	=		(AutoclaveWashingUnitTestBean) getBeanObject( bean_id,  bean_name, request);  
		bean.clear();
		bean.setMode(mode) ;
		bean.setLanguageId(locale);
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setLoginById((String)session.getAttribute("login_user")) ;
		bean.setMode(mode) ;
		bean.initSsParameter();
		bean.setUnit_type(unit_type);

%>
		<form name="formAutoclaveWashingUnitTestQueryCriteria" id="formAutoclaveWashingUnitTestQueryCriteria" action="../../eSS/jsp/AutoclaveWashingUnitTestQueryResult.jsp" method="post" target="frameAutoclaveWashingUnitTestQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="eSS.UnitType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="unit_type" id="unit_type"  onchange='populate_code1(this)'><%=bean.getUnit_type_List()%></select>	</td>
					<td  class="label"><fmt:message key="eSS.AutoclaveWashUnit.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="autoclave_wash_unit_code" id="autoclave_wash_unit_code">
					<%=bean.getAutoclave_wash_unit_code_List1(unit_type)%>
					</select></td>
					<td  class="label"><fmt:message key="eSS.TestDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getTest_date()%>" name="test_date"  maxLength="10" size="10"  onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('test_date');"></img></td>
				</tr>
				<tr>
						<td class="label"><fmt:message key="eSS.Entry.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="entry_completed_yn" id="entry_completed_yn" >
						<option value='%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>		
						<option value='Y' selected><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>		
						<option value='N'><fmt:message key="eSS.Notcompleted.label" bundle="${ss_labels}"/></option>		
						</select>
					</td>
					<td colspan=3>&nbsp;</td>
					<td class="label">&nbsp;<input type='submit' class='Button' value='Search' name='search' id='search'></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">

			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="autoclave_wash_unit_code,test_date">
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

