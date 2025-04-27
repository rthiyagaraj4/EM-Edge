<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	 <script language="JavaScript" src="../../ePH/js/TPNConsLimits.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String remarks1		= request.getParameter("remarks");
	//String name         =request.getParameter("name");
	//String remarks   ="";
	//String remarks1="";
	   
	if(remarks1==null)
	remarks1="";
	
		
	%>
     
</head>
<title>Remarks</title>


<body style="background-color:#E2E3F0;" OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<form name="TpnConstGenericRemarks" id="TpnConstGenericRemarks" >
<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>
	<tr>
		<td align='left' class='label' width='10%'></td>
	</tr>
	<tr>
		<td align='left' width='90%' class='label'>&nbsp;&nbsp;<textarea name="remarks" rows="5" cols="60" onBlur="makeValidString(this)" readonly><%=remarks1%></textarea></td>
		
	</tr>
	<TR>
		<td class='label'>
			<center><input type='Button' class='Button' name='Close' id='Close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.close();"></center>
		</TD>
	</TR>
</table>


</body>

</html>
	
<% 
 //remarks.setLength(0);
//putObjectInBean(bean_id,bean,request);
%>

