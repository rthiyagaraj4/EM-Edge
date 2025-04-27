<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../js/ATCClassification.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
	String bean_id		       = "@ATCClassificationBean" ;
	String bean_name		   = "ePH.ATCClassificationBean";
	ATCClassificationBean bean = (ATCClassificationBean)getBeanObject( bean_id,bean_name,request );
		bean.setLanguageId(locale);
	HashMap level_codes        = bean.getPharmaLevelCodes();
	if(level_codes==null)level_codes= new HashMap();
	String disabled ="";
	if(level_codes.size()>0){
		disabled = "";
	}else{
		disabled = "disabled";
	}

%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<table  border=0 align="center" width='100%' cellpadding='0' cellspacing='0'>
	<tr> 
		<td align="right" class="white">
			<input type="button" name="btnSelect" id="btnSelect" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' class="button" onClick="selectedPharmaLevels()" <%=disabled%>>
			<input type="button" name="btnClose" id="btnClose"  value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="button" onClick="window.close()">
		</td>
	</tr>
</table>
</body>
<% putObjectInBean(bean_id,bean,request ) ; %>
</html>

