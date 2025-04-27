<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page  import="java.util.*, eOR.*, eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/PrivilegeGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<STYLE TYPE="text/css">

	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 
	</STYLE>

</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "privilegegroupbean" ;
	String bean_name = "eOR.PrivilegeGroupBean";
	String mode	= request.getParameter("mode");
	String tabValue	= request.getParameter("tabvalue");
	if(mode == null) mode="1";
	PrivilegeGroupBean bean = (PrivilegeGroupBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
		
%>
<body topmargin="0" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="ordercataegorydtls_copyfrom" id="ordercataegorydtls_copyfrom">
<table border="0" cellspacing="0" cellpadding="3" width="100%" align="center">
<tr>
	<td class="label" width="25%" nowrap><fmt:message key="eOR.CopyFrom.label" bundle="${or_labels}"/></td>
	<td class="fields" width="25%"><select name="copy from" id="copy from" onChange='fillCopyFrom("<%=tabValue%>",this);'>
	<option value="defaultSelect">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<%if(!tabValue.equals("OR")){%>
	<option value="OR"><fmt:message key="Common.Ordering.label" bundle="${common_labels}"/></option>
	<%}%>
	<%if(!tabValue.equals("VW")){%>
	<!-- 
		Modified by Kishore kumar N on Aug-17-09, for the CRF 641
	-->

	<!-- <option value="VW"><fmt:message key="eOR.Viewing.label" bundle="${or_labels}"/></option> -->
	<%}%>
	<%if(!tabValue.equals("AU")){%>
	<option value="AU"><fmt:message key="eOR.Authorizing.label" bundle="${or_labels}"/></option>
	<%}%>
	<%if(!tabValue.equals("SA")){%>
<!-- 	<option value="SA"><fmt:message key="eOR.Spl-Approving.label" bundle="${or_labels}"/></option> -->
	<%}%>
	<%if(!tabValue.equals("CS")){%>
	<!-- <option value="CS"><fmt:message key="eOR.Co-Signing.label" bundle="${or_labels}"/></option> -->
	<%}%>
	<%if(!tabValue.equals("RR")){%>
	<!-- <option value="RR"><fmt:message key="eOR.Resulting.label" bundle="${or_labels}"/></option> -->
	<%}%>
	<%if(!tabValue.equals("CN")){%>
	<!-- <option value="CN"><fmt:message key="Common.Consent.label" bundle="${common_labels}"/></option> -->
	<%}%>
	<%if(!tabValue.equals("RC")){%>
	<!-- <option value="RC"><fmt:message key="eOR.Recording.label" bundle="${or_labels}"/></option> 
	
	ends here.
	-->


	<%}%>
	</select></td>
	<td colspan=4></td>
	</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
</body>
</html>

