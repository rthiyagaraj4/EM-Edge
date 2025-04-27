<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8"); 
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
    //ends
	String locale = (String) session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
	String diag_text	= request.getParameter("diag_text");
%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="prescription_diagtext" id="prescription_diagtext">
<table  border=0 align="center" width='100%' cellpadding='0' cellspacing='0'>
<tr> 
 <td  class="label"><textarea cols="78" rows="10" name="diag_text" readonly><%=diag_text%></textarea></td>
</tr>
</table>
</form>
</body>
</html>

