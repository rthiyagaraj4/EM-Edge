<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>   

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

 
<html>
<head>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!-- NO Iestyle sheet is used, that is why this piece of code is kept here -->
	<style type='text/css'>
		ADDRESS{font-style: NORMAL;} 
	</style>
   <title><fmt:message key="eOR.EditorPreview.label" bundle="${or_labels}"/></title>
     </head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	String bean_id		= request.getParameter( "bean_id" ) ;
	String bean_name	= request.getParameter( "bean_name" ) ;
  	String details		= "";	
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

 		ConsentFormat bean		= (ConsentFormat)getBeanObject( bean_id, bean_name ,request) ;
		details					= bean.getConsentValues();
 	if(details==null)	details ="";
	//details				= "<img src='../../eCommon/images/Entilogo.jpg' align='center'></img>"  +details  ;
	details				= "<img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40' align='center'></img>"  +details  ;
//	System.out.println("details"+details);

%>


<form name="editor_preview" id="editor_preview" method="post" target="messageFrame">


<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td align=left ></td>
	</tr>
  	<tr>
		<td align=left ><%=details%></td>
	</tr>
	<tr>
		<td align=left ></td>
	</tr>
</table>
 
</form>

</body>

</html>

