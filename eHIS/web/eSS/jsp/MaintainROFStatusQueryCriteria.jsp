<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
			request.setCharacterEncoding("UTF-8");
			String sStyle	 =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String locale= (String)session.getAttribute("LOCALE");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/MaintainROFStatus.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode					=		request.getParameter( "mode" ) ;
	String bean_id				=		"maintainROFStatusBean";
	String bean_name			=		"eSS.MaintainROFStatusBean";
	
	MaintainROFStatusBean bean  =		(MaintainROFStatusBean) getBeanObject( bean_id, bean_name,request ); 

	if (mode != null) {
			mode = mode.trim();
		}
	
	
	bean.clear(); 
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(locale);
	
	bean.setMode(mode.trim());
	java.util.HashMap defaultParameter = bean.getSSParameter();
	//String default_doc_type_code =		(String)defaultParameter.get("DEF_ROF_DOC_TYPE_CODE");
	

	
%>
<body onload='FocusFirstElement();document.MaintainROFStatusQuery.submit();' onMouseDown='CodeArrest();'>
	<form name="MaintainROFStatusQuery" id="MaintainROFStatusQuery" action="../../eSS/jsp/MaintainROFStatusQueryResult.jsp" method="post" target="qryResultMaintainROFStatus">
			<table border="0" cellpadding="0" cellspacing="0" width='98%'>
				<tr>
					<td colspan='6'>&nbsp;</th>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.getDocTypes()%></select></td>
					<td class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_no" id="doc_no" value="" size='8' maxLength='8' class='NUMBER' onKeyPress="return isValidInteger();"></td>
					<td class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_date" id="doc_date" value="" size='10' maxLength='10' onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="store_code" id="store_code" ><%=bean.getStores()%></select></td>
					<td class="label"> </td>
					<td class="label">&nbsp;&nbsp;</td>
					<td class="label">&nbsp;&nbsp;</td>
					<td ><input type='button' class='Button' value='Search' name='search' id='search' onClick='searchResult();'></td>
				</tr>
				<tr>
					<td colspan='6'>&nbsp;</th>
				</tr>
			</table>
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

