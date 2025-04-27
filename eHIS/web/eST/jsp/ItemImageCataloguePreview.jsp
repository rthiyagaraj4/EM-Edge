<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.*, eST.Common.*, eCommon.Common.*,java.io.*, java.security.AccessController" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
	
<%
		request.setCharacterEncoding("UTF-8");
		//String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eST/js/ItemSearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
<%
		String imageURL	= request.getParameter("imageURL")==null?"":request.getParameter("imageURL");
		String img_path	= request.getParameter("img_path")==null?"":request.getParameter("img_path");
%>	  
	
	
		<form name="ViewImage1" id="ViewImage1">
		
			<table cellspacing='0' cellpadding='0' width='100%' height='100%' border='0'>
				<th><fmt:message key="Common.Image.label" bundle="${common_labels}"/></th>
				<tr >
					<td class='WHITE' align='center' valign='middle'>

						<img src="<%=imageURL%>" border=0 align='center' >
					</td>
				</tr>
				<tr  height='5'>
					<td  align='right' >
						<input type="button" class="button" name="ok" id="ok" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'   onClick="window.close();">				
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

