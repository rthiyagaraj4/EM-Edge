<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*, eST.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%		
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/ProcessGLDistribution.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<body onLoad="FocusFirstElement();"> 
<%
	String mode;
	String bean_id;
	String bean_name;
	mode	= request.getParameter( "mode" ) ;
	bean_id = "processGLDistributionBean" ;
	bean_name = "eST.ProcessGLDistributionBean";
	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	ProcessGLDistributionBean bean = (ProcessGLDistributionBean) getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.initialize();
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if(!((String)bean.isGL_INTERFACE_YN()).equals("N"))
	{
	bean.loadData();

%>
<form name="formProcessGLDistribution" id="formProcessGLDistribution" onReset="FocusFirstElement();">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr><td colspan='2'>&nbsp;</td></tr>
	<tr>
		<td class='label'  width='50%'><fmt:message key="Common.CurrentProcessMonth/Year.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;<input class="NUMBER" type='text' maxLength='2' size='2' name="curr_proc_month" id="curr_proc_month" value="<%=bean.getCurr_proc_month()%>" disabled><input class="NUMBER" type='text' maxLength='4' size='4' name="curr_proc_year" id="curr_proc_year" value="<%=bean.getCurr_proc_year()%>" disabled></td>
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
}

else
{%>
<script>
		alert(getMessage("GENERAL_LEDGER_INTERFACE_ENABLED","ST"));
		document.location.href="../../eCommon/html/blank.html";
</script>
<%}
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

