<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<!--
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
12/02/2017	IN065713		Dinesh T		12/02/2018		Ramesh G		ML-MMOH-CRF-0987
------------------------------------------------------------------------------------------------------------------------------
-->

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
  	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/OrderSet.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String oledb_con_string=(String)session.getValue("oledb_con_string");
	String user_id = (String)session.getValue("login_user");
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	String l_invoke_func=request.getParameter("p_invoke_func")==null?"":request.getParameter("p_invoke_func");//IN065713
	String valid=request.getParameter("valid")==null?"":request.getParameter("valid");
	String l_query_string=request.getQueryString();//IN065713
%>
<form name='orderset_order_btn' id='orderset_order_btn' target='messageFrame' >

<table cellpadding=3 cellspacing=0 border=0 width="100%" height="100%" align=center>
	<tr>
		<td class='button'>
		<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button' onClick='addedorderset()'>
		
		<!--<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onClick='clearChecked()'>--><!--IN065713-->
		<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onClick='clearChecked("ADDITIONAL_CANCEL_BUTTON")' id='cancel_addi_window'><!--IN065713-->
		</td>
	</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="help_function_id" id="help_function_id" value="ORDER_SET">
<input type='hidden' name ='oledb_con_string' value='<%=oledb_con_string%>' >
<input type='hidden' name ='p_invoke_func' value='<%=l_invoke_func%>' ><!--IN065713-->
<input type='hidden' name ='p_query_string' value='<%=l_query_string%>' ><!--IN065713-->
<input type='hidden' name ='valid' value='<%=valid%>' >
</form>
</body>
</html>

