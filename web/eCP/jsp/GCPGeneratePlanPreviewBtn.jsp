<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/GCPGenerateCarePlan.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	String selected_diagnosis = request.getParameter("selected_diag")==null?"":request.getParameter("selected_diag");
	String disabled ="";
	 eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
	if(selected_diagnosis.equals("")){
		HashMap codeKeyValue = new HashMap();
		codeKeyValue =  bean.getSelectedIntvn();
		if(codeKeyValue.equals(""))
			disabled = "disabled";
		//out.println("<script>alert('codeKeyValue::-"+codeKeyValue+"--')</script>");
	}
%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='gen_preview_btn' id='gen_preview_btn' target='' >
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td  class='label' align=left>
		<!-- <input type="button" value='Expand' name='exp_btn' id='exp_btn' class='button' onClick='frameResize(this)'> -->&nbsp;
		</td>
		<td  class='label' align=right>
		<input type="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class='button' onClick='PreviewRecord()' <%=disabled%>>
		&nbsp;&nbsp;
		
		<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='PreviewClose()'>
		</td>
	</tr>
</table>
</form>

</body>
</html>

