<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"   import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
<head>
<%
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale		=		(String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");


%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/ProcessGLDistribution.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement();" onMouseDown="CodeArrest()">
<%
	String mode;
	String bean_id;
	String bean_name;
	mode				=		request.getParameter( "mode" ) ;
	bean_id				=		"processGLDistributionBean" ;
	bean_name			=		"eSS.ProcessGLDistributionBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	ProcessGLDistributionBean bean = (ProcessGLDistributionBean) getBeanObject( bean_id, bean_name,request );  
	bean.clear() ;
	bean.setLanguageId(locale);
		
	/*ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);*/

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.loadData();

%>
<form name="formProcessGLDistribution" id="formProcessGLDistribution" onReset="FocusFirstElement();">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr><td colspan='2'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' align='right' width='50%'>Current Process Month/Year</td>
		<td>&nbsp;<input class="NUMBER" type='text' maxLength='2' size='2' name="curr_proc_month" id="curr_proc_month" value="<%=bean.getCurr_proc_month()%>" disabled><input class="NUMBER" type='text' maxLength='4' size='4' name="curr_proc_year" id="curr_proc_year" value="<%=bean.getCurr_proc_year()%>" disabled></td>
	</tr>
	<tr>
		<td colspan='2'>&nbsp;</td>
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

