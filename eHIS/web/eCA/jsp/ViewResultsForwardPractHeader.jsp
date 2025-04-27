<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ViewResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body   onMouseDown="CodeArrest()" onKeyDown="lockKey()">     <%--onload='FocusFirstElement()' --%>
<form name="review_results_forward_pract_hdr" id="review_results_forward_pract_hdr" target="messageFrame">
<table cellpadding=3 cellspacing=0 border=1 width="100%" id='detailHeader'>
<tr>
<Td class=columnheader><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></Td>
<Td class=columnheader><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></Td>
<Td class=columnheader><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></Td></tr>
</table>
</form>
</body>
</html>

