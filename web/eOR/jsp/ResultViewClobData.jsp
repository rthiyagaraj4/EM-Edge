<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	//String function_id = request.getParameter( "function_id" ) ;
	request.setCharacterEncoding("UTF-8");

	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";


	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name , request) ; 
	bean.setLanguageId(localeName);

	String row_index = request.getParameter("row_index");
	//out.println(row_index);
	if(row_index==null)	row_index="";

	String templateText = bean.getClobData(row_index);
	//out.println("template_id= "+row_index+"templateText="+templateText);
%>

<html>
<head>
	<title><fmt:message key="Common.Result.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<body   OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name='result_clob_data_view' id='result_clob_data_view' METHOD=POST>
<table cellpadding=3 cellspacing=0 border=0 align=center width='100%'>
<tr><td><TEXTAREA NAME="" ROWS="25" COLS="110" readonly class="OR_RESULTTEXTAREAODD"><%=templateText%></TEXTAREA></td></tr>
<tr><td class='button'><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'></td></tr>
</table>
</FORM>
</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

