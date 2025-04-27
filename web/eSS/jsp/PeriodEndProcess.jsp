<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  contentType="text/html;charset=UTF-8"   import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" %>

<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String locale= (String)session.getAttribute("LOCALE");

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/PeriodEnd.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement();" onMouseDown="CodeArrest()">
<%
	String mode;
	String bean_id;
	String bean_name;
	
	mode					=		 request.getParameter( "mode" ) ;
	bean_id					=		"PeriodEndBean" ;
	bean_name				=		"eSS.PeriodEndBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	PeriodEndBean bean		=		(PeriodEndBean) getBeanObject( bean_id,bean_name, request  );
	bean.clear() ;
/*ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);*/
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	bean.initFacility_id();
	bean.loadData();
%>
		
<form name="formPeriodEnd" id="formPeriodEnd" onReset="FocusFirstElement();">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%' style='margin-top:184px'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr><td colspan='2'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' align='right' width='50%' style='padding-right: 300px;'><fmt:message key="eSS.CurrentProcessMonthYear.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input class="NUMBER" type='text' maxLength='2' size='2' name="curr_proc_month" id="curr_proc_month" value="<%=bean.getCurr_proc_month()%>" disabled><input class="NUMBER" type='text' maxLength='4' size='4' name="curr_proc_year" id="curr_proc_year" value="<%=bean.getCurr_proc_year()%>" disabled></td>
	</tr>
	<tr><td colspan='2'>&nbsp;</td></tr>
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

