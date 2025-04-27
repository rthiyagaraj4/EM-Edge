<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/AutoclaveWashingTest.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onLoad="FocusFirstElement();" onMouseDown='CodeArrest();' >
<jsp:useBean id="bean" scope="page" class="eSS.StatisticalGroupBean"/>	

<%
		String mode;
		String bean_id;
		String bean_name;
		String codeDisabled			=		"";
		String disabled				=		""	;
		
		mode						=		request.getParameter( "mode" ) ;
		bean_id						=		"statisticalGroupBean" ;
		bean_name					=		"eSS.StatisticalGroupBean";

		if ((mode == null) || (mode.equals(""))) 
			return ;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
		//StatisticalGroupBean bean = (StatisticalGroupBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
			codeDisabled = "disabled";
			if (request.getParameter( "stat_group_code" ) == null ) {
				return;		
			}
			bean.setStat_group_code(request.getParameter( "stat_group_code" )) ;
			bean.loadData() ;
			
			if (bean.getEff_status().equals("D"))
				disabled = "disabled" ;
		}
%>
		
<form name="formStatisticalGroup" id="formStatisticalGroup" onReset="FocusFirstElement();">
<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
	<td width='100%' align='center' class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="text" value="<%=bean.getStat_group_code()%>" name="stat_group_code" size='8' maxLength='8' class='UPPER' onKeyPress="return CheckForSpecChars(event);" <%=codeDisabled%> onBlur="checkSpecialChars(this);"><%=bean.getMandatoryImageTag()%>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="text" value="<%=bean.getLong_desc()%>" name="long_desc" size='40' maxLength='40' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getMandatoryImageTag()%>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="text" value="<%=bean.getShort_desc()%>" name="short_desc" size='15' maxLength='15' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getMandatoryImageTag()%>
			</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.Countbycomponents.label" bundle="${ss_labels}"/></td>
		<td class="label">&nbsp;<input type="checkbox" value="Y" name="count_components_yn" id="count_components_yn" <%=codeDisabled%> <%=bean.getChecked(bean.getCount_components_yn())%>>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="checkbox" value="E" name="eff_status" id="eff_status" <%=bean.getChecked(bean.getEff_status())%>>
					</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

</form>
</body>
<% putObjectInBean(bean_id,bean,request);%>
</html>

