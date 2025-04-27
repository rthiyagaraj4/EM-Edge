<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="JavaScript" src="../../eSS/js/SterilizationType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement()" onMouseDown="CodeArrest()"> 
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled =	"";
	String disabled		=	"";

	/* Mandatory checks start */
	mode	= request.getParameter( "mode" ) ;

	bean_id = "sterilizationTypeBean" ;
	bean_name = "eSS.SterilizationTypeBean";
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	SterilizationTypeBean bean = (SterilizationTypeBean)getBeanObject( bean_id, bean_name, request ) ; 
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	/* Initialize Function specific end */
String duration_disable="";
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled = "disabled";
		duration_disable="";
		bean.setSterile_type(request.getParameter("sterile_type")) ;
		bean.loadData() ;

		if(bean.getEff_status().equals("D"))
		{
			disabled = "disabled" ;
			duration_disable="disabled";
		}
	}
	 bean.setLanguageId(locale);

%>
<form name="formSterilizationType" id="formSterilizationType" onreset="FocusFirstElement()">
	<table border="0" cellpadding="100" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
	<td width='100%' align='center' class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getSterile_type()%>" name="sterile_type" size='4' maxLength='4' class='UPPER' onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);CheckCode(this);"  <%=codeDisabled%>><%=bean.getMandatoryImageTag()%>
			</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getLong_desc()%>" name="long_desc"  size='40' maxLength='40' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getMandatoryImageTag()%>
			</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getShort_desc()%>" name="short_desc" size='15' maxLength='15' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getMandatoryImageTag()%>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center" class="label"><fmt:message key="eSS.UseWithin.label" bundle="${ss_labels}"/></td>
		<td class="label">&nbsp;&nbsp;
		<input type="text" class="NUMBER" value="<%=bean.getSterile_life()%>" name="sterile_life" size='3' maxLength='3' onKeyPress="return isValidInteger();" <%=disabled%> onBlur="checkIntegerFormat(this);">
		<select name="sterile_life_unit" id="sterile_life_unit" <%=duration_disable%> >
		<%=bean.getSterile_life_unit_List()%>
							</select>
			</td>
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
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
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

</form>
</body>
<% putObjectInBean(bean_id,bean,request);%>
</html>

