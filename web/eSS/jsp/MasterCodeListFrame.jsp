<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, eSS.*, eSS.Common.* , eCommon.Common.*,eSS.ReportsMasterCodeBean" %>
<!--<%@ page import="eSS.ReportsMasterCodeBean" %> -->
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/SsCommon.js"></script>
	<script language="JavaScript" src="../js/MasterCodeList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload="FocusFirstElement()" onMouseDown="CodeArrest()">

<%
	/* Mandatory checks start */
//	String mode					=	request.getParameter( "mode" );
	String bean_id				=	"ReportsMasterCodeBean";
	String bean_name			=	"eSS.ReportsMasterCodeBean";
	
	/* Initialize Function specific start */
	ReportsMasterCodeBean bean = (ReportsMasterCodeBean)getBeanObject( bean_id, bean_name,request ) ;  
//	bean.clear() ;

	/* Initialize Function specific end */

%>
		
<form name="MasterCodeListFrame" id="MasterCodeListFrame" >
<br>

<table cellpadding=0 cellspacing=0 width="70%" align="center">
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td align="right" class="label" width='35%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td align="left"  colspan="2">&nbsp;&nbsp;<select name="master_code" id="master_code" onchange="loadPage();"><option value="">&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
	<%
	
	ArrayList	arrMasterCode		=	null;
	HashMap		hmMasterCode		=	null;	
	String code = "",	desc		=	"";

	arrMasterCode		=	bean.getMasterCodeList();
	int arrLength		=	arrMasterCode.size();
	for(int i=0;i<arrLength; i++)
	{
		hmMasterCode      	=	(HashMap) arrMasterCode.get(i);
		
		code				=	(String)hmMasterCode.get("code");
		desc				=	(String)hmMasterCode.get("desc");
	
		%>
			<option value="<%=code%>"  ><%=desc%></option>
		<%
	}
	%>
	</select></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</form>
</body>

</html>

