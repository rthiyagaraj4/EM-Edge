<!--
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
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
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String oledb_con_string=(String)session.getValue("oledb_con_string");
	String user_id = (String)session.getValue("login_user");
	String l_invoke_func = request.getParameter("p_invoke_func")==null?"":request.getParameter("p_invoke_func");//IN065713
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
%>
<form name='orderset_order_btn' id='orderset_order_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" height="100%" align=center>
	<tr>
		<td class='button'>
			<INPUT TYPE="button" name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button' onClick='includeDosageType()'>		
			<INPUT TYPE="button" name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onClick='cancelDosageType()'>
		</td>
	</tr>
</table>
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type='hidden' name ='oledb_con_string' value='<%=oledb_con_string%>' >
<input type='hidden' name ='p_invoke_func' value='<%=l_invoke_func%>' ><!--IN065713-->
<input type='hidden' name ='p_query_string' value='' ><!--IN065713-->
</form>
</body>
</html>

