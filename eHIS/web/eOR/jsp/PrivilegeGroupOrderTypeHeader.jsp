<!DOCTYPE html>
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
<%@page  import="java.util.*, eOR.*, eOR.Common.*,eCommon.Common.*" %>
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
<script language="JavaScript" src="../../eOR/js/PrivilegeGroup.js"></script>
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
<body topmargin="0" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = "privilegegroupbean" ;
	String bean_name = "eOR.PrivilegeGroupBean";
	String mode	= request.getParameter("mode");
	if(mode == null)mode="1";
	PrivilegeGroupBean bean = (PrivilegeGroupBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setLanguageId(localeName);
	
%>
<form name="ordertypedtls_header" id="ordertypedtls_header">
<table cellspacing='0' cellpadding='3' width='100%' height="100%" border='1' align="center">
	<th class='columnheader' colspan='4' style="text-align:left;"><fmt:message key="eOR.SelectOrderType.label" bundle="${or_labels}"/></th>
	<tr>
	<th class='columnheader' width="65%" style="text-align:left;"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
	<th class='columnheader' width="30%" style="text-align:left;"><fmt:message key="Common.rule.label" bundle="${common_labels}"/></th>
	</tr>
</table>
</form>
</body>
</html>

