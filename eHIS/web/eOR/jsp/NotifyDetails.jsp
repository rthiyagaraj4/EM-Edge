<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------
17/10/2018	IN067817		sivabagyam	 17/10/2018	        Ramesh G       ML-MMOH-CRF-1198
28/1/2019	IN069597 		sivabagyam	 28/1/2019	        Ramesh G       CA-Common-Multi Facility Orders
-----------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%@page import="java.sql.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");%>
<html>
<head><title>Notification Details</title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad='' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<Form name='Spec_Lab_Detail_Form' id='Spec_Lab_Detail_Form'>
<%
	
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	
	String orderId = request.getParameter("order_id");
	//String facility_id = (String)session.getValue("facility_id");//IN069597 
	String facility_id =  request.getParameter("facility_id");//IN069597 
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	String allValues ="";
	allValues		= bean.notificationDetails(orderId,facility_id);
%>
<textarea rows="30" cols="127"  style="font-family:Courier New;white-space:pre-wrap" readonly ><%=allValues %></textarea>
</Form>
</body>
</html>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    <td align="right" valign="left">
		<INPUT TYPE="button" id="close" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onClick='window.close()'>
	</td>
  </tr>	
</table>
<%
	putObjectInBean(bean_id,bean,request);
%>

