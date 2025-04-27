<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>


<%
    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String code	=	request.getParameter("form_code");
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<table border="0" width="40%" cellspacing="0" cellpadding="0">
	<tr><td width="12%" class="white">&nbsp;</td>
		<td class="clicked"  width="44%" height="20" id="select_col">
		<a href="javascript:parent.callSelect('<%=code%>')" id="select" style="color:white;"><b>
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b> </a>
		</td>
		<td class="normal" width="44%" height="20" id="association_col">
		<a href="javascript:parent.callAssociation('<%=code%>')" id="association" style='color:white;'><b>
		<fmt:message key="Common.Association.label" bundle="${common_labels}"/></b></a>
		</td>
	</tr>
</table>
</body>
<script>parent.callSelect('<%=code%>')</script>
</html>

