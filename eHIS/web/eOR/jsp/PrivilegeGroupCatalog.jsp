<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOR/js/PrivilegeGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/Tabs.css'></link>
<% if(sStyle!=null && sStyle.equals("IeStyle.css")) { %>
	<STYLE TYPE="text/css">
	A:active {
		COLOR: black;
	}
	A:visited {
		COLOR: black;
	}
	A:link {
		COLOR: black;
	}
	</STYLE>
<%  } %>


</head>
 
<body  STYLE="" onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	
	String mode	   = request.getParameter("mode") ;
	String order_category	   = request.getParameter("order_category") ;
	String order_type	   = request.getParameter("order_type") ;
	String tabValue	   = request.getParameter("tabValue")==null?"":request.getParameter("tabValue");
	//String function_id = request.getParameter( "function_id" ) ;
	//System.out.println("=in group catalog=="+order_category+"=="+order_type+"=="+tabValue);
	String bean_id = "privilegegroupbean" ;
	String bean_name = "eOR.PrivilegeGroupBean";
	// String Alphabets ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String AlphabetsHtml =  "";
	// String readOnly = "" ;
	// String disabled = "" ;
%>

<form name="detailUpperForm" id="detailUpperForm" method="post" >

<table border=0 id="headerTab" cellpadding=3 cellspacing=0 width='100%' height='100%' align="center">
<th class='columnheader' colspan='8'><fmt:message key="eOR.SelectOrderCatalog.label" bundle="${or_labels}"/></th>
<%try {%>
<tr>
	<td colspan="2">
	<table align='center' cellspacing='1' id="searchTxt" cellpadding='1' width="100%" border='0'>
	<tr>
		<td class='label'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<INPUT TYPE="text" name="search_text" id="search_text" value="" onKeyPress=""; maxlength='100' size='40' ><INPUT TYPE="button" class="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="callSearchText()">
		</td>    
		<%
		if(tabValue.equalsIgnoreCase("AU"))
		{
		%>
			<td class='label'><fmt:message key="eOR.Limitto.label" bundle="${or_labels}"/></td>
			<td class='fields'>
				<select name="limt_auth_to" id="limt_auth_to">
						<option value="AL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="AA" selected><fmt:message key="eOR.AuthorizationApplicable.label" bundle="${or_labels}"/></option>
				</select>
				<INPUT TYPE="button" class="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="callLimitText(limt_auth_to)">
			</td>   
		<%
		}
		%>
	</tr>

<tr>
	<td colspan="4">
	<table align='center' cellspacing='1' id="alphabet" cellpadding='1' width='100%' border='0' style="">
	<tr>
		<td><jsp:include page="OrCommonAlphaLink.jsp" flush="true"/></td>
	</tr>
	</table>
	</td>
</tr>

	</table>
	</td>
</tr>
</table>


<!-- <input type="hidden" name="mode" id="mode" value="<%=mode%>"> -->
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="alphabetsHtml" id="alphabetsHtml" value='<%=AlphabetsHtml%>'>
<input type='hidden' name="mode" id="mode" value="<%=mode%>">
<input type='hidden' value='N' name='detailPageMode' id='detailPageMode'>
<input type="hidden" name="function_id" id="function_id" value="">
<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
<input type="hidden" name="tabValue" id="tabValue" value="<%=tabValue%>">


<%}catch(Exception e){
	System.out.println(e.getMessage());

}%>
</form>
</body>
</html>



