<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>

<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode			= request.getParameter( "mode" ) ;
	//String function_id  = request.getParameter("function_id") ;
	String bean_id		= "or_organism" ;
	String bean_name	= "eOR.ChartHorizontalBean";

	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ChartHorizontalBean bean =
	(ChartHorizontalBean)getBeanObject( bean_id,bean_name, request );  
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;
	/* Initialize Function specific end */

%>

<form name='Org_header' id='Org_header' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width='100%'  height='100%' align='center'>

<tr >
	<td class="label" width='15%' ><fmt:message key="eOR.resultmatrix.label" bundle="${or_labels}"/></td>
	<td width='20%' class='fields'><select name="chart_result_type" id="chart_result_type" onChange="parent.parent.resetLower()"><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=bean.getComboOptions()%></select>
	<img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>

</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
  
  </form>
 </body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

