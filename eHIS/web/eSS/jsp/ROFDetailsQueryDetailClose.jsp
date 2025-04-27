<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle		 = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eSS/js/ROFDetails.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body >
	<form name="ROFDetailsQueryDetailClose" id="ROFDetailsQueryDetailClose">
	<br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='right'>
				<tr>
					<td class="BODYCOLORFILLED" align='right'><input type="button" value="Close" class="BUTTON" onClick="CloseWindow();"></td>
				</tr>
		</table>
				
		</form>
		
	</body>
</html>

