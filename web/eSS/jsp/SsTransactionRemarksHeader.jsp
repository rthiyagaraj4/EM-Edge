<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="eSS.*, eSS.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/SsTransactionRemarks.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	
	String mode				=		request.getParameter( "mode" ) ;
	String bean_id			=		"SsTransactionRemarksBean" ;
	String bean_name		=		"eSS.SsTransactionRemarksBean";
	

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	eSS.SsTransactionRemarksBean bean = (eSS.SsTransactionRemarksBean)getBeanObject(bean_id,bean_name,request) ;  
	bean.setLanguageId(locale);
	bean.clear() ;

	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode(mode);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	
	int i=0;
	
%>
<body onLoad="FocusFirstElement();">
	<form name="frmSsTransactionRemarksHeader" id="frmSsTransactionRemarksHeader" onReset="FocusFirstElement();">
	<table border=0  width='70%' height='100%' cellpadding=1 cellspacing=0 align=center>
		<tr>
				<td class="LABEL" ><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></td>
				<td class=fields>
				<select name="transaction_type" id="transaction_type" onChange="setValue(this);">
				  <%=bean.getTransactionTypes()%>	 				
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></td>
				
		</tr>
	</table>
	<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
	<input type="hidden" name="total_count_flag" id="total_count_flag"	value="<%=i%>">
	<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	
<%
	putObjectInBean(bean_id,bean,request);
%>
	</form>
</body>
</html>

