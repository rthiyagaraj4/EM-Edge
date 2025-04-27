<!DOCTYPE html>
<%--Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>


<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>   

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

 
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link> <!-- To display the calendar --> 
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/RefusalOrders.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<!-- NO style sheet is used, that is why this piece of code is kept here -->
  	<style type='text/css'>
		ADDRESS{font-style: NORMAL;} 
		INPUT.TEXT_DISPLAY
		{
			background:white;  
			color: RED ;
 			border-style: none;
		}
 	</style>
   </head>
   <title><fmt:message key="eOR.EditorPreview.label" bundle="${or_labels}"/></title>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="focusFrame()">

<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String bean_id				=	request.getParameter("bean_id");
    String bean_name			=	request.getParameter("bean_name");
    if(bean_id ==null || bean_name==null)
	   return;
	
//	String id					=	request.getParameter("id");
	
	RefusalOrdersBean bean		= (RefusalOrdersBean)getBeanObject( bean_id, bean_name ,request) ;
	bean.setLanguageId(localeName);
	String refusal_details		= (String ) bean.getConsentContent();
	if(refusal_details==null) refusal_details="";
   //	refusal_details				= "<img src='../../eCommon/images/Entilogo.jpg' align='center'></img>"  +refusal_details  ;
   	refusal_details				= "<img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40' align='center'></img>"  +refusal_details  ;
 %>


<form name="editor_preview" id="editor_preview" method="post" target="messageFrame">


<table cellpadding=3 cellspacing=0 border=0 style='table-layout: fixed;'>
	<tr>
		<td></td>
	</tr>
   	<tr>
		<td align=left id="consent_details" style='word-wrap:break-word;'><%=refusal_details%></td>
		
 	</tr>
	<tr>
		<td></td>
	</tr>
</table>
	<input type="hidden" name ="bean_id" value="<%=bean_id%>">
	<input type="hidden" name ="bean_name" value="<%=bean_name%>">
</form>

</body>

<%
 	refusal_details = null;
%>

</html>

