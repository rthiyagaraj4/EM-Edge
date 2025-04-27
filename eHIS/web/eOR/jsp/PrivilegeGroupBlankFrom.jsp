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

<body topmargin="0" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="ordercataegoryblank" id="ordercataegoryblank">
<table border="0" cellspacing="0" cellpadding="3" width="100%" height='100%' align="center">
<tr>
	<td class="label" width="100%">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td class="fields" width="100%">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	
	</tr>
</table>
</form>
</body>
</html>

