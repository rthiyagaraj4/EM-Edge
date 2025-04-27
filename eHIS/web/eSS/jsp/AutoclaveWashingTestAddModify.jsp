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

<%--This JSP is call when a user clicks on Create Button from Autoclave / Washing Test Menu--%>
<%@ page contentType="text/html;charset=UTF-8" import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/AutoclaveWashingTest.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	
	</head>
<body onLoad="FocusFirstElement();checkcheckBiBmsTypeQuery()" onMouseDown='CodeArrest();'> 
<%
	
		String mode;
		String bean_id;
		String bean_name;
		
		String codeDisabled =	"";
		String disabled		=	"";
		
		mode	= request.getParameter( "mode" ) ;
		bean_id = "autoclaveWashingTestBean" ;
		bean_name = "eSS.AutoclaveWashingTestBean";
		
		if ((mode == null) || (mode.equals(""))) 
			return ;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
		AutoclaveWashingTestBean bean = (AutoclaveWashingTestBean) getBeanObject( bean_id,  bean_name, request );
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
			codeDisabled = "disabled";
			if (request.getParameter( "test_code" ) == null ) {
				return;		
			}
			bean.setCode(0,request.getParameter( "test_code" )) ;
			bean.loadData() ;
		
			disabled = bean.getEff_status(0).equals("D")?"disabled":"";
		}
		bean.setLanguageId(locale) ;
%>
<script language="javascript">
var varUnitType="<%=bean.getUnit_type(0)%>";
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
<form name="formAutoclaveWashingTest" id="formAutoclaveWashingTest" onReset="FocusFirstElement();">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="text" value="<%=bean.getCode(0)%>" name="code_0" size='8' maxLength='8'  class="UPPER" onKeyPress="return CheckForSpecChars(event);" <%=codeDisabled%> onBlur="checkSpecialChars(this);"><%=bean.getMandatoryImageTag()%>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="text" value="<%=bean.getLong_desc(0)%>" name="long_desc_0" size='40' maxLength='40' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getMandatoryImageTag()%>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="text" value="<%=bean.getShort_desc(0)%>" name="short_desc_0" size='15' maxLength='15' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getMandatoryImageTag()%>
			</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.UnitType.label" bundle="${ss_labels}"/></td>
		<td class="label">&nbsp;<select name="unit_type_0" id="unit_type_0" <%=codeDisabled%>>
			<%=bean.getUnit_type_List(bean.getUnit_type(0))%>
		</select>
				</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<!-- Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312 -->
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></td>
		<td class="label">&nbsp;<select name="biological_indicator_0" id="biological_indicator_0" <%=disabled%>>
			<%=bean.getBiological_Indicator_List(bean.getBiological_Indicator(0))%>
		</select>
				</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></td>
		<td class="label">&nbsp;<select name="bms_pass_fail_0" id="bms_pass_fail_0" <%=disabled%>>
			<%=bean.getBMS_PassFail_List(bean.getBms_Pass_Fail(0))%>
		</select>
				</td>
	</tr>
	<!-- Added ends -->
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<input type="checkbox" value="E" name="eff_status_0" id="eff_status_0" <%=bean.getChecked(bean.getEff_status(0))%>>
					</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>

	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

