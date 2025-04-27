<!--
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		07/08/2017		Ramesh G		ML-MMOH-CRF-0345.1
																			Created this file for this CRF
12/02/2018	IN065713		Dinesh T		12/02/2018		ML-MMOH-CRF-0987
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
%>
<form name='orderset_order_btn' id='orderset_order_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" height="100%" align=center>
	<tr>
		<td class='button'>
			<INPUT TYPE="button" name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button' onClick='includeDosageTypeAgeWise()'>
		
			<!-- <INPUT TYPE="button" name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onClick='clearChecked()'> --><!--IN065713-->
			<INPUT TYPE="button" name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onClick='cancelDosageTypeAgeWise()'><!--IN065713-->
		</td>
	</tr>
</table>
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type='hidden' name ='oledb_con_string' value='<%=oledb_con_string%>' >
<input type='hidden' name ='p_invoke_func' value='<%=l_invoke_func%>' ><!--IN065713-->
<input type='hidden' name ='p_query_string' value='<%=request.getQueryString()%>' ><!--IN065713-->
</form>
</body>
</html>

