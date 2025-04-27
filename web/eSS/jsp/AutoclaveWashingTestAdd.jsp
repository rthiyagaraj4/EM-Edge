<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

12/11/2014				AAKH_CRF_0057			Sakti Sankar		52312											Autoclaving function, option to select
																													Biological indicator , BMS Pass / Fail 
																													Both in Master as wel as Transaction function.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page contentType="text/html;charset=UTF-8" import="java.util.ArrayList, eSS.*, eSS.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
		String locale	=	(String)session.getAttribute("LOCALE");
		String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/AutoclaveWashingTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
</head>
<body onLoad="FocusFirstElement();" onMouseDown='CodeArrest();'>
	<%
		String	mode			=	request.getParameter( "mode" ) ;
		String	bean_id			=	"autoclaveWashingTestBean" ;
		String	bean_name		=	"eSS.AutoclaveWashingTestBean";
		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;

		AutoclaveWashingTestBean bean = (AutoclaveWashingTestBean) getBeanObject( bean_id, bean_name, request ) ;
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setLanguageId(locale) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
%>
<form name="formAutoclaveWashingTest" id="formAutoclaveWashingTest" onReset="FocusFirstElement();">
	<table border="0" cellpadding="100" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">	
		<table cellpadding="0" cellspacing="0" align="center" border=1>
		<tr>
			<th align="center" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="eSS.UnitType.label" bundle="${ss_labels}"/></td>
			<th align="center" ><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></td>
			<th align="center" ><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></td>
			<th align="center" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		</tr>
		<%
			String classValue = null;
			int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
			for ( int cnt=0; cnt<max_rows; cnt++ ) {
				if(cnt%2 ==0)
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
				
		%>
			 <TR>
				<td align="center" class="<%=classValue %>" >
					<input type="text" name="code_<%=cnt %>" id="code_<%=cnt %>"  size="8" maxlength="8" class="UPPER" onKeyPress="return CheckForSpecChars(event)" onBlur="resetColorCode(this);convertToUpperCase(this);checkSpecialChars(this);">
				</td>
				<td align="center" class="<%=classValue %>" >
					<input type="text" name="long_desc_<%=cnt %>" id="long_desc_<%=cnt %>"  size="40" maxlength="40" onBlur="makeValidString(this);resetColorCode(this);">
				</td>
				<td align="center" class="<%=classValue %>" >
					<input type="text" name="short_desc_<%=cnt %>" id="short_desc_<%=cnt %>" size="15" maxlength="15" onBlur="makeValidString(this);resetColorCode(this);">
				</td>
				<td align="center" class="<%=classValue %>" >
					<select name="unit_type_<%=cnt %>" id="unit_type_<%=cnt %>" onChange="checkBiBmsType(this,'<%=cnt %>');">
						<%=bean.getUnit_type_List(bean.getUnit_type(cnt))%>
					</select>
				</td>
				<!-- Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312 -->
				<td align="center" class="<%=classValue %>" >
					<select name="biological_indicator_<%=cnt%>" id="biological_indicator_<%=cnt%>">
						<%=bean.getBiological_Indicator_List(bean.getBiological_Indicator(cnt))%>
					</select>
				</td>
				<td align="center" class="<%=classValue %>" >
					<select name="bms_pass_fail_<%=cnt%>" id="bms_pass_fail_<%=cnt%>">
						<%=bean.getBMS_PassFail_List(bean.getBms_Pass_Fail(cnt))%>
					</select>
				</td>
				<!-- Added ends -->
				<td align="center" class="<%=classValue %>">
					<input type="checkBox" name="eff_status_<%=cnt %>" id="eff_status_<%=cnt %>" value="E" checked>
				</td>
			</tr>
	<%
		}
	%>		
		</table>
	</td>
	</tr>
</table>
	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=max_rows%>">
</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

