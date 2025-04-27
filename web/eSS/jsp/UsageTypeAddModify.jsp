<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page
contentType="text/html;charset=UTF-8" import=" eSS.*,eSS.Common.* , eCommon.Common.*, java.text.*,java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
	<script language="javascript" src="../../eSS/js/UsageType.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	
</head>
<body onLoad="FocusFirstElement();" onMouseDown="CodeArrest()"> 
<%
	String mode				=	 null;
	String bean_id			=	 null;
	String bean_name		=	 null;
	String disabled			=	 "";
	
	mode					=	request.getParameter("mode");
	bean_id					=	"usageTypeBean";
	bean_name				=	"eSS.UsageTypeBean";
	String usage_type		=	request.getParameter("usage_type");

	if (mode == null || mode.equals("")) 
		return;
	if (!(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	UsageTypeBean bean		=	 (UsageTypeBean)getBeanObject(bean_id, bean_name,request);  
	bean.clear();
	bean.setMode( mode ) ;
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		if (usage_type ==  null)
			return;		
		bean.setCode(0,usage_type);
		bean.loadData();
		if(bean.getEff_status(0).equals("D"))
			disabled ="disabled";
	}
%>
<form name="formUsageType" id="formUsageType"  onreset="FocusFirstElement();">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
	<td width='100%' align='center' class="WHITE">
		<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td align="left">&nbsp;&nbsp;<input type="text" name="code_0" id="code_0" value="<%= bean.getCode(0) %>" size="8" maxlength="8" disabled>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td align="left">&nbsp;&nbsp;<input type="text" name="long_desc_0" id="long_desc_0" value="<%=bean.getLong_desc(0) %>" size="42" maxlength="40" <%= disabled %> >
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td align="left">&nbsp;&nbsp;<input type="text" name="short_desc_0" id="short_desc_0" value="<%= bean.getShort_desc(0) %>" size="20" maxlength="15" <%= disabled %> >
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td class="label" align="right"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td align="left">&nbsp;<input type="checkBox" name="eff_status_0" id="eff_status_0" value="E" <%=(bean.getEff_status(0)).equals("E")?"checked":"" %> >
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<%
			if((bean.getEff_status(0)).equals("E")) {
		%>
			<script language="javascript">
					document.formUsageType.long_desc_0.focus();
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
				}
		%>
		</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">	
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

