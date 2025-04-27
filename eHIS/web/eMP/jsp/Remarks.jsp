<!DOCTYPE html>
﻿<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<html>
	<%
    request.setCharacterEncoding("UTF-8");
	%>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>	
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eMP/js/PatEncBanner.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	<!--Below code was modified by N Munisekhar on 29-Nov-2012 against SKR-SCF-0711 [IN036143]-->
	function loadPassedData(){
		var obj = window.dialogArguments; 
		var str=obj.data;
		document.forms[0].remarks.value = str.replace(/[+]/g," ");
		
    }
	</script>
</head>
<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<body onLoad="loadPassedData()" onKeyDown = 'lockKey();'>
<%
try{ 
%>
<form method=post action="">
<table cellpadding='3' cellspacing='0' width='100%' height='100%' align='center'>
<tr></tr><tr></tr><tr></tr><tr></tr>
<tr><td class='COLUMNHEADER' colspan='1' align='center' width='30%'><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></b>&nbsp;</td></tr>

  <tr>
    <td class='fields'><textarea id ="remarks" name="remarks" rows="20" cols='60' Readonly></textarea></td>
</tr>

	<tr>
    <td align='center'><input type=button class=button name=Close value='<fmt:message key="Common.close.label" bundle="${common_labels}"/> ' onclick='window.close()'></td>
	 <!--end SKR-SCF-0711 [IN036143] -->
  
</tr>
<%}catch(Exception e){
	e.printStackTrace();
}%>
</form>
</body>
</html>


