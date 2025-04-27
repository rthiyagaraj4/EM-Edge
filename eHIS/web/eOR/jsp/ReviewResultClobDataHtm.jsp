<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReviewResults" ;
	String bean_name = "eOR.ReviewResults";



	ReviewResults bean = (ReviewResults)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	
	String accession_num = request.getParameter("accession_num");
	String hist_data = bean.getClobData(accession_num);

//	out.println(accession_num);
	//if(accession_num==null)	accession_num="";

%>

<html>
<head>
	<title><fmt:message key="Common.Result.label" bundle="${common_labels}"/></title>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 

</head>
<body style='background-color:#E2E3F0;' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()"; onLoad="document.result_clob_data_view.bcls.blur()" >
<FORM name='result_clob_data_view' id='result_clob_data_view' METHOD=POST>
<table cellpadding=3 cellspacing=0 border=0 align=center width='100%'>

<tr><td><%=hist_data%></td></tr>
<tr><td class='button'>
<INPUT TYPE="button" name="bcls" id="bcls" class="button" value="Close" onClick='window.close()'></td></tr>

</table>
</FORM>
<%

	putObjectInBean(bean_id,bean,request);
%>
</BODY>
</HTML>

