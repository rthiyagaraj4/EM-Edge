<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>

<html>
<head><title><fmt:message key="Common.StartConsult.label" bundle="${common_labels}"/></title>
	    <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eOP/js/StartCons.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey();'>
<table width='20%' align=right cellspacing='0' cellpadding='0' >
<br>
<tr>
<td width='100%' class='white'>		
			<table cellspacing='0' cellpadding='0' width='100%'>
				<tr>
					<td width=100% align = 'right' class='white'>				
						<input type='button' name='OK' id='OK'  class='button' onclick="PopulateThis()" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'>
					</td>	
					
					<td  align = 'left' class='white' >
						<input type='button' name='cancel' id='cancel' class='button' onclick="closewin()" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'>
					</td>	
					
					<td class='white'>&nbsp;</td>
					<td class='white'>&nbsp;</td>
					<td class='white'>&nbsp;</td>
					<td class='white'>&nbsp;</td>
					<td class='white'>&nbsp;</td>
					<td class='white'>&nbsp;</td>
					
				</tr>
			</table>
</td>
</tr>	
</table>

</body>
</html>

